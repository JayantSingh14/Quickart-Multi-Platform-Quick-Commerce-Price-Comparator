package com.facebook.react.runtime;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.debug.DevMenuModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import java.util.HashMap;

@Nullsafe
/* loaded from: classes3.dex */
class CoreReactPackage extends BaseReactPackage {

    /* renamed from: a, reason: collision with root package name */
    public final DevSupportManager f19237a;

    /* renamed from: b, reason: collision with root package name */
    public final m f19238b;

    public CoreReactPackage(DevSupportManager devSupportManager, m mVar) {
        this.f19237a = devSupportManager;
        this.f19238b = mVar;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        DevSupportManager devSupportManager;
        str.getClass();
        devSupportManager = this.f19237a;
        switch (str) {
            case "LogBox":
                return new LogBoxModule(reactApplicationContext, devSupportManager);
            case "DevSettings":
                return new DevSettingsModule(reactApplicationContext, devSupportManager);
            case "DeviceInfo":
                return new DeviceInfoModule(reactApplicationContext);
            case "DevMenu":
                return new DevMenuModule(reactApplicationContext, devSupportManager);
            case "DeviceEventManager":
                return new DeviceEventManagerModule(reactApplicationContext, this.f19238b);
            case "PlatformConstants":
                return new AndroidInfoModule(reactApplicationContext);
            case "ExceptionsManager":
                return new ExceptionsManagerModule(devSupportManager);
            case "SourceCode":
                return new SourceCodeModule(reactApplicationContext);
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {AndroidInfoModule.class, DeviceInfoModule.class, SourceCodeModule.class, DevMenuModule.class, DevSettingsModule.class, DeviceEventManagerModule.class, LogBoxModule.class, ExceptionsManagerModule.class};
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < 8; i2++) {
            Class cls = clsArr[i2];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            if (reactModule != null) {
                map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.Companion.a(cls)));
            }
        }
        return new com.facebook.react.a(map);
    }
}
