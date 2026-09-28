package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class ThreadState extends JobNode {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54161g = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state$volatile");
    private volatile /* synthetic */ int _state$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final Thread f54162e = Thread.currentThread();

    /* renamed from: f, reason: collision with root package name */
    public DisposableHandle f54163f;

    public static void o(int i2) {
        throw new IllegalStateException(("Illegal state " + i2).toString());
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f54161g;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    return;
                }
                o(i2);
                throw null;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 2));
        this.f54162e.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void n() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f54161g;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        o(i2);
                        throw null;
                    }
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i2, 1)) {
                DisposableHandle disposableHandle = this.f54163f;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }
}
