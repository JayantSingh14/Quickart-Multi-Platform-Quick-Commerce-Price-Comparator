package com.truecaller.android.sdk.oAuth;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.HashSet;

@RestrictTo
/* loaded from: classes4.dex */
public class ShareProfileHelperV2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f47274a;

    @RestrictTo
    public static abstract class TrueAppInfo {

        /* renamed from: a, reason: collision with root package name */
        public static final HashSet f47275a;

        static {
            HashSet hashSet = new HashSet(2);
            hashSet.add("0ac1169ae6cead75264c725febd8e8d941f25e31");
            hashSet.add("8a03e08e354a73ac49509c8b708fbe15aee2fb2a");
            f47275a = hashSet;
        }

        public abstract String a();
    }

    public static class TruecallerAppInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.TrueAppInfo
        public final String a() {
            return "com.truecaller";
        }
    }

    public static class TruecallerDappInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.TrueAppInfo
        public final String a() {
            return "com.truecaller.debug";
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f47274a = arrayList;
        arrayList.add(new TruecallerAppInfo());
        arrayList.add(new TruecallerDappInfo());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent a(android.content.Context r11, java.lang.String r12) throws java.security.NoSuchAlgorithmException {
        /*
            java.util.ArrayList r0 = com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.f47274a
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb3
            java.lang.Object r1 = r0.next()
            com.truecaller.android.sdk.oAuth.ShareProfileHelperV2$TrueAppInfo r1 = (com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.TrueAppInfo) r1
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r12)
            java.lang.String r3 = r1.a()
            android.content.Intent r2 = r2.setPackage(r3)
            java.lang.String r3 = "android.intent.category.DEFAULT"
            android.content.Intent r2 = r2.addCategory(r3)
            android.content.pm.PackageManager r3 = r11.getPackageManager()
            r4 = 0
            android.content.pm.ResolveInfo r3 = r3.resolveActivity(r2, r4)
            if (r3 == 0) goto L6
            android.content.pm.ActivityInfo r3 = r3.activityInfo
            java.lang.String r3 = r3.packageName
            android.content.pm.Signature[] r3 = com.truecaller.android.sdk.oAuth.UtilsV2.b(r11, r3)
            if (r3 != 0) goto L3b
            goto L6
        L3b:
            int r5 = r3.length
            r6 = r4
        L3d:
            if (r6 >= r5) goto L6
            r7 = r3[r6]
            byte[] r7 = r7.toByteArray()
            java.lang.String r7 = com.truecaller.android.sdk.oAuth.UtilsV2.c(r7)
            if (r7 == 0) goto Lb0
            java.util.HashSet r8 = com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.TrueAppInfo.f47275a
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto Lb0
            java.lang.String r0 = "com.truecaller.android.sdk.intent.action.v2.oAuth"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto Laf
            java.lang.String r12 = r1.a()
            java.lang.String r0 = "content://"
            r1 = 1
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch: java.lang.Exception -> La8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La8
            r11.<init>(r0)     // Catch: java.lang.Exception -> La8
            r11.append(r12)     // Catch: java.lang.Exception -> La8
            java.lang.String r12 = ".TcInfoContentProvider/tcOAuthPopup"
            r11.append(r12)     // Catch: java.lang.Exception -> La8
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> La8
            android.net.Uri r6 = android.net.Uri.parse(r11)     // Catch: java.lang.Exception -> La8
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> La8
            if (r11 == 0) goto La3
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L97
            if (r12 == 0) goto La3
            int r12 = r11.getInt(r4)     // Catch: java.lang.Throwable -> L97
            if (r12 != r1) goto L92
            r4 = r1
        L92:
            r11.close()     // Catch: java.lang.Exception -> La8
            r1 = r4
            goto La8
        L97:
            r0 = move-exception
            r12 = r0
            r11.close()     // Catch: java.lang.Throwable -> L9d
            goto La2
        L9d:
            r0 = move-exception
            r11 = r0
            r12.addSuppressed(r11)     // Catch: java.lang.Exception -> La8
        La2:
            throw r12     // Catch: java.lang.Exception -> La8
        La3:
            if (r11 == 0) goto La8
            r11.close()     // Catch: java.lang.Exception -> La8
        La8:
            if (r1 != 0) goto Laf
            java.lang.String r11 = "com.truecaller.android.sdk.intent.action.v1.oAuth"
            r2.setAction(r11)
        Laf:
            return r2
        Lb0:
            int r6 = r6 + 1
            goto L3d
        Lb3:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.oAuth.ShareProfileHelperV2.a(android.content.Context, java.lang.String):android.content.Intent");
    }
}
