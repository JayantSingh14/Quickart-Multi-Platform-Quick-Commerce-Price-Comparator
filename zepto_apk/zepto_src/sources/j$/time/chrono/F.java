package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class F extends AbstractC0109a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final F f53216c = new F();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // j$.time.chrono.k
    public final l S(int i2) {
        if (i2 == 0) {
            return I.BEFORE_BE;
        }
        if (i2 == 1) {
            return I.BE;
        }
        throw new DateTimeException("Invalid era: " + i2);
    }

    @Override // j$.time.chrono.k
    public final String getId() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.k
    public final String W() {
        return "buddhist";
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate F(int i2, int i3, int i4) {
        return new H(LocalDate.of(i2 - 543, i3, i4));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate y(int i2, int i3) {
        return new H(LocalDate.h0(i2 - 543, i3));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate r(long j2) {
        return new H(LocalDate.ofEpochDay(j2));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate O() {
        return new H(LocalDate.J(LocalDate.g0(Clock.b())));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof H) {
            return (H) temporalAccessor;
        }
        return new H(LocalDate.J(temporalAccessor));
    }

    @Override // j$.time.chrono.k
    public final boolean C(long j2) {
        return r.f53253c.C(j2 - 543);
    }

    @Override // j$.time.chrono.k
    public final int v(l lVar, int i2) {
        if (lVar instanceof I) {
            return lVar == I.BE ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    private F() {
    }

    @Override // j$.time.chrono.k
    public final List B() {
        return j$.time.d.c(I.values());
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.q Y(j$.time.temporal.a aVar) {
        int i2 = E.f53215a[aVar.ordinal()];
        if (i2 == 1) {
            j$.time.temporal.q qVar = j$.time.temporal.a.PROLEPTIC_MONTH.f53410b;
            return j$.time.temporal.q.f(qVar.f53435a + 6516, qVar.f53438d + 6516);
        }
        if (i2 == 2) {
            j$.time.temporal.q qVar2 = j$.time.temporal.a.YEAR.f53410b;
            return j$.time.temporal.q.g(1L, (-(qVar2.f53435a + 543)) + 1, qVar2.f53438d + 543);
        }
        if (i2 != 3) {
            return aVar.f53410b;
        }
        j$.time.temporal.q qVar3 = j$.time.temporal.a.YEAR.f53410b;
        return j$.time.temporal.q.f(qVar3.f53435a + 543, qVar3.f53438d + 543);
    }

    @Override // j$.time.chrono.AbstractC0109a, j$.time.chrono.k
    public final ChronoLocalDate U(Map map, j$.time.format.C c2) {
        return (H) super.U(map, c2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.k
    public final InterfaceC0116h w(Instant instant, ZoneId zoneId) {
        return j.J(this, instant, zoneId);
    }

    public Object writeReplace() {
        return new D((byte) 1, this);
    }
}
