package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public static final int J = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property K = new AnonymousClass6(Float.class, Snapshot.WIDTH);
    public static final Property L = new AnonymousClass7(Float.class, Snapshot.HEIGHT);
    public static final Property M = new AnonymousClass8(Float.class, "paddingStart");
    public static final Property Q = new AnonymousClass9(Float.class, "paddingEnd");
    public int A;
    public int B;
    public final ExtendedFloatingActionButtonBehavior C;
    public boolean D;
    public boolean E;
    public boolean F;
    public ColorStateList G;
    public int H;
    public int I;
    public int u;
    public final ChangeSizeStrategy v;
    public final ChangeSizeStrategy w;
    public final ShowStrategy x;
    public final HideStrategy y;
    public final int z;

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2, reason: invalid class name */
    class AnonymousClass2 implements Size {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int a() {
            return ExtendedFloatingActionButton.this.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int b() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int getWidth() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return (extendedFloatingActionButton.getMeasuredWidth() - (extendedFloatingActionButton.getCollapsedPadding() * 2)) + extendedFloatingActionButton.A + extendedFloatingActionButton.B;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3, reason: invalid class name */
    class AnonymousClass3 implements Size {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnonymousClass2 f40453a;

        public AnonymousClass3(AnonymousClass2 anonymousClass2) {
            this.f40453a = anonymousClass2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int a() {
            return ExtendedFloatingActionButton.this.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int b() {
            return ExtendedFloatingActionButton.this.A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            int i2 = extendedFloatingActionButton.I;
            ExtendedFloatingActionButton extendedFloatingActionButton2 = ExtendedFloatingActionButton.this;
            if (i2 != -1) {
                return (i2 == 0 || i2 == -2) ? extendedFloatingActionButton2.getMeasuredHeight() : i2;
            }
            if (!(extendedFloatingActionButton.getParent() instanceof View)) {
                return extendedFloatingActionButton2.getMeasuredHeight();
            }
            View view = (View) extendedFloatingActionButton.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                return (view.getHeight() - ((!(extendedFloatingActionButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingBottom() + view.getPaddingTop());
            }
            return extendedFloatingActionButton2.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final ViewGroup.LayoutParams getLayoutParams() {
            int i2 = ExtendedFloatingActionButton.this.I;
            if (i2 == 0) {
                i2 = -2;
            }
            return new ViewGroup.LayoutParams(-1, i2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public final int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            boolean z = extendedFloatingActionButton.getParent() instanceof View;
            AnonymousClass2 anonymousClass2 = this.f40453a;
            if (!z) {
                return anonymousClass2.getWidth();
            }
            View view = (View) extendedFloatingActionButton.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.width != -2) {
                return (view.getWidth() - ((!(extendedFloatingActionButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingRight() + view.getPaddingLeft());
            }
            return anonymousClass2.getWidth();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6, reason: invalid class name */
    public class AnonymousClass6 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public final void set(View view, Float f2) {
            View view2 = view;
            view2.getLayoutParams().width = f2.intValue();
            view2.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7, reason: invalid class name */
    public class AnonymousClass7 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public final void set(View view, Float f2) {
            View view2 = view;
            view2.getLayoutParams().height = f2.intValue();
            view2.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$8, reason: invalid class name */
    public class AnonymousClass8 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            return Float.valueOf(view.getPaddingStart());
        }

        @Override // android.util.Property
        public final void set(View view, Float f2) {
            View view2 = view;
            int iIntValue = f2.intValue();
            int paddingTop = view2.getPaddingTop();
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view2.setPaddingRelative(iIntValue, paddingTop, view2.getPaddingEnd(), view2.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$9, reason: invalid class name */
    public class AnonymousClass9 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            return Float.valueOf(view.getPaddingEnd());
        }

        @Override // android.util.Property
        public final void set(View view, Float f2) {
            View view2 = view;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view2.setPaddingRelative(view2.getPaddingStart(), view2.getPaddingTop(), f2.intValue(), view2.getPaddingBottom());
        }
    }

    public class ChangeSizeStrategy extends BaseMotionStrategy {

        /* renamed from: g, reason: collision with root package name */
        public final Size f40459g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f40460h;

        public ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.f40459g = size;
            this.f40460h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void a() {
            super.a();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.E = false;
            extendedFloatingActionButton.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            Size size = this.f40459g;
            layoutParams.width = size.getLayoutParams().width;
            layoutParams.height = size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final void b() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            boolean z = this.f40460h;
            extendedFloatingActionButton.D = z;
            ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!z) {
                extendedFloatingActionButton.H = layoutParams.width;
                extendedFloatingActionButton.I = layoutParams.height;
            }
            Size size = this.f40459g;
            layoutParams.width = size.getLayoutParams().width;
            layoutParams.height = size.getLayoutParams().height;
            int iB = size.b();
            int paddingTop = extendedFloatingActionButton.getPaddingTop();
            int iA = size.a();
            int paddingBottom = extendedFloatingActionButton.getPaddingBottom();
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            extendedFloatingActionButton.setPaddingRelative(iB, paddingTop, iA, paddingBottom);
            extendedFloatingActionButton.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final boolean c() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return this.f40460h == extendedFloatingActionButton.D || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(extendedFloatingActionButton.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final int e() {
            return this.f40460h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final AnimatorSet f() {
            MotionSpec motionSpec = this.f40435f;
            if (motionSpec == null) {
                if (this.f40434e == null) {
                    this.f40434e = MotionSpec.b(e(), this.f40430a);
                }
                motionSpec = this.f40434e;
                motionSpec.getClass();
            }
            boolean zG = motionSpec.g(Snapshot.WIDTH);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            Size size = this.f40459g;
            if (zG) {
                PropertyValuesHolder[] propertyValuesHolderArrE = motionSpec.e(Snapshot.WIDTH);
                propertyValuesHolderArrE[0].setFloatValues(extendedFloatingActionButton.getWidth(), size.getWidth());
                motionSpec.h(Snapshot.WIDTH, propertyValuesHolderArrE);
            }
            if (motionSpec.g(Snapshot.HEIGHT)) {
                PropertyValuesHolder[] propertyValuesHolderArrE2 = motionSpec.e(Snapshot.HEIGHT);
                propertyValuesHolderArrE2[0].setFloatValues(extendedFloatingActionButton.getHeight(), size.getHeight());
                motionSpec.h(Snapshot.HEIGHT, propertyValuesHolderArrE2);
            }
            if (motionSpec.g("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrE3 = motionSpec.e("paddingStart");
                PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArrE3[0];
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                propertyValuesHolder.setFloatValues(extendedFloatingActionButton.getPaddingStart(), size.b());
                motionSpec.h("paddingStart", propertyValuesHolderArrE3);
            }
            if (motionSpec.g("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrE4 = motionSpec.e("paddingEnd");
                PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolderArrE4[0];
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                propertyValuesHolder2.setFloatValues(extendedFloatingActionButton.getPaddingEnd(), size.a());
                motionSpec.h("paddingEnd", propertyValuesHolderArrE4);
            }
            if (motionSpec.g("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrE5 = motionSpec.e("labelOpacity");
                boolean z = this.f40460h;
                propertyValuesHolderArrE5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                motionSpec.h("labelOpacity", propertyValuesHolderArrE5);
            }
            return g(motionSpec);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.D = this.f40460h;
            extendedFloatingActionButton.E = true;
            extendedFloatingActionButton.setHorizontallyScrolling(true);
        }
    }

    public class HideStrategy extends BaseMotionStrategy {

        /* renamed from: g, reason: collision with root package name */
        public boolean f40465g;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void a() {
            super.a();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.u = 0;
            if (this.f40465g) {
                return;
            }
            extendedFloatingActionButton.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final void b() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final boolean c() {
            int i2 = ExtendedFloatingActionButton.J;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            if (extendedFloatingActionButton.getVisibility() == 0) {
                if (extendedFloatingActionButton.u != 1) {
                    return false;
                }
            } else if (extendedFloatingActionButton.u == 2) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void d() {
            super.d();
            this.f40465g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final int e() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f40465g = false;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            extendedFloatingActionButton.u = 1;
        }
    }

    public static abstract class OnChangedCallback {
    }

    public class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void a() {
            super.a();
            ExtendedFloatingActionButton.this.u = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final void b() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            extendedFloatingActionButton.setAlpha(1.0f);
            extendedFloatingActionButton.setScaleY(1.0f);
            extendedFloatingActionButton.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final boolean c() {
            int i2 = ExtendedFloatingActionButton.J;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            if (extendedFloatingActionButton.getVisibility() != 0) {
                if (extendedFloatingActionButton.u != 2) {
                    return false;
                }
            } else if (extendedFloatingActionButton.u == 1) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public final int e() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            extendedFloatingActionButton.u = 2;
        }
    }

    public interface Size {
        int a();

        int b();

        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r4, int r5) {
        /*
            r0 = 1
            r1 = 2
            if (r5 == 0) goto L20
            if (r5 == r0) goto L1d
            if (r5 == r1) goto L1a
            r2 = 3
            if (r5 != r2) goto Le
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r2 = r4.w
            goto L22
        Le:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unknown strategy type: "
            java.lang.String r5 = android.support.v4.media.b.f(r5, r0)
            r4.<init>(r5)
            throw r4
        L1a:
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r2 = r4.v
            goto L22
        L1d:
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy r2 = r4.y
            goto L22
        L20:
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy r2 = r4.x
        L22:
            boolean r3 = r2.c()
            if (r3 == 0) goto L29
            return
        L29:
            java.util.WeakHashMap r3 = androidx.core.view.ViewCompat.f3080a
            boolean r3 = r4.isLaidOut()
            if (r3 != 0) goto L45
            int r3 = r4.getVisibility()
            if (r3 == 0) goto L3c
            int r0 = r4.u
            if (r0 != r1) goto L41
            goto L92
        L3c:
            int r3 = r4.u
            if (r3 == r0) goto L41
            goto L92
        L41:
            boolean r0 = r4.F
            if (r0 == 0) goto L92
        L45:
            boolean r0 = r4.isInEditMode()
            if (r0 != 0) goto L92
            if (r5 != r1) goto L68
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            if (r5 == 0) goto L5c
            int r0 = r5.width
            r4.H = r0
            int r5 = r5.height
            r4.I = r5
            goto L68
        L5c:
            int r5 = r4.getWidth()
            r4.H = r5
            int r5 = r4.getHeight()
            r4.I = r5
        L68:
            r5 = 0
            r4.measure(r5, r5)
            android.animation.AnimatorSet r4 = r2.f()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$5 r5 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$5
            r5.<init>()
            r4.addListener(r5)
            java.util.ArrayList r5 = r2.f40432c
            java.util.Iterator r5 = r5.iterator()
        L7e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L8e
            java.lang.Object r0 = r5.next()
            android.animation.Animator$AnimatorListener r0 = (android.animation.Animator.AnimatorListener) r0
            r4.addListener(r0)
            goto L7e
        L8e:
            r4.start()
            return
        L92:
            r2.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton, int):void");
    }

    public final void f(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.C;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i2 = this.z;
        if (i2 >= 0) {
            return i2;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return getIconSize() + (Math.min(getPaddingStart(), getPaddingEnd()) * 2);
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.w.f40435f;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.y.f40435f;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.x.f40435f;
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.v.f40435f;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.D = false;
            this.v.b();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.F = z;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        this.w.f40435f = motionSpec;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(MotionSpec.b(i2, getContext()));
    }

    public void setExtended(boolean z) {
        if (this.D == z) {
            return;
        }
        ChangeSizeStrategy changeSizeStrategy = z ? this.w : this.v;
        if (changeSizeStrategy.c()) {
            return;
        }
        changeSizeStrategy.b();
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.y.f40435f = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(MotionSpec.b(i2, getContext()));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.D || this.E) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        this.A = getPaddingStart();
        this.B = getPaddingEnd();
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.D || this.E) {
            return;
        }
        this.A = i2;
        this.B = i4;
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.x.f40435f = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(MotionSpec.b(i2, getContext()));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        this.v.f40435f = motionSpec;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(MotionSpec.b(i2, getContext()));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        this.G = getTextColors();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$4] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3] */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = J;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.u = 0;
        AnimatorTracker animatorTracker = new AnimatorTracker();
        ShowStrategy showStrategy = new ShowStrategy(animatorTracker);
        this.x = showStrategy;
        HideStrategy hideStrategy = new HideStrategy(animatorTracker);
        this.y = hideStrategy;
        this.D = true;
        this.E = false;
        this.F = false;
        Context context2 = getContext();
        this.C = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i2, i3, new int[0]);
        MotionSpec motionSpecA = MotionSpec.a(context2, typedArrayD, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec motionSpecA2 = MotionSpec.a(context2, typedArrayD, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec motionSpecA3 = MotionSpec.a(context2, typedArrayD, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec motionSpecA4 = MotionSpec.a(context2, typedArrayD, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.z = typedArrayD.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int i4 = typedArrayD.getInt(R.styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        this.A = getPaddingStart();
        this.B = getPaddingEnd();
        AnimatorTracker animatorTracker2 = new AnimatorTracker();
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        final ?? anonymousClass3 = new AnonymousClass3(anonymousClass2);
        ChangeSizeStrategy changeSizeStrategy = new ChangeSizeStrategy(animatorTracker2, i4 != 1 ? i4 != 2 ? new Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int a() {
                return ExtendedFloatingActionButton.this.B;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int b() {
                return ExtendedFloatingActionButton.this.A;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int getHeight() {
                int i5 = ExtendedFloatingActionButton.this.I;
                return i5 == -1 ? anonymousClass3.getHeight() : (i5 == 0 || i5 == -2) ? ExtendedFloatingActionButton.this.getMeasuredHeight() : i5;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final ViewGroup.LayoutParams getLayoutParams() {
                ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
                int i5 = extendedFloatingActionButton.H;
                if (i5 == 0) {
                    i5 = -2;
                }
                int i6 = extendedFloatingActionButton.I;
                return new ViewGroup.LayoutParams(i5, i6 != 0 ? i6 : -2);
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int getWidth() {
                int i5 = ExtendedFloatingActionButton.this.H;
                return i5 == -1 ? anonymousClass3.getWidth() : (i5 == 0 || i5 == -2) ? anonymousClass2.getWidth() : i5;
            }
        } : anonymousClass3 : anonymousClass2, true);
        this.w = changeSizeStrategy;
        ChangeSizeStrategy changeSizeStrategy2 = new ChangeSizeStrategy(animatorTracker2, new Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int a() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int b() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int getHeight() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final ViewGroup.LayoutParams getLayoutParams() {
                ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
                return new ViewGroup.LayoutParams(extendedFloatingActionButton.getCollapsedSize(), extendedFloatingActionButton.getCollapsedSize());
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public final int getWidth() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }
        }, false);
        this.v = changeSizeStrategy2;
        showStrategy.f40435f = motionSpecA;
        hideStrategy.f40435f = motionSpecA2;
        changeSizeStrategy.f40435f = motionSpecA3;
        changeSizeStrategy2.f40435f = motionSpecA4;
        typedArrayD.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.d(context2, attributeSet, i2, i3, ShapeAppearanceModel.f41006m).a());
        this.G = getTextColors();
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f40462a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f40463b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f40464c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f40463b = false;
            this.f40464c = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean g(Rect rect, View view) {
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void i(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f2567h == 0) {
                layoutParams.f2567h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                y(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).f2560a instanceof BottomSheetBehavior : false) {
                    z(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List listL = coordinatorLayout.l(extendedFloatingActionButton);
            int size = listL.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = (View) listL.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).f2560a instanceof BottomSheetBehavior : false) && z(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (y(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i2, extendedFloatingActionButton);
            return true;
        }

        public final boolean y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f40463b && !this.f40464c) || layoutParams.f2565f != appBarLayout.getId()) {
                return false;
            }
            if (this.f40462a == null) {
                this.f40462a = new Rect();
            }
            Rect rect = this.f40462a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f40464c ? 2 : 1);
            } else {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f40464c ? 3 : 0);
            }
            return true;
        }

        public final boolean z(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f40463b && !this.f40464c) || layoutParams.f2565f != view.getId()) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f40464c ? 2 : 1);
            } else {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f40464c ? 3 : 0);
            }
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f40463b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f40464c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.G = getTextColors();
    }
}
