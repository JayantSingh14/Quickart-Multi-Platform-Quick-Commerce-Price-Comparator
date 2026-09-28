package cl.json;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;

/* loaded from: classes.dex */
public class RNSharePackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("RNShare")) {
            return new RNShare(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new a(0);
    }
}
