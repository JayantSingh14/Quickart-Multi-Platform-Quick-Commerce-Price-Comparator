package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes2.dex */
public final class LocalTime implements Temporal, j$.time.temporal.l, Comparable<LocalTime>, Serializable {
    public static final LocalTime MAX;
    public static final LocalTime MIN;

    /* renamed from: e, reason: collision with root package name */
    public static final LocalTime f53186e;

    /* renamed from: f, reason: collision with root package name */
    public static final LocalTime[] f53187f = new LocalTime[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a, reason: collision with root package name */
    public final byte f53188a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f53189b;

    /* renamed from: c, reason: collision with root package name */
    public final byte f53190c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53191d;

    static {
        int i2 = 0;
        while (true) {
            LocalTime[] localTimeArr = f53187f;
            if (i2 < localTimeArr.length) {
                localTimeArr[i2] = new LocalTime(i2, 0, 0, 0);
                i2++;
            } else {
                LocalTime localTime = localTimeArr[0];
                f53186e = localTime;
                LocalTime localTime2 = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static LocalTime of(int i2, int i3, int i4, int i5) {
        j$.time.temporal.a.HOUR_OF_DAY.c0(i2);
        j$.time.temporal.a.MINUTE_OF_HOUR.c0(i3);
        j$.time.temporal.a.SECOND_OF_MINUTE.c0(i4);
        j$.time.temporal.a.NANO_OF_SECOND.c0(i5);
        return s(i2, i3, i4, i5);
    }

    public static LocalTime K(long j2) {
        j$.time.temporal.a.NANO_OF_DAY.c0(j2);
        int i2 = (int) (j2 / 3600000000000L);
        long j3 = j2 - (i2 * 3600000000000L);
        int i3 = (int) (j3 / 60000000000L);
        long j4 = j3 - (i3 * 60000000000L);
        int i4 = (int) (j4 / 1000000000);
        return s(i2, i3, i4, (int) (j4 - (i4 * 1000000000)));
    }

    public static LocalTime A(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalTime localTime = (LocalTime) temporalAccessor.e(j$.time.temporal.o.f53434g);
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static LocalTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.f53283g;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, new f(2));
    }

    public static LocalTime s(int i2, int i3, int i4, int i5) {
        if ((i3 | i4 | i5) == 0) {
            return f53187f[i2];
        }
        return new LocalTime(i2, i3, i4, i5);
    }

    public LocalTime(int i2, int i3, int i4, int i5) {
        this.f53188a = (byte) i2;
        this.f53189b = (byte) i3;
        this.f53190c = (byte) i4;
        this.f53191d = i5;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).d0();
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return J(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar == j$.time.temporal.a.NANO_OF_DAY) {
                return g0();
            }
            if (nVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return g0() / 1000;
            }
            return J(nVar);
        }
        return nVar.s(this);
    }

    public final int J(j$.time.temporal.n nVar) {
        int i2 = i.f53381a[((j$.time.temporal.a) nVar).ordinal()];
        byte b2 = this.f53189b;
        int i3 = this.f53191d;
        byte b3 = this.f53188a;
        switch (i2) {
            case 1:
                return i3;
            case 2:
                throw new j$.time.temporal.p("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return i3 / 1000;
            case 4:
                throw new j$.time.temporal.p("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return i3 / 1000000;
            case 6:
                return (int) (g0() / 1000000);
            case 7:
                return this.f53190c;
            case 8:
                return toSecondOfDay();
            case 9:
                return b2;
            case 10:
                return (b3 * 60) + b2;
            case 11:
                return b3 % 12;
            case 12:
                int i4 = b3 % 12;
                if (i4 % 12 == 0) {
                    return 12;
                }
                return i4;
            case 14:
                if (b3 == 0) {
                    return 24;
                }
            case 13:
                return b3;
            case 15:
                return b3 / 12;
            default:
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
    }

    public int getHour() {
        return this.f53188a;
    }

    public int getMinute() {
        return this.f53189b;
    }

    public int getSecond() {
        return this.f53190c;
    }

    public int getNano() {
        return this.f53191d;
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (LocalTime) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final LocalTime a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (LocalTime) nVar.q(this, j2);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        aVar.c0(j2);
        int i2 = i.f53381a[aVar.ordinal()];
        byte b2 = this.f53189b;
        byte b3 = this.f53190c;
        int i3 = this.f53191d;
        byte b4 = this.f53188a;
        switch (i2) {
            case 1:
                return i0((int) j2);
            case 2:
                return K(j2);
            case 3:
                return i0(((int) j2) * 1000);
            case 4:
                return K(j2 * 1000);
            case 5:
                return i0(((int) j2) * 1000000);
            case 6:
                return K(j2 * 1000000);
            case 7:
                int i4 = (int) j2;
                if (b3 != i4) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.c0(i4);
                    return s(b4, b2, i4, i3);
                }
                return this;
            case 8:
                return e0(j2 - toSecondOfDay());
            case 9:
                int i5 = (int) j2;
                if (b2 != i5) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.c0(i5);
                    return s(b4, i5, b3, i3);
                }
                return this;
            case 10:
                return c0(j2 - ((b4 * 60) + b2));
            case 11:
                return Z(j2 - (b4 % 12));
            case 12:
                if (j2 == 12) {
                    j2 = 0;
                }
                return Z(j2 - (b4 % 12));
            case 13:
                int i6 = (int) j2;
                if (b4 != i6) {
                    j$.time.temporal.a.HOUR_OF_DAY.c0(i6);
                    return s(i6, b2, b3, i3);
                }
                return this;
            case 14:
                if (j2 == 24) {
                    j2 = 0;
                }
                int i7 = (int) j2;
                if (b4 != i7) {
                    j$.time.temporal.a.HOUR_OF_DAY.c0(i7);
                    return s(i7, b2, b3, i3);
                }
                return this;
            case 15:
                return Z((j2 - (b4 / 12)) * 12);
            default:
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
    }

    public final LocalTime i0(int i2) {
        if (this.f53191d == i2) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.c0(i2);
        return s(this.f53188a, this.f53189b, this.f53190c, i2);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final LocalTime c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (i.f53382b[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return d0(j2);
                case 2:
                    return d0((j2 % 86400000000L) * 1000);
                case 3:
                    return d0((j2 % DateUtils.MILLIS_PER_DAY) * 1000000);
                case 4:
                    return e0(j2);
                case 5:
                    return c0(j2);
                case 6:
                    return Z(j2);
                case 7:
                    return Z((j2 % 2) * 12);
                default:
                    throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalTime) temporalUnit.q(this, j2);
    }

    public final LocalTime Z(long j2) {
        if (j2 == 0) {
            return this;
        }
        return s(((((int) (j2 % 24)) + this.f53188a) + 24) % 24, this.f53189b, this.f53190c, this.f53191d);
    }

    public final LocalTime c0(long j2) {
        if (j2 != 0) {
            int i2 = (this.f53188a * 60) + this.f53189b;
            int i3 = ((((int) (j2 % 1440)) + i2) + 1440) % 1440;
            if (i2 != i3) {
                return s(i3 / 60, i3 % 60, this.f53190c, this.f53191d);
            }
        }
        return this;
    }

    public final LocalTime e0(long j2) {
        if (j2 != 0) {
            int i2 = (this.f53189b * 60) + (this.f53188a * 3600) + this.f53190c;
            int i3 = ((((int) (j2 % 86400)) + i2) + MMKV.ExpireInDay) % MMKV.ExpireInDay;
            if (i2 != i3) {
                return s(i3 / MMKV.ExpireInHour, (i3 / 60) % 60, i3 % 60, this.f53191d);
            }
        }
        return this;
    }

    public final LocalTime d0(long j2) {
        if (j2 != 0) {
            long jG0 = g0();
            long j3 = (((j2 % 86400000000000L) + jG0) + 86400000000000L) % 86400000000000L;
            if (jG0 != j3) {
                return s((int) (j3 / 3600000000000L), (int) ((j3 / 60000000000L) % 60), (int) ((j3 / 1000000000) % 60), (int) (j3 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53429b || temporalQuery == j$.time.temporal.o.f53428a || temporalQuery == j$.time.temporal.o.f53432e || temporalQuery == j$.time.temporal.o.f53431d) {
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53434g) {
            return this;
        }
        if (temporalQuery == j$.time.temporal.o.f53433f) {
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        return temporal.a(g0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        LocalTime localTimeA = A(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            long jG0 = localTimeA.g0() - g0();
            switch (i.f53382b[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return jG0;
                case 2:
                    return jG0 / 1000;
                case 3:
                    return jG0 / 1000000;
                case 4:
                    return jG0 / 1000000000;
                case 5:
                    return jG0 / 60000000000L;
                case 6:
                    return jG0 / 3600000000000L;
                case 7:
                    return jG0 / 43200000000000L;
                default:
                    throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
            }
        }
        return temporalUnit.s(this, localTimeA);
    }

    public int toSecondOfDay() {
        return (this.f53189b * 60) + (this.f53188a * 3600) + this.f53190c;
    }

    public final long g0() {
        return (this.f53190c * 1000000000) + (this.f53189b * 60000000000L) + (this.f53188a * 3600000000000L) + this.f53191d;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime localTime) {
        int iCompare = Integer.compare(this.f53188a, localTime.f53188a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.f53189b, localTime.f53189b)) == 0 && (iCompare = Integer.compare(this.f53190c, localTime.f53190c)) == 0) ? Integer.compare(this.f53191d, localTime.f53191d) : iCompare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.f53188a == localTime.f53188a && this.f53189b == localTime.f53189b && this.f53190c == localTime.f53190c && this.f53191d == localTime.f53191d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long jG0 = g0();
        return (int) (jG0 ^ (jG0 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.f53188a;
        sb.append(b2 < 10 ? "0" : "");
        sb.append((int) b2);
        byte b3 = this.f53189b;
        sb.append(b3 < 10 ? ":0" : ":");
        sb.append((int) b3);
        byte b4 = this.f53190c;
        int i2 = this.f53191d;
        if (b4 > 0 || i2 > 0) {
            sb.append(b4 < 10 ? ":0" : ":");
            sb.append((int) b4);
            if (i2 > 0) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                if (i2 % 1000000 == 0) {
                    sb.append(Integer.toString((i2 / 1000000) + 1000).substring(1));
                } else if (i2 % 1000 == 0) {
                    sb.append(Integer.toString((i2 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i2 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void j0(DataOutput dataOutput) {
        byte b2 = this.f53190c;
        byte b3 = this.f53188a;
        byte b4 = this.f53189b;
        int i2 = this.f53191d;
        if (i2 != 0) {
            dataOutput.writeByte(b3);
            dataOutput.writeByte(b4);
            dataOutput.writeByte(b2);
            dataOutput.writeInt(i2);
            return;
        }
        if (b2 != 0) {
            dataOutput.writeByte(b3);
            dataOutput.writeByte(b4);
            dataOutput.writeByte(~b2);
        } else if (b4 == 0) {
            dataOutput.writeByte(~b3);
        } else {
            dataOutput.writeByte(b3);
            dataOutput.writeByte(~b4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    public static LocalTime f0(ObjectInput objectInput) throws IOException {
        int i2;
        int i3;
        int i4 = objectInput.readByte();
        byte b2 = 0;
        if (i4 < 0) {
            i4 = ~i4;
            i3 = 0;
            i2 = 0;
        } else {
            byte b3 = objectInput.readByte();
            if (b3 < 0) {
                ?? r5 = ~b3;
                i2 = 0;
                b2 = r5;
                i3 = 0;
            } else {
                byte b4 = objectInput.readByte();
                if (b4 < 0) {
                    i3 = ~b4;
                    i2 = 0;
                    b2 = b3;
                } else {
                    i2 = objectInput.readInt();
                    b2 = b3;
                    i3 = b4;
                }
            }
        }
        return of(i4, b2, i3, i2);
    }
}
