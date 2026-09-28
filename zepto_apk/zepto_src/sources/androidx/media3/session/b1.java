package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.session.MediaSession;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10315c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10316d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10317e;

    public /* synthetic */ b1(int i2, int i3, Object obj, Object obj2, Object obj3) {
        this.f10313a = i3;
        this.f10315c = obj;
        this.f10314b = i2;
        this.f10316d = obj2;
        this.f10317e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10313a) {
            case 0:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f10315c;
                if (this.f10314b == mediaNotificationManager.f10052h) {
                    MediaSession mediaSession = (MediaSession) this.f10316d;
                    mediaNotificationManager.d(mediaSession, (MediaNotification) this.f10317e, mediaNotificationManager.c(mediaSession, false));
                    break;
                }
                break;
            default:
                MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                int i2 = this.f10314b;
                List list = (List) this.f10316d;
                if (i2 == -1) {
                    mediaSessionLegacyStub.f10115g.s.q1(list);
                } else {
                    mediaSessionLegacyStub.f10115g.s.g1(i2, list);
                }
                MediaSessionImpl mediaSessionImpl = mediaSessionLegacyStub.f10115g;
                Player.Commands.Builder builder = new Player.Commands.Builder();
                builder.f5434a.a(20);
                builder.d();
                mediaSessionImpl.r((MediaSession.ControllerInfo) this.f10317e);
                break;
        }
    }
}
