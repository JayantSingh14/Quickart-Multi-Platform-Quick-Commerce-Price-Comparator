package j$.time.temporal;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53426a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f53427b;

    public /* synthetic */ m(int i2, int i3) {
        this.f53426a = i3;
        this.f53427b = i2;
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        switch (this.f53426a) {
            case 0:
                int iJ = temporal.j(a.DAY_OF_WEEK);
                int i2 = this.f53427b;
                if (iJ == i2) {
                    return temporal;
                }
                return temporal.c(iJ - i2 >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            default:
                int iJ2 = temporal.j(a.DAY_OF_WEEK);
                int i3 = this.f53427b;
                if (iJ2 == i3) {
                    return temporal;
                }
                return temporal.d(i3 - iJ2 >= 0 ? 7 - r1 : -r1, ChronoUnit.DAYS);
        }
    }
}
