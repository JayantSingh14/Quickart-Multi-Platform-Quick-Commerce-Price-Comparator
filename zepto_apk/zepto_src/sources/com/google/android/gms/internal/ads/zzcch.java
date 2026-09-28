package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcch extends zzbcb implements zzccj {
    public zzcch(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzccj
    public final void c6(IObjectWrapper iObjectWrapper, zzccn zzccnVar, zzccg zzccgVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzccnVar);
        zzbcd.e(parcelG, zzccgVar);
        j1(1, parcelG);
    }
}
