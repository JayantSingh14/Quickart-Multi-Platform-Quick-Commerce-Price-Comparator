package com.facebook.react;

import android.os.Trace;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevMenuModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerResolver;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
class CoreModulesPackage extends BaseReactPackage implements ReactPackageLogger {

    /* renamed from: a, reason: collision with root package name */
    public final ReactInstanceManager f18409a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultHardwareBackBtnHandler f18410b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18411c;

    /* renamed from: com.facebook.react.CoreModulesPackage$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements ViewManagerResolver {
        @Override // com.facebook.react.uimanager.ViewManagerResolver
        public final Collection a() {
            throw null;
        }

        @Override // com.facebook.react.uimanager.ViewManagerResolver
        public final ViewManager b(String str) {
            throw null;
        }
    }

    public CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, int i2) {
        this.f18409a = reactInstanceManager;
        this.f18410b = defaultHardwareBackBtnHandler;
        this.f18411c = i2;
    }

    @Override // com.facebook.react.ReactPackageLogger
    public final void a() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    @Override // com.facebook.react.ReactPackageLogger
    public final void b() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        ReactInstanceManager reactInstanceManager;
        str.getClass();
        reactInstanceManager = this.f18409a;
        switch (str) {
            case "LogBox":
                return new LogBoxModule(reactApplicationContext, reactInstanceManager.f18463j);
            case "Timing":
                return new TimingModule(reactApplicationContext, reactInstanceManager.f18463j);
            case "DevSettings":
                return new DevSettingsModule(reactApplicationContext, reactInstanceManager.f18463j);
            case "DeviceInfo":
                return new DeviceInfoModule(reactApplicationContext);
            case "DevMenu":
                return new DevMenuModule(reactApplicationContext, reactInstanceManager.f18463j);
            case "DeviceEventManager":
                return new DeviceEventManagerModule(reactApplicationContext, this.f18410b);
            case "PlatformConstants":
                return new AndroidInfoModule(reactApplicationContext);
            case "ExceptionsManager":
                return new ExceptionsManagerModule(reactInstanceManager.f18463j);
            case "SourceCode":
                return new SourceCodeModule(reactApplicationContext);
            case "HeadlessJsTaskSupport":
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            case "UIManager":
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
                Intrinsics.checkNotNullParameter("createUIManagerModule", "sectionName");
                Trace.beginSection(androidx.tracing.Trace.g("createUIManagerModule"));
                try {
                    return new UIManagerModule(reactApplicationContext, (List<ViewManager>) reactInstanceManager.g(reactApplicationContext), this.f18411c);
                } finally {
                    Trace.endSection();
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
                }
            default:
                throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for ".concat(str));
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevMenuModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class};
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < 11; i2++) {
            Class cls = clsArr[i2];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.Companion.a(cls)));
        }
        return new a(map);
    }
}
