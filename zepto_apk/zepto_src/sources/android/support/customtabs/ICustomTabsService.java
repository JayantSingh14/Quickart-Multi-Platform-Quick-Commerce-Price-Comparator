package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.customtabs.ICustomTabsCallback;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface ICustomTabsService extends IInterface {
    public static final String O = "android$support$customtabs$ICustomTabsService".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements ICustomTabsService {
        @Override // android.support.customtabs.ICustomTabsService
        public final int G9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean J4(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean N4(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Oa(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean U8(long j2) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Z9(ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsService {

        public static class Proxy implements ICustomTabsService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f16a;

            @Override // android.support.customtabs.ICustomTabsService
            public final int G9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    parcelObtain.writeString(str);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f16a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean J4(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.b(parcelObtain, uri, 0);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f16a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean N4(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f16a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean Oa(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.b(parcelObtain, uri, 0);
                    this.f16a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean U8(long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeLong(0L);
                    this.f16a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean Z9(ICustomTabsCallback iCustomTabsCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.O);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    this.f16a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f16a;
            }
        }

        public Stub() {
            attachInterface(this, ICustomTabsService.O);
        }

        public static ICustomTabsService g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICustomTabsService.O);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICustomTabsService)) {
                return (ICustomTabsService) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f16a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = ICustomTabsService.O;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i2) {
                case 2:
                    boolean zU8 = U8(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zU8 ? 1 : 0);
                    return true;
                case 3:
                    boolean zZ9 = Z9(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zZ9 ? 1 : 0);
                    return true;
                case 4:
                    ICustomTabsCallback iCustomTabsCallbackG = ICustomTabsCallback.Stub.g(parcel.readStrongBinder());
                    Uri uri = (Uri) _Parcel.a(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zOa = oa(iCustomTabsCallbackG, uri, (Bundle) _Parcel.a(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zOa ? 1 : 0);
                    return true;
                case 5:
                    Bundle bundleX3 = X3((Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    _Parcel.b(parcel2, bundleX3, 1);
                    return true;
                case 6:
                    boolean zO5 = o5(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zO5 ? 1 : 0);
                    return true;
                case 7:
                    boolean zOa2 = Oa(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Uri) _Parcel.a(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zOa2 ? 1 : 0);
                    return true;
                case 8:
                    int iG9 = G9(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), parcel.readString(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iG9);
                    return true;
                case 9:
                    boolean zC2 = C2(parcel.readInt(), (Uri) _Parcel.a(parcel, Uri.CREATOR), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), ICustomTabsCallback.Stub.g(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                case 10:
                    boolean zN4 = N4(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zN4 ? 1 : 0);
                    return true;
                case 11:
                    boolean zJ4 = J4(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Uri) _Parcel.a(parcel, Uri.CREATOR), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zJ4 ? 1 : 0);
                    return true;
                case 12:
                    ICustomTabsCallback iCustomTabsCallbackG2 = ICustomTabsCallback.Stub.g(parcel.readStrongBinder());
                    boolean zD3 = D3(parcel.readInt(), (Uri) _Parcel.a(parcel, Uri.CREATOR), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), iCustomTabsCallbackG2);
                    parcel2.writeNoException();
                    parcel2.writeInt(zD3 ? 1 : 0);
                    return true;
                case 13:
                    Gb(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 14:
                    b5(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    public static class _Parcel {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Parcelable parcelable, int i2) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i2);
            }
        }
    }

    boolean C2(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback);

    boolean D3(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback);

    int G9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);

    void Gb(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean J4(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle);

    boolean N4(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean Oa(ICustomTabsCallback iCustomTabsCallback, Uri uri);

    boolean U8(long j2);

    Bundle X3(Bundle bundle, String str);

    boolean Z9(ICustomTabsCallback iCustomTabsCallback);

    void b5(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle);

    boolean o5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean oa(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, ArrayList arrayList);
}
