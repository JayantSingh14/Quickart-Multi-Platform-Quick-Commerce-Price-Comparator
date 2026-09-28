package j$.util;

import j$.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DesugarTimeZone {
    public static TimeZone getTimeZone(String str) {
        return TimeZone.getTimeZone(str);
    }

    public static ZoneId toZoneId(TimeZone timeZone) {
        String id = timeZone.getID();
        Map map = ZoneId.f53197a;
        Objects.requireNonNull(id, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        String str = (String) map.get(id);
        if (str != null) {
            id = str;
        }
        return ZoneId.of(id);
    }
}
