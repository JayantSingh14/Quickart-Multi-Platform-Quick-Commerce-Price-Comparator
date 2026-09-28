package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzbm extends zzbcc implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzb();
        } else {
            if (i2 != 2) {
                return false;
            }
            zze zzeVar = (zze) zzbcd.b(parcel, zze.CREATOR);
            zzbcd.f(parcel);
            k1(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
