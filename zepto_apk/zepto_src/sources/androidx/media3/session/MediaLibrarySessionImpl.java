package androidx.media3.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.legacy.MediaSessionCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
class MediaLibrarySessionImpl extends MediaSessionImpl {
    public static final /* synthetic */ int C = 0;

    /* renamed from: androidx.media3.session.MediaLibrarySessionImpl$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<MediaSession.MediaItemsWithStartPosition> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SettableFuture f10041a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaLibraryService.LibraryParams f10042b;

        public AnonymousClass1(SettableFuture settableFuture, MediaLibraryService.LibraryParams libraryParams) {
            this.f10041a = settableFuture;
            this.f10042b = libraryParams;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
            this.f10041a.n(new LibraryResult(-1, SystemClock.elapsedRealtime(), this.f10042b, new SessionError("no error message provided", -1, Bundle.EMPTY), null, 4));
            Log.e("MediaSessionImpl", "Failed fetching recent media item at boot time: " + th.getMessage(), th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) {
            MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaSession.MediaItemsWithStartPosition) obj;
            boolean zIsEmpty = mediaItemsWithStartPosition.f10088a.isEmpty();
            SettableFuture settableFuture = this.f10041a;
            MediaLibraryService.LibraryParams libraryParams = this.f10042b;
            if (zIsEmpty) {
                settableFuture.n(new LibraryResult(-2, SystemClock.elapsedRealtime(), libraryParams, new SessionError("no error message provided", -2, Bundle.EMPTY), null, 4));
                return;
            }
            settableFuture.n(LibraryResult.c(ImmutableList.t((MediaItem) mediaItemsWithStartPosition.f10088a.get(Math.max(0, Math.min(mediaItemsWithStartPosition.f10089b, r0.size() - 1)))), libraryParams));
        }
    }

    public static Object B(Future future) {
        Assertions.g(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e2) {
            Log.i("MediaSessionImpl", "Library operation failed", e2);
            return null;
        }
    }

    public static void C(int i2, LibraryResult libraryResult) {
        if (libraryResult.f9947a == 0) {
            ImmutableList immutableList = (ImmutableList) libraryResult.f9949c;
            immutableList.getClass();
            if (immutableList.size() <= i2) {
                return;
            }
            throw new IllegalStateException("Invalid size=" + immutableList.size() + ", pageSize=" + i2);
        }
    }

    public static void x(MediaLibrarySessionImpl mediaLibrarySessionImpl, Runnable runnable) {
        Util.X(mediaLibrarySessionImpl.f10102l, runnable);
    }

    public final ListenableFuture A(MediaSession.ControllerInfo controllerInfo, String str, MediaLibraryService.LibraryParams libraryParams) {
        controllerInfo.f10086e.getClass();
        throw null;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public final MediaSessionServiceLegacyStub b(MediaSessionCompat.Token token) {
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = new MediaLibraryServiceLegacyStub(this);
        mediaLibraryServiceLegacyStub.q(token);
        return mediaLibraryServiceLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public final void d(MediaSessionImpl.RemoteControllerTask remoteControllerTask) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        super.d(remoteControllerTask);
        synchronized (this.f10091a) {
            mediaSessionServiceLegacyStub = this.v;
        }
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) mediaSessionServiceLegacyStub;
        if (mediaLibraryServiceLegacyStub != null) {
            try {
                remoteControllerTask.d(mediaLibraryServiceLegacyStub.f10035m, 0);
            } catch (RemoteException e2) {
                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
            }
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public final boolean h(MediaSession.ControllerInfo controllerInfo) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        if (super.h(controllerInfo)) {
            return true;
        }
        synchronized (this.f10091a) {
            mediaSessionServiceLegacyStub = this.v;
        }
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) mediaSessionServiceLegacyStub;
        return mediaLibraryServiceLegacyStub != null && mediaLibraryServiceLegacyStub.f10156l.i(controllerInfo);
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public final void o(MediaSession.ControllerInfo controllerInfo) {
        controllerInfo.f10086e.getClass();
        throw null;
    }

    public final ListenableFuture y(MediaSession.ControllerInfo controllerInfo, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (!Objects.equals(str, "androidx.media3.session.recent.root")) {
            u(controllerInfo);
            throw null;
        }
        if (this.f10098h.f10121m == null) {
            return Futures.d(LibraryResult.b(-6));
        }
        if (this.s.u() == 1) {
            if (this.y) {
                e().getClass();
            }
            throw null;
        }
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5266a = "androidx.media3.session.recent.item";
        MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
        builder2.q = Boolean.FALSE;
        builder2.r = Boolean.TRUE;
        builder.f5276k = new MediaMetadata(builder2);
        return Futures.d(LibraryResult.c(ImmutableList.t(builder.a()), libraryParams));
    }

    public final ListenableFuture z(MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams == null || !libraryParams.f10028b || !MediaSessionImpl.k(controllerInfo)) {
            u(controllerInfo);
            throw null;
        }
        if (this.f10098h.f10121m == null) {
            return Futures.d(LibraryResult.b(-6));
        }
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5266a = "androidx.media3.session.recent.root";
        MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
        builder2.q = Boolean.TRUE;
        builder2.r = Boolean.FALSE;
        builder.f5276k = new MediaMetadata(builder2);
        MediaItem mediaItemA = builder.a();
        LibraryResult.d(mediaItemA);
        return Futures.d(new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, mediaItemA, 2));
    }
}
