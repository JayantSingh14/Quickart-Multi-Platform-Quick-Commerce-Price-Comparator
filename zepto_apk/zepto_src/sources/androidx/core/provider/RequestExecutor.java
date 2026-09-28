package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
class RequestExecutor {

    public static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f2928a;

        /* renamed from: b, reason: collision with root package name */
        public int f2929b;

        public static class ProcessPriorityThread extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final int f2930a;

            public ProcessPriorityThread(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f2930a = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f2930a);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f2928a, this.f2929b);
        }
    }

    public static class HandlerExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f2931a;

        public HandlerExecutor(Handler handler) {
            this.f2931a = handler;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.getClass();
            Handler handler = this.f2931a;
            if (handler.post(runnable)) {
                return;
            }
            throw new RejectedExecutionException(handler + " is shutting down");
        }
    }

    public static class ReplyRunnable<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Callable f2932a;

        /* renamed from: b, reason: collision with root package name */
        public Consumer f2933b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f2934c;

        @Override // java.lang.Runnable
        public final void run() {
            final Object objCall;
            try {
                objCall = ((FontRequestWorker.AnonymousClass3) this.f2932a).call();
            } catch (Exception unused) {
                objCall = null;
            }
            final Consumer consumer = this.f2933b;
            this.f2934c.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(objCall);
                }
            });
        }
    }
}
