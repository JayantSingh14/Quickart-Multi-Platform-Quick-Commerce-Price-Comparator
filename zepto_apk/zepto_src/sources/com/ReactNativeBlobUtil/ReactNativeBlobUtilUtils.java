package com.ReactNativeBlobUtil;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import coil3.util.UtilsKt;
import com.ReactNativeBlobUtil.Utils.PathResolver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilUtils {

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils$1, reason: invalid class name */
    class AnonymousClass1 implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static void a(String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("event", "warn");
        writableMapCreateMap.putString("detail", str);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.f13918b.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilMessage", writableMapCreateMap);
    }

    public static boolean b(String str) {
        return str != null && str.startsWith("content://");
    }

    public static String c(String str) {
        String string;
        Uri uri = null;
        if (str != null) {
            if (str.matches("\\w+\\:.*")) {
                if (str.startsWith("file://")) {
                    return str.replace("file://", "");
                }
                Uri uri2 = Uri.parse(str);
                if (!str.startsWith("bundle-assets://")) {
                    ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
                    if (DocumentsContract.isDocumentUri(reactApplicationContext, uri2)) {
                        if ("com.android.externalstorage.documents".equals(uri2.getAuthority())) {
                            String[] strArrSplit = DocumentsContract.getDocumentId(uri2).split(":");
                            if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                                File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
                                if (externalFilesDir == null) {
                                    return "";
                                }
                                return externalFilesDir + "/" + strArrSplit[1];
                            }
                        } else if ("com.android.providers.downloads.documents".equals(uri2.getAuthority())) {
                            try {
                                String documentId = DocumentsContract.getDocumentId(uri2);
                                if (documentId == null || !documentId.startsWith("raw:/")) {
                                    return PathResolver.a(reactApplicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ((documentId == null || !documentId.startsWith("msf:")) ? Long.valueOf(documentId) : Long.valueOf(documentId.split(":")[1])).longValue()), null, null);
                                }
                                return Uri.parse(documentId).getPath();
                            } catch (Exception unused) {
                            }
                        } else {
                            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                                String[] strArrSplit2 = DocumentsContract.getDocumentId(uri2).split(":");
                                String str2 = strArrSplit2[0];
                                if ("image".equals(str2)) {
                                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                } else if ("video".equals(str2)) {
                                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                                } else if ("audio".equals(str2)) {
                                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                }
                                return PathResolver.a(reactApplicationContext, uri, "_id=?", new String[]{strArrSplit2[1]});
                            }
                            if ("content".equalsIgnoreCase(uri2.getScheme())) {
                                return "com.google.android.apps.photos.content".equals(uri2.getAuthority()) ? uri2.getLastPathSegment() : PathResolver.a(reactApplicationContext, uri2, null, null);
                            }
                            try {
                                InputStream inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(uri2);
                                if (inputStreamOpenInputStream != null) {
                                    Cursor cursorQuery = reactApplicationContext.getContentResolver().query(uri2, null, null, null, null);
                                    cursorQuery.moveToFirst();
                                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                                    if (columnIndex >= 0) {
                                        string = cursorQuery.getString(columnIndex);
                                        cursorQuery.close();
                                    } else {
                                        string = null;
                                    }
                                    if (string != null) {
                                        File file = new File(reactApplicationContext.getCacheDir(), string);
                                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                                        byte[] bArr = new byte[1024];
                                        while (inputStreamOpenInputStream.read(bArr) > 0) {
                                            fileOutputStream.write(bArr);
                                        }
                                        fileOutputStream.close();
                                        inputStreamOpenInputStream.close();
                                        return file.getAbsolutePath();
                                    }
                                }
                            } catch (Exception e2) {
                                a(e2.toString());
                            }
                        }
                    } else {
                        if ("content".equalsIgnoreCase(uri2.getScheme())) {
                            return "com.google.android.apps.photos.content".equals(uri2.getAuthority()) ? uri2.getLastPathSegment() : PathResolver.a(reactApplicationContext, uri2, null, null);
                        }
                        if (UtilsKt.SCHEME_FILE.equalsIgnoreCase(uri2.getScheme())) {
                            return uri2.getPath();
                        }
                    }
                }
            }
            return str;
        }
        return null;
    }

    public static byte[] d(String str, String str2) {
        return str2.equalsIgnoreCase("ascii") ? str.getBytes(Charset.forName("US-ASCII")) : str2.toLowerCase(Locale.ROOT).contains("base64") ? Base64.decode(str, 2) : str2.equalsIgnoreCase("utf8") ? str.getBytes(Charset.forName("UTF-8")) : str.getBytes(Charset.forName("US-ASCII"));
    }
}
