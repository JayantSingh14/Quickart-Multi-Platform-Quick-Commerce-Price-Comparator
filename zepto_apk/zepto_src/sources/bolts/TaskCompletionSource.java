package bolts;

/* loaded from: classes3.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Task f13213a = new Task();

    public final void a() {
        if (!this.f13213a.j()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void b(Exception exc) {
        Task task = this.f13213a;
        synchronized (task.f13195a) {
            try {
                if (task.f13196b) {
                    throw new IllegalStateException("Cannot set the error on a completed task.");
                }
                task.f13196b = true;
                task.f13199e = exc;
                task.f13195a.notifyAll();
                task.i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object obj) {
        if (!this.f13213a.k(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
