package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1281a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1281a) {
            case 0:
                ArchTaskExecutor.a().f1276a.f1278b.execute(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
