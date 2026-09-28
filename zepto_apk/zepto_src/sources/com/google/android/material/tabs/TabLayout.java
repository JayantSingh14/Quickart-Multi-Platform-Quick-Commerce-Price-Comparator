package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@ViewPager.DecorView
/* loaded from: classes4.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int I0 = R.style.Widget_Design_TabLayout;
    public static final Pools.SynchronizedPool J0 = new Pools.SynchronizedPool(16);
    public final int A;
    public ViewPager A0;
    public int B;
    public PagerAdapter B0;
    public int C;
    public DataSetObserver C0;
    public boolean D;
    public TabLayoutOnPageChangeListener D0;
    public boolean E;
    public AdapterChangeListener E0;
    public int F;
    public boolean F0;
    public int G;
    public int G0;
    public boolean H;
    public final Pools.SimplePool H0;
    public TabIndicatorInterpolator I;
    public final TimeInterpolator J;
    public BaseOnTabSelectedListener K;
    public final ArrayList L;
    public ViewPagerOnTabSelectedListener M;
    public ValueAnimator Q;

    /* renamed from: a, reason: collision with root package name */
    public int f41215a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f41216b;

    /* renamed from: c, reason: collision with root package name */
    public Tab f41217c;

    /* renamed from: d, reason: collision with root package name */
    public final SlidingTabIndicator f41218d;

    /* renamed from: e, reason: collision with root package name */
    public final int f41219e;

    /* renamed from: f, reason: collision with root package name */
    public final int f41220f;

    /* renamed from: g, reason: collision with root package name */
    public final int f41221g;

    /* renamed from: h, reason: collision with root package name */
    public final int f41222h;

    /* renamed from: i, reason: collision with root package name */
    public final int f41223i;

    /* renamed from: j, reason: collision with root package name */
    public final int f41224j;

    /* renamed from: k, reason: collision with root package name */
    public final int f41225k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f41226l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f41227m;
    public ColorStateList n;
    public Drawable o;
    public int p;
    public final PorterDuff.Mode q;
    public final float r;
    public final float s;
    public final int t;
    public int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public int z;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41229a;

        public AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void b(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.A0 == viewPager) {
                tabLayout.j(pagerAdapter2, this.f41229a);
            }
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void a(Tab tab);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            TabLayout.this.h();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            TabLayout.this.h();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f41232c = 0;

        /* renamed from: a, reason: collision with root package name */
        public ValueAnimator f41233a;

        public SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void a(int i2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.G0 == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i2);
                TabIndicatorInterpolator tabIndicatorInterpolator = tabLayout.I;
                Drawable drawable = tabLayout.o;
                tabIndicatorInterpolator.getClass();
                RectF rectFA = TabIndicatorInterpolator.a(tabLayout, childAt);
                drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
                tabLayout.f41215a = i2;
            }
        }

        public final void b(int i2) {
            TabLayout tabLayout = TabLayout.this;
            Rect bounds = tabLayout.o.getBounds();
            tabLayout.o.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        public final void c(View view, View view2, float f2) {
            TabLayout tabLayout = TabLayout.this;
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = tabLayout.o;
                drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.o.getBounds().bottom);
            } else {
                tabLayout.I.b(tabLayout, view, view2, f2, tabLayout.o);
            }
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }

        public final void d(int i2, int i3, boolean z) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f41215a == i2) {
                return;
            }
            final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            final View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                a(tabLayout.getSelectedTabPosition());
                return;
            }
            tabLayout.f41215a = i2;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    int i4 = SlidingTabIndicator.f41232c;
                    SlidingTabIndicator.this.c(childAt, childAt2, animatedFraction);
                }
            };
            if (!z) {
                this.f41233a.removeAllUpdateListeners();
                this.f41233a.addUpdateListener(animatorUpdateListener);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f41233a = valueAnimator;
            valueAnimator.setInterpolator(tabLayout.J);
            valueAnimator.setDuration(i3);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.start();
        }

        @Override // android.view.View
        public final void draw(Canvas canvas) {
            int height;
            TabLayout tabLayout = TabLayout.this;
            int iHeight = tabLayout.o.getBounds().height();
            if (iHeight < 0) {
                iHeight = tabLayout.o.getIntrinsicHeight();
            }
            int i2 = tabLayout.B;
            if (i2 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i2 != 1) {
                height = 0;
                if (i2 != 2) {
                    iHeight = i2 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (tabLayout.o.getBounds().width() > 0) {
                Rect bounds = tabLayout.o.getBounds();
                tabLayout.o.setBounds(bounds.left, height, bounds.right, iHeight);
                tabLayout.o.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f41233a;
            TabLayout tabLayout = TabLayout.this;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                d(tabLayout.getSelectedTabPosition(), -1, false);
                return;
            }
            if (tabLayout.f41215a == -1) {
                tabLayout.f41215a = tabLayout.getSelectedTabPosition();
            }
            a(tabLayout.f41215a);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.z == 1 || tabLayout.C == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.d(16, getContext())) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    tabLayout.z = 0;
                    tabLayout.m(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }
    }

    public static class Tab {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f41238a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f41239b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f41240c;

        /* renamed from: d, reason: collision with root package name */
        public int f41241d = -1;

        /* renamed from: e, reason: collision with root package name */
        public View f41242e;

        /* renamed from: f, reason: collision with root package name */
        public TabLayout f41243f;

        /* renamed from: g, reason: collision with root package name */
        public TabView f41244g;
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f41245a;

        /* renamed from: b, reason: collision with root package name */
        public int f41246b;

        /* renamed from: c, reason: collision with root package name */
        public int f41247c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f41245a = new WeakReference(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void a(float f2, int i2) {
            boolean z;
            TabLayout tabLayout = (TabLayout) this.f41245a.get();
            if (tabLayout != null) {
                int i3 = this.f41247c;
                boolean z2 = true;
                if (i3 != 2 || this.f41246b == 1) {
                    z = true;
                } else {
                    z = true;
                    z2 = false;
                }
                if (i3 == 2 && this.f41246b == 0) {
                    z = false;
                }
                tabLayout.k(i2, f2, z2, z, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void c(int i2) {
            this.f41246b = this.f41247c;
            this.f41247c = i2;
            TabLayout tabLayout = (TabLayout) this.f41245a.get();
            if (tabLayout != null) {
                tabLayout.G0 = this.f41247c;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void d(int i2) {
            TabLayout tabLayout = (TabLayout) this.f41245a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f41247c;
            tabLayout.i((i2 < 0 || i2 >= tabLayout.getTabCount()) ? null : (Tab) tabLayout.f41216b.get(i2), i3 == 0 || (i3 == 2 && this.f41246b == 0));
        }
    }

    public final class TabView extends LinearLayout {

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ int f41248l = 0;

        /* renamed from: a, reason: collision with root package name */
        public Tab f41249a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f41250b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f41251c;

        /* renamed from: d, reason: collision with root package name */
        public View f41252d;

        /* renamed from: e, reason: collision with root package name */
        public BadgeDrawable f41253e;

        /* renamed from: f, reason: collision with root package name */
        public View f41254f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f41255g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f41256h;

        /* renamed from: i, reason: collision with root package name */
        public Drawable f41257i;

        /* renamed from: j, reason: collision with root package name */
        public int f41258j;

        public TabView(Context context) {
            super(context);
            this.f41258j = 2;
            e(context);
            int i2 = TabLayout.this.f41219e;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            setPaddingRelative(i2, TabLayout.this.f41220f, TabLayout.this.f41221g, TabLayout.this.f41222h);
            setGravity(17);
            setOrientation(!TabLayout.this.D ? 1 : 0);
            setClickable(true);
            ViewCompat.I(this, new PointerIconCompat(PointerIcon.getSystemIcon(getContext(), 1002)));
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.f41253e;
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.f41253e == null) {
                this.f41253e = new BadgeDrawable(getContext(), null);
            }
            b();
            BadgeDrawable badgeDrawable = this.f41253e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a() {
            if (this.f41253e != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f41252d;
                if (view != null) {
                    BadgeDrawable badgeDrawable = this.f41253e;
                    if (badgeDrawable != null) {
                        if (badgeDrawable.d() != null) {
                            badgeDrawable.d().setForeground(null);
                        } else {
                            view.getOverlay().remove(badgeDrawable);
                        }
                    }
                    this.f41252d = null;
                }
            }
        }

        public final void b() {
            Tab tab;
            if (this.f41253e != null) {
                if (this.f41254f != null) {
                    a();
                    return;
                }
                ImageView imageView = this.f41251c;
                if (imageView != null && (tab = this.f41249a) != null && tab.f41238a != null) {
                    if (this.f41252d == imageView) {
                        c(imageView);
                        return;
                    }
                    a();
                    ImageView imageView2 = this.f41251c;
                    if (this.f41253e == null || imageView2 == null) {
                        return;
                    }
                    setClipChildren(false);
                    setClipToPadding(false);
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    if (viewGroup != null) {
                        viewGroup.setClipChildren(false);
                        viewGroup.setClipToPadding(false);
                    }
                    BadgeDrawable badgeDrawable = this.f41253e;
                    Rect rect = new Rect();
                    imageView2.getDrawingRect(rect);
                    badgeDrawable.setBounds(rect);
                    badgeDrawable.i(imageView2, null);
                    if (badgeDrawable.d() != null) {
                        badgeDrawable.d().setForeground(badgeDrawable);
                    } else {
                        imageView2.getOverlay().add(badgeDrawable);
                    }
                    this.f41252d = imageView2;
                    return;
                }
                TextView textView = this.f41250b;
                if (textView == null || this.f41249a == null) {
                    a();
                    return;
                }
                if (this.f41252d == textView) {
                    c(textView);
                    return;
                }
                a();
                TextView textView2 = this.f41250b;
                if (this.f41253e == null || textView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup2 = (ViewGroup) getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                BadgeDrawable badgeDrawable2 = this.f41253e;
                Rect rect2 = new Rect();
                textView2.getDrawingRect(rect2);
                badgeDrawable2.setBounds(rect2);
                badgeDrawable2.i(textView2, null);
                if (badgeDrawable2.d() != null) {
                    badgeDrawable2.d().setForeground(badgeDrawable2);
                } else {
                    textView2.getOverlay().add(badgeDrawable2);
                }
                this.f41252d = textView2;
            }
        }

        public final void c(View view) {
            BadgeDrawable badgeDrawable = this.f41253e;
            if (badgeDrawable == null || view != this.f41252d) {
                return;
            }
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            badgeDrawable.setBounds(rect);
            badgeDrawable.i(view, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d() {
            /*
                r3 = this;
                r3.f()
                com.google.android.material.tabs.TabLayout$Tab r0 = r3.f41249a
                if (r0 == 0) goto L20
                com.google.android.material.tabs.TabLayout r1 = r0.f41243f
                if (r1 == 0) goto L18
                int r1 = r1.getSelectedTabPosition()
                r2 = -1
                if (r1 == r2) goto L20
                int r0 = r0.f41241d
                if (r1 != r0) goto L20
                r0 = 1
                goto L21
            L18:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Tab not attached to a TabLayout"
                r0.<init>(r1)
                throw r0
            L20:
                r0 = 0
            L21:
                r3.setSelected(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.d():void");
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f41257i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f41257i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, com.google.android.material.tabs.TabLayout$TabView] */
        public final void e(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int i2 = tabLayout.t;
            if (i2 != 0) {
                Drawable drawableB = AppCompatResources.b(i2, context);
                this.f41257i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f41257i.setState(getDrawableState());
                }
            } else {
                this.f41257i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (tabLayout.n != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = RippleUtils.a(tabLayout.n);
                boolean z = tabLayout.H;
                if (z) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z ? null : gradientDrawable2);
            }
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            setBackground(gradientDrawable);
            tabLayout.invalidate();
        }

        public final void f() {
            int i2;
            ViewParent parent;
            Tab tab = this.f41249a;
            View view = tab != null ? tab.f41242e : null;
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f41254f;
                    if (view2 != null && (parent = view2.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f41254f);
                    }
                    addView(view);
                }
                this.f41254f = view;
                TextView textView = this.f41250b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f41251c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f41251c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.f41255g = textView2;
                if (textView2 != null) {
                    this.f41258j = textView2.getMaxLines();
                }
                this.f41256h = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view3 = this.f41254f;
                if (view3 != null) {
                    removeView(view3);
                    this.f41254f = null;
                }
                this.f41255g = null;
                this.f41256h = null;
            }
            if (this.f41254f == null) {
                if (this.f41251c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f41251c = imageView2;
                    addView(imageView2, 0);
                }
                if (this.f41250b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f41250b = textView3;
                    addView(textView3);
                    this.f41258j = this.f41250b.getMaxLines();
                }
                TextView textView4 = this.f41250b;
                TabLayout tabLayout = TabLayout.this;
                textView4.setTextAppearance(tabLayout.f41223i);
                if (!isSelected() || (i2 = tabLayout.f41225k) == -1) {
                    this.f41250b.setTextAppearance(tabLayout.f41224j);
                } else {
                    this.f41250b.setTextAppearance(i2);
                }
                ColorStateList colorStateList = tabLayout.f41226l;
                if (colorStateList != null) {
                    this.f41250b.setTextColor(colorStateList);
                }
                g(this.f41250b, this.f41251c, true);
                b();
                final ImageView imageView3 = this.f41251c;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                            View view5 = imageView3;
                            if (view5.getVisibility() == 0) {
                                int i11 = TabView.f41248l;
                                TabView.this.c(view5);
                            }
                        }
                    });
                }
                final TextView textView5 = this.f41250b;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                            View view5 = textView5;
                            if (view5.getVisibility() == 0) {
                                int i11 = TabView.f41248l;
                                TabView.this.c(view5);
                            }
                        }
                    });
                }
            } else {
                TextView textView6 = this.f41255g;
                if (textView6 != null || this.f41256h != null) {
                    g(textView6, this.f41256h, false);
                }
            }
            if (tab == null || TextUtils.isEmpty(tab.f41240c)) {
                return;
            }
            setContentDescription(tab.f41240c);
        }

        public final void g(TextView textView, ImageView imageView, boolean z) {
            boolean z2;
            Drawable drawable;
            Tab tab = this.f41249a;
            Drawable drawableMutate = (tab == null || (drawable = tab.f41238a) == null) ? null : drawable.mutate();
            TabLayout tabLayout = TabLayout.this;
            if (drawableMutate != null) {
                drawableMutate.setTintList(tabLayout.f41227m);
                PorterDuff.Mode mode = tabLayout.q;
                if (mode != null) {
                    drawableMutate.setTintMode(mode);
                }
            }
            Tab tab2 = this.f41249a;
            CharSequence charSequence = tab2 != null ? tab2.f41239b : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (zIsEmpty) {
                    z2 = false;
                } else {
                    this.f41249a.getClass();
                    z2 = true;
                }
                textView.setText(!zIsEmpty ? charSequence : null);
                textView.setVisibility(z2 ? 0 : 8);
                if (!zIsEmpty) {
                    setVisibility(0);
                }
            } else {
                z2 = false;
            }
            if (z && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iD = (z2 && imageView.getVisibility() == 0) ? (int) ViewUtils.d(8, getContext()) : 0;
                if (tabLayout.D) {
                    if (iD != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(iD);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iD != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iD;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.f41249a;
            CharSequence charSequence2 = tab3 != null ? tab3.f41240c : null;
            if (zIsEmpty) {
                charSequence = charSequence2;
            }
            TooltipCompat.a(this, charSequence);
        }

        public int getContentHeight() {
            View[] viewArr = {this.f41250b, this.f41251c, this.f41254f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                View view = viewArr[i2];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f41250b, this.f41251c, this.f41254f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                View view = viewArr[i2];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        @Nullable
        public Tab getTab() {
            return this.f41249a;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f41253e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfoCompat.q(this.f41253e.c());
            }
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, this.f41249a.f41241d, 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompat.n(false);
                accessibilityNodeInfoCompat.j(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3189g);
            }
            accessibilityNodeInfoCompat.t(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i2, int i3) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(tabLayout.u, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f41250b != null) {
                float f2 = tabLayout.r;
                int i4 = this.f41258j;
                ImageView imageView = this.f41251c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f41250b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = tabLayout.s;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f41250b.getTextSize();
                int lineCount = this.f41250b.getLineCount();
                int maxLines = this.f41250b.getMaxLines();
                if (f2 != textSize || (maxLines >= 0 && i4 != maxLines)) {
                    if (tabLayout.C == 1 && f2 > textSize && lineCount == 1) {
                        Layout layout = this.f41250b.getLayout();
                        if (layout == null) {
                            return;
                        }
                        if ((f2 / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                            return;
                        }
                    }
                    this.f41250b.setTextSize(0, f2);
                    this.f41250b.setMaxLines(i4);
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f41249a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            Tab tab = this.f41249a;
            TabLayout tabLayout = tab.f41243f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.i(tab, true);
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.f41250b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f41251c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f41254f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@Nullable Tab tab) {
            if (tab != this.f41249a) {
                this.f41249a = tab;
                d();
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager f41262a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f41262a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void a(Tab tab) throws Resources.NotFoundException {
            this.f41262a.setCurrentItem(tab.f41241d);
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Dimension
    private int getDefaultHeight() {
        ArrayList arrayList = this.f41216b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Tab tab = (Tab) arrayList.get(i2);
            if (tab != null && tab.f41238a != null && !TextUtils.isEmpty(tab.f41239b)) {
                return !this.D ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.v;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.C;
        if (i3 == 0 || i3 == 2) {
            return this.x;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f41218d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        SlidingTabIndicator slidingTabIndicator = this.f41218d;
        int childCount = slidingTabIndicator.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = slidingTabIndicator.getChildAt(i3);
                if ((i3 != i2 || childAt.isSelected()) && (i3 == i2 || !childAt.isSelected())) {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                } else {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).f();
                    }
                }
                i3++;
            }
        }
    }

    public final void a(Tab tab, boolean z) {
        ArrayList arrayList = this.f41216b;
        int size = arrayList.size();
        if (tab.f41243f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        tab.f41241d = size;
        arrayList.add(size, tab);
        int size2 = arrayList.size();
        int i2 = -1;
        for (int i3 = size + 1; i3 < size2; i3++) {
            if (((Tab) arrayList.get(i3)).f41241d == this.f41215a) {
                i2 = i3;
            }
            ((Tab) arrayList.get(i3)).f41241d = i3;
        }
        this.f41215a = i2;
        TabView tabView = tab.f41244g;
        tabView.setSelected(false);
        tabView.setActivated(false);
        int i4 = tab.f41241d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.C == 1 && this.z == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f41218d.addView(tabView, i4, layoutParams);
        if (z) {
            TabLayout tabLayout = tab.f41243f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.i(tab, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        Tab tabG = g();
        CharSequence charSequence = tabItem.f41212a;
        if (charSequence != null) {
            if (TextUtils.isEmpty(tabG.f41240c) && !TextUtils.isEmpty(charSequence)) {
                tabG.f41244g.setContentDescription(charSequence);
            }
            tabG.f41239b = charSequence;
            TabView tabView = tabG.f41244g;
            if (tabView != null) {
                tabView.d();
            }
        }
        Drawable drawable = tabItem.f41213b;
        if (drawable != null) {
            tabG.f41238a = drawable;
            TabLayout tabLayout = tabG.f41243f;
            if (tabLayout.z == 1 || tabLayout.C == 2) {
                tabLayout.m(true);
            }
            TabView tabView2 = tabG.f41244g;
            if (tabView2 != null) {
                tabView2.d();
            }
        }
        int i2 = tabItem.f41214c;
        if (i2 != 0) {
            tabG.f41242e = LayoutInflater.from(tabG.f41244g.getContext()).inflate(i2, (ViewGroup) tabG.f41244g, false);
            TabView tabView3 = tabG.f41244g;
            if (tabView3 != null) {
                tabView3.d();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabG.f41240c = tabItem.getContentDescription();
            TabView tabView4 = tabG.f41244g;
            if (tabView4 != null) {
                tabView4.d();
            }
        }
        a(tabG, this.f41216b.isEmpty());
    }

    public final void c(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (isLaidOut()) {
                SlidingTabIndicator slidingTabIndicator = this.f41218d;
                int childCount = slidingTabIndicator.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (slidingTabIndicator.getChildAt(i3).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iE = e(0.0f, i2);
                if (scrollX != iE) {
                    f();
                    this.Q.setIntValues(scrollX, iE);
                    this.Q.start();
                }
                ValueAnimator valueAnimator = slidingTabIndicator.f41233a;
                if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f41215a != i2) {
                    slidingTabIndicator.f41233a.cancel();
                }
                slidingTabIndicator.d(i2, this.A, true);
                return;
            }
        }
        k(i2, 0.0f, true, true, true);
    }

    public final void d() {
        int i2 = this.C;
        int iMax = (i2 == 0 || i2 == 2) ? Math.max(0, this.y - this.f41219e) : 0;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        SlidingTabIndicator slidingTabIndicator = this.f41218d;
        slidingTabIndicator.setPaddingRelative(iMax, 0, 0, 0);
        int i3 = this.C;
        if (i3 == 0) {
            int i4 = this.z;
            if (i4 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i4 == 1) {
                slidingTabIndicator.setGravity(1);
            } else if (i4 == 2) {
            }
            slidingTabIndicator.setGravity(8388611);
        } else if (i3 == 1 || i3 == 2) {
            if (this.z == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            slidingTabIndicator.setGravity(1);
        }
        m(true);
    }

    public final int e(float f2, int i2) {
        SlidingTabIndicator slidingTabIndicator;
        View childAt;
        int i3 = this.C;
        if ((i3 != 0 && i3 != 2) || (childAt = (slidingTabIndicator = this.f41218d).getChildAt(i2)) == null) {
            return 0;
        }
        int i4 = i2 + 1;
        View childAt2 = i4 < slidingTabIndicator.getChildCount() ? slidingTabIndicator.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return getLayoutDirection() == 0 ? left + i5 : left - i5;
    }

    public final void f() {
        if (this.Q == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.Q = valueAnimator;
            valueAnimator.setInterpolator(this.J);
            this.Q.setDuration(this.A);
            this.Q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    public final Tab g() {
        Tab tab = (Tab) J0.b();
        if (tab == null) {
            tab = new Tab();
        }
        tab.f41243f = this;
        Pools.SimplePool simplePool = this.H0;
        TabView tabView = simplePool != null ? (TabView) simplePool.b() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f41240c)) {
            tabView.setContentDescription(tab.f41239b);
        } else {
            tabView.setContentDescription(tab.f41240c);
        }
        tab.f41244g = tabView;
        return tab;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Tab tab = this.f41217c;
        if (tab != null) {
            return tab.f41241d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f41216b.size();
    }

    public int getTabGravity() {
        return this.z;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f41227m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.G;
    }

    public int getTabIndicatorGravity() {
        return this.B;
    }

    public int getTabMaxWidth() {
        return this.u;
    }

    public int getTabMode() {
        return this.C;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.n;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.o;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f41226l;
    }

    public final void h() {
        Tab tab;
        int currentItem;
        SlidingTabIndicator slidingTabIndicator = this.f41218d;
        int childCount = slidingTabIndicator.getChildCount() - 1;
        while (true) {
            tab = null;
            if (childCount < 0) {
                break;
            }
            TabView tabView = (TabView) slidingTabIndicator.getChildAt(childCount);
            slidingTabIndicator.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.H0.a(tabView);
            }
            requestLayout();
            childCount--;
        }
        ArrayList arrayList = this.f41216b;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Tab tab2 = (Tab) it.next();
            it.remove();
            tab2.f41243f = null;
            tab2.f41244g = null;
            tab2.f41238a = null;
            tab2.f41239b = null;
            tab2.f41240c = null;
            tab2.f41241d = -1;
            tab2.f41242e = null;
            J0.a(tab2);
        }
        this.f41217c = null;
        PagerAdapter pagerAdapter = this.B0;
        if (pagerAdapter != null) {
            int iC = pagerAdapter.c();
            for (int i2 = 0; i2 < iC; i2++) {
                Tab tabG = g();
                CharSequence charSequenceD = this.B0.d(i2);
                if (TextUtils.isEmpty(tabG.f41240c) && !TextUtils.isEmpty(charSequenceD)) {
                    tabG.f41244g.setContentDescription(charSequenceD);
                }
                tabG.f41239b = charSequenceD;
                TabView tabView2 = tabG.f41244g;
                if (tabView2 != null) {
                    tabView2.d();
                }
                a(tabG, false);
            }
            ViewPager viewPager = this.A0;
            if (viewPager == null || iC <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            if (currentItem >= 0 && currentItem < getTabCount()) {
                tab = (Tab) arrayList.get(currentItem);
            }
            i(tab, true);
        }
    }

    public final void i(Tab tab, boolean z) {
        TabLayout tabLayout;
        Tab tab2 = this.f41217c;
        ArrayList arrayList = this.L;
        if (tab2 == tab) {
            if (tab2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((BaseOnTabSelectedListener) arrayList.get(size)).getClass();
                }
                c(tab.f41241d);
                return;
            }
            return;
        }
        int i2 = tab != null ? tab.f41241d : -1;
        if (z) {
            if ((tab2 == null || tab2.f41241d == -1) && i2 != -1) {
                tabLayout = this;
                tabLayout.k(i2, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                c(i2);
            }
            if (i2 != -1) {
                setSelectedTabView(i2);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.f41217c = tab;
        if (tab2 != null && tab2.f41243f != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((BaseOnTabSelectedListener) arrayList.get(size2)).getClass();
            }
        }
        if (tab != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((BaseOnTabSelectedListener) arrayList.get(size3)).a(tab);
            }
        }
    }

    public final void j(PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.B0;
        if (pagerAdapter2 != null && (dataSetObserver = this.C0) != null) {
            pagerAdapter2.f12323a.unregisterObserver(dataSetObserver);
        }
        this.B0 = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.C0 == null) {
                this.C0 = new PagerAdapterObserver();
            }
            pagerAdapter.f12323a.registerObserver(this.C0);
        }
        h();
    }

    public final void k(int i2, float f2, boolean z, boolean z2, boolean z3) {
        float f3 = i2 + f2;
        int iRound = Math.round(f3);
        if (iRound >= 0) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (iRound >= slidingTabIndicator.getChildCount()) {
                return;
            }
            if (z2) {
                TabLayout.this.f41215a = Math.round(f3);
                ValueAnimator valueAnimator = slidingTabIndicator.f41233a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    slidingTabIndicator.f41233a.cancel();
                }
                slidingTabIndicator.c(slidingTabIndicator.getChildAt(i2), slidingTabIndicator.getChildAt(i2 + 1), f2);
            }
            ValueAnimator valueAnimator2 = this.Q;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.Q.cancel();
            }
            int iE = e(f2, i2);
            int scrollX = getScrollX();
            boolean z4 = (i2 < getSelectedTabPosition() && iE >= scrollX) || (i2 > getSelectedTabPosition() && iE <= scrollX) || i2 == getSelectedTabPosition();
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (getLayoutDirection() == 1) {
                z4 = (i2 < getSelectedTabPosition() && iE <= scrollX) || (i2 > getSelectedTabPosition() && iE >= scrollX) || i2 == getSelectedTabPosition();
            }
            if (z4 || this.G0 == 1 || z3) {
                if (i2 < 0) {
                    iE = 0;
                }
                scrollTo(iE, 0);
            }
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void l(ViewPager viewPager, boolean z) {
        TabLayout tabLayout;
        ArrayList arrayList;
        ArrayList arrayList2;
        ViewPager viewPager2 = this.A0;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.D0;
            if (tabLayoutOnPageChangeListener != null && (arrayList2 = viewPager2.D0) != null) {
                arrayList2.remove(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.E0;
            if (adapterChangeListener != null && (arrayList = this.A0.G0) != null) {
                arrayList.remove(adapterChangeListener);
            }
        }
        ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = this.M;
        ArrayList arrayList3 = this.L;
        if (viewPagerOnTabSelectedListener != null) {
            arrayList3.remove(viewPagerOnTabSelectedListener);
            this.M = null;
        }
        if (viewPager != null) {
            this.A0 = viewPager;
            if (this.D0 == null) {
                this.D0 = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.D0;
            tabLayoutOnPageChangeListener2.f41247c = 0;
            tabLayoutOnPageChangeListener2.f41246b = 0;
            if (viewPager.D0 == null) {
                viewPager.D0 = new ArrayList();
            }
            viewPager.D0.add(tabLayoutOnPageChangeListener2);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener2 = new ViewPagerOnTabSelectedListener(viewPager);
            this.M = viewPagerOnTabSelectedListener2;
            if (!arrayList3.contains(viewPagerOnTabSelectedListener2)) {
                arrayList3.add(viewPagerOnTabSelectedListener2);
            }
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                j(adapter, true);
            }
            if (this.E0 == null) {
                this.E0 = new AdapterChangeListener();
            }
            AdapterChangeListener adapterChangeListener2 = this.E0;
            adapterChangeListener2.f41229a = true;
            if (viewPager.G0 == null) {
                viewPager.G0 = new ArrayList();
            }
            viewPager.G0.add(adapterChangeListener2);
            k(viewPager.getCurrentItem(), 0.0f, true, true, true);
            tabLayout = this;
        } else {
            tabLayout = this;
            tabLayout.A0 = null;
            j(null, false);
        }
        tabLayout.F0 = z;
    }

    public final void m(boolean z) {
        int i2 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (i2 >= slidingTabIndicator.getChildCount()) {
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.C == 1 && this.z == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i2++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
        if (this.A0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                l((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.F0) {
            setupWithViewPager(null);
            this.F0 = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i2 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (i2 >= slidingTabIndicator.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i2);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).f41257i) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.f41257i.draw(canvas);
            }
            i2++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        new AccessibilityNodeInfoCompat(accessibilityNodeInfo).o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, getTabCount(), 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.d(r1, r0)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.w
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.d(r2, r1)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.u = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.C
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.b(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.D == z) {
            return;
        }
        this.D = z;
        int i2 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (i2 >= slidingTabIndicator.getChildCount()) {
                d();
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                TabView tabView = (TabView) childAt;
                tabView.setOrientation(!TabLayout.this.D ? 1 : 0);
                TextView textView = tabView.f41255g;
                if (textView == null && tabView.f41256h == null) {
                    tabView.g(tabView.f41250b, tabView.f41251c, true);
                } else {
                    tabView.g(textView, tabView.f41256h, false);
                }
            }
            i2++;
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.Q.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.o = drawableMutate;
        int i2 = this.p;
        if (i2 != 0) {
            drawableMutate.setTint(i2);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.F;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.o.getIntrinsicHeight();
        }
        this.f41218d.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.p = i2;
        Drawable drawable = this.o;
        if (i2 != 0) {
            drawable.setTint(i2);
        } else {
            drawable.setTintList(null);
        }
        m(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.B != i2) {
            this.B = i2;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            this.f41218d.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.F = i2;
        this.f41218d.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            d();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f41227m != colorStateList) {
            this.f41227m = colorStateList;
            ArrayList arrayList = this.f41216b;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                TabView tabView = ((Tab) arrayList.get(i2)).f41244g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(ContextCompat.b(i2, getContext()));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.G = i2;
        if (i2 == 0) {
            this.I = new TabIndicatorInterpolator();
            return;
        }
        if (i2 == 1) {
            this.I = new ElasticTabIndicatorInterpolator();
        } else {
            if (i2 == 2) {
                this.I = new FadeTabIndicatorInterpolator();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.E = z;
        int i2 = SlidingTabIndicator.f41232c;
        SlidingTabIndicator slidingTabIndicator = this.f41218d;
        slidingTabIndicator.a(TabLayout.this.getSelectedTabPosition());
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        slidingTabIndicator.postInvalidateOnAnimation();
    }

    public void setTabMode(int i2) {
        if (i2 != this.C) {
            this.C = i2;
            d();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.n == colorStateList) {
            return;
        }
        this.n = colorStateList;
        int i2 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (i2 >= slidingTabIndicator.getChildCount()) {
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                Context context = getContext();
                int i3 = TabView.f41248l;
                ((TabView) childAt).e(context);
            }
            i2++;
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(ContextCompat.b(i2, getContext()));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f41226l != colorStateList) {
            this.f41226l = colorStateList;
            ArrayList arrayList = this.f41216b;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                TabView tabView = ((Tab) arrayList.get(i2)).f41244g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        j(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.H == z) {
            return;
        }
        this.H = z;
        int i2 = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.f41218d;
            if (i2 >= slidingTabIndicator.getChildCount()) {
                return;
            }
            View childAt = slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                Context context = getContext();
                int i3 = TabView.f41248l;
                ((TabView) childAt).e(context);
            }
            i2++;
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        l(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = I0;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f41215a = -1;
        this.f41216b = new ArrayList();
        this.f41225k = -1;
        this.p = 0;
        this.u = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.F = -1;
        this.L = new ArrayList();
        this.H0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.f41218d = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.TabLayout, i2, i3, R.styleable.TabLayout_tabTextAppearance);
        ColorStateList colorStateListD = DrawableUtils.d(getBackground());
        if (colorStateListD != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.m(colorStateListD);
            materialShapeDrawable.k(context2);
            materialShapeDrawable.l(ViewCompat.j(this));
            setBackground(materialShapeDrawable);
        }
        setSelectedTabIndicator(MaterialResources.d(context2, typedArrayD, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayD.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        slidingTabIndicator.b(typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayD.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayD.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayD.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f41222h = dimensionPixelSize;
        this.f41221g = dimensionPixelSize;
        this.f41220f = dimensionPixelSize;
        this.f41219e = dimensionPixelSize;
        this.f41219e = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f41220f = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, dimensionPixelSize);
        this.f41221g = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, dimensionPixelSize);
        this.f41222h = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, dimensionPixelSize);
        if (MaterialAttributes.b(context2, R.attr.isMaterial3Theme, false)) {
            this.f41223i = R.attr.textAppearanceTitleSmall;
        } else {
            this.f41223i = R.attr.textAppearanceButton;
        }
        int resourceId = typedArrayD.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.f41224j = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.r = dimensionPixelSize2;
            this.f41226l = MaterialResources.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayD.hasValue(R.styleable.TabLayout_tabSelectedTextAppearance)) {
                this.f41225k = typedArrayD.getResourceId(R.styleable.TabLayout_tabSelectedTextAppearance, resourceId);
            }
            int i4 = this.f41225k;
            int[] iArr = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr2 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i4 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i4, androidx.appcompat.R.styleable.TextAppearance);
                try {
                    typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, (int) dimensionPixelSize2);
                    ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
                    if (colorStateListA != null) {
                        this.f41226l = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor()), this.f41226l.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (typedArrayD.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f41226l = MaterialResources.a(context2, typedArrayD, R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayD.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f41226l = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{typedArrayD.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0), this.f41226l.getDefaultColor()});
            }
            this.f41227m = MaterialResources.a(context2, typedArrayD, R.styleable.TabLayout_tabIconTint);
            this.q = ViewUtils.i(typedArrayD.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.n = MaterialResources.a(context2, typedArrayD, R.styleable.TabLayout_tabRippleColor);
            this.A = typedArrayD.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.J = MotionUtils.d(context2, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.f39817b);
            this.v = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.w = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.t = typedArrayD.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.y = typedArrayD.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.C = typedArrayD.getInt(R.styleable.TabLayout_tabMode, 1);
            this.z = typedArrayD.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.D = typedArrayD.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.H = typedArrayD.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayD.recycle();
            Resources resources = getResources();
            this.s = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.x = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            d();
        } finally {
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i2) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.K;
        ArrayList arrayList = this.L;
        if (baseOnTabSelectedListener2 != null) {
            arrayList.remove(baseOnTabSelectedListener2);
        }
        this.K = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener == null || arrayList.contains(baseOnTabSelectedListener)) {
            return;
        }
        arrayList.add(baseOnTabSelectedListener);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.b(i2, getContext()));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
