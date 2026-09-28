package android.support.customtabs;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IEngagementSignalsCallback extends IInterface {
    public static final String P = "android$support$customtabs$IEngagementSignalsCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IEngagementSignalsCallback {
        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void Pb() {
            throw null;
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void S5() {
            throw null;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void o7() {
            throw null;
        }
    }

    public static abstract class Stub extends Binder implements IEngagementSignalsCallback {

        public static class Proxy implements IEngagementSignalsCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f17a;

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public final void Pb() {
                throw null;
            }

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public final void S5() {
                throw null;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f17a;
            }

            @Override // android.support.customtabs.IEngagementSignalsCallback
            public final void o7() {
                throw null;
            }
        }

        public Stub() {
            attachInterface(this, IEngagementSignalsCallback.P);
        }

        public static IEngagementSignalsCallback g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IEngagementSignalsCallback.P);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IEngagementSignalsCallback)) {
                return (IEngagementSignalsCallback) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f17a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IEngagementSignalsCallback.P;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 2) {
                parcel.readInt();
                S5();
                throw null;
            }
            if (i2 == 3) {
                parcel.readInt();
                o7();
                throw null;
            }
            if (i2 != 4) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.readInt();
            Pb();
            throw null;
        }
    }

    public static class _Parcel {
    }

    void Pb();

    void S5();

    void o7();
}
