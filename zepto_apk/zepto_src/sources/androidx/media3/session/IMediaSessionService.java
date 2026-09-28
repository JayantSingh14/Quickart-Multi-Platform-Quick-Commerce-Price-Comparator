package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaSessionService;

/* loaded from: classes3.dex */
public interface IMediaSessionService extends IInterface {

    public static class Default implements IMediaSessionService {
        @Override // androidx.media3.session.IMediaSessionService
        public final void G7(IMediaController iMediaController, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IMediaSessionService {

        public static class Proxy implements IMediaSessionService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f9939a;

            @Override // androidx.media3.session.IMediaSessionService
            public final void G7(IMediaController iMediaController, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSessionService");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    this.f9939a.transact(3001, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9939a;
            }
        }

        public Stub() {
            attachInterface(this, "androidx.media3.session.IMediaSessionService");
        }

        public static IMediaSessionService g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSessionService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSessionService)) {
                return (IMediaSessionService) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f9939a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("androidx.media3.session.IMediaSessionService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("androidx.media3.session.IMediaSessionService");
                return true;
            }
            if (i2 != 3001) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            ((MediaSessionService.MediaSessionServiceStub) this).G7(IMediaController.Stub.g(parcel.readStrongBinder()), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            return true;
        }
    }

    public static class _Parcel {
    }

    void G7(IMediaController iMediaController, Bundle bundle);
}
