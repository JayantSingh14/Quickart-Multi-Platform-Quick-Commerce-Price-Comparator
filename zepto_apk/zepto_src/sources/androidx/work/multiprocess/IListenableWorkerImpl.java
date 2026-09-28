package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IListenableWorkerImpl extends IInterface {
    public static final String j0 = "androidx$work$multiprocess$IListenableWorkerImpl".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IListenableWorkerImpl {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {

        public static class Proxy implements IListenableWorkerImpl {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, IListenableWorkerImpl.j0);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IListenableWorkerImpl.j0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 1) {
                parcel.createByteArray();
                IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                L3();
                return true;
            }
            if (i2 != 2) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.createByteArray();
            IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
            u6();
            return true;
        }
    }

    void L3();

    void u6();
}
