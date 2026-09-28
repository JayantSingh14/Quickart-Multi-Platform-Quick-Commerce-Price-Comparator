package com.facebook.cache.disk;

import android.os.StatFs;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.analytics.d;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.SystemClock;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final long n = TimeUnit.HOURS.toMillis(2);
    public static final long o = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final long f17032a;

    /* renamed from: b, reason: collision with root package name */
    public final long f17033b;

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f17034c;

    /* renamed from: d, reason: collision with root package name */
    public long f17035d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f17036e;

    /* renamed from: f, reason: collision with root package name */
    public long f17037f;

    /* renamed from: g, reason: collision with root package name */
    public final StatFsHelper f17038g;

    /* renamed from: h, reason: collision with root package name */
    public final DiskStorage f17039h;

    /* renamed from: i, reason: collision with root package name */
    public final DefaultEntryEvictionComparatorSupplier f17040i;

    /* renamed from: j, reason: collision with root package name */
    public final NoOpCacheErrorLogger f17041j;

    /* renamed from: k, reason: collision with root package name */
    public final CacheStats f17042k;

    /* renamed from: l, reason: collision with root package name */
    public final SystemClock f17043l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f17044m = new Object();

    /* renamed from: com.facebook.cache.disk.DiskStorageCache$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @VisibleForTesting
    public static class CacheStats {

        /* renamed from: a, reason: collision with root package name */
        public boolean f17045a;

        /* renamed from: b, reason: collision with root package name */
        public long f17046b;

        /* renamed from: c, reason: collision with root package name */
        public long f17047c;

        public final synchronized long a() {
            return this.f17046b;
        }

        public final synchronized void b(long j2, long j3) {
            if (this.f17045a) {
                this.f17046b += j2;
                this.f17047c += j3;
            }
        }
    }

    public static class Params {

        /* renamed from: a, reason: collision with root package name */
        public final long f17048a;

        /* renamed from: b, reason: collision with root package name */
        public final long f17049b;

        public Params(long j2, long j3, long j4) {
            this.f17048a = j3;
            this.f17049b = j4;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier, Params params, NoOpCacheEventListener noOpCacheEventListener, NoOpCacheErrorLogger noOpCacheErrorLogger, NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry, ExecutorService executorService) {
        StatFsHelper statFsHelper;
        this.f17032a = params.f17048a;
        long j2 = params.f17049b;
        this.f17033b = j2;
        this.f17035d = j2;
        StatFsHelper statFsHelper2 = StatFsHelper.f17120h;
        synchronized (StatFsHelper.class) {
            try {
                if (StatFsHelper.f17120h == null) {
                    StatFsHelper.f17120h = new StatFsHelper();
                }
                statFsHelper = StatFsHelper.f17120h;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f17038g = statFsHelper;
        this.f17039h = diskStorage;
        this.f17040i = defaultEntryEvictionComparatorSupplier;
        this.f17037f = -1L;
        this.f17041j = noOpCacheErrorLogger;
        CacheStats cacheStats = new CacheStats();
        cacheStats.f17045a = false;
        cacheStats.f17046b = -1L;
        cacheStats.f17047c = -1L;
        this.f17042k = cacheStats;
        this.f17043l = SystemClock.f17138a;
        this.f17036e = new HashSet();
        this.f17034c = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.FileCache
    public final void a() {
        synchronized (this.f17044m) {
            try {
                this.f17039h.a();
                this.f17036e.clear();
            } catch (IOException | NullPointerException e2) {
                NoOpCacheErrorLogger noOpCacheErrorLogger = this.f17041j;
                e2.getMessage();
                noOpCacheErrorLogger.getClass();
            }
            CacheStats cacheStats = this.f17042k;
            synchronized (cacheStats) {
                cacheStats.f17045a = false;
                cacheStats.f17047c = -1L;
                cacheStats.f17046b = -1L;
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final boolean b(CacheKey cacheKey) {
        try {
            synchronized (this.f17044m) {
                try {
                    ArrayList arrayListB = CacheKeyUtil.b(cacheKey);
                    for (int i2 = 0; i2 < arrayListB.size(); i2++) {
                        String str = (String) arrayListB.get(i2);
                        if (this.f17039h.d(str, cacheKey)) {
                            this.f17036e.add(str);
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IOException unused) {
            SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
            settableCacheEventA.f17060a = cacheKey;
            settableCacheEventA.b();
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final BinaryResource c(CacheKey cacheKey) {
        BinaryResource binaryResourceF;
        SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
        settableCacheEventA.f17060a = cacheKey;
        try {
            synchronized (this.f17044m) {
                try {
                    ArrayList arrayListB = CacheKeyUtil.b(cacheKey);
                    String str = null;
                    binaryResourceF = null;
                    for (int i2 = 0; i2 < arrayListB.size() && (binaryResourceF = this.f17039h.f((str = (String) arrayListB.get(i2)), cacheKey)) == null; i2++) {
                    }
                    if (binaryResourceF == null) {
                        this.f17036e.remove(str);
                    } else {
                        str.getClass();
                        this.f17036e.add(str);
                    }
                } finally {
                }
            }
            return binaryResourceF;
        } catch (IOException unused) {
            this.f17041j.getClass();
            return null;
        } finally {
            settableCacheEventA.b();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final BinaryResource d(CacheKey cacheKey, d dVar) {
        String strA;
        FileBinaryResource fileBinaryResourceCommit;
        SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
        settableCacheEventA.f17060a = cacheKey;
        synchronized (this.f17044m) {
            strA = CacheKeyUtil.a(cacheKey);
            try {
            } finally {
                settableCacheEventA.b();
            }
        }
        try {
            DiskStorage.Inserter inserterK = k(strA, cacheKey);
            try {
                inserterK.a(dVar);
                synchronized (this.f17044m) {
                    fileBinaryResourceCommit = inserterK.commit();
                    this.f17036e.add(strA);
                    this.f17042k.b(fileBinaryResourceCommit.f16987a.length(), 1L);
                }
                fileBinaryResourceCommit.size();
                this.f17042k.a();
                return fileBinaryResourceCommit;
            } finally {
                if (!inserterK.f()) {
                    FLog.e(DiskStorageCache.class, "Failed to delete temp file");
                }
            }
        } catch (IOException e2) {
            FLog.f(DiskStorageCache.class, "Failed inserting a file into the cache", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final boolean e(CacheKey cacheKey) {
        synchronized (this.f17044m) {
            try {
                ArrayList arrayListB = CacheKeyUtil.b(cacheKey);
                for (int i2 = 0; i2 < arrayListB.size(); i2++) {
                    if (this.f17036e.contains((String) arrayListB.get(i2))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final void f(CacheKey cacheKey) {
        synchronized (this.f17044m) {
            try {
                ArrayList arrayListB = CacheKeyUtil.b(cacheKey);
                for (int i2 = 0; i2 < arrayListB.size(); i2++) {
                    String str = (String) arrayListB.get(i2);
                    this.f17039h.remove(str);
                    this.f17036e.remove(str);
                }
            } catch (IOException e2) {
                NoOpCacheErrorLogger noOpCacheErrorLogger = this.f17041j;
                e2.getMessage();
                noOpCacheErrorLogger.getClass();
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public final boolean g(CacheKey cacheKey) {
        synchronized (this.f17044m) {
            if (e(cacheKey)) {
                return true;
            }
            try {
                ArrayList arrayListB = CacheKeyUtil.b(cacheKey);
                for (int i2 = 0; i2 < arrayListB.size(); i2++) {
                    String str = (String) arrayListB.get(i2);
                    if (this.f17039h.h(str, cacheKey)) {
                        this.f17036e.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public final void h(long j2) throws IOException {
        DiskStorage diskStorage = this.f17039h;
        try {
            ArrayList arrayListI = i(diskStorage.g());
            CacheStats cacheStats = this.f17042k;
            long jA = cacheStats.a() - j2;
            Iterator it = arrayListI.iterator();
            int i2 = 0;
            long j3 = 0;
            while (it.hasNext()) {
                DiskStorage.Entry entry = (DiskStorage.Entry) it.next();
                if (j3 > jA) {
                    break;
                }
                long jE = diskStorage.e(entry);
                this.f17036e.remove(entry.getId());
                if (jE > 0) {
                    i2++;
                    j3 += jE;
                    SettableCacheEvent.a().b();
                }
            }
            cacheStats.b(-j3, -i2);
            diskStorage.b();
        } catch (IOException e2) {
            e2.getMessage();
            this.f17041j.getClass();
            throw e2;
        }
    }

    public final ArrayList i(Collection collection) {
        this.f17043l.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() + n;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            DiskStorage.Entry entry = (DiskStorage.Entry) it.next();
            if (entry.getTimestamp() > jCurrentTimeMillis) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        this.f17040i.getClass();
        Collections.sort(arrayList2, new DefaultEntryEvictionComparatorSupplier.AnonymousClass1());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j() {
        /*
            r17 = this;
            r1 = r17
            com.facebook.common.time.SystemClock r0 = r1.f17043l
            r0.getClass()
            long r2 = java.lang.System.currentTimeMillis()
            com.facebook.cache.disk.DiskStorageCache$CacheStats r4 = r1.f17042k
            monitor-enter(r4)
            boolean r0 = r4.f17045a     // Catch: java.lang.Throwable -> La5
            monitor-exit(r4)
            r4 = 0
            r5 = -1
            if (r0 == 0) goto L23
            long r7 = r1.f17037f
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L23
            long r2 = r2 - r7
            long r7 = com.facebook.cache.disk.DiskStorageCache.o
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 <= 0) goto La4
        L23:
            com.facebook.common.time.SystemClock r0 = r1.f17043l
            r0.getClass()
            long r2 = java.lang.System.currentTimeMillis()
            long r7 = com.facebook.cache.disk.DiskStorageCache.n
            long r7 = r7 + r2
            com.facebook.cache.disk.DiskStorage r0 = r1.f17039h     // Catch: java.io.IOException -> L67
            java.util.Collection r0 = r0.g()     // Catch: java.io.IOException -> L67
            java.util.Iterator r0 = r0.iterator()     // Catch: java.io.IOException -> L67
            r9 = 0
            r11 = r4
            r12 = r11
        L3d:
            boolean r13 = r0.hasNext()     // Catch: java.io.IOException -> L67
            if (r13 == 0) goto L69
            java.lang.Object r13 = r0.next()     // Catch: java.io.IOException -> L67
            com.facebook.cache.disk.DiskStorage$Entry r13 = (com.facebook.cache.disk.DiskStorage.Entry) r13     // Catch: java.io.IOException -> L67
            int r12 = r12 + 1
            long r15 = r13.getSize()     // Catch: java.io.IOException -> L67
            long r9 = r9 + r15
            long r15 = r13.getTimestamp()     // Catch: java.io.IOException -> L67
            int r15 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r15 <= 0) goto L3d
            r13.getSize()     // Catch: java.io.IOException -> L67
            long r15 = r13.getTimestamp()     // Catch: java.io.IOException -> L67
            long r14 = r15 - r2
            long r5 = java.lang.Math.max(r14, r5)     // Catch: java.io.IOException -> L67
            r11 = 1
            goto L3d
        L67:
            r0 = move-exception
            goto L9c
        L69:
            if (r11 == 0) goto L70
            com.facebook.cache.common.NoOpCacheErrorLogger r0 = r1.f17041j     // Catch: java.io.IOException -> L67
            r0.getClass()     // Catch: java.io.IOException -> L67
        L70:
            com.facebook.cache.disk.DiskStorageCache$CacheStats r5 = r1.f17042k     // Catch: java.io.IOException -> L67
            monitor-enter(r5)     // Catch: java.io.IOException -> L67
            long r6 = r5.f17047c     // Catch: java.lang.Throwable -> L99
            monitor-exit(r5)     // Catch: java.io.IOException -> L67
            long r11 = (long) r12     // Catch: java.io.IOException -> L67
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L88
            com.facebook.cache.disk.DiskStorageCache$CacheStats r0 = r1.f17042k     // Catch: java.io.IOException -> L67
            long r5 = r0.a()     // Catch: java.io.IOException -> L67
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L86
            goto L88
        L86:
            r13 = 1
            goto L93
        L88:
            com.facebook.cache.disk.DiskStorageCache$CacheStats r5 = r1.f17042k     // Catch: java.io.IOException -> L67
            monitor-enter(r5)     // Catch: java.io.IOException -> L67
            r5.f17047c = r11     // Catch: java.lang.Throwable -> L96
            r5.f17046b = r9     // Catch: java.lang.Throwable -> L96
            r13 = 1
            r5.f17045a = r13     // Catch: java.lang.Throwable -> L96
            monitor-exit(r5)     // Catch: java.io.IOException -> L67
        L93:
            r1.f17037f = r2
            return r13
        L96:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L96
            throw r0     // Catch: java.io.IOException -> L67
        L99:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L99
            throw r0     // Catch: java.io.IOException -> L67
        L9c:
            com.facebook.cache.common.NoOpCacheErrorLogger r2 = r1.f17041j
            r0.getMessage()
            r2.getClass()
        La4:
            return r4
        La5:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DiskStorageCache.j():boolean");
    }

    public final DiskStorage.Inserter k(String str, CacheKey cacheKey) {
        synchronized (this.f17044m) {
            boolean zJ = j();
            l();
            long jA = this.f17042k.a();
            if (jA > this.f17035d && !zJ) {
                CacheStats cacheStats = this.f17042k;
                synchronized (cacheStats) {
                    cacheStats.f17045a = false;
                    cacheStats.f17047c = -1L;
                    cacheStats.f17046b = -1L;
                }
                j();
            }
            long j2 = this.f17035d;
            if (jA > j2) {
                h((j2 * 9) / 10);
            }
        }
        return this.f17039h.c(str, cacheKey);
    }

    public final void l() {
        boolean zIsExternal = this.f17039h.isExternal();
        StatFsHelper.StorageType storageType = StatFsHelper.StorageType.f17129a;
        StatFsHelper.StorageType storageType2 = zIsExternal ? StatFsHelper.StorageType.f17130b : storageType;
        StatFsHelper statFsHelper = this.f17038g;
        long jA = this.f17033b - this.f17042k.a();
        statFsHelper.a();
        statFsHelper.a();
        ReentrantLock reentrantLock = statFsHelper.f17127f;
        if (reentrantLock.tryLock()) {
            try {
                if (android.os.SystemClock.uptimeMillis() - statFsHelper.f17126e > StatFsHelper.f17121i) {
                    statFsHelper.f17122a = StatFsHelper.b(statFsHelper.f17122a, statFsHelper.f17123b);
                    statFsHelper.f17124c = StatFsHelper.b(statFsHelper.f17124c, statFsHelper.f17125d);
                    statFsHelper.f17126e = android.os.SystemClock.uptimeMillis();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        StatFs statFs = storageType2 == storageType ? statFsHelper.f17122a : statFsHelper.f17124c;
        long availableBlocksLong = statFs != null ? statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() : 0L;
        if (availableBlocksLong <= 0 || availableBlocksLong < jA) {
            this.f17035d = this.f17032a;
        } else {
            this.f17035d = this.f17033b;
        }
    }
}
