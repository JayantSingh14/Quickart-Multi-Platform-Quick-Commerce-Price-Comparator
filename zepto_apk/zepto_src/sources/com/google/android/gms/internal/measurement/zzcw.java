package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzcw extends zzbm implements zzcx {
    public zzcw() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 2) {
            return false;
        }
        ((zzdu) this).zze();
        return true;
    }
}
