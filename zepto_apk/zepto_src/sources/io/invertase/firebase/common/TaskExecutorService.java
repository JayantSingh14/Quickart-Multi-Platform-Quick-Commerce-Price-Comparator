package io.invertase.firebase.common;

import android.support.v4.media.b;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TaskExecutorService {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f49242e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f49243a;

    /* renamed from: b, reason: collision with root package name */
    public final int f49244b;

    /* renamed from: c, reason: collision with root package name */
    public final int f49245c;

    /* renamed from: d, reason: collision with root package name */
    public final a f49246d = new RejectedExecutionHandler() { // from class: io.invertase.firebase.common.a
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            HashMap map = TaskExecutorService.f49242e;
            TaskExecutorService taskExecutorService = this.f49250a;
            taskExecutorService.getClass();
            if (threadPoolExecutor.isShutdown() || threadPoolExecutor.isTerminated() || threadPoolExecutor.isTerminating()) {
                return;
            }
            taskExecutorService.a("", true).execute(runnable);
        }
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [io.invertase.firebase.common.a] */
    public TaskExecutorService(String str) {
        this.f49243a = str;
        ReactNativeFirebaseJSON reactNativeFirebaseJSON = ReactNativeFirebaseJSON.f49237b;
        JSONObject jSONObject = reactNativeFirebaseJSON.f49238a;
        this.f49244b = jSONObject != null ? jSONObject.optInt("android_task_executor_maximum_pool_size", 1) : 1;
        JSONObject jSONObject2 = reactNativeFirebaseJSON.f49238a;
        this.f49245c = jSONObject2 != null ? jSONObject2.optInt("android_task_executor_keep_alive_seconds", 3) : 3;
    }

    public static void c(String str) {
        HashMap map = f49242e;
        synchronized (map) {
            try {
                ExecutorService executorService = (ExecutorService) map.get(str);
                if (executorService != null) {
                    executorService.shutdownNow();
                    map.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ExecutorService a(String str, boolean z) {
        ExecutorService executorServiceNewSingleThreadExecutor;
        String strB = b(str, z);
        HashMap map = f49242e;
        synchronized (map) {
            try {
                ExecutorService executorService = (ExecutorService) map.get(strB);
                if (executorService != null) {
                    return executorService;
                }
                if (z) {
                    executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                } else {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, this.f49244b, this.f49245c, TimeUnit.SECONDS, new SynchronousQueue());
                    threadPoolExecutor.setRejectedExecutionHandler(this.f49246d);
                    executorServiceNewSingleThreadExecutor = threadPoolExecutor;
                }
                map.put(strB, executorServiceNewSingleThreadExecutor);
                return executorServiceNewSingleThreadExecutor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String b(String str, boolean z) {
        String str2 = this.f49243a;
        return z ? b.l(str2, "TransactionalExecutor", str) : b.l(str2, "Executor", str);
    }
}
