package io.sentry.android.replay;

import io.sentry.SentryReplayEvent;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LastSegmentData {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenshotRecorderConfig f52409a;

    /* renamed from: b, reason: collision with root package name */
    public final ReplayCache f52410b;

    /* renamed from: c, reason: collision with root package name */
    public final Date f52411c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52412d;

    /* renamed from: e, reason: collision with root package name */
    public final long f52413e;

    /* renamed from: f, reason: collision with root package name */
    public final SentryReplayEvent.ReplayType f52414f;

    /* renamed from: g, reason: collision with root package name */
    public final String f52415g;

    /* renamed from: h, reason: collision with root package name */
    public final List f52416h;

    public LastSegmentData(ScreenshotRecorderConfig recorderConfig, ReplayCache cache, Date timestamp, int i2, long j2, SentryReplayEvent.ReplayType replayType, String str, List events) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(replayType, "replayType");
        Intrinsics.checkNotNullParameter(events, "events");
        this.f52409a = recorderConfig;
        this.f52410b = cache;
        this.f52411c = timestamp;
        this.f52412d = i2;
        this.f52413e = j2;
        this.f52414f = replayType;
        this.f52415g = str;
        this.f52416h = events;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastSegmentData)) {
            return false;
        }
        LastSegmentData lastSegmentData = (LastSegmentData) obj;
        return Intrinsics.b(this.f52409a, lastSegmentData.f52409a) && Intrinsics.b(this.f52410b, lastSegmentData.f52410b) && Intrinsics.b(this.f52411c, lastSegmentData.f52411c) && this.f52412d == lastSegmentData.f52412d && this.f52413e == lastSegmentData.f52413e && this.f52414f == lastSegmentData.f52414f && Intrinsics.b(this.f52415g, lastSegmentData.f52415g) && Intrinsics.b(this.f52416h, lastSegmentData.f52416h);
    }

    public final int hashCode() {
        int iHashCode = (this.f52414f.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.b(this.f52412d, (this.f52411c.hashCode() + ((this.f52410b.hashCode() + (this.f52409a.hashCode() * 31)) * 31)) * 31, 31), 31, this.f52413e)) * 31;
        String str = this.f52415g;
        return this.f52416h.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "LastSegmentData(recorderConfig=" + this.f52409a + ", cache=" + this.f52410b + ", timestamp=" + this.f52411c + ", id=" + this.f52412d + ", duration=" + this.f52413e + ", replayType=" + this.f52414f + ", screenAtStart=" + this.f52415g + ", events=" + this.f52416h + ')';
    }
}
