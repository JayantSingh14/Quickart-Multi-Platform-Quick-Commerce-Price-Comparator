package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzbm extends zzbcb implements zzbo {
    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zze(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        Parcel parcelZ0 = z0(1, parcelG);
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzaVar);
        Parcel parcelZ0 = z0(3, parcelG);
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }
}
