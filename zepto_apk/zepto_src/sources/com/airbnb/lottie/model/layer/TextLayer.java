package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayCompatKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class TextLayer extends BaseLayer {
    public final StringBuilder D;
    public final RectF E;
    public final Matrix F;
    public final Paint G;
    public final Paint H;
    public final HashMap I;
    public final LongSparseArray J;
    public final ArrayList K;
    public final TextKeyframeAnimation L;
    public final LottieDrawable M;
    public final LottieComposition N;
    public final TextRangeUnits O;
    public final ColorKeyframeAnimation P;
    public ValueCallbackKeyframeAnimation Q;
    public final ColorKeyframeAnimation R;
    public ValueCallbackKeyframeAnimation S;
    public final FloatKeyframeAnimation T;
    public ValueCallbackKeyframeAnimation U;
    public final FloatKeyframeAnimation V;
    public ValueCallbackKeyframeAnimation W;
    public final IntegerKeyframeAnimation X;
    public ValueCallbackKeyframeAnimation Y;
    public ValueCallbackKeyframeAnimation Z;
    public final IntegerKeyframeAnimation a0;
    public final IntegerKeyframeAnimation b0;
    public final IntegerKeyframeAnimation c0;

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$1, reason: invalid class name */
    public class AnonymousClass1 extends Paint {
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$2, reason: invalid class name */
    public class AnonymousClass2 extends Paint {
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14658a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f14658a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14658a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14658a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class TextSubLine {

        /* renamed from: a, reason: collision with root package name */
        public String f14659a;

        /* renamed from: b, reason: collision with root package name */
        public float f14660b;
    }

    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        AnimatableTextRangeSelector animatableTextRangeSelector;
        AnimatableTextRangeSelector animatableTextRangeSelector2;
        AnimatableIntegerValue animatableIntegerValue;
        AnimatableTextRangeSelector animatableTextRangeSelector3;
        AnimatableIntegerValue animatableIntegerValue2;
        AnimatableTextRangeSelector animatableTextRangeSelector4;
        AnimatableIntegerValue animatableIntegerValue3;
        AnimatableTextStyle animatableTextStyle;
        AnimatableIntegerValue animatableIntegerValue4;
        AnimatableTextStyle animatableTextStyle2;
        AnimatableFloatValue animatableFloatValue;
        AnimatableTextStyle animatableTextStyle3;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableTextStyle animatableTextStyle4;
        AnimatableColorValue animatableColorValue;
        AnimatableTextStyle animatableTextStyle5;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(1);
        anonymousClass1.setStyle(Paint.Style.FILL);
        this.G = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(1);
        anonymousClass2.setStyle(Paint.Style.STROKE);
        this.H = anonymousClass2;
        this.I = new HashMap();
        this.J = new LongSparseArray();
        this.K = new ArrayList();
        this.O = TextRangeUnits.f14620b;
        this.M = lottieDrawable;
        this.N = layer.f14639b;
        TextKeyframeAnimation textKeyframeAnimationA = layer.q.a();
        this.L = textKeyframeAnimationA;
        textKeyframeAnimationA.a(this);
        g(textKeyframeAnimationA);
        AnimatableTextProperties animatableTextProperties = layer.r;
        if (animatableTextProperties != null && (animatableTextStyle5 = animatableTextProperties.f14479a) != null && (animatableColorValue2 = animatableTextStyle5.f14485a) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA = animatableColorValue2.a();
            this.P = (ColorKeyframeAnimation) baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            g(baseKeyframeAnimationA);
        }
        if (animatableTextProperties != null && (animatableTextStyle4 = animatableTextProperties.f14479a) != null && (animatableColorValue = animatableTextStyle4.f14486b) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA2 = animatableColorValue.a();
            this.R = (ColorKeyframeAnimation) baseKeyframeAnimationA2;
            baseKeyframeAnimationA2.a(this);
            g(baseKeyframeAnimationA2);
        }
        if (animatableTextProperties != null && (animatableTextStyle3 = animatableTextProperties.f14479a) != null && (animatableFloatValue2 = animatableTextStyle3.f14487c) != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA = animatableFloatValue2.a();
            this.T = floatKeyframeAnimationA;
            floatKeyframeAnimationA.a(this);
            g(floatKeyframeAnimationA);
        }
        if (animatableTextProperties != null && (animatableTextStyle2 = animatableTextProperties.f14479a) != null && (animatableFloatValue = animatableTextStyle2.f14488d) != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA2 = animatableFloatValue.a();
            this.V = floatKeyframeAnimationA2;
            floatKeyframeAnimationA2.a(this);
            g(floatKeyframeAnimationA2);
        }
        if (animatableTextProperties != null && (animatableTextStyle = animatableTextProperties.f14479a) != null && (animatableIntegerValue4 = animatableTextStyle.f14489e) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA3 = animatableIntegerValue4.a();
            this.X = (IntegerKeyframeAnimation) baseKeyframeAnimationA3;
            baseKeyframeAnimationA3.a(this);
            g(baseKeyframeAnimationA3);
        }
        if (animatableTextProperties != null && (animatableTextRangeSelector4 = animatableTextProperties.f14480b) != null && (animatableIntegerValue3 = animatableTextRangeSelector4.f14481a) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA4 = animatableIntegerValue3.a();
            this.a0 = (IntegerKeyframeAnimation) baseKeyframeAnimationA4;
            baseKeyframeAnimationA4.a(this);
            g(baseKeyframeAnimationA4);
        }
        if (animatableTextProperties != null && (animatableTextRangeSelector3 = animatableTextProperties.f14480b) != null && (animatableIntegerValue2 = animatableTextRangeSelector3.f14482b) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA5 = animatableIntegerValue2.a();
            this.b0 = (IntegerKeyframeAnimation) baseKeyframeAnimationA5;
            baseKeyframeAnimationA5.a(this);
            g(baseKeyframeAnimationA5);
        }
        if (animatableTextProperties != null && (animatableTextRangeSelector2 = animatableTextProperties.f14480b) != null && (animatableIntegerValue = animatableTextRangeSelector2.f14483c) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA6 = animatableIntegerValue.a();
            this.c0 = (IntegerKeyframeAnimation) baseKeyframeAnimationA6;
            baseKeyframeAnimationA6.a(this);
            g(baseKeyframeAnimationA6);
        }
        if (animatableTextProperties == null || (animatableTextRangeSelector = animatableTextProperties.f14480b) == null) {
            return;
        }
        this.O = animatableTextRangeSelector.f14484d;
    }

    public static void v(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void w(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final List A(String str, float f2, Font font, float f3, float f4, boolean z) {
        float fMeasureText;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (z) {
                int iA = FontCharacter.a(cCharAt, font.f14457a, font.f14459c);
                SparseArrayCompat sparseArrayCompat = this.N.f14142h;
                sparseArrayCompat.getClass();
                FontCharacter fontCharacter = (FontCharacter) SparseArrayCompatKt.a(sparseArrayCompat, iA);
                if (fontCharacter != null) {
                    fMeasureText = (Utils.c() * ((float) fontCharacter.f14463c) * f3) + f4;
                }
            } else {
                fMeasureText = this.G.measureText(str.substring(i5, i5 + 1)) + f4;
            }
            if (cCharAt == ' ') {
                z2 = true;
                f7 = fMeasureText;
            } else if (z2) {
                z2 = false;
                i4 = i5;
                f6 = fMeasureText;
            } else {
                f6 += fMeasureText;
            }
            f5 += fMeasureText;
            if (f2 > 0.0f && f5 >= f2 && cCharAt != ' ') {
                i2++;
                TextSubLine textSubLineX = x(i2);
                if (i4 == i3) {
                    textSubLineX.f14659a = str.substring(i3, i5).trim();
                    textSubLineX.f14660b = (f5 - fMeasureText) - ((r10.length() - r8.length()) * f7);
                    i3 = i5;
                    i4 = i3;
                    f5 = fMeasureText;
                    f6 = f5;
                } else {
                    textSubLineX.f14659a = str.substring(i3, i4 - 1).trim();
                    textSubLineX.f14660b = ((f5 - f6) - ((r8.length() - r14.length()) * f7)) - f7;
                    f5 = f6;
                    i3 = i4;
                }
            }
        }
        if (f5 > 0.0f) {
            i2++;
            TextSubLine textSubLineX2 = x(i2);
            textSubLineX2.f14659a = str.substring(i3);
            textSubLineX2.f14660b = f5;
        }
        return this.K.subList(0, i2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        PointF pointF = LottieProperty.f14178a;
        if (colorFilter == 1) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.Q;
            if (valueCallbackKeyframeAnimation != null) {
                q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.Q = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            g(this.Q);
            return;
        }
        if (colorFilter == 2) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = this.S;
            if (valueCallbackKeyframeAnimation3 != null) {
                q(valueCallbackKeyframeAnimation3);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.S = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            g(this.S);
            return;
        }
        if (colorFilter == LottieProperty.n) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = this.U;
            if (valueCallbackKeyframeAnimation5 != null) {
                q(valueCallbackKeyframeAnimation5);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.U = valueCallbackKeyframeAnimation6;
            valueCallbackKeyframeAnimation6.a(this);
            g(this.U);
            return;
        }
        if (colorFilter == LottieProperty.o) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation7 = this.W;
            if (valueCallbackKeyframeAnimation7 != null) {
                q(valueCallbackKeyframeAnimation7);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation8 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.W = valueCallbackKeyframeAnimation8;
            valueCallbackKeyframeAnimation8.a(this);
            g(this.W);
            return;
        }
        if (colorFilter == LottieProperty.A) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation9 = this.Y;
            if (valueCallbackKeyframeAnimation9 != null) {
                q(valueCallbackKeyframeAnimation9);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation10 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.Y = valueCallbackKeyframeAnimation10;
            valueCallbackKeyframeAnimation10.a(this);
            g(this.Y);
            return;
        }
        if (colorFilter != LottieProperty.H) {
            if (colorFilter == LottieProperty.J) {
                this.L.l(lottieValueCallback);
                return;
            }
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation11 = this.Z;
        if (valueCallbackKeyframeAnimation11 != null) {
            q(valueCallbackKeyframeAnimation11);
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation12 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        this.Z = valueCallbackKeyframeAnimation12;
        valueCallbackKeyframeAnimation12.a(this);
        g(this.Z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        super.f(rectF, matrix, z);
        LottieComposition lottieComposition = this.N;
        rectF.set(0.0f, 0.0f, lottieComposition.f14145k.width(), lottieComposition.f14145k.height());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02d1  */
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.graphics.Canvas r32, android.graphics.Matrix r33, int r34) {
        /*
            Method dump skipped, instructions count: 1364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.l(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void u(DocumentData documentData, int i2, int i3) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.Q;
        Paint paint = this.G;
        if (valueCallbackKeyframeAnimation != null) {
            paint.setColor(((Integer) valueCallbackKeyframeAnimation.f()).intValue());
        } else {
            ColorKeyframeAnimation colorKeyframeAnimation = this.P;
            if (colorKeyframeAnimation == null || !y(i3)) {
                paint.setColor(documentData.f14449h);
            } else {
                paint.setColor(((Integer) colorKeyframeAnimation.f()).intValue());
            }
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.S;
        Paint paint2 = this.H;
        if (valueCallbackKeyframeAnimation2 != null) {
            paint2.setColor(((Integer) valueCallbackKeyframeAnimation2.f()).intValue());
        } else {
            ColorKeyframeAnimation colorKeyframeAnimation2 = this.R;
            if (colorKeyframeAnimation2 == null || !y(i3)) {
                paint2.setColor(documentData.f14450i);
            } else {
                paint2.setColor(((Integer) colorKeyframeAnimation2.f()).intValue());
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation = this.w.f14389j;
        int iIntValue = 100;
        int iIntValue2 = baseKeyframeAnimation == null ? 100 : ((Integer) baseKeyframeAnimation.f()).intValue();
        IntegerKeyframeAnimation integerKeyframeAnimation = this.X;
        if (integerKeyframeAnimation != null && y(i3)) {
            iIntValue = ((Integer) integerKeyframeAnimation.f()).intValue();
        }
        int iRound = Math.round((((iIntValue / 100.0f) * ((iIntValue2 * 255.0f) / 100.0f)) * i2) / 255.0f);
        paint.setAlpha(iRound);
        paint2.setAlpha(iRound);
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = this.U;
        if (valueCallbackKeyframeAnimation3 != null) {
            paint2.setStrokeWidth(((Float) valueCallbackKeyframeAnimation3.f()).floatValue());
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.T;
        if (floatKeyframeAnimation == null || !y(i3)) {
            paint2.setStrokeWidth(Utils.c() * documentData.f14451j);
        } else {
            paint2.setStrokeWidth(((Float) floatKeyframeAnimation.f()).floatValue());
        }
    }

    public final TextSubLine x(int i2) {
        ArrayList arrayList = this.K;
        for (int size = arrayList.size(); size < i2; size++) {
            TextSubLine textSubLine = new TextSubLine();
            textSubLine.f14659a = "";
            textSubLine.f14660b = 0.0f;
            arrayList.add(textSubLine);
        }
        return (TextSubLine) arrayList.get(i2 - 1);
    }

    public final boolean y(int i2) {
        IntegerKeyframeAnimation integerKeyframeAnimation;
        int length = ((DocumentData) this.L.f()).f14442a.length();
        IntegerKeyframeAnimation integerKeyframeAnimation2 = this.a0;
        if (integerKeyframeAnimation2 == null || (integerKeyframeAnimation = this.b0) == null) {
            return true;
        }
        int iMin = Math.min(((Integer) integerKeyframeAnimation2.f()).intValue(), ((Integer) integerKeyframeAnimation.f()).intValue());
        int iMax = Math.max(((Integer) integerKeyframeAnimation2.f()).intValue(), ((Integer) integerKeyframeAnimation.f()).intValue());
        IntegerKeyframeAnimation integerKeyframeAnimation3 = this.c0;
        if (integerKeyframeAnimation3 != null) {
            int iIntValue = ((Integer) integerKeyframeAnimation3.f()).intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.O == TextRangeUnits.f14620b) {
            return i2 >= iMin && i2 < iMax;
        }
        float f2 = (i2 / length) * 100.0f;
        return f2 >= ((float) iMin) && f2 < ((float) iMax);
    }

    public final boolean z(Canvas canvas, DocumentData documentData, int i2, float f2) {
        PointF pointF = documentData.f14453l;
        PointF pointF2 = documentData.f14454m;
        float fC = Utils.c();
        float f3 = (i2 * documentData.f14447f * fC) + (pointF == null ? 0.0f : (documentData.f14447f * fC) + pointF.y);
        if (this.M.x && pointF2 != null && pointF != null && f3 >= pointF.y + pointF2.y + documentData.f14444c) {
            return false;
        }
        float f4 = pointF == null ? 0.0f : pointF.x;
        float f5 = pointF2 != null ? pointF2.x : 0.0f;
        int iOrdinal = documentData.f14445d.ordinal();
        if (iOrdinal == 0) {
            canvas.translate(f4, f3);
            return true;
        }
        if (iOrdinal == 1) {
            canvas.translate((f4 + f5) - f2, f3);
            return true;
        }
        if (iOrdinal != 2) {
            return true;
        }
        canvas.translate(((f5 / 2.0f) + f4) - (f2 / 2.0f), f3);
        return true;
    }
}
