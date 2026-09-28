package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a, reason: collision with root package name */
    public final List f14500a;

    public BaseAnimatableValue(List list) {
        this.f14500a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List b() {
        return this.f14500a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        List list = this.f14500a;
        return list.isEmpty() || (list.size() == 1 && ((Keyframe) list.get(0)).c());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List list = this.f14500a;
        if (!list.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(list.toArray()));
        }
        return sb.toString();
    }
}
