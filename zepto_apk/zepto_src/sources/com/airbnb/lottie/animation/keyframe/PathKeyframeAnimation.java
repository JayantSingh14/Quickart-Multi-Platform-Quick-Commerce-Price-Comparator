package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f14360i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f14361j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f14362k;

    /* renamed from: l, reason: collision with root package name */
    public final PathMeasure f14363l;

    /* renamed from: m, reason: collision with root package name */
    public PathKeyframe f14364m;

    public PathKeyframeAnimation(ArrayList arrayList) {
        super(arrayList);
        this.f14360i = new PointF();
        this.f14361j = new float[2];
        this.f14362k = new float[2];
        this.f14363l = new PathMeasure();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        float f3;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.q;
        LottieValueCallback lottieValueCallback = this.f14333e;
        if (lottieValueCallback == null || keyframe.f14822h == null) {
            f3 = f2;
        } else {
            f3 = f2;
            PointF pointF = (PointF) lottieValueCallback.b(pathKeyframe.f14821g, pathKeyframe.f14822h.floatValue(), (PointF) pathKeyframe.f14816b, (PointF) pathKeyframe.f14817c, e(), f3, this.f14332d);
            if (pointF != null) {
                return pointF;
            }
        }
        if (path == null) {
            return (PointF) keyframe.f14816b;
        }
        PathKeyframe pathKeyframe2 = this.f14364m;
        PathMeasure pathMeasure = this.f14363l;
        if (pathKeyframe2 != pathKeyframe) {
            pathMeasure.setPath(path, false);
            this.f14364m = pathKeyframe;
        }
        float length = pathMeasure.getLength();
        float f4 = f3 * length;
        float[] fArr = this.f14361j;
        float[] fArr2 = this.f14362k;
        pathMeasure.getPosTan(f4, fArr, fArr2);
        PointF pointF2 = this.f14360i;
        pointF2.set(fArr[0], fArr[1]);
        if (f4 < 0.0f) {
            pointF2.offset(fArr2[0] * f4, fArr2[1] * f4);
            return pointF2;
        }
        if (f4 > length) {
            float f5 = f4 - length;
            pointF2.offset(fArr2[0] * f5, fArr2[1] * f5);
        }
        return pointF2;
    }
}
