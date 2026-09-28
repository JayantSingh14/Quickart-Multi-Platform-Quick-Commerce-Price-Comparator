package androidx.media3.session;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    public static final /* synthetic */ int o = 0;

    /* renamed from: m, reason: collision with root package name */
    public final BrowserLegacyCbForBroadcast f10035m;
    public final MediaLibrarySessionImpl n;

    public final class BrowserLegacyCb implements MediaSession.ControllerCb {

        /* renamed from: b, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f10037b;

        /* renamed from: a, reason: collision with root package name */
        public final Object f10036a = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f10038c = new ArrayList();

        public BrowserLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f10037b = remoteUserInfo;
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void c(int i2, String str, MediaLibraryService.LibraryParams libraryParams) {
            Bundle bundle = libraryParams != null ? libraryParams.f10027a : null;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            MediaLibraryServiceLegacyStub.this.d(this.f10037b, str, bundle);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BrowserLegacyCb) {
                return Util.a(this.f10037b, ((BrowserLegacyCb) obj).f10037b);
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.f10037b);
        }
    }

    public final class BrowserLegacyCbForBroadcast implements MediaSession.ControllerCb {
        public BrowserLegacyCbForBroadcast() {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void c(int i2, String str, MediaLibraryService.LibraryParams libraryParams) {
            Bundle bundle;
            MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = MediaLibraryServiceLegacyStub.this;
            if (libraryParams == null || (bundle = libraryParams.f10027a) == null) {
                mediaLibraryServiceLegacyStub.e(str);
            } else {
                int i3 = Util.f5744a;
                mediaLibraryServiceLegacyStub.c(bundle, str);
            }
        }
    }

    public static class SearchRequest {
    }

    public MediaLibraryServiceLegacyStub(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        super(mediaLibrarySessionImpl);
        this.n = mediaLibrarySessionImpl;
        this.f10035m = new BrowserLegacyCbForBroadcast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SettableFuture r(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, LibraryResult libraryResult) {
        Object obj;
        mediaLibraryServiceLegacyStub.getClass();
        Assertions.e(libraryResult, "LibraryResult must not be null");
        SettableFuture settableFuture = new SettableFuture();
        if (libraryResult.f9947a != 0 || (obj = libraryResult.f9949c) == null) {
            settableFuture.n(null);
            return settableFuture;
        }
        ImmutableList immutableList = (ImmutableList) obj;
        if (immutableList.isEmpty()) {
            settableFuture.n(new ArrayList());
            return settableFuture;
        }
        ArrayList arrayList = new ArrayList();
        settableFuture.q(new l0(4, settableFuture, arrayList), MoreExecutors.a());
        c cVar = new c(mediaLibraryServiceLegacyStub, new AtomicInteger(0), immutableList, arrayList, settableFuture, 2);
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            byte[] bArr = ((MediaItem) immutableList.get(i2)).f5260d.f5389k;
            if (bArr == null) {
                arrayList.add(null);
                cVar.run();
            } else {
                ListenableFuture listenableFutureC = mediaLibraryServiceLegacyStub.n.f10103m.c(bArr);
                arrayList.add(listenableFutureC);
                listenableFutureC.q(cVar, MoreExecutors.a());
            }
        }
        return settableFuture;
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void f(Bundle bundle, MediaBrowserServiceCompat.Result result, String str) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            result.e();
        } else {
            result.a();
            Util.X(this.n.f10102l, new w0(this, str, controllerInfoS, result, bundle));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final MediaBrowserServiceCompat.BrowserRoot g(String str, int i2, Bundle bundle) {
        MediaSession.ControllerInfo controllerInfoS;
        LibraryResult libraryResult;
        Object obj;
        Bundle bundle2;
        if (super.g(str, i2, bundle) != null && (controllerInfoS = s()) != null) {
            ConnectedControllersManager connectedControllersManager = this.f10156l;
            if (connectedControllersManager.k(controllerInfoS, 50000)) {
                MediaLibrarySessionImpl mediaLibrarySessionImpl = this.n;
                MediaLibraryService.LibraryParams libraryParamsH = LegacyConversions.h(mediaLibrarySessionImpl.f10096f, bundle);
                AtomicReference atomicReference = new AtomicReference();
                ConditionVariable conditionVariable = new ConditionVariable();
                Util.X(mediaLibrarySessionImpl.f10102l, new c(this, atomicReference, controllerInfoS, libraryParamsH, conditionVariable, 1));
                try {
                    conditionVariable.a();
                    libraryResult = (LibraryResult) ((ListenableFuture) atomicReference.get()).get();
                    Assertions.e(libraryResult, "LibraryResult must not be null");
                } catch (InterruptedException | CancellationException | ExecutionException e2) {
                    Log.e("MLSLegacyStub", "Couldn't get a result from onGetLibraryRoot", e2);
                    libraryResult = null;
                }
                if (libraryResult == null || libraryResult.f9947a != 0 || (obj = libraryResult.f9949c) == null) {
                    if (libraryResult == null || libraryResult.f9947a == 0) {
                        return MediaUtils.f10167a;
                    }
                    return null;
                }
                MediaLibraryService.LibraryParams libraryParams = libraryResult.f9951e;
                if (libraryParams != null) {
                    Bundle bundle3 = libraryParams.f10027a;
                    bundle2 = new Bundle(bundle3);
                    if (bundle3.containsKey("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY")) {
                        boolean z = bundle3.getBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", false);
                        bundle2.remove("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY");
                        bundle2.putInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", z ? 1 : 3);
                    }
                    bundle2.putBoolean("android.service.media.extra.RECENT", libraryParams.f10028b);
                    bundle2.putBoolean("android.service.media.extra.OFFLINE", libraryParams.f10029c);
                    bundle2.putBoolean("android.service.media.extra.SUGGESTED", libraryParams.f10030d);
                } else {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("android.media.browse.SEARCH_SUPPORTED", connectedControllersManager.k(controllerInfoS, 50005));
                return new MediaBrowserServiceCompat.BrowserRoot(((MediaItem) obj).f5257a, bundle2);
            }
        }
        return null;
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void h(Bundle bundle, MediaBrowserServiceCompat.Result result, String str) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            result.f(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            result.a();
            Util.X(this.n.f10102l, new w0(this, controllerInfoS, result, bundle, str));
        } else {
            Log.h("MLSLegacyStub", "onLoadChildren(): Ignoring empty parentId from " + controllerInfoS);
            result.f(null);
        }
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void i(String str, MediaBrowserServiceCompat.Result result) {
        h(null, result, str);
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void j(String str, MediaBrowserServiceCompat.Result result) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            result.f(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            result.a();
            Util.X(this.n.f10102l, new v0(this, controllerInfoS, result, str));
        } else {
            Log.h("MLSLegacyStub", "Ignoring empty itemId from " + controllerInfoS);
            result.f(null);
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void k(Bundle bundle, MediaBrowserServiceCompat.Result result, String str) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            result.f(null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.h("MLSLegacyStub", "Ignoring empty query from " + controllerInfoS);
            result.f(null);
            return;
        }
        if (controllerInfoS.f10086e instanceof BrowserLegacyCb) {
            result.a();
            Util.X(this.n.f10102l, new d(this, controllerInfoS, result, bundle, str));
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void l(Bundle bundle, String str) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Util.X(this.n.f10102l, new d(this, controllerInfoS, bundle, str, 1));
            return;
        }
        Log.h("MLSLegacyStub", "onSubscribe(): Ignoring empty id from " + controllerInfoS);
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void m(String str) {
        MediaSession.ControllerInfo controllerInfoS = s();
        if (controllerInfoS == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Util.X(this.n.f10102l, new v0(this, controllerInfoS, str, 2));
            return;
        }
        Log.h("MLSLegacyStub", "onUnsubscribe(): Ignoring empty id from " + controllerInfoS);
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub
    public final MediaSession.ControllerInfo p(MediaSessionManager.RemoteUserInfo remoteUserInfo, Bundle bundle) {
        return new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.f10154j.b(remoteUserInfo), new BrowserLegacyCb(remoteUserInfo), bundle);
    }

    public final MediaSession.ControllerInfo s() {
        return this.f10156l.g(b());
    }
}
