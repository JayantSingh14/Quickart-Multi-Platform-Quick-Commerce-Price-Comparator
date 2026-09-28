package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzcd extends zzbcc implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzft zzftVar = (zzft) zzbcd.b(parcel, zzft.CREATOR);
            zzbcd.f(parcel);
            ((zzeq) this).Jb(zzftVar);
        } else {
            if (i2 != 2) {
                return false;
            }
            zzft zzftVar2 = (zzft) zzbcd.b(parcel, zzft.CREATOR);
            zzbcd.f(parcel);
            ((zzeq) this).L9(zzftVar2);
        }
        parcel2.writeNoException();
        return true;
    }
}
