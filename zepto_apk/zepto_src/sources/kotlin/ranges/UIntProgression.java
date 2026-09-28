package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public class UIntProgression implements Iterable<UInt>, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53857d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f53858a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53859b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53860c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public UIntProgression(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f53858a = i2;
        if (i4 > 0) {
            if (Integer.compare(i2 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) < 0) {
                UInt.Companion companion = UInt.f53556b;
                i3 -= UProgressionUtilKt.a(i3, i2, i4);
            }
        } else {
            if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Integer.compare(i2 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) > 0) {
                UInt.Companion companion2 = UInt.f53556b;
                i3 += UProgressionUtilKt.a(i2, i3, -i4);
            }
        }
        this.f53859b = i3;
        this.f53860c = i4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UIntProgression)) {
            return false;
        }
        if (isEmpty() && ((UIntProgression) obj).isEmpty()) {
            return true;
        }
        UIntProgression uIntProgression = (UIntProgression) obj;
        return this.f53858a == uIntProgression.f53858a && this.f53859b == uIntProgression.f53859b && this.f53860c == uIntProgression.f53860c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f53858a * 31) + this.f53859b) * 31) + this.f53860c;
    }

    public boolean isEmpty() {
        int i2 = this.f53860c;
        int i3 = this.f53859b;
        int i4 = this.f53858a;
        return i2 > 0 ? Integer.compare(i4 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) > 0 : Integer.compare(i4 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(this.f53858a, this.f53859b, this.f53860c, null);
    }

    public String toString() {
        StringBuilder sb;
        int i2 = this.f53859b;
        int i3 = this.f53858a;
        int i4 = this.f53860c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append((Object) UInt.a(i3));
            sb.append("..");
            sb.append((Object) UInt.a(i2));
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append((Object) UInt.a(i3));
            sb.append(" downTo ");
            sb.append((Object) UInt.a(i2));
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
