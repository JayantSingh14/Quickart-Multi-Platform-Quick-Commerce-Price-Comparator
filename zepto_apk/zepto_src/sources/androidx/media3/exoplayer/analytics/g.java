package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6459a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6460b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f6461c;

    public /* synthetic */ g(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, int i2) {
        this.f6459a = i2;
        this.f6460b = eventTime;
        this.f6461c = mediaLoadData;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6459a) {
            case 0:
                analyticsListener.G(this.f6460b, this.f6461c);
                break;
            default:
                analyticsListener.O(this.f6460b, this.f6461c);
                break;
        }
    }
}
