package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzp extends com.google.android.gms.internal.common.zza implements IInterface {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final IObjectWrapper V2(ObjectWrapper objectWrapper, String str, boolean z, long j2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeLong(j2);
        return android.support.v4.media.a.f(zzB(7, parcelZza));
    }

    public final IObjectWrapper g(ObjectWrapper objectWrapper, String str, int i2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i2);
        return android.support.v4.media.a.f(zzB(2, parcelZza));
    }

    public final IObjectWrapper j1(ObjectWrapper objectWrapper, String str, int i2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i2);
        return android.support.v4.media.a.f(zzB(4, parcelZza));
    }

    public final int w1(ObjectWrapper objectWrapper, String str, boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i2 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i2;
    }

    public final IObjectWrapper y3(ObjectWrapper objectWrapper, String str, int i2, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i2);
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper2);
        return android.support.v4.media.a.f(zzB(8, parcelZza));
    }

    public final int z0(ObjectWrapper objectWrapper, String str, boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i2 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i2;
    }

    public final int zzi() throws RemoteException {
        Parcel parcelZzB = zzB(6, zza());
        int i2 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i2;
    }
}
