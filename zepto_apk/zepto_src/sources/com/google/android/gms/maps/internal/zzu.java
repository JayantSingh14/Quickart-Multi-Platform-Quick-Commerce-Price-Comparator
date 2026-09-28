package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzu extends com.google.android.gms.internal.maps.zzb implements zzv {
    public zzu() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveStartedListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        int i3 = parcel.readInt();
        com.google.android.gms.internal.maps.zzc.b(parcel);
        zzb(i3);
        parcel2.writeNoException();
        return true;
    }
}
