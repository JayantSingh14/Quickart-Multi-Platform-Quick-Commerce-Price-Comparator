package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;

/* loaded from: classes4.dex */
public final class zzdh extends zzbcb implements zzdj {
    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zze() {
        Parcel parcelZ0 = z0(1, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zzf() {
        Parcel parcelZ0 = z0(2, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }
}
