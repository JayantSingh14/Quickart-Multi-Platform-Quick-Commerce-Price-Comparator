package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbeb extends zzbcb implements zzbed {
    @Override // com.google.android.gms.internal.ads.zzbed
    public final void K5(IObjectWrapper iObjectWrapper, zzbek zzbekVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbekVar);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbed
    public final com.google.android.gms.ads.internal.client.zzea zzg() {
        Parcel parcelZ0 = z0(5, g());
        com.google.android.gms.ads.internal.client.zzea zzeaVarXb = com.google.android.gms.ads.internal.client.zzdz.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzeaVarXb;
    }
}
