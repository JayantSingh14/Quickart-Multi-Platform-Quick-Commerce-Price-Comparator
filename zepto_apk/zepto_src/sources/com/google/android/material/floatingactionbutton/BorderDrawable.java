package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

@RestrictTo
/* loaded from: classes4.dex */
class BorderDrawable extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f40438b;

    /* renamed from: h, reason: collision with root package name */
    public float f40444h;

    /* renamed from: i, reason: collision with root package name */
    public int f40445i;

    /* renamed from: j, reason: collision with root package name */
    public int f40446j;

    /* renamed from: k, reason: collision with root package name */
    public int f40447k;

    /* renamed from: l, reason: collision with root package name */
    public int f40448l;

    /* renamed from: m, reason: collision with root package name */
    public int f40449m;
    public ShapeAppearanceModel o;
    public ColorStateList p;

    /* renamed from: a, reason: collision with root package name */
    public final ShapeAppearancePathProvider f40437a = ShapeAppearancePathProvider.b();

    /* renamed from: c, reason: collision with root package name */
    public final Path f40439c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f40440d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final RectF f40441e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f40442f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final BorderState f40443g = new BorderState();
    public boolean n = true;

    public class BorderState extends Drawable.ConstantState {
        public BorderState() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return BorderDrawable.this;
        }
    }

    public BorderDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this.o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f40438b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z = this.n;
        Paint paint = this.f40438b;
        Rect rect = this.f40440d;
        if (z) {
            copyBounds(rect);
            float fHeight = this.f40444h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.h(this.f40445i, this.f40449m), ColorUtils.h(this.f40446j, this.f40449m), ColorUtils.h(ColorUtils.k(this.f40446j, 0), this.f40449m), ColorUtils.h(ColorUtils.k(this.f40448l, 0), this.f40449m), ColorUtils.h(this.f40448l, this.f40449m), ColorUtils.h(this.f40447k, this.f40449m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f40441e;
        rectF.set(rect);
        CornerSize cornerSize = this.o.f41011e;
        RectF rectF2 = this.f40442f;
        rectF2.set(getBounds());
        float fMin = Math.min(cornerSize.a(rectF2), rectF.width() / 2.0f);
        ShapeAppearanceModel shapeAppearanceModel = this.o;
        rectF2.set(getBounds());
        if (shapeAppearanceModel.f(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f40443g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f40444h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ShapeAppearanceModel shapeAppearanceModel = this.o;
        RectF rectF = this.f40442f;
        rectF.set(getBounds());
        if (shapeAppearanceModel.f(rectF)) {
            CornerSize cornerSize = this.o.f41011e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), cornerSize.a(rectF));
            return;
        }
        Rect rect = this.f40440d;
        copyBounds(rect);
        RectF rectF2 = this.f40441e;
        rectF2.set(rect);
        ShapeAppearanceModel shapeAppearanceModel2 = this.o;
        Path path = this.f40439c;
        this.f40437a.a(shapeAppearanceModel2, 1.0f, rectF2, null, path);
        DrawableUtils.e(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        ShapeAppearanceModel shapeAppearanceModel = this.o;
        RectF rectF = this.f40442f;
        rectF.set(getBounds());
        if (!shapeAppearanceModel.f(rectF)) {
            return true;
        }
        int iRound = Math.round(this.f40444h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f40449m)) != this.f40449m) {
            this.n = true;
            this.f40449m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f40438b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f40438b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
