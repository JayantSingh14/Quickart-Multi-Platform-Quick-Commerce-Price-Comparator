package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Application f4915a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewModelProvider.AndroidViewModelFactory f4916b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f4917c;

    /* renamed from: d, reason: collision with root package name */
    public final Lifecycle f4918d;

    /* renamed from: e, reason: collision with root package name */
    public final SavedStateRegistry f4919e;

    public SavedStateViewModelFactory() {
        this.f4916b = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel a(Class modelClass, MutableCreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        String str = (String) extras.a(ViewModelProviders.ViewModelKey.f4972a);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f4906a) == null || extras.a(SavedStateHandleSupport.f4907b) == null) {
            if (this.f4918d != null) {
                return e(modelClass, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(ViewModelProvider.AndroidViewModelFactory.f4945d);
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.a(SavedStateViewModelFactoryKt.f4921b, modelClass) : SavedStateViewModelFactoryKt.a(SavedStateViewModelFactoryKt.f4920a, modelClass);
        return constructorA == null ? this.f4916b.a(modelClass, extras) : (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.b(modelClass, constructorA, SavedStateHandleSupport.a(extras)) : SavedStateViewModelFactoryKt.b(modelClass, constructorA, application, SavedStateHandleSupport.a(extras));
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel c(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return e(modelClass, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public final void d(ViewModel viewModel) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Lifecycle lifecycle = this.f4918d;
        if (lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.f4919e;
            Intrinsics.c(savedStateRegistry);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    public final ViewModel e(Class modelClass, String key) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Lifecycle lifecycle = this.f4918d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
        Application application = this.f4915a;
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.a(SavedStateViewModelFactoryKt.f4921b, modelClass) : SavedStateViewModelFactoryKt.a(SavedStateViewModelFactoryKt.f4920a, modelClass);
        if (constructorA == null) {
            if (application != null) {
                return this.f4916b.c(modelClass);
            }
            if (ViewModelProvider.NewInstanceFactory.f4947a == null) {
                ViewModelProvider.NewInstanceFactory.f4947a = new ViewModelProvider.NewInstanceFactory();
            }
            Intrinsics.c(ViewModelProvider.NewInstanceFactory.f4947a);
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return JvmViewModelProviders.a(modelClass);
        }
        SavedStateRegistry registry = this.f4919e;
        Intrinsics.c(registry);
        Bundle bundle = this.f4917c;
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Bundle bundleA = registry.a(key);
        Class[] clsArr = SavedStateHandle.f4896f;
        SavedStateHandle savedStateHandleA = SavedStateHandle.Companion.a(bundleA, bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(key, savedStateHandleA);
        savedStateHandleController.b(lifecycle, registry);
        LegacySavedStateHandleController.b(lifecycle, registry);
        ViewModel viewModelB = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.b(modelClass, constructorA, savedStateHandleA) : SavedStateViewModelFactoryKt.b(modelClass, constructorA, application, savedStateHandleA);
        viewModelB.a("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return viewModelB;
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f4919e = owner.getSavedStateRegistry();
        this.f4918d = owner.getLifecycle();
        this.f4917c = bundle;
        this.f4915a = application;
        if (application != null) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (ViewModelProvider.AndroidViewModelFactory.f4944c == null) {
                Intrinsics.checkNotNullParameter(application, "application");
                ViewModelProvider.AndroidViewModelFactory.f4944c = new ViewModelProvider.AndroidViewModelFactory(application);
            }
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.f4944c;
            Intrinsics.c(androidViewModelFactory);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f4916b = androidViewModelFactory;
    }
}
