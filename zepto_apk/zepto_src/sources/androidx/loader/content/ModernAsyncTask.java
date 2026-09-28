package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
abstract class ModernAsyncTask<Result> {

    /* renamed from: e, reason: collision with root package name */
    public static Handler f4997e;

    /* renamed from: b, reason: collision with root package name */
    public volatile Status f4999b = Status.f5007a;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f5000c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f5001d = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public final FutureTask f4998a = new FutureTask<Object>(new Callable<Object>() { // from class: androidx.loader.content.ModernAsyncTask.1
        @Override // java.util.concurrent.Callable
        public final Object call() {
            ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
            modernAsyncTask.f5001d.set(true);
            Object objA = null;
            try {
                Process.setThreadPriority(10);
                objA = modernAsyncTask.a();
                Binder.flushPendingCommands();
                return objA;
            } finally {
            }
        }
    }) { // from class: androidx.loader.content.ModernAsyncTask.2
        @Override // java.util.concurrent.FutureTask
        public final void done() {
            ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
            try {
                Object obj = get();
                if (modernAsyncTask.f5001d.get()) {
                    return;
                }
                modernAsyncTask.d(obj);
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                if (modernAsyncTask.f5001d.get()) {
                    return;
                }
                modernAsyncTask.d(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5006a;

        static {
            int[] iArr = new int[Status.values().length];
            f5006a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5006a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Status {

        /* renamed from: a, reason: collision with root package name */
        public static final Status f5007a;

        /* renamed from: b, reason: collision with root package name */
        public static final Status f5008b;

        /* renamed from: c, reason: collision with root package name */
        public static final Status f5009c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Status[] f5010d;

        static {
            Status status = new Status("PENDING", 0);
            f5007a = status;
            Status status2 = new Status("RUNNING", 1);
            f5008b = status2;
            Status status3 = new Status("FINISHED", 2);
            f5009c = status3;
            f5010d = new Status[]{status, status2, status3};
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f5010d.clone();
        }
    }

    public abstract Object a();

    public void b(Object obj) {
    }

    public void c(Object obj) {
    }

    public final void d(final Object obj) {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (f4997e == null) {
                    f4997e = new Handler(Looper.getMainLooper());
                }
                handler = f4997e;
            } catch (Throwable th) {
                throw th;
            }
        }
        handler.post(new Runnable() { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.lang.Runnable
            public final void run() {
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                Object obj2 = obj;
                if (modernAsyncTask.f5000c.get()) {
                    modernAsyncTask.b(obj2);
                } else {
                    modernAsyncTask.c(obj2);
                }
                modernAsyncTask.f4999b = Status.f5009c;
            }
        });
    }
}
