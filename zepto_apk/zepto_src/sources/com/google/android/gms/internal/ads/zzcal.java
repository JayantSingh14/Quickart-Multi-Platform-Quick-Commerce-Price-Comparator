package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzcal extends zzbcc implements zzcam {
    public zzcal() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zze();
        } else if (i2 == 2) {
            int i3 = parcel.readInt();
            zzbcd.f(parcel);
            zzf(i3);
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            a(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
