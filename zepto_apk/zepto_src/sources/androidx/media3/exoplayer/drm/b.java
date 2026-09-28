package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6952b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6953c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f6951a = i2;
        this.f6952b = obj;
        this.f6953c = obj2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.media3.exoplayer.drm.DrmSessionEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.media3.exoplayer.drm.DrmSessionEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.media3.exoplayer.drm.DrmSessionEventListener, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6951a) {
            case 0:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) this.f6952b;
                this.f6953c.Z(eventDispatcher.f6924a, eventDispatcher.f6925b);
                break;
            case 1:
                DrmSessionEventListener.EventDispatcher eventDispatcher2 = (DrmSessionEventListener.EventDispatcher) this.f6952b;
                this.f6953c.S(eventDispatcher2.f6924a, eventDispatcher2.f6925b);
                break;
            case 2:
                DrmSessionEventListener.EventDispatcher eventDispatcher3 = (DrmSessionEventListener.EventDispatcher) this.f6952b;
                this.f6953c.E(eventDispatcher3.f6924a, eventDispatcher3.f6925b);
                break;
            default:
                DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference = (DefaultDrmSessionManager.PreacquiredSessionReference) this.f6952b;
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.p != 0 && !preacquiredSessionReference.f6915c) {
                    Looper looper = defaultDrmSessionManager.t;
                    looper.getClass();
                    preacquiredSessionReference.f6914b = defaultDrmSessionManager.e(looper, preacquiredSessionReference.f6913a, (Format) this.f6953c, false);
                    defaultDrmSessionManager.n.add(preacquiredSessionReference);
                    break;
                }
                break;
        }
    }
}
