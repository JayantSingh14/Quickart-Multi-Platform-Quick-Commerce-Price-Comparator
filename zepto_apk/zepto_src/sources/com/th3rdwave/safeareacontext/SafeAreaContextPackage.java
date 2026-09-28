package com.th3rdwave.safeareacontext;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.a;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SafeAreaContextPackage extends BaseReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.I(new SafeAreaProviderManager(), new SafeAreaViewManager());
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.b(name, SafeAreaContextModule.NAME)) {
            return new SafeAreaContextModule(reactContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        HashMap map = new HashMap();
        Class cls = new Class[]{SafeAreaContextModule.class}[0];
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            map.put(strName, new ReactModuleInfo(strName2, name, true, reactModule.needsEagerInit(), reactModule.isCxxModule(), false));
        }
        return new a(map);
    }
}
