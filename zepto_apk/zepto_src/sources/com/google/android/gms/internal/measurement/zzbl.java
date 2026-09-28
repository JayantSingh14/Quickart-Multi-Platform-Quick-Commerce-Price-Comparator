package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzbl implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f36801a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36802b;

    public zzbl(IBinder iBinder, String str) {
        this.f36801a = iBinder;
        this.f36802b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f36801a;
    }

    public final Parcel g(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f36801a.transact(i2, parcel, parcelObtain, 0);
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

    public final void j1(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f36801a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final void w1(Parcel parcel) {
        try {
            this.f36801a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel z0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f36802b);
        return parcelObtain;
    }
}
