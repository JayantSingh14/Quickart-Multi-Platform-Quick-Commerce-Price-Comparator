package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Pair<A, B> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f53533a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f53534b;

    public Pair(Object obj, Object obj2) {
        this.f53533a = obj;
        this.f53534b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.b(this.f53533a, pair.f53533a) && Intrinsics.b(this.f53534b, pair.f53534b);
    }

    public final int hashCode() {
        Object obj = this.f53533a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f53534b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f53533a + ", " + this.f53534b + ')';
    }
}
