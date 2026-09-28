package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SuppressLint({"RestrictedApi"})
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    public boolean f11886b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f11887c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11888d;

    /* renamed from: e, reason: collision with root package name */
    public Recreator.SavedStateProvider f11889e;

    /* renamed from: a, reason: collision with root package name */
    public final SafeIterableMap f11885a = new SafeIterableMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f11890f = true;

    @Metadata
    /* loaded from: classes3.dex */
    public interface AutoRecreated {
        void a(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface SavedStateProvider {
        Bundle a();
    }

    public final Bundle a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f11888d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f11887c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(key);
        Bundle bundle3 = this.f11887c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f11887c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f11887c = null;
        return bundle2;
    }

    public final SavedStateProvider b() {
        Intrinsics.checkNotNullParameter("androidx.lifecycle.internal.SavedStateHandlesProvider", "key");
        Iterator it = this.f11885a.iterator();
        while (it.hasNext()) {
            Map.Entry components = (Map.Entry) it.next();
            Intrinsics.checkNotNullExpressionValue(components, "components");
            String str = (String) components.getKey();
            SavedStateProvider savedStateProvider = (SavedStateProvider) components.getValue();
            if (Intrinsics.b(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                return savedStateProvider;
            }
        }
        return null;
    }

    public final void c(String key, SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (((SavedStateProvider) this.f11885a.d(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(LegacySavedStateHandleController.OnRecreation.class, "clazz");
        if (!this.f11890f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.SavedStateProvider savedStateProvider = this.f11889e;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.f11889e = savedStateProvider;
        try {
            LegacySavedStateHandleController.OnRecreation.class.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.f11889e;
            if (savedStateProvider2 != null) {
                String name = LegacySavedStateHandleController.OnRecreation.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                savedStateProvider2.b(name);
            }
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + LegacySavedStateHandleController.OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
