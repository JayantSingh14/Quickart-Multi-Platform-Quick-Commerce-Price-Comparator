package androidx.media3.exoplayer;

import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import java.util.concurrent.TimeoutException;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlayerMessage {

    /* renamed from: a, reason: collision with root package name */
    public final Target f6340a;

    /* renamed from: b, reason: collision with root package name */
    public final Sender f6341b;

    /* renamed from: c, reason: collision with root package name */
    public final SystemClock f6342c;

    /* renamed from: d, reason: collision with root package name */
    public int f6343d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6344e;

    /* renamed from: f, reason: collision with root package name */
    public final Looper f6345f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6346g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6347h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6348i;

    public interface Sender {
        void b(PlayerMessage playerMessage);
    }

    public interface Target {
        void o(int i2, Object obj);
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i2, SystemClock systemClock, Looper looper) {
        this.f6341b = sender;
        this.f6340a = target;
        this.f6345f = looper;
        this.f6342c = systemClock;
    }

    public final synchronized void a(long j2) {
        boolean z;
        Assertions.g(this.f6346g);
        Assertions.g(this.f6345f.getThread() != Thread.currentThread());
        this.f6342c.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() + j2;
        while (true) {
            z = this.f6348i;
            if (z || j2 <= 0) {
                break;
            }
            this.f6342c.getClass();
            wait(j2);
            this.f6342c.getClass();
            j2 = jElapsedRealtime - android.os.SystemClock.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery timed out.");
        }
    }

    public final synchronized void b(boolean z) {
        this.f6347h = z | this.f6347h;
        this.f6348i = true;
        notifyAll();
    }

    public final void c() {
        Assertions.g(!this.f6346g);
        this.f6346g = true;
        this.f6341b.b(this);
    }
}
