package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.WeakHashMap;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    public final int f41156a;

    /* renamed from: b, reason: collision with root package name */
    public final int f41157b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41158c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f41159d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f41160e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f41161f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f41162g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f41163h;

    /* renamed from: i, reason: collision with root package name */
    public final SnackbarBaseLayout f41164i;

    /* renamed from: j, reason: collision with root package name */
    public final SnackbarContentLayout f41165j;

    /* renamed from: l, reason: collision with root package name */
    public int f41167l;

    /* renamed from: m, reason: collision with root package name */
    public int f41168m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public final AccessibilityManager r;
    public static final FastOutSlowInInterpolator t = AnimationUtils.f39817b;
    public static final LinearInterpolator u = AnimationUtils.f39816a;
    public static final LinearOutSlowInInterpolator v = AnimationUtils.f39819d;
    public static final int[] x = {R.attr.snackbarStyle};
    public static final String y = "BaseTransientBottomBar";
    public static final Handler w = new Handler(Looper.getMainLooper(), new AnonymousClass1());

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f41166k = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f41164i == null || (context = baseTransientBottomBar.f41163h) == null) {
                return;
            }
            int iHeight = WindowUtils.a(context).height();
            int[] iArr = new int[2];
            SnackbarBaseLayout snackbarBaseLayout = baseTransientBottomBar.f41164i;
            snackbarBaseLayout.getLocationInWindow(iArr);
            int height = (iHeight - (snackbarBaseLayout.getHeight() + iArr[1])) + ((int) baseTransientBottomBar.f41164i.getTranslationY());
            int i2 = baseTransientBottomBar.o;
            if (height >= i2) {
                baseTransientBottomBar.p = i2;
                return;
            }
            ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.f41164i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.y, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            int i3 = baseTransientBottomBar.o;
            baseTransientBottomBar.p = i3;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = (i3 - height) + marginLayoutParams.bottomMargin;
            baseTransientBottomBar.f41164i.requestLayout();
        }
    };
    public final AnonymousClass5 s = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public final void a() {
            Handler handler = BaseTransientBottomBar.w;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public final void b(int i2) {
            Handler handler = BaseTransientBottomBar.w;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    };

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$1, reason: invalid class name */
    public class AnonymousClass1 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
            int i2 = message.what;
            if (i2 == 0) {
                final BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                SnackbarBaseLayout snackbarBaseLayout = baseTransientBottomBar.f41164i;
                if (snackbarBaseLayout.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                        Behavior behavior = new Behavior();
                        BehaviorDelegate behaviorDelegate = behavior.f41184j;
                        behaviorDelegate.getClass();
                        behaviorDelegate.f41185a = baseTransientBottomBar.s;
                        behavior.f39964b = new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                            public final void a(View view) {
                                if (view.getParent() != null) {
                                    view.setVisibility(8);
                                }
                                BaseTransientBottomBar.this.b(0);
                            }

                            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                            public final void b(int i3) {
                                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                                if (i3 == 0) {
                                    SnackbarManager.b().e(baseTransientBottomBar2.s);
                                } else if (i3 == 1 || i3 == 2) {
                                    SnackbarManager.b().d(baseTransientBottomBar2.s);
                                }
                            }
                        };
                        layoutParams2.c(behavior);
                        layoutParams2.f2566g = 80;
                    }
                    snackbarBaseLayout.f41197k = true;
                    baseTransientBottomBar.f41162g.addView(snackbarBaseLayout);
                    snackbarBaseLayout.f41197k = false;
                    baseTransientBottomBar.f();
                    snackbarBaseLayout.setVisibility(4);
                }
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (snackbarBaseLayout.isLaidOut()) {
                    baseTransientBottomBar.e();
                    return true;
                }
                baseTransientBottomBar.q = true;
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            final BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
            int i3 = message.arg1;
            AccessibilityManager accessibilityManager = baseTransientBottomBar2.r;
            if (accessibilityManager == null || ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) != null && enabledAccessibilityServiceList.isEmpty())) {
                SnackbarBaseLayout snackbarBaseLayout2 = baseTransientBottomBar2.f41164i;
                if (snackbarBaseLayout2.getVisibility() == 0) {
                    if (snackbarBaseLayout2.getAnimationMode() == 1) {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                        valueAnimatorOfFloat.setInterpolator(baseTransientBottomBar2.f41159d);
                        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass11());
                        valueAnimatorOfFloat.setDuration(baseTransientBottomBar2.f41157b);
                        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(i3) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                BaseTransientBottomBar.this.c();
                            }
                        });
                        valueAnimatorOfFloat.start();
                        return true;
                    }
                    ValueAnimator valueAnimator = new ValueAnimator();
                    int height = snackbarBaseLayout2.getHeight();
                    ViewGroup.LayoutParams layoutParams3 = snackbarBaseLayout2.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        height += ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                    }
                    valueAnimator.setIntValues(0, height);
                    valueAnimator.setInterpolator(baseTransientBottomBar2.f41160e);
                    valueAnimator.setDuration(baseTransientBottomBar2.f41158c);
                    valueAnimator.addListener(new AnimatorListenerAdapter(i3) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.c();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                            SnackbarContentLayout snackbarContentLayout = baseTransientBottomBar3.f41165j;
                            snackbarContentLayout.f41198a.setAlpha(1.0f);
                            ViewPropertyAnimator viewPropertyAnimatorAlpha = snackbarContentLayout.f41198a.animate().alpha(0.0f);
                            long j2 = baseTransientBottomBar3.f41157b;
                            ViewPropertyAnimator duration = viewPropertyAnimatorAlpha.setDuration(j2);
                            TimeInterpolator timeInterpolator = snackbarContentLayout.f41200c;
                            long j3 = 0;
                            duration.setInterpolator(timeInterpolator).setStartDelay(j3).start();
                            if (snackbarContentLayout.f41199b.getVisibility() == 0) {
                                snackbarContentLayout.f41199b.setAlpha(1.0f);
                                snackbarContentLayout.f41199b.animate().alpha(0.0f).setDuration(j2).setInterpolator(timeInterpolator).setStartDelay(j3).start();
                            }
                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            FastOutSlowInInterpolator fastOutSlowInInterpolator = BaseTransientBottomBar.t;
                            BaseTransientBottomBar.this.f41164i.setTranslationY(iIntValue);
                        }
                    });
                    valueAnimator.start();
                    return true;
                }
            }
            baseTransientBottomBar2.c();
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$11, reason: invalid class name */
    class AnonymousClass11 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass11() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f41164i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            throw null;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            throw null;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            throw null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface DismissEvent {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: j, reason: collision with root package name */
        public final BehaviorDelegate f41184j;

        public Behavior() {
            BehaviorDelegate behaviorDelegate = new BehaviorDelegate();
            this.f39969g = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            this.f39970h = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            this.f39967e = 0;
            this.f41184j = behaviorDelegate;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            BehaviorDelegate behaviorDelegate = this.f41184j;
            behaviorDelegate.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.b().e(behaviorDelegate.f41185a);
                }
            } else if (coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.b().d(behaviorDelegate.f41185a);
            }
            return super.m(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean y(View view) {
            this.f41184j.getClass();
            return view instanceof SnackbarBaseLayout;
        }
    }

    @RestrictTo
    public static class BehaviorDelegate {

        /* renamed from: a, reason: collision with root package name */
        public AnonymousClass5 f41185a;
    }

    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Duration {
    }

    @RestrictTo
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        public static final View.OnTouchListener f41186l = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar f41187a;

        /* renamed from: b, reason: collision with root package name */
        public final ShapeAppearanceModel f41188b;

        /* renamed from: c, reason: collision with root package name */
        public int f41189c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41190d;

        /* renamed from: e, reason: collision with root package name */
        public final float f41191e;

        /* renamed from: f, reason: collision with root package name */
        public final int f41192f;

        /* renamed from: g, reason: collision with root package name */
        public final int f41193g;

        /* renamed from: h, reason: collision with root package name */
        public ColorStateList f41194h;

        /* renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f41195i;

        /* renamed from: j, reason: collision with root package name */
        public Rect f41196j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f41197k;

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1, reason: invalid class name */
        public class AnonymousClass1 implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            GradientDrawable gradientDrawable;
            super(MaterialThemeOverlay.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.E(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.f41189c = typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f41188b = ShapeAppearanceModel.c(context2, attributeSet, 0, 0).a();
            }
            this.f41190d = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.i(typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f41191e = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f41192f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f41193g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f41186l);
            setFocusable(true);
            if (getBackground() == null) {
                int iG = MaterialColors.g(getBackgroundOverlayColorAlpha(), MaterialColors.b(R.attr.colorSurface, this), MaterialColors.b(R.attr.colorOnSurface, this));
                ShapeAppearanceModel shapeAppearanceModel = this.f41188b;
                if (shapeAppearanceModel != null) {
                    FastOutSlowInInterpolator fastOutSlowInInterpolator = BaseTransientBottomBar.t;
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
                    materialShapeDrawable.m(ColorStateList.valueOf(iG));
                    gradientDrawable = materialShapeDrawable;
                } else {
                    Resources resources = getResources();
                    FastOutSlowInInterpolator fastOutSlowInInterpolator2 = BaseTransientBottomBar.t;
                    float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setCornerRadius(dimension);
                    gradientDrawable2.setColor(iG);
                    gradientDrawable = gradientDrawable2;
                }
                ColorStateList colorStateList = this.f41194h;
                if (colorStateList != null) {
                    gradientDrawable.setTintList(colorStateList);
                }
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                setBackground(gradientDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f41187a = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.f41191e;
        }

        public int getAnimationMode() {
            return this.f41189c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f41190d;
        }

        public int getMaxInlineActionWidth() {
            return this.f41193g;
        }

        public int getMaxWidth() {
            return this.f41192f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.f41187a;
            if (baseTransientBottomBar != null && Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = baseTransientBottomBar.f41164i.getRootWindowInsets()) != null) {
                baseTransientBottomBar.o = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                baseTransientBottomBar.f();
            }
            ViewCompat.x(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            final BaseTransientBottomBar baseTransientBottomBar = this.f41187a;
            if (baseTransientBottomBar != null) {
                SnackbarManager snackbarManagerB = SnackbarManager.b();
                AnonymousClass5 anonymousClass5 = baseTransientBottomBar.s;
                synchronized (snackbarManagerB.f41203a) {
                    z = true;
                    if (!snackbarManagerB.c(anonymousClass5)) {
                        SnackbarManager.SnackbarRecord snackbarRecord = snackbarManagerB.f41206d;
                        if (!(snackbarRecord != null && snackbarRecord.f41208a.get() == anonymousClass5)) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    BaseTransientBottomBar.w.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseTransientBottomBar.this.c();
                        }
                    });
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            BaseTransientBottomBar baseTransientBottomBar = this.f41187a;
            if (baseTransientBottomBar == null || !baseTransientBottomBar.q) {
                return;
            }
            baseTransientBottomBar.e();
            baseTransientBottomBar.q = false;
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int i4 = this.f41192f;
            if (i4 <= 0 || getMeasuredWidth() <= i4) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }

        public void setAnimationMode(int i2) {
            this.f41189c = i2;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f41194h != null) {
                drawable = drawable.mutate();
                drawable.setTintList(this.f41194h);
                drawable.setTintMode(this.f41195i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f41194h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintList(colorStateList);
                drawableMutate.setTintMode(this.f41195i);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f41195i = mode;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintMode(mode);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f41197k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f41196j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            BaseTransientBottomBar baseTransientBottomBar = this.f41187a;
            if (baseTransientBottomBar != null) {
                FastOutSlowInInterpolator fastOutSlowInInterpolator = BaseTransientBottomBar.t;
                baseTransientBottomBar.f();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f41186l);
            super.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.material.snackbar.BaseTransientBottomBar$5] */
    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        if (snackbarContentLayout == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (snackbarContentLayout2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f41162g = viewGroup;
        this.f41165j = snackbarContentLayout2;
        this.f41163h = context;
        ThemeEnforcement.c(context, ThemeEnforcement.f40649a, "Theme.AppCompat");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(x);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) layoutInflaterFrom.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
        this.f41164i = snackbarBaseLayout;
        snackbarBaseLayout.setBaseTransientBottomBar(this);
        float actionTextColorAlpha = snackbarBaseLayout.getActionTextColorAlpha();
        if (actionTextColorAlpha != 1.0f) {
            snackbarContentLayout.f41199b.setTextColor(MaterialColors.g(actionTextColorAlpha, MaterialColors.b(R.attr.colorSurface, snackbarContentLayout), snackbarContentLayout.f41199b.getCurrentTextColor()));
        }
        snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
        snackbarBaseLayout.addView(snackbarContentLayout);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        snackbarBaseLayout.setAccessibilityLiveRegion(1);
        snackbarBaseLayout.setImportantForAccessibility(1);
        snackbarBaseLayout.setFitsSystemWindows(true);
        ViewCompat.H(snackbarBaseLayout, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                int iG = windowInsetsCompat.g();
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.f41167l = iG;
                baseTransientBottomBar.f41168m = windowInsetsCompat.h();
                baseTransientBottomBar.n = windowInsetsCompat.i();
                baseTransientBottomBar.f();
                return windowInsetsCompat;
            }
        });
        ViewCompat.z(snackbarBaseLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a(1048576);
                accessibilityNodeInfoCompat.f3185a.setDismissable(true);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 1048576) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                BaseTransientBottomBar.this.a();
                return true;
            }
        });
        this.r = (AccessibilityManager) context.getSystemService("accessibility");
        this.f41158c = MotionUtils.c(context, R.attr.motionDurationLong2, Type.TSIG);
        this.f41156a = MotionUtils.c(context, R.attr.motionDurationLong2, 150);
        this.f41157b = MotionUtils.c(context, R.attr.motionDurationMedium1, 75);
        this.f41159d = MotionUtils.d(context, R.attr.motionEasingEmphasizedInterpolator, u);
        this.f41161f = MotionUtils.d(context, R.attr.motionEasingEmphasizedInterpolator, v);
        this.f41160e = MotionUtils.d(context, R.attr.motionEasingEmphasizedInterpolator, t);
    }

    public void a() {
        b(3);
    }

    public final void b(int i2) {
        SnackbarManager snackbarManagerB = SnackbarManager.b();
        AnonymousClass5 anonymousClass5 = this.s;
        synchronized (snackbarManagerB.f41203a) {
            try {
                if (snackbarManagerB.c(anonymousClass5)) {
                    snackbarManagerB.a(snackbarManagerB.f41205c, i2);
                } else {
                    SnackbarManager.SnackbarRecord snackbarRecord = snackbarManagerB.f41206d;
                    if (snackbarRecord != null && snackbarRecord.f41208a.get() == anonymousClass5) {
                        snackbarManagerB.a(snackbarManagerB.f41206d, i2);
                    }
                }
            } finally {
            }
        }
    }

    public final void c() {
        SnackbarManager snackbarManagerB = SnackbarManager.b();
        AnonymousClass5 anonymousClass5 = this.s;
        synchronized (snackbarManagerB.f41203a) {
            try {
                if (snackbarManagerB.c(anonymousClass5)) {
                    snackbarManagerB.f41205c = null;
                    SnackbarManager.SnackbarRecord snackbarRecord = snackbarManagerB.f41206d;
                    if (snackbarRecord != null && snackbarRecord != null) {
                        snackbarManagerB.f41205c = snackbarRecord;
                        snackbarManagerB.f41206d = null;
                        SnackbarManager.Callback callback = (SnackbarManager.Callback) snackbarRecord.f41208a.get();
                        if (callback != null) {
                            callback.a();
                        } else {
                            snackbarManagerB.f41205c = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ViewParent parent = this.f41164i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f41164i);
        }
    }

    public final void d() {
        SnackbarManager snackbarManagerB = SnackbarManager.b();
        AnonymousClass5 anonymousClass5 = this.s;
        synchronized (snackbarManagerB.f41203a) {
            try {
                if (snackbarManagerB.c(anonymousClass5)) {
                    snackbarManagerB.f(snackbarManagerB.f41205c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z = true;
        AccessibilityManager accessibilityManager = this.r;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z = false;
        }
        SnackbarBaseLayout snackbarBaseLayout = this.f41164i;
        if (z) {
            snackbarBaseLayout.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
                @Override // java.lang.Runnable
                public final void run() {
                    final BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                    SnackbarBaseLayout snackbarBaseLayout2 = baseTransientBottomBar.f41164i;
                    if (snackbarBaseLayout2 == null) {
                        return;
                    }
                    ViewParent parent = snackbarBaseLayout2.getParent();
                    SnackbarBaseLayout snackbarBaseLayout3 = baseTransientBottomBar.f41164i;
                    if (parent != null) {
                        snackbarBaseLayout3.setVisibility(0);
                    }
                    if (snackbarBaseLayout3.getAnimationMode() == 1) {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorOfFloat.setInterpolator(baseTransientBottomBar.f41159d);
                        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass11());
                        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                        valueAnimatorOfFloat2.setInterpolator(baseTransientBottomBar.f41161f);
                        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                                baseTransientBottomBar2.f41164i.setScaleX(fFloatValue);
                                baseTransientBottomBar2.f41164i.setScaleY(fFloatValue);
                            }
                        });
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
                        animatorSet.setDuration(baseTransientBottomBar.f41156a);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                BaseTransientBottomBar.this.d();
                            }
                        });
                        animatorSet.start();
                        return;
                    }
                    int height = snackbarBaseLayout3.getHeight();
                    ViewGroup.LayoutParams layoutParams = snackbarBaseLayout3.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        height += ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    snackbarBaseLayout3.setTranslationY(height);
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(height, 0);
                    valueAnimator.setInterpolator(baseTransientBottomBar.f41160e);
                    valueAnimator.setDuration(baseTransientBottomBar.f41158c);
                    valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.d();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                            BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                            SnackbarContentLayout snackbarContentLayout = baseTransientBottomBar2.f41165j;
                            int i2 = baseTransientBottomBar2.f41158c;
                            int i3 = baseTransientBottomBar2.f41156a;
                            int i4 = i2 - i3;
                            snackbarContentLayout.f41198a.setAlpha(0.0f);
                            long j2 = i3;
                            ViewPropertyAnimator duration = snackbarContentLayout.f41198a.animate().alpha(1.0f).setDuration(j2);
                            TimeInterpolator timeInterpolator = snackbarContentLayout.f41200c;
                            long j3 = i4;
                            duration.setInterpolator(timeInterpolator).setStartDelay(j3).start();
                            if (snackbarContentLayout.f41199b.getVisibility() == 0) {
                                snackbarContentLayout.f41199b.setAlpha(0.0f);
                                snackbarContentLayout.f41199b.animate().alpha(1.0f).setDuration(j2).setInterpolator(timeInterpolator).setStartDelay(j3).start();
                            }
                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(height) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            FastOutSlowInInterpolator fastOutSlowInInterpolator = BaseTransientBottomBar.t;
                            BaseTransientBottomBar.this.f41164i.setTranslationY(iIntValue);
                        }
                    });
                    valueAnimator.start();
                }
            });
            return;
        }
        if (snackbarBaseLayout.getParent() != null) {
            snackbarBaseLayout.setVisibility(0);
        }
        d();
    }

    public final void f() {
        SnackbarBaseLayout snackbarBaseLayout = this.f41164i;
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        boolean z = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = y;
        if (!z) {
            Log.w(str, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (snackbarBaseLayout.f41196j == null) {
            Log.w(str, "Unable to update margins because original view margins are not set");
            return;
        }
        if (snackbarBaseLayout.getParent() == null) {
            return;
        }
        int i2 = this.f41167l;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = snackbarBaseLayout.f41196j;
        int i3 = rect.bottom + i2;
        int i4 = rect.left + this.f41168m;
        int i5 = rect.right + this.n;
        int i6 = rect.top;
        boolean z2 = (marginLayoutParams.bottomMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5 && marginLayoutParams.topMargin == i6) ? false : true;
        if (z2) {
            marginLayoutParams.bottomMargin = i3;
            marginLayoutParams.leftMargin = i4;
            marginLayoutParams.rightMargin = i5;
            marginLayoutParams.topMargin = i6;
            snackbarBaseLayout.requestLayout();
        }
        if ((z2 || this.p != this.o) && Build.VERSION.SDK_INT >= 29 && this.o > 0) {
            ViewGroup.LayoutParams layoutParams2 = snackbarBaseLayout.getLayoutParams();
            if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams2).f2560a instanceof SwipeDismissBehavior)) {
                Runnable runnable = this.f41166k;
                snackbarBaseLayout.removeCallbacks(runnable);
                snackbarBaseLayout.post(runnable);
            }
        }
    }
}
