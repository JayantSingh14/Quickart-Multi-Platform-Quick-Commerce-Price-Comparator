package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbsv;

/* loaded from: classes4.dex */
public final class zzci extends zzbcb implements zzck {
    public zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void W9(zzbsv zzbsvVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbsvVar);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void i0(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(18, parcelG);
    }
}
