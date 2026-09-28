package com.airbnb.lottie.animation.keyframe;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: classes3.dex */
public class TransformKeyframeAnimation {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f14380a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f14381b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f14382c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f14383d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f14384e;

    /* renamed from: f, reason: collision with root package name */
    public BaseKeyframeAnimation f14385f;

    /* renamed from: g, reason: collision with root package name */
    public BaseKeyframeAnimation f14386g;

    /* renamed from: h, reason: collision with root package name */
    public BaseKeyframeAnimation f14387h;

    /* renamed from: i, reason: collision with root package name */
    public BaseKeyframeAnimation f14388i;

    /* renamed from: j, reason: collision with root package name */
    public BaseKeyframeAnimation f14389j;

    /* renamed from: k, reason: collision with root package name */
    public FloatKeyframeAnimation f14390k;

    /* renamed from: l, reason: collision with root package name */
    public FloatKeyframeAnimation f14391l;

    /* renamed from: m, reason: collision with root package name */
    public BaseKeyframeAnimation f14392m;
    public BaseKeyframeAnimation n;
    public final boolean o;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        AnimatablePathValue animatablePathValue = animatableTransform.f14490a;
        this.f14385f = animatablePathValue == null ? null : animatablePathValue.a();
        AnimatableValue animatableValue = animatableTransform.f14491b;
        this.f14386g = animatableValue == null ? null : animatableValue.a();
        AnimatableScaleValue animatableScaleValue = animatableTransform.f14492c;
        this.f14387h = animatableScaleValue == null ? null : animatableScaleValue.a();
        AnimatableFloatValue animatableFloatValue = animatableTransform.f14493d;
        this.f14388i = animatableFloatValue == null ? null : animatableFloatValue.a();
        AnimatableFloatValue animatableFloatValue2 = animatableTransform.f14495f;
        FloatKeyframeAnimation floatKeyframeAnimationA = animatableFloatValue2 == null ? null : animatableFloatValue2.a();
        this.f14390k = floatKeyframeAnimationA;
        this.o = animatableTransform.f14499j;
        if (floatKeyframeAnimationA != null) {
            this.f14381b = new Matrix();
            this.f14382c = new Matrix();
            this.f14383d = new Matrix();
            this.f14384e = new float[9];
        } else {
            this.f14381b = null;
            this.f14382c = null;
            this.f14383d = null;
            this.f14384e = null;
        }
        AnimatableFloatValue animatableFloatValue3 = animatableTransform.f14496g;
        this.f14391l = animatableFloatValue3 == null ? null : animatableFloatValue3.a();
        AnimatableIntegerValue animatableIntegerValue = animatableTransform.f14494e;
        if (animatableIntegerValue != null) {
            this.f14389j = animatableIntegerValue.a();
        }
        AnimatableFloatValue animatableFloatValue4 = animatableTransform.f14497h;
        if (animatableFloatValue4 != null) {
            this.f14392m = animatableFloatValue4.a();
        } else {
            this.f14392m = null;
        }
        AnimatableFloatValue animatableFloatValue5 = animatableTransform.f14498i;
        if (animatableFloatValue5 != null) {
            this.n = animatableFloatValue5.a();
        } else {
            this.n = null;
        }
    }

    public final void a(BaseLayer baseLayer) {
        baseLayer.g(this.f14389j);
        baseLayer.g(this.f14392m);
        baseLayer.g(this.n);
        baseLayer.g(this.f14385f);
        baseLayer.g(this.f14386g);
        baseLayer.g(this.f14387h);
        baseLayer.g(this.f14388i);
        baseLayer.g(this.f14390k);
        baseLayer.g(this.f14391l);
    }

    public final void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.f14389j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f14392m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.f14385f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.f14386g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.f14387h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.f14388i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f14390k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f14391l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(animationListener);
        }
    }

    public final boolean c(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        if (colorFilter == LottieProperty.f14178a) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f14385f;
            if (baseKeyframeAnimation == null) {
                this.f14385f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.f14179b) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f14386g;
            if (baseKeyframeAnimation2 == null) {
                this.f14386g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.f14180c) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.f14386g;
            if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3;
                LottieValueCallback lottieValueCallback2 = splitDimensionPathKeyframeAnimation.f14376m;
                splitDimensionPathKeyframeAnimation.f14376m = lottieValueCallback;
                return true;
            }
        }
        if (colorFilter == LottieProperty.f14181d) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.f14386g;
            if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation2 = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4;
                LottieValueCallback lottieValueCallback3 = splitDimensionPathKeyframeAnimation2.n;
                splitDimensionPathKeyframeAnimation2.n = lottieValueCallback;
                return true;
            }
        }
        if (colorFilter == LottieProperty.f14187j) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.f14387h;
            if (baseKeyframeAnimation5 == null) {
                this.f14387h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.f14188k) {
            BaseKeyframeAnimation baseKeyframeAnimation6 = this.f14388i;
            if (baseKeyframeAnimation6 == null) {
                this.f14388i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == 3) {
            BaseKeyframeAnimation baseKeyframeAnimation7 = this.f14389j;
            if (baseKeyframeAnimation7 == null) {
                this.f14389j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.x) {
            BaseKeyframeAnimation baseKeyframeAnimation8 = this.f14392m;
            if (baseKeyframeAnimation8 == null) {
                this.f14392m = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation8.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.y) {
            BaseKeyframeAnimation baseKeyframeAnimation9 = this.n;
            if (baseKeyframeAnimation9 == null) {
                this.n = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation9.k(lottieValueCallback);
            return true;
        }
        if (colorFilter == LottieProperty.f14189l) {
            if (this.f14390k == null) {
                this.f14390k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.f14390k.k(lottieValueCallback);
            return true;
        }
        if (colorFilter != LottieProperty.f14190m) {
            return false;
        }
        if (this.f14391l == null) {
            this.f14391l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
        }
        this.f14391l.k(lottieValueCallback);
        return true;
    }

    public final void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f14384e[i2] = 0.0f;
        }
    }

    public final Matrix e() {
        PointF pointF;
        ScaleXY scaleXY;
        PointF pointF2;
        Matrix matrix = this.f14380a;
        matrix.reset();
        BaseKeyframeAnimation baseKeyframeAnimation = this.f14386g;
        if (baseKeyframeAnimation != null && (pointF2 = (PointF) baseKeyframeAnimation.f()) != null) {
            float f2 = pointF2.x;
            if (f2 != 0.0f || pointF2.y != 0.0f) {
                matrix.preTranslate(f2, pointF2.y);
            }
        }
        if (!this.o) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f14388i;
            if (baseKeyframeAnimation2 != null) {
                float fFloatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? ((Float) baseKeyframeAnimation2.f()).floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).l();
                if (fFloatValue != 0.0f) {
                    matrix.preRotate(fFloatValue);
                }
            }
        } else if (baseKeyframeAnimation != null) {
            float f3 = baseKeyframeAnimation.f14332d;
            PointF pointF3 = (PointF) baseKeyframeAnimation.f();
            float f4 = pointF3.x;
            float f5 = pointF3.y;
            baseKeyframeAnimation.j(1.0E-4f + f3);
            PointF pointF4 = (PointF) baseKeyframeAnimation.f();
            baseKeyframeAnimation.j(f3);
            matrix.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f5, pointF4.x - f4)));
        }
        if (this.f14390k != null) {
            float fCos = this.f14391l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r4.l()) + 90.0f));
            float fSin = this.f14391l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r6.l()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r1.l()));
            d();
            float[] fArr = this.f14384e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f6 = -fSin;
            fArr[3] = f6;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.f14381b;
            matrix2.setValues(fArr);
            d();
            fArr[0] = 1.0f;
            fArr[3] = fTan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.f14382c;
            matrix3.setValues(fArr);
            d();
            fArr[0] = fCos;
            fArr[1] = f6;
            fArr[3] = fSin;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.f14383d;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f14387h;
        if (baseKeyframeAnimation3 != null && (scaleXY = (ScaleXY) baseKeyframeAnimation3.f()) != null) {
            float f7 = scaleXY.f14838a;
            if (f7 != 1.0f || scaleXY.f14839b != 1.0f) {
                matrix.preScale(f7, scaleXY.f14839b);
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.f14385f;
        if (baseKeyframeAnimation4 != null && (pointF = (PointF) baseKeyframeAnimation4.f()) != null) {
            float f8 = pointF.x;
            if (f8 != 0.0f || pointF.y != 0.0f) {
                matrix.preTranslate(-f8, -pointF.y);
            }
        }
        return matrix;
    }

    public final Matrix f(float f2) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.f14386g;
        PointF pointF = baseKeyframeAnimation == null ? null : (PointF) baseKeyframeAnimation.f();
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f14387h;
        ScaleXY scaleXY = baseKeyframeAnimation2 == null ? null : (ScaleXY) baseKeyframeAnimation2.f();
        Matrix matrix = this.f14380a;
        matrix.reset();
        if (pointF != null) {
            matrix.preTranslate(pointF.x * f2, pointF.y * f2);
        }
        if (scaleXY != null) {
            double d2 = f2;
            matrix.preScale((float) Math.pow(scaleXY.f14838a, d2), (float) Math.pow(scaleXY.f14839b, d2));
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f14388i;
        if (baseKeyframeAnimation3 != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation3.f()).floatValue();
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.f14385f;
            PointF pointF2 = baseKeyframeAnimation4 != null ? (PointF) baseKeyframeAnimation4.f() : null;
            matrix.preRotate(fFloatValue * f2, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return matrix;
    }
}
