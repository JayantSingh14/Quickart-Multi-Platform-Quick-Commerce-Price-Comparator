package com.swmansion.reanimated;

import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.runtime.ReactHostImpl;

/* loaded from: classes.dex */
public class DevMenuUtils {
    public static void addDevMenuOption(ReactApplicationContext reactApplicationContext, DevOptionHandler devOptionHandler) {
        if (reactApplicationContext.getApplicationContext() instanceof ReactApplication) {
            DevSupportManager devSupportManagerB = reactApplicationContext.isBridgeless() ? ((ReactHostImpl) ((ReactApplication) reactApplicationContext.getApplicationContext()).b()).b() : ((ReactApplication) reactApplicationContext.getApplicationContext()).a().f().f18463j;
            if (devSupportManagerB == null) {
                throw new RuntimeException("[Reanimated] DevSupportManager is not available");
            }
            devSupportManagerB.n("Toggle slow animations (Reanimated)", devOptionHandler);
        }
    }
}
