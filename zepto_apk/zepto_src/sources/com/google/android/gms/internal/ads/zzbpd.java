package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public abstract class zzbpd extends zzbcc implements zzbpe {
    public zzbpd() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzbcd.b(parcel, ParcelFileDescriptor.CREATOR);
        zzbcd.f(parcel);
        ((zzbpg) this).f25403a.b(parcelFileDescriptor);
        return true;
    }
}
