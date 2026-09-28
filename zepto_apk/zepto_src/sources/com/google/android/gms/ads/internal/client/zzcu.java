package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzcu extends zzbcc implements zzcv {
    public zzcu() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zze zzeVar = (zze) zzbcd.b(parcel, zze.CREATOR);
            zzbcd.f(parcel);
            ((zzbe) this).R9(zzeVar);
        } else if (i2 == 2) {
            ((zzbe) this).zzc();
        } else if (i2 == 3) {
            ((zzbe) this).zzd();
        } else if (i2 != 4 && i2 != 5) {
            return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
