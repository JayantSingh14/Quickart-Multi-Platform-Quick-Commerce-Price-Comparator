package com.swmansion.reanimated;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import androidx.work.impl.c;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.reanimated.layoutReanimation.AnimationsManager;
import com.swmansion.reanimated.nativeProxy.NoopEventHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class NodesManager implements EventDispatcherListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ReaCompatibility compatibility;
    private double lastFrameTimeMs;
    private final AnimationsManager mAnimationManager;
    private int mAnimationsDragFactor;
    private final GuardedFrameCallback mChoreographerCallback;
    private final ReactContext mContext;
    protected final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    private NativeProxy mNativeProxy;
    private Queue<NativeUpdateOperation> mOperationsInBatch;
    private final ReactChoreographer mReactChoreographer;
    private boolean mTryRunBatchUpdatesSynchronously;
    private final UIImplementation mUIImplementation;
    private final UIManager mUIManager;
    public Set<String> nativeProps;
    public Set<String> uiProps;
    private Long mFirstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private boolean mSlowAnimationsEnabled = false;
    private final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    private RCTEventEmitter mCustomEventHandler = new NoopEventHandler();
    private List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    private ConcurrentLinkedQueue<CopiedEvent> mEventQueue = new ConcurrentLinkedQueue<>();

    /* renamed from: com.swmansion.reanimated.NodesManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(int i2, WritableMap writableMap) {
            this.mViewTag = i2;
            this.mNativeProps = writableMap;
        }
    }

    public interface OnAnimationFrame {
        void onAnimationFrame(double d2);
    }

    public NodesManager(ReactContext reactContext) {
        Set<String> set = Collections.EMPTY_SET;
        this.uiProps = set;
        this.nativeProps = set;
        this.mOperationsInBatch = new LinkedList();
        this.mTryRunBatchUpdatesSynchronously = false;
        this.mContext = reactContext;
        UIManager uIManagerF = UIManagerHelper.f(reactContext, 1, true);
        this.mUIManager = uIManagerF;
        this.mUIImplementation = uIManagerF instanceof UIManagerModule ? ((UIManagerModule) uIManagerF).getUIImplementation() : null;
        Objects.requireNonNull(uIManagerF);
        this.mCustomEventNamesResolver = new c(uIManagerF, 5);
        this.mEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.mReactChoreographer = ReactChoreographer.Companion.a();
        this.mChoreographerCallback = new GuardedFrameCallback(reactContext) { // from class: com.swmansion.reanimated.NodesManager.2
            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            public void doFrameGuarded(long j2) {
                NodesManager.this.onAnimationFrame(j2);
            }
        };
        EventDispatcher eventDispatcherA = UIManagerHelper.a(reactContext, 1);
        Objects.requireNonNull(eventDispatcherA);
        eventDispatcherA.e(this);
        this.mAnimationManager = new AnimationsManager(reactContext, uIManagerF);
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
            return;
        }
        if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
            return;
        }
        if (obj instanceof ReadableArray) {
            if (obj instanceof WritableArray) {
                writableMap.putArray(str, (ReadableArray) obj);
                return;
            } else {
                writableMap.putArray(str, copyReadableArray((ReadableArray) obj));
                return;
            }
        }
        if (!(obj instanceof ReadableMap)) {
            throw new IllegalStateException("[Reanimated] Unknown type of animated value.");
        }
        if (obj instanceof WritableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else {
            writableMap.putMap(str, copyReadableMap((ReadableMap) obj));
        }
    }

    private static WritableArray copyReadableArray(ReadableArray readableArray) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            switch (AnonymousClass4.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i2).ordinal()]) {
                case 1:
                    writableArrayCreateArray.pushBoolean(readableArray.getBoolean(i2));
                    break;
                case 2:
                    writableArrayCreateArray.pushString(readableArray.getString(i2));
                    break;
                case 3:
                    writableArrayCreateArray.pushNull();
                    break;
                case 4:
                    writableArrayCreateArray.pushDouble(readableArray.getDouble(i2));
                    break;
                case 5:
                    writableArrayCreateArray.pushMap(copyReadableMap(readableArray.getMap(i2)));
                    break;
                case 6:
                    writableArrayCreateArray.pushArray(copyReadableArray(readableArray.getArray(i2)));
                    break;
                default:
                    throw new IllegalStateException("[Reanimated] Unknown type of ReadableArray.");
            }
        }
        return writableArrayCreateArray;
    }

    private static WritableMap copyReadableMap(ReadableMap readableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.merge(readableMap);
        return writableMapCreateMap;
    }

    private void handleEvent(Event event) {
        event.dispatch(this.mCustomEventHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationFrame(long j2) {
        double dLongValue = j2 / 1000000.0d;
        if (this.mSlowAnimationsEnabled) {
            dLongValue = ((dLongValue - this.mFirstUptime.longValue()) / this.mAnimationsDragFactor) + this.mFirstUptime.longValue();
        }
        if (dLongValue > this.lastFrameTimeMs) {
            this.lastFrameTimeMs = dLongValue;
            while (!this.mEventQueue.isEmpty()) {
                CopiedEvent copiedEventPoll = this.mEventQueue.poll();
                handleEvent(copiedEventPoll.getTargetTag(), copiedEventPoll.getEventName(), copiedEventPoll.getPayload());
            }
            if (!this.mFrameCallbacks.isEmpty()) {
                List<OnAnimationFrame> list = this.mFrameCallbacks;
                this.mFrameCallbacks = new ArrayList(list.size());
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    list.get(i2).onAnimationFrame(dLongValue);
                }
            }
            performOperations();
        }
        this.mCallbackPosted.set(false);
        if (this.mFrameCallbacks.isEmpty() && this.mEventQueue.isEmpty()) {
            return;
        }
        startUpdatingOnAnimationFrame();
    }

    private void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.c(ReactChoreographer.CallbackType.f19070c, this.mChoreographerCallback);
        }
    }

    public void configureProps(Set<String> set, Set<String> set2) {
        this.uiProps = set;
        this.nativeProps = set2;
    }

    public void dispatchCommand(final int i2, final String str, final ReadableArray readableArray) {
        ReactContext reactContext = this.mContext;
        reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext.getExceptionHandler()) { // from class: com.swmansion.reanimated.NodesManager.1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                NodesManager.this.mUIManager.dispatchCommand(i2, str, readableArray);
            }
        });
    }

    public void enableSlowAnimations(boolean z, int i2) {
        this.mSlowAnimationsEnabled = z;
        this.mAnimationsDragFactor = i2;
        if (z) {
            this.mFirstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    public void enqueueUpdateViewOnNativeThread(int i2, WritableMap writableMap, boolean z) {
        if (z) {
            this.mTryRunBatchUpdatesSynchronously = true;
        }
        this.mOperationsInBatch.add(new NativeUpdateOperation(i2, writableMap));
    }

    public AnimationsManager getAnimationsManager() {
        return this.mAnimationManager;
    }

    public UIManagerModule.CustomEventNamesResolver getEventNameResolver() {
        return this.mCustomEventNamesResolver;
    }

    public NativeProxy getNativeProxy() {
        return this.mNativeProxy;
    }

    public void initWithContext(ReactApplicationContext reactApplicationContext, String str) {
        this.mNativeProxy = new NativeProxy(reactApplicationContext, str);
        this.mAnimationManager.setAndroidUIScheduler(getNativeProxy().getAndroidUIScheduler());
        ReaCompatibility reaCompatibility = new ReaCompatibility(reactApplicationContext);
        this.compatibility = reaCompatibility;
        reaCompatibility.registerFabricEventListener(this);
    }

    public void invalidate() {
        AnimationsManager animationsManager = this.mAnimationManager;
        if (animationsManager != null) {
            animationsManager.invalidate();
        }
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.invalidate();
            this.mNativeProxy = null;
        }
    }

    public boolean isAnimationRunning() {
        return this.mCallbackPosted.get();
    }

    public float[] measure(int i2) {
        try {
            return NativeMethodsHelper.measure(this.mUIManager.resolveView(i2));
        } catch (IllegalViewOperationException e2) {
            e2.printStackTrace();
            return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        }
    }

    public String obtainProp(int i2, String str) {
        View viewResolveView;
        try {
            viewResolveView = this.mUIManager.resolveView(i2);
            str.getClass();
            switch (str) {
                case "opacity":
                    return Float.toString(viewResolveView.getAlpha());
                case "height":
                    return Float.toString(PixelUtil.a(viewResolveView.getHeight()));
                case "zIndex":
                    return Float.toString(viewResolveView.getElevation());
                case "top":
                    return Float.toString(PixelUtil.a(viewResolveView.getTop()));
                case "left":
                    return Float.toString(PixelUtil.a(viewResolveView.getLeft()));
                case "width":
                    return Float.toString(PixelUtil.a(viewResolveView.getWidth()));
                case "backgroundColor":
                    Drawable background = viewResolveView.getBackground();
                    try {
                        Integer num = (Integer) background.getClass().getMethod("getColor", null).invoke(background, null);
                        num.intValue();
                        String str2 = String.format("%08x", num);
                        return "#" + str2.substring(2, 8) + str2.substring(0, 2);
                    } catch (Exception unused) {
                        return "Unable to resolve background color";
                    }
                default:
                    throw new IllegalArgumentException(android.support.v4.media.b.D("[Reanimated] Attempted to get unsupported property ", str, " with function `getViewProp`"));
            }
        } catch (Exception unused2) {
            return "[Reanimated] Unable to resolve view";
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(Event event) {
        if (this.mNativeProxy == null) {
            return;
        }
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
            performOperations();
            return;
        }
        if (this.mNativeProxy.isAnyHandlerWaitingForEvent(this.mCustomEventNamesResolver.e(event.getEventName()), event.getViewTag())) {
            this.mEventQueue.offer(new CopiedEvent(event));
        }
        startUpdatingOnAnimationFrame();
    }

    public void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    public void performOperations() {
        if (this.mOperationsInBatch.isEmpty()) {
            return;
        }
        final Queue<NativeUpdateOperation> queue = this.mOperationsInBatch;
        this.mOperationsInBatch = new LinkedList();
        final boolean z = this.mTryRunBatchUpdatesSynchronously;
        this.mTryRunBatchUpdatesSynchronously = false;
        final Semaphore semaphore = new Semaphore(0);
        ReactContext reactContext = this.mContext;
        reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext.getExceptionHandler()) { // from class: com.swmansion.reanimated.NodesManager.3
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                UIViewOperationQueue uIViewOperationQueue = NodesManager.this.mUIImplementation.f19498f;
                boolean z2 = false;
                boolean z3 = uIViewOperationQueue.f19520h.isEmpty() && uIViewOperationQueue.f19519g.isEmpty();
                if (z && z3) {
                    z2 = true;
                }
                if (!z2) {
                    semaphore.release();
                }
                while (!queue.isEmpty()) {
                    NativeUpdateOperation nativeUpdateOperation = (NativeUpdateOperation) queue.remove();
                    ReactShadowNode reactShadowNodeJ = NodesManager.this.mUIImplementation.j(nativeUpdateOperation.mViewTag);
                    if (reactShadowNodeJ != null) {
                        ((UIManagerModule) NodesManager.this.mUIManager).updateView(nativeUpdateOperation.mViewTag, reactShadowNodeJ.s(), nativeUpdateOperation.mNativeProps);
                    }
                }
                if (z3) {
                    NodesManager.this.mUIImplementation.e(-1);
                }
                if (z2) {
                    semaphore.release();
                }
            }
        });
        if (z) {
            try {
                semaphore.tryAcquire(16L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    public void registerEventHandler(RCTEventEmitter rCTEventEmitter) {
        this.mCustomEventHandler = rCTEventEmitter;
    }

    public void scrollTo(int i2, double d2, double d3, boolean z) {
        try {
            NativeMethodsHelper.scrollTo(this.mUIManager.resolveView(i2), d2, d3, z);
        } catch (IllegalViewOperationException e2) {
            e2.printStackTrace();
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        this.mEventEmitter.emit(str, writableMap);
    }

    public void startUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(true)) {
            return;
        }
        this.mReactChoreographer.b(ReactChoreographer.CallbackType.f19070c, this.mChoreographerCallback);
    }

    public void synchronouslyUpdateUIProps(int i2, ReadableMap readableMap) {
        this.compatibility.synchronouslyUpdateUIProps(i2, readableMap);
    }

    public void updateProps(int i2, Map<String, Object> map) {
        try {
            if (this.mUIManager.resolveView(i2) == null) {
                return;
            }
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (this.uiProps.contains(key)) {
                    addProp(javaOnlyMap, key, value);
                    z = true;
                } else if (this.nativeProps.contains(key)) {
                    addProp(writableMapCreateMap2, key, value);
                    z2 = true;
                } else {
                    addProp(writableMapCreateMap, key, value);
                    z3 = true;
                }
            }
            if (i2 != -1) {
                if (z) {
                    UIImplementation uIImplementation = this.mUIImplementation;
                    ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(javaOnlyMap);
                    uIImplementation.getClass();
                    UiThreadUtil.assertOnUiThread();
                    uIImplementation.f19498f.f19514b.updateProperties(i2, reactStylesDiffMap);
                }
                if (z2) {
                    enqueueUpdateViewOnNativeThread(i2, writableMapCreateMap2, true);
                }
                if (z3) {
                    WritableMap writableMapCreateMap3 = Arguments.createMap();
                    writableMapCreateMap3.putInt("viewTag", i2);
                    writableMapCreateMap3.putMap("props", writableMapCreateMap);
                    sendEvent("onReanimatedPropsChange", writableMapCreateMap3);
                }
            }
        } catch (IllegalViewOperationException unused) {
        }
    }

    private void handleEvent(int i2, String str, @Nullable WritableMap writableMap) {
        this.mCustomEventHandler.receiveEvent(i2, str, writableMap);
    }
}
