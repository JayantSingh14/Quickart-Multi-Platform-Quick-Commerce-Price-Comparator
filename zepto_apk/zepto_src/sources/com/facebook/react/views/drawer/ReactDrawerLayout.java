package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactDrawerLayout extends DrawerLayout {
    public int I;
    public int J;
    public boolean K;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        try {
            if (!super.onInterceptTouchEvent(ev)) {
                return false;
            }
            NativeGestureUtil.b(this, ev);
            this.K = true;
            return true;
        } catch (IllegalArgumentException e2) {
            FLog.r("ReactNative", "Error intercepting touch event.", e2);
            return false;
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 1 && this.K) {
            NativeGestureUtil.a(this, ev);
            this.K = false;
        }
        super.onTouchEvent(ev);
        return true;
    }

    public final void setDrawerPosition$ReactAndroid_release(int i2) {
        this.I = i2;
        u();
    }

    public final void setDrawerWidth$ReactAndroid_release(int i2) {
        this.J = i2;
        u();
    }

    public final void u() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout.LayoutParams");
            DrawerLayout.LayoutParams layoutParams2 = (DrawerLayout.LayoutParams) layoutParams;
            layoutParams2.f4238a = this.I;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = this.J;
            childAt.setLayoutParams(layoutParams2);
            childAt.setClickable(true);
        }
    }
}
