package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class AndroidMainExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f58075a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f58075a.post(runnable);
    }
}
