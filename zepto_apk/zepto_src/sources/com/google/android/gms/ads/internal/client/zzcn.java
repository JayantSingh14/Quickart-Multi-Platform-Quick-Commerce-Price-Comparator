package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbcz;

/* loaded from: classes4.dex */
public abstract class zzcn extends zzbcc implements zzco {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21158a = 0;

    public zzcn() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        zzbcd.f(parcel);
        ((zzbcz) this).p1(string, string2);
        parcel2.writeNoException();
        return true;
    }
}
