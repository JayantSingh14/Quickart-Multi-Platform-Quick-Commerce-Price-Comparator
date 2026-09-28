package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzdad;

/* loaded from: classes4.dex */
public abstract class zzdz extends zzbcc implements zzea {
    public zzdz() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzea Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 1:
                parcel2.writeNoException();
                parcel2.writeString(((zzdad) this).f27543a);
                return true;
            case 2:
                parcel2.writeNoException();
                parcel2.writeString(((zzdad) this).f27544b);
                return true;
            case 3:
                parcel2.writeNoException();
                parcel2.writeTypedList(((zzdad) this).f27547e);
                return true;
            case 4:
                zzv zzvVarZzh = ((zzdad) this).zzh();
                parcel2.writeNoException();
                zzbcd.d(parcel2, zzvVarZzh);
                return true;
            case 5:
                parcel2.writeNoException();
                zzbcd.d(parcel2, ((zzdad) this).f27551i);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeString(((zzdad) this).f27545c);
                return true;
            default:
                return false;
        }
    }
}
