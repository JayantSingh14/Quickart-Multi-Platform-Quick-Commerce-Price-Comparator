package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final SavedStateRegistry f4909a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4910b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f4911c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f4912d;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, final ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.f4909a = savedStateRegistry;
        this.f4912d = LazyKt.b(new Function0<SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SavedStateHandleSupport.c(viewModelStoreOwner);
            }
        });
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4911c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((SavedStateHandlesVM) this.f4912d.getValue()).f4914b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((SavedStateHandle) entry.getValue()).b().a();
            if (!Intrinsics.b(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f4910b = false;
        return bundle;
    }

    public final void b() {
        if (this.f4910b) {
            return;
        }
        Bundle bundleA = this.f4909a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4911c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.f4911c = bundle;
        this.f4910b = true;
    }
}
