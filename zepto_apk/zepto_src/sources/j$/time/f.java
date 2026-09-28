package j$.time;

import j$.time.format.DateTimeFormatterBuilder;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;

/* loaded from: classes2.dex */
public final /* synthetic */ class f implements TemporalQuery, j$.time.temporal.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53271a;

    public /* synthetic */ f(int i2) {
        this.f53271a = i2;
    }

    @Override // j$.time.temporal.l
    public Temporal f(Temporal temporal) {
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return temporal.a(temporal.l(aVar).f53438d, aVar);
    }

    @Override // j$.time.temporal.TemporalQuery
    public Object queryFrom(TemporalAccessor temporalAccessor) {
        f fVar = j$.time.temporal.o.f53428a;
        switch (this.f53271a) {
            case 0:
                return LocalDate.J(temporalAccessor);
            case 1:
                return LocalDateTime.A(temporalAccessor);
            case 2:
                return LocalTime.A(temporalAccessor);
            case 3:
                f fVar2 = DateTimeFormatterBuilder.f53292h;
                ZoneId zoneId = (ZoneId) temporalAccessor.e(fVar);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 4:
            default:
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.g(aVar)) {
                    return LocalTime.K(temporalAccessor.h(aVar));
                }
                return null;
            case 5:
                return (ZoneId) temporalAccessor.e(fVar);
            case 6:
                return (j$.time.chrono.k) temporalAccessor.e(j$.time.temporal.o.f53429b);
            case 7:
                return (TemporalUnit) temporalAccessor.e(j$.time.temporal.o.f53430c);
            case 8:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.g(aVar2)) {
                    return ZoneOffset.ofTotalSeconds(temporalAccessor.j(aVar2));
                }
                return null;
            case 9:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.e(fVar);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.e(j$.time.temporal.o.f53431d);
            case 10:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.g(aVar3)) {
                    return LocalDate.ofEpochDay(temporalAccessor.h(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f53271a) {
            case 5:
                return "ZoneId";
            case 6:
                return "Chronology";
            case 7:
                return "Precision";
            case 8:
                return "ZoneOffset";
            case 9:
                return "Zone";
            case 10:
                return "LocalDate";
            case 11:
                return "LocalTime";
            default:
                return super.toString();
        }
    }
}
