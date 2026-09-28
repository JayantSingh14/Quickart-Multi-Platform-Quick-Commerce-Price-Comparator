package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String h0 = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public final void q2(String[] strArr) {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {

        public static class Proxy implements IMultiInstanceInvalidationCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f11757a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f11757a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public final void q2(String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationCallback.h0);
                    parcelObtain.writeStringArray(strArr);
                    this.f11757a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.h0);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IMultiInstanceInvalidationCallback.h0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            ((MultiInstanceInvalidationClient$callback$1) this).q2(parcel.createStringArray());
            return true;
        }
    }

    void q2(String[] strArr);
}
