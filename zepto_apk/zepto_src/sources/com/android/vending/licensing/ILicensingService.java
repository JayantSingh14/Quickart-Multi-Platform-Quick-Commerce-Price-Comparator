package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.vending.licensing.ILicenseResultListener;

/* loaded from: classes3.dex */
public interface ILicensingService extends IInterface {

    public static class Default implements ILicensingService {
        @Override // com.android.vending.licensing.ILicensingService
        public final void E5(long j2, String str, ILicenseResultListener iLicenseResultListener) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ILicensingService {

        public static class Proxy implements ILicensingService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f15292a;

            @Override // com.android.vending.licensing.ILicensingService
            public final void E5(long j2, String str, ILicenseResultListener iLicenseResultListener) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLicenseResultListener);
                    this.f15292a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15292a;
            }
        }

        public Stub() {
            attachInterface(this, "com.android.vending.licensing.ILicensingService");
        }

        public static ILicensingService g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ILicensingService)) {
                return (ILicensingService) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f15292a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("com.android.vending.licensing.ILicensingService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("com.android.vending.licensing.ILicensingService");
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            E5(parcel.readLong(), parcel.readString(), ILicenseResultListener.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void E5(long j2, String str, ILicenseResultListener iLicenseResultListener);
}
