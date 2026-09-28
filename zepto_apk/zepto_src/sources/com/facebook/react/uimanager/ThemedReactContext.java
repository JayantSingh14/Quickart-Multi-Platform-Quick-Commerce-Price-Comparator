package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.util.Collection;

/* loaded from: classes.dex */
public class ThemedReactContext extends ReactContext {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f19479a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19480b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19481c;

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, String str, int i2) {
        super(context);
        initializeFromOther(reactApplicationContext);
        this.f19479a = reactApplicationContext;
        this.f19480b = str;
        this.f19481c = i2;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.f19479a.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void destroy() {
        this.f19479a.destroy();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final CatalystInstance getCatalystInstance() {
        return this.f19479a.getCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final Activity getCurrentActivity() {
        return this.f19479a.getCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final UIManager getFabricUIManager() {
        return this.f19479a.getFabricUIManager();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final CallInvokerHolder getJSCallInvokerHolder() {
        return this.f19479a.getJSCallInvokerHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final JavaScriptModule getJSModule(Class cls) {
        return this.f19479a.getJSModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.f19479a.getJavaScriptContextHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final NativeModule getNativeModule(Class cls) {
        return this.f19479a.getNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final Collection getNativeModules() {
        return this.f19479a.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final String getSourceURL() {
        return this.f19479a.getSourceURL();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void handleException(Exception exc) {
        this.f19479a.handleException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasActiveCatalystInstance() {
        return this.f19479a.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasActiveReactInstance() {
        return this.f19479a.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasCatalystInstance() {
        return this.f19479a.hasCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasCurrentActivity() {
        return this.f19479a.hasCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasNativeModule(Class cls) {
        return this.f19479a.hasNativeModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasReactInstance() {
        return this.f19479a.hasReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean isBridgeless() {
        return this.f19479a.isBridgeless();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void registerSegment(int i2, String str, Callback callback) {
        this.f19479a.registerSegment(i2, str, callback);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.f19479a.removeLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final NativeModule getNativeModule(String str) {
        return this.f19479a.getNativeModule(str);
    }
}
