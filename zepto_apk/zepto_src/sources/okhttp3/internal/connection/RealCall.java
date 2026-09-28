package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealCall implements Call {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f56517a;

    /* renamed from: b, reason: collision with root package name */
    public final Request f56518b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56519c;

    /* renamed from: d, reason: collision with root package name */
    public final RealConnectionPool f56520d;

    /* renamed from: e, reason: collision with root package name */
    public final EventListener f56521e;

    /* renamed from: f, reason: collision with root package name */
    public final RealCall$timeout$1 f56522f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f56523g;

    /* renamed from: h, reason: collision with root package name */
    public Object f56524h;

    /* renamed from: i, reason: collision with root package name */
    public ExchangeFinder f56525i;

    /* renamed from: j, reason: collision with root package name */
    public RealConnection f56526j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f56527k;

    /* renamed from: l, reason: collision with root package name */
    public Exchange f56528l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f56529m;
    public boolean n;
    public boolean o;
    public volatile boolean p;
    public volatile Exchange q;
    public volatile RealConnection r;

    @Metadata
    @SourceDebugExtension
    public final class AsyncCall implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Callback f56530a;

        /* renamed from: b, reason: collision with root package name */
        public volatile AtomicInteger f56531b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RealCall f56532c;

        public AsyncCall(RealCall realCall, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.f56532c = realCall;
            this.f56530a = responseCallback;
            this.f56531b = new AtomicInteger(0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dispatcher dispatcher;
            String str = "OkHttp " + this.f56532c.f56518b.f56331a.g();
            RealCall realCall = this.f56532c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                realCall.f56522f.i();
                boolean z = false;
                try {
                    try {
                        try {
                            this.f56530a.onResponse(realCall, realCall.f());
                            dispatcher = realCall.f56517a.f56297a;
                        } catch (IOException e2) {
                            e = e2;
                            z = true;
                            if (z) {
                                Platform platform = Platform.f56791a;
                                Platform platform2 = Platform.f56791a;
                                String str2 = "Callback failure for " + RealCall.a(realCall);
                                platform2.getClass();
                                Platform.i(4, str2, e);
                            } else {
                                this.f56530a.onFailure(realCall, e);
                            }
                            dispatcher = realCall.f56517a.f56297a;
                            dispatcher.c(this);
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            realCall.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                ExceptionsKt.a(iOException, th);
                                this.f56530a.onFailure(realCall, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        realCall.f56517a.f56297a.c(this);
                        throw th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th3) {
                    th = th3;
                }
                dispatcher.c(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    @Metadata
    public static final class CallReference extends WeakReference<RealCall> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f56533a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.f56533a = obj;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(OkHttpClient client, Request originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.f56517a = client;
        this.f56518b = originalRequest;
        this.f56519c = z;
        this.f56520d = client.f56298b.f56210a;
        this.f56521e = client.f56301e.d(this);
        ?? r4 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public final void l() {
                this.f56534m.cancel();
            }
        };
        r4.g(client.x, TimeUnit.MILLISECONDS);
        this.f56522f = r4;
        this.f56523g = new AtomicBoolean();
        this.o = true;
    }

    public static final String a(RealCall realCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(realCall.p ? "canceled " : "");
        sb.append(realCall.f56519c ? "web socket" : "call");
        sb.append(" to ");
        sb.append(realCall.f56518b.f56331a.g());
        return sb.toString();
    }

    public final void b(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        byte[] bArr = Util.f56394a;
        if (this.f56526j != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.f56526j = connection;
        connection.p.add(new CallReference(this, this.f56524h));
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        Socket socketI;
        byte[] bArr = Util.f56394a;
        RealConnection realConnection = this.f56526j;
        if (realConnection != null) {
            synchronized (realConnection) {
                socketI = i();
            }
            if (this.f56526j == null) {
                if (socketI != null) {
                    Util.d(socketI);
                }
                this.f56521e.l(this, realConnection);
            } else if (socketI != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.f56527k && j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException == null) {
            this.f56521e.d(this);
            return interruptedIOException;
        }
        EventListener eventListener = this.f56521e;
        Intrinsics.c(interruptedIOException);
        eventListener.e(this, interruptedIOException);
        return interruptedIOException;
    }

    @Override // okhttp3.Call
    public final void cancel() {
        Socket socket;
        if (this.p) {
            return;
        }
        this.p = true;
        Exchange exchange = this.q;
        if (exchange != null) {
            exchange.f56492d.cancel();
        }
        RealConnection realConnection = this.r;
        if (realConnection != null && (socket = realConnection.f56536c) != null) {
            Util.d(socket);
        }
        this.f56521e.g(this);
    }

    public final Object clone() {
        return new RealCall(this.f56517a, this.f56518b, this.f56519c);
    }

    public final Response d() {
        if (!this.f56523g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        i();
        Platform platform = Platform.f56791a;
        this.f56524h = Platform.f56791a.g();
        this.f56521e.f(this);
        try {
            Dispatcher dispatcher = this.f56517a.f56297a;
            synchronized (dispatcher) {
                Intrinsics.checkNotNullParameter(this, "call");
                dispatcher.f56241d.add(this);
            }
            return f();
        } finally {
            Dispatcher dispatcher2 = this.f56517a.f56297a;
            dispatcher2.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
            dispatcher2.b(dispatcher2.f56241d, this);
        }
    }

    public final void e(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.o) {
                throw new IllegalStateException("released");
            }
            Unit unit = Unit.f53572a;
        }
        if (z && (exchange = this.q) != null) {
            exchange.f56492d.cancel();
            exchange.f56489a.g(exchange, true, true, null);
        }
        this.f56528l = null;
    }

    public final Response f() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt.i(arrayList, this.f56517a.f56299c);
        arrayList.add(new RetryAndFollowUpInterceptor(this.f56517a));
        arrayList.add(new BridgeInterceptor(this.f56517a.f56306j));
        arrayList.add(new CacheInterceptor(this.f56517a.f56307k));
        arrayList.add(ConnectInterceptor.f56484a);
        if (!this.f56519c) {
            CollectionsKt.i(arrayList, this.f56517a.f56300d);
        }
        arrayList.add(new CallServerInterceptor(this.f56519c));
        Request request = this.f56518b;
        OkHttpClient okHttpClient = this.f56517a;
        try {
            try {
                Response responseA = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.y, okHttpClient.z, okHttpClient.A).a(this.f56518b);
                if (this.p) {
                    Util.c(responseA);
                    throw new IOException("Canceled");
                }
                h(null);
                return responseA;
            } catch (IOException e2) {
                IOException iOExceptionH = h(e2);
                Intrinsics.d(iOExceptionH, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionH;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                h(null);
            }
            throw th;
        }
    }

    public final IOException g(Exchange exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (Intrinsics.b(exchange, this.q)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (!this.f56529m) {
                            if (z2 || !this.n) {
                                z4 = false;
                            }
                            Unit unit = Unit.f53572a;
                        }
                        if (z) {
                            this.f56529m = false;
                        }
                        if (z2) {
                            this.n = false;
                        }
                        boolean z5 = this.f56529m;
                        boolean z6 = (z5 || this.n) ? false : true;
                        if (!z5 && !this.n && !this.o) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                        Unit unit2 = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z2) {
                    }
                    z4 = false;
                    Unit unit22 = Unit.f53572a;
                }
            }
            if (z3) {
                this.q = null;
                RealConnection realConnection = this.f56526j;
                if (realConnection != null) {
                    synchronized (realConnection) {
                        realConnection.f56546m++;
                    }
                }
            }
            if (z4) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException h(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.o) {
                    this.o = false;
                    if (!this.f56529m && !this.n) {
                        z = true;
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? c(iOException) : iOException;
    }

    public final Socket i() {
        RealConnection connection = this.f56526j;
        Intrinsics.c(connection);
        byte[] bArr = Util.f56394a;
        ArrayList arrayList = connection.p;
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (Intrinsics.b(((Reference) it.next()).get(), this)) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i2);
        this.f56526j = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        connection.q = System.nanoTime();
        RealConnectionPool realConnectionPool = this.f56520d;
        realConnectionPool.getClass();
        Intrinsics.checkNotNullParameter(connection, "connection");
        byte[] bArr2 = Util.f56394a;
        boolean z = connection.f56543j;
        TaskQueue taskQueue = realConnectionPool.f56554b;
        if (!z) {
            taskQueue.c(realConnectionPool.f56555c, 0L);
            return null;
        }
        connection.f56543j = true;
        ConcurrentLinkedQueue concurrentLinkedQueue = realConnectionPool.f56556d;
        concurrentLinkedQueue.remove(connection);
        if (concurrentLinkedQueue.isEmpty()) {
            taskQueue.a();
        }
        Socket socket = connection.f56537d;
        Intrinsics.c(socket);
        return socket;
    }

    @Override // okhttp3.Call
    public final void l0(Callback responseCallback) {
        AsyncCall other;
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.f56523g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        Platform platform = Platform.f56791a;
        this.f56524h = Platform.f56791a.g();
        this.f56521e.f(this);
        Dispatcher dispatcher = this.f56517a.f56297a;
        AsyncCall call = new AsyncCall(this, responseCallback);
        dispatcher.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (dispatcher) {
            dispatcher.f56239b.add(call);
            if (!this.f56519c) {
                String str = this.f56518b.f56331a.f56262d;
                Iterator it = dispatcher.f56240c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator it2 = dispatcher.f56239b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                other = null;
                                break;
                            } else {
                                other = (AsyncCall) it2.next();
                                if (Intrinsics.b(other.f56532c.f56518b.f56331a.f56262d, str)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        other = (AsyncCall) it.next();
                        if (Intrinsics.b(other.f56532c.f56518b.f56331a.f56262d, str)) {
                            break;
                        }
                    }
                }
                if (other != null) {
                    Intrinsics.checkNotNullParameter(other, "other");
                    call.f56531b = other.f56531b;
                }
            }
            Unit unit = Unit.f53572a;
        }
        dispatcher.d();
    }

    @Override // okhttp3.Call
    public final Request r() {
        return this.f56518b;
    }

    @Override // okhttp3.Call
    public final boolean s() {
        return this.p;
    }
}
