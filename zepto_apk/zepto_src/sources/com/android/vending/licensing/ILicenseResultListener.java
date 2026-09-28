package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ILicenseResultListener extends IInterface {

    public static class Default implements ILicenseResultListener {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ILicenseResultListener {
        static final int TRANSACTION_verifyLicense = 1;

        public static class Proxy implements ILicenseResultListener {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f15291a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15291a;
            }
        }

        public Stub() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        public static ILicenseResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicenseResultListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ILicenseResultListener)) {
                return (ILicenseResultListener) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f15291a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            verifyLicense(parcel.readInt(), parcel.readString(), parcel.readString());
            return true;
        }
    }

    void verifyLicense(int i2, String str, String str2);
}
