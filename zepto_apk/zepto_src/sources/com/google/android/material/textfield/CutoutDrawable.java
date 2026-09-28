package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes4.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    public static final /* synthetic */ int z = 0;
    public CutoutDrawableState y;

    public static class ImplApi14 extends CutoutDrawable {
        public Paint A;
        public int B;

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Canvas canvas2;
            Drawable.Callback callback = getCallback();
            if (callback instanceof View) {
                View view = (View) callback;
                if (view.getLayerType() != 2) {
                    view.setLayerType(2, null);
                }
                canvas2 = canvas;
            } else {
                canvas2 = canvas;
                this.B = canvas2.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
            }
            super.draw(canvas2);
            if (getCallback() instanceof View) {
                return;
            }
            canvas2.restoreToCount(this.B);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public final void f(Canvas canvas) {
            super.f(canvas);
            RectF rectF = this.y.s;
            if (this.A == null) {
                Paint paint = new Paint(1);
                this.A = paint;
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.A.setColor(-1);
                this.A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
            canvas.drawRect(rectF, this.A);
        }
    }

    @TargetApi(18)
    public static class ImplApi18 extends CutoutDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public final void f(Canvas canvas) {
            if (this.y.s.isEmpty()) {
                super.f(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.y.s);
            } else {
                canvas.clipRect(this.y.s, Region.Op.DIFFERENCE);
            }
            super.f(canvas);
            canvas.restore();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.y = new CutoutDrawableState(this.y);
        return this;
    }

    public final void y(float f2, float f3, float f4, float f5) {
        RectF rectF = this.y.s;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    public static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {
        public final RectF s;

        public CutoutDrawableState(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
            super(shapeAppearanceModel);
            this.s = rectF;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            int i2 = CutoutDrawable.z;
            ImplApi18 implApi18 = new ImplApi18(this);
            implApi18.y = this;
            implApi18.invalidateSelf();
            return implApi18;
        }

        public CutoutDrawableState(CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.s = cutoutDrawableState.s;
        }
    }
}
