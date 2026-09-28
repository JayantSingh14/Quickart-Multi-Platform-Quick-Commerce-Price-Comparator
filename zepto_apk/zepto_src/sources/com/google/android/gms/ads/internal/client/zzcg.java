package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzcg extends zzbcc implements zzch {
    public zzcg() {
        super("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzea zzdyVar;
        if (i2 == 1) {
            String string = parcel.readString();
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
                zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(strongBinder);
            } else {
                zzdyVar = null;
            }
            zzbcd.f(parcel);
            A5(string, zzdyVar);
            throw null;
        }
        if (i2 == 2) {
            String string2 = parcel.readString();
            zzbcd.f(parcel);
            c0(string2);
            throw null;
        }
        if (i2 != 3) {
            return false;
        }
        String string3 = parcel.readString();
        zze zzeVar = (zze) zzbcd.b(parcel, zze.CREATOR);
        zzbcd.f(parcel);
        W8(string3, zzeVar);
        throw null;
    }
}
