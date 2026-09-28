package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public class CancellationTokenSource implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13184a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13185b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f13186c = BoltsExecutors.f13179d.f13181b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13187d;

    /* renamed from: bolts.CancellationTokenSource$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f13184a) {
            try {
                if (this.f13187d) {
                    return;
                }
                Iterator it = this.f13185b.iterator();
                if (it.hasNext()) {
                    ((CancellationTokenRegistration) it.next()).getClass();
                    throw null;
                }
                this.f13185b.clear();
                this.f13187d = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Locale locale = Locale.US;
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        synchronized (this.f13184a) {
            if (this.f13187d) {
                throw new IllegalStateException("Object already closed");
            }
        }
        return name + "@" + hexString + "[cancellationRequested=" + Boolean.toString(false) + "]";
    }
}
