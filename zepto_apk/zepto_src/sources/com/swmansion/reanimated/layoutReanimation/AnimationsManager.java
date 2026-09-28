package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class AnimationsManager implements ViewHierarchyObserver {
    private ReactContext mContext;
    private NativeMethodsHolder mNativeMethodsHolder;
    private ReanimatedNativeHierarchyManager mReanimatedNativeHierarchyManager;
    private UIManager mUIManager;
    private WeakReference<AndroidUIScheduler> mWeakAndroidUIScheduler;
    private final HashSet<Integer> mEnteringViews = new HashSet<>();
    private final HashMap<Integer, Rect> mEnteringViewTargetValues = new HashMap<>();
    private HashMap<Integer, View> mExitingViews = new HashMap<>();
    private HashMap<Integer, Integer> mExitingSubviewCountMap = new HashMap<>();
    private HashSet<Integer> mAncestorsToRemove = new HashSet<>();
    private HashMap<Integer, Runnable> mCallbacks = new HashMap<>();
    private boolean isInvalidated = false;
    private final SharedTransitionManager mSharedTransitionManager = new SharedTransitionManager(this);

    public AnimationsManager(ReactContext reactContext, UIManager uIManager) {
        this.mContext = reactContext;
        this.mUIManager = uIManager;
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
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else {
            if (!(obj instanceof ReadableMap)) {
                throw new IllegalStateException("[Reanimated] Unknown type of animated value for Layout Animations.");
            }
            writableMap.putMap(str, (ReadableMap) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkDuplicateSharedTag(View view) {
        int id = view.getId();
        ViewParent parent = view.getParent();
        while (parent != 0 && !parent.getClass().getSimpleName().equals("Screen")) {
            parent = parent.getParent();
        }
        if (parent != 0) {
            this.mNativeMethodsHolder.checkDuplicateSharedTag(id, ((View) parent).getId());
        }
    }

    private static Point convertScreenLocationToViewCoordinates(Point point, View view) {
        int[] iArr = {0, 0};
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return new Point(point.x - iArr[0], point.y - iArr[1]);
    }

    private void maybeDropAncestors(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            while (view2 != null && !(view2 instanceof RootView)) {
                View view3 = (View) view2.getParent();
                int id = view2.getId();
                int iIntValue = this.mExitingSubviewCountMap.get(Integer.valueOf(id)) != null ? r2.intValue() - 1 : 0;
                Integer numValueOf = Integer.valueOf(iIntValue);
                if (iIntValue <= 0) {
                    if (this.mAncestorsToRemove.contains(Integer.valueOf(id))) {
                        this.mAncestorsToRemove.remove(Integer.valueOf(id));
                        if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                            removeView(view2, (ViewGroup) view3);
                        }
                    }
                    this.mExitingSubviewCountMap.remove(Integer.valueOf(id));
                } else {
                    this.mExitingSubviewCountMap.put(Integer.valueOf(id), numValueOf);
                }
                view2 = view3;
            }
        }
    }

    private void registerExitingAncestors(View view) {
        for (View view2 = (View) view.getParent(); view2 != null && !(view2 instanceof RootView); view2 = (View) view2.getParent()) {
            int id = view2.getId();
            Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id));
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            this.mExitingSubviewCountMap.put(Integer.valueOf(id), Integer.valueOf(iIntValue));
        }
    }

    private boolean removeOrAnimateExitRecursive(View view, boolean z, boolean z2) {
        boolean z3;
        int id = view.getId();
        ViewManager viewManagerResolveViewManager = resolveViewManager(id);
        if (viewManagerResolveViewManager != null) {
            String name = viewManagerResolveViewManager.getName();
            if (name.equals(ReactModalHostManager.REACT_CLASS) || name.equals(ScreenViewManager.REACT_CLASS) || name.equals(ScreenStackViewManager.REACT_CLASS)) {
                cancelAnimationsRecursive(view);
                return false;
            }
        }
        boolean zShouldAnimateExiting = shouldAnimateExiting(id, z2);
        boolean z4 = zShouldAnimateExiting && (hasAnimationForTag(id, 2) || this.mExitingViews.containsKey(Integer.valueOf(id)));
        boolean z5 = z && !z4;
        if (hasAnimationForTag(id, 4)) {
            this.mSharedTransitionManager.notifyAboutRemovedView(view);
            this.mSharedTransitionManager.makeSnapshot(view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z3 = false;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (removeOrAnimateExitRecursive(childAt, z5, zShouldAnimateExiting)) {
                    z3 = true;
                } else if (z5 && childAt.getId() != -1) {
                    arrayList.add(childAt);
                }
            }
        } else {
            z3 = false;
        }
        boolean z6 = z4 || z3;
        if (z4) {
            HashMap<String, Object> mapPrepareDataForAnimationWorklet = prepareDataForAnimationWorklet(new Snapshot(view, this.mReanimatedNativeHierarchyManager).toCurrentMap(), false);
            if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                this.mExitingViews.put(Integer.valueOf(id), view);
                registerExitingAncestors(view);
                this.mNativeMethodsHolder.startAnimation(id, 2, mapPrepareDataForAnimationWorklet);
            }
        }
        this.mNativeMethodsHolder.clearAnimationConfig(id);
        if (!z6) {
            return false;
        }
        if (z3) {
            if (id == -1) {
                cancelAnimationsRecursive(view);
                return false;
            }
            this.mAncestorsToRemove.add(Integer.valueOf(id));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeView((View) it.next(), (ViewGroup) view);
        }
        return true;
    }

    private void removeView(View view, @Nullable ViewGroup viewGroup) {
        int id = view.getId();
        if (this.mCallbacks.containsKey(Integer.valueOf(id))) {
            Runnable runnable = this.mCallbacks.get(Integer.valueOf(id));
            this.mCallbacks.remove(Integer.valueOf(id));
            if (runnable != null) {
                runnable.run();
            }
        } else {
            this.mReanimatedNativeHierarchyManager.publicDropView(view);
        }
        if (viewGroup == null || viewGroup.indexOfChild(view) == -1) {
            return;
        }
        viewGroup.removeView(view);
    }

    private ViewManager resolveViewManager(int i2) {
        try {
            return this.mReanimatedNativeHierarchyManager.resolveViewManager(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public void cancelAnimationsInSubviews(View view) {
        cancelAnimationsRecursive(view);
        clearAnimationConfigRecursive(view);
    }

    public void cancelAnimationsRecursive(View view) {
        if (this.mExitingViews.containsKey(Integer.valueOf(view.getId()))) {
            endLayoutAnimation(view.getId(), true);
        } else if ((view instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(view.getId()))) {
            cancelAnimationsInSubviews((ViewGroup) view);
        }
    }

    public void clearAnimationConfigRecursive(View view) {
        this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                clearAnimationConfigRecursive(viewGroup.getChildAt(i2));
            }
        }
    }

    public void endLayoutAnimation(int i2, boolean z) {
        View viewResolveView = resolveView(i2);
        if (viewResolveView == null) {
            return;
        }
        Rect rect = this.mEnteringViewTargetValues.get(Integer.valueOf(i2));
        if (!z && this.mEnteringViews.contains(Integer.valueOf(i2)) && rect != null) {
            viewResolveView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
        this.mEnteringViews.remove(Integer.valueOf(i2));
        this.mEnteringViewTargetValues.remove(Integer.valueOf(i2));
        if (z) {
            if ((viewResolveView instanceof ViewGroup) && this.mAncestorsToRemove.contains(Integer.valueOf(i2))) {
                cancelAnimationsInSubviews((ViewGroup) viewResolveView);
            }
            this.mExitingViews.remove(Integer.valueOf(i2));
            maybeDropAncestors(viewResolveView);
            removeView(viewResolveView, (ViewGroup) viewResolveView.getParent());
        }
        this.mSharedTransitionManager.finishSharedAnimation(i2);
    }

    public ReactContext getContext() {
        return this.mContext;
    }

    public ReanimatedNativeHierarchyManager getReanimatedNativeHierarchyManager() {
        return this.mReanimatedNativeHierarchyManager;
    }

    public boolean hasAnimationForTag(int i2, int i3) {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        return nativeMethodsHolder != null && nativeMethodsHolder.hasAnimation(i2, i3);
    }

    public void invalidate() {
        this.isInvalidated = true;
        this.mNativeMethodsHolder = null;
        this.mContext = null;
        this.mUIManager = null;
        this.mExitingViews = null;
        this.mExitingSubviewCountMap = null;
        this.mAncestorsToRemove = null;
        this.mCallbacks = null;
    }

    public boolean isLayoutAnimationEnabled() {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        return nativeMethodsHolder != null && nativeMethodsHolder.isLayoutAnimationEnabled();
    }

    public void makeSnapshotOfTopScreenViews(ViewGroup viewGroup) {
        this.mSharedTransitionManager.doSnapshotForTopScreenViews(viewGroup);
    }

    public void maybeRegisterSharedView(View view) {
        if (hasAnimationForTag(view.getId(), 4)) {
            this.mSharedTransitionManager.notifyAboutNewView(view);
        }
    }

    public void navigationTabChanged(View view, View view2) {
        this.mSharedTransitionManager.navigationTabChanged(view, view2);
    }

    public void notifyAboutScreenWillDisappear() {
        this.mSharedTransitionManager.onScreenWillDisappear();
    }

    public void notifyAboutViewsRemoval(int[] iArr) {
        this.mSharedTransitionManager.onViewsRemoval(iArr);
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewCreate(View view, ViewGroup viewGroup, Snapshot snapshot) {
        if (this.isInvalidated) {
            return;
        }
        maybeRegisterSharedView(view);
        if (hasAnimationForTag(view.getId(), 1)) {
            AndroidUIScheduler androidUIScheduler = this.mWeakAndroidUIScheduler.get();
            if (androidUIScheduler != null) {
                androidUIScheduler.triggerUI();
            }
            int id = view.getId();
            HashMap<String, Object> targetMap = snapshot.toTargetMap();
            if (targetMap != null) {
                this.mNativeMethodsHolder.startAnimation(id, 1, prepareDataForAnimationWorklet(targetMap, true));
                this.mEnteringViews.add(Integer.valueOf(id));
            }
        }
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewRemoval(View view, ViewGroup viewGroup, Runnable runnable) {
        if (this.isInvalidated) {
            return;
        }
        this.mCallbacks.put(Integer.valueOf(view.getId()), runnable);
        if (removeOrAnimateExitRecursive(view, true, true)) {
            return;
        }
        removeView(view, viewGroup);
    }

    @Override // com.swmansion.reanimated.layoutReanimation.ViewHierarchyObserver
    public void onViewUpdate(View view, Snapshot snapshot, Snapshot snapshot2) {
        if (this.isInvalidated) {
            return;
        }
        int id = view.getId();
        if (!hasAnimationForTag(id, 3)) {
            if (this.mEnteringViews.contains(Integer.valueOf(id))) {
                HashMap<Integer, Rect> map = this.mEnteringViewTargetValues;
                Integer numValueOf = Integer.valueOf(id);
                int i2 = snapshot2.originX;
                int i3 = snapshot2.originY;
                map.put(numValueOf, new Rect(i2, i3, snapshot2.width + i2, snapshot2.height + i3));
                int i4 = snapshot.originX;
                int i5 = snapshot.originY;
                view.layout(i4, i5, snapshot.width + i4, snapshot.height + i5);
                return;
            }
            return;
        }
        HashMap<String, Object> currentMap = snapshot.toCurrentMap();
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        boolean z = true;
        for (int i6 = 0; i6 < Snapshot.targetKeysToTransform.size(); i6++) {
            if (((Number) currentMap.get(Snapshot.currentKeysToTransform.get(i6))).doubleValue() != ((Number) targetMap.get(Snapshot.targetKeysToTransform.get(i6))).doubleValue()) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        HashMap<String, Object> mapPrepareDataForAnimationWorklet = prepareDataForAnimationWorklet(currentMap, false);
        HashMap<String, Object> map2 = new HashMap<>(prepareDataForAnimationWorklet(targetMap, true));
        for (String str : mapPrepareDataForAnimationWorklet.keySet()) {
            map2.put(str, mapPrepareDataForAnimationWorklet.get(str));
        }
        this.mNativeMethodsHolder.startAnimation(id, 3, map2);
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> map, boolean z) {
        return prepareDataForAnimationWorklet(map, z, false);
    }

    public void printSubTree(View view, int i2) {
        if (i2 == 0) {
            Log.v("rea", "----------------------");
        }
        if (view == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append("+");
        }
        sb.append(" TAG:");
        sb.append(view.getId());
        sb.append(" CLASS:");
        sb.append(view.getClass().getSimpleName());
        Log.v("rea", sb.toString());
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return;
            }
            printSubTree(viewGroup.getChildAt(i3), i2 + 1);
            i3++;
        }
    }

    public void progressLayoutAnimation(int i2, Map<String, Object> map, boolean z) {
        ViewGroup viewGroup;
        View viewResolveView = resolveView(i2);
        if (viewResolveView == null || (viewGroup = (ViewGroup) viewResolveView.getParent()) == null) {
            return;
        }
        ViewManager viewManagerResolveViewManager = resolveViewManager(i2);
        ViewManager viewManagerResolveViewManager2 = resolveViewManager(viewGroup.getId());
        if (viewManagerResolveViewManager == null) {
            return;
        }
        setNewProps(map, viewResolveView, viewManagerResolveViewManager, viewManagerResolveViewManager2, Integer.valueOf(viewGroup.getId()), z);
    }

    public View resolveView(int i2) {
        if (this.mExitingViews.containsKey(Integer.valueOf(i2))) {
            return this.mExitingViews.get(Integer.valueOf(i2));
        }
        View transitioningView = this.mSharedTransitionManager.getTransitioningView(i2);
        if (transitioningView != null) {
            return transitioningView;
        }
        try {
            return this.mUIManager.resolveView(i2);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }

    public void screenDidLayout(View view) {
        this.mSharedTransitionManager.screenDidLayout(view);
    }

    public void setAndroidUIScheduler(AndroidUIScheduler androidUIScheduler) {
        this.mWeakAndroidUIScheduler = new WeakReference<>(androidUIScheduler);
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
        this.mSharedTransitionManager.setNativeMethods(nativeMethodsHolder);
    }

    public void setNewProps(Map<String, Object> map, View view, ViewManager viewManager, ViewManager viewManager2, Integer num, boolean z) {
        float fFloatValue = map.get(Snapshot.ORIGIN_X) != null ? ((Double) map.get(Snapshot.ORIGIN_X)).floatValue() : PixelUtil.a(view.getLeft());
        float fFloatValue2 = map.get(Snapshot.ORIGIN_Y) != null ? ((Double) map.get(Snapshot.ORIGIN_Y)).floatValue() : PixelUtil.a(view.getTop());
        float fFloatValue3 = map.get(Snapshot.WIDTH) != null ? ((Double) map.get(Snapshot.WIDTH)).floatValue() : PixelUtil.a(view.getWidth());
        float fFloatValue4 = map.get(Snapshot.HEIGHT) != null ? ((Double) map.get(Snapshot.HEIGHT)).floatValue() : PixelUtil.a(view.getHeight());
        if (map.containsKey(Snapshot.TRANSFORM_MATRIX)) {
            float[] fArr = new float[9];
            Object obj = map.get(Snapshot.TRANSFORM_MATRIX);
            if (obj instanceof ReadableNativeArray) {
                ReadableNativeArray readableNativeArray = (ReadableNativeArray) obj;
                for (int i2 = 0; i2 < 9; i2++) {
                    fArr[i2] = Double.valueOf(readableNativeArray.getDouble(i2)).floatValue();
                }
            } else {
                ArrayList arrayList = (ArrayList) map.get(Snapshot.TRANSFORM_MATRIX);
                for (int i3 = 0; i3 < 9; i3++) {
                    fArr[i3] = ((Float) arrayList.get(i3)).floatValue();
                }
            }
            view.setScaleX(fArr[0]);
            view.setScaleY(fArr[4]);
            map.remove(Snapshot.TRANSFORM_MATRIX);
        }
        updateLayout(view, viewManager2, num.intValue(), fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, z);
        map.remove(Snapshot.ORIGIN_X);
        map.remove(Snapshot.ORIGIN_Y);
        map.remove(Snapshot.GLOBAL_ORIGIN_X);
        map.remove(Snapshot.GLOBAL_ORIGIN_Y);
        map.remove(Snapshot.WIDTH);
        map.remove(Snapshot.HEIGHT);
        if (map.size() == 0) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (String str : map.keySet()) {
            addProp(javaOnlyMap, str, map.get(str));
        }
        viewManager.updateProperties(view, new ReactStylesDiffMap(javaOnlyMap));
    }

    public void setReanimatedNativeHierarchyManager(ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager) {
        this.mReanimatedNativeHierarchyManager = reanimatedNativeHierarchyManager;
    }

    public boolean shouldAnimateExiting(int i2, boolean z) {
        return this.mNativeMethodsHolder.shouldAnimateExiting(i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateLayout(View view, ViewManager viewManager, int i2, float f2, float f3, float f4, float f5, boolean z) {
        int iRound = Math.round(PixelUtil.b(f2));
        int iRound2 = Math.round(PixelUtil.b(f3));
        int iRound3 = Math.round(PixelUtil.b(f4));
        int iRound4 = Math.round(PixelUtil.b(f5));
        view.measure(View.MeasureSpec.makeMeasureSpec(iRound3, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound4, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        if (i2 % 10 != 1 || viewManager == 0) {
            if (z) {
                Point pointConvertScreenLocationToViewCoordinates = convertScreenLocationToViewCoordinates(new Point(iRound, iRound2), (View) view.getParent());
                iRound = pointConvertScreenLocationToViewCoordinates.x;
                iRound2 = pointConvertScreenLocationToViewCoordinates.y;
            }
            view.layout(iRound, iRound2, iRound3 + iRound, iRound4 + iRound2);
            return;
        }
        if (!(viewManager instanceof IViewManagerWithChildren)) {
            throw new IllegalViewOperationException(android.support.v4.media.b.g(i2, "[Reanimated] Trying to use view with tag ", " as a parent, but its Manager doesn't implement IViewManagerWithChildren."));
        }
        if (((IViewManagerWithChildren) viewManager).needsCustomLayoutForChildren()) {
            return;
        }
        view.layout(iRound, iRound2, iRound3 + iRound, iRound4 + iRound2);
    }

    public void viewDidLayout(View view) {
        this.mSharedTransitionManager.viewDidLayout(view);
    }

    public void visitNativeTreeAndMakeSnapshot(View view) {
        this.mSharedTransitionManager.visitNativeTreeAndMakeSnapshot(view);
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> map, boolean z, boolean z2) {
        HashMap<String, Object> map2 = new HashMap<>();
        Iterator<String> it = (z ? Snapshot.targetKeysToTransform : Snapshot.currentKeysToTransform).iterator();
        while (it.hasNext()) {
            String next = it.next();
            map2.put(next, Float.valueOf(PixelUtil.a(Utils.convertToFloat(map.get(next)))));
        }
        if (z2) {
            String str = z ? Snapshot.TARGET_TRANSFORM_MATRIX : Snapshot.CURRENT_TRANSFORM_MATRIX;
            map2.put(str, map.get(str));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null) {
            map2.put("windowWidth", Float.valueOf(PixelUtil.a(0.0f)));
            map2.put("windowHeight", Float.valueOf(PixelUtil.a(0.0f)));
            return map2;
        }
        currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        map2.put("windowWidth", Float.valueOf(PixelUtil.a(displayMetrics.widthPixels)));
        map2.put("windowHeight", Float.valueOf(PixelUtil.a(i2)));
        return map2;
    }

    private void cancelAnimationsInSubviews(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null) {
                if (this.mExitingViews.containsKey(Integer.valueOf(childAt.getId()))) {
                    endLayoutAnimation(childAt.getId(), true);
                } else if ((childAt instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(childAt.getId()))) {
                    cancelAnimationsInSubviews((ViewGroup) childAt);
                }
            }
        }
    }
}
