package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.media.a;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class DrawerArrowDrawable extends Drawable {

    /* renamed from: l, reason: collision with root package name */
    public static final float f453l = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    public final Paint f454a;

    /* renamed from: b, reason: collision with root package name */
    public final float f455b;

    /* renamed from: c, reason: collision with root package name */
    public final float f456c;

    /* renamed from: d, reason: collision with root package name */
    public final float f457d;

    /* renamed from: e, reason: collision with root package name */
    public final float f458e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f459f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f460g;

    /* renamed from: h, reason: collision with root package name */
    public final int f461h;

    /* renamed from: i, reason: collision with root package name */
    public float f462i;

    /* renamed from: j, reason: collision with root package name */
    public final float f463j;

    /* renamed from: k, reason: collision with root package name */
    public final int f464k;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f454a = paint;
        this.f460g = new Path();
        this.f464k = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.f463j = (float) (Math.cos(f453l) * (dimension / 2.0f));
            invalidateSelf();
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
        if (this.f459f != z) {
            this.f459f = z;
            invalidateSelf();
        }
        float fRound = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (fRound != this.f458e) {
            this.f458e = fRound;
            invalidateSelf();
        }
        this.f461h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f456c = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f455b = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f457d = typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float a(float f2, float f3, float f4) {
        return a.a(f3, f2, f4, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = this.f464k;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? getLayoutDirection() == 0 : getLayoutDirection() == 1))) {
            z = true;
        }
        float f2 = this.f455b;
        float fSqrt = (float) Math.sqrt(f2 * f2 * 2.0f);
        float f3 = this.f462i;
        float f4 = this.f456c;
        float fA = a(f4, fSqrt, f3);
        float fA2 = a(f4, this.f457d, this.f462i);
        float fRound = Math.round(a(0.0f, this.f463j, this.f462i));
        float fA3 = a(0.0f, f453l, this.f462i);
        float fA4 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.f462i);
        double d2 = fA;
        double d3 = fA3;
        boolean z2 = z;
        float fRound2 = Math.round(Math.cos(d3) * d2);
        float fRound3 = Math.round(Math.sin(d3) * d2);
        Path path = this.f460g;
        path.rewind();
        float f5 = this.f458e;
        Paint paint = this.f454a;
        float fA5 = a(paint.getStrokeWidth() + f5, -this.f463j, this.f462i);
        float f6 = (-fA2) / 2.0f;
        path.moveTo(f6 + fRound, 0.0f);
        path.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        path.moveTo(f6, fA5);
        path.rLineTo(fRound2, fRound3);
        path.moveTo(f6, -fA5);
        path.rLineTo(fRound2, -fRound3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + this.f458e + ((((int) (fHeight - (r6 * 2.0f))) / 4) * 2));
        if (this.f459f) {
            canvas.rotate(fA4 * (z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f461h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f461h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        Paint paint = this.f454a;
        if (i2 != paint.getAlpha()) {
            paint.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f454a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
