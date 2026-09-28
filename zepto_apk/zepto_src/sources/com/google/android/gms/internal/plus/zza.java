package com.google.android.gms.internal.plus;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f38192a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38193b;

    public zza(IBinder iBinder, String str) {
        this.f38192a = iBinder;
        this.f38193b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f38192a;
    }

    public final void g(int i2, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f38192a.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
