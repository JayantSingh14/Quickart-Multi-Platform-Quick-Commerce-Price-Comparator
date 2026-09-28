package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import in.juspay.hyper.constants.LogSubCategory;

/* loaded from: classes4.dex */
public final class zzfak implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30750a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30751b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30752c;

    /* renamed from: d, reason: collision with root package name */
    public final int f30753d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f30754e;

    /* renamed from: f, reason: collision with root package name */
    public final int f30755f;

    public zzfak(String str, int i2, int i3, int i4, boolean z, int i5) {
        this.f30750a = str;
        this.f30751b = i2;
        this.f30752c = i3;
        this.f30753d = i4;
        this.f30754e = z;
        this.f30755f = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        zzfiz.b(bundle, "carrier", this.f30750a, !TextUtils.isEmpty(r0));
        int i2 = this.f30751b;
        zzfiz.c(bundle, "cnt", i2, i2 != -2);
        bundle.putInt("gnt", this.f30752c);
        bundle.putInt("pt", this.f30753d);
        Bundle bundleA = zzfiz.a(bundle, LogSubCategory.Context.DEVICE);
        bundle.putBundle(LogSubCategory.Context.DEVICE, bundleA);
        Bundle bundleA2 = zzfiz.a(bundleA, "network");
        bundleA.putBundle("network", bundleA2);
        bundleA2.putInt("active_network_state", this.f30755f);
        bundleA2.putBoolean("active_network_metered", this.f30754e);
    }
}
