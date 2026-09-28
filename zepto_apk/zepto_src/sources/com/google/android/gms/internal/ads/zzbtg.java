package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbtg extends zzbcb implements zzbti {
    public zzbtg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final IObjectWrapper zze() {
        return android.support.v4.media.a.f(z0(1, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final boolean zzf() {
        Parcel parcelZ0 = z0(2, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }
}
