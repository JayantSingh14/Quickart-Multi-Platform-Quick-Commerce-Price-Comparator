package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzge extends com.google.android.gms.internal.measurement.zzbl implements zzgg {
    public zzge(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    public final void ib(zzop zzopVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.measurement.zzbn.c(parcelZ0, zzopVar);
        w1(parcelZ0);
    }
}
