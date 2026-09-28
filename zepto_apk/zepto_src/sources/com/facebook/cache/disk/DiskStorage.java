package com.facebook.cache.disk;

import androidx.media3.exoplayer.analytics.d;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Nullsafe
/* loaded from: classes3.dex */
public interface DiskStorage {

    public static class DiskDumpInfo {
        public DiskDumpInfo() {
            new ArrayList();
            new HashMap();
        }
    }

    public static class DiskDumpInfoEntry {
    }

    public interface Entry {
        String getId();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
        void a(d dVar);

        FileBinaryResource commit();

        boolean f();
    }

    void a();

    void b();

    Inserter c(String str, CacheKey cacheKey);

    boolean d(String str, CacheKey cacheKey);

    long e(Entry entry);

    BinaryResource f(String str, CacheKey cacheKey);

    Collection g();

    boolean h(String str, CacheKey cacheKey);

    boolean isExternal();

    long remove(String str);
}
