package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzcab extends zzbcc implements zzcac {
    public zzcab() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            parcel2.writeNoException();
            parcel2.writeString(((zzcaw) this).f25797a);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(((zzcaw) this).f25798b);
        return true;
    }
}
