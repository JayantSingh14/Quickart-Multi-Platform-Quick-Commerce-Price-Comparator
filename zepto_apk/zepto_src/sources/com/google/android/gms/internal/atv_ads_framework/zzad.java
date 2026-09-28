package com.google.android.gms.internal.atv_ads_framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.pm.PackageInfoCompat;

/* loaded from: classes4.dex */
public final class zzad {
    public static zza a(Context context) {
        return context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE") ? zza.LAUNCHER_X : context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv") ? zza.FIRE_TV : (context.getPackageManager().hasSystemFeature("com.google.android.tv.custom_launcher") && f(context, "com.google.android.tvrecommendations")) ? zza.CUSTOM : (context.getPackageManager().hasSystemFeature("android.software.leanback") && f(context, "com.google.android.tvlauncher")) ? zza.TV_LAUNCHER : (context.getPackageManager().hasSystemFeature("android.software.leanback") && f(context, "com.google.android.leanbacklauncher")) ? zza.LEANBACK : zza.UNKNOWN;
    }

    public static zzab b(Context context) {
        String strE;
        String strE2;
        zzt zztVarK = zzu.k();
        String packageName = context.getApplicationContext().getPackageName();
        zztVarK.d();
        zzu.l((zzu) zztVarK.f36121b, packageName);
        String strE3 = e(context, context.getApplicationContext().getPackageName());
        if (!strE3.isEmpty()) {
            zztVarK.d();
            zzu.m((zzu) zztVarK.f36121b, strE3);
        }
        zzj zzjVarK = zzk.k();
        String strD = d();
        zzjVarK.d();
        zzk.l((zzk) zzjVarK.f36121b, strD);
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("com.google.android.tv.operator_tier");
        zzjVarK.d();
        zzk.m((zzk) zzjVarK.f36121b, zHasSystemFeature);
        zzk zzkVar = (zzk) zzjVarK.b();
        zzr zzrVarK = zzs.k();
        zzrVarK.d();
        zzs.l((zzs) zzrVarK.f36121b);
        zzs zzsVar = (zzs) zzrVarK.b();
        zza zzaVarA = a(context);
        zzo zzoVarK = zzp.k();
        int iOrdinal = zzaVarA.ordinal();
        if (iOrdinal != 0) {
            strE = "";
            if (iOrdinal == 1) {
                zzoVarK.e(3);
                strE = e(context, "com.google.android.apps.tv.launcherx");
                strE2 = "";
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    zzoVarK.e(5);
                } else if (iOrdinal == 4) {
                    zzoVarK.e(6);
                } else if (iOrdinal == 5) {
                    zzoVarK.e(1);
                }
                strE2 = "";
            } else {
                zzoVarK.e(4);
                strE2 = e(context, "com.google.android.tvrecommendations");
            }
        } else {
            zzoVarK.e(2);
            strE = e(context, "com.google.android.tvlauncher");
            strE2 = e(context, "com.google.android.tvrecommendations");
        }
        if (!strE.isEmpty()) {
            zzoVarK.d();
            zzp.l((zzp) zzoVarK.f36121b, strE);
        }
        if (!strE2.isEmpty()) {
            zzoVarK.d();
            zzp.m((zzp) zzoVarK.f36121b, strE2);
        }
        zzab zzabVarK = zzac.k();
        zzabVarK.d();
        zzac.o((zzac) zzabVarK.f36121b, (zzu) zztVarK.b());
        zzabVarK.d();
        zzac.p((zzac) zzabVarK.f36121b, zzkVar);
        zzabVarK.d();
        zzac.q((zzac) zzabVarK.f36121b, zzsVar);
        zzabVarK.d();
        zzac.l((zzac) zzabVarK.f36121b, (zzp) zzoVarK.b());
        return zzabVarK;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)(1:5)|6|(1:8)|9|(6:(1:(0))(2:14|(1:16)(1:17))|70|26|(9:39|36|40|(1:42)(4:43|(3:46|73|44)|76|50)|51|(1:53)|54|(2:57|55)|75)(9:(1:(7:30|(1:37)|51|(0)|54|(1:55)|75)(0))(1:38)|36|40|(0)(0)|51|(0)|54|(1:55)|75)|65|66)(2:18|(1:20)(1:21))|22|(1:24)(1:25)|70|26|(0)(0)|65|66|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014f, code lost:
    
        r2.add(com.google.android.gms.internal.atv_ads_framework.zzx.SIGNAL_COLLECTION_ERROR_NULL_CONTENT_PROVIDER_DATA);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[Catch: zzax -> 0x014f, TryCatch #1 {zzax -> 0x014f, blocks: (B:26:0x0095, B:40:0x00c0, B:42:0x00d2, B:51:0x0108, B:53:0x010c, B:54:0x0112, B:55:0x0120, B:57:0x0126, B:43:0x00d7, B:50:0x0101, B:63:0x014e, B:37:0x00b5, B:38:0x00ba, B:39:0x00bd, B:44:0x00e6, B:46:0x00ec), top: B:70:0x0095, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2 A[Catch: zzax -> 0x014f, TryCatch #1 {zzax -> 0x014f, blocks: (B:26:0x0095, B:40:0x00c0, B:42:0x00d2, B:51:0x0108, B:53:0x010c, B:54:0x0112, B:55:0x0120, B:57:0x0126, B:43:0x00d7, B:50:0x0101, B:63:0x014e, B:37:0x00b5, B:38:0x00ba, B:39:0x00bd, B:44:0x00e6, B:46:0x00ec), top: B:70:0x0095, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[Catch: zzax -> 0x014f, TRY_LEAVE, TryCatch #1 {zzax -> 0x014f, blocks: (B:26:0x0095, B:40:0x00c0, B:42:0x00d2, B:51:0x0108, B:53:0x010c, B:54:0x0112, B:55:0x0120, B:57:0x0126, B:43:0x00d7, B:50:0x0101, B:63:0x014e, B:37:0x00b5, B:38:0x00ba, B:39:0x00bd, B:44:0x00e6, B:46:0x00ec), top: B:70:0x0095, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c A[Catch: zzax -> 0x014f, TryCatch #1 {zzax -> 0x014f, blocks: (B:26:0x0095, B:40:0x00c0, B:42:0x00d2, B:51:0x0108, B:53:0x010c, B:54:0x0112, B:55:0x0120, B:57:0x0126, B:43:0x00d7, B:50:0x0101, B:63:0x014e, B:37:0x00b5, B:38:0x00ba, B:39:0x00bd, B:44:0x00e6, B:46:0x00ec), top: B:70:0x0095, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0126 A[Catch: zzax -> 0x014f, LOOP:0: B:55:0x0120->B:57:0x0126, LOOP_END, TRY_LEAVE, TryCatch #1 {zzax -> 0x014f, blocks: (B:26:0x0095, B:40:0x00c0, B:42:0x00d2, B:51:0x0108, B:53:0x010c, B:54:0x0112, B:55:0x0120, B:57:0x0126, B:43:0x00d7, B:50:0x0101, B:63:0x014e, B:37:0x00b5, B:38:0x00ba, B:39:0x00bd, B:44:0x00e6, B:46:0x00ec), top: B:70:0x0095, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.atv_ads_framework.zzbh c(android.content.Context r14) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzad.c(android.content.Context):com.google.android.gms.internal.atv_ads_framework.zzbh");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = android.os.Build.FINGERPRINT
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L42
            r0.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzar r0 = new com.google.android.gms.internal.atv_ads_framework.zzar
            r0.<init>()
            r1 = 2
            r0.f36033b = r1
            r1 = 0
            r0.f36035c = r1
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.f36036d = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L20:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L30
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            r2.add(r3)
            goto L20
        L30:
            java.util.List r0 = java.util.Collections.unmodifiableList(r2)
            int r2 = r0.size()
            r3 = 3
            if (r2 != r3) goto L42
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L44
        L42:
            java.lang.String r0 = ""
        L44:
            java.lang.String r0 = com.google.android.gms.internal.atv_ads_framework.zzaf.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzad.d():java.lang.String");
    }

    public static String e(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? Long.toString(PackageInfoCompat.a(packageInfo)) : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static boolean f(Context context, String str) {
        return (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
    }
}
