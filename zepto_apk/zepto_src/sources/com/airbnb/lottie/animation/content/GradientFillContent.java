package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a, reason: collision with root package name */
    public final String f14259a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14260b;

    /* renamed from: c, reason: collision with root package name */
    public final BaseLayer f14261c;

    /* renamed from: d, reason: collision with root package name */
    public final LongSparseArray f14262d = new LongSparseArray();

    /* renamed from: e, reason: collision with root package name */
    public final LongSparseArray f14263e = new LongSparseArray();

    /* renamed from: f, reason: collision with root package name */
    public final Path f14264f;

    /* renamed from: g, reason: collision with root package name */
    public final LPaint f14265g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f14266h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f14267i;

    /* renamed from: j, reason: collision with root package name */
    public final GradientType f14268j;

    /* renamed from: k, reason: collision with root package name */
    public final GradientColorKeyframeAnimation f14269k;

    /* renamed from: l, reason: collision with root package name */
    public final IntegerKeyframeAnimation f14270l;

    /* renamed from: m, reason: collision with root package name */
    public final PointKeyframeAnimation f14271m;
    public final PointKeyframeAnimation n;
    public ValueCallbackKeyframeAnimation o;
    public ValueCallbackKeyframeAnimation p;
    public final LottieDrawable q;
    public final int r;
    public BaseKeyframeAnimation s;
    public float t;
    public final DropShadowKeyframeAnimation u;

    public GradientFillContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.f14264f = path;
        this.f14265g = new LPaint(1);
        this.f14266h = new RectF();
        this.f14267i = new ArrayList();
        this.t = 0.0f;
        this.f14261c = baseLayer;
        this.f14259a = gradientFill.f14515g;
        this.f14260b = gradientFill.f14516h;
        this.q = lottieDrawable;
        this.f14268j = gradientFill.f14509a;
        path.setFillType(gradientFill.f14510b);
        this.r = (int) (lottieComposition.b() / 32.0f);
        BaseKeyframeAnimation baseKeyframeAnimationA = gradientFill.f14511c.a();
        this.f14269k = (GradientColorKeyframeAnimation) baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.g(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = gradientFill.f14512d.a();
        this.f14270l = (IntegerKeyframeAnimation) baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.g(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = gradientFill.f14513e.a();
        this.f14271m = (PointKeyframeAnimation) baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.g(baseKeyframeAnimationA3);
        BaseKeyframeAnimation baseKeyframeAnimationA4 = gradientFill.f14514f.a();
        this.n = (PointKeyframeAnimation) baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        baseLayer.g(baseKeyframeAnimationA4);
        if (baseLayer.m() != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA = baseLayer.m().f14501a.a();
            this.s = floatKeyframeAnimationA;
            floatKeyframeAnimationA.a(this);
            baseLayer.g(this.s);
        }
        if (baseLayer.n() != null) {
            this.u = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.n());
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = (Content) list2.get(i2);
            if (content instanceof PathContent) {
                this.f14267i.add((PathContent) content);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        PointF pointF = LottieProperty.f14178a;
        if (colorFilter == 4) {
            this.f14270l.k(lottieValueCallback);
            return;
        }
        ColorFilter colorFilter2 = LottieProperty.F;
        BaseLayer baseLayer = this.f14261c;
        if (colorFilter == colorFilter2) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.o;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.o = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseLayer.g(this.o);
            return;
        }
        if (colorFilter == LottieProperty.G) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = this.p;
            if (valueCallbackKeyframeAnimation3 != null) {
                baseLayer.q(valueCallbackKeyframeAnimation3);
            }
            this.f14262d.a();
            this.f14263e.a();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.p = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            baseLayer.g(this.p);
            return;
        }
        if (colorFilter == LottieProperty.f14182e) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.k(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.s = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.a(this);
            baseLayer.g(this.s);
            return;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.u;
        if (colorFilter == 5 && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14345c.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.B && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.c(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.C && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14347e.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.D && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14348f.k(lottieValueCallback);
        } else {
            if (colorFilter != LottieProperty.E || dropShadowKeyframeAnimation == null) {
                return;
            }
            dropShadowKeyframeAnimation.f14349g.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.f14264f;
        path.reset();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14267i;
            if (i2 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((PathContent) arrayList.get(i2)).j(), matrix);
                i2++;
            }
        }
    }

    public final int[] g(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.p;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14259a;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        Shader radialGradient;
        if (this.f14260b) {
            return;
        }
        NetworkFetcher networkFetcher = L.f14106a;
        Path path = this.f14264f;
        path.reset();
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f14267i;
            if (i3 >= arrayList.size()) {
                break;
            }
            path.addPath(((PathContent) arrayList.get(i3)).j(), matrix);
            i3++;
        }
        path.computeBounds(this.f14266h, false);
        GradientType gradientType = GradientType.f14530a;
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = this.f14269k;
        PointKeyframeAnimation pointKeyframeAnimation = this.n;
        PointKeyframeAnimation pointKeyframeAnimation2 = this.f14271m;
        if (this.f14268j == gradientType) {
            long jI = i();
            LongSparseArray longSparseArray = this.f14262d;
            shader = (LinearGradient) longSparseArray.c(jI);
            if (shader == null) {
                PointF pointF = (PointF) pointKeyframeAnimation2.f();
                PointF pointF2 = (PointF) pointKeyframeAnimation.f();
                GradientColor gradientColor = (GradientColor) gradientColorKeyframeAnimation.f();
                radialGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, g(gradientColor.f14508b), gradientColor.f14507a, Shader.TileMode.CLAMP);
                longSparseArray.g(jI, radialGradient);
                shader = radialGradient;
            }
        } else {
            long jI2 = i();
            LongSparseArray longSparseArray2 = this.f14263e;
            shader = (RadialGradient) longSparseArray2.c(jI2);
            if (shader == null) {
                PointF pointF3 = (PointF) pointKeyframeAnimation2.f();
                PointF pointF4 = (PointF) pointKeyframeAnimation.f();
                GradientColor gradientColor2 = (GradientColor) gradientColorKeyframeAnimation.f();
                int[] iArrG = g(gradientColor2.f14508b);
                float f2 = pointF3.x;
                float f3 = pointF3.y;
                float fHypot = (float) Math.hypot(pointF4.x - f2, pointF4.y - f3);
                if (fHypot <= 0.0f) {
                    fHypot = 0.001f;
                }
                radialGradient = new RadialGradient(f2, f3, fHypot, iArrG, gradientColor2.f14507a, Shader.TileMode.CLAMP);
                longSparseArray2.g(jI2, radialGradient);
                shader = radialGradient;
            }
        }
        shader.setLocalMatrix(matrix);
        LPaint lPaint = this.f14265g;
        lPaint.setShader(shader);
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.o;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.f());
        }
        BaseKeyframeAnimation baseKeyframeAnimation = this.s;
        if (baseKeyframeAnimation != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation.f()).floatValue();
            if (fFloatValue == 0.0f) {
                lPaint.setMaskFilter(null);
            } else if (fFloatValue != this.t) {
                lPaint.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.t = fFloatValue;
        }
        float f4 = i2 / 255.0f;
        int iIntValue = (int) (((((Integer) this.f14270l.f()).intValue() * f4) / 100.0f) * 255.0f);
        PointF pointF5 = MiscUtils.f14809a;
        lPaint.setAlpha(Math.max(0, Math.min(255, iIntValue)));
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.u;
        if (dropShadowKeyframeAnimation != null) {
            ThreadLocal threadLocal = Utils.f14810a;
            dropShadowKeyframeAnimation.b(lPaint, matrix, (int) (((f4 * iIntValue) / 255.0f) * 255.0f));
        }
        canvas.drawPath(path, lPaint);
        NetworkFetcher networkFetcher2 = L.f14106a;
    }

    public final int i() {
        float f2 = this.f14271m.f14332d;
        float f3 = this.r;
        int iRound = Math.round(f2 * f3);
        int iRound2 = Math.round(this.n.f14332d * f3);
        int iRound3 = Math.round(this.f14269k.f14332d * f3);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }
}
