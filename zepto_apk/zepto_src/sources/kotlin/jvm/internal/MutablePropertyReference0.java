package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    @Override // kotlin.reflect.KProperty0
    public final KProperty0.Getter b() {
        return ((KMutableProperty0) getReflected()).b();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public final KMutableProperty0.Setter c() {
        return ((KMutableProperty0) getReflected()).c();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.f53802a.getClass();
        return this;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return get();
    }
}
