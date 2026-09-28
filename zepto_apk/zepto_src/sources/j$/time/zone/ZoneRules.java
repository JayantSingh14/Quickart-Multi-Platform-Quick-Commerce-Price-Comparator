package j$.time.zone;

import com.tencent.mmkv.MMKV;
import j$.time.Clock;
import j$.time.DayOfWeek;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.LocalTime;
import j$.time.Month;
import j$.time.ZoneOffset;
import j$.time.chrono.r;
import j$.time.temporal.m;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ZoneRules implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final long[] f53463i = new long[0];

    /* renamed from: j, reason: collision with root package name */
    public static final e[] f53464j = new e[0];

    /* renamed from: k, reason: collision with root package name */
    public static final LocalDateTime[] f53465k = new LocalDateTime[0];

    /* renamed from: l, reason: collision with root package name */
    public static final b[] f53466l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f53467a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f53468b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f53469c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f53470d;

    /* renamed from: e, reason: collision with root package name */
    public final ZoneOffset[] f53471e;

    /* renamed from: f, reason: collision with root package name */
    public final e[] f53472f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeZone f53473g;

    /* renamed from: h, reason: collision with root package name */
    public final transient ConcurrentHashMap f53474h = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a(j$.time.LocalDateTime r5, j$.time.zone.b r6) {
        /*
            j$.time.LocalDateTime r0 = r6.f53478b
            j$.time.ZoneOffset r1 = r6.f53480d
            int r2 = r1.getTotalSeconds()
            j$.time.ZoneOffset r3 = r6.f53479c
            int r4 = r3.getTotalSeconds()
            if (r2 <= r4) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = 0
        L13:
            j$.time.LocalDateTime r4 = r6.f53478b
            if (r2 == 0) goto L33
            boolean r0 = r5.J(r0)
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            int r0 = r1.getTotalSeconds()
            int r2 = r3.getTotalSeconds()
            int r0 = r0 - r2
            long r2 = (long) r0
            j$.time.LocalDateTime r0 = r4.Z(r2)
            boolean r5 = r5.J(r0)
            if (r5 == 0) goto L39
            goto L4f
        L33:
            boolean r0 = r5.J(r0)
            if (r0 != 0) goto L3a
        L39:
            return r1
        L3a:
            int r0 = r1.getTotalSeconds()
            int r1 = r3.getTotalSeconds()
            int r0 = r0 - r1
            long r0 = (long) r0
            j$.time.LocalDateTime r0 = r4.Z(r0)
            boolean r5 = r5.J(r0)
            if (r5 == 0) goto L4f
        L4e:
            return r3
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.ZoneRules.a(j$.time.LocalDateTime, j$.time.zone.b):java.lang.Object");
    }

    public ZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f53467a = jArr;
        this.f53468b = zoneOffsetArr;
        this.f53469c = jArr2;
        this.f53471e = zoneOffsetArr2;
        this.f53472f = eVarArr;
        if (jArr2.length == 0) {
            this.f53470d = f53465k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                ZoneOffset zoneOffset = zoneOffsetArr2[i2];
                int i3 = i2 + 1;
                ZoneOffset zoneOffset2 = zoneOffsetArr2[i3];
                LocalDateTime localDateTimeK = LocalDateTime.K(jArr2[i2], 0, zoneOffset);
                if (zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds()) {
                    arrayList.add(localDateTimeK);
                    arrayList.add(localDateTimeK.Z(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()));
                } else {
                    arrayList.add(localDateTimeK.Z(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()));
                    arrayList.add(localDateTimeK);
                }
                i2 = i3;
            }
            this.f53470d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f53473g = null;
    }

    public ZoneRules(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f53468b = zoneOffsetArr;
        long[] jArr = f53463i;
        this.f53467a = jArr;
        this.f53469c = jArr;
        this.f53470d = f53465k;
        this.f53471e = zoneOffsetArr;
        this.f53472f = f53464j;
        this.f53473g = null;
    }

    public ZoneRules(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {h(timeZone.getRawOffset())};
        this.f53468b = zoneOffsetArr;
        long[] jArr = f53463i;
        this.f53467a = jArr;
        this.f53469c = jArr;
        this.f53470d = f53465k;
        this.f53471e = zoneOffsetArr;
        this.f53472f = f53464j;
        this.f53473g = timeZone;
    }

    public static ZoneOffset h(int i2) {
        return ZoneOffset.ofTotalSeconds(i2 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f53473g != null ? (byte) 100 : (byte) 1, this);
    }

    public boolean isFixedOffset() {
        b bVar;
        TimeZone timeZone = this.f53473g;
        if (timeZone != null) {
            if (timeZone.useDaylightTime() || timeZone.getDSTSavings() != 0) {
                return false;
            }
            Instant instantNow = Instant.now();
            long epochSecond = instantNow.getEpochSecond();
            if (instantNow.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
                epochSecond++;
            }
            int iC = c(epochSecond, d(instantNow));
            b[] bVarArrB = b(iC);
            int length = bVarArrB.length - 1;
            while (true) {
                if (length >= 0) {
                    bVar = bVarArrB[length];
                    if (epochSecond > bVar.f53477a) {
                        break;
                    }
                    length--;
                } else {
                    bVar = null;
                    if (iC > 1800) {
                        b[] bVarArrB2 = b(iC - 1);
                        int length2 = bVarArrB2.length - 1;
                        while (true) {
                            if (length2 >= 0) {
                                b bVar2 = bVarArrB2[length2];
                                if (epochSecond > bVar2.f53477a) {
                                    bVar = bVar2;
                                    break;
                                }
                                length2--;
                            } else {
                                long jMin = Math.min(epochSecond - 31104000, (Clock.systemUTC().a() / 1000) + 31968000);
                                int offset = timeZone.getOffset((epochSecond - 1) * 1000);
                                long epochDay = LocalDate.of(1800, 1, 1).toEpochDay() * 86400;
                                while (true) {
                                    if (epochDay > jMin) {
                                        break;
                                    }
                                    int offset2 = timeZone.getOffset(jMin * 1000);
                                    if (offset != offset2) {
                                        int iC2 = c(jMin, h(offset2));
                                        b[] bVarArrB3 = b(iC2 + 1);
                                        int length3 = bVarArrB3.length - 1;
                                        while (true) {
                                            if (length3 >= 0) {
                                                bVar = bVarArrB3[length3];
                                                if (epochSecond > bVar.f53477a) {
                                                    break;
                                                }
                                                length3--;
                                            } else {
                                                b[] bVarArrB4 = b(iC2);
                                                bVar = bVarArrB4[bVarArrB4.length - 1];
                                                break;
                                            }
                                        }
                                    } else {
                                        jMin -= 7776000;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (bVar != null) {
                return false;
            }
        } else if (this.f53469c.length != 0) {
            return false;
        }
        return true;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f53473g;
        if (timeZone != null) {
            return h(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f53469c;
        if (jArr.length == 0) {
            return this.f53468b[0];
        }
        long epochSecond = instant.getEpochSecond();
        int length = this.f53472f.length;
        ZoneOffset[] zoneOffsetArr = this.f53471e;
        if (length > 0 && epochSecond > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
            b bVar = null;
            for (int i2 = 0; i2 < bVarArrB.length; i2++) {
                bVar = bVarArrB[i2];
                if (epochSecond < bVar.f53477a) {
                    return bVar.f53479c;
                }
            }
            return bVar.f53480d;
        }
        int iBinarySearch = Arrays.binarySearch(jArr, epochSecond);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return zoneOffsetArr[iBinarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        int totalSeconds = bVar.f53480d.getTotalSeconds();
        ZoneOffset zoneOffset = bVar.f53479c;
        return totalSeconds > zoneOffset.getTotalSeconds() ? Collections.EMPTY_LIST : j$.time.d.c(new Object[]{zoneOffset, bVar.f53480d});
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        if (r9.s(r1) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        if (r9.f53185b.g0() <= r1.f53185b.g0()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r9) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.ZoneRules.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final b[] b(int i2) {
        LocalDate localDateA;
        boolean z;
        Integer num;
        int i3 = 0;
        boolean z2 = true;
        Integer numValueOf = Integer.valueOf(i2);
        ConcurrentHashMap concurrentHashMap = this.f53474h;
        b[] bVarArr = (b[]) concurrentHashMap.get(numValueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f53473g;
        if (timeZone != null) {
            b[] bVarArr2 = f53466l;
            if (i2 < 1800) {
                return bVarArr2;
            }
            LocalDateTime localDateTime = LocalDateTime.MIN;
            LocalDate localDateOf = LocalDate.of(i2 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.c0(0);
            long jB0 = new LocalDateTime(localDateOf, LocalTime.f53187f[0]).b0(this.f53468b[0]);
            int offset = timeZone.getOffset(jB0 * 1000);
            long j2 = 31968000 + jB0;
            while (jB0 < j2) {
                long j3 = jB0 + 7776000;
                if (offset != timeZone.getOffset(j3 * 1000)) {
                    while (j3 - jB0 > 1) {
                        boolean z3 = z2;
                        Integer num2 = numValueOf;
                        long jFloorDiv = Math.floorDiv(j3 + jB0, 2L);
                        if (timeZone.getOffset(jFloorDiv * 1000) == offset) {
                            jB0 = jFloorDiv;
                        } else {
                            j3 = jFloorDiv;
                        }
                        z2 = z3;
                        numValueOf = num2;
                    }
                    z = z2;
                    num = numValueOf;
                    if (timeZone.getOffset(jB0 * 1000) == offset) {
                        jB0 = j3;
                    }
                    ZoneOffset zoneOffsetH = h(offset);
                    int offset2 = timeZone.getOffset(jB0 * 1000);
                    ZoneOffset zoneOffsetH2 = h(offset2);
                    if (c(jB0, zoneOffsetH2) == i2) {
                        b[] bVarArr3 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length + 1);
                        bVarArr3[bVarArr3.length - 1] = new b(jB0, zoneOffsetH, zoneOffsetH2);
                        offset = offset2;
                        bVarArr2 = bVarArr3;
                    } else {
                        offset = offset2;
                    }
                } else {
                    z = z2;
                    num = numValueOf;
                    jB0 = j3;
                }
                z2 = z;
                numValueOf = num;
            }
            Integer num3 = numValueOf;
            if (1916 <= i2 && i2 < 2100) {
                concurrentHashMap.putIfAbsent(num3, bVarArr2);
            }
            return bVarArr2;
        }
        int i4 = 1;
        long j4 = 1;
        e[] eVarArr = this.f53472f;
        b[] bVarArr4 = new b[eVarArr.length];
        int i5 = 0;
        while (i5 < eVarArr.length) {
            e eVar = eVarArr[i5];
            DayOfWeek dayOfWeek = eVar.f53485c;
            Month month = eVar.f53483a;
            byte b2 = eVar.f53484b;
            if (b2 < 0) {
                long j5 = i2;
                int iA = month.A(r.f53253c.C(j5)) + 1 + b2;
                LocalDate localDate = LocalDate.MIN;
                j$.time.temporal.a.YEAR.c0(j5);
                j$.time.temporal.a.DAY_OF_MONTH.c0(iA);
                localDateA = LocalDate.A(i2, month.q(), iA);
                if (dayOfWeek != null) {
                    localDateA = localDateA.b(new m(dayOfWeek.q(), i4));
                }
            } else {
                LocalDate localDate2 = LocalDate.MIN;
                j$.time.temporal.a.YEAR.c0(i2);
                j$.time.temporal.a.DAY_OF_MONTH.c0(b2);
                localDateA = LocalDate.A(i2, month.q(), b2);
                if (dayOfWeek != null) {
                    localDateA = localDateA.b(new m(dayOfWeek.q(), i3));
                }
            }
            long j6 = j4;
            if (eVar.f53487e) {
                localDateA = localDateA.j0(j6);
            }
            LocalDateTime localDateTimeOf = LocalDateTime.of(localDateA, eVar.f53486d);
            int i6 = c.f53481a[eVar.f53488f.ordinal()];
            ZoneOffset zoneOffset = eVar.f53490h;
            if (i6 == 1) {
                localDateTimeOf = localDateTimeOf.Z(zoneOffset.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
            } else if (i6 == 2) {
                localDateTimeOf = localDateTimeOf.Z(zoneOffset.getTotalSeconds() - eVar.f53489g.getTotalSeconds());
            }
            bVarArr4[i5] = new b(localDateTimeOf, zoneOffset, eVar.f53491i);
            i4 = 1;
            i5++;
            j4 = 1;
        }
        if (i2 < 2100) {
            concurrentHashMap.putIfAbsent(numValueOf, bVarArr4);
        }
        return bVarArr4;
    }

    public final boolean g(Instant instant) {
        ZoneOffset zoneOffsetH;
        TimeZone timeZone = this.f53473g;
        if (timeZone != null) {
            zoneOffsetH = h(timeZone.getRawOffset());
        } else {
            int length = this.f53469c.length;
            ZoneOffset[] zoneOffsetArr = this.f53468b;
            if (length == 0) {
                zoneOffsetH = zoneOffsetArr[0];
            } else {
                int iBinarySearch = Arrays.binarySearch(this.f53467a, instant.getEpochSecond());
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 2;
                }
                zoneOffsetH = zoneOffsetArr[iBinarySearch + 1];
            }
        }
        return !zoneOffsetH.equals(d(instant));
    }

    public static int c(long j2, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Math.floorDiv(j2 + zoneOffset.getTotalSeconds(), MMKV.ExpireInDay)).getYear();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneRules) {
            ZoneRules zoneRules = (ZoneRules) obj;
            if (Objects.equals(this.f53473g, zoneRules.f53473g) && Arrays.equals(this.f53467a, zoneRules.f53467a) && Arrays.equals(this.f53468b, zoneRules.f53468b) && Arrays.equals(this.f53469c, zoneRules.f53469c) && Arrays.equals(this.f53471e, zoneRules.f53471e) && Arrays.equals(this.f53472f, zoneRules.f53472f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f53473g) ^ Arrays.hashCode(this.f53467a)) ^ Arrays.hashCode(this.f53468b)) ^ Arrays.hashCode(this.f53469c)) ^ Arrays.hashCode(this.f53471e)) ^ Arrays.hashCode(this.f53472f);
    }

    public final String toString() {
        TimeZone timeZone = this.f53473g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f53468b[r1.length - 1] + "]";
    }
}
