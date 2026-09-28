package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class q implements l {
    public static final q AH;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ q[] f53252a;

    @Override // j$.time.chrono.l
    public final int q() {
        return 1;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f53252a.clone();
    }

    static {
        q qVar = new q("AH", 0);
        AH = qVar;
        f53252a = new q[]{qVar};
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.ERA) {
            return j$.time.temporal.q.f(1L, 1L);
        }
        return super.l(nVar);
    }
}
