package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    public static final EngineResourceFactory v = new EngineResourceFactory();

    /* renamed from: a, reason: collision with root package name */
    public final ResourceCallbacksAndExecutors f15964a;

    /* renamed from: b, reason: collision with root package name */
    public final StateVerifier f15965b;

    /* renamed from: c, reason: collision with root package name */
    public final Engine f15966c;

    /* renamed from: d, reason: collision with root package name */
    public final Pools.Pool f15967d;

    /* renamed from: e, reason: collision with root package name */
    public final EngineResourceFactory f15968e;

    /* renamed from: f, reason: collision with root package name */
    public final Engine f15969f;

    /* renamed from: g, reason: collision with root package name */
    public final GlideExecutor f15970g;

    /* renamed from: h, reason: collision with root package name */
    public final GlideExecutor f15971h;

    /* renamed from: i, reason: collision with root package name */
    public final GlideExecutor f15972i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f15973j;

    /* renamed from: k, reason: collision with root package name */
    public Key f15974k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15975l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15976m;
    public Resource n;
    public DataSource o;
    public boolean p;
    public GlideException q;
    public boolean r;
    public EngineResource s;
    public DecodeJob t;
    public volatile boolean u;

    public class CallLoadFailed implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SingleRequest f15977a;

        public CallLoadFailed(SingleRequest singleRequest) {
            this.f15977a = singleRequest;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.f15977a.e()) {
                synchronized (EngineJob.this) {
                    try {
                        ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = EngineJob.this.f15964a;
                        SingleRequest singleRequest = this.f15977a;
                        resourceCallbacksAndExecutors.getClass();
                        if (resourceCallbacksAndExecutors.f15983a.contains(new ResourceCallbackAndExecutor(singleRequest, Executors.f16517b))) {
                            EngineJob engineJob = EngineJob.this;
                            SingleRequest singleRequest2 = this.f15977a;
                            engineJob.getClass();
                            try {
                                singleRequest2.h(engineJob.q, 5);
                            } catch (Throwable th) {
                                throw new CallbackException(th);
                            }
                        }
                        EngineJob.this.c();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public class CallResourceReady implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SingleRequest f15979a;

        public CallResourceReady(SingleRequest singleRequest) {
            this.f15979a = singleRequest;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.f15979a.e()) {
                synchronized (EngineJob.this) {
                    try {
                        ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = EngineJob.this.f15964a;
                        SingleRequest singleRequest = this.f15979a;
                        resourceCallbacksAndExecutors.getClass();
                        if (resourceCallbacksAndExecutors.f15983a.contains(new ResourceCallbackAndExecutor(singleRequest, Executors.f16517b))) {
                            EngineJob.this.s.b();
                            EngineJob engineJob = EngineJob.this;
                            SingleRequest singleRequest2 = this.f15979a;
                            engineJob.getClass();
                            try {
                                singleRequest2.i(engineJob.s, engineJob.o);
                                EngineJob.this.g(this.f15979a);
                            } catch (Throwable th) {
                                throw new CallbackException(th);
                            }
                        }
                        EngineJob.this.c();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public static class EngineResourceFactory {
    }

    public static final class ResourceCallbackAndExecutor {

        /* renamed from: a, reason: collision with root package name */
        public final SingleRequest f15981a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f15982b;

        public ResourceCallbackAndExecutor(SingleRequest singleRequest, Executor executor) {
            this.f15981a = singleRequest;
            this.f15982b = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f15981a.equals(((ResourceCallbackAndExecutor) obj).f15981a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f15981a.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f15983a;

        public ResourceCallbacksAndExecutors(ArrayList arrayList) {
            this.f15983a = arrayList;
        }

        @Override // java.lang.Iterable
        public final Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.f15983a.iterator();
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Engine engine, Engine engine2, Pools.Pool pool) {
        EngineResourceFactory engineResourceFactory = v;
        this.f15964a = new ResourceCallbacksAndExecutors(new ArrayList(2));
        this.f15965b = StateVerifier.a();
        this.f15973j = new AtomicInteger();
        this.f15970g = glideExecutor;
        this.f15971h = glideExecutor2;
        this.f15972i = glideExecutor4;
        this.f15969f = engine;
        this.f15966c = engine2;
        this.f15967d = pool;
        this.f15968e = engineResourceFactory;
    }

    public final synchronized void a(SingleRequest singleRequest, Executor executor) {
        try {
            this.f15965b.b();
            ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = this.f15964a;
            resourceCallbacksAndExecutors.getClass();
            resourceCallbacksAndExecutors.f15983a.add(new ResourceCallbackAndExecutor(singleRequest, executor));
            if (this.p) {
                d(1);
                executor.execute(new CallResourceReady(singleRequest));
            } else if (this.r) {
                d(1);
                executor.execute(new CallLoadFailed(singleRequest));
            } else {
                Preconditions.a(!this.u, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier b() {
        return this.f15965b;
    }

    public final void c() {
        EngineResource engineResource;
        synchronized (this) {
            try {
                this.f15965b.b();
                Preconditions.a(e(), "Not yet complete!");
                int iDecrementAndGet = this.f15973j.decrementAndGet();
                Preconditions.a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    engineResource = this.s;
                    f();
                } else {
                    engineResource = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (engineResource != null) {
            engineResource.c();
        }
    }

    public final synchronized void d(int i2) {
        EngineResource engineResource;
        Preconditions.a(e(), "Not yet complete!");
        if (this.f15973j.getAndAdd(i2) == 0 && (engineResource = this.s) != null) {
            engineResource.b();
        }
    }

    public final boolean e() {
        return this.r || this.p || this.u;
    }

    public final synchronized void f() {
        boolean zA;
        if (this.f15974k == null) {
            throw new IllegalArgumentException();
        }
        this.f15964a.f15983a.clear();
        this.f15974k = null;
        this.s = null;
        this.n = null;
        this.r = false;
        this.u = false;
        this.p = false;
        DecodeJob decodeJob = this.t;
        DecodeJob.ReleaseManager releaseManager = decodeJob.f15902g;
        synchronized (releaseManager) {
            releaseManager.f15917a = true;
            zA = releaseManager.a();
        }
        if (zA) {
            decodeJob.p();
        }
        this.t = null;
        this.q = null;
        this.o = null;
        this.f15967d.a(this);
    }

    public final synchronized void g(SingleRequest singleRequest) {
        try {
            this.f15965b.b();
            ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = this.f15964a;
            resourceCallbacksAndExecutors.getClass();
            resourceCallbacksAndExecutors.f15983a.remove(new ResourceCallbackAndExecutor(singleRequest, Executors.f16517b));
            if (this.f15964a.f15983a.isEmpty()) {
                if (!e()) {
                    this.u = true;
                    DecodeJob decodeJob = this.t;
                    decodeJob.D = true;
                    DataFetcherGenerator dataFetcherGenerator = decodeJob.B;
                    if (dataFetcherGenerator != null) {
                        dataFetcherGenerator.cancel();
                    }
                    Engine engine = this.f15969f;
                    Key key = this.f15974k;
                    synchronized (engine) {
                        Jobs jobs = engine.f15940a;
                        jobs.getClass();
                        HashMap map = jobs.f16008a;
                        if (equals(map.get(key))) {
                            map.remove(key);
                        }
                    }
                }
                if (this.p || this.r) {
                    if (this.f15973j.get() == 0) {
                        f();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h(DecodeJob decodeJob) {
        (this.f15976m ? this.f15972i : this.f15971h).execute(decodeJob);
    }
}
