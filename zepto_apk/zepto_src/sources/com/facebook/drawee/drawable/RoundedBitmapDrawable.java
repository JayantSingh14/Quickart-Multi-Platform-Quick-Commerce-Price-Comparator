package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.ref.WeakReference;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundedBitmapDrawable extends RoundedDrawable {
    public static final /* synthetic */ int D = 0;
    public final Bitmap A;
    public WeakReference B;
    public RectF C;
    public final Paint y;
    public final Paint z;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.y = paint2;
        Paint paint3 = new Paint(1);
        this.z = paint3;
        this.C = null;
        this.A = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable
    public final void d() {
        super.d();
        if (this.C == null) {
            this.C = new RectF();
        }
        this.t.mapRect(this.C, this.f17376m);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Shader shader;
        FrescoSystrace.a();
        if (!((this.f17365b || this.f17366c || this.f17367d > 0.0f) && this.A != null)) {
            super.draw(canvas);
            FrescoSystrace.a();
            return;
        }
        d();
        a();
        WeakReference weakReference = this.B;
        Paint paint = this.y;
        Bitmap bitmap = this.A;
        if (weakReference == null || weakReference.get() != bitmap) {
            this.B = new WeakReference(bitmap);
            if (bitmap != null) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                this.f17369f = true;
            }
        }
        if (this.f17369f && (shader = paint.getShader()) != null) {
            shader.setLocalMatrix(this.t);
            this.f17369f = false;
        }
        paint.setFilterBitmap(this.v);
        int iSave = canvas.save();
        canvas.concat(this.s);
        Path path = this.f17368e;
        if (this.C != null) {
            int iSave2 = canvas.save();
            canvas.clipRect(this.C);
            canvas.drawPath(path, paint);
            canvas.restoreToCount(iSave2);
        } else {
            canvas.drawPath(path, paint);
        }
        float f2 = this.f17367d;
        if (f2 > 0.0f) {
            Paint paint2 = this.z;
            paint2.setStrokeWidth(f2);
            paint2.setColor(DrawableUtils.b(this.f17370g, paint.getAlpha()));
            canvas.drawPath(this.f17371h, paint2);
        }
        canvas.restoreToCount(iSave);
        FrescoSystrace.a();
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        super.setAlpha(i2);
        Paint paint = this.y;
        if (i2 != paint.getAlpha()) {
            paint.setAlpha(i2);
            super.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.y.setColorFilter(colorFilter);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, com.facebook.drawee.drawable.Rounded
    public final void o() {
    }
}
