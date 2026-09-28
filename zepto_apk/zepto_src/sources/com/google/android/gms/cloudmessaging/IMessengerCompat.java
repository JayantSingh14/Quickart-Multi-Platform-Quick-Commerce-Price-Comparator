package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
interface IMessengerCompat extends IInterface {

    public static class Impl extends Binder implements IMessengerCompat {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            throw null;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            throw null;
        }
    }

    public static class Proxy implements IMessengerCompat {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            throw null;
        }
    }
}
