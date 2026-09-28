package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6483a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f6484b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f6485c;

    public /* synthetic */ o(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig, int i2) {
        this.f6483a = i2;
        this.f6484b = eventTime;
        this.f6485c = audioTrackConfig;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6483a) {
            case 0:
                analyticsListener.z(this.f6484b, this.f6485c);
                break;
            default:
                analyticsListener.D(this.f6484b, this.f6485c);
                break;
        }
    }
}
