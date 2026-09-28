package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzccf extends zzbcc implements zzccg {
    public zzccf() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            parcel.readString();
            parcel.readString();
            zzbcd.f(parcel);
        } else if (i2 == 2) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            ((zzbxo) this).b(string);
        } else {
            if (i2 != 3) {
                return false;
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Bundle bundle = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
            zzbcd.f(parcel);
            ((zzbxo) this).G2(string2, string3, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}
