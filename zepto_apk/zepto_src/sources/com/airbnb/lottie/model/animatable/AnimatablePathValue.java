package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14476a;

    public AnimatablePathValue(ArrayList arrayList) {
        this.f14476a = arrayList;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation a() {
        ArrayList arrayList = this.f14476a;
        return ((Keyframe) arrayList.get(0)).c() ? new PointKeyframeAnimation(arrayList) : new PathKeyframeAnimation(arrayList);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final List b() {
        return this.f14476a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final boolean c() {
        ArrayList arrayList = this.f14476a;
        return arrayList.size() == 1 && ((Keyframe) arrayList.get(0)).c();
    }
}
