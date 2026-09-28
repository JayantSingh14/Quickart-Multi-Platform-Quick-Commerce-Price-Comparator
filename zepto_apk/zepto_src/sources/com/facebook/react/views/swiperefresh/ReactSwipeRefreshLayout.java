package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactSwipeRefreshLayout extends SwipeRefreshLayout {
    public boolean A0;
    public float B0;
    public final int C0;
    public float D0;
    public boolean E0;
    public boolean F0;
    public boolean Q;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSwipeRefreshLayout(ThemedReactContext reactContext) {
        super(reactContext, null);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.C0 = ViewConfiguration.get(reactContext).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public final boolean a() {
        View childAt = getChildAt(0);
        return childAt != null ? childAt.canScrollVertically(-1) : super.a();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.D0 = ev.getX();
            this.E0 = false;
        } else if (action == 2) {
            float fAbs = Math.abs(ev.getX() - this.D0);
            if (this.E0 || fAbs > this.C0) {
                this.E0 = true;
                return false;
            }
        }
        if (!super.onInterceptTouchEvent(ev)) {
            return false;
        }
        NativeGestureUtil.b(this, ev);
        this.F0 = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.Q) {
            return;
        }
        this.Q = true;
        setProgressViewOffset(this.B0);
        setRefreshing(this.A0);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 1 && this.F0) {
            NativeGestureUtil.a(this, ev);
            this.F0 = false;
        }
        return super.onTouchEvent(ev);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void setProgressViewOffset(float f2) {
        this.B0 = f2;
        if (this.Q) {
            int progressCircleDiameter = getProgressCircleDiameter();
            int iRound = Math.round(PixelUtil.b(f2)) - progressCircleDiameter;
            int iRound2 = Math.round(PixelUtil.b(f2 + 64.0f)) - progressCircleDiameter;
            this.w = iRound;
            this.x = iRound2;
            this.G = true;
            f();
            this.f11980c = false;
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean z) {
        this.A0 = z;
        if (this.Q) {
            super.setRefreshing(z);
        }
    }
}
