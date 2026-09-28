package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzv extends com.google.android.gms.internal.common.zza implements zzx {
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() throws RemoteException {
        return a.f(zzB(1, zza()));
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() throws RemoteException {
        Parcel parcelZzB = zzB(2, zza());
        int i2 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i2;
    }
}
