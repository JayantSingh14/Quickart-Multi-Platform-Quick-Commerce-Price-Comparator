package com.ReactNativeBlobUtil.Utils;

/* loaded from: classes3.dex */
public class PathResolver {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(com.facebook.react.bridge.ReactApplicationContext r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            java.lang.String r7 = r8.getString(r9)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L28
            goto L2b
        L24:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L40
        L28:
            r0 = move-exception
            r9 = r0
            goto L37
        L2b:
            if (r8 == 0) goto L30
            r8.close()
        L30:
            return r7
        L31:
            r0 = move-exception
            r9 = r0
            goto L40
        L34:
            r0 = move-exception
            r9 = r0
            r8 = r7
        L37:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r8 == 0) goto L3f
            r8.close()
        L3f:
            return r7
        L40:
            if (r7 == 0) goto L45
            r7.close()
        L45:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.Utils.PathResolver.a(com.facebook.react.bridge.ReactApplicationContext, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }
}
