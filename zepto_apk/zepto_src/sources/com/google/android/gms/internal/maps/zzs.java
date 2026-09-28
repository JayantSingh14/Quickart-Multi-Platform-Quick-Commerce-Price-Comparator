package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzs extends zza implements zzu {
    @Override // com.google.android.gms.internal.maps.zzu
    public final boolean o9(zzu zzuVar) {
        Parcel parcelZ0 = z0();
        zzc.d(parcelZ0, zzuVar);
        Parcel parcelG = g(5, parcelZ0);
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final int zzd() {
        Parcel parcelG = g(1, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final int zzf() {
        Parcel parcelG = g(6, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final ArrayList zzg() {
        Parcel parcelG = g(3, z0());
        ArrayList<IBinder> arrayListCreateBinderArrayList = parcelG.createBinderArrayList();
        parcelG.recycle();
        return arrayListCreateBinderArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzu
    public final boolean zzi() {
        Parcel parcelG = g(4, z0());
        int i2 = zzc.f36737a;
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }
}
