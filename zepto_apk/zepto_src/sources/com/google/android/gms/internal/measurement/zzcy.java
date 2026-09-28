package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzcy extends zzbl implements zzda {
    public zzcy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void L7(long j2, Bundle bundle, String str, String str2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeString(str);
        parcelZ0.writeString(str2);
        zzbn.c(parcelZ0, bundle);
        parcelZ0.writeLong(j2);
        j1(1, parcelZ0);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        Parcel parcelG = g(2, z0());
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }
}
