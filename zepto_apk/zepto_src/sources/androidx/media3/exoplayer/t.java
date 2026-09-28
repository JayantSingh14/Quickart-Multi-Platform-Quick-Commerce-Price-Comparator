package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaSource;

/* loaded from: classes3.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7950a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7951b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Pair f7952c;

    public /* synthetic */ t(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i2) {
        this.f7950a = i2;
        this.f7951b = forwardingEventListener;
        this.f7952c = pair;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7950a) {
            case 0:
                AnalyticsCollector analyticsCollector = this.f7951b.f6315b.f6309h;
                Pair pair = this.f7952c;
                analyticsCollector.E(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
                break;
            case 1:
                AnalyticsCollector analyticsCollector2 = this.f7951b.f6315b.f6309h;
                Pair pair2 = this.f7952c;
                analyticsCollector2.Z(((Integer) pair2.first).intValue(), (MediaSource.MediaPeriodId) pair2.second);
                break;
            default:
                AnalyticsCollector analyticsCollector3 = this.f7951b.f6315b.f6309h;
                Pair pair3 = this.f7952c;
                analyticsCollector3.S(((Integer) pair3.first).intValue(), (MediaSource.MediaPeriodId) pair3.second);
                break;
        }
    }
}
