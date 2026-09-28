package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface ICustomTabsCallback extends IInterface {
    public static final String N = "android$support$customtabs$ICustomTabsCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static abstract class Stub extends Binder implements ICustomTabsCallback {

        public static class Proxy implements ICustomTabsCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f15a;

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void B9(int i2, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void C6(Bundle bundle, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeString(str);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void Ca(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void X6(Bundle bundle, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeString(str);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void a9(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(11, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15a;
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final Bundle f6(Bundle bundle, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeString(str);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.a(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void j5(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void l2(int i2, int i3, int i4, int i5, int i6, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void p9(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void sb(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void yb(int i2, Uri uri, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.N);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, uri, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.b(parcelObtain, bundle, 0);
                    this.f15a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICustomTabsCallback.N);
        }

        public static ICustomTabsCallback g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICustomTabsCallback.N);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICustomTabsCallback)) {
                return (ICustomTabsCallback) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f15a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = ICustomTabsCallback.N;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i2) {
                case 2:
                    Ca(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    C6((Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readString());
                    return true;
                case 4:
                    sb((Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    X6((Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    yb(parcel.readInt(), (Uri) _Parcel.a(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle bundleF6 = f6((Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    _Parcel.b(parcel2, bundleF6, 1);
                    return true;
                case 8:
                    B9(parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 9:
                    j5((Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 10:
                    l2(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 11:
                    a9((Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 12:
                    p9((Bundle) _Parcel.a(parcel, Bundle.CREATOR));
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

    void B9(int i2, int i3, Bundle bundle);

    void C6(Bundle bundle, String str);

    void Ca(int i2, Bundle bundle);

    void X6(Bundle bundle, String str);

    void a9(Bundle bundle);

    Bundle f6(Bundle bundle, String str);

    void j5(Bundle bundle);

    void l2(int i2, int i3, int i4, int i5, int i6, Bundle bundle);

    void p9(Bundle bundle);

    void sb(Bundle bundle);

    void yb(int i2, Uri uri, boolean z, Bundle bundle);

    public static class Default implements ICustomTabsCallback {
        @Override // android.support.customtabs.ICustomTabsCallback
        public final void B9(int i2, int i3, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void Ca(int i2, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void a9(Bundle bundle) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final Bundle f6(Bundle bundle, String str) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void j5(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void l2(int i2, int i3, int i4, int i5, int i6, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void p9(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void sb(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void yb(int i2, Uri uri, boolean z, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void C6(Bundle bundle, String str) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void X6(Bundle bundle, String str) {
        }
    }
}
