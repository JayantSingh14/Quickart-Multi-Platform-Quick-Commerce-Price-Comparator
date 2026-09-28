package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbur extends zzbcc implements zzbus {
    public zzbur() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbto zzbtmVar;
        if (i2 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbtmVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
                zzbtmVar = iInterfaceQueryLocalInterface instanceof zzbto ? (zzbto) iInterfaceQueryLocalInterface : new zzbtm(strongBinder);
            }
            zzbcd.f(parcel);
            zzelw zzelwVar = (zzelw) this;
            zzelwVar.f29686b.f29689c = zzbtmVar;
            ((zzekv) zzelwVar.f29685a.f29464c).zzj();
        } else if (i2 == 2) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            ((zzekv) ((zzelw) this).f29685a.f29464c).Qb(0, string);
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            ((zzelw) this).a(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
