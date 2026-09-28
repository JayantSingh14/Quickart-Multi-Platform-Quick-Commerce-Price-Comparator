package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaPeriod;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7915a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f7916b;

    public /* synthetic */ i(ProgressiveMediaPeriod progressiveMediaPeriod, int i2) {
        this.f7915a = i2;
        this.f7916b = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.f7916b;
        switch (this.f7915a) {
            case 0:
                progressiveMediaPeriod.H = true;
                break;
            case 1:
                Map map = ProgressiveMediaPeriod.X;
                progressiveMediaPeriod.x();
                break;
            default:
                if (!progressiveMediaPeriod.Q) {
                    MediaPeriod.Callback callback = progressiveMediaPeriod.r;
                    callback.getClass();
                    callback.k(progressiveMediaPeriod);
                    break;
                }
                break;
        }
    }
}
