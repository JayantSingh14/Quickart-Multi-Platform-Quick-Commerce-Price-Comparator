package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TransactionExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f11851a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f11852b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f11853c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f11854d;

    public TransactionExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f11851a = executor;
        this.f11852b = new ArrayDeque();
        this.f11854d = new Object();
    }

    public final void a() {
        synchronized (this.f11854d) {
            try {
                Object objPoll = this.f11852b.poll();
                Runnable runnable = (Runnable) objPoll;
                this.f11853c = runnable;
                if (objPoll != null) {
                    this.f11851a.execute(runnable);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        synchronized (this.f11854d) {
            try {
                this.f11852b.offer(new androidx.constraintlayout.motion.widget.a(9, command, this));
                if (this.f11853c == null) {
                    a();
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
