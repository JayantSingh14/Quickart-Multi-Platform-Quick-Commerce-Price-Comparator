package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public interface IMediaControllerCallback extends IInterface {

    public static class Default implements IMediaControllerCallback {
        @Override // android.support.v4.media.session.IMediaControllerCallback
        public final void A0() {
            throw null;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        public static class Proxy implements IMediaControllerCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f71a;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public final void A0() {
                throw null;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f71a;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.readString();
                    return true;
                case 2:
                    A0();
                    return true;
                case 3:
                    return true;
                case 4:
                    kb();
                    return true;
                case 5:
                    parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                    Ja();
                    return true;
                case 6:
                    k2();
                    return true;
                case 7:
                    C3();
                    return true;
                case 8:
                    M6((ParcelableVolumeInfo) _Parcel.a(parcel, ParcelableVolumeInfo.CREATOR));
                    return true;
                case 9:
                    parcel.readInt();
                    return true;
                case 10:
                    parcel.readInt();
                    return true;
                case 11:
                    parcel.readInt();
                    return true;
                case 12:
                    parcel.readInt();
                    return true;
                case 13:
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    public static class _Parcel {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void A0();

    void C3();

    void Ja();

    void M6(ParcelableVolumeInfo parcelableVolumeInfo);

    void k2();

    void kb();
}
