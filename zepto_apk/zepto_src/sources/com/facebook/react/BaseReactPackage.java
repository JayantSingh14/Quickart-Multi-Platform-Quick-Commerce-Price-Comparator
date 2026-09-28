package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public abstract class BaseReactPackage implements ReactPackage {

    @Metadata
    public final class ModuleHolderProvider implements Provider<NativeModule> {

        /* renamed from: a, reason: collision with root package name */
        public final String f18402a;

        /* renamed from: b, reason: collision with root package name */
        public final ReactApplicationContext f18403b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseReactPackage f18404c;

        public ModuleHolderProvider(BaseReactPackage baseReactPackage, String name, ReactApplicationContext reactContext) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            this.f18404c = baseReactPackage;
            this.f18402a = name;
            this.f18403b = reactContext;
        }

        @Override // javax.inject.Provider
        public final Object get() {
            return this.f18404c.getModule(this.f18402a, this.f18403b);
        }
    }

    @Override // com.facebook.react.ReactPackage
    @NotNull
    public List<NativeModule> createNativeModules(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        throw new UnsupportedOperationException("createNativeModules method is not supported. Use getModule() method instead.");
    }

    @Override // com.facebook.react.ReactPackage
    @NotNull
    public List<ViewManager> createViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<ModuleSpec> viewManagers = getViewManagers(reactContext);
        List<ModuleSpec> list = viewManagers;
        if (list == null || list.isEmpty()) {
            return EmptyList.f53609a;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ModuleSpec> it = viewManagers.iterator();
        while (it.hasNext()) {
            Object obj = it.next().getProvider().get();
            Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.react.uimanager.ViewManager<*, *>");
            arrayList.add((ViewManager) obj);
        }
        return arrayList;
    }

    public abstract NativeModule getModule(String str, ReactApplicationContext reactApplicationContext);

    @NotNull
    public final Iterable<ModuleHolder> getNativeModuleIterator$ReactAndroid_release(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1(getReactModuleInfoProvider().a().entrySet().iterator(), this, reactContext);
    }

    public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

    @NotNull
    public List<ModuleSpec> getViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return EmptyList.f53609a;
    }
}
