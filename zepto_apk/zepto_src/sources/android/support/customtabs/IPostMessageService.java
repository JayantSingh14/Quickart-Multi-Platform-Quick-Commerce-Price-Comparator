package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.customtabs.ICustomTabsCallback;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IPostMessageService extends IInterface {
    public static final String R = "android$support$customtabs$IPostMessageService".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IPostMessageService {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.IPostMessageService
        public final void s3(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            throw null;
        }
    }

    public static abstract class Stub extends Binder implements IPostMessageService {

        public static class Proxy implements IPostMessageService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f18a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f18a;
            }

            @Override // android.support.customtabs.IPostMessageService
            public final void s3(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                throw null;
            }
        }

        public Stub() {
            attachInterface(this, IPostMessageService.R);
        }

        public static IPostMessageService g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPostMessageService.R);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPostMessageService)) {
                return (IPostMessageService) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f18a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IPostMessageService.R;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 2) {
                s3(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 3) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            t9(ICustomTabsCallback.Stub.g(parcel.readStrongBinder()), parcel.readString(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class _Parcel {
    }

    void s3(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    void t9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);
}
