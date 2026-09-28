package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes4.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public ViewOffsetHelper f39901a;

    /* renamed from: b, reason: collision with root package name */
    public int f39902b;

    public ViewOffsetBehavior() {
        this.f39902b = 0;
    }

    public void A(CoordinatorLayout coordinatorLayout, View view, int i2) {
        coordinatorLayout.v(i2, view);
    }

    public boolean B(int i2) {
        ViewOffsetHelper viewOffsetHelper = this.f39901a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.b(i2);
        }
        this.f39902b = i2;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
        A(coordinatorLayout, view, i2);
        if (this.f39901a == null) {
            this.f39901a = new ViewOffsetHelper(view);
        }
        ViewOffsetHelper viewOffsetHelper = this.f39901a;
        View view2 = viewOffsetHelper.f39903a;
        viewOffsetHelper.f39904b = view2.getTop();
        viewOffsetHelper.f39905c = view2.getLeft();
        this.f39901a.a();
        int i3 = this.f39902b;
        if (i3 == 0) {
            return true;
        }
        this.f39901a.b(i3);
        this.f39902b = 0;
        return true;
    }

    public int y() {
        ViewOffsetHelper viewOffsetHelper = this.f39901a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.f39906d;
        }
        return 0;
    }

    public int z() {
        return y();
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39902b = 0;
    }
}
