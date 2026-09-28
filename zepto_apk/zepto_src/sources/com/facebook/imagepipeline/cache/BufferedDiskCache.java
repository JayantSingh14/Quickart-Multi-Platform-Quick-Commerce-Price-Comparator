package com.facebook.imagepipeline.cache;

import androidx.media3.common.util.e;
import androidx.media3.datasource.b;
import androidx.media3.exoplayer.analytics.d;
import androidx.webkit.internal.c;
import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBuffer;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BufferedDiskCache {

    /* renamed from: a, reason: collision with root package name */
    public final FileCache f17730a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f17731b;

    /* renamed from: c, reason: collision with root package name */
    public final PooledByteStreams f17732c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f17733d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f17734e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageCacheStatsTracker f17735f;

    /* renamed from: g, reason: collision with root package name */
    public final StagingArea f17736g;

    @Metadata
    public static final class Companion {
    }

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor readExecutor, Executor writeExecutor, ImageCacheStatsTracker imageCacheStatsTracker) {
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        Intrinsics.checkNotNullParameter(readExecutor, "readExecutor");
        Intrinsics.checkNotNullParameter(writeExecutor, "writeExecutor");
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        this.f17730a = fileCache;
        this.f17731b = pooledByteBufferFactory;
        this.f17732c = pooledByteStreams;
        this.f17733d = readExecutor;
        this.f17734e = writeExecutor;
        this.f17735f = imageCacheStatsTracker;
        StagingArea stagingArea = new StagingArea();
        stagingArea.f17772a = new HashMap();
        Intrinsics.checkNotNullExpressionValue(stagingArea, "getInstance(...)");
        this.f17736g = stagingArea;
    }

    public final void a() {
        this.f17736g.a();
        try {
            Task.a(new c(this, 3), this.f17734e);
        } catch (Exception e2) {
            FLog.u("Failed to schedule disk-cache clear", new Object[0], e2);
            Task.c(e2);
        }
    }

    public final boolean b(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(key, "key");
        StagingArea stagingArea = this.f17736g;
        synchronized (stagingArea) {
            if (stagingArea.f17772a.containsKey(key)) {
                EncodedImage encodedImage = (EncodedImage) stagingArea.f17772a.get(key);
                synchronized (encodedImage) {
                    if (EncodedImage.V(encodedImage)) {
                        return true;
                    }
                    stagingArea.f17772a.remove(key);
                    FLog.p(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), key.a(), Integer.valueOf(System.identityHashCode(key)));
                }
            }
            if (this.f17730a.e(key)) {
                return true;
            }
            EncodedImage encodedImageB = this.f17736g.b(key);
            ImageCacheStatsTracker imageCacheStatsTracker = this.f17735f;
            if (encodedImageB != null) {
                encodedImageB.close();
                FLog.l(BufferedDiskCache.class, "Found image for %s in staging area", key.a());
                imageCacheStatsTracker.getClass();
                return true;
            }
            FLog.l(BufferedDiskCache.class, "Did not find image for %s in staging area", key.a());
            imageCacheStatsTracker.getClass();
            try {
                return this.f17730a.g(key);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public final void c(CacheKey key, EncodedImage encodedImage) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        FrescoSystrace.a();
        Executor executor = this.f17734e;
        if (!EncodedImage.V(encodedImage)) {
            throw new IllegalStateException("Check failed.");
        }
        StagingArea stagingArea = this.f17736g;
        synchronized (stagingArea) {
            key.getClass();
            if (!EncodedImage.V(encodedImage)) {
                throw new IllegalArgumentException();
            }
            EncodedImage.b((EncodedImage) stagingArea.f17772a.put(key, EncodedImage.a(encodedImage)));
            stagingArea.c();
        }
        EncodedImage encodedImageA = EncodedImage.a(encodedImage);
        try {
            executor.execute(new e(this, key, encodedImageA, 13));
        } catch (Exception e2) {
            FLog.u("Failed to schedule disk-cache write for %s", new Object[]{key.a()}, e2);
            stagingArea.e(key, encodedImage);
            EncodedImage.b(encodedImageA);
        }
    }

    public final PooledByteBuffer d(CacheKey cacheKey) throws IOException {
        ImageCacheStatsTracker imageCacheStatsTracker = this.f17735f;
        try {
            FLog.l(BufferedDiskCache.class, "Disk cache read for %s", cacheKey.a());
            BinaryResource binaryResourceC = this.f17730a.c(cacheKey);
            if (binaryResourceC == null) {
                FLog.l(BufferedDiskCache.class, "Disk cache miss for %s", cacheKey.a());
                imageCacheStatsTracker.getClass();
                return null;
            }
            FLog.l(BufferedDiskCache.class, "Found entry in disk cache for %s", cacheKey.a());
            imageCacheStatsTracker.getClass();
            InputStream inputStreamA = binaryResourceC.a();
            try {
                MemoryPooledByteBuffer memoryPooledByteBufferB = this.f17731b.b(inputStreamA, (int) binaryResourceC.size());
                inputStreamA.close();
                FLog.l(BufferedDiskCache.class, "Successful read from disk cache for %s", cacheKey.a());
                return memoryPooledByteBufferB;
            } catch (Throwable th) {
                inputStreamA.close();
                throw th;
            }
        } catch (IOException e2) {
            FLog.u("Exception reading from cache for %s", new Object[]{cacheKey.a()}, e2);
            imageCacheStatsTracker.getClass();
            throw e2;
        }
    }

    public final void e(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f17736g.d(key);
        try {
            Task.a(new b(4, this, key), this.f17734e);
        } catch (Exception e2) {
            FLog.u("Failed to schedule disk-cache remove for %s", new Object[]{key.a()}, e2);
            Task.c(e2);
        }
    }

    public final void f(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.l(BufferedDiskCache.class, "About to write to disk-cache for key %s", cacheKey.a());
        try {
            this.f17730a.d(cacheKey, new d(10, encodedImage, this));
            this.f17735f.getClass();
            FLog.l(BufferedDiskCache.class, "Successful disk-cache write for key %s", cacheKey.a());
        } catch (IOException e2) {
            FLog.u("Failed to write to disk-cache for key %s", new Object[]{cacheKey.a()}, e2);
        }
    }
}
