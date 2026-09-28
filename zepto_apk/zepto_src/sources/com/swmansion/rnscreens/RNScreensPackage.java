package com.swmansion.rnscreens;

import android.util.Log;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RNScreensPackage extends BaseReactPackage {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "reactContext");
        InsetsObserverProxy insetsObserverProxy = InsetsObserverProxy.f46927a;
        Intrinsics.checkNotNullParameter(context, "context");
        if (InsetsObserverProxy.f46931e) {
            Log.w("[RNScreens]", "InsetObserverProxy registers on new context while it has not been invalidated on the old one. Please report this as issue at https://github.com/software-mansion/react-native-screens/issues");
        }
        InsetsObserverProxy.f46931e = true;
        context.addLifecycleEventListener(insetsObserverProxy);
        return CollectionsKt.I(new ScreenContainerViewManager(), new ScreenViewManager(), new ModalScreenViewManager(), new ScreenStackViewManager(), new ScreenStackHeaderConfigViewManager(), new ScreenStackHeaderSubviewManager(), new SearchBarManager(), new ScreenFooterManager(), new ScreenContentWrapperManager());
    }

    @Override // com.facebook.react.BaseReactPackage
    public final NativeModule getModule(String s, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        if (Intrinsics.b(s, "RNSModule")) {
            return new ScreensModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public final ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new cl.json.a(8);
    }
}
