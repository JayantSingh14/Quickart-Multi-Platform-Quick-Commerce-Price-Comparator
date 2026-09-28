package com.google.android.gms.internal.pal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzfj implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f37732a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37733b;

    public zzfj(IBinder iBinder, String str) {
        this.f37732a = iBinder;
        this.f37733b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37732a;
    }

    public final Parcel g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f37733b);
        return parcelObtain;
    }

    public final void j1(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f37732a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final Parcel z0(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f37732a.transact(i2, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e2) {
                parcelObtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }
}
