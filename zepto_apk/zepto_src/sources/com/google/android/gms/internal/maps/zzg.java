package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzg extends zza implements zzi {
    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper J2(Bitmap bitmap) {
        Parcel parcelZ0 = z0();
        zzc.c(parcelZ0, bitmap);
        return a.f(g(6, parcelZ0));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper Z1(float f2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeFloat(f2);
        return a.f(g(5, parcelZ0));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper r(int i2) {
        Parcel parcelZ0 = z0();
        parcelZ0.writeInt(i2);
        return a.f(g(1, parcelZ0));
    }

    @Override // com.google.android.gms.internal.maps.zzi
    public final IObjectWrapper zzd() {
        return a.f(g(4, z0()));
    }
}
