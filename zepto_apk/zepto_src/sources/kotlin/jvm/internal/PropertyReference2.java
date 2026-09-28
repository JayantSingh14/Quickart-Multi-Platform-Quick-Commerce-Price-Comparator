package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

/* loaded from: classes.dex */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    @Override // kotlin.reflect.KProperty2
    public final KProperty2.Getter b() {
        return ((KProperty2) getReflected()).b();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.f53802a.getClass();
        return this;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PropertyReference2Impl) this).b().call(obj, obj2);
    }
}
