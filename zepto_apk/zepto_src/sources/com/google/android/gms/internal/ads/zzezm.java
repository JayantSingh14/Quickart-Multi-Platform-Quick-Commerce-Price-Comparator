package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import in.juspay.hypersdk.core.PaymentConstants;

/* loaded from: classes4.dex */
public final class zzezm implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f30676a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30677b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30678c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30679d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30680e;

    /* renamed from: f, reason: collision with root package name */
    public final int f30681f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30682g;

    /* renamed from: h, reason: collision with root package name */
    public final String f30683h;

    public zzezm(boolean z, boolean z2, String str, boolean z3, int i2, int i3, int i4, String str2) {
        this.f30676a = z;
        this.f30677b = z2;
        this.f30678c = str;
        this.f30679d = z3;
        this.f30680e = i2;
        this.f30681f = i3;
        this.f30682g = i4;
        this.f30683h = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putString("js", this.f30678c);
        bundle.putBoolean("is_nonagon", true);
        zzbgb zzbgbVar = zzbgk.s4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        bundle.putString("extra_caps", (String) zzbdVar.f21153c.a(zzbgbVar));
        bundle.putInt("target_api", this.f30680e);
        bundle.putInt("dv", this.f30681f);
        bundle.putInt("lv", this.f30682g);
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.E6)).booleanValue()) {
            String str = this.f30683h;
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ev", str);
            }
        }
        Bundle bundleA = zzfiz.a(bundle, "sdk_env");
        bundleA.putBoolean("mf", ((Boolean) zzbik.f25181g.c()).booleanValue());
        bundleA.putBoolean("instant_app", this.f30676a);
        bundleA.putBoolean("lite", this.f30677b);
        bundleA.putBoolean("is_privileged_process", this.f30679d);
        bundle.putBundle("sdk_env", bundleA);
        Bundle bundleA2 = zzfiz.a(bundleA, "build_meta");
        bundleA2.putString("cl", "829525209");
        bundleA2.putString("rapid_rc", PaymentConstants.ENVIRONMENT.DEV);
        bundleA2.putString("rapid_rollup", "HEAD");
        bundleA.putBundle("build_meta", bundleA2);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        bundle.putString("js", this.f30678c);
        bundle.putInt("target_api", this.f30680e);
    }
}
