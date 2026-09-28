package com.amazon.identity.auth.device.authorization;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface AmazonAuthorizationServiceInterface extends IInterface {
    public static final String DESCRIPTOR = "com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface";

    public static class Default implements AmazonAuthorizationServiceInterface {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
        public final Bundle authorize(Bundle bundle, String str, String[] strArr) {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
        public final Bundle clearAuthorizationState(Bundle bundle, String str) {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
        public final Bundle getMetaData() {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
        public final Bundle getToken(Bundle bundle, String str, String[] strArr) {
            return null;
        }

        @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
        public final Bundle openWorkflow(Bundle bundle, String str, String str2, String str3) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements AmazonAuthorizationServiceInterface {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15131a = 0;

        public static class a implements AmazonAuthorizationServiceInterface {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f15132a;

            public a(IBinder iBinder) {
                this.f15132a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15132a;
            }

            @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
            public final Bundle authorize(Bundle bundle, String str, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    if (!this.f15132a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f15131a;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
            public final Bundle clearAuthorizationState(Bundle bundle, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.f15132a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f15131a;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
            public final Bundle getMetaData() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                    if (!this.f15132a.transact(5, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f15131a;
                    }
                    parcelObtain2.readException();
                    Bundle bundle = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
            public final Bundle getToken(Bundle bundle, String str, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    if (!this.f15132a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f15131a;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface
            public final Bundle openWorkflow(Bundle bundle, String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f15132a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f15131a;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, AmazonAuthorizationServiceInterface.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                return true;
            }
            if (i2 == 1) {
                parcel.enforceInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                Bundle bundleAuthorize = authorize(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                if (bundleAuthorize != null) {
                    parcel2.writeInt(1);
                    bundleAuthorize.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                Bundle token = getToken(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                if (token != null) {
                    parcel2.writeInt(1);
                    token.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                Bundle bundleClearAuthorizationState = clearAuthorizationState(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (bundleClearAuthorizationState != null) {
                    parcel2.writeInt(1);
                    bundleClearAuthorizationState.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
                Bundle bundleOpenWorkflow = openWorkflow(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (bundleOpenWorkflow != null) {
                    parcel2.writeInt(1);
                    bundleOpenWorkflow.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 != 5) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
            Bundle metaData = getMetaData();
            parcel2.writeNoException();
            if (metaData != null) {
                parcel2.writeInt(1);
                metaData.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    Bundle authorize(Bundle bundle, String str, String[] strArr) throws RemoteException;

    Bundle clearAuthorizationState(Bundle bundle, String str) throws RemoteException;

    Bundle getMetaData() throws RemoteException;

    Bundle getToken(Bundle bundle, String str, String[] strArr) throws RemoteException;

    Bundle openWorkflow(Bundle bundle, String str, String str2, String str3) throws RemoteException;
}
