package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {

    /* renamed from: a, reason: collision with root package name */
    public final ClassReference f4938a;

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f4939b;

    /* renamed from: c, reason: collision with root package name */
    public final Function0 f4940c;

    /* renamed from: d, reason: collision with root package name */
    public final Lambda f4941d;

    /* renamed from: e, reason: collision with root package name */
    public ViewModel f4942e;

    @Metadata
    /* renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function0<CreationExtras.Empty> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CreationExtras.Empty.f4963b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(ClassReference viewModelClass, Function0 storeProducer, Function0 factoryProducer, Function0 extrasProducer) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        Intrinsics.checkNotNullParameter(extrasProducer, "extrasProducer");
        this.f4938a = viewModelClass;
        this.f4939b = (Lambda) storeProducer;
        this.f4940c = factoryProducer;
        this.f4941d = (Lambda) extrasProducer;
    }

    @Override // kotlin.Lazy
    public final boolean d() {
        return this.f4942e != null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.Lazy
    public final Object getValue() {
        ViewModel viewModel = this.f4942e;
        if (viewModel != null) {
            return viewModel;
        }
        ViewModelStore store = (ViewModelStore) this.f4939b.invoke();
        ViewModelProvider.Factory factory = (ViewModelProvider.Factory) this.f4940c.invoke();
        CreationExtras extras = (CreationExtras) this.f4941d.invoke();
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        ViewModel viewModelA = new ViewModelProvider(store, factory, extras).a(this.f4938a);
        this.f4942e = viewModelA;
        return viewModelA;
    }
}
