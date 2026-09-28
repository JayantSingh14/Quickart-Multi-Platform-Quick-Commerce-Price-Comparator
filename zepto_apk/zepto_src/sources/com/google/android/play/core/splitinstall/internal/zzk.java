package com.google.android.play.core.splitinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzk implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f41985a;

    public zzk(IBinder iBinder) {
        this.f41985a = iBinder;
    }

    public static Parcel g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f41985a;
    }

    public final void z0(int i2, Parcel parcel) {
        try {
            this.f41985a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
