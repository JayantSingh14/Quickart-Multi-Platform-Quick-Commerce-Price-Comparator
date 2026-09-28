package io.sentry.android.replay.capture;

import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.protocol.SentryId;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.util.FileUtils;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class SessionCaptureStrategy extends BaseCaptureStrategy {
    public static final /* synthetic */ int u = 0;
    public final SentryOptions r;
    public final HubAdapter s;
    public final CurrentDateProvider t;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCaptureStrategy(SentryOptions options, HubAdapter hubAdapter, CurrentDateProvider dateProvider, ScheduledExecutorService executor) {
        super(options, hubAdapter, dateProvider, executor);
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.r = options;
        this.s = hubAdapter;
        this.t = dateProvider;
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void b(ScreenshotRecorderConfig recorderConfig) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        n("onConfigurationChanged", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.SessionCaptureStrategy$onConfigurationChanged$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) segment;
                    SessionCaptureStrategy sessionCaptureStrategy = this.f52589c;
                    created.a(sessionCaptureStrategy.s, new Hint());
                    sessionCaptureStrategy.e(sessionCaptureStrategy.f() + 1);
                    sessionCaptureStrategy.i(created.f52586a.u);
                }
                return Unit.f53572a;
            }
        });
        super.b(recorderConfig);
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void c(ScreenshotRecorderConfig recorderConfig, int i2, SentryId replayId, SentryReplayEvent.ReplayType replayType) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        super.c(recorderConfig, i2, replayId, replayType);
        if (this.s != null) {
            Sentry.c(new c(this));
        }
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void g(boolean z, Function1 onSegmentSent) {
        Intrinsics.checkNotNullParameter(onSegmentSent, "onSegmentSent");
        this.r.getLogger().c(SentryLevel.DEBUG, "Replay is already running in 'session' mode, not capturing for event", new Object[0]);
        this.f52526g.set(z);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final CaptureStrategy h() {
        return this;
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void j(final Function2 store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.t.getClass();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final int i2 = m().f52486b;
        final int i3 = m().f52485a;
        Runnable runnable = new Runnable() { // from class: io.sentry.android.replay.capture.d
            @Override // java.lang.Runnable
            public final void run() {
                int i4 = SessionCaptureStrategy.u;
                SessionCaptureStrategy this$0 = this.f52606a;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Function2 store2 = store;
                Intrinsics.checkNotNullParameter(store2, "$store");
                ReplayCache replayCache = this$0.f52527h;
                if (replayCache != null) {
                    store2.invoke(replayCache, Long.valueOf(jCurrentTimeMillis));
                }
                Date date = (Date) this$0.f52529j.a(this$0, BaseCaptureStrategy.q[1]);
                SentryOptions sentryOptions = this$0.r;
                if (date == null) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "Segment timestamp is not set, not recording frame", new Object[0]);
                    return;
                }
                if (this$0.f52526g.get()) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "Not capturing segment, because the app is terminating, will be captured on next launch", new Object[0]);
                    return;
                }
                this$0.t.getClass();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - date.getTime() >= sentryOptions.getSessionReplay().f51866j) {
                    CaptureStrategy.ReplaySegment replaySegmentL = BaseCaptureStrategy.l(this$0, sentryOptions.getSessionReplay().f51866j, date, this$0.d(), this$0.f(), i2, i3);
                    if (replaySegmentL instanceof CaptureStrategy.ReplaySegment.Created) {
                        CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) replaySegmentL;
                        created.a(this$0.s, new Hint());
                        this$0.e(this$0.f() + 1);
                        this$0.i(created.f52586a.u);
                    }
                }
                if (jCurrentTimeMillis2 - this$0.f52530k.get() >= sentryOptions.getSessionReplay().f51867k) {
                    sentryOptions.getReplayController().stop();
                    sentryOptions.getLogger().c(SentryLevel.INFO, "Session replay deadline exceeded (1h), stopping recording", new Object[0]);
                }
            }
        };
        ExecutorsKt.c(this.f52523d, this.r, "SessionCaptureStrategy.add_frame", runnable);
    }

    public final void n(String str, Function1 function1) {
        this.t.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Date date = (Date) this.f52529j.a(this, BaseCaptureStrategy.q[1]);
        if (date == null) {
            return;
        }
        int iF = f();
        long time = jCurrentTimeMillis - date.getTime();
        SentryId sentryIdD = d();
        int i2 = m().f52486b;
        int i3 = m().f52485a;
        ExecutorsKt.c(this.f52523d, this.r, "SessionCaptureStrategy.".concat(str), new a(this, time, date, sentryIdD, iF, i2, i3, function1));
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void pause() {
        n(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE, new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.SessionCaptureStrategy.pause.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    SessionCaptureStrategy sessionCaptureStrategy = SessionCaptureStrategy.this;
                    ((CaptureStrategy.ReplaySegment.Created) segment).a(sessionCaptureStrategy.s, new Hint());
                    sessionCaptureStrategy.e(sessionCaptureStrategy.f() + 1);
                }
                return Unit.f53572a;
            }
        });
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void stop() {
        ReplayCache replayCache = this.f52527h;
        final File fileB = replayCache != null ? replayCache.b() : null;
        n("stop", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.SessionCaptureStrategy.stop.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    ((CaptureStrategy.ReplaySegment.Created) segment).a(SessionCaptureStrategy.this.s, new Hint());
                }
                FileUtils.a(fileB);
                return Unit.f53572a;
            }
        });
        if (this.s != null) {
            Sentry.c(new com.google.common.net.a(8));
        }
        super.stop();
    }
}
