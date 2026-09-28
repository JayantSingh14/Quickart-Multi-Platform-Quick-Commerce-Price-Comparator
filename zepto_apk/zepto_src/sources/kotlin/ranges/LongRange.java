package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class LongRange extends LongProgression implements ClosedRange<Long>, OpenEndRange<Long> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f53855e = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final LongRange f53856f = new LongRange(1, 0);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public LongRange(long j2, long j3) {
        super(j2, j3, 1L);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return Long.valueOf(this.f53848a);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return Long.valueOf(this.f53849b);
    }

    @Override // kotlin.ranges.LongProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof LongRange)) {
            return false;
        }
        if (isEmpty() && ((LongRange) obj).isEmpty()) {
            return true;
        }
        LongRange longRange = (LongRange) obj;
        if (this.f53848a == longRange.f53848a) {
            return this.f53849b == longRange.f53849b;
        }
        return false;
    }

    @Override // kotlin.ranges.LongProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.f53848a;
        long j3 = 31 * (j2 ^ (j2 >>> 32));
        long j4 = this.f53849b;
        return (int) (j3 + (j4 ^ (j4 >>> 32)));
    }

    @Override // kotlin.ranges.LongProgression
    public final boolean isEmpty() {
        return this.f53848a > this.f53849b;
    }

    @Override // kotlin.ranges.LongProgression
    public final String toString() {
        return this.f53848a + ".." + this.f53849b;
    }
}
