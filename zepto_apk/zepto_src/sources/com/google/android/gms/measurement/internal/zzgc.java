package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzgc extends com.google.android.gms.internal.measurement.zzbm implements zzgd {
    public zzgc() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
        com.google.android.gms.internal.measurement.zzbn.f(parcel);
        ((zzmd) this).J0(arrayListCreateTypedArrayList);
        return true;
    }
}
