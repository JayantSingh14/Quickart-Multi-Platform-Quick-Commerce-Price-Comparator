package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzc extends com.google.android.gms.internal.maps.zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzc();
            throw null;
        }
        if (i2 != 2) {
            return false;
        }
        zzb();
        throw null;
    }
}
