package androidx.media3.session.legacy;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.util.List;
import org.xbill.DNS.Type;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public interface IMediaSession extends IInterface {

    public static abstract class Stub extends Binder implements IMediaSession {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f10431a = 0;

        public static class Proxy implements IMediaSession {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f10432a;

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void C(float f2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void D9(IMediaControllerCallback iMediaControllerCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder(iMediaControllerCallback.asBinder());
                    if (!this.f10432a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void E() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(13, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int E0() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(47, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final long F() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(9, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean F0() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(45, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int G() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(37, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void G8(int i2, int i3) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void I0() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(23, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Mb(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void N1(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void P1(Uri uri, Bundle bundle) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Rb(IMediaControllerCallback iMediaControllerCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder((IMediaControllerCallback.Stub) iMediaControllerCallback);
                    if (!this.f10432a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void T6(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final String V() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(6, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final CharSequence V0() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(30, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void X(long j2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Xa(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void Y5(long j2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a1() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(22, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a2(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void a8(int i2, int i3) {
                throw null;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f10432a;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void ca(MediaDescriptionCompat mediaDescriptionCompat) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d0(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void d3(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final Bundle getExtras() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(31, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final MediaMetadataCompat getMetadata() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(27, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final int l0() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(32, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final List m1() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(29, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void next() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(20, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final ParcelableVolumeInfo o1() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(10, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void o6(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void p() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(33, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final boolean p4(KeyEvent keyEvent) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void pause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(18, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void previous() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(21, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void s5(Bundle bundle, String str) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void stop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(19, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final PlaybackStateCompat u() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.f10432a.transact(28, parcelObtain, parcelObtain2, 0)) {
                        int i2 = Stub.f10431a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public final void w3(Uri uri, Bundle bundle) {
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
            proxy.f10432a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.getClass();
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            IMediaControllerCallback iMediaControllerCallback = null;
            IMediaControllerCallback iMediaControllerCallback2 = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    T6(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    boolean zP4 = p4(parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(zP4 ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    IBinder strongBinder = parcel.readStrongBinder();
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaControllerCallback)) {
                            IMediaControllerCallback.Stub.Proxy proxy = new IMediaControllerCallback.Stub.Proxy();
                            proxy.f10430a = strongBinder;
                            iMediaControllerCallback2 = proxy;
                        } else {
                            iMediaControllerCallback2 = (IMediaControllerCallback) iInterfaceQueryLocalInterface;
                        }
                    }
                    Rb(iMediaControllerCallback2);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMediaControllerCallback)) {
                            IMediaControllerCallback.Stub.Proxy proxy2 = new IMediaControllerCallback.Stub.Proxy();
                            proxy2.f10430a = strongBinder2;
                            iMediaControllerCallback = proxy2;
                        } else {
                            iMediaControllerCallback = (IMediaControllerCallback) iInterfaceQueryLocalInterface2;
                        }
                    }
                    D9(iMediaControllerCallback);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    boolean zT0 = T0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(zT0 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    String strV = V();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeString(strV);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    String strZ = z();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeString(strZ);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PendingIntent pendingIntentK0 = k0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (pendingIntentK0 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    pendingIntentK0.writeToParcel(parcel2, 1);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    long jF = F();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeLong(jF);
                    return true;
                case 10:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    ParcelableVolumeInfo parcelableVolumeInfoO1 = o1();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (parcelableVolumeInfoO1 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    parcelableVolumeInfoO1.writeToParcel(parcel2, 1);
                    return true;
                case 11:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    int i4 = parcel.readInt();
                    int i5 = parcel.readInt();
                    parcel.readString();
                    a8(i4, i5);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    int i6 = parcel.readInt();
                    int i7 = parcel.readInt();
                    parcel.readString();
                    G8(i6, i7);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    E();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    d3(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Xa(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    w3(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Y5(parcel.readLong());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    pause();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    stop();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    next();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    previous();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    a1();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    I0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    X(parcel.readLong());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    i7(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    N1(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaMetadataCompat metadata = getMetadata();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (metadata == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    parcel2.writeBundle(metadata.f10606a);
                    return true;
                case 28:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    PlaybackStateCompat playbackStateCompatU = u();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (playbackStateCompatU == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    playbackStateCompatU.writeToParcel(parcel2, 1);
                    return true;
                case 29:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    List listM1 = m1();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listM1);
                    return true;
                case 30:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    CharSequence charSequenceV0 = V0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (charSequenceV0 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    TextUtils.writeToParcel(charSequenceV0, parcel2, 1);
                    return true;
                case 31:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Bundle extras = getExtras();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (extras == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    extras.writeToParcel(parcel2, 1);
                    return true;
                case 32:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    int iL0 = l0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(iL0);
                    return true;
                case 33:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    p();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    s5(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Mb(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    P1(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    int iG = G();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(iG);
                    return true;
                case Type.A6 /* 38 */:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 39:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    d0(parcel.readInt());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    parcel.readInt();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    e9(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    a2(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    ca(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    V4(parcel.readInt());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    boolean zF0 = F0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(zF0 ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    N9(parcel.readInt() != 0);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    int iE0 = E0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    parcel2.writeInt(iE0);
                    return true;
                case Type.DNSKEY /* 48 */:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    o6(parcel.readInt());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    C(parcel.readFloat());
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Bundle bundleR0 = r0();
                    parcel2.getClass();
                    parcel2.writeNoException();
                    if (bundleR0 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    bundleR0.writeToParcel(parcel2, 1);
                    return true;
                case 51:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    x7(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.getClass();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void C(float f2);

    void D9(IMediaControllerCallback iMediaControllerCallback);

    void E();

    int E0();

    long F();

    boolean F0();

    int G();

    void G8(int i2, int i3);

    void I0();

    void Mb(Bundle bundle, String str);

    void N1(Bundle bundle, String str);

    void N9(boolean z);

    void P1(Uri uri, Bundle bundle);

    void Rb(IMediaControllerCallback iMediaControllerCallback);

    boolean T0();

    void T6(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper);

    String V();

    CharSequence V0();

    void V4(int i2);

    void X(long j2);

    void Xa(Bundle bundle, String str);

    void Y5(long j2);

    void a1();

    void a2(MediaDescriptionCompat mediaDescriptionCompat, int i2);

    void a8(int i2, int i3);

    void ca(MediaDescriptionCompat mediaDescriptionCompat);

    void d0(int i2);

    void d3(Bundle bundle, String str);

    void e9(MediaDescriptionCompat mediaDescriptionCompat);

    Bundle getExtras();

    MediaMetadataCompat getMetadata();

    void i7(RatingCompat ratingCompat);

    PendingIntent k0();

    int l0();

    List m1();

    void next();

    ParcelableVolumeInfo o1();

    void o6(int i2);

    void p();

    boolean p4(KeyEvent keyEvent);

    void pause();

    void previous();

    Bundle r0();

    void s5(Bundle bundle, String str);

    void stop();

    PlaybackStateCompat u();

    void w3(Uri uri, Bundle bundle);

    void x7(RatingCompat ratingCompat, Bundle bundle);

    String z();
}
