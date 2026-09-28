package io.ktor.client.plugins.cache;

import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpCacheEntryKt$cacheExpires$1 extends Lambda implements Function0<GMTDate> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpCacheEntryKt$cacheExpires$1 f49731c = new HttpCacheEntryKt$cacheExpires$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return DateJvmKt.b(null);
    }
}
