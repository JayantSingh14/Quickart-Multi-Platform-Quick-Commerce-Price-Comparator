package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public class InterruptUtil extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13811d;

    public InterruptUtil(Context context) {
        V(context);
        this.f13811d = Thread.currentThread().isInterrupted();
    }

    public final void T1() {
        if (this.f13811d) {
            try {
                Thread.currentThread().interrupt();
            } catch (SecurityException e2) {
                o1("Failed to intrreupt current thread", e2);
            }
        }
    }
}
