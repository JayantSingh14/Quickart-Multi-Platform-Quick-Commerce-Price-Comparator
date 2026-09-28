package com.amazon.identity.auth.device.authorization;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.identity.auth.device.IAuthError;

/* loaded from: classes3.dex */
public interface IAuthorizationListener extends IInterface {
    public static final String DESCRIPTOR = "com.amazon.identity.auth.device.authorization.IAuthorizationListener";

    public static class Default implements IAuthorizationListener {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.IAuthorizationListener
        public final void onCancel(Bundle bundle) {
        }

        @Override // com.amazon.identity.auth.device.authorization.IAuthorizationListener
        public final void onError(IAuthError iAuthError) {
        }

        @Override // com.amazon.identity.auth.device.authorization.IAuthorizationListener
        public final void onSuccess(Bundle bundle) {
        }
    }

    public static abstract class Stub extends Binder implements IAuthorizationListener {
        public Stub() {
            attachInterface(this, IAuthorizationListener.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(IAuthorizationListener.DESCRIPTOR);
                return true;
            }
            IAuthError aVar = null;
            if (i2 == 1) {
                parcel.enforceInterface(IAuthorizationListener.DESCRIPTOR);
                onSuccess(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel.enforceInterface(IAuthorizationListener.DESCRIPTOR);
                onCancel(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(IAuthorizationListener.DESCRIPTOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.amazon.identity.auth.device.IAuthError");
                aVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAuthError)) ? new IAuthError.Stub.a(strongBinder) : (IAuthError) iInterfaceQueryLocalInterface;
            }
            onError(aVar);
            parcel2.writeNoException();
            return true;
        }
    }

    void onCancel(Bundle bundle) throws RemoteException;

    void onError(IAuthError iAuthError) throws RemoteException;

    void onSuccess(Bundle bundle) throws RemoteException;
}
