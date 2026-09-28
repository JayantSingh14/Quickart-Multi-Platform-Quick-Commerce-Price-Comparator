package io.sentry.android.replay.capture;

import io.sentry.protocol.SentryId;
import java.util.Date;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52593a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f52594b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Date f52595c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SentryId f52596d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f52597e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f52598f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f52599g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Lambda f52600h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ BaseCaptureStrategy f52601i;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(BufferCaptureStrategy bufferCaptureStrategy, long j2, Date date, SentryId sentryId, int i2, int i3, int i4, Function1 function1) {
        this.f52601i = bufferCaptureStrategy;
        this.f52594b = j2;
        this.f52595c = date;
        this.f52596d = sentryId;
        this.f52597e = i2;
        this.f52598f = i3;
        this.f52599g = i4;
        this.f52600h = (Lambda) function1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? onSegmentCreated = this.f52600h;
        BaseCaptureStrategy baseCaptureStrategy = this.f52601i;
        switch (this.f52593a) {
            case 0:
                int i2 = BufferCaptureStrategy.w;
                BufferCaptureStrategy this$0 = (BufferCaptureStrategy) baseCaptureStrategy;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Date currentSegmentTimestamp = this.f52595c;
                Intrinsics.checkNotNullParameter(currentSegmentTimestamp, "$currentSegmentTimestamp");
                SentryId replayId = this.f52596d;
                Intrinsics.checkNotNullParameter(replayId, "$replayId");
                Intrinsics.checkNotNullParameter(onSegmentCreated, "$onSegmentCreated");
                onSegmentCreated.invoke(BaseCaptureStrategy.l(this$0, this.f52594b, currentSegmentTimestamp, replayId, this.f52597e, this.f52598f, this.f52599g));
                break;
            default:
                int i3 = SessionCaptureStrategy.u;
                SessionCaptureStrategy this$02 = (SessionCaptureStrategy) baseCaptureStrategy;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                Date currentSegmentTimestamp2 = this.f52595c;
                Intrinsics.checkNotNullParameter(currentSegmentTimestamp2, "$currentSegmentTimestamp");
                SentryId replayId2 = this.f52596d;
                Intrinsics.checkNotNullParameter(replayId2, "$replayId");
                Intrinsics.checkNotNullParameter(onSegmentCreated, "$onSegmentCreated");
                onSegmentCreated.invoke(BaseCaptureStrategy.l(this$02, this.f52594b, currentSegmentTimestamp2, replayId2, this.f52597e, this.f52598f, this.f52599g));
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(SessionCaptureStrategy sessionCaptureStrategy, long j2, Date date, SentryId sentryId, int i2, int i3, int i4, Function1 function1) {
        this.f52601i = sessionCaptureStrategy;
        this.f52594b = j2;
        this.f52595c = date;
        this.f52596d = sentryId;
        this.f52597e = i2;
        this.f52598f = i3;
        this.f52599g = i4;
        this.f52600h = (Lambda) function1;
    }
}
