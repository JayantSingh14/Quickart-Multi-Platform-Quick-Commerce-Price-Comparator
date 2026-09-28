package androidx.arch.core.executor;

import android.os.Looper;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: b, reason: collision with root package name */
    public static volatile ArchTaskExecutor f1274b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f1275c = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final DefaultTaskExecutor f1276a = new DefaultTaskExecutor();

    public static ArchTaskExecutor a() {
        if (f1274b != null) {
            return f1274b;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (f1274b == null) {
                    f1274b = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1274b;
    }

    public final void b(Runnable runnable) {
        DefaultTaskExecutor defaultTaskExecutor = this.f1276a;
        if (defaultTaskExecutor.f1279c == null) {
            synchronized (defaultTaskExecutor.f1277a) {
                try {
                    if (defaultTaskExecutor.f1279c == null) {
                        defaultTaskExecutor.f1279c = DefaultTaskExecutor.a(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        defaultTaskExecutor.f1279c.post(runnable);
    }
}
