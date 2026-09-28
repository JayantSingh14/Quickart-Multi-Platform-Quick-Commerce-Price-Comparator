package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaLibraryService;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public interface IMediaController extends IInterface {

    public static abstract class Stub extends Binder implements IMediaController {

        public static class Proxy implements IMediaController {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f9936a;

            @Override // androidx.media3.session.IMediaController
            public final void Ab(int i2, String str, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(4001, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void D() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(0);
                    this.f9936a.transact(3006, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void I6(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(3002, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void N8(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(3009, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void S0(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    this.f9936a.transact(3011, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void T8(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(3008, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void X2(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(3001, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9936a;
            }

            @Override // androidx.media3.session.IMediaController
            public final void j9(int i2, Bundle bundle, Bundle bundle2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    _Parcel.b(parcelObtain, bundle2);
                    this.f9936a.transact(3013, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void ub(int i2, Bundle bundle, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9936a.transact(3007, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public final void y4(int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9936a.transact(3003, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.media3.session.IMediaController");
        }

        public static IMediaController g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaController");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaController)) {
                return (IMediaController) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.f9936a = iBinder;
            return proxy;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            MediaLibraryService.LibraryParams libraryParamsA;
            SessionToken sessionToken;
            int i4 = 0;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("androidx.media3.session.IMediaController");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("androidx.media3.session.IMediaController");
                return true;
            }
            if (i2 == 4001) {
                ((MediaControllerStub) this).Ab(parcel.readInt(), parcel.readString(), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                return true;
            }
            if (i2 != 4002) {
                switch (i2) {
                    case 3001:
                        ((MediaControllerStub) this).X2(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                        return true;
                    case 3002:
                        ((MediaControllerStub) this).I6(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                        return true;
                    case 3003:
                        ((MediaControllerStub) this).y4(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                        return true;
                    case 3004:
                        int i5 = parcel.readInt();
                        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Bundle.CREATOR);
                        MediaControllerStub mediaControllerStub = (MediaControllerStub) this;
                        if (arrayListCreateTypedArrayList != null) {
                            try {
                                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) mediaControllerStub.f10022a.get();
                                int iD = (mediaControllerImplBase == null || (sessionToken = mediaControllerImplBase.f9981l) == null) ? -1 : sessionToken.f10269a.d();
                                if (iD != -1) {
                                    UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                                    ImmutableList.Builder builder = new ImmutableList.Builder();
                                    while (i4 < arrayListCreateTypedArrayList.size()) {
                                        Bundle bundle = (Bundle) arrayListCreateTypedArrayList.get(i4);
                                        bundle.getClass();
                                        builder.h(CommandButton.b(iD, bundle));
                                        i4++;
                                    }
                                    mediaControllerStub.z0(new i1(i5, builder.j()));
                                    break;
                                } else {
                                    break;
                                }
                            } catch (RuntimeException e2) {
                                Log.i("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", e2);
                                break;
                            }
                        }
                        break;
                    case 3005:
                        int i6 = parcel.readInt();
                        Parcelable.Creator creator = Bundle.CREATOR;
                        Bundle bundle2 = (Bundle) _Parcel.a(parcel, creator);
                        Bundle bundle3 = (Bundle) _Parcel.a(parcel, creator);
                        MediaControllerStub mediaControllerStub2 = (MediaControllerStub) this;
                        if (bundle2 != null && bundle3 != null) {
                            try {
                                mediaControllerStub2.z0(new r0(i6, SessionCommand.a(bundle2), bundle3));
                                break;
                            } catch (RuntimeException e3) {
                                Log.i("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", e3);
                                break;
                            }
                        } else {
                            Log.h("MediaControllerStub", "Ignoring custom command with null args.");
                            break;
                        }
                    case 3006:
                        parcel.readInt();
                        ((MediaControllerStub) this).D();
                        return true;
                    case 3007:
                        ((MediaControllerStub) this).ub(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                        return true;
                    case 3008:
                        ((MediaControllerStub) this).T8(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                        return true;
                    case 3009:
                        ((MediaControllerStub) this).N8(parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                        return true;
                    case 3010:
                        parcel.readInt();
                        Parcelable.Creator creator2 = Bundle.CREATOR;
                        Bundle bundle4 = (Bundle) _Parcel.a(parcel, creator2);
                        Bundle bundle5 = (Bundle) _Parcel.a(parcel, creator2);
                        MediaControllerStub mediaControllerStub3 = (MediaControllerStub) this;
                        if (bundle4 != null && bundle5 != null) {
                            try {
                                try {
                                    mediaControllerStub3.z0(new s(7, SessionCommands.a(bundle4), Player.Commands.b(bundle5)));
                                    break;
                                } catch (RuntimeException e4) {
                                    Log.i("MediaControllerStub", "Ignoring malformed Bundle for Commands", e4);
                                    break;
                                }
                            } catch (RuntimeException e5) {
                                Log.i("MediaControllerStub", "Ignoring malformed Bundle for SessionCommands", e5);
                                break;
                            }
                        }
                        break;
                    case 3011:
                        ((MediaControllerStub) this).S0(parcel.readInt());
                        return true;
                    case 3012:
                        parcel.readInt();
                        Bundle bundle6 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                        MediaControllerStub mediaControllerStub4 = (MediaControllerStub) this;
                        if (bundle6 == null) {
                            Log.h("MediaControllerStub", "Ignoring null Bundle for extras");
                            return true;
                        }
                        mediaControllerStub4.z0(new o0(bundle6, 4));
                        return true;
                    case 3013:
                        int i7 = parcel.readInt();
                        Parcelable.Creator creator3 = Bundle.CREATOR;
                        ((MediaControllerStub) this).j9(i7, (Bundle) _Parcel.a(parcel, creator3), (Bundle) _Parcel.a(parcel, creator3));
                        return true;
                    case 3014:
                        int i8 = parcel.readInt();
                        PendingIntent pendingIntent = (PendingIntent) _Parcel.a(parcel, PendingIntent.CREATOR);
                        MediaControllerStub mediaControllerStub5 = (MediaControllerStub) this;
                        if (pendingIntent == null) {
                            Log.h("MediaControllerStub", "Ignoring null session activity intent");
                            return true;
                        }
                        mediaControllerStub5.z0(new o0(i8, 3, pendingIntent));
                        return true;
                    case 3015:
                        try {
                            ((MediaControllerStub) this).z0(new o0(parcel.readInt(), i4, SessionError.a((Bundle) _Parcel.a(parcel, Bundle.CREATOR))));
                            break;
                        } catch (RuntimeException e6) {
                            Log.i("MediaControllerStub", "Ignoring malformed Bundle for SessionError", e6);
                            break;
                        }
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            } else {
                parcel.readInt();
                String string = parcel.readString();
                int i9 = parcel.readInt();
                Bundle bundle7 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                MediaControllerStub mediaControllerStub6 = (MediaControllerStub) this;
                if (TextUtils.isEmpty(string)) {
                    Log.h("MediaControllerStub", "onSearchResultChanged(): Ignoring empty query");
                } else if (i9 < 0) {
                    android.support.v4.media.a.r(i9, "onSearchResultChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
                } else {
                    if (bundle7 == null) {
                        libraryParamsA = null;
                    } else {
                        try {
                            libraryParamsA = MediaLibraryService.LibraryParams.a(bundle7);
                        } catch (RuntimeException e7) {
                            Log.i("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e7);
                        }
                    }
                    mediaControllerStub6.z0(new p0(string, i9, libraryParamsA, i4));
                }
            }
            return true;
        }
    }

    public static class _Parcel {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Bundle bundle) {
            if (bundle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            }
        }
    }

    void Ab(int i2, String str, int i3, Bundle bundle);

    void D();

    void I6(int i2, Bundle bundle);

    void N8(int i2, Bundle bundle);

    void S0(int i2);

    void T8(int i2, Bundle bundle);

    void X2(int i2, Bundle bundle);

    void j9(int i2, Bundle bundle, Bundle bundle2);

    void ub(int i2, Bundle bundle, boolean z);

    void y4(int i2, Bundle bundle);

    public static class Default implements IMediaController {
        @Override // androidx.media3.session.IMediaController
        public final void Ab(int i2, String str, int i3, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void I6(int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void N8(int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void S0(int i2) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void T8(int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void X2(int i2, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaController
        public final void j9(int i2, Bundle bundle, Bundle bundle2) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void ub(int i2, Bundle bundle, boolean z) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void y4(int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaController
        public final void D() {
        }
    }
}
