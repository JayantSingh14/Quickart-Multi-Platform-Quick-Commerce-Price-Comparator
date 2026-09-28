package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MaskKeyframeAnimation {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14357a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f14358b;

    /* renamed from: c, reason: collision with root package name */
    public final List f14359c;

    public MaskKeyframeAnimation(List list) {
        this.f14359c = list;
        this.f14357a = new ArrayList(list.size());
        this.f14358b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f14357a.add(((Mask) list.get(i2)).f14538b.a());
            this.f14358b.add(((Mask) list.get(i2)).f14539c.a());
        }
    }
}
