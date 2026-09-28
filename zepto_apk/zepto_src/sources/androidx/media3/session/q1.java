package androidx.media3.session;

import androidx.media3.common.MediaItem;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class q1 implements MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10739a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaItem f10740b;

    public /* synthetic */ q1(int i2, MediaItem mediaItem) {
        this.f10739a = i2;
        this.f10740b = mediaItem;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public final Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        MediaItem mediaItem = this.f10740b;
        switch (this.f10739a) {
            case 0:
                int i3 = MediaSessionStub.f10157h;
                break;
            case 1:
                int i4 = MediaSessionStub.f10157h;
                break;
            default:
                int i5 = MediaSessionStub.f10157h;
                break;
        }
        return mediaSessionImpl.l(controllerInfo, ImmutableList.t(mediaItem));
    }
}
