package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class CharRange extends CharProgression implements ClosedRange<Character>, OpenEndRange<Character> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f53836e = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new CharRange((char) 1, (char) 0);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return Character.valueOf(this.f53829a);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return Character.valueOf(this.f53830b);
    }

    @Override // kotlin.ranges.CharProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof CharRange)) {
            return false;
        }
        if (isEmpty() && ((CharRange) obj).isEmpty()) {
            return true;
        }
        CharRange charRange = (CharRange) obj;
        return this.f53829a == charRange.f53829a && this.f53830b == charRange.f53830b;
    }

    @Override // kotlin.ranges.CharProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f53829a * 31) + this.f53830b;
    }

    @Override // kotlin.ranges.CharProgression
    public final boolean isEmpty() {
        return Intrinsics.e(this.f53829a, this.f53830b) > 0;
    }

    @Override // kotlin.ranges.CharProgression
    public final String toString() {
        return this.f53829a + ".." + this.f53830b;
    }
}
