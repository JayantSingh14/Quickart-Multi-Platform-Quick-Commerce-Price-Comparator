package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;

/* loaded from: classes3.dex */
public final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8054a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f8055b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Pair f8056c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f8057d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f8058e;

    public /* synthetic */ u(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i2) {
        this.f8054a = i2;
        this.f8055b = forwardingEventListener;
        this.f8056c = pair;
        this.f8057d = loadEventInfo;
        this.f8058e = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8054a) {
            case 0:
                AnalyticsCollector analyticsCollector = this.f8055b.f6315b.f6309h;
                Pair pair = this.f8056c;
                analyticsCollector.M(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, this.f8057d, this.f8058e);
                break;
            case 1:
                AnalyticsCollector analyticsCollector2 = this.f8055b.f6315b.f6309h;
                Pair pair2 = this.f8056c;
                analyticsCollector2.B(((Integer) pair2.first).intValue(), (MediaSource.MediaPeriodId) pair2.second, this.f8057d, this.f8058e);
                break;
            default:
                AnalyticsCollector analyticsCollector3 = this.f8055b.f6315b.f6309h;
                Pair pair3 = this.f8056c;
                analyticsCollector3.Q(((Integer) pair3.first).intValue(), (MediaSource.MediaPeriodId) pair3.second, this.f8057d, this.f8058e);
                break;
        }
    }
}
