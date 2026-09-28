package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class CacheStorage$Companion$Unlimited$1 extends Lambda implements Function0<UnlimitedStorage> {

    /* renamed from: c, reason: collision with root package name */
    public static final CacheStorage$Companion$Unlimited$1 f49753c = new CacheStorage$Companion$Unlimited$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new UnlimitedStorage();
    }
}
