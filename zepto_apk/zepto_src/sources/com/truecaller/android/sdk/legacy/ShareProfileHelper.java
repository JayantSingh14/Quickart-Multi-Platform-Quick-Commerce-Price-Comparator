package com.truecaller.android.sdk.legacy;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.HashSet;

@RestrictTo
/* loaded from: classes4.dex */
public class ShareProfileHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f47245a;

    @RestrictTo
    public static abstract class TrueAppInfo {

        /* renamed from: a, reason: collision with root package name */
        public static final HashSet f47246a;

        static {
            HashSet hashSet = new HashSet(2);
            hashSet.add("0ac1169ae6cead75264c725febd8e8d941f25e31");
            hashSet.add("8a03e08e354a73ac49509c8b708fbe15aee2fb2a");
            f47246a = hashSet;
        }

        public abstract String a();
    }

    public static class TruecallerAppInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo
        public final String a() {
            return "com.truecaller";
        }
    }

    public static class TruecallerDappInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo
        public final String a() {
            return "com.truecaller.debug";
        }
    }

    public static class TruemessengerAppInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo
        public final String a() {
            return "com.truecaller.messenger";
        }
    }

    public static class TruemessengerDappInfo extends TrueAppInfo {
        @Override // com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo
        public final String a() {
            return "com.truecaller.messenger.debug";
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f47245a = arrayList;
        arrayList.add(new TruecallerAppInfo());
        arrayList.add(new TruemessengerAppInfo());
        arrayList.add(new TruecallerDappInfo());
        arrayList.add(new TruemessengerDappInfo());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent a(android.content.Context r12, java.lang.String r13) throws android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException {
        /*
            java.util.ArrayList r0 = com.truecaller.android.sdk.legacy.ShareProfileHelper.f47245a
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto Lbc
            java.lang.Object r1 = r0.next()
            com.truecaller.android.sdk.legacy.ShareProfileHelper$TrueAppInfo r1 = (com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo) r1
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r13)
            java.lang.String r4 = r1.a()
            android.content.Intent r3 = r3.setPackage(r4)
            java.lang.String r4 = "android.intent.category.DEFAULT"
            android.content.Intent r3 = r3.addCategory(r4)
            android.content.pm.PackageManager r4 = r12.getPackageManager()
            r5 = 0
            android.content.pm.ResolveInfo r4 = r4.resolveActivity(r3, r5)
            if (r4 == 0) goto L6
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            java.lang.String r4 = r4.packageName
            android.content.pm.PackageManager r6 = r12.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
            r7 = 64
            android.content.pm.PackageInfo r2 = r6.getPackageInfo(r4, r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3f
        L3f:
            if (r2 != 0) goto L42
            goto L6
        L42:
            android.content.pm.Signature[] r2 = r2.signatures
            int r4 = r2.length
            r6 = r5
        L46:
            if (r6 >= r4) goto L6
            r7 = r2[r6]
            byte[] r7 = r7.toByteArray()
            java.lang.String r7 = com.truecaller.android.sdk.legacy.Utils.b(r7)
            if (r7 == 0) goto Lb9
            java.util.HashSet r8 = com.truecaller.android.sdk.legacy.ShareProfileHelper.TrueAppInfo.f47246a
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto Lb9
            java.lang.String r0 = "com.truecaller.android.sdk.intent.action.v3.SHARE_PROFILE"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto Lb8
            java.lang.String r13 = r1.a()
            java.lang.String r0 = "content://"
            r1 = 1
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Exception -> Lb1
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb1
            r12.<init>(r0)     // Catch: java.lang.Exception -> Lb1
            r12.append(r13)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r13 = ".TcInfoContentProvider/tcBottomSheet"
            r12.append(r13)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Exception -> Lb1
            android.net.Uri r7 = android.net.Uri.parse(r12)     // Catch: java.lang.Exception -> Lb1
            r10 = 0
            r11 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Lb1
            if (r12 == 0) goto Lac
            boolean r13 = r12.moveToFirst()     // Catch: java.lang.Throwable -> La0
            if (r13 == 0) goto Lac
            int r13 = r12.getInt(r5)     // Catch: java.lang.Throwable -> La0
            if (r13 != r1) goto L9b
            r5 = r1
        L9b:
            r12.close()     // Catch: java.lang.Exception -> Lb1
            r1 = r5
            goto Lb1
        La0:
            r0 = move-exception
            r13 = r0
            r12.close()     // Catch: java.lang.Throwable -> La6
            goto Lab
        La6:
            r0 = move-exception
            r12 = r0
            r13.addSuppressed(r12)     // Catch: java.lang.Exception -> Lb1
        Lab:
            throw r13     // Catch: java.lang.Exception -> Lb1
        Lac:
            if (r12 == 0) goto Lb1
            r12.close()     // Catch: java.lang.Exception -> Lb1
        Lb1:
            if (r1 != 0) goto Lb8
            java.lang.String r12 = "com.truecaller.android.sdk.intent.action.v1.SHARE_PROFILE"
            r3.setAction(r12)
        Lb8:
            return r3
        Lb9:
            int r6 = r6 + 1
            goto L46
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.legacy.ShareProfileHelper.a(android.content.Context, java.lang.String):android.content.Intent");
    }
}
