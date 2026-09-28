package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: classes3.dex */
public final class MatchGroup {

    /* renamed from: a, reason: collision with root package name */
    public final String f53983a;

    /* renamed from: b, reason: collision with root package name */
    public final IntRange f53984b;

    public MatchGroup(String value, IntRange range) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        this.f53983a = value;
        this.f53984b = range;
    }

    public final String a() {
        return this.f53983a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.b(this.f53983a, matchGroup.f53983a) && Intrinsics.b(this.f53984b, matchGroup.f53984b);
    }

    public final int hashCode() {
        return this.f53984b.hashCode() + (this.f53983a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f53983a + ", range=" + this.f53984b + ')';
    }
}
