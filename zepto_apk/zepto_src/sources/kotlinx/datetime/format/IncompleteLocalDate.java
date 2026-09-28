package kotlinx.datetime.format;

import android.support.v4.media.b;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.Month;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeArithmeticException;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.internal.format.parser.Copyable;
import org.apache.commons.codec.language.Soundex;

@Metadata
/* loaded from: classes3.dex */
public final class IncompleteLocalDate implements DateFieldContainer, Copyable<IncompleteLocalDate> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f55421a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f55422b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f55423c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f55424d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f55425e;

    public IncompleteLocalDate() {
        this(0);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer A() {
        return this.f55422b;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void C(Integer num) {
        this.f55424d = num;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final IncompleteLocalDate copy() {
        return new IncompleteLocalDate(this.f55421a, this.f55422b, this.f55423c, this.f55424d, this.f55425e);
    }

    public final LocalDate b() throws Exception {
        LocalDate localDate;
        Integer num = this.f55421a;
        LocalDateFormatKt.b(num, "year");
        int iIntValue = num.intValue();
        Integer num2 = this.f55425e;
        if (num2 == null) {
            Integer num3 = this.f55422b;
            LocalDateFormatKt.b(num3, "monthNumber");
            int iIntValue2 = num3.intValue();
            Integer num4 = this.f55423c;
            LocalDateFormatKt.b(num4, "dayOfMonth");
            localDate = new LocalDate(iIntValue, iIntValue2, num4.intValue());
        } else {
            LocalDate localDate2 = new LocalDate(iIntValue, 1, 1);
            int iIntValue3 = num2.intValue() - 1;
            DateTimeUnit.Companion.getClass();
            DateTimeUnit.DayBased unit = DateTimeUnit.f55343a;
            int i2 = LocalDateJvmKt.f55357c;
            Intrinsics.checkNotNullParameter(localDate2, "<this>");
            Intrinsics.checkNotNullParameter(unit, "unit");
            long j2 = iIntValue3;
            Intrinsics.checkNotNullParameter(localDate2, "<this>");
            Intrinsics.checkNotNullParameter(unit, "unit");
            j$.time.LocalDate localDate3 = localDate2.f55353a;
            try {
                if (unit == null) {
                    throw new NoWhenBranchMatchedException();
                }
                j$.time.LocalDate localDateA = LocalDateJvmKt.a(Math.addExact(localDate3.toEpochDay(), Math.multiplyExact(j2, unit.f55344b)));
                LocalDate localDate4 = new LocalDate(localDateA);
                if (localDateA.getYear() != iIntValue) {
                    throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + num2 + ", which is not a valid day of year for the year " + iIntValue);
                }
                if (this.f55422b != null) {
                    int monthValue = localDateA.getMonthValue();
                    Integer num5 = this.f55422b;
                    if (num5 == null || monthValue != num5.intValue()) {
                        StringBuilder sb = new StringBuilder("Can not create a LocalDate from the given input: the day of year is ");
                        sb.append(num2);
                        sb.append(", which is ");
                        Month month = localDateA.getMonth();
                        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
                        sb.append(month);
                        sb.append(", but ");
                        sb.append(this.f55422b);
                        sb.append(" was specified as the month number");
                        throw new DateTimeFormatException(sb.toString());
                    }
                }
                if (this.f55423c != null) {
                    int dayOfMonth = localDateA.getDayOfMonth();
                    Integer num6 = this.f55423c;
                    if (num6 == null || dayOfMonth != num6.intValue()) {
                        StringBuilder sb2 = new StringBuilder("Can not create a LocalDate from the given input: the day of year is ");
                        sb2.append(num2);
                        sb2.append(", which is the day ");
                        sb2.append(localDateA.getDayOfMonth());
                        sb2.append(" of ");
                        Month month2 = localDateA.getMonth();
                        Intrinsics.checkNotNullExpressionValue(month2, "getMonth(...)");
                        sb2.append(month2);
                        sb2.append(", but ");
                        sb2.append(this.f55423c);
                        sb2.append(" was specified as the day of month");
                        throw new DateTimeFormatException(sb2.toString());
                    }
                }
                localDate = localDate4;
            } catch (Exception cause) {
                if (!(cause instanceof DateTimeException) && !(cause instanceof ArithmeticException)) {
                    throw cause;
                }
                String message = "The result of adding " + j2 + " of " + unit + " to " + localDate2 + " is out of LocalDate range.";
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(cause, "cause");
                throw new DateTimeArithmeticException(message, cause);
            }
        }
        Integer num7 = this.f55424d;
        if (num7 != null) {
            int iIntValue4 = num7.intValue();
            j$.time.LocalDate localDate5 = localDate.f55353a;
            DayOfWeek dayOfWeek = localDate5.getDayOfWeek();
            Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
            Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
            if (iIntValue4 != dayOfWeek.ordinal() + 1) {
                StringBuilder sb3 = new StringBuilder("Can not create a LocalDate from the given input: the day of week is ");
                if (1 > iIntValue4 || iIntValue4 >= 8) {
                    throw new IllegalArgumentException(b.f(iIntValue4, "Expected ISO day-of-week number in 1..7, got ").toString());
                }
                sb3.append((DayOfWeek) DayOfWeekKt.EntriesMappings.f55349a.get(iIntValue4 - 1));
                sb3.append(" but the date is ");
                sb3.append(localDate);
                sb3.append(", which is a ");
                DayOfWeek dayOfWeek2 = localDate5.getDayOfWeek();
                Intrinsics.checkNotNullExpressionValue(dayOfWeek2, "getDayOfWeek(...)");
                sb3.append(dayOfWeek2);
                throw new DateTimeFormatException(sb3.toString());
            }
        }
        return localDate;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer d() {
        return this.f55424d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IncompleteLocalDate)) {
            return false;
        }
        IncompleteLocalDate incompleteLocalDate = (IncompleteLocalDate) obj;
        return Intrinsics.b(this.f55421a, incompleteLocalDate.f55421a) && Intrinsics.b(this.f55422b, incompleteLocalDate.f55422b) && Intrinsics.b(this.f55423c, incompleteLocalDate.f55423c) && Intrinsics.b(this.f55424d, incompleteLocalDate.f55424d) && Intrinsics.b(this.f55425e, incompleteLocalDate.f55425e);
    }

    public final int hashCode() {
        Integer num = this.f55421a;
        int iHashCode = (num != null ? num.hashCode() : 0) * 923521;
        Integer num2 = this.f55422b;
        int iHashCode2 = ((num2 != null ? num2.hashCode() : 0) * 29791) + iHashCode;
        Integer num3 = this.f55423c;
        int iHashCode3 = ((num3 != null ? num3.hashCode() : 0) * 961) + iHashCode2;
        Integer num4 = this.f55424d;
        int iHashCode4 = ((num4 != null ? num4.hashCode() : 0) * 31) + iHashCode3;
        Integer num5 = this.f55425e;
        return iHashCode4 + (num5 != null ? num5.hashCode() : 0);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void l(Integer num) {
        this.f55425e = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void q(Integer num) {
        this.f55422b = num;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Object obj = this.f55421a;
        if (obj == null) {
            obj = "??";
        }
        sb.append(obj);
        sb.append(Soundex.SILENT_MARKER);
        Object obj2 = this.f55422b;
        if (obj2 == null) {
            obj2 = "??";
        }
        sb.append(obj2);
        sb.append(Soundex.SILENT_MARKER);
        Object obj3 = this.f55423c;
        if (obj3 == null) {
            obj3 = "??";
        }
        sb.append(obj3);
        sb.append(" (day of week is ");
        Integer num = this.f55424d;
        sb.append(num != null ? num : "??");
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer u() {
        return this.f55421a;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void v(Integer num) {
        this.f55423c = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer x() {
        return this.f55425e;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void y(Integer num) {
        this.f55421a = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer z() {
        return this.f55423c;
    }

    public /* synthetic */ IncompleteLocalDate(int i2) {
        this(null, null, null, null, null);
    }

    public IncompleteLocalDate(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.f55421a = num;
        this.f55422b = num2;
        this.f55423c = num3;
        this.f55424d = num4;
        this.f55425e = num5;
    }
}
