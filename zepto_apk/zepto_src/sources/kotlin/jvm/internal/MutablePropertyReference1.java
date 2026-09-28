package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    @Override // kotlin.reflect.KProperty1
    public final KProperty1.Getter b() {
        return ((KMutableProperty1) getReflected()).b();
    }

    @Override // kotlin.reflect.KMutableProperty1
    public final KMutableProperty1.Setter c() {
        return ((KMutableProperty1) getReflected()).c();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.f53802a.getClass();
        return this;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return get(obj);
    }
}
