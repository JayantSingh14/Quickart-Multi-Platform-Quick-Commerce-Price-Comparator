package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Function0 f53545a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f53546b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f53547c;

    public SynchronizedLazyImpl(Function0 initializer, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        obj = (i2 & 2) != 0 ? null : obj;
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f53545a = initializer;
        this.f53546b = UNINITIALIZED_VALUE.f53566a;
        this.f53547c = obj == null ? this : obj;
    }

    @Override // kotlin.Lazy
    public final boolean d() {
        return this.f53546b != UNINITIALIZED_VALUE.f53566a;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f53546b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f53566a;
        if (obj != uninitialized_value) {
            return obj;
        }
        synchronized (this.f53547c) {
            objInvoke = this.f53546b;
            if (objInvoke == uninitialized_value) {
                Function0 function0 = this.f53545a;
                Intrinsics.c(function0);
                objInvoke = function0.invoke();
                this.f53546b = objInvoke;
                this.f53545a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
