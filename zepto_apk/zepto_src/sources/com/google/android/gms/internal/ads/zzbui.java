package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbui extends zzbcc implements zzbuj {
    public zzbui() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 2) {
            ((zzekv) ((zzejx) this).f29514a.f29464c).zzj();
        } else if (i2 == 3) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            ((zzekv) ((zzejx) this).f29514a.f29464c).Qb(0, string);
        } else {
            if (i2 != 4) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            ((zzejx) this).a(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
