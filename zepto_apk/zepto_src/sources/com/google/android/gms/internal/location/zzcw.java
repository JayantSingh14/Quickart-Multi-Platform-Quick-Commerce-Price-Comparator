package com.google.android.gms.internal.location;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes4.dex */
final class zzcw extends com.google.android.gms.location.zzq {

    /* renamed from: b, reason: collision with root package name */
    public final zzcs f36656b;

    public zzcw(zzcs zzcsVar) {
        this.f36656b = zzcsVar;
    }

    @Override // com.google.android.gms.location.zzr
    public final void Z4(LocationAvailability locationAvailability) {
        this.f36656b.zza().notifyListener(new zzcu(locationAvailability));
    }

    @Override // com.google.android.gms.location.zzr
    public final void v9(LocationResult locationResult) {
        this.f36656b.zza().notifyListener(new zzct(locationResult));
    }

    @Override // com.google.android.gms.location.zzr
    public final void zzf() {
        this.f36656b.zza().notifyListener(new zzcv(this));
    }
}
