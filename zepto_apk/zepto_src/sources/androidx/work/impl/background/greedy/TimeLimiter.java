package androidx.work.impl.background.greedy;

import androidx.constraintlayout.motion.widget.a;
import androidx.work.impl.DefaultRunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncherImpl;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TimeLimiter {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultRunnableScheduler f12720a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkLauncherImpl f12721b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12722c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12723d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f12724e;

    public TimeLimiter(DefaultRunnableScheduler runnableScheduler, WorkLauncherImpl launcher) {
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        long millis = TimeUnit.MINUTES.toMillis(90L);
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.f12720a = runnableScheduler;
        this.f12721b = launcher;
        this.f12722c = millis;
        this.f12723d = new Object();
        this.f12724e = new LinkedHashMap();
    }

    public final void a(StartStopToken token) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(token, "token");
        synchronized (this.f12723d) {
            runnable = (Runnable) this.f12724e.remove(token);
        }
        if (runnable != null) {
            this.f12720a.a(runnable);
        }
    }

    public final void b(StartStopToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        a aVar = new a(12, this, token);
        synchronized (this.f12723d) {
        }
        this.f12720a.b(this.f12722c, aVar);
    }
}
