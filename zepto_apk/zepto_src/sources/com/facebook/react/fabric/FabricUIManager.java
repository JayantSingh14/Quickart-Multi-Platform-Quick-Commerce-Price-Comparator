package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.fabric.DevToolsReactPerfLogger;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.internal.interop.InteropUIBlockListener;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountItemDispatcher;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItemFactory;
import com.facebook.react.interfaces.fabric.SurfaceHandler;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor;
import com.facebook.react.internal.interop.InteropEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.BatchEventDispatchedListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.FabricEventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.SynchronousEventReceiver;
import com.facebook.react.views.text.FontMetricsUtil;
import com.facebook.react.views.text.TextLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

@DoNotStripAny
@SuppressLint({"MissingNativeLoadLibrary"})
/* loaded from: classes3.dex */
public class FabricUIManager implements UIManager, LifecycleEventListener, UIBlockViewResolver, SynchronousEventReceiver {
    private static final DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener FABRIC_PERF_LOGGER = new a();
    public static final boolean IS_DEVELOPMENT_ENVIRONMENT = false;
    public static final String TAG = "FabricUIManager";

    @NonNull
    private final BatchEventDispatchedListener mBatchEventDispatchedListener;

    @Nullable
    private FabricUIManagerBinding mBinding;
    public DevToolsReactPerfLogger mDevToolsReactPerfLogger;

    @NonNull
    @ThreadConfined
    private final DispatchUIFrameCallback mDispatchUIFrameCallback;

    @NonNull
    private final EventDispatcher mEventDispatcher;

    @Nullable
    private InteropUIBlockListener mInteropUIBlockListener;

    @NonNull
    private final MountItemDispatcher mMountItemDispatcher;
    private final MountingManager.MountItemExecutor mMountItemExecutor;

    @NonNull
    private final MountingManager mMountingManager;

    @NonNull
    private final ReactApplicationContext mReactApplicationContext;

    @NonNull
    private final ViewManagerRegistry mViewManagerRegistry;

    @NonNull
    private final CopyOnWriteArrayList<UIManagerListener> mListeners = new CopyOnWriteArrayList<>();
    private boolean mMountNotificationScheduled = false;
    private List<Integer> mSurfaceIdsWithPendingMountNotification = new ArrayList();
    private final Set<SynchronousEvent> mSynchronousEvents = new HashSet();
    private volatile boolean mDestroyed = false;
    private boolean mDriveCxxAnimations = false;
    private long mDispatchViewUpdatesTime = 0;
    private long mCommitStartTime = 0;
    private long mLayoutTime = 0;
    private long mFinishTransactionTime = 0;
    private long mFinishTransactionCPPTime = 0;
    private int mCurrentSynchronousCommitNumber = 10000;

    public class DispatchUIFrameCallback extends GuardedFrameCallback {
        private volatile boolean mIsMountingEnabled;

        @ThreadConfined
        private boolean mIsScheduled;

        @ThreadConfined
        private boolean mShouldSchedule;

        public /* synthetic */ DispatchUIFrameCallback(FabricUIManager fabricUIManager, ReactApplicationContext reactApplicationContext) {
            this((ReactContext) reactApplicationContext);
        }

        @ThreadConfined
        @UiThread
        private void schedule() {
            if (this.mIsScheduled || !this.mShouldSchedule) {
                return;
            }
            this.mIsScheduled = true;
            ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19069b, this);
        }

