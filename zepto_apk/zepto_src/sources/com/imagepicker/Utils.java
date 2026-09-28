package com.imagepicker;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import coil3.util.UtilsKt;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public class Utils {
    public static void a(Uri uri, Uri uri2, ContentResolver contentResolver) throws IOException {
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri2);
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            outputStreamOpenOutputStream.write(bArr, 0, i2);
                        }
                    }
                    inputStreamOpenInputStream.close();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static File b(Context context, String str) throws IOException {
        try {
            File file = new File(context.getCacheDir(), "rn_image_picker_lib_temp_" + UUID.randomUUID() + CLConstants.DOT_SALT_DELIMETER + str);
            file.createNewFile();
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri c(android.content.Context r9, android.net.Uri r10) throws java.io.IOException {
        /*
            r0 = 1
            r1 = -1
            android.content.ContentResolver r2 = r9.getContentResolver()
            java.lang.String r3 = r2.getType(r10)
            java.lang.String r4 = "jpg"
            if (r3 != 0) goto L10
        Le:
            r8 = r4
            goto L4b
        L10:
            int r5 = r3.hashCode()
            switch(r5) {
                case -1487394660: goto L2f;
                case -879267568: goto L24;
                case -879258763: goto L19;
                default: goto L17;
            }
        L17:
            r5 = r1
            goto L39
        L19:
            java.lang.String r5 = "image/png"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L22
            goto L17
        L22:
            r5 = 2
            goto L39
        L24:
            java.lang.String r5 = "image/gif"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L2d
            goto L17
        L2d:
            r5 = r0
            goto L39
        L2f:
            java.lang.String r5 = "image/jpeg"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L38
            goto L17
        L38:
            r5 = 0
        L39:
            switch(r5) {
                case 0: goto Le;
                case 1: goto L48;
                case 2: goto L45;
                default: goto L3c;
            }
        L3c:
            android.webkit.MimeTypeMap r4 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r4 = r4.getExtensionFromMimeType(r3)
            goto Le
        L45:
            java.lang.String r4 = "png"
            goto Le
        L48:
            java.lang.String r4 = "gif"
            goto Le
        L4b:
            if (r8 != 0) goto L74
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r10
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)
            boolean r4 = r10.moveToFirst()
            if (r4 == 0) goto L75
            java.lang.String r4 = "_display_name"
            int r4 = r10.getColumnIndex(r4)
            java.lang.String r10 = r10.getString(r4)
            r4 = 46
            int r4 = r10.lastIndexOf(r4)
            if (r4 == r1) goto L75
            int r4 = r4 + r0
            java.lang.String r8 = r10.substring(r4)
            goto L75
        L74:
            r3 = r10
        L75:
            java.io.File r9 = b(r9, r8)
            android.net.Uri r9 = android.net.Uri.fromFile(r9)
            a(r3, r9, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.Utils.c(android.content.Context, android.net.Uri):android.net.Uri");
    }

    public static WritableMap d(String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(CLConstants.FIELD_ERROR_CODE, str);
        if (str2 != null) {
            writableMapCreateMap.putString("errorMessage", str2);
        }
        return writableMapCreateMap;
    }

    public static String e(Context context, Uri uri) {
        return uri.getScheme().equals(UtilsKt.SCHEME_FILE) ? uri.getLastPathSegment() : uri.getScheme().equals("content") ? f(context, uri) : "Unknown";
    }

    public static String f(Context context, Uri uri) {
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        String lastPathSegment = uri.getLastPathSegment();
        try {
            if (cursorQuery.moveToFirst()) {
                lastPathSegment = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            }
            cursorQuery.close();
            return lastPathSegment;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public static double g(Context context, Uri uri) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                double statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                parcelFileDescriptorOpenFileDescriptor.close();
                return statSize;
            } finally {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int[] h(Context context, Uri uri) throws IOException {
        int[] iArr;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String strB = new ExifInterface(context.getContentResolver().openInputStream(uri)).b("Orientation");
                BitmapFactory.Options options = new BitmapFactory.Options();
                boolean z = true;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (!strB.equals(String.valueOf(6)) && !strB.equals(String.valueOf(8))) {
                    z = false;
                }
                if (z) {
                    iArr = new int[]{options.outHeight, options.outWidth};
                    if (inputStreamOpenInputStream == null) {
                        return iArr;
                    }
                } else {
                    iArr = new int[]{options.outWidth, options.outHeight};
                    if (inputStreamOpenInputStream == null) {
                        return iArr;
                    }
                }
                inputStreamOpenInputStream.close();
                return iArr;
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new int[]{0, 0};
        }
    }

    public static String i(Context context, Uri uri) {
        if (uri.getScheme().equals(UtilsKt.SCHEME_FILE)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
        }
        if (uri.getScheme().equals("content")) {
            String type = context.getContentResolver().getType(uri);
            int length = type.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = type.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    return type;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strF = f(context, uri);
            int iLastIndexOf = strF.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                return strF.substring(iLastIndexOf + 1);
            }
        }
        return "Unknown";
    }

    public static String j(Context context, Uri uri) throws IOException {
        String str;
        if (!uri.getScheme().contains("content")) {
            return uri.toString();
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        try {
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex == -1) {
                cursorQuery.close();
                str = null;
            } else {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(columnIndex);
                cursorQuery.close();
                str = string;
            }
            c(context, uri);
            return str;
        } finally {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(17:278|15|16|(3:298|17|18)|(7:302|19|20|286|21|22|(23:(1:40)(4:(1:35)|(1:37)(1:38)|290|39)|41|318|42|43|312|44|(1:50)(1:49)|(8:308|52|53|304|54|55|296|56)(1:63)|64|(3:67|68|82)|86|300|87|88|(1:92)(1:93)|95|(1:97)|98|(1:103)|104|(2:334|106)|107))|140|294|141|276|142|(1:144)|148|159|(8:282|161|274|162|163|328|164|(3:165|166|(4:168|292|169|170)(10:326|173|174|322|175|320|176|288|177|205)))(1:206)|207|(1:209)|210) */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0228, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0235, code lost:
    
        android.util.Log.e("RNIP", "Could not load image metadata: " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0218 A[Catch: all -> 0x0221, TRY_LEAVE, TryCatch #1 {all -> 0x0221, blocks: (B:142:0x020b, B:144:0x0218), top: B:276:0x020b, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0294 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.react.bridge.WritableMap k(java.util.List r28, com.imagepicker.Options r29, android.content.Context r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.Utils.k(java.util.List, com.imagepicker.Options, android.content.Context):com.facebook.react.bridge.WritableMap");
    }

    public static void l(Uri uri, Context context, String str) {
        Uri uriInsert;
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (str.equals("video")) {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        a(uri, uriInsert, contentResolver);
    }
}
