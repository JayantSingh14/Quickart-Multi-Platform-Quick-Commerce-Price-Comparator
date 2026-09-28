package androidx.media3.session;

import android.os.BadParcelableException;
import android.os.Bundle;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import com.google.android.gms.common.api.Api;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10781a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaLibraryServiceLegacyStub f10782b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaSession.ControllerInfo f10783c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat.Result f10784d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f10785e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f10786f;

    public /* synthetic */ w0(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle, String str) {
        this.f10782b = mediaLibraryServiceLegacyStub;
        this.f10783c = controllerInfo;
        this.f10784d = result;
        this.f10785e = bundle;
        this.f10786f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f10786f;
        Bundle bundle = this.f10785e;
        final MediaBrowserServiceCompat.Result result = this.f10784d;
        MediaSession.ControllerInfo controllerInfo = this.f10783c;
        final MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = this.f10782b;
        final int i2 = 1;
        switch (this.f10781a) {
            case 0:
                int i3 = MediaLibraryServiceLegacyStub.o;
                mediaLibraryServiceLegacyStub.getClass();
                SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
                if (!mediaLibraryServiceLegacyStub.f10156l.l(controllerInfo, sessionCommand)) {
                    result.e();
                    break;
                } else {
                    ListenableFuture listenableFutureN = mediaLibraryServiceLegacyStub.n.n(controllerInfo, sessionCommand, bundle);
                    listenableFutureN.q(new l0(2, listenableFutureN, result), MoreExecutors.a());
                    break;
                }
            default:
                int i4 = MediaLibraryServiceLegacyStub.o;
                if (!mediaLibraryServiceLegacyStub.f10156l.k(controllerInfo, 50003)) {
                    result.f(null);
                    break;
                } else {
                    MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibraryServiceLegacyStub.n;
                    if (bundle != null) {
                        bundle.setClassLoader(mediaLibrarySessionImpl.f10096f.getClassLoader());
                        try {
                            int i5 = bundle.getInt("android.media.browse.extra.PAGE");
                            int i6 = bundle.getInt("android.media.browse.extra.PAGE_SIZE");
                            if (i5 >= 0 && i6 > 0) {
                                final SettableFuture settableFutureI0 = Util.i0(mediaLibrarySessionImpl.y(controllerInfo, str, i6, LegacyConversions.h(mediaLibrarySessionImpl.f10096f, bundle)), new AsyncFunction() { // from class: androidx.media3.session.u0
                                    @Override // com.google.common.util.concurrent.AsyncFunction
                                    public final ListenableFuture apply(Object obj) {
                                        Object obj2;
                                        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = mediaLibraryServiceLegacyStub;
                                        LibraryResult libraryResult = (LibraryResult) obj;
                                        switch (i2) {
                                            case 0:
                                                int i7 = MediaLibraryServiceLegacyStub.o;
                                                mediaLibraryServiceLegacyStub2.getClass();
                                                Assertions.e(libraryResult, "LibraryResult must not be null");
                                                SettableFuture settableFuture = new SettableFuture();
                                                if (libraryResult.f9947a != 0 || (obj2 = libraryResult.f9949c) == null) {
                                                    settableFuture.n(null);
                                                } else {
                                                    MediaItem mediaItem = (MediaItem) obj2;
                                                    byte[] bArr = mediaItem.f5260d.f5389k;
                                                    if (bArr == null) {
                                                        settableFuture.n(LegacyConversions.a(mediaItem, null));
                                                    } else {
                                                        ListenableFuture listenableFutureC = mediaLibraryServiceLegacyStub2.n.f10103m.c(bArr);
                                                        settableFuture.q(new l0(3, settableFuture, listenableFutureC), MoreExecutors.a());
                                                        listenableFutureC.q(new v0(listenableFutureC, settableFuture, mediaItem, 0), MoreExecutors.a());
                                                    }
                                                }
                                                return settableFuture;
                                            default:
                                                return MediaLibraryServiceLegacyStub.r(mediaLibraryServiceLegacyStub2, libraryResult);
                                        }
                                    }
                                });
                                settableFutureI0.q(new Runnable() { // from class: androidx.media3.session.x0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        MediaBrowserServiceCompat.Result result2 = result;
                                        SettableFuture settableFuture = settableFutureI0;
                                        switch (i2) {
                                            case 0:
                                                int i7 = MediaLibraryServiceLegacyStub.o;
                                                try {
                                                    result2.f((MediaBrowserCompat.MediaItem) settableFuture.get());
                                                    break;
                                                } catch (InterruptedException | CancellationException | ExecutionException e2) {
                                                    Log.i("MLSLegacyStub", "Library operation failed", e2);
                                                    result2.f(null);
                                                    return;
                                                }
                                            default:
                                                int i8 = MediaLibraryServiceLegacyStub.o;
                                                try {
                                                    List list = (List) settableFuture.get();
                                                    result2.f(list == null ? null : MediaUtils.g(list));
                                                    break;
                                                } catch (InterruptedException | CancellationException | ExecutionException e3) {
                                                    Log.i("MLSLegacyStub", "Library operation failed", e3);
                                                    result2.f(null);
                                                }
                                        }
                                    }
                                }, MoreExecutors.a());
                                break;
                            }
                        } catch (BadParcelableException unused) {
                        }
                    }
                    final SettableFuture settableFutureI02 = Util.i0(mediaLibrarySessionImpl.y(controllerInfo, str, Api.BaseClientBuilder.API_PRIORITY_OTHER, null), new AsyncFunction() { // from class: androidx.media3.session.u0
                        @Override // com.google.common.util.concurrent.AsyncFunction
                        public final ListenableFuture apply(Object obj) {
                            Object obj2;
                            MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = mediaLibraryServiceLegacyStub;
                            LibraryResult libraryResult = (LibraryResult) obj;
                            switch (i2) {
                                case 0:
                                    int i7 = MediaLibraryServiceLegacyStub.o;
                                    mediaLibraryServiceLegacyStub2.getClass();
                                    Assertions.e(libraryResult, "LibraryResult must not be null");
                                    SettableFuture settableFuture = new SettableFuture();
                                    if (libraryResult.f9947a != 0 || (obj2 = libraryResult.f9949c) == null) {
                                        settableFuture.n(null);
                                    } else {
                                        MediaItem mediaItem = (MediaItem) obj2;
                                        byte[] bArr = mediaItem.f5260d.f5389k;
                                        if (bArr == null) {
                                            settableFuture.n(LegacyConversions.a(mediaItem, null));
                                        } else {
                                            ListenableFuture listenableFutureC = mediaLibraryServiceLegacyStub2.n.f10103m.c(bArr);
                                            settableFuture.q(new l0(3, settableFuture, listenableFutureC), MoreExecutors.a());
                                            listenableFutureC.q(new v0(listenableFutureC, settableFuture, mediaItem, 0), MoreExecutors.a());
                                        }
                                    }
                                    return settableFuture;
                                default:
                                    return MediaLibraryServiceLegacyStub.r(mediaLibraryServiceLegacyStub2, libraryResult);
                            }
                        }
                    });
                    settableFutureI02.q(new Runnable() { // from class: androidx.media3.session.x0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaBrowserServiceCompat.Result result2 = result;
                            SettableFuture settableFuture = settableFutureI02;
                            switch (i2) {
                                case 0:
                                    int i7 = MediaLibraryServiceLegacyStub.o;
                                    try {
                                        result2.f((MediaBrowserCompat.MediaItem) settableFuture.get());
                                        break;
                                    } catch (InterruptedException | CancellationException | ExecutionException e2) {
                                        Log.i("MLSLegacyStub", "Library operation failed", e2);
                                        result2.f(null);
                                        return;
                                    }
                                default:
                                    int i8 = MediaLibraryServiceLegacyStub.o;
                                    try {
                                        List list = (List) settableFuture.get();
                                        result2.f(list == null ? null : MediaUtils.g(list));
                                        break;
                                    } catch (InterruptedException | CancellationException | ExecutionException e3) {
                                        Log.i("MLSLegacyStub", "Library operation failed", e3);
                                        result2.f(null);
                                    }
                            }
                        }
                    }, MoreExecutors.a());
                    break;
                }
        }
    }

    public /* synthetic */ w0(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, String str, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle) {
        this.f10782b = mediaLibraryServiceLegacyStub;
        this.f10786f = str;
        this.f10783c = controllerInfo;
        this.f10784d = result;
        this.f10785e = bundle;
    }
}
