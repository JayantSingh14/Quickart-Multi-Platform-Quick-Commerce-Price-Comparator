package com.swmansion.reanimated.nativeProxy;

import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.b;
import android.util.Log;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.reanimated.BuildConfig;
import com.swmansion.reanimated.DevMenuUtils;
import com.swmansion.reanimated.NativeProxy;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.reanimated.Utils;
import com.swmansion.reanimated.keyboard.KeyboardAnimationManager;
import com.swmansion.reanimated.keyboard.KeyboardWorkletWrapper;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.sensor.ReanimatedSensorContainer;
import com.swmansion.reanimated.sensor.ReanimatedSensorType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class NativeProxyCommon {
    private final GestureHandlerStateManager gestureHandlerStateManager;
    private final KeyboardAnimationManager keyboardAnimationManager;
    protected final AndroidUIScheduler mAndroidUIScheduler;
    protected final WeakReference<ReactApplicationContext> mContext;
    protected NodesManager mNodesManager;
    private final ReanimatedSensorContainer reanimatedSensorContainer;
    private Long firstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private boolean slowAnimationsEnabled = false;
    private final int ANIMATIONS_DRAG_FACTOR = 10;
    protected String cppVersion = null;

    static {
        SoLoader.m("reanimated");
    }

    public NativeProxyCommon(ReactApplicationContext reactApplicationContext) {
        GestureHandlerStateManager gestureHandlerStateManager = null;
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
        WeakReference<ReactApplicationContext> weakReference = new WeakReference<>(reactApplicationContext);
        this.mContext = weakReference;
        this.reanimatedSensorContainer = new ReanimatedSensorContainer(weakReference);
        this.keyboardAnimationManager = new KeyboardAnimationManager(weakReference);
        addDevMenuOption();
        try {
            gestureHandlerStateManager = (GestureHandlerStateManager) reactApplicationContext.getNativeModule(RNGestureHandlerModule.class);
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = gestureHandlerStateManager;
    }

    private void addDevMenuOption() {
        DevMenuUtils.addDevMenuOption(this.mContext.get(), new DevOptionHandler() { // from class: com.swmansion.reanimated.nativeProxy.a
            @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
            public final void a() {
                this.f46917a.toggleSlowAnimations();
            }
        });
    }

    private Set<String> convertProps(ReadableNativeArray readableNativeArray) {
        HashSet hashSet = new HashSet();
        ArrayList<Object> arrayList = readableNativeArray.toArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hashSet.add((String) arrayList.get(i2));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSlowAnimations() {
        boolean z = this.slowAnimationsEnabled;
        this.slowAnimationsEnabled = !z;
        if (!z) {
            this.firstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
        this.mNodesManager.enableSlowAnimations(this.slowAnimationsEnabled, 10);
    }

    public void checkCppVersion() {
        if (this.cppVersion == null) {
            throw new RuntimeException("[Reanimated] Java side failed to resolve C++ code version. See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#java-side-failed-to-resolve-c-code-version for more information.");
        }
        String reanimatedJavaVersion = getReanimatedJavaVersion();
        if (!this.cppVersion.equals(reanimatedJavaVersion)) {
            throw new RuntimeException(b.r(b.y("[Reanimated] Mismatch between Java code version and C++ code version (", reanimatedJavaVersion, " vs. "), this.cppVersion, " respectively). See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#mismatch-between-java-code-version-and-c-code-version for more information."));
        }
    }

    @DoNotStrip
    public void configureProps(ReadableNativeArray readableNativeArray, ReadableNativeArray readableNativeArray2) {
        this.mNodesManager.configureProps(convertProps(readableNativeArray), convertProps(readableNativeArray2));
    }

    @DoNotStrip
    public void dispatchCommand(int i2, String str, ReadableArray readableArray) {
        this.mNodesManager.dispatchCommand(i2, str, readableArray);
    }

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    @DoNotStrip
    public long getAnimationTimestamp() {
        if (!this.slowAnimationsEnabled) {
            return SystemClock.uptimeMillis();
        }
        return ((SystemClock.uptimeMillis() - this.firstUptime.longValue()) / 10) + this.firstUptime.longValue();
    }

    public abstract HybridData getHybridData();

    @DoNotStrip
    public boolean getIsReducedMotion() {
        String string = Settings.Global.getString(this.mContext.get().getContentResolver(), "transition_animation_scale");
        return (string != null ? Float.parseFloat(string) : 1.0f) == 0.0f;
    }

    @DoNotStrip
    public String getReanimatedJavaVersion() {
        return BuildConfig.REANIMATED_VERSION_JAVA;
    }

    public native void installJSIBindings();

    public void invalidate() {
        this.mAndroidUIScheduler.deactivate();
    }

    @DoNotStrip
    public void maybeFlushUIUpdatesQueue() {
        if (this.mNodesManager.isAnimationRunning()) {
            return;
        }
        this.mNodesManager.performOperations();
    }

    @DoNotStrip
    public float[] measure(int i2) {
        return this.mNodesManager.measure(i2);
    }

    @DoNotStrip
    public String obtainProp(int i2, String str) {
        return this.mNodesManager.obtainProp(i2, str);
    }

    public void prepareLayoutAnimations(LayoutAnimations layoutAnimations) {
        if (Utils.isChromeDebugger) {
            Log.w("[REANIMATED]", "You can not use LayoutAnimation with enabled Chrome Debugger");
            return;
        }
        ReanimatedModule reanimatedModule = (ReanimatedModule) this.mContext.get().getNativeModule(ReanimatedModule.class);
        Objects.requireNonNull(reanimatedModule);
        this.mNodesManager = reanimatedModule.getNodesManager();
        ReanimatedModule reanimatedModule2 = (ReanimatedModule) this.mContext.get().getNativeModule(ReanimatedModule.class);
        Objects.requireNonNull(reanimatedModule2);
        reanimatedModule2.getNodesManager().getAnimationsManager().setNativeMethods(NativeProxy.createNativeMethodsHolder(layoutAnimations));
    }

    @DoNotStrip
    public void registerEventHandler(EventHandler eventHandler) {
        eventHandler.mCustomEventNamesResolver = this.mNodesManager.getEventNameResolver();
        this.mNodesManager.registerEventHandler(eventHandler);
    }

    @DoNotStrip
    public int registerSensor(int i2, int i3, SensorSetter sensorSetter) {
        return this.reanimatedSensorContainer.registerSensor(ReanimatedSensorType.getInstanceById(i2), i3, sensorSetter);
    }

    @DoNotStrip
    public void requestRender(AnimationFrameCallback animationFrameCallback) {
        this.mNodesManager.postOnAnimation(animationFrameCallback);
    }

    @DoNotStrip
    public void scrollTo(int i2, double d2, double d3, boolean z) {
        this.mNodesManager.scrollTo(i2, d2, d3, z);
    }

    @DoNotStrip
    public void setCppVersion(String str) {
        this.cppVersion = str;
    }

    @DoNotStrip
    public void setGestureState(int i2, int i3) {
        GestureHandlerStateManager gestureHandlerStateManager = this.gestureHandlerStateManager;
        if (gestureHandlerStateManager != null) {
            gestureHandlerStateManager.setGestureHandlerState(i2, i3);
        }
    }

    @DoNotStrip
    public int subscribeForKeyboardEvents(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z, boolean z2) {
        return this.keyboardAnimationManager.subscribeForKeyboardUpdates(keyboardWorkletWrapper, z, z2);
    }

    @DoNotStrip
    public void synchronouslyUpdateUIProps(int i2, ReadableMap readableMap) {
        this.mNodesManager.synchronouslyUpdateUIProps(i2, readableMap);
    }

    @DoNotStrip
    public void unregisterSensor(int i2) {
        this.reanimatedSensorContainer.unregisterSensor(i2);
    }

    @DoNotStrip
    public void unsubscribeFromKeyboardEvents(int i2) {
        this.keyboardAnimationManager.unsubscribeFromKeyboardUpdates(i2);
    }

    @DoNotStrip
    public void updateProps(int i2, Map<String, Object> map) {
        this.mNodesManager.updateProps(i2, map);
    }
}
