package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbpp extends zzbcc implements zzbpq {
    public zzbpp() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 2) {
            ((zzdzg) this).zze();
        } else {
            if (i2 != 3) {
                return false;
            }
            String string = parcel.readString();
            zzbcd.f(parcel);
            ((zzdzg) this).c0(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
