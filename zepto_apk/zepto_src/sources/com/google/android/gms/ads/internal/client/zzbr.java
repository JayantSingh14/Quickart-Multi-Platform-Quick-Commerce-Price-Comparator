package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzblm;

/* loaded from: classes4.dex */
public final class zzbr extends zzbcb implements zzbt {
    public zzbr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void P8(zzbjn zzbjnVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzbjnVar);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void S8(zzbk zzbkVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbkVar);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void i3(String str, zzblf zzblfVar, zzblc zzblcVar) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzblfVar);
        zzbcd.e(parcelG, zzblcVar);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void ob(zzblm zzblmVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzblmVar);
        j1(10, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final zzbq zze() {
        zzbq zzboVar;
        Parcel parcelZ0 = z0(1, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
        }
        parcelZ0.recycle();
        return zzboVar;
    }
}
