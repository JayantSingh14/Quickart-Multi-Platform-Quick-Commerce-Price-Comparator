package ch.qos.logback.core.rolling.helper;

import j$.time.TimeConversions;
import j$.util.DesugarGregorianCalendar;
import j$.util.DesugarTimeZone;
import j$.util.GregorianCalendarRetargetInterface;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes3.dex */
public class RollingCalendar extends GregorianCalendar implements GregorianCalendarRetargetInterface {

    /* renamed from: ch.qos.logback.core.rolling.helper.RollingCalendar$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13728a;

        static {
            int[] iArr = new int[PeriodicityType.values().length];
            f13728a = iArr;
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13728a[6] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13728a[7] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13728a[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13728a[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13728a[3] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13728a[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13728a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        DesugarTimeZone.getTimeZone(TimeZones.GMT_ID);
    }

    @Override // java.util.GregorianCalendar
    public final /* synthetic */ ZonedDateTime toZonedDateTime() {
        return TimeConversions.convert(toZonedDateTime());
    }

    @Override // java.util.GregorianCalendar, j$.util.GregorianCalendarRetargetInterface
    public final /* synthetic */ j$.time.ZonedDateTime toZonedDateTime() {
        return DesugarGregorianCalendar.toZonedDateTime(this);
    }
}
