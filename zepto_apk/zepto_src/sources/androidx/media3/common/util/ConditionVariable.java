package androidx.media3.common.util;

@UnstableApi
/* loaded from: classes3.dex */
public class ConditionVariable {

    /* renamed from: a, reason: collision with root package name */
    public final SystemClock f5669a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5670b;

    public ConditionVariable() {
        this(0);
    }

    public final synchronized void a() {
        while (!this.f5670b) {
            wait();
        }
    }

    public final synchronized boolean b(long j2) {
        if (j2 <= 0) {
            return this.f5670b;
        }
        this.f5669a.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j3 = j2 + jElapsedRealtime;
        if (j3 < jElapsedRealtime) {
            a();
        } else {
            while (!this.f5670b && jElapsedRealtime < j3) {
                wait(j3 - jElapsedRealtime);
                this.f5669a.getClass();
                jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            }
        }
        return this.f5670b;
    }

    public final synchronized void c() {
        this.f5670b = false;
    }

    public final synchronized boolean d() {
        return this.f5670b;
    }

    public final synchronized boolean e() {
        if (this.f5670b) {
            return false;
        }
        this.f5670b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(int i2) {
        this.f5669a = Clock.f5662a;
    }
}
