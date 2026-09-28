package ch.qos.logback.core.hook;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.util.Duration;

/* loaded from: classes3.dex */
public class DelayingShutdownHook extends ShutdownHookBase {

    /* renamed from: e, reason: collision with root package name */
    public static final Duration f13486e = new Duration((long) 0.0d);

    /* renamed from: d, reason: collision with root package name */
    public final Duration f13487d = f13486e;

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        StringBuilder sb = new StringBuilder("Sleeping for ");
        Duration duration = this.f13487d;
        sb.append(duration);
        s1(sb.toString());
        try {
            Thread.sleep(duration.f13804a);
        } catch (InterruptedException unused) {
        }
        s1("Logback context being closed via shutdown hook");
        Context context = this.f13733b;
        if (context instanceof ContextBase) {
            ((ContextBase) context).stop();
        }
    }
}
