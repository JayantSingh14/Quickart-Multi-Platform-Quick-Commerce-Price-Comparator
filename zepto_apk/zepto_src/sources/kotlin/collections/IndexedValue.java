package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class IndexedValue<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f53612a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f53613b;

    public IndexedValue(int i2, Object obj) {
        this.f53612a = i2;
        this.f53613b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f53612a == indexedValue.f53612a && Intrinsics.b(this.f53613b, indexedValue.f53613b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f53612a) * 31;
        Object obj = this.f53613b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f53612a + ", value=" + this.f53613b + ')';
    }
}
