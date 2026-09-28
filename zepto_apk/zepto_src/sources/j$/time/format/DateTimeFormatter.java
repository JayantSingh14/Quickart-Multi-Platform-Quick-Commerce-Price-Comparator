package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;

    /* renamed from: g, reason: collision with root package name */
    public static final DateTimeFormatter f53283g;

    /* renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f53284h;

    /* renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f53285i;

    /* renamed from: a, reason: collision with root package name */
    public final C0121d f53286a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f53287b;

    /* renamed from: c, reason: collision with root package name */
    public final A f53288c;

    /* renamed from: d, reason: collision with root package name */
    public final C f53289d;

    /* renamed from: e, reason: collision with root package name */
    public final j$.time.chrono.r f53290e;

    /* renamed from: f, reason: collision with root package name */
    public final ZoneId f53291f;

    /* JADX WARN: Removed duplicated region for block: B:131:0x0218 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x048f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.format.DateTimeFormatter ofPattern(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.ofPattern(java.lang.String):j$.time.format.DateTimeFormatter");
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        D d2 = D.EXCEEDS_PAD;
        dateTimeFormatterBuilder.l(aVar, 4, 10, d2);
        dateTimeFormatterBuilder.d(Soundex.SILENT_MARKER);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        dateTimeFormatterBuilder.k(aVar2, 2);
        dateTimeFormatterBuilder.d(Soundex.SILENT_MARKER);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        dateTimeFormatterBuilder.k(aVar3, 2);
        C c2 = C.STRICT;
        j$.time.chrono.r rVar = j$.time.chrono.r.f53253c;
        DateTimeFormatter dateTimeFormatterO = dateTimeFormatterBuilder.o(c2, rVar);
        ISO_LOCAL_DATE = dateTimeFormatterO;
        DateTimeFormatterBuilder caseInsensitive = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive.a(dateTimeFormatterO);
        caseInsensitive.appendOffsetId().o(c2, rVar);
        DateTimeFormatterBuilder caseInsensitive2 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive2.a(dateTimeFormatterO);
        caseInsensitive2.n();
        caseInsensitive2.appendOffsetId().o(c2, rVar);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        dateTimeFormatterBuilder2.k(aVar4, 2);
        dateTimeFormatterBuilder2.d(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        dateTimeFormatterBuilder2.k(aVar5, 2);
        dateTimeFormatterBuilder2.n();
        dateTimeFormatterBuilder2.d(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        dateTimeFormatterBuilder2.k(aVar6, 2);
        dateTimeFormatterBuilder2.n();
        dateTimeFormatterBuilder2.b(j$.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterO2 = dateTimeFormatterBuilder2.o(c2, null);
        f53283g = dateTimeFormatterO2;
        DateTimeFormatterBuilder caseInsensitive3 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive3.a(dateTimeFormatterO2);
        caseInsensitive3.appendOffsetId().o(c2, null);
        DateTimeFormatterBuilder caseInsensitive4 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive4.a(dateTimeFormatterO2);
        caseInsensitive4.n();
        caseInsensitive4.appendOffsetId().o(c2, null);
        DateTimeFormatterBuilder caseInsensitive5 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive5.a(dateTimeFormatterO);
        caseInsensitive5.d('T');
        caseInsensitive5.a(dateTimeFormatterO2);
        DateTimeFormatter dateTimeFormatterO3 = caseInsensitive5.o(c2, rVar);
        f53284h = dateTimeFormatterO3;
        DateTimeFormatterBuilder caseInsensitive6 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive6.a(dateTimeFormatterO3);
        p pVar = p.LENIENT;
        caseInsensitive6.c(pVar);
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendOffsetId = caseInsensitive6.appendOffsetId();
        p pVar2 = p.STRICT;
        dateTimeFormatterBuilderAppendOffsetId.c(pVar2);
        DateTimeFormatter dateTimeFormatterO4 = dateTimeFormatterBuilderAppendOffsetId.o(c2, rVar);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder3.a(dateTimeFormatterO4);
        dateTimeFormatterBuilder3.n();
        dateTimeFormatterBuilder3.d('[');
        p pVar3 = p.SENSITIVE;
        dateTimeFormatterBuilder3.c(pVar3);
        j$.time.f fVar = DateTimeFormatterBuilder.f53292h;
        dateTimeFormatterBuilder3.c(new s(fVar, "ZoneRegionId()"));
        dateTimeFormatterBuilder3.d(']');
        dateTimeFormatterBuilder3.o(c2, rVar);
        DateTimeFormatterBuilder dateTimeFormatterBuilder4 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder4.a(dateTimeFormatterO3);
        dateTimeFormatterBuilder4.n();
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendOffsetId2 = dateTimeFormatterBuilder4.appendOffsetId();
        dateTimeFormatterBuilderAppendOffsetId2.n();
        dateTimeFormatterBuilderAppendOffsetId2.d('[');
        dateTimeFormatterBuilderAppendOffsetId2.c(pVar3);
        dateTimeFormatterBuilderAppendOffsetId2.c(new s(fVar, "ZoneRegionId()"));
        dateTimeFormatterBuilderAppendOffsetId2.d(']');
        dateTimeFormatterBuilderAppendOffsetId2.o(c2, rVar);
        DateTimeFormatterBuilder caseInsensitive7 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive7.l(aVar, 4, 10, d2);
        caseInsensitive7.d(Soundex.SILENT_MARKER);
        caseInsensitive7.k(j$.time.temporal.a.DAY_OF_YEAR, 3);
        caseInsensitive7.n();
        caseInsensitive7.appendOffsetId().o(c2, rVar);
        DateTimeFormatterBuilder caseInsensitive8 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive8.l(j$.time.temporal.i.f53419c, 4, 10, d2);
        caseInsensitive8.e("-W");
        caseInsensitive8.k(j$.time.temporal.i.f53418b, 2);
        caseInsensitive8.d(Soundex.SILENT_MARKER);
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        caseInsensitive8.k(aVar7, 1);
        caseInsensitive8.n();
        caseInsensitive8.appendOffsetId().o(c2, rVar);
        DateTimeFormatterBuilder caseInsensitive9 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive9.getClass();
        caseInsensitive9.c(new g());
        f53285i = caseInsensitive9.o(c2, null);
        DateTimeFormatterBuilder caseInsensitive10 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive10.k(aVar, 4);
        caseInsensitive10.k(aVar2, 2);
        caseInsensitive10.k(aVar3, 2);
        caseInsensitive10.n();
        caseInsensitive10.c(pVar);
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendOffset = caseInsensitive10.appendOffset("+HHMMss", "Z");
        dateTimeFormatterBuilderAppendOffset.c(pVar2);
        dateTimeFormatterBuilderAppendOffset.o(c2, rVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        DateTimeFormatterBuilder caseInsensitive11 = new DateTimeFormatterBuilder().parseCaseInsensitive();
        caseInsensitive11.c(pVar);
        caseInsensitive11.n();
        caseInsensitive11.g(aVar7, map);
        caseInsensitive11.e(", ");
        caseInsensitive11.m();
        caseInsensitive11.l(aVar3, 1, 2, D.NOT_NEGATIVE);
        caseInsensitive11.d(' ');
        caseInsensitive11.g(aVar2, map2);
        caseInsensitive11.d(' ');
        caseInsensitive11.k(aVar, 4);
        caseInsensitive11.d(' ');
        caseInsensitive11.k(aVar4, 2);
        caseInsensitive11.d(':');
        caseInsensitive11.k(aVar5, 2);
        caseInsensitive11.n();
        caseInsensitive11.d(':');
        caseInsensitive11.k(aVar6, 2);
        caseInsensitive11.m();
        caseInsensitive11.d(' ');
        caseInsensitive11.appendOffset("+HHMM", TimeZones.GMT_ID).o(C.SMART, rVar);
    }

    public DateTimeFormatter(C0121d c0121d, Locale locale, A a2, C c2, j$.time.chrono.r rVar, ZoneId zoneId) {
        Objects.requireNonNull(c0121d, "printerParser");
        this.f53286a = c0121d;
        Objects.requireNonNull(locale, "locale");
        this.f53287b = locale;
        Objects.requireNonNull(a2, "decimalStyle");
        this.f53288c = a2;
        Objects.requireNonNull(c2, "resolverStyle");
        this.f53289d = c2;
        this.f53290e = rVar;
        this.f53291f = zoneId;
    }

    public DateTimeFormatter withZone(ZoneId zoneId) {
        if (Objects.equals(this.f53291f, zoneId)) {
            return this;
        }
        return new DateTimeFormatter(this.f53286a, this.f53287b, this.f53288c, this.f53289d, this.f53290e, zoneId);
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            this.f53286a.q(new w(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new DateTimeException(e2.getMessage(), e2);
        }
    }

    public <T> T parse(CharSequence charSequence, TemporalQuery<T> temporalQuery) {
        String string;
        Objects.requireNonNull(charSequence, "text");
        Objects.requireNonNull(temporalQuery, "query");
        try {
            return (T) a(charSequence).e(temporalQuery);
        } catch (DateTimeParseException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            DateTimeParseException dateTimeParseException = new DateTimeParseException("Text '" + string + "' could not be parsed: " + e3.getMessage(), e3);
            charSequence.toString();
            throw dateTimeParseException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0210  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.format.B a(java.lang.CharSequence r27) {
        /*
            Method dump skipped, instructions count: 956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.a(java.lang.CharSequence):j$.time.format.B");
    }

    public final String toString() {
        String string = this.f53286a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }
}
