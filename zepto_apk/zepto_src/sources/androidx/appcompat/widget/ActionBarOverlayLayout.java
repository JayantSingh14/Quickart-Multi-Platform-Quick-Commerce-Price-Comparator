package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.api.Api;

@SuppressLint({"UnknownNullness"})
@RestrictTo
/* loaded from: classes3.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] C = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final WindowInsetsCompat D;
    public static final Rect E;
    public final NestedScrollingParentHelper A;
    public final NoSystemUiLayoutFlagView B;

    /* renamed from: a, reason: collision with root package name */
    public int f700a;

    /* renamed from: b, reason: collision with root package name */
    public int f701b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f702c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f703d;

    /* renamed from: e, reason: collision with root package name */
    public DecorToolbar f704e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f705f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f706g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f707h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f708i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f709j;

    /* renamed from: k, reason: collision with root package name */
    public int f710k;

    /* renamed from: l, reason: collision with root package name */
    public int f711l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f712m;
    public final Rect n;
    public final Rect o;
    public final Rect p;
    public WindowInsetsCompat q;
    public WindowInsetsCompat r;
    public WindowInsetsCompat s;
    public WindowInsetsCompat t;
    public ActionBarVisibilityCallback u;
    public OverScroller v;
    public ViewPropertyAnimator w;
    public final AnimatorListenerAdapter x;
    public final Runnable y;
    public final Runnable z;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.q();
            actionBarOverlayLayout.w = actionBarOverlayLayout.f703d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.x);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.q();
            actionBarOverlayLayout.w = actionBarOverlayLayout.f703d.animate().translationY(-actionBarOverlayLayout.f703d.getHeight()).setListener(actionBarOverlayLayout.x);
        }
    }

    public interface ActionBarVisibilityCallback {
        void a();

        void b(int i2);

        void c(boolean z);

        void d();

        void e();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static final class NoSystemUiLayoutFlagView extends View {
        @Override // android.view.View
        public final int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    static {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
        builder.c(Insets.c(0, 1, 0, 1));
        D = builder.a();
        E = new Rect();
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f701b = 0;
        this.f712m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f3149b;
        this.q = windowInsetsCompat;
        this.r = windowInsetsCompat;
        this.s = windowInsetsCompat;
        this.t = windowInsetsCompat;
        this.x = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w = null;
                actionBarOverlayLayout.f709j = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w = null;
                actionBarOverlayLayout.f709j = false;
            }
        };
        this.y = new AnonymousClass2();
        this.z = new AnonymousClass3();
        r(context);
        this.A = new NestedScrollingParentHelper();
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = new NoSystemUiLayoutFlagView(context);
        noSystemUiLayoutFlagView.setWillNotDraw(true);
        this.B = noSystemUiLayoutFlagView;
        addView(noSystemUiLayoutFlagView);
    }

    public static boolean p(View view, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i3 = rect.left;
        if (i2 != i3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
            z2 = true;
        } else {
            z2 = false;
        }
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i5 = rect.top;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i5;
            z2 = true;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i7 = rect.right;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i7;
            z2 = true;
        }
        if (z) {
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i9 = rect.bottom;
            if (i8 != i9) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i9;
                return true;
            }
        }
        return z2;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean a() {
        s();
        return this.f704e.a();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void b(MenuBuilder menuBuilder, MenuPresenter.Callback callback) {
        s();
        this.f704e.b(menuBuilder, callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean c() {
        s();
        return this.f704e.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean d() {
        s();
        return this.f704e.d();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f705f != null) {
            if (this.f703d.getVisibility() == 0) {
                translationY = (int) (this.f703d.getTranslationY() + this.f703d.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.f705f.setBounds(0, translationY, getWidth(), this.f705f.getIntrinsicHeight() + translationY);
            this.f705f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean e() {
        s();
        return this.f704e.e();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void f() {
        s();
        this.f704e.f();
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final boolean g() {
        s();
        return this.f704e.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f703d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.A.a();
    }

    public CharSequence getTitle() {
        s();
        return this.f704e.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void h(int i2) {
        s();
        if (i2 == 2) {
            this.f704e.l();
        } else if (i2 == 5) {
            this.f704e.r();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void i(int i2, View view) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void j(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void k(View view, int i2, int i3, int[] iArr, int i4) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public final void l() {
        s();
        this.f704e.n();
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        s();
        WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(this, windowInsets);
        boolean zP = p(this.f703d, new Rect(windowInsetsCompatR.h(), windowInsetsCompatR.j(), windowInsetsCompatR.i(), windowInsetsCompatR.g()), false);
        Rect rect = this.f712m;
        ViewCompat.b(this, windowInsetsCompatR, rect);
        WindowInsetsCompat windowInsetsCompatL = windowInsetsCompatR.l(rect.left, rect.top, rect.right, rect.bottom);
        this.q = windowInsetsCompatL;
        boolean z = true;
        if (!this.r.equals(windowInsetsCompatL)) {
            this.r = this.q;
            zP = true;
        }
        Rect rect2 = this.n;
        if (rect2.equals(rect)) {
            z = zP;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return windowInsetsCompatR.a().c().b().q();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r(getContext());
        ViewCompat.x(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.f708i || !z) {
            return false;
        }
        this.v.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.v.getFinalY() > this.f703d.getHeight()) {
            q();
            ((AnonymousClass3) this.z).run();
        } else {
            q();
            ((AnonymousClass2) this.y).run();
        }
        this.f709j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f710k + i3;
        this.f710k = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.A.f3059a = i2;
        this.f710k = getActionBarHideOffset();
        q();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f703d.getVisibility() != 0) {
            return false;
        }
        return this.f708i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f708i || this.f709j) {
            return;
        }
        if (this.f710k <= this.f703d.getHeight()) {
            q();
            postDelayed(this.y, 600L);
        } else {
            q();
            postDelayed(this.z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        s();
        int i3 = this.f711l ^ i2;
        this.f711l = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & 256) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.c(!z2);
            if (z || !z2) {
                this.u.a();
            } else {
                this.u.d();
            }
        }
        if ((i3 & 256) == 0 || this.u == null) {
            return;
        }
        ViewCompat.x(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f701b = i2;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.b(i2);
        }
    }

    public final void q() {
        removeCallbacks(this.y);
        removeCallbacks(this.z);
        ViewPropertyAnimator viewPropertyAnimator = this.w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void r(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(C);
        this.f700a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f705f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.v = new OverScroller(context);
    }

    public final void s() {
        DecorToolbar wrapper;
        if (this.f702c == null) {
            this.f702c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f703d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof DecorToolbar) {
                wrapper = (DecorToolbar) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f704e = wrapper;
        }
    }

    public void setActionBarHideOffset(int i2) {
        q();
        this.f703d.setTranslationY(-Math.max(0, Math.min(i2, this.f703d.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.u = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.u.b(this.f701b);
            int i2 = this.f711l;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ViewCompat.x(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f707h = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f708i) {
            this.f708i = z;
            if (z) {
                return;
            }
            q();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        s();
        this.f704e.setIcon(i2);
    }

    public void setLogo(int i2) {
        s();
        this.f704e.p(i2);
    }

    public void setOverlayMode(boolean z) {
        this.f706g = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        s();
        this.f704e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        s();
        this.f704e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        s();
        this.f704e.setIcon(drawable);
    }
}
