package com.google.android.gms.measurement.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzgf extends com.google.android.gms.internal.measurement.zzbm implements zzgg {
    public zzgf() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 2) {
            return false;
        }
        zzop zzopVar = (zzop) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzop.CREATOR);
        com.google.android.gms.internal.measurement.zzbn.f(parcel);
        ((zzme) this).ib(zzopVar);
        return true;
    }
}
