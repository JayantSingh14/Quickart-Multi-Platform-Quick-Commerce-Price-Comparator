package androidx.media3.session;

import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class m1 implements MediaSessionStub.ControllerPlayerTask, MediaSessionStub.MediaItemPlayerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaSessionStub f10704a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10705b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10706c;

    public /* synthetic */ m1(MediaSessionStub mediaSessionStub, int i2, int i3) {
        this.f10704a = mediaSessionStub;
        this.f10705b = i2;
        this.f10706c = i3;
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void b(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionStub.f10157h;
        MediaSessionStub mediaSessionStub = this.f10704a;
        playerWrapper.s0(mediaSessionStub.V2(controllerInfo, playerWrapper, this.f10705b), mediaSessionStub.V2(controllerInfo, playerWrapper, this.f10706c));
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void e(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        int i2 = MediaSessionStub.f10157h;
        MediaSessionStub mediaSessionStub = this.f10704a;
        playerWrapper.p0(mediaSessionStub.V2(controllerInfo, playerWrapper, this.f10705b), mediaSessionStub.V2(controllerInfo, playerWrapper, this.f10706c), list);
    }
}
