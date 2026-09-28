package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;
import android.support.v4.media.b;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes4.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {

    /* renamed from: l, reason: collision with root package name */
    public final DrawingDelegate f40828l;

    /* renamed from: m, reason: collision with root package name */
    public IndeterminateAnimatorDelegate f40829m;
    public VectorDrawableCompat n;

    public IndeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate drawingDelegate, IndeterminateAnimatorDelegate indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.f40828l = drawingDelegate;
        this.f40829m = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.f40826a = this;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final void c() {
        super.f(false, false, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2;
        VectorDrawableCompat vectorDrawableCompat;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            boolean z = this.f40811c != null && Settings.Global.getFloat(this.f40809a.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f;
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40810b;
            if (z && (vectorDrawableCompat = this.n) != null) {
                vectorDrawableCompat.setBounds(getBounds());
                this.n.setTint(baseProgressIndicatorSpec.f40779c[0]);
                this.n.draw(canvas);
                return;
            }
            canvas.save();
            DrawingDelegate drawingDelegate = this.f40828l;
            Rect bounds = getBounds();
            float fB = b();
            boolean zE = super.e();
            boolean zD = super.d();
            drawingDelegate.f40821a.a();
            drawingDelegate.a(canvas, bounds, fB, zE, zD);
            int i3 = baseProgressIndicatorSpec.f40783g;
            int i4 = this.f40818j;
            Paint paint = this.f40817i;
            if (i3 == 0) {
                this.f40828l.d(canvas, paint, 0.0f, 1.0f, baseProgressIndicatorSpec.f40780d, i4, 0);
                i2 = i3;
            } else {
                DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) this.f40829m.f40827b.get(0);
                DrawingDelegate.ActiveIndicator activeIndicator2 = (DrawingDelegate.ActiveIndicator) b.c(1, this.f40829m.f40827b);
                DrawingDelegate drawingDelegate2 = this.f40828l;
                if (drawingDelegate2 instanceof LinearDrawingDelegate) {
                    i2 = i3;
                    drawingDelegate2.d(canvas, paint, 0.0f, activeIndicator.f40822a, baseProgressIndicatorSpec.f40780d, i4, i2);
                    this.f40828l.d(canvas, paint, activeIndicator2.f40823b, 1.0f, baseProgressIndicatorSpec.f40780d, i4, i2);
                } else {
                    i2 = i3;
                    i4 = 0;
                    drawingDelegate2.d(canvas, paint, activeIndicator2.f40823b, activeIndicator.f40822a + 1.0f, baseProgressIndicatorSpec.f40780d, 0, i2);
                }
            }
            for (int i5 = 0; i5 < this.f40829m.f40827b.size(); i5++) {
                DrawingDelegate.ActiveIndicator activeIndicator3 = (DrawingDelegate.ActiveIndicator) this.f40829m.f40827b.get(i5);
                this.f40828l.c(canvas, paint, activeIndicator3, this.f40818j);
                if (i5 > 0 && i2 > 0) {
                    this.f40828l.d(canvas, paint, ((DrawingDelegate.ActiveIndicator) this.f40829m.f40827b.get(i5 - 1)).f40823b, activeIndicator3.f40822a, baseProgressIndicatorSpec.f40780d, i4, i2);
                }
            }
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final boolean g(boolean z, boolean z2, boolean z3) {
        VectorDrawableCompat vectorDrawableCompat;
        boolean zG = super.g(z, z2, z3);
        if (this.f40811c != null && Settings.Global.getFloat(this.f40809a.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f && (vectorDrawableCompat = this.n) != null) {
            return vectorDrawableCompat.setVisible(z, z2);
        }
        if (!super.isRunning()) {
            this.f40829m.a();
        }
        if (z && z3) {
            this.f40829m.f();
        }
        return zG;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f40818j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f40828l.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f40828l.f();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return f(z, z2, true);
    }
}
