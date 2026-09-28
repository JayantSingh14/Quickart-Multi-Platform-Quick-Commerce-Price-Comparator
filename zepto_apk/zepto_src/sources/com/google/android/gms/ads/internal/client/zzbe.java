package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.FullScreenContentCallback;

/* loaded from: classes4.dex */
public final class zzbe extends zzcu {

    /* renamed from: a, reason: collision with root package name */
    public final FullScreenContentCallback f21155a;

    public zzbe(FullScreenContentCallback fullScreenContentCallback) {
        this.f21155a = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void R9(zze zzeVar) {
        if (this.f21155a != null) {
            zzeVar.b();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.f21155a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.b();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzd() {
        FullScreenContentCallback fullScreenContentCallback = this.f21155a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.a();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzf() {
    }
}
