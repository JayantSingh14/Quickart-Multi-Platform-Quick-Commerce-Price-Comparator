package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbjw extends zzbcb implements zzbjy {
    public zzbjw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final IObjectWrapper zzb() {
        return android.support.v4.media.a.f(z0(1, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final Uri zzc() {
        Parcel parcelZ0 = z0(2, g());
        Uri uri = (Uri) zzbcd.b(parcelZ0, Uri.CREATOR);
        parcelZ0.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final double zzd() {
        Parcel parcelZ0 = z0(3, g());
        double d2 = parcelZ0.readDouble();
        parcelZ0.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final int zze() {
        Parcel parcelZ0 = z0(4, g());
        int i2 = parcelZ0.readInt();
        parcelZ0.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final int zzf() {
        Parcel parcelZ0 = z0(5, g());
        int i2 = parcelZ0.readInt();
        parcelZ0.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final Map zzg() {
        Parcel parcelZ0 = z0(6, g());
        HashMap hashMap = parcelZ0.readHashMap(zzbcd.f24690a);
        parcelZ0.recycle();
        return hashMap;
    }
}
