package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f36276a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36277b;

    public zza(IBinder iBinder, String str) {
        this.f36276a = iBinder;
        this.f36277b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f36276a;
    }

    public final Parcel g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f36277b);
        return parcelObtain;
    }

    public final void z0(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f36276a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
