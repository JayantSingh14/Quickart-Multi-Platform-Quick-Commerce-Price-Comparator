package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzw<TResult> extends Task<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f39804a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final zzr f39805b = new zzr();

    /* renamed from: c, reason: collision with root package name */
    public boolean f39806c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f39807d;

    /* renamed from: e, reason: collision with root package name */
    public Object f39808e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f39809f;

    @Override // com.google.android.gms.tasks.Task
    public final void a(Executor executor, OnCanceledListener onCanceledListener) {
        this.f39805b.a(new zzh(executor, onCanceledListener));
        w();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.f39805b.a(new zzj(TaskExecutors.f39751a, onCompleteListener));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final void b(Executor executor, OnCompleteListener onCompleteListener) {
        this.f39805b.a(new zzj(executor, onCompleteListener));
        w();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task c(OnFailureListener onFailureListener) {
        d(TaskExecutors.f39751a, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task d(Executor executor, OnFailureListener onFailureListener) {
        this.f39805b.a(new zzl(executor, onFailureListener));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task e(OnSuccessListener onSuccessListener) {
        f(TaskExecutors.f39751a, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task f(Executor executor, OnSuccessListener onSuccessListener) {
        this.f39805b.a(new zzn(executor, onSuccessListener));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task g(Continuation continuation) {
        return h(TaskExecutors.f39751a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task h(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.f39805b.a(new zzd(executor, continuation, zzwVar));
        w();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task i(com.google.android.gms.internal.appset.zzq zzqVar) {
        return j(TaskExecutors.f39751a, zzqVar);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task j(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.f39805b.a(new zzf(executor, continuation, zzwVar));
        w();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception k() {
        Exception exc;
        synchronized (this.f39804a) {
            exc = this.f39809f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object l() {
        Object obj;
        synchronized (this.f39804a) {
            try {
                Preconditions.checkState(this.f39806c, "Task is not yet complete");
                if (this.f39807d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f39809f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.f39808e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object m() {
        Object obj;
        synchronized (this.f39804a) {
            try {
                Preconditions.checkState(this.f39806c, "Task is not yet complete");
                if (this.f39807d) {
                    throw new CancellationException("Task is already canceled.");
                }
                if (IOException.class.isInstance(this.f39809f)) {
                    throw ((Throwable) IOException.class.cast(this.f39809f));
                }
                Exception exc = this.f39809f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.f39808e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean n() {
        return this.f39807d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean o() {
        boolean z;
        synchronized (this.f39804a) {
            z = this.f39806c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean p() {
        boolean z;
        synchronized (this.f39804a) {
            try {
                z = false;
                if (this.f39806c && !this.f39807d && this.f39809f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task q(SuccessContinuation successContinuation) {
        Executor executor = TaskExecutors.f39751a;
        zzw zzwVar = new zzw();
        this.f39805b.a(new zzp(executor, successContinuation, zzwVar));
        w();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task r(Executor executor, SuccessContinuation successContinuation) {
        zzw zzwVar = new zzw();
        this.f39805b.a(new zzp(executor, successContinuation, zzwVar));
        w();
        return zzwVar;
    }

    public final void s(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f39804a) {
            if (this.f39806c) {
                throw DuplicateTaskCompletionException.a(this);
            }
            this.f39806c = true;
            this.f39809f = exc;
        }
        this.f39805b.b(this);
    }

    public final void t(Object obj) {
        synchronized (this.f39804a) {
            if (this.f39806c) {
                throw DuplicateTaskCompletionException.a(this);
            }
            this.f39806c = true;
            this.f39808e = obj;
        }
        this.f39805b.b(this);
    }

    public final void u() {
        synchronized (this.f39804a) {
            try {
                if (this.f39806c) {
                    return;
                }
                this.f39806c = true;
                this.f39807d = true;
                this.f39805b.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean v(Object obj) {
        synchronized (this.f39804a) {
            try {
                if (this.f39806c) {
                    return false;
                }
                this.f39806c = true;
                this.f39808e = obj;
                this.f39805b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w() {
        synchronized (this.f39804a) {
            try {
                if (this.f39806c) {
                    this.f39805b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
