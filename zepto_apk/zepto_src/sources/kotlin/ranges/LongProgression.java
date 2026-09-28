package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53847d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f53848a;

    /* renamed from: b, reason: collision with root package name */
    public final long f53849b;

    /* renamed from: c, reason: collision with root package name */
    public final long f53850c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static LongProgression a(long j2, long j3, long j4) {
            return new LongProgression(j2, j3, j4);
        }
    }

    public LongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f53848a = j2;
        if (j4 > 0) {
            if (j2 < j3) {
                long j5 = j3 % j4;
                long j6 = j2 % j4;
                long j7 = ((j5 < 0 ? j5 + j4 : j5) - (j6 < 0 ? j6 + j4 : j6)) % j4;
                j3 -= j7 < 0 ? j7 + j4 : j7;
            }
        } else {
            if (j4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (j2 > j3) {
                long j8 = -j4;
                long j9 = j2 % j8;
                long j10 = j3 % j8;
                long j11 = ((j9 < 0 ? j9 + j8 : j9) - (j10 < 0 ? j10 + j8 : j10)) % j8;
                j3 += j11 < 0 ? j11 + j8 : j11;
            }
        }
        this.f53849b = j3;
        this.f53850c = j4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongProgression)) {
            return false;
        }
        if (isEmpty() && ((LongProgression) obj).isEmpty()) {
            return true;
        }
        LongProgression longProgression = (LongProgression) obj;
        return this.f53848a == longProgression.f53848a && this.f53849b == longProgression.f53849b && this.f53850c == longProgression.f53850c;
    }

    public final long f() {
        return this.f53848a;
    }

    public final long g() {
        return this.f53849b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = 31;
        long j3 = this.f53848a;
        long j4 = this.f53849b;
        long j5 = (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32))) * j2;
        long j6 = this.f53850c;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public final long i() {
        return this.f53850c;
    }

    public boolean isEmpty() {
        long j2 = this.f53850c;
        long j3 = this.f53849b;
        long j4 = this.f53848a;
        return j2 > 0 ? j4 > j3 : j4 < j3;
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new LongProgressionIterator(this.f53848a, this.f53849b, this.f53850c);
    }

    public String toString() {
        StringBuilder sb;
        long j2 = this.f53850c;
        long j3 = this.f53849b;
        long j4 = this.f53848a;
        if (j2 > 0) {
            sb = new StringBuilder();
            sb.append(j4);
            sb.append("..");
            sb.append(j3);
            sb.append(" step ");
            sb.append(j2);
        } else {
            sb = new StringBuilder();
            sb.append(j4);
            sb.append(" downTo ");
            sb.append(j3);
            sb.append(" step ");
            sb.append(-j2);
        }
        return sb.toString();
    }
}
