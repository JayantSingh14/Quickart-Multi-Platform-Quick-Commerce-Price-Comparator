package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53866d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f53867a;

    /* renamed from: b, reason: collision with root package name */
    public final long f53868b;

    /* renamed from: c, reason: collision with root package name */
    public final long f53869c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ULongProgression(long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        long j5;
        long j6;
        long jB;
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f53867a = j2;
        if (j4 <= 0) {
            j5 = j3;
            j6 = j4;
            if (j4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Long.compare(j2 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j5) <= 0) {
                jB = j5;
            } else {
                ULong.Companion companion = ULong.f53561b;
                jB = j5 + UProgressionUtilKt.b(j2, j5, -j6);
            }
        } else if (Long.compare(j2 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j3) >= 0) {
            j5 = j3;
            j6 = j4;
            jB = j5;
        } else {
            ULong.Companion companion2 = ULong.f53561b;
            j6 = j4;
            jB = j3 - UProgressionUtilKt.b(j3, j2, j4);
        }
        this.f53868b = jB;
        this.f53869c = j6;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ULongProgression)) {
            return false;
        }
        if (isEmpty() && ((ULongProgression) obj).isEmpty()) {
            return true;
        }
        ULongProgression uLongProgression = (ULongProgression) obj;
        return this.f53867a == uLongProgression.f53867a && this.f53868b == uLongProgression.f53868b && this.f53869c == uLongProgression.f53869c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = this.f53867a;
        ULong.Companion companion = ULong.f53561b;
        long j3 = this.f53868b;
        int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f53869c;
        return i2 + ((int) ((j4 >>> 32) ^ j4));
    }

    public boolean isEmpty() {
        long j2 = this.f53869c;
        long j3 = this.f53868b;
        long j4 = this.f53867a;
        return j2 > 0 ? Long.compare(j4 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j3) > 0 : Long.compare(j4 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j3) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.f53867a, this.f53868b, this.f53869c, null);
    }

    public String toString() {
        StringBuilder sb;
        long j2 = this.f53869c;
        long j3 = this.f53868b;
        long j4 = this.f53867a;
        if (j2 > 0) {
            sb = new StringBuilder();
            ULong.Companion companion = ULong.f53561b;
            sb.append((Object) UnsignedKt.c(j4));
            sb.append("..");
            sb.append((Object) UnsignedKt.c(j3));
            sb.append(" step ");
        } else {
            sb = new StringBuilder();
            ULong.Companion companion2 = ULong.f53561b;
            sb.append((Object) UnsignedKt.c(j4));
            sb.append(" downTo ");
            sb.append((Object) UnsignedKt.c(j3));
            sb.append(" step ");
            j2 = -j2;
        }
        sb.append(j2);
        return sb.toString();
    }
}
