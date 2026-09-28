package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzs {

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.android.play.core.splitinstall.internal.zzu f42131c = new com.google.android.play.core.splitinstall.internal.zzu("SplitInstallInfoProvider");

    /* renamed from: a, reason: collision with root package name */
    public final Context f42132a;

    /* renamed from: b, reason: collision with root package name */
    public final String f42133b;

    public zzs(Context context) {
        this.f42132a = context;
        this.f42133b = context.getPackageName();
    }

    public static String b(String str) {
        return str.startsWith("config.") ? "" : str.split("\\.config\\.", 2)[0];
    }

    public static boolean d(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }

    public static final HashSet e(PackageInfo packageInfo) {
        HashSet hashSet = new HashSet();
        Iterator it = g(packageInfo).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!d(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static final HashSet g(PackageInfo packageInfo) {
        Bundle bundle = packageInfo.applicationInfo.metaData;
        HashSet hashSet = new HashSet();
        com.google.android.play.core.splitinstall.internal.zzu zzuVar = f42131c;
        if (bundle != null) {
            String string = bundle.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                zzuVar.a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        String[] strArr = packageInfo.splitNames;
        if (strArr != null) {
            zzuVar.a("Adding splits from package manager: %s", Arrays.toString(strArr));
            Collections.addAll(hashSet, strArr);
        } else {
            zzuVar.a("No splits are found or app cannot be found in package manager.", new Object[0]);
        }
        zzq zzqVar = (zzq) zzr.f42130a.get();
        if (zzqVar != null) {
            hashSet.addAll(zzqVar.zza());
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.play.core.splitinstall.zzk a(android.os.Bundle r10) throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            com.google.android.play.core.splitinstall.internal.zzu r2 = com.google.android.play.core.splitinstall.zzs.f42131c
            if (r10 != 0) goto Le
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r1 = "No metadata found in Context."
            r2.e(r1, r10)
            return r0
        Le:
            java.lang.String r3 = "com.android.vending.splits"
            int r10 = r10.getInt(r3)
            if (r10 != 0) goto L1e
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r1 = "No metadata found in AndroidManifest."
            r2.e(r1, r10)
            return r0
        L1e:
            android.content.Context r3 = r9.f42132a     // Catch: android.content.res.Resources.NotFoundException -> Ldf
            android.content.res.Resources r3 = r3.getResources()     // Catch: android.content.res.Resources.NotFoundException -> Ldf
            android.content.res.XmlResourceParser r10 = r3.getXml(r10)     // Catch: android.content.res.Resources.NotFoundException -> Ldf
            com.google.android.play.core.splitinstall.zzi r3 = new com.google.android.play.core.splitinstall.zzi
            r3.<init>()
        L2d:
            int r4 = r10.next()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            r5 = 1
            if (r4 == r5) goto Lc9
            int r4 = r10.getEventType()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            r5 = 2
            if (r4 != r5) goto L2d
            java.lang.String r4 = r10.getName()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            java.lang.String r6 = "splits"
            boolean r4 = r4.equals(r6)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r4 != 0) goto L4b
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L2d
        L4b:
            int r4 = r10.next()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            r6 = 3
            if (r4 == r6) goto L2d
            int r4 = r10.getEventType()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r4 != r5) goto L4b
            java.lang.String r4 = r10.getName()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            java.lang.String r7 = "module"
            boolean r4 = r4.equals(r7)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r4 == 0) goto Lc5
            java.lang.String r4 = "name"
            java.lang.String r4 = com.google.android.play.core.splitinstall.zzbg.a(r4, r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r4 == 0) goto Lc1
        L6c:
            int r7 = r10.next()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 == r6) goto L4b
            int r7 = r10.getEventType()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 != r5) goto L6c
            java.lang.String r7 = r10.getName()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            java.lang.String r8 = "language"
            boolean r7 = r7.equals(r8)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 != 0) goto L88
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L6c
        L88:
            int r7 = r10.next()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 == r6) goto L6c
            int r7 = r10.getEventType()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 != r5) goto L88
            java.lang.String r7 = r10.getName()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            java.lang.String r8 = "entry"
            boolean r7 = r7.equals(r8)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 == 0) goto Lbd
            java.lang.String r7 = "key"
            java.lang.String r7 = com.google.android.play.core.splitinstall.zzbg.a(r7, r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            java.lang.String r8 = "split"
            java.lang.String r8 = com.google.android.play.core.splitinstall.zzbg.a(r8, r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            if (r7 == 0) goto L88
            if (r8 == 0) goto L88
            r3.a(r4, r7, r8)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L88
        Lb7:
            r10 = move-exception
            goto Lce
        Lb9:
            r10 = move-exception
            goto Lce
        Lbb:
            r10 = move-exception
            goto Lce
        Lbd:
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L88
        Lc1:
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L4b
        Lc5:
            com.google.android.play.core.splitinstall.zzbg.b(r10)     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto L4b
        Lc9:
            com.google.android.play.core.splitinstall.zzk r0 = r3.b()     // Catch: java.lang.IllegalStateException -> Lb7 java.io.IOException -> Lb9 org.xmlpull.v1.XmlPullParserException -> Lbb
            goto Ld5
        Lce:
            java.lang.String r3 = "SplitInstall"
            java.lang.String r4 = "Error while parsing splits.xml"
            android.util.Log.e(r3, r4, r10)
        Ld5:
            if (r0 != 0) goto Lde
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r1 = "Can't parse languages metadata."
            r2.e(r1, r10)
        Lde:
            return r0
        Ldf:
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r1 = "Resource with languages metadata doesn't exist."
            r2.e(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.zzs.a(android.os.Bundle):com.google.android.play.core.splitinstall.zzk");
    }

    public final HashSet c() {
        PackageInfo packageInfoF = f();
        return (packageInfoF == null || packageInfoF.applicationInfo == null) ? new HashSet() : e(packageInfoF);
    }

    public final PackageInfo f() {
        try {
            return this.f42132a.getPackageManager().getPackageInfo(this.f42133b, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            f42131c.b("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }
}
