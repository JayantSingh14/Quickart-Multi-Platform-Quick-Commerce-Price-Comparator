package androidx.media3.session;

import androidx.media3.session.MediaSession;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10291a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionImpl f10292b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaSession.ControllerInfo f10293c;

    public /* synthetic */ a(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        this.f10291a = i2;
        this.f10292b = mediaSessionImpl;
        this.f10293c = controllerInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10291a) {
            case 0:
                MediaSessionImpl mediaSessionImpl = this.f10292b;
                if (!mediaSessionImpl.j()) {
                    mediaSessionImpl.o(this.f10293c);
                    break;
                }
                break;
            case 1:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 1, MediaSessionStub.i5(new o0(8)));
                break;
            case 2:
                MediaSessionStub mediaSessionStub = this.f10292b.f10097g;
                MediaSession.ControllerInfo controllerInfo = this.f10293c;
                mediaSessionStub.getClass();
                mediaSessionStub.d4(controllerInfo, Integer.MIN_VALUE, 1, MediaSessionStub.i5(new s(11, mediaSessionStub, controllerInfo)));
                break;
            case 3:
                MediaSessionStub mediaSessionStub2 = this.f10292b.f10097g;
                MediaSession.ControllerInfo controllerInfo2 = this.f10293c;
                mediaSessionStub2.getClass();
                mediaSessionStub2.d4(controllerInfo2, Integer.MIN_VALUE, 1, MediaSessionStub.i5(new s(11, mediaSessionStub2, controllerInfo2)));
                break;
            case 4:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 1, MediaSessionStub.i5(new o0(8)));
                break;
            case 5:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 9, MediaSessionStub.i5(new o0(16)));
                break;
            case 6:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 7, MediaSessionStub.i5(new o0(12)));
                break;
            case 7:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 12, MediaSessionStub.i5(new o0(15)));
                break;
            case 8:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 11, MediaSessionStub.i5(new o0(11)));
                break;
            default:
                this.f10292b.f10097g.d4(this.f10293c, Integer.MIN_VALUE, 3, MediaSessionStub.i5(new o0(21)));
                break;
        }
    }
}
