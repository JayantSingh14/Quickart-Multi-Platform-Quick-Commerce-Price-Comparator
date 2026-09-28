package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6454b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Format f6455c;

    public /* synthetic */ e(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, int i2) {
        this.f6453a = i2;
        this.f6454b = eventTime;
        this.f6455c = format;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6453a) {
            case 0:
                analyticsListener.l(this.f6454b, this.f6455c);
                break;
            default:
                analyticsListener.h(this.f6454b, this.f6455c);
                break;
        }
    }
}
