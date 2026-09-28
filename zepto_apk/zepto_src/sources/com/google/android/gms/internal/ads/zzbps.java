package com.google.android.gms.internal.ads;

import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzbps extends zzbcc implements zzbpt {
    public zzbps() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzbpm.CREATOR);
        zzbcd.f(parcel);
        r5(arrayListCreateTypedArrayList);
        parcel2.writeNoException();
        return true;
    }
}
