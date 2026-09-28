package com.rnfs;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.b;
import android.util.Base64;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.rnfs.DownloadParams;
import com.rnfs.UploadParams;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = RNFSManager.MODULE_NAME)
/* loaded from: classes.dex */
public class RNFSManager extends ReactContextBaseJavaModule {
    static final String MODULE_NAME = "RNFSManager";
    private static final String RNFSCachesDirectoryPath = "RNFSCachesDirectoryPath";
    private static final String RNFSDocumentDirectory = "RNFSDocumentDirectory";
    private static final String RNFSDocumentDirectoryPath = "RNFSDocumentDirectoryPath";
    private static final String RNFSDownloadDirectoryPath = "RNFSDownloadDirectoryPath";
    private static final String RNFSExternalCachesDirectoryPath = "RNFSExternalCachesDirectoryPath";
    private static final String RNFSExternalDirectoryPath = "RNFSExternalDirectoryPath";
    private static final String RNFSExternalStorageDirectoryPath = "RNFSExternalStorageDirectoryPath";
    private static final String RNFSFileTypeDirectory = "RNFSFileTypeDirectory";
    private static final String RNFSFileTypeRegular = "RNFSFileTypeRegular";
    private static final String RNFSPicturesDirectoryPath = "RNFSPicturesDirectoryPath";
    private static final String RNFSTemporaryDirectoryPath = "RNFSTemporaryDirectoryPath";
    private SparseArray<Downloader> downloaders;
    private ReactApplicationContext reactContext;
    private SparseArray<Uploader> uploaders;

    /* renamed from: com.rnfs.RNFSManager$3, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 implements DownloadParams.OnTaskCompleted {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46434a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Promise f46435b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f46436c;

        public AnonymousClass3(int i2, Promise promise, ReadableMap readableMap) {
            this.f46434a = i2;
            this.f46435b = promise;
            this.f46436c = readableMap;
        }

        public final void a(DownloadResult downloadResult) {
            Exception exc = downloadResult.f46421c;
            Promise promise = this.f46435b;
            if (exc != null) {
                RNFSManager.this.reject(promise, this.f46436c.getString("toFile"), downloadResult.f46421c);
            } else {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("jobId", this.f46434a);
                writableMapCreateMap.putInt("statusCode", downloadResult.f46419a);
                writableMapCreateMap.putDouble("bytesWritten", downloadResult.f46420b);
                promise.resolve(writableMapCreateMap);
            }
        }
    }

    /* renamed from: com.rnfs.RNFSManager$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass4 implements DownloadParams.OnDownloadBegin {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46438a;

        public AnonymousClass4(int i2) {
            this.f46438a = i2;
        }

        public final void a(int i2, long j2, HashMap map) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            for (Map.Entry entry : map.entrySet()) {
                writableMapCreateMap.putString((String) entry.getKey(), (String) entry.getValue());
            }
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putInt("jobId", this.f46438a);
            writableMapCreateMap2.putInt("statusCode", i2);
            writableMapCreateMap2.putDouble("contentLength", j2);
            writableMapCreateMap2.putMap("headers", writableMapCreateMap);
            RNFSManager rNFSManager = RNFSManager.this;
            rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "DownloadBegin", writableMapCreateMap2);
        }
    }

    /* renamed from: com.rnfs.RNFSManager$5, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass5 implements DownloadParams.OnDownloadProgress {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46440a;

        public AnonymousClass5(int i2) {
            this.f46440a = i2;
        }
    }

    /* renamed from: com.rnfs.RNFSManager$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass6 implements UploadParams.onUploadComplete {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46442a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Promise f46443b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f46444c;

        public AnonymousClass6(int i2, Promise promise, ReadableMap readableMap) {
            this.f46442a = i2;
            this.f46443b = promise;
            this.f46444c = readableMap;
        }

        public final void a(UploadResult uploadResult) {
            Exception exc = uploadResult.f46463c;
            Promise promise = this.f46443b;
            if (exc != null) {
                RNFSManager.this.reject(promise, this.f46444c.getString("toUrl"), uploadResult.f46463c);
            } else {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("jobId", this.f46442a);
                writableMapCreateMap.putInt("statusCode", uploadResult.f46461a);
                writableMapCreateMap.putMap("headers", uploadResult.f46462b);
                writableMapCreateMap.putString("body", uploadResult.f46464d);
                promise.resolve(writableMapCreateMap);
            }
        }
    }

    /* renamed from: com.rnfs.RNFSManager$7, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass7 implements UploadParams.onUploadBegin {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46446a;

        public AnonymousClass7(int i2) {
            this.f46446a = i2;
        }
    }

    /* renamed from: com.rnfs.RNFSManager$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements UploadParams.onUploadProgress {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46448a;

        public AnonymousClass8(int i2) {
            this.f46448a = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class CopyFileTask extends AsyncTask<String, Void, Exception> {
        public CopyFileTask() {
        }

        @Override // android.os.AsyncTask
        public final Exception doInBackground(String[] strArr) throws IOException {
            String[] strArr2 = strArr;
            RNFSManager rNFSManager = RNFSManager.this;
            try {
                String str = strArr2[0];
                String str2 = strArr2[1];
                InputStream inputStream = rNFSManager.getInputStream(str);
                OutputStream outputStreamC = RNFSManager.c(rNFSManager, str2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        inputStream.close();
                        outputStreamC.close();
                        return null;
                    }
                    outputStreamC.write(bArr, 0, i2);
                    Thread.yield();
                }
            } catch (Exception e2) {
                return e2;
            }
        }
    }

    public RNFSManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.downloaders = new SparseArray<>();
        this.uploaders = new SparseArray<>();
        this.reactContext = reactApplicationContext;
    }

    private void DeleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                DeleteRecursive(file2);
            }
        }
        file.delete();
    }

    public static /* bridge */ /* synthetic */ OutputStream c(RNFSManager rNFSManager, String str) {
        return rNFSManager.getOutputStream(str, false);
    }

