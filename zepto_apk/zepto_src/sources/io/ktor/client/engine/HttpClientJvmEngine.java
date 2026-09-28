package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpSendPipeline;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class HttpClientJvmEngine implements HttpClientEngine {
    @Override // io.ktor.client.engine.HttpClientEngine
    public final void K1(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.f49264g.g(HttpSendPipeline.f50033j, new HttpClientEngine$install$1(client, this, null));
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final Set Z0() {
        return EmptySet.f53611a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((CompletableJob) JobKt.e(null)).complete();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        throw null;
    }
}
