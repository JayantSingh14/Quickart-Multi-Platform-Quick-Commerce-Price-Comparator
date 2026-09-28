package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1 f4906a = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();

    /* renamed from: b, reason: collision with root package name */
    public static final SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1 f4907b = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();

    /* renamed from: c, reason: collision with root package name */
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 f4908c = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    public static final SavedStateHandle a(MutableCreationExtras mutableCreationExtras) {
        Intrinsics.checkNotNullParameter(mutableCreationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) mutableCreationExtras.a(f4906a);
        if (savedStateRegistryOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) mutableCreationExtras.a(f4907b);
        if (viewModelStoreOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) mutableCreationExtras.a(f4908c);
        String key = (String) mutableCreationExtras.a(ViewModelProviders.ViewModelKey.f4972a);
        if (key == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider savedStateProviderB = savedStateRegistryOwner.getSavedStateRegistry().b();
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProviderB instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProviderB : null;
        if (savedStateHandlesProvider == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        SavedStateHandlesVM savedStateHandlesVMC = c(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = (SavedStateHandle) savedStateHandlesVMC.f4914b.get(key);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Class[] clsArr = SavedStateHandle.f4896f;
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandlesProvider.b();
        Bundle bundle2 = savedStateHandlesProvider.f4911c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(key) : null;
        Bundle bundle4 = savedStateHandlesProvider.f4911c;
        if (bundle4 != null) {
            bundle4.remove(key);
        }
        Bundle bundle5 = savedStateHandlesProvider.f4911c;
        if (bundle5 != null && bundle5.isEmpty()) {
            savedStateHandlesProvider.f4911c = null;
        }
        SavedStateHandle savedStateHandleA = SavedStateHandle.Companion.a(bundle3, bundle);
        savedStateHandlesVMC.f4914b.put(key, savedStateHandleA);
        return savedStateHandleA;
    }

    public static final void b(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        Lifecycle.State stateB = savedStateRegistryOwner.getLifecycle().b();
        if (stateB != Lifecycle.State.f4806b && stateB != Lifecycle.State.f4807c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (savedStateRegistryOwner.getSavedStateRegistry().b() == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesVM c(ViewModelStoreOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "<this>");
        SavedStateHandleSupport$savedStateHandlesVM$1 factory = new SavedStateHandleSupport$savedStateHandlesVM$1();
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModelStore viewModelStore = owner.getViewModelStore();
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, factory, owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f4963b);
        Intrinsics.checkNotNullParameter("androidx.lifecycle.internal.SavedStateHandlesVM", "key");
        Intrinsics.checkNotNullParameter(SavedStateHandlesVM.class, "modelClass");
        Intrinsics.checkNotNullParameter(SavedStateHandlesVM.class, "<this>");
        return (SavedStateHandlesVM) viewModelProvider.f4943a.a(Reflection.a(SavedStateHandlesVM.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
