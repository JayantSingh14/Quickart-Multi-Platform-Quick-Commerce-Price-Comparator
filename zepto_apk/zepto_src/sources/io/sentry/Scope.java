package io.sentry;

import in.juspay.airborne.ota.Constants;
import in.juspay.hypersdk.analytics.LogConstants;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.protocol.App;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

/* loaded from: classes.dex */
public final class Scope implements IScope {

    /* renamed from: a, reason: collision with root package name */
    public ITransaction f51759a;

    /* renamed from: b, reason: collision with root package name */
    public User f51760b;

    /* renamed from: c, reason: collision with root package name */
    public String f51761c;

    /* renamed from: d, reason: collision with root package name */
    public Request f51762d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f51763e;

    /* renamed from: f, reason: collision with root package name */
    public final Queue f51764f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f51765g;

    /* renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f51766h;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f51767i;

    /* renamed from: j, reason: collision with root package name */
    public final SentryOptions f51768j;

    /* renamed from: k, reason: collision with root package name */
    public volatile Session f51769k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f51770l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f51771m;
    public final Object n;
    public final Contexts o;
    public final CopyOnWriteArrayList p;
    public PropagationContext q;
    public SentryId r;

    @ApiStatus.Internal
    /* loaded from: classes3.dex */
    public interface IWithPropagationContext {
        void a(PropagationContext propagationContext);
    }

    /* loaded from: classes3.dex */
    public interface IWithSession {
        void b(Session session);
    }

    @ApiStatus.Internal
    /* loaded from: classes3.dex */
    public interface IWithTransaction {
        void e(ITransaction iTransaction);
    }

    public static final class SessionPair {

        /* renamed from: a, reason: collision with root package name */
        public final Session f51772a;

        /* renamed from: b, reason: collision with root package name */
        public final Session f51773b;

        public SessionPair(Session session, Session session2) {
            this.f51773b = session;
            this.f51772a = session2;
        }
    }

    public Scope(SentryOptions sentryOptions) {
        this.f51763e = new ArrayList();
        this.f51765g = new ConcurrentHashMap();
        this.f51766h = new ConcurrentHashMap();
        this.f51767i = new CopyOnWriteArrayList();
        this.f51770l = new Object();
        this.f51771m = new Object();
        this.n = new Object();
        this.o = new Contexts();
        this.p = new CopyOnWriteArrayList();
        this.r = SentryId.f52907b;
        this.f51768j = sentryOptions;
        int maxBreadcrumbs = sentryOptions.getMaxBreadcrumbs();
        this.f51764f = maxBreadcrumbs > 0 ? new SynchronizedQueue(new CircularFifoQueue(maxBreadcrumbs)) : new SynchronizedQueue(new DisabledQueue());
        this.q = new PropagationContext();
    }

    @Override // io.sentry.IScope
    public final PropagationContext A() {
        return this.q;
    }

