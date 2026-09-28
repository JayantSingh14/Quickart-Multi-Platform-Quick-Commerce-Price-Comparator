package kotlin.time;

import coil3.decode.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {

    /* renamed from: a, reason: collision with root package name */
    public final DurationUnit f54009a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f54010b;

    @Metadata
    @SourceDebugExtension
    public static final class LongTimeMark implements ComparableTimeMark {

        /* renamed from: a, reason: collision with root package name */
        public final long f54011a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractLongTimeSource f54012b;

        /* renamed from: c, reason: collision with root package name */
        public final long f54013c;

        public LongTimeMark(long j2, AbstractLongTimeSource timeSource, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.f54011a = j2;
            this.f54012b = timeSource;
            this.f54013c = j3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof LongTimeMark)) {
                return false;
            }
            if (!Intrinsics.b(this.f54012b, ((LongTimeMark) obj).f54012b)) {
                return false;
            }
            long j2 = j((ComparableTimeMark) obj);
            Duration.f54014b.getClass();
            return j2 == 0;
        }

        public final int hashCode() {
            Duration.Companion companion = Duration.f54014b;
            return Long.hashCode(this.f54011a) + (Long.hashCode(this.f54013c) * 37);
        }

        @Override // kotlin.time.ComparableTimeMark
        public final long j(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                AbstractLongTimeSource abstractLongTimeSource = longTimeMark.f54012b;
                AbstractLongTimeSource abstractLongTimeSource2 = this.f54012b;
                if (Intrinsics.b(abstractLongTimeSource2, abstractLongTimeSource)) {
                    return Duration.g(LongSaturatedMathKt.b(this.f54011a, longTimeMark.f54011a, abstractLongTimeSource2.f54009a), Duration.g(this.f54013c, Duration.l(longTimeMark.f54013c)));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("LongTimeMark(");
            sb.append(this.f54011a);
            AbstractLongTimeSource abstractLongTimeSource = this.f54012b;
            DurationUnit durationUnit = abstractLongTimeSource.f54009a;
            Intrinsics.checkNotNullParameter(durationUnit, "<this>");
            switch (durationUnit.ordinal()) {
                case 0:
                    str = "ns";
                    break;
                case 1:
                    str = "us";
                    break;
                case 2:
                    str = "ms";
                    break;
                case 3:
                    str = "s";
                    break;
                case 4:
                    str = "m";
                    break;
                case 5:
                    str = "h";
                    break;
                case 6:
                    str = "d";
                    break;
                default:
                    throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
            }
            sb.append(str);
            sb.append(" + ");
            sb.append((Object) Duration.i(this.f54013c));
            sb.append(", ");
            sb.append(abstractLongTimeSource);
            sb.append(')');
            return sb.toString();
        }
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.f54009a = unit;
        this.f54010b = LazyKt.b(new a(this, 12));
    }

    public abstract long a();
}
