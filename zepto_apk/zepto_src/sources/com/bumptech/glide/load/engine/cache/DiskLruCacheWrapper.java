package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: b, reason: collision with root package name */
    public final File f16094b;

    /* renamed from: e, reason: collision with root package name */
    public DiskLruCache f16097e;

    /* renamed from: d, reason: collision with root package name */
    public final DiskCacheWriteLocker f16096d = new DiskCacheWriteLocker();

    /* renamed from: c, reason: collision with root package name */
    public final long f16095c = 262144000;

    /* renamed from: a, reason: collision with root package name */
    public final SafeKeyGenerator f16093a = new SafeKeyGenerator();

    public DiskLruCacheWrapper(File file) {
        this.f16094b = file;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void a(Key key, DiskCache.Writer writer) {
        DiskCacheWriteLocker.WriteLock writeLock;
        DiskLruCache diskLruCacheC;
        boolean z;
        String strA = this.f16093a.a(key);
        DiskCacheWriteLocker diskCacheWriteLocker = this.f16096d;
        synchronized (diskCacheWriteLocker) {
            writeLock = (DiskCacheWriteLocker.WriteLock) diskCacheWriteLocker.f16087a.get(strA);
            if (writeLock == null) {
                DiskCacheWriteLocker.WriteLockPool writeLockPool = diskCacheWriteLocker.f16088b;
                synchronized (writeLockPool.f16091a) {
                    writeLock = (DiskCacheWriteLocker.WriteLock) writeLockPool.f16091a.poll();
                }
                if (writeLock == null) {
                    writeLock = new DiskCacheWriteLocker.WriteLock();
                }
                diskCacheWriteLocker.f16087a.put(strA, writeLock);
            }
            writeLock.f16090b++;
        }
        writeLock.f16089a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strA + " for for Key: " + key);
            }
            try {
                diskLruCacheC = c();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (diskLruCacheC.r(strA) != null) {
                return;
            }
            DiskLruCache.Editor editorE = diskLruCacheC.e(strA);
            if (editorE == null) {
                throw new IllegalStateException("Had two simultaneous puts for: ".concat(strA));
            }
            try {
                if (writer.a(editorE.b())) {
                    DiskLruCache.a(DiskLruCache.this, editorE, true);
                    editorE.f15732c = true;
                }
                if (!z) {
                    try {
                        editorE.a();
                    } catch (IOException unused) {
                    }
                }
            } finally {
                if (!editorE.f15732c) {
                    try {
                        editorE.a();
                    } catch (IOException unused2) {
                    }
                }
            }
        } finally {
            this.f16096d.a(strA);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File b(Key key) {
        String strA = this.f16093a.a(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strA + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value valueR = c().r(strA);
            if (valueR != null) {
                return valueR.f15741a[0];
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    public final synchronized DiskLruCache c() {
        try {
            if (this.f16097e == null) {
                this.f16097e = DiskLruCache.x(this.f16094b, this.f16095c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f16097e;
    }
}
