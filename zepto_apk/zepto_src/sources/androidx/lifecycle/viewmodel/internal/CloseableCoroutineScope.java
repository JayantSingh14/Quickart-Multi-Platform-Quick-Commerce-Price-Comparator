package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: classes3.dex */
public final class CloseableCoroutineScope implements AutoCloseable, CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f4967a;

    public CloseableCoroutineScope(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f4967a = coroutineContext;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        JobKt.b(this.f4967a, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f4967a;
    }
}
