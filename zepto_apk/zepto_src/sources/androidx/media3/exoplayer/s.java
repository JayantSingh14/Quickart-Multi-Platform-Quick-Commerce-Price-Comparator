package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;

/* loaded from: classes3.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7396a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f7397b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Pair f7398c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7399d;

    public /* synthetic */ s(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, MediaLoadData mediaLoadData, int i2) {
        this.f7396a = i2;
        this.f7397b = forwardingEventListener;
        this.f7398c = pair;
        this.f7399d = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7396a) {
            case 0:
                AnalyticsCollector analyticsCollector = this.f7397b.f6315b.f6309h;
                Pair pair = this.f7398c;
                int iIntValue = ((Integer) pair.first).intValue();
                MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) pair.second;
                mediaPeriodId.getClass();
                analyticsCollector.h(iIntValue, mediaPeriodId, this.f7399d);
                break;
            default:
                AnalyticsCollector analyticsCollector2 = this.f7397b.f6315b.f6309h;
                Pair pair2 = this.f7398c;
                analyticsCollector2.R(((Integer) pair2.first).intValue(), (MediaSource.MediaPeriodId) pair2.second, this.f7399d);
                break;
        }
    }
}
