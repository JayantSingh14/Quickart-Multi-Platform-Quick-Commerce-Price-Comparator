package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    public static final int q = R.style.Widget_Design_FloatingActionButton;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f40468b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f40469c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f40470d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f40471e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f40472f;

    /* renamed from: g, reason: collision with root package name */
    public int f40473g;

    /* renamed from: h, reason: collision with root package name */
    public int f40474h;

    /* renamed from: i, reason: collision with root package name */
    public int f40475i;

    /* renamed from: j, reason: collision with root package name */
    public int f40476j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40477k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f40478l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f40479m;
    public final AppCompatImageHelper n;
    public final ExpandableWidgetHelper o;
    public FloatingActionButtonImplLollipop p;

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$1, reason: invalid class name */
    class AnonymousClass1 implements FloatingActionButtonImpl.InternalVisibilityChangedListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnVisibilityChangedListener f40480a;

        public AnonymousClass1(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.f40480a = onVisibilityChangedListener;
        }

        public final void a() {
            this.f40480a.a(FloatingActionButton.this);
        }

        public final void b() {
            this.f40480a.b();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }

        public final void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Size {
    }

    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final TransformationCallback f40485a;

        public TransformationCallbackWrapper(TransformationCallback transformationCallback) {
            this.f40485a = transformationCallback;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void a() {
            this.f40485a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void b() {
            this.f40485a.a(FloatingActionButton.this);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).f40485a.equals(this.f40485a);
        }

        public final int hashCode() {
            return this.f40485a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.p == null) {
            this.p = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return this.p;
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public final boolean a() {
        return this.o.f40427b;
    }

    public final void d(AnimatorListenerAdapter animatorListenerAdapter) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.u == null) {
            impl.u = new ArrayList();
        }
        impl.u.add(animatorListenerAdapter);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().k(getDrawableState());
    }

    public final void e(Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.t == null) {
            impl.t = new ArrayList();
        }
        impl.t.add(animatorListener);
    }

    public final void f(TransformationCallback transformationCallback) {
        FloatingActionButtonImpl impl = getImpl();
        TransformationCallbackWrapper transformationCallbackWrapper = new TransformationCallbackWrapper(transformationCallback);
        if (impl.v == null) {
            impl.v = new ArrayList();
        }
        impl.v.add(transformationCallbackWrapper);
    }

    public final int g(int i2) {
        int i3 = this.f40474h;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        return i2 != -1 ? i2 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? g(1) : g(0);
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f40468b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f40469c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().f();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f40495i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f40496j;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().f40491e;
    }

    @Px
    public int getCustomSize() {
        return this.f40474h;
    }

    public int getExpandedComponentIdHint() {
        return this.o.f40428c;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return getImpl().o;
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f40472f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f40472f;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().f40487a;
        shapeAppearanceModel.getClass();
        return shapeAppearanceModel;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return getImpl().n;
    }

    public int getSize() {
        return this.f40473g;
    }

    public int getSizeDimension() {
        return g(this.f40473g);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f40470d;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f40471e;
    }

    public boolean getUseCompatPadding() {
        return this.f40477k;
    }

    public final void h(OnVisibilityChangedListener onVisibilityChangedListener, final boolean z) {
        final FloatingActionButtonImpl impl = getImpl();
        final AnonymousClass1 anonymousClass1 = onVisibilityChangedListener == null ? null : new AnonymousClass1(onVisibilityChangedListener);
        if (impl.w.getVisibility() == 0) {
            if (impl.s == 1) {
                return;
            }
        } else if (impl.s != 2) {
            return;
        }
        Animator animator = impl.f40499m;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        FloatingActionButton floatingActionButton = impl.w;
        if (!floatingActionButton.isLaidOut() || floatingActionButton.isInEditMode()) {
            floatingActionButton.b(z ? 8 : 4, z);
            if (anonymousClass1 != null) {
                anonymousClass1.a();
                return;
            }
            return;
        }
        MotionSpec motionSpec = impl.o;
        AnimatorSet animatorSetB = motionSpec != null ? impl.b(motionSpec, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, FloatingActionButtonImpl.G, FloatingActionButtonImpl.H);
        animatorSetB.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1

            /* renamed from: a, reason: collision with root package name */
            public boolean f40500a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator2) {
                this.f40500a = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.s = 0;
                floatingActionButtonImpl.f40499m = null;
                if (this.f40500a) {
                    return;
                }
                boolean z2 = z;
                floatingActionButtonImpl.w.b(z2 ? 8 : 4, z2);
                FloatingActionButton.AnonymousClass1 anonymousClass12 = anonymousClass1;
                if (anonymousClass12 != null) {
                    anonymousClass12.a();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.w.b(0, z);
                floatingActionButtonImpl.s = 1;
                floatingActionButtonImpl.f40499m = animator2;
                this.f40500a = false;
            }
        });
        ArrayList arrayList = impl.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetB.start();
    }

    public final boolean i() {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.w.getVisibility() == 0) {
            if (impl.s != 1) {
                return false;
            }
        } else if (impl.s == 2) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.w.getVisibility() != 0) {
            if (impl.s != 2) {
                return false;
            }
        } else if (impl.s == 1) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().i();
    }

    public final void k(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.f40478l;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f40470d;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f40471e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.c(colorForState, mode));
    }

    public final void m(OnVisibilityChangedListener onVisibilityChangedListener, final boolean z) {
        final FloatingActionButtonImpl impl = getImpl();
        final AnonymousClass1 anonymousClass1 = onVisibilityChangedListener == null ? null : new AnonymousClass1(onVisibilityChangedListener);
        if (impl.w.getVisibility() != 0) {
            if (impl.s == 2) {
                return;
            }
        } else if (impl.s != 1) {
            return;
        }
        Animator animator = impl.f40499m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = impl.n == null;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        FloatingActionButton floatingActionButton = impl.w;
        boolean z3 = floatingActionButton.isLaidOut() && !floatingActionButton.isInEditMode();
        Matrix matrix = impl.B;
        if (!z3) {
            floatingActionButton.b(0, z);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.q = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (anonymousClass1 != null) {
                anonymousClass1.b();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z2 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z2 ? 0.4f : 0.0f);
            float f2 = z2 ? 0.4f : 0.0f;
            impl.q = f2;
            impl.a(f2, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        MotionSpec motionSpec = impl.n;
        AnimatorSet animatorSetB = motionSpec != null ? impl.b(motionSpec, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, FloatingActionButtonImpl.E, FloatingActionButtonImpl.F);
        animatorSetB.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.s = 0;
                floatingActionButtonImpl.f40499m = null;
                FloatingActionButton.AnonymousClass1 anonymousClass12 = anonymousClass1;
                if (anonymousClass12 != null) {
                    anonymousClass12.b();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.w.b(0, z);
                floatingActionButtonImpl.s = 2;
                floatingActionButtonImpl.f40499m = animator2;
            }
        });
        ArrayList arrayList = impl.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        final FloatingActionButtonImpl impl = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl.f40488b;
        FloatingActionButton floatingActionButton = impl.w;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.c(floatingActionButton, materialShapeDrawable);
        }
        if (impl instanceof FloatingActionButtonImplLollipop) {
            return;
        }
        ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
        if (impl.C == null) {
            impl.C = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                    float rotation = floatingActionButtonImpl.w.getRotation();
                    if (floatingActionButtonImpl.p == rotation) {
                        return true;
                    }
                    floatingActionButtonImpl.p = rotation;
                    floatingActionButtonImpl.q();
                    return true;
                }
            };
        }
        viewTreeObserver.addOnPreDrawListener(impl.C);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.C = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f40475i = (sizeDimension - this.f40476j) / 2;
        getImpl().r();
        int iMin = Math.min(View.resolveSize(sizeDimension, i2), View.resolveSize(sizeDimension, i3));
        Rect rect = this.f40478l;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.f3321a);
        Bundle bundle = (Bundle) extendableSavedState.f41211c.get("expandableWidgetHelper");
        bundle.getClass();
        ExpandableWidgetHelper expandableWidgetHelper = this.o;
        expandableWidgetHelper.getClass();
        expandableWidgetHelper.f40427b = bundle.getBoolean("expanded", false);
        expandableWidgetHelper.f40428c = bundle.getInt("expandedComponentIdHint", 0);
        if (expandableWidgetHelper.f40427b) {
            View view = expandableWidgetHelper.f40426a;
            ViewParent parent = view.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).g(view);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        SimpleArrayMap simpleArrayMap = extendableSavedState.f41211c;
        ExpandableWidgetHelper expandableWidgetHelper = this.o;
        expandableWidgetHelper.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", expandableWidgetHelper.f40427b);
        bundle.putInt("expandedComponentIdHint", expandableWidgetHelper.f40428c);
        simpleArrayMap.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.f40479m;
            rect.set(0, 0, measuredWidth, measuredHeight);
            k(rect);
            FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = this.p;
            int i2 = -(floatingActionButtonImplLollipop.f40492f ? Math.max((floatingActionButtonImplLollipop.f40497k - floatingActionButtonImplLollipop.w.getSizeDimension()) / 2, 0) : 0);
            rect.inset(i2, i2);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f40468b != colorStateList) {
            this.f40468b = colorStateList;
            FloatingActionButtonImpl impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.f40488b;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            BorderDrawable borderDrawable = impl.f40490d;
            if (borderDrawable != null) {
                if (colorStateList != null) {
                    borderDrawable.f40449m = colorStateList.getColorForState(borderDrawable.getState(), borderDrawable.f40449m);
                }
                borderDrawable.p = colorStateList;
                borderDrawable.n = true;
                borderDrawable.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f40469c != mode) {
            this.f40469c = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().f40488b;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f2) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.f40494h != f2) {
            impl.f40494h = f2;
            impl.l(f2, impl.f40495i, impl.f40496j);
        }
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.f40495i != f2) {
            impl.f40495i = f2;
            impl.l(impl.f40494h, f2, impl.f40496j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.f40496j != f2) {
            impl.f40496j = f2;
            impl.l(impl.f40494h, impl.f40495i, f2);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i2 != this.f40474h) {
            this.f40474h = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeDrawable materialShapeDrawable = getImpl().f40488b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.l(f2);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f40492f) {
            getImpl().f40492f = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.o.f40428c = i2;
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().o = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(MotionSpec.b(i2, getContext()));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            FloatingActionButtonImpl impl = getImpl();
            float f2 = impl.q;
            impl.q = f2;
            Matrix matrix = impl.B;
            impl.a(f2, matrix);
            impl.w.setImageMatrix(matrix);
            if (this.f40470d != null) {
                l();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.n.c(i2);
        l();
    }

    public void setMaxImageSize(int i2) {
        this.f40476j = i2;
        FloatingActionButtonImpl impl = getImpl();
        if (impl.r != i2) {
            impl.r = i2;
            float f2 = impl.q;
            impl.q = f2;
            Matrix matrix = impl.B;
            impl.a(f2, matrix);
            impl.w.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        ArrayList arrayList = getImpl().v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((FloatingActionButtonImpl.InternalTransformationCallback) it.next()).b();
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        ArrayList arrayList = getImpl().v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((FloatingActionButtonImpl.InternalTransformationCallback) it.next()).b();
            }
        }
    }

    @RestrictTo
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        FloatingActionButtonImpl impl = getImpl();
        impl.f40493g = z;
        impl.r();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().o(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().n = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(MotionSpec.b(i2, getContext()));
    }

    public void setSize(int i2) {
        this.f40474h = 0;
        if (i2 != this.f40473g) {
            this.f40473g = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f40470d != colorStateList) {
            this.f40470d = colorStateList;
            l();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f40471e != mode) {
            this.f40471e = mode;
            l();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().m();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().m();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().m();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f40477k != z) {
            this.f40477k = z;
            getImpl().j();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f40482a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f40483b;

        public BaseBehavior() {
            this.f40483b = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean g(Rect rect, View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.f40478l;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void i(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f2567h == 0) {
                layoutParams.f2567h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                y(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).f2560a instanceof BottomSheetBehavior : false) {
                    z(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List listL = coordinatorLayout.l(floatingActionButton);
            int size = listL.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) listL.get(i4);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.LayoutParams ? ((CoordinatorLayout.LayoutParams) layoutParams).f2560a instanceof BottomSheetBehavior : false) && z(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (y(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i2, floatingActionButton);
            Rect rect = floatingActionButton.f40478l;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                int i5 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    floatingActionButton.offsetTopAndBottom(i3);
                }
                if (i5 != 0) {
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    floatingActionButton.offsetLeftAndRight(i5);
                }
            }
            return true;
        }

        public final boolean y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!(this.f40483b && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).f2565f == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (this.f40482a == null) {
                this.f40482a = new Rect();
            }
            Rect rect = this.f40482a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.h(null, false);
            } else {
                floatingActionButton.m(null, false);
            }
            return true;
        }

        public final boolean z(View view, FloatingActionButton floatingActionButton) {
            if (!(this.f40483b && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).f2565f == view.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.h(null, false);
            } else {
                floatingActionButton.m(null, false);
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f40483b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = q;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40478l = new Rect();
        this.f40479m = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.FloatingActionButton, i2, i3, new int[0]);
        this.f40468b = MaterialResources.a(context2, typedArrayD, R.styleable.FloatingActionButton_backgroundTint);
        this.f40469c = ViewUtils.i(typedArrayD.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f40472f = MaterialResources.a(context2, typedArrayD, R.styleable.FloatingActionButton_rippleColor);
        this.f40473g = typedArrayD.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f40474h = typedArrayD.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayD.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayD.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayD.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f40477k = typedArrayD.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayD.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0));
        MotionSpec motionSpecA = MotionSpec.a(context2, typedArrayD, R.styleable.FloatingActionButton_showMotionSpec);
        MotionSpec motionSpecA2 = MotionSpec.a(context2, typedArrayD, R.styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel shapeAppearanceModelA = ShapeAppearanceModel.d(context2, attributeSet, i2, i3, ShapeAppearanceModel.f41006m).a();
        boolean z = typedArrayD.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayD.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        typedArrayD.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.n = appCompatImageHelper;
        appCompatImageHelper.b(attributeSet, i2);
        this.o = new ExpandableWidgetHelper(this);
        getImpl().o(shapeAppearanceModelA);
        getImpl().h(this.f40468b, this.f40469c, this.f40472f, dimensionPixelSize);
        getImpl().f40497k = dimensionPixelSize2;
        FloatingActionButtonImpl impl = getImpl();
        if (impl.f40494h != dimension) {
            impl.f40494h = dimension;
            impl.l(dimension, impl.f40495i, impl.f40496j);
        }
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.f40495i != dimension2) {
            impl2.f40495i = dimension2;
            impl2.l(impl2.f40494h, dimension2, impl2.f40496j);
        }
        FloatingActionButtonImpl impl3 = getImpl();
        if (impl3.f40496j != dimension3) {
            impl3.f40496j = dimension3;
            impl3.l(impl3.f40494h, impl3.f40495i, dimension3);
        }
        getImpl().n = motionSpecA;
        getImpl().o = motionSpecA2;
        getImpl().f40492f = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f40472f != colorStateList) {
            this.f40472f = colorStateList;
            getImpl().n(this.f40472f);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b() {
        }
    }
}
