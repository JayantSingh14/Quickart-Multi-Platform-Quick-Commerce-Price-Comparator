package androidx.work;

import android.content.Context;
import androidx.constraintlayout.helper.widget.a;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: e, reason: collision with root package name */
    public final JobImpl f12499e;

    /* renamed from: f, reason: collision with root package name */
    public final SettableFuture f12500f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultScheduler f12501g;

    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {WKSRecord.Service.INGRES_NET}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public JobListenableFuture f12502a;

        /* renamed from: b, reason: collision with root package name */
        public int f12503b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JobListenableFuture f12504c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CoroutineWorker f12505d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JobListenableFuture jobListenableFuture, CoroutineWorker coroutineWorker, Continuation continuation) {
            super(2, continuation);
            this.f12504c = jobListenableFuture;
            this.f12505d = coroutineWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f12504c, this.f12505d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f12503b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f12502a = this.f12504c;
                this.f12503b = 1;
                this.f12505d.getClass();
                throw new IllegalStateException("Not implemented");
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JobListenableFuture jobListenableFuture = this.f12502a;
            ResultKt.b(obj);
            jobListenableFuture.f12525a.i(obj);
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {WKSRecord.Service.BOOTPC}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    final class C00791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f12506a;

        public C00791(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new C00791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00791) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f12506a;
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    this.f12506a = 1;
                    obj = coroutineWorker.a();
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                coroutineWorker.f12500f.i((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                coroutineWorker.f12500f.j(th);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context appContext, @NotNull WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f12499e = JobKt.a();
        SettableFuture settableFuture = new SettableFuture();
        Intrinsics.checkNotNullExpressionValue(settableFuture, "create()");
        this.f12500f = settableFuture;
        settableFuture.q(new a(this, 4), getTaskExecutor().b());
        this.f12501g = Dispatchers.f54091a;
    }

    public abstract Object a();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        JobImpl jobImplA = JobKt.a();
        ContextScope contextScopeA = CoroutineScopeKt.a(this.f12501g.plus(jobImplA));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(jobImplA);
        BuildersKt.c(contextScopeA, null, new AnonymousClass1(jobListenableFuture, this, null), 3);
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.f12500f.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        BuildersKt.c(CoroutineScopeKt.a(this.f12501g.plus(this.f12499e)), null, new C00791(null), 3);
        return this.f12500f;
    }
}
