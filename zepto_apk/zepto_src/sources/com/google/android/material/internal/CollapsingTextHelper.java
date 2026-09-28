package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.BaseInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;
import java.util.WeakHashMap;
import org.xbill.DNS.WKSRecord;

@RestrictTo
/* loaded from: classes4.dex */
public final class CollapsingTextHelper {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public CancelableFontCallback D;
    public CancelableFontCallback E;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public Bitmap K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int[] R;
    public boolean S;
    public final TextPaint T;
    public final TextPaint U;
    public TimeInterpolator V;
    public BaseInterpolator W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f40553a;
    public ColorStateList a0;

    /* renamed from: b, reason: collision with root package name */
    public float f40554b;
    public float b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40555c;
    public float c0;

    /* renamed from: d, reason: collision with root package name */
    public float f40556d;
    public float d0;

    /* renamed from: e, reason: collision with root package name */
    public float f40557e;
    public ColorStateList e0;

    /* renamed from: f, reason: collision with root package name */
    public int f40558f;
    public float f0;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f40559g;
    public float g0;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f40560h;
    public float h0;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f40561i;
    public StaticLayout i0;
    public float j0;
    public float k0;
    public float l0;
    public CharSequence m0;
    public ColorStateList n;
    public ColorStateList o;
    public int p;
    public float q;
    public float r;
    public CollapsingToolbarLayout.StaticLayoutBuilderConfigurer r0;
    public float s;
    public float t;
    public float u;
    public float v;
    public Typeface w;
    public Typeface x;
    public Typeface y;
    public Typeface z;

    /* renamed from: j, reason: collision with root package name */
    public int f40562j = 16;

    /* renamed from: k, reason: collision with root package name */
    public int f40563k = 16;

    /* renamed from: l, reason: collision with root package name */
    public float f40564l = 15.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f40565m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;
    public int n0 = 1;
    public float o0 = 0.0f;
    public float p0 = 1.0f;
    public int q0 = 1;

    public CollapsingTextHelper(ViewGroup viewGroup) {
        this.f40553a = viewGroup;
        TextPaint textPaint = new TextPaint(WKSRecord.Service.PWDGEN);
        this.T = textPaint;
        this.U = new TextPaint(textPaint);
        this.f40560h = new Rect();
        this.f40559g = new Rect();
        this.f40561i = new RectF();
        float f2 = this.f40556d;
        this.f40557e = android.support.v4.media.a.a(1.0f, f2, 0.5f, f2);
        h(viewGroup.getContext().getResources().getConfiguration());
    }

    public static int a(float f2, int i2, int i3) {
        float f3 = 1.0f - f2;
        return Color.argb(Math.round((Color.alpha(i3) * f2) + (Color.alpha(i2) * f3)), Math.round((Color.red(i3) * f2) + (Color.red(i2) * f3)), Math.round((Color.green(i3) * f2) + (Color.green(i2) * f3)), Math.round((Color.blue(i3) * f2) + (Color.blue(i2) * f3)));
    }

    public static float g(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.a(f2, f3, f4);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        boolean z = this.f40553a.getLayoutDirection() == 1;
        if (this.J) {
            return (z ? TextDirectionHeuristicsCompat.f2964d : TextDirectionHeuristicsCompat.f2963c).a(charSequence, charSequence.length());
        }
        return z;
    }

