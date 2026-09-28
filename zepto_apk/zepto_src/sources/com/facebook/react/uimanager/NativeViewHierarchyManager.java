package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Trace;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.react.R;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@NotThreadSafe
/* loaded from: classes.dex */
public class NativeViewHierarchyManager {
    private static final String TAG = "NativeViewHierarchyManager";
    private final boolean DEBUG_MODE;
    private final RectF mBoundingBox;
    private final JSResponderHandler mJSResponderHandler;
    private volatile boolean mLayoutAnimationEnabled;
    private final LayoutAnimationController mLayoutAnimator;
    private HashMap<Integer, Set<Integer>> mPendingDeletionsForTag;
    private final SparseBooleanArray mRootTags;
    private final RootViewManager mRootViewManager;
    private final SparseArray<ViewManager> mTagsToViewManagers;
    private final SparseArray<View> mTagsToViews;
    private final ViewManagerRegistry mViewManagers;

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        RootViewManager rootViewManager = new RootViewManager();
        this.DEBUG_MODE = false;
        this.mJSResponderHandler = new JSResponderHandler();
        this.mLayoutAnimator = new LayoutAnimationController();
        this.mBoundingBox = new RectF();
        this.mViewManagers = viewManagerRegistry;
        this.mTagsToViews = new SparseArray<>();
        this.mTagsToViewManagers = new SparseArray<>();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public static String c(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        if (viewGroup != null) {
            sb.append("View tag:" + viewGroup.getId() + " View Type:" + viewGroup.getClass().toString() + StringUtils.LF);
            StringBuilder sb2 = new StringBuilder("  children(");
            sb2.append(viewGroupManager.getChildCount((ViewGroupManager) viewGroup));
            sb2.append("): [\n");
            sb.append(sb2.toString());
            for (int i2 = 0; viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i2) != null; i2 += 16) {
                int i3 = 0;
                while (true) {
                    int i4 = i2 + i3;
                    if (viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i4) == null || i3 >= 16) {
                        break;
                    }
                    sb.append(viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i4).getId() + ",");
                    i3++;
                }
                sb.append(StringUtils.LF);
            }
            sb.append(" ],\n");
        }
        if (iArr != null) {
            sb.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i5 = 0; i5 < iArr.length; i5 += 16) {
                int i6 = 0;
                while (true) {
                    int i7 = i5 + i6;
                    if (i7 >= iArr.length || i6 >= 16) {
                        break;
                    }
                    sb.append(iArr[i7] + ",");
                    i6++;
                }
                sb.append(StringUtils.LF);
            }
            sb.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            sb.append("  viewsToAdd(" + viewAtIndexArr.length + "): [\n");
            for (int i8 = 0; i8 < viewAtIndexArr.length; i8 += 16) {
                int i9 = 0;
                while (true) {
                    int i10 = i8 + i9;
                    if (i10 >= viewAtIndexArr.length || i9 >= 16) {
                        break;
                    }
                    sb.append("[" + viewAtIndexArr[i10].f19593b + "," + viewAtIndexArr[i10].f19592a + "],");
                    i9++;
                }
                sb.append(StringUtils.LF);
            }
            sb.append(" ],\n");
        }
        if (iArr2 != null) {
            sb.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i11 = 0; i11 < iArr2.length; i11 += 16) {
                int i12 = 0;
                while (true) {
                    int i13 = i11 + i12;
                    if (i13 >= iArr2.length || i12 >= 16) {
                        break;
                    }
                    sb.append(iArr2[i13] + ",");
                    i12++;
                }
                sb.append(StringUtils.LF);
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    public synchronized void addRootView(int i2, View view) {
        addRootViewGroup(i2, view);
    }

    public final synchronized void addRootViewGroup(int i2, View view) {
        try {
            if (this.DEBUG_MODE) {
                FLog.d(TAG, "addRootViewGroup[%d]: %s", Integer.valueOf(i2), view != null ? view.toString() : "<null>");
            }
            if (view.getId() != -1) {
                FLog.g(TAG, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
            }
            this.mTagsToViews.put(i2, view);
            this.mTagsToViewManagers.put(i2, this.mRootViewManager);
            this.mRootTags.put(i2, true);
            view.setId(i2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(View view, int[] iArr) {
        this.mBoundingBox.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        RectF rectF = this.mBoundingBox;
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(view.getLeft(), view.getTop());
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
        iArr[0] = Math.round(this.mBoundingBox.left);
        iArr[1] = Math.round(this.mBoundingBox.top);
        RectF rectF2 = this.mBoundingBox;
        iArr[2] = Math.round(rectF2.right - rectF2.left);
        RectF rectF3 = this.mBoundingBox;
        iArr[3] = Math.round(rectF3.bottom - rectF3.top);
    }

    public synchronized void clearJSResponder() {
        JSResponderHandler jSResponderHandler = this.mJSResponderHandler;
        jSResponderHandler.f19366a = -1;
        ViewParent viewParent = jSResponderHandler.f19367b;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        jSResponderHandler.f19367b = null;
    }

    public synchronized void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    public synchronized void configureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mLayoutAnimator.initializeFromConfig(readableMap, callback);
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i2, String str, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        try {
            if (this.DEBUG_MODE) {
                FLog.b(TAG, "createView[%d]: %s %s", Integer.valueOf(i2), str, reactStylesDiffMap != null ? reactStylesDiffMap.toString() : "<null>");
            }
            UiThreadUtil.assertOnUiThread();
            SystraceMessage.Builder builderA = SystraceMessage.a("NativeViewHierarchyManager_createView");
            builderA.a(i2, "tag");
            builderA.b(str, "className");
            builderA.c();
            try {
                ViewManager viewManagerA = this.mViewManagers.a(str);
                this.mTagsToViews.put(i2, viewManagerA.createView(i2, themedReactContext, reactStylesDiffMap, null, this.mJSResponderHandler));
                this.mTagsToViewManagers.put(i2, viewManagerA);
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final Set d(int i2) {
        if (this.mPendingDeletionsForTag == null) {
            this.mPendingDeletionsForTag = new HashMap<>();
        }
        if (!this.mPendingDeletionsForTag.containsKey(Integer.valueOf(i2))) {
            this.mPendingDeletionsForTag.put(Integer.valueOf(i2), new HashSet());
        }
        return this.mPendingDeletionsForTag.get(Integer.valueOf(i2));
    }

    @Deprecated
    public synchronized void dispatchCommand(int i2, int i3, @Nullable ReadableArray readableArray) {
        try {
            if (this.DEBUG_MODE) {
                FLog.b(TAG, "dispatchCommand[%d]: %d %s", Integer.valueOf(i2), Integer.valueOf(i3), readableArray != null ? readableArray.toString() : "<null>");
            }
            UiThreadUtil.assertOnUiThread();
            View view = this.mTagsToViews.get(i2);
            if (view == null) {
                throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i2 + "] and command " + i3);
            }
            resolveViewManager(i2).receiveCommand((ViewManager) view, i3, readableArray);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void dropView(View view) {
        try {
            if (this.DEBUG_MODE) {
                FLog.c(TAG, "dropView[%d]", Integer.valueOf(view != null ? view.getId() : -1));
            }
            UiThreadUtil.assertOnUiThread();
            if (view == null) {
                return;
            }
            if (this.mTagsToViewManagers.get(view.getId()) == null) {
                return;
            }
            if (!this.mRootTags.get(view.getId())) {
                resolveViewManager(view.getId()).onDropViewInstance(view);
            }
            ViewManager viewManager = this.mTagsToViewManagers.get(view.getId());
            if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                for (int childCount = viewGroupManager.getChildCount((ViewGroupManager) viewGroup) - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroupManager.getChildAt((ViewGroupManager) viewGroup, childCount);
                    if (childAt == null) {
                        FLog.g(TAG, "Unable to drop null child view");
                    } else if (this.mTagsToViews.get(childAt.getId()) != null) {
                        dropView(childAt);
                    }
                }
                viewGroupManager.removeAllViews(viewGroup);
            }
            this.mTagsToViews.remove(view.getId());
            this.mTagsToViewManagers.remove(view.getId());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int findTargetTagForTouch(int i2, float f2, float f3) {
        View view;
        try {
            if (this.DEBUG_MODE) {
                FLog.b(TAG, "findTargetTagForTouch[%d]: %f %f", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3));
            }
            UiThreadUtil.assertOnUiThread();
            view = this.mTagsToViews.get(i2);
            if (view == null) {
                throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return TouchTargetHelper.b(f2, f3, (ViewGroup) view);
    }

    @Nullable
    public synchronized long getInstanceHandle(int i2) {
        Long l2;
        View view = this.mTagsToViews.get(i2);
        if (view == null) {
            throw new IllegalViewOperationException("Unable to find view for tag: " + i2);
        }
        l2 = (Long) view.getTag(R.id.view_tag_instance_handle);
        if (l2 == null) {
            throw new IllegalViewOperationException("Unable to find instanceHandle for tag: " + i2);
        }
        return l2.longValue();
    }

    public synchronized int getRootViewNum() {
        return this.mRootTags.size();
    }

    public synchronized void manageChildren(int i2, @Nullable int[] iArr, @Nullable ViewAtIndex[] viewAtIndexArr, @Nullable int[] iArr2) throws Throwable {
        Throwable th;
        final int i3;
        try {
            try {
                if (this.DEBUG_MODE) {
                    try {
                        String str = TAG;
                        String string = iArr != null ? iArr.toString() : "<null>";
                        String string2 = viewAtIndexArr != null ? viewAtIndexArr.toString() : "<null>";
                        String string3 = iArr2 != null ? iArr2.toString() : "<null>";
                        FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = FLog.f17086a;
                        if (fLogDefaultLoggingDelegate.a(3)) {
                            String str2 = "createView[" + i2 + "]: " + string + StringUtils.SPACE + string2 + StringUtils.SPACE + string3;
                            fLogDefaultLoggingDelegate.getClass();
                            FLogDefaultLoggingDelegate.b(3, str, str2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                UiThreadUtil.assertOnUiThread();
                final Set setD = d(i2);
                final ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i2);
                final ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i2);
                if (viewGroup == null) {
                    throw new IllegalViewOperationException("Trying to manageChildren view with tag " + i2 + " which doesn't exist\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                }
                int childCount = viewGroupManager.getChildCount((ViewGroupManager) viewGroup);
                if (iArr != null) {
                    int length = iArr.length - 1;
                    while (length >= 0) {
                        int i4 = iArr[length];
                        if (i4 < 0) {
                            throw new IllegalViewOperationException("Trying to remove a negative view index:" + i4 + " view tag: " + i2 + "\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        }
                        if (viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i4) == null) {
                            if (this.mRootTags.get(i2) && viewGroupManager.getChildCount((ViewGroupManager) viewGroup) == 0) {
                                return;
                            }
                            throw new IllegalViewOperationException("Trying to remove a view index above child count " + i4 + " view tag: " + i2 + "\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        }
                        if (i4 >= childCount) {
                            throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i4 + " view tag: " + i2 + "\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        }
                        View childAt = viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i4);
                        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(childAt)) {
                            int id = childAt.getId();
                            if (iArr2 != null) {
                                for (int i5 : iArr2) {
                                    if (i5 == id) {
                                        break;
                                    }
                                }
                            }
                            viewGroupManager.removeViewAt((ViewGroupManager) viewGroup, i4);
                        } else {
                            viewGroupManager.removeViewAt((ViewGroupManager) viewGroup, i4);
                        }
                        length--;
                        childCount = i4;
                    }
                }
                if (iArr2 != null) {
                    int i6 = 0;
                    while (i6 < iArr2.length) {
                        int i7 = iArr2[i6];
                        final View view = this.mTagsToViews.get(i7);
                        if (view == null) {
                            throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i7 + "\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        }
                        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(view)) {
                            setD.add(Integer.valueOf(i7));
                            i3 = i2;
                            this.mLayoutAnimator.deleteView(view, new LayoutAnimationListener() { // from class: com.facebook.react.uimanager.NativeViewHierarchyManager.1
                                @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener
                                public final void a() {
                                    UiThreadUtil.assertOnUiThread();
                                    ViewGroupManager viewGroupManager2 = viewGroupManager;
                                    ViewGroup viewGroup2 = viewGroup;
                                    View view2 = view;
                                    viewGroupManager2.removeView(viewGroup2, view2);
                                    NativeViewHierarchyManager nativeViewHierarchyManager = NativeViewHierarchyManager.this;
                                    nativeViewHierarchyManager.dropView(view2);
                                    Integer numValueOf = Integer.valueOf(view2.getId());
                                    Set set = setD;
                                    set.remove(numValueOf);
                                    if (set.isEmpty()) {
                                        nativeViewHierarchyManager.mPendingDeletionsForTag.remove(Integer.valueOf(i3));
                                    }
                                }
                            });
                        } else {
                            i3 = i2;
                            dropView(view);
                        }
                        i6++;
                        i2 = i3;
                    }
                }
                int i8 = i2;
                if (viewAtIndexArr != null) {
                    for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
                        View view2 = this.mTagsToViews.get(viewAtIndex.f19592a);
                        if (view2 == null) {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.f19592a + "\n detail: " + c(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        }
                        int i9 = viewAtIndex.f19593b;
                        if (!setD.isEmpty()) {
                            i9 = 0;
                            int i10 = 0;
                            while (i9 < viewGroup.getChildCount() && i10 != viewAtIndex.f19593b) {
                                if (!setD.contains(Integer.valueOf(viewGroup.getChildAt(i9).getId()))) {
                                    i10++;
                                }
                                i9++;
                            }
                        }
                        viewGroupManager.addView((ViewGroupManager) viewGroup, view2, i9);
                    }
                }
                if (setD.isEmpty()) {
                    this.mPendingDeletionsForTag.remove(Integer.valueOf(i8));
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void measure(int i2, int[] iArr) {
        try {
            if (this.DEBUG_MODE) {
                FLog.c(TAG, "measure[%d]", Integer.valueOf(i2));
            }
            UiThreadUtil.assertOnUiThread();
            View view = this.mTagsToViews.get(i2);
            if (view == null) {
                throw new NoSuchNativeViewException("No native view for " + i2 + " currently exists");
            }
            View view2 = (View) RootViewUtil.a(view);
            if (view2 == null) {
                throw new NoSuchNativeViewException("Native view " + i2 + " is no longer on screen");
            }
            b(view2, iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            b(view, iArr);
            iArr[0] = iArr[0] - i3;
            iArr[1] = iArr[1] - i4;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void measureInWindow(int i2, int[] iArr) {
        try {
            if (this.DEBUG_MODE) {
                FLog.c(TAG, "measureInWindow[%d]", Integer.valueOf(i2));
            }
            UiThreadUtil.assertOnUiThread();
            View view = this.mTagsToViews.get(i2);
            if (view == null) {
                throw new NoSuchNativeViewException("No native view for " + i2 + " currently exists");
            }
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            iArr[0] = iArr[0] - rect.left;
            iArr[1] = iArr[1] - rect.top;
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeRootView(int i2) {
        try {
            if (this.DEBUG_MODE) {
                FLog.c(TAG, "removeRootView[%d]", Integer.valueOf(i2));
            }
            UiThreadUtil.assertOnUiThread();
            if (!this.mRootTags.get(i2)) {
                SoftAssertions.assertUnreachable("View with tag " + i2 + " is not registered as a root view");
            }
            View view = this.mTagsToViews.get(i2);
            dropView(view);
            this.mRootTags.delete(i2);
            if (view != null) {
                view.setId(-1);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized View resolveView(int i2) {
        View view;
        view = this.mTagsToViews.get(i2);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to resolve view with tag " + i2 + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i2) {
        ViewManager viewManager;
        viewManager = this.mTagsToViewManagers.get(i2);
        if (viewManager == null) {
            throw new IllegalViewOperationException("ViewManager for tag " + i2 + " could not be found.\n");
        }
        return viewManager;
    }

    public synchronized void sendAccessibilityEvent(int i2, int i3) {
        View view = this.mTagsToViews.get(i2);
        if (view == null) {
            throw new RetryableMountingLayerException("Could not find view with tag " + i2);
        }
        view.sendAccessibilityEvent(i3);
    }

    public synchronized void setChildren(int i2, ReadableArray readableArray) {
        try {
            if (this.DEBUG_MODE) {
                FLog.d(TAG, "setChildren[%d]: %s", Integer.valueOf(i2), readableArray != null ? readableArray.toString() : "<null>");
            }
            UiThreadUtil.assertOnUiThread();
            ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i2);
            ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i2);
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                View view = this.mTagsToViews.get(readableArray.getInt(i3));
                if (view == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Trying to add unknown view tag: ");
                    sb.append(readableArray.getInt(i3));
                    sb.append("\n detail: ");
                    ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[readableArray.size()];
                    for (int i4 = 0; i4 < readableArray.size(); i4++) {
                        viewAtIndexArr[i4] = new ViewAtIndex(readableArray.getInt(i4), i4);
                    }
                    sb.append(c(viewGroup, viewGroupManager, null, viewAtIndexArr, null));
                    throw new IllegalViewOperationException(sb.toString());
                }
                viewGroupManager.addView((ViewGroupManager) viewGroup, view, i3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void setJSResponder(int i2, int i3, boolean z) {
        if (!z) {
            this.mJSResponderHandler.b(i3, null);
            return;
        }
        View view = this.mTagsToViews.get(i2);
        if (i3 != i2 && (view instanceof ViewParent)) {
            this.mJSResponderHandler.b(i3, (ViewParent) view);
            return;
        }
        if (this.mRootTags.get(i2)) {
            SoftAssertions.assertUnreachable("Cannot block native responder on " + i2 + " that is a root view");
        }
        this.mJSResponderHandler.b(i3, view.getParent());
    }

    public void setLayoutAnimationEnabled(boolean z) {
        this.mLayoutAnimationEnabled = z;
    }

    public synchronized void updateInstanceHandle(int i2, long j2) {
        UiThreadUtil.assertOnUiThread();
        try {
            View viewResolveView = resolveView(i2);
            UiThreadUtil.assertOnUiThread();
            viewResolveView.setTag(R.id.view_tag_instance_handle, Long.valueOf(j2));
        } catch (IllegalViewOperationException e2) {
            FLog.h(TAG, "Unable to update properties for view tag " + i2, e2);
        }
    }

    @Deprecated
    public void updateLayout(int i2, int i3, int i4, int i5, int i6) {
        updateLayout(i2, i2, i3, i4, i5, i6, YogaDirection.INHERIT);
    }

    public synchronized void updateProperties(int i2, ReactStylesDiffMap reactStylesDiffMap) {
        try {
            if (this.DEBUG_MODE) {
                FLog.d(TAG, "updateProperties[%d]: %s", Integer.valueOf(i2), reactStylesDiffMap.toString());
            }
            UiThreadUtil.assertOnUiThread();
            try {
                ViewManager viewManagerResolveViewManager = resolveViewManager(i2);
                View viewResolveView = resolveView(i2);
                if (reactStylesDiffMap != null) {
                    viewManagerResolveViewManager.updateProperties(viewResolveView, reactStylesDiffMap);
                }
            } catch (IllegalViewOperationException e2) {
                FLog.h(TAG, "Unable to update properties for view tag " + i2, e2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void updateViewExtraData(int i2, Object obj) {
        try {
            if (this.DEBUG_MODE) {
                FLog.d(TAG, "updateViewExtraData[%d]: %s", Integer.valueOf(i2), obj.toString());
            }
            UiThreadUtil.assertOnUiThread();
            resolveViewManager(i2).updateExtraData(resolveView(i2), obj);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void updateLayout(int i2, int i3, int i4, int i5, int i6, int i7, YogaDirection direction) {
        try {
            if (this.DEBUG_MODE) {
                String str = TAG;
                if (FLog.f17086a.a(3)) {
                    FLog.a(str, "updateLayout[" + i3 + "]->[" + i2 + "]: " + i4 + StringUtils.SPACE + i5 + StringUtils.SPACE + i6 + StringUtils.SPACE + i7);
                }
            }
            UiThreadUtil.assertOnUiThread();
            SystraceMessage.Builder builderA = SystraceMessage.a("NativeViewHierarchyManager_updateLayout");
            builderA.a(i2, "parentTag");
            builderA.a(i3, "tag");
            builderA.c();
            try {
                View viewResolveView = resolveView(i3);
                Intrinsics.checkNotNullParameter(direction, "direction");
                int iOrdinal = direction.ordinal();
                int i8 = 1;
                if (iOrdinal == 1) {
                    i8 = 0;
                } else if (iOrdinal != 2) {
                    i8 = 2;
                }
                viewResolveView.setLayoutDirection(i8);
                viewResolveView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
                ViewParent parent = viewResolveView.getParent();
                if (parent instanceof RootView) {
                    parent.requestLayout();
                }
                if (!this.mRootTags.get(i2)) {
                    NativeModule nativeModule = (ViewManager) this.mTagsToViewManagers.get(i2);
                    if (!(nativeModule instanceof IViewManagerWithChildren)) {
                        throw new IllegalViewOperationException("Trying to use view with tag " + i2 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                    }
                    IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) nativeModule;
                    if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(viewResolveView)) {
                            this.mLayoutAnimator.applyLayoutUpdate(viewResolveView, i4, i5, i6, i7);
                        } else {
                            viewResolveView.layout(i4, i5, i4 + i6, i5 + i7);
                        }
                    }
                } else if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(viewResolveView)) {
                    this.mLayoutAnimator.applyLayoutUpdate(viewResolveView, i4, i5, i6, i7);
                } else {
                    viewResolveView.layout(i4, i5, i4 + i6, i5 + i7);
                }
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void dispatchCommand(int i2, String str, @Nullable ReadableArray readableArray) {
        try {
            if (this.DEBUG_MODE) {
                FLog.b(TAG, "dispatchCommand[%d]: %s %s", Integer.valueOf(i2), str, readableArray != null ? readableArray.toString() : "<null>");
            }
            UiThreadUtil.assertOnUiThread();
            View view = this.mTagsToViews.get(i2);
            if (view != null) {
                resolveViewManager(i2).receiveCommand((ViewManager) view, str, readableArray);
            } else {
                throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i2 + "] and command " + str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
