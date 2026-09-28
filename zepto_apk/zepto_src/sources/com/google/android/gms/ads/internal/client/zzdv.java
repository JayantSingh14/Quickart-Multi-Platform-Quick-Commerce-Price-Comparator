package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzebh;

/* loaded from: classes4.dex */
public abstract class zzdv extends zzbcc implements zzdw {
    public zzdv() {
        super("com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        ((zzebh) this).R4(parcel.readString(), IObjectWrapper.Stub.g(parcel.readStrongBinder()), a.g(parcel, parcel));
        parcel2.writeNoException();
        return true;
    }
}
