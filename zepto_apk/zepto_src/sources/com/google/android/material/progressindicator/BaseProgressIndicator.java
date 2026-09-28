package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {

    /* renamed from: l, reason: collision with root package name */
    public static final int f40761l = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a, reason: collision with root package name */
    public final BaseProgressIndicatorSpec f40762a;

    /* renamed from: b, reason: collision with root package name */
    public int f40763b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f40764c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40765d;

    /* renamed from: e, reason: collision with root package name */
    public AnimatorDurationScaleProvider f40766e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40767f;

    /* renamed from: g, reason: collision with root package name */
    public int f40768g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f40769h;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f40770i;

    /* renamed from: j, reason: collision with root package name */
    public final Animatable2Compat.AnimationCallback f40771j;

    /* renamed from: k, reason: collision with root package name */
    public final Animatable2Compat.AnimationCallback f40772k;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ShowAnimationBehavior {
    }

    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(MaterialThemeOverlay.a(context, attributeSet, i2, f40761l), attributeSet, i2);
        this.f40767f = false;
        this.f40768g = 4;
        this.f40769h = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public final void run() {
                int i4 = BaseProgressIndicator.f40761l;
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                if (baseProgressIndicator.f40765d > 0) {
                    SystemClock.uptimeMillis();
                }
                baseProgressIndicator.setVisibility(0);
            }
        };
        this.f40770i = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public final void run() {
                int i4 = BaseProgressIndicator.f40761l;
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                ((DrawableWithAnimatedVisibilityChange) baseProgressIndicator.getCurrentDrawable()).f(false, false, true);
                if ((baseProgressIndicator.getProgressDrawable() == null || !baseProgressIndicator.getProgressDrawable().isVisible()) && (baseProgressIndicator.getIndeterminateDrawable() == null || !baseProgressIndicator.getIndeterminateDrawable().isVisible())) {
                    baseProgressIndicator.setVisibility(4);
                }
                baseProgressIndicator.getClass();
            }
        };
        this.f40771j = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.3
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public final void a(Drawable drawable) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setIndeterminate(false);
                baseProgressIndicator.b(baseProgressIndicator.f40763b);
            }
        };
        this.f40772k = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.4
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public final void a(Drawable drawable) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                if (baseProgressIndicator.f40767f) {
                    return;
                }
                baseProgressIndicator.setVisibility(baseProgressIndicator.f40768g);
            }
        };
        Context context2 = getContext();
        this.f40762a = a(context2, attributeSet);
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        typedArrayD.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f40765d = Math.min(typedArrayD.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayD.recycle();
        this.f40766e = new AnimatorDurationScaleProvider();
        this.f40764c = true;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f40828l;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().f40806l;
    }

    public abstract BaseProgressIndicatorSpec a(Context context, AttributeSet attributeSet);

    public void b(int i2) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.f40763b = i2;
            this.f40767f = true;
            if (getIndeterminateDrawable().isVisible()) {
                AnimatorDurationScaleProvider animatorDurationScaleProvider = this.f40766e;
                ContentResolver contentResolver = getContext().getContentResolver();
                animatorDurationScaleProvider.getClass();
                if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                    getIndeterminateDrawable().f40829m.e();
                    return;
                }
            }
            this.f40771j.a(getIndeterminateDrawable());
        }
    }

    public final boolean c() {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f40762a.f40782f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f40762a.f40779c;
    }

    @Px
    public int getIndicatorTrackGapSize() {
        return this.f40762a.f40783g;
    }

    public int getShowAnimationBehavior() {
        return this.f40762a.f40781e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f40762a.f40780d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f40762a.f40778b;
    }

    @Px
    public int getTrackThickness() {
        return this.f40762a.f40777a;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f40829m.d(this.f40771j);
        }
        DeterminateDrawable<S> progressDrawable = getProgressDrawable();
        Animatable2Compat.AnimationCallback animationCallback = this.f40772k;
        if (progressDrawable != null) {
            DeterminateDrawable<S> progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.f40814f == null) {
                progressDrawable2.f40814f = new ArrayList();
            }
            if (!progressDrawable2.f40814f.contains(animationCallback)) {
                progressDrawable2.f40814f.add(animationCallback);
            }
        }
        if (getIndeterminateDrawable() != null) {
            IndeterminateDrawable<S> indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f40814f == null) {
                indeterminateDrawable.f40814f = new ArrayList();
            }
            if (!indeterminateDrawable.f40814f.contains(animationCallback)) {
                indeterminateDrawable.f40814f.add(animationCallback);
            }
        }
        if (c()) {
            if (this.f40765d > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f40770i);
        removeCallbacks(this.f40769h);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).c();
        IndeterminateDrawable<S> indeterminateDrawable = getIndeterminateDrawable();
        Animatable2Compat.AnimationCallback animationCallback = this.f40772k;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().h(animationCallback);
            getIndeterminateDrawable().f40829m.g();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().h(animationCallback);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i2, int i3) {
        try {
            DrawingDelegate<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i2) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i3) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        boolean z = i2 == 0;
        if (this.f40764c) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).f(c(), false, z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f40764c) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).f(c(), false, false);
        }
    }

    @RestrictTo
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.f40766e = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f40811c = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f40811c = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.f40762a.f40782f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.c();
            }
            super.setIndeterminate(z);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.f(c(), false, false);
            }
            if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && c()) {
                ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).f40829m.f();
            }
            this.f40767f = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof IndeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((DrawableWithAnimatedVisibilityChange) drawable).c();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.c(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f40762a.f40779c = iArr;
        getIndeterminateDrawable().f40829m.c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(@Px int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (baseProgressIndicatorSpec.f40783g != i2) {
            baseProgressIndicatorSpec.f40783g = i2;
            baseProgressIndicatorSpec.a();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (isIndeterminate()) {
            return;
        }
        b(i2);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof DeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.f(false, false, false);
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.f40762a.f40781e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (baseProgressIndicatorSpec.f40780d != i2) {
            baseProgressIndicatorSpec.f40780d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (baseProgressIndicatorSpec.f40778b != i2) {
            baseProgressIndicatorSpec.f40778b = Math.min(i2, baseProgressIndicatorSpec.f40777a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(@Px int i2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40762a;
        if (baseProgressIndicatorSpec.f40777a != i2) {
            baseProgressIndicatorSpec.f40777a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 != 0 && i2 != 4 && i2 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f40768g = i2;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
