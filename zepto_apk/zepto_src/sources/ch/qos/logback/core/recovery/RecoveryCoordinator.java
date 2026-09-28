package ch.qos.logback.core.recovery;

/* loaded from: classes3.dex */
public class RecoveryCoordinator {

    /* renamed from: a, reason: collision with root package name */
    public long f13704a;

    /* renamed from: b, reason: collision with root package name */
    public long f13705b;

    public RecoveryCoordinator() {
        this.f13704a = 20L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f13704a;
        if (j2 < 327680) {
            this.f13704a = 4 * j2;
        }
        this.f13705b = j2 + jCurrentTimeMillis;
    }
}
