package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public final class zzedo extends zzbyq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzedq f29145a;

    public zzedo(zzedq zzedqVar) {
        this.f29145a = zzedqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void N7(com.google.android.gms.ads.internal.util.zzba zzbaVar) {
        zzcdt zzcdtVar = this.f29145a.f29148a;
        zzbaVar.getClass();
        zzcdtVar.c(new com.google.android.gms.ads.internal.util.zzaz(zzbaVar.f21515a, zzbaVar.f21516b));
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void f8(ParcelFileDescriptor parcelFileDescriptor, zzbza zzbzaVar) {
        this.f29145a.f29148a.b(new zzeeg(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbzaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void la(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzedq zzedqVar = this.f29145a;
        zzedqVar.f29148a.b(new zzeeg(autoCloseInputStream, zzedqVar.f29152e));
    }
}
