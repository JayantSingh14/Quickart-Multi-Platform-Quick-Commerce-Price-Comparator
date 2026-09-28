package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;

/* loaded from: classes4.dex */
public final class zzcm extends zzbcb implements zzco {
    public zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void p1(String str, String str2) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        j1(1, parcelG);
    }
}
