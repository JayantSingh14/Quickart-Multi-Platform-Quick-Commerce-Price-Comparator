package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes4.dex */
final class zzbvq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdOverlayInfoParcel f25601a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbvr f25602b;

    public zzbvq(zzbvr zzbvrVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f25601a = adOverlayInfoParcel;
        this.f25602b = zzbvrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.overlay.zzn zznVar = com.google.android.gms.ads.internal.zzt.C.f21678b;
        com.google.android.gms.ads.internal.overlay.zzn.a(this.f25602b.f25603a, this.f25601a, true, null);
    }
}
