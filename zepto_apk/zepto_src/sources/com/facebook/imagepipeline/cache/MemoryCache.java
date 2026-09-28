package com.facebook.imagepipeline.cache;

import androidx.media3.exoplayer.analytics.l;
import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface MemoryCache<K, V> extends MemoryTrimmable, HasDebugData {

    @Metadata
    public interface CacheTrimStrategy {
    }

    CloseableReference b(Object obj, CloseableReference closeableReference);

    int c(Predicate predicate);

    boolean d(l lVar);

    CloseableReference get(Object obj);
}
