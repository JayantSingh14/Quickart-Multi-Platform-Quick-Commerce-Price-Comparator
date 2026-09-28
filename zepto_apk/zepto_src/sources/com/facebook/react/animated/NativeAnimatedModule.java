package com.facebook.react.animated;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = NativeAnimatedModuleSpec.NAME)
/* loaded from: classes.dex */
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean ANIMATED_MODULE_DEBUG = false;

    @NonNull
    private final GuardedFrameCallback mAnimatedFrameCallback;
    private boolean mBatchingControlledByJS;
    private volatile long mCurrentBatchNumber;
    private volatile long mCurrentFrameNumber;
    private boolean mEnqueuedAnimationOnFrame;
    private boolean mInitializedForFabric;
    private boolean mInitializedForNonFabric;
    private final AtomicReference<NativeAnimatedNodesManager> mNodesManager;
    private int mNumFabricAnimations;
    private int mNumNonFabricAnimations;

    @NonNull
    private final ConcurrentOperationQueue mOperations;

    @NonNull
    private final ConcurrentOperationQueue mPreOperations;
    private final ReactChoreographer mReactChoreographer;
    private int mUIManagerType;

    /* renamed from: com.facebook.react.animated.NativeAnimatedModule$25, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass25 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18610a;

        static {
            int[] iArr = new int[BatchExecutionOpCodes.values().length];
            f18610a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18610a[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18610a[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18610a[8] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18610a[11] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18610a[12] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18610a[15] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18610a[16] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18610a[19] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18610a[20] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f18610a[0] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18610a[1] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f18610a[5] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f18610a[6] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f18610a[9] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f18610a[10] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f18610a[14] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f18610a[7] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f18610a[18] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f18610a[13] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f18610a[17] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class BatchExecutionOpCodes {

        /* JADX INFO: Fake field, exist only in values array */
        BatchExecutionOpCodes EF5;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ BatchExecutionOpCodes[] f18624b = {new BatchExecutionOpCodes("OP_CODE_CREATE_ANIMATED_NODE", 0), new BatchExecutionOpCodes("OP_CODE_UPDATE_ANIMATED_NODE_CONFIG", 1), new BatchExecutionOpCodes("OP_CODE_GET_VALUE", 2), new BatchExecutionOpCodes("OP_START_LISTENING_TO_ANIMATED_NODE_VALUE", 3), new BatchExecutionOpCodes("OP_STOP_LISTENING_TO_ANIMATED_NODE_VALUE", 4), new BatchExecutionOpCodes("OP_CODE_CONNECT_ANIMATED_NODES", 5), new BatchExecutionOpCodes("OP_CODE_DISCONNECT_ANIMATED_NODES", 6), new BatchExecutionOpCodes("OP_CODE_START_ANIMATING_NODE", 7), new BatchExecutionOpCodes("OP_CODE_STOP_ANIMATION", 8), new BatchExecutionOpCodes("OP_CODE_SET_ANIMATED_NODE_VALUE", 9), new BatchExecutionOpCodes("OP_CODE_SET_ANIMATED_NODE_OFFSET", 10), new BatchExecutionOpCodes("OP_CODE_FLATTEN_ANIMATED_NODE_OFFSET", 11), new BatchExecutionOpCodes("OP_CODE_EXTRACT_ANIMATED_NODE_OFFSET", 12), new BatchExecutionOpCodes("OP_CODE_CONNECT_ANIMATED_NODE_TO_VIEW", 13), new BatchExecutionOpCodes("OP_CODE_DISCONNECT_ANIMATED_NODE_FROM_VIEW", 14), new BatchExecutionOpCodes("OP_CODE_RESTORE_DEFAULT_VALUES", 15), new BatchExecutionOpCodes("OP_CODE_DROP_ANIMATED_NODE", 16), new BatchExecutionOpCodes("OP_CODE_ADD_ANIMATED_EVENT_TO_VIEW", 17), new BatchExecutionOpCodes("OP_CODE_REMOVE_ANIMATED_EVENT_FROM_VIEW", 18), new BatchExecutionOpCodes("OP_CODE_ADD_LISTENER", 19), new BatchExecutionOpCodes("OP_CODE_REMOVE_LISTENERS", 20)};

        /* renamed from: a, reason: collision with root package name */
        public static BatchExecutionOpCodes[] f18623a = null;

        public static BatchExecutionOpCodes a(int i2) {
            if (f18623a == null) {
                f18623a = values();
            }
            return f18623a[i2 - 1];
        }

        public static BatchExecutionOpCodes valueOf(String str) {
            return (BatchExecutionOpCodes) Enum.valueOf(BatchExecutionOpCodes.class, str);
        }

        public static BatchExecutionOpCodes[] values() {
            return (BatchExecutionOpCodes[]) f18624b.clone();
        }
    }

    public class ConcurrentOperationQueue {

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue f18625a = new ConcurrentLinkedQueue();

        /* renamed from: b, reason: collision with root package name */
        public UIThreadOperation f18626b = null;

        /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0027 A[EDGE_INSN: B:27:0x0027->B:14:0x0027 BREAK  A[LOOP:0: B:6:0x000d->B:24:0x0049], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(long r6, com.facebook.react.animated.NativeAnimatedNodesManager r8) {
            /*
                r5 = this;
                boolean r0 = r5.b()
                r1 = 0
                if (r0 == 0) goto L8
                goto L32
            L8:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            Ld:
                com.facebook.react.animated.NativeAnimatedModule$UIThreadOperation r2 = r5.f18626b
                if (r2 == 0) goto L1d
                long r3 = r2.f18627a
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 <= 0) goto L18
                goto L27
            L18:
                r0.add(r2)
                r5.f18626b = r1
            L1d:
                java.util.concurrent.ConcurrentLinkedQueue r2 = r5.f18625a
                java.lang.Object r2 = r2.poll()
                com.facebook.react.animated.NativeAnimatedModule$UIThreadOperation r2 = (com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation) r2
                if (r2 != 0) goto L29
            L27:
                r1 = r0
                goto L32
            L29:
                long r3 = r2.f18627a
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 <= 0) goto L49
                r5.f18626b = r2
                goto L27
            L32:
                if (r1 == 0) goto L48
                java.util.Iterator r6 = r1.iterator()
            L38:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L48
                java.lang.Object r7 = r6.next()
                com.facebook.react.animated.NativeAnimatedModule$UIThreadOperation r7 = (com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation) r7
                r7.a(r8)
                goto L38
            L48:
                return
            L49:
                r0.add(r2)
                goto Ld
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.NativeAnimatedModule.ConcurrentOperationQueue.a(long, com.facebook.react.animated.NativeAnimatedNodesManager):void");
        }

        public final boolean b() {
            return this.f18625a.isEmpty() && this.f18626b == null;
        }
    }

    public abstract class UIThreadOperation {

        /* renamed from: a, reason: collision with root package name */
        public long f18627a = -1;

        public abstract void a(NativeAnimatedNodesManager nativeAnimatedNodesManager);
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mOperations = new ConcurrentOperationQueue();
        this.mPreOperations = new ConcurrentOperationQueue();
        this.mNodesManager = new AtomicReference<>();
        this.mBatchingControlledByJS = false;
        this.mInitializedForFabric = false;
        this.mInitializedForNonFabric = false;
        this.mEnqueuedAnimationOnFrame = false;
        this.mUIManagerType = 1;
        this.mNumFabricAnimations = 0;
        this.mNumNonFabricAnimations = 0;
        this.mReactChoreographer = ReactChoreographer.Companion.a();
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) { // from class: com.facebook.react.animated.NativeAnimatedModule.1
            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            public final void doFrameGuarded(long j2) {
                NativeAnimatedModule nativeAnimatedModule = NativeAnimatedModule.this;
                try {
                    nativeAnimatedModule.mEnqueuedAnimationOnFrame = false;
                    NativeAnimatedNodesManager nodesManager = nativeAnimatedModule.getNodesManager();
                    boolean z = true;
                    if (nodesManager != null) {
                        if (nodesManager.f18629b.size() > 0 || nodesManager.f18630c.size() > 0) {
                            nodesManager.m(j2);
                        }
                    }
                    if (nodesManager != null && nativeAnimatedModule.mReactChoreographer != null) {
                        if (ReactNativeFeatureFlags.f18968a.lazyAnimationCallbacks()) {
                            if (nodesManager.f18629b.size() <= 0 && nodesManager.f18630c.size() <= 0) {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                        }
                        nativeAnimatedModule.enqueueFrameCallback();
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private void addOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.f18627a = this.mCurrentBatchNumber;
        this.mOperations.f18625a.add(uIThreadOperation);
    }

    private void addPreOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.f18627a = this.mCurrentBatchNumber;
        this.mPreOperations.f18625a.add(uIThreadOperation);
    }

    private void addUnbatchedOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.f18627a = -1L;
        this.mOperations.f18625a.add(uIThreadOperation);
    }

    private void clearFrameCallback() {
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        Assertions.c(reactChoreographer);
        reactChoreographer.c(ReactChoreographer.CallbackType.f19070c, this.mAnimatedFrameCallback);
        this.mEnqueuedAnimationOnFrame = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementInFlightAnimationsForViewTag(int i2) {
        if (ViewUtil.a(i2) == 2) {
            this.mNumFabricAnimations--;
        } else {
            this.mNumNonFabricAnimations--;
        }
        int i3 = this.mNumNonFabricAnimations;
        if (i3 == 0 && this.mNumFabricAnimations > 0 && this.mUIManagerType != 2) {
            this.mUIManagerType = 2;
        } else {
            if (this.mNumFabricAnimations != 0 || i3 <= 0 || this.mUIManagerType == 1) {
                return;
            }
            this.mUIManagerType = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueFrameCallback() {
        if (this.mEnqueuedAnimationOnFrame) {
            return;
        }
        ReactChoreographer reactChoreographer = this.mReactChoreographer;
        Assertions.c(reactChoreographer);
        reactChoreographer.b(ReactChoreographer.CallbackType.f19070c, this.mAnimatedFrameCallback);
        this.mEnqueuedAnimationOnFrame = true;
    }

    private void initializeLifecycleEventListenersForViewTag(int i2) {
        UIManager uIManagerF;
        int iA = ViewUtil.a(i2);
        this.mUIManagerType = iA;
        if (iA == 2) {
            this.mNumFabricAnimations++;
        } else {
            this.mNumNonFabricAnimations++;
        }
        NativeAnimatedNodesManager nodesManager = getNodesManager();
        if (nodesManager != null) {
            int i3 = this.mUIManagerType;
            if (i3 != 2 ? !nodesManager.f18636i : !nodesManager.f18635h) {
                UIManager uIManagerF2 = UIManagerHelper.f(nodesManager.f18632e, i3, true);
                if (uIManagerF2 != null) {
                    uIManagerF2.getEventDispatcher().e(nodesManager);
                    if (i3 == 2) {
                        nodesManager.f18635h = true;
                    } else {
                        nodesManager.f18636i = true;
                    }
                }
            }
        } else {
            ReactSoftExceptionLogger.logSoftException(NativeAnimatedModuleSpec.NAME, new RuntimeException("initializeLifecycleEventListenersForViewTag could not get NativeAnimatedNodesManager"));
        }
        if (this.mUIManagerType == 2) {
            if (this.mInitializedForFabric) {
                return;
            }
        } else if (this.mInitializedForNonFabric) {
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext == null || (uIManagerF = UIManagerHelper.f(reactApplicationContext, this.mUIManagerType, true)) == null) {
            return;
        }
        uIManagerF.addUIManagerEventListener(this);
        if (this.mUIManagerType == 2) {
            this.mInitializedForFabric = true;
        } else {
            this.mInitializedForNonFabric = true;
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addAnimatedEventToView(double d2, final String str, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        initializeLifecycleEventListenersForViewTag(i2);
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.21
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.a(i2, str, readableMap);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodeToView(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        initializeLifecycleEventListenersForViewTag(i3);
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.18
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.b(i2, i3);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodes(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.16
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.c(i2, i3);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void createAnimatedNode(double d2, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.4
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.d(i2, readableMap);
            }
        });
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    @UiThread
    public void didDispatchMountItems(UIManager uIManager) {
        if (this.mUIManagerType != 2) {
            return;
        }
        long j2 = this.mCurrentBatchNumber - 1;
        if (!this.mBatchingControlledByJS) {
            this.mCurrentFrameNumber++;
            if (this.mCurrentFrameNumber - this.mCurrentBatchNumber > 2) {
                this.mCurrentBatchNumber = this.mCurrentFrameNumber;
                j2 = this.mCurrentBatchNumber;
            }
        }
        this.mPreOperations.a(j2, getNodesManager());
        this.mOperations.a(j2, getNodesManager());
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uIManager) {
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uIManager) {
        this.mCurrentFrameNumber++;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodeFromView(double d2, double d3) {
        int i2 = (int) d3;
        decrementInFlightAnimationsForViewTag(i2);
        addOperation(new UIThreadOperation((int) d2, i2) { // from class: com.facebook.react.animated.NativeAnimatedModule.19

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f18593b;

            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(this.f18593b);
                if (animatedNode != null && (animatedNode instanceof PropsAnimatedNode)) {
                    ((PropsAnimatedNode) animatedNode).f18644f = -1;
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodes(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.17
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.e(i2, i3);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void dropAnimatedNode(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.9
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                SparseArray sparseArray = nativeAnimatedNodesManager.f18628a;
                int i3 = i2;
                sparseArray.remove(i3);
                nativeAnimatedNodesManager.f18630c.remove(i3);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void extractAnimatedNodeOffset(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.13
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.f(i2);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void finishOperationBatch() {
        this.mBatchingControlledByJS = false;
        this.mCurrentBatchNumber++;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void flattenAnimatedNodeOffset(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.12
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.g(i2);
            }
        });
    }

    @Nullable
    public NativeAnimatedNodesManager getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager.get() == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            AtomicReference<NativeAnimatedNodesManager> atomicReference = this.mNodesManager;
            NativeAnimatedNodesManager nativeAnimatedNodesManager = new NativeAnimatedNodesManager(reactApplicationContextIfActiveOrWarn);
            while (!atomicReference.compareAndSet(null, nativeAnimatedNodesManager) && atomicReference.get() == null) {
            }
        }
        return this.mNodesManager.get();
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void getValue(double d2, final Callback callback) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.23
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.i(i2, callback);
            }
        });
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        getReactApplicationContext().removeLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        clearFrameCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        clearFrameCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        enqueueFrameCallback();
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void queueAndExecuteBatchedOperations(final ReadableArray readableArray) {
        final int size = readableArray.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            switch (BatchExecutionOpCodes.a(readableArray.getInt(i2)).ordinal()) {
                case 0:
                case 1:
                case 5:
                case 6:
                case 9:
                case 10:
                case 14:
                    i2 += 3;
                    continue;
                case 2:
                case 3:
                case 4:
                case 8:
                case 11:
                case 12:
                case 15:
                case 16:
                case 19:
                case 20:
                    i2 += 2;
                    continue;
                case 7:
                case 18:
                    break;
                case 13:
                    int i4 = i2 + 2;
                    i2 += 3;
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i4));
                    continue;
                case 17:
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i3));
                    break;
                default:
                    throw new IllegalArgumentException("Batch animation execution op: fetching viewTag: unknown op code");
            }
            i2 += 4;
        }
        startOperationBatch();
        addUnbatchedOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.24
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                NativeAnimatedModule nativeAnimatedModule = NativeAnimatedModule.this;
                nativeAnimatedModule.getReactApplicationContextIfActiveOrWarn();
                int i5 = 0;
                while (i5 < size) {
                    int i6 = i5 + 1;
                    ReadableArray readableArray2 = readableArray;
                    switch (BatchExecutionOpCodes.a(readableArray2.getInt(i5)).ordinal()) {
                        case 0:
                            int i7 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.d(readableArray2.getInt(i6), readableArray2.getMap(i7));
                            break;
                        case 1:
                            int i8 = i5 + 2;
                            int i9 = readableArray2.getInt(i6);
                            i5 += 3;
                            ReadableMap map = readableArray2.getMap(i8);
                            AnimatedNode animatedNode = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(i9);
                            if (animatedNode == 0 || !(animatedNode instanceof AnimatedNodeWithUpdateableConfig)) {
                                break;
                            } else {
                                nativeAnimatedNodesManager.q(animatedNode);
                                ((AnimatedNodeWithUpdateableConfig) animatedNode).a(map);
                                nativeAnimatedNodesManager.f18630c.put(i9, animatedNode);
                                break;
                            }
                        case 2:
                            i5 += 2;
                            nativeAnimatedNodesManager.i(readableArray2.getInt(i6), null);
                            break;
                        case 3:
                            i5 += 2;
                            final int i10 = readableArray2.getInt(i6);
                            AnimatedNodeValueListener animatedNodeValueListener = new AnimatedNodeValueListener() { // from class: com.facebook.react.animated.NativeAnimatedModule.24.1
                                @Override // com.facebook.react.animated.AnimatedNodeValueListener
                                public final void a(double d2) {
                                    WritableMap writableMapCreateMap = Arguments.createMap();
                                    writableMapCreateMap.putInt("tag", i10);
                                    writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, d2);
                                    ReactApplicationContext reactApplicationContextIfActiveOrWarn = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                                    if (reactApplicationContextIfActiveOrWarn != null) {
                                        reactApplicationContextIfActiveOrWarn.emitDeviceEvent("onAnimatedValueUpdate", writableMapCreateMap);
                                    }
                                }
                            };
                            AnimatedNode animatedNode2 = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(i10);
                            if (animatedNode2 != null && (animatedNode2 instanceof ValueAnimatedNode)) {
                                ((ValueAnimatedNode) animatedNode2).f18675g = animatedNodeValueListener;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case 4:
                            i5 += 2;
                            AnimatedNode animatedNode3 = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(readableArray2.getInt(i6));
                            if (animatedNode3 != null && (animatedNode3 instanceof ValueAnimatedNode)) {
                                ((ValueAnimatedNode) animatedNode3).f18675g = null;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case 5:
                            int i11 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.c(readableArray2.getInt(i6), readableArray2.getInt(i11));
                            break;
                        case 6:
                            int i12 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.e(readableArray2.getInt(i6), readableArray2.getInt(i12));
                            break;
                        case 7:
                            if (ReactNativeFeatureFlags.f18968a.lazyAnimationCallbacks()) {
                                nativeAnimatedModule.enqueueFrameCallback();
                            }
                            int i13 = readableArray2.getInt(i6);
                            int i14 = i5 + 3;
                            int i15 = readableArray2.getInt(i5 + 2);
                            i5 += 4;
                            nativeAnimatedNodesManager.o(i13, readableArray2.getMap(i14), null, i15);
                            break;
                        case 8:
                            i5 += 2;
                            nativeAnimatedNodesManager.p(readableArray2.getInt(i6));
                            break;
                        case 9:
                            int i16 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.n(readableArray2.getInt(i6), readableArray2.getDouble(i16));
                            break;
                        case 10:
                            int i17 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.n(readableArray2.getInt(i6), readableArray2.getDouble(i17));
                            break;
                        case 11:
                            i5 += 2;
                            nativeAnimatedNodesManager.g(readableArray2.getInt(i6));
                            break;
                        case 12:
                            i5 += 2;
                            nativeAnimatedNodesManager.f(readableArray2.getInt(i6));
                            break;
                        case 13:
                            int i18 = i5 + 2;
                            i5 += 3;
                            nativeAnimatedNodesManager.b(readableArray2.getInt(i6), readableArray2.getInt(i18));
                            break;
                        case 14:
                            int i19 = i5 + 2;
                            int i20 = readableArray2.getInt(i6);
                            i5 += 3;
                            nativeAnimatedModule.decrementInFlightAnimationsForViewTag(readableArray2.getInt(i19));
                            AnimatedNode animatedNode4 = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(i20);
                            if (animatedNode4 == null || !(animatedNode4 instanceof PropsAnimatedNode)) {
                                break;
                            } else {
                                ((PropsAnimatedNode) animatedNode4).f18644f = -1;
                                break;
                            }
                        case 15:
                            i5 += 2;
                            nativeAnimatedNodesManager.l(readableArray2.getInt(i6));
                            break;
                        case 16:
                            i5 += 2;
                            int i21 = readableArray2.getInt(i6);
                            nativeAnimatedNodesManager.f18628a.remove(i21);
                            nativeAnimatedNodesManager.f18630c.remove(i21);
                            break;
                        case 17:
                            int i22 = readableArray2.getInt(i6);
                            int i23 = i5 + 3;
                            String string = readableArray2.getString(i5 + 2);
                            i5 += 4;
                            nativeAnimatedNodesManager.a(i22, string, readableArray2.getMap(i23));
                            break;
                        case 18:
                            int i24 = readableArray2.getInt(i6);
                            nativeAnimatedModule.decrementInFlightAnimationsForViewTag(i24);
                            int i25 = i5 + 3;
                            String string2 = readableArray2.getString(i5 + 2);
                            i5 += 4;
                            nativeAnimatedNodesManager.k(i24, readableArray2.getInt(i25), string2);
                            break;
                        case 19:
                        case 20:
                            i5 += 2;
                            break;
                        default:
                            throw new IllegalArgumentException("Batch animation execution op: unknown op code");
                    }
                }
            }
        });
        finishOperationBatch();
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeAnimatedEventFromView(double d2, final String str, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        decrementInFlightAnimationsForViewTag(i2);
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.22
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                String str2 = str;
                nativeAnimatedNodesManager.k(i2, i3, str2);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void restoreDefaultValues(double d2) {
        final int i2 = (int) d2;
        addPreOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.20
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.l(i2);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeOffset(double d2, final double d3) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.11
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                SparseArray sparseArray = nativeAnimatedNodesManager.f18628a;
                int i3 = i2;
                AnimatedNode animatedNode = (AnimatedNode) sparseArray.get(i3);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    return;
                }
                ((ValueAnimatedNode) animatedNode).f18674f = d3;
                nativeAnimatedNodesManager.f18630c.put(i3, animatedNode);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeValue(double d2, final double d3) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.10
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.n(i2, d3);
            }
        });
    }

    @VisibleForTesting
    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager.set(nativeAnimatedNodesManager);
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startAnimatingNode(double d2, double d3, final ReadableMap readableMap, final Callback callback) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        addUnbatchedOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.14
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.o(i2, readableMap, callback, i3);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startListeningToAnimatedNodeValue(double d2) {
        final int i2 = (int) d2;
        final AnimatedNodeValueListener animatedNodeValueListener = new AnimatedNodeValueListener() { // from class: com.facebook.react.animated.NativeAnimatedModule.6
            @Override // com.facebook.react.animated.AnimatedNodeValueListener
            public final void a(double d3) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("tag", i2);
                writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, d3);
                ReactApplicationContext reactApplicationContextIfActiveOrWarn = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                if (reactApplicationContextIfActiveOrWarn != null) {
                    reactApplicationContextIfActiveOrWarn.emitDeviceEvent("onAnimatedValueUpdate", writableMapCreateMap);
                }
            }
        };
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.7
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNodeValueListener animatedNodeValueListener2 = animatedNodeValueListener;
                AnimatedNode animatedNode = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(i2);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    return;
                }
                ((ValueAnimatedNode) animatedNode).f18675g = animatedNodeValueListener2;
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopAnimation(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.15
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.p(i2);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopListeningToAnimatedNodeValue(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.8
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                AnimatedNode animatedNode = (AnimatedNode) nativeAnimatedNodesManager.f18628a.get(i2);
                if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
                    return;
                }
                ((ValueAnimatedNode) animatedNode).f18675g = null;
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void updateAnimatedNodeConfig(double d2, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() { // from class: com.facebook.react.animated.NativeAnimatedModule.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.react.animated.NativeAnimatedModule.UIThreadOperation
            public final void a(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                SparseArray sparseArray = nativeAnimatedNodesManager.f18628a;
                int i3 = i2;
                AnimatedNode animatedNode = (AnimatedNode) sparseArray.get(i3);
                if (animatedNode != 0 && (animatedNode instanceof AnimatedNodeWithUpdateableConfig)) {
                    nativeAnimatedNodesManager.q(animatedNode);
                    ((AnimatedNodeWithUpdateableConfig) animatedNode).a(readableMap);
                    nativeAnimatedNodesManager.f18630c.put(i3, animatedNode);
                }
            }
        });
    }

    public void userDrivenScrollEnded(int i2) {
        int i3;
        ArrayList arrayList;
        NativeAnimatedNodesManager nativeAnimatedNodesManager = this.mNodesManager.get();
        if (nativeAnimatedNodesManager == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        ListIterator listIterator = nativeAnimatedNodesManager.f18631d.listIterator();
        while (listIterator.hasNext()) {
            EventAnimationDriver eventAnimationDriver = (EventAnimationDriver) listIterator.next();
            if (eventAnimationDriver != null && "topScrollEnded".equals(eventAnimationDriver.eventName) && i2 == (i3 = eventAnimationDriver.viewTag)) {
                hashSet.add(Integer.valueOf(i3));
                ValueAnimatedNode valueAnimatedNode = eventAnimationDriver.valueNode;
                if (valueAnimatedNode != null && (arrayList = valueAnimatedNode.f18521a) != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(((AnimatedNode) it.next()).f18524d));
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushInt(((Integer) it2.next()).intValue());
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("tags", writableArrayCreateArray);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("onUserDrivenAnimationEnded", writableMapCreateMap);
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    @UiThread
    public void willDispatchViewUpdates(UIManager uIManager) {
        if ((this.mOperations.b() && this.mPreOperations.b()) || this.mUIManagerType == 2) {
            return;
        }
        final long j2 = this.mCurrentBatchNumber;
        this.mCurrentBatchNumber = 1 + j2;
        UIBlock uIBlock = new UIBlock() { // from class: com.facebook.react.animated.NativeAnimatedModule.2
            @Override // com.facebook.react.uimanager.UIBlock
            public final void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
                NativeAnimatedModule nativeAnimatedModule = NativeAnimatedModule.this;
                nativeAnimatedModule.mPreOperations.a(j2, nativeAnimatedModule.getNodesManager());
            }
        };
        UIBlock uIBlock2 = new UIBlock() { // from class: com.facebook.react.animated.NativeAnimatedModule.3
            @Override // com.facebook.react.uimanager.UIBlock
            public final void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
                NativeAnimatedModule nativeAnimatedModule = NativeAnimatedModule.this;
                nativeAnimatedModule.mOperations.a(j2, nativeAnimatedModule.getNodesManager());
            }
        };
        UIManagerModule uIManagerModule = (UIManagerModule) uIManager;
        uIManagerModule.prependUIBlock(uIBlock);
        uIManagerModule.addUIBlock(uIBlock2);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uIManager) {
    }
}
