package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import org.slf4j.Logger;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycle$Plugin$install$1", f = "HttpRequestLifecycle.kt", l = {Type.A6}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpRequestLifecycle$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49578a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49579b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49580c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycle$Plugin$install$1(HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49580c = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpRequestLifecycle$Plugin$install$1 httpRequestLifecycle$Plugin$install$1 = new HttpRequestLifecycle$Plugin$install$1(this.f49580c, (Continuation) obj3);
        httpRequestLifecycle$Plugin$install$1.f49579b = (PipelineContext) obj;
        return httpRequestLifecycle$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CompletableJob completableJob;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49578a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJob = (CompletableJob) this.f49579b;
            try {
                ResultKt.b(obj);
                completableJob.complete();
                return Unit.f53572a;
            } catch (Throwable th) {
                th = th;
                try {
                    completableJob.c(th);
                    throw th;
                } catch (Throwable th2) {
                    completableJob.complete();
                    throw th2;
                }
            }
        }
        ResultKt.b(obj);
        PipelineContext pipelineContext = (PipelineContext) this.f49579b;
        final CompletableJob completableJobA = SupervisorKt.a(((HttpRequestBuilder) pipelineContext.f50587a).f50007e);
        CoroutineContext.Element element = this.f49580c.f49261d.get(Job.Key.f54121a);
        Intrinsics.c(element);
        Logger logger = HttpRequestLifecycleKt.f49581a;
        final DisposableHandle disposableHandleJ0 = ((Job) element).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$handler$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Throwable th3 = (Throwable) obj2;
                Job job = completableJobA;
                if (th3 != null) {
                    HttpRequestLifecycleKt.f49581a.r("Cancelling request because engine Job failed with error: " + th3);
                    ((JobSupport) job).y(ExceptionsKt.a("Engine failed", th3));
                } else {
                    HttpRequestLifecycleKt.f49581a.r("Cancelling request because engine Job completed");
                    ((JobImpl) job).complete();
                }
                return Unit.f53572a;
            }
        });
        ((JobSupport) completableJobA).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                disposableHandleJ0.dispose();
                return Unit.f53572a;
            }
        });
        try {
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.f50587a;
            httpRequestBuilder.getClass();
            Intrinsics.checkNotNullParameter(completableJobA, "<set-?>");
            httpRequestBuilder.f50007e = completableJobA;
            this.f49579b = completableJobA;
            this.f49578a = 1;
            if (pipelineContext.e(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            completableJob = completableJobA;
            completableJob.complete();
            return Unit.f53572a;
        } catch (Throwable th3) {
            th = th3;
            completableJob = completableJobA;
            completableJob.c(th);
            throw th;
        }
    }
}
