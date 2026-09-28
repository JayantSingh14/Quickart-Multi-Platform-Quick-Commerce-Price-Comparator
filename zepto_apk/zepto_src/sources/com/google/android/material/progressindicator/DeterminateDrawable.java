package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes4.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    public static final FloatPropertyCompat q = new AnonymousClass1();

    /* renamed from: l, reason: collision with root package name */
    public final DrawingDelegate f40806l;

    /* renamed from: m, reason: collision with root package name */
    public final SpringForce f40807m;
    public final SpringAnimation n;
    public final DrawingDelegate.ActiveIndicator o;
    public boolean p;

    /* renamed from: com.google.android.material.progressindicator.DeterminateDrawable$1, reason: invalid class name */
    public class AnonymousClass1 extends FloatPropertyCompat<DeterminateDrawable<?>> {
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.o.f40823b * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            FloatPropertyCompat floatPropertyCompat = DeterminateDrawable.q;
            determinateDrawable.o.f40823b = f2 / 10000.0f;
            determinateDrawable.invalidateSelf();
        }
    }

    public DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.p = false;
        this.f40806l = drawingDelegate;
        this.o = new DrawingDelegate.ActiveIndicator();
        SpringForce springForce = new SpringForce();
        this.f40807m = springForce;
        springForce.f4281b = 1.0f;
        springForce.f4282c = false;
        springForce.a(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this);
        springAnimation.t = Float.MAX_VALUE;
        springAnimation.u = false;
        this.n = springAnimation;
        springAnimation.s = springForce;
        if (this.f40816h != 1.0f) {
            this.f40816h = 1.0f;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final void c() {
        super.f(false, false, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            DrawingDelegate drawingDelegate = this.f40806l;
            Rect bounds = getBounds();
            float fB = b();
            boolean zE = super.e();
            boolean zD = super.d();
            drawingDelegate.f40821a.a();
            drawingDelegate.a(canvas, bounds, fB, zE, zD);
            Paint paint = this.f40817i;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40810b;
            int i2 = baseProgressIndicatorSpec.f40779c[0];
            DrawingDelegate.ActiveIndicator activeIndicator = this.o;
            activeIndicator.f40824c = i2;
            int iA = baseProgressIndicatorSpec.f40783g;
            if (iA > 0) {
                if (!(this.f40806l instanceof LinearDrawingDelegate)) {
                    iA = (int) ((MathUtils.a(activeIndicator.f40823b, 0.0f, 0.01f) * iA) / 0.01f);
                }
                this.f40806l.d(canvas, paint, activeIndicator.f40823b, 1.0f, baseProgressIndicatorSpec.f40780d, this.f40818j, iA);
            } else {
                this.f40806l.d(canvas, paint, 0.0f, 1.0f, baseProgressIndicatorSpec.f40780d, this.f40818j, 0);
            }
            this.f40806l.c(canvas, paint, activeIndicator, this.f40818j);
            this.f40806l.b(canvas, paint, baseProgressIndicatorSpec.f40779c[0], this.f40818j);
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final boolean g(boolean z, boolean z2, boolean z3) {
        boolean zG = super.g(z, z2, z3);
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.f40811c;
        ContentResolver contentResolver = this.f40809a.getContentResolver();
        animatorDurationScaleProvider.getClass();
        float f2 = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f2 == 0.0f) {
            this.p = true;
            return zG;
        }
        this.p = false;
        this.f40807m.a(50.0f / f2);
        return zG;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f40818j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f40806l.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f40806l.f();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.n.e();
        this.o.f40823b = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        boolean z = this.p;
        DrawingDelegate.ActiveIndicator activeIndicator = this.o;
        SpringAnimation springAnimation = this.n;
        if (z) {
            springAnimation.e();
            activeIndicator.f40823b = i2 / 10000.0f;
            invalidateSelf();
        } else {
            springAnimation.f4265b = activeIndicator.f40823b * 10000.0f;
            springAnimation.f4266c = true;
            springAnimation.d(i2);
        }
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return f(z, z2, true);
    }
}
