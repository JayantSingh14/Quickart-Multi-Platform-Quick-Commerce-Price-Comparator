package com.bumptech.glide.load.engine;

import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.ActiveResources;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f15939h = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    public final Jobs f15940a;

    /* renamed from: b, reason: collision with root package name */
    public final EngineKeyFactory f15941b;

    /* renamed from: c, reason: collision with root package name */
    public final LruResourceCache f15942c;

    /* renamed from: d, reason: collision with root package name */
    public final EngineJobFactory f15943d;

    /* renamed from: e, reason: collision with root package name */
    public final ResourceRecycler f15944e;

    /* renamed from: f, reason: collision with root package name */
    public final DecodeJobFactory f15945f;

    /* renamed from: g, reason: collision with root package name */
    public final ActiveResources f15946g;

    @VisibleForTesting
    public static class DecodeJobFactory {

        /* renamed from: a, reason: collision with root package name */
        public final LazyDiskCacheProvider f15947a;

        /* renamed from: b, reason: collision with root package name */
        public final Pools.Pool f15948b = FactoryPools.a(150, new FactoryPools.Factory<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public final Object create() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob(decodeJobFactory.f15947a, decodeJobFactory.f15948b);
            }
        });

        /* renamed from: c, reason: collision with root package name */
        public int f15949c;

        public DecodeJobFactory(LazyDiskCacheProvider lazyDiskCacheProvider) {
            this.f15947a = lazyDiskCacheProvider;
        }
    }

    @VisibleForTesting
    public static class EngineJobFactory {

        /* renamed from: a, reason: collision with root package name */
        public final GlideExecutor f15951a;

        /* renamed from: b, reason: collision with root package name */
        public final GlideExecutor f15952b;

        /* renamed from: c, reason: collision with root package name */
        public final GlideExecutor f15953c;

        /* renamed from: d, reason: collision with root package name */
        public final GlideExecutor f15954d;

        /* renamed from: e, reason: collision with root package name */
        public final Engine f15955e;

        /* renamed from: f, reason: collision with root package name */
        public final Engine f15956f;

        /* renamed from: g, reason: collision with root package name */
        public final Pools.Pool f15957g = FactoryPools.a(150, new FactoryPools.Factory<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public final Object create() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                GlideExecutor glideExecutor = engineJobFactory.f15951a;
                Pools.Pool pool = engineJobFactory.f15957g;
                return new EngineJob(glideExecutor, engineJobFactory.f15952b, engineJobFactory.f15953c, engineJobFactory.f15954d, engineJobFactory.f15955e, engineJobFactory.f15956f, pool);
            }
        });

        public EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Engine engine, Engine engine2) {
            this.f15951a = glideExecutor;
            this.f15952b = glideExecutor2;
            this.f15953c = glideExecutor3;
            this.f15954d = glideExecutor4;
            this.f15955e = engine;
            this.f15956f = engine2;
        }
    }

    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a, reason: collision with root package name */
        public final InternalCacheDiskCacheFactory f15959a;

        /* renamed from: b, reason: collision with root package name */
        public volatile DiskCache f15960b;

        public LazyDiskCacheProvider(InternalCacheDiskCacheFactory internalCacheDiskCacheFactory) {
            this.f15959a = internalCacheDiskCacheFactory;
        }

        public final DiskCache a() {
            if (this.f15960b == null) {
                synchronized (this) {
                    try {
                        if (this.f15960b == null) {
                            this.f15960b = this.f15959a.a();
                        }
                        if (this.f15960b == null) {
                            this.f15960b = new DiskCacheAdapter();
                        }
                    } finally {
                    }
                }
            }
            return this.f15960b;
        }
    }

    public class LoadStatus {

        /* renamed from: a, reason: collision with root package name */
        public final EngineJob f15961a;

        /* renamed from: b, reason: collision with root package name */
        public final SingleRequest f15962b;

        public LoadStatus(SingleRequest singleRequest, EngineJob engineJob) {
            this.f15962b = singleRequest;
            this.f15961a = engineJob;
        }

        public final void a() {
            synchronized (Engine.this) {
                this.f15961a.g(this.f15962b);
            }
        }
    }

    public Engine(LruResourceCache lruResourceCache, InternalCacheDiskCacheFactory internalCacheDiskCacheFactory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4) throws Throwable {
        this.f15942c = lruResourceCache;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(internalCacheDiskCacheFactory);
        ActiveResources activeResources = new ActiveResources();
        this.f15946g = activeResources;
        synchronized (this) {
            try {
                synchronized (activeResources) {
                    try {
                        try {
                            activeResources.f15863d = this;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
                this.f15941b = new EngineKeyFactory();
                this.f15940a = new Jobs();
                this.f15943d = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
                this.f15945f = new DecodeJobFactory(lazyDiskCacheProvider);
                this.f15944e = new ResourceRecycler();
                lruResourceCache.f16099d = this;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static void c(String str, long j2, Key key) {
        StringBuilder sbX = b.x(str, " in ");
        sbX.append(LogTime.a(j2));
        sbX.append("ms, key: ");
        sbX.append(key);
        Log.v("Engine", sbX.toString());
    }

    public static void g(Resource resource) {
        if (!(resource instanceof EngineResource)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((EngineResource) resource).c();
    }

    public final LoadStatus a(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, CachedHashCodeArrayMap cachedHashCodeArrayMap, boolean z, boolean z2, Options options, boolean z3, boolean z4, SingleRequest singleRequest, Executor executor) {
        long jElapsedRealtimeNanos;
        if (f15939h) {
            int i4 = LogTime.f16520b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.f15941b.getClass();
        EngineKey engineKey = new EngineKey(obj, key, i2, i3, cachedHashCodeArrayMap, cls, cls2, options);
        synchronized (this) {
            try {
                EngineResource engineResourceB = b(engineKey, z3, jElapsedRealtimeNanos);
                if (engineResourceB == null) {
                    return h(glideContext, obj, key, i2, i3, cls, cls2, priority, diskCacheStrategy, cachedHashCodeArrayMap, z, z2, options, z3, z4, singleRequest, executor, engineKey, jElapsedRealtimeNanos);
                }
                singleRequest.i(engineResourceB, DataSource.f15792e);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final EngineResource b(EngineKey engineKey, boolean z, long j2) throws Throwable {
        Throwable th;
        EngineResource<?> engineResource;
        Throwable th2;
        Engine engine;
        EngineKey engineKey2;
        EngineResource engineResource2;
        if (z) {
            ActiveResources activeResources = this.f15946g;
            synchronized (activeResources) {
                try {
                    ActiveResources.ResourceWeakReference resourceWeakReference = (ActiveResources.ResourceWeakReference) activeResources.f15861b.get(engineKey);
                    if (resourceWeakReference == null) {
                        engineResource = null;
                    } else {
                        engineResource = resourceWeakReference.get();
                        if (engineResource == null) {
                            try {
                                activeResources.b(resourceWeakReference);
                            } catch (Throwable th3) {
                                th = th3;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                    th = th4;
                                }
                            }
                        }
                    }
                    if (engineResource != null) {
                        engineResource.b();
                    }
                    if (engineResource != null) {
                        if (f15939h) {
                            c("Loaded resource from active resources", j2, engineKey);
                        }
                        return engineResource;
                    }
                    LruResourceCache lruResourceCache = this.f15942c;
                    synchronized (lruResourceCache) {
                        try {
                            Object objRemove = lruResourceCache.f16521a.remove(engineKey);
                            if (objRemove != null) {
                                try {
                                    lruResourceCache.f16523c -= lruResourceCache.c(objRemove);
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    while (true) {
                                        try {
                                            throw th2;
                                        } catch (Throwable th6) {
                                            th2 = th6;
                                        }
                                        th2 = th6;
                                    }
                                }
                            }
                            Resource resource = (Resource) objRemove;
                            if (resource == null) {
                                engine = this;
                                engineKey2 = engineKey;
                                engineResource2 = null;
                            } else if (resource instanceof EngineResource) {
                                engineResource2 = (EngineResource) resource;
                                engine = this;
                                engineKey2 = engineKey;
                            } else {
                                engine = this;
                                engineKey2 = engineKey;
                                engineResource2 = new EngineResource(resource, true, true, engineKey2, engine);
                            }
                            if (engineResource2 != null) {
                                engineResource2.b();
                                engine.f15946g.a(engineKey2, engineResource2);
                            }
                            if (engineResource2 != null) {
                                if (f15939h) {
                                    c("Loaded resource from cache", j2, engineKey2);
                                }
                                return engineResource2;
                            }
                        } catch (Throwable th7) {
                            th2 = th7;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        }
        return null;
    }

    public final synchronized void d(EngineJob engineJob, Key key, EngineResource engineResource) {
        if (engineResource != null) {
            try {
                if (engineResource.f15993a) {
                    this.f15946g.a(key, engineResource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Jobs jobs = this.f15940a;
        jobs.getClass();
        engineJob.getClass();
        HashMap map = jobs.f16008a;
        if (engineJob.equals(map.get(key))) {
            map.remove(key);
        }
    }

    public final void e(Key key, EngineResource engineResource) {
        ActiveResources activeResources = this.f15946g;
        synchronized (activeResources) {
            ActiveResources.ResourceWeakReference resourceWeakReference = (ActiveResources.ResourceWeakReference) activeResources.f15861b.remove(key);
            if (resourceWeakReference != null) {
                resourceWeakReference.f15868c = null;
                resourceWeakReference.clear();
            }
        }
        if (engineResource.f15993a) {
        } else {
            this.f15944e.a(engineResource, false);
        }
    }

    public final void f(Resource resource) {
        this.f15944e.a(resource, true);
    }

    public final LoadStatus h(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, CachedHashCodeArrayMap cachedHashCodeArrayMap, boolean z, boolean z2, Options options, boolean z3, boolean z4, SingleRequest singleRequest, Executor executor, EngineKey engineKey, long j2) {
        EngineJob engineJob = (EngineJob) this.f15940a.f16008a.get(engineKey);
        if (engineJob != null) {
            engineJob.a(singleRequest, executor);
            if (f15939h) {
                c("Added to existing load", j2, engineKey);
            }
            return new LoadStatus(singleRequest, engineJob);
        }
        EngineJob engineJob2 = (EngineJob) this.f15943d.f15957g.b();
        Preconditions.c(engineJob2, "Argument must not be null");
        synchronized (engineJob2) {
            engineJob2.f15974k = engineKey;
            engineJob2.f15975l = z3;
            engineJob2.f15976m = z4;
        }
        DecodeJobFactory decodeJobFactory = this.f15945f;
        DecodeJob decodeJob = (DecodeJob) decodeJobFactory.f15948b.b();
        Preconditions.c(decodeJob, "Argument must not be null");
        int i4 = decodeJobFactory.f15949c;
        decodeJobFactory.f15949c = i4 + 1;
        DecodeHelper decodeHelper = decodeJob.f15896a;
        decodeHelper.f15885c = glideContext;
        decodeHelper.f15886d = obj;
        decodeHelper.n = key;
        decodeHelper.f15887e = i2;
        decodeHelper.f15888f = i3;
        decodeHelper.p = diskCacheStrategy;
        decodeHelper.f15889g = cls;
        decodeHelper.f15890h = decodeJob.f15899d;
        decodeHelper.f15893k = cls2;
        decodeHelper.o = priority;
        decodeHelper.f15891i = options;
        decodeHelper.f15892j = cachedHashCodeArrayMap;
        decodeHelper.q = z;
        decodeHelper.r = z2;
        decodeJob.f15903h = glideContext;
        decodeJob.f15904i = key;
        decodeJob.f15905j = priority;
        decodeJob.f15906k = engineKey;
        decodeJob.f15907l = i2;
        decodeJob.f15908m = i3;
        decodeJob.n = diskCacheStrategy;
        decodeJob.o = options;
        decodeJob.p = engineJob2;
        decodeJob.q = i4;
        decodeJob.s = DecodeJob.RunReason.f15920a;
        decodeJob.u = obj;
        Jobs jobs = this.f15940a;
        jobs.getClass();
        jobs.f16008a.put(engineKey, engineJob2);
        engineJob2.a(singleRequest, executor);
        synchronized (engineJob2) {
            engineJob2.t = decodeJob;
            DecodeJob.Stage stageI = decodeJob.i(DecodeJob.Stage.f15924a);
            ((stageI == DecodeJob.Stage.f15925b || stageI == DecodeJob.Stage.f15926c) ? engineJob2.f15970g : engineJob2.f15976m ? engineJob2.f15972i : engineJob2.f15971h).execute(decodeJob);
        }
        if (f15939h) {
            c("Started new load", j2, engineKey);
        }
        return new LoadStatus(singleRequest, engineJob2);
    }
}
