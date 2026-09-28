package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.Queue;
import kotlin.SinceKotlin;

@SinceKotlin
/* loaded from: classes3.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f53768a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f53769b = false;

    /* renamed from: c, reason: collision with root package name */
    public final int f53770c = 4;

    public AdaptedFunctionReference(Object obj) {
        this.f53768a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.f53769b == adaptedFunctionReference.f53769b && this.f53770c == adaptedFunctionReference.f53770c && Intrinsics.b(this.f53768a, adaptedFunctionReference.f53768a) && Queue.class.equals(Queue.class);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return 1;
    }

    public final int hashCode() {
        Object obj = this.f53768a;
        return ((((((((((Queue.class.hashCode() + ((obj != null ? obj.hashCode() : 0) * 31)) * 31) + 96417) * 31) + 1636195860) * 31) + (this.f53769b ? 1231 : 1237)) * 31) + 1) * 31) + this.f53770c;
    }

    public final String toString() {
        Reflection.f53802a.getClass();
        return ReflectionFactory.a(this);
    }
}
