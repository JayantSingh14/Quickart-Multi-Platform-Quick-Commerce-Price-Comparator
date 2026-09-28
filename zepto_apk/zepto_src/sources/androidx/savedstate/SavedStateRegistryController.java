package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.b;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* renamed from: a, reason: collision with root package name */
    public final SavedStateRegistryOwner f11891a;

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateRegistry f11892b = new SavedStateRegistry();

    /* renamed from: c, reason: collision with root package name */
    public boolean f11893c;

    @Metadata
    public static final class Companion {
        public static SavedStateRegistryController a(SavedStateRegistryOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new SavedStateRegistryController(owner);
        }
    }

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f11891a = savedStateRegistryOwner;
    }

    public final void a() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.f11891a;
        Lifecycle lifecycle = savedStateRegistryOwner.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.f4806b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(savedStateRegistryOwner));
        SavedStateRegistry savedStateRegistry = this.f11892b;
        savedStateRegistry.getClass();
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (savedStateRegistry.f11886b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new b(savedStateRegistry, 2));
        savedStateRegistry.f11886b = true;
        this.f11893c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f11893c) {
            a();
        }
        Lifecycle lifecycle = this.f11891a.getLifecycle();
        if (lifecycle.b().a(Lifecycle.State.f4808d)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
        }
        SavedStateRegistry savedStateRegistry = this.f11892b;
        if (!savedStateRegistry.f11886b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (savedStateRegistry.f11888d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        savedStateRegistry.f11887c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        savedStateRegistry.f11888d = true;
    }

    public final void c(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        SavedStateRegistry savedStateRegistry = this.f11892b;
        savedStateRegistry.getClass();
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = savedStateRegistry.f11887c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap safeIterableMap = savedStateRegistry.f11885a;
        safeIterableMap.getClass();
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
        safeIterableMap.f1285c.put(iteratorWithAdditions, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle.putBundle((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }
}
