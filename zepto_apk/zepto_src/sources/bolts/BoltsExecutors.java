package bolts;

import in.juspay.hyper.constants.LogSubCategory;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class BoltsExecutors {

    /* renamed from: d, reason: collision with root package name */
    public static final BoltsExecutors f13179d = new BoltsExecutors();

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f13180a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f13181b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f13182c;

    public static class ImmediateExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public ThreadLocal f13183a;

        public final void a() {
            ThreadLocal threadLocal = this.f13183a;
            Integer num = (Integer) threadLocal.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                threadLocal.remove();
            } else {
                threadLocal.set(Integer.valueOf(iIntValue));
            }
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ThreadLocal threadLocal = this.f13183a;
            Integer num = (Integer) threadLocal.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            threadLocal.set(Integer.valueOf(iIntValue));
            try {
                if (iIntValue <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.f13179d.f13180a.execute(runnable);
                }
                a();
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
    }

    public BoltsExecutors() {
        ExecutorService executorServiceNewCachedThreadPool;
        String property = System.getProperty("java.runtime.name");
        if (property == null ? false : property.toLowerCase(Locale.US).contains(LogSubCategory.LifeCycle.ANDROID)) {
            AndroidExecutors androidExecutors = AndroidExecutors.f13175b;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.f13176c, AndroidExecutors.f13177d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            executorServiceNewCachedThreadPool = threadPoolExecutor;
        } else {
            executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        }
        this.f13180a = executorServiceNewCachedThreadPool;
        this.f13181b = Executors.newSingleThreadScheduledExecutor();
        ImmediateExecutor immediateExecutor = new ImmediateExecutor();
        immediateExecutor.f13183a = new ThreadLocal();
        this.f13182c = immediateExecutor;
    }
}
