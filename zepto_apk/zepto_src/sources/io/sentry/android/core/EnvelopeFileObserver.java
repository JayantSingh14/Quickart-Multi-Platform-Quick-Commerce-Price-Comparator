package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.OutboxSender;
import io.sentry.SentryLevel;
import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Cached;
import io.sentry.hints.Flushable;
import io.sentry.hints.Resettable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class EnvelopeFileObserver extends FileObserver {

    /* renamed from: a, reason: collision with root package name */
    public final String f52129a;

    /* renamed from: b, reason: collision with root package name */
    public final OutboxSender f52130b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f52131c;

    /* renamed from: d, reason: collision with root package name */
    public final long f52132d;

    /* loaded from: classes3.dex */
    public static final class CachedEnvelopeHint implements Cached, Retryable, SubmissionResult, Flushable, ApplyScopeData, Resettable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f52133a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f52134b;

        /* renamed from: c, reason: collision with root package name */
        public CountDownLatch f52135c;

        /* renamed from: d, reason: collision with root package name */
        public final long f52136d;

        /* renamed from: e, reason: collision with root package name */
        public final ILogger f52137e;

        public CachedEnvelopeHint(long j2, ILogger iLogger) {
            reset();
            this.f52136d = j2;
            Objects.b(iLogger, "ILogger is required.");
            this.f52137e = iLogger;
        }

        @Override // io.sentry.hints.Retryable
        public final boolean a() {
            return this.f52133a;
        }

        @Override // io.sentry.hints.SubmissionResult
        public final void c(boolean z) {
            this.f52134b = z;
            this.f52135c.countDown();
        }

        @Override // io.sentry.hints.Retryable
        public final void d(boolean z) {
            this.f52133a = z;
        }

        @Override // io.sentry.hints.SubmissionResult
        public final boolean e() {
            return this.f52134b;
        }

        @Override // io.sentry.hints.Flushable
        public final boolean g() {
            try {
                return this.f52135c.await(this.f52136d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.f52137e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e2);
                return false;
            }
        }

        @Override // io.sentry.hints.Resettable
        public final void reset() {
            this.f52135c = new CountDownLatch(1);
            this.f52133a = false;
            this.f52134b = false;
        }
    }

    public EnvelopeFileObserver(String str, OutboxSender outboxSender, ILogger iLogger, long j2) {
        super(str);
        this.f52129a = str;
        this.f52130b = outboxSender;
        Objects.b(iLogger, "Logger is required.");
        this.f52131c = iLogger;
        this.f52132d = j2;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i2, String str) {
        if (str == null || i2 != 8) {
            return;
        }
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Integer numValueOf = Integer.valueOf(i2);
        String str2 = this.f52129a;
        ILogger iLogger = this.f52131c;
        iLogger.c(sentryLevel, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", numValueOf, str2, str);
        Hint hintA = HintUtils.a(new CachedEnvelopeHint(this.f52132d, iLogger));
        String strR = android.support.v4.media.b.r(android.support.v4.media.b.w(str2), File.separator, str);
        OutboxSender outboxSender = this.f52130b;
        outboxSender.getClass();
        Objects.b(strR, "Path is required.");
        outboxSender.b(new File(strR), hintA);
    }
}
