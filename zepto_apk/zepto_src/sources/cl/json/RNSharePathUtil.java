package cl.json;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import coil3.util.UtilsKt;
import com.facebook.react.bridge.ReactContext;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class RNSharePathUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f13817a = new ArrayList();

    public static Uri a(ReactContext reactContext, File file) {
        ArrayList arrayList = f13817a;
        if (arrayList.size() == 0) {
            ComponentCallbacks2 componentCallbacks2 = (Application) reactContext.getApplicationContext();
            if (componentCallbacks2 instanceof ShareApplication) {
                arrayList.add(((ShareApplication) componentCallbacks2).a());
            }
            arrayList.add(reactContext.getPackageName() + ".rnshare.fileprovider");
        }
        String authority = Uri.fromFile(file).getAuthority();
        if (!TextUtils.isEmpty(authority) && arrayList.contains(authority)) {
            return Uri.fromFile(file);
        }
        if (file.getAbsolutePath().startsWith("content://")) {
            return Uri.fromFile(file);
        }
        Uri uriD = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            try {
                uriD = FileProvider.d(reactContext, (String) arrayList.get(i2), file);
            } catch (Exception e2) {
                System.out.println("RNSharePathUtil::compatUriFromFile ERROR " + e2.getMessage());
            }
            if (uriD != null) {
                break;
            }
        }
        return uriD;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r7 = 0
            androidx.loader.content.CursorLoader r1 = new androidx.loader.content.CursorLoader     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            android.database.Cursor r8 = r1.i()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r8 == 0) goto L2f
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2c
            if (r9 == 0) goto L2f
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2c
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2c
            r8.close()
            return r9
        L28:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L44
        L2c:
            r0 = move-exception
            r9 = r0
            goto L3b
        L2f:
            if (r8 == 0) goto L43
            r8.close()
            return r7
        L35:
            r0 = move-exception
            r9 = r0
            goto L44
        L38:
            r0 = move-exception
            r9 = r0
            r8 = r7
        L3b:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L28
            if (r8 == 0) goto L43
            r8.close()
        L43:
            return r7
        L44:
            if (r7 == 0) goto L49
            r7.close()
        L49:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.RNSharePathUtil.b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String c(Context context, Uri uri, Boolean bool) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                String str = strArrSplit[0];
                if ("primary".equalsIgnoreCase(str) || "0".equalsIgnoreCase(str)) {
                    return "" + (bool.booleanValue() ? context.getCacheDir() : context.getExternalCacheDir()) + "/" + strArrSplit[1];
                }
                if ("raw".equalsIgnoreCase(str)) {
                    return "" + strArrSplit[1];
                }
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sbY = b.y("/storage/", str, "/");
                    sbY.append(strArrSplit[1]);
                    return sbY.toString();
                }
            } else {
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId.startsWith("raw:")) {
                        return "" + documentId.replaceFirst("raw:", "");
                    }
                    return "" + b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                }
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = strArrSplit2[0];
                    if ("image".equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    } else if ("raw".equalsIgnoreCase(str2)) {
                        return "" + strArrSplit2[1];
                    }
                    return "" + b(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                return "" + b(context, uri, null, null);
            }
            if (UtilsKt.SCHEME_FILE.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }
}
