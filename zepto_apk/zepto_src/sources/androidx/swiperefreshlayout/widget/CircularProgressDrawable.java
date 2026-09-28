package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.a;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final LinearInterpolator f11952g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f11953h = new FastOutSlowInInterpolator();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f11954i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final Ring f11955a;

    /* renamed from: b, reason: collision with root package name */
    public float f11956b;

    /* renamed from: c, reason: collision with root package name */
    public final Resources f11957c;

    /* renamed from: d, reason: collision with root package name */
    public final ValueAnimator f11958d;

    /* renamed from: e, reason: collision with root package name */
    public float f11959e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11960f;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ProgressDrawableSize {
    }

    public static class Ring {

        /* renamed from: a, reason: collision with root package name */
        public final RectF f11965a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f11966b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f11967c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f11968d;

        /* renamed from: e, reason: collision with root package name */
        public float f11969e;

        /* renamed from: f, reason: collision with root package name */
        public float f11970f;

        /* renamed from: g, reason: collision with root package name */
        public float f11971g;

        /* renamed from: h, reason: collision with root package name */
        public float f11972h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f11973i;

        /* renamed from: j, reason: collision with root package name */
        public int f11974j;

        /* renamed from: k, reason: collision with root package name */
        public float f11975k;

        /* renamed from: l, reason: collision with root package name */
        public float f11976l;

        /* renamed from: m, reason: collision with root package name */
        public float f11977m;
        public boolean n;
        public Path o;
        public float p;
        public float q;
        public int r;
        public int s;
        public int t;
        public int u;

        public Ring() {
            Paint paint = new Paint();
            this.f11966b = paint;
            Paint paint2 = new Paint();
            this.f11967c = paint2;
            Paint paint3 = new Paint();
            this.f11968d = paint3;
            this.f11969e = 0.0f;
            this.f11970f = 0.0f;
            this.f11971g = 0.0f;
            this.f11972h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public final void a(int i2) {
            this.f11974j = i2;
            this.u = this.f11973i[i2];
        }
    }

    public CircularProgressDrawable(Context context) {
        context.getClass();
        this.f11957c = context.getResources();
        final Ring ring = new Ring();
        this.f11955a = ring;
        ring.f11973i = f11954i;
        ring.a(0);
        ring.f11972h = 2.5f;
        ring.f11966b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                circularProgressDrawable.getClass();
                Ring ring2 = ring;
                CircularProgressDrawable.i(fFloatValue, ring2);
                circularProgressDrawable.a(fFloatValue, ring2, false);
                circularProgressDrawable.invalidateSelf();
            }
        });
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f11952g);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                Ring ring2 = ring;
                circularProgressDrawable.a(1.0f, ring2, true);
                ring2.f11975k = ring2.f11969e;
                ring2.f11976l = ring2.f11970f;
                ring2.f11977m = ring2.f11971g;
                ring2.a((ring2.f11974j + 1) % ring2.f11973i.length);
                if (!circularProgressDrawable.f11960f) {
                    circularProgressDrawable.f11959e += 1.0f;
                    return;
                }
                circularProgressDrawable.f11960f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                if (ring2.n) {
                    ring2.n = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f11959e = 0.0f;
            }
        });
        this.f11958d = valueAnimatorOfFloat;
    }

    public static void i(float f2, Ring ring) {
        if (f2 <= 0.75f) {
            ring.u = ring.f11973i[ring.f11974j];
            return;
        }
        float f3 = (f2 - 0.75f) / 0.25f;
        int[] iArr = ring.f11973i;
        int i2 = ring.f11974j;
        int i3 = iArr[i2];
        int i4 = iArr[(i2 + 1) % iArr.length];
        ring.u = ((((i3 >> 24) & 255) + ((int) ((((i4 >> 24) & 255) - r1) * f3))) << 24) | ((((i3 >> 16) & 255) + ((int) ((((i4 >> 16) & 255) - r3) * f3))) << 16) | ((((i3 >> 8) & 255) + ((int) ((((i4 >> 8) & 255) - r4) * f3))) << 8) | ((i3 & 255) + ((int) (f3 * ((i4 & 255) - r2))));
    }

    public final void a(float f2, Ring ring, boolean z) {
        float interpolation;
        float interpolation2;
        if (this.f11960f) {
            i(f2, ring);
            float fFloor = (float) (Math.floor(ring.f11977m / 0.8f) + 1.0d);
            float f3 = ring.f11975k;
            float f4 = ring.f11976l;
            ring.f11969e = (((f4 - 0.01f) - f3) * f2) + f3;
            ring.f11970f = f4;
            float f5 = ring.f11977m;
            ring.f11971g = a.a(fFloor, f5, f2, f5);
            return;
        }
        if (f2 != 1.0f || z) {
            float f6 = ring.f11977m;
            FastOutSlowInInterpolator fastOutSlowInInterpolator = f11953h;
            if (f2 < 0.5f) {
                interpolation = ring.f11975k;
                interpolation2 = (fastOutSlowInInterpolator.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f7 = ring.f11975k + 0.79f;
                interpolation = f7 - (((1.0f - fastOutSlowInInterpolator.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f7;
            }
            float f8 = (0.20999998f * f2) + f6;
            float f9 = (f2 + this.f11959e) * 216.0f;
            ring.f11969e = interpolation;
            ring.f11970f = interpolation2;
            ring.f11971g = f8;
            this.f11956b = f9;
        }
    }

    public final void b(boolean z) {
        Ring ring = this.f11955a;
        if (ring.n != z) {
            ring.n = z;
        }
        invalidateSelf();
    }

    public final void c(float f2) {
        Ring ring = this.f11955a;
        if (f2 != ring.p) {
            ring.p = f2;
        }
        invalidateSelf();
    }

    public final void d(int... iArr) {
        Ring ring = this.f11955a;
        ring.f11973i = iArr;
        ring.a(0);
        ring.a(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f11956b, bounds.exactCenterX(), bounds.exactCenterY());
        Ring ring = this.f11955a;
        RectF rectF = ring.f11965a;
        float f2 = ring.q;
        float fMin = (ring.f11972h / 2.0f) + f2;
        if (f2 <= 0.0f) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((ring.r * ring.p) / 2.0f, ring.f11972h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f3 = ring.f11969e;
        float f4 = ring.f11971g;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((ring.f11970f + f4) * 360.0f) - f5;
        Paint paint = ring.f11966b;
        paint.setColor(ring.u);
        paint.setAlpha(ring.t);
        float f7 = ring.f11972h / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, ring.f11968d);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, paint);
        if (ring.n) {
            Path path = ring.o;
            if (path == null) {
                Path path2 = new Path();
                ring.o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f9 = (ring.r * ring.p) / 2.0f;
            ring.o.moveTo(0.0f, 0.0f);
            ring.o.lineTo(ring.r * ring.p, 0.0f);
            Path path3 = ring.o;
            float f10 = ring.r;
            float f11 = ring.p;
            path3.lineTo((f10 * f11) / 2.0f, ring.s * f11);
            ring.o.offset((rectF.centerX() + fMin2) - f9, (ring.f11972h / 2.0f) + rectF.centerY());
            ring.o.close();
            Paint paint2 = ring.f11967c;
            paint2.setColor(ring.u);
            paint2.setAlpha(ring.t);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(ring.o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    public final void e(float f2) {
        this.f11955a.f11971g = f2;
        invalidateSelf();
    }

    public final void f(float f2, float f3, float f4, float f5) {
        float f6 = this.f11957c.getDisplayMetrics().density;
        float f7 = f3 * f6;
        Ring ring = this.f11955a;
        ring.f11972h = f7;
        ring.f11966b.setStrokeWidth(f7);
        ring.q = f2 * f6;
        ring.a(0);
        ring.r = (int) (f4 * f6);
        ring.s = (int) (f5 * f6);
    }

    public final void g(float f2) {
        Ring ring = this.f11955a;
        ring.f11969e = 0.0f;
        ring.f11970f = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f11955a.t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(int i2) {
        if (i2 == 0) {
            f(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            f(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f11958d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f11955a.t = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f11955a.f11966b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f11958d.cancel();
        Ring ring = this.f11955a;
        float f2 = ring.f11969e;
        ring.f11975k = f2;
        float f3 = ring.f11970f;
        ring.f11976l = f3;
        ring.f11977m = ring.f11971g;
        if (f3 != f2) {
            this.f11960f = true;
            this.f11958d.setDuration(666L);
            this.f11958d.start();
            return;
        }
        ring.a(0);
        ring.f11975k = 0.0f;
        ring.f11976l = 0.0f;
        ring.f11977m = 0.0f;
        ring.f11969e = 0.0f;
        ring.f11970f = 0.0f;
        ring.f11971g = 0.0f;
        this.f11958d.setDuration(1332L);
        this.f11958d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f11958d.cancel();
        this.f11956b = 0.0f;
        Ring ring = this.f11955a;
        if (ring.n) {
            ring.n = false;
        }
        ring.a(0);
        ring.f11975k = 0.0f;
        ring.f11976l = 0.0f;
        ring.f11977m = 0.0f;
        ring.f11969e = 0.0f;
        ring.f11970f = 0.0f;
        ring.f11971g = 0.0f;
        invalidateSelf();
    }
}
