package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import com.amazon.apay.hardened.activity.APayBrowserActivity;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ViewModelProviderImpl f4943a;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface Factory {

        @Metadata
        public static final class Companion {
        }

        default ViewModel a(Class modelClass, MutableCreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return c(modelClass);
        }

        default ViewModel b(ClassReference modelClass, MutableCreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return a(JvmClassMappingKt.a(modelClass), extras);
        }

        default ViewModel c(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
        }
    }

    @Metadata
    public static class NewInstanceFactory implements Factory {

        /* renamed from: a, reason: collision with root package name */
        public static NewInstanceFactory f4947a;

        @Metadata
        public static final class Companion {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel a(Class modelClass, MutableCreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return c(modelClass);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel b(ClassReference modelClass, MutableCreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return a(JvmClassMappingKt.a(modelClass), extras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel c(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return JvmViewModelProviders.a(modelClass);
        }
    }

    @Metadata
    @RestrictTo
    /* loaded from: classes3.dex */
    public static class OnRequeryFactory {
        public void d(ViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory) {
        this(store, factory, CreationExtras.Empty.f4963b);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public final ViewModel a(ClassReference modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(modelClass, "<this>");
        String strK = modelClass.k();
        if (strK == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return this.f4943a.a(modelClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strK));
    }

    @Metadata
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: c, reason: collision with root package name */
        public static AndroidViewModelFactory f4944c;

        /* renamed from: d, reason: collision with root package name */
        public static final ViewModelProvider$AndroidViewModelFactory$Companion$APPLICATION_KEY$1 f4945d = new ViewModelProvider$AndroidViewModelFactory$Companion$APPLICATION_KEY$1();

        /* renamed from: b, reason: collision with root package name */
        public final Application f4946b;

        @Metadata
        public static final class Companion {
        }

        public AndroidViewModelFactory(Application application) {
            this.f4946b = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel a(Class modelClass, MutableCreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (this.f4946b != null) {
                return c(modelClass);
            }
            Application application = (Application) extras.a(f4945d);
            if (application != null) {
                return d(modelClass, application);
            }
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return JvmViewModelProviders.a(modelClass);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel c(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Application application = this.f4946b;
            if (application != null) {
                return d(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public final ViewModel d(Class modelClass, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                return JvmViewModelProviders.a(modelClass);
            }
            try {
                ViewModel viewModel = (ViewModel) modelClass.getConstructor(Application.class).newInstance(application);
                Intrinsics.checkNotNullExpressionValue(viewModel, "{\n                try {\n…          }\n            }");
                return viewModel;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e5);
            }
        }

        public AndroidViewModelFactory() {
            this(null);
        }
    }

    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.f4943a = new ViewModelProviderImpl(store, factory, defaultCreationExtras);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewModelProvider(APayBrowserActivity owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModelStore viewModelStore = owner.getViewModelStore();
        Intrinsics.checkNotNullParameter(owner, "owner");
        Factory defaultViewModelProviderFactory = owner.getDefaultViewModelProviderFactory();
        Intrinsics.checkNotNullParameter(owner, "owner");
        this(viewModelStore, defaultViewModelProviderFactory, owner.getDefaultViewModelCreationExtras());
    }
}
