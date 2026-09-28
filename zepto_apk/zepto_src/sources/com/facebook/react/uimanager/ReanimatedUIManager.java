package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.zeptoconsumerapp.BuildConfig;
import java.util.List;

@ReactModule(name = UIManagerModule.NAME)
/* loaded from: classes.dex */
public class ReanimatedUIManager extends UIManagerModule {
    public ReanimatedUIManager(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i2) {
        super(reactApplicationContext, list, i2);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public boolean canOverrideExistingModule() {
        return true;
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void clearJSResponder() {
        super.clearJSResponder();
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.configureNextLayoutAnimation(readableMap, callback, callback2);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void createView(int i2, String str, int i3, ReadableMap readableMap) {
        super.createView(i2, str, i3, readableMap);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void dispatchViewManagerCommand(int i2, Dynamic dynamic, @Nullable ReadableArray readableArray) {
        super.dispatchViewManagerCommand(i2, dynamic, readableArray);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void findSubviewIn(int i2, ReadableArray readableArray, Callback callback) {
        super.findSubviewIn(i2, readableArray, callback);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @Nullable
    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getConstantsForViewManager(@Nullable String str) {
        return super.getConstantsForViewManager(str);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getDefaultEventTypes() {
        return super.getDefaultEventTypes();
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void manageChildren(int i2, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        super.manageChildren(i2, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void measure(int i2, Callback callback) {
        super.measure(i2, callback);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void measureInWindow(int i2, Callback callback) {
        super.measureInWindow(i2, callback);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void measureLayout(int i2, int i3, Callback callback, Callback callback2) {
        super.measureLayout(i2, i3, callback, callback2);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule, com.facebook.react.bridge.OnBatchCompleteListener
    public void onBatchComplete() {
        super.onBatchComplete();
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void removeRootView(int i2) {
        super.removeRootView(i2);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule, com.facebook.react.bridge.UIManager
    @ReactMethod
    public void sendAccessibilityEvent(int i2, int i3) {
        super.sendAccessibilityEvent(i2, i3);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void setChildren(int i2, ReadableArray readableArray) {
        super.setChildren(i2, readableArray);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void setJSResponder(int i2, boolean z) {
        super.setJSResponder(i2, z);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        super.setLayoutAnimationEnabledExperimental(z);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    public void updateView(int i2, String str, ReadableMap readableMap) {
        super.updateView(i2, str, readableMap);
    }

    @Override // com.facebook.react.uimanager.UIManagerModule
    @ReactMethod
    @Deprecated
    public void viewIsDescendantOf(int i2, int i3, Callback callback) {
        super.viewIsDescendantOf(i2, i3, callback);
    }
}
