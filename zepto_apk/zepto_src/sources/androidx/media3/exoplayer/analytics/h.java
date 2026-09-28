package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6463b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f6464c;

    public /* synthetic */ h(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        this.f6462a = i2;
        this.f6463b = eventTime;
        this.f6464c = z;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6462a) {
            case 0:
                AnalyticsListener.EventTime eventTime = this.f6463b;
                analyticsListener.getClass();
                analyticsListener.a(eventTime, this.f6464c);
                break;
            case 1:
                analyticsListener.d(this.f6463b, this.f6464c);
                break;
            case 2:
                analyticsListener.w(this.f6463b, this.f6464c);
                break;
            default:
                analyticsListener.f(this.f6463b, this.f6464c);
                break;
        }
    }
}
