package org.xbill.DNS;

import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;

/* loaded from: classes5.dex */
final class FormattedTime {
    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC);

    private FormattedTime() {
    }

    public static String format(Instant instant) {
        return DEFAULT_FORMAT.format(instant);
    }

    public static Instant parse(String str) throws DateTimeParseException {
        if (str.length() == 14) {
            return (Instant) DEFAULT_FORMAT.parse(str, new o());
        }
        if (str.length() <= 10) {
            return Instant.ofEpochSecond(Long.parseLong(str));
        }
        throw new DateTimeParseException("Invalid time encoding: ", str, 0);
    }
}
