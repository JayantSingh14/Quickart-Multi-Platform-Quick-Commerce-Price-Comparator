package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* renamed from: j$.time.chrono.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0111c implements ChronoLocalDate, Temporal, j$.time.temporal.l, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract ChronoLocalDate J(long j2);

    public abstract ChronoLocalDate K(long j2);

    public abstract ChronoLocalDate X(long j2);

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal a(long j2, j$.time.temporal.n nVar) {
        return a(j2, nVar);
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: b */
    public /* bridge */ /* synthetic */ Temporal m(LocalDate localDate) {
        return m(localDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal d(long j2, TemporalUnit temporalUnit) {
        return d(j2, temporalUnit);
    }

    public static ChronoLocalDate s(k kVar, Temporal temporal) {
        ChronoLocalDate chronoLocalDate = (ChronoLocalDate) temporal;
        if (kVar.equals(chronoLocalDate.i())) {
            return chronoLocalDate;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + kVar.getId() + ", actual: " + chronoLocalDate.i().getId());
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public ChronoLocalDate c(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return super.c(j2, temporalUnit);
        }
        switch (AbstractC0110b.f53222a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return J(j2);
            case 2:
                return J(Math.multiplyExact(j2, 7));
            case 3:
                return K(j2);
            case 4:
                return X(j2);
            case 5:
                return X(Math.multiplyExact(j2, 10));
            case 6:
                return X(Math.multiplyExact(j2, 100));
            case 7:
                return X(Math.multiplyExact(j2, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(Math.addExact(h(aVar), j2), (j$.time.temporal.n) aVar);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDate chronoLocalDateT = i().t(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            Objects.requireNonNull(temporalUnit, "unit");
            return temporalUnit.s(this, chronoLocalDateT);
        }
        switch (AbstractC0110b.f53222a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return chronoLocalDateT.toEpochDay() - toEpochDay();
            case 2:
                return (chronoLocalDateT.toEpochDay() - toEpochDay()) / 7;
            case 3:
                return A(chronoLocalDateT);
            case 4:
                return A(chronoLocalDateT) / 12;
            case 5:
                return A(chronoLocalDateT) / 120;
            case 6:
                return A(chronoLocalDateT) / 1200;
            case 7:
                return A(chronoLocalDateT) / 12000;
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return chronoLocalDateT.h(aVar) - h(aVar);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    public final long A(ChronoLocalDate chronoLocalDate) {
        if (i().Y(j$.time.temporal.a.MONTH_OF_YEAR).f53438d != 12) {
            throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        long jH = h(aVar) * 32;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_MONTH;
        return (((chronoLocalDate.h(aVar) * 32) + chronoLocalDate.j(aVar2)) - (jH + j(aVar2))) / 32;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int hashCode() {
        long epochDay = toEpochDay();
        return ((int) (epochDay ^ (epochDay >>> 32))) ^ i().hashCode();
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final String toString() {
        long jH = h(j$.time.temporal.a.YEAR_OF_ERA);
        long jH2 = h(j$.time.temporal.a.MONTH_OF_YEAR);
        long jH3 = h(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(i().toString());
        sb.append(StringUtils.SPACE);
        sb.append(u());
        sb.append(StringUtils.SPACE);
        sb.append(jH);
        sb.append(jH2 < 10 ? "-0" : "-");
        sb.append(jH2);
        sb.append(jH3 < 10 ? "-0" : "-");
        sb.append(jH3);
        return sb.toString();
    }
}
