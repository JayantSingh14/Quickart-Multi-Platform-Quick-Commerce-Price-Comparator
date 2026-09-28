package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: classes3.dex */
final class HttpClientJvmEngine$createCallContext$onParentCancelCleanupHandle$1 extends Lambda implements Function1<Throwable, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        if (((Throwable) obj) == null) {
            return Unit.f53572a;
        }
        JobKt.b(null, null);
        throw null;
    }
}