        @Override // com.facebook.react.uimanager.GuardedFrameCallback
        @ThreadConfined
        @UiThread
        public void doFrameGuarded(long j2) {
            this.mIsScheduled = false;
            if (!this.mIsMountingEnabled) {
                FLog.q(FabricUIManager.TAG, "Not flushing pending UI operations: exception was previously thrown");
                return;
            }
            if (FabricUIManager.this.mDestroyed) {
                FLog.q(FabricUIManager.TAG, "Not flushing pending UI operations: FabricUIManager is destroyed");
                return;
            }
            if (FabricUIManager.this.mDriveCxxAnimations && FabricUIManager.this.mBinding != null) {
                FabricUIManager.this.mBinding.driveCxxAnimations();
            }
            if (ReactNativeFeatureFlags.f18968a.useOptimisedViewPreallocationOnAndroid() && FabricUIManager.this.mBinding != null) {
                FabricUIManager.this.mBinding.drainPreallocateViewsQueue();
            }
            try {
                try {
                    FabricUIManager.this.mMountItemDispatcher.dispatchPreMountItems(j2);
                    FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                    schedule();
                    FabricUIManager.this.mSynchronousEvents.clear();
                } catch (Exception e2) {
                    FLog.h(FabricUIManager.TAG, "Exception thrown when executing UIFrameGuarded", e2);
                    this.mIsMountingEnabled = false;
                    throw e2;
                }
            } catch (Throwable th) {
                schedule();
                throw th;
            }
        }

        @ThreadConfined
        @UiThread
        public void pause() {
            ReactChoreographer.Companion.a().c(ReactChoreographer.CallbackType.f19069b, this);
            this.mShouldSchedule = false;
            this.mIsScheduled = false;
        }

        @ThreadConfined
        @UiThread
        public void resume() {
            this.mShouldSchedule = true;
            schedule();
        }

