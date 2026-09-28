package kotlinx.coroutines.scheduling;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

@Metadata
/* loaded from: classes.dex */
final class TaskImpl extends Task {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f55157c;

    public TaskImpl(Runnable runnable, long j2, boolean z) {
        super(j2, z);
        this.f55157c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f55157c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f55157c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(DebugStringsKt.a(runnable));
        sb.append(", ");
        sb.append(this.f55155a);
        sb.append(", ");
        boolean z = this.f55156b;
        String str = TasksKt.f55158a;
        return e.t(sb, z ? "Blocking" : "Non-blocking", ']');
    }
}
