package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzbvp implements com.google.android.gms.ads.internal.overlay.zzr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbvr f25600a;

    public zzbvp(zzbvr zzbvrVar) {
        this.f25600a = zzbvrVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is closed.");
        this.f25600a.f25604b.l();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is destroyed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is created.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is stopped.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is restarted.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is started.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Opening AdMobCustomTabsAdapter overlay.");
        this.f25600a.f25604b.i();
    }
}
