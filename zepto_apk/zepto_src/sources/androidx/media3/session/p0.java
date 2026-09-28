package androidx.media3.session;

import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class p0 implements MediaControllerStub.ControllerTask, MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10728a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10729b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10730c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaLibraryService.LibraryParams f10731d;

    public /* synthetic */ p0(String str, int i2, int i3, MediaLibraryService.LibraryParams libraryParams) {
        this.f10728a = 2;
        this.f10729b = str;
        this.f10730c = i3;
        this.f10731d = libraryParams;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        switch (this.f10728a) {
            case 0:
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) mediaControllerImplBase;
                int i2 = MediaControllerStub.f10021b;
                if (mediaBrowserImplBase.isConnected()) {
                    new f(mediaBrowserImplBase, this.f10729b, this.f10730c, this.f10731d, 0);
                    throw null;
                }
                return;
            default:
                MediaBrowserImplBase mediaBrowserImplBase2 = (MediaBrowserImplBase) mediaControllerImplBase;
                int i3 = MediaControllerStub.f10021b;
                if (mediaBrowserImplBase2.isConnected()) {
                    new f(mediaBrowserImplBase2, this.f10729b, this.f10730c, this.f10731d, 1);
                    throw null;
                }
                return;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        int i3 = MediaSessionStub.f10157h;
        return ((MediaLibrarySessionImpl) mediaSessionImpl).y(controllerInfo, this.f10729b, this.f10730c, this.f10731d);
    }

    public /* synthetic */ p0(String str, int i2, MediaLibraryService.LibraryParams libraryParams, int i3) {
        this.f10728a = i3;
        this.f10729b = str;
        this.f10730c = i2;
        this.f10731d = libraryParams;
    }
}
