package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ViewModelProviderImpl {

    /* renamed from: a, reason: collision with root package name */
    public final ViewModelStore f4964a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewModelProvider.Factory f4965b;

    /* renamed from: c, reason: collision with root package name */
    public final CreationExtras f4966c;

    public ViewModelProviderImpl(ViewModelStore store, ViewModelProvider.Factory factory, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.f4964a = store;
        this.f4965b = factory;
        this.f4966c = extras;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewModel a(ClassReference modelClass, String key) {
        ViewModel viewModel;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(key, "key");
        ViewModelStore viewModelStore = this.f4964a;
        viewModelStore.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = viewModelStore.f4948a;
        ViewModel viewModel2 = (ViewModel) linkedHashMap.get(key);
        boolean zH = modelClass.h(viewModel2);
        ViewModelProvider.Factory factory = this.f4965b;
        if (zH) {
            if (factory instanceof ViewModelProvider.OnRequeryFactory) {
                Intrinsics.c(viewModel2);
                ((ViewModelProvider.OnRequeryFactory) factory).d(viewModel2);
            }
            Intrinsics.d(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
            return viewModel2;
        }
        MutableCreationExtras extras = new MutableCreationExtras(this.f4966c);
        extras.b(ViewModelProviders.ViewModelKey.f4972a, key);
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        try {
            try {
                viewModel = factory.b(modelClass, extras);
            } catch (AbstractMethodError unused) {
                viewModel = factory.c(JvmClassMappingKt.a(modelClass));
            }
        } catch (AbstractMethodError unused2) {
            viewModel = factory.a(JvmClassMappingKt.a(modelClass), extras);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ViewModel viewModel3 = (ViewModel) linkedHashMap.put(key, viewModel);
        if (viewModel3 != null) {
            viewModel3.b();
        }
        return viewModel;
    }
}
