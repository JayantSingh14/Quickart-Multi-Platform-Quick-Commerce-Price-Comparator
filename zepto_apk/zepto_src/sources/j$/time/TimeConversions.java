package j$.time;

/* loaded from: classes2.dex */
public class TimeConversions {
    public static java.time.ZoneId convert(ZoneId zoneId) {
        if (zoneId == null) {
            return null;
        }
        return java.time.ZoneId.of(zoneId.getId());
    }

    public static java.time.Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return java.time.Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
    }

    public static Instant convert(java.time.Instant instant) {
        if (instant == null) {
            return null;
        }
        return Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
    }

    public static java.time.ZonedDateTime convert(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        LocalDateTime localDateTime = zonedDateTime.f53204a;
        return java.time.ZonedDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano(), convert(zonedDateTime.f53206c));
    }
}
