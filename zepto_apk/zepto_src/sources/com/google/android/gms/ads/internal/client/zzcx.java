package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbsz;

/* loaded from: classes4.dex */
public abstract class zzcx extends zzbcc implements zzcy {
    public zzcx() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcy asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return iInterfaceQueryLocalInterface instanceof zzcy ? (zzcy) iInterfaceQueryLocalInterface : new zzcw(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzfc liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzbcd.d(parcel2, liteSdkVersion);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        zzbsz adapterCreator = getAdapterCreator();
        parcel2.writeNoException();
        zzbcd.e(parcel2, adapterCreator);
        return true;
    }
}
