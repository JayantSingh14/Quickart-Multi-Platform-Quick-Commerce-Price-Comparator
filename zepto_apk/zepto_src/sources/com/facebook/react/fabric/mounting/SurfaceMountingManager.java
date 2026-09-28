package com.facebook.react.fabric.mounting;

import android.os.Trace;
import android.support.v4.media.b;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.constraintlayout.motion.widget.a;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IViewGroupManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.systrace.Systrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = "SurfaceMountingManager";
    private JSResponderHandler mJSResponderHandler;
    private MountingManager.MountItemExecutor mMountItemExecutor;
    private RootViewManager mRootViewManager;
    private final int mSurfaceId;
    private SparseArrayCompat<Object> mTagSetForStoppedSurface;

    @Nullable
    private ThemedReactContext mThemedReactContext;
    private ViewManagerRegistry mViewManagerRegistry;
    private volatile boolean mIsStopped = false;
    private volatile boolean mRootViewAttached = false;
    private ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    private Queue<MountItem> mOnViewAttachMountItems = new ArrayDeque();

    @ThreadConfined
    private final Set<Integer> mErroneouslyReaddedReactTags = new HashSet();

    @ThreadConfined
    private final Set<Integer> mViewsWithActiveTouches = new HashSet();

    @ThreadConfined
    private final Set<Integer> mViewsToDeleteAfterTouchFinishes = new HashSet();

    public static class PendingViewEvent {
        private final boolean mCanCoalesceEvent;
        private final int mEventCategory;
        private final String mEventName;

        @Nullable
        private final WritableMap mParams;

        public PendingViewEvent(String str, @Nullable WritableMap writableMap, int i2, boolean z) {
            this.mEventName = str;
            this.mParams = writableMap;
            this.mEventCategory = i2;
            this.mCanCoalesceEvent = z;
        }

        public void dispatch(EventEmitterWrapper eventEmitterWrapper) {
            if (this.mCanCoalesceEvent) {
                eventEmitterWrapper.dispatchUnique(this.mEventName, this.mParams);
            } else {
                eventEmitterWrapper.dispatch(this.mEventName, this.mParams, this.mEventCategory);
            }
        }
    }

    public static class ViewState {

        @Nullable
        ReadableMap mCurrentLocalData;

        @Nullable
        ReactStylesDiffMap mCurrentProps;

        @Nullable
        EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;

        @Nullable
        @ThreadConfined
        Queue<PendingViewEvent> mPendingEventQueue;
        final int mReactTag;

        @Nullable
        StateWrapper mStateWrapper;

        @Nullable
        View mView;

        @Nullable
        ViewManager mViewManager;

        public /* synthetic */ ViewState(int i2, int i3) {
            this(i2);
        }

        @NonNull
        public String toString() {
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + (this.mViewManager == null);
        }

        public /* synthetic */ ViewState(int i2, View view, ViewManager viewManager) {
            this(i2, view, viewManager, true);
        }

        private ViewState(int i2) {
            this(i2, null, null, false);
        }

        private ViewState(int i2, @Nullable View view, @Nullable ViewManager viewManager, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mPendingEventQueue = null;
            this.mReactTag = i2;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = viewManager;
        }
    }

    public SurfaceMountingManager(int i2, @NonNull JSResponderHandler jSResponderHandler, @NonNull ViewManagerRegistry viewManagerRegistry, @NonNull RootViewManager rootViewManager, @NonNull MountingManager.MountItemExecutor mountItemExecutor, @NonNull ThemedReactContext themedReactContext) {
        this.mSurfaceId = i2;
        this.mJSResponderHandler = jSResponderHandler;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
        this.mThemedReactContext = themedReactContext;
    }

    @AnyThread
    private void addRootView(@NonNull View view) throws Exception {
        if (isStopped()) {
            return;
        }
        this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, this.mRootViewManager));
        a aVar = new a(22, this, view);
        if (UiThreadUtil.isOnUiThread()) {
            aVar.run();
        } else {
            UiThreadUtil.runOnUiThread(aVar);
        }
    }

    @ThreadConfined
    @UiThread
    private void executeMountItemsOnViewAttach() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachMountItems);
    }

    @Nullable
    private ViewState getNullableViewState(int i2) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i2));
    }

    @NonNull
    private static IViewGroupManager<ViewGroup> getViewGroupManager(@NonNull ViewState viewState) {
        NativeModule nativeModule = viewState.mViewManager;
        if (nativeModule != null) {
            return (IViewGroupManager) nativeModule;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    @NonNull
    private ViewState getViewState(int i2) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i2));
        if (viewState != null) {
            return viewState;
        }
        StringBuilder sbU = b.u(i2, "Unable to find viewState for tag ", ". Surface stopped: ");
        sbU.append(isStopped());
        throw new RetryableMountingLayerException(sbU.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void lambda$addRootView$0(View view) {
        if (isStopped()) {
            return;
        }
        if (view.getId() == this.mSurfaceId) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException(b.o(new StringBuilder("Race condition in addRootView detected. Trying to set an id of ["), this.mSurfaceId, "] on the RootView, but that id has already been set. ")));
        } else if (view.getId() != -1) {
            String str = TAG;
            FLog.i(str, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(this.mSurfaceId));
            Intrinsics.checkNotNullParameter("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.", "msg");
            ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView."));
        }
        view.setId(this.mSurfaceId);
        if (view instanceof ReactRoot) {
            ((ReactRoot) view).setRootViewTag(this.mSurfaceId);
        }
        executeMountItemsOnViewAttach();
        this.mRootViewAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$stopSurface$1() {
        ArrayList arrayList;
        if (ReactNativeFeatureFlags.f18968a.enableViewRecycling()) {
            ViewManagerRegistry viewManagerRegistry = this.mViewManagerRegistry;
            int i2 = this.mSurfaceId;
            synchronized (viewManagerRegistry) {
                arrayList = new ArrayList(viewManagerRegistry.f19601a.values());
            }
            com.facebook.react.uimanager.b bVar = new com.facebook.react.uimanager.b(i2, 0, arrayList);
            if (UiThreadUtil.isOnUiThread()) {
                bVar.run();
            } else {
                UiThreadUtil.runOnUiThread(bVar);
            }
        }
        this.mTagSetForStoppedSurface = new SparseArrayCompat<>();
        for (Map.Entry<Integer, ViewState> entry : this.mTagToViewState.entrySet()) {
            this.mTagSetForStoppedSurface.c(entry.getKey().intValue(), this);
            onViewStateDeleted(entry.getValue());
        }
        this.mTagToViewState = null;
        this.mJSResponderHandler = null;
        this.mRootViewManager = null;
        this.mMountItemExecutor = null;
        this.mThemedReactContext = null;
        this.mOnViewAttachMountItems.clear();
        FLog.g(TAG, "Surface [" + this.mSurfaceId + "] was stopped on SurfaceMountingManager.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logViewHierarchy(ViewGroup viewGroup, boolean z) {
        int id = viewGroup.getId();
        String str = TAG;
        StringBuilder sbU = b.u(id, "  <ViewGroup tag=", " class=");
        sbU.append(viewGroup.getClass().toString());
        sbU.append(">");
        FLog.g(str, sbU.toString());
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            String str2 = TAG;
            StringBuilder sbU2 = b.u(i2, "     <View idx=", " tag=");
            sbU2.append(viewGroup.getChildAt(i2).getId());
            sbU2.append(" class=");
            sbU2.append(viewGroup.getChildAt(i2).getClass().toString());
            sbU2.append(">");
            FLog.g(str2, sbU2.toString());
        }
        String str3 = TAG;
        FLog.g(str3, "  </ViewGroup tag=" + id + ">");
        if (z) {
            FLog.g(str3, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                int id2 = viewGroup2 == null ? -1 : viewGroup2.getId();
                String str4 = TAG;
                StringBuilder sbU3 = b.u(id2, "<ViewParent tag=", " class=");
                sbU3.append(parent.getClass().toString());
                sbU3.append(">");
                FLog.g(str4, sbU3.toString());
            }
        }
    }

    @UiThread
    private void onViewStateDeleted(ViewState viewState) {
        StateWrapper stateWrapper = viewState.mStateWrapper;
        if (stateWrapper != null) {
            stateWrapper.destroyState();
            viewState.mStateWrapper = null;
        }
        EventEmitterWrapper eventEmitterWrapper = viewState.mEventEmitter;
        if (eventEmitterWrapper != null) {
            eventEmitterWrapper.destroy();
            viewState.mEventEmitter = null;
        }
        ViewManager viewManager = viewState.mViewManager;
        if (viewState.mIsRoot || viewManager == null) {
            return;
        }
        viewManager.onDropViewInstance(viewState.mView);
    }

    @UiThread
    public void addViewAt(final int i2, final int i3, final int i4) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        View view = viewState.mView;
        if (!(view instanceof ViewGroup)) {
            StringBuilder sbT = b.t(i2, i3, "Unable to add a view into a view that is not a ViewGroup. ParentTag: ", " - Tag: ", " - Index: ");
            sbT.append(i4);
            String string = sbT.toString();
            FLog.g(TAG, string);
            throw new IllegalStateException(string);
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        ViewState viewState2 = getViewState(i3);
        View view2 = viewState2.mView;
        if (view2 == null) {
            throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i3);
        }
        boolean z = SHOW_CHANGED_VIEW_HIERARCHIES;
        if (z) {
            String str = TAG;
            StringBuilder sbT2 = b.t(i3, i2, "addViewAt: [", "] -> [", "] idx: ");
            sbT2.append(i4);
            sbT2.append(" BEFORE");
            FLog.g(str, sbT2.toString());
            logViewHierarchy(viewGroup, false);
        }
        ViewParent parent = view2.getParent();
        if (parent != null) {
            boolean z2 = parent instanceof ViewGroup;
            int id = z2 ? ((ViewGroup) parent).getId() : -1;
            String str2 = TAG;
            StringBuilder sbT3 = b.t(i3, i2, "addViewAt: cannot insert view [", "] into parent [", "]: View already has a parent: [");
            sbT3.append(id);
            sbT3.append("]  Parent: ");
            sbT3.append(parent.getClass().getSimpleName());
            sbT3.append(" View: ");
            sbT3.append(view2.getClass().getSimpleName());
            ReactSoftExceptionLogger.logSoftException(str2, new IllegalStateException(sbT3.toString()));
            if (z2) {
                ((ViewGroup) parent).removeView(view2);
            }
            this.mErroneouslyReaddedReactTags.add(Integer.valueOf(i3));
        }
        try {
            getViewGroupManager(viewState).addView(viewGroup, view2, i4);
            if (z) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FLog.g(SurfaceMountingManager.TAG, "addViewAt: [" + i3 + "] -> [" + i2 + "] idx: " + i4 + " AFTER");
                        SurfaceMountingManager.logViewHierarchy(viewGroup, false);
                    }
                });
            }
        } catch (IllegalStateException | IndexOutOfBoundsException e2) {
            StringBuilder sbT4 = b.t(i3, i2, "addViewAt: failed to insert view [", "] into parent [", "] at index ");
            sbT4.append(i4);
            throw new IllegalStateException(sbT4.toString(), e2);
        }
    }

    public void attachRootView(View view, ThemedReactContext themedReactContext) {
        this.mThemedReactContext = themedReactContext;
        addRootView(view);
    }

    @UiThread
    public void createView(@NonNull String str, int i2, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        if (isStopped()) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null || nullableViewState.mView == null) {
            createViewUnsafe(str, i2, readableMap, stateWrapper, eventEmitterWrapper, z);
        }
    }

    @UiThread
    public void createViewUnsafe(@NonNull String str, int i2, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        Systrace.a("SurfaceMountingManager::createViewUnsafe(" + str + ")");
        try {
            ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
            ViewState viewState = new ViewState(i2, 0);
            viewState.mCurrentProps = reactStylesDiffMap;
            viewState.mStateWrapper = stateWrapper;
            viewState.mEventEmitter = eventEmitterWrapper;
            this.mTagToViewState.put(Integer.valueOf(i2), viewState);
            if (z) {
                ViewManager viewManagerA = this.mViewManagerRegistry.a(str);
                viewState.mView = viewManagerA.createView(i2, this.mThemedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
                viewState.mViewManager = viewManagerA;
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @UiThread
    public void deleteView(int i2) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException(b.g(i2, "Unable to find viewState for tag: ", " for deleteView")));
        } else if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid() && this.mViewsWithActiveTouches.contains(Integer.valueOf(i2))) {
            this.mViewsToDeleteAfterTouchFinishes.add(Integer.valueOf(i2));
        } else {
            this.mTagToViewState.remove(Integer.valueOf(i2));
            onViewStateDeleted(nullableViewState);
        }
    }

    @AnyThread
    public void enqueuePendingEvent(int i2, String str, boolean z, @Nullable WritableMap writableMap, int i3) {
        final ViewState viewState;
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null || (viewState = concurrentHashMap.get(Integer.valueOf(i2))) == null) {
            return;
        }
        final PendingViewEvent pendingViewEvent = new PendingViewEvent(str, writableMap, i3, z);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewState viewState2 = viewState;
                EventEmitterWrapper eventEmitterWrapper = viewState2.mEventEmitter;
                if (eventEmitterWrapper != null) {
                    pendingViewEvent.dispatch(eventEmitterWrapper);
                    return;
                }
                if (viewState2.mPendingEventQueue == null) {
                    viewState2.mPendingEventQueue = new LinkedList();
                }
                viewState.mPendingEventQueue.add(pendingViewEvent);
            }
        });
    }

    @Nullable
    public ThemedReactContext getContext() {
        return this.mThemedReactContext;
    }

    @Nullable
    @AnyThread
    @ThreadConfined
    public EventEmitterWrapper getEventEmitter(int i2) {
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @UiThread
    public View getView(int i2) {
        ViewState nullableViewState = getNullableViewState(i2);
        View view = nullableViewState == null ? null : nullableViewState.mView;
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException(b.g(i2, "Trying to resolve view with tag ", " which doesn't exist"));
    }

    public boolean getViewExists(int i2) {
        SparseArrayCompat<Object> sparseArrayCompat = this.mTagSetForStoppedSurface;
        if (sparseArrayCompat != null) {
            if (ContainerHelpersKt.a(sparseArrayCompat.f1608c, i2, sparseArrayCompat.f1606a) >= 0) {
                return true;
            }
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i2));
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    public void markActiveTouchForTag(int i2) {
        if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid()) {
            this.mViewsWithActiveTouches.add(Integer.valueOf(i2));
        }
    }

    @UiThread
    public void preallocateView(@NonNull String str, int i2, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped() && getNullableViewState(i2) == null) {
            createViewUnsafe(str, i2, readableMap, stateWrapper, null, z);
        }
    }

    public void printSurfaceState() {
        FLog.i(TAG, "Views created for surface {%d}:", Integer.valueOf(getSurfaceId()));
        for (ViewState viewState : this.mTagToViewState.values()) {
            ViewManager viewManager = viewState.mViewManager;
            Integer numValueOf = null;
            String name = viewManager != null ? viewManager.getName() : null;
            View view = viewState.mView;
            View view2 = view != null ? (View) view.getParent() : null;
            if (view2 != null) {
                numValueOf = Integer.valueOf(view2.getId());
            }
            FLog.i(TAG, "<%s id=%d parentTag=%s isRoot=%b />", name, Integer.valueOf(viewState.mReactTag), numValueOf, Boolean.valueOf(viewState.mIsRoot));
        }
    }

    @Deprecated
    public void receiveCommand(int i2, int i3, @Nullable ReadableArray readableArray) {
        if (isStopped()) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null) {
            throw new RetryableMountingLayerException(b.d(i2, i3, "Unable to find viewState for tag: [", "] for commandId: "));
        }
        ViewManager viewManager = nullableViewState.mViewManager;
        if (viewManager == null) {
            throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewManager for tag "));
        }
        View view = nullableViewState.mView;
        if (view == null) {
            throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewState view for tag "));
        }
        viewManager.receiveCommand((ViewManager) view, i3, readableArray);
    }

    @UiThread
    public void removeViewAt(final int i2, final int i3, int i4) {
        final int i5;
        if (isStopped()) {
            return;
        }
        if (this.mErroneouslyReaddedReactTags.contains(Integer.valueOf(i2))) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException(b.g(i2, "removeViewAt tried to remove a React View that was actually reused. This indicates a bug in the Differ (specifically instruction ordering). [", "]")));
            return;
        }
        UiThreadUtil.assertOnUiThread();
        ViewState nullableViewState = getNullableViewState(i3);
        if (nullableViewState == null) {
            ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException(b.g(i3, "Unable to find viewState for tag: [", "] for removeViewAt")));
            return;
        }
        View view = nullableViewState.mView;
        if (!(view instanceof ViewGroup)) {
            StringBuilder sbT = b.t(i3, i2, "Unable to remove a view from a view that is not a ViewGroup. ParentTag: ", " - Tag: ", " - Index: ");
            sbT.append(i4);
            String string = sbT.toString();
            FLog.g(TAG, string);
            throw new IllegalStateException(string);
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup == null) {
            throw new IllegalStateException(b.g(i3, "Unable to find view for tag [", "]"));
        }
        int i6 = 0;
        if (SHOW_CHANGED_VIEW_HIERARCHIES) {
            String str = TAG;
            StringBuilder sbT2 = b.t(i2, i3, "removeViewAt: [", "] -> [", "] idx: ");
            sbT2.append(i4);
            sbT2.append(" BEFORE");
            FLog.g(str, sbT2.toString());
            logViewHierarchy(viewGroup, false);
        }
        IViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
        View childAt = viewGroupManager.getChildAt(viewGroup, i4);
        int id = childAt != null ? childAt.getId() : -1;
        if (id != i2) {
            int childCount = viewGroup.getChildCount();
            while (true) {
                if (i6 >= childCount) {
                    i6 = -1;
                    break;
                } else if (viewGroup.getChildAt(i6).getId() == i2) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 == -1) {
                String str2 = TAG;
                StringBuilder sbT3 = b.t(i2, i3, "removeViewAt: [", "] -> [", "] @");
                sbT3.append(i4);
                sbT3.append(": view already removed from parent! Children in parent: ");
                sbT3.append(childCount);
                FLog.g(str2, sbT3.toString());
                return;
            }
            logViewHierarchy(viewGroup, true);
            String str3 = TAG;
            StringBuilder sbT4 = b.t(i2, i3, "Tried to remove view [", "] of parent [", "] at index ");
            android.support.v4.media.a.q(i4, id, ", but got view tag ", " - actual index of view: ", sbT4);
            sbT4.append(i6);
            ReactSoftExceptionLogger.logSoftException(str3, new IllegalStateException(sbT4.toString()));
            i5 = i6;
        } else {
            i5 = i4;
        }
        try {
            viewGroupManager.removeViewAt(viewGroup, i5);
            if (SHOW_CHANGED_VIEW_HIERARCHIES) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.mounting.SurfaceMountingManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FLog.g(SurfaceMountingManager.TAG, "removeViewAt: [" + i2 + "] -> [" + i3 + "] idx: " + i5 + " AFTER");
                        SurfaceMountingManager.logViewHierarchy(viewGroup, false);
                    }
                });
            }
        } catch (RuntimeException e2) {
            int childCount2 = viewGroupManager.getChildCount(viewGroup);
            logViewHierarchy(viewGroup, true);
            StringBuilder sbU = b.u(i5, "Cannot remove child at index ", " from parent ViewGroup [");
            sbU.append(viewGroup.getId());
            sbU.append("], only ");
            sbU.append(childCount2);
            sbU.append(" children in parent. Warning: childCount may be incorrect!");
            throw new IllegalStateException(sbU.toString(), e2);
        }
    }

    @ThreadConfined
    @UiThread
    public void scheduleMountItemOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachMountItems.add(mountItem);
    }

    public void sendAccessibilityEvent(int i2, int i3) {
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        if (viewState.mViewManager == null) {
            throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewState manager for tag "));
        }
        View view = viewState.mView;
        if (view == null) {
            throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewState view for tag "));
        }
        view.sendAccessibilityEvent(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public synchronized void setJSResponder(int i2, int i3, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        if (!z) {
            this.mJSResponderHandler.b(i3, null);
            return;
        }
        ViewState viewState = getViewState(i2);
        View view = viewState.mView;
        if (i3 != i2 && (view instanceof ViewParent)) {
            this.mJSResponderHandler.b(i3, (ViewParent) view);
            return;
        }
        if (view == 0) {
            SoftAssertions.assertUnreachable("Cannot find view for tag [" + i2 + "].");
            return;
        }
        if (viewState.mIsRoot) {
            SoftAssertions.assertUnreachable("Cannot block native responder on [" + i2 + "] that is a root view");
        }
        this.mJSResponderHandler.b(i3, view.getParent());
    }

    @AnyThread
    public void stopSurface() {
        FLog.g(TAG, "Stopping surface [" + this.mSurfaceId + "]");
        if (isStopped()) {
            return;
        }
        this.mIsStopped = true;
        for (ViewState viewState : this.mTagToViewState.values()) {
            StateWrapper stateWrapper = viewState.mStateWrapper;
            if (stateWrapper != null) {
                stateWrapper.destroyState();
                viewState.mStateWrapper = null;
            }
            EventEmitterWrapper eventEmitterWrapper = viewState.mEventEmitter;
            if (eventEmitterWrapper != null) {
                eventEmitterWrapper.destroy();
                viewState.mEventEmitter = null;
            }
        }
        androidx.constraintlayout.helper.widget.a aVar = new androidx.constraintlayout.helper.widget.a(this, 14);
        if (UiThreadUtil.isOnUiThread()) {
            aVar.run();
        } else {
            UiThreadUtil.runOnUiThread(aVar);
        }
    }

    public void sweepActiveTouchForTag(int i2) {
        if (ReactNativeFeatureFlags.f18968a.enableEventEmitterRetentionDuringGesturesOnAndroid()) {
            this.mViewsWithActiveTouches.remove(Integer.valueOf(i2));
            if (this.mViewsToDeleteAfterTouchFinishes.contains(Integer.valueOf(i2))) {
                this.mViewsToDeleteAfterTouchFinishes.remove(Integer.valueOf(i2));
                deleteView(i2);
            }
        }
    }

    @UiThread
    public void updateEventEmitter(int i2, @NonNull EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i2));
        if (viewState == null) {
            viewState = new ViewState(i2, 0);
            this.mTagToViewState.put(Integer.valueOf(i2), viewState);
        }
        EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
        viewState.mEventEmitter = eventEmitterWrapper;
        if (eventEmitterWrapper2 != eventEmitterWrapper && eventEmitterWrapper2 != null) {
            eventEmitterWrapper2.destroy();
        }
        Queue<PendingViewEvent> queue = viewState.mPendingEventQueue;
        if (queue != null) {
            Iterator<PendingViewEvent> it = queue.iterator();
            while (it.hasNext()) {
                it.next().dispatch(eventEmitterWrapper);
            }
            viewState.mPendingEventQueue = null;
        }
    }

    @UiThread
    public void updateLayout(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        if (viewState.mIsRoot) {
            return;
        }
        View view = viewState.mView;
        if (view == null) {
            throw new IllegalStateException(b.f(i2, "Unable to find View for tag: "));
        }
        int i10 = 1;
        if (i9 == 1) {
            i10 = 0;
        } else if (i9 != 2) {
            i10 = 2;
        }
        view.setLayoutDirection(i10);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        NativeModule nativeModule = getViewState(i3).mViewManager;
        IViewGroupManager iViewGroupManager = nativeModule != null ? (IViewGroupManager) nativeModule : null;
        if (iViewGroupManager == null || !iViewGroupManager.needsCustomLayoutForChildren()) {
            view.layout(i4, i5, i6 + i4, i7 + i5);
        }
        int i11 = i8 == 0 ? 4 : 0;
        if (view.getVisibility() != i11) {
            view.setVisibility(i11);
        }
    }

    @UiThread
    public void updateOverflowInset(int i2, int i3, int i4, int i5, int i6) {
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        if (viewState.mIsRoot) {
            return;
        }
        KeyEvent.Callback callback = viewState.mView;
        if (callback == null) {
            throw new IllegalStateException(b.f(i2, "Unable to find View for tag: "));
        }
        if (callback instanceof ReactOverflowViewWithInset) {
            ((ReactOverflowViewWithInset) callback).setOverflowInset(i3, i4, i5, i6);
        }
    }

    @UiThread
    public void updatePadding(int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        if (viewState.mIsRoot) {
            return;
        }
        View view = viewState.mView;
        if (view == null) {
            throw new IllegalStateException(b.f(i2, "Unable to find View for tag: "));
        }
        ViewManager viewManager = viewState.mViewManager;
        if (viewManager != null) {
            viewManager.setPadding(view, i3, i4, i5, i6);
        } else {
            throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
        }
    }

    public void updateProps(int i2, ReadableMap readableMap) {
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        viewState.mCurrentProps = new ReactStylesDiffMap(readableMap);
        View view = viewState.mView;
        if (view == null) {
            throw new IllegalStateException(b.g(i2, "Unable to find view for tag [", "]"));
        }
        ViewManager viewManager = viewState.mViewManager;
        Assertions.c(viewManager);
        viewManager.updateProperties(view, viewState.mCurrentProps);
    }

    @UiThread
    public void updateState(int i2, @Nullable StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (isStopped()) {
            return;
        }
        ViewState viewState = getViewState(i2);
        StateWrapper stateWrapper2 = viewState.mStateWrapper;
        viewState.mStateWrapper = stateWrapper;
        ViewManager viewManager = viewState.mViewManager;
        if (viewManager == null) {
            throw new IllegalStateException(b.f(i2, "Unable to find ViewManager for tag: "));
        }
        Object objUpdateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
        if (objUpdateState != null) {
            viewManager.updateExtraData(viewState.mView, objUpdateState);
        }
        if (stateWrapper2 != null) {
            stateWrapper2.destroyState();
        }
    }

    public void receiveCommand(int i2, @NonNull String str, @Nullable ReadableArray readableArray) {
        if (isStopped()) {
            return;
        }
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState != null) {
            ViewManager viewManager = nullableViewState.mViewManager;
            if (viewManager != null) {
                View view = nullableViewState.mView;
                if (view != null) {
                    viewManager.receiveCommand((ViewManager) view, str, readableArray);
                    return;
                }
                throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewState view for tag "));
            }
            throw new RetryableMountingLayerException(b.f(i2, "Unable to find viewState manager for tag "));
        }
        throw new RetryableMountingLayerException(b.h(i2, "Unable to find viewState for tag: ", " for commandId: ", str));
    }
}
