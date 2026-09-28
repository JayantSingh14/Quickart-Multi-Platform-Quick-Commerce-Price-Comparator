package in.juspay.airborne.services;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.airborne.utils.OTAUtils;
import in.juspay.hyperutil.FileUtilCallback;
import in.juspay.hyperutil.HyperFileUtil;
import in.juspay.hyperutil.TrackerCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class FileProviderService {
    private static final String LOG_TAG = "FileProviderService";
    final HyperFileUtil hyperFileUtil;

    @NonNull
    private final OTAServices otaServices;

    @NonNull
    private final Map<String, String> fileCache = new HashMap();

    @NonNull
    private final List<String> fileCacheWhiteList = new ArrayList();
    private final boolean shouldCheckInternalAssets = true;

    public enum Mode {
        NEW,
        RE_OPEN
    }

    public FileProviderService(@NonNull final OTAServices oTAServices) {
        this.otaServices = oTAServices;
        this.hyperFileUtil = new HyperFileUtil(oTAServices.getCleanUpValue(), new FileUtilCallback() { // from class: in.juspay.airborne.services.FileProviderService.1
            @Override // in.juspay.hyperutil.FileUtilCallback
            public boolean copyFile(@NotNull File file, @NotNull File file2) {
                return FileProviderService.this.copyFile(file, file2);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            public boolean deleteFile(@NotNull File file) {
                return FileProviderService.this.deleteFile(file);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            @NotNull
            public InputStream getAssetFileAsInputStream(@NotNull String str) throws IOException {
                return FileProviderService.this.openAsset(str);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            @NonNull
            public byte[] getFileInAssets(@NotNull String str) throws RuntimeException {
                return FileProviderService.this.getAssetFileAsByte(str);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            @NonNull
            public File getFileInInternalStorage(@NotNull String str) {
                return FileProviderService.this.getFileFromInternalStorageInternal(str);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            @NonNull
            public JSONObject getMetadata(@NotNull String str) throws JSONException {
                return oTAServices.getRemoteAssetService().getMetadata(str);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            @NonNull
            public byte[] readFileFromInternalStorage(@NotNull String str) throws RuntimeException, FileNotFoundException {
                return FileProviderService.this.getInternalStorageFileAsByte(str);
            }

            @Override // in.juspay.hyperutil.FileUtilCallback
            public void resetMetadata(@NonNull String str) {
                try {
                    oTAServices.getRemoteAssetService().resetMetadata(str);
                } catch (JSONException e2) {
                    oTAServices.getTrackerCallback().trackException("action", "system", "file_provider_service", b.C("Couldn't reset metadata for file name ", str), e2);
                }
            }
        }, new TrackerCallback() { // from class: in.juspay.airborne.services.FileProviderService.2
            @Override // in.juspay.hyperutil.TrackerCallback
            public void track(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject) {
                oTAServices.getTrackerCallback().track(str, str2, str3, str4, str5, jSONObject);
            }

            @Override // in.juspay.hyperutil.TrackerCallback
            public void trackAndLogException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Throwable th) {
                oTAServices.getTrackerCallback().trackAndLogException(str, str2, str3, str4, str5, th);
            }

            @Override // in.juspay.hyperutil.TrackerCallback
            public void trackException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Throwable th) {
                oTAServices.getTrackerCallback().trackException(str, str2, str3, str4, th);
            }
        });
    }

    private void cacheFile(String str, String str2) {
        this.fileCache.put(str, str2);
        Log.d(LOG_TAG, "Caching file: " + str);
    }

    private void deleteAndRemoveMetadata(String str) {
        try {
            getFileFromInternalStorageInternal(str).delete();
            this.otaServices.getRemoteAssetService().resetMetadata(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteFile(File file) {
        try {
            return file.isDirectory() ? OTAUtils.deleteRecursive(file) : file.delete();
        } catch (Exception e2) {
            this.otaServices.getTrackerCallback().trackException("action", "system", "file_provider_service", "Error while deleting file " + file.getAbsolutePath(), e2);
            return false;
        }
    }

    private void deleteFileFromCache(String str) {
        if (isFileCached(str)) {
            this.fileCache.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getFileFromInternalStorageInternal(String str) {
        a.t("Getting file from internal storage. Filename: ", str, LOG_TAG);
        File fileOpen = this.otaServices.getWorkspace().open(str);
        File parentFile = fileOpen.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return fileOpen;
    }

    private boolean isFileCached(String str) {
        return this.fileCache.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream openAsset(String str) throws IOException {
        return this.otaServices.getWorkspace().openAsset(str);
    }

    private void readFromInputStream(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        }
    }

    private boolean writeToFile(@NonNull Context context, String str, byte[] bArr, boolean z) {
        deleteFileFromCache(str);
        return writeToFile(getFileFromInternalStorageInternal(str), bArr, z);
    }

    public void addToFileCacheWhiteList(String str) {
        this.fileCacheWhiteList.add(str);
    }

    public boolean copyFile(File file, File file2) throws IOException {
        try {
            Log.d(LOG_TAG, "copyFile: " + file.getAbsolutePath() + "   " + file2.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    return true;
                } catch (Exception e2) {
                    this.otaServices.getTrackerCallback().trackException("action", "system", "file_provider_service", "Files.copy failed: " + file.getName(), e2);
                }
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException e3) {
            this.otaServices.getTrackerCallback().trackException("action", "system", "file_provider_service", "File not found: " + file.getName(), e3);
            return false;
        } catch (Exception e4) {
            this.otaServices.getTrackerCallback().trackException("action", "system", "file_provider_service", "Exception: " + file.getName(), e4);
            return false;
        }
    }

    public boolean deleteFileFromInternalStorage(String str) {
        if (!this.otaServices.getFromAirborne()) {
            return this.hyperFileUtil.deleteFileFromInternalStorage(str);
        }
        in.juspay.airborne.TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        RemoteAssetService remoteAssetService = this.otaServices.getRemoteAssetService();
        File fileFromInternalStorageInternal = getFileFromInternalStorageInternal(str);
        if (!fileFromInternalStorageInternal.exists()) {
            Log.e(LOG_TAG, str + " not found");
            return false;
        }
        Log.d(LOG_TAG, "Deleting " + str + " from internal storage");
        try {
            trackerCallback.track("action", "system", "warning", "file_provider_service", "file_deleted", new JSONObject().put("Deleted file", str));
            remoteAssetService.resetMetadata(str);
        } catch (Exception e2) {
            trackerCallback.trackException("action", "system", "file_provider_service", "Error while resetting etag", e2);
        }
        return deleteFile(fileFromInternalStorageInternal);
    }

    public byte[] getAssetFileAsByte(String str) throws IOException {
        in.juspay.airborne.TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenAsset = openAsset(str);
                try {
                    readFromInputStream(byteArrayOutputStream, inputStreamOpenAsset);
                    if (inputStreamOpenAsset != null) {
                        inputStreamOpenAsset.close();
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            trackerCallback.trackException("action", "system", "file_provider_service", b.C("Could not read ", str), e2);
            throw new RuntimeException(e2);
        } catch (Exception e3) {
            trackerCallback.trackException("action", "system", "file_provider_service", b.C("Exception: Could not read ", str), e3);
            return new byte[0];
        }
    }

    public File getFileFromInternalStorage(String str) {
        a.t("Getting file from internal storage. Filename: ", str, LOG_TAG);
        return !this.otaServices.getFromAirborne() ? this.hyperFileUtil.getFileFromInternalStorage(str) : getFileFromInternalStorageInternal(str);
    }

    public HyperFileUtil getHyperFileUtil() {
        return this.hyperFileUtil;
    }

    public byte[] getInternalStorageFileAsByte(String str) throws IOException, RuntimeException {
        in.juspay.airborne.TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        RemoteAssetService remoteAssetService = this.otaServices.getRemoteAssetService();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileInputStream fileInputStream = new FileInputStream(getFileFromInternalStorageInternal(str));
                try {
                    readFromInputStream(byteArrayOutputStream, fileInputStream);
                    fileInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException e2) {
            a.t("File not found ", str, LOG_TAG);
            try {
                remoteAssetService.resetMetadata(str);
                throw e2;
            } catch (JSONException unused) {
                trackerCallback.trackException("action", "system", "file_provider_service", b.C("Couldn't reset ", str), e2);
                throw e2;
            }
        } catch (IOException e3) {
            trackerCallback.trackException("action", "system", "file_provider_service", b.C("Could not read ", str), e3);
            deleteFileFromInternalStorage(str);
            throw new RuntimeException(e3);
        } catch (Exception e4) {
            trackerCallback.trackException("action", "system", "file_provider_service", b.C("Exception: Could not read ", str), e4);
            deleteFileFromInternalStorage(str);
            throw new RuntimeException(e4);
        }
    }

    public boolean isFilePresent(@NonNull Context context, String str) throws IOException {
        if (!this.otaServices.getFromAirborne()) {
            return this.hyperFileUtil.isFilePresent(str);
        }
        if (this.otaServices.getWorkspace().open(str).exists()) {
            return true;
        }
        try {
            InputStream inputStreamOpenAsset = openAsset(str);
            if (inputStreamOpenAsset != null) {
                inputStreamOpenAsset.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public Set<String> listAllFilesRecursively(String str, File file) {
        File[] fileArrListFiles;
        HashSet hashSet = new HashSet();
        if (file != null && file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    StringBuilder sbW = b.w(str);
                    sbW.append(file2.getName());
                    sbW.append("/");
                    hashSet.addAll(listAllFilesRecursively(sbW.toString(), file2));
                } else if (this.otaServices.getFromAirborne()) {
                    StringBuilder sbW2 = b.w(str);
                    sbW2.append(file2.getName());
                    hashSet.add(sbW2.toString());
                } else {
                    StringBuilder sbW3 = b.w(str);
                    sbW3.append(this.hyperFileUtil.encodeFileName(file2.getName()));
                    hashSet.add(sbW3.toString());
                }
            }
        }
        return hashSet;
    }

    @Nullable
    public String[] listFilesRecursive(String str) {
        return (String[]) listAllFilesRecursively("", this.otaServices.getWorkspace().open(str)).toArray(new String[0]);
    }

    public TempWriter newTempWriter(String str) {
        try {
            return new TempWriter(str, Mode.NEW, this.otaServices);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public TempWriter reOpenTempWriter(String str) throws FileNotFoundException {
        return new TempWriter(str, Mode.RE_OPEN, this.otaServices);
    }

    public String readFromAssets(String str) {
        in.juspay.airborne.TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        try {
            return new String(getAssetFileAsByte(str));
        } catch (Exception e2) {
            trackerCallback.trackException("action", "system", "file_provider_service", b.C("Exception trying to read file from assets: ", str), e2);
            return null;
        }
    }

    public String readFromCache(String str) {
        if (!isFileCached(str)) {
            return null;
        }
        String str2 = this.fileCache.get(str);
        Log.d(LOG_TAG, "Returning cached value of the file: " + str);
        Log.d(LOG_TAG, "Cached: " + str2);
        return str2;
    }

    @NonNull
    public String readFromFile(@NonNull String str) {
        return readFromFile(str, true);
    }

    public String readFromInternalStorage(String str) {
        if (this.otaServices.getUseBundledAssets()) {
            return null;
        }
        if (!this.otaServices.getFromAirborne()) {
            String fileFromInternalStorage = this.hyperFileUtil.readFileFromInternalStorage(str);
            return fileFromInternalStorage != null ? fileFromInternalStorage : "";
        }
        try {
            String str2 = new String(getInternalStorageFileAsByte(str));
            this.otaServices.getTrackerCallback().track("action", "system", "debug", "file_provider_service", "readFromInternalStorage", new JSONObject().put("Returning the file content for file ", str));
            if (!str.endsWith(".json")) {
                return str2;
            }
            try {
                new JSONObject(str2);
                return str2;
            } catch (JSONException unused) {
                deleteAndRemoveMetadata(str);
                return null;
            }
        } catch (Exception e2) {
            this.otaServices.getTrackerCallback().trackException("action", "system", "file_provider_service", "read from internal storage failed", e2);
            return null;
        }
    }

    public boolean updateCertificate(@NonNull Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, true);
    }

    public boolean updateFile(@NonNull Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, false);
    }

    public String writeFileToDisk(@NonNull Context context, String str, String str2) throws JSONException, IOException {
        try {
            File file = new File(context.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS)[0].getAbsolutePath());
            file.mkdirs();
            File file2 = new File(file, str2);
            file2.createNewFile();
            if (!file2.exists()) {
                Log.d(LOG_TAG, "Exception in creating the file");
                return "{\"error\":\"true\",\"data\":\"unknown_error::Exception in creating the file\"}";
            }
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", "false");
            jSONObject.put("data", file);
            return jSONObject.toString();
        } catch (Exception e2) {
            Log.d(LOG_TAG, "Exception in downloading the file :" + e2);
            return b.D("{\"error\":\"true\",\"data\":\"", "unknown_error::" + e2, "\"}");
        }
    }

    public String readFromFile(String str, boolean z) {
        String fromCache = z ? readFromCache(str) : null;
        if (fromCache == null && !this.otaServices.getFromAirborne()) {
            fromCache = this.hyperFileUtil.readFileForHyperSDK(str);
        } else if (fromCache == null && (fromCache = readFromInternalStorage(str)) == null) {
            fromCache = readFromAssets(str);
        }
        if (this.fileCacheWhiteList.contains(str) && fromCache != null) {
            cacheFile(str, fromCache);
        }
        return fromCache == null ? "" : fromCache;
    }

    public boolean updateFile(String str, byte[] bArr) {
        return writeToFile(Workspace.getCtx(), str, bArr, false);
    }

    @Nullable
    public String[] listFilesRecursive(File file) {
        return (String[]) listAllFilesRecursively("", file).toArray(new String[0]);
    }

    public boolean writeToFile(File file, byte[] bArr, boolean z) throws IOException {
        in.juspay.airborne.TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        try {
            String name = file.getName();
            if (!z && !this.otaServices.getFromAirborne()) {
                HyperFileUtil.DecodeFileResponse decodeFileResponseDecodeFileContent = this.hyperFileUtil.decodeFileContent(file.getName(), bArr);
                name = decodeFileResponseDecodeFileContent.getFileName();
                bArr = decodeFileResponseDecodeFileContent.getContent();
            }
            File file2 = new File(file.getParentFile(), "temp_" + name);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr);
                    boolean zRenameTo = file2.renameTo(new File(file.getParentFile(), name));
                    fileOutputStream.close();
                    return zRenameTo;
                } finally {
                }
            } catch (Exception e2) {
                trackerCallback.trackException("action", "system", "file_provider_service", "Exception writing decrypted js file " + name, e2);
                return false;
            }
        } catch (FileNotFoundException e3) {
            trackerCallback.trackException("action", "system", "file_provider_service", "File not found: " + file.getName(), e3);
            return false;
        } catch (IOException e4) {
            trackerCallback.trackException("action", "system", "file_provider_service", "IOException: " + file.getName(), e4);
            return false;
        } catch (Exception e5) {
            trackerCallback.trackException("action", "system", "file_provider_service", "Exception: " + file.getName(), e5);
            return false;
        }
    }
}
