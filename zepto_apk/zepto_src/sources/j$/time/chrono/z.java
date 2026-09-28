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
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class z extends AbstractC0109a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final z f53268c = new z();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.k
    public final String getId() {
        return "Minguo";
    }

    @Override // j$.time.chrono.k
    public final l S(int i2) {
        if (i2 == 0) {
            return C.BEFORE_ROC;
        }
        if (i2 == 1) {
            return C.ROC;
        }
        throw new DateTimeException("Invalid era: " + i2);
    }

    @Override // j$.time.chrono.k
    public final String W() {
        return "roc";
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate F(int i2, int i3, int i4) {
        return new B(LocalDate.of(i2 + 1911, i3, i4));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate y(int i2, int i3) {
        return new B(LocalDate.h0(i2 + 1911, i3));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate r(long j2) {
        return new B(LocalDate.ofEpochDay(j2));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate O() {
        return new B(LocalDate.J(LocalDate.g0(Clock.b())));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof B) {
            return (B) temporalAccessor;
        }
        return new B(LocalDate.J(temporalAccessor));
    }

    @Override // j$.time.chrono.k
    public final boolean C(long j2) {
        return r.f53253c.C(j2 + 1911);
    }

    @Override // j$.time.chrono.k
    public final int v(l lVar, int i2) {
        if (lVar instanceof C) {
            return lVar == C.ROC ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.k
    public final List B() {
        return j$.time.d.c(C.values());
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.q Y(j$.time.temporal.a aVar) {
        int i2 = y.f53267a[aVar.ordinal()];
        if (i2 == 1) {
            j$.time.temporal.q qVar = j$.time.temporal.a.PROLEPTIC_MONTH.f53410b;
            return j$.time.temporal.q.f(qVar.f53435a - 22932, qVar.f53438d - 22932);
        }
        if (i2 == 2) {
            j$.time.temporal.q qVar2 = j$.time.temporal.a.YEAR.f53410b;
            return j$.time.temporal.q.g(1L, qVar2.f53438d - 1911, (-qVar2.f53435a) + 1912);
        }
        if (i2 != 3) {
            return aVar.f53410b;
        }
        j$.time.temporal.q qVar3 = j$.time.temporal.a.YEAR.f53410b;
        return j$.time.temporal.q.f(qVar3.f53435a - 1911, qVar3.f53438d - 1911);
    }

    @Override // j$.time.chrono.AbstractC0109a, j$.time.chrono.k
    public final ChronoLocalDate U(Map map, j$.time.format.C c2) {
        return (B) super.U(map, c2);
    }

    private z() {
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
