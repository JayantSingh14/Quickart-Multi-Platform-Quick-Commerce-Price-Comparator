package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.util.collections.ConcurrentSetKt$ConcurrentSet$1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class UnlimitedCacheStorage$store$data$1 extends Lambda implements Function0<Set<HttpCacheEntry>> {

    /* renamed from: c, reason: collision with root package name */
    public static final UnlimitedCacheStorage$store$data$1 f49841c = new UnlimitedCacheStorage$store$data$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new ConcurrentSetKt$ConcurrentSet$1();
    }
}
