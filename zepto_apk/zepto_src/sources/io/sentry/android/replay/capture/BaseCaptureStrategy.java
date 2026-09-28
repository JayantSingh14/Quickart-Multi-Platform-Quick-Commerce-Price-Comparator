package io.sentry.android.replay.capture;

import android.annotation.TargetApi;
import io.sentry.DateUtils;
import io.sentry.HubAdapter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$1;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3;
import io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.gestures.ReplayGestureConverter;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.protocol.SentryId;
import io.sentry.transport.CurrentDateProvider;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;

@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class BaseCaptureStrategy implements CaptureStrategy {
    public static final /* synthetic */ KProperty[] q;

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52520a;

    /* renamed from: b, reason: collision with root package name */
    public final HubAdapter f52521b;

    /* renamed from: c, reason: collision with root package name */
    public final CurrentDateProvider f52522c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f52523d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f52524e;

    /* renamed from: f, reason: collision with root package name */
    public final ReplayGestureConverter f52525f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f52526g;

    /* renamed from: h, reason: collision with root package name */
    public ReplayCache f52527h;

    /* renamed from: i, reason: collision with root package name */
    public final BaseCaptureStrategy$special$$inlined$persistableAtomic$1 f52528i;

    /* renamed from: j, reason: collision with root package name */
    public final BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1 f52529j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicLong f52530k;

    /* renamed from: l, reason: collision with root package name */
    public final BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2 f52531l;

    /* renamed from: m, reason: collision with root package name */
    public final BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1 f52532m;
    public final BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2 n;
    public final BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3 o;
    public final ConcurrentLinkedDeque p;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class ReplayPersistingExecutorServiceThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f52575a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            StringBuilder sb = new StringBuilder("SentryReplayPersister-");
            int i2 = this.f52575a;
            this.f52575a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(r, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl("recorderConfig", "getRecorderConfig()Lio/sentry/android/replay/ScreenshotRecorderConfig;", BaseCaptureStrategy.class);
        Reflection.f53802a.getClass();
        q = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl("segmentTimestamp", "getSegmentTimestamp()Ljava/util/Date;", BaseCaptureStrategy.class), new MutablePropertyReference1Impl("screenAtStart", "getScreenAtStart()Ljava/lang/String;", BaseCaptureStrategy.class), new MutablePropertyReference1Impl("currentReplayId", "getCurrentReplayId()Lio/sentry/protocol/SentryId;", BaseCaptureStrategy.class), new MutablePropertyReference1Impl("currentSegment", "getCurrentSegment()I", BaseCaptureStrategy.class), new MutablePropertyReference1Impl("replayType", "getReplayType()Lio/sentry/SentryReplayEvent$ReplayType;", BaseCaptureStrategy.class)};
    }

    public BaseCaptureStrategy(SentryOptions options, HubAdapter hubAdapter, CurrentDateProvider dateProvider, ScheduledExecutorService replayExecutor) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(replayExecutor, "replayExecutor");
        this.f52520a = options;
        this.f52521b = hubAdapter;
        this.f52522c = dateProvider;
        this.f52523d = replayExecutor;
        this.f52524e = LazyKt.b(BaseCaptureStrategy$persistingExecutor$2.f52576c);
        this.f52525f = new ReplayGestureConverter(dateProvider);
        this.f52526g = new AtomicBoolean(false);
        this.f52528i = new BaseCaptureStrategy$special$$inlined$persistableAtomic$1(this, this);
        this.f52529j = new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1(this, this);
        this.f52530k = new AtomicLong();
        this.f52531l = new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$2(this, this);
        this.f52532m = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1(SentryId.f52907b, this, this);
        this.n = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2(this, this);
        this.o = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3(this, this);
        this.p = new ConcurrentLinkedDeque();
    }

    public static final ScheduledExecutorService k(BaseCaptureStrategy baseCaptureStrategy) {
        Object value = baseCaptureStrategy.f52524e.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-persistingExecutor>(...)");
        return (ScheduledExecutorService) value;
    }

    public static CaptureStrategy.ReplaySegment l(BaseCaptureStrategy baseCaptureStrategy, long j2, Date currentSegmentTimestamp, SentryId replayId, int i2, int i3, int i4) {
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3 baseCaptureStrategy$special$$inlined$persistableAtomic$default$3 = baseCaptureStrategy.o;
        KProperty[] kPropertyArr = q;
        SentryReplayEvent.ReplayType replayType = (SentryReplayEvent.ReplayType) baseCaptureStrategy$special$$inlined$persistableAtomic$default$3.a(baseCaptureStrategy, kPropertyArr[5]);
        ReplayCache replayCache = baseCaptureStrategy.f52527h;
        int i5 = baseCaptureStrategy.m().f52489e;
        int i6 = baseCaptureStrategy.m().f52490f;
        String str = (String) baseCaptureStrategy.f52531l.a(baseCaptureStrategy, kPropertyArr[2]);
        ConcurrentLinkedDeque events = baseCaptureStrategy.p;
        baseCaptureStrategy.getClass();
        Intrinsics.checkNotNullParameter(currentSegmentTimestamp, "currentSegmentTimestamp");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        Intrinsics.checkNotNullParameter(replayType, "replayType");
        Intrinsics.checkNotNullParameter(events, "events");
        return CaptureStrategy.Companion.a(baseCaptureStrategy.f52521b, baseCaptureStrategy.f52520a, j2, currentSegmentTimestamp, replayId, i2, i3, i4, replayType, replayCache, i5, i6, str, null, events);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bd  */
    @Override // io.sentry.android.replay.capture.CaptureStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.capture.BaseCaptureStrategy.a(android.view.MotionEvent):void");
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void b(ScreenshotRecorderConfig recorderConfig) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(recorderConfig, "<set-?>");
        KProperty property = q[0];
        BaseCaptureStrategy$special$$inlined$persistableAtomic$1 baseCaptureStrategy$special$$inlined$persistableAtomic$1 = this.f52528i;
        baseCaptureStrategy$special$$inlined$persistableAtomic$1.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52533a.getAndSet(recorderConfig);
        if (Intrinsics.b(andSet, recorderConfig)) {
            return;
        }
        BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass2(andSet, recorderConfig, baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52535c);
        BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52534b;
        boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
        SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
        if (zA) {
            ExecutorsKt.c(k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass1(anonymousClass2));
            return;
        }
        try {
            anonymousClass2.invoke();
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void c(ScreenshotRecorderConfig recorderConfig, int i2, SentryId replayId, SentryReplayEvent.ReplayType replayType) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        this.f52527h = new ReplayCache(this.f52520a, replayId);
        Intrinsics.checkNotNullParameter(replayId, "<set-?>");
        KProperty[] kPropertyArr = q;
        KProperty property = kPropertyArr[3];
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1 baseCaptureStrategy$special$$inlined$persistableAtomic$default$1 = this.f52532m;
        baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52540a.getAndSet(replayId);
        if (!Intrinsics.b(andSet, replayId)) {
            BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass2(andSet, replayId, baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52542c);
            BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52541b;
            boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
            SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
            if (zA) {
                ExecutorsKt.c(k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass1(anonymousClass2));
            } else {
                try {
                    anonymousClass2.invoke();
                } catch (Throwable th) {
                    sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
                }
            }
        }
        e(i2);
        if (replayType == null) {
            replayType = this instanceof SessionCaptureStrategy ? SentryReplayEvent.ReplayType.SESSION : SentryReplayEvent.ReplayType.BUFFER;
        }
        Intrinsics.checkNotNullParameter(replayType, "<set-?>");
        KProperty property2 = kPropertyArr[5];
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3 baseCaptureStrategy$special$$inlined$persistableAtomic$default$3 = this.o;
        baseCaptureStrategy$special$$inlined$persistableAtomic$default$3.getClass();
        Intrinsics.checkNotNullParameter(property2, "property");
        Object andSet2 = baseCaptureStrategy$special$$inlined$persistableAtomic$default$3.f52554a.getAndSet(replayType);
        if (!Intrinsics.b(andSet2, replayType)) {
            final BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3.AnonymousClass2 anonymousClass22 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3.AnonymousClass2(andSet2, replayType, baseCaptureStrategy$special$$inlined$persistableAtomic$default$3.f52556c);
            BaseCaptureStrategy baseCaptureStrategy2 = baseCaptureStrategy$special$$inlined$persistableAtomic$default$3.f52555b;
            boolean zA2 = baseCaptureStrategy2.f52520a.getMainThreadChecker().a();
            SentryOptions sentryOptions2 = baseCaptureStrategy2.f52520a;
            if (zA2) {
                ExecutorsKt.c(k(baseCaptureStrategy2), sentryOptions2, "CaptureStrategy.runInBackground", new Runnable() { // from class: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        anonymousClass22.invoke();
                    }
                });
            } else {
                try {
                    anonymousClass22.invoke();
                } catch (Throwable th2) {
                    sentryOptions2.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th2);
                }
            }
        }
        Intrinsics.checkNotNullParameter(recorderConfig, "<set-?>");
        KProperty property3 = kPropertyArr[0];
        BaseCaptureStrategy$special$$inlined$persistableAtomic$1 baseCaptureStrategy$special$$inlined$persistableAtomic$1 = this.f52528i;
        baseCaptureStrategy$special$$inlined$persistableAtomic$1.getClass();
        Intrinsics.checkNotNullParameter(property3, "property");
        Object andSet3 = baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52533a.getAndSet(recorderConfig);
        if (!Intrinsics.b(andSet3, recorderConfig)) {
            BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass2 anonymousClass23 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass2(andSet3, recorderConfig, baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52535c);
            BaseCaptureStrategy baseCaptureStrategy3 = baseCaptureStrategy$special$$inlined$persistableAtomic$1.f52534b;
            boolean zA3 = baseCaptureStrategy3.f52520a.getMainThreadChecker().a();
            SentryOptions sentryOptions3 = baseCaptureStrategy3.f52520a;
            if (zA3) {
                ExecutorsKt.c(k(baseCaptureStrategy3), sentryOptions3, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomic$1.AnonymousClass1(anonymousClass23));
            } else {
                try {
                    anonymousClass23.invoke();
                } catch (Throwable th3) {
                    sentryOptions3.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th3);
                }
            }
        }
        i(DateUtils.a());
        AtomicLong atomicLong = this.f52530k;
        this.f52522c.getClass();
        atomicLong.set(System.currentTimeMillis());
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final SentryId d() {
        return (SentryId) this.f52532m.a(this, q[3]);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void e(int i2) {
        KProperty property = q[4];
        Integer numValueOf = Integer.valueOf(i2);
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2 baseCaptureStrategy$special$$inlined$persistableAtomic$default$2 = this.n;
        baseCaptureStrategy$special$$inlined$persistableAtomic$default$2.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomic$default$2.f52547a.getAndSet(numValueOf);
        if (Intrinsics.b(andSet, numValueOf)) {
            return;
        }
        final BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2.AnonymousClass2(andSet, numValueOf, baseCaptureStrategy$special$$inlined$persistableAtomic$default$2.f52549c);
        BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomic$default$2.f52548b;
        boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
        SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
        if (zA) {
            ExecutorsKt.c(k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new Runnable() { // from class: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomic$default$2.1
                @Override // java.lang.Runnable
                public final void run() {
                    anonymousClass2.invoke();
                }
            });
            return;
        }
        try {
            anonymousClass2.invoke();
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final int f() {
        return ((Number) this.n.a(this, q[4])).intValue();
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void i(Date date) {
        KProperty property = q[1];
        BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1 baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1 = this.f52529j;
        baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.f52561a.getAndSet(date);
        if (Intrinsics.b(andSet, date)) {
            return;
        }
        final BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.AnonymousClass2(andSet, date, baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.f52563c);
        BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.f52562b;
        boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
        SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
        if (zA) {
            ExecutorsKt.c(k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new Runnable() { // from class: io.sentry.android.replay.capture.BaseCaptureStrategy$special$$inlined$persistableAtomicNullable$default$1.1
                @Override // java.lang.Runnable
                public final void run() {
                    anonymousClass2.invoke();
                }
            });
            return;
        }
        try {
            anonymousClass2.invoke();
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    public final ScreenshotRecorderConfig m() {
        return (ScreenshotRecorderConfig) this.f52528i.a(this, q[0]);
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void pause() {
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public final void resume() {
        i(DateUtils.a());
    }

    @Override // io.sentry.android.replay.capture.CaptureStrategy
    public void stop() {
        ReplayCache replayCache = this.f52527h;
        if (replayCache != null) {
            replayCache.close();
        }
        e(-1);
        this.f52530k.set(0L);
        i(null);
        SentryId EMPTY_ID = SentryId.f52907b;
        Intrinsics.checkNotNullExpressionValue(EMPTY_ID, "EMPTY_ID");
        Intrinsics.checkNotNullParameter(EMPTY_ID, "<set-?>");
        KProperty property = q[3];
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1 baseCaptureStrategy$special$$inlined$persistableAtomic$default$1 = this.f52532m;
        baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        Object andSet = baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52540a.getAndSet(EMPTY_ID);
        if (Intrinsics.b(andSet, EMPTY_ID)) {
            return;
        }
        BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass2 anonymousClass2 = new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass2(andSet, EMPTY_ID, baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52542c);
        BaseCaptureStrategy baseCaptureStrategy = baseCaptureStrategy$special$$inlined$persistableAtomic$default$1.f52541b;
        boolean zA = baseCaptureStrategy.f52520a.getMainThreadChecker().a();
        SentryOptions sentryOptions = baseCaptureStrategy.f52520a;
        if (zA) {
            ExecutorsKt.c(k(baseCaptureStrategy), sentryOptions, "CaptureStrategy.runInBackground", new BaseCaptureStrategy$special$$inlined$persistableAtomic$default$1.AnonymousClass1(anonymousClass2));
            return;
        }
        try {
            anonymousClass2.invoke();
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }
}
