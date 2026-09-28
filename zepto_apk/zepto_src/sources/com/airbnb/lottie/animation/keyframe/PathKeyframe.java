package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes3.dex */
public class PathKeyframe extends Keyframe<PointF> {
    public Path q;
    public final Keyframe r;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe keyframe) {
        super(lottieComposition, (PointF) keyframe.f14816b, (PointF) keyframe.f14817c, keyframe.f14818d, keyframe.f14819e, keyframe.f14820f, keyframe.f14821g, keyframe.f14822h);
        this.r = keyframe;
        d();
    }

    public final void d() {
        Object obj;
        Object obj2 = this.f14817c;
        Object obj3 = this.f14816b;
        boolean z = (obj2 == null || obj3 == null || !((PointF) obj3).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        if (obj3 == null || (obj = this.f14817c) == null || z) {
            return;
        }
        PointF pointF = (PointF) obj3;
        PointF pointF2 = (PointF) obj;
        Keyframe keyframe = this.r;
        PointF pointF3 = keyframe.o;
        PointF pointF4 = keyframe.p;
        ThreadLocal threadLocal = Utils.f14810a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        this.q = path;
    }
}
