package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: classes3.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f4811a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f4812b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f4811a = lifecycle;
        this.f4812b = coroutineContext;
        if (lifecycle.b() == Lifecycle.State.f4805a) {
            JobKt.b(coroutineContext, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle lifecycle = this.f4811a;
        if (lifecycle.b().compareTo(Lifecycle.State.f4805a) <= 0) {
            lifecycle.c(this);
            JobKt.b(this.f4812b, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f4812b;
    }
}
