package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface INotificationSideChannel extends IInterface {
    public static final String U = "android$support$v4$app$INotificationSideChannel".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements INotificationSideChannel {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void b8(String str) {
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void g3(int i2, String str, String str2) {
            throw null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void wb(String str, int i2, String str2, Notification notification) {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {

        public static class Proxy implements INotificationSideChannel {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f20a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f20a;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void b8(String str) {
                throw null;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void g3(int i2, String str, String str2) {
                throw null;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void wb(String str, int i2, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotificationSideChannel.U);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(null);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f20a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INotificationSideChannel.U);
        }

        public static INotificationSideChannel g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(INotificationSideChannel.U);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof INotificationSideChannel)) {
                return (INotificationSideChannel) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f20a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = INotificationSideChannel.U;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 1) {
                wb(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) (parcel.readInt() != 0 ? Notification.CREATOR.createFromParcel(parcel) : null));
                throw null;
            }
            if (i2 == 2) {
                g3(parcel.readInt(), parcel.readString(), parcel.readString());
                throw null;
            }
            if (i2 != 3) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            b8(parcel.readString());
            throw null;
        }
    }

    public static class _Parcel {
    }

    void b8(String str);

    void g3(int i2, String str, String str2);

    void wb(String str, int i2, String str2, Notification notification);
}
