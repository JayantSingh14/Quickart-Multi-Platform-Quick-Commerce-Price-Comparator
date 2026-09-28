package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbsx extends zzbcb implements zzbsz {
    @Override // com.google.android.gms.internal.ads.zzbsz
    public final boolean Y(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        Parcel parcelZ0 = z0(4, parcelG);
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final zzbtc b(String str) {
        zzbtc zzbtaVar;
        Parcel parcelG = g();
        parcelG.writeString(str);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbtaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbtaVar = iInterfaceQueryLocalInterface instanceof zzbtc ? (zzbtc) iInterfaceQueryLocalInterface : new zzbta(strongBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }
        parcelZ0.recycle();
        return zzbtaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final boolean o(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        Parcel parcelZ0 = z0(2, parcelG);
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final zzbuy q(String str) {
        zzbuy zzbuwVar;
        Parcel parcelG = g();
        parcelG.writeString(str);
        Parcel parcelZ0 = z0(3, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i2 = zzbux.f25576a;
        if (strongBinder == null) {
            zzbuwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
            zzbuwVar = iInterfaceQueryLocalInterface instanceof zzbuy ? (zzbuy) iInterfaceQueryLocalInterface : new zzbuw(strongBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        }
        parcelZ0.recycle();
        return zzbuwVar;
    }
}
