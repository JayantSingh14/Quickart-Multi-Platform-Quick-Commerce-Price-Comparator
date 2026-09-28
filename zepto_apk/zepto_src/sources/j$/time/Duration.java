package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Duration f53175c = new Duration(0, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f53176d = BigInteger.valueOf(1000000000);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f53177a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53178b;

    public static Duration ofMinutes(long j2) {
        return s(Math.multiplyExact(j2, 60), 0);
    }

    public static Duration ofSeconds(long j2) {
        return s(j2, 0);
    }

    public static Duration K(long j2, long j3) {
        return s(Math.addExact(j2, Math.floorDiv(j3, 1000000000L)), (int) Math.floorMod(j3, 1000000000L));
    }

    public static Duration ofMillis(long j2) {
        long j3 = j2 / 1000;
        int i2 = (int) (j2 % 1000);
        if (i2 < 0) {
            i2 += 1000;
            j3--;
        }
        return s(j3, i2 * 1000000);
    }

    public static Duration J(long j2) {
        long j3 = j2 / 1000000000;
        int i2 = (int) (j2 % 1000000000);
        if (i2 < 0) {
            i2 = (int) (i2 + 1000000000);
            j3--;
        }
        return s(j3, i2);
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        try {
            return J(temporal.n(temporal2, ChronoUnit.NANOS));
        } catch (DateTimeException | ArithmeticException unused) {
            long jN = temporal.n(temporal2, ChronoUnit.SECONDS);
            long j2 = 0;
            try {
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                long jH = temporal2.h(aVar) - temporal.h(aVar);
                if (jN > 0 && jH < 0) {
                    jN++;
                } else if (jN < 0 && jH > 0) {
                    jN--;
                }
                j2 = jH;
            } catch (DateTimeException unused2) {
            }
            return K(jN, j2);
        }
    }

    public static Duration s(long j2, int i2) {
        if ((i2 | j2) == 0) {
            return f53175c;
        }
        return new Duration(j2, i2);
    }

    public Duration(long j2, int i2) {
        this.f53177a = j2;
        this.f53178b = i2;
    }

    public boolean isNegative() {
        return this.f53177a < 0;
    }

    public long getSeconds() {
        return this.f53177a;
    }

    public final Duration Z(long j2, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return X(Math.multiplyExact(j2, MMKV.ExpireInDay), 0L);
        }
        if (temporalUnit.A()) {
            throw new j$.time.temporal.p("Unit must not have an estimated duration");
        }
        if (j2 == 0) {
            return this;
        }
        if (temporalUnit instanceof ChronoUnit) {
            int i2 = c.f53209a[((ChronoUnit) temporalUnit).ordinal()];
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? X(Math.multiplyExact(temporalUnit.J().f53177a, j2), 0L) : X(j2, 0L) : X(j2 / 1000, (j2 % 1000) * 1000000) : X((j2 / 1000000000) * 1000, 0L).X(0L, (j2 % 1000000000) * 1000) : X(0L, j2);
        }
        return X(temporalUnit.J().A(j2).getSeconds(), 0L).X(0L, r11.f53178b);
    }

    public final Duration X(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return K(Math.addExact(Math.addExact(this.f53177a, j2), j3 / 1000000000), this.f53178b + (j3 % 1000000000));
    }

    public Duration minus(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? Z(Long.MAX_VALUE, temporalUnit).Z(1L, temporalUnit) : Z(-j2, temporalUnit);
    }

    public final Duration A(long j2) {
        if (j2 == 0) {
            return f53175c;
        }
        if (j2 == 1) {
            return this;
        }
        BigInteger bigIntegerExact = BigDecimal.valueOf(this.f53177a).add(BigDecimal.valueOf(this.f53178b, 9)).multiply(BigDecimal.valueOf(j2)).movePointRight(9).toBigIntegerExact();
        BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerExact.divideAndRemainder(f53176d);
        if (bigIntegerArrDivideAndRemainder[0].bitLength() > 63) {
            throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
        }
        return K(bigIntegerArrDivideAndRemainder[0].longValue(), bigIntegerArrDivideAndRemainder[1].intValue());
    }

    public Duration abs() {
        return isNegative() ? A(-1L) : this;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal q(Temporal temporal) {
        long j2 = this.f53177a;
        if (j2 != 0) {
            temporal = temporal.c(j2, ChronoUnit.SECONDS);
        }
        int i2 = this.f53178b;
        return i2 != 0 ? temporal.c(i2, ChronoUnit.NANOS) : temporal;
    }

    public long toMillis() {
        long j2 = this.f53178b;
        long j3 = this.f53177a;
        if (j3 < 0) {
            j3++;
            j2 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j3, 1000), j2 / 1000000);
    }

    public long toNanos() {
        long j2 = this.f53178b;
        long j3 = this.f53177a;
        if (j3 < 0) {
            j3++;
            j2 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j3, 1000000000L), j2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int iCompare = Long.compare(this.f53177a, duration.f53177a);
        return iCompare != 0 ? iCompare : this.f53178b - duration.f53178b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f53177a == duration.f53177a && this.f53178b == duration.f53178b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f53177a;
        return (this.f53178b * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        if (this == f53175c) {
            return "PT0S";
        }
        long j2 = this.f53177a;
        int i2 = this.f53178b;
        long j3 = (j2 >= 0 || i2 <= 0) ? j2 : 1 + j2;
        long j4 = j3 / 3600;
        int i3 = (int) ((j3 % 3600) / 60);
        int i4 = (int) (j3 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j4 != 0) {
            sb.append(j4);
            sb.append('H');
        }
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        if (i4 == 0 && i2 == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j2 < 0 && i2 > 0 && i4 == 0) {
            sb.append("-0");
        } else {
            sb.append(i4);
        }
        if (i2 > 0) {
            int length = sb.length();
            if (j2 < 0) {
                sb.append(2000000000 - i2);
            } else {
                sb.append(i2 + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
