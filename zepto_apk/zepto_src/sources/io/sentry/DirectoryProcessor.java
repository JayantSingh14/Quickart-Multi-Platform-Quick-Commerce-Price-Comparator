package io.sentry;

import io.sentry.hints.Cached;
import io.sentry.hints.Enqueable;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
abstract class DirectoryProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final HubAdapter f51599a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f51600b;

    /* renamed from: c, reason: collision with root package name */
    public final long f51601c;

    /* renamed from: d, reason: collision with root package name */
    public final Queue f51602d;

    public static final class SendCachedEnvelopeHint implements Cached, Retryable, SubmissionResult, Flushable, Enqueable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f51603a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f51604b = false;

        /* renamed from: c, reason: collision with root package name */
        public final CountDownLatch f51605c = new CountDownLatch(1);

        /* renamed from: d, reason: collision with root package name */
        public final long f51606d;

        /* renamed from: e, reason: collision with root package name */
        public final ILogger f51607e;

        /* renamed from: f, reason: collision with root package name */
        public final String f51608f;

        /* renamed from: g, reason: collision with root package name */
        public final Queue f51609g;

        public SendCachedEnvelopeHint(long j2, ILogger iLogger, String str, Queue queue) {
            this.f51606d = j2;
            this.f51608f = str;
            this.f51609g = queue;
            this.f51607e = iLogger;
        }

        @Override // io.sentry.hints.Retryable
        public final boolean a() {
            return this.f51603a;
        }

        @Override // io.sentry.hints.Enqueable
        public final void b() {
            this.f51609g.add(this.f51608f);
        }

        @Override // io.sentry.hints.SubmissionResult
        public final void c(boolean z) {
            this.f51604b = z;
            this.f51605c.countDown();
        }

        @Override // io.sentry.hints.Retryable
        public final void d(boolean z) {
            this.f51603a = z;
        }

        @Override // io.sentry.hints.SubmissionResult
        public final boolean e() {
            return this.f51604b;
        }

        @Override // io.sentry.hints.Flushable
        public final boolean g() {
            try {
                return this.f51605c.await(this.f51606d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.f51607e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e2);
                return false;
            }
        }
    }

    public DirectoryProcessor(HubAdapter hubAdapter, ILogger iLogger, long j2, int i2) {
        this.f51599a = hubAdapter;
        this.f51600b = iLogger;
        this.f51601c = j2;
        this.f51602d = new SynchronizedQueue(new CircularFifoQueue(i2));
    }

    public abstract boolean a(String str);

    public abstract void b(File file, Hint hint);
}
