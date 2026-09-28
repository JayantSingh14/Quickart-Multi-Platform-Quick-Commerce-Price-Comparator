package androidx.media3.session;

import android.os.RemoteException;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.MediaSessionService;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class e1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionImpl f10356b;

    public /* synthetic */ e1(MediaSessionImpl mediaSessionImpl, int i2) {
        this.f10355a = i2;
        this.f10356b = mediaSessionImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10355a) {
            case 0:
                MediaSessionImpl mediaSessionImpl = this.f10356b;
                MediaSessionImpl.PlayerListener playerListener = mediaSessionImpl.t;
                if (playerListener != null) {
                    mediaSessionImpl.s.A0(playerListener);
                    return;
                }
                return;
            case 1:
                MediaSessionImpl mediaSessionImpl2 = this.f10356b;
                MediaSessionService.MediaSessionListener mediaSessionListener = mediaSessionImpl2.u;
                if (mediaSessionListener != null) {
                    MediaSessionService.this.g(mediaSessionImpl2.f10101k, false);
                    return;
                }
                return;
            case 2:
                MediaSessionImpl mediaSessionImpl3 = this.f10356b;
                synchronized (mediaSessionImpl3.f10091a) {
                    try {
                        if (mediaSessionImpl3.w) {
                            return;
                        }
                        final SessionPositionInfo sessionPositionInfoN = mediaSessionImpl3.s.n();
                        if (!mediaSessionImpl3.f10093c.hasMessages(1) && MediaUtils.a(sessionPositionInfoN, mediaSessionImpl3.r.f10170c)) {
                            ConnectedControllersManager connectedControllersManager = mediaSessionImpl3.f10097g.f10160d;
                            ImmutableList immutableListF = connectedControllersManager.f();
                            for (int i2 = 0; i2 < immutableListF.size(); i2++) {
                                final MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) immutableListF.get(i2);
                                final boolean zJ = connectedControllersManager.j(controllerInfo, 16);
                                final boolean zJ2 = connectedControllersManager.j(controllerInfo, 17);
                                mediaSessionImpl3.c(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.f1
                                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                                    public final void d(MediaSession.ControllerCb controllerCb, int i3) {
                                        int i4 = MediaSessionImpl.B;
                                        controllerCb.a(i3, sessionPositionInfoN, zJ, zJ2, controllerInfo.f10084c);
                                    }
                                });
                            }
                            try {
                                mediaSessionImpl3.f10098h.f10117i.a(0, sessionPositionInfoN, true, true, 0);
                            } catch (RemoteException e2) {
                                Log.e("MediaSessionImpl", "Exception in using media1 API", e2);
                            }
                        }
                        mediaSessionImpl3.v();
                        return;
                    } finally {
                    }
                }
            default:
                int i3 = MediaSessionImpl.B;
                this.f10356b.v();
                return;
        }
    }
}
