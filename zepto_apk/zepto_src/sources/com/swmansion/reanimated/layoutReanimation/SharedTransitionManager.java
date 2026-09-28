package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.reanimated.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class SharedTransitionManager {
    private final AnimationsManager mAnimationsManager;
    private NativeMethodsHolder mNativeMethodsHolder;
    private View mTransitionContainer;
    private final List<View> mAddedSharedViews = new ArrayList();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final Map<Integer, SortedSet<Integer>> mSharedViewChildrenIndices = new HashMap();
    private final List<View> mRemovedSharedViews = new ArrayList();
    private final Set<Integer> mViewTagsToHide = new HashSet();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, SharedElement> mSharedElementsLookup = new HashMap();
    private final List<SharedElement> mSharedElementsWithProgress = new ArrayList();
    private final List<SharedElement> mSharedElementsWithAnimation = new ArrayList();
    private final Set<View> mReattachedViews = new HashSet();
    private boolean mIsTransitionPrepared = false;
    private final Set<Integer> mTagsToCleanup = new HashSet();

    /* loaded from: classes4.dex */
    public class PrepareConfigCleanupTreeVisitor implements TreeVisitor {
        public PrepareConfigCleanupTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            SharedTransitionManager.this.mTagsToCleanup.add(Integer.valueOf(view.getId()));
        }
    }

    /* loaded from: classes4.dex */
    public class SnapshotTreeVisitor implements TreeVisitor {
        public SnapshotTreeVisitor() {
        }

        @Override // com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor
        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class TopWillAppearListener implements EventDispatcherListener {
        private final EventDispatcher mEventDispatcher;

        public TopWillAppearListener(EventDispatcher eventDispatcher) {
            this.mEventDispatcher = eventDispatcher;
        }

        @Override // com.facebook.react.uimanager.events.EventDispatcherListener
        public void onEventDispatch(Event event) {
            if (event.getEventName().equals("topWillAppear")) {
                SharedTransitionManager sharedTransitionManager = SharedTransitionManager.this;
                sharedTransitionManager.tryStartSharedTransitionForViews(sharedTransitionManager.mAddedSharedViews, true);
                SharedTransitionManager.this.mAddedSharedViews.clear();
                this.mEventDispatcher.d(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface TreeVisitor {
        void run(View view);
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    private void clearAllSharedConfigsForView(View view) {
        int id = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id));
        this.mNativeMethodsHolder.clearAnimationConfig(id);
    }

    private void disableCleaningForViewTag(int i2) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i2));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i2), 1);
        }
    }

    private void enableCleaningForViewTag(int i2) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i2));
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.mDisableCleaningForViewTag.remove(Integer.valueOf(i2));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findScreen(View view) {
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("Screen")) {
                return (View) parent;
            }
        }
        return null;
    }

    private void findSharedViewsForScreen(View view, List<View> list) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                list.add(topScreenForStack);
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                findSharedViewsForScreen(viewGroup.getChildAt(i2), list);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private View findStack(View view) {
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("ScreenStack")) {
                return (View) parent;
            }
        }
        return null;
    }

    private List<SharedElement> getSharedElementsForCurrentTransition(List<View> list, boolean z) {
        boolean z2;
        ViewGroup viewGroup;
        boolean z3 = this.mReattachedViews.size() > 0;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (!z) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(Integer.valueOf(it.next().getId()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        HashSet hashSet2 = new HashSet();
        Iterator<View> it2 = this.mRemovedSharedViews.iterator();
        while (it2.hasNext()) {
            hashSet2.add(Integer.valueOf(it2.next().getId()));
        }
        for (View view : list) {
            int iFindPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(view.getId());
            if (z3) {
                while (hashSet2.contains(Integer.valueOf(iFindPrecedingViewTagForTransition))) {
                    this.mNativeMethodsHolder.clearAnimationConfig(iFindPrecedingViewTagForTransition);
                    iFindPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(view.getId());
                }
            }
            boolean z4 = !z && hashSet.contains(Integer.valueOf(iFindPrecedingViewTagForTransition));
            if (iFindPrecedingViewTagForTransition >= 0) {
                View viewMaybeOverrideSiblingForTabNavigator = maybeOverrideSiblingForTabNavigator(view, reanimatedNativeHierarchyManager.resolveView(iFindPrecedingViewTagForTransition));
                if (z) {
                    viewMaybeOverrideSiblingForTabNavigator = view;
                    view = viewMaybeOverrideSiblingForTabNavigator;
                }
                if (z4) {
                    clearAllSharedConfigsForView(view);
                    clearAllSharedConfigsForView(viewMaybeOverrideSiblingForTabNavigator);
                } else {
                    boolean zContainsKey = this.mCurrentSharedTransitionViews.containsKey(Integer.valueOf(view.getId()));
                    if (zContainsKey) {
                        z2 = z3;
                    } else {
                        View viewFindScreen = findScreen(view);
                        View viewFindScreen2 = findScreen(viewMaybeOverrideSiblingForTabNavigator);
                        if (viewFindScreen != null && viewFindScreen2 != null && (viewGroup = (ViewGroup) findStack(viewFindScreen)) != null) {
                            ViewGroupManager viewGroupManager = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId());
                            z2 = z3;
                            boolean z5 = false;
                            for (int i2 = 0; i2 < viewGroupManager.getChildCount((ViewGroupManager) viewGroup); i2++) {
                                if (viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i2) == viewFindScreen2) {
                                    z5 = true;
                                }
                            }
                            if (z5) {
                                ViewGroupManager viewGroupManager2 = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId());
                                int childCount = viewGroupManager2.getChildCount((ViewGroupManager) viewGroup);
                                if (childCount >= 2) {
                                    View childAt = viewGroupManager2.getChildAt((ViewGroupManager) viewGroup, childCount - 1);
                                    View childAt2 = viewGroupManager2.getChildAt((ViewGroupManager) viewGroup, childCount - 2);
                                    if (!z ? !(childAt.getId() != viewFindScreen.getId() || childAt2.getId() != viewFindScreen2.getId()) : !(childAt2.getId() != viewFindScreen.getId() || childAt.getId() != viewFindScreen2.getId())) {
                                    }
                                }
                                z3 = z2;
                            }
                        }
                    }
                    Snapshot snapshot = null;
                    if (z) {
                        this.mViewTagsToHide.add(Integer.valueOf(view.getId()));
                        if (zContainsKey) {
                            snapshot = new Snapshot(view);
                        } else {
                            makeSnapshot(view);
                        }
                        makeSnapshot(viewMaybeOverrideSiblingForTabNavigator);
                    } else if (zContainsKey) {
                        makeSnapshot(view);
                    }
                    if (snapshot == null) {
                        snapshot = this.mSnapshotRegistry.get(Integer.valueOf(view.getId()));
                    }
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(viewMaybeOverrideSiblingForTabNavigator.getId()));
                    if (snapshot2 == null) {
                        makeSnapshot(viewMaybeOverrideSiblingForTabNavigator);
                    }
                    arrayList.add(view);
                    arrayList.add(viewMaybeOverrideSiblingForTabNavigator);
                    arrayList2.add(new SharedElement(view, snapshot, viewMaybeOverrideSiblingForTabNavigator, snapshot2));
                    z3 = z2;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<SharedElement> it3 = this.mSharedElements.iterator();
            while (it3.hasNext()) {
                arrayList3.add(it3.next().sourceView);
            }
            HashSet hashSet3 = new HashSet();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                hashSet3.add(((SharedElement) it4.next()).sourceView);
            }
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                View view2 = (View) it5.next();
                if (!hashSet3.contains(view2)) {
                    this.mViewTagsToHide.remove(Integer.valueOf(view2.getId()));
                    view2.setVisibility(0);
                }
            }
            this.mCurrentSharedTransitionViews.clear();
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                View view3 = (View) it6.next();
                this.mCurrentSharedTransitionViews.put(Integer.valueOf(view3.getId()), view3);
            }
        }
        this.mSharedElements = arrayList2;
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            SharedElement sharedElement = (SharedElement) it7.next();
            this.mSharedElementsLookup.put(Integer.valueOf(sharedElement.sourceView.getId()), sharedElement);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishSharedAnimation$1(ViewParent viewParent) {
        if (this.mReattachedViews.size() > 0) {
            return;
        }
        ((ViewGroup) viewParent).removeView(this.mTransitionContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortViewsByTags$0(View view, View view2) {
        return Integer.compare(view2.getId(), view.getId());
    }

    private View maybeOverrideSiblingForTabNavigator(View view, View view2) {
        View tabNavigator = ScreensHelper.getTabNavigator(view);
        if (tabNavigator == null) {
            return view2;
        }
        int id = view2.getId();
        int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view.getId());
        int i2 = -1;
        for (int i3 = 0; i3 < sharedGroup.length; i3++) {
            if (sharedGroup[i3] == id) {
                i2 = i3;
            }
        }
        while (i2 >= 0) {
            View viewResolveView = this.mAnimationsManager.resolveView(sharedGroup[i2]);
            if (tabNavigator == ScreensHelper.getTabNavigator(viewResolveView)) {
                return viewResolveView;
            }
            i2--;
        }
        return view2;
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SharedElement sharedElement : this.mSharedElements) {
            if (sharedElement.targetView == view2) {
                arrayList.add(sharedElement);
                View view3 = sharedElement.sourceView;
                View view4 = sharedElement.targetView;
                Snapshot snapshot = new Snapshot(view3);
                Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                Snapshot snapshot3 = new Snapshot(view4);
                int i2 = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                int i3 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                snapshot2.originX = i2;
                snapshot2.originY = i3;
                snapshot2.globalOriginX = i2;
                snapshot2.globalOriginY = i3;
                snapshot2.originXByParent = snapshot3.originXByParent;
                snapshot2.originYByParent = snapshot3.originYByParent;
                snapshot2.height = snapshot3.height;
                snapshot2.width = snapshot3.width;
                sharedElement.sourceViewSnapshot = snapshot;
                sharedElement.targetViewSnapshot = snapshot2;
                disableCleaningForViewTag(view3.getId());
                disableCleaningForViewTag(view4.getId());
            }
        }
        startSharedTransition(arrayList, 4);
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        Iterator<SharedElement> it = list.iterator();
        while (it.hasNext()) {
            View view = it.next().sourceView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int id = viewGroup.getId();
                int iIndexOfChild = viewGroup.indexOfChild(view);
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(iIndexOfChild));
                SortedSet<Integer> sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id));
                if (sortedSet == null) {
                    this.mSharedViewChildrenIndices.put(Integer.valueOf(id), new TreeSet(Collections.singleton(Integer.valueOf(iIndexOfChild))));
                } else {
                    sortedSet.add(Integer.valueOf(iIndexOfChild));
                }
            }
        }
        Iterator<SharedElement> it2 = list.iterator();
        while (it2.hasNext()) {
            View view2 = it2.next().sourceView;
            ((ViewGroup) view2.getParent()).removeView(view2);
            ((ViewGroup) this.mTransitionContainer).addView(view2);
            this.mReattachedViews.add(view2);
        }
    }

    private void setupTransitionContainer() {
        Activity currentActivity;
        if (this.mTransitionContainer == null) {
            this.mTransitionContainer = new ReactViewGroup(this.mAnimationsManager.getContext());
        }
        if (this.mTransitionContainer.getParent() != null || (currentActivity = this.mAnimationsManager.getContext().getCurrentActivity()) == null) {
            return;
        }
        ((ViewGroup) currentActivity.getWindow().getDecorView().getRootView()).addView(this.mTransitionContainer);
        this.mTransitionContainer.bringToFront();
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, new androidx.media3.datasource.cache.a(3));
    }

    private void startPreparedTransitions() {
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
        startSharedTransition(this.mSharedElementsWithProgress, 5);
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2, int i2) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> mapPrepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap<String, Object> map = new HashMap<>(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        map.putAll(mapPrepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), i2, map);
    }

    private void startSharedTransition(List<SharedElement> list, int i2) {
        for (SharedElement sharedElement : list) {
            View view = sharedElement.sourceView;
            view.setVisibility(0);
            startSharedAnimationForView(view, sharedElement.sourceViewSnapshot, sharedElement.targetViewSnapshot, i2);
            sharedElement.targetView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryStartSharedTransitionForViews(List<View> list, boolean z) {
        if (!prepareSharedTransition(list, z)) {
            return false;
        }
        startPreparedTransitions();
        return true;
    }

    private void visitTree(View view, TreeVisitor treeVisitor) {
        int id = view.getId();
        if (id == -1) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        try {
            treeVisitor.run(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewManager viewManagerResolveViewManager = reanimatedNativeHierarchyManager.resolveViewManager(id);
                ViewGroupManager viewGroupManager = viewManagerResolveViewManager instanceof ViewGroupManager ? (ViewGroupManager) viewManagerResolveViewManager : null;
                if (viewGroupManager == null) {
                    return;
                }
                for (int i2 = 0; i2 < viewGroupManager.getChildCount((ViewGroupManager) viewGroup); i2++) {
                    visitTree(viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i2), treeVisitor);
                }
            }
        } catch (IllegalViewOperationException unused) {
        }
    }

    public void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                Log.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    public void finishSharedAnimation(int i2) {
        ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i2))) {
            enableCleaningForViewTag(i2);
            return;
        }
        SharedElement sharedElement = this.mSharedElementsLookup.get(Integer.valueOf(i2));
        if (sharedElement == null) {
            return;
        }
        this.mSharedElementsLookup.remove(Integer.valueOf(i2));
        View view = sharedElement.sourceView;
        if (this.mReattachedViews.contains(view)) {
            this.mReattachedViews.remove(view);
            int id = view.getId();
            ((ViewGroup) this.mTransitionContainer).removeView(view);
            View view2 = this.mSharedTransitionParent.get(Integer.valueOf(id));
            Integer num = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id));
            int iIntValue = num.intValue();
            ViewGroup viewGroup = (ViewGroup) view2;
            int id2 = viewGroup.getId();
            SortedSet<Integer> sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id2));
            int size = sortedSet.headSet(num).size();
            sortedSet.remove(num);
            if (sortedSet.isEmpty()) {
                this.mSharedViewChildrenIndices.remove(Integer.valueOf(id2));
            }
            int i3 = iIntValue - size;
            if (i3 <= viewGroup.getChildCount()) {
                viewGroup.addView(view, i3);
            } else {
                viewGroup.addView(view);
            }
            Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id));
            if (snapshot != null) {
                int i4 = snapshot.originX;
                int i5 = snapshot.originY;
                if (findStack(view) == null) {
                    snapshot.originX = snapshot.originXByParent;
                    snapshot.originY = snapshot.originYByParent;
                }
                HashMap<String, Object> basicMap = snapshot.toBasicMap();
                HashMap map = new HashMap();
                for (String str : basicMap.keySet()) {
                    Object obj = basicMap.get(str);
                    if (str.equals(Snapshot.TRANSFORM_MATRIX)) {
                        map.put(str, obj);
                    } else {
                        map.put(str, Double.valueOf(PixelUtil.a(Utils.convertToFloat(obj))));
                    }
                }
                this.mAnimationsManager.progressLayoutAnimation(id, map, true);
                snapshot.originX = i4;
                snapshot.originY = i5;
            }
            if (this.mViewTagsToHide.contains(Integer.valueOf(i2))) {
                view.setVisibility(4);
            }
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(sharedElement.targetView.getId()));
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id));
            this.mSharedTransitionParent.remove(Integer.valueOf(id));
            this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id));
        }
        sharedElement.targetView.setVisibility(0);
        if (this.mRemovedSharedViews.contains(view)) {
            this.mRemovedSharedViews.remove(view);
            this.mSnapshotRegistry.remove(Integer.valueOf(view.getId()));
            this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        }
        if (this.mReattachedViews.isEmpty()) {
            View view3 = this.mTransitionContainer;
            if (view3 != null && (parent = view3.getParent()) != null) {
                this.mTransitionContainer.post(new androidx.constraintlayout.motion.widget.a(27, this, parent));
            }
            this.mSharedElements.clear();
            this.mSharedElementsWithProgress.clear();
            this.mSharedElementsWithAnimation.clear();
            this.mViewTagsToHide.clear();
        }
    }

    @Nullable
    public View getTransitioningView(int i2) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i2));
    }

    public void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    public void navigationTabChanged(View view, View view2) {
        Snapshot snapshot;
        this.mAddedSharedViews.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        findSharedViewsForScreen(view, arrayList2);
        sortViewsByTags(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            View view3 = (View) it.next();
            int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view3.getId());
            int length = sharedGroup.length - 1;
            while (true) {
                if (length >= 0) {
                    View viewResolveView = this.mAnimationsManager.resolveView(sharedGroup[length]);
                    if (ScreensHelper.isViewChildOfScreen(viewResolveView, view2) && (snapshot = this.mSnapshotRegistry.get(Integer.valueOf(view3.getId()))) != null) {
                        arrayList.add(new SharedElement(view3, snapshot, viewResolveView, new Snapshot(viewResolveView)));
                        break;
                    }
                    length--;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.mSharedElements = arrayList;
        this.mSharedElementsWithAnimation.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SharedElement sharedElement = (SharedElement) it2.next();
            this.mSharedElementsLookup.put(Integer.valueOf(sharedElement.sourceView.getId()), sharedElement);
            this.mSharedElementsWithAnimation.add(sharedElement);
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(arrayList);
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
    }

    public void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    public void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    public void onScreenWillDisappear() {
        Iterator<Integer> it = this.mTagsToCleanup.iterator();
        while (it.hasNext()) {
            this.mNativeMethodsHolder.clearAnimationConfig(it.next().intValue());
        }
        this.mTagsToCleanup.clear();
        if (this.mIsTransitionPrepared) {
            this.mIsTransitionPrepared = false;
            for (SharedElement sharedElement : this.mSharedElementsWithAnimation) {
                sharedElement.targetViewSnapshot = new Snapshot(sharedElement.targetView);
            }
            for (SharedElement sharedElement2 : this.mSharedElementsWithProgress) {
                sharedElement2.targetViewSnapshot = new Snapshot(sharedElement2.targetView);
            }
            startPreparedTransitions();
        }
    }

    public void onViewsRemoval(int[] iArr) {
        if (iArr == null) {
            return;
        }
        visitTreeForTags(iArr, new SnapshotTreeVisitor());
        if (this.mRemovedSharedViews.size() > 0) {
            boolean zPrepareSharedTransition = prepareSharedTransition(this.mRemovedSharedViews, false);
            this.mIsTransitionPrepared = zPrepareSharedTransition;
            if (!zPrepareSharedTransition) {
                this.mRemovedSharedViews.clear();
            }
            visitTreeForTags(iArr, new PrepareConfigCleanupTreeVisitor());
        }
    }

    public void orderByAnimationTypes(List<SharedElement> list) {
        this.mSharedElementsWithProgress.clear();
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement sharedElement : list) {
            if (this.mAnimationsManager.hasAnimationForTag(sharedElement.sourceView.getId(), 5)) {
                this.mSharedElementsWithProgress.add(sharedElement);
            } else {
                this.mSharedElementsWithAnimation.add(sharedElement);
            }
        }
    }

    public boolean prepareSharedTransition(List<View> list, boolean z) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        orderByAnimationTypes(sharedElementsForCurrentTransition);
        return true;
    }

    public void screenDidLayout(View view) {
        EventDispatcher eventDispatcherB;
        if (this.mAddedSharedViews.isEmpty() || (eventDispatcherB = UIManagerHelper.b((ReactContext) view.getContext(), view.getId())) == null) {
            return;
        }
        eventDispatcherB.e(new TopWillAppearListener(eventDispatcherB));
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    public void viewDidLayout(View view) {
    }

    public void visitNativeTreeAndMakeSnapshot(View view) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                makeSnapshot(topScreenForStack);
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i2));
            }
        }
    }

    public void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr == null) {
            return;
        }
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        for (int i2 : iArr) {
            visitTree(reanimatedNativeHierarchyManager.resolveView(i2), treeVisitor);
        }
    }
}
