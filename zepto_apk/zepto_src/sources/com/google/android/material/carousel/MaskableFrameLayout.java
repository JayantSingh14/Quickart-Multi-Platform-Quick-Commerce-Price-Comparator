package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.media3.exoplayer.analytics.p;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

/* loaded from: classes4.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f40188g = 0;

    /* renamed from: a, reason: collision with root package name */
    public float f40189a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f40190b;

    /* renamed from: c, reason: collision with root package name */
    public OnMaskChangedListener f40191c;

    /* renamed from: d, reason: collision with root package name */
    public ShapeAppearanceModel f40192d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableDelegate f40193e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f40194f;

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        if (this.f40189a != -1.0f) {
            float fB = AnimationUtils.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f40189a);
            setMaskRectF(new RectF(fB, 0.0f, getWidth() - fB, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        ShapeableDelegate shapeableDelegate = this.f40193e;
        if (shapeableDelegate.c()) {
            Path path = shapeableDelegate.f41083e;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        RectF rectF = this.f40190b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    @NonNull
    public RectF getMaskRectF() {
        return this.f40190b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f40189a;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f40192d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f40194f;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            ShapeableDelegate shapeableDelegate = this.f40193e;
            if (zBooleanValue != shapeableDelegate.f41079a) {
                shapeableDelegate.f41079a = zBooleanValue;
                shapeableDelegate.b(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ShapeableDelegate shapeableDelegate = this.f40193e;
        this.f40194f = Boolean.valueOf(shapeableDelegate.f41079a);
        if (true != shapeableDelegate.f41079a) {
            shapeableDelegate.f41079a = true;
            shapeableDelegate.b(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f40189a != -1.0f) {
            a();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        RectF rectF = this.f40190b;
        if (rectF.isEmpty() || motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @RestrictTo
    @VisibleForTesting
    public void setForceCompatClipping(boolean z) {
        ShapeableDelegate shapeableDelegate = this.f40193e;
        if (z != shapeableDelegate.f41079a) {
            shapeableDelegate.f41079a = z;
            shapeableDelegate.b(this);
        }
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskRectF(@NonNull RectF rectF) {
        RectF rectF2 = this.f40190b;
        rectF2.set(rectF);
        ShapeableDelegate shapeableDelegate = this.f40193e;
        shapeableDelegate.f41082d = rectF2;
        shapeableDelegate.d();
        shapeableDelegate.b(this);
        OnMaskChangedListener onMaskChangedListener = this.f40191c;
        if (onMaskChangedListener != null) {
            onMaskChangedListener.a();
        }
    }

    @Deprecated
    public void setMaskXPercentage(float f2) {
        float fA = MathUtils.a(f2, 0.0f, 1.0f);
        if (this.f40189a != fA) {
            this.f40189a = fA;
            a();
        }
    }

    public void setOnMaskChangedListener(@Nullable OnMaskChangedListener onMaskChangedListener) {
        this.f40191c = onMaskChangedListener;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearanceModelH = shapeAppearanceModel.h(new p(27));
        this.f40192d = shapeAppearanceModelH;
        ShapeableDelegate shapeableDelegate = this.f40193e;
        shapeableDelegate.f41081c = shapeAppearanceModelH;
        shapeableDelegate.d();
        shapeableDelegate.b(this);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f40189a = -1.0f;
        this.f40190b = new RectF();
        this.f40193e = ShapeableDelegate.a(this);
        this.f40194f = null;
        setShapeAppearanceModel(ShapeAppearanceModel.c(context, attributeSet, i2, 0).a());
    }
}
