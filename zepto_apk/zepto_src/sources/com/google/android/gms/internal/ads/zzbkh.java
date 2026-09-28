package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbkh extends zzbcc implements zzbki {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25283a = 0;

    public zzbkh() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            zzbcd.f(parcel);
            N(iObjectWrapperG);
        } else if (i2 == 2) {
            zzc();
        } else {
            if (i2 != 3) {
                return false;
            }
            IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            zzbcd.f(parcel);
            H0(iObjectWrapperG2);
        }
        parcel2.writeNoException();
        return true;
    }
}
