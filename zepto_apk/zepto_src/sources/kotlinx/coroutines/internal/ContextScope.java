package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public final class ContextScope implements CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f55065a;

    public ContextScope(CoroutineContext coroutineContext) {
        this.f55065a = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f55065a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f55065a + ')';
    }
}
