package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Function0 f53573a;

    /* renamed from: b, reason: collision with root package name */
    public Object f53574b;

    @Override // kotlin.Lazy
    public final boolean d() {
        return this.f53574b != UNINITIALIZED_VALUE.f53566a;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        if (this.f53574b == UNINITIALIZED_VALUE.f53566a) {
            Function0 function0 = this.f53573a;
            Intrinsics.c(function0);
            this.f53574b = function0.invoke();
            this.f53573a = null;
        }
        return this.f53574b;
    }

    public final String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
