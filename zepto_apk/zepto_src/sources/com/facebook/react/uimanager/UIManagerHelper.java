package com.facebook.react.uimanager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;

@Nullsafe
/* loaded from: classes.dex */
public class UIManagerHelper {
    public static EventDispatcher a(ReactContext reactContext, int i2) {
        if (reactContext.isBridgeless()) {
            boolean z = reactContext instanceof ThemedReactContext;
            Object obj = reactContext;
            if (z) {
                obj = ((ThemedReactContext) reactContext).f19479a;
            }
            return ((EventDispatcherProvider) obj).getEventDispatcher();
        }
        UIManager uIManagerF = f(reactContext, i2, false);
        if (uIManagerF == null) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new ReactNoCrashSoftException(android.support.v4.media.b.f(i2, "Unable to find UIManager for UIManagerType ")));
            return null;
        }
        EventDispatcher eventDispatcher = uIManagerF.getEventDispatcher();
        if (eventDispatcher == null) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new IllegalStateException(android.support.v4.media.b.f(i2, "Cannot get EventDispatcher for UIManagerType ")));
        }
        return eventDispatcher;
    }

    public static EventDispatcher b(ReactContext reactContext, int i2) {
        EventDispatcher eventDispatcherA = a(reactContext, ViewUtil.a(i2));
        if (eventDispatcherA == null) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new IllegalStateException(android.support.v4.media.b.f(i2, "Cannot get EventDispatcher for reactTag ")));
        }
        return eventDispatcherA;
    }

    public static ReactContext c(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static int d(Context context) {
        if (context instanceof ThemedReactContext) {
            return ((ThemedReactContext) context).f19481c;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int e(View view) {
        if (view instanceof ReactRoot) {
            ReactRoot reactRoot = (ReactRoot) view;
            if (reactRoot.getUIManagerType() == 2) {
                return reactRoot.getRootViewTag();
            }
        } else {
            int id = view.getId();
            if (ViewUtil.a(id) != 1) {
                Context context = view.getContext();
                if (!(context instanceof ThemedReactContext) && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                int iD = d(context);
                if (iD == -1) {
                    ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new IllegalStateException(android.support.v4.media.b.g(id, "Fabric View [", "] does not have SurfaceId associated with it")));
                }
                return iD;
            }
        }
        return -1;
    }

    public static UIManager f(ReactContext reactContext, int i2, boolean z) {
        if (reactContext.isBridgeless()) {
            UIManager fabricUIManager = reactContext.getFabricUIManager();
            if (fabricUIManager != null) {
                return fabricUIManager;
            }
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the instance hasn't been initialized yet."));
            return null;
        }
        if (!reactContext.hasCatalystInstance()) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        }
        if (!reactContext.hasActiveReactInstance()) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
            if (z) {
                return null;
            }
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        try {
            return i2 == 2 ? reactContext.getFabricUIManager() : (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
        } catch (IllegalArgumentException unused) {
            ReactSoftExceptionLogger.logSoftException("com.facebook.react.uimanager.UIManagerHelper", new ReactNoCrashSoftException(android.support.v4.media.b.f(i2, "Cannot get UIManager for UIManagerType: ")));
            return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
        }
    }
}
