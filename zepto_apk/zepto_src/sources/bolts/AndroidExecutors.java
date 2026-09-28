package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class AndroidExecutors {

    /* renamed from: b, reason: collision with root package name */
    public static final AndroidExecutors f13175b = new AndroidExecutors();

    /* renamed from: c, reason: collision with root package name */
    public static final int f13176c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f13177d;

    /* renamed from: a, reason: collision with root package name */
    public final Executor f13178a = new UIThreadExecutor();

    public static class UIThreadExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f13176c = iAvailableProcessors + 1;
        f13177d = (iAvailableProcessors * 2) + 1;
    }
}
