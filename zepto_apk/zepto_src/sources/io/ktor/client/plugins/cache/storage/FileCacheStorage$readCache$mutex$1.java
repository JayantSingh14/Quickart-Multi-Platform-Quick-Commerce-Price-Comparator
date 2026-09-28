package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
/* loaded from: classes3.dex */
final class FileCacheStorage$readCache$mutex$1 extends Lambda implements Function0<Mutex> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return MutexKt.a();
    }
}
