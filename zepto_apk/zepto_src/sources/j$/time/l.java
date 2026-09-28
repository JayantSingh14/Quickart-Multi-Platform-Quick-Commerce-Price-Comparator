package j$.time;

import j$.time.format.DateTimeFormatterBuilder;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes2.dex */
public final class l implements TemporalAccessor, j$.time.temporal.l, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f53385c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a, reason: collision with root package name */
    public final int f53386a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53387b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        l lVar = (l) obj;
        int i2 = this.f53386a - lVar.f53386a;
        return i2 == 0 ? this.f53387b - lVar.f53387b : i2;
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.e("--");
        dateTimeFormatterBuilder.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        dateTimeFormatterBuilder.d(Soundex.SILENT_MARKER);
        dateTimeFormatterBuilder.k(j$.time.temporal.a.DAY_OF_MONTH, 2);
        dateTimeFormatterBuilder.toFormatter();
    }

    public l(int i2, int i3) {
        this.f53386a = i2;
        this.f53387b = i3;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.MONTH_OF_YEAR || nVar == j$.time.temporal.a.DAY_OF_MONTH : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return nVar.A();
        }
        if (nVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return super.l(nVar);
        }
        Month monthK = Month.K(this.f53386a);
        monthK.getClass();
        int i2 = j.f53383a[monthK.ordinal()];
        return j$.time.temporal.q.g(1L, i2 != 1 ? (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) ? 30 : 31 : 28, Month.K(r8).J());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        return l(nVar).a(h(nVar), nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        int i2;
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.s(this);
        }
        int i3 = k.f53384a[((j$.time.temporal.a) nVar).ordinal()];
        if (i3 == 1) {
            i2 = this.f53387b;
        } else {
            if (i3 != 2) {
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
            }
            i2 = this.f53386a;
        }
        return i2;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return j$.time.chrono.r.f53253c;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        if (!j$.time.chrono.k.E(temporal).equals(j$.time.chrono.r.f53253c)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        Temporal temporalA = temporal.a(this.f53386a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return temporalA.a(Math.min(temporalA.l(aVar).f53438d, this.f53387b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f53386a == lVar.f53386a && this.f53387b == lVar.f53387b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f53386a << 6) + this.f53387b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        int i2 = this.f53386a;
        sb.append(i2 < 10 ? "0" : "");
        sb.append(i2);
        int i3 = this.f53387b;
        sb.append(i3 < 10 ? "-0" : "-");
        sb.append(i3);
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
