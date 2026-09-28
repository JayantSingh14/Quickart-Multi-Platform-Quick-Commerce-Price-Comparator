package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzdu extends zzbcb implements zzdw {
    public zzdu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdw
    public final void R4(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, iObjectWrapper2);
        j1(1, parcelG);
    }
}
