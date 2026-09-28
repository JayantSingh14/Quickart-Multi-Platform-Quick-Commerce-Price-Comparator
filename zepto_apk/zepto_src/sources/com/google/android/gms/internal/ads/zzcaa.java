package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzcaa extends zzbcb implements zzcac {
    public zzcaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzcac
    public final String zze() {
        Parcel parcelZ0 = z0(1, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzcac
    public final int zzf() {
        Parcel parcelZ0 = z0(2, g());
        int i2 = parcelZ0.readInt();
        parcelZ0.recycle();
        return i2;
    }
}
