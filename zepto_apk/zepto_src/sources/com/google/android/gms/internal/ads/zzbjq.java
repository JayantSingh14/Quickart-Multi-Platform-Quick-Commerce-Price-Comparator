package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzbjq extends zzbcc implements zzbjr {
    public zzbjq() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzbjr Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return iInterfaceQueryLocalInterface instanceof zzbjr ? (zzbjr) iInterfaceQueryLocalInterface : new zzbjp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 2) {
            parcel2.writeNoException();
            parcel2.writeString(((zzbjg) this).f25233a);
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        ArrayList arrayList = ((zzbjg) this).f25235c;
        parcel2.writeNoException();
        parcel2.writeList(arrayList);
        return true;
    }
}
