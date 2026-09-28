package kotlinx.datetime.format;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface DateTimeFormatBuilder {

    @Metadata
    public interface WithDate extends DateTimeFormatBuilder {

        @Metadata
        public static final class DefaultImpls {
            public static /* synthetic */ void a(WithDate withDate) {
                Padding padding = Padding.f55478a;
                withDate.j();
            }
        }

        void c();

        void f(DateTimeFormat dateTimeFormat);

        void j();

        void s(DayOfWeekNames dayOfWeekNames);

        void t(Padding padding);

        void u(MonthNames monthNames);
    }

    @Metadata
    public interface WithDateTime extends WithDate, WithTime {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    @Metadata
    public interface WithDateTimeComponents extends WithDateTime, WithUtcOffset {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    @Metadata
    public interface WithTime extends DateTimeFormatBuilder {

        @Metadata
        public static final class DefaultImpls {
            public static /* synthetic */ void a(WithTime withTime) {
                Padding padding = Padding.f55478a;
                withTime.n();
            }

            public static /* synthetic */ void b(WithTime withTime) {
                Padding padding = Padding.f55478a;
                withTime.l();
            }

            public static /* synthetic */ void c(WithTime withTime) {
                Padding padding = Padding.f55478a;
                withTime.m();
            }
        }

        void i(LocalTimeFormat localTimeFormat);

        void l();

        void m();

        void n();

        void p(int i2, int i3);
    }

    @Metadata
    public interface WithUtcOffset extends DateTimeFormatBuilder {

        @Metadata
        public static final class DefaultImpls {
            public static /* synthetic */ void a(WithUtcOffset withUtcOffset) {
                Padding padding = Padding.f55478a;
                withUtcOffset.o();
            }

            public static /* synthetic */ void b(WithUtcOffset withUtcOffset) {
                Padding padding = Padding.f55478a;
                withUtcOffset.e();
            }

            public static /* synthetic */ void c(WithUtcOffset withUtcOffset) {
                Padding padding = Padding.f55478a;
                withUtcOffset.r();
            }
        }

        void e();

        void o();

        void q(UtcOffsetFormat utcOffsetFormat);

        void r();
    }

    void h(String str);
}
