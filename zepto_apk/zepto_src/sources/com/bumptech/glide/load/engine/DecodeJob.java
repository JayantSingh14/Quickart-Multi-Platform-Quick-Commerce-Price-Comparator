package com.bumptech.glide.load.engine;

import android.os.Build;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public DataFetcher A;
    public volatile DataFetcherGenerator B;
    public volatile boolean C;
    public volatile boolean D;

    /* renamed from: d, reason: collision with root package name */
    public final Engine.LazyDiskCacheProvider f15899d;

    /* renamed from: e, reason: collision with root package name */
    public final Pools.Pool f15900e;

    /* renamed from: h, reason: collision with root package name */
    public GlideContext f15903h;

    /* renamed from: i, reason: collision with root package name */
    public Key f15904i;

    /* renamed from: j, reason: collision with root package name */
    public Priority f15905j;

    /* renamed from: k, reason: collision with root package name */
    public EngineKey f15906k;

    /* renamed from: l, reason: collision with root package name */
    public int f15907l;

    /* renamed from: m, reason: collision with root package name */
    public int f15908m;
    public DiskCacheStrategy n;
    public Options o;
    public EngineJob p;
    public int q;
    public Stage r;
    public RunReason s;
    public long t;
    public Object u;
    public Thread v;
    public Key w;
    public Key x;
    public Object y;
    public DataSource z;

    /* renamed from: a, reason: collision with root package name */
    public final DecodeHelper f15896a = new DecodeHelper();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f15897b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final StateVerifier f15898c = StateVerifier.a();

    /* renamed from: f, reason: collision with root package name */
    public final DeferredEncodeManager f15901f = new DeferredEncodeManager();

    /* renamed from: g, reason: collision with root package name */
    public final ReleaseManager f15902g = new ReleaseManager();

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15909a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15910b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f15911c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f15911c = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15911c[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f15910b = iArr2;
            try {
                iArr2[1] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15910b[2] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15910b[3] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15910b[5] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15910b[0] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f15909a = iArr3;
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15909a[1] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15909a[2] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface Callback<R> {
    }

    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* renamed from: a, reason: collision with root package name */
        public final DataSource f15912a;

        public DecodeCallback(DataSource dataSource) {
            this.f15912a = dataSource;
        }

        public final Resource a(Resource resource) {
            Resource resourceA;
            Transformation transformation;
            EncodeStrategy encodeStrategyB;
            boolean z;
            Key dataCacheKey;
            DecodeJob decodeJob = DecodeJob.this;
            decodeJob.getClass();
            Class<?> cls = resource.get().getClass();
            DataSource dataSource = DataSource.f15791d;
            DataSource dataSource2 = this.f15912a;
            DecodeHelper decodeHelper = decodeJob.f15896a;
            ResourceEncoder resourceEncoderB = null;
            if (dataSource2 != dataSource) {
                Transformation transformationE = decodeHelper.e(cls);
                transformation = transformationE;
                resourceA = transformationE.a(decodeJob.f15903h, resource, decodeJob.f15907l, decodeJob.f15908m);
            } else {
                resourceA = resource;
                transformation = null;
            }
            if (!resource.equals(resourceA)) {
                resource.recycle();
            }
            if (decodeHelper.f15885c.f15672b.f15691d.b(resourceA.a()) != null) {
                Registry registry = decodeHelper.f15885c.f15672b;
                registry.getClass();
                resourceEncoderB = registry.f15691d.b(resourceA.a());
                if (resourceEncoderB == null) {
                    throw new Registry.NoResultEncoderAvailableException(resourceA.a());
                }
                encodeStrategyB = resourceEncoderB.b(decodeJob.o);
            } else {
                encodeStrategyB = EncodeStrategy.f15800c;
            }
            ResourceEncoder resourceEncoder = resourceEncoderB;
            Key key = decodeJob.w;
            ArrayList arrayListB = decodeHelper.b();
            int size = arrayListB.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (((ModelLoader.LoadData) arrayListB.get(i2)).f16167a.equals(key)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!decodeJob.n.d(!z, dataSource2, encodeStrategyB)) {
                return resourceA;
            }
            if (resourceEncoder == null) {
                throw new Registry.NoResultEncoderAvailableException(resourceA.get().getClass());
            }
            int iOrdinal = encodeStrategyB.ordinal();
            if (iOrdinal == 0) {
                dataCacheKey = new DataCacheKey(decodeJob.w, decodeJob.f15904i);
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyB);
                }
                dataCacheKey = new ResourceCacheKey(decodeHelper.f15885c.f15671a, decodeJob.w, decodeJob.f15904i, decodeJob.f15907l, decodeJob.f15908m, transformation, cls, decodeJob.o);
            }
            LockedResource lockedResource = (LockedResource) LockedResource.f16012e.b();
            Preconditions.c(lockedResource, "Argument must not be null");
            lockedResource.f16016d = false;
            lockedResource.f16015c = true;
            lockedResource.f16014b = resourceA;
            DeferredEncodeManager deferredEncodeManager = decodeJob.f15901f;
            deferredEncodeManager.f15914a = dataCacheKey;
            deferredEncodeManager.f15915b = resourceEncoder;
            deferredEncodeManager.f15916c = lockedResource;
            return lockedResource;
        }
    }

    public static class DeferredEncodeManager<Z> {

        /* renamed from: a, reason: collision with root package name */
        public Key f15914a;

        /* renamed from: b, reason: collision with root package name */
        public ResourceEncoder f15915b;

        /* renamed from: c, reason: collision with root package name */
        public LockedResource f15916c;
    }

    public interface DiskCacheProvider {
    }

    public static class ReleaseManager {

        /* renamed from: a, reason: collision with root package name */
        public boolean f15917a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f15918b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15919c;

        public final boolean a() {
            return (this.f15919c || this.f15918b) && this.f15917a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RunReason {

        /* renamed from: a, reason: collision with root package name */
        public static final RunReason f15920a;

        /* renamed from: b, reason: collision with root package name */
        public static final RunReason f15921b;

        /* renamed from: c, reason: collision with root package name */
        public static final RunReason f15922c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ RunReason[] f15923d;

        static {
            RunReason runReason = new RunReason("INITIALIZE", 0);
            f15920a = runReason;
            RunReason runReason2 = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            f15921b = runReason2;
            RunReason runReason3 = new RunReason("DECODE_DATA", 2);
            f15922c = runReason3;
            f15923d = new RunReason[]{runReason, runReason2, runReason3};
        }

        public static RunReason valueOf(String str) {
            return (RunReason) Enum.valueOf(RunReason.class, str);
        }

        public static RunReason[] values() {
            return (RunReason[]) f15923d.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Stage {

        /* renamed from: a, reason: collision with root package name */
        public static final Stage f15924a;

        /* renamed from: b, reason: collision with root package name */
        public static final Stage f15925b;

        /* renamed from: c, reason: collision with root package name */
        public static final Stage f15926c;

        /* renamed from: d, reason: collision with root package name */
        public static final Stage f15927d;

        /* renamed from: e, reason: collision with root package name */
        public static final Stage f15928e;

        /* renamed from: f, reason: collision with root package name */
        public static final Stage f15929f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ Stage[] f15930g;

        static {
            Stage stage = new Stage("INITIALIZE", 0);
            f15924a = stage;
            Stage stage2 = new Stage("RESOURCE_CACHE", 1);
            f15925b = stage2;
            Stage stage3 = new Stage("DATA_CACHE", 2);
            f15926c = stage3;
            Stage stage4 = new Stage("SOURCE", 3);
            f15927d = stage4;
            Stage stage5 = new Stage("ENCODE", 4);
            f15928e = stage5;
            Stage stage6 = new Stage("FINISHED", 5);
            f15929f = stage6;
            f15930g = new Stage[]{stage, stage2, stage3, stage4, stage5, stage6};
        }

        public static Stage valueOf(String str) {
            return (Stage) Enum.valueOf(Stage.class, str);
        }

        public static Stage[] values() {
            return (Stage[]) f15930g.clone();
        }
    }

    public DecodeJob(Engine.LazyDiskCacheProvider lazyDiskCacheProvider, Pools.Pool pool) {
        this.f15899d = lazyDiskCacheProvider;
        this.f15900e = pool;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void a(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", Collections.singletonList(exc));
        Class clsA = dataFetcher.a();
        glideException.f16002b = key;
        glideException.f16003c = dataSource;
        glideException.f16004d = clsA;
        this.f15897b.add(glideException);
        if (Thread.currentThread() == this.v) {
            r();
        } else {
            this.s = RunReason.f15921b;
            this.p.h(this);
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier b() {
        return this.f15898c;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void c(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.w = key;
        this.y = obj;
        this.A = dataFetcher;
        this.z = dataSource;
        this.x = key2;
        if (Thread.currentThread() == this.v) {
            g();
        } else {
            this.s = RunReason.f15922c;
            this.p.h(this);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(DecodeJob<?> decodeJob) {
        DecodeJob<?> decodeJob2 = decodeJob;
        int iOrdinal = this.f15905j.ordinal() - decodeJob2.f15905j.ordinal();
        return iOrdinal == 0 ? this.q - decodeJob2.q : iOrdinal;
    }

    public final Resource d(DataFetcher dataFetcher, Object obj, DataSource dataSource) {
        if (obj == null) {
            return null;
        }
        try {
            int i2 = LogTime.f16520b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Resource resourceE = e(obj, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                l(jElapsedRealtimeNanos, "Decoded result " + resourceE, null);
            }
            return resourceE;
        } finally {
            dataFetcher.b();
        }
    }

    public final Resource e(Object obj, DataSource dataSource) {
        DataRewinder dataRewinderB;
        LoadPath loadPathC = this.f15896a.c(obj.getClass());
        Options options = this.o;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = dataSource == DataSource.f15791d || this.f15896a.r;
            Option option = Downsampler.f16278i;
            Boolean bool = (Boolean) options.c(option);
            if (bool == null || (bool.booleanValue() && !z)) {
                options = new Options();
                options.f15817b.g(this.o.f15817b);
                options.f15817b.put(option, Boolean.valueOf(z));
            }
        }
        Options options2 = options;
        DataRewinderRegistry dataRewinderRegistry = this.f15903h.f15672b.f15692e;
        synchronized (dataRewinderRegistry) {
            try {
                DataRewinder.Factory factory = (DataRewinder.Factory) dataRewinderRegistry.f15829a.get(obj.getClass());
                if (factory == null) {
                    Iterator it = dataRewinderRegistry.f15829a.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DataRewinder.Factory factory2 = (DataRewinder.Factory) it.next();
                        if (factory2.a().isAssignableFrom(obj.getClass())) {
                            factory = factory2;
                            break;
                        }
                    }
                }
                if (factory == null) {
                    factory = DataRewinderRegistry.f15828b;
                }
                dataRewinderB = factory.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            int i2 = this.f15907l;
            int i3 = this.f15908m;
            DecodeCallback decodeCallback = new DecodeCallback(dataSource);
            Pools.Pool pool = loadPathC.f16009a;
            Object objB = pool.b();
            Preconditions.c(objB, "Argument must not be null");
            List list = (List) objB;
            try {
                Resource resourceA = loadPathC.a(dataRewinderB, options2, i2, i3, decodeCallback, list);
                pool.a(list);
                return resourceA;
            } catch (Throwable th2) {
                pool.a(list);
                throw th2;
            }
        } finally {
            dataRewinderB.b();
        }
    }

    public final void g() {
        Resource resourceD;
        boolean zA;
        if (Log.isLoggable("DecodeJob", 2)) {
            l(this.t, "Retrieved data", "data: " + this.y + ", cache key: " + this.w + ", fetcher: " + this.A);
        }
        LockedResource lockedResource = null;
        try {
            resourceD = d(this.A, this.y, this.z);
        } catch (GlideException e2) {
            Key key = this.x;
            DataSource dataSource = this.z;
            e2.f16002b = key;
            e2.f16003c = dataSource;
            e2.f16004d = null;
            this.f15897b.add(e2);
            resourceD = null;
        }
        if (resourceD == null) {
            r();
            return;
        }
        DataSource dataSource2 = this.z;
        if (resourceD instanceof Initializable) {
            ((Initializable) resourceD).initialize();
        }
        if (this.f15901f.f15916c != null) {
            lockedResource = (LockedResource) LockedResource.f16012e.b();
            Preconditions.c(lockedResource, "Argument must not be null");
            lockedResource.f16016d = false;
            lockedResource.f16015c = true;
            lockedResource.f16014b = resourceD;
            resourceD = lockedResource;
        }
        t();
        EngineJob engineJob = this.p;
        synchronized (engineJob) {
            engineJob.n = resourceD;
            engineJob.o = dataSource2;
        }
        synchronized (engineJob) {
            try {
                engineJob.f15965b.b();
                if (engineJob.u) {
                    engineJob.n.recycle();
                    engineJob.f();
                } else {
                    if (engineJob.f15964a.f15983a.isEmpty()) {
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    if (engineJob.p) {
                        throw new IllegalStateException("Already have resource");
                    }
                    EngineJob.EngineResourceFactory engineResourceFactory = engineJob.f15968e;
                    Resource resource = engineJob.n;
                    boolean z = engineJob.f15975l;
                    Key key2 = engineJob.f15974k;
                    Engine engine = engineJob.f15966c;
                    engineResourceFactory.getClass();
                    engineJob.s = new EngineResource(resource, z, true, key2, engine);
                    engineJob.p = true;
                    EngineJob.ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = engineJob.f15964a;
                    resourceCallbacksAndExecutors.getClass();
                    ArrayList arrayList = new ArrayList(resourceCallbacksAndExecutors.f15983a);
                    engineJob.d(arrayList.size() + 1);
                    engineJob.f15969f.d(engineJob, engineJob.f15974k, engineJob.s);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        EngineJob.ResourceCallbackAndExecutor resourceCallbackAndExecutor = (EngineJob.ResourceCallbackAndExecutor) it.next();
                        resourceCallbackAndExecutor.f15982b.execute(new EngineJob.CallResourceReady(resourceCallbackAndExecutor.f15981a));
                    }
                    engineJob.c();
                }
            } finally {
            }
        }
        this.r = Stage.f15928e;
        try {
            DeferredEncodeManager deferredEncodeManager = this.f15901f;
            if (deferredEncodeManager.f15916c != null) {
                Engine.LazyDiskCacheProvider lazyDiskCacheProvider = this.f15899d;
                Options options = this.o;
                deferredEncodeManager.getClass();
                try {
                    lazyDiskCacheProvider.a().a(deferredEncodeManager.f15914a, new DataCacheWriter(deferredEncodeManager.f15915b, deferredEncodeManager.f15916c, options));
                    deferredEncodeManager.f15916c.c();
                } catch (Throwable th) {
                    deferredEncodeManager.f15916c.c();
                    throw th;
                }
            }
            ReleaseManager releaseManager = this.f15902g;
            synchronized (releaseManager) {
                releaseManager.f15918b = true;
                zA = releaseManager.a();
            }
            if (zA) {
                p();
            }
        } finally {
            if (lockedResource != null) {
                lockedResource.c();
            }
        }
    }

    public final DataFetcherGenerator h() {
        int iOrdinal = this.r.ordinal();
        DecodeHelper decodeHelper = this.f15896a;
        if (iOrdinal == 1) {
            return new ResourceCacheGenerator(decodeHelper, this);
        }
        if (iOrdinal == 2) {
            return new DataCacheGenerator(decodeHelper.a(), decodeHelper, this);
        }
        if (iOrdinal == 3) {
            return new SourceGenerator(decodeHelper, this);
        }
        if (iOrdinal == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    public final Stage i(Stage stage) {
        int iOrdinal = stage.ordinal();
        if (iOrdinal == 0) {
            boolean zB = this.n.b();
            Stage stage2 = Stage.f15925b;
            return zB ? stage2 : i(stage2);
        }
        if (iOrdinal == 1) {
            boolean zA = this.n.a();
            Stage stage3 = Stage.f15926c;
            return zA ? stage3 : i(stage3);
        }
        Stage stage4 = Stage.f15929f;
        if (iOrdinal == 2) {
            return Stage.f15927d;
        }
        if (iOrdinal == 3 || iOrdinal == 5) {
            return stage4;
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    public final void l(long j2, String str, String str2) {
        StringBuilder sbX = b.x(str, " in ");
        sbX.append(LogTime.a(j2));
        sbX.append(", load key: ");
        sbX.append(this.f15906k);
        sbX.append(str2 != null ? ", ".concat(str2) : "");
        sbX.append(", thread: ");
        sbX.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sbX.toString());
    }

    public final void n() {
        boolean zA;
        t();
        GlideException glideException = new GlideException("Failed to load resource", new ArrayList(this.f15897b));
        EngineJob engineJob = this.p;
        synchronized (engineJob) {
            engineJob.q = glideException;
        }
        synchronized (engineJob) {
            try {
                engineJob.f15965b.b();
                if (engineJob.u) {
                    engineJob.f();
                } else {
                    if (engineJob.f15964a.f15983a.isEmpty()) {
                        throw new IllegalStateException("Received an exception without any callbacks to notify");
                    }
                    if (engineJob.r) {
                        throw new IllegalStateException("Already failed once");
                    }
                    engineJob.r = true;
                    Key key = engineJob.f15974k;
                    EngineJob.ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = engineJob.f15964a;
                    resourceCallbacksAndExecutors.getClass();
                    ArrayList arrayList = new ArrayList(resourceCallbacksAndExecutors.f15983a);
                    engineJob.d(arrayList.size() + 1);
                    engineJob.f15969f.d(engineJob, key, null);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        EngineJob.ResourceCallbackAndExecutor resourceCallbackAndExecutor = (EngineJob.ResourceCallbackAndExecutor) it.next();
                        resourceCallbackAndExecutor.f15982b.execute(new EngineJob.CallLoadFailed(resourceCallbackAndExecutor.f15981a));
                    }
                    engineJob.c();
                }
            } finally {
            }
        }
        ReleaseManager releaseManager = this.f15902g;
        synchronized (releaseManager) {
            releaseManager.f15919c = true;
            zA = releaseManager.a();
        }
        if (zA) {
            p();
        }
    }

    public final void p() {
        ReleaseManager releaseManager = this.f15902g;
        synchronized (releaseManager) {
            releaseManager.f15918b = false;
            releaseManager.f15917a = false;
            releaseManager.f15919c = false;
        }
        DeferredEncodeManager deferredEncodeManager = this.f15901f;
        deferredEncodeManager.f15914a = null;
        deferredEncodeManager.f15915b = null;
        deferredEncodeManager.f15916c = null;
        DecodeHelper decodeHelper = this.f15896a;
        decodeHelper.f15885c = null;
        decodeHelper.f15886d = null;
        decodeHelper.n = null;
        decodeHelper.f15889g = null;
        decodeHelper.f15893k = null;
        decodeHelper.f15891i = null;
        decodeHelper.o = null;
        decodeHelper.f15892j = null;
        decodeHelper.p = null;
        decodeHelper.f15883a.clear();
        decodeHelper.f15894l = false;
        decodeHelper.f15884b.clear();
        decodeHelper.f15895m = false;
        this.C = false;
        this.f15903h = null;
        this.f15904i = null;
        this.o = null;
        this.f15905j = null;
        this.f15906k = null;
        this.p = null;
        this.r = null;
        this.B = null;
        this.v = null;
        this.w = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.t = 0L;
        this.D = false;
        this.u = null;
        this.f15897b.clear();
        this.f15900e.a(this);
    }

    public final void q() {
        this.s = RunReason.f15921b;
        this.p.h(this);
    }

    public final void r() {
        this.v = Thread.currentThread();
        int i2 = LogTime.f16520b;
        this.t = SystemClock.elapsedRealtimeNanos();
        boolean zB = false;
        while (!this.D && this.B != null && !(zB = this.B.b())) {
            this.r = i(this.r);
            this.B = h();
            if (this.r == Stage.f15927d) {
                q();
                return;
            }
        }
        if ((this.r == Stage.f15929f || this.D) && !zB) {
            n();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataFetcher dataFetcher = this.A;
        try {
            try {
                try {
                    if (this.D) {
                        n();
                        if (dataFetcher != null) {
                            dataFetcher.b();
                            return;
                        }
                        return;
                    }
                    s();
                    if (dataFetcher != null) {
                        dataFetcher.b();
                    }
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.D + ", stage: " + this.r, th);
                    }
                    if (this.r != Stage.f15928e) {
                        this.f15897b.add(th);
                        n();
                    }
                    if (!this.D) {
                        throw th;
                    }
                    throw th;
                }
            } catch (CallbackException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            throw th2;
        }
    }

    public final void s() {
        int iOrdinal = this.s.ordinal();
        if (iOrdinal == 0) {
            this.r = i(Stage.f15924a);
            this.B = h();
            r();
        } else if (iOrdinal == 1) {
            r();
        } else if (iOrdinal == 2) {
            g();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    public final void t() {
        this.f15898c.b();
        if (this.C) {
            throw new IllegalStateException("Already notified", this.f15897b.isEmpty() ? null : (Throwable) b.c(1, this.f15897b));
        }
        this.C = true;
    }
}
