package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class c1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10330a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10331b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10332c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10333d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10334e;

    public /* synthetic */ c1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession, MediaNotification mediaNotification, boolean z) {
        this.f10332c = mediaNotificationManager;
        this.f10333d = mediaSession;
        this.f10334e = mediaNotification;
        this.f10331b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10330a) {
            case 0:
                ((MediaNotificationManager) this.f10332c).d((MediaSession) this.f10333d, (MediaNotification) this.f10334e, this.f10331b);
                break;
            default:
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
                MediaUtils.f(playerWrapper, (MediaSession.MediaItemsWithStartPosition) this.f10333d);
                int iU = playerWrapper.u();
                if (iU == 1) {
                    if (playerWrapper.D1(2)) {
                        playerWrapper.p();
                    }
                } else if (iU == 4 && playerWrapper.D1(4)) {
                    playerWrapper.k0();
                }
                boolean z = this.f10331b;
                if (z && playerWrapper.D1(1)) {
                    playerWrapper.E();
                }
                Player.Commands.Builder builder = new Player.Commands.Builder();
                builder.f5434a.b(31, 2);
                builder.c(1, z);
                builder.d();
                mediaSessionLegacyStub.f10115g.r((MediaSession.ControllerInfo) this.f10334e);
                break;
        }
    }

    public /* synthetic */ c1(MediaSessionLegacyStub.AnonymousClass1 anonymousClass1, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition, boolean z, MediaSession.ControllerInfo controllerInfo) {
        this.f10332c = anonymousClass1;
        this.f10333d = mediaItemsWithStartPosition;
        this.f10331b = z;
        this.f10334e = controllerInfo;
    }
}
