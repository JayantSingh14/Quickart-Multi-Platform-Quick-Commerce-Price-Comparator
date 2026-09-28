package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IWorkManagerImplCallback extends IInterface {
    public static final String l0 = "androidx$work$multiprocess$IWorkManagerImplCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IWorkManagerImplCallback {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {

        public static class Proxy implements IWorkManagerImplCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f13073a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f13073a;
            }
        }

        public Stub() {
            attachInterface(this, IWorkManagerImplCallback.l0);
        }

        public static IWorkManagerImplCallback g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWorkManagerImplCallback.l0);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWorkManagerImplCallback)) {
                return (IWorkManagerImplCallback) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f13073a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IWorkManagerImplCallback.l0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 1) {
                parcel.createByteArray();
                onSuccess();
                return true;
            }
            if (i2 != 2) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.readString();
            A2();
            return true;
        }
    }

    void A2();

    void onSuccess();
}
