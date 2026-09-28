package j$.time.temporal;

import j$.time.DateTimeException;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface TemporalAccessor {
    boolean g(n nVar);

    long h(n nVar);

    default q l(n nVar) {
        if (!(nVar instanceof a)) {
            Objects.requireNonNull(nVar, "field");
            return nVar.K(this);
        }
        if (g(nVar)) {
            return ((a) nVar).f53410b;
        }
        throw new p(j$.time.b.a("Unsupported field: ", nVar));
    }

    default int j(n nVar) {
        q qVarL = l(nVar);
        if (!qVarL.d()) {
            throw new p("Invalid field " + nVar + " for get() method, use getLong() instead");
        }
        long jH = h(nVar);
        if (qVarL.e(jH)) {
            return (int) jH;
        }
        throw new DateTimeException("Invalid value for " + nVar + " (valid values " + qVarL + "): " + jH);
    }

    default Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == o.f53428a || temporalQuery == o.f53429b || temporalQuery == o.f53430c) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }
}
