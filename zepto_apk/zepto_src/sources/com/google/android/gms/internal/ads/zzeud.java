package com.google.android.gms.internal.ads;

import android.os.Bundle;
import in.juspay.hyper.constants.LogSubCategory;

/* loaded from: classes4.dex */
public final class zzeud implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final double f30339a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30340b;

    public zzeud(double d2, boolean z) {
        this.f30339a = d2;
        this.f30340b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        Bundle bundleA = zzfiz.a(bundle, LogSubCategory.Context.DEVICE);
        bundle.putBundle(LogSubCategory.Context.DEVICE, bundleA);
        Bundle bundleA2 = zzfiz.a(bundleA, "battery");
        bundleA.putBundle("battery", bundleA2);
        bundleA2.putBoolean("is_charging", this.f30340b);
        bundleA2.putDouble("battery_level", this.f30339a);
    }
}
