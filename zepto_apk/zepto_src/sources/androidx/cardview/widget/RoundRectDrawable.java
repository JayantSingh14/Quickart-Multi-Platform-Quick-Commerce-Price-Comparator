package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes3.dex */
class RoundRectDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f1376a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1377b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f1378c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f1379d;

    /* renamed from: e, reason: collision with root package name */
    public float f1380e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f1383h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f1384i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f1385j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1381f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1382g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f1386k = PorterDuff.Mode.SRC_IN;

    public RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.f1376a = f2;
        Paint paint = new Paint(5);
        this.f1377b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f1383h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f1383h.getDefaultColor()));
        this.f1378c = new RectF();
        this.f1379d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f1378c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f1379d;
        rect2.set(rect);
        if (this.f1381f) {
            rect2.inset((int) Math.ceil(RoundRectDrawableWithShadow.a(this.f1380e, this.f1376a, this.f1382g)), (int) Math.ceil(RoundRectDrawableWithShadow.b(this.f1380e, this.f1376a, this.f1382g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1377b;
        if (this.f1384i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1384i);
            z = true;
        }
        RectF rectF = this.f1378c;
        float f2 = this.f1376a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f1379d, this.f1376a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f1385j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f1383h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1383h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f1377b;
        boolean z = colorForState != paint.getColor();
        if (z) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1385j;
        if (colorStateList2 == null || (mode = this.f1386k) == null) {
            return z;
        }
        this.f1384i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f1377b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1377b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f1385j = colorStateList;
        this.f1384i = a(colorStateList, this.f1386k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f1386k = mode;
        this.f1384i = a(this.f1385j, mode);
        invalidateSelf();
    }
}
