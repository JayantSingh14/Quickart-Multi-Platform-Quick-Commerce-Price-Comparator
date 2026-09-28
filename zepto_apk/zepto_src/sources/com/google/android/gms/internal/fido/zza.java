package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f36569a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36570b;

    public zza(IBinder iBinder, String str) {
        this.f36569a = iBinder;
        this.f36570b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f36569a;
    }

    public final Parcel g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f36570b);
        return parcelObtain;
    }

    public final void z0(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f36569a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
