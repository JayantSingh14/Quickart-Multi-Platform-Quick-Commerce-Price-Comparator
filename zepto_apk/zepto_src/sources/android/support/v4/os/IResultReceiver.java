package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.os.ResultReceiver;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IResultReceiver extends IInterface {
    public static final String W = "android$support$v4$os$IResultReceiver".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IResultReceiver {
        @Override // android.support.v4.os.IResultReceiver
        public final void K6(int i2, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f113a = 0;

        public static class Proxy implements IResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f114a;

            @Override // android.support.v4.os.IResultReceiver
            public final void K6(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IResultReceiver.W);
                    parcelObtain.writeInt(i2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f114a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f114a;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.W);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IResultReceiver.W;
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
            ((ResultReceiver.MyResultReceiver) this).K6(parcel.readInt(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            return true;
        }
    }

    public static class _Parcel {
    }

    void K6(int i2, Bundle bundle);
}
