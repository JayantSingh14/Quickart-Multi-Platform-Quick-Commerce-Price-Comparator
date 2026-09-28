package ch.qos.logback.core.status;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.PrintStream;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class OnPrintStreamStatusListenerBase extends ContextAwareBase implements StatusListener, LifeCycle {

    /* renamed from: d, reason: collision with root package name */
    public boolean f13744d = false;

    /* renamed from: e, reason: collision with root package name */
    public final long f13745e = 300;

    public abstract PrintStream T1();

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13744d;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13744d = true;
        long j2 = this.f13745e;
        if (j2 <= 0 || this.f13733b == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = this.f13733b.D().b().iterator();
        while (it.hasNext()) {
            Status status = (Status) it.next();
            if (jCurrentTimeMillis - status.b().longValue() < j2) {
                StringBuilder sb = new StringBuilder();
                StatusPrinter.a(sb, "", status);
                T1().print(sb);
            }
        }
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13744d = false;
    }

    @Override // ch.qos.logback.core.status.StatusListener
    public final void z0(StatusBase statusBase) {
        if (this.f13744d) {
            StringBuilder sb = new StringBuilder();
            StatusPrinter.a(sb, "", statusBase);
            T1().print(sb);
        }
    }
}
