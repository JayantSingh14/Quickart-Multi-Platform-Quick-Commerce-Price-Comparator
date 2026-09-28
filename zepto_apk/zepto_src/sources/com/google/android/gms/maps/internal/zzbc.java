package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbc extends com.google.android.gms.internal.maps.zzb implements zzbd {
    public zzbc() {
        super("com.google.android.gms.maps.internal.IOnMyLocationClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        K3();
        throw null;
    }
}
