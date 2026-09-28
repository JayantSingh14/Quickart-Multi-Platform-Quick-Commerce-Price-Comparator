package com.amazon.identity.auth.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IAuthError extends IInterface {

    public static class Default implements IAuthError {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAuthError {

        public static class a implements IAuthError {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f15084a;

            public a(IBinder iBinder) {
                this.f15084a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15084a;
            }
        }

        public Stub() {
            attachInterface(this, "com.amazon.identity.auth.device.IAuthError");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.amazon.identity.auth.device.IAuthError");
            return true;
        }
    }
}
