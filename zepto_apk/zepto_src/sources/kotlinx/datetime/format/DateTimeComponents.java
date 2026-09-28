package kotlinx.datetime.format;

import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.common.api.Api;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.DateTimeComponentsFormat;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DateTimeComponents {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f55382b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f55383c;

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeComponentsContents f55384a;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Formats {

        /* renamed from: a, reason: collision with root package name */
        public static final DateTimeComponentsFormat f55385a;

        /* renamed from: b, reason: collision with root package name */
        public static final DateTimeComponentsFormat f55386b;

        static {
            Companion companion = DateTimeComponents.f55382b;
            DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1 block = DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.f55387c;
            companion.getClass();
            Intrinsics.checkNotNullParameter(block, "block");
            DateTimeComponentsFormat.Builder builder = new DateTimeComponentsFormat.Builder(new AppendableFormatStructure());
            block.invoke(builder);
            f55385a = new DateTimeComponentsFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder));
            DateTimeComponents$Formats$RFC_1123$1 block2 = DateTimeComponents$Formats$RFC_1123$1.f55393c;
            Intrinsics.checkNotNullParameter(block2, "block");
            DateTimeComponentsFormat.Builder builder2 = new DateTimeComponentsFormat.Builder(new AppendableFormatStructure());
            block2.invoke(builder2);
            f55386b = new DateTimeComponentsFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder2));
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl("monthNumber", "getMonthNumber()Ljava/lang/Integer;", DateTimeComponents.class);
        Reflection.f53802a.getClass();
        f55383c = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl("dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("dayOfYear", "getDayOfYear()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("hour", "getHour()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("minute", "getMinute()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("second", "getSecond()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("offsetHours", "getOffsetHours()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("offsetMinutesOfHour", "getOffsetMinutesOfHour()Ljava/lang/Integer;", DateTimeComponents.class), new MutablePropertyReference1Impl("offsetSecondsOfMinute", "getOffsetSecondsOfMinute()Ljava/lang/Integer;", DateTimeComponents.class)};
        f55382b = new Companion();
    }

    public DateTimeComponents() {
        this(new DateTimeComponentsContents(0));
    }

    public final Instant a() {
        DateTimeComponentsContents dateTimeComponentsContents = this.f55384a;
        UtcOffset utcOffsetA = dateTimeComponentsContents.f55403c.a();
        IncompleteLocalTime incompleteLocalTime = dateTimeComponentsContents.f55402b;
        LocalTime localTimeD = incompleteLocalTime.d();
        IncompleteLocalDate incompleteLocalDateCopy = dateTimeComponentsContents.f55401a.copy();
        Integer num = incompleteLocalDateCopy.f55421a;
        LocalDateFormatKt.b(num, "year");
        incompleteLocalDateCopy.f55421a = Integer.valueOf(num.intValue() % 10000);
        try {
            Intrinsics.c(dateTimeComponentsContents.f55401a.f55421a);
            long jMultiplyExact = Math.multiplyExact(r1.intValue() / 10000, 315569520000L);
            long epochDay = incompleteLocalDateCopy.b().f55353a.toEpochDay();
            long jAddExact = Math.addExact(jMultiplyExact, (((epochDay > TTL.MAX_VALUE ? Api.BaseClientBuilder.API_PRIORITY_OTHER : epochDay < -2147483648L ? Integer.MIN_VALUE : (int) epochDay) * MMKV.ExpireInDay) + localTimeD.f55360a.toSecondOfDay()) - utcOffsetA.f55363a.getTotalSeconds());
            Instant.Companion.getClass();
            if (jAddExact < Instant.f55350b.f55352a.getEpochSecond() || jAddExact > Instant.f55351c.f55352a.getEpochSecond()) {
                Intrinsics.checkNotNullParameter("The parsed date is outside the range representable by Instant", APayConstants.Error.MESSAGE);
                throw new DateTimeFormatException("The parsed date is outside the range representable by Instant");
            }
            Integer num2 = incompleteLocalTime.f55433f;
            return Instant.Companion.a(num2 != null ? num2.intValue() : 0, jAddExact);
        } catch (ArithmeticException e2) {
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant", e2);
        }
    }

    public DateTimeComponents(DateTimeComponentsContents contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.f55384a = contents;
        contents.getClass();
        new TwoDigitNumber(new DateTimeComponents$monthNumber$2(contents.f55401a, IncompleteLocalDate.class, "monthNumber", "getMonthNumber()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$dayOfMonth$2(contents.f55401a, IncompleteLocalDate.class, "dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", 0));
        new ThreeDigitNumber(new DateTimeComponents$dayOfYear$2(contents.f55401a, IncompleteLocalDate.class, "dayOfYear", "getDayOfYear()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$hour$2(contents.f55402b, IncompleteLocalTime.class, "hour", "getHour()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$hourOfAmPm$2(contents.f55402b, IncompleteLocalTime.class, "hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$minute$2(contents.f55402b, IncompleteLocalTime.class, "minute", "getMinute()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$second$2(contents.f55402b, IncompleteLocalTime.class, "second", "getSecond()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$offsetHours$2(contents.f55403c, IncompleteUtcOffset.class, "totalHoursAbs", "getTotalHoursAbs()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$offsetMinutesOfHour$2(contents.f55403c, IncompleteUtcOffset.class, "minutesOfHour", "getMinutesOfHour()Ljava/lang/Integer;", 0));
        new TwoDigitNumber(new DateTimeComponents$offsetSecondsOfMinute$2(contents.f55403c, IncompleteUtcOffset.class, "secondsOfMinute", "getSecondsOfMinute()Ljava/lang/Integer;", 0));
    }
}
