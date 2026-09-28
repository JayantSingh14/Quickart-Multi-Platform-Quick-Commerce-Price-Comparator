package com.zoontek.rnpermissions;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class RNPermissionsPackage extends TurboReactPackage implements ViewManagerOnDemandReactPackage {

    /* renamed from: com.zoontek.rnpermissions.RNPermissionsPackage$1, reason: invalid class name */
    class AnonymousClass1 implements ReactModuleInfoProvider {
        @Override // com.facebook.react.module.model.ReactModuleInfoProvider
        public final Map a() {
            HashMap map = new HashMap();
            Class cls = new Class[]{RNPermissionsModule.class}[0];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls.getName();
            boolean zCanOverrideExistingModule = reactModule.canOverrideExistingModule();
            boolean zNeedsEagerInit = reactModule.needsEagerInit();
            reactModule.hasConstants();
            map.put(strName, new ReactModuleInfo(strName2, name, zCanOverrideExistingModule, zNeedsEagerInit, reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls), 0));
            return map;
        }
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public final List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new RNPermissionsModule(reactApplicationContext));
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.getClass();
        if (str.equals(RNPermissionsModule.NAME)) {
            return new RNPermissionsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.zoontek.rnpermissions.RNPermissionsPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new AnonymousClass1();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException("No ReactModuleInfoProvider for com.zoontek.rnpermissions.RNPermissionsPackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("No ReactModuleInfoProvider for com.zoontek.rnpermissions.RNPermissionsPackage$$ReactModuleInfoProvider", e);
        }
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public final /* bridge */ /* synthetic */ Collection getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return null;
    }
}
