package io.sentry;

import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryOptions;
import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.hints.Backfillable;
import io.sentry.metrics.IMetricsClient;
import io.sentry.metrics.NoopMetricsAggregator;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransport;
import io.sentry.util.CollectionUtils;
import io.sentry.util.FileUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SentryClient implements ISentryClient, IMetricsClient {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51804a;

    /* renamed from: b, reason: collision with root package name */
    public final ITransport f51805b;

    /* renamed from: c, reason: collision with root package name */
    public final SortBreadcrumbsByDate f51806c = new SortBreadcrumbsByDate();

    /* renamed from: d, reason: collision with root package name */
    public final IMetricsAggregator f51807d;

    public static final class SortBreadcrumbsByDate implements Comparator<Breadcrumb> {
        @Override // java.util.Comparator
        public final int compare(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
            return breadcrumb.a().compareTo(breadcrumb2.a());
        }
    }

    public SentryClient(SentryOptions sentryOptions) throws IllegalArgumentException {
        this.f51804a = sentryOptions;
        ITransportFactory transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof NoOpTransportFactory) {
            transportFactory = new AsyncHttpTransportFactory();
            sentryOptions.setTransportFactory(transportFactory);
        }
        Dsn dsnRetrieveParsedDsn = sentryOptions.retrieveParsedDsn();
        URI uri = dsnRetrieveParsedDsn.f51612c;
        String string = uri.resolve(uri.getPath() + "/envelope/").toString();
        StringBuilder sb = new StringBuilder("Sentry sentry_version=7,sentry_client=");
        sb.append(sentryOptions.getSentryClientName());
        sb.append(",sentry_key=");
        sb.append(dsnRetrieveParsedDsn.f51611b);
        String str = dsnRetrieveParsedDsn.f51610a;
        sb.append((str == null || str.length() <= 0) ? "" : ",sentry_secret=".concat(str));
        String string2 = sb.toString();
        String sentryClientName = sentryOptions.getSentryClientName();
        HashMap map = new HashMap();
        map.put("User-Agent", sentryClientName);
        map.put("X-Sentry-Auth", string2);
        this.f51805b = transportFactory.a(sentryOptions, new RequestDetails(string, map));
        this.f51807d = sentryOptions.isEnableMetrics() ? new MetricsAggregator(sentryOptions, this) : NoopMetricsAggregator.f52786a;
    }

    public static ArrayList k(Hint hint) {
        ArrayList arrayList = new ArrayList(hint.f51637b);
        Attachment attachment = hint.f51638c;
        if (attachment != null) {
            arrayList.add(attachment);
        }
        Attachment attachment2 = hint.f51639d;
        if (attachment2 != null) {
            arrayList.add(attachment2);
        }
        Attachment attachment3 = hint.f51640e;
        if (attachment3 != null) {
            arrayList.add(attachment3);
        }
        return arrayList;
    }

    public final void a(SentryBaseEvent sentryBaseEvent, IScope iScope) {
        if (iScope != null) {
            if (sentryBaseEvent.f51794d == null) {
                sentryBaseEvent.f51794d = iScope.getRequest();
            }
            if (sentryBaseEvent.f51799i == null) {
                sentryBaseEvent.f51799i = iScope.t();
            }
            if (sentryBaseEvent.f51795e == null) {
                sentryBaseEvent.f51795e = CollectionUtils.d(new HashMap(iScope.n()));
            } else {
                for (Map.Entry entry : iScope.n().entrySet()) {
                    if (!sentryBaseEvent.f51795e.containsKey(entry.getKey())) {
                        sentryBaseEvent.f51795e.put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            if (sentryBaseEvent.f51803m == null) {
                sentryBaseEvent.f51803m = CollectionUtils.b(new ArrayList(iScope.i()));
            } else {
                Queue queueI = iScope.i();
                List list = sentryBaseEvent.f51803m;
                if (list != null && !queueI.isEmpty()) {
                    list.addAll(queueI);
                    Collections.sort(list, this.f51806c);
                }
            }
            if (sentryBaseEvent.o == null) {
                sentryBaseEvent.o = CollectionUtils.d(new HashMap(iScope.getExtras()));
            } else {
                for (Map.Entry entry2 : iScope.getExtras().entrySet()) {
                    if (!sentryBaseEvent.o.containsKey(entry2.getKey())) {
                        sentryBaseEvent.o.put((String) entry2.getKey(), entry2.getValue());
                    }
                }
            }
            for (Map.Entry<String, Object> entry3 : new Contexts(iScope.q()).entrySet()) {
                String key = entry3.getKey();
                Contexts contexts = sentryBaseEvent.f51792b;
                if (!contexts.containsKey(key)) {
                    contexts.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
    }

    public final SentryEnvelope b(SentryBaseEvent sentryBaseEvent, ArrayList arrayList, Session session, TraceContext traceContext, ProfilingTraceData profilingTraceData) {
        SentryId sentryId;
        ArrayList arrayList2 = new ArrayList();
        SentryOptions sentryOptions = this.f51804a;
        if (sentryBaseEvent != null) {
            ISerializer serializer = sentryOptions.getSerializer();
            Charset charset = SentryEnvelopeItem.f51819d;
            Objects.b(serializer, "ISerializer is required.");
            SentryEnvelopeItem.CachedItem cachedItem = new SentryEnvelopeItem.CachedItem(new androidx.media3.datasource.b(8, serializer, sentryBaseEvent));
            arrayList2.add(new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(sentryBaseEvent), new m(cachedItem, 4), "application/json", (String) null, (String) null), new m(cachedItem, 5)));
            sentryId = sentryBaseEvent.f51791a;
        } else {
            sentryId = null;
        }
        if (session != null) {
            arrayList2.add(SentryEnvelopeItem.b(sentryOptions.getSerializer(), session));
        }
        if (profilingTraceData != null) {
            long maxTraceFileSize = sentryOptions.getMaxTraceFileSize();
            ISerializer serializer2 = sentryOptions.getSerializer();
            Charset charset2 = SentryEnvelopeItem.f51819d;
            File file = profilingTraceData.f51727a;
            SentryEnvelopeItem.CachedItem cachedItem2 = new SentryEnvelopeItem.CachedItem(new in.juspay.airborne.ota.b(file, maxTraceFileSize, profilingTraceData, serializer2, 1));
            arrayList2.add(new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Profile, new m(cachedItem2, 2), "application-json", file.getName(), (String) null), new m(cachedItem2, 3)));
            if (sentryId == null) {
                sentryId = new SentryId(profilingTraceData.w);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Attachment attachment = (Attachment) it.next();
                ISerializer serializer3 = sentryOptions.getSerializer();
                ILogger logger = sentryOptions.getLogger();
                long maxAttachmentSize = sentryOptions.getMaxAttachmentSize();
                Charset charset3 = SentryEnvelopeItem.f51819d;
                SentryEnvelopeItem.CachedItem cachedItem3 = new SentryEnvelopeItem.CachedItem(new in.juspay.airborne.ota.b(attachment, maxAttachmentSize, serializer3, logger, 2));
                arrayList2.add(new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Attachment, new m(cachedItem3, 0), attachment.d(), attachment.e(), attachment.c()), new m(cachedItem3, 1)));
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return new SentryEnvelope(new SentryEnvelopeHeader(sentryId, sentryOptions.getSdkVersion(), traceContext), arrayList2);
    }

    public final SentryEnvelope c(final SentryReplayEvent sentryReplayEvent, final ReplayRecording replayRecording, TraceContext traceContext, final boolean z) {
        ArrayList arrayList = new ArrayList();
        SentryOptions sentryOptions = this.f51804a;
        final ISerializer serializer = sentryOptions.getSerializer();
        final ILogger logger = sentryOptions.getLogger();
        Charset charset = SentryEnvelopeItem.f51819d;
        final File file = sentryReplayEvent.p;
        SentryEnvelopeItem.CachedItem cachedItem = new SentryEnvelopeItem.CachedItem(new Callable() { // from class: io.sentry.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ISerializer iSerializer = serializer;
                SentryReplayEvent sentryReplayEvent2 = sentryReplayEvent;
                File file2 = file;
                ILogger iLogger = logger;
                boolean z2 = z;
                Charset charset2 = SentryEnvelopeItem.f51819d;
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, SentryEnvelopeItem.f51819d));
                        try {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            iSerializer.e(sentryReplayEvent2, bufferedWriter);
                            linkedHashMap.put(SentryItemType.ReplayEvent.getItemType(), byteArrayOutputStream.toByteArray());
                            byteArrayOutputStream.reset();
                            ReplayRecording replayRecording2 = replayRecording;
                            if (replayRecording2 != null) {
                                iSerializer.e(replayRecording2, bufferedWriter);
                                linkedHashMap.put(SentryItemType.ReplayRecording.getItemType(), byteArrayOutputStream.toByteArray());
                                byteArrayOutputStream.reset();
                            }
                            if (file2 != null && file2.exists()) {
                                byte[] bArrB = FileUtils.b(10485760L, file2.getPath());
                                if (bArrB.length > 0) {
                                    linkedHashMap.put(SentryItemType.ReplayVideo.getItemType(), bArrB);
                                }
                            }
                            byte[] bArrG = SentryEnvelopeItem.g(linkedHashMap);
                            bufferedWriter.close();
                            byteArrayOutputStream.close();
                            if (file2 != null) {
                                if (z2) {
                                    return bArrG;
                                }
                            }
                            return bArrG;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        iLogger.b(SentryLevel.ERROR, "Could not serialize replay recording", th);
                        if (file2 == null) {
                            return null;
                        }
                        if (z2) {
                            FileUtils.a(file2.getParentFile());
                            return null;
                        }
                        file2.delete();
                        return null;
                    } finally {
                        if (file2 != null) {
                            if (z2) {
                                FileUtils.a(file2.getParentFile());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                }
            }
        });
        arrayList.add(new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.ReplayVideo, new m(cachedItem, 7), (String) null, (String) null, (String) null), new m(cachedItem, 9)));
        return new SentryEnvelope(new SentryEnvelopeHeader(sentryReplayEvent.f51791a, sentryOptions.getSessionReplay().f51869m, traceContext), arrayList);
    }

    public final SentryId d(SentryEnvelope sentryEnvelope, Hint hint) {
        if (hint == null) {
            hint = new Hint();
        }
        try {
            hint.a();
            return n(sentryEnvelope, hint);
        } catch (IOException e2) {
            this.f51804a.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope.", e2);
            return SentryId.f52907b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.protocol.SentryId e(io.sentry.SentryEvent r12, io.sentry.IScope r13, io.sentry.Hint r14) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryClient.e(io.sentry.SentryEvent, io.sentry.IScope, io.sentry.Hint):io.sentry.protocol.SentryId");
    }

    public final SentryId f(SentryReplayEvent sentryReplayEvent, IScope iScope, Hint hint) {
        Contexts contexts;
        if (o(sentryReplayEvent, hint) && iScope != null) {
            if (sentryReplayEvent.f51794d == null) {
                sentryReplayEvent.f51794d = iScope.getRequest();
            }
            if (sentryReplayEvent.f51799i == null) {
                sentryReplayEvent.f51799i = iScope.t();
            }
            if (sentryReplayEvent.f51795e == null) {
                sentryReplayEvent.f51795e = CollectionUtils.d(new HashMap(iScope.n()));
            } else {
                for (Map.Entry entry : iScope.n().entrySet()) {
                    if (!sentryReplayEvent.f51795e.containsKey(entry.getKey())) {
                        sentryReplayEvent.f51795e.put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            Iterator<Map.Entry<String, Object>> it = new Contexts(iScope.q()).entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                contexts = sentryReplayEvent.f51792b;
                if (!zHasNext) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (!contexts.containsKey(next.getKey())) {
                    contexts.put(next.getKey(), next.getValue());
                }
            }
            ISpan iSpanH = iScope.h();
            if (contexts.a() == null) {
                if (iSpanH == null) {
                    contexts.c(TransactionContext.a(iScope.A()));
                } else {
                    contexts.c(iSpanH.o());
                }
            }
        }
        SentryOptions sentryOptions = this.f51804a;
        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Capturing session replay: %s", sentryReplayEvent.f51791a);
        SentryId sentryId = SentryId.f52907b;
        SentryId sentryId2 = sentryReplayEvent.f51791a;
        if (sentryId2 != null) {
            sentryId = sentryId2;
        }
        Iterator<EventProcessor> it2 = sentryOptions.getEventProcessors().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            EventProcessor next2 = it2.next();
            try {
                sentryReplayEvent = next2.a(sentryReplayEvent, hint);
            } catch (Throwable th) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing replay event by processor: %s", next2.getClass().getName());
            }
            if (sentryReplayEvent == null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Replay event was dropped by a processor: %s", next2.getClass().getName());
                sentryOptions.getClientReportRecorder().a(DiscardReason.EVENT_PROCESSOR, DataCategory.Replay);
                break;
            }
        }
        TraceContext traceContextG = null;
        if (sentryReplayEvent != null) {
            SentryOptions.BeforeSendReplayCallback beforeSendReplay = sentryOptions.getBeforeSendReplay();
            if (beforeSendReplay != null) {
                try {
                    sentryReplayEvent = beforeSendReplay.d();
                } catch (Throwable th2) {
                    sentryOptions.getLogger().b(SentryLevel.ERROR, "The BeforeSendReplay callback threw an exception. It will be added as breadcrumb and continue.", th2);
                    sentryReplayEvent = null;
                }
            }
            if (sentryReplayEvent == null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Event was dropped by beforeSendReplay", new Object[0]);
                sentryOptions.getClientReportRecorder().a(DiscardReason.BEFORE_SEND, DataCategory.Replay);
            }
        }
        if (sentryReplayEvent == null) {
            return SentryId.f52907b;
        }
        if (iScope != null) {
            try {
                ITransaction iTransactionJ = iScope.j();
                if (iTransactionJ != null) {
                    traceContextG = iTransactionJ.g();
                } else {
                    Baggage baggage = iScope.E(new androidx.media3.exoplayer.analytics.d(25, sentryOptions, iScope)).f51750c;
                    if (baggage != null) {
                        traceContextG = baggage.g();
                    }
                }
            } catch (IOException e2) {
                sentryOptions.getLogger().a(SentryLevel.WARNING, e2, "Capturing event %s failed.", sentryId);
                return SentryId.f52907b;
            }
        }
        SentryEnvelope sentryEnvelopeC = c(sentryReplayEvent, hint.f51641f, traceContextG, Backfillable.class.isInstance(HintUtils.b(hint)));
        hint.a();
        this.f51805b.M(sentryEnvelopeC, hint);
        return sentryId;
    }

    public final void g(Session session, Hint hint) {
        Objects.b(session, "Session is required.");
        SentryOptions sentryOptions = this.f51804a;
        String str = session.f51906m;
        if (str == null || str.isEmpty()) {
            sentryOptions.getLogger().c(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            ISerializer serializer = sentryOptions.getSerializer();
            SdkVersion sdkVersion = sentryOptions.getSdkVersion();
            Objects.b(serializer, "Serializer is required.");
            d(new SentryEnvelope(null, sdkVersion, SentryEnvelopeItem.b(serializer, session)), hint);
        } catch (IOException e2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to capture session.", e2);
        }
    }

    public final SentryId h(SentryTransaction sentryTransaction, TraceContext traceContext, IScope iScope, Hint hint, ProfilingTraceData profilingTraceData) {
        SentryTransaction sentryTransactionD;
        Hint hint2 = hint == null ? new Hint() : hint;
        if (o(sentryTransaction, hint2) && iScope != null) {
            hint2.f51637b.addAll(iScope.C());
        }
        SentryOptions sentryOptions = this.f51804a;
        ILogger logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "Capturing transaction: %s", sentryTransaction.f51791a);
        SentryId sentryId = SentryId.f52907b;
        SentryId sentryId2 = sentryTransaction.f51791a;
        SentryId sentryId3 = sentryId2 != null ? sentryId2 : sentryId;
        if (o(sentryTransaction, hint2)) {
            a(sentryTransaction, iScope);
            sentryTransactionD = iScope != null ? m(sentryTransaction, hint2, iScope.G()) : sentryTransaction;
            if (sentryTransactionD == null) {
                sentryOptions.getLogger().c(sentryLevel, "Transaction was dropped by applyScope", new Object[0]);
            }
        } else {
            sentryTransactionD = sentryTransaction;
        }
        if (sentryTransactionD != null) {
            sentryTransactionD = m(sentryTransactionD, hint2, sentryOptions.getEventProcessors());
        }
        if (sentryTransactionD == null) {
            sentryOptions.getLogger().c(sentryLevel, "Transaction was dropped by Event processors.", new Object[0]);
            return sentryId;
        }
        int size = sentryTransactionD.s.size();
        SentryOptions.BeforeSendTransactionCallback beforeSendTransaction = sentryOptions.getBeforeSendTransaction();
        if (beforeSendTransaction != null) {
            try {
                sentryTransactionD = beforeSendTransaction.d();
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th);
                sentryTransactionD = null;
            }
        }
        int size2 = sentryTransactionD == null ? 0 : sentryTransactionD.s.size();
        if (sentryTransactionD == null) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            IClientReportRecorder clientReportRecorder = sentryOptions.getClientReportRecorder();
            DiscardReason discardReason = DiscardReason.BEFORE_SEND;
            clientReportRecorder.a(discardReason, DataCategory.Transaction);
            sentryOptions.getClientReportRecorder().c(discardReason, DataCategory.Span, size + 1);
            return SentryId.f52907b;
        }
        if (size2 < size) {
            int i2 = size - size2;
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "%d spans were dropped by beforeSendTransaction.", Integer.valueOf(i2));
            sentryOptions.getClientReportRecorder().c(DiscardReason.BEFORE_SEND, DataCategory.Span, i2);
        }
        try {
            ArrayList arrayListK = k(hint2);
            ArrayList arrayList = new ArrayList();
            Iterator it = arrayListK.iterator();
            while (it.hasNext()) {
                ((Attachment) it.next()).getClass();
            }
            SentryEnvelope sentryEnvelopeB = b(sentryTransactionD, arrayList, null, traceContext, profilingTraceData);
            hint2.a();
            return sentryEnvelopeB != null ? n(sentryEnvelopeB, hint2) : sentryId3;
        } catch (SentryEnvelopeException | IOException e2) {
            sentryOptions.getLogger().a(SentryLevel.WARNING, e2, "Capturing transaction %s failed.", sentryId3);
            return SentryId.f52907b;
        }
    }

    public final void i(boolean z) throws IOException {
        long shutdownTimeoutMillis;
        SentryOptions sentryOptions = this.f51804a;
        sentryOptions.getLogger().c(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        try {
            this.f51807d.close();
        } catch (IOException e2) {
            sentryOptions.getLogger().b(SentryLevel.WARNING, "Failed to close the metrics aggregator.", e2);
        }
        if (z) {
            shutdownTimeoutMillis = 0;
        } else {
            try {
                shutdownTimeoutMillis = sentryOptions.getShutdownTimeoutMillis();
            } catch (IOException e3) {
                sentryOptions.getLogger().b(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", e3);
            }
        }
        j(shutdownTimeoutMillis);
        this.f51805b.n(z);
        for (EventProcessor eventProcessor : sentryOptions.getEventProcessors()) {
            if (eventProcessor instanceof Closeable) {
                try {
                    ((Closeable) eventProcessor).close();
                } catch (IOException e4) {
                    sentryOptions.getLogger().c(SentryLevel.WARNING, "Failed to close the event processor {}.", eventProcessor, e4);
                }
            }
        }
    }

    public final void j(long j2) {
        this.f51805b.v(j2);
    }

    public final SentryEvent l(SentryEvent sentryEvent, Hint hint, List list) {
        SentryOptions sentryOptions = this.f51804a;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor eventProcessor = (EventProcessor) it.next();
            try {
                boolean z = eventProcessor instanceof BackfillingEventProcessor;
                boolean zIsInstance = Backfillable.class.isInstance(HintUtils.b(hint));
                if (zIsInstance && z) {
                    sentryEvent = eventProcessor.b(sentryEvent, hint);
                } else if (!zIsInstance && !z) {
                    sentryEvent = eventProcessor.b(sentryEvent, hint);
                }
            } catch (Throwable th) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing event by processor: %s", eventProcessor.getClass().getName());
            }
            if (sentryEvent == null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Event was dropped by a processor: %s", eventProcessor.getClass().getName());
                sentryOptions.getClientReportRecorder().a(DiscardReason.EVENT_PROCESSOR, DataCategory.Error);
                break;
            }
        }
        return sentryEvent;
    }

    public final SentryTransaction m(SentryTransaction sentryTransaction, Hint hint, List list) {
        SentryOptions sentryOptions = this.f51804a;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor eventProcessor = (EventProcessor) it.next();
            int size = sentryTransaction.s.size();
            try {
                sentryTransaction = eventProcessor.c(sentryTransaction, hint);
            } catch (Throwable th) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing transaction by processor: %s", eventProcessor.getClass().getName());
            }
            int size2 = sentryTransaction == null ? 0 : sentryTransaction.s.size();
            if (sentryTransaction == null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Transaction was dropped by a processor: %s", eventProcessor.getClass().getName());
                IClientReportRecorder clientReportRecorder = sentryOptions.getClientReportRecorder();
                DiscardReason discardReason = DiscardReason.EVENT_PROCESSOR;
                clientReportRecorder.a(discardReason, DataCategory.Transaction);
                sentryOptions.getClientReportRecorder().c(discardReason, DataCategory.Span, size + 1);
                break;
            }
            if (size2 < size) {
                int i2 = size - size2;
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "%d spans were dropped by a processor: %s", Integer.valueOf(i2), eventProcessor.getClass().getName());
                sentryOptions.getClientReportRecorder().c(DiscardReason.EVENT_PROCESSOR, DataCategory.Span, i2);
            }
        }
        return sentryTransaction;
    }

    public final SentryId n(SentryEnvelope sentryEnvelope, Hint hint) {
        SentryOptions sentryOptions = this.f51804a;
        SentryOptions.BeforeEnvelopeCallback beforeEnvelopeCallback = sentryOptions.getBeforeEnvelopeCallback();
        if (beforeEnvelopeCallback != null) {
            try {
                beforeEnvelopeCallback.a(sentryEnvelope);
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "The BeforeEnvelope callback threw an exception.", th);
            }
        }
        this.f51805b.M(sentryEnvelope, hint);
        SentryId sentryId = sentryEnvelope.f51812a.f51814a;
        return sentryId != null ? sentryId : SentryId.f52907b;
    }

    public final boolean o(SentryBaseEvent sentryBaseEvent, Hint hint) {
        if (HintUtils.e(hint)) {
            return true;
        }
        this.f51804a.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", sentryBaseEvent.f51791a);
        return false;
    }
}
