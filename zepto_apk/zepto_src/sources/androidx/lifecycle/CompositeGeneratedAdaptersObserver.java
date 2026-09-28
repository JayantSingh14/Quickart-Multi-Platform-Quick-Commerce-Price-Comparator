package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final GeneratedAdapter[] f4768a;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapters) {
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        this.f4768a = generatedAdapters;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        new MethodCallsLogger();
        GeneratedAdapter[] generatedAdapterArr = this.f4768a;
        for (GeneratedAdapter generatedAdapter : generatedAdapterArr) {
            generatedAdapter.a();
        }
        for (GeneratedAdapter generatedAdapter2 : generatedAdapterArr) {
            generatedAdapter2.a();
        }
    }
}
