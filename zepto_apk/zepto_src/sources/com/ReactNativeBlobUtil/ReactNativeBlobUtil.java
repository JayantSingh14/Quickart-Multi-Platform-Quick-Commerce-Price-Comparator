package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class ReactNativeBlobUtil extends ReactContextBaseJavaModule {
    private final ReactNativeBlobUtilImpl delegate;

    public ReactNativeBlobUtil(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new ReactNativeBlobUtilImpl(reactApplicationContext);
    }

    @ReactMethod
    public void actionViewIntent(String str, String str2, @Nullable String str3, final Promise promise) {
        Uri uriD;
        this.delegate.getClass();
        try {
            if (ReactNativeBlobUtilUtils.b(str)) {
                uriD = Uri.parse(str);
            } else {
                uriD = FileProvider.d(ReactNativeBlobUtilImpl.f13918b, ReactNativeBlobUtilImpl.f13918b.getPackageName() + ".provider", new File(str));
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriD, str2);
            intent.setFlags(1);
            intent.addFlags(268435456);
            if (str3 != null) {
                intent = Intent.createChooser(intent, str3);
            }
            try {
                ReactNativeBlobUtilImpl.f13918b.startActivity(intent);
                promise.resolve(Boolean.TRUE);
            } catch (ActivityNotFoundException unused) {
                promise.reject("ENOAPP", "No app installed for " + str2);
            }
            ReactNativeBlobUtilImpl.f13921e = true;
            ReactNativeBlobUtilImpl.f13918b.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.4
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public final void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public final void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public final void onHostResume() {
                    if (ReactNativeBlobUtilImpl.f13921e) {
                        promise.resolve(null);
                    }
                    ReactNativeBlobUtilImpl.f13918b.removeLifecycleEventListener(this);
                }
            });
        } catch (Exception e2) {
            promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        this.delegate.getClass();
        DownloadManager downloadManager = (DownloadManager) ReactNativeBlobUtilImpl.f13918b.getSystemService("download");
        if (readableMap == null || !readableMap.hasKey("path")) {
            promise.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload config or path missing.");
            return;
        }
        String strC = ReactNativeBlobUtilUtils.c(readableMap.getString("path"));
        if (strC == null) {
            promise.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload can not resolve URI:" + readableMap.getString("path"));
        } else {
            try {
                downloadManager.addCompletedDownload(readableMap.hasKey("title") ? readableMap.getString("title") : "", readableMap.hasKey("description") ? readableMap.getString("description") : "", true, readableMap.hasKey("mime") ? readableMap.getString("mime") : null, strC, Long.valueOf(ReactNativeBlobUtilFS.g(strC).getString("size")).longValue(), readableMap.hasKey("showNotification") && readableMap.getBoolean("showNotification"));
                promise.resolve(null);
            } catch (Exception e2) {
                promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
            }
        }
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void cancelRequest(String str, Callback callback) {
        this.delegate.getClass();
        try {
            ReactNativeBlobUtilReq.a(str);
            callback.invoke(null, str);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage(), null);
        }
    }

    @ReactMethod
    public void closeStream(String str, Callback callback) throws IOException {
        this.delegate.getClass();
        ReactNativeBlobUtilStream.a(str, callback);
    }

    @ReactMethod
    @RequiresApi
    public void copyToInternal(String str, String str2, Promise promise) throws Throwable {
        this.delegate.getClass();
        ReactNativeBlobUtilMediaCollection.a(Uri.parse(str), str2, promise);
    }

    @ReactMethod
    public void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise) throws IOException {
        this.delegate.getClass();
        if (!readableMap.hasKey(CLConstants.FIELD_PAY_INFO_NAME) || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
            return;
        }
        if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
            return;
        }
        if (str2 == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid path");
            return;
        }
        FileDescription fileDescription = new FileDescription(readableMap.getString(CLConstants.FIELD_PAY_INFO_NAME), readableMap.getString("mimeType"), readableMap.getString("parentFolder"));
        ReactNativeBlobUtilMediaCollection.MediaType mediaTypeValueOf = ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str);
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        Uri uriB = ReactNativeBlobUtilMediaCollection.b(fileDescription, mediaTypeValueOf);
        if (uriB == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
        } else if (ReactNativeBlobUtilMediaCollection.d(uriB, str2, false, promise, ReactNativeBlobUtilImpl.f13918b)) {
            promise.resolve(uriB.toString());
        }
    }

    @ReactMethod
    public void cp(final String str, final String str2, final Callback callback) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.5
            /* JADX WARN: Removed duplicated region for block: B:47:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00e7  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #7 {Exception -> 0x00f4, blocks: (B:52:0x00f0, B:56:0x00f8), top: B:62:0x00f0 }] */
            /* JADX WARN: Removed duplicated region for block: B:62:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 256
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.AnonymousClass5.run():void");
            }
        });
    }

    @ReactMethod
    public void createFile(final String str, final String str2, final String str3, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.2
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                String str4 = str;
                String str5 = str3;
                Promise promise2 = promise;
                try {
                    String strC = ReactNativeBlobUtilUtils.c(str4);
                    File file = new File(strC);
                    boolean zCreateNewFile = file.createNewFile();
                    boolean zEquals = str5.equals("uri");
                    String str6 = str2;
                    if (zEquals) {
                        File file2 = new File(str6.replace("ReactNativeBlobUtil-file://", ""));
                        if (!file2.exists()) {
                            promise2.reject("ENOENT", "Source file : " + str6 + " does not exist");
                            return;
                        }
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[10240];
                        for (int i2 = fileInputStream.read(bArr); i2 > 0; i2 = fileInputStream.read(bArr)) {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                        fileInputStream.close();
                        fileOutputStream.close();
                    } else {
                        if (!zCreateNewFile) {
                            promise2.reject("EEXIST", "File `" + strC + "` already exists");
                            return;
                        }
                        new FileOutputStream(file).write(ReactNativeBlobUtilUtils.d(str6, str5));
                    }
                    promise2.resolve(strC);
                } catch (Exception e2) {
                    promise2.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                }
            }
        });
    }

    @ReactMethod
    public void createFileASCII(final String str, final ReadableArray readableArray, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                String str2 = str;
                ReadableArray readableArray2 = readableArray;
                Promise promise2 = promise;
                try {
                    String strC = ReactNativeBlobUtilUtils.c(str2);
                    File file = new File(strC);
                    if (!file.createNewFile()) {
                        promise2.reject("EEXIST", "File at path `" + strC + "` already exists");
                        return;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[readableArray2.size()];
                    for (int i2 = 0; i2 < readableArray2.size(); i2++) {
                        bArr[i2] = (byte) readableArray2.getInt(i2);
                    }
                    fileOutputStream.write(bArr);
                    promise2.resolve(strC);
                } catch (Exception e2) {
                    promise2.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                }
            }
        });
    }

    @ReactMethod
    public void createMediaFile(ReadableMap readableMap, String str, Promise promise) throws IOException {
        this.delegate.getClass();
        if (!readableMap.hasKey(CLConstants.FIELD_PAY_INFO_NAME) || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
            return;
        }
        if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
        }
        FileDescription fileDescription = new FileDescription(readableMap.getString(CLConstants.FIELD_PAY_INFO_NAME), readableMap.getString("mimeType"), readableMap.getString("parentFolder"));
        ReactNativeBlobUtilMediaCollection.MediaType mediaTypeValueOf = ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str);
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        Uri uriB = ReactNativeBlobUtilMediaCollection.b(fileDescription, mediaTypeValueOf);
        if (uriB != null) {
            promise.resolve(uriB.toString());
        } else {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
        }
    }

    @ReactMethod
    public void df(final Callback callback) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13920d.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.12
            @Override // java.lang.Runnable
            public final void run() {
                ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
                StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
                writableMapCreateMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
                File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    StatFs statFs2 = new StatFs(externalFilesDir.getPath());
                    writableMapCreateMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
                    writableMapCreateMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
                } else {
                    writableMapCreateMap.putString("external_free", "-1");
                    writableMapCreateMap.putString("external_total", "-1");
                }
                callback.invoke(null, writableMapCreateMap);
            }
        });
    }

    @ReactMethod
    public void enableProgressReport(String str, int i2, int i3) {
        this.delegate.getClass();
        ReactNativeBlobUtilReq.y.put(str, new ReactNativeBlobUtilProgressConfig(i2, i3));
    }

    @ReactMethod
    public void enableUploadProgressReport(String str, int i2, int i3) {
        this.delegate.getClass();
        ReactNativeBlobUtilReq.z.put(str, new ReactNativeBlobUtilProgressConfig(i2, i3));
    }

    @ReactMethod
    public void exists(String str, Callback callback) throws IOException {
        this.delegate.getClass();
        if (str != null && str.startsWith("bundle-assets://")) {
            try {
                ReactNativeBlobUtilImpl.f13918b.getAssets().openFd(str.replace("bundle-assets://", ""));
                callback.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            } catch (IOException unused) {
                Boolean bool = Boolean.FALSE;
                callback.invoke(bool, bool);
                return;
            }
        }
        String strC = ReactNativeBlobUtilUtils.c(str);
        if (strC == null) {
            Boolean bool2 = Boolean.FALSE;
            callback.invoke(bool2, bool2);
        } else {
            callback.invoke(Boolean.valueOf(new File(strC).exists()), Boolean.valueOf(new File(strC).isDirectory()));
        }
    }

    @ReactMethod
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        ReactNativeBlobUtilImpl reactNativeBlobUtilImpl = this.delegate;
        reactNativeBlobUtilImpl.getClass();
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, str4, null, reactNativeBlobUtilImpl.f13923a, callback).run();
    }

    @ReactMethod
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilImpl reactNativeBlobUtilImpl = this.delegate;
        reactNativeBlobUtilImpl.getClass();
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, null, readableArray, reactNativeBlobUtilImpl.f13923a, callback).run();
    }

    @ReactMethod
    @RequiresApi
    public void getBlob(String str, String str2, Promise promise) throws IOException {
        this.delegate.getClass();
        ReactNativeBlobUtilMediaCollection.c(Uri.parse(str), str2, promise);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        HashMap map2 = new HashMap();
        File filesDir = reactApplicationContext.getFilesDir();
        map2.put("DocumentDir", filesDir != null ? filesDir.getAbsolutePath() : "");
        File cacheDir = reactApplicationContext.getCacheDir();
        map2.put("CacheDir", cacheDir != null ? cacheDir.getAbsolutePath() : "");
        map2.put("DCIMDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_DCIM));
        map2.put("PictureDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        map2.put("MusicDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        map2.put("DownloadDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        map2.put("MovieDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        map2.put("RingtoneDir", ReactNativeBlobUtilFS.b(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            map2.put("SDCardDir", ReactNativeBlobUtilFS.b(reactApplicationContext, null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir == null || externalFilesDir.getParentFile() == null) {
                map2.put("SDCardApplicationDir", "");
            } else {
                map2.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            }
        } else {
            map2.put("SDCardDir", "");
            map2.put("SDCardApplicationDir", "");
        }
        map2.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        map2.put("LibraryDir", "");
        map2.put("ApplicationSupportDir", "");
        map.putAll(map2);
        getReactApplicationContext();
        map.putAll(ReactNativeBlobUtilFS.c());
        return map;
    }

    @ReactMethod
    public void getContentIntent(String str, Promise promise) {
        this.delegate.getClass();
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        ReactNativeBlobUtilImpl.f13922f.put(99900, promise);
        ReactNativeBlobUtilImpl.f13918b.startActivityForResult(intent, 99900, null);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "ReactNativeBlobUtil";
    }

    @ReactMethod
    public void getSDCardApplicationDir(Promise promise) {
        this.delegate.getClass();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
            return;
        }
        try {
            promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
        } catch (Exception e2) {
            promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void getSDCardDir(Promise promise) {
        this.delegate.getClass();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
            return;
        }
        try {
            promise.resolve(reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
        } catch (Exception e2) {
            promise.reject("ReactNativeBlobUtil.getSDCardDir", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void hash(final String str, final String str2, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.10
            @Override // java.lang.Runnable
            public final void run() throws NoSuchAlgorithmException, IOException {
                String str3 = str;
                String str4 = str2;
                Promise promise2 = promise;
                try {
                    HashMap map = new HashMap();
                    map.put("md5", MessageDigestAlgorithms.MD5);
                    map.put("sha1", MessageDigestAlgorithms.SHA_1);
                    map.put("sha224", MessageDigestAlgorithms.SHA_224);
                    map.put("sha256", MessageDigestAlgorithms.SHA_256);
                    map.put("sha384", MessageDigestAlgorithms.SHA_384);
                    map.put("sha512", MessageDigestAlgorithms.SHA_512);
                    if (!map.containsKey(str4)) {
                        promise2.reject("EINVAL", "Invalid algorithm '" + str4 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                        return;
                    }
                    String strC = ReactNativeBlobUtilUtils.c(str3);
                    File file = new File(strC);
                    if (file.isDirectory()) {
                        promise2.reject("EISDIR", "Expecting a file but '" + strC + "' is a directory");
                        return;
                    }
                    if (!file.exists()) {
                        promise2.reject("ENOENT", "No such file '" + strC + "'");
                        return;
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance((String) map.get(str4));
                    FileInputStream fileInputStream = new FileInputStream(strC);
                    byte[] bArr = new byte[1048576];
                    long length = file.length();
                    if (length != 0) {
                        while (true) {
                            int i2 = fileInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else {
                                messageDigest.update(bArr, 0, i2);
                            }
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : messageDigest.digest()) {
                        sb.append(String.format("%02x", Byte.valueOf(b2)));
                    }
                    promise2.resolve(sb.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    promise2.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                }
            }
        });
    }

    @ReactMethod
    public void ls(String str, Promise promise) {
        this.delegate.getClass();
        try {
            String strC = ReactNativeBlobUtilUtils.c(str);
            File file = new File(strC);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strC + "'");
                return;
            }
            if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + strC + "'");
                return;
            }
            String[] list = new File(strC).list();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str2 : list) {
                writableArrayCreateArray.pushString(str2);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void lstat(String str, final Callback callback) {
        this.delegate.getClass();
        new AsyncTask<String, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.1
            @Override // android.os.AsyncTask
            public final Integer doInBackground(String[] strArr) {
                String[] strArr2 = strArr;
                WritableArray writableArrayCreateArray = Arguments.createArray();
                String str2 = strArr2[0];
                Callback callback2 = callback;
                if (str2 == null) {
                    callback2.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr2[0]);
                if (!file.exists()) {
                    callback2.invoke(b.r(new StringBuilder("failed to lstat path `"), strArr2[0], "` because it does not exist or it is not a folder"));
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str3 : file.list()) {
                        writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.g(file.getPath() + "/" + str3));
                    }
                } else {
                    writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.g(file.getAbsolutePath()));
                }
                callback2.invoke(null, writableArrayCreateArray);
                return 0;
            }
        }.execute(ReactNativeBlobUtilUtils.c(str));
    }

    @ReactMethod
    public void mkdir(String str, Promise promise) {
        this.delegate.getClass();
        String strC = ReactNativeBlobUtilUtils.c(str);
        File file = new File(strC);
        if (file.exists()) {
            promise.reject("EEXIST", a.n(new StringBuilder(), file.isDirectory() ? "Folder" : "File", " '", strC, "' already exists"));
            return;
        }
        try {
            if (file.mkdirs()) {
                promise.resolve(Boolean.TRUE);
                return;
            }
            promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + strC + "'");
        } catch (Exception e2) {
            promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void mv(String str, String str2, Callback callback) {
        this.delegate.getClass();
        String strC = ReactNativeBlobUtilUtils.c(str);
        String strC2 = ReactNativeBlobUtilUtils.c(str2);
        File file = new File(strC);
        if (!file.exists()) {
            callback.invoke(b.D("Source file at path `", strC, "` does not exist"));
            return;
        }
        try {
            File file2 = new File(strC2);
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                callback.invoke("mv failed because the destination directory doesn't exist");
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                callback.invoke(new Object[0]);
            } else {
                callback.invoke("mv failed for unknown reasons");
            }
        } catch (Exception e2) {
            callback.invoke(e2.toString());
        }
    }

    @ReactMethod
    public void readFile(final String str, final String str2, final boolean z, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.6
            /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 324
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.AnonymousClass6.run():void");
            }
        });
    }

    @ReactMethod
    public void readStream(final String str, final String str2, final int i2, final int i3, final String str3) {
        this.delegate.getClass();
        final ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        ReactNativeBlobUtilImpl.f13920d.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.11
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                ReactNativeBlobUtilStream reactNativeBlobUtilStream = new ReactNativeBlobUtilStream(reactApplicationContext);
                String str4 = str2;
                String str5 = str3;
                ReactApplicationContext reactApplicationContext2 = ReactNativeBlobUtilImpl.f13918b;
                String str6 = str;
                String strC = ReactNativeBlobUtilUtils.c(str6);
                if (strC != null) {
                    str6 = strC;
                }
                try {
                    int i4 = str4.equalsIgnoreCase("base64") ? 4095 : 4096;
                    int i5 = i2;
                    if (i5 > 0) {
                        i4 = i5;
                    }
                    InputStream inputStreamOpenInputStream = (strC == null || !str6.startsWith("bundle-assets://")) ? strC == null ? ReactNativeBlobUtilImpl.f13918b.getContentResolver().openInputStream(Uri.parse(str6)) : new FileInputStream(new File(str6)) : ReactNativeBlobUtilImpl.f13918b.getAssets().open(str6.replace("bundle-assets://", ""));
                    boolean zEqualsIgnoreCase = str4.equalsIgnoreCase("utf8");
                    int i6 = i3;
                    int i7 = -1;
                    String str7 = "data";
                    if (zEqualsIgnoreCase) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenInputStream, Charset.forName("UTF-8"));
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, i4);
                        char[] cArr = new char[i4];
                        for (int i8 = 0; bufferedReader.read(cArr, i8, i4) != -1; i8 = 0) {
                            reactNativeBlobUtilStream.c(str5, "data", new String(cArr));
                            if (i6 > 0) {
                                SystemClock.sleep(i6);
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                    } else if (str4.equalsIgnoreCase("ascii")) {
                        byte[] bArr = new byte[i4];
                        while (true) {
                            int i9 = inputStreamOpenInputStream.read(bArr);
                            if (i9 == -1) {
                                break;
                            }
                            WritableArray writableArrayCreateArray = Arguments.createArray();
                            for (int i10 = 0; i10 < i9; i10++) {
                                writableArrayCreateArray.pushInt(bArr[i10]);
                            }
                            reactNativeBlobUtilStream.b(str5, writableArrayCreateArray);
                            if (i6 > 0) {
                                SystemClock.sleep(i6);
                            }
                        }
                    } else {
                        if (!str4.equalsIgnoreCase("base64")) {
                            reactNativeBlobUtilStream.d(str5, "EINVAL", "Unrecognized encoding `" + str4 + "`, should be one of `base64`, `utf8`, `ascii`");
                            inputStreamOpenInputStream.close();
                        }
                        byte[] bArr2 = new byte[i4];
                        while (true) {
                            int i11 = inputStreamOpenInputStream.read(bArr2);
                            if (i11 == i7) {
                                break;
                            }
                            if (i11 < i4) {
                                byte[] bArr3 = new byte[i11];
                                System.arraycopy(bArr2, 0, bArr3, 0, i11);
                                reactNativeBlobUtilStream.c(str5, str7, Base64.encodeToString(bArr3, 2));
                            } else {
                                reactNativeBlobUtilStream.c(str5, str7, Base64.encodeToString(bArr2, 2));
                            }
                            if (i6 > 0) {
                                SystemClock.sleep(i6);
                                str7 = str7;
                                i7 = -1;
                            }
                        }
                    }
                    reactNativeBlobUtilStream.c(str5, "end", "");
                    inputStreamOpenInputStream.close();
                } catch (FileNotFoundException unused) {
                    reactNativeBlobUtilStream.d(str5, "ENOENT", b.D("No such file '", str6, "'"));
                } catch (Exception e2) {
                    reactNativeBlobUtilStream.d(str5, "EUNSPECIFIED", b.D("Failed to convert data to ", str4, " encoded string. This might be because this encoding cannot be used for this data."));
                    e2.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void removeSession(ReadableArray readableArray, final Callback callback) {
        this.delegate.getClass();
        new AsyncTask<ReadableArray, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.3
            @Override // android.os.AsyncTask
            public final Integer doInBackground(ReadableArray[] readableArrayArr) {
                ReadableArray[] readableArrayArr2 = readableArrayArr;
                Callback callback2 = callback;
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < readableArrayArr2[0].size(); i2++) {
                        String string = readableArrayArr2[0].getString(i2);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        callback2.invoke(null, Boolean.TRUE);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        callback2.invoke(sb.toString());
                    }
                } catch (Exception e2) {
                    callback2.invoke(e2.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr2[0].size());
            }
        }.execute(readableArray);
    }

    @ReactMethod
    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        this.delegate.getClass();
        final ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.9
            @Override // java.lang.Runnable
            public final void run() {
                ReadableArray readableArray2 = readableArray;
                int size = readableArray2.size();
                String[] strArr = new String[size];
                String[] strArr2 = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    ReadableMap map = readableArray2.getMap(i2);
                    if (map.hasKey("path")) {
                        strArr[i2] = map.getString("path");
                        if (map.hasKey("mime")) {
                            strArr2[i2] = map.getString("mime");
                        } else {
                            strArr2[i2] = null;
                        }
                    }
                }
                ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
                final Callback callback2 = callback;
                try {
                    MediaScannerConnection.scanFile(reactApplicationContext2, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.2
                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                        public final void onScanCompleted(String str, Uri uri) {
                            callback2.invoke(null, Boolean.TRUE);
                        }
                    });
                } catch (Exception e2) {
                    callback2.invoke(e2.getLocalizedMessage(), null);
                }
            }
        });
    }

    @ReactMethod
    public void slice(String str, String str2, int i2, int i3, Promise promise) throws IOException {
        this.delegate.getClass();
        try {
            String strC = ReactNativeBlobUtilUtils.c(str);
            String strC2 = ReactNativeBlobUtilUtils.c(str2);
            File file = new File(strC);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + strC + "' is a directory");
                return;
            }
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strC + "'");
                return;
            }
            int length = (int) file.length();
            int iMin = Math.min(length, i3) - i2;
            FileInputStream fileInputStream = new FileInputStream(new File(strC));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(strC2));
            int iSkip = (int) fileInputStream.skip(i2);
            if (iSkip != i2) {
                promise.reject("EUNSPECIFIED", "Skipped " + iSkip + " instead of the specified " + i2 + " bytes, size is " + length);
                return;
            }
            byte[] bArr = new byte[10240];
            int i4 = 0;
            while (i4 < iMin) {
                int i5 = fileInputStream.read(bArr, 0, 10240);
                int i6 = iMin - i4;
                if (i5 <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, Math.min(i6, i5));
                i4 += i5;
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            promise.resolve(strC2);
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void stat(String str, Callback callback) {
        this.delegate.getClass();
        try {
            String strC = ReactNativeBlobUtilUtils.c(str);
            WritableMap writableMapG = ReactNativeBlobUtilFS.g(strC);
            if (writableMapG != null) {
                callback.invoke(null, writableMapG);
                return;
            }
            callback.invoke("failed to stat path `" + strC + "` because it does not exist or it is not a folder", null);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void unlink(String str, Callback callback) {
        this.delegate.getClass();
        try {
            ReactNativeBlobUtilFS.a(new File(ReactNativeBlobUtilUtils.c(str)));
            callback.invoke(null, Boolean.TRUE);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage(), Boolean.FALSE);
        }
    }

    @ReactMethod
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) throws IOException {
        this.delegate.getClass();
        ReactNativeBlobUtilStream.e(str, readableArray, callback);
    }

    @ReactMethod
    public void writeChunk(String str, String str2, Callback callback) throws IOException {
        this.delegate.getClass();
        ReactNativeBlobUtilStream.f(str, str2, callback);
    }

    @ReactMethod
    public void writeFile(final String str, final String str2, final String str3, final boolean z, final boolean z2, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.8
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                int length;
                FileOutputStream fileOutputStream;
                String str4 = str;
                String str5 = str2;
                Promise promise2 = promise;
                try {
                    File file = new File(str4);
                    File parentFile = file.getParentFile();
                    if (!file.exists()) {
                        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                            promise2.reject("EUNSPECIFIED", "Failed to create parent directory of '" + str4 + "'");
                            return;
                        }
                        if (!file.createNewFile()) {
                            promise2.reject("ENOENT", "File '" + str4 + "' does not exist and could not be created");
                            return;
                        }
                    }
                    boolean zEqualsIgnoreCase = str5.equalsIgnoreCase("uri");
                    String str6 = str3;
                    boolean z3 = z2;
                    if (zEqualsIgnoreCase) {
                        String strC = ReactNativeBlobUtilUtils.c(str6);
                        File file2 = new File(strC);
                        if (!file2.exists()) {
                            promise2.reject("ENOENT", "No such file '" + str4 + "' ('" + strC + "')");
                            return;
                        }
                        byte[] bArr = new byte[10240];
                        FileInputStream fileInputStream = null;
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file2);
                            try {
                                fileOutputStream = new FileOutputStream(file, z3);
                                length = 0;
                                while (true) {
                                    try {
                                        int i2 = fileInputStream2.read(bArr);
                                        if (i2 <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i2);
                                        length += i2;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                                fileInputStream2.close();
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } else {
                        byte[] bArrD = ReactNativeBlobUtilUtils.d(str6, str5);
                        if (z) {
                            throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file, z3);
                        try {
                            fileOutputStream2.write(bArrD);
                            length = bArrD.length;
                        } finally {
                            fileOutputStream2.close();
                        }
                    }
                    promise2.resolve(Integer.valueOf(length));
                } catch (FileNotFoundException unused) {
                    promise2.reject("ENOENT", "File '" + str4 + "' does not exist and could not be created, or it is a directory");
                } catch (Exception e2) {
                    promise2.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                }
            }
        });
    }

    @ReactMethod
    public void writeFileArray(final String str, final ReadableArray readableArray, final boolean z, final Promise promise) {
        this.delegate.getClass();
        ReactNativeBlobUtilImpl.f13919c.execute(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.7
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                String str2 = str;
                ReadableArray readableArray2 = readableArray;
                boolean z2 = z;
                Promise promise2 = promise;
                try {
                    File file = new File(str2);
                    File parentFile = file.getParentFile();
                    if (!file.exists()) {
                        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                            promise2.reject("ENOTDIR", "Failed to create parent directory of '" + str2 + "'");
                            return;
                        }
                        if (!file.createNewFile()) {
                            promise2.reject("ENOENT", "File '" + str2 + "' does not exist and could not be created");
                            return;
                        }
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file, z2);
                    try {
                        byte[] bArr = new byte[readableArray2.size()];
                        for (int i2 = 0; i2 < readableArray2.size(); i2++) {
                            bArr[i2] = (byte) readableArray2.getInt(i2);
                        }
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        promise2.resolve(Integer.valueOf(readableArray2.size()));
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (FileNotFoundException unused) {
                    promise2.reject("ENOENT", "File '" + str2 + "' does not exist and could not be created");
                } catch (Exception e2) {
                    promise2.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                }
            }
        });
    }

    @ReactMethod
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        this.delegate.getClass();
        new ReactNativeBlobUtilStream(ReactNativeBlobUtilImpl.f13918b).g(str, str2, z, callback);
    }

    @ReactMethod
    public void writeToMediaFile(String str, String str2, boolean z, Promise promise) {
        this.delegate.getClass();
        if (ReactNativeBlobUtilMediaCollection.d(Uri.parse(str), str2, z, promise, ReactNativeBlobUtilImpl.f13918b)) {
            promise.resolve("Success");
        }
    }
}
