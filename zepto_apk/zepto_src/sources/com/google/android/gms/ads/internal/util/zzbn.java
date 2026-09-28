package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzbn extends zzbcc implements zzbo {
    public zzbn() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            String string = parcel.readString();
            String string2 = parcel.readString();
            zzbcd.f(parcel);
            boolean zZze = zze(iObjectWrapperG, string, string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZze ? 1 : 0);
            return true;
        }
        if (i2 == 2) {
            IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            zzbcd.f(parcel);
            zzf(iObjectWrapperG2);
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
        com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzbcd.b(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
        zzbcd.f(parcel);
        boolean zZzg = zzg(iObjectWrapperG3, zzaVar);
        parcel2.writeNoException();
        parcel2.writeInt(zZzg ? 1 : 0);
        return true;
    }
}