    private void copyInputStream(InputStream inputStream, String str, String str2, Promise promise) throws Throwable {
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        try {
            try {
                try {
                    outputStream = getOutputStream(str2, false);
                } catch (IOException unused) {
                    return;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[10240];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, i2);
                }
            }
            promise.resolve(null);
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Exception e3) {
            e = e3;
            outputStream2 = outputStream;
            reject(promise, str, new Exception("Failed to copy '" + str + "' to " + str2 + " (" + e.getLocalizedMessage() + ")"));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
            return;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            if (outputStream2 == null) {
                throw th;
            }
            try {
                outputStream2.close();
                throw th;
            } catch (IOException unused5) {
                throw th;
            }
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }

    private Uri getFileUri(String str, boolean z) throws IORejectionException {
        Uri uri = Uri.parse(str);
        if (uri.getScheme() != null) {
            return uri;
        }
        File file = new File(str);
        if (!z && file.isDirectory()) {
            throw new IORejectionException("EISDIR", b.D("EISDIR: illegal operation on a directory, read '", str, "'"));
        }
        return Uri.parse("file://" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream getInputStream(String str) throws IORejectionException, FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = this.reactContext.getContentResolver().openInputStream(getFileUri(str, false));
            if (inputStreamOpenInputStream != null) {
                return inputStreamOpenInputStream;
            }
            throw new IORejectionException("ENOENT", b.D("ENOENT: could not open an input stream for '", str, "'"));
        } catch (FileNotFoundException e2) {
            throw new IORejectionException("ENOENT", "ENOENT: " + e2.getMessage() + ", open '" + str + "'");
        }
    }

