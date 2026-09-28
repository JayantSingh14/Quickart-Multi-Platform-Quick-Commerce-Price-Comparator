package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.PlayerInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
class MediaControllerStub extends IMediaController.Stub {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f10021b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f10022a;

    public interface ControllerTask<T extends MediaControllerImplBase> {
        void a(MediaControllerImplBase mediaControllerImplBase);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase) {
        this.f10022a = new WeakReference(mediaControllerImplBase);
    }

    @Override // androidx.media3.session.IMediaController
    public final void Ab(int i2, String str, int i3, Bundle bundle) {
        MediaLibraryService.LibraryParams libraryParamsA;
        if (TextUtils.isEmpty(str)) {
            Log.h("MediaControllerStub", "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if (i3 < 0) {
            android.support.v4.media.a.r(i3, "onChildrenChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
            return;
        }
        if (bundle == null) {
            libraryParamsA = null;
        } else {
            try {
                libraryParamsA = MediaLibraryService.LibraryParams.a(bundle);
            } catch (RuntimeException e2) {
                Log.i("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        z0(new p0(str, i3, libraryParamsA, 1));
    }

    @Override // androidx.media3.session.IMediaController
    public final void D() {
        z0(new o0(2));
    }

    @Override // androidx.media3.session.IMediaController
    public final void I6(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            j1(i2, SessionResult.a(bundle));
        } catch (RuntimeException e2) {
            Log.i("MediaControllerStub", "Ignoring malformed Bundle for SessionResult", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void N8(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            z0(new q0(Player.Commands.b(bundle)));
        } catch (RuntimeException e2) {
            Log.i("MediaControllerStub", "Ignoring malformed Bundle for Commands", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void S0(int i2) {
        z0(new o0(1));
    }

    @Override // androidx.media3.session.IMediaController
    public final void T8(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            z0(new s0(SessionPositionInfo.b(bundle), 1));
        } catch (RuntimeException e2) {
            Log.i("MediaControllerStub", "Ignoring malformed Bundle for SessionPositionInfo", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void X2(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            z0(new s0(ConnectionState.a(bundle), 0));
        } catch (RuntimeException e2) {
            Log.i("MediaControllerStub", "Malformed Bundle for ConnectionResult. Disconnected from the session.", e2);
            D();
        }
    }

    public final void j1(int i2, Object obj) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10022a.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.f9971b.c(i2, obj);
            mediaControllerImplBase.o().l(new g2(i2, 2, mediaControllerImplBase));
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void j9(int i2, Bundle bundle, Bundle bundle2) {
        SessionToken sessionToken;
        if (bundle == null || bundle2 == null) {
            return;
        }
        try {
            MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10022a.get();
            int iD = (mediaControllerImplBase == null || (sessionToken = mediaControllerImplBase.f9981l) == null) ? -1 : sessionToken.f10269a.d();
            if (iD == -1) {
                return;
            }
            try {
                z0(new s(6, PlayerInfo.h(iD, bundle), new PlayerInfo.BundlingExclusions(bundle2.getBoolean(PlayerInfo.BundlingExclusions.f10195d, false), bundle2.getBoolean(PlayerInfo.BundlingExclusions.f10196e, false))));
            } catch (RuntimeException e2) {
                Log.i("MediaControllerStub", "Ignoring malformed Bundle for BundlingExclusions", e2);
            }
        } catch (RuntimeException e3) {
            Log.i("MediaControllerStub", "Ignoring malformed Bundle for PlayerInfo", e3);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void ub(int i2, Bundle bundle, boolean z) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PlayerInfo.BundlingExclusions.f10195d, z);
        bundle2.putBoolean(PlayerInfo.BundlingExclusions.f10196e, true);
        j9(i2, bundle, bundle2);
    }

    @Override // androidx.media3.session.IMediaController
    public final void y4(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            j1(i2, LibraryResult.a(bundle));
        } catch (RuntimeException e2) {
            Log.i("MediaControllerStub", "Ignoring malformed Bundle for LibraryResult", e2);
        }
    }

    public final void z0(ControllerTask controllerTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10022a.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            Util.X(mediaControllerImplBase.o().f9958e, new l0(1, mediaControllerImplBase, controllerTask));
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
