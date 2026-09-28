package com.chuckerteam.chucker.internal.support;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ChessboardDrawable extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f16748b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f16749a;

    @Metadata
    public static final class Companion {
    }

    public ChessboardDrawable(int i2, int i3, int i4) {
        Paint paint = new Paint();
        int i5 = i4 * 2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        bitmapCreateBitmap.eraseColor(i2);
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(i4, 0, i5, i4);
        canvas.drawRect(rect, paint);
        rect.offsetTo(0, i4);
        canvas.drawRect(rect, paint);
        paint.reset();
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        this.f16749a = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawPaint(this.f16749a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f16749a.getColorFilter() == null ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f16749a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f16749a.setColorFilter(colorFilter);
    }
}
