package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

/* loaded from: classes2.dex */
public interface l extends TemporalAccessor, j$.time.temporal.l {
    int q();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.ERA : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int j(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.ERA) {
            return q();
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long h(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.ERA) {
            return q();
        }
        if (nVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
        return nVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.ERAS;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    default Temporal f(Temporal temporal) {
        return temporal.a(q(), j$.time.temporal.a.ERA);
    }
}