    @Override // io.sentry.IScope
    public final void B(String str) {
        this.f51761c = str;
        Contexts contexts = this.o;
        App app2 = (App) contexts.d(App.class, Constants.APP_DIR);
        if (app2 == null) {
            app2 = new App();
            contexts.b(app2);
        }
        if (str == null) {
            app2.f52807i = null;
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            app2.f52807i = arrayList;
        }
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().h(contexts);
        }
    }

    @Override // io.sentry.IScope
    public final List C() {
        return new CopyOnWriteArrayList(this.p);
    }

    @Override // io.sentry.IScope
    public final void D() {
        this.f51769k = null;
    }

    @Override // io.sentry.IScope
    public final PropagationContext E(IWithPropagationContext iWithPropagationContext) {
        PropagationContext propagationContext;
        synchronized (this.n) {
            iWithPropagationContext.a(this.q);
            propagationContext = new PropagationContext(this.q);
        }
        return propagationContext;
    }

    @Override // io.sentry.IScope
    public final void F(IWithTransaction iWithTransaction) {
        synchronized (this.f51771m) {
            iWithTransaction.e(this.f51759a);
        }
    }

    @Override // io.sentry.IScope
    public final List G() {
        return this.f51767i;
    }

    @Override // io.sentry.IScope
    public final void H(PropagationContext propagationContext) {
        this.q = propagationContext;
        SpanContext spanContext = new SpanContext(propagationContext.f51748a, propagationContext.f51749b, LogConstants.DEFAULT_CHANNEL, null, null);
        spanContext.f51929i = "auto";
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().b(spanContext, this);
        }
    }

    @Override // io.sentry.IScope
    public final SentryLevel a() {
        return null;
    }

    @Override // io.sentry.IScope
    public final void b(Breadcrumb breadcrumb, Hint hint) {
        if (hint == null) {
            new Hint();
        }
        SentryOptions sentryOptions = this.f51768j;
        SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumb = sentryOptions.getBeforeBreadcrumb();
        if (beforeBreadcrumb != null) {
            try {
                breadcrumb = beforeBreadcrumb.a(breadcrumb);
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th);
                if (th.getMessage() != null) {
                    breadcrumb.b(th.getMessage(), "sentry:message");
                }
            }
        }
        if (breadcrumb == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
            return;
        }
        Collection collection = this.f51764f;
        ((SynchronizedCollection) collection).add(breadcrumb);
        for (IScopeObserver iScopeObserver : sentryOptions.getScopeObservers()) {
            iScopeObserver.d(breadcrumb);
            iScopeObserver.a(collection);
        }
    }

    @Override // io.sentry.IScope
    public final void c(User user) {
        this.f51760b = user;
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().c(user);
        }
    }

    @Override // io.sentry.IScope
    public final void clear() {
        this.f51760b = null;
        this.f51762d = null;
        this.f51761c = null;
        this.f51763e.clear();
        o();
        this.f51765g.clear();
        this.f51766h.clear();
        this.f51767i.clear();
        w();
        this.p.clear();
    }

    @Override // io.sentry.IScope
    public final IScope clone() {
        return new Scope(this);
    }

    @Override // io.sentry.IScope
    public final void d(Breadcrumb breadcrumb) {
        b(breadcrumb, null);
    }

    @Override // io.sentry.IScope
    public final void e(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.f51765g;
        concurrentHashMap.put(str, str2);
        for (IScopeObserver iScopeObserver : this.f51768j.getScopeObservers()) {
            iScopeObserver.e(str, str2);
            iScopeObserver.j(concurrentHashMap);
        }
    }

    @Override // io.sentry.IScope
    public final void f(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.f51766h;
        concurrentHashMap.put(str, str2);
        for (IScopeObserver iScopeObserver : this.f51768j.getScopeObservers()) {
            iScopeObserver.f(str, str2);
            iScopeObserver.i(concurrentHashMap);
        }
    }

    @Override // io.sentry.IScope
    public final void g(SentryId sentryId) {
        this.r = sentryId;
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().g(sentryId);
        }
    }

    @Override // io.sentry.IScope
    public final Map getExtras() {
        return this.f51766h;
    }

    @Override // io.sentry.IScope
    public final Request getRequest() {
        return this.f51762d;
    }

    @Override // io.sentry.IScope
    public final ISpan h() {
        Span spanM;
        ITransaction iTransaction = this.f51759a;
        return (iTransaction == null || (spanM = iTransaction.m()) == null) ? iTransaction : spanM;
    }

    @Override // io.sentry.IScope
    public final Queue i() {
        return this.f51764f;
    }

    @Override // io.sentry.IScope
    public final ITransaction j() {
        return this.f51759a;
    }

    @Override // io.sentry.IScope
    public final String k() {
        return this.f51761c;
    }

    @Override // io.sentry.IScope
    public final Session l() {
        Session session;
        synchronized (this.f51770l) {
            try {
                session = null;
                if (this.f51769k != null) {
                    Session session2 = this.f51769k;
                    session2.getClass();
                    session2.b(DateUtils.a());
                    Session sessionA = this.f51769k.clone();
                    this.f51769k = null;
                    session = sessionA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return session;
    }

    @Override // io.sentry.IScope
    public final Session m(IWithSession iWithSession) {
        Session sessionA;
        synchronized (this.f51770l) {
            try {
                iWithSession.b(this.f51769k);
                sessionA = this.f51769k != null ? this.f51769k.clone() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionA;
    }

    @Override // io.sentry.IScope
    public final Map n() {
        return CollectionUtils.c(this.f51765g);
    }

    @Override // io.sentry.IScope
    public final void o() {
        Collection collection = this.f51764f;
        ((SynchronizedCollection) collection).clear();
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().a(collection);
        }
    }

    @Override // io.sentry.IScope
    public final SessionPair p() {
        SessionPair sessionPair;
        synchronized (this.f51770l) {
            try {
                if (this.f51769k != null) {
                    Session session = this.f51769k;
                    session.getClass();
                    session.b(DateUtils.a());
                }
                Session session2 = this.f51769k;
                sessionPair = null;
                if (this.f51768j.getRelease() != null) {
                    String distinctId = this.f51768j.getDistinctId();
                    User user = this.f51760b;
                    this.f51769k = new Session(Session.State.Ok, DateUtils.a(), DateUtils.a(), 0, distinctId, UUID.randomUUID(), Boolean.TRUE, null, null, user != null ? user.f52963e : null, null, this.f51768j.getEnvironment(), this.f51768j.getRelease(), null);
                    sessionPair = new SessionPair(this.f51769k.clone(), session2 != null ? session2.clone() : null);
                } else {
                    this.f51768j.getLogger().c(SentryLevel.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionPair;
    }

    @Override // io.sentry.IScope
    public final Contexts q() {
        return this.o;
    }

    @Override // io.sentry.IScope
    public final void r(ITransaction iTransaction) {
        synchronized (this.f51771m) {
            try {
                this.f51759a = iTransaction;
                for (IScopeObserver iScopeObserver : this.f51768j.getScopeObservers()) {
                    iScopeObserver.k(iTransaction.getName());
                    iScopeObserver.b(iTransaction.o(), this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.IScope
    public final List s() {
        return this.f51763e;
    }

    @Override // io.sentry.IScope
    public final User t() {
        return this.f51760b;
    }

    @Override // io.sentry.IScope
    public final void u(String str, HashMap map) {
        Contexts contexts = this.o;
        contexts.put(str, map);
        Iterator<IScopeObserver> it = this.f51768j.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().h(contexts);
        }
    }

    @Override // io.sentry.IScope
    public final String v() {
        ITransaction iTransaction = this.f51759a;
        if (iTransaction != null) {
            return iTransaction.getName();
        }
        return null;
    }

    @Override // io.sentry.IScope
    public final void w() {
        synchronized (this.f51771m) {
            this.f51759a = null;
        }
        for (IScopeObserver iScopeObserver : this.f51768j.getScopeObservers()) {
            iScopeObserver.k(null);
            iScopeObserver.b(null, this);
        }
    }

    @Override // io.sentry.IScope
    public final void x(String str) {
        this.o.remove(str);
    }

    @Override // io.sentry.IScope
    public final Session y() {
        return this.f51769k;
    }

    @Override // io.sentry.IScope
    public final SentryId z() {
        return this.r;
    }

    /* renamed from: clone, reason: collision with other method in class */
    public final Object m71clone() {
        return new Scope(this);
    }

    public Scope(Scope scope) {
        User user;
        SynchronizedQueue synchronizedQueue;
        this.f51763e = new ArrayList();
        this.f51765g = new ConcurrentHashMap();
        this.f51766h = new ConcurrentHashMap();
        this.f51767i = new CopyOnWriteArrayList();
        this.f51770l = new Object();
        this.f51771m = new Object();
        this.n = new Object();
        this.o = new Contexts();
        this.p = new CopyOnWriteArrayList();
        this.r = SentryId.f52907b;
        this.f51759a = scope.f51759a;
        this.f51769k = scope.f51769k;
        this.f51768j = scope.f51768j;
        User user2 = scope.f51760b;
        Request request = null;
        if (user2 != null) {
            user = new User();
            user.f52959a = user2.f52959a;
            user.f52961c = user2.f52961c;
            user.f52960b = user2.f52960b;
            user.f52963e = user2.f52963e;
            user.f52962d = user2.f52962d;
            user.f52964f = user2.f52964f;
            user.f52965g = user2.f52965g;
            user.f52966h = CollectionUtils.c(user2.f52966h);
            user.f52967i = CollectionUtils.c(user2.f52967i);
        } else {
            user = null;
        }
        this.f51760b = user;
        this.f51761c = scope.f51761c;
        this.r = scope.r;
        Request request2 = scope.f51762d;
        if (request2 != null) {
            request = new Request();
            request.f52872a = request2.f52872a;
            request.f52876e = request2.f52876e;
            request.f52873b = request2.f52873b;
            request.f52874c = request2.f52874c;
            request.f52877f = CollectionUtils.c(request2.f52877f);
            request.f52878g = CollectionUtils.c(request2.f52878g);
            request.f52880i = CollectionUtils.c(request2.f52880i);
            request.f52883l = CollectionUtils.c(request2.f52883l);
            request.f52875d = request2.f52875d;
            request.f52881j = request2.f52881j;
            request.f52879h = request2.f52879h;
            request.f52882k = request2.f52882k;
        }
        this.f51762d = request;
        this.f51763e = new ArrayList(scope.f51763e);
        this.f51767i = new CopyOnWriteArrayList(scope.f51767i);
        Breadcrumb[] breadcrumbArr = (Breadcrumb[]) ((SynchronizedQueue) scope.f51764f).toArray(new Breadcrumb[0]);
        int maxBreadcrumbs = scope.f51768j.getMaxBreadcrumbs();
        if (maxBreadcrumbs > 0) {
            synchronizedQueue = new SynchronizedQueue(new CircularFifoQueue(maxBreadcrumbs));
        } else {
            synchronizedQueue = new SynchronizedQueue(new DisabledQueue());
        }
        for (Breadcrumb breadcrumb : breadcrumbArr) {
            synchronizedQueue.add(new Breadcrumb(breadcrumb));
        }
        this.f51764f = synchronizedQueue;
        ConcurrentHashMap concurrentHashMap = scope.f51765g;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            if (entry != null) {
                concurrentHashMap2.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f51765g = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = scope.f51766h;
        ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
        for (Map.Entry entry2 : concurrentHashMap3.entrySet()) {
            if (entry2 != null) {
                concurrentHashMap4.put((String) entry2.getKey(), entry2.getValue());
            }
        }
        this.f51766h = concurrentHashMap4;
        this.o = new Contexts(scope.o);
        this.p = new CopyOnWriteArrayList(scope.p);
        this.q = new PropagationContext(scope.q);
    }
}
