package androidx.media3.datasource.cache;

import android.database.SQLException;
import android.os.ConditionVariable;
import android.support.v4.media.b;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CachedContent;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

@UnstableApi
/* loaded from: classes3.dex */
public final class SimpleCache implements Cache {

    /* renamed from: k, reason: collision with root package name */
    public static final HashSet f6025k = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final File f6026a;

    /* renamed from: b, reason: collision with root package name */
    public final LeastRecentlyUsedCacheEvictor f6027b;

    /* renamed from: c, reason: collision with root package name */
    public final CachedContentIndex f6028c;

    /* renamed from: d, reason: collision with root package name */
    public final CacheFileMetadataIndex f6029d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f6030e;

    /* renamed from: f, reason: collision with root package name */
    public final Random f6031f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6032g;

    /* renamed from: h, reason: collision with root package name */
    public long f6033h;

    /* renamed from: i, reason: collision with root package name */
    public long f6034i;

    /* renamed from: j, reason: collision with root package name */
    public Cache.CacheException f6035j;

    public SimpleCache(File file, LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor, StandaloneDatabaseProvider standaloneDatabaseProvider) {
        boolean zAdd;
        CachedContentIndex cachedContentIndex = new CachedContentIndex(standaloneDatabaseProvider, file);
        CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex(standaloneDatabaseProvider);
        synchronized (SimpleCache.class) {
            zAdd = f6025k.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f6026a = file;
        this.f6027b = leastRecentlyUsedCacheEvictor;
        this.f6028c = cachedContentIndex;
        this.f6029d = cacheFileMetadataIndex;
        this.f6030e = new HashMap();
        this.f6031f = new Random();
        this.f6032g = true;
        this.f6033h = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread() { // from class: androidx.media3.datasource.cache.SimpleCache.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("ExoPlayer:SimpleCacheInit");
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.a(SimpleCache.this);
                    SimpleCache.this.f6027b.getClass();
                }
            }
        }.start();
        conditionVariable.block();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(SimpleCache simpleCache) throws NumberFormatException {
        long j2;
        CachedContentIndex cachedContentIndex = simpleCache.f6028c;
        File file = simpleCache.f6026a;
        if (!file.exists()) {
            try {
                e(file);
            } catch (Cache.CacheException e2) {
                simpleCache.f6035j = e2;
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            Log.d("SimpleCache", str);
            simpleCache.f6035j = new Cache.CacheException(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                j2 = -1;
                break;
            }
            File file2 = fileArrListFiles[i2];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    j2 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    Log.d("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i2++;
        }
        simpleCache.f6033h = j2;
        if (j2 == -1) {
            try {
                simpleCache.f6033h = f(file);
            } catch (IOException e3) {
                String str2 = "Failed to create cache UID: " + file;
                Log.e("SimpleCache", str2, e3);
                simpleCache.f6035j = new Cache.CacheException(str2, e3);
                return;
            }
        }
        try {
            cachedContentIndex.e(simpleCache.f6033h);
            CacheFileMetadataIndex cacheFileMetadataIndex = simpleCache.f6029d;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.b(simpleCache.f6033h);
                HashMap mapA = cacheFileMetadataIndex.a();
                simpleCache.i(file, true, fileArrListFiles, mapA);
                cacheFileMetadataIndex.c(mapA.keySet());
            } else {
                simpleCache.i(file, true, fileArrListFiles, null);
            }
            UnmodifiableIterator it = ImmutableSet.o(cachedContentIndex.f6000a.keySet()).iterator();
            while (it.hasNext()) {
                cachedContentIndex.f((String) it.next());
            }
            try {
                cachedContentIndex.g();
            } catch (IOException e4) {
                Log.e("SimpleCache", "Storing index file failed", e4);
            }
        } catch (IOException e5) {
            String str3 = "Failed to initialize cache indices: " + file;
            Log.e("SimpleCache", str3, e5);
            simpleCache.f6035j = new Cache.CacheException(str3, e5);
        }
    }

    public static void e(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        Log.d("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    public static long f(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, b.k(Long.toString(jAbs, 16), ".uid"));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public final void b(SimpleCacheSpan simpleCacheSpan) {
        CachedContentIndex cachedContentIndex = this.f6028c;
        String str = simpleCacheSpan.f5983a;
        cachedContentIndex.d(str).f5995c.add(simpleCacheSpan);
        this.f6034i += simpleCacheSpan.f5985c;
        ArrayList arrayList = (ArrayList) this.f6030e.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).c(this, simpleCacheSpan);
            }
        }
        this.f6027b.c(this, simpleCacheSpan);
    }

    public final synchronized void c(String str, ContentMetadataMutations contentMetadataMutations) {
        d();
        CachedContentIndex cachedContentIndex = this.f6028c;
        CachedContent cachedContentD = cachedContentIndex.d(str);
        DefaultContentMetadata defaultContentMetadata = cachedContentD.f5997e;
        DefaultContentMetadata defaultContentMetadataA = defaultContentMetadata.a(contentMetadataMutations);
        cachedContentD.f5997e = defaultContentMetadataA;
        if (!defaultContentMetadataA.equals(defaultContentMetadata)) {
            cachedContentIndex.f6004e.f(cachedContentD);
        }
        try {
            this.f6028c.g();
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        }
    }

    public final synchronized void d() {
        Cache.CacheException cacheException = this.f6035j;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public final synchronized long g(long j2, long j3, String str) {
        long j4;
        long jA;
        long j5 = j3 == -1 ? Long.MAX_VALUE : j3 + j2;
        long j6 = j5 >= 0 ? j5 : Long.MAX_VALUE;
        j4 = 0;
        while (j2 < j6) {
            long j7 = j6 - j2;
            synchronized (this) {
                if (j7 == -1) {
                    j7 = Long.MAX_VALUE;
                }
                CachedContent cachedContentC = this.f6028c.c(str);
                jA = cachedContentC != null ? cachedContentC.a(j2, j7) : -j7;
            }
        }
        return j4;
        if (jA > 0) {
            j4 += jA;
        } else {
            jA = -jA;
        }
        j2 += jA;
    }

    public final synchronized DefaultContentMetadata h(String str) {
        CachedContent cachedContentC;
        cachedContentC = this.f6028c.c(str);
        return cachedContentC != null ? cachedContentC.f5997e : DefaultContentMetadata.f6018c;
    }

    public final void i(File file, boolean z, File[] fileArr, HashMap map) {
        long j2;
        long j3;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                i(file2, false, file2.listFiles(), map);
            } else if (!z || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                CacheFileMetadata cacheFileMetadata = map != null ? (CacheFileMetadata) map.remove(name) : null;
                if (cacheFileMetadata != null) {
                    j2 = cacheFileMetadata.f5978a;
                    j3 = cacheFileMetadata.f5979b;
                } else {
                    j2 = -1;
                    j3 = -9223372036854775807L;
                }
                SimpleCacheSpan simpleCacheSpanB = SimpleCacheSpan.b(file2, j2, j3, this.f6028c);
                if (simpleCacheSpanB != null) {
                    b(simpleCacheSpanB);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void j(CacheSpan cacheSpan) {
        CachedContent cachedContentC = this.f6028c.c(cacheSpan.f5983a);
        cachedContentC.getClass();
        long j2 = cacheSpan.f5984b;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = cachedContentC.f5996d;
            if (i2 >= arrayList.size()) {
                throw new IllegalStateException();
            }
            if (((CachedContent.Range) arrayList.get(i2)).f5998a == j2) {
                arrayList.remove(i2);
                this.f6028c.f(cachedContentC.f5994b);
                notifyAll();
            } else {
                i2++;
            }
        }
    }

    public final void k(CacheSpan cacheSpan) throws DatabaseIOException {
        String str = cacheSpan.f5983a;
        CachedContentIndex cachedContentIndex = this.f6028c;
        CachedContent cachedContentC = cachedContentIndex.c(str);
        if (cachedContentC == null || !cachedContentC.f5995c.remove(cacheSpan)) {
            return;
        }
        File file = cacheSpan.f5987e;
        if (file != null) {
            file.delete();
        }
        this.f6034i -= cacheSpan.f5985c;
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f6029d;
        if (cacheFileMetadataIndex != null) {
            file.getClass();
            String name = file.getName();
            try {
                cacheFileMetadataIndex.f5982b.getClass();
                try {
                    cacheFileMetadataIndex.f5981a.getWritableDatabase().delete(cacheFileMetadataIndex.f5982b, "name = ?", new String[]{name});
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                }
            } catch (IOException unused) {
                android.support.v4.media.a.y("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        cachedContentIndex.f(cachedContentC.f5994b);
        ArrayList arrayList = (ArrayList) this.f6030e.get(cacheSpan.f5983a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).a(cacheSpan);
            }
        }
        this.f6027b.a(cacheSpan);
    }

    public final void l() throws DatabaseIOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.f6028c.f6000a.values()).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((CachedContent) it.next()).f5995c.iterator();
            while (it2.hasNext()) {
                CacheSpan cacheSpan = (CacheSpan) it2.next();
                File file = cacheSpan.f5987e;
                file.getClass();
                if (file.length() != cacheSpan.f5985c) {
                    arrayList.add(cacheSpan);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            k((CacheSpan) arrayList.get(i2));
        }
    }

    public final synchronized CacheSpan m(long j2, long j3, String str) {
        long j4;
        SimpleCacheSpan simpleCacheSpanB;
        d();
        CachedContent cachedContentC = this.f6028c.c(str);
        if (cachedContentC != null) {
            j4 = j2;
            while (true) {
                simpleCacheSpanB = cachedContentC.b(j4, j3);
                if (!simpleCacheSpanB.f5986d) {
                    break;
                }
                File file = simpleCacheSpanB.f5987e;
                file.getClass();
                if (file.length() == simpleCacheSpanB.f5985c) {
                    break;
                }
                l();
            }
        } else {
            j4 = j2;
            simpleCacheSpanB = new SimpleCacheSpan(str, j4, j3, -9223372036854775807L, null);
        }
        if (simpleCacheSpanB.f5986d) {
            return n(str, simpleCacheSpanB);
        }
        CachedContent cachedContentD = this.f6028c.d(str);
        long j5 = simpleCacheSpanB.f5985c;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = cachedContentD.f5996d;
            if (i2 >= arrayList.size()) {
                arrayList.add(new CachedContent.Range(j4, j5));
                return simpleCacheSpanB;
            }
            CachedContent.Range range = (CachedContent.Range) arrayList.get(i2);
            long j6 = range.f5998a;
            if (j6 <= j4) {
                long j7 = range.f5999b;
                if (j7 == -1 || j6 + j7 > j4) {
                    break;
                }
                i2++;
            } else {
                if (j5 == -1 || j4 + j5 > j6) {
                    break;
                }
                i2++;
            }
        }
        return null;
    }

    public final SimpleCacheSpan n(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z;
        File file;
        if (!this.f6032g) {
            return simpleCacheSpan;
        }
        File file2 = simpleCacheSpan.f5987e;
        file2.getClass();
        String name = file2.getName();
        long j2 = simpleCacheSpan.f5985c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f6029d;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.d(j2, jCurrentTimeMillis, name);
            } catch (IOException unused) {
                jCurrentTimeMillis = jCurrentTimeMillis;
                Log.h("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        CachedContent cachedContentC = this.f6028c.c(str);
        cachedContentC.getClass();
        TreeSet treeSet = cachedContentC.f5995c;
        Assertions.g(treeSet.remove(simpleCacheSpan));
        file2.getClass();
        if (z) {
            File parentFile = file2.getParentFile();
            parentFile.getClass();
            File fileC = SimpleCacheSpan.c(parentFile, cachedContentC.f5993a, simpleCacheSpan.f5984b, jCurrentTimeMillis);
            if (file2.renameTo(fileC)) {
                file = fileC;
            } else {
                Log.h("CachedContent", "Failed to rename " + file2 + " to " + fileC);
                file = file2;
            }
        } else {
            file = file2;
        }
        Assertions.g(simpleCacheSpan.f5986d);
        SimpleCacheSpan simpleCacheSpan2 = new SimpleCacheSpan(simpleCacheSpan.f5983a, simpleCacheSpan.f5984b, simpleCacheSpan.f5985c, jCurrentTimeMillis, file);
        treeSet.add(simpleCacheSpan2);
        ArrayList arrayList = (ArrayList) this.f6030e.get(simpleCacheSpan.f5983a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).b(this, simpleCacheSpan, simpleCacheSpan2);
            }
        }
        this.f6027b.b(this, simpleCacheSpan, simpleCacheSpan2);
        return simpleCacheSpan2;
    }
}
