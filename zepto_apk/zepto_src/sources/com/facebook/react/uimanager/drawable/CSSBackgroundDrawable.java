package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.ArrayList;
import java.util.Iterator;

@Nullsafe
@UnstableReactNativeAPI
/* loaded from: classes.dex */
public class CSSBackgroundDrawable extends Drawable {
    public final Context A;

    /* renamed from: a, reason: collision with root package name */
    public Spacing f19653a;

    /* renamed from: b, reason: collision with root package name */
    public Spacing f19654b;

    /* renamed from: c, reason: collision with root package name */
    public Spacing f19655c;

    /* renamed from: d, reason: collision with root package name */
    public BorderStyle f19656d;

    /* renamed from: e, reason: collision with root package name */
    public Path f19657e;

    /* renamed from: f, reason: collision with root package name */
    public Path f19658f;

    /* renamed from: g, reason: collision with root package name */
    public Path f19659g;

    /* renamed from: h, reason: collision with root package name */
    public Path f19660h;

    /* renamed from: i, reason: collision with root package name */
    public Path f19661i;

    /* renamed from: k, reason: collision with root package name */
    public Path f19663k;

    /* renamed from: l, reason: collision with root package name */
    public RectF f19664l;

    /* renamed from: m, reason: collision with root package name */
    public RectF f19665m;
    public RectF n;
    public RectF o;
    public PointF p;
    public PointF q;
    public PointF r;
    public PointF s;

    /* renamed from: j, reason: collision with root package name */
    public final Path f19662j = new Path();
    public boolean t = false;
    public final Paint u = new Paint(1);
    public int v = 0;
    public ArrayList w = null;
    public int x = 255;
    public final BorderRadiusStyle y = new BorderRadiusStyle();
    public ComputedBorderRadius z = new ComputedBorderRadius();
    public final int B = -1;

