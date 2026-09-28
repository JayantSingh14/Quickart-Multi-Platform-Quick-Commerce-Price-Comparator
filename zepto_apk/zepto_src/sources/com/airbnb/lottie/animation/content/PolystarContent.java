package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.v4.media.a;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: e, reason: collision with root package name */
    public final String f14282e;

    /* renamed from: f, reason: collision with root package name */
    public final LottieDrawable f14283f;

    /* renamed from: g, reason: collision with root package name */
    public final PolystarShape.Type f14284g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f14285h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14286i;

    /* renamed from: j, reason: collision with root package name */
    public final FloatKeyframeAnimation f14287j;

    /* renamed from: k, reason: collision with root package name */
    public final BaseKeyframeAnimation f14288k;

    /* renamed from: l, reason: collision with root package name */
    public final FloatKeyframeAnimation f14289l;

    /* renamed from: m, reason: collision with root package name */
    public final FloatKeyframeAnimation f14290m;
    public final FloatKeyframeAnimation n;
    public final FloatKeyframeAnimation o;
    public final FloatKeyframeAnimation p;
    public boolean r;

    /* renamed from: a, reason: collision with root package name */
    public final Path f14278a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f14279b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final PathMeasure f14280c = new PathMeasure();

    /* renamed from: d, reason: collision with root package name */
    public final float[] f14281d = new float[2];
    public final CompoundTrimPathContent q = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14291a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f14291a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14291a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f14283f = lottieDrawable;
        this.f14282e = polystarShape.f14554a;
        PolystarShape.Type type = polystarShape.f14555b;
        this.f14284g = type;
        this.f14285h = polystarShape.f14563j;
        this.f14286i = polystarShape.f14564k;
        FloatKeyframeAnimation floatKeyframeAnimationA = polystarShape.f14556c.a();
        this.f14287j = floatKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA = polystarShape.f14557d.a();
        this.f14288k = baseKeyframeAnimationA;
        FloatKeyframeAnimation floatKeyframeAnimationA2 = polystarShape.f14558e.a();
        this.f14289l = floatKeyframeAnimationA2;
        FloatKeyframeAnimation floatKeyframeAnimationA3 = polystarShape.f14560g.a();
        this.n = floatKeyframeAnimationA3;
        FloatKeyframeAnimation floatKeyframeAnimationA4 = polystarShape.f14562i.a();
        this.p = floatKeyframeAnimationA4;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.f14290m = polystarShape.f14559f.a();
            this.o = polystarShape.f14561h.a();
        } else {
            this.f14290m = null;
            this.o = null;
        }
        baseLayer.g(floatKeyframeAnimationA);
        baseLayer.g(baseKeyframeAnimationA);
        baseLayer.g(floatKeyframeAnimationA2);
        baseLayer.g(floatKeyframeAnimationA3);
        baseLayer.g(floatKeyframeAnimationA4);
        if (type == type2) {
            baseLayer.g(this.f14290m);
            baseLayer.g(this.o);
        }
        floatKeyframeAnimationA.a(this);
        baseKeyframeAnimationA.a(this);
        floatKeyframeAnimationA2.a(this);
        floatKeyframeAnimationA3.a(this);
        floatKeyframeAnimationA4.a(this);
        if (type == type2) {
            this.f14290m.a(this);
            this.o.a(this);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.r = false;
        this.f14283f.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i2 >= arrayList.size()) {
                return;
            }
            Content content = (Content) arrayList.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.f14325c == ShapeTrimPath.Type.f14616a) {
                    this.q.f14226a.add(trimPathContent);
                    trimPathContent.d(this);
                }
            }
            i2++;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (colorFilter == LottieProperty.r) {
            this.f14287j.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.s) {
            this.f14289l.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.f14186i) {
            this.f14288k.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.t && (floatKeyframeAnimation2 = this.f14290m) != null) {
            floatKeyframeAnimation2.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.u) {
            this.n.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.v && (floatKeyframeAnimation = this.o) != null) {
            floatKeyframeAnimation.k(lottieValueCallback);
        } else if (colorFilter == LottieProperty.w) {
            this.p.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14282e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        boolean z;
        float f2;
        double d2;
        float f3;
        float f4;
        double d3;
        float fCos;
        float fSin;
        float f5;
        float f6;
        float f7;
        float f8;
        int i2;
        float f9;
        double d4;
        float f10;
        double d5;
        int i3;
        boolean z2 = this.r;
        Path path = this.f14278a;
        if (z2) {
            return path;
        }
        path.reset();
        if (this.f14285h) {
            this.r = true;
            return path;
        }
        int iOrdinal = this.f14284g.ordinal();
        FloatKeyframeAnimation floatKeyframeAnimation = this.n;
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.p;
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.f14289l;
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.f14287j;
        BaseKeyframeAnimation baseKeyframeAnimation = this.f14288k;
        float f11 = 0.0f;
        if (iOrdinal == 0) {
            z = true;
            boolean z3 = false;
            float fFloatValue = ((Float) floatKeyframeAnimation4.f()).floatValue();
            double radians = Math.toRadians((floatKeyframeAnimation3 != null ? ((Float) floatKeyframeAnimation3.f()).floatValue() : 0.0d) - 90.0d);
            double d6 = fFloatValue;
            float f12 = (float) (6.283185307179586d / d6);
            if (this.f14286i) {
                f12 *= -1.0f;
            }
            float f13 = f12;
            float f14 = f13 / 2.0f;
            float f15 = fFloatValue - ((int) fFloatValue);
            if (f15 != 0.0f) {
                f2 = 100.0f;
                d2 = d6;
                radians += (1.0f - f15) * f14;
            } else {
                f2 = 100.0f;
                d2 = d6;
            }
            float fFloatValue2 = ((Float) floatKeyframeAnimation.f()).floatValue();
            float fFloatValue3 = ((Float) this.f14290m.f()).floatValue();
            FloatKeyframeAnimation floatKeyframeAnimation5 = this.o;
            float fFloatValue4 = floatKeyframeAnimation5 != null ? ((Float) floatKeyframeAnimation5.f()).floatValue() / f2 : 0.0f;
            float fFloatValue5 = floatKeyframeAnimation2 != null ? ((Float) floatKeyframeAnimation2.f()).floatValue() / f2 : 0.0f;
            if (f15 != 0.0f) {
                float fA = a.a(fFloatValue2, fFloatValue3, f15, fFloatValue3);
                double d7 = fA;
                f3 = 2.0f;
                fCos = (float) (Math.cos(radians) * d7);
                fSin = (float) (Math.sin(radians) * d7);
                path.moveTo(fCos, fSin);
                d3 = radians + ((f13 * f15) / 2.0f);
                f5 = fA;
                f4 = f14;
            } else {
                f3 = 2.0f;
                double d8 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d8);
                float fSin2 = (float) (Math.sin(radians) * d8);
                path.moveTo(fCos2, fSin2);
                f4 = f14;
                d3 = radians + f4;
                fCos = fCos2;
                fSin = fSin2;
                f5 = 0.0f;
            }
            double dCeil = Math.ceil(d2) * 2.0d;
            double d9 = d3;
            int i4 = 0;
            while (true) {
                double d10 = i4;
                if (d10 >= dCeil) {
                    break;
                }
                float f16 = z3 ? fFloatValue2 : fFloatValue3;
                if (f5 == f11 || d10 != dCeil - 2.0d) {
                    f6 = f11;
                    f7 = f4;
                } else {
                    f6 = f11;
                    f7 = (f13 * f15) / f3;
                }
                if (f5 != f11 && d10 == dCeil - 1.0d) {
                    f16 = f5;
                }
                double d11 = f16;
                float fCos3 = (float) (Math.cos(d9) * d11);
                float f17 = fFloatValue2;
                float fSin3 = (float) (Math.sin(d9) * d11);
                if (fFloatValue4 == f6 && fFloatValue5 == f6) {
                    path.lineTo(fCos3, fSin3);
                    f8 = f15;
                    i2 = i4;
                    f9 = fCos3;
                } else {
                    f8 = f15;
                    Path path2 = path;
                    float f18 = fSin;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    i2 = i4;
                    float f19 = fCos;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f20 = z3 ? fFloatValue4 : fFloatValue5;
                    float f21 = z3 ? fFloatValue5 : fFloatValue4;
                    float f22 = (z3 ? fFloatValue3 : f17) * f20 * 0.47829f;
                    float f23 = fCos4 * f22;
                    float f24 = f22 * fSin4;
                    float f25 = (z3 ? f17 : fFloatValue3) * f21 * 0.47829f;
                    float f26 = fCos5 * f25;
                    float f27 = f25 * fSin5;
                    if (f15 != 0.0f) {
                        if (i2 == 0) {
                            f23 *= f8;
                            f24 *= f8;
                        } else if (d10 == dCeil - 1.0d) {
                            f26 *= f8;
                            f27 *= f8;
                        }
                    }
                    f9 = fCos3;
                    path = path2;
                    path.cubicTo(f19 - f23, f18 - f24, f26 + fCos3, fSin3 + f27, f9, fSin3);
                }
                d9 += f7;
                z3 = !z3;
                i4 = i2 + 1;
                fCos = f9;
                fSin = fSin3;
                f15 = f8;
                fFloatValue2 = f17;
                f11 = f6;
            }
            PointF pointF = (PointF) baseKeyframeAnimation.f();
            path.offset(pointF.x, pointF.y);
            path.close();
        } else if (iOrdinal != 1) {
            z = true;
        } else {
            int iFloor = (int) Math.floor(((Float) floatKeyframeAnimation4.f()).floatValue());
            double radians2 = Math.toRadians((floatKeyframeAnimation3 != null ? ((Float) floatKeyframeAnimation3.f()).floatValue() : 0.0d) - 90.0d);
            double d12 = iFloor;
            float fFloatValue6 = ((Float) floatKeyframeAnimation2.f()).floatValue() / 100.0f;
            float fFloatValue7 = ((Float) floatKeyframeAnimation.f()).floatValue();
            double d13 = fFloatValue7;
            z = true;
            float fCos6 = (float) (Math.cos(radians2) * d13);
            float fSin6 = (float) (Math.sin(radians2) * d13);
            path.moveTo(fCos6, fSin6);
            double d14 = (float) (6.283185307179586d / d12);
            double dCeil2 = Math.ceil(d12);
            float f28 = fCos6;
            double d15 = radians2 + d14;
            int i5 = 0;
            while (true) {
                double d16 = i5;
                if (d16 >= dCeil2) {
                    break;
                }
                double d17 = d14;
                float fCos7 = (float) (Math.cos(d15) * d13);
                float f29 = fSin6;
                float fSin7 = (float) (Math.sin(d15) * d13);
                if (fFloatValue6 != 0.0f) {
                    f10 = fFloatValue6;
                    Path path3 = path;
                    d4 = d13;
                    double dAtan23 = (float) (Math.atan2(f29, f28) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan23);
                    float fSin8 = (float) Math.sin(dAtan23);
                    double dAtan24 = (float) (Math.atan2(fSin7, fCos7) - 1.5707963267948966d);
                    float f30 = fFloatValue7 * f10 * 0.25f;
                    float f31 = fCos8 * f30;
                    float f32 = f30 * fSin8;
                    float fCos9 = ((float) Math.cos(dAtan24)) * f30;
                    float fSin9 = f30 * ((float) Math.sin(dAtan24));
                    if (d16 == dCeil2 - 1.0d) {
                        Path path4 = this.f14279b;
                        path4.reset();
                        path4.moveTo(f28, f29);
                        float f33 = f28 - f31;
                        float f34 = f29 - f32;
                        float f35 = fCos7 + fCos9;
                        float f36 = fSin7 + fSin9;
                        path4.cubicTo(f33, f34, f35, f36, fCos7, fSin7);
                        PathMeasure pathMeasure = this.f14280c;
                        pathMeasure.setPath(path4, false);
                        float length = pathMeasure.getLength() * 0.9999f;
                        float[] fArr = this.f14281d;
                        pathMeasure.getPosTan(length, fArr, null);
                        d5 = d17;
                        path = path3;
                        i3 = i5;
                        path.cubicTo(f33, f34, f35, f36, fArr[0], fArr[1]);
                        fCos7 = fCos7;
                        fSin7 = fSin7;
                    } else {
                        d5 = d17;
                        path = path3;
                        i3 = i5;
                        path.cubicTo(f28 - f31, f29 - f32, fCos7 + fCos9, fSin7 + fSin9, fCos7, fSin7);
                    }
                } else {
                    d4 = d13;
                    f10 = fFloatValue6;
                    d5 = d17;
                    i3 = i5;
                    if (d16 == dCeil2 - 1.0d) {
                        i5 = i3 + 1;
                        f28 = fCos7;
                        fFloatValue6 = f10;
                        d13 = d4;
                        fSin6 = fSin7;
                        d14 = d5;
                    } else {
                        path.lineTo(fCos7, fSin7);
                    }
                }
                d15 += d5;
                i5 = i3 + 1;
                f28 = fCos7;
                fFloatValue6 = f10;
                d13 = d4;
                fSin6 = fSin7;
                d14 = d5;
            }
            PointF pointF2 = (PointF) baseKeyframeAnimation.f();
            path.offset(pointF2.x, pointF2.y);
            path.close();
        }
        path.close();
        this.q.a(path);
        this.r = z;
        return path;
    }
}
