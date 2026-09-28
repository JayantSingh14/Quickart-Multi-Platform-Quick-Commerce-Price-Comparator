package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Duration implements Comparable<Duration> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f54014b = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final long f54015c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f54016d;

    /* renamed from: a, reason: collision with root package name */
    public final long f54017a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        int i2 = DurationJvmKt.f54018a;
        f54015c = DurationKt.b(4611686018427387903L);
        f54016d = DurationKt.b(-4611686018427387903L);
    }

    public /* synthetic */ Duration(long j2) {
        this.f54017a = j2;
    }

    public static final long a(long j2, long j3) {
        long j4 = 1000000;
        long j5 = j3 / j4;
        long j6 = j2 + j5;
        if (-4611686018426L > j6 || j6 >= 4611686018427L) {
            return DurationKt.b(RangesKt.c(j6, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.d((j6 * j4) + (j3 - (j5 * j4)));
    }

    public static final void b(StringBuilder sb, int i2, int i3, int i4, String str, boolean z) {
        sb.append(i2);
        if (i3 != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String strD = StringsKt.D(i4, String.valueOf(i3));
            int i5 = -1;
            int length = strD.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (strD.charAt(length) != '0') {
                        i5 = length;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (z || i7 >= 3) {
                sb.append((CharSequence) strD, 0, ((i5 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strD, 0, i7);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static int c(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 >= 0 && (((int) j4) & 1) != 0) {
            int i2 = (((int) j2) & 1) - (((int) j3) & 1);
            return j2 < 0 ? -i2 : i2;
        }
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static final int d(long j2) {
        if (e(j2)) {
            return 0;
        }
        return (((int) j2) & 1) == 1 ? (int) (((j2 >> 1) % 1000) * 1000000) : (int) ((j2 >> 1) % 1000000000);
    }

    public static final boolean e(long j2) {
        return j2 == f54015c || j2 == f54016d;
    }

    public static final long g(long j2, long j3) {
        if (e(j2)) {
            if (!e(j3) || (j3 ^ j2) >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (e(j3)) {
            return j3;
        }
        int i2 = ((int) j2) & 1;
        if (i2 != (((int) j3) & 1)) {
            return i2 == 1 ? a(j2 >> 1, j3 >> 1) : a(j3 >> 1, j2 >> 1);
        }
        long j4 = (j2 >> 1) + (j3 >> 1);
        return i2 == 0 ? (-4611686018426999999L > j4 || j4 >= 4611686018427000000L) ? DurationKt.b(j4 / 1000000) : DurationKt.d(j4) : DurationKt.c(j4);
    }

    public static final long h(long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j2 == f54015c) {
            return Long.MAX_VALUE;
        }
        if (j2 == f54016d) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(j2 >> 1, (((int) j2) & 1) == 0 ? DurationUnit.f54019b : DurationUnit.f54021d, unit);
    }

    public static String i(long j2) {
        long j3;
        int iH;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == f54015c) {
            return "Infinity";
        }
        if (j2 == f54016d) {
            return "-Infinity";
        }
        int i2 = 0;
        boolean z = j2 < 0;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(Soundex.SILENT_MARKER);
        }
        long jL = j2 < 0 ? l(j2) : j2;
        long jH = h(jL, DurationUnit.f54025h);
        int iH2 = e(jL) ? 0 : (int) (h(jL, DurationUnit.f54024g) % 24);
        if (e(jL)) {
            j3 = 0;
            iH = 0;
        } else {
            j3 = 0;
            iH = (int) (h(jL, DurationUnit.f54023f) % 60);
        }
        int iH3 = e(jL) ? 0 : (int) (h(jL, DurationUnit.f54022e) % 60);
        int iD = d(jL);
        boolean z2 = jH != j3;
        boolean z3 = iH2 != 0;
        boolean z4 = iH != 0;
        boolean z5 = (iH3 == 0 && iD == 0) ? false : true;
        if (z2) {
            sb.append(jH);
            sb.append('d');
            i2 = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(iH2);
            sb.append('h');
            i2 = i3;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(iH);
            sb.append('m');
            i2 = i4;
        }
        if (z5) {
            int i5 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            if (iH3 != 0 || z2 || z3 || z4) {
                b(sb, iH3, iD, 9, "s", false);
            } else if (iD >= 1000000) {
                b(sb, iD / 1000000, iD % 1000000, 6, "ms", false);
            } else if (iD >= 1000) {
                b(sb, iD / 1000, iD % 1000, 3, "us", false);
            } else {
                sb.append(iD);
                sb.append("ns");
            }
            i2 = i5;
        }
        if (z && i2 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long l(long j2) {
        long j3 = ((-(j2 >> 1)) << 1) + (((int) j2) & 1);
        int i2 = DurationJvmKt.f54018a;
        return j3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        return c(this.f54017a, duration.f54017a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Duration) {
            return this.f54017a == ((Duration) obj).f54017a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f54017a);
    }

    public final String toString() {
        return i(this.f54017a);
    }
}
