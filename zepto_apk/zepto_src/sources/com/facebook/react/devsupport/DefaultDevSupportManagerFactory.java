package com.facebook.react.devsupport;

import android.app.Application;
import android.content.Context;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.runtime.ReactHostImplDevHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DefaultDevSupportManagerFactory implements DevSupportManagerFactory {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerFactory
    public final DevSupportManager a(Application applicationContext, ReactInstanceDevHelper reactInstanceManagerHelper, String str, boolean z, int i2, SurfaceDelegateFactory surfaceDelegateFactory) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
        if (!z) {
            return new ReleaseDevSupportManager();
        }
        try {
            Intrinsics.checkNotNullExpressionValue("com.facebook.react.devsupport.BridgeDevSupportManager", "toString(...)");
            Object objNewInstance = BridgeDevSupportManager.class.getConstructor(Context.class, ReactInstanceDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class, SurfaceDelegateFactory.class, DevLoadingViewManager.class, PausedInDebuggerOverlayManager.class).newInstance(applicationContext, reactInstanceManagerHelper, str, Boolean.TRUE, null, null, Integer.valueOf(i2), null, surfaceDelegateFactory, null, null);
            Intrinsics.d(objNewInstance, "null cannot be cast to non-null type com.facebook.react.devsupport.interfaces.DevSupportManager");
            return (DevSupportManager) objNewInstance;
        } catch (Exception unused) {
            return new PerftestDevSupportManager(applicationContext);
        }
    }

    public final DevSupportManager b(Context applicationContext, ReactHostImplDevHelper reactInstanceManagerHelper, String str, boolean z) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
        return !z ? new ReleaseDevSupportManager() : new BridgelessDevSupportManager(applicationContext, reactInstanceManagerHelper, str);
    }
}
