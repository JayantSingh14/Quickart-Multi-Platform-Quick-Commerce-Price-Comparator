package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DebugCorePackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f18412a;

    /* renamed from: com.facebook.react.DebugCorePackage$1, reason: invalid class name */
    class AnonymousClass1 implements ReactModuleInfoProvider {
        @Override // com.facebook.react.module.model.ReactModuleInfoProvider
        public final Map a() {
            return Collections.EMPTY_MAP;
        }
    }

    public final Map c() {
        if (this.f18412a == null) {
            HashMap map = new HashMap();
            map.put(DebuggingOverlayManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new b(0)));
            this.f18412a = map;
        }
        return this.f18412a;
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ModuleSpec moduleSpec = (ModuleSpec) ((HashMap) c()).get(str);
        if (moduleSpec != null) {
            return (ViewManager) moduleSpec.getProvider().get();
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new AnonymousClass1();
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final Collection getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return ((HashMap) c()).keySet();
    }

    @Override // com.facebook.react.BaseReactPackage
    public final List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(((HashMap) c()).values());
    }
}
