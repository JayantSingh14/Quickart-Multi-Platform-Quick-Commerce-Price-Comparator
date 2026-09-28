package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.math.MathUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int F = R.style.Widget_Design_CollapsingToolbar;
    public WindowInsetsCompat A;
    public int B;
    public boolean C;
    public int D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public boolean f39869a;

    /* renamed from: b, reason: collision with root package name */
    public final int f39870b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f39871c;

    /* renamed from: d, reason: collision with root package name */
    public View f39872d;

    /* renamed from: e, reason: collision with root package name */
    public View f39873e;

    /* renamed from: f, reason: collision with root package name */
    public int f39874f;

    /* renamed from: g, reason: collision with root package name */
    public int f39875g;

    /* renamed from: h, reason: collision with root package name */
    public int f39876h;

    /* renamed from: i, reason: collision with root package name */
    public int f39877i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f39878j;

    /* renamed from: k, reason: collision with root package name */
    public final CollapsingTextHelper f39879k;

    /* renamed from: l, reason: collision with root package name */
    public final ElevationOverlayProvider f39880l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f39881m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public int q;
    public boolean r;
    public ValueAnimator s;
    public long t;
    public final TimeInterpolator u;
    public final TimeInterpolator v;
    public int w;
    public AppBarLayout.OnOffsetChangedListener x;
    public int y;
    public int z;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f39884a;

        /* renamed from: b, reason: collision with root package name */
        public float f39885b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f39884a = 0;
            this.f39885b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f39884a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f39885b = typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void a(int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.y = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.A;
            int iJ = windowInsetsCompat != null ? windowInsetsCompat.j() : 0;
            int childCount = collapsingToolbarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = collapsingToolbarLayout.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelperB = CollapsingToolbarLayout.b(childAt);
                int i4 = layoutParams.f39884a;
                if (i4 == 1) {
                    viewOffsetHelperB.b(MathUtils.b(-i2, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.b(childAt).f39904b) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).bottomMargin));
                } else if (i4 == 2) {
                    viewOffsetHelperB.b(Math.round((-i2) * layoutParams.f39885b));
                }
            }
            collapsingToolbarLayout.d();
            if (collapsingToolbarLayout.p != null && iJ > 0) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                collapsingToolbarLayout.postInvalidateOnAnimation();
            }
            int height = collapsingToolbarLayout.getHeight();
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            int minimumHeight = (height - collapsingToolbarLayout.getMinimumHeight()) - iJ;
            float f2 = minimumHeight;
            float fMin = Math.min(1.0f, (height - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) / f2);
            CollapsingTextHelper collapsingTextHelper = collapsingToolbarLayout.f39879k;
            collapsingTextHelper.f40556d = fMin;
            collapsingTextHelper.f40557e = android.support.v4.media.a.a(1.0f, fMin, 0.5f, fMin);
            collapsingTextHelper.f40558f = collapsingToolbarLayout.y + minimumHeight;
            collapsingTextHelper.p(Math.abs(i2) / f2);
        }
    }

    @RequiresApi
    @RestrictTo
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public static ViewOffsetHelper b(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(R.id.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() throws Resources.NotFoundException {
        ColorStateList colorStateListE = MaterialColors.e(R.attr.colorSurfaceContainer, getContext());
        if (colorStateListE != null) {
            return colorStateListE.getDefaultColor();
        }
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        ElevationOverlayProvider elevationOverlayProvider = this.f39880l;
        return elevationOverlayProvider.a(dimension, elevationOverlayProvider.f40423d);
    }

    public final void a() {
        if (this.f39869a) {
            ViewGroup viewGroup = null;
            this.f39871c = null;
            this.f39872d = null;
            int i2 = this.f39870b;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.f39871c = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f39872d = view;
                }
            }
            if (this.f39871c == null) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.f39871c = viewGroup;
            }
            c();
            this.f39869a = false;
        }
    }

    public final void c() {
        View view;
        if (!this.f39881m && (view = this.f39873e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f39873e);
            }
        }
        if (!this.f39881m || this.f39871c == null) {
            return;
        }
        if (this.f39873e == null) {
            this.f39873e = new View(getContext());
        }
        if (this.f39873e.getParent() == null) {
            this.f39871c.addView(this.f39873e, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.y < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f39871c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.f39881m && this.n) {
            ViewGroup viewGroup = this.f39871c;
            CollapsingTextHelper collapsingTextHelper = this.f39879k;
            if (viewGroup == null || this.o == null || this.q <= 0 || this.z != 1 || collapsingTextHelper.f40554b >= collapsingTextHelper.f40557e) {
                collapsingTextHelper.d(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                collapsingTextHelper.d(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.A;
        int iJ = windowInsetsCompat != null ? windowInsetsCompat.j() : 0;
        if (iJ > 0) {
            this.p.setBounds(0, -this.y, getWidth(), iJ - this.y);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        View view2;
        Drawable drawable = this.o;
        if (drawable == null || this.q <= 0 || ((view2 = this.f39872d) == null || view2 == this ? view != this.f39871c : view != view2)) {
            z = false;
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.z == 1 && view != null && this.f39881m) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.o.mutate().setAlpha(this.q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper != null) {
            collapsingTextHelper.R = drawableState;
            ColorStateList colorStateList2 = collapsingTextHelper.o;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = collapsingTextHelper.n) != null && colorStateList.isStateful())) {
                collapsingTextHelper.i(false);
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        if (!this.f39881m || (view = this.f39873e) == null) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int titleMarginStart = 0;
        boolean z2 = view.isAttachedToWindow() && this.f39873e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = getLayoutDirection() == 1;
            View view2 = this.f39872d;
            if (view2 == null) {
                view2 = this.f39871c;
            }
            int height = ((getHeight() - b(view2).f39904b) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
            View view3 = this.f39873e;
            Rect rect = this.f39878j;
            DescendantOffsetUtils.a(this, view3, rect);
            ViewGroup viewGroup = this.f39871c;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                titleMarginStart = toolbar.getTitleMarginStart();
                titleMarginEnd = toolbar.getTitleMarginEnd();
                titleMarginTop = toolbar.getTitleMarginTop();
                titleMarginBottom = toolbar.getTitleMarginBottom();
            } else if (viewGroup instanceof android.widget.Toolbar) {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                titleMarginStart = toolbar2.getTitleMarginStart();
                titleMarginEnd = toolbar2.getTitleMarginEnd();
                titleMarginTop = toolbar2.getTitleMarginTop();
                titleMarginBottom = toolbar2.getTitleMarginBottom();
            } else {
                titleMarginBottom = 0;
                titleMarginEnd = 0;
                titleMarginTop = 0;
            }
            int i6 = rect.left + (z3 ? titleMarginEnd : titleMarginStart);
            int i7 = rect.top + height + titleMarginTop;
            int i8 = rect.right;
            if (!z3) {
                titleMarginStart = titleMarginEnd;
            }
            int i9 = i8 - titleMarginStart;
            int i10 = (rect.bottom + height) - titleMarginBottom;
            CollapsingTextHelper collapsingTextHelper = this.f39879k;
            Rect rect2 = collapsingTextHelper.f40560h;
            if (rect2.left != i6 || rect2.top != i7 || rect2.right != i9 || rect2.bottom != i10) {
                rect2.set(i6, i7, i9, i10);
                collapsingTextHelper.S = true;
            }
            int i11 = z3 ? this.f39876h : this.f39874f;
            int i12 = rect.top + this.f39875g;
            int i13 = (i4 - i2) - (z3 ? this.f39874f : this.f39876h);
            int i14 = (i5 - i3) - this.f39877i;
            Rect rect3 = collapsingTextHelper.f40559g;
            if (rect3.left != i11 || rect3.top != i12 || rect3.right != i13 || rect3.bottom != i14) {
                rect3.set(i11, i12, i13, i14);
                collapsingTextHelper.S = true;
            }
            collapsingTextHelper.i(z);
        }
    }

    public final void f() {
        if (this.f39871c != null && this.f39881m && TextUtils.isEmpty(this.f39879k.G)) {
            ViewGroup viewGroup = this.f39871c;
            setTitle(viewGroup instanceof Toolbar ? ((Toolbar) viewGroup).getTitle() : viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f39884a = 0;
        layoutParams.f39885b = 0.5f;
        return layoutParams;
    }

    public int getCollapsedTitleGravity() {
        return this.f39879k.f40563k;
    }

    public float getCollapsedTitleTextSize() {
        return this.f39879k.f40565m;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f39879k.w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.f39879k.f40562j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f39877i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f39876h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f39874f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f39875g;
    }

    public float getExpandedTitleTextSize() {
        return this.f39879k.f40564l;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f39879k.z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @RequiresApi
    @RestrictTo
    public int getHyphenationFrequency() {
        return this.f39879k.q0;
    }

    @RestrictTo
    public int getLineCount() {
        StaticLayout staticLayout = this.f39879k.i0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi
    @RestrictTo
    public float getLineSpacingAdd() {
        return this.f39879k.i0.getSpacingAdd();
    }

    @RequiresApi
    @RestrictTo
    public float getLineSpacingMultiplier() {
        return this.f39879k.i0.getSpacingMultiplier();
    }

    @RestrictTo
    public int getMaxLines() {
        return this.f39879k.n0;
    }

    public int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.w;
        if (i2 >= 0) {
            return i2 + this.B + this.D;
        }
        WindowInsetsCompat windowInsetsCompat = this.A;
        int iJ = windowInsetsCompat != null ? windowInsetsCompat.j() : 0;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iJ, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f39881m) {
            return this.f39879k.G;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.z;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f39879k.V;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f39879k.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.x == null) {
                this.x = new OffsetUpdateListener();
            }
            AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.x;
            if (appBarLayout.f39842h == null) {
                appBarLayout.f39842h = new ArrayList();
            }
            if (onOffsetChangedListener != null && !appBarLayout.f39842h.contains(onOffsetChangedListener)) {
                appBarLayout.f39842h.add(onOffsetChangedListener);
            }
            ViewCompat.x(this);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f39879k.h(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.x;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).f39842h) != null) {
            arrayList.remove(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.A;
        if (windowInsetsCompat != null) {
            int iJ = windowInsetsCompat.j();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iJ) {
                    childAt.offsetTopAndBottom(iJ);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            ViewOffsetHelper viewOffsetHelperB = b(getChildAt(i7));
            View view = viewOffsetHelperB.f39903a;
            viewOffsetHelperB.f39904b = view.getTop();
            viewOffsetHelperB.f39905c = view.getLeft();
        }
        e(false, i2, i3, i4, i5);
        f();
        d();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            b(getChildAt(i8)).a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r9.a()
            super.onMeasure(r10, r11)
            int r11 = android.view.View.MeasureSpec.getMode(r11)
            androidx.core.view.WindowInsetsCompat r0 = r9.A
            if (r0 == 0) goto L13
            int r0 = r0.j()
            goto L14
        L13:
            r0 = 0
        L14:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == 0) goto L1c
            boolean r11 = r9.C
            if (r11 == 0) goto L2c
        L1c:
            if (r0 <= 0) goto L2c
            r9.B = r0
            int r11 = r9.getMeasuredHeight()
            int r11 = r11 + r0
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r1)
            super.onMeasure(r10, r11)
        L2c:
            boolean r11 = r9.E
            if (r11 == 0) goto L7f
            com.google.android.material.internal.CollapsingTextHelper r11 = r9.f39879k
            int r0 = r11.n0
            r2 = 1
            if (r0 <= r2) goto L7f
            r9.f()
            int r7 = r9.getMeasuredWidth()
            int r8 = r9.getMeasuredHeight()
            r5 = 0
            r6 = 0
            r4 = 1
            r3 = r9
            r3.e(r4, r5, r6, r7, r8)
            int r0 = r11.p
            if (r0 <= r2) goto L80
            android.text.TextPaint r4 = r11.U
            float r5 = r11.f40564l
            r4.setTextSize(r5)
            android.graphics.Typeface r5 = r11.z
            r4.setTypeface(r5)
            float r11 = r11.g0
            r4.setLetterSpacing(r11)
            float r11 = r4.ascent()
            float r11 = -r11
            float r4 = r4.descent()
            float r4 = r4 + r11
            int r11 = java.lang.Math.round(r4)
            int r0 = r0 - r2
            int r0 = r0 * r11
            r3.D = r0
            int r11 = r9.getMeasuredHeight()
            int r0 = r3.D
            int r11 = r11 + r0
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r1)
            super.onMeasure(r10, r11)
            goto L80
        L7f:
            r3 = r9
        L80:
            android.view.ViewGroup r10 = r3.f39871c
            if (r10 == 0) goto Lc4
            android.view.View r11 = r3.f39872d
            if (r11 == 0) goto La8
            if (r11 != r3) goto L8b
            goto La8
        L8b:
            android.view.ViewGroup$LayoutParams r10 = r11.getLayoutParams()
            boolean r0 = r10 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto La0
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            int r11 = r11.getMeasuredHeight()
            int r0 = r10.topMargin
            int r11 = r11 + r0
            int r10 = r10.bottomMargin
            int r11 = r11 + r10
            goto La4
        La0:
            int r11 = r11.getMeasuredHeight()
        La4:
            r9.setMinimumHeight(r11)
            return
        La8:
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            boolean r0 = r11 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto Lbd
            android.view.ViewGroup$MarginLayoutParams r11 = (android.view.ViewGroup.MarginLayoutParams) r11
            int r10 = r10.getMeasuredHeight()
            int r0 = r11.topMargin
            int r10 = r10 + r0
            int r11 = r11.bottomMargin
            int r10 = r10 + r11
            goto Lc1
        Lbd:
            int r10 = r10.getMeasuredHeight()
        Lc1:
            r9.setMinimumHeight(r10)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            ViewGroup viewGroup = this.f39871c;
            if (this.z == 1 && viewGroup != null && this.f39881m) {
                i3 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f39879k.l(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.f39879k.k(i2);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.o != colorStateList) {
            collapsingTextHelper.o = colorStateList;
            collapsingTextHelper.i(false);
        }
    }

    public void setCollapsedTitleTextSize(float f2) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.f40565m != f2) {
            collapsingTextHelper.f40565m = f2;
            collapsingTextHelper.i(false);
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.m(typeface)) {
            collapsingTextHelper.i(false);
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f39871c;
                if (this.z == 1 && viewGroup != null && this.f39881m) {
                    height = viewGroup.getBottom();
                }
                drawableMutate.setBounds(0, 0, width, height);
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(getContext().getDrawable(i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.f40562j != i2) {
            collapsingTextHelper.f40562j = i2;
            collapsingTextHelper.i(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f39877i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f39876h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f39874f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f39875g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.f39879k.n(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.n != colorStateList) {
            collapsingTextHelper.n = colorStateList;
            collapsingTextHelper.i(false);
        }
    }

    public void setExpandedTitleTextSize(float f2) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.f40564l != f2) {
            collapsingTextHelper.f40564l = f2;
            collapsingTextHelper.i(false);
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.o(typeface)) {
            collapsingTextHelper.i(false);
        }
    }

    @RestrictTo
    public void setExtraMultilineHeightEnabled(boolean z) {
        this.E = z;
    }

    @RestrictTo
    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.C = z;
    }

    @RequiresApi
    @RestrictTo
    public void setHyphenationFrequency(int i2) {
        this.f39879k.q0 = i2;
    }

    @RequiresApi
    @RestrictTo
    public void setLineSpacingAdd(float f2) {
        this.f39879k.o0 = f2;
    }

    @RequiresApi
    @RestrictTo
    public void setLineSpacingMultiplier(@FloatRange float f2) {
        this.f39879k.p0 = f2;
    }

    @RestrictTo
    public void setMaxLines(int i2) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (i2 != collapsingTextHelper.n0) {
            collapsingTextHelper.n0 = i2;
            Bitmap bitmap = collapsingTextHelper.K;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.K = null;
            }
            collapsingTextHelper.i(false);
        }
    }

    @RestrictTo
    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.f39879k.J = z;
    }

    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.q) {
            if (this.o != null && (viewGroup = this.f39871c) != null) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                viewGroup.postInvalidateOnAnimation();
            }
            this.q = i2;
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(@IntRange long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange int i2) {
        if (this.w != i2) {
            this.w = i2;
            d();
        }
    }

    public void setScrimsShown(boolean z) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        boolean z2 = isLaidOut() && !isInEditMode();
        if (this.r != z) {
            if (z2) {
                int i2 = z ? 255 : 0;
                a();
                ValueAnimator valueAnimator = this.s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.s = valueAnimator2;
                    valueAnimator2.setInterpolator(i2 > this.q ? this.u : this.v);
                    this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                        }
                    });
                } else if (valueAnimator.isRunning()) {
                    this.s.cancel();
                }
                this.s.setDuration(this.t);
                this.s.setIntValues(this.q, i2);
                this.s.start();
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    @RequiresApi
    @RestrictTo
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (collapsingTextHelper.r0 != staticLayoutBuilderConfigurer) {
            collapsingTextHelper.r0 = staticLayoutBuilderConfigurer;
            collapsingTextHelper.i(true);
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                Drawable drawable3 = this.p;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(getContext().getDrawable(i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        if (charSequence == null || !TextUtils.equals(collapsingTextHelper.G, charSequence)) {
            collapsingTextHelper.G = charSequence;
            collapsingTextHelper.H = null;
            Bitmap bitmap = collapsingTextHelper.K;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.K = null;
            }
            collapsingTextHelper.i(false);
        }
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i2) {
        this.z = i2;
        boolean z = i2 == 1;
        this.f39879k.f40555c = z;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z && this.o == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        collapsingTextHelper.F = truncateAt;
        collapsingTextHelper.i(false);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f39881m) {
            this.f39881m = z;
            setContentDescription(getTitle());
            c();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        CollapsingTextHelper collapsingTextHelper = this.f39879k;
        collapsingTextHelper.V = timeInterpolator;
        collapsingTextHelper.i(false);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3;
        ColorStateList colorStateListA;
        ColorStateList colorStateListA2;
        int i4 = F;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i4), attributeSet, i2);
        this.f39869a = true;
        this.f39878j = new Rect();
        this.w = -1;
        this.B = 0;
        this.D = 0;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.f39879k = collapsingTextHelper;
        collapsingTextHelper.W = AnimationUtils.f39820e;
        collapsingTextHelper.i(false);
        collapsingTextHelper.J = false;
        this.f39880l = new ElevationOverlayProvider(context2);
        int[] iArr = R.styleable.CollapsingToolbarLayout;
        ThemeEnforcement.a(context2, attributeSet, i2, i4);
        ThemeEnforcement.b(context2, attributeSet, iArr, i2, i4, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i4);
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691);
        if (collapsingTextHelper.f40562j != i5) {
            collapsingTextHelper.f40562j = i5;
            collapsingTextHelper.i(false);
        }
        collapsingTextHelper.l(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f39877i = dimensionPixelSize;
        this.f39876h = dimensionPixelSize;
        this.f39875g = dimensionPixelSize;
        this.f39874f = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f39874f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f39876h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f39875g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f39877i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f39881m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        collapsingTextHelper.n(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        collapsingTextHelper.k(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            collapsingTextHelper.n(typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            collapsingTextHelper.k(typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_titleTextEllipsize)) {
            int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_titleTextEllipsize, -1);
            setTitleEllipsize(i6 != 0 ? i6 != 1 ? i6 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor) && collapsingTextHelper.n != (colorStateListA2 = MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.CollapsingToolbarLayout_expandedTitleTextColor))) {
            collapsingTextHelper.n = colorStateListA2;
            collapsingTextHelper.i(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor) && collapsingTextHelper.o != (colorStateListA = MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor))) {
            collapsingTextHelper.o = colorStateListA;
            collapsingTextHelper.i(false);
        }
        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_maxLines) && (i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1)) != collapsingTextHelper.n0) {
            collapsingTextHelper.n0 = i3;
            Bitmap bitmap = collapsingTextHelper.K;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.K = null;
            }
            collapsingTextHelper.i(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator)) {
            collapsingTextHelper.V = android.view.animation.AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, 0));
            collapsingTextHelper.i(false);
        }
        this.t = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        this.u = MotionUtils.d(context2, R.attr.motionEasingStandardInterpolator, AnimationUtils.f39818c);
        this.v = MotionUtils.d(context2, R.attr.motionEasingStandardInterpolator, AnimationUtils.f39819d);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f39870b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.C = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.H(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                WindowInsetsCompat windowInsetsCompat2 = collapsingToolbarLayout.getFitsSystemWindows() ? windowInsetsCompat : null;
                if (!Objects.equals(collapsingToolbarLayout.A, windowInsetsCompat2)) {
                    collapsingToolbarLayout.A = windowInsetsCompat2;
                    collapsingToolbarLayout.requestLayout();
                }
                return windowInsetsCompat.c();
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.f39884a = 0;
        layoutParams2.f39885b = 0.5f;
        return layoutParams2;
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f39884a = 0;
        layoutParams.f39885b = 0.5f;
        return layoutParams;
    }
}
