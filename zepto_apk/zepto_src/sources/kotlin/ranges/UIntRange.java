package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f53865e = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new UIntRange(-1, 0, null);
    }

    public UIntRange(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        super(i2, i3, 1, null);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return new UInt(this.f53858a);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return new UInt(this.f53859b);
    }

    @Override // kotlin.ranges.UIntProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof UIntRange)) {
            return false;
        }
        if (isEmpty() && ((UIntRange) obj).isEmpty()) {
            return true;
        }
        UIntRange uIntRange = (UIntRange) obj;
        if (this.f53858a == uIntRange.f53858a) {
            return this.f53859b == uIntRange.f53859b;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f53858a * 31) + this.f53859b;
    }

    @Override // kotlin.ranges.UIntProgression
    public final boolean isEmpty() {
        return Integer.compare(this.f53858a ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ this.f53859b) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public final String toString() {
        return ((Object) UInt.a(this.f53858a)) + ".." + ((Object) UInt.a(this.f53859b));
    }
}
