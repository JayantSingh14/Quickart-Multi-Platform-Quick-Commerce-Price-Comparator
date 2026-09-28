package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14323a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f14324b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ShapeTrimPath.Type f14325c;

    /* renamed from: d, reason: collision with root package name */
    public final FloatKeyframeAnimation f14326d;

    /* renamed from: e, reason: collision with root package name */
    public final FloatKeyframeAnimation f14327e;

    /* renamed from: f, reason: collision with root package name */
    public final FloatKeyframeAnimation f14328f;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        shapeTrimPath.getClass();
        this.f14323a = shapeTrimPath.f14615e;
        this.f14325c = shapeTrimPath.f14611a;
        FloatKeyframeAnimation floatKeyframeAnimationA = shapeTrimPath.f14612b.a();
        this.f14326d = floatKeyframeAnimationA;
        FloatKeyframeAnimation floatKeyframeAnimationA2 = shapeTrimPath.f14613c.a();
        this.f14327e = floatKeyframeAnimationA2;
        FloatKeyframeAnimation floatKeyframeAnimationA3 = shapeTrimPath.f14614d.a();
        this.f14328f = floatKeyframeAnimationA3;
        baseLayer.g(floatKeyframeAnimationA);
        baseLayer.g(floatKeyframeAnimationA2);
        baseLayer.g(floatKeyframeAnimationA3);
        floatKeyframeAnimationA.a(this);
        floatKeyframeAnimationA2.a(this);
        floatKeyframeAnimationA3.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14324b;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((BaseKeyframeAnimation.AnimationListener) arrayList.get(i2)).a();
            i2++;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
    }

    public final void d(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f14324b.add(animationListener);
    }
}
