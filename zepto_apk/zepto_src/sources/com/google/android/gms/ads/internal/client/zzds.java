package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzds extends zzbcc implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzdt Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return iInterfaceQueryLocalInterface instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface : new zzdr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzt zztVar = (zzt) zzbcd.b(parcel, zzt.CREATOR);
            zzbcd.f(parcel);
            ((zzfs) this).va(zztVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        boolean zZzf = ((zzfs) this).zzf();
        parcel2.writeNoException();
        ClassLoader classLoader = zzbcd.f24690a;
        parcel2.writeInt(zZzf ? 1 : 0);
        return true;
    }
}
