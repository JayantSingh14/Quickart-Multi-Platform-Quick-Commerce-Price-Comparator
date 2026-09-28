package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6448a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6449b;

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, int i2) {
        this.f6448a = i2;
        this.f6449b = eventTime;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6448a) {
            case 0:
                analyticsListener.k(this.f6449b);
                break;
            case 1:
                analyticsListener.c(this.f6449b);
                break;
            case 2:
                analyticsListener.j(this.f6449b);
                break;
            case 3:
                analyticsListener.K(this.f6449b);
                break;
            case 4:
                analyticsListener.J(this.f6449b);
                break;
            default:
                analyticsListener.Q(this.f6449b);
                break;
        }
    }

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, int i2) {
        this.f6448a = i2;
        this.f6449b = eventTime;
    }
}
