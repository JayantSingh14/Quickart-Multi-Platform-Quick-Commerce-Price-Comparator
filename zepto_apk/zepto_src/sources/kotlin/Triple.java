package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Triple<A, B, C> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f53548a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f53549b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f53550c;

    public Triple(Object obj, Object obj2, Object obj3) {
        this.f53548a = obj;
        this.f53549b = obj2;
        this.f53550c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Intrinsics.b(this.f53548a, triple.f53548a) && Intrinsics.b(this.f53549b, triple.f53549b) && Intrinsics.b(this.f53550c, triple.f53550c);
    }

    public final int hashCode() {
        Object obj = this.f53548a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f53549b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f53550c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f53548a + ", " + this.f53549b + ", " + this.f53550c + ')';
    }
}
