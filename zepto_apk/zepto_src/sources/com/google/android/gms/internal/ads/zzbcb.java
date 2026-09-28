package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzbcb implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f24688a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24689b;

    public zzbcb(IBinder iBinder, String str) {
        this.f24688a = iBinder;
        this.f24689b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f24688a;
    }

    public final Parcel g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f24689b);
        return parcelObtain;
    }

    public final void j1(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f24688a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final void w1(int i2, Parcel parcel) {
        try {
            this.f24688a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel z0(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f24688a.transact(i2, parcel, parcelObtain, 0);
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
