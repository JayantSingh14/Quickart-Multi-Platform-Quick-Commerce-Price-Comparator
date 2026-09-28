package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] p1 = {R.attr.state_enabled};
    public static final ShapeDrawable q1 = new ShapeDrawable(new OvalShape());
    public float A;
    public boolean A0;
    public float B;
    public boolean B0;
    public ColorStateList C;
    public Drawable C0;
    public float D;
    public ColorStateList D0;
    public ColorStateList E;
    public MotionSpec E0;
    public CharSequence F;
    public MotionSpec F0;
    public boolean G;
    public float G0;
    public Drawable H;
    public float H0;
    public ColorStateList I;
    public float I0;
    public float J;
    public float J0;
    public boolean K;
    public float K0;
    public boolean L;
    public float L0;
    public Drawable M;
    public float M0;
    public float N0;
    public final Context O0;
    public final Paint P0;
    public RippleDrawable Q;
    public final Paint.FontMetrics Q0;
    public final RectF R0;
    public final PointF S0;
    public final Path T0;
    public final TextDrawableHelper U0;
    public int V0;
    public int W0;
    public ColorStateList X;
    public int X0;
    public float Y;
    public int Y0;
    public SpannableStringBuilder Z;
    public int Z0;
    public int a1;
    public boolean b1;
    public int c1;
    public int d1;
    public ColorFilter e1;
    public PorterDuffColorFilter f1;
    public ColorStateList g1;
    public PorterDuff.Mode h1;
    public int[] i1;
    public ColorStateList j1;
    public WeakReference k1;
    public TextUtils.TruncateAt l1;
    public boolean m1;
    public int n1;
    public boolean o1;
    public ColorStateList y;
    public ColorStateList z;

    public interface Delegate {
        void a();
    }

    public ChipDrawable(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, Chip.x);
        this.B = -1.0f;
        this.P0 = new Paint(1);
        this.Q0 = new Paint.FontMetrics();
        this.R0 = new RectF();
        this.S0 = new PointF();
        this.T0 = new Path();
        this.d1 = 255;
        this.h1 = PorterDuff.Mode.SRC_IN;
        this.k1 = new WeakReference(null);
        k(context);
        this.O0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.U0 = textDrawableHelper;
        this.F = "";
        textDrawableHelper.f40640a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = p1;
        setState(iArr);
        if (!Arrays.equals(this.i1, iArr)) {
            this.i1 = iArr;
            if (d0()) {
                G(getState(), iArr);
            }
        }
        this.m1 = true;
        q1.setTint(-1);
    }

    public static boolean D(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean E(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void e0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final float A() {
        if (!c0() && !b0()) {
            return 0.0f;
        }
        float f2 = this.H0;
        Drawable drawable = this.b1 ? this.C0 : this.H;
        float intrinsicWidth = this.J;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f2 + this.I0;
    }

    public final float B() {
        if (d0()) {
            return this.L0 + this.Y + this.M0;
        }
        return 0.0f;
    }

    public final float C() {
        return this.o1 ? i() : this.B;
    }

    public final void F() {
        Delegate delegate = (Delegate) this.k1.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public final boolean G(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.y;
        int iC = c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.V0) : 0);
        boolean state = true;
        if (this.V0 != iC) {
            this.V0 = iC;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.z;
        int iC2 = c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.W0) : 0);
        if (this.W0 != iC2) {
            this.W0 = iC2;
            zOnStateChange = true;
        }
        int iH = ColorUtils.h(iC2, iC);
        if ((this.X0 != iH) | (this.f40974a.f40991c == null)) {
            this.X0 = iH;
            m(ColorStateList.valueOf(iH));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.C;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.Y0) : 0;
        if (this.Y0 != colorForState) {
            this.Y0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.j1 == null || !RippleUtils.d(iArr)) ? 0 : this.j1.getColorForState(iArr, this.Z0);
        if (this.Z0 != colorForState2) {
            this.Z0 = colorForState2;
        }
        TextAppearance textAppearance = this.U0.f40646g;
        int colorForState3 = (textAppearance == null || (colorStateList = textAppearance.f40877j) == null) ? 0 : colorStateList.getColorForState(iArr, this.a1);
        if (this.a1 != colorForState3) {
            this.a1 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z = false;
        } else {
            int length = state2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (state2[i2] != 16842912) {
                    i2++;
                } else if (this.A0) {
                    z = true;
                }
            }
            z = false;
        }
        if (this.b1 == z || this.C0 == null) {
            z2 = false;
        } else {
            float fA = A();
            this.b1 = z;
            if (fA != A()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.g1;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.c1) : 0;
        if (this.c1 != colorForState4) {
            this.c1 = colorForState4;
            ColorStateList colorStateList6 = this.g1;
            PorterDuff.Mode mode = this.h1;
            this.f1 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (E(this.H)) {
            state |= this.H.setState(iArr);
        }
        if (E(this.C0)) {
            state |= this.C0.setState(iArr);
        }
        if (E(this.M)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.M.setState(iArr3);
        }
        if (E(this.Q)) {
            state |= this.Q.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            F();
        }
        return state;
    }

    public final void H(boolean z) {
        if (this.A0 != z) {
            this.A0 = z;
            float fA = A();
            if (!z && this.b1) {
                this.b1 = false;
            }
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void I(Drawable drawable) {
        if (this.C0 != drawable) {
            float fA = A();
            this.C0 = drawable;
            float fA2 = A();
            e0(this.C0);
            y(this.C0);
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            if (this.B0 && (drawable = this.C0) != null && this.A0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z) {
        if (this.B0 != z) {
            boolean zB0 = b0();
            this.B0 = z;
            boolean zB02 = b0();
            if (zB0 != zB02) {
                if (zB02) {
                    y(this.C0);
                } else {
                    e0(this.C0);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void L(float f2) {
        if (this.B != f2) {
            this.B = f2;
            ShapeAppearanceModel.Builder builderG = this.f40974a.f40989a.g();
            builderG.c(f2);
            setShapeAppearanceModel(builderG.a());
        }
    }

    public final void M(Drawable drawable) {
        Drawable drawable2 = this.H;
        Drawable drawableO = drawable2 != null ? DrawableCompat.o(drawable2) : null;
        if (drawableO != drawable) {
            float fA = A();
            this.H = drawable != null ? drawable.mutate() : null;
            float fA2 = A();
            e0(drawableO);
            if (c0()) {
                y(this.H);
            }
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void N(float f2) {
        if (this.J != f2) {
            float fA = A();
            this.J = f2;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void O(ColorStateList colorStateList) {
        this.K = true;
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (c0()) {
                this.H.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void P(boolean z) {
        if (this.G != z) {
            boolean zC0 = c0();
            this.G = z;
            boolean zC02 = c0();
            if (zC0 != zC02) {
                if (zC02) {
                    y(this.H);
                } else {
                    e0(this.H);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (this.o1) {
                t(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void R(float f2) {
        if (this.D != f2) {
            this.D = f2;
            this.P0.setStrokeWidth(f2);
            if (this.o1) {
                u(f2);
            }
            invalidateSelf();
        }
    }

    public final void S(Drawable drawable) {
        Drawable drawable2 = this.M;
        Drawable drawableO = drawable2 != null ? DrawableCompat.o(drawable2) : null;
        if (drawableO != drawable) {
            float fB = B();
            this.M = drawable != null ? drawable.mutate() : null;
            this.Q = new RippleDrawable(RippleUtils.c(this.E), this.M, q1);
            float fB2 = B();
            e0(drawableO);
            if (d0()) {
                y(this.M);
            }
            invalidateSelf();
            if (fB != fB2) {
                F();
            }
        }
    }

    public final void T(float f2) {
        if (this.M0 != f2) {
            this.M0 = f2;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void U(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void V(float f2) {
        if (this.L0 != f2) {
            this.L0 = f2;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            if (d0()) {
                this.M.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void X(boolean z) {
        if (this.L != z) {
            boolean zD0 = d0();
            this.L = z;
            boolean zD02 = d0();
            if (zD0 != zD02) {
                if (zD02) {
                    y(this.M);
                } else {
                    e0(this.M);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Y(float f2) {
        if (this.I0 != f2) {
            float fA = A();
            this.I0 = f2;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void Z(float f2) {
        if (this.H0 != f2) {
            float fA = A();
            this.H0 = f2;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void a() {
        F();
        invalidateSelf();
    }

    public final void a0(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            this.j1 = null;
            onStateChange(getState());
        }
    }

    public final boolean b0() {
        return this.B0 && this.C0 != null && this.b1;
    }

    public final boolean c0() {
        return this.G && this.H != null;
    }

    public final boolean d0() {
        return this.L && this.M != null;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2;
        Canvas canvas2;
        int iSaveLayerAlpha;
        int i3;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i2 = this.d1) == 0) {
            return;
        }
        if (i2 < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i2);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.o1;
        Paint paint = this.P0;
        RectF rectF = this.R0;
        if (!z) {
            paint.setColor(this.V0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C(), C(), paint);
        }
        if (!this.o1) {
            paint.setColor(this.W0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.e1;
            if (colorFilter == null) {
                colorFilter = this.f1;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C(), C(), paint);
        }
        if (this.o1) {
            super.draw(canvas);
        }
        if (this.D > 0.0f && !this.o1) {
            paint.setColor(this.Y0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.o1) {
                ColorFilter colorFilter2 = this.e1;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f1;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f2 = bounds.left;
            float f3 = this.D / 2.0f;
            rectF.set(f2 + f3, bounds.top + f3, bounds.right - f3, bounds.bottom - f3);
            float f4 = this.B - (this.D / 2.0f);
            canvas2.drawRoundRect(rectF, f4, f4, paint);
        }
        paint.setColor(this.Z0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.o1) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.T0;
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.f40974a;
            this.r.a(materialShapeDrawableState.f40989a, materialShapeDrawableState.f40997i, rectF2, this.q, path);
            e(canvas2, paint, path, this.f40974a.f40989a, g());
        } else {
            canvas2.drawRoundRect(rectF, C(), C(), paint);
        }
        if (c0()) {
            z(bounds, rectF);
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas2.translate(f5, f6);
            this.H.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.H.draw(canvas2);
            canvas2.translate(-f5, -f6);
        }
        if (b0()) {
            z(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas2.translate(f7, f8);
            this.C0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.C0.draw(canvas2);
            canvas2.translate(-f7, -f8);
        }
        if (this.m1 && this.F != null) {
            PointF pointF = this.S0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.F;
            TextDrawableHelper textDrawableHelper = this.U0;
            if (charSequence != null) {
                float fA = A() + this.G0 + this.J0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fA;
                } else {
                    pointF.x = bounds.right - fA;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = textDrawableHelper.f40640a;
                Paint.FontMetrics fontMetrics = this.Q0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.F != null) {
                float fA2 = A() + this.G0 + this.J0;
                float fB = B() + this.N0 + this.K0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fA2;
                    rectF.right = bounds.right - fB;
                } else {
                    rectF.left = bounds.left + fB;
                    rectF.right = bounds.right - fA2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            TextAppearance textAppearance = textDrawableHelper.f40646g;
            TextPaint textPaint2 = textDrawableHelper.f40640a;
            if (textAppearance != null) {
                textPaint2.drawableState = getState();
                textDrawableHelper.f40646g.e(this.O0, textPaint2, textDrawableHelper.f40641b);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(textDrawableHelper.a(this.F.toString())) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i3 = iSave;
            } else {
                i3 = 0;
            }
            CharSequence charSequenceEllipsize = this.F;
            if (z2 && this.l1 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.l1);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i3);
            }
        }
        if (d0()) {
            rectF.setEmpty();
            if (d0()) {
                float f9 = this.N0 + this.M0;
                if (getLayoutDirection() == 0) {
                    float f10 = bounds.right - f9;
                    rectF.right = f10;
                    rectF.left = f10 - this.Y;
                } else {
                    float f11 = bounds.left + f9;
                    rectF.left = f11;
                    rectF.right = f11 + this.Y;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f12 = this.Y;
                float f13 = fExactCenterY - (f12 / 2.0f);
                rectF.top = f13;
                rectF.bottom = f13 + f12;
            }
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.M.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Q.setBounds(this.M.getBounds());
            this.Q.jumpToCurrentState();
            this.Q.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.d1 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.d1;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.e1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(B() + this.U0.a(this.F.toString()) + A() + this.G0 + this.J0 + this.K0 + this.N0), this.n1);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.o1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.A, this.B);
        } else {
            outline.setRoundRect(bounds, this.B);
            outline2 = outline;
        }
        outline2.setAlpha(this.d1 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (D(this.y) || D(this.z) || D(this.C)) {
            return true;
        }
        TextAppearance textAppearance = this.U0.f40646g;
        if (textAppearance == null || (colorStateList = textAppearance.f40877j) == null || !colorStateList.isStateful()) {
            return (this.B0 && this.C0 != null && this.A0) || E(this.H) || E(this.C0) || D(this.g1);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i2) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (c0()) {
            zOnLayoutDirectionChanged |= this.H.setLayoutDirection(i2);
        }
        if (b0()) {
            zOnLayoutDirectionChanged |= this.C0.setLayoutDirection(i2);
        }
        if (d0()) {
            zOnLayoutDirectionChanged |= this.M.setLayoutDirection(i2);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        boolean zOnLevelChange = super.onLevelChange(i2);
        if (c0()) {
            zOnLevelChange |= this.H.setLevel(i2);
        }
        if (b0()) {
            zOnLevelChange |= this.C0.setLevel(i2);
        }
        if (d0()) {
            zOnLevelChange |= this.M.setLevel(i2);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        if (this.o1) {
            super.onStateChange(iArr);
        }
        return G(iArr, this.i1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.d1 != i2) {
            this.d1 = i2;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.e1 != colorFilter) {
            this.e1 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.g1 != colorStateList) {
            this.g1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.h1 != mode) {
            this.h1 = mode;
            ColorStateList colorStateList = this.g1;
            this.f1 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (c0()) {
            visible |= this.H.setVisible(z, z2);
        }
        if (b0()) {
            visible |= this.C0.setVisible(z, z2);
        }
        if (d0()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void y(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.M) {
            if (drawable.isStateful()) {
                drawable.setState(this.i1);
            }
            drawable.setTintList(this.X);
            return;
        }
        Drawable drawable2 = this.H;
        if (drawable == drawable2 && this.K) {
            drawable2.setTintList(this.I);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void z(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (c0() || b0()) {
            float f2 = this.G0 + this.H0;
            Drawable drawable = this.b1 ? this.C0 : this.H;
            float intrinsicWidth = this.J;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + intrinsicWidth;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - intrinsicWidth;
            }
            Drawable drawable2 = this.b1 ? this.C0 : this.H;
            float fCeil = this.J;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(ViewUtils.d(24, this.O0));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }
}
