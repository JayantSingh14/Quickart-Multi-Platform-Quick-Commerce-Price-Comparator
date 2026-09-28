package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzgb extends com.google.android.gms.internal.measurement.zzbl implements zzgd {
    public zzgb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgd
    public final void J0(List list) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeTypedList(list);
        w1(parcelZ0);
    }
}
