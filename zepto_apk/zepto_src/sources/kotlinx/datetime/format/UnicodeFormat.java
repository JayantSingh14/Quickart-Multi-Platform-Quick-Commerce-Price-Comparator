package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public interface UnicodeFormat {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    public static abstract class Directive implements UnicodeFormat {

        @Metadata
        public static abstract class DateBased extends Directive {

            @Metadata
            public static final class CyclicYearName extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class DayOfMonth extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class DayOfWeek extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class DayOfWeekInMonth extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class DayOfYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class Era extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class LocalizedDayOfWeek extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class ModifiedJulianDay extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class MonthOfYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class QuarterOfYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class RelatedGregorianYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class StandaloneLocalizedDayOfWeek extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class StandaloneMonthOfYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class StandaloneQuarterOfYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class WeekBasedYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class WeekOfMonth extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class WeekOfWeekBasedYear extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class Year extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class YearOfEra extends DateBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }
        }

        @Metadata
        public static abstract class OffsetBased extends Directive {

            @Metadata
            public static final class LocalizedZoneOffset extends OffsetBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    throw null;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return 'O';
                }
            }

            @Metadata
            public static final class ZoneOffset1 extends OffsetBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class ZoneOffset2 extends OffsetBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class ZoneOffset3 extends OffsetBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }
        }

        @Metadata
        public static abstract class TimeBased extends Directive {

            @Metadata
            public static final class AmPmHourOfDay extends TimeBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class AmPmMarker extends TimeBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class HourOfDay extends TimeBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class MinuteOfHour extends TimeBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static abstract class WithSecondPrecision extends TimeBased {

                @Metadata
                public static final class SecondOfMinute extends WithSecondPrecision {
                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final int a() {
                        return 0;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final char b() {
                        return (char) 0;
                    }
                }
            }

            @Metadata
            public static abstract class WithSubsecondPrecision extends WithSecondPrecision {

                @Metadata
                public static final class FractionOfSecond extends WithSubsecondPrecision {
                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final int a() {
                        return 0;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final char b() {
                        return (char) 0;
                    }
                }

                @Metadata
                public static final class MilliOfDay extends WithSubsecondPrecision {
                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final int a() {
                        return 0;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final char b() {
                        return (char) 0;
                    }
                }

                @Metadata
                public static final class NanoOfDay extends WithSubsecondPrecision {
                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final int a() {
                        return 0;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final char b() {
                        return (char) 0;
                    }
                }

                @Metadata
                public static final class NanoOfSecond extends WithSubsecondPrecision {
                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final int a() {
                        return 0;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public final char b() {
                        return (char) 0;
                    }
                }
            }
        }

        @Metadata
        public static abstract class ZoneBased extends Directive {

            @Metadata
            public static final class GenericTimeZoneName extends ZoneBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class TimeZoneId extends ZoneBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }

            @Metadata
            public static final class TimeZoneName extends ZoneBased {
                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final int a() {
                    return 0;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public final char b() {
                    return (char) 0;
                }
            }
        }

        public abstract int a();

        public abstract char b();

        public final boolean equals(Object obj) {
            if (!(obj instanceof Directive)) {
                return false;
            }
            Directive directive = (Directive) obj;
            return b() == directive.b() && a() == directive.a();
        }

        public final int hashCode() {
            return a() + (Character.hashCode(b()) * 31);
        }

        public final String toString() {
            return StringsKt.I(String.valueOf(b()), a());
        }
    }

    @Metadata
    public static final class OptionalGroup implements UnicodeFormat {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OptionalGroup)) {
                return false;
            }
            ((OptionalGroup) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "[null]";
        }
    }

    @Metadata
    public static final class Sequence implements UnicodeFormat {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Sequence)) {
                return false;
            }
            ((Sequence) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            CollectionsKt.E(null, "", null, null, null, 62);
            throw null;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class StringLiteral implements UnicodeFormat {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringLiteral)) {
                return false;
            }
            ((StringLiteral) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }
}
