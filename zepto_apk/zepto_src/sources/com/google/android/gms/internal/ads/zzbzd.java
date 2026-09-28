package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbzd {

    /* renamed from: a, reason: collision with root package name */
    public int f25746a;

    /* renamed from: b, reason: collision with root package name */
    public int f25747b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25748c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25749d;

    /* renamed from: e, reason: collision with root package name */
    public final String f25750e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25751f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25752g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f25753h;

    /* renamed from: i, reason: collision with root package name */
    public final String f25754i;

    /* renamed from: j, reason: collision with root package name */
    public final String f25755j;

    /* renamed from: k, reason: collision with root package name */
    public final float f25756k;

    /* renamed from: l, reason: collision with root package name */
    public final int f25757l;

    /* renamed from: m, reason: collision with root package name */
    public final int f25758m;
    public final String n;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbzd(android.content.Context r8) {
        /*
            r7 = this;
            r7.<init>()
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            com.google.android.gms.internal.ads.zzbgk.a(r8)
            r7.b(r8)
            r7.c(r8)
            r7.d(r8)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r2 = e(r0, r2)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L23
            r2 = r4
            goto L24
        L23:
            r2 = r3
        L24:
            r7.f25748c = r2
            java.lang.String r2 = "http://www.google.com"
            android.content.pm.ResolveInfo r2 = e(r0, r2)
            if (r2 == 0) goto L30
            r2 = r4
            goto L31
        L30:
            r2 = r3
        L31:
            r7.f25749d = r2
            java.lang.String r2 = r1.getCountry()
            r7.f25750e = r2
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r2 = r2.f21679c
            com.google.android.gms.ads.internal.client.zzbb r2 = com.google.android.gms.ads.internal.client.zzbb.f21141g
            com.google.android.gms.ads.internal.util.client.zzf r2 = r2.f21142a
            boolean r2 = com.google.android.gms.ads.internal.util.client.zzf.r()
            r7.f25751f = r2
            boolean r2 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r8)
            r7.f25752g = r2
            boolean r2 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r8)
            r7.f25753h = r2
            java.lang.String r1 = r1.getLanguage()
            r7.f25754i = r1
            java.lang.String r1 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r0 = e(r0, r1)
            java.lang.String r1 = "."
            r2 = 0
            if (r0 != 0) goto L66
        L64:
            r0 = r2
            goto L9f
        L66:
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            if (r0 != 0) goto L6b
            goto L64
        L6b:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r6 = r0.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.PackageInfo r3 = r5.getPackageInfo(r6, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            if (r3 == 0) goto L64
            int r3 = r3.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r0 = r0.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            int r5 = r5.length()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            int r5 = r5 + r4
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            int r6 = r6.length()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            int r5 = r5 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            r6.<init>(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            r6.append(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            r6.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            r6.append(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r0 = r6.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
        L9f:
            r7.f25755j = r0
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)     // Catch: java.lang.Exception -> Ld7
            java.lang.String r3 = "com.android.vending"
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r5)     // Catch: java.lang.Exception -> Ld7
            if (r0 == 0) goto Ld7
            int r3 = r0.versionCode     // Catch: java.lang.Exception -> Ld7
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Exception -> Ld7
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> Ld7
            int r5 = r5.length()     // Catch: java.lang.Exception -> Ld7
            int r5 = r5 + r4
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> Ld7
            int r4 = r4.length()     // Catch: java.lang.Exception -> Ld7
            int r5 = r5 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld7
            r4.<init>(r5)     // Catch: java.lang.Exception -> Ld7
            r4.append(r3)     // Catch: java.lang.Exception -> Ld7
            r4.append(r1)     // Catch: java.lang.Exception -> Ld7
            r4.append(r0)     // Catch: java.lang.Exception -> Ld7
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> Ld7
        Ld7:
            r7.n = r2
            android.content.res.Resources r8 = r8.getResources()
            if (r8 != 0) goto Le0
            goto Lf2
        Le0:
            android.util.DisplayMetrics r8 = r8.getDisplayMetrics()
            if (r8 == 0) goto Lf2
            float r0 = r8.density
            r7.f25756k = r0
            int r0 = r8.widthPixels
            r7.f25757l = r0
            int r8 = r8.heightPixels
            r7.f25758m = r8
        Lf2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzd.<init>(android.content.Context):void");
    }

    public static ResolveInfo e(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("DeviceInfo.getResolveInfo", th);
            return null;
        }
    }

    public final zzbze a() {
        return new zzbze(this.f25748c, this.f25749d, this.f25750e, this.f25751f, this.f25752g, this.f25753h, this.f25754i, this.f25755j, this.n, this.f25746a, this.f25747b, this.f25756k, this.f25757l, this.f25758m);
    }

    public final void b(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                audioManager.getMode();
                audioManager.isMusicActive();
                audioManager.isSpeakerphoneOn();
                audioManager.getStreamVolume(3);
                audioManager.getRingerMode();
                audioManager.getStreamVolume(2);
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("DeviceInfo.gatherAudioInfo", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            r0.getNetworkOperator()
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r2 == 0) goto L2d
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.F9
            com.google.android.gms.ads.internal.client.zzbd r4 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r4 = r4.f21153c
            java.lang.Object r2 = r4.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L2d
            goto L31
        L2d:
            int r3 = r0.getNetworkType()
        L31:
            r5.f25747b = r3
            r0.getPhoneType()
            r0 = -2
            r5.f25746a = r0
            r0 = -1
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r2 = r2.f21679c
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzs.d(r6, r2)
            if (r6 == 0) goto L5f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L5a
            int r0 = r6.getType()
            r5.f25746a = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            r6.ordinal()
            goto L5c
        L5a:
            r5.f25746a = r0
        L5c:
            r1.isActiveNetworkMetered()
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzd.c(android.content.Context):void");
    }

    public final void d(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent intentRegisterReceiver = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fc)).booleanValue() || Build.VERSION.SDK_INT < 33) ? context.registerReceiver(null, intentFilter) : context.registerReceiver(null, intentFilter, 4);
        if (intentRegisterReceiver != null) {
            intentRegisterReceiver.getIntExtra(CLConstants.OTP_STATUS, -1);
            intentRegisterReceiver.getIntExtra("level", -1);
            intentRegisterReceiver.getIntExtra("scale", -1);
        }
    }

    public zzbzd(Context context, zzbze zzbzeVar) {
        zzbgk.a(context);
        b(context);
        c(context);
        d(context);
        String str = Build.FINGERPRINT;
        String str2 = Build.DEVICE;
        zzbhl.a(context);
        this.f25748c = zzbzeVar.f25759a;
        this.f25749d = zzbzeVar.f25760b;
        this.f25750e = zzbzeVar.f25761c;
        this.f25751f = zzbzeVar.f25762d;
        this.f25752g = zzbzeVar.f25763e;
        this.f25753h = zzbzeVar.f25764f;
        this.f25754i = zzbzeVar.f25765g;
        this.f25755j = zzbzeVar.f25766h;
        this.n = zzbzeVar.f25767i;
        this.f25756k = zzbzeVar.f25770l;
        this.f25757l = zzbzeVar.f25771m;
        this.f25758m = zzbzeVar.n;
    }
}
