package io.ktor.utils.io.internal;

import com.google.android.gms.internal.pal.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CancellableReusableContinuation<T> implements Continuation<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51238a = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "state");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51239b = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "jobCancellationHandler");

    @NotNull
    private volatile /* synthetic */ Object state = null;

    @NotNull
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    @Metadata
    public final class JobRelation implements Function1<Throwable, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final Job f51240a;

        /* renamed from: b, reason: collision with root package name */
        public DisposableHandle f51241b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancellableReusableContinuation f51242c;

        public JobRelation(CancellableReusableContinuation cancellableReusableContinuation, Job job) {
            Intrinsics.checkNotNullParameter(job, "job");
            this.f51242c = cancellableReusableContinuation;
            this.f51240a = job;
            DisposableHandle disposableHandleD = job.D(true, true, this);
            if (job.a()) {
                this.f51241b = disposableHandleD;
            }
        }

        public final void a() {
            DisposableHandle disposableHandle = this.f51241b;
            if (disposableHandle != null) {
                this.f51241b = null;
                disposableHandle.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            Throwable th = (Throwable) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableReusableContinuation.f51238a;
            CancellableReusableContinuation cancellableReusableContinuation = this.f51242c;
            cancellableReusableContinuation.getClass();
            do {
                atomicReferenceFieldUpdater = CancellableReusableContinuation.f51239b;
                if (atomicReferenceFieldUpdater.compareAndSet(cancellableReusableContinuation, this, null)) {
                    break;
                }
            } while (atomicReferenceFieldUpdater.get(cancellableReusableContinuation) == this);
            a();
            if (th != null) {
                CancellableReusableContinuation.a(cancellableReusableContinuation, this.f51240a, th);
            }
            return Unit.f53572a;
        }
    }

    public static final void a(CancellableReusableContinuation cancellableReusableContinuation, Job job, Throwable th) {
        Object obj;
        Continuation continuation;
        do {
            obj = cancellableReusableContinuation.state;
            if (!(obj instanceof Continuation)) {
                return;
            }
            continuation = (Continuation) obj;
            if (continuation.getContext().get(Job.Key.f54121a) != job) {
                return;
            }
        } while (!a.o(f51238a, cancellableReusableContinuation, obj));
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        Result.Companion companion = Result.f53538b;
        continuation.resumeWith(ResultKt.a(th));
    }

    public final void b(Boolean value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Result.Companion companion = Result.f53538b;
        resumeWith(value);
        JobRelation jobRelation = (JobRelation) f51239b.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.a();
        }
    }

    public final void c(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Result.Companion companion = Result.f53538b;
        resumeWith(ResultKt.a(cause));
        JobRelation jobRelation = (JobRelation) f51239b.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.a();
        }
    }

    public final Object d(Continuation actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        while (true) {
            Object obj = this.state;
            if (obj != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51238a;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                return obj;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f51238a;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, actual)) {
                if (atomicReferenceFieldUpdater2.get(this) != null) {
                    break;
                }
            }
            Job job = (Job) actual.getContext().get(Job.Key.f54121a);
            JobRelation jobRelation = (JobRelation) this.jobCancellationHandler;
            if ((jobRelation != null ? jobRelation.f51240a : null) != job) {
                if (job == null) {
                    JobRelation jobRelation2 = (JobRelation) f51239b.getAndSet(this, null);
                    if (jobRelation2 != null) {
                        jobRelation2.a();
                    }
                } else {
                    JobRelation jobRelation3 = new JobRelation(this, job);
                    while (true) {
                        Object obj2 = this.jobCancellationHandler;
                        JobRelation jobRelation4 = (JobRelation) obj2;
                        if (jobRelation4 != null && jobRelation4.f51240a == job) {
                            jobRelation3.a();
                            break;
                        }
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f51239b;
                        while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, jobRelation3)) {
                            if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                                break;
                            }
                        }
                        if (jobRelation4 != null) {
                            jobRelation4.a();
                        }
                    }
                }
            }
            return CoroutineSingletons.f53689a;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext context;
        Object obj = this.state;
        Continuation continuation = obj instanceof Continuation ? (Continuation) obj : null;
        return (continuation == null || (context = continuation.getContext()) == null) ? EmptyCoroutineContext.f53685a : context;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objA;
        while (true) {
            Object obj2 = this.state;
            if (obj2 == null) {
                objA = Result.a(obj);
                if (objA == null) {
                    ResultKt.b(obj);
                    objA = obj;
                }
            } else if (!(obj2 instanceof Continuation)) {
                return;
            } else {
                objA = null;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51238a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (obj2 instanceof Continuation) {
                ((Continuation) obj2).resumeWith(obj);
                return;
            }
            return;
        }
    }
}
