package PrefetchAgreementWallet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface PrefetchAgreementWalletInterface extends IInterface {

    public static class Default implements PrefetchAgreementWalletInterface {
        @Override // PrefetchAgreementWallet.PrefetchAgreementWalletInterface
        public final String a() {
            return null;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements PrefetchAgreementWalletInterface {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f2a = 0;

        public static class a implements PrefetchAgreementWalletInterface {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f3a;

            @Override // PrefetchAgreementWallet.PrefetchAgreementWalletInterface
            public final String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("PrefetchAgreementWallet.PrefetchAgreementWalletInterface");
                    parcelObtain.writeString("{\"useCase\"=\"WALLET\", \"intentType\"=\"getDeviceBindingDetails\"}");
                    if (!this.f3a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f2a;
                    }
                    parcelObtain2.readException();
                    String string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3a;
            }
        }

        public Stub() {
            attachInterface(this, "PrefetchAgreementWallet.PrefetchAgreementWalletInterface");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString("PrefetchAgreementWallet.PrefetchAgreementWalletInterface");
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface("PrefetchAgreementWallet.PrefetchAgreementWalletInterface");
            parcel.readString();
            String strA = a();
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a();
}
