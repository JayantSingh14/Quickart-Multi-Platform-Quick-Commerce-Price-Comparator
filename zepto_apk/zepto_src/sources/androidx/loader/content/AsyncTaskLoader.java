package androidx.loader.content;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.ModernAsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: h, reason: collision with root package name */
    public Executor f4982h;

    /* renamed from: i, reason: collision with root package name */
    public volatile LoadTask f4983i;

    /* renamed from: j, reason: collision with root package name */
    public volatile LoadTask f4984j;

    public final class LoadTask extends ModernAsyncTask<D> implements Runnable {
        public LoadTask() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final Object a() {
            try {
                return AsyncTaskLoader.this.i();
            } catch (OperationCanceledException e2) {
                if (this.f5000c.get()) {
                    return null;
                }
                throw e2;
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final void b(Object obj) {
            AsyncTaskLoader asyncTaskLoader = AsyncTaskLoader.this;
            asyncTaskLoader.j(obj);
            if (asyncTaskLoader.f4984j == this) {
                if (asyncTaskLoader.f4995g) {
                    if (asyncTaskLoader.f4991c) {
                        asyncTaskLoader.k();
                    } else {
                        asyncTaskLoader.f4994f = true;
                    }
                }
                SystemClock.uptimeMillis();
                asyncTaskLoader.f4984j = null;
                asyncTaskLoader.h();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final void c(Object obj) {
            AsyncTaskLoader asyncTaskLoader = AsyncTaskLoader.this;
            if (asyncTaskLoader.f4983i == this) {
                if (asyncTaskLoader.f4992d) {
                    asyncTaskLoader.j(obj);
                    return;
                }
                asyncTaskLoader.f4995g = false;
                SystemClock.uptimeMillis();
                asyncTaskLoader.f4983i = null;
                asyncTaskLoader.a(obj);
                return;
            }
            asyncTaskLoader.j(obj);
            if (asyncTaskLoader.f4984j == this) {
                if (asyncTaskLoader.f4995g) {
                    if (asyncTaskLoader.f4991c) {
                        asyncTaskLoader.k();
                    } else {
                        asyncTaskLoader.f4994f = true;
                    }
                }
                SystemClock.uptimeMillis();
                asyncTaskLoader.f4984j = null;
                asyncTaskLoader.h();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            AsyncTaskLoader.this.h();
        }
    }

    public AsyncTaskLoader(Context context) {
        this.f4991c = false;
        this.f4992d = false;
        this.f4993e = true;
        this.f4994f = false;
        this.f4995g = false;
        this.f4990b = context.getApplicationContext();
    }

    @Override // androidx.loader.content.Loader
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.b(str, fileDescriptor, printWriter, strArr);
        if (this.f4983i != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f4983i);
            printWriter.print(" waiting=");
            this.f4983i.getClass();
            printWriter.println(false);
        }
        if (this.f4984j != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f4984j);
            printWriter.print(" waiting=");
            this.f4984j.getClass();
            printWriter.println(false);
        }
    }

    @Override // androidx.loader.content.Loader
    public final boolean c() {
        if (this.f4983i == null) {
            return false;
        }
        boolean z = this.f4991c;
        if (!z) {
            if (z) {
                k();
            } else {
                this.f4994f = true;
            }
        }
        if (this.f4984j != null) {
            this.f4983i.getClass();
            this.f4983i = null;
            return false;
        }
        this.f4983i.getClass();
        LoadTask loadTask = this.f4983i;
        loadTask.f5000c.set(true);
        boolean zCancel = loadTask.f4998a.cancel(false);
        if (zCancel) {
            this.f4984j = this.f4983i;
            g();
        }
        this.f4983i = null;
        return zCancel;
    }

    public void g() {
    }

    public final void h() {
        if (this.f4984j != null || this.f4983i == null) {
            return;
        }
        this.f4983i.getClass();
        if (this.f4982h == null) {
            this.f4982h = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        LoadTask loadTask = this.f4983i;
        Executor executor = this.f4982h;
        if (loadTask.f4999b == ModernAsyncTask.Status.f5007a) {
            loadTask.f4999b = ModernAsyncTask.Status.f5008b;
            executor.execute(loadTask.f4998a);
            return;
        }
        int iOrdinal = loadTask.f4999b.ordinal();
        if (iOrdinal == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (iOrdinal == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    public abstract Object i();

    public void j(Object obj) {
    }

    public final void k() {
        c();
        this.f4983i = new LoadTask();
        h();
    }
}
