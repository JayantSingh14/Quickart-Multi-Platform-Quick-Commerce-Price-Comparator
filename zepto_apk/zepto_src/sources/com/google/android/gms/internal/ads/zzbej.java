package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbej extends zzbcc implements zzbek {
    public zzbej() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                zzbcd.f(parcel);
            } else if (i2 != 4 && i2 != 5) {
                return false;
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
