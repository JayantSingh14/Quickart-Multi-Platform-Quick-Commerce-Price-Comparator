package com.facebook.react.runtime;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.tracing.Trace;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReactSurfaceView extends ReactRootView {
    public final ReactSurfaceImpl u;
    public final JSTouchDispatcher v;
    public final JSPointerDispatcher w;
    public boolean x;
    public int y;
    public int z;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSurfaceView(Activity activity, ReactSurfaceImpl surface) {
        super(activity);
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.u = surface;
        this.v = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.w = new JSPointerDispatcher(this);
        }
    }

    private final Point getViewportOffset() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        iArr[0] = iArr[0] - rect.left;
        iArr[1] = iArr[1] - rect.top;
        return new Point(iArr[0], iArr[1]);
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.RootView
    public final void a(View view, MotionEvent ev) {
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcherB = this.u.b();
        if (eventDispatcherB == null) {
            return;
        }
        this.v.c(ev, eventDispatcherB);
        if (view == null || (jSPointerDispatcher = this.w) == null) {
            return;
        }
        jSPointerDispatcher.g(view, ev, eventDispatcherB);
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.RootView
    public final void d(ViewGroup childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.u.b() == null) {
            return;
        }
        this.v.f19384c = false;
        JSPointerDispatcher jSPointerDispatcher = this.w;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.f19377e = -1;
        }
    }

    @Override // com.facebook.react.ReactRootView
    public final void f(MotionEvent event, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        JSPointerDispatcher jSPointerDispatcher = this.w;
        if (jSPointerDispatcher == null) {
            if (ReactFeatureFlags.dispatchPointerEvents) {
                FLog.q("ReactSurfaceView", "Unable to dispatch pointer events to JS before the dispatcher is available");
            }
        } else {
            EventDispatcher eventDispatcherB = this.u.b();
            if (eventDispatcherB != null) {
                jSPointerDispatcher.d(event, eventDispatcherB, z);
            } else {
                FLog.q("ReactSurfaceView", "Unable to dispatch pointer events to JS as the React instance has not been attached");
            }
        }
    }

    @Override // com.facebook.react.ReactRootView
    public final void g(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ReactSurfaceImpl reactSurfaceImpl = this.u;
        EventDispatcher eventDispatcherB = reactSurfaceImpl.b();
        if (eventDispatcherB == null) {
            FLog.q("ReactSurfaceView", "Unable to dispatch touch events to JS as the React instance has not been attached");
        } else {
            this.v.b(event, eventDispatcherB, ((ReactHostImpl) reactSurfaceImpl.f19279b.get()).m());
        }
    }

    @Override // com.facebook.react.ReactRootView
    @Nullable
    public ReactContext getCurrentReactContext() {
        ReactSurfaceImpl reactSurfaceImpl = this.u;
        if (reactSurfaceImpl.f19279b.get() != null) {
            return ((ReactHostImpl) reactSurfaceImpl.f19279b.get()).m();
        }
        return null;
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.ReactRoot
    @NotNull
    public String getJSModuleName() {
        String moduleName = this.u.f19280c.getModuleName();
        Intrinsics.checkNotNullExpressionValue(moduleName, "<get-moduleName>(...)");
        return moduleName;
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.ReactRoot
    public int getUIManagerType() {
        return 2;
    }

    @Override // com.facebook.react.ReactRootView
    public final void h(StackOverflowError t) {
        Intrinsics.checkNotNullParameter(t, "t");
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.u.f19279b.get();
        Intrinsics.checkNotNullExpressionValue(reactHostImpl, "getReactHost(...)");
        String string = Objects.toString(t.getMessage(), "");
        Intrinsics.c(string);
        reactHostImpl.p(new IllegalViewOperationException(string, this, t));
    }

    @Override // com.facebook.react.ReactRootView
    public final boolean i() {
        ReactSurfaceImpl reactSurfaceImpl = this.u;
        return (reactSurfaceImpl.f19279b.get() == null || ((ReactHostImpl) reactSurfaceImpl.f19279b.get()).m() == null) ? false : true;
    }

    @Override // com.facebook.react.ReactRootView
    public final boolean j() {
        ReactSurfaceImpl reactSurfaceImpl = this.u;
        return (reactSurfaceImpl.f19279b.get() == null || ((ReactHostImpl) reactSurfaceImpl.f19279b.get()).f19250l == null) ? false : true;
    }

    @Override // com.facebook.react.ReactRootView
    public final boolean l() {
        return this.u.f19279b.get() != null;
    }

    @Override // com.facebook.react.ReactRootView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.x && z) {
            Point viewportOffset = getViewportOffset();
            this.u.c(this.y, this.z, viewportOffset.x, viewportOffset.y);
        }
    }

    @Override // com.facebook.react.ReactRootView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter("ReactSurfaceView.onMeasure", "sectionName");
        Trace.b("ReactSurfaceView.onMeasure");
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                iMax = Math.max(iMax, childAt.getPaddingRight() + childAt.getPaddingLeft() + childAt.getMeasuredWidth() + childAt.getLeft());
            }
            size = iMax;
        } else {
            size = View.MeasureSpec.getSize(i2);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int childCount2 = getChildCount();
            int iMax2 = 0;
            for (int i5 = 0; i5 < childCount2; i5++) {
                View childAt2 = getChildAt(i5);
                iMax2 = Math.max(iMax2, childAt2.getPaddingBottom() + childAt2.getPaddingTop() + childAt2.getMeasuredHeight() + childAt2.getTop());
            }
            size2 = iMax2;
        } else {
            size2 = View.MeasureSpec.getSize(i3);
        }
        setMeasuredDimension(size, size2);
        this.x = true;
        this.y = i2;
        this.z = i3;
        Point viewportOffset = getViewportOffset();
        this.u.c(i2, i3, viewportOffset.x, viewportOffset.y);
        android.os.Trace.endSection();
    }

    @Override // com.facebook.react.ReactRootView, android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.facebook.react.ReactRootView
    public void setIsFabric(boolean z) {
        super.setIsFabric(true);
    }
}
