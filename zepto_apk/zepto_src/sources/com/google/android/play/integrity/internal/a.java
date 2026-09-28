package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f42150a;

    /* renamed from: b, reason: collision with root package name */
    public final String f42151b;

    public a(IBinder iBinder, String str) {
        this.f42150a = iBinder;
        this.f42151b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f42150a;
    }

    public final void g(int i2, Parcel parcel) {
        try {
            this.f42150a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
