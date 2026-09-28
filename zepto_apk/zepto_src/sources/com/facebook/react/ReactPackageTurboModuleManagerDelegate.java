package com.facebook.react;

import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor;
import com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18494a = 0;
    private final List<ModuleProvider> mModuleProviders;
    private final Map<ModuleProvider, Map<String, ReactModuleInfo>> mPackageModuleInfos;
    private List<ReactPackage> mPackages;
    private ReactApplicationContext mReactContext;
    private final boolean mShouldEnableLegacyModuleInterop;

    public static abstract class Builder {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f18495a;

        /* renamed from: b, reason: collision with root package name */
        public ReactApplicationContext f18496b;

        public final ReactPackageTurboModuleManagerDelegate a() {
            Assertions.d(this.f18496b, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            Assertions.d(this.f18495a, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return b(this.f18496b, this.f18495a);
        }

        public abstract DefaultTurboModuleManagerDelegate b(ReactApplicationContext reactApplicationContext, ArrayList arrayList);

        public final void c(ArrayList arrayList) {
            this.f18495a = new ArrayList(arrayList);
        }

        public final void d(BridgeReactContext bridgeReactContext) {
            this.f18496b = bridgeReactContext;
        }
    }

    public interface ModuleProvider {
        NativeModule getModule(String str);
    }

    public ReactPackageTurboModuleManagerDelegate(final ReactApplicationContext reactApplicationContext, List list, HybridData hybridData) {
        super(hybridData);
        this.mModuleProviders = new ArrayList();
        this.mPackageModuleInfos = new HashMap();
        ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor = ReactNativeFeatureFlags.f18968a;
        this.mShouldEnableLegacyModuleInterop = reactNativeFeatureFlagsAccessor.enableBridgelessArchitecture() && reactNativeFeatureFlagsAccessor.useTurboModuleInterop();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReactPackage reactPackage = (ReactPackage) it.next();
            if (reactPackage instanceof BaseReactPackage) {
                final BaseReactPackage baseReactPackage = (BaseReactPackage) reactPackage;
                ModuleProvider moduleProvider = new ModuleProvider() { // from class: com.facebook.react.i
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        int i2 = ReactPackageTurboModuleManagerDelegate.f18494a;
                        return baseReactPackage.getModule(str, reactApplicationContext);
                    }
                };
                this.mModuleProviders.add(moduleProvider);
                this.mPackageModuleInfos.put(moduleProvider, baseReactPackage.getReactModuleInfoProvider().a());
            } else if (unstable_shouldEnableLegacyModuleInterop() && (reactPackage instanceof LazyReactPackage)) {
                LazyReactPackage lazyReactPackage = (LazyReactPackage) reactPackage;
                List<ModuleSpec> listA = lazyReactPackage.a();
                final HashMap map = new HashMap();
                for (ModuleSpec moduleSpec : listA) {
                    map.put(moduleSpec.getName(), moduleSpec.getProvider());
                }
                final int i2 = 0;
                ModuleProvider moduleProvider2 = new ModuleProvider() { // from class: com.facebook.react.j
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        HashMap map2 = map;
                        switch (i2) {
                            case 0:
                                int i3 = ReactPackageTurboModuleManagerDelegate.f18494a;
                                Provider provider = (Provider) map2.get(str);
                                if (provider != null) {
                                    return (NativeModule) provider.get();
                                }
                                return null;
                            default:
                                return (NativeModule) map2.get(str);
                        }
                    }
                };
                this.mModuleProviders.add(moduleProvider2);
                this.mPackageModuleInfos.put(moduleProvider2, lazyReactPackage.b().a());
            } else if (unstable_shouldEnableLegacyModuleInterop()) {
                List<NativeModule> listCreateNativeModules = reactPackage.createNativeModules(reactApplicationContext);
                final HashMap map2 = new HashMap();
                HashMap map3 = new HashMap();
                for (NativeModule nativeModule : listCreateNativeModules) {
                    Class<?> cls = nativeModule.getClass();
                    ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                    String strName = reactModule != null ? reactModule.name() : nativeModule.getName();
                    map3.put(strName, reactModule != null ? new ReactModuleInfo(strName, cls.getName(), reactModule.canOverrideExistingModule(), true, reactModule.isCxxModule(), ReactModuleInfo.Companion.a(cls)) : new ReactModuleInfo(strName, cls.getName(), nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(cls), ReactModuleInfo.Companion.a(cls)));
                    map2.put(strName, nativeModule);
                }
                final int i3 = 1;
                ModuleProvider moduleProvider3 = new ModuleProvider() { // from class: com.facebook.react.j
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        HashMap map22 = map2;
                        switch (i3) {
                            case 0:
                                int i32 = ReactPackageTurboModuleManagerDelegate.f18494a;
                                Provider provider = (Provider) map22.get(str);
                                if (provider != null) {
                                    return (NativeModule) provider.get();
                                }
                                return null;
                            default:
                                return (NativeModule) map22.get(str);
                        }
                    }
                };
                this.mModuleProviders.add(moduleProvider3);
                this.mPackageModuleInfos.put(moduleProvider3, map3);
            }
        }
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public List<String> getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            for (ReactModuleInfo reactModuleInfo : this.mPackageModuleInfos.get(it.next()).values()) {
                if (reactModuleInfo.f19025f && reactModuleInfo.f19023d) {
                    arrayList.add(reactModuleInfo.f19020a);
                }
            }
        }
        return arrayList;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    @Nullable
    public NativeModule getLegacyModule(String str) {
        if (!unstable_shouldEnableLegacyModuleInterop()) {
            return null;
        }
        NativeModule nativeModule = null;
        for (ModuleProvider moduleProvider : this.mModuleProviders) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(moduleProvider).get(str);
            if (reactModuleInfo != null && !reactModuleInfo.f19025f && (nativeModule == null || reactModuleInfo.f19022c)) {
                NativeModule module = moduleProvider.getModule(str);
                if (module != null) {
                    nativeModule = module;
                }
            }
        }
        if (nativeModule instanceof TurboModule) {
            return null;
        }
        return nativeModule;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    @Nullable
    public TurboModule getModule(String str) {
        Object obj = null;
        for (ModuleProvider moduleProvider : this.mModuleProviders) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(moduleProvider).get(str);
            if (reactModuleInfo != null && reactModuleInfo.f19025f && (obj == null || reactModuleInfo.f19022c)) {
                Object module = moduleProvider.getModule(str);
                if (module != null) {
                    obj = module;
                }
            }
        }
        if (obj instanceof TurboModule) {
            return (TurboModule) obj;
        }
        return null;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isLegacyModuleRegistered(String str) {
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(it.next()).get(str);
            if (reactModuleInfo != null && !reactModuleInfo.f19025f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isModuleRegistered(String str) {
        Iterator<ModuleProvider> it = this.mModuleProviders.iterator();
        while (it.hasNext()) {
            ReactModuleInfo reactModuleInfo = this.mPackageModuleInfos.get(it.next()).get(str);
            if (reactModuleInfo != null && reactModuleInfo.f19025f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return this.mShouldEnableLegacyModuleInterop;
    }
}
