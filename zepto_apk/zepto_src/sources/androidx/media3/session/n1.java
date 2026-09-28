package androidx.media3.session;

import androidx.media3.common.MediaItem;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class n1 implements MediaSessionStub.ControllerPlayerTask, MediaSessionStub.MediaItemPlayerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10716a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionStub f10717b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10718c;

    public /* synthetic */ n1(MediaSessionStub mediaSessionStub, int i2, int i3) {
        this.f10716a = i3;
        this.f10717b = mediaSessionStub;
        this.f10718c = i2;
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void b(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        int i2 = this.f10718c;
        MediaSessionStub mediaSessionStub = this.f10717b;
        switch (this.f10716a) {
            case 0:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.d1(mediaSessionStub.V2(controllerInfo, playerWrapper, i2));
                break;
            default:
                int i4 = MediaSessionStub.f10157h;
                playerWrapper.r0(mediaSessionStub.V2(controllerInfo, playerWrapper, i2));
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void e(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        int i2 = this.f10718c;
        MediaSessionStub mediaSessionStub = this.f10717b;
        switch (this.f10716a) {
            case 1:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.g1(mediaSessionStub.V2(controllerInfo, playerWrapper, i2), list);
                break;
            case 2:
                int i4 = MediaSessionStub.f10157h;
                mediaSessionStub.getClass();
                if (list.size() != 1) {
                    playerWrapper.p0(mediaSessionStub.V2(controllerInfo, playerWrapper, i2), mediaSessionStub.V2(controllerInfo, playerWrapper, i2 + 1), list);
                    break;
                } else {
                    playerWrapper.R0(mediaSessionStub.V2(controllerInfo, playerWrapper, i2), (MediaItem) list.get(0));
                    break;
                }
            default:
                int i5 = MediaSessionStub.f10157h;
                playerWrapper.g1(mediaSessionStub.V2(controllerInfo, playerWrapper, i2), list);
                break;
        }
    }
}
