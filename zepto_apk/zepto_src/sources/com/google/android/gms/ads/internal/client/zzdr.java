package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzdr extends zzbcb implements zzdt {
    public zzdr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void va(zzt zztVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zztVar);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final boolean zzf() {
        Parcel parcelZ0 = z0(2, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }
}