    /* renamed from: com.facebook.react.uimanager.drawable.CSSBackgroundDrawable$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19666a;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            f19666a = iArr;
            try {
                BorderStyle.Companion companion = BorderStyle.f19856a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f19666a;
                BorderStyle.Companion companion2 = BorderStyle.f19856a;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f19666a;
                BorderStyle.Companion companion3 = BorderStyle.f19856a;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CSSBackgroundDrawable(Context context) {
        this.A = context;
    }

    public static void f(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = d6 - d10;
        double d13 = d7 - d11;
        double dAbs = Math.abs(d4 - d2) / 2.0d;
        double dAbs2 = Math.abs(d5 - d3) / 2.0d;
        double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = dAbs2 * dAbs2;
        double d17 = dAbs * dAbs;
        double dA = b.a(d17, d14, d14, d16);
        double d18 = dAbs * 2.0d * dAbs * d15 * d14;
        double d19 = (-(d17 * ((d15 * d15) - d16))) / dA;
        double d20 = dA * 2.0d;
        double dSqrt = ((-d18) / d20) - Math.sqrt(Math.pow(d18 / d20, 2.0d) + d19);
        double d21 = (d14 * dSqrt) + d15;
        double d22 = dSqrt + d10;
        double d23 = d21 + d11;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    public static float g(float f2, float f3) {
        return Math.max(f2 - f3, 0.0f);
    }

    public static DashPathEffect h(BorderStyle borderStyle, float f2) {
        int iOrdinal = borderStyle.ordinal();
        if (iOrdinal == 1) {
            float f3 = f2 * 3.0f;
            return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
        }
        if (iOrdinal != 2) {
            return null;
        }
        return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
    }

    public static int j(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24);
    }

    public final void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i2 == 0) {
            return;
        }
        if (this.f19661i == null) {
            this.f19661i = new Path();
        }
        Paint paint = this.u;
        paint.setColor(i2);
        this.f19661i.reset();
        this.f19661i.moveTo(f2, f3);
        this.f19661i.lineTo(f4, f5);
        this.f19661i.lineTo(f6, f7);
        this.f19661i.lineTo(f8, f9);
        this.f19661i.lineTo(f2, f3);
        canvas.drawPath(this.f19661i, paint);
    }

    public final Shader b() {
        ArrayList arrayList = this.w;
        Shader composeShader = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinearGradient linearGradientA = ((BackgroundImageLayer) it.next()).a(getBounds());
            if (linearGradientA != null) {
                composeShader = composeShader == null ? linearGradientA : new ComposeShader(linearGradientA, composeShader, PorterDuff.Mode.SRC_OVER);
            }
        }
        return composeShader;
    }

    public final int c(int i2) {
        Spacing spacing = this.f19654b;
        float fA = spacing != null ? spacing.a(i2) : 0.0f;
        Spacing spacing2 = this.f19655c;
        return ((((int) (spacing2 != null ? spacing2.a(i2) : 255.0f)) << 24) & (-16777216)) | (((int) fA) & 16777215);
    }

    public final float d(float f2, int i2) {
        Spacing spacing = this.f19653a;
        Float fValueOf = null;
        if (spacing != null) {
            float f3 = spacing.f19476b[i2];
            if (!Float.isNaN(f3)) {
                fValueOf = Float.valueOf(f3);
            }
        }
        return fValueOf == null ? f2 : fValueOf.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04b7  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instructions count: 1241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.drawable.CSSBackgroundDrawable.draw(android.graphics.Canvas):void");
    }

    public final RectF e() {
        float fD = d(0.0f, 8);
        float fD2 = d(fD, 1);
        float fD3 = d(fD, 3);
        float fD4 = d(fD, 0);
        float fD5 = d(fD, 2);
        if (this.f19653a != null) {
            boolean z = getLayoutDirection() == 1;
            float[] fArr = this.f19653a.f19476b;
            float f2 = fArr[4];
            float f3 = fArr[5];
            if (I18nUtil.a(this.A)) {
                if (!Float.isNaN(f2)) {
                    fD4 = f2;
                }
                if (!Float.isNaN(f3)) {
                    fD5 = f3;
                }
                float f4 = z ? fD5 : fD4;
                if (z) {
                    fD5 = fD4;
                }
                fD4 = f4;
            } else {
                float f5 = z ? f3 : f2;
                if (!z) {
                    f2 = f3;
                }
                if (!Float.isNaN(f5)) {
                    fD4 = f5;
                }
                if (!Float.isNaN(f2)) {
                    fD5 = f2;
                }
            }
        }
        return new RectF(fD4, fD2, fD5, fD3);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getLayoutDirection() {
        int i2 = this.B;
        return i2 == -1 ? super.getLayoutDirection() : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int iAlpha = (Color.alpha(this.v) * this.x) >> 8;
        if (iAlpha != 0) {
            return iAlpha != 255 ? -3 : -1;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (!this.y.c()) {
            outline.setRect(getBounds());
            return;
        }
        k();
        Path path = this.f19660h;
        path.getClass();
        outline.setConvexPath(path);
    }

    public final boolean i(int i2) {
        Spacing spacing = this.f19654b;
        float fA = spacing != null ? spacing.a(i2) : Float.NaN;
        Spacing spacing2 = this.f19655c;
        return (Float.isNaN(fA) || Float.isNaN(spacing2 != null ? spacing2.a(i2) : Float.NaN)) ? false : true;
    }

    public final void k() {
        float f2;
        if (this.t) {
            this.t = false;
            if (this.f19657e == null) {
                this.f19657e = new Path();
            }
            if (this.f19658f == null) {
                this.f19658f = new Path();
            }
            if (this.f19659g == null) {
                this.f19659g = new Path();
            }
            if (this.f19660h == null) {
                this.f19660h = new Path();
            }
            if (this.f19663k == null) {
                this.f19663k = new Path();
            }
            if (this.f19664l == null) {
                this.f19664l = new RectF();
            }
            if (this.f19665m == null) {
                this.f19665m = new RectF();
            }
            if (this.n == null) {
                this.n = new RectF();
            }
            if (this.o == null) {
                this.o = new RectF();
            }
            this.f19657e.reset();
            this.f19658f.reset();
            this.f19659g.reset();
            this.f19660h.reset();
            this.f19663k.reset();
            this.f19664l.set(getBounds());
            this.f19665m.set(getBounds());
            this.n.set(getBounds());
            this.o.set(getBounds());
            RectF rectFE = e();
            int iC = c(0);
            int iC2 = c(1);
            int iC3 = c(2);
            int iC4 = c(3);
            int iC5 = c(8);
            int iC6 = c(9);
            int iC7 = c(11);
            int iC8 = c(10);
            if (i(9)) {
                iC2 = iC6;
                iC4 = iC2;
            }
            if (!i(10)) {
                iC8 = iC4;
            }
            if (!i(11)) {
                iC7 = iC2;
            }
            if (Color.alpha(iC) == 0 && Color.alpha(iC7) == 0 && Color.alpha(iC3) == 0 && Color.alpha(iC8) == 0 && Color.alpha(iC5) == 0) {
                f2 = 0.0f;
            } else {
                RectF rectF = this.f19664l;
                rectF.top += rectFE.top;
                rectF.bottom -= rectFE.bottom;
                rectF.left += rectFE.left;
                rectF.right -= rectFE.right;
                f2 = 0.8f;
            }
            RectF rectF2 = this.o;
            rectF2.top = (rectFE.top * 0.5f) + rectF2.top;
            rectF2.bottom -= rectFE.bottom * 0.5f;
            rectF2.left = (rectFE.left * 0.5f) + rectF2.left;
            rectF2.right -= rectFE.right * 0.5f;
            ComputedBorderRadius computedBorderRadiusD = this.y.d(getLayoutDirection(), this.A, PixelUtil.a(this.f19665m.width()), PixelUtil.a(this.f19665m.height()));
            this.z = computedBorderRadiusD;
            CornerRadii cornerRadiiA = computedBorderRadiusD.f19873a.a();
            CornerRadii cornerRadiiA2 = this.z.f19874b.a();
            CornerRadii cornerRadiiA3 = this.z.f19875c.a();
            CornerRadii cornerRadiiA4 = this.z.f19876d.a();
            float f3 = rectFE.left;
            float f4 = cornerRadiiA.f19879a;
            float fG = g(f4, f3);
            float f5 = rectFE.top;
            float f6 = cornerRadiiA.f19880b;
            float fG2 = g(f6, f5);
            float f7 = rectFE.right;
            float f8 = cornerRadiiA2.f19879a;
            float fG3 = g(f8, f7);
            float f9 = rectFE.top;
            float f10 = cornerRadiiA2.f19880b;
            float fG4 = g(f10, f9);
            float f11 = rectFE.right;
            float f12 = f2;
            float f13 = cornerRadiiA4.f19879a;
            float fG5 = g(f13, f11);
            float f14 = rectFE.bottom;
            float f15 = cornerRadiiA4.f19880b;
            float fG6 = g(f15, f14);
            float f16 = rectFE.left;
            float f17 = cornerRadiiA3.f19879a;
            float fG7 = g(f17, f16);
            float f18 = rectFE.bottom;
            float f19 = cornerRadiiA3.f19880b;
            float fG8 = g(f19, f18);
            Path path = this.f19657e;
            RectF rectF3 = this.f19664l;
            float[] fArr = {fG, fG2, fG3, fG4, fG5, fG6, fG7, fG8};
            Path.Direction direction = Path.Direction.CW;
            path.addRoundRect(rectF3, fArr, direction);
            Path path2 = this.f19658f;
            RectF rectF4 = this.f19664l;
            path2.addRoundRect(rectF4.left - f12, rectF4.top - f12, rectF4.right + f12, rectF4.bottom + f12, new float[]{fG, fG2, fG3, fG4, fG5, fG6, fG7, fG8}, direction);
            this.f19659g.addRoundRect(this.f19665m, new float[]{cornerRadiiA.f19879a, cornerRadiiA.f19880b, cornerRadiiA2.f19879a, cornerRadiiA2.f19880b, cornerRadiiA4.f19879a, cornerRadiiA4.f19880b, cornerRadiiA3.f19879a, cornerRadiiA3.f19880b}, direction);
            Spacing spacing = this.f19653a;
            float fA = spacing != null ? spacing.a(8) / 2.0f : 0.0f;
            this.f19660h.addRoundRect(this.n, new float[]{f4 + fA, f6 + fA, f8 + fA, f10 + fA, f13 + fA, f15 + fA, f17 + fA, f19 + fA}, direction);
            Path path3 = this.f19663k;
            RectF rectF5 = this.o;
            float f20 = rectFE.left * 0.5f;
            float f21 = rectFE.top * 0.5f;
            float f22 = rectFE.right * 0.5f;
            float f23 = rectFE.bottom * 0.5f;
            path3.addRoundRect(rectF5, new float[]{f4 - f20, f6 - f21, f8 - f22, f10 - f21, f13 - f22, f15 - f23, f17 - f20, f19 - f23}, direction);
            if (this.p == null) {
                this.p = new PointF();
            }
            PointF pointF = this.p;
            RectF rectF6 = this.f19664l;
            float f24 = rectF6.left;
            pointF.x = f24;
            float f25 = rectF6.top;
            pointF.y = f25;
            double d2 = f24;
            double d3 = f25;
            RectF rectF7 = this.f19665m;
            f(d2, d3, (fG * 2.0f) + f24, (fG2 * 2.0f) + f25, rectF7.left, rectF7.top, d2, d3, pointF);
            if (this.s == null) {
                this.s = new PointF();
            }
            PointF pointF2 = this.s;
            RectF rectF8 = this.f19664l;
            float f26 = rectF8.left;
            pointF2.x = f26;
            float f27 = rectF8.bottom;
            pointF2.y = f27;
            double d4 = f26;
            double d5 = f27;
            RectF rectF9 = this.f19665m;
            f(d4, f27 - (fG8 * 2.0f), (fG7 * 2.0f) + f26, d5, rectF9.left, rectF9.bottom, d4, d5, pointF2);
            if (this.q == null) {
                this.q = new PointF();
            }
            PointF pointF3 = this.q;
            RectF rectF10 = this.f19664l;
            float f28 = rectF10.right;
            pointF3.x = f28;
            float f29 = rectF10.top;
            pointF3.y = f29;
            double d6 = f29;
            double d7 = f28;
            RectF rectF11 = this.f19665m;
            f(f28 - (fG3 * 2.0f), d6, d7, (fG4 * 2.0f) + f29, rectF11.right, rectF11.top, d7, d6, pointF3);
            if (this.r == null) {
                this.r = new PointF();
            }
            PointF pointF4 = this.r;
            RectF rectF12 = this.f19664l;
            float f30 = rectF12.right;
            pointF4.x = f30;
            float f31 = rectF12.bottom;
            pointF4.y = f31;
            double d8 = f31 - (fG6 * 2.0f);
            double d9 = f30;
            double d10 = f31;
            RectF rectF13 = this.f19665m;
            f(f30 - (fG5 * 2.0f), d8, d9, d10, rectF13.right, rectF13.bottom, d9, d10, pointF4);
        }
    }

    public final void l(int i2) {
        BorderStyle borderStyle = this.f19656d;
        this.u.setPathEffect(borderStyle != null ? h(borderStyle, i2) : null);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.t = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (i2 != this.x) {
            this.x = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