    public final void c(float f2, boolean z) {
        float f3;
        float f4;
        Typeface typeface;
        boolean z2;
        StaticLayout staticLayoutA;
        Layout.Alignment alignment;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f40560h.width();
        float fWidth2 = this.f40559g.width();
        if (Math.abs(f2 - 1.0f) < 1.0E-5f) {
            f3 = this.f40565m;
            f4 = this.f0;
            this.L = 1.0f;
            typeface = this.w;
        } else {
            float f5 = this.f40564l;
            float f6 = this.g0;
            Typeface typeface2 = this.z;
            if (Math.abs(f2 - 0.0f) < 1.0E-5f) {
                this.L = 1.0f;
            } else {
                this.L = g(this.f40564l, this.f40565m, f2, this.W) / this.f40564l;
            }
            float f7 = this.f40565m / this.f40564l;
            fWidth = (z || this.f40555c || fWidth2 * f7 <= fWidth) ? fWidth2 : Math.min(fWidth / f7, fWidth2);
            f3 = f5;
            f4 = f6;
            typeface = typeface2;
        }
        TextPaint textPaint = this.T;
        if (fWidth > 0.0f) {
            boolean z3 = this.M != f3;
            boolean z4 = this.h0 != f4;
            boolean z5 = this.C != typeface;
            StaticLayout staticLayout = this.i0;
            boolean z6 = z3 || z4 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z5 || this.S;
            this.M = f3;
            this.h0 = f4;
            this.C = typeface;
            this.S = false;
            textPaint.setLinearText(this.L != 1.0f);
            z2 = z6;
        } else {
            z2 = false;
        }
        if (this.H == null || z2) {
            textPaint.setTextSize(this.M);
            textPaint.setTypeface(this.C);
            textPaint.setLetterSpacing(this.h0);
            boolean zB = b(this.G);
            this.I = zB;
            int i2 = this.n0;
            if (i2 <= 1 || (zB && !this.f40555c)) {
                i2 = 1;
            }
            try {
                if (i2 == 1) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    int absoluteGravity = Gravity.getAbsoluteGravity(this.f40562j, zB ? 1 : 0) & 7;
                    alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
                }
                StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.G, textPaint, (int) fWidth);
                staticLayoutBuilderCompat.f40638l = this.F;
                staticLayoutBuilderCompat.f40637k = zB;
                staticLayoutBuilderCompat.f40631e = alignment;
                staticLayoutBuilderCompat.f40636j = false;
                staticLayoutBuilderCompat.f40632f = i2;
                float f8 = this.o0;
                float f9 = this.p0;
                staticLayoutBuilderCompat.f40633g = f8;
                staticLayoutBuilderCompat.f40634h = f9;
                staticLayoutBuilderCompat.f40635i = this.q0;
                staticLayoutBuilderCompat.f40639m = this.r0;
                staticLayoutA = staticLayoutBuilderCompat.a();
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
                Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
                staticLayoutA = null;
            }
            staticLayoutA.getClass();
            this.i0 = staticLayoutA;
            this.H = staticLayoutA.getText();
        }
    }

    public final void d(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H != null) {
            RectF rectF = this.f40561i;
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            TextPaint textPaint = this.T;
            textPaint.setTextSize(this.M);
            float f2 = this.u;
            float f3 = this.v;
            float f4 = this.L;
            if (f4 != 1.0f && !this.f40555c) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (this.n0 <= 1 || ((this.I && !this.f40555c) || (this.f40555c && this.f40554b <= this.f40557e))) {
                canvas.translate(f2, f3);
                this.i0.draw(canvas);
            } else {
                float lineStart = this.u - this.i0.getLineStart(0);
                int alpha = textPaint.getAlpha();
                canvas.translate(lineStart, f3);
                if (!this.f40555c) {
                    textPaint.setAlpha((int) (this.l0 * alpha));
                    if (Build.VERSION.SDK_INT >= 31) {
                        textPaint.setShadowLayer(this.N, this.O, this.P, MaterialColors.a(this.Q, textPaint.getAlpha()));
                    }
                    this.i0.draw(canvas);
                }
                if (!this.f40555c) {
                    textPaint.setAlpha((int) (this.k0 * alpha));
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, MaterialColors.a(this.Q, textPaint.getAlpha()));
                }
                int lineBaseline = this.i0.getLineBaseline(0);
                CharSequence charSequence = this.m0;
                float f5 = lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, textPaint);
                if (i2 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, this.Q);
                }
                if (!this.f40555c) {
                    String strTrim = this.m0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = android.support.v4.media.a.k(1, 0, strTrim);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(this.i0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) textPaint);
                }
                canvas = canvas;
            }
            canvas.restoreToCount(iSave);
        }
    }

    public final float e() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f40565m);
        textPaint.setTypeface(this.w);
        textPaint.setLetterSpacing(this.f0);
        return -textPaint.ascent();
    }

    public final int f(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.R;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void h(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.y;
            if (typeface != null) {
                this.x = TypefaceUtils.a(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = TypefaceUtils.a(configuration, typeface2);
            }
            Typeface typeface3 = this.x;
            if (typeface3 == null) {
                typeface3 = this.y;
            }
            this.w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.z = typeface4;
            i(true);
        }
    }

    public final void i(boolean z) {
        float fMeasureText;
        float f2;
        StaticLayout staticLayout;
        ViewGroup viewGroup = this.f40553a;
        if ((viewGroup.getHeight() <= 0 || viewGroup.getWidth() <= 0) && !z) {
            return;
        }
        c(1.0f, z);
        CharSequence charSequence = this.H;
        TextPaint textPaint = this.T;
        if (charSequence != null && (staticLayout = this.i0) != null) {
            this.m0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.m0;
        if (charSequence2 != null) {
            this.j0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.j0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f40563k, this.I ? 1 : 0);
        int i2 = absoluteGravity & 112;
        Rect rect = this.f40560h;
        if (i2 == 48) {
            this.r = rect.top;
        } else if (i2 != 80) {
            this.r = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.r = textPaint.ascent() + rect.bottom;
        }
        int i3 = absoluteGravity & 8388615;
        if (i3 == 1) {
            this.t = rect.centerX() - (this.j0 / 2.0f);
        } else if (i3 != 5) {
            this.t = rect.left;
        } else {
            this.t = rect.right - this.j0;
        }
        c(0.0f, z);
        float height = this.i0 != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.i0;
        if (staticLayout2 == null || this.n0 <= 1) {
            CharSequence charSequence3 = this.H;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.i0;
        this.p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f40562j, this.I ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        Rect rect2 = this.f40559g;
        if (i4 == 48) {
            this.q = rect2.top;
        } else if (i4 != 80) {
            this.q = rect2.centerY() - (height / 2.0f);
        } else {
            this.q = textPaint.descent() + (rect2.bottom - height);
        }
        int i5 = absoluteGravity2 & 8388615;
        if (i5 == 1) {
            this.s = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i5 != 5) {
            this.s = rect2.left;
        } else {
            this.s = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.K;
        if (bitmap != null) {
            bitmap.recycle();
            this.K = null;
        }
        q(this.f40554b);
        float f3 = this.f40554b;
        boolean z2 = this.f40555c;
        RectF rectF = this.f40561i;
        if (z2) {
            if (f3 < this.f40557e) {
                rect = rect2;
            }
            rectF.set(rect);
        } else {
            rectF.left = g(rect2.left, rect.left, f3, this.V);
            rectF.top = g(this.q, this.r, f3, this.V);
            rectF.right = g(rect2.right, rect.right, f3, this.V);
            rectF.bottom = g(rect2.bottom, rect.bottom, f3, this.V);
        }
        if (!this.f40555c) {
            this.u = g(this.s, this.t, f3, this.V);
            this.v = g(this.q, this.r, f3, this.V);
            q(f3);
            f2 = f3;
        } else if (f3 < this.f40557e) {
            this.u = this.s;
            this.v = this.q;
            q(0.0f);
            f2 = 0.0f;
        } else {
            this.u = this.t;
            this.v = this.r - Math.max(0, this.f40558f);
            q(1.0f);
            f2 = 1.0f;
        }
        FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.f39817b;
        this.k0 = 1.0f - g(0.0f, 1.0f, 1.0f - f3, fastOutSlowInInterpolator);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        viewGroup.postInvalidateOnAnimation();
        this.l0 = g(1.0f, 0.0f, f3, fastOutSlowInInterpolator);
        viewGroup.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.o;
        ColorStateList colorStateList2 = this.n;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f2, f(colorStateList2), f(this.o)));
        } else {
            textPaint.setColor(f(colorStateList));
        }
        int i6 = Build.VERSION.SDK_INT;
        float f4 = this.f0;
        float f5 = this.g0;
        if (f4 != f5) {
            textPaint.setLetterSpacing(g(f5, f4, f3, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f4);
        }
        this.N = AnimationUtils.a(this.b0, this.X, f3);
        this.O = AnimationUtils.a(this.c0, this.Y, f3);
        this.P = AnimationUtils.a(this.d0, this.Z, f3);
        int iA = a(f3, f(this.e0), f(this.a0));
        this.Q = iA;
        textPaint.setShadowLayer(this.N, this.O, this.P, iA);
        if (this.f40555c) {
            int alpha = textPaint.getAlpha();
            float f6 = this.f40557e;
            textPaint.setAlpha((int) ((f3 <= f6 ? AnimationUtils.b(1.0f, 0.0f, this.f40556d, f6, f3) : AnimationUtils.b(0.0f, 1.0f, f6, 1.0f, f3)) * alpha));
            if (i6 >= 31) {
                textPaint.setShadowLayer(this.N, this.O, this.P, MaterialColors.a(this.Q, textPaint.getAlpha()));
            }
        }
        viewGroup.postInvalidateOnAnimation();
    }

    public final void j(ColorStateList colorStateList) {
        if (this.o == colorStateList && this.n == colorStateList) {
            return;
        }
        this.o = colorStateList;
        this.n = colorStateList;
        i(false);
    }

    public final void k(int i2) {
        ViewGroup viewGroup = this.f40553a;
        TextAppearance textAppearance = new TextAppearance(viewGroup.getContext(), i2);
        ColorStateList colorStateList = textAppearance.f40877j;
        if (colorStateList != null) {
            this.o = colorStateList;
        }
        float f2 = textAppearance.f40878k;
        if (f2 != 0.0f) {
            this.f40565m = f2;
        }
        ColorStateList colorStateList2 = textAppearance.f40868a;
        if (colorStateList2 != null) {
            this.a0 = colorStateList2;
        }
        this.Y = textAppearance.f40872e;
        this.Z = textAppearance.f40873f;
        this.X = textAppearance.f40874g;
        this.f0 = textAppearance.f40876i;
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.f40867c = true;
        }
        CancelableFontCallback.ApplyFont applyFont = new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public final void a(Typeface typeface) {
                CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
                if (collapsingTextHelper.m(typeface)) {
                    collapsingTextHelper.i(false);
                }
            }
        };
        textAppearance.a();
        this.E = new CancelableFontCallback(applyFont, textAppearance.n);
        textAppearance.c(viewGroup.getContext(), this.E);
        i(false);
    }

    public final void l(int i2) {
        if (this.f40563k != i2) {
            this.f40563k = i2;
            i(false);
        }
    }

    public final boolean m(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.f40867c = true;
        }
        if (this.y == typeface) {
            return false;
        }
        this.y = typeface;
        Typeface typefaceA = TypefaceUtils.a(this.f40553a.getContext().getResources().getConfiguration(), typeface);
        this.x = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.y;
        }
        this.w = typefaceA;
        return true;
    }

    public final void n(int i2) {
        ViewGroup viewGroup = this.f40553a;
        TextAppearance textAppearance = new TextAppearance(viewGroup.getContext(), i2);
        ColorStateList colorStateList = textAppearance.f40877j;
        if (colorStateList != null) {
            this.n = colorStateList;
        }
        float f2 = textAppearance.f40878k;
        if (f2 != 0.0f) {
            this.f40564l = f2;
        }
        ColorStateList colorStateList2 = textAppearance.f40868a;
        if (colorStateList2 != null) {
            this.e0 = colorStateList2;
        }
        this.c0 = textAppearance.f40872e;
        this.d0 = textAppearance.f40873f;
        this.b0 = textAppearance.f40874g;
        this.g0 = textAppearance.f40876i;
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.f40867c = true;
        }
        CancelableFontCallback.ApplyFont applyFont = new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public final void a(Typeface typeface) {
                CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
                if (collapsingTextHelper.o(typeface)) {
                    collapsingTextHelper.i(false);
                }
            }
        };
        textAppearance.a();
        this.D = new CancelableFontCallback(applyFont, textAppearance.n);
        textAppearance.c(viewGroup.getContext(), this.D);
        i(false);
    }

    public final boolean o(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.f40867c = true;
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceA = TypefaceUtils.a(this.f40553a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.B;
        }
        this.z = typefaceA;
        return true;
    }

    public final void p(float f2) {
        float f3;
        float fA = MathUtils.a(f2, 0.0f, 1.0f);
        if (fA != this.f40554b) {
            this.f40554b = fA;
            boolean z = this.f40555c;
            RectF rectF = this.f40561i;
            Rect rect = this.f40560h;
            Rect rect2 = this.f40559g;
            if (z) {
                if (fA < this.f40557e) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = g(rect2.left, rect.left, fA, this.V);
                rectF.top = g(this.q, this.r, fA, this.V);
                rectF.right = g(rect2.right, rect.right, fA, this.V);
                rectF.bottom = g(rect2.bottom, rect.bottom, fA, this.V);
            }
            if (!this.f40555c) {
                this.u = g(this.s, this.t, fA, this.V);
                this.v = g(this.q, this.r, fA, this.V);
                q(fA);
                f3 = fA;
            } else if (fA < this.f40557e) {
                this.u = this.s;
                this.v = this.q;
                q(0.0f);
                f3 = 0.0f;
            } else {
                this.u = this.t;
                this.v = this.r - Math.max(0, this.f40558f);
                q(1.0f);
                f3 = 1.0f;
            }
            FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.f39817b;
            this.k0 = 1.0f - g(0.0f, 1.0f, 1.0f - fA, fastOutSlowInInterpolator);
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            ViewGroup viewGroup = this.f40553a;
            viewGroup.postInvalidateOnAnimation();
            this.l0 = g(1.0f, 0.0f, fA, fastOutSlowInInterpolator);
            viewGroup.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.o;
            ColorStateList colorStateList2 = this.n;
            TextPaint textPaint = this.T;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f3, f(colorStateList2), f(this.o)));
            } else {
                textPaint.setColor(f(colorStateList));
            }
            int i2 = Build.VERSION.SDK_INT;
            float f4 = this.f0;
            float f5 = this.g0;
            if (f4 != f5) {
                textPaint.setLetterSpacing(g(f5, f4, fA, fastOutSlowInInterpolator));
            } else {
                textPaint.setLetterSpacing(f4);
            }
            this.N = AnimationUtils.a(this.b0, this.X, fA);
            this.O = AnimationUtils.a(this.c0, this.Y, fA);
            this.P = AnimationUtils.a(this.d0, this.Z, fA);
            int iA = a(fA, f(this.e0), f(this.a0));
            this.Q = iA;
            textPaint.setShadowLayer(this.N, this.O, this.P, iA);
            if (this.f40555c) {
                int alpha = textPaint.getAlpha();
                float f6 = this.f40557e;
                textPaint.setAlpha((int) ((fA <= f6 ? AnimationUtils.b(1.0f, 0.0f, this.f40556d, f6, fA) : AnimationUtils.b(0.0f, 1.0f, f6, 1.0f, fA)) * alpha));
                if (i2 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, MaterialColors.a(this.Q, textPaint.getAlpha()));
                }
            }
            viewGroup.postInvalidateOnAnimation();
        }
    }

    public final void q(float f2) {
        c(f2, false);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        this.f40553a.postInvalidateOnAnimation();
    }
}
