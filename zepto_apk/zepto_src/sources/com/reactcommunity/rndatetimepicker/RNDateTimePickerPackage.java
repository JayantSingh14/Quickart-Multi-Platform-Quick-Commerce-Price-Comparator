package com.reactcommunity.rndatetimepicker;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;

/* loaded from: classes.dex */
public class RNDateTimePickerPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(DatePickerModule.NAME)) {
            return new DatePickerModule(reactApplicationContext);
        }
        if (str.equals(TimePickerModule.NAME)) {
            return new TimePickerModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new cl.json.a(3);
    }
}