    private static byte[] getInputStreamBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused2) {
        }
        return byteArray;
    }

    private String getOriginalFilepath(String str, boolean z) throws IORejectionException {
        Uri fileUri = getFileUri(str, z);
        if (fileUri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = this.reactContext.getContentResolver().query(fileUri, null, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    str = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                }
                cursorQuery.close();
            } catch (IllegalArgumentException unused) {
            }
        }
        return str;
    }

    private OutputStream getOutputStream(String str, boolean z) throws IORejectionException, FileNotFoundException {
        try {
            OutputStream outputStreamOpenOutputStream = this.reactContext.getContentResolver().openOutputStream(getFileUri(str, false), z ? "wa" : getWriteAccessByAPILevel());
            if (outputStreamOpenOutputStream != null) {
                return outputStreamOpenOutputStream;
            }
            throw new IORejectionException("ENOENT", b.D("ENOENT: could not open an output stream for '", str, "'"));
        } catch (FileNotFoundException e2) {
            throw new IORejectionException("ENOENT", "ENOENT: " + e2.getMessage() + ", open '" + str + "'");
        }
    }

    private int getResIdentifier(String str) {
        boolean z = true;
        String strSubstring = str.substring(str.lastIndexOf(CLConstants.DOT_SALT_DELIMETER) + 1);
        String strSubstring2 = str.substring(0, str.lastIndexOf(CLConstants.DOT_SALT_DELIMETER));
        if (!strSubstring.equals("png") && !strSubstring.equals("jpg") && !strSubstring.equals("jpeg") && !strSubstring.equals("bmp") && !strSubstring.equals("gif") && !strSubstring.equals("webp") && !strSubstring.equals("psd") && !strSubstring.equals("svg") && !strSubstring.equals("tiff")) {
            z = false;
        }
        return getReactApplicationContext().getResources().getIdentifier(strSubstring2, z ? "drawable" : "raw", getReactApplicationContext().getPackageName());
    }

    private String getWriteAccessByAPILevel() {
        return Build.VERSION.SDK_INT <= 28 ? "w" : "rwt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reject(Promise promise, String str, Exception exc) {
        if (exc instanceof FileNotFoundException) {
            rejectFileNotFound(promise, str);
        } else if (!(exc instanceof IORejectionException)) {
            promise.reject((String) null, exc.getMessage());
        } else {
            IORejectionException iORejectionException = (IORejectionException) exc;
            promise.reject(iORejectionException.a(), iORejectionException.getMessage());
        }
    }

    private void rejectFileIsDirectory(Promise promise) {
        promise.reject("EISDIR", "EISDIR: illegal operation on a directory, read");
    }

    private void rejectFileNotFound(Promise promise, String str) {
        promise.reject("ENOENT", "ENOENT: no such file or directory, open '" + str + "'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((RCTNativeAppEventEmitter) reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void appendFile(String str, String str2, Promise promise) throws IOException {
        try {
            byte[] bArrDecode = Base64.decode(str2, 0);
            OutputStream outputStream = getOutputStream(str, true);
            outputStream.write(bArrDecode);
            outputStream.close();
            promise.resolve(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void copyFile(final String str, String str2, ReadableMap readableMap, final Promise promise) {
        new CopyFileTask() { // from class: com.rnfs.RNFSManager.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.os.AsyncTask
            public final void onPostExecute(Exception exc) {
                Exception exc2 = exc;
                Promise promise2 = promise;
                if (exc2 == null) {
                    promise2.resolve(null);
                } else {
                    exc2.printStackTrace();
                    RNFSManager.this.reject(promise2, str, exc2);
                }
            }
        }.execute(str, str2);
    }

    @ReactMethod
    public void copyFileAssets(String str, String str2, Promise promise) throws Throwable {
        try {
            copyInputStream(getReactApplicationContext().getAssets().open(str), str, str2, promise);
        } catch (IOException unused) {
            reject(promise, str, new Exception(b.D("Asset '", str, "' could not be opened")));
        }
    }

    @ReactMethod
    public void copyFileRes(String str, String str2, Promise promise) throws Throwable {
        try {
            copyInputStream(getReactApplicationContext().getResources().openRawResource(getResIdentifier(str)), str, str2, promise);
        } catch (Exception unused) {
            reject(promise, str, new Exception(b.D("Res '", str, "' could not be opened")));
        }
    }

    @ReactMethod
    public void downloadFile(ReadableMap readableMap, Promise promise) {
        try {
            File file = new File(readableMap.getString("toFile"));
            URL url = new URL(readableMap.getString("fromUrl"));
            int i2 = readableMap.getInt("jobId");
            ReadableMap map = readableMap.getMap("headers");
            int i3 = readableMap.getInt("progressInterval");
            int i4 = readableMap.getInt("progressDivider");
            int i5 = readableMap.getInt("readTimeout");
            int i6 = readableMap.getInt("connectionTimeout");
            boolean z = readableMap.getBoolean("hasBeginCallback");
            boolean z2 = readableMap.getBoolean("hasProgressCallback");
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.f46409a = url;
            downloadParams.f46410b = file;
            downloadParams.f46411c = map;
            downloadParams.f46412d = i3;
            downloadParams.f46413e = i4;
            downloadParams.f46414f = i5;
            downloadParams.f46415g = i6;
            downloadParams.f46416h = new AnonymousClass3(i2, promise, readableMap);
            if (z) {
                downloadParams.f46417i = new AnonymousClass4(i2);
            }
            if (z2) {
                downloadParams.f46418j = new AnonymousClass5(i2);
            }
            Downloader downloader = new Downloader();
            downloader.execute(downloadParams);
            this.downloaders.put(i2, downloader);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, readableMap.getString("toFile"), e2);
        }
    }

    @ReactMethod
    public void exists(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(new File(str).exists()));
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void existsAssets(String str, Promise promise) throws IOException {
        try {
            AssetManager assets = getReactApplicationContext().getAssets();
            try {
                String[] list = assets.list(str);
                if (list != null && list.length > 0) {
                    promise.resolve(Boolean.TRUE);
                    return;
                }
            } catch (Exception unused) {
            }
            InputStream inputStreamOpen = null;
            try {
                try {
                    inputStreamOpen = assets.open(str);
                    promise.resolve(Boolean.TRUE);
                    if (inputStreamOpen == null) {
                        return;
                    }
                } catch (Exception unused2) {
                    promise.resolve(Boolean.FALSE);
                    if (inputStreamOpen == null) {
                        return;
                    }
                }
                try {
                    inputStreamOpen.close();
                } catch (Exception unused3) {
                }
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void existsRes(String str, Promise promise) {
        try {
            if (getResIdentifier(str) > 0) {
                promise.resolve(Boolean.TRUE);
            } else {
                promise.resolve(Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void getAllExternalFilesDirs(Promise promise) {
        File[] externalFilesDirs = getReactApplicationContext().getExternalFilesDirs(null);
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (File file : externalFilesDirs) {
            if (file != null) {
                writableArrayCreateArray.pushString(file.getAbsolutePath());
            }
        }
        promise.resolve(writableArrayCreateArray);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put(RNFSDocumentDirectory, 0);
        map.put(RNFSDocumentDirectoryPath, getReactApplicationContext().getFilesDir().getAbsolutePath());
        map.put(RNFSTemporaryDirectoryPath, getReactApplicationContext().getCacheDir().getAbsolutePath());
        map.put(RNFSPicturesDirectoryPath, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put(RNFSCachesDirectoryPath, getReactApplicationContext().getCacheDir().getAbsolutePath());
        map.put(RNFSDownloadDirectoryPath, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        map.put(RNFSFileTypeRegular, 0);
        map.put(RNFSFileTypeDirectory, 1);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            map.put(RNFSExternalStorageDirectoryPath, externalStorageDirectory.getAbsolutePath());
        } else {
            map.put(RNFSExternalStorageDirectoryPath, null);
        }
        File externalFilesDir = getReactApplicationContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            map.put(RNFSExternalDirectoryPath, externalFilesDir.getAbsolutePath());
        } else {
            map.put(RNFSExternalDirectoryPath, null);
        }
        File externalCacheDir = getReactApplicationContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            map.put(RNFSExternalCachesDirectoryPath, externalCacheDir.getAbsolutePath());
            return map;
        }
        map.put(RNFSExternalCachesDirectoryPath, null);
        return map;
    }

    @ReactMethod
    public void getFSInfo(Promise promise) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long totalBytes = statFs.getTotalBytes();
        long freeBytes = statFs.getFreeBytes();
        long totalBytes2 = statFs2.getTotalBytes();
        long freeBytes2 = statFs2.getFreeBytes();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("totalSpace", totalBytes);
        writableMapCreateMap.putDouble("freeSpace", freeBytes);
        writableMapCreateMap.putDouble("totalSpaceEx", totalBytes2);
        writableMapCreateMap.putDouble("freeSpaceEx", freeBytes2);
        promise.resolve(writableMapCreateMap);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void hash(String str, String str2, Promise promise) throws Exception {
        int i2;
        try {
            HashMap map = new HashMap();
            map.put("md5", MessageDigestAlgorithms.MD5);
            map.put("sha1", MessageDigestAlgorithms.SHA_1);
            map.put("sha224", MessageDigestAlgorithms.SHA_224);
            map.put("sha256", MessageDigestAlgorithms.SHA_256);
            map.put("sha384", MessageDigestAlgorithms.SHA_384);
            map.put("sha512", MessageDigestAlgorithms.SHA_512);
            if (!map.containsKey(str2)) {
                throw new Exception("Invalid hash algorithm");
            }
            File file = new File(str);
            if (file.isDirectory()) {
                rejectFileIsDirectory(promise);
                return;
            }
            if (!file.exists()) {
                rejectFileNotFound(promise, str);
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance((String) map.get(str2));
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[10240];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                } else {
                    messageDigest.update(bArr, 0, i3);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest()) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            promise.resolve(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void mkdir(String str, ReadableMap readableMap, Promise promise) throws Exception {
        try {
            File file = new File(str);
            file.mkdirs();
            if (!file.exists()) {
                throw new Exception("Directory could not be created");
            }
            promise.resolve(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void moveFile(final String str, String str2, ReadableMap readableMap, final Promise promise) {
        try {
            final File file = new File(str);
            if (file.renameTo(new File(str2))) {
                promise.resolve(Boolean.TRUE);
            } else {
                new CopyFileTask() { // from class: com.rnfs.RNFSManager.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.os.AsyncTask
                    public final void onPostExecute(Exception exc) {
                        Exception exc2 = exc;
                        Promise promise2 = promise;
                        if (exc2 == null) {
                            file.delete();
                            promise2.resolve(Boolean.TRUE);
                        } else {
                            exc2.printStackTrace();
                            RNFSManager.this.reject(promise2, str, exc2);
                        }
                    }
                }.execute(str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void pathForBundle(String str, Promise promise) {
    }

    @ReactMethod
    public void pathForGroup(String str, Promise promise) {
    }

    @ReactMethod
    public void read(String str, int i2, int i3, Promise promise) throws IOException {
        try {
            InputStream inputStream = getInputStream(str);
            byte[] bArr = new byte[i2];
            inputStream.skip(i3);
            promise.resolve(Base64.encodeToString(bArr, 0, inputStream.read(bArr, 0, i2), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void readDir(String str, Promise promise) throws Exception {
        try {
            File file = new File(str);
            if (!file.exists()) {
                throw new Exception("Folder does not exist");
            }
            File[] fileArrListFiles = file.listFiles();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (File file2 : fileArrListFiles) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putDouble("mtime", file2.lastModified() / 1000.0d);
                writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, file2.getName());
                writableMapCreateMap.putString("path", file2.getAbsolutePath());
                writableMapCreateMap.putDouble("size", file2.length());
                writableMapCreateMap.putInt("type", file2.isDirectory() ? 1 : 0);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void readDirAssets(String str, Promise promise) throws IOException {
        int length;
        try {
            AssetManager assets = getReactApplicationContext().getAssets();
            String[] list = assets.list(str);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str2 : list) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, str2);
                if (!str.isEmpty()) {
                    str2 = str + "/" + str2;
                }
                writableMapCreateMap.putString("path", str2);
                int i2 = 1;
                try {
                    AssetFileDescriptor assetFileDescriptorOpenFd = assets.openFd(str2);
                    if (assetFileDescriptorOpenFd != null) {
                        length = (int) assetFileDescriptorOpenFd.getLength();
                        try {
                            assetFileDescriptorOpenFd.close();
                            i2 = 0;
                        } catch (IOException e2) {
                            e = e2;
                            i2 = 1 ^ (e.getMessage().contains("compressed") ? 1 : 0);
                            writableMapCreateMap.putInt("size", length);
                            writableMapCreateMap.putInt("type", i2);
                            writableArrayCreateArray.pushMap(writableMapCreateMap);
                        }
                    } else {
                        length = 0;
                    }
                } catch (IOException e3) {
                    e = e3;
                    length = 0;
                }
                writableMapCreateMap.putInt("size", length);
                writableMapCreateMap.putInt("type", i2);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (IOException e4) {
            reject(promise, str, e4);
        }
    }

    @ReactMethod
    public void readFile(String str, Promise promise) {
        try {
            promise.resolve(Base64.encodeToString(getInputStreamBytes(getInputStream(str)), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void readFileAssets(String str, Promise promise) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                try {
                    InputStream inputStreamOpen = getReactApplicationContext().getAssets().open(str, 0);
                    if (inputStreamOpen == null) {
                        reject(promise, str, new Exception("Failed to open file"));
                        if (inputStreamOpen == null) {
                            return;
                        }
                    } else {
                        byte[] bArr = new byte[inputStreamOpen.available()];
                        inputStreamOpen.read(bArr);
                        promise.resolve(Base64.encodeToString(bArr, 2));
                    }
                    inputStreamOpen.close();
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                reject(promise, str, e2);
                if (0 != 0) {
                    inputStream.close();
                }
            }
        } catch (IOException unused2) {
        }
    }

    @ReactMethod
    public void readFileRes(String str, Promise promise) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                try {
                    InputStream inputStreamOpenRawResource = getReactApplicationContext().getResources().openRawResource(getResIdentifier(str));
                    if (inputStreamOpenRawResource == null) {
                        reject(promise, str, new Exception("Failed to open file"));
                        if (inputStreamOpenRawResource == null) {
                            return;
                        }
                    } else {
                        byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                        inputStreamOpenRawResource.read(bArr);
                        promise.resolve(Base64.encodeToString(bArr, 2));
                    }
                    inputStreamOpenRawResource.close();
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                reject(promise, str, e2);
                if (0 != 0) {
                    inputStream.close();
                }
            }
        } catch (IOException unused2) {
        }
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void scanFile(String str, final Promise promise) {
        MediaScannerConnection.scanFile(getReactApplicationContext(), new String[]{str}, null, new MediaScannerConnection.MediaScannerConnectionClient() { // from class: com.rnfs.RNFSManager.9
            @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
            public final void onMediaScannerConnected() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str2, Uri uri) {
                promise.resolve(str2);
            }
        });
    }

    @ReactMethod
    public void setReadable(String str, Boolean bool, Boolean bool2, Promise promise) throws Exception {
        try {
            File file = new File(str);
            if (!file.exists()) {
                throw new Exception("File does not exist");
            }
            file.setReadable(bool.booleanValue(), bool2.booleanValue());
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void stat(String str, Promise promise) throws Exception {
        try {
            String originalFilepath = getOriginalFilepath(str, true);
            File file = new File(originalFilepath);
            if (!file.exists()) {
                throw new Exception("File does not exist");
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("ctime", (int) (file.lastModified() / 1000));
            writableMapCreateMap.putInt("mtime", (int) (file.lastModified() / 1000));
            writableMapCreateMap.putDouble("size", file.length());
            writableMapCreateMap.putInt("type", file.isDirectory() ? 1 : 0);
            writableMapCreateMap.putString("originalFilepath", originalFilepath);
            promise.resolve(writableMapCreateMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void stopDownload(int i2) {
        Downloader downloader = this.downloaders.get(i2);
        if (downloader != null) {
            downloader.b();
        }
    }

    @ReactMethod
    public void stopUpload(int i2) {
        Uploader uploader = this.uploaders.get(i2);
        if (uploader != null) {
            uploader.b();
        }
    }

    @ReactMethod
    public void touch(String str, double d2, double d3, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(new File(str).setLastModified((long) d2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void unlink(String str, Promise promise) throws Exception {
        try {
            File file = new File(str);
            if (!file.exists()) {
                throw new Exception("File does not exist");
            }
            DeleteRecursive(file);
            promise.resolve(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void uploadFiles(ReadableMap readableMap, Promise promise) {
        try {
            ReadableArray array = readableMap.getArray("files");
            URL url = new URL(readableMap.getString("toUrl"));
            int i2 = readableMap.getInt("jobId");
            ReadableMap map = readableMap.getMap("headers");
            ReadableMap map2 = readableMap.getMap("fields");
            String string = readableMap.getString("method");
            boolean z = readableMap.getBoolean("binaryStreamOnly");
            boolean z2 = readableMap.getBoolean("hasBeginCallback");
            boolean z3 = readableMap.getBoolean("hasProgressCallback");
            ArrayList arrayList = new ArrayList();
            UploadParams uploadParams = new UploadParams();
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList.add(array.getMap(i3));
            }
            uploadParams.f46452a = url;
            uploadParams.f46453b = arrayList;
            uploadParams.f46455d = map;
            uploadParams.f46457f = string;
            uploadParams.f46456e = map2;
            uploadParams.f46454c = z;
            uploadParams.f46458g = new AnonymousClass6(i2, promise, readableMap);
            if (z2) {
                uploadParams.f46460i = new AnonymousClass7(i2);
            }
            if (z3) {
                uploadParams.f46459h = new AnonymousClass8(i2);
            }
            Uploader uploader = new Uploader();
            uploader.execute(uploadParams);
            this.uploaders.put(i2, uploader);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, readableMap.getString("toUrl"), e2);
        }
    }

    @ReactMethod
    public void write(String str, String str2, int i2, Promise promise) throws IOException {
        try {
            byte[] bArrDecode = Base64.decode(str2, 0);
            if (i2 < 0) {
                OutputStream outputStream = getOutputStream(str, true);
                outputStream.write(bArrDecode);
                outputStream.close();
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
                randomAccessFile.seek(i2);
                randomAccessFile.write(bArrDecode);
                randomAccessFile.close();
            }
            promise.resolve(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }

    @ReactMethod
    public void writeFile(String str, String str2, ReadableMap readableMap, Promise promise) throws IOException {
        try {
            byte[] bArrDecode = Base64.decode(str2, 0);
            OutputStream outputStream = getOutputStream(str, false);
            outputStream.write(bArrDecode);
            outputStream.close();
            promise.resolve(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            reject(promise, str, e2);
        }
    }
}
