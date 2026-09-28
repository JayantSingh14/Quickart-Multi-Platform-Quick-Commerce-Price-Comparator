package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzo extends com.google.android.gms.internal.maps.zzb implements zzp {
    public zzo() {
        super("com.google.android.gms.maps.internal.IOnCameraIdleListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
