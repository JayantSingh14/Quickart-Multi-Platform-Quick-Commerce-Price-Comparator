package androidx.media3.session.legacy;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.MediaControllerCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.util.List;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f10429a = 0;

        public static class Proxy implements IMediaControllerCallback {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f10430a;

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void A0() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (!this.f10430a.transact(2, parcelObtain, null, 1)) {
                        int i2 = Stub.f10429a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void G4(MediaMetadataCompat mediaMetadataCompat) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        parcelObtain.writeInt(1);
                        parcelObtain.writeBundle(mediaMetadataCompat.f10606a);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10430a.transact(4, parcelObtain, null, 1)) {
                        int i2 = Stub.f10429a;
                    }
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void T2(List list) {
                throw null;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f10430a;
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void d1(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcelObtain.writeInt(i2);
                    if (!this.f10430a.transact(9, parcelObtain, null, 1)) {
                        int i3 = Stub.f10429a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void d6(ParcelableVolumeInfo parcelableVolumeInfo) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcelObtain.writeInt(1);
                    parcelableVolumeInfo.writeToParcel(parcelObtain, 0);
                    if (!this.f10430a.transact(8, parcelObtain, null, 1)) {
                        int i2 = Stub.f10429a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void g5(PlaybackStateCompat playbackStateCompat) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        parcelObtain.writeInt(1);
                        playbackStateCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10430a.transact(3, parcelObtain, null, 1)) {
                        int i2 = Stub.f10429a;
                    }
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void m5(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcelObtain.writeInt(i2);
                    if (!this.f10430a.transact(12, parcelObtain, null, 1)) {
                        int i3 = Stub.f10429a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public final void z9(CharSequence charSequence) {
                throw null;
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
            if (i2 == 1598968902) {
                parcel2.getClass();
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    String string = parcel.readString();
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) ((MediaControllerCompat.Callback.StubCompat) this).f10574b.get();
                    if (callback != null) {
                        callback.m(1, string, bundle);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    A0();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    ((MediaControllerCompat.Callback.StubCompat) this).g5(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    G4(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    T2(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    z9(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    O7(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    d6(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    ((MediaControllerCompat.Callback.StubCompat) this).d1(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readInt();
                    return true;
                case 11:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    boolean z = parcel.readInt() != 0;
                    MediaControllerCompat.Callback callback2 = (MediaControllerCompat.Callback) ((MediaControllerCompat.Callback.StubCompat) this).f10574b.get();
                    if (callback2 != null) {
                        callback2.m(11, Boolean.valueOf(z), null);
                        return true;
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    ((MediaControllerCompat.Callback.StubCompat) this).m5(parcel.readInt());
                    return true;
                case 13:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    MediaControllerCompat.Callback callback3 = (MediaControllerCompat.Callback) ((MediaControllerCompat.Callback.StubCompat) this).f10574b.get();
                    if (callback3 != null) {
                        callback3.m(13, null, null);
                        return true;
                    }
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void A0();

    void G4(MediaMetadataCompat mediaMetadataCompat);

    void O7(Bundle bundle);

    void T2(List list);

    void d1(int i2);

    void d6(ParcelableVolumeInfo parcelableVolumeInfo);

    void g5(PlaybackStateCompat playbackStateCompat);

    void m5(int i2);

    void z9(CharSequence charSequence);
}
