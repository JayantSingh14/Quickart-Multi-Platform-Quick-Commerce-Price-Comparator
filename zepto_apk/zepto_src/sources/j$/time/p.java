package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class p implements TemporalAmount, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final p f53393d = new p(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a, reason: collision with root package name */
    public final int f53394a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53395b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53396c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        d.c(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    public static p a(int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return f53393d;
        }
        return new p(i2, i3, i4);
    }

    public p(int i2, int i3, int i4) {
        this.f53394a = i2;
        this.f53395b = i3;
        this.f53396c = i4;
    }

    @Override // j$.time.temporal.TemporalAmount
    public final Temporal q(Temporal temporal) {
        j$.time.chrono.k kVar = (j$.time.chrono.k) temporal.e(j$.time.temporal.o.f53429b);
        if (kVar == null || j$.time.chrono.r.f53253c.equals(kVar)) {
            int i2 = this.f53394a;
            int i3 = this.f53395b;
            if (i3 != 0) {
                long j2 = (i2 * 12) + i3;
                if (j2 != 0) {
                    temporal = temporal.c(j2, ChronoUnit.MONTHS);
                }
            } else if (i2 != 0) {
                temporal = temporal.c(i2, ChronoUnit.YEARS);
            }
            int i4 = this.f53396c;
            return i4 != 0 ? temporal.c(i4, ChronoUnit.DAYS) : temporal;
        }
        throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + kVar.getId());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f53394a == pVar.f53394a && this.f53395b == pVar.f53395b && this.f53396c == pVar.f53396c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f53396c, 16) + Integer.rotateLeft(this.f53395b, 8) + this.f53394a;
    }

    public final String toString() {
        if (this == f53393d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i2 = this.f53394a;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('Y');
        }
        int i3 = this.f53395b;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.f53396c;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
