package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbkq extends zzbcb implements zzbks {
    public zzbkq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final boolean J(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        Parcel parcelZ0 = z0(10, parcelG);
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final IObjectWrapper T9() {
        return android.support.v4.media.a.f(z0(9, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final String zzh() {
        Parcel parcelZ0 = z0(4, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }
}
