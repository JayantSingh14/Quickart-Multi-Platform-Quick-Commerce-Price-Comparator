package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public final class zzedp extends zzbyq {

    /* renamed from: a, reason: collision with root package name */
    public final zzcdt f29146a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbza f29147b;

    public zzedp(zzcdt zzcdtVar, zzbza zzbzaVar) {
        this.f29146a = zzcdtVar;
        this.f29147b = zzbzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void N7(com.google.android.gms.ads.internal.util.zzba zzbaVar) {
        zzbaVar.getClass();
        this.f29146a.c(new com.google.android.gms.ads.internal.util.zzaz(zzbaVar.f21515a, zzbaVar.f21516b));
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void f8(ParcelFileDescriptor parcelFileDescriptor, zzbza zzbzaVar) {
        this.f29146a.b(new zzeeg(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbzaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void la(ParcelFileDescriptor parcelFileDescriptor) {
        this.f29146a.b(new zzeeg(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.f29147b));
    }
}
