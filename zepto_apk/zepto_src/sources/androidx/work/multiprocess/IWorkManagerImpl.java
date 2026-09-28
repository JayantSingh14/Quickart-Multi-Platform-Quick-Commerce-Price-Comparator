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
public interface IWorkManagerImpl extends IInterface {
    public static final String k0 = "androidx$work$multiprocess$IWorkManagerImpl".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IWorkManagerImpl {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {

        public static class Proxy implements IWorkManagerImpl {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, IWorkManagerImpl.k0);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IWorkManagerImpl.k0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    H7();
                    return true;
                case 2:
                    parcel.readString();
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    B3();
                    return true;
                case 3:
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    Q9();
                    return true;
                case 4:
                    parcel.readString();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    h5();
                    return true;
                case 5:
                    parcel.readString();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    O1();
                    return true;
                case 6:
                    parcel.readString();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    I1();
                    return true;
                case 7:
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    g9();
                    return true;
                case 8:
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    v3();
                    return true;
                case 9:
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    X1();
                    return true;
                case 10:
                    parcel.createByteArray();
                    IWorkManagerImplCallback.Stub.g(parcel.readStrongBinder());
                    t4();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void B3();

    void H7();

    void I1();

    void O1();

    void Q9();

    void X1();

    void g9();

    void h5();

    void t4();

    void v3();
}
