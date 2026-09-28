package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzct extends zzbm implements zzcu {
    public zzct() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
        zzbn.f(parcel);
        ((zzco) this).b0(bundle);
        parcel2.writeNoException();
        return true;
    }
}
