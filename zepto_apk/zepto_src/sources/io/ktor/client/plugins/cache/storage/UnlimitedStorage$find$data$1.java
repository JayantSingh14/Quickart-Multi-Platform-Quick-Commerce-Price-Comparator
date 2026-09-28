package io.ktor.client.plugins.cache.storage;

import io.ktor.util.collections.ConcurrentSetKt$ConcurrentSet$1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class UnlimitedStorage$find$data$1 extends Lambda implements Function0<Set<CachedResponseData>> {

    /* renamed from: c, reason: collision with root package name */
    public static final UnlimitedStorage$find$data$1 f49843c = new UnlimitedStorage$find$data$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new ConcurrentSetKt$ConcurrentSet$1();
    }
}
