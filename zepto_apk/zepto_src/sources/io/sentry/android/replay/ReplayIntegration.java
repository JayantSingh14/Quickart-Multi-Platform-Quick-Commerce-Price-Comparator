package io.sentry.android.replay;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.DataCategory;
import io.sentry.HubAdapter;
import io.sentry.IConnectionStatusProvider;
import io.sentry.IScope;
import io.sentry.ISentryExecutorService;
import io.sentry.Integration;
import io.sentry.NoOpReplayBreadcrumbConverter;
import io.sentry.ReplayBreadcrumbConverter;
import io.sentry.ReplayController;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.android.replay.capture.BaseCaptureStrategy;
import io.sentry.android.replay.capture.BufferCaptureStrategy;
import io.sentry.android.replay.capture.CaptureStrategy;
import io.sentry.android.replay.capture.SessionCaptureStrategy;
import io.sentry.android.replay.gestures.GestureRecorder;
import io.sentry.android.replay.gestures.TouchRecorderCallback;
import io.sentry.android.replay.util.ExecutorsKt;
import io.sentry.android.replay.util.MainLooperHandler;
import io.sentry.android.replay.util.SamplingKt;
import io.sentry.hints.Backfillable;
import io.sentry.protocol.SentryId;
import io.sentry.react.RNSentryReplayBreadcrumbConverter;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.RateLimiter;
import io.sentry.util.FileUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Random;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@StabilityInferred(parameters = 0)
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReplayIntegration implements Integration, Closeable, ScreenshotRecorderCallback, TouchRecorderCallback, ReplayController, ComponentCallbacks, IConnectionStatusProvider.IConnectionStatusObserver, RateLimiter.IRateLimitObserver, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52435a;

    /* renamed from: b, reason: collision with root package name */
    public final CurrentDateProvider f52436b;

    /* renamed from: c, reason: collision with root package name */
    public SentryOptions f52437c;

    /* renamed from: d, reason: collision with root package name */
    public HubAdapter f52438d;

    /* renamed from: e, reason: collision with root package name */
    public Recorder f52439e;

    /* renamed from: f, reason: collision with root package name */
    public GestureRecorder f52440f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f52441g;

    /* renamed from: h, reason: collision with root package name */
    public final Lazy f52442h;

    /* renamed from: i, reason: collision with root package name */
    public final Lazy f52443i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f52444j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f52445k;

    /* renamed from: l, reason: collision with root package name */
    public CaptureStrategy f52446l;

    /* renamed from: m, reason: collision with root package name */
    public ReplayBreadcrumbConverter f52447m;
    public final MainLooperHandler n;
    public final ReplayLifecycle o;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class PreviousReplayHint implements Backfillable {
        @Override // io.sentry.hints.Backfillable
        public final boolean a() {
            return false;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class ReplayExecutorServiceThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f52448a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r) {
            Intrinsics.checkNotNullParameter(r, "r");
            StringBuilder sb = new StringBuilder("SentryReplayIntegration-");
            int i2 = this.f52448a;
            this.f52448a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(r, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public ReplayIntegration(Context context) {
        CurrentDateProvider dateProvider = CurrentDateProvider.f53091a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Context applicationContext = context.getApplicationContext();
        context = applicationContext != null ? applicationContext : context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.f52435a = context;
        this.f52436b = dateProvider;
        this.f52441g = LazyKt.b(ReplayIntegration$random$2.f52453c);
        this.f52442h = LazyKt.b(ReplayIntegration$rootViewsSpy$2.f52455c);
        this.f52443i = LazyKt.b(ReplayIntegration$replayExecutor$2.f52454c);
        this.f52444j = new AtomicBoolean(false);
        this.f52445k = new AtomicBoolean(false);
        NoOpReplayBreadcrumbConverter noOpReplayBreadcrumbConverter = NoOpReplayBreadcrumbConverter.f51708a;
        Intrinsics.checkNotNullExpressionValue(noOpReplayBreadcrumbConverter, "getInstance()");
        this.f52447m = noOpReplayBreadcrumbConverter;
        this.n = new MainLooperHandler(0);
        this.o = new ReplayLifecycle();
    }

    public final synchronized void A() {
        try {
            if (this.f52444j.get()) {
                ReplayLifecycle replayLifecycle = this.o;
                ReplayState replayState = ReplayState.PAUSED;
                if (replayLifecycle.a(replayState)) {
                    Recorder recorder = this.f52439e;
                    if (recorder != null) {
                        recorder.pause();
                    }
                    CaptureStrategy captureStrategy = this.f52446l;
                    if (captureStrategy != null) {
                        captureStrategy.pause();
                    }
                    ReplayLifecycle replayLifecycle2 = this.o;
                    replayLifecycle2.getClass();
                    Intrinsics.checkNotNullParameter(replayState, "<set-?>");
                    replayLifecycle2.f52456a = replayState;
                }
            }
        } finally {
        }
    }

    public final synchronized void D() {
        HubAdapter hubAdapter;
        HubAdapter hubAdapter2;
        RateLimiter rateLimiterO;
        RateLimiter rateLimiterO2;
        try {
            if (this.f52444j.get()) {
                ReplayLifecycle replayLifecycle = this.o;
                ReplayState replayState = ReplayState.RESUMED;
                if (replayLifecycle.a(replayState)) {
                    if (!this.f52445k.get()) {
                        SentryOptions sentryOptions = this.f52437c;
                        if (sentryOptions == null) {
                            Intrinsics.h("options");
                            throw null;
                        }
                        if (sentryOptions.getConnectionStatusProvider().b() != IConnectionStatusProvider.ConnectionStatus.DISCONNECTED && (((hubAdapter = this.f52438d) == null || (rateLimiterO2 = hubAdapter.o()) == null || !rateLimiterO2.b(DataCategory.All)) && ((hubAdapter2 = this.f52438d) == null || (rateLimiterO = hubAdapter2.o()) == null || !rateLimiterO.b(DataCategory.Replay)))) {
                            CaptureStrategy captureStrategy = this.f52446l;
                            if (captureStrategy != null) {
                                captureStrategy.resume();
                            }
                            Recorder recorder = this.f52439e;
                            if (recorder != null) {
                                recorder.resume();
                            }
                            ReplayLifecycle replayLifecycle2 = this.o;
                            replayLifecycle2.getClass();
                            Intrinsics.checkNotNullParameter(replayState, "<set-?>");
                            replayLifecycle2.f52456a = replayState;
                        }
                    }
                }
            }
        } finally {
        }
    }

    @Override // io.sentry.IConnectionStatusProvider.IConnectionStatusObserver
    public final void a(IConnectionStatusProvider.ConnectionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (this.f52446l instanceof SessionCaptureStrategy) {
            if (status == IConnectionStatusProvider.ConnectionStatus.DISCONNECTED) {
                A();
            } else {
                D();
            }
        }
    }

    @Override // io.sentry.ReplayController
    public final synchronized void b(Boolean bool) {
        try {
            if (this.f52444j.get()) {
                if (this.o.f52456a.compareTo(ReplayState.STARTED) >= 0 && this.o.f52456a.compareTo(ReplayState.STOPPED) < 0) {
                    SentryId sentryId = SentryId.f52907b;
                    CaptureStrategy captureStrategy = this.f52446l;
                    if (sentryId.equals(captureStrategy != null ? captureStrategy.d() : null)) {
                        SentryOptions sentryOptions = this.f52437c;
                        if (sentryOptions != null) {
                            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Replay id is not set, not capturing for event", new Object[0]);
                            return;
                        } else {
                            Intrinsics.h("options");
                            throw null;
                        }
                    }
                    CaptureStrategy captureStrategy2 = this.f52446l;
                    if (captureStrategy2 != null) {
                        captureStrategy2.g(bool.equals(Boolean.TRUE), new Function1<Date, Unit>() { // from class: io.sentry.android.replay.ReplayIntegration$captureReplay$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Date newTimestamp = (Date) obj;
                                Intrinsics.checkNotNullParameter(newTimestamp, "newTimestamp");
                                ReplayIntegration replayIntegration = this.f52449c;
                                CaptureStrategy captureStrategy3 = replayIntegration.f52446l;
                                if (captureStrategy3 != null) {
                                    captureStrategy3.e(Integer.valueOf(captureStrategy3.f()).intValue() + 1);
                                }
                                CaptureStrategy captureStrategy4 = replayIntegration.f52446l;
                                if (captureStrategy4 != null) {
                                    captureStrategy4.i(newTimestamp);
                                }
                                return Unit.f53572a;
                            }
                        });
                    }
                    CaptureStrategy captureStrategy3 = this.f52446l;
                    this.f52446l = captureStrategy3 != null ? captureStrategy3.h() : null;
                }
            }
        } finally {
        }
    }

    @Override // io.sentry.ReplayController
    public final void c(RNSentryReplayBreadcrumbConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.f52447m = converter;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        RateLimiter rateLimiterO;
        try {
            if (this.f52444j.get() && this.o.a(ReplayState.CLOSED)) {
                SentryOptions sentryOptions = this.f52437c;
                if (sentryOptions == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                sentryOptions.getConnectionStatusProvider().d(this);
                HubAdapter hubAdapter = this.f52438d;
                if (hubAdapter != null && (rateLimiterO = hubAdapter.o()) != null) {
                    rateLimiterO.f53110d.remove(this);
                }
                SentryOptions sentryOptions2 = this.f52437c;
                if (sentryOptions2 == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                if (sentryOptions2.getSessionReplay().f51868l) {
                    try {
                        this.f52435a.unregisterComponentCallbacks(this);
                    } catch (Throwable unused) {
                    }
                }
                stop();
                Recorder recorder = this.f52439e;
                if (recorder != null) {
                    recorder.close();
                }
                this.f52439e = null;
                ((RootViewsSpy) this.f52442h.getValue()).close();
                ScheduledExecutorService replayExecutor = (ScheduledExecutorService) this.f52443i.getValue();
                Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
                SentryOptions sentryOptions3 = this.f52437c;
                if (sentryOptions3 == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                ExecutorsKt.a(replayExecutor, sentryOptions3);
                ReplayLifecycle replayLifecycle = this.o;
                ReplayState replayState = ReplayState.CLOSED;
                replayLifecycle.getClass();
                Intrinsics.checkNotNullParameter(replayState, "<set-?>");
                replayLifecycle.f52456a = replayState;
            }
        } finally {
        }
    }

    @Override // io.sentry.transport.RateLimiter.IRateLimitObserver
    public final void e(RateLimiter rateLimiter) {
        Intrinsics.checkNotNullParameter(rateLimiter, "rateLimiter");
        if (this.f52446l instanceof SessionCaptureStrategy) {
            if (rateLimiter.b(DataCategory.All) || rateLimiter.b(DataCategory.Replay)) {
                A();
            } else {
                D();
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions options) {
        Double d2;
        HubAdapter hub = HubAdapter.f51658a;
        Intrinsics.checkNotNullParameter(hub, "hub");
        Intrinsics.checkNotNullParameter(options, "options");
        this.f52437c = options;
        if (Build.VERSION.SDK_INT < 26) {
            options.getLogger().c(SentryLevel.INFO, "Session replay is only supported on API 26 and above", new Object[0]);
            return;
        }
        Double d3 = options.getSessionReplay().f51857a;
        if ((d3 == null || d3.doubleValue() <= 0.0d) && ((d2 = options.getSessionReplay().f51858b) == null || d2.doubleValue() <= 0.0d)) {
            options.getLogger().c(SentryLevel.INFO, "Session replay is disabled, no sample rate specified", new Object[0]);
            return;
        }
        this.f52438d = hub;
        ScheduledExecutorService replayExecutor = (ScheduledExecutorService) this.f52443i.getValue();
        Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
        this.f52439e = new WindowRecorder(options, this, this.n, replayExecutor);
        this.f52440f = new GestureRecorder(options, this);
        this.f52444j.set(true);
        options.getConnectionStatusProvider().c(this);
        RateLimiter rateLimiterO = hub.o();
        if (rateLimiterO != null) {
            rateLimiterO.f53110d.add(this);
        }
        if (options.getSessionReplay().f51868l) {
            try {
                this.f52435a.registerComponentCallbacks(this);
            } catch (Throwable th) {
                options.getLogger().b(SentryLevel.INFO, "ComponentCallbacks is not available, orientation changes won't be handled by Session replay", th);
            }
        }
        IntegrationUtils.a("Replay");
        SentryIntegrationPackageStorage.c().b("maven:io.sentry:sentry-android-replay", "7.22.5");
        SentryOptions sentryOptions = this.f52437c;
        if (sentryOptions == null) {
            Intrinsics.h("options");
            throw null;
        }
        ISentryExecutorService executorService = sentryOptions.getExecutorService();
        Intrinsics.checkNotNullExpressionValue(executorService, "options.executorService");
        SentryOptions sentryOptions2 = this.f52437c;
        if (sentryOptions2 != null) {
            ExecutorsKt.b(executorService, sentryOptions2, new c(this, 0));
        } else {
            Intrinsics.h("options");
            throw null;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Recorder recorder;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (!this.f52444j.get() || this.o.f52456a.compareTo(ReplayState.STARTED) < 0 || this.o.f52456a.compareTo(ReplayState.STOPPED) >= 0) {
            return;
        }
        Recorder recorder2 = this.f52439e;
        if (recorder2 != null) {
            recorder2.stop();
        }
        Context context = this.f52435a;
        SentryOptions sentryOptions = this.f52437c;
        if (sentryOptions == null) {
            Intrinsics.h("options");
            throw null;
        }
        SentryReplayOptions sessionReplay = sentryOptions.getSessionReplay();
        Intrinsics.checkNotNullExpressionValue(sessionReplay, "options.sessionReplay");
        ScreenshotRecorderConfig screenshotRecorderConfigA = ScreenshotRecorderConfig.Companion.a(context, sessionReplay);
        CaptureStrategy captureStrategy = this.f52446l;
        if (captureStrategy != null) {
            captureStrategy.b(screenshotRecorderConfigA);
        }
        Recorder recorder3 = this.f52439e;
        if (recorder3 != null) {
            recorder3.i0(screenshotRecorderConfigA);
        }
        if (this.o.f52456a != ReplayState.PAUSED || (recorder = this.f52439e) == null) {
            return;
        }
        recorder.pause();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // io.sentry.ReplayController
    public final void pause() {
        this.f52445k.set(true);
        A();
    }

    @Override // io.sentry.ReplayController
    public final ReplayBreadcrumbConverter r() {
        return this.f52447m;
    }

    @Override // io.sentry.ReplayController
    public final void resume() {
        this.f52445k.set(false);
        D();
    }

    public final void s(String str) {
        File[] fileArrListFiles;
        SentryId EMPTY_ID;
        SentryOptions sentryOptions = this.f52437c;
        if (sentryOptions == null) {
            Intrinsics.h("options");
            throw null;
        }
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null || (fileArrListFiles = new File(cacheDirPath).listFiles()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles()");
        for (File file : fileArrListFiles) {
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            if (StringsKt.O(name, "replay_", false)) {
                CaptureStrategy captureStrategy = this.f52446l;
                if (captureStrategy == null || (EMPTY_ID = captureStrategy.d()) == null) {
                    EMPTY_ID = SentryId.f52907b;
                    Intrinsics.checkNotNullExpressionValue(EMPTY_ID, "EMPTY_ID");
                }
                String string = EMPTY_ID.toString();
                Intrinsics.checkNotNullExpressionValue(string, "replayId.toString()");
                if (!StringsKt.n(name, string, false) && (StringsKt.z(str) || !StringsKt.n(name, str, false))) {
                    FileUtils.a(file);
                }
            }
        }
    }

    @Override // io.sentry.ReplayController
    public final synchronized void start() {
        BaseCaptureStrategy bufferCaptureStrategy;
        if (this.f52444j.get()) {
            ReplayLifecycle replayLifecycle = this.o;
            ReplayState replayState = ReplayState.STARTED;
            if (!replayLifecycle.a(replayState)) {
                SentryOptions sentryOptions = this.f52437c;
                if (sentryOptions != null) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "Session replay is already being recorded, not starting a new one", new Object[0]);
                    return;
                } else {
                    Intrinsics.h("options");
                    throw null;
                }
            }
            Random random = (Random) this.f52441g.getValue();
            SentryOptions sentryOptions2 = this.f52437c;
            if (sentryOptions2 == null) {
                Intrinsics.h("options");
                throw null;
            }
            boolean zA = SamplingKt.a(random, sentryOptions2.getSessionReplay().f51857a);
            if (!zA) {
                SentryOptions sentryOptions3 = this.f52437c;
                if (sentryOptions3 == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                Double d2 = sentryOptions3.getSessionReplay().f51858b;
                if (!(d2 != null && d2.doubleValue() > 0.0d)) {
                    SentryOptions sentryOptions4 = this.f52437c;
                    if (sentryOptions4 != null) {
                        sentryOptions4.getLogger().c(SentryLevel.INFO, "Session replay is not started, full session was not sampled and onErrorSampleRate is not specified", new Object[0]);
                        return;
                    } else {
                        Intrinsics.h("options");
                        throw null;
                    }
                }
            }
            Context context = this.f52435a;
            SentryOptions sentryOptions5 = this.f52437c;
            if (sentryOptions5 == null) {
                Intrinsics.h("options");
                throw null;
            }
            SentryReplayOptions sessionReplay = sentryOptions5.getSessionReplay();
            Intrinsics.checkNotNullExpressionValue(sessionReplay, "options.sessionReplay");
            ScreenshotRecorderConfig screenshotRecorderConfigA = ScreenshotRecorderConfig.Companion.a(context, sessionReplay);
            if (zA) {
                SentryOptions sentryOptions6 = this.f52437c;
                if (sentryOptions6 == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                HubAdapter hubAdapter = this.f52438d;
                CurrentDateProvider currentDateProvider = this.f52436b;
                ScheduledExecutorService replayExecutor = (ScheduledExecutorService) this.f52443i.getValue();
                Intrinsics.checkNotNullExpressionValue(replayExecutor, "replayExecutor");
                bufferCaptureStrategy = new SessionCaptureStrategy(sentryOptions6, hubAdapter, currentDateProvider, replayExecutor);
            } else {
                SentryOptions sentryOptions7 = this.f52437c;
                if (sentryOptions7 == null) {
                    Intrinsics.h("options");
                    throw null;
                }
                HubAdapter hubAdapter2 = this.f52438d;
                CurrentDateProvider currentDateProvider2 = this.f52436b;
                Random random2 = (Random) this.f52441g.getValue();
                ScheduledExecutorService replayExecutor2 = (ScheduledExecutorService) this.f52443i.getValue();
                Intrinsics.checkNotNullExpressionValue(replayExecutor2, "replayExecutor");
                bufferCaptureStrategy = new BufferCaptureStrategy(sentryOptions7, hubAdapter2, currentDateProvider2, random2, replayExecutor2);
            }
            this.f52446l = bufferCaptureStrategy;
            bufferCaptureStrategy.c(screenshotRecorderConfigA, 0, new SentryId(), null);
            Recorder recorder = this.f52439e;
            if (recorder != null) {
                recorder.i0(screenshotRecorderConfigA);
            }
            if (this.f52439e instanceof OnRootViewsChangedListener) {
                RootViewsSpy$listeners$1 rootViewsSpy$listeners$1A = ((RootViewsSpy) this.f52442h.getValue()).a();
                Recorder recorder2 = this.f52439e;
                Intrinsics.d(recorder2, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
                rootViewsSpy$listeners$1A.add((OnRootViewsChangedListener) recorder2);
            }
            ((RootViewsSpy) this.f52442h.getValue()).a().add(this.f52440f);
            ReplayLifecycle replayLifecycle2 = this.o;
            replayLifecycle2.getClass();
            Intrinsics.checkNotNullParameter(replayState, "<set-?>");
            replayLifecycle2.f52456a = replayState;
        }
    }

    @Override // io.sentry.ReplayController
    public final synchronized void stop() {
        try {
            if (this.f52444j.get()) {
                ReplayLifecycle replayLifecycle = this.o;
                ReplayState replayState = ReplayState.STOPPED;
                if (replayLifecycle.a(replayState)) {
                    if (this.f52439e instanceof OnRootViewsChangedListener) {
                        RootViewsSpy$listeners$1 rootViewsSpy$listeners$1A = ((RootViewsSpy) this.f52442h.getValue()).a();
                        Recorder recorder = this.f52439e;
                        Intrinsics.d(recorder, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
                        rootViewsSpy$listeners$1A.remove((OnRootViewsChangedListener) recorder);
                    }
                    ((RootViewsSpy) this.f52442h.getValue()).a().remove(this.f52440f);
                    Recorder recorder2 = this.f52439e;
                    if (recorder2 != null) {
                        recorder2.stop();
                    }
                    GestureRecorder gestureRecorder = this.f52440f;
                    if (gestureRecorder != null) {
                        gestureRecorder.b();
                    }
                    CaptureStrategy captureStrategy = this.f52446l;
                    if (captureStrategy != null) {
                        captureStrategy.stop();
                    }
                    this.f52446l = null;
                    ReplayLifecycle replayLifecycle2 = this.o;
                    replayLifecycle2.getClass();
                    Intrinsics.checkNotNullParameter(replayState, "<set-?>");
                    replayLifecycle2.f52456a = replayState;
                }
            }
        } finally {
        }
    }

    public final void x(final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.f52438d != null) {
            Sentry.c(new ScopeCallback() { // from class: io.sentry.android.replay.b
                @Override // io.sentry.ScopeCallback
                public final void h(IScope it) {
                    Ref.ObjectRef screen = objectRef;
                    Intrinsics.checkNotNullParameter(screen, "$screen");
                    Intrinsics.checkNotNullParameter(it, "it");
                    String strK = it.k();
                    screen.f53801a = strK != null ? StringsKt.T(ClassUtils.PACKAGE_SEPARATOR_CHAR, strK, strK) : null;
                }
            });
        }
        CaptureStrategy captureStrategy = this.f52446l;
        if (captureStrategy != null) {
            captureStrategy.j(new Function2<ReplayCache, Long, Unit>() { // from class: io.sentry.android.replay.ReplayIntegration$onScreenshotRecorded$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws IOException {
                    HubAdapter hubAdapter;
                    HubAdapter hubAdapter2;
                    RateLimiter rateLimiterO;
                    RateLimiter rateLimiterO2;
                    ReplayCache onScreenshotRecorded = (ReplayCache) obj;
                    long jLongValue = ((Number) obj2).longValue();
                    Intrinsics.checkNotNullParameter(onScreenshotRecorded, "$this$onScreenshotRecorded");
                    String str = (String) objectRef.f53801a;
                    onScreenshotRecorded.getClass();
                    Bitmap bitmap2 = bitmap;
                    Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
                    if (onScreenshotRecorded.b() != null && !bitmap2.isRecycled()) {
                        File fileB = onScreenshotRecorded.b();
                        if (fileB != null) {
                            fileB.mkdirs();
                        }
                        File screenshot = new File(onScreenshotRecorded.b(), jLongValue + ".jpg");
                        screenshot.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(screenshot);
                        try {
                            bitmap2.compress(Bitmap.CompressFormat.JPEG, onScreenshotRecorded.f52417a.getSessionReplay().f51863g.screenshotQuality, fileOutputStream);
                            fileOutputStream.flush();
                            Unit unit = Unit.f53572a;
                            fileOutputStream.close();
                            Intrinsics.checkNotNullParameter(screenshot, "screenshot");
                            onScreenshotRecorded.f52423g.add(new ReplayFrame(screenshot, jLongValue, str));
                        } finally {
                        }
                    }
                    ReplayIntegration replayIntegration = this;
                    if (replayIntegration.f52446l instanceof SessionCaptureStrategy) {
                        SentryOptions sentryOptions = replayIntegration.f52437c;
                        if (sentryOptions == null) {
                            Intrinsics.h("options");
                            throw null;
                        }
                        if (sentryOptions.getConnectionStatusProvider().b() == IConnectionStatusProvider.ConnectionStatus.DISCONNECTED || (((hubAdapter = replayIntegration.f52438d) != null && (rateLimiterO2 = hubAdapter.o()) != null && rateLimiterO2.b(DataCategory.All)) || ((hubAdapter2 = replayIntegration.f52438d) != null && (rateLimiterO = hubAdapter2.o()) != null && rateLimiterO.b(DataCategory.Replay)))) {
                            replayIntegration.A();
                        }
                    }
                    return Unit.f53572a;
                }
            });
        }
    }
}
