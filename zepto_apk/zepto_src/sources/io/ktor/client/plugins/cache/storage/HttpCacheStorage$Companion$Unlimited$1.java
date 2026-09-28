package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class HttpCacheStorage$Companion$Unlimited$1 extends Lambda implements Function0<UnlimitedCacheStorage> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpCacheStorage$Companion$Unlimited$1 f49822c = new HttpCacheStorage$Companion$Unlimited$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new UnlimitedCacheStorage();
    }
}
