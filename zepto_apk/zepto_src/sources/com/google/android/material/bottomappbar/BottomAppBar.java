package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.d;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int d1 = R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int e1 = R.attr.motionDurationLong2;
    public static final int f1 = R.attr.motionEasingEmphasizedInterpolator;
    public Integer G0;
    public final MaterialShapeDrawable H0;
    public AnimatorSet I0;
    public AnimatorSet J0;
    public int K0;
    public int L0;
    public int M0;
    public final int N0;
    public int O0;
    public int P0;
    public final boolean Q0;
    public boolean R0;
    public final boolean S0;
    public final boolean T0;
    public final boolean U0;
    public boolean V0;
    public boolean W0;
    public Behavior X0;
    public int Y0;
    public int Z0;
    public int a1;
    public final AnimatorListenerAdapter b1;
    public final TransformationCallback c1;

    public interface AnimationListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface MenuAlignmentMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public int f39999c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f40000d;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f39999c = parcel.readInt();
            this.f40000d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f39999c);
            parcel.writeInt(this.f40000d ? 1 : 0);
        }
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public static void N(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.f2563d = 17;
        int i2 = bottomAppBar.M0;
        if (i2 == 1) {
            layoutParams.f2563d = 49;
        }
        if (i2 == 0) {
            layoutParams.f2563d |= 80;
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.Y0;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.c(getContext(), e1, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return G(this.K0);
    }

    private float getFabTranslationY() {
        if (this.M0 == 1) {
            return -getTopEdgeTreatment().f40004d;
        }
        return E() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.a1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.Z0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.H0.f40974a.f40989a.f41015i;
    }

    public final View E() {
        if (getParent() instanceof CoordinatorLayout) {
            ArrayList arrayList = (ArrayList) ((CoordinatorLayout) getParent()).f2546b.f2576b.get(this);
            List<View> arrayList2 = arrayList == null ? null : new ArrayList(arrayList);
            if (arrayList2 == null) {
                arrayList2 = Collections.EMPTY_LIST;
            }
            for (View view : arrayList2) {
                if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                    return view;
                }
            }
        }
        return null;
    }

    public final int F(ActionMenuView actionMenuView, int i2, boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset = 0;
        if (this.P0 != 1 && (i2 != 1 || !z)) {
            return 0;
        }
        boolean zH = ViewUtils.h(this);
        int measuredWidth = zH ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f243a & 8388615) == 8388611) {
                measuredWidth = zH ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zH ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i4 = zH ? this.Z0 : -this.a1;
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            if (!zH) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        }
        return measuredWidth - ((right + i4) + dimensionPixelOffset);
    }

    public final float G(int i2) {
        boolean zH = ViewUtils.h(this);
        if (i2 != 1) {
            return 0.0f;
        }
        View viewE = E();
        int i3 = zH ? this.a1 : this.Z0;
        return ((getMeasuredWidth() / 2) - ((this.O0 == -1 || viewE == null) ? this.N0 + i3 : ((viewE.getMeasuredWidth() / 2) + this.O0) + i3)) * (zH ? -1 : 1);
    }

    public final boolean H() {
        View viewE = E();
        FloatingActionButton floatingActionButton = viewE instanceof FloatingActionButton ? (FloatingActionButton) viewE : null;
        return floatingActionButton != null && floatingActionButton.j();
    }

    public final void I(final int i2, final boolean z) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!isLaidOut()) {
            this.V0 = false;
            return;
        }
        AnimatorSet animatorSet = this.J0;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!H()) {
            i2 = 0;
            z = false;
        }
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
            if (Math.abs(actionMenuView.getTranslationX() - F(actionMenuView, i2, z)) > 1.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7

                    /* renamed from: a, reason: collision with root package name */
                    public boolean f39987a;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator animator) {
                        this.f39987a = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        if (this.f39987a) {
                            return;
                        }
                        BottomAppBar bottomAppBar = BottomAppBar.this;
                        bottomAppBar.getClass();
                        bottomAppBar.M(actionMenuView, i2, z, false);
                    }
                });
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                arrayList.add(animatorSet2);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(objectAnimatorOfFloat);
            }
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        this.J0 = animatorSet3;
        animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                int i3 = BottomAppBar.d1;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.getClass();
                bottomAppBar.V0 = false;
                bottomAppBar.J0 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                int i3 = BottomAppBar.d1;
                BottomAppBar.this.getClass();
            }
        });
        this.J0.start();
    }

    public final void J() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.J0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (H()) {
            M(actionMenuView, this.K0, this.W0, false);
        } else {
            M(actionMenuView, 0, false, false);
        }
    }

    public final void K() {
        getTopEdgeTreatment().f40005e = getFabTranslationX();
        this.H0.n((this.W0 && H() && this.M0 == 1) ? 1.0f : 0.0f);
        View viewE = E();
        if (viewE != null) {
            viewE.setTranslationY(getFabTranslationY());
            viewE.setTranslationX(getFabTranslationX());
        }
    }

    public final void L(int i2) {
        float f2 = i2;
        if (f2 != getTopEdgeTreatment().f40003c) {
            getTopEdgeTreatment().f40003c = f2;
            this.H0.invalidateSelf();
        }
    }

    public final void M(final ActionMenuView actionMenuView, final int i2, final boolean z, boolean z2) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i2;
                boolean z3 = z;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                actionMenuView.setTranslationX(bottomAppBar.F(r3, i3, z3));
            }
        };
        if (z2) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.H0.f40974a.f40993e;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f40004d;
    }

    public int getFabAlignmentMode() {
        return this.K0;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.O0;
    }

    public int getFabAnchorMode() {
        return this.M0;
    }

    public int getFabAnimationMode() {
        return this.L0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f40002b;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f40001a;
    }

    public boolean getHideOnScroll() {
        return this.R0;
    }

    public int getMenuAlignmentMode() {
        return this.P0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.c(this, this.H0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            AnimatorSet animatorSet = this.J0;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.I0;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            K();
            View viewE = E();
            if (viewE != null) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (viewE.isLaidOut()) {
                    viewE.post(new d(1, viewE));
                }
            }
        }
        J();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        this.K0 = savedState.f39999c;
        this.W0 = savedState.f40000d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f39999c = this.K0;
        savedState.f40000d = this.W0;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        this.H0.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().c(f2);
            this.H0.invalidateSelf();
            K();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.H0;
        materialShapeDrawable.l(f2);
        int iH = materialShapeDrawable.f40974a.o - materialShapeDrawable.h();
        Behavior behavior = getBehavior();
        behavior.f39960h = iH;
        if (behavior.f39959g == 1) {
            setTranslationY(behavior.f39958f + iH);
        }
    }

    public void setFabAlignmentMode(final int i2) {
        this.V0 = true;
        I(i2, this.W0);
        if (this.K0 != i2) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (isLaidOut()) {
                AnimatorSet animatorSet = this.I0;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                ArrayList arrayList = new ArrayList();
                if (this.L0 == 1) {
                    View viewE = E();
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewE instanceof FloatingActionButton ? (FloatingActionButton) viewE : null, "translationX", G(i2));
                    objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
                    arrayList.add(objectAnimatorOfFloat);
                } else {
                    View viewE2 = E();
                    FloatingActionButton floatingActionButton = viewE2 instanceof FloatingActionButton ? (FloatingActionButton) viewE2 : null;
                    if (floatingActionButton != null && !floatingActionButton.i()) {
                        floatingActionButton.h(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
                            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                            public final void a(FloatingActionButton floatingActionButton2) {
                                int i3 = BottomAppBar.d1;
                                floatingActionButton2.setTranslationX(BottomAppBar.this.G(i2));
                                floatingActionButton2.m(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                                    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                                    public final void b() {
                                        BottomAppBar bottomAppBar = BottomAppBar.this;
                                        int i4 = BottomAppBar.d1;
                                    }
                                }, true);
                            }
                        }, true);
                    }
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(arrayList);
                animatorSet2.setInterpolator(MotionUtils.d(getContext(), f1, AnimationUtils.f39816a));
                this.I0 = animatorSet2;
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        BottomAppBar bottomAppBar = BottomAppBar.this;
                        int i3 = BottomAppBar.d1;
                        bottomAppBar.I0 = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator) {
                        int i3 = BottomAppBar.d1;
                    }
                });
                this.I0.start();
            }
        }
        this.K0 = i2;
    }

    public void setFabAlignmentModeEndMargin(@Px int i2) {
        if (this.O0 != i2) {
            this.O0 = i2;
            K();
        }
    }

    public void setFabAnchorMode(int i2) {
        this.M0 = i2;
        K();
        View viewE = E();
        if (viewE != null) {
            N(this, viewE);
            viewE.requestLayout();
            this.H0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i2) {
        this.L0 = i2;
    }

    public void setFabCornerSize(@Dimension float f2) {
        if (f2 != getTopEdgeTreatment().f40006f) {
            getTopEdgeTreatment().f40006f = f2;
            this.H0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().f40002b = f2;
            this.H0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f40001a = f2;
            this.H0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.R0 = z;
    }

    public void setMenuAlignmentMode(int i2) {
        if (this.P0 != i2) {
            this.P0 = i2;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                M(actionMenuView, this.K0, H(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.G0 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.G0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.G0 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = d1;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.H0 = materialShapeDrawable;
        this.V0 = false;
        this.W0 = true;
        this.b1 = new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (bottomAppBar.V0) {
                    return;
                }
                bottomAppBar.I(bottomAppBar.K0, bottomAppBar.W0);
            }
        };
        this.c1 = new TransformationCallback<FloatingActionButton>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
            @Override // com.google.android.material.animation.TransformationCallback
            public final void a(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.H0.n((floatingActionButton.getVisibility() == 0 && bottomAppBar.M0 == 1) ? floatingActionButton.getScaleY() : 0.0f);
            }

            @Override // com.google.android.material.animation.TransformationCallback
            public final void b(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (bottomAppBar.M0 != 1) {
                    return;
                }
                float translationX = floatingActionButton.getTranslationX();
                float f2 = bottomAppBar.getTopEdgeTreatment().f40005e;
                MaterialShapeDrawable materialShapeDrawable2 = bottomAppBar.H0;
                if (f2 != translationX) {
                    bottomAppBar.getTopEdgeTreatment().f40005e = translationX;
                    materialShapeDrawable2.invalidateSelf();
                }
                float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (bottomAppBar.getTopEdgeTreatment().f40004d != fMax) {
                    bottomAppBar.getTopEdgeTreatment().c(fMax);
                    materialShapeDrawable2.invalidateSelf();
                }
                materialShapeDrawable2.n(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        };
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.BottomAppBar, i2, i3, new int[0]);
        ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayD, R.styleable.BottomAppBar_backgroundTint);
        if (typedArrayD.hasValue(R.styleable.BottomAppBar_navigationIconTint)) {
            setNavigationIconTint(typedArrayD.getColor(R.styleable.BottomAppBar_navigationIconTint, -1));
        }
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayD.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayD.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.K0 = typedArrayD.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.L0 = typedArrayD.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.M0 = typedArrayD.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.Q0 = typedArrayD.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.P0 = typedArrayD.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.R0 = typedArrayD.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.S0 = typedArrayD.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.T0 = typedArrayD.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.U0 = typedArrayD.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.O0 = typedArrayD.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean z = typedArrayD.getBoolean(R.styleable.BottomAppBar_addElevationShadow, true);
        typedArrayD.recycle();
        this.N0 = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = new BottomAppBarTopEdgeTreatment();
        bottomAppBarTopEdgeTreatment.f40006f = -1.0f;
        bottomAppBarTopEdgeTreatment.f40002b = dimensionPixelOffset;
        bottomAppBarTopEdgeTreatment.f40001a = dimensionPixelOffset2;
        bottomAppBarTopEdgeTreatment.c(dimensionPixelOffset3);
        bottomAppBarTopEdgeTreatment.f40005e = 0.0f;
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.f41027i = bottomAppBarTopEdgeTreatment;
        materialShapeDrawable.setShapeAppearanceModel(builder.a());
        if (z) {
            materialShapeDrawable.r(2);
        } else {
            materialShapeDrawable.r(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        Paint.Style style = Paint.Style.FILL;
        materialShapeDrawable.o();
        materialShapeDrawable.k(context2);
        setElevation(dimensionPixelSize);
        materialShapeDrawable.setTintList(colorStateListA);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setBackground(materialShapeDrawable);
        ViewUtils.c(this, attributeSet, i2, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                boolean z2;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (bottomAppBar.S0) {
                    bottomAppBar.Y0 = windowInsetsCompat.g();
                }
                boolean z3 = false;
                if (bottomAppBar.T0) {
                    z2 = bottomAppBar.a1 != windowInsetsCompat.h();
                    bottomAppBar.a1 = windowInsetsCompat.h();
                } else {
                    z2 = false;
                }
                if (bottomAppBar.U0) {
                    boolean z4 = bottomAppBar.Z0 != windowInsetsCompat.i();
                    bottomAppBar.Z0 = windowInsetsCompat.i();
                    z3 = z4;
                }
                if (!z2 && !z3) {
                    return windowInsetsCompat;
                }
                AnimatorSet animatorSet = bottomAppBar.J0;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AnimatorSet animatorSet2 = bottomAppBar.I0;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                bottomAppBar.K();
                bottomAppBar.J();
                return windowInsetsCompat;
            }
        });
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.X0 == null) {
            this.X0 = new Behavior();
        }
        return this.X0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: m, reason: collision with root package name */
        public final Rect f39997m;
        public WeakReference n;
        public int o;
        public final View.OnLayoutChangeListener p;

        public Behavior() {
            this.p = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    Behavior behavior = Behavior.this;
                    BottomAppBar bottomAppBar = (BottomAppBar) behavior.n.get();
                    if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        int measuredWidth = floatingActionButton.getMeasuredWidth();
                        int measuredHeight = floatingActionButton.getMeasuredHeight();
                        Rect rect = behavior.f39997m;
                        rect.set(0, 0, measuredWidth, measuredHeight);
                        floatingActionButton.k(rect);
                        int iHeight = rect.height();
                        bottomAppBar.L(iHeight);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().f41011e.a(new RectF(rect)));
                        height = iHeight;
                    }
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (behavior.o == 0) {
                        if (bottomAppBar.M0 == 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                        boolean zH = ViewUtils.h(view);
                        int i10 = bottomAppBar.N0;
                        if (zH) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += i10;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += i10;
                        }
                    }
                    int i11 = BottomAppBar.d1;
                    bottomAppBar.K();
                }
            };
            this.f39997m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
            final BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.n = new WeakReference(bottomAppBar);
            int i3 = BottomAppBar.d1;
            View viewE = bottomAppBar.E();
            if (viewE != null) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (!viewE.isLaidOut()) {
                    BottomAppBar.N(bottomAppBar, viewE);
                    this.o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) viewE.getLayoutParams())).bottomMargin;
                    if (viewE instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) viewE;
                        if (bottomAppBar.M0 == 0 && bottomAppBar.Q0) {
                            ViewCompat.E(floatingActionButton, 0.0f);
                            floatingActionButton.setCompatElevation(0.0f);
                        }
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.d(bottomAppBar.b1);
                        floatingActionButton.e(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                BottomAppBar bottomAppBar2 = BottomAppBar.this;
                                bottomAppBar2.b1.onAnimationStart(animator);
                                View viewE2 = bottomAppBar2.E();
                                FloatingActionButton floatingActionButton2 = viewE2 instanceof FloatingActionButton ? (FloatingActionButton) viewE2 : null;
                                if (floatingActionButton2 != null) {
                                    floatingActionButton2.setTranslationX(bottomAppBar2.getFabTranslationX());
                                }
                            }
                        });
                        floatingActionButton.f(bottomAppBar.c1);
                    }
                    viewE.addOnLayoutChangeListener(this.p);
                    bottomAppBar.K();
                }
            }
            coordinatorLayout.v(i2, bottomAppBar);
            super.n(coordinatorLayout, bottomAppBar, i2);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.v(coordinatorLayout, bottomAppBar, view2, view3, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.p = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    Behavior behavior = Behavior.this;
                    BottomAppBar bottomAppBar = (BottomAppBar) behavior.n.get();
                    if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        int measuredWidth = floatingActionButton.getMeasuredWidth();
                        int measuredHeight = floatingActionButton.getMeasuredHeight();
                        Rect rect = behavior.f39997m;
                        rect.set(0, 0, measuredWidth, measuredHeight);
                        floatingActionButton.k(rect);
                        int iHeight = rect.height();
                        bottomAppBar.L(iHeight);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().f41011e.a(new RectF(rect)));
                        height = iHeight;
                    }
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (behavior.o == 0) {
                        if (bottomAppBar.M0 == 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                        boolean zH = ViewUtils.h(view);
                        int i10 = bottomAppBar.N0;
                        if (zH) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += i10;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += i10;
                        }
                    }
                    int i11 = BottomAppBar.d1;
                    bottomAppBar.K();
                }
            };
            this.f39997m = new Rect();
        }
    }
}
