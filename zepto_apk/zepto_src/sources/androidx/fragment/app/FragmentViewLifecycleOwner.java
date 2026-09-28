package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f4680a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewModelStore f4681b;

    /* renamed from: c, reason: collision with root package name */
    public final d f4682c;

    /* renamed from: d, reason: collision with root package name */
    public ViewModelProvider.Factory f4683d;

    /* renamed from: e, reason: collision with root package name */
    public LifecycleRegistry f4684e = null;

    /* renamed from: f, reason: collision with root package name */
    public SavedStateRegistryController f4685f = null;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore, d dVar) {
        this.f4680a = fragment;
        this.f4681b = viewModelStore;
        this.f4682c = dVar;
    }

    public final void a(Lifecycle.Event event) {
        this.f4684e.f(event);
    }

    public final void b() {
        if (this.f4684e == null) {
            this.f4684e = new LifecycleRegistry(this);
            SavedStateRegistryController savedStateRegistryControllerA = SavedStateRegistryController.Companion.a(this);
            this.f4685f = savedStateRegistryControllerA;
            savedStateRegistryControllerA.a();
            this.f4682c.run();
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f4680a;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.b(ViewModelProvider.AndroidViewModelFactory.f4945d, application);
        }
        mutableCreationExtras.b(SavedStateHandleSupport.f4906a, fragment);
        mutableCreationExtras.b(SavedStateHandleSupport.f4907b, this);
        if (fragment.getArguments() != null) {
            mutableCreationExtras.b(SavedStateHandleSupport.f4908c, fragment.getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f4680a;
        ViewModelProvider.Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f4683d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f4683d == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f4683d = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.f4683d;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        b();
        return this.f4684e;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f4685f.f11892b;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        b();
        return this.f4681b;
    }
}
