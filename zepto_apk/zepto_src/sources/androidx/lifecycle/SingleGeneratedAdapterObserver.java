package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final GeneratedAdapter f4928a;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        Intrinsics.checkNotNullParameter(generatedAdapter, "generatedAdapter");
        this.f4928a = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        GeneratedAdapter generatedAdapter = this.f4928a;
        generatedAdapter.a();
        generatedAdapter.a();
    }
}
