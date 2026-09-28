package com.google.android.gms.internal.location;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            zze();
            return true;
        }
        zzg zzgVar = (zzg) zzc.a(parcel, zzg.CREATOR);
        zzc.b(parcel);
        nb(zzgVar);
        return true;
    }
}
