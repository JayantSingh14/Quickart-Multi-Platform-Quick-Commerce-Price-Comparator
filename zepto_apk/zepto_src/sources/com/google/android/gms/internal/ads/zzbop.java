package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbop extends zzbcc implements zzboq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25390a = 0;

    public zzbop() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            q(string);
        } else {
            if (i2 != 2) {
                return false;
            }
            zzf();
        }
        parcel2.writeNoException();
        return true;
    }
}
