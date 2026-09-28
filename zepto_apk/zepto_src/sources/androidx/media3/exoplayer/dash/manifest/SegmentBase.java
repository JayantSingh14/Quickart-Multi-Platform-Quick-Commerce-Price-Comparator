package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.manifest.Representation;
import com.google.common.math.BigIntegerMath;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SegmentBase {

    /* renamed from: a, reason: collision with root package name */
    public final RangedUri f6843a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6844b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6845c;

    public static abstract class MultiSegmentBase extends SegmentBase {

        /* renamed from: d, reason: collision with root package name */
        public final long f6846d;

        /* renamed from: e, reason: collision with root package name */
        public final long f6847e;

        /* renamed from: f, reason: collision with root package name */
        public final List f6848f;

        /* renamed from: g, reason: collision with root package name */
        public final long f6849g;

        /* renamed from: h, reason: collision with root package name */
        public final long f6850h;

        /* renamed from: i, reason: collision with root package name */
        public final long f6851i;

        public MultiSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5, List list, long j6, long j7, long j8) {
            super(rangedUri, j2, j3);
            this.f6846d = j4;
            this.f6847e = j5;
            this.f6848f = list;
            this.f6851i = j6;
            this.f6849g = j7;
            this.f6850h = j8;
        }

        public final long b(long j2, long j3) {
            long jD = d(j2);
            return jD != -1 ? jD : (int) (f((j3 - this.f6850h) + this.f6851i, j2) - c(j2, j3));
        }

        public final long c(long j2, long j3) {
            long jD = d(j2);
            long j4 = this.f6846d;
            if (jD == -1) {
                long j5 = this.f6849g;
                if (j5 != -9223372036854775807L) {
                    return Math.max(j4, f((j3 - this.f6850h) - j5, j2));
                }
            }
            return j4;
        }

        public abstract long d(long j2);

        public final long e(long j2, long j3) {
            long j4 = this.f6844b;
            long j5 = this.f6846d;
            List list = this.f6848f;
            if (list != null) {
                return (((SegmentTimelineElement) list.get((int) (j2 - j5))).f6857b * 1000000) / j4;
            }
            long jD = d(j3);
            return (jD == -1 || j2 != (j5 + jD) - 1) ? (this.f6847e * 1000000) / j4 : j3 - g(j2);
        }

        public final long f(long j2, long j3) {
            long jD = d(j3);
            long j4 = this.f6846d;
            if (jD != 0) {
                if (this.f6848f != null) {
                    long j5 = (jD + j4) - 1;
                    long j6 = j4;
                    while (j6 <= j5) {
                        long j7 = ((j5 - j6) / 2) + j6;
                        long jG = g(j7);
                        if (jG < j2) {
                            j6 = j7 + 1;
                        } else {
                            if (jG <= j2) {
                                return j7;
                            }
                            j5 = j7 - 1;
                        }
                    }
                    return j6 == j4 ? j6 : j5;
                }
                long j8 = (j2 / ((this.f6847e * 1000000) / this.f6844b)) + j4;
                if (j8 >= j4) {
                    return jD == -1 ? j8 : Math.min(j8, (j4 + jD) - 1);
                }
            }
            return j4;
        }

        public final long g(long j2) {
            long j3 = this.f6846d;
            List list = this.f6848f;
            long j4 = list != null ? ((SegmentTimelineElement) list.get((int) (j2 - j3))).f6856a - this.f6845c : (j2 - j3) * this.f6847e;
            int i2 = Util.f5744a;
            return Util.b0(j4, 1000000L, this.f6844b, RoundingMode.FLOOR);
        }

        public abstract RangedUri h(Representation.MultiSegmentRepresentation multiSegmentRepresentation, long j2);

        public boolean i() {
            return this.f6848f != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {

        /* renamed from: j, reason: collision with root package name */
        public final List f6852j;

        public SegmentList(RangedUri rangedUri, long j2, long j3, long j4, long j5, List list, long j6, List list2, long j7, long j8) {
            super(rangedUri, j2, j3, j4, j5, list, j6, j7, j8);
            this.f6852j = list2;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase.MultiSegmentBase
        public final long d(long j2) {
            return this.f6852j.size();
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase.MultiSegmentBase
        public final RangedUri h(Representation.MultiSegmentRepresentation multiSegmentRepresentation, long j2) {
            return (RangedUri) this.f6852j.get((int) (j2 - this.f6846d));
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase.MultiSegmentBase
        public final boolean i() {
            return true;
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {

        /* renamed from: j, reason: collision with root package name */
        public final UrlTemplate f6853j;

        /* renamed from: k, reason: collision with root package name */
        public final UrlTemplate f6854k;

        /* renamed from: l, reason: collision with root package name */
        public final long f6855l;

        public SegmentTemplate(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, List list, long j7, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j8, long j9) {
            super(rangedUri, j2, j3, j4, j6, list, j7, j8, j9);
            this.f6853j = urlTemplate;
            this.f6854k = urlTemplate2;
            this.f6855l = j5;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase
        public final RangedUri a(Representation representation) {
            UrlTemplate urlTemplate = this.f6853j;
            if (urlTemplate == null) {
                return this.f6843a;
            }
            Format format = representation.f6835a;
            return new RangedUri(0L, -1L, urlTemplate.a(format.f5221i, format.f5213a, 0L, 0L));
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase.MultiSegmentBase
        public final long d(long j2) {
            if (this.f6848f != null) {
                return r0.size();
            }
            long j3 = this.f6855l;
            if (j3 != -1) {
                return (j3 - this.f6846d) + 1;
            }
            if (j2 == -9223372036854775807L) {
                return -1L;
            }
            BigInteger bigIntegerMultiply = BigInteger.valueOf(j2).multiply(BigInteger.valueOf(this.f6844b));
            BigInteger bigIntegerMultiply2 = BigInteger.valueOf(this.f6847e).multiply(BigInteger.valueOf(1000000L));
            RoundingMode roundingMode = RoundingMode.CEILING;
            int i2 = BigIntegerMath.f43262a;
            return new BigDecimal(bigIntegerMultiply).divide(new BigDecimal(bigIntegerMultiply2), 0, roundingMode).toBigIntegerExact().longValue();
        }

        @Override // androidx.media3.exoplayer.dash.manifest.SegmentBase.MultiSegmentBase
        public final RangedUri h(Representation.MultiSegmentRepresentation multiSegmentRepresentation, long j2) {
            long j3 = this.f6846d;
            List list = this.f6848f;
            long j4 = list != null ? ((SegmentTimelineElement) list.get((int) (j2 - j3))).f6856a : (j2 - j3) * this.f6847e;
            Format format = multiSegmentRepresentation.f6835a;
            return new RangedUri(0L, -1L, this.f6854k.a(format.f5221i, format.f5213a, j2, j4));
        }
    }

    public static final class SegmentTimelineElement {

        /* renamed from: a, reason: collision with root package name */
        public final long f6856a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6857b;

        public SegmentTimelineElement(long j2, long j3) {
            this.f6856a = j2;
            this.f6857b = j3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SegmentTimelineElement.class == obj.getClass()) {
                SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
                if (this.f6856a == segmentTimelineElement.f6856a && this.f6857b == segmentTimelineElement.f6857b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((int) this.f6856a) * 31) + ((int) this.f6857b);
        }
    }

    public SegmentBase(RangedUri rangedUri, long j2, long j3) {
        this.f6843a = rangedUri;
        this.f6844b = j2;
        this.f6845c = j3;
    }

    public RangedUri a(Representation representation) {
        return this.f6843a;
    }

    public static class SingleSegmentBase extends SegmentBase {

        /* renamed from: d, reason: collision with root package name */
        public final long f6858d;

        /* renamed from: e, reason: collision with root package name */
        public final long f6859e;

        public SingleSegmentBase(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
            super(rangedUri, j2, j3);
            this.f6858d = j4;
            this.f6859e = j5;
        }

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
