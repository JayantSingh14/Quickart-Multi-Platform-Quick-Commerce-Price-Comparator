package com.google.android.gms.internal.location;

import android.location.Location;

/* loaded from: classes4.dex */
final class zzcz extends com.google.android.gms.location.zzt {

    /* renamed from: b, reason: collision with root package name */
    public final zzcs f36658b;

    public zzcz(zzcs zzcsVar) {
        this.f36658b = zzcsVar;
    }

    @Override // com.google.android.gms.location.zzu
    public final void h0(Location location) {
        ((zzas) this.f36658b).zza().notifyListener(new zzcx());
    }

    @Override // com.google.android.gms.location.zzu
    public final void zze() {
        ((zzas) this.f36658b).zza().notifyListener(new zzcy(this));
    }
}
