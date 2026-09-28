package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LegacySavedStateHandleController {

    @Metadata
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public final void a(SavedStateRegistryOwner owner) throws NoSuchMethodException, SecurityException {
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (!(owner instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner).getViewModelStore();
            SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
            viewModelStore.getClass();
            LinkedHashMap linkedHashMap = viewModelStore.f4948a;
            Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                Intrinsics.checkNotNullParameter(key, "key");
                ViewModel viewModel = (ViewModel) linkedHashMap.get(key);
                Intrinsics.c(viewModel);
                LegacySavedStateHandleController.a(viewModel, savedStateRegistry, owner.getLifecycle());
            }
            if (new HashSet(linkedHashMap.keySet()).isEmpty()) {
                return;
            }
            savedStateRegistry.d();
        }
    }

    public static final void a(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.f4905c) {
            return;
        }
        savedStateHandleController.b(lifecycle, registry);
        b(lifecycle, registry);
    }

    public static void b(final Lifecycle lifecycle, final SavedStateRegistry savedStateRegistry) throws NoSuchMethodException, SecurityException {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.f4806b || stateB.a(Lifecycle.State.f4808d)) {
            savedStateRegistry.d();
        } else {
            lifecycle.a(new LifecycleEventObserver() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void a(LifecycleOwner source, Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.c(this);
                        savedStateRegistry.d();
                    }
                }
            });
        }
    }
}
