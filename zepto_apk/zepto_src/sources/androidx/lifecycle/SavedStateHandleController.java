package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SavedStateHandleController implements LifecycleEventObserver, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final String f4903a;

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateHandle f4904b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4905c;

    public SavedStateHandleController(String key, SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f4903a = key;
        this.f4904b = handle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f4905c = false;
            source.getLifecycle().c(this);
        }
    }

    public final void b(Lifecycle lifecycle, SavedStateRegistry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (this.f4905c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f4905c = true;
        lifecycle.a(this);
        registry.c(this.f4903a, this.f4904b.f4901e);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
