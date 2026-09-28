package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.TreeSet;

@UnstableApi
/* loaded from: classes3.dex */
public final class CacheDataSink implements DataSink {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleCache f5951a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5952b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5953c;

    /* renamed from: d, reason: collision with root package name */
    public DataSpec f5954d;

    /* renamed from: e, reason: collision with root package name */
    public long f5955e;

    /* renamed from: f, reason: collision with root package name */
    public File f5956f;

    /* renamed from: g, reason: collision with root package name */
    public OutputStream f5957g;

    /* renamed from: h, reason: collision with root package name */
    public long f5958h;

    /* renamed from: i, reason: collision with root package name */
    public long f5959i;

    /* renamed from: j, reason: collision with root package name */
    public ReusableBufferedOutputStream f5960j;

    public static final class CacheDataSinkException extends Cache.CacheException {
    }

    public static final class Factory implements DataSink.Factory {
    }

    public CacheDataSink(SimpleCache simpleCache) {
        simpleCache.getClass();
        this.f5951a = simpleCache;
        this.f5952b = 5242880L;
        this.f5953c = 20480;
    }

    public final void a() throws CacheDataSinkException {
        if (this.f5954d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f5957g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            Util.h(this.f5957g);
            this.f5957g = null;
            File file = this.f5956f;
            this.f5956f = null;
            SimpleCache simpleCache = this.f5951a;
            long j2 = this.f5958h;
            synchronized (simpleCache) {
                if (file.exists()) {
                    if (j2 == 0) {
                        file.delete();
                        return;
                    }
                    SimpleCacheSpan simpleCacheSpanB = SimpleCacheSpan.b(file, j2, -9223372036854775807L, simpleCache.f6028c);
                    simpleCacheSpanB.getClass();
                    CachedContent cachedContentC = simpleCache.f6028c.c(simpleCacheSpanB.f5983a);
                    cachedContentC.getClass();
                    Assertions.g(cachedContentC.c(simpleCacheSpanB.f5984b, simpleCacheSpanB.f5985c));
                    long jB = cachedContentC.f5997e.b();
                    if (jB != -1) {
                        Assertions.g(simpleCacheSpanB.f5984b + simpleCacheSpanB.f5985c <= jB);
                    }
                    if (simpleCache.f6029d == null) {
                        simpleCache.b(simpleCacheSpanB);
                        simpleCache.f6028c.g();
                        simpleCache.notifyAll();
                        return;
                    }
                    try {
                        simpleCache.f6029d.d(simpleCacheSpanB.f5985c, simpleCacheSpanB.f5988f, file.getName());
                        simpleCache.b(simpleCacheSpanB);
                        try {
                            simpleCache.f6028c.g();
                            simpleCache.notifyAll();
                            return;
                        } catch (IOException e2) {
                            throw new Cache.CacheException(e2);
                        }
                    } catch (IOException e3) {
                        throw new Cache.CacheException(e3);
                    }
                }
            }
        } catch (Throwable th) {
            Util.h(this.f5957g);
            this.f5957g = null;
            File file2 = this.f5956f;
            this.f5956f = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(DataSpec dataSpec) {
        File fileC;
        long j2 = dataSpec.f5857g;
        long jMin = j2 == -1 ? -1L : Math.min(j2 - this.f5959i, this.f5955e);
        int i2 = Util.f5744a;
        long j3 = dataSpec.f5856f + this.f5959i;
        SimpleCache simpleCache = this.f5951a;
        String str = dataSpec.f5858h;
        synchronized (simpleCache) {
            try {
                simpleCache.d();
                CachedContent cachedContentC = simpleCache.f6028c.c(str);
                cachedContentC.getClass();
                Assertions.g(cachedContentC.c(j3, jMin));
                if (!simpleCache.f6026a.exists()) {
                    SimpleCache.e(simpleCache.f6026a);
                    simpleCache.l();
                }
                LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor = simpleCache.f6027b;
                if (jMin != -1) {
                    while (leastRecentlyUsedCacheEvictor.f6023c + jMin > leastRecentlyUsedCacheEvictor.f6021a) {
                        TreeSet treeSet = leastRecentlyUsedCacheEvictor.f6022b;
                        if (treeSet.isEmpty()) {
                            break;
                        }
                        CacheSpan cacheSpan = (CacheSpan) treeSet.first();
                        synchronized (simpleCache) {
                            simpleCache.k(cacheSpan);
                        }
                    }
                } else {
                    leastRecentlyUsedCacheEvictor.getClass();
                }
                File file = new File(simpleCache.f6026a, Integer.toString(simpleCache.f6031f.nextInt(10)));
                if (!file.exists()) {
                    SimpleCache.e(file);
                }
                fileC = SimpleCacheSpan.c(file, cachedContentC.f5993a, j3, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5956f = fileC;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f5956f);
        int i3 = this.f5953c;
        if (i3 > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.f5960j;
            if (reusableBufferedOutputStream == null) {
                this.f5960j = new ReusableBufferedOutputStream(fileOutputStream, i3);
            } else {
                reusableBufferedOutputStream.a(fileOutputStream);
            }
            this.f5957g = this.f5960j;
        } else {
            this.f5957g = fileOutputStream;
        }
        this.f5958h = 0L;
    }
}
