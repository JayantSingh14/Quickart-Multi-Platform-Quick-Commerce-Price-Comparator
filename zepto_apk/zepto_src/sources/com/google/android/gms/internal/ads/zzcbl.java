package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes4.dex */
public final class zzcbl implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25833a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f25834b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzg f25835c;

    /* renamed from: d, reason: collision with root package name */
    public String f25836d = "-1";

    /* renamed from: e, reason: collision with root package name */
    public int f25837e = -1;

    public zzcbl(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.f25834b = PreferenceManager.getDefaultSharedPreferences(context);
        this.f25835c = zzgVar;
        this.f25833a = context;
    }

    public final void a(int i2, String str) {
        Context context;
        zzbgb zzbgbVar = zzbgk.U0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean z = true;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? !(str.isEmpty() || str.charAt(0) != '1') : !(i2 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1")))) {
            z = false;
        }
        this.f25835c.P(z);
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.R6)).booleanValue() && z && (context = this.f25833a) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "IABTCF_PurposeConsents"
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.W0     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.internal.ads.zzbgi r3 = r2.f21153c     // Catch: java.lang.Throwable -> L38
            java.lang.Object r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L38
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L38
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L38
            r3 = 1
            java.lang.String r4 = "-1"
            r5 = -1
            java.lang.String r6 = "gad_has_consent_for_cookies"
            if (r1 == 0) goto L5b
            boolean r0 = java.util.Objects.equals(r11, r6)     // Catch: java.lang.Throwable -> L38
            android.content.Context r1 = r9.f25833a
            com.google.android.gms.ads.internal.util.zzg r2 = r9.f25835c
            if (r0 == 0) goto L3b
            int r10 = r10.getInt(r6, r5)     // Catch: java.lang.Throwable -> L38
            int r11 = r2.k()     // Catch: java.lang.Throwable -> L38
            if (r10 == r11) goto L34
            r2.P(r3)     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.ads.internal.util.zzac.a(r1)     // Catch: java.lang.Throwable -> L38
        L34:
            r2.Q0(r10)     // Catch: java.lang.Throwable -> L38
            return
        L38:
            r10 = move-exception
            goto Lbc
        L3b:
            java.lang.String r0 = "IABTCF_TCString"
            boolean r0 = java.util.Objects.equals(r11, r0)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto Lbb
            java.lang.String r10 = r10.getString(r11, r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r11 = r2.t()     // Catch: java.lang.Throwable -> L38
            boolean r11 = java.util.Objects.equals(r10, r11)     // Catch: java.lang.Throwable -> L38
            if (r11 != 0) goto L57
            r2.P(r3)     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.ads.internal.util.zzac.a(r1)     // Catch: java.lang.Throwable -> L38
        L57:
            r2.P0(r10)     // Catch: java.lang.Throwable -> L38
            return
        L5b:
            java.lang.String r1 = r10.getString(r0, r4)     // Catch: java.lang.Throwable -> L38
            int r10 = r10.getInt(r6, r5)     // Catch: java.lang.Throwable -> L38
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L38
            int r7 = r11.hashCode()     // Catch: java.lang.Throwable -> L38
            r8 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            if (r7 == r8) goto L7e
            r0 = -527267622(0xffffffffe09288da, float:-8.447143E19)
            if (r7 == r0) goto L76
            goto L86
        L76:
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L86
            r11 = r3
            goto L87
        L7e:
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L86
            r11 = 0
            goto L87
        L86:
            r11 = r5
        L87:
            if (r11 == 0) goto La8
            if (r11 == r3) goto L8c
            goto Lbb
        L8c:
            com.google.android.gms.internal.ads.zzbgb r11 = com.google.android.gms.internal.ads.zzbgk.U0     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.internal.ads.zzbgi r0 = r2.f21153c     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = r0.a(r11)     // Catch: java.lang.Throwable -> L38
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L38
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L38
            if (r11 == 0) goto Lbb
            if (r10 == r5) goto Lbb
            int r11 = r9.f25837e     // Catch: java.lang.Throwable -> L38
            if (r11 == r10) goto Lbb
            r9.f25837e = r10     // Catch: java.lang.Throwable -> L38
            r9.a(r10, r1)     // Catch: java.lang.Throwable -> L38
            return
        La8:
            boolean r11 = r1.equals(r4)     // Catch: java.lang.Throwable -> L38
            if (r11 != 0) goto Lbb
            java.lang.String r11 = r9.f25836d     // Catch: java.lang.Throwable -> L38
            boolean r11 = r11.equals(r1)     // Catch: java.lang.Throwable -> L38
            if (r11 != 0) goto Lbb
            r9.f25836d = r1     // Catch: java.lang.Throwable -> L38
            r9.a(r10, r1)     // Catch: java.lang.Throwable -> L38
        Lbb:
            return
        Lbc:
            com.google.android.gms.ads.internal.zzt r11 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.internal.ads.zzcda r11 = r11.f21684h
            java.lang.String r0 = "AdMobPlusIdlessListener.onSharedPreferenceChanged"
            r11.d(r0, r10)
            java.lang.String r11 = "onSharedPreferenceChanged, errorMessage = "
            com.google.android.gms.ads.internal.util.zze.l(r11, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbl.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }
}
