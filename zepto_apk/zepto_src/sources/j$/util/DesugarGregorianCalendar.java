package j$.util;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final /* synthetic */ class DesugarGregorianCalendar {
    /* JADX WARN: Multi-variable type inference failed */
    public static ZonedDateTime toZonedDateTime(GregorianCalendar gregorianCalendar) {
        Instant instantA = Instant.A(gregorianCalendar.getTimeInMillis());
        TimeZone timeZone = gregorianCalendar.getTimeZone();
        ZoneId zoneId = timeZone instanceof TimeZoneRetargetInterface ? ((TimeZoneRetargetInterface) timeZone).toZoneId() : DesugarTimeZone.toZoneId(timeZone);
        Objects.requireNonNull(instantA, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instantA.getEpochSecond(), instantA.getNano(), zoneId);
    }
}
