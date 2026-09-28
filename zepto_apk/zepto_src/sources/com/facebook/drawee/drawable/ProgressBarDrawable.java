package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ProgressBarDrawable extends Drawable implements CloneableDrawable {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f17330a = new Paint(1);

    /* renamed from: b, reason: collision with root package name */
    public final Path f17331b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final RectF f17332c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    public final int f17333d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public final int f17334e = -2147450625;

    /* renamed from: f, reason: collision with root package name */
    public final int f17335f = 10;

    /* renamed from: g, reason: collision with root package name */
    public final int f17336g = 20;

    /* renamed from: h, reason: collision with root package name */
    public int f17337h;

    public final void a(Canvas canvas, int i2, int i3) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width();
        int i4 = this.f17335f;
        int i5 = ((iWidth - (i4 * 2)) * i2) / 10000;
        int i6 = bounds.left + i4;
        int i7 = (bounds.bottom - i4) - this.f17336g;
        RectF rectF = this.f17332c;
        rectF.set(i6, i7, i6 + i5, i7 + r2);
        Paint paint = this.f17330a;
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Path path = this.f17331b;
        path.reset();
        path.setFillType(Path.FillType.EVEN_ODD);
        double d2 = 0;
        double d3 = this.f17336g / 2;
        path.addRoundRect(rectF, (float) Math.min(d2, d3), (float) Math.min(d2, d3), Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        a(canvas, 10000, this.f17333d);
        a(canvas, this.f17337h, this.f17334e);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int color = this.f17330a.getColor() >>> 24;
        if (color != 0) {
            return color != 255 ? -3 : -1;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        int i2 = this.f17335f;
        padding.set(i2, i2, i2, i2);
        return i2 != 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        this.f17337h = i2;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f17330a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f17330a.setColorFilter(colorFilter);
    }
}
