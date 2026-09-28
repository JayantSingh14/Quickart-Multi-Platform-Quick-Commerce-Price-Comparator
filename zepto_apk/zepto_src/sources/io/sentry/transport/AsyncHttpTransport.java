package io.sentry.transport;

import io.sentry.DataCategory;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.RequestDetails;
import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.replay.capture.c;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.Cached;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Enqueable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.transport.AsyncHttpTransport;
import io.sentry.transport.TransportResult;
import io.sentry.util.HintUtils;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class AsyncHttpTransport implements ITransport {

    /* renamed from: a, reason: collision with root package name */
    public final QueuedThreadPoolExecutor f53078a;

    /* renamed from: b, reason: collision with root package name */
    public final IEnvelopeCache f53079b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryOptions f53080c;

    /* renamed from: d, reason: collision with root package name */
    public final RateLimiter f53081d;

    /* renamed from: e, reason: collision with root package name */
    public final ITransportGate f53082e;

    /* renamed from: f, reason: collision with root package name */
    public final HttpConnection f53083f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Runnable f53084g;

    public static final class AsyncConnectionThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f53085a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("SentryAsyncConnection-");
            int i2 = this.f53085a;
            this.f53085a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public final class EnvelopeSender implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SentryEnvelope f53086a;

        /* renamed from: b, reason: collision with root package name */
        public final Hint f53087b;

        /* renamed from: c, reason: collision with root package name */
        public final IEnvelopeCache f53088c;

        /* renamed from: d, reason: collision with root package name */
        public final TransportResult f53089d = new TransportResult.ErrorTransportResult(-1);

        public EnvelopeSender(SentryEnvelope sentryEnvelope, Hint hint, IEnvelopeCache iEnvelopeCache) {
            Objects.b(sentryEnvelope, "Envelope is required.");
            this.f53086a = sentryEnvelope;
            this.f53087b = hint;
            Objects.b(iEnvelopeCache, "EnvelopeCache is required.");
            this.f53088c = iEnvelopeCache;
        }

        public static /* synthetic */ void a(EnvelopeSender envelopeSender, TransportResult transportResult, SubmissionResult submissionResult) {
            AsyncHttpTransport.this.f53080c.getLogger().c(SentryLevel.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(transportResult.b()));
            submissionResult.c(transportResult.b());
        }

        public final TransportResult b() {
            TransportResult transportResult = this.f53089d;
            SentryEnvelope sentryEnvelope = this.f53086a;
            sentryEnvelope.f51812a.f51817d = null;
            IEnvelopeCache iEnvelopeCache = this.f53088c;
            Hint hint = this.f53087b;
            iEnvelopeCache.v0(sentryEnvelope, hint);
            Object objB = HintUtils.b(hint);
            boolean zIsInstance = DiskFlushNotification.class.isInstance(HintUtils.b(hint));
            AsyncHttpTransport asyncHttpTransport = AsyncHttpTransport.this;
            if (zIsInstance && objB != null) {
                DiskFlushNotification diskFlushNotification = (DiskFlushNotification) objB;
                if (diskFlushNotification.b(sentryEnvelope.f51812a.f51814a)) {
                    diskFlushNotification.d();
                    asyncHttpTransport.f53080c.getLogger().c(SentryLevel.DEBUG, "Disk flush envelope fired", new Object[0]);
                } else {
                    asyncHttpTransport.f53080c.getLogger().c(SentryLevel.DEBUG, "Not firing envelope flush as there's an ongoing transaction", new Object[0]);
                }
            }
            boolean zIsConnected = asyncHttpTransport.f53082e.isConnected();
            SentryOptions sentryOptions = asyncHttpTransport.f53080c;
            if (!zIsConnected) {
                Object objB2 = HintUtils.b(hint);
                if (Retryable.class.isInstance(HintUtils.b(hint)) && objB2 != null) {
                    ((Retryable) objB2).d(true);
                    return transportResult;
                }
                LogUtils.a(Retryable.class, objB2, sentryOptions.getLogger());
                sentryOptions.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, sentryEnvelope);
                return transportResult;
            }
            SentryEnvelope sentryEnvelopeE = sentryOptions.getClientReportRecorder().e(sentryEnvelope);
            try {
                SentryDate sentryDateNow = sentryOptions.getDateProvider().now();
                sentryEnvelopeE.f51812a.f51817d = DateUtils.b(Double.valueOf(sentryDateNow.d() / 1000000.0d).longValue());
                TransportResult transportResultD = asyncHttpTransport.f53083f.d(sentryEnvelopeE);
                if (transportResultD.b()) {
                    iEnvelopeCache.x(sentryEnvelope);
                    return transportResultD;
                }
                String str = "The transport failed to send the envelope with response code " + transportResultD.a();
                sentryOptions.getLogger().c(SentryLevel.ERROR, str, new Object[0]);
                if (transportResultD.a() >= 400 && transportResultD.a() != 429) {
                    c cVar = new c(new b(this, sentryEnvelopeE));
                    Object objB3 = HintUtils.b(hint);
                    if (!Retryable.class.isInstance(HintUtils.b(hint)) || objB3 == null) {
                        cVar.a(objB3);
                    }
                }
                throw new IllegalStateException(str);
            } catch (IOException e2) {
                Object objB4 = HintUtils.b(hint);
                if (!Retryable.class.isInstance(HintUtils.b(hint)) || objB4 == null) {
                    LogUtils.a(Retryable.class, objB4, sentryOptions.getLogger());
                    sentryOptions.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, sentryEnvelopeE);
                } else {
                    ((Retryable) objB4).d(true);
                }
                throw new IllegalStateException("Sending the event failed.", e2);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            AsyncHttpTransport.this.f53084g = this;
            TransportResult transportResultB = this.f53089d;
            try {
                transportResultB = b();
                AsyncHttpTransport.this.f53080c.getLogger().c(SentryLevel.DEBUG, "Envelope flushed", new Object[0]);
            } catch (Throwable th) {
                try {
                    AsyncHttpTransport.this.f53080c.getLogger().a(SentryLevel.ERROR, th, "Envelope submission failed", new Object[0]);
                    throw th;
                } finally {
                    Hint hint = this.f53087b;
                    Object objB = HintUtils.b(hint);
                    if (SubmissionResult.class.isInstance(HintUtils.b(hint)) && objB != null) {
                        a(this, transportResultB, (SubmissionResult) objB);
                    }
                    AsyncHttpTransport.this.f53084g = null;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [io.sentry.transport.a] */
    public AsyncHttpTransport(SentryOptions sentryOptions, RateLimiter rateLimiter, ITransportGate iTransportGate, RequestDetails requestDetails) {
        int maxQueueSize = sentryOptions.getMaxQueueSize();
        final IEnvelopeCache envelopeDiskCache = sentryOptions.getEnvelopeDiskCache();
        final ILogger logger = sentryOptions.getLogger();
        SentryDateProvider dateProvider = sentryOptions.getDateProvider();
        QueuedThreadPoolExecutor queuedThreadPoolExecutor = new QueuedThreadPoolExecutor(maxQueueSize, new AsyncConnectionThreadFactory(), new RejectedExecutionHandler() { // from class: io.sentry.transport.a
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (runnable instanceof AsyncHttpTransport.EnvelopeSender) {
                    AsyncHttpTransport.EnvelopeSender envelopeSender = (AsyncHttpTransport.EnvelopeSender) runnable;
                    boolean zC = HintUtils.c(envelopeSender.f53087b, Cached.class);
                    Hint hint = envelopeSender.f53087b;
                    if (!zC) {
                        envelopeDiskCache.v0(envelopeSender.f53086a, hint);
                    }
                    Object objB = HintUtils.b(hint);
                    if (SubmissionResult.class.isInstance(HintUtils.b(hint)) && objB != null) {
                        ((SubmissionResult) objB).c(false);
                    }
                    Object objB2 = HintUtils.b(hint);
                    if (Retryable.class.isInstance(HintUtils.b(hint)) && objB2 != null) {
                        ((Retryable) objB2).d(true);
                    }
                    logger.c(SentryLevel.WARNING, "Envelope rejected", new Object[0]);
                }
            }
        }, logger, dateProvider);
        HttpConnection httpConnection = new HttpConnection(sentryOptions, requestDetails, rateLimiter);
        this.f53084g = null;
        this.f53078a = queuedThreadPoolExecutor;
        IEnvelopeCache envelopeDiskCache2 = sentryOptions.getEnvelopeDiskCache();
        Objects.b(envelopeDiskCache2, "envelopeCache is required");
        this.f53079b = envelopeDiskCache2;
        this.f53080c = sentryOptions;
        this.f53081d = rateLimiter;
        Objects.b(iTransportGate, "transportGate is required");
        this.f53082e = iTransportGate;
        this.f53083f = httpConnection;
    }

    @Override // io.sentry.transport.ITransport
    public final void M(SentryEnvelope sentryEnvelope, Hint hint) {
        boolean z;
        IEnvelopeCache iEnvelopeCache;
        DataCategory dataCategory;
        boolean zIsInstance = Cached.class.isInstance(HintUtils.b(hint));
        SentryOptions sentryOptions = this.f53080c;
        IEnvelopeCache iEnvelopeCache2 = this.f53079b;
        if (zIsInstance) {
            iEnvelopeCache = NoOpEnvelopeCache.f53097a;
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z = true;
        } else {
            z = false;
            iEnvelopeCache = iEnvelopeCache2;
        }
        RateLimiter rateLimiter = this.f53081d;
        rateLimiter.getClass();
        Collection<SentryEnvelopeItem> collection = sentryEnvelope.f51813b;
        Iterator it = collection.iterator();
        SentryEnvelope sentryEnvelopeE = null;
        ArrayList arrayList = null;
        while (true) {
            boolean zHasNext = it.hasNext();
            SentryOptions sentryOptions2 = rateLimiter.f53108b;
            if (!zHasNext) {
                if (arrayList != null) {
                    sentryOptions2.getLogger().c(SentryLevel.INFO, "%d items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
                    ArrayList arrayList2 = new ArrayList();
                    for (SentryEnvelopeItem sentryEnvelopeItem : collection) {
                        if (!arrayList.contains(sentryEnvelopeItem)) {
                            arrayList2.add(sentryEnvelopeItem);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        sentryOptions2.getLogger().c(SentryLevel.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
                        Object objB = HintUtils.b(hint);
                        if (SubmissionResult.class.isInstance(HintUtils.b(hint)) && objB != null) {
                            ((SubmissionResult) objB).c(false);
                        }
                        Object objB2 = HintUtils.b(hint);
                        if (Retryable.class.isInstance(HintUtils.b(hint)) && objB2 != null) {
                            ((Retryable) objB2).d(false);
                        }
                    } else {
                        sentryEnvelopeE = new SentryEnvelope(sentryEnvelope.f51812a, arrayList2);
                    }
                } else {
                    sentryEnvelopeE = sentryEnvelope;
                }
                if (sentryEnvelopeE == null) {
                    if (z) {
                        iEnvelopeCache2.x(sentryEnvelope);
                        return;
                    }
                    return;
                }
                if (UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class.isInstance(HintUtils.b(hint))) {
                    sentryEnvelopeE = sentryOptions.getClientReportRecorder().e(sentryEnvelopeE);
                }
                Future futureSubmit = this.f53078a.submit(new EnvelopeSender(sentryEnvelopeE, hint, iEnvelopeCache));
                if (futureSubmit != null && futureSubmit.isCancelled()) {
                    sentryOptions.getClientReportRecorder().b(DiscardReason.QUEUE_OVERFLOW, sentryEnvelopeE);
                    return;
                }
                Object objB3 = HintUtils.b(hint);
                if (!Enqueable.class.isInstance(HintUtils.b(hint)) || objB3 == null) {
                    return;
                }
                ((Enqueable) objB3).b();
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Envelope enqueued", new Object[0]);
                return;
            }
            SentryEnvelopeItem sentryEnvelopeItem2 = (SentryEnvelopeItem) it.next();
            String itemType = sentryEnvelopeItem2.f51820a.f51827c.getItemType();
            itemType.getClass();
            switch (itemType) {
                case "attachment":
                    dataCategory = DataCategory.Attachment;
                    break;
                case "replay_video":
                    dataCategory = DataCategory.Replay;
                    break;
                case "statsd":
                    dataCategory = DataCategory.MetricBucket;
                    break;
                case "profile":
                    dataCategory = DataCategory.Profile;
                    break;
                case "event":
                    dataCategory = DataCategory.Error;
                    break;
                case "check_in":
                    dataCategory = DataCategory.Monitor;
                    break;
                case "session":
                    dataCategory = DataCategory.Session;
                    break;
                case "transaction":
                    dataCategory = DataCategory.Transaction;
                    break;
                default:
                    dataCategory = DataCategory.Unknown;
                    break;
            }
            if (rateLimiter.b(dataCategory)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(sentryEnvelopeItem2);
                sentryOptions2.getClientReportRecorder().d(DiscardReason.RATELIMIT_BACKOFF, sentryEnvelopeItem2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        n(false);
    }

    @Override // io.sentry.transport.ITransport
    public final boolean i() {
        boolean z;
        RateLimiter rateLimiter = this.f53081d;
        rateLimiter.getClass();
        rateLimiter.f53107a.getClass();
        Date date = new Date(System.currentTimeMillis());
        ConcurrentHashMap concurrentHashMap = rateLimiter.f53109c;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Date date2 = (Date) concurrentHashMap.get((DataCategory) it.next());
            if (date2 != null && !date.after(date2)) {
                z = true;
                break;
            }
        }
        QueuedThreadPoolExecutor queuedThreadPoolExecutor = this.f53078a;
        SentryDate sentryDate = queuedThreadPoolExecutor.f53103b;
        return (z || (sentryDate != null && (queuedThreadPoolExecutor.f53105d.now().b(sentryDate) > 2000000000L ? 1 : (queuedThreadPoolExecutor.f53105d.now().b(sentryDate) == 2000000000L ? 0 : -1)) < 0)) ? false : true;
    }

    @Override // io.sentry.transport.ITransport
    public final void n(boolean z) {
        long flushTimeoutMillis;
        this.f53081d.close();
        this.f53078a.shutdown();
        this.f53080c.getLogger().c(SentryLevel.DEBUG, "Shutting down", new Object[0]);
        if (z) {
            flushTimeoutMillis = 0;
        } else {
            try {
                flushTimeoutMillis = this.f53080c.getFlushTimeoutMillis();
            } catch (InterruptedException unused) {
                this.f53080c.getLogger().c(SentryLevel.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (this.f53078a.awaitTermination(flushTimeoutMillis, TimeUnit.MILLISECONDS)) {
            return;
        }
        this.f53080c.getLogger().c(SentryLevel.WARNING, "Failed to shutdown the async connection async sender  within " + flushTimeoutMillis + " ms. Trying to force it now.", new Object[0]);
        this.f53078a.shutdownNow();
        if (this.f53084g != null) {
            this.f53078a.getRejectedExecutionHandler().rejectedExecution(this.f53084g, this.f53078a);
        }
    }

    @Override // io.sentry.transport.ITransport
    public final RateLimiter o() {
        return this.f53081d;
    }

    @Override // io.sentry.transport.ITransport
    public final void v(long j2) throws InterruptedException {
        QueuedThreadPoolExecutor queuedThreadPoolExecutor = this.f53078a;
        queuedThreadPoolExecutor.getClass();
        try {
            ReusableCountLatch reusableCountLatch = queuedThreadPoolExecutor.f53106e;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            reusableCountLatch.getClass();
            reusableCountLatch.f53114a.tryAcquireSharedNanos(1, timeUnit.toNanos(j2));
        } catch (InterruptedException e2) {
            queuedThreadPoolExecutor.f53104c.b(SentryLevel.ERROR, "Failed to wait till idle", e2);
            Thread.currentThread().interrupt();
        }
    }
}
