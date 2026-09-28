package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
public final class g implements InterfaceC0122e {
    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        Long lA = wVar.a(j$.time.temporal.a.INSTANT_SECONDS);
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        TemporalAccessor temporalAccessor = wVar.f53370a;
        Long lValueOf = temporalAccessor.g(aVar) ? Long.valueOf(temporalAccessor.h(aVar)) : null;
        int i2 = 0;
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        int iA = aVar.f53410b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
        if (jLongValue >= -62167219200L) {
            long j2 = jLongValue - 253402300800L;
            long jFloorDiv = Math.floorDiv(j2, 315569520000L) + 1;
            LocalDateTime localDateTimeK = LocalDateTime.K(Math.floorMod(j2, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (jFloorDiv > 0) {
                sb.append('+');
                sb.append(jFloorDiv);
            }
            sb.append(localDateTimeK);
            if (localDateTimeK.getSecond() == 0) {
                sb.append(":00");
            }
        } else {
            long j3 = jLongValue + 62167219200L;
            long j4 = j3 / 315569520000L;
            long j5 = j3 % 315569520000L;
            LocalDateTime localDateTimeK2 = LocalDateTime.K(j5 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(localDateTimeK2);
            if (localDateTimeK2.getSecond() == 0) {
                sb.append(":00");
            }
            if (j4 < 0) {
                if (localDateTimeK2.getYear() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j4 - 1));
                } else if (j5 == 0) {
                    sb.insert(length, j4);
                } else {
                    sb.insert(length + 1, Math.abs(j4));
                }
            }
        }
        if (iA > 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int i3 = 100000000;
            while (true) {
                if (iA <= 0 && i2 % 3 == 0 && i2 >= -2) {
                    break;
                }
                int i4 = iA / i3;
                sb.append((char) (i4 + 48));
                iA -= i4 * i3;
                i3 /= 10;
                i2++;
            }
        }
        sb.append('Z');
        return true;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        int i3;
        int i4;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.a(DateTimeFormatter.ISO_LOCAL_DATE);
        dateTimeFormatterBuilder.d('T');
        j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
        dateTimeFormatterBuilder.k(aVar, 2);
        dateTimeFormatterBuilder.d(':');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
        dateTimeFormatterBuilder.k(aVar2, 2);
        dateTimeFormatterBuilder.d(':');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
        dateTimeFormatterBuilder.k(aVar3, 2);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
        int i5 = 0;
        dateTimeFormatterBuilder.b(aVar4, 0, 9, true);
        dateTimeFormatterBuilder.d('Z');
        C0121d c0121d = dateTimeFormatterBuilder.toFormatter().f53286a;
        if (c0121d.f53314b) {
            c0121d = new C0121d(c0121d.f53313a, false);
        }
        u uVar2 = new u(uVar.f53361a);
        uVar2.f53362b = uVar.f53362b;
        uVar2.f53363c = uVar.f53363c;
        int iS = c0121d.s(uVar2, charSequence, i2);
        if (iS < 0) {
            return iS;
        }
        long jLongValue = uVar2.d(j$.time.temporal.a.YEAR).longValue();
        int iIntValue = uVar2.d(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
        int iIntValue2 = uVar2.d(j$.time.temporal.a.DAY_OF_MONTH).intValue();
        int iIntValue3 = uVar2.d(aVar).intValue();
        int iIntValue4 = uVar2.d(aVar2).intValue();
        Long lD = uVar2.d(aVar3);
        Long lD2 = uVar2.d(aVar4);
        int iIntValue5 = lD != null ? lD.intValue() : 0;
        int iIntValue6 = lD2 != null ? lD2.intValue() : 0;
        if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
            i3 = 0;
            i4 = iIntValue5;
            i5 = 1;
        } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
            uVar.c().f53276d = true;
            i3 = iIntValue3;
            i4 = 59;
        } else {
            i3 = iIntValue3;
            i4 = iIntValue5;
        }
        try {
            LocalDateTime localDateTimeOf = LocalDateTime.of(((int) jLongValue) % 10000, iIntValue, iIntValue2, i3, iIntValue4, i4, 0);
            return uVar.f(aVar4, iIntValue6, i2, uVar.f(j$.time.temporal.a.INSTANT_SECONDS, localDateTimeOf.f0(localDateTimeOf.f53184a.j0(i5), localDateTimeOf.f53185b).b0(ZoneOffset.UTC) + Math.multiplyExact(jLongValue / 10000, 315569520000L), i2, iS));
        } catch (RuntimeException unused) {
            return ~i2;
        }
    }

    public final String toString() {
        return "Instant()";
    }
}
