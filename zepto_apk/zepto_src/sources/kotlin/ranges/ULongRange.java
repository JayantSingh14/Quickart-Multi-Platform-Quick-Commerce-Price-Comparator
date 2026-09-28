package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f53874e = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new ULongRange(-1L, 0L, null);
    }

    public ULongRange(long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        super(j2, j3, 1L, null);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return new ULong(this.f53867a);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return new ULong(this.f53868b);
    }

    @Override // kotlin.ranges.ULongProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof ULongRange)) {
            return false;
        }
        if (isEmpty() && ((ULongRange) obj).isEmpty()) {
            return true;
        }
        ULongRange uLongRange = (ULongRange) obj;
        if (this.f53867a == uLongRange.f53867a) {
            return this.f53868b == uLongRange.f53868b;
        }
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.f53867a;
        ULong.Companion companion = ULong.f53561b;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        long j3 = this.f53868b;
        return i2 + ((int) ((j3 >>> 32) ^ j3));
    }

    @Override // kotlin.ranges.ULongProgression
    public final boolean isEmpty() {
        return Long.compare(this.f53867a ^ Long.MIN_VALUE, Long.MIN_VALUE ^ this.f53868b) > 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        ULong.Companion companion = ULong.f53561b;
        sb.append((Object) UnsignedKt.c(this.f53867a));
        sb.append("..");
        sb.append((Object) UnsignedKt.c(this.f53868b));
        return sb.toString();
    }
}
