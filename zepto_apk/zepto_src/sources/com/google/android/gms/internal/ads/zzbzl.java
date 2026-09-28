package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbzl extends zzbcc implements zzbzm {
    public zzbzl() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            parcel2.writeNoException();
            parcel2.writeString(((zzbzj) this).f25777a);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(((zzbzj) this).f25778b);
        return true;
    }
}
