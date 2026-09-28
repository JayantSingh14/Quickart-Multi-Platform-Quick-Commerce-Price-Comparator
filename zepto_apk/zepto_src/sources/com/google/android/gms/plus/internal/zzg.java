package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ICancelToken;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzg extends com.google.android.gms.internal.plus.zza implements zzf {
    @Override // com.google.android.gms.plus.internal.zzf
    public final ICancelToken R2(zzb zzbVar, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f38193b);
        com.google.android.gms.internal.plus.zzc.b(parcelObtain, zzbVar);
        parcelObtain.writeInt(i2);
        parcelObtain.writeInt(i3);
        parcelObtain.writeInt(-1);
        parcelObtain.writeString(null);
        parcelObtain = Parcel.obtain();
        try {
            this.f38192a.transact(16, parcelObtain, parcelObtain, 0);
            parcelObtain.readException();
            parcelObtain.recycle();
            return ICancelToken.Stub.asInterface(parcelObtain.readStrongBinder());
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void Y4(zzb zzbVar, ArrayList arrayList) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f38193b);
        com.google.android.gms.internal.plus.zzc.b(parcelObtain, zzbVar);
        parcelObtain.writeStringList(arrayList);
        g(34, parcelObtain);
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void Z5(zzb zzbVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f38193b);
        com.google.android.gms.internal.plus.zzc.b(parcelObtain, zzbVar);
        g(19, parcelObtain);
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void zza() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f38193b);
        g(6, parcelObtain);
    }
}
