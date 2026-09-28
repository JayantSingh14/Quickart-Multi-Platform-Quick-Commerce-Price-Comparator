package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzbl extends zzbcb implements zzbn {
    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void k1(zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        j1(1, g());
    }
}
