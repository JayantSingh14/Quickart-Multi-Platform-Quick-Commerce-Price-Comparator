package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class IntRange extends IntProgression implements ClosedRange<Integer>, OpenEndRange<Integer> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f53845e = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final IntRange f53846f = new IntRange(1, 0, 1);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return Integer.valueOf(this.f53838a);
    }

    public final boolean c1(int i2) {
        return this.f53838a <= i2 && i2 <= this.f53839b;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return Integer.valueOf(this.f53839b);
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRange = (IntRange) obj;
        if (this.f53838a == intRange.f53838a) {
            return this.f53839b == intRange.f53839b;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f53838a * 31) + this.f53839b;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean isEmpty() {
        return this.f53838a > this.f53839b;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        return this.f53838a + ".." + this.f53839b;
    }
}
