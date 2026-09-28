package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.DateUtils;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.SentryTransaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ClientReportRecorder implements IClientReportRecorder {

    /* renamed from: a, reason: collision with root package name */
    public final IClientReportStorage f52717a = new AtomicClientReportStorage();

    /* renamed from: b, reason: collision with root package name */
    public final SentryOptions f52718b;

    public ClientReportRecorder(SentryOptions sentryOptions) {
        this.f52718b = sentryOptions;
    }

    public static DataCategory f(SentryItemType sentryItemType) {
        return SentryItemType.Event.equals(sentryItemType) ? DataCategory.Error : SentryItemType.Session.equals(sentryItemType) ? DataCategory.Session : SentryItemType.Transaction.equals(sentryItemType) ? DataCategory.Transaction : SentryItemType.UserFeedback.equals(sentryItemType) ? DataCategory.UserReport : SentryItemType.Profile.equals(sentryItemType) ? DataCategory.Profile : SentryItemType.Statsd.equals(sentryItemType) ? DataCategory.MetricBucket : SentryItemType.Attachment.equals(sentryItemType) ? DataCategory.Attachment : SentryItemType.CheckIn.equals(sentryItemType) ? DataCategory.Monitor : SentryItemType.ReplayVideo.equals(sentryItemType) ? DataCategory.Replay : DataCategory.Default;
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void a(DiscardReason discardReason, DataCategory dataCategory) {
        c(discardReason, dataCategory, 1L);
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void b(DiscardReason discardReason, SentryEnvelope sentryEnvelope) {
        if (sentryEnvelope == null) {
            return;
        }
        try {
            Iterator it = sentryEnvelope.f51813b.iterator();
            while (it.hasNext()) {
                d(discardReason, (SentryEnvelopeItem) it.next());
            }
        } catch (Throwable th) {
            this.f52718b.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost envelope.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void c(DiscardReason discardReason, DataCategory dataCategory, long j2) {
        try {
            g(discardReason.getReason(), dataCategory.getCategory(), Long.valueOf(j2));
        } catch (Throwable th) {
            this.f52718b.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void d(DiscardReason discardReason, SentryEnvelopeItem sentryEnvelopeItem) {
        SentryTransaction sentryTransactionF;
        SentryOptions sentryOptions = this.f52718b;
        if (sentryEnvelopeItem == null) {
            return;
        }
        try {
            SentryItemType sentryItemType = sentryEnvelopeItem.f51820a.f51827c;
            if (SentryItemType.ClientReport.equals(sentryItemType)) {
                try {
                    h(sentryEnvelopeItem.c(sentryOptions.getSerializer()));
                } catch (Exception unused) {
                    sentryOptions.getLogger().c(SentryLevel.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                }
            } else {
                DataCategory dataCategoryF = f(sentryItemType);
                if (dataCategoryF.equals(DataCategory.Transaction) && (sentryTransactionF = sentryEnvelopeItem.f(sentryOptions.getSerializer())) != null) {
                    g(discardReason.getReason(), DataCategory.Span.getCategory(), Long.valueOf(sentryTransactionF.s.size() + 1));
                }
                g(discardReason.getReason(), dataCategoryF.getCategory(), 1L);
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost envelope item.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final SentryEnvelope e(SentryEnvelope sentryEnvelope) {
        SentryOptions sentryOptions = this.f52718b;
        Date dateA = DateUtils.a();
        AtomicClientReportStorage atomicClientReportStorage = (AtomicClientReportStorage) this.f52717a;
        atomicClientReportStorage.getClass();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((Map) atomicClientReportStorage.f52711a.a()).entrySet()) {
            long andSet = ((AtomicLong) entry.getValue()).getAndSet(0L);
            Long lValueOf = Long.valueOf(andSet);
            if (andSet > 0) {
                arrayList.add(new DiscardedEvent(((ClientReportKey) entry.getKey()).f52715a, ((ClientReportKey) entry.getKey()).f52716b, lValueOf));
            }
        }
        ClientReport clientReport = arrayList.isEmpty() ? null : new ClientReport(dateA, arrayList);
        if (clientReport == null) {
            return sentryEnvelope;
        }
        try {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = sentryEnvelope.f51813b.iterator();
            while (it.hasNext()) {
                arrayList2.add((SentryEnvelopeItem) it.next());
            }
            arrayList2.add(SentryEnvelopeItem.a(sentryOptions.getSerializer(), clientReport));
            return new SentryEnvelope(sentryEnvelope.f51812a, arrayList2);
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return sentryEnvelope;
        }
    }

    public final void g(String str, String str2, Long l2) {
        AtomicLong atomicLong = (AtomicLong) ((Map) ((AtomicClientReportStorage) this.f52717a).f52711a.a()).get(new ClientReportKey(str, str2));
        if (atomicLong != null) {
            atomicLong.addAndGet(l2.longValue());
        }
    }

    public final void h(ClientReport clientReport) {
        if (clientReport == null) {
            return;
        }
        Iterator it = clientReport.f52713b.iterator();
        while (it.hasNext()) {
            DiscardedEvent discardedEvent = (DiscardedEvent) it.next();
            g(discardedEvent.c(), discardedEvent.a(), discardedEvent.b());
        }
    }
}
