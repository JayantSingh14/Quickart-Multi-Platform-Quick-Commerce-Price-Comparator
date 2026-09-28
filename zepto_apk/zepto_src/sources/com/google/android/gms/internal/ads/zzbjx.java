package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbjx extends zzbcc implements zzbjy {
    public zzbjx() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbjy Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbjy ? (zzbjy) iInterfaceQueryLocalInterface : new zzbjw(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperZzb = ((zzbjj) this).zzb();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzb);
                return true;
            case 2:
                parcel2.writeNoException();
                zzbcd.d(parcel2, ((zzbjj) this).f25244b);
                return true;
            case 3:
                parcel2.writeNoException();
                parcel2.writeDouble(((zzbjj) this).f25245c);
                return true;
            case 4:
                parcel2.writeNoException();
                parcel2.writeInt(((zzbjj) this).f25246d);
                return true;
            case 5:
                parcel2.writeNoException();
                parcel2.writeInt(((zzbjj) this).f25247e);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeMap(((zzbjj) this).f25248f);
                return true;
            default:
                return false;
        }
    }
}
