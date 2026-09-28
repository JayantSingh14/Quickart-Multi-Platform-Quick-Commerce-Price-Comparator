package io.sentry.android.replay.capture;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import androidx.media3.exoplayer.analytics.l;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ReplayFrame;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.SamplingKt;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.util.Random;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BufferCaptureStrategy extends BaseCaptureStrategy {
    public static final /* synthetic */ int w = 0;
    public final SentryOptions r;
    public final HubAdapter s;
    public final CurrentDateProvider t;
    public final Random u;
    public final ArrayList v;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferCaptureStrategy(SentryOptions options, HubAdapter hubAdapter, CurrentDateProvider dateProvider, Random random, ScheduledExecutorService executor) {
        super(options, hubAdapter, dateProvider, executor);
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.r = options;
        this.s = hubAdapter;
        this.t = dateProvider;
        this.u = random;
        this.v = new ArrayList();
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.a(event);
        this.t.getClass();
        CaptureStrategy.Companion.b(this.p, System.currentTimeMillis() - this.r.getSessionReplay().f51865i, null);
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void b(ScreenshotRecorderConfig recorderConfig) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        n("configuration_changed", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$onConfigurationChanged$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    BufferCaptureStrategy bufferCaptureStrategy = this.f52579c;
                    bufferCaptureStrategy.v.add(segment);
                    bufferCaptureStrategy.e(bufferCaptureStrategy.f() + 1);
                }
                return Unit.f53572a;
            }
        });
        super.b(recorderConfig);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void g(boolean z, final Function1 onSegmentSent) {
        Intrinsics.checkNotNullParameter(onSegmentSent, "onSegmentSent");
        SentryOptions sentryOptions = this.r;
        if (!SamplingKt.a(this.u, sentryOptions.getSessionReplay().f51858b)) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Replay wasn't sampled by onErrorSampleRate, not capturing for event", new Object[0]);
            return;
        }
        if (this.s != null) {
            Sentry.c(new l(this, 28));
        }
        if (!z) {
            n("capture_replay", new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$captureReplay$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) throws InterruptedException {
                    HubAdapter hubAdapter;
                    CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                    Intrinsics.checkNotNullParameter(segment, "segment");
                    BufferCaptureStrategy bufferCaptureStrategy = this.f52577c;
                    ArrayList arrayList = bufferCaptureStrategy.v;
                    Intrinsics.checkNotNullParameter(arrayList, "<this>");
                    CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) (arrayList.isEmpty() ? null : arrayList.remove(0));
                    while (true) {
                        hubAdapter = bufferCaptureStrategy.s;
                        if (created == null) {
                            break;
                        }
                        created.a(hubAdapter, new Hint());
                        Intrinsics.checkNotNullParameter(arrayList, "<this>");
                        created = (CaptureStrategy.ReplaySegment.Created) (arrayList.isEmpty() ? null : arrayList.remove(0));
                        Thread.sleep(100L);
                    }
                    if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                        CaptureStrategy.ReplaySegment.Created created2 = (CaptureStrategy.ReplaySegment.Created) segment;
                        created2.a(hubAdapter, new Hint());
                        Date date = created2.f52586a.u;
                        Intrinsics.checkNotNullExpressionValue(date, "segment.replay.timestamp");
                        onSegmentSent.invoke(date);
                    }
                    return Unit.f53572a;
                }
            });
        } else {
            this.f52526g.set(true);
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Not capturing replay for crashed event, will be captured on next launch", new Object[0]);
        }
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final CaptureStrategy h() {
        boolean z = this.f52526g.get();
        SentryOptions sentryOptions = this.r;
        if (z) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Not converting to session mode, because the process is about to terminate", new Object[0]);
            return this;
        }
        SessionCaptureStrategy sessionCaptureStrategy = new SessionCaptureStrategy(sentryOptions, this.s, this.t, this.f52523d);
        sessionCaptureStrategy.c(m(), f(), d(), SentryReplayEvent.ReplayType.BUFFER);
        return sessionCaptureStrategy;
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void j(final Function2 store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.t.getClass();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Runnable runnable = new Runnable() { // from class: io.sentry.android.replay.capture.b
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = BufferCaptureStrategy.w;
                final BufferCaptureStrategy this$0 = this.f52602a;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Function2 store2 = store;
                Intrinsics.checkNotNullParameter(store2, "$store");
                ReplayCache replayCache = this$0.f52527h;
                if (replayCache != null) {
                    store2.invoke(replayCache, Long.valueOf(jCurrentTimeMillis));
                }
                this$0.t.getClass();
                final long jCurrentTimeMillis2 = System.currentTimeMillis() - this$0.r.getSessionReplay().f51865i;
                ReplayCache replayCache2 = this$0.f52527h;
                String strE = replayCache2 != null ? replayCache2.e(jCurrentTimeMillis2) : null;
                KProperty property = BaseCaptureStrategy.q[2];
                BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 = this$0.f52531l;
                baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.getClass();
                Intrinsics.checkNotNullParameter(property, "property");
                Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52568a.getAndSet(strE);
                if (!Intrinsics.b(andSet, strE)) {
                    BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass2(andSet, strE, baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52570c);
                    BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.f52569b;
                    boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
                    SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
                    if (zA) {
                        ExecutorsKt.c(BaseCaptureStrategy.k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2.AnonymousClass1(anonymousClass2));
                    } else {
                        try {
                            anonymousClass2.invoke();
                        } catch (Throwable th) {
                            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
                        }
                    }
                }
                ArrayList arrayList = this$0.v;
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                CollectionsKt.N(arrayList, new Function1<CaptureStrategy.ReplaySegment.Created, Boolean>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy$rotate$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CaptureStrategy.ReplaySegment.Created it = (CaptureStrategy.ReplaySegment.Created) obj;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it.f52586a.u.getTime() >= jCurrentTimeMillis2) {
                            return Boolean.FALSE;
                        }
                        BufferCaptureStrategy bufferCaptureStrategy = this$0;
                        bufferCaptureStrategy.e(bufferCaptureStrategy.f() - 1);
                        File file = it.f52586a.p;
                        SentryOptions sentryOptions2 = bufferCaptureStrategy.r;
                        if (file != null) {
                            try {
                                if (!file.delete()) {
                                    sentryOptions2.getLogger().c(SentryLevel.ERROR, "Failed to delete replay segment: %s", file.getAbsolutePath());
                                }
                            } catch (Throwable th2) {
                                sentryOptions2.getLogger().a(SentryLevel.ERROR, th2, "Failed to delete replay segment: %s", file.getAbsolutePath());
                            }
                        }
                        booleanRef.f53798a = true;
                        return Boolean.TRUE;
                    }
                });
                if (booleanRef.f53798a) {
                    Iterator it = arrayList.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.b0();
                            throw null;
                        }
                        CaptureStrategy.ReplaySegment.Created created = (CaptureStrategy.ReplaySegment.Created) next;
                        created.f52586a.t = i3;
                        List<RRWebEvent> list = created.f52587b.f51752b;
                        if (list != null) {
                            for (RRWebEvent rRWebEvent : list) {
                                if (rRWebEvent instanceof RRWebVideoEvent) {
                                    ((RRWebVideoEvent) rRWebEvent).f53068d = i3;
                                }
                            }
                        }
                        i3 = i4;
                    }
                }
            }
        };
        ExecutorsKt.c(this.f52523d, this.r, "BufferCaptureStrategy.add_frame", runnable);
    }

    public final void n(String str, Function1 function1) {
        Date dateB;
        ArrayList arrayList;
        SentryOptions sentryOptions = this.r;
        long j2 = sentryOptions.getSessionReplay().f51865i;
        this.t.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ReplayCache replayCache = this.f52527h;
        if (replayCache == null || (arrayList = replayCache.f52423g) == null || !(!arrayList.isEmpty())) {
            dateB = DateUtils.b(jCurrentTimeMillis - j2);
        } else {
            ReplayCache replayCache2 = this.f52527h;
            Intrinsics.c(replayCache2);
            dateB = DateUtils.b(((ReplayFrame) CollectionsKt.z(replayCache2.f52423g)).f52433b);
        }
        Intrinsics.checkNotNullExpressionValue(dateB, "if (cache?.frames?.isNot…ReplayDuration)\n        }");
        ExecutorsKt.c(this.f52523d, sentryOptions, "BufferCaptureStrategy.".concat(str), new a(this, jCurrentTimeMillis - dateB.getTime(), dateB, d(), f(), m().f52486b, m().f52485a, function1));
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void pause() {
        n(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE, new Function1<CaptureStrategy.ReplaySegment, Unit>() { // from class: io.sentry.android.replay.capture.BufferCaptureStrategy.pause.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CaptureStrategy.ReplaySegment segment = (CaptureStrategy.ReplaySegment) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                if (segment instanceof CaptureStrategy.ReplaySegment.Created) {
                    BufferCaptureStrategy bufferCaptureStrategy = BufferCaptureStrategy.this;
                    bufferCaptureStrategy.v.add(segment);
                    bufferCaptureStrategy.e(bufferCaptureStrategy.f() + 1);
                }
                return Unit.f53572a;
            }
        });
    }

    @Override // io.sentry.android.replay.capture.BaseCaptureStrategy, io.sentry.android.replay.capture.CaptureStrategy
    public final void stop() {
        ReplayCache replayCache = this.f52527h;
        ExecutorsKt.c(this.f52523d, this.r, "BufferCaptureStrategy.stop", new com.swmansion.gesturehandler.react.b(replayCache != null ? replayCache.b() : null, 10));
        super.stop();
    }
}
