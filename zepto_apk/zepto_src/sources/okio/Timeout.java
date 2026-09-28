package okio;

import android.support.v4.media.b;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class Timeout {

    /* renamed from: d, reason: collision with root package name */
    public static final Timeout$Companion$NONE$1 f57001d = new Timeout$Companion$NONE$1();

    /* renamed from: a, reason: collision with root package name */
    public boolean f57002a;

    /* renamed from: b, reason: collision with root package name */
    public long f57003b;

    /* renamed from: c, reason: collision with root package name */
    public long f57004c;

    @Metadata
    public static final class Companion {
    }

    public Timeout a() {
        this.f57002a = false;
        return this;
    }

    public Timeout b() {
        this.f57004c = 0L;
        return this;
    }

    public long c() {
        if (this.f57002a) {
            return this.f57003b;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout d(long j2) {
        this.f57002a = true;
        this.f57003b = j2;
        return this;
    }

    public boolean e() {
        return this.f57002a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f57002a && this.f57003b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout g(long j2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "timeout < 0: ").toString());
        }
        this.f57004c = unit.toNanos(j2);
        return this;
    }

    public long h() {
        return this.f57004c;
    }
}
