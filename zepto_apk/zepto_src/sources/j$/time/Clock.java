package j$.time;

import j$.util.DesugarTimeZone;
import j$.util.TimeZoneRetargetInterface;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class Clock {
    public abstract Instant instant();

    public static Clock systemUTC() {
        return a.f53207b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a b() {
        TimeZone timeZone = TimeZone.getDefault();
        return new a(timeZone instanceof TimeZoneRetargetInterface ? ((TimeZoneRetargetInterface) timeZone).toZoneId() : DesugarTimeZone.toZoneId(timeZone));
    }

    public long a() {
        return instant().toEpochMilli();
    }
}
