package com.brentvatne.exoplayer;

import android.content.Context;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RNVSimpleCache {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleCache f15558a;

    public static DataSource.Factory a(HttpDataSource.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (f15558a == null) {
            return factory;
        }
        CacheDataSource.Factory factory2 = new CacheDataSource.Factory();
        SimpleCache simpleCache = f15558a;
        Intrinsics.c(simpleCache);
        factory2.f5974a = simpleCache;
        factory2.f5977d = factory;
        Intrinsics.checkNotNullExpressionValue(factory2, "setUpstreamDataSourceFactory(...)");
        return factory2;
    }

    public static void b(int i2, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f15558a != null || i2 <= 0) {
            return;
        }
        long j2 = 1024;
        f15558a = new SimpleCache(new File(context.getCacheDir(), "RNVCache"), new LeastRecentlyUsedCacheEvictor(i2 * j2 * j2), new StandaloneDatabaseProvider(context.getApplicationContext(), "exoplayer_internal.db", null, 1));
    }
}
