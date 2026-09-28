package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6442a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6443b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6444c;

    public /* synthetic */ a(AnalyticsListener.EventTime eventTime, String str, int i2) {
        this.f6442a = i2;
        this.f6443b = eventTime;
        this.f6444c = str;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6442a) {
            case 0:
                AnalyticsListener.EventTime eventTime = this.f6443b;
                analyticsListener.getClass();
                analyticsListener.R(eventTime, this.f6444c);
                break;
            case 1:
                analyticsListener.E(this.f6443b, this.f6444c);
                break;
            case 2:
                AnalyticsListener.EventTime eventTime2 = this.f6443b;
                analyticsListener.getClass();
                analyticsListener.C(eventTime2, this.f6444c);
                break;
            default:
                analyticsListener.B(this.f6443b, this.f6444c);
                break;
        }
    }

    public /* synthetic */ a(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, int i2) {
        this.f6442a = i2;
        this.f6443b = eventTime;
        this.f6444c = str;
    }
}
