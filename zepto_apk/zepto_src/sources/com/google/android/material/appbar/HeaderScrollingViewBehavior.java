package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.search.SearchBar;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f39897c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f39898d;

    /* renamed from: e, reason: collision with root package name */
    public int f39899e;

    /* renamed from: f, reason: collision with root package name */
    public int f39900f;

    public HeaderScrollingViewBehavior() {
        this.f39897c = new Rect();
        this.f39898d = new Rect();
        this.f39899e = 0;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public final void A(CoordinatorLayout coordinatorLayout, View view, int i2) {
        AppBarLayout appBarLayoutC = C(coordinatorLayout.l(view));
        int iB = 0;
        if (appBarLayoutC == null) {
            coordinatorLayout.v(i2, view);
            this.f39899e = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int bottom = appBarLayoutC.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int bottom2 = ((appBarLayoutC.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        Rect rect = this.f39897c;
        rect.set(paddingLeft, bottom, width, bottom2);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.h() + rect.left;
                rect.right -= lastWindowInsets.i();
            }
        }
        int i3 = layoutParams.f2562c;
        if (i3 == 0) {
            i3 = 8388659;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f39898d;
        Gravity.apply(i3, measuredWidth, measuredHeight, rect, rect2, i2);
        if (this.f39900f != 0) {
            float fD = D(appBarLayoutC);
            int i4 = this.f39900f;
            iB = MathUtils.b((int) (fD * i4), 0, i4);
        }
        view.layout(rect2.left, rect2.top - iB, rect2.right, rect2.bottom - iB);
        this.f39899e = rect2.top - appBarLayoutC.getBottom();
    }

    public abstract AppBarLayout C(List list);

    public float D(View view) {
        return 1.0f;
    }

    public int E(View view) {
        return view.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
        AppBarLayout appBarLayoutC;
        WindowInsetsCompat lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (appBarLayoutC = C(coordinatorLayout.l(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size > 0) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (appBarLayoutC.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.g() + lastWindowInsets.j();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int iE = size + E(appBarLayoutC);
        int measuredHeight = appBarLayoutC.getMeasuredHeight();
        if (this instanceof SearchBar.ScrollingViewBehavior) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iE -= measuredHeight;
        }
        coordinatorLayout.w(i2, i3, View.MeasureSpec.makeMeasureSpec(iE, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), view);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39897c = new Rect();
        this.f39898d = new Rect();
        this.f39899e = 0;
    }
}
