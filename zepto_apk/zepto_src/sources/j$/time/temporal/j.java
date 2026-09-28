package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.format.B;
import j$.time.format.C;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'JULIAN_DAY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class j implements n {
    public static final j JULIAN_DAY;
    public static final j MODIFIED_JULIAN_DAY;
    public static final j RATA_DIE;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ j[] f53421d;
    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a, reason: collision with root package name */
    public final transient String f53422a;

    /* renamed from: b, reason: collision with root package name */
    public final transient q f53423b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f53424c;

    @Override // j$.time.temporal.n
    public final boolean X() {
        return true;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f53421d.clone();
    }

    static {
        ChronoUnit chronoUnit = ChronoUnit.DAYS;
        ChronoUnit chronoUnit2 = ChronoUnit.FOREVER;
        j jVar = new j("JULIAN_DAY", 0, "JulianDay", chronoUnit, chronoUnit2, 2440588L);
        JULIAN_DAY = jVar;
        j jVar2 = new j("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", chronoUnit, chronoUnit2, 40587L);
        MODIFIED_JULIAN_DAY = jVar2;
        j jVar3 = new j("RATA_DIE", 2, "RataDie", chronoUnit, chronoUnit2, 719163L);
        RATA_DIE = jVar3;
        f53421d = new j[]{jVar, jVar2, jVar3};
    }

    public j(String str, int i2, String str2, ChronoUnit chronoUnit, ChronoUnit chronoUnit2, long j2) {
        this.f53422a = str2;
        this.f53423b = q.f((-365243219162L) + j2, 365241780471L + j2);
        this.f53424c = j2;
    }

    @Override // j$.time.temporal.n
    public final q A() {
        return this.f53423b;
    }

    @Override // j$.time.temporal.n
    public final q K(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.g(a.EPOCH_DAY)) {
            return this.f53423b;
        }
        throw new DateTimeException("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.n
    public final boolean Z(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.n
    public final long s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY) + this.f53424c;
    }

    @Override // j$.time.temporal.n
    public final Temporal q(Temporal temporal, long j2) {
        if (!this.f53423b.e(j2)) {
            throw new DateTimeException("Invalid value: " + this.f53422a + StringUtils.SPACE + j2);
        }
        return temporal.a(Math.subtractExact(j2, this.f53424c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.n
    public final TemporalAccessor J(HashMap map, B b2, C c2) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.k kVarE = j$.time.chrono.k.E(b2);
        C c3 = C.LENIENT;
        long j2 = this.f53424c;
        if (c2 == c3) {
            return kVarE.r(Math.subtractExact(jLongValue, j2));
        }
        this.f53423b.b(jLongValue, this);
        return kVarE.r(jLongValue - j2);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f53422a;
    }
}
