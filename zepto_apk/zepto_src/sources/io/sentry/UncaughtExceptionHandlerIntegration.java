package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.BlockingFlushHint;
import io.sentry.hints.EventDropReason;
import io.sentry.hints.SessionEnd;
import io.sentry.hints.TransactionEnd;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryId;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import java.io.Closeable;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

/* loaded from: classes.dex */
public final class UncaughtExceptionHandlerIntegration implements Integration, Thread.UncaughtExceptionHandler, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f51971a;

    /* renamed from: b, reason: collision with root package name */
    public HubAdapter f51972b;

    /* renamed from: c, reason: collision with root package name */
    public SentryOptions f51973c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f51974d = false;

    @ApiStatus.Internal
    public static class UncaughtExceptionHint extends BlockingFlushHint implements SessionEnd, TransactionEnd {

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReference f51975d;

        public UncaughtExceptionHint(long j2, ILogger iLogger) {
            super(j2, iLogger);
            this.f51975d = new AtomicReference();
        }

        @Override // io.sentry.hints.DiskFlushNotification
        public final boolean b(SentryId sentryId) {
            SentryId sentryId2 = (SentryId) this.f51975d.get();
            return sentryId2 != null && sentryId2.equals(sentryId);
        }

        @Override // io.sentry.hints.DiskFlushNotification
        public final void c(SentryId sentryId) {
            this.f51975d.set(sentryId);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this == Thread.getDefaultUncaughtExceptionHandler()) {
            Thread.setDefaultUncaughtExceptionHandler(this.f51971a);
            SentryOptions sentryOptions = this.f51973c;
            if (sentryOptions != null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        if (this.f51974d) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.f51974d = true;
        this.f51972b = hubAdapter;
        this.f51973c = sentryOptions;
        ILogger logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.f51973c.isEnableUncaughtExceptionHandler()));
        if (this.f51973c.isEnableUncaughtExceptionHandler()) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                this.f51973c.getLogger().c(sentryLevel, "default UncaughtExceptionHandler class='" + defaultUncaughtExceptionHandler.getClass().getName() + "'", new Object[0]);
                if (defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandlerIntegration) {
                    this.f51971a = ((UncaughtExceptionHandlerIntegration) defaultUncaughtExceptionHandler).f51971a;
                } else {
                    this.f51971a = defaultUncaughtExceptionHandler;
                }
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f51973c.getLogger().c(sentryLevel, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
            IntegrationUtils.a("UncaughtExceptionHandler");
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        SentryId sentryId;
        SentryOptions sentryOptions = this.f51973c;
        if (sentryOptions == null || this.f51972b == null) {
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.INFO, "Uncaught exception received.", new Object[0]);
        try {
            UncaughtExceptionHint uncaughtExceptionHint = new UncaughtExceptionHint(this.f51973c.getFlushTimeoutMillis(), this.f51973c.getLogger());
            Mechanism mechanism = new Mechanism();
            mechanism.f52851d = Boolean.FALSE;
            mechanism.f52848a = "UncaughtExceptionHandler";
            SentryEvent sentryEvent = new SentryEvent(new ExceptionMechanismException(mechanism, th, thread));
            sentryEvent.u = SentryLevel.FATAL;
            if (this.f51972b.j() == null && (sentryId = sentryEvent.f51791a) != null) {
                uncaughtExceptionHint.c(sentryId);
            }
            Hint hintA = HintUtils.a(uncaughtExceptionHint);
            boolean zEquals = this.f51972b.A(sentryEvent, hintA).equals(SentryId.f52907b);
            EventDropReason eventDropReason = (EventDropReason) hintA.b(EventDropReason.class, "sentry:eventDropReason");
            if ((!zEquals || EventDropReason.MULTITHREADED_DEDUPLICATION.equals(eventDropReason)) && !uncaughtExceptionHint.g()) {
                this.f51973c.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", sentryEvent.f51791a);
            }
        } catch (Throwable th2) {
            this.f51973c.getLogger().b(SentryLevel.ERROR, "Error sending uncaught exception to Sentry.", th2);
        }
        if (this.f51971a != null) {
            this.f51973c.getLogger().c(SentryLevel.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
            this.f51971a.uncaughtException(thread, th);
        } else if (this.f51973c.isPrintUncaughtStackTrace()) {
            th.printStackTrace();
        }
    }
}
