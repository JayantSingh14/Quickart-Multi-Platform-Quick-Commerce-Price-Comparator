package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface ITrustedWebActivityCallback extends IInterface {
    public static final String S = "android$support$customtabs$trusted$ITrustedWebActivityCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements ITrustedWebActivityCallback {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {

        public static class Proxy implements ITrustedWebActivityCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f19a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f19a;
            }
        }

        public Stub() {
            attachInterface(this, ITrustedWebActivityCallback.S);
        }

        public static ITrustedWebActivityCallback g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITrustedWebActivityCallback.S);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ITrustedWebActivityCallback)) {
                return (ITrustedWebActivityCallback) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f19a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = ITrustedWebActivityCallback.S;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 != 2) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.readString();
            f7();
            throw null;
        }
    }

    public static class _Parcel {
    }

    void f7();
}
