package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DayOfWeek implements TemporalAccessor, j$.time.temporal.l {
    public static final DayOfWeek FRIDAY;
    public static final DayOfWeek MONDAY;
    public static final DayOfWeek SATURDAY;
    public static final DayOfWeek SUNDAY;
    public static final DayOfWeek THURSDAY;
    public static final DayOfWeek TUESDAY;
    public static final DayOfWeek WEDNESDAY;

    /* renamed from: a, reason: collision with root package name */
    public static final DayOfWeek[] f53173a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DayOfWeek[] f53174b;

    public static DayOfWeek valueOf(String str) {
        return (DayOfWeek) Enum.valueOf(DayOfWeek.class, str);
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) f53174b.clone();
    }

    static {
        DayOfWeek dayOfWeek = new DayOfWeek("MONDAY", 0);
        MONDAY = dayOfWeek;
        DayOfWeek dayOfWeek2 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = dayOfWeek2;
        DayOfWeek dayOfWeek3 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = dayOfWeek3;
        DayOfWeek dayOfWeek4 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = dayOfWeek4;
        DayOfWeek dayOfWeek5 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = dayOfWeek5;
        DayOfWeek dayOfWeek6 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = dayOfWeek6;
        DayOfWeek dayOfWeek7 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = dayOfWeek7;
        f53174b = new DayOfWeek[]{dayOfWeek, dayOfWeek2, dayOfWeek3, dayOfWeek4, dayOfWeek5, dayOfWeek6, dayOfWeek7};
        f53173a = values();
    }

    public static DayOfWeek s(int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + i2);
        }
        return f53173a[i2 - 1];
    }

    public final int q() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.DAY_OF_WEEK : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return nVar.A();
        }
        return super.l(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return q();
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return q();
        }
        if (nVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
        return nVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.DAYS;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        return temporal.a(q(), j$.time.temporal.a.DAY_OF_WEEK);
    }
}
