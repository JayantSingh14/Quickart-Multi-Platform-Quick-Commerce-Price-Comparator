package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import androidx.room.IMultiInstanceInvalidationCallback;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    public static final String i0 = "androidx$room$IMultiInstanceInvalidationService".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IMultiInstanceInvalidationService {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public final void m6(int i2, String[] strArr) {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f11758a = 0;

        public static class Proxy implements IMultiInstanceInvalidationService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f11759a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f11759a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public final void m6(int i2, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMultiInstanceInvalidationService.i0);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStringArray(strArr);
                    this.f11759a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationService.i0);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = IMultiInstanceInvalidationService.i0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            IMultiInstanceInvalidationCallback callback = null;
            IMultiInstanceInvalidationCallback callback2 = null;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    ((MultiInstanceInvalidationService$binder$1) this).m6(parcel.readInt(), parcel.createStringArray());
                    return true;
                }
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IMultiInstanceInvalidationCallback.h0);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                        IMultiInstanceInvalidationCallback.Stub.Proxy proxy = new IMultiInstanceInvalidationCallback.Stub.Proxy();
                        proxy.f11757a = strongBinder;
                        callback2 = proxy;
                    } else {
                        callback2 = (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
                    }
                }
                int i4 = parcel.readInt();
                Intrinsics.checkNotNullParameter(callback2, "callback");
                MultiInstanceInvalidationService multiInstanceInvalidationService = ((MultiInstanceInvalidationService$binder$1) this).f11794b;
                synchronized (multiInstanceInvalidationService.f11792c) {
                    multiInstanceInvalidationService.f11792c.unregister(callback2);
                }
                parcel2.writeNoException();
                return true;
            }
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(IMultiInstanceInvalidationCallback.h0);
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMultiInstanceInvalidationCallback)) {
                    IMultiInstanceInvalidationCallback.Stub.Proxy proxy2 = new IMultiInstanceInvalidationCallback.Stub.Proxy();
                    proxy2.f11757a = strongBinder2;
                    callback = proxy2;
                } else {
                    callback = (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface2;
                }
            }
            String string = parcel.readString();
            MultiInstanceInvalidationService$binder$1 multiInstanceInvalidationService$binder$1 = (MultiInstanceInvalidationService$binder$1) this;
            Intrinsics.checkNotNullParameter(callback, "callback");
            int i5 = 0;
            if (string != null) {
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = multiInstanceInvalidationService$binder$1.f11794b;
                synchronized (multiInstanceInvalidationService2.f11792c) {
                    try {
                        int i6 = multiInstanceInvalidationService2.f11790a + 1;
                        multiInstanceInvalidationService2.f11790a = i6;
                        if (multiInstanceInvalidationService2.f11792c.register(callback, Integer.valueOf(i6))) {
                            multiInstanceInvalidationService2.f11791b.put(Integer.valueOf(i6), string);
                            i5 = i6;
                        } else {
                            multiInstanceInvalidationService2.f11790a--;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            parcel2.writeNoException();
            parcel2.writeInt(i5);
            return true;
        }
    }

    void m6(int i2, String[] strArr);
}
