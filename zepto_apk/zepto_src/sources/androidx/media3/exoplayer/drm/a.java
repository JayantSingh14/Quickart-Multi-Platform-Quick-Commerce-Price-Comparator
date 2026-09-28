package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6950b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f6949a = i2;
        this.f6950b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6949a) {
            case 0:
                DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference = (DefaultDrmSessionManager.PreacquiredSessionReference) this.f6950b;
                if (!preacquiredSessionReference.f6915c) {
                    DrmSession drmSession = preacquiredSessionReference.f6914b;
                    if (drmSession != null) {
                        drmSession.f(preacquiredSessionReference.f6913a);
                    }
                    DefaultDrmSessionManager.this.n.remove(preacquiredSessionReference);
                    preacquiredSessionReference.f6915c = true;
                    break;
                }
                break;
            default:
                ((DefaultDrmSession) this.f6950b).f(null);
                break;
        }
    }
}