        private DispatchUIFrameCallback(@NonNull ReactContext reactContext) {
            super(reactContext);
            this.mIsMountingEnabled = true;
            this.mShouldSchedule = false;
            this.mIsScheduled = false;
        }
    }

    public class MountItemDispatchListener implements MountItemDispatcher.ItemDispatchListener {
        public /* synthetic */ MountItemDispatchListener(FabricUIManager fabricUIManager, int i2) {
            this();
        }

        @Override // com.facebook.react.fabric.mounting.MountItemDispatcher.ItemDispatchListener
        public void didDispatchMountItems() {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).didDispatchMountItems(FabricUIManager.this);
            }
        }

        @Override // com.facebook.react.fabric.mounting.MountItemDispatcher.ItemDispatchListener
        @ThreadConfined
        @UiThread
        public void didMountItems(@Nullable List<MountItem> list) {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).didMountItems(FabricUIManager.this);
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            for (MountItem mountItem : list) {
                if (mountItem != null && !FabricUIManager.this.mSurfaceIdsWithPendingMountNotification.contains(Integer.valueOf(mountItem.getSurfaceId()))) {
                    FabricUIManager.this.mSurfaceIdsWithPendingMountNotification.add(Integer.valueOf(mountItem.getSurfaceId()));
                }
            }
            if (FabricUIManager.this.mMountNotificationScheduled || FabricUIManager.this.mSurfaceIdsWithPendingMountNotification.isEmpty()) {
                return;
            }
            FabricUIManager.this.mMountNotificationScheduled = true;
            UiThreadUtil.getUiThreadHandler().postAtFrontOfQueue(new Runnable() { // from class: com.facebook.react.fabric.FabricUIManager.MountItemDispatchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    FabricUIManager.this.mMountNotificationScheduled = false;
                    List list2 = FabricUIManager.this.mSurfaceIdsWithPendingMountNotification;
                    FabricUIManager.this.mSurfaceIdsWithPendingMountNotification = new ArrayList();
                    FabricUIManagerBinding fabricUIManagerBinding = FabricUIManager.this.mBinding;
                    if (fabricUIManagerBinding == null || FabricUIManager.this.mDestroyed) {
                        return;
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        fabricUIManagerBinding.reportMount(((Integer) it2.next()).intValue());
                    }
                }
            });
        }

        @Override // com.facebook.react.fabric.mounting.MountItemDispatcher.ItemDispatchListener
        @ThreadConfined
        @UiThread
        public void willMountItems(@Nullable List<MountItem> list) {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).willMountItems(FabricUIManager.this);
            }
        }

        private MountItemDispatchListener() {
        }
    }

    static {
        FabricSoLoader.staticInit();
    }

    public FabricUIManager(@NonNull ReactApplicationContext reactApplicationContext, @NonNull ViewManagerRegistry viewManagerRegistry, @NonNull BatchEventDispatchedListener batchEventDispatchedListener) {
        MountingManager.MountItemExecutor mountItemExecutor = new MountingManager.MountItemExecutor() { // from class: com.facebook.react.fabric.FabricUIManager.1
            @Override // com.facebook.react.fabric.mounting.MountingManager.MountItemExecutor
            public void executeItems(Queue<MountItem> queue) {
                FabricUIManager.this.mMountItemDispatcher.dispatchMountItems(queue);
            }
        };
        this.mMountItemExecutor = mountItemExecutor;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(this, reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(viewManagerRegistry, mountItemExecutor);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener(this, 0));
        this.mEventDispatcher = new FabricEventDispatcher(reactApplicationContext);
        this.mBatchEventDispatchedListener = batchEventDispatchedListener;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mViewManagerRegistry = viewManagerRegistry;
        reactApplicationContext.registerComponentCallbacks(viewManagerRegistry);
    }

    @AnyThread
    @ThreadConfined
    private MountItem createIntBufferBatchMountItem(int i2, @Nullable int[] iArr, @Nullable Object[] objArr, int i3) {
        if (iArr == null) {
            iArr = new int[0];
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        return MountItemFactory.createIntBufferBatchMountItem(i2, iArr, objArr, i3);
    }

    @AnyThread
    @ThreadConfined
    private void destroyUnmountedView(int i2, int i3) {
        this.mMountItemDispatcher.addMountItem(MountItemFactory.createDestroyViewMountItem(i2, i3));
    }

    @NonNull
    private InteropUIBlockListener getInteropUIBlockListener() {
        if (this.mInteropUIBlockListener == null) {
            InteropUIBlockListener interopUIBlockListener = new InteropUIBlockListener();
            this.mInteropUIBlockListener = interopUIBlockListener;
            addUIManagerEventListener(interopUIBlockListener);
        }
        return this.mInteropUIBlockListener;
    }

    @AnyThread
    @ThreadConfined
    @SuppressLint({"NotInvokedPrivateMethod"})
    private boolean isOnMainThread() {
        return UiThreadUtil.isOnUiThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$static$0(DevToolsReactPerfLogger.FabricCommitPoint fabricCommitPoint) {
        long commitDuration = fabricCommitPoint.getCommitDuration();
        long layoutDuration = fabricCommitPoint.getLayoutDuration();
        long diffDuration = fabricCommitPoint.getDiffDuration();
        long transactionEndDuration = fabricCommitPoint.getTransactionEndDuration();
        long batchExecutionDuration = fabricCommitPoint.getBatchExecutionDuration();
        LongStreamingStats longStreamingStats = DevToolsReactPerfLogger.mStreamingCommitStats;
        longStreamingStats.add(commitDuration);
        LongStreamingStats longStreamingStats2 = DevToolsReactPerfLogger.mStreamingLayoutStats;
        longStreamingStats2.add(layoutDuration);
        LongStreamingStats longStreamingStats3 = DevToolsReactPerfLogger.mStreamingDiffStats;
        longStreamingStats3.add(diffDuration);
        LongStreamingStats longStreamingStats4 = DevToolsReactPerfLogger.mStreamingTransactionEndStats;
        longStreamingStats4.add(transactionEndDuration);
        LongStreamingStats longStreamingStats5 = DevToolsReactPerfLogger.mStreamingBatchExecutionStats;
        longStreamingStats5.add(batchExecutionDuration);
        String str = TAG;
        Object[] objArr = {Long.valueOf(fabricCommitPoint.getCommitNumber()), Long.valueOf(commitDuration), Double.valueOf(longStreamingStats.getAverage()), Double.valueOf(longStreamingStats.getMedian()), Long.valueOf(longStreamingStats.getMax()), Long.valueOf(layoutDuration), Double.valueOf(longStreamingStats2.getAverage()), Double.valueOf(longStreamingStats2.getMedian()), Long.valueOf(longStreamingStats2.getMax()), Long.valueOf(diffDuration), Double.valueOf(longStreamingStats3.getAverage()), Double.valueOf(longStreamingStats3.getMedian()), Long.valueOf(longStreamingStats3.getMax()), Long.valueOf(transactionEndDuration), Double.valueOf(longStreamingStats4.getAverage()), Double.valueOf(longStreamingStats4.getMedian()), Long.valueOf(longStreamingStats4.getMax()), Long.valueOf(batchExecutionDuration), Double.valueOf(longStreamingStats5.getAverage()), Double.valueOf(longStreamingStats5.getMedian()), Long.valueOf(longStreamingStats5.getMax())};
        if (FLog.f17086a.a(4)) {
            FLogDefaultLoggingDelegate.b(4, str, String.format(null, "Statistics of Fabric commit #%d:\n - Total commit time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Layout time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Diffing time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - FinishTransaction (Diffing + JNI serialization): %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Mounting: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n", objArr));
        }
    }

    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5) {
        return measure(i2, str, readableMap, readableMap2, readableMap3, f2, f3, f4, f5, null);
    }

    private NativeArray measureLines(ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, float f2, float f3) {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        Layout layoutB = TextLayoutManager.b(reactApplicationContext, readableMapBuffer, readableMapBuffer2, PixelUtil.b(f2), PixelUtil.b(f3), null);
        CharSequence text = layoutB.getText();
        TextPaint textPaint = (TextPaint) TextLayoutManager.f20135a.get();
        textPaint.getClass();
        return (NativeArray) FontMetricsUtil.a(text, layoutB, textPaint, reactApplicationContext);
    }

    private long measureMapBuffer(int i2, String str, ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, @Nullable ReadableMapBuffer readableMapBuffer3, float f2, float f3, float f4, float f5, @Nullable float[] fArr) {
        ReactContext context;
        if (i2 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i2, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0L;
            }
            context = surfaceManagerEnforced.getContext();
        } else {
            context = this.mReactApplicationContext;
        }
        return this.mMountingManager.measureMapBuffer(context, str, readableMapBuffer, readableMapBuffer2, readableMapBuffer3, LayoutMetricsConversions.getYogaSize(f2, f3), LayoutMetricsConversions.getYogaMeasureMode(f2, f3), LayoutMetricsConversions.getYogaSize(f4, f5), LayoutMetricsConversions.getYogaMeasureMode(f4, f5), fArr);
    }

    @AnyThread
    @ThreadConfined
    private void preallocateView(int i2, int i3, String str, @Nullable Object obj, @Nullable Object obj2, boolean z) {
        this.mMountItemDispatcher.addPreAllocateMountItem(MountItemFactory.createPreAllocateViewMountItem(i2, i3, str, (ReadableMap) obj, (StateWrapper) obj2, z));
    }

    @AnyThread
    @ThreadConfined
    private void scheduleMountItem(@Nullable MountItem mountItem, int i2, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = mountItem instanceof BatchMountItem;
        boolean z2 = (z && !((BatchMountItem) mountItem).isBatchEmpty()) || !(z || mountItem == null);
        Iterator<UIManagerListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().didScheduleMountItems(this);
        }
        if (z) {
            this.mCommitStartTime = j2;
            this.mLayoutTime = j6 - j5;
            this.mFinishTransactionCPPTime = j8 - j7;
            this.mFinishTransactionTime = jUptimeMillis - j7;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        if (z2) {
            this.mMountItemDispatcher.addMountItem(mountItem);
            GuardedRunnable guardedRunnable = new GuardedRunnable(this.mReactApplicationContext) { // from class: com.facebook.react.fabric.FabricUIManager.3
                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                guardedRunnable.run();
            }
        }
        if (z) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, null, i2, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, null, i2, j7);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, null, i2, j8);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, null, i2, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, null, i2, j4);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, null, i2, j5);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, null, i2, j6);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_AFFECTED_NODES, null, i2, j6, i3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, null, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.bridge.UIManager
    @ThreadConfined
    @UiThread
    @Deprecated
    public <T extends View> int addRootView(T t, WritableMap writableMap) {
        String str = TAG;
        Intrinsics.checkNotNullParameter("Do not call addRootView in Fabric; it is unsupported. Call startSurface instead.", "msg");
        ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Do not call addRootView in Fabric; it is unsupported. Call startSurface instead."));
        ReactRoot reactRoot = (ReactRoot) t;
        int rootViewTag = reactRoot.getRootViewTag();
        this.mMountingManager.startSurface(rootViewTag, new ThemedReactContext(this.mReactApplicationContext, t.getContext(), reactRoot.getSurfaceID(), rootViewTag), t);
        String jSModuleName = reactRoot.getJSModuleName();
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.d(str, "Starting surface for module: %s and reactTag: %d", jSModuleName, Integer.valueOf(rootViewTag));
        }
        this.mBinding.startSurface(rootViewTag, jSModuleName, (NativeMap) writableMap);
        return rootViewTag;
    }

    public void addUIBlock(UIBlock uIBlock) {
        if (ReactNativeFeatureFlags.f18968a.useFabricInterop()) {
            getInteropUIBlockListener().addUIBlock(uIBlock);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.add(uIManagerListener);
    }

    public void attachRootView(SurfaceHandler surfaceHandler, View view) {
        this.mMountingManager.attachRootView(surfaceHandler.getSurfaceId(), view, new ThemedReactContext(this.mReactApplicationContext, view.getContext(), surfaceHandler.getModuleName(), surfaceHandler.getSurfaceId()));
        surfaceHandler.setMountable(true);
    }

    public void clearJSResponder() {
        this.mMountItemDispatcher.addMountItem(new MountItem() { // from class: com.facebook.react.fabric.FabricUIManager.5
            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public void execute(@NonNull MountingManager mountingManager) {
                mountingManager.clearJSResponder();
            }

            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public int getSurfaceId() {
                return -1;
            }

            @NonNull
            public String toString() {
                return "CLEAR_JS_RESPONDER";
            }
        });
    }

    public DispatchCommandMountItem createDispatchCommandMountItemForInterop(int i2, int i3, String str, @Nullable ReadableArray readableArray) {
        try {
            return MountItemFactory.createDispatchCommandMountItem(i2, i3, Integer.parseInt(str), readableArray);
        } catch (NumberFormatException unused) {
            return MountItemFactory.createDispatchCommandMountItem(i2, i3, str, readableArray);
        }
    }

    @AnyThread
    @ThreadConfined
    public void dispatchCommand(int i2, int i3, String str, @Nullable ReadableArray readableArray) {
        if (ReactNativeFeatureFlags.f18968a.useFabricInterop()) {
            this.mMountItemDispatcher.addViewCommandMountItem(createDispatchCommandMountItemForInterop(i2, i3, str, readableArray));
        } else {
            this.mMountItemDispatcher.addViewCommandMountItem(MountItemFactory.createDispatchCommandMountItem(i2, i3, str, readableArray));
        }
    }

    @UnstableReactNativeAPI
    public void experimental_prefetchResource(String str, int i2, int i3, ReadableMapBuffer readableMapBuffer) {
        this.mMountingManager.experimental_prefetchResource(this.mReactApplicationContext, str, i2, i3, readableMapBuffer);
    }

    public int getColor(int i2, String[] strArr) {
        ThemedReactContext context = this.mMountingManager.getSurfaceManagerEnforced(i2, "getColor").getContext();
        if (context == null) {
            return 0;
        }
        for (String str : strArr) {
            Integer numResolveResourcePath = ColorPropConverter.resolveResourcePath(context, str);
            if (numResolveResourcePath != null) {
                return numResolveResourcePath.intValue();
            }
        }
        return 0;
    }

    @Override // com.facebook.react.bridge.UIManager
    @NonNull
    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public Map<String, Long> getPerformanceCounters() {
        HashMap map = new HashMap();
        map.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        map.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        map.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        map.put("RunStartTime", Long.valueOf(this.mMountItemDispatcher.getRunStartTime()));
        map.put("BatchedExecutionTime", Long.valueOf(this.mMountItemDispatcher.getBatchedExecutionTime()));
        map.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        map.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return map;
    }

    public boolean getThemeData(int i2, float[] fArr) {
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i2);
        ThemedReactContext context = surfaceManager != null ? surfaceManager.getContext() : null;
        if (context == null) {
            FLog.s(TAG, "Couldn't get context for surfaceId %d in getThemeData", Integer.valueOf(i2));
            return false;
        }
        EditText editText = new EditText(context);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        float[] fArr2 = {PixelUtil.a(editText.getPaddingStart()), PixelUtil.a(editText.getPaddingEnd()), PixelUtil.a(editText.getPaddingTop()), PixelUtil.a(editText.getPaddingBottom())};
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[3];
        return true;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void initialize() {
        this.mEventDispatcher.i(new FabricEventEmitter(this));
        this.mEventDispatcher.b(this.mBatchEventDispatchedListener);
        ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor = ReactNativeFeatureFlags.f18968a;
        if (reactNativeFeatureFlagsAccessor.enableFabricLogs()) {
            DevToolsReactPerfLogger devToolsReactPerfLogger = new DevToolsReactPerfLogger();
            this.mDevToolsReactPerfLogger = devToolsReactPerfLogger;
            devToolsReactPerfLogger.addDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.addFabricListener(this.mDevToolsReactPerfLogger);
        }
        if (reactNativeFeatureFlagsAccessor.useFabricInterop()) {
            this.mReactApplicationContext.internal_registerInteropModule(RCTEventEmitter.class, new InteropEventEmitter(this.mReactApplicationContext));
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    public void invalidate() {
        String str = TAG;
        if (FLog.f17086a.a(4)) {
            FLogDefaultLoggingDelegate.b(4, str, "FabricUIManager.invalidate");
        }
        DevToolsReactPerfLogger devToolsReactPerfLogger = this.mDevToolsReactPerfLogger;
        if (devToolsReactPerfLogger != null) {
            devToolsReactPerfLogger.removeDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.removeFabricListener(this.mDevToolsReactPerfLogger);
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot double-destroy FabricUIManager"));
            return;
        }
        this.mDestroyed = true;
        this.mEventDispatcher.h(this.mBatchEventDispatchedListener);
        this.mEventDispatcher.f();
        this.mReactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        this.mViewManagerRegistry.b();
        this.mReactApplicationContext.removeLifecycleEventListener(this);
        onHostPause();
        this.mBinding.unregister();
        this.mBinding = null;
        ViewManagerPropertyUpdater.a();
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            return;
        }
        this.mEventDispatcher.c();
    }

    @Override // com.facebook.react.bridge.UIManager
    public void markActiveTouchForTag(int i2, int i3) {
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i2);
        if (surfaceManager != null) {
            surfaceManager.markActiveTouchForTag(i3);
        }
    }

    @AnyThread
    public void onAllAnimationsComplete() {
        this.mDriveCxxAnimations = false;
    }

    @AnyThread
    public void onAnimationStarted() {
        this.mDriveCxxAnimations = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.mDispatchUIFrameCallback.pause();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mDispatchUIFrameCallback.resume();
    }

    public void onRequestEventBeat() {
        this.mEventDispatcher.a();
    }

    public void prependUIBlock(UIBlock uIBlock) {
        if (ReactNativeFeatureFlags.f18968a.useFabricInterop()) {
            getInteropUIBlockListener().prependUIBlock(uIBlock);
        }
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public void profileNextBatch() {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int i2, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i2, str, false, writableMap, 2);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.remove(uIManagerListener);
    }

    @Override // com.facebook.react.bridge.UIManager
    @Nullable
    @Deprecated
    public String resolveCustomDirectEventName(@Nullable String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("top")) {
            return str;
        }
        return "on" + str.substring(3);
    }

    @Override // com.facebook.react.bridge.UIManager, com.facebook.react.fabric.interop.UIBlockViewResolver
    public View resolveView(int i2) {
        UiThreadUtil.assertOnUiThread();
        SurfaceMountingManager surfaceManagerForView = this.mMountingManager.getSurfaceManagerForView(i2);
        if (surfaceManagerForView == null) {
            return null;
        }
        return surfaceManagerForView.getView(i2);
    }

    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    public void sendAccessibilityEvent(int i2, int i3) {
        this.mMountItemDispatcher.addMountItem(MountItemFactory.createSendAccessibilityEventMountItem(-1, i2, i3));
    }

    @AnyThread
    @ThreadConfined
    public void sendAccessibilityEventFromJS(int i2, int i3, String str) {
        int i4;
        if ("focus".equals(str)) {
            i4 = 8;
        } else if ("windowStateChange".equals(str)) {
            i4 = 32;
        } else if ("click".equals(str)) {
            i4 = 1;
        } else {
            if (!"viewHoverEnter".equals(str)) {
                throw new IllegalArgumentException(b.C("sendAccessibilityEventFromJS: invalid eventType ", str));
            }
            i4 = 128;
        }
        this.mMountItemDispatcher.addMountItem(MountItemFactory.createSendAccessibilityEventMountItem(i2, i3, i4));
    }

    public void setBinding(FabricUIManagerBinding fabricUIManagerBinding) {
        this.mBinding = fabricUIManagerBinding;
    }

    public void setJSResponder(final int i2, final int i3, final int i4, final boolean z) {
        this.mMountItemDispatcher.addMountItem(new MountItem() { // from class: com.facebook.react.fabric.FabricUIManager.4
            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public void execute(@NonNull MountingManager mountingManager) {
                SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(i2);
                if (surfaceManager != null) {
                    surfaceManager.setJSResponder(i3, i4, z);
                    return;
                }
                FLog.g(FabricUIManager.TAG, "setJSResponder skipped, surface no longer available [" + i2 + "]");
            }

            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public int getSurfaceId() {
                return i2;
            }

            @NonNull
            @SuppressLint({"DefaultLocale"})
            public String toString() {
                return String.format("SET_JS_RESPONDER [%d] [surface:%d]", Integer.valueOf(i3), Integer.valueOf(i2));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i2, int i3) {
        int rootViewTag = ((ReactRoot) t).getRootViewTag();
        Context context = t.getContext();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, context, str, rootViewTag);
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", str, Integer.valueOf(rootViewTag));
        }
        this.mMountingManager.startSurface(rootViewTag, themedReactContext, t);
        Point pointB = UiThreadUtil.isOnUiThread() ? RootViewUtil.b(t) : new Point(0, 0);
        this.mBinding.startSurfaceWithConstraints(rootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3), pointB.x, pointB.y, I18nUtil.b(context), I18nUtil.a(context));
        return rootViewTag;
    }

    public void stopSurface(SurfaceHandler surfaceHandler) {
        if (!surfaceHandler.isRunning()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to stop surface that hasn't started yet"));
            return;
        }
        this.mMountingManager.stopSurface(surfaceHandler.getSurfaceId());
        if (!(surfaceHandler instanceof SurfaceHandlerBinding)) {
            throw new IllegalArgumentException("Invalid SurfaceHandler");
        }
        this.mBinding.stopSurfaceWithSurfaceHandler((SurfaceHandlerBinding) surfaceHandler);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void sweepActiveTouchForTag(int i2, int i3) {
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i2);
        if (surfaceManager != null) {
            surfaceManager.sweepActiveTouchForTag(i3);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    @ThreadConfined
    @UiThread
    public void synchronouslyUpdateViewOnUIThread(final int i2, @NonNull final ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        int i3 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i3 + 1;
        MountItem mountItem = new MountItem() { // from class: com.facebook.react.fabric.FabricUIManager.2
            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public void execute(@NonNull MountingManager mountingManager) {
                try {
                    mountingManager.updateProps(i2, readableMap);
                } catch (Exception unused) {
                }
            }

            @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
            public int getSurfaceId() {
                return -1;
            }

            @NonNull
            public String toString() {
                return String.format("SYNC UPDATE PROPS [%d]: %s", Integer.valueOf(i2), FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT ? readableMap.toHashMap().toString() : "<hidden>");
            }
        };
        if (!this.mMountingManager.getViewExists(i2)) {
            this.mMountItemDispatcher.addMountItem(mountItem);
            return;
        }
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, null, i3);
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.d(TAG, "SynchronouslyUpdateViewOnUIThread for tag %d: %s", Integer.valueOf(i2), IS_DEVELOPMENT_ENVIRONMENT ? readableMap.toHashMap().toString() : "<hidden>");
        }
        mountItem.execute(this.mMountingManager);
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, null, i3);
    }

    @Override // com.facebook.react.bridge.UIManager
    @ThreadConfined
    @UiThread
    public void updateRootLayoutSpecs(int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        boolean zA;
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.c(TAG, "Updating Root Layout Specs for [%d]", Integer.valueOf(i2));
        }
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i2);
        if (surfaceManager == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException(b.f(i2, "Cannot updateRootLayoutSpecs on surfaceId that does not exist: ")));
            return;
        }
        ThemedReactContext context = surfaceManager.getContext();
        if (context != null) {
            boolean zB = I18nUtil.b(context);
            zA = I18nUtil.a(context);
            z = zB;
        } else {
            z = false;
            zA = false;
        }
        this.mBinding.setConstraints(i2, LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3), LayoutMetricsConversions.getMinSize(i4), LayoutMetricsConversions.getMaxSize(i4), i5, i6, z, zA);
    }

    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5, @Nullable float[] fArr) {
        ReactContext context;
        if (i2 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i2, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0L;
            }
            context = surfaceManagerEnforced.getContext();
        } else {
            context = this.mReactApplicationContext;
        }
        return this.mMountingManager.measure(context, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f2, f3), LayoutMetricsConversions.getYogaMeasureMode(f2, f3), LayoutMetricsConversions.getYogaSize(f4, f5), LayoutMetricsConversions.getYogaMeasureMode(f4, f5), fArr);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void receiveEvent(int i2, int i3, String str, @Nullable WritableMap writableMap) {
        receiveEvent(i2, i3, str, false, writableMap, 2);
    }

    public void receiveEvent(int i2, int i3, String str, boolean z, @Nullable WritableMap writableMap, int i4) {
        receiveEvent(i2, i3, str, z, writableMap, i4, false);
    }

    @Override // com.facebook.react.uimanager.events.SynchronousEventReceiver
    public void receiveEvent(int i2, int i3, String str, boolean z, @Nullable WritableMap writableMap, int i4, boolean z2) {
        if (this.mDestroyed) {
            FLog.g(TAG, "Attempted to receiveEvent after destruction");
            return;
        }
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i2, i3);
        if (eventEmitter == null) {
            if (this.mMountingManager.getViewExists(i3)) {
                this.mMountingManager.enqueuePendingEvent(i2, i3, str, z, writableMap, i4);
                return;
            }
            FLog.a(TAG, "Unable to invoke event: " + str + " for reactTag: " + i3);
            return;
        }
        if (z2) {
            if (this.mSynchronousEvents.add(new SynchronousEvent(i2, i3, str))) {
                eventEmitter.dispatchEventSynchronously(str, writableMap);
            }
        } else if (z) {
            eventEmitter.dispatchUnique(str, writableMap);
        } else {
            eventEmitter.dispatch(str, writableMap, i4);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    public void stopSurface(int i2) {
        this.mMountingManager.stopSurface(i2);
        this.mBinding.stopSurface(i2);
    }

    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    @Deprecated
    public void dispatchCommand(int i2, int i3, @Nullable ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    @Override // com.facebook.react.bridge.UIManager
    @AnyThread
    @ThreadConfined
    @Deprecated
    public void dispatchCommand(int i2, String str, @Nullable ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    @AnyThread
    @ThreadConfined
    @Deprecated
    public void dispatchCommand(int i2, int i3, int i4, @Nullable ReadableArray readableArray) {
        this.mMountItemDispatcher.addViewCommandMountItem(MountItemFactory.createDispatchCommandMountItem(i2, i3, i4, readableArray));
    }

    public void startSurface(SurfaceHandler surfaceHandler, Context context, @Nullable View view) {
        int iA = ReactRootViewTagGenerator.a();
        this.mMountingManager.startSurface(iA, new ThemedReactContext(this.mReactApplicationContext, context, surfaceHandler.getModuleName(), iA), view);
        if (surfaceHandler instanceof SurfaceHandlerBinding) {
            this.mBinding.startSurfaceWithSurfaceHandler(iA, (SurfaceHandlerBinding) surfaceHandler, view != null);
            return;
        }
        throw new IllegalArgumentException("Invalid SurfaceHandler");
    }
}
