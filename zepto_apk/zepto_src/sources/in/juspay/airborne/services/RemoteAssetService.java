package in.juspay.airborne.services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.airborne.TrackerCallback;
import in.juspay.airborne.network.OTANetUtils;
import in.juspay.airborne.utils.OTAUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RemoteAssetService {
    private static final String LOG_TAG = "RemoteAssetService";
    private static final JSONArray fileDownloadTimes = new JSONArray();
    private JSONObject assetMetadata;

    @NonNull
    private final OTAServices otaServices;

    public static class AssetDownloadTask extends AsyncTask<Void, Void, Boolean> {
        private final WeakReference<Context> contextWeakReference;

        @Nullable
        private final DownloadCallback downloadCallback;
        private final String fileName;
        private final String location;
        private final RemoteAssetService remoteAssetService;
        private final long renewFileStartTime;
        private final long ttlInMilliSeconds;

        public AssetDownloadTask(@NonNull Context context, String str, String str2, long j2, RemoteAssetService remoteAssetService, long j3, @Nullable DownloadCallback downloadCallback) {
            this.location = str;
            this.fileName = str2;
            this.ttlInMilliSeconds = j2;
            this.remoteAssetService = remoteAssetService;
            this.contextWeakReference = new WeakReference<>(context);
            this.renewFileStartTime = j3;
            this.downloadCallback = downloadCallback;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            Context context = this.contextWeakReference.get();
            if (context != null) {
                try {
                    if (!this.location.contains("certificates")) {
                        return Boolean.valueOf(this.remoteAssetService.getContent(context, this.location, this.fileName, this.ttlInMilliSeconds));
                    }
                    this.remoteAssetService.updateCertificates(context, this.location, this.ttlInMilliSeconds);
                } catch (Exception e2) {
                    this.remoteAssetService.otaServices.getTrackerCallback().trackAndLogException(RemoteAssetService.LOG_TAG, "action", "system", "remote_asset_service", "Could not renew file " + this.location + ": " + e2.getMessage(), e2);
                }
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) throws JSONException {
            super.onPostExecute((AssetDownloadTask) bool);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - this.renewFileStartTime;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startTime", this.renewFileStartTime);
                jSONObject.put("endTime", jCurrentTimeMillis);
                jSONObject.put("totalTime", j2);
                jSONObject.put("fileName", this.fileName);
            } catch (JSONException unused) {
            }
            RemoteAssetService.fileDownloadTimes.put(jSONObject);
            DownloadCallback downloadCallback = this.downloadCallback;
            if (downloadCallback != null) {
                downloadCallback.onDownload(bool.booleanValue(), this.location, this.remoteAssetService.otaServices.getFileProviderService().hyperFileUtil.appendSdkNameAndVersion(this.fileName));
            }
        }
    }

    public interface DownloadCallback {
        void onDownload(boolean z, String str, String str2);
    }

    public RemoteAssetService(@NonNull OTAServices oTAServices) {
        this.otaServices = oTAServices;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #0 {Exception -> 0x006e, blocks: (B:7:0x002d, B:9:0x0033, B:10:0x004c), top: B:17:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String decideAndUpdateInternalStorage(@androidx.annotation.NonNull android.content.Context r10, byte[] r11, java.lang.String r12, java.lang.String r13) throws java.security.NoSuchAlgorithmException {
        /*
            r9 = this;
            java.lang.String r0 = in.juspay.airborne.utils.OTAUtils.md5(r11)
            if (r0 != 0) goto L8
            java.lang.String r0 = ""
        L8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "hashInDisk: "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RemoteAssetService"
            android.util.Log.d(r2, r1)
            java.lang.String r1 = "newHash: "
            java.lang.String r1 = r1.concat(r0)
            android.util.Log.d(r2, r1)
            in.juspay.airborne.services.OTAServices r1 = r9.otaServices
            in.juspay.airborne.TrackerCallback r2 = r1.getTrackerCallback()
            r1 = 0
            if (r12 == 0) goto L4c
            boolean r12 = r12.equals(r0)     // Catch: java.lang.Exception -> L6e
            if (r12 == 0) goto L4c
            java.lang.String r3 = "action"
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "remote_asset_service"
            java.lang.String r7 = "remote_asset_service_compare_hash"
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Exception -> L6e
            r10.<init>()     // Catch: java.lang.Exception -> L6e
            java.lang.String r11 = "Remote hash is same as disk hash. Not updating asset"
            org.json.JSONObject r8 = r10.put(r11, r13)     // Catch: java.lang.Exception -> L6e
            r2.track(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L6e
            goto L6e
        L4c:
            java.lang.String r3 = "action"
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "remote_asset_service"
            java.lang.String r7 = "remote_asset_service_compare_hash"
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Exception -> L6e
            r12.<init>()     // Catch: java.lang.Exception -> L6e
            java.lang.String r8 = "Remote hash differs from disk hash. Updating asset"
            org.json.JSONObject r8 = r12.put(r8, r13)     // Catch: java.lang.Exception -> L6e
            r2.track(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L6e
            in.juspay.airborne.services.OTAServices r12 = r9.otaServices     // Catch: java.lang.Exception -> L6e
            in.juspay.airborne.services.FileProviderService r12 = r12.getFileProviderService()     // Catch: java.lang.Exception -> L6e
            boolean r1 = r12.updateFile(r10, r13, r11)     // Catch: java.lang.Exception -> L6e
        L6e:
            if (r1 == 0) goto L71
            goto L72
        L71:
            r0 = 0
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.airborne.services.RemoteAssetService.decideAndUpdateInternalStorage(android.content.Context, byte[], java.lang.String, java.lang.String):java.lang.String");
    }

    private byte[] download(String str, String str2) {
        HashMap map = new HashMap();
        map.put("ts", String.valueOf(System.currentTimeMillis()));
        map.put("If-None-Match", str);
        map.put("Accept-Encoding", "gzip");
        Log.d(LOG_TAG, "START fetching content from: " + str2);
        try {
            String clientId = this.otaServices.getClientId();
            if (clientId == null) {
                clientId = "";
            }
            return new OTANetUtils(Workspace.getCtx(), clientId, this.otaServices.getCleanUpValue()).fetchIfModified(str2, map);
        } catch (Exception e2) {
            this.otaServices.getTrackerCallback().trackAndLogException(LOG_TAG, "action", "system", "remote_asset_service", "Error While Downloading File", e2);
            return null;
        }
    }

    private long getAssetTtl() {
        return Long.parseLong(this.otaServices.getWorkspace().getFromSharedPreference("REMOTE_ASSET_TTL_MILLISECONDS", String.valueOf(DateUtils.MILLIS_PER_HOUR)));
    }

    private synchronized void setMetadata(String str, JSONObject jSONObject) throws JSONException {
        try {
            if (this.assetMetadata == null) {
                getMetadata(str);
            }
            this.assetMetadata.put(str, jSONObject);
            this.otaServices.getWorkspace().writeToSharedPreference("asset_metadata.json", this.assetMetadata.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    private String unzipAndUpdateInternalStorage(@NonNull Context context, byte[] bArr) throws NoSuchAlgorithmException, IOException {
        String strMd5 = OTAUtils.md5(bArr);
        if (strMd5 == null) {
            strMd5 = "";
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return strMd5;
                }
                String name = nextEntry.getName();
                if (!nextEntry.isDirectory()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i2 = zipInputStream.read();
                            if (i2 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i2);
                        } catch (Throwable th) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    this.otaServices.getFileProviderService().updateCertificate(context, name, byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                }
            } catch (Throwable th3) {
                try {
                    zipInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCertificates(@NonNull Context context, String str, long j2) throws JSONException, NoSuchAlgorithmException, IOException {
        String string;
        String strMd5;
        TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        FileProviderService fileProviderService = this.otaServices.getFileProviderService();
        JSONObject metadata = getMetadata(str);
        boolean z = true;
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        if (metadata.getString("lastChecked") != null) {
            string = metadata.getString("hashInDisk");
            strMd5 = metadata.getString("zipHashInDisk");
        } else {
            string = "";
            strMd5 = string;
        }
        byte[] bArrDownload = download(strMd5, str);
        if (bArrDownload != null) {
            strMd5 = OTAUtils.md5(bArrDownload);
        } else {
            z = false;
        }
        boolean z2 = z;
        if (!this.otaServices.getFromAirborne()) {
            bArrDownload = fileProviderService.hyperFileUtil.verifyFileForHyperSDK(bArrDownload, strSubstring);
        }
        byte[] bArr = bArrDownload;
        Log.d(LOG_TAG, "DONE fetching content from: ".concat(str));
        Log.d(LOG_TAG, "hashInDisk: " + string);
        Log.d(LOG_TAG, "newHash: ");
        Object obj = strMd5;
        trackerCallback.track("action", "system", "info", "remote_asset_service", "remote_asset_service_update_hash", new JSONObject().put("Hash of file in disk", strSubstring).put("new hash", ""));
        if (bArr == null) {
            if (z2) {
                return;
            }
            trackerCallback.track("action", "system", "info", "remote_asset_service", "remote_asset_service_etag_match", new JSONObject().put("ETAG matched for", strSubstring).put("Not downloading from", str));
        } else {
            String strUnzipAndUpdateInternalStorage = unzipAndUpdateInternalStorage(context, bArr);
            metadata.put("lastChecked", System.currentTimeMillis());
            metadata.put("hashInDisk", strUnzipAndUpdateInternalStorage);
            metadata.put("zipHashInDisk", obj);
            setMetadata(str, metadata);
        }
    }

    public boolean getContent(@NonNull Context context, String str) throws Exception {
        return getContent(context, str, getAssetTtl());
    }

    public JSONArray getFileDownloadTimes() {
        return fileDownloadTimes;
    }

    public synchronized JSONObject getMetadata(String str) throws JSONException {
        try {
            TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
            try {
                this.assetMetadata = new JSONObject(this.otaServices.getWorkspace().getFromSharedPreference("asset_metadata.json", "{}"));
                Log.d(LOG_TAG, "assetMetadata: " + this.assetMetadata);
                if (!this.assetMetadata.has(str)) {
                    this.assetMetadata.put(str, new JSONObject());
                    ((JSONObject) this.assetMetadata.get(str)).put("lastChecked", 0);
                    ((JSONObject) this.assetMetadata.get(str)).put("hashInDisk", "");
                    ((JSONObject) this.assetMetadata.get(str)).put("zipHashInDisk", "");
                }
            } catch (JSONException e2) {
                trackerCallback.trackAndLogException(LOG_TAG, "action", "system", "remote_asset_service", "Exception trying to read from KeyStore: asset_metadata.json", e2);
                throw new RuntimeException("Unexpected internal error.", e2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (JSONObject) this.assetMetadata.get(str);
    }

    public void renewFile(@NonNull Context context, String str, String str2, long j2, DownloadCallback downloadCallback) {
        renewFile(context, str, getAssetTtl(), str2, j2, downloadCallback);
    }

    public synchronized void resetMetadata(String str) throws JSONException {
        try {
            if (this.assetMetadata == null) {
                getMetadata(str);
            }
            this.assetMetadata.remove(str);
            this.otaServices.getWorkspace().writeToSharedPreference("asset_metadata.json", this.assetMetadata.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean getContent(@NonNull Context context, String str, long j2) throws Exception {
        return getContent(context, str, null, j2);
    }

    public void renewFile(@NonNull Context context, String str, long j2, DownloadCallback downloadCallback) {
        renewFile(context, str, getAssetTtl(), null, j2, downloadCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getContent(@NonNull Context context, String str, String str2, long j2) throws Exception {
        String fromFile;
        String strMd5;
        FileProviderService fileProviderService = this.otaServices.getFileProviderService();
        TrackerCallback trackerCallback = this.otaServices.getTrackerCallback();
        int iLastIndexOf = str.lastIndexOf("/");
        if (str2 == null) {
            str2 = str.substring(iLastIndexOf + 1);
        }
        JSONObject metadata = !this.otaServices.getFromAirborne() ? fileProviderService.hyperFileUtil.getMetadata(str2) : getMetadata(str2);
        if (metadata.getString("lastChecked") != null) {
            fromFile = metadata.getString("hashInDisk");
            strMd5 = metadata.getString("zipHashInDisk");
        } else {
            fromFile = fileProviderService.readFromFile(str2 + ".hash");
            strMd5 = "";
        }
        byte[] bArrDownload = download(strMd5, str);
        if (bArrDownload != null) {
            strMd5 = OTAUtils.md5(bArrDownload);
        }
        if (!this.otaServices.getFromAirborne()) {
            bArrDownload = fileProviderService.hyperFileUtil.verifyFileForHyperSDK(bArrDownload, str2);
        }
        if (bArrDownload == null) {
            trackerCallback.track("action", "system", "info", "remote_asset_service", "remote_asset_service_etag_match", new JSONObject().put("ETAG matched for file", str2).put("Not downloading from", str));
            return false;
        }
        Log.d(LOG_TAG, "DONE fetching content from: ".concat(str));
        Log.d(LOG_TAG, "Text: ".concat(new String(bArrDownload)));
        String strDecideAndUpdateInternalStorage = decideAndUpdateInternalStorage(context, bArrDownload, fromFile, str2);
        if (strDecideAndUpdateInternalStorage != null) {
            fileProviderService.writeFileToDisk(context, strDecideAndUpdateInternalStorage, str2 + ".hash");
            metadata.put("lastChecked", System.currentTimeMillis());
            metadata.put("hashInDisk", strDecideAndUpdateInternalStorage);
            metadata.put("zipHashInDisk", strMd5);
            setMetadata(fileProviderService.hyperFileUtil.getFileNameForMetadata(str2), metadata);
        }
        return true;
    }

    public void renewFile(@NonNull Context context, String str, long j2, String str2, long j3, @Nullable DownloadCallback downloadCallback) {
        Log.d(LOG_TAG, "Looking to renew file: " + str);
        new AssetDownloadTask(context, str, str2, j2, this, j3, downloadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
