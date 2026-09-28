package io.sentry;

import io.sentry.Scope;
import io.sentry.Session;
import io.sentry.hints.AbnormalExit;
import io.sentry.protocol.Request;
import io.sentry.util.HintUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Scope.IWithSession, SpanFinishedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f52768a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52769b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f52770c;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3) {
        this.f52768a = obj;
        this.f52769b = obj2;
        this.f52770c = obj3;
    }

    @Override // io.sentry.SpanFinishedCallback
    public void a(Span span) {
        SentryTracer sentryTracer = (SentryTracer) this.f52768a;
        SpanFinishedCallback spanFinishedCallback = (SpanFinishedCallback) this.f52769b;
        if (spanFinishedCallback != null) {
            spanFinishedCallback.a(span);
        }
        io.sentry.android.core.d dVar = sentryTracer.r.f51970g;
        if (dVar != null) {
            dVar.b(sentryTracer);
        }
        TransactionPerformanceCollector transactionPerformanceCollector = sentryTracer.q;
        if (transactionPerformanceCollector != null) {
            ((AtomicReference) this.f52770c).set(transactionPerformanceCollector.d(sentryTracer));
        }
    }

    @Override // io.sentry.Scope.IWithSession
    public void b(Session session) {
        ConcurrentHashMap concurrentHashMap;
        SentryClient sentryClient = (SentryClient) this.f52768a;
        if (session == null) {
            sentryClient.f51804a.getLogger().c(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
            return;
        }
        sentryClient.getClass();
        SentryEvent sentryEvent = (SentryEvent) this.f52769b;
        String strH = null;
        Session.State state = sentryEvent.e() != null ? Session.State.Crashed : null;
        boolean z = Session.State.Crashed == state || sentryEvent.f();
        Request request = sentryEvent.f51794d;
        String str = (request == null || (concurrentHashMap = request.f52877f) == null || !concurrentHashMap.containsKey("user-agent")) ? null : (String) sentryEvent.f51794d.f52877f.get("user-agent");
        Object objB = HintUtils.b((Hint) this.f52770c);
        if (objB instanceof AbnormalExit) {
            strH = ((AbnormalExit) objB).h();
            state = Session.State.Abnormal;
        }
        if (!session.c(state, str, z, strH) || session.f51900g == Session.State.Ok) {
            return;
        }
        session.b(DateUtils.a());
    }
}
