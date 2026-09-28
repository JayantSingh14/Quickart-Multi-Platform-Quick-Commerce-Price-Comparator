package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Trace;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.NoopPrinter;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.UIViewOperationQueue.ChangeJSResponderOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.ConfigureLayoutAnimationOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.DispatchStringCommandOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.FindTargetForTouchOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.MeasureInWindowOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.MeasureOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.RemoveRootViewOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.SendAccessibilityEvent;
import com.facebook.react.uimanager.UIViewOperationQueue.SetLayoutAnimationEnabledOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UIBlockOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UpdatePropertiesOperation;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherImpl;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.SystraceMessage;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

@ReactModule(name = UIManagerModule.NAME)
/* loaded from: classes.dex */
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG;
    public static final String NAME = "UIManager";
    public static final String TAG = "UIManagerModule";
    private int mBatchId;
    private final Map<String, Object> mCustomDirectEvents;
    private final EventDispatcher mEventDispatcher;
    private final List<UIManagerModuleListener> mListeners;
    private final MemoryTrimCallback mMemoryTrimCallback;
    private final Map<String, Object> mModuleConstants;
    private final UIImplementation mUIImplementation;
    private final CopyOnWriteArrayList<UIManagerListener> mUIManagerListeners;
    private final ViewManagerRegistry mViewManagerRegistry;

    public interface CustomEventNamesResolver {
        String e(String str);
    }

    public static class MemoryTrimCallback implements ComponentCallbacks2 {
        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlin.Lazy] */
        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i2) {
            if (i2 >= 60) {
                ((ClearableSynchronizedPool) YogaNodePool.f19623a.getValue()).c();
            }
        }
    }

    static {
        DebugOverlayTag tag = ReactDebugOverlayTags.f17193d;
        Intrinsics.checkNotNullParameter(tag, "tag");
        DEBUG = false;
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mListeners = new ArrayList();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        this.mBatchId = 0;
        DisplayMetricsHolder.f(reactApplicationContext);
        EventDispatcherImpl eventDispatcherImpl = new EventDispatcherImpl(reactApplicationContext);
        this.mEventDispatcher = eventDispatcherImpl;
        this.mModuleConstants = createConstants(viewManagerResolver);
        this.mCustomDirectEvents = UIManagerModuleConstants.c();
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(viewManagerResolver);
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcherImpl, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    private static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        SystraceMessage.Builder builderA = SystraceMessage.a("CreateUIManagerConstants");
        Boolean bool = Boolean.TRUE;
        builderA.b(bool, "Lazy");
        builderA.c();
        try {
            HashMap mapB = UIManagerModuleConstants.b();
            mapB.put("ViewManagerNames", new ArrayList(viewManagerResolver.a()));
            mapB.put("LazyViewManagersEnabled", bool);
            return mapB;
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public <T extends View> int addRootView(T t) {
        return addRootView(t, null);
    }

    public void addUIBlock(UIBlock uIBlock) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new UIBlockOperation(uIBlock));
    }

    @Override // com.facebook.react.bridge.UIManager
    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.add(uIManagerListener);
    }

    @Deprecated
    public void addUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.add(uIManagerModuleListener);
    }

    @ReactMethod
    public void clearJSResponder() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new ChangeJSResponderOperation(0, 0, true, false));
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new ConfigureLayoutAnimationOperation(readableMap, callback));
    }

    @ReactMethod
    public void createView(int i2, String str, int i3, ReadableMap readableMap) {
        ReactStylesDiffMap reactStylesDiffMap;
        if (DEBUG) {
            String str2 = "(UIManager.createView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            FLog.a("ReactNative", str2);
            NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17193d, str2);
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            synchronized (uIImplementation.f19493a) {
                try {
                    ReactShadowNode reactShadowNodeCreateShadowNodeInstance = uIImplementation.f19497e.a(str).createShadowNodeInstance(uIImplementation.f19495c);
                    ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i3);
                    Assertions.d(reactShadowNodeA, "Root node with tag " + i3 + " doesn't exist");
                    reactShadowNodeCreateShadowNodeInstance.t(i2);
                    reactShadowNodeCreateShadowNodeInstance.E(str);
                    reactShadowNodeCreateShadowNodeInstance.m(reactShadowNodeA.G());
                    reactShadowNodeCreateShadowNodeInstance.n(reactShadowNodeA.M());
                    ShadowNodeRegistry shadowNodeRegistry = uIImplementation.f19496d;
                    shadowNodeRegistry.f19473c.a();
                    shadowNodeRegistry.f19471a.put(reactShadowNodeCreateShadowNodeInstance.G(), reactShadowNodeCreateShadowNodeInstance);
                    if (readableMap != null) {
                        reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                        reactShadowNodeCreateShadowNodeInstance.A(reactStylesDiffMap);
                    } else {
                        reactStylesDiffMap = null;
                    }
                    uIImplementation.f(reactShadowNodeCreateShadowNodeInstance, reactStylesDiffMap);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    @Deprecated
    public void dispatchCommand(int i2, int i3, @Nullable ReadableArray readableArray) {
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.getClass();
        if (uIImplementation.d(i2, "dispatchViewManagerCommand: " + i3)) {
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
            uIViewOperationQueue.getClass();
            uIViewOperationQueue.f19519g.add(uIViewOperationQueue.new DispatchCommandOperation(i2, i3, readableArray));
        }
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i2, Dynamic dynamic, @Nullable ReadableArray readableArray) {
        UIManager uIManagerF = UIManagerHelper.f(getReactApplicationContext(), ViewUtil.a(i2), true);
        if (uIManagerF == null) {
            return;
        }
        if (dynamic.getType() == ReadableType.Number) {
            uIManagerF.dispatchCommand(i2, dynamic.asInt(), readableArray);
        } else if (dynamic.getType() == ReadableType.String) {
            uIManagerF.dispatchCommand(i2, dynamic.asString(), readableArray);
        }
    }

    @ReactMethod
    public void findSubviewIn(int i2, ReadableArray readableArray, Callback callback) {
        UIImplementation uIImplementation = this.mUIImplementation;
        float fRound = Math.round(PixelUtil.b((float) readableArray.getDouble(0)));
        float fRound2 = Math.round(PixelUtil.b((float) readableArray.getDouble(1)));
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new FindTargetForTouchOperation(i2, fRound, fRound2, callback));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @Nullable
    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getConstantsForViewManager(String str) {
        ViewManager viewManagerB;
        ViewManagerRegistry viewManagerRegistry = this.mUIImplementation.f19497e;
        synchronized (viewManagerRegistry) {
            viewManagerB = (ViewManager) viewManagerRegistry.f19601a.get(str);
            if (viewManagerB == null) {
                ViewManagerResolver viewManagerResolver = viewManagerRegistry.f19602b;
                if (viewManagerResolver != null) {
                    viewManagerB = viewManagerResolver.b(str);
                    if (viewManagerB != null) {
                        viewManagerRegistry.f19601a.put(str, viewManagerB);
                    }
                } else {
                    viewManagerB = null;
                }
            }
        }
        if (viewManagerB == null) {
            return null;
        }
        return getConstantsForViewManager(viewManagerB, this.mCustomDirectEvents);
    }

    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.c());
    }

    @Deprecated
    public CustomEventNamesResolver getDirectEventNamesResolver() {
        return new CustomEventNamesResolver() { // from class: com.facebook.react.uimanager.UIManagerModule.1
            @Override // com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver
            public final String e(String str) {
                return UIManagerModule.this.resolveCustomDirectEventName(str);
            }
        };
    }

    @Override // com.facebook.react.bridge.UIManager
    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public Map<String, Long> getPerformanceCounters() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.getClass();
        HashMap map = new HashMap();
        map.put("CommitStartTime", Long.valueOf(uIViewOperationQueue.p));
        map.put("CommitEndTime", Long.valueOf(uIViewOperationQueue.q));
        map.put("LayoutTime", Long.valueOf(uIViewOperationQueue.r));
        map.put("DispatchViewUpdatesTime", Long.valueOf(uIViewOperationQueue.s));
        map.put("RunStartTime", Long.valueOf(uIViewOperationQueue.t));
        map.put("RunEndTime", Long.valueOf(uIViewOperationQueue.u));
        map.put("BatchedExecutionTime", Long.valueOf(uIViewOperationQueue.v));
        map.put("NonBatchedExecutionTime", Long.valueOf(uIViewOperationQueue.w));
        map.put("NativeModulesThreadCpuTime", Long.valueOf(uIViewOperationQueue.x));
        map.put("CreateViewCount", Long.valueOf(uIViewOperationQueue.y));
        map.put("UpdatePropsCount", Long.valueOf(uIViewOperationQueue.z));
        return map;
    }

    @Deprecated
    public UIImplementation getUIImplementation() {
        return this.mUIImplementation;
    }

    @Deprecated
    public ViewManagerRegistry getViewManagerRegistry_DO_NOT_USE() {
        return this.mViewManagerRegistry;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        getReactApplicationContext().registerComponentCallbacks(this.mViewManagerRegistry);
        this.mEventDispatcher.j((RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.mEventDispatcher.c();
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.f19502j = false;
        uIImplementation.f19497e.b();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.unregisterComponentCallbacks(this.mMemoryTrimCallback);
        reactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        ((ClearableSynchronizedPool) YogaNodePool.f19623a.getValue()).c();
        ViewManagerPropertyUpdater.a();
    }

    public void invalidateNodeLayout(int i2) {
        ReactShadowNode reactShadowNodeA = this.mUIImplementation.f19496d.a(i2);
        if (reactShadowNodeA != null) {
            reactShadowNodeA.D();
            this.mUIImplementation.e(-1);
        } else {
            FLog.q("ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i2);
        }
    }

    @ReactMethod
    public void manageChildren(int i2, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        int[] iArr;
        ShadowNodeRegistry shadowNodeRegistry;
        boolean z;
        ReadableArray readableArray6 = readableArray;
        if (DEBUG) {
            String str = "(UIManager.manageChildren) tag: " + i2 + ", moveFrom: " + readableArray6 + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5;
            FLog.a("ReactNative", str);
            NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17193d, str);
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            synchronized (uIImplementation.f19493a) {
                try {
                    ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
                    int size = readableArray6 == null ? 0 : readableArray6.size();
                    int size2 = readableArray3 == null ? 0 : readableArray3.size();
                    int size3 = readableArray5 == null ? 0 : readableArray5.size();
                    if (size != 0 && (readableArray2 == null || size != readableArray2.size())) {
                        Intrinsics.checkNotNullParameter("Size of moveFrom != size of moveTo!", "msg");
                        throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
                    }
                    if (size2 != 0 && (readableArray4 == null || size2 != readableArray4.size())) {
                        Intrinsics.checkNotNullParameter("Size of addChildTags != size of addAtIndices!", "msg");
                        throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
                    }
                    int i3 = size + size2;
                    ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[i3];
                    int i4 = size + size3;
                    int[] iArr2 = new int[i4];
                    int[] iArr3 = new int[i4];
                    int[] iArr4 = new int[size3];
                    if (size > 0) {
                        Assertions.c(readableArray6);
                        Assertions.c(readableArray2);
                        iArr = iArr4;
                        int i5 = 0;
                        while (i5 < size) {
                            int i6 = size;
                            int i7 = readableArray6.getInt(i5);
                            int i8 = reactShadowNodeA.a(i7).f19456a;
                            viewAtIndexArr[i5] = new ViewAtIndex(i8, readableArray2.getInt(i5));
                            iArr2[i5] = i7;
                            iArr3[i5] = i8;
                            i5++;
                            readableArray6 = readableArray;
                            size = i6;
                            i4 = i4;
                        }
                    } else {
                        iArr = iArr4;
                    }
                    int i9 = i4;
                    int i10 = size;
                    if (size2 > 0) {
                        Assertions.c(readableArray3);
                        Assertions.c(readableArray4);
                        for (int i11 = 0; i11 < size2; i11++) {
                            viewAtIndexArr[i10 + i11] = new ViewAtIndex(readableArray3.getInt(i11), readableArray4.getInt(i11));
                        }
                    }
                    if (size3 > 0) {
                        Assertions.c(readableArray5);
                        for (int i12 = 0; i12 < size3; i12++) {
                            int i13 = readableArray5.getInt(i12);
                            int i14 = reactShadowNodeA.a(i13).f19456a;
                            int i15 = i10 + i12;
                            iArr2[i15] = i13;
                            iArr3[i15] = i14;
                            iArr[i12] = i14;
                        }
                    }
                    Arrays.sort(viewAtIndexArr, ViewAtIndex.f19591c);
                    Arrays.sort(iArr2);
                    int i16 = -1;
                    for (int i17 = i9 - 1; i17 >= 0; i17--) {
                        int i18 = iArr2[i17];
                        if (i18 == i16) {
                            throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i2);
                        }
                        reactShadowNodeA.C(i18);
                        i16 = iArr2[i17];
                    }
                    for (int i19 = 0; i19 < i3; i19++) {
                        ViewAtIndex viewAtIndex = viewAtIndexArr[i19];
                        ReactShadowNode reactShadowNodeA2 = uIImplementation.f19496d.a(viewAtIndex.f19592a);
                        if (reactShadowNodeA2 == null) {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.f19592a);
                        }
                        reactShadowNodeA.r(reactShadowNodeA2, viewAtIndex.f19593b);
                    }
                    NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.f19499g;
                    nativeViewHierarchyOptimizer.getClass();
                    int i20 = 0;
                    while (true) {
                        shadowNodeRegistry = nativeViewHierarchyOptimizer.f19415b;
                        int i21 = i9;
                        if (i20 >= i21) {
                            break;
                        }
                        int i22 = iArr3[i20];
                        int i23 = 0;
                        while (true) {
                            if (i23 >= size3) {
                                z = false;
                                break;
                            } else {
                                if (iArr[i23] == i22) {
                                    z = true;
                                    break;
                                }
                                i23++;
                            }
                        }
                        nativeViewHierarchyOptimizer.g(shadowNodeRegistry.a(i22), z);
                        i20++;
                        i9 = i21;
                    }
                    for (int i24 = 0; i24 < i3; i24++) {
                        ViewAtIndex viewAtIndex2 = viewAtIndexArr[i24];
                        nativeViewHierarchyOptimizer.c(reactShadowNodeA, shadowNodeRegistry.a(viewAtIndex2.f19592a), viewAtIndex2.f19593b);
                    }
                    for (int i25 = 0; i25 < size3; i25++) {
                        ReactShadowNode reactShadowNodeA3 = uIImplementation.f19496d.a(iArr[i25]);
                        uIImplementation.i(reactShadowNodeA3);
                        reactShadowNodeA3.dispose();
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public void markActiveTouchForTag(int i2, int i3) {
    }

    @ReactMethod
    public void measure(int i2, Callback callback) {
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
            uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new MeasureOperation(i2, callback));
        }
    }

    @ReactMethod
    public void measureInWindow(int i2, Callback callback) {
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
            uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new MeasureInWindowOperation(i2, callback));
        }
    }

    @ReactMethod
    public void measureLayout(int i2, int i3, Callback callback, Callback callback2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            try {
                uIImplementation.g(i2, i3, uIImplementation.f19500h);
                callback2.invoke(Float.valueOf(PixelUtil.a(uIImplementation.f19500h[0])), Float.valueOf(PixelUtil.a(uIImplementation.f19500h[1])), Float.valueOf(PixelUtil.a(uIImplementation.f19500h[2])), Float.valueOf(PixelUtil.a(uIImplementation.f19500h[3])));
            } catch (IllegalViewOperationException e2) {
                callback.invoke(e2.getMessage());
            }
        }
    }

    public void onBatchComplete() {
        int i2 = this.mBatchId;
        this.mBatchId = i2 + 1;
        SystraceMessage.Builder builderA = SystraceMessage.a("onBatchCompleteUI");
        builderA.a(i2, "BatchId");
        builderA.c();
        Iterator<UIManagerModuleListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().willDispatchViewUpdates(this);
        }
        Iterator<UIManagerListener> it2 = this.mUIManagerListeners.iterator();
        while (it2.hasNext()) {
            it2.next().willDispatchViewUpdates(this);
        }
        try {
            if (this.mUIImplementation.f19498f.f19514b.getRootViewNum() > 0) {
                this.mUIImplementation.e(i2);
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mUIImplementation.getClass();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19524l = false;
        ReactChoreographer.Companion.a().c(ReactChoreographer.CallbackType.f19069b, uIViewOperationQueue.f19517e);
        uIViewOperationQueue.d();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19524l = true;
        ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19069b, uIViewOperationQueue.f19517e);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(0, uIViewOperationQueue.new UIBlockOperation(uIBlock));
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public void profileNextBatch() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.n = true;
        uIViewOperationQueue.p = 0L;
        uIViewOperationQueue.y = 0L;
        uIViewOperationQueue.z = 0L;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int i2, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i2, str, writableMap);
    }

    @ReactMethod
    public void removeRootView(int i2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.f19493a) {
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.f19496d;
            shadowNodeRegistry.f19473c.a();
            if (i2 != -1) {
                SparseBooleanArray sparseBooleanArray = shadowNodeRegistry.f19472b;
                if (!sparseBooleanArray.get(i2)) {
                    throw new IllegalViewOperationException(android.support.v4.media.b.g(i2, "View with tag ", " is not registered as a root view"));
                }
                shadowNodeRegistry.f19471a.remove(i2);
                sparseBooleanArray.delete(i2);
            }
        }
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new RemoveRootViewOperation(i2));
    }

    @Override // com.facebook.react.bridge.UIManager
    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.remove(uIManagerListener);
    }

    @Deprecated
    public void removeUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.remove(uIManagerModuleListener);
    }

    @Override // com.facebook.react.bridge.UIManager
    @Nullable
    @Deprecated
    public String resolveCustomDirectEventName(@Nullable String str) {
        Map map;
        return (str == null || (map = (Map) this.mCustomDirectEvents.get(str)) == null) ? str : (String) map.get("registrationName");
    }

    @Deprecated
    public int resolveRootTagFromReactTag(int i2) {
        if (i2 % 10 != 1) {
            ShadowNodeRegistry shadowNodeRegistry = this.mUIImplementation.f19496d;
            shadowNodeRegistry.f19473c.a();
            if (!shadowNodeRegistry.f19472b.get(i2)) {
                ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(i2);
                if (reactShadowNodeA != null) {
                    return reactShadowNodeA.O();
                }
                FLog.q("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i2);
                return 0;
            }
        }
        return i2;
    }

    @Override // com.facebook.react.bridge.UIManager, com.facebook.react.fabric.interop.UIBlockViewResolver
    public View resolveView(int i2) {
        UiThreadUtil.assertOnUiThread();
        return this.mUIImplementation.f19498f.f19514b.resolveView(i2);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i2, int i3) {
        int iA = ViewUtil.a(i2);
        if (iA != 2) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
            uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new SendAccessibilityEvent(i2, i3));
        } else {
            UIManager uIManagerF = UIManagerHelper.f(getReactApplicationContext(), iA, true);
            if (uIManagerF != null) {
                uIManagerF.sendAccessibilityEvent(i2, i3);
            }
        }
    }

    @ReactMethod
    public void setChildren(int i2, ReadableArray readableArray) {
        if (DEBUG) {
            String str = "(UIManager.setChildren) tag: " + i2 + ", children: " + readableArray;
            FLog.a("ReactNative", str);
            NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17193d, str);
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            synchronized (uIImplementation.f19493a) {
                try {
                    ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
                    for (int i3 = 0; i3 < readableArray.size(); i3++) {
                        ReactShadowNode reactShadowNodeA2 = uIImplementation.f19496d.a(readableArray.getInt(i3));
                        if (reactShadowNodeA2 == null) {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i3));
                        }
                        reactShadowNodeA.r(reactShadowNodeA2, i3);
                    }
                    NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.f19499g;
                    nativeViewHierarchyOptimizer.getClass();
                    for (int i4 = 0; i4 < readableArray.size(); i4++) {
                        nativeViewHierarchyOptimizer.c(reactShadowNodeA, nativeViewHierarchyOptimizer.f19415b.a(readableArray.getInt(i4)), i4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @ReactMethod
    public void setJSResponder(int i2, boolean z) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
        if (reactShadowNodeA == null) {
            return;
        }
        while (reactShadowNodeA.N() == NativeKind.f19405c) {
            reactShadowNodeA = reactShadowNodeA.getParent();
        }
        int iG = reactShadowNodeA.G();
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new ChangeJSResponderOperation(iG, i2, false, z));
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.f19498f;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new SetLayoutAnimationEnabledOperation(z));
    }

    public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mUIImplementation.f19498f.f19523k = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public void setViewLocalData(final int i2, final Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) { // from class: com.facebook.react.uimanager.UIManagerModule.2
            @Override // com.facebook.react.bridge.GuardedRunnable
            public final void runGuarded() {
                UIImplementation uIImplementation = UIManagerModule.this.mUIImplementation;
                ShadowNodeRegistry shadowNodeRegistry = uIImplementation.f19496d;
                int i3 = i2;
                ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(i3);
                if (reactShadowNodeA == null) {
                    FLog.q("ReactNative", "Attempt to set local data for view with unknown tag: " + i3);
                } else {
                    reactShadowNodeA.q(obj);
                    UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
                    if (uIViewOperationQueue.f19520h.isEmpty() && uIViewOperationQueue.f19519g.isEmpty()) {
                        uIImplementation.e(-1);
                    }
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.react.bridge.UIManager
    public void stopSurface(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.react.bridge.UIManager
    public void sweepActiveTouchForTag(int i2, int i3) {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
        uIImplementation.getClass();
        UiThreadUtil.assertOnUiThread();
        uIImplementation.f19498f.f19514b.updateProperties(i2, reactStylesDiffMap);
    }

    public void updateInsetsPadding(int i2, int i3, int i4, int i5, int i6) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        UIImplementation uIImplementation = this.mUIImplementation;
        ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
        if (reactShadowNodeA == null) {
            FLog.q("ReactNative", "Tried to update size of non-existent tag: " + i2);
            return;
        }
        reactShadowNodeA.w(i4, 4);
        reactShadowNodeA.w(i3, 1);
        reactShadowNodeA.w(i6, 5);
        reactShadowNodeA.w(i5, 3);
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
        if (uIViewOperationQueue.f19520h.isEmpty() && uIViewOperationQueue.f19519g.isEmpty()) {
            uIImplementation.e(-1);
        }
    }

    public void updateNodeSize(int i2, int i3, int i4) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        UIImplementation uIImplementation = this.mUIImplementation;
        ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
        if (reactShadowNodeA == null) {
            FLog.q("ReactNative", "Tried to update size of non-existent tag: " + i2);
            return;
        }
        reactShadowNodeA.K(i3);
        reactShadowNodeA.c(i4);
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
        if (uIViewOperationQueue.f19520h.isEmpty() && uIViewOperationQueue.f19519g.isEmpty()) {
            uIImplementation.e(-1);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public void updateRootLayoutSpecs(final int i2, final int i3, final int i4, int i5, int i6) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) { // from class: com.facebook.react.uimanager.UIManagerModule.3
            @Override // com.facebook.react.bridge.GuardedRunnable
            public final void runGuarded() {
                UIManagerModule uIManagerModule = UIManagerModule.this;
                ShadowNodeRegistry shadowNodeRegistry = uIManagerModule.mUIImplementation.f19496d;
                int i7 = i2;
                ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(i7);
                if (reactShadowNodeA == null) {
                    FLog.q("ReactNative", "Tried to update non-existent root tag: " + i7);
                } else {
                    reactShadowNodeA.d(i3, i4);
                }
                uIManagerModule.mUIImplementation.e(-1);
            }
        });
    }

    @ReactMethod
    public void updateView(int i2, String str, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.updateView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            FLog.a("ReactNative", str2);
            NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17193d, str2);
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation.f19502j) {
            uIImplementation.f19497e.a(str);
            ReactShadowNode reactShadowNodeA = uIImplementation.f19496d.a(i2);
            if (reactShadowNodeA == null) {
                throw new IllegalViewOperationException(android.support.v4.media.b.f(i2, "Trying to update non-existent view with tag "));
            }
            if (readableMap != null) {
                ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                reactShadowNodeA.A(reactStylesDiffMap);
                if (reactShadowNodeA.J()) {
                    return;
                }
                NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.f19499g;
                nativeViewHierarchyOptimizer.getClass();
                if (reactShadowNodeA.V() && !NativeViewHierarchyOptimizer.f(reactStylesDiffMap)) {
                    nativeViewHierarchyOptimizer.h(reactShadowNodeA, reactStylesDiffMap);
                } else {
                    if (reactShadowNodeA.V()) {
                        return;
                    }
                    int iG = reactShadowNodeA.G();
                    UIViewOperationQueue uIViewOperationQueue = nativeViewHierarchyOptimizer.f19414a;
                    uIViewOperationQueue.z++;
                    uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new UpdatePropertiesOperation(iG, reactStylesDiffMap));
                }
            }
        }
    }

    @ReactMethod
    @Deprecated
    public void viewIsDescendantOf(int i2, int i3, Callback callback) {
        ShadowNodeRegistry shadowNodeRegistry = this.mUIImplementation.f19496d;
        ReactShadowNode reactShadowNodeA = shadowNodeRegistry.a(i2);
        ReactShadowNode reactShadowNodeA2 = shadowNodeRegistry.a(i3);
        if (reactShadowNodeA == null || reactShadowNodeA2 == null) {
            callback.invoke(Boolean.FALSE);
        } else {
            callback.invoke(Boolean.valueOf(reactShadowNodeA.y(reactShadowNodeA2)));
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int addRootView(T t, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter("UIManagerModule.addRootView", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("UIManagerModule.addRootView"));
        int iA = ReactRootViewTagGenerator.a();
        ThemedReactContext themedReactContext = new ThemedReactContext(getReactApplicationContext(), t.getContext(), ((ReactRoot) t).getSurfaceID(), -1);
        final UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.f19493a) {
            final ReactShadowNodeImpl reactShadowNodeImpl = new ReactShadowNodeImpl();
            if (I18nUtil.b(uIImplementation.f19495c)) {
                reactShadowNodeImpl.u.A();
            }
            reactShadowNodeImpl.f19457b = "Root";
            reactShadowNodeImpl.f19456a = iA;
            reactShadowNodeImpl.f19459d = themedReactContext;
            themedReactContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.uimanager.UIImplementation.1

                /* renamed from: a */
                public final /* synthetic */ ReactShadowNodeImpl f19503a;

                public AnonymousClass1(final ReactShadowNodeImpl reactShadowNodeImpl2) {
                    reactShadowNodeImpl = reactShadowNodeImpl2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ShadowNodeRegistry shadowNodeRegistry = UIImplementation.this.f19496d;
                    shadowNodeRegistry.f19473c.a();
                    ReactShadowNodeImpl reactShadowNodeImpl2 = reactShadowNodeImpl;
                    int i2 = reactShadowNodeImpl2.f19456a;
                    shadowNodeRegistry.f19471a.put(i2, reactShadowNodeImpl2);
                    shadowNodeRegistry.f19472b.put(i2, true);
                }
            });
            uIImplementation.f19498f.f19514b.addRootView(iA, t);
        }
        Trace.endSection();
        return iA;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int i2, int i3, String str, @Nullable WritableMap writableMap) {
        ((RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class)).receiveEvent(i3, str, writableMap);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void dispatchCommand(int i2, String str, @Nullable ReadableArray readableArray) {
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.getClass();
        if (uIImplementation.d(i2, "dispatchViewManagerCommand: " + str)) {
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.f19498f;
            uIViewOperationQueue.getClass();
            uIViewOperationQueue.f19519g.add(uIViewOperationQueue.new DispatchStringCommandOperation(i2, str, readableArray));
        }
    }

    public static Map<String, Object> createConstants(List<ViewManager> list, @Nullable Map<String, Object> map, @Nullable Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        SystraceMessage.Builder builderA = SystraceMessage.a("CreateUIManagerConstants");
        builderA.b(Boolean.FALSE, "Lazy");
        builderA.c();
        try {
            return UIManagerModuleConstantsHelper.a(list, map, map2);
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @Nullable
    public static WritableMap getConstantsForViewManager(ViewManager viewManager, Map<String, Object> map) {
        SystraceMessage.Builder builderA = SystraceMessage.a("UIManagerModule.getConstantsForViewManager");
        builderA.b(viewManager.getName(), "ViewManager");
        builderA.b(Boolean.TRUE, "Lazy");
        builderA.c();
        try {
            return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.b(viewManager, null, map));
        } finally {
            SystraceMessage.b().c();
        }
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mListeners = new ArrayList();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        this.mBatchId = 0;
        DisplayMetricsHolder.f(reactApplicationContext);
        EventDispatcherImpl eventDispatcherImpl = new EventDispatcherImpl(reactApplicationContext);
        this.mEventDispatcher = eventDispatcherImpl;
        HashMap map = new HashMap();
        this.mCustomDirectEvents = map;
        this.mModuleConstants = createConstants(list, null, map);
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(list);
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcherImpl, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }
}
