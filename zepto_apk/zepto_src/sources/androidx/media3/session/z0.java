package androidx.media3.session;

import androidx.media3.session.MediaSession;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes3.dex */
public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10807a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaLibrarySessionImpl f10808b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f10809c;

    public /* synthetic */ z0(MediaLibrarySessionImpl mediaLibrarySessionImpl, ListenableFuture listenableFuture, MediaSession.ControllerInfo controllerInfo, int i2) {
        this.f10807a = i2;
        this.f10808b = mediaLibrarySessionImpl;
        this.f10809c = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f10809c;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f10808b;
        switch (this.f10807a) {
            case 0:
                int i2 = MediaLibrarySessionImpl.C;
                mediaLibrarySessionImpl.getClass();
                break;
            default:
                int i3 = MediaLibrarySessionImpl.C;
                mediaLibrarySessionImpl.getClass();
                break;
        }
    }
}
