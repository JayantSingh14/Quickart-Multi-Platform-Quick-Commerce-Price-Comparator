package com.facebook.cache.disk;

import androidx.media3.exoplayer.analytics.d;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public interface FileCache extends DiskTrimmable {
    void a();

    boolean b(CacheKey cacheKey);

    BinaryResource c(CacheKey cacheKey);

    BinaryResource d(CacheKey cacheKey, d dVar);

    boolean e(CacheKey cacheKey);

    void f(CacheKey cacheKey);

    boolean g(CacheKey cacheKey);
}
