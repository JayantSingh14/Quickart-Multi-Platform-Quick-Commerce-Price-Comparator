package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7390a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7391b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7392c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7393d;

    public /* synthetic */ p(Object obj, Object obj2, Object obj3, int i2) {
        this.f7390a = i2;
        this.f7391b = obj;
        this.f7392c = obj2;
        this.f7393d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7390a) {
            case 0:
                MediaPeriodQueue mediaPeriodQueue = (MediaPeriodQueue) this.f7391b;
                mediaPeriodQueue.getClass();
                mediaPeriodQueue.f6291c.y(((ImmutableList.Builder) this.f7392c).j(), (MediaSource.MediaPeriodId) this.f7393d);
                break;
            default:
                AnalyticsCollector analyticsCollector = ((MediaSourceList.ForwardingEventListener) this.f7391b).f6315b.f6309h;
                Pair pair = (Pair) this.f7392c;
                analyticsCollector.K(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, (Exception) this.f7393d);
                break;
        }
    }
}
