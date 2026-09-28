package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import androidx.annotation.RestrictTo;
import java.util.List;
import org.xbill.DNS.Type;

@RestrictTo
/* loaded from: classes3.dex */
public interface IMediaSession extends IInterface {

    public static class Default implements IMediaSession {
        @Override // android.support.v4.media.session.IMediaSession
        public final void W6(IMediaControllerCallback iMediaControllerCallback) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.media.session.IMediaSession
        public final boolean wa() {
            throw null;
        }
    }

    public static abstract class Stub extends Binder implements IMediaSession {

        public static class Proxy implements IMediaSession {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f72a;

            @Override // android.support.v4.media.session.IMediaSession
            public final void W6(IMediaControllerCallback iMediaControllerCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaControllerCallback);
                    this.f72a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f72a;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final boolean wa() {
                throw null;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        public static IMediaSession g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f72a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            IInterface iInterfaceQueryLocalInterface;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            IMediaControllerCallback iMediaControllerCallback = null;
            switch (i2) {
                case 1:
                    parcel.readString();
                    s1();
                    throw null;
                case 2:
                    wa();
                    throw null;
                case 3:
                    IBinder strongBinder = parcel.readStrongBinder();
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMediaControllerCallback)) {
                            IMediaControllerCallback.Stub.Proxy proxy = new IMediaControllerCallback.Stub.Proxy();
                            proxy.f71a = strongBinder;
                            iMediaControllerCallback = proxy;
                        } else {
                            iMediaControllerCallback = (IMediaControllerCallback) iInterfaceQueryLocalInterface2;
                        }
                    }
                    W6(iMediaControllerCallback);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null && (iInterfaceQueryLocalInterface = strongBinder2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback")) != null && (iInterfaceQueryLocalInterface instanceof IMediaControllerCallback)) {
                    }
                    u3();
                    throw null;
                case 5:
                    boolean zT0 = T0();
                    parcel2.writeNoException();
                    parcel2.writeInt(zT0 ? 1 : 0);
                    return true;
                case 6:
                    String strV = V();
                    parcel2.writeNoException();
                    parcel2.writeString(strV);
                    return true;
                case 7:
                    String strZ = z();
                    parcel2.writeNoException();
                    parcel2.writeString(strZ);
                    return true;
                case 8:
                    k0();
                    throw null;
                case 9:
                    F();
                    throw null;
                case 10:
                    o1();
                    throw null;
                case 11:
                    parcel.readInt();
                    parcel.readInt();
                    parcel.readString();
                    c4();
                    throw null;
                case 12:
                    parcel.readInt();
                    parcel.readInt();
                    parcel.readString();
                    I4();
                    throw null;
                case 13:
                    E();
                    throw null;
                case 14:
                    parcel.readString();
                    M2();
                    throw null;
                case 15:
                    parcel.readString();
                    t1();
                    throw null;
                case 16:
                    z5();
                    throw null;
                case 17:
                    parcel.readLong();
                    P3();
                    throw null;
                case 18:
                    pause();
                    throw null;
                case 19:
                    stop();
                    throw null;
                case 20:
                    next();
                    throw null;
                case 21:
                    previous();
                    throw null;
                case 22:
                    a1();
                    throw null;
                case 23:
                    I0();
                    throw null;
                case 24:
                    parcel.readLong();
                    O5();
                    throw null;
                case 25:
                    r9();
                    throw null;
                case 26:
                    parcel.readString();
                    U5();
                    throw null;
                case 27:
                    getMetadata();
                    throw null;
                case 28:
                    u();
                    throw null;
                case 29:
                    List listM1 = m1();
                    parcel2.writeNoException();
                    if (listM1 == null) {
                        parcel2.writeInt(-1);
                        return true;
                    }
                    int size = listM1.size();
                    parcel2.writeInt(size);
                    for (int i4 = 0; i4 < size; i4++) {
                        Parcelable parcelable = (Parcelable) listM1.get(i4);
                        if (parcelable != null) {
                            parcel2.writeInt(1);
                            parcelable.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                    }
                    return true;
                case 30:
                    V0();
                    throw null;
                case 31:
                    getExtras();
                    throw null;
                case 32:
                    l0();
                    throw null;
                case 33:
                    p();
                    throw null;
                case 34:
                    parcel.readString();
                    U3();
                    throw null;
                case 35:
                    parcel.readString();
                    k5();
                    throw null;
                case 36:
                    k4();
                    throw null;
                case 37:
                    G();
                    throw null;
                case Type.A6 /* 38 */:
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 39:
                    parcel.readInt();
                    V8();
                    throw null;
                case 40:
                    parcel.readInt();
                    parcel2.writeNoException();
                    return true;
                case 41:
                    s7();
                    throw null;
                case 42:
                    parcel.readInt();
                    E1();
                    throw null;
                case 43:
                    Q8();
                    throw null;
                case 44:
                    parcel.readInt();
                    B2();
                    throw null;
                case 45:
                    F0();
                    throw null;
                case 46:
                    parcel.readInt();
                    x2();
                    throw null;
                case 47:
                    E0();
                    throw null;
                case Type.DNSKEY /* 48 */:
                    parcel.readInt();
                    K8();
                    throw null;
                case 49:
                    parcel.readFloat();
                    w7();
                    throw null;
                case 50:
                    r0();
                    throw null;
                case 51:
                    vb();
                    throw null;
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

    void B2();

    void E();

    int E0();

    void E1();

    long F();

    boolean F0();

    int G();

    void I0();

    void I4();

    void K8();

    void M2();

    void O5();

    void P3();

    void Q8();

    boolean T0();

    void U3();

    void U5();

    String V();

    CharSequence V0();

    void V8();

    void W6(IMediaControllerCallback iMediaControllerCallback);

    void a1();

    void c4();

    Bundle getExtras();

    MediaMetadataCompat getMetadata();

    PendingIntent k0();

    void k4();

    void k5();

    int l0();

    List m1();

    void next();

    ParcelableVolumeInfo o1();

    void p();

    void pause();

    void previous();

    Bundle r0();

    void r9();

    void s1();

    void s7();

    void stop();

    void t1();

    PlaybackStateCompat u();

    void u3();

    void vb();

    void w7();

    boolean wa();

    void x2();

    String z();

    void z5();
}
