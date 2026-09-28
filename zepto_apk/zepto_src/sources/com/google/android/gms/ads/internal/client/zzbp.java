package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public abstract class zzbp extends zzbcc implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            zzm zzmVar = (zzm) zzbcd.b(parcel, zzm.CREATOR);
            zzbcd.f(parcel);
            U0(zzmVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 2) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
            return true;
        }
        if (i2 == 3) {
            boolean zZzg = zzg();
            parcel2.writeNoException();
            ClassLoader classLoader = zzbcd.f24690a;
            parcel2.writeInt(zZzg ? 1 : 0);
            return true;
        }
        if (i2 == 4) {
            String strZzh = zzh();
            parcel2.writeNoException();
            parcel2.writeString(strZzh);
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        zzm zzmVar2 = (zzm) zzbcd.b(parcel, zzm.CREATOR);
        int i3 = parcel.readInt();
        zzbcd.f(parcel);
        P7(zzmVar2, i3);
        parcel2.writeNoException();
        return true;
    }
}
