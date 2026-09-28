package com.google.android.gms.internal.ads;

import android.os.Bundle;
import in.juspay.hyper.constants.LogSubCategory;

/* loaded from: classes4.dex */
public final class zzexr implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30543a;

    public zzexr(Bundle bundle) {
        this.f30543a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        Bundle bundleA = zzfiz.a(bundle, LogSubCategory.Context.DEVICE);
        bundleA.putBundle("android_mem_info", this.f30543a);
        bundle.putBundle(LogSubCategory.Context.DEVICE, bundleA);
    }
}
