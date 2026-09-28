package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* loaded from: classes4.dex */
public final class zzbwn extends zzbll {

    /* renamed from: a, reason: collision with root package name */
    public final NativeAd.OnNativeAdLoadedListener f25656a;

    public zzbwn(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.f25656a = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzblm
    public final void L2(zzbls zzblsVar) {
        zzbwi zzbwiVar = new zzbwi(zzblsVar);
        zzebf zzebfVar = (zzebf) this.f25656a;
        zzebfVar.f28995a.Xb(zzbwiVar, zzebfVar.f28996b);
    }
}
