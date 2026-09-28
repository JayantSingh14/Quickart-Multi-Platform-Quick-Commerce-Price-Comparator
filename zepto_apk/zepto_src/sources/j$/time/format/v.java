package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

/* loaded from: classes2.dex */
public final class v implements TemporalAccessor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChronoLocalDate f53366a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemporalAccessor f53367b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.k f53368c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f53369d;

    public v(ChronoLocalDate chronoLocalDate, TemporalAccessor temporalAccessor, j$.time.chrono.k kVar, ZoneId zoneId) {
        this.f53366a = chronoLocalDate;
        this.f53367b = temporalAccessor;
        this.f53368c = kVar;
        this.f53369d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        ChronoLocalDate chronoLocalDate = this.f53366a;
        if (chronoLocalDate != null && nVar.X()) {
            return chronoLocalDate.g(nVar);
        }
        return this.f53367b.g(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        ChronoLocalDate chronoLocalDate = this.f53366a;
        if (chronoLocalDate != null && nVar.X()) {
            return chronoLocalDate.l(nVar);
        }
        return this.f53367b.l(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        ChronoLocalDate chronoLocalDate = this.f53366a;
        if (chronoLocalDate != null && nVar.X()) {
            return chronoLocalDate.h(nVar);
        }
        return this.f53367b.h(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return this.f53368c;
        }
        if (temporalQuery == j$.time.temporal.o.f53428a) {
            return this.f53369d;
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return this.f53367b.e(temporalQuery);
        }
        return temporalQuery.queryFrom(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.k kVar = this.f53368c;
        if (kVar != null) {
            str = " with chronology " + kVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f53369d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f53367b + str + str2;
    }
}
