package androidx.media3.session;

import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10295b;

    public /* synthetic */ a0(Object obj, int i2) {
        this.f10294a = i2;
        this.f10295b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10294a) {
            case 0:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10295b;
                MediaControllerImplBase.SessionServiceConnection sessionServiceConnection = mediaControllerImplBase.f9982m;
                if (sessionServiceConnection != null) {
                    mediaControllerImplBase.f9973d.unbindService(sessionServiceConnection);
                    mediaControllerImplBase.f9982m = null;
                }
                mediaControllerImplBase.f9972c.f10022a.clear();
                return;
            case 1:
                ((SequencedFutureManager) this.f10295b).b();
                return;
            case 2:
                ((MediaController) this.f10295b).release();
                return;
            default:
                synchronized (((MediaSessionService) this.f10295b).f10142a) {
                }
                return;
        }
    }
}
