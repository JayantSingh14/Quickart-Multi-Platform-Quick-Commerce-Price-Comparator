package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.PhaseContent;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpCallValidator {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f49498d = new Companion();

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49499e = new AttributeKey("HttpResponseValidator");

    /* renamed from: a, reason: collision with root package name */
    public final List f49500a;

    /* renamed from: b, reason: collision with root package name */
    public final List f49501b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f49502c;

    @Metadata
    public static final class Companion implements HttpClientPlugin<Config, HttpCallValidator> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) throws InvalidPhaseException {
            HttpCallValidator plugin = (HttpCallValidator) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50017g, new HttpCallValidator$Companion$install$1(plugin, null));
            PipelinePhase phase = new PipelinePhase("BeforeReceive");
            PipelinePhase relativeTo = HttpResponsePipeline.f50069g;
            HttpResponsePipeline httpResponsePipeline = scope.f49263f;
            httpResponsePipeline.getClass();
            Intrinsics.checkNotNullParameter(relativeTo, "reference");
            Intrinsics.checkNotNullParameter(phase, "phase");
            if (!httpResponsePipeline.e(phase)) {
                int iC = httpResponsePipeline.c(relativeTo);
                if (iC == -1) {
                    throw new InvalidPhaseException("Phase " + relativeTo + " was not registered for this pipeline");
                }
                ArrayList arrayList = httpResponsePipeline.f50583b;
                Intrinsics.checkNotNullParameter(relativeTo, "relativeTo");
                arrayList.add(iC, new PhaseContent(phase, new PipelinePhaseRelation.Before()));
            }
            httpResponsePipeline.g(phase, new HttpCallValidator$Companion$install$2(plugin, null));
            ((HttpSend) HttpClientPluginKt.a(scope, HttpSend.f49625b)).a(new HttpCallValidator$Companion$install$3(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCallValidator(CollectionsKt.R(config.f49516a), CollectionsKt.R(config.f49517b), config.f49518c);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpCallValidator.f49499e;
        }
    }

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f49516a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f49517b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public boolean f49518c = true;
    }

    public HttpCallValidator(List responseValidators, List callExceptionHandlers, boolean z) {
        Intrinsics.checkNotNullParameter(responseValidators, "responseValidators");
        Intrinsics.checkNotNullParameter(callExceptionHandlers, "callExceptionHandlers");
        this.f49500a = responseValidators;
        this.f49501b = callExceptionHandlers;
        this.f49502c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit a(io.ktor.client.plugins.HttpCallValidator r6, java.lang.Throwable r7, io.ktor.client.request.HttpRequest r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r6.getClass()
            boolean r0 = r9 instanceof io.ktor.client.plugins.HttpCallValidator$processException$1
            if (r0 == 0) goto L16
            r0 = r9
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = (io.ktor.client.plugins.HttpCallValidator$processException$1) r0
            int r1 = r0.f49524f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f49524f = r1
            goto L1b
        L16:
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = new io.ktor.client.plugins.HttpCallValidator$processException$1
            r0.<init>(r6, r9)
        L1b:
            java.lang.Object r9 = r0.f49522d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f49524f
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L29
            if (r1 != r2) goto L36
        L29:
            java.util.Iterator r6 = r0.f49521c
            io.ktor.client.request.HttpRequest r7 = r0.f49520b
            java.lang.Throwable r8 = r0.f49519a
            kotlin.ResultKt.b(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L68
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.b(r9)
            org.slf4j.Logger r9 = io.ktor.client.plugins.HttpCallValidatorKt.f49530a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Processing exception "
            r1.<init>(r4)
            r1.append(r7)
            java.lang.String r4 = " for request "
            r1.append(r4)
            io.ktor.http.Url r4 = r8.N()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r9.r(r1)
            java.util.List r6 = r6.f49501b
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L68:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r6.next()
            io.ktor.client.plugins.HandlerWrapper r9 = (io.ktor.client.plugins.HandlerWrapper) r9
            boolean r1 = r9 instanceof io.ktor.client.plugins.ExceptionHandlerWrapper
            r4 = 0
            if (r1 != 0) goto L8c
            boolean r1 = r9 instanceof io.ktor.client.plugins.RequestExceptionHandlerWrapper
            if (r1 != 0) goto L7e
            goto L68
        L7e:
            io.ktor.client.plugins.RequestExceptionHandlerWrapper r9 = (io.ktor.client.plugins.RequestExceptionHandlerWrapper) r9
            r9.getClass()
            r0.f49519a = r7
            r0.f49520b = r8
            r0.f49521c = r6
            r0.f49524f = r2
            throw r4
        L8c:
            io.ktor.client.plugins.ExceptionHandlerWrapper r9 = (io.ktor.client.plugins.ExceptionHandlerWrapper) r9
            r9.getClass()
            r0.f49519a = r7
            r0.f49520b = r8
            r0.f49521c = r6
            r0.f49524f = r3
            throw r4
        L9a:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.a(io.ktor.client.plugins.HttpCallValidator, java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.client.plugins.HttpCallValidator r5, io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            if (r0 == 0) goto L16
            r0 = r7
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = (io.ktor.client.plugins.HttpCallValidator$validateResponse$1) r0
            int r1 = r0.f49529e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f49529e = r1
            goto L1b
        L16:
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = new io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.f49527c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49529e
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.util.Iterator r5 = r0.f49526b
            io.ktor.client.statement.HttpResponse r6 = r0.f49525a
            kotlin.ResultKt.b(r7)
            goto L60
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.b(r7)
            org.slf4j.Logger r7 = io.ktor.client.plugins.HttpCallValidatorKt.f49530a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Validating response for request "
            r2.<init>(r4)
            io.ktor.client.call.HttpClientCall r4 = r6.o1()
            io.ktor.client.request.HttpRequest r4 = r4.d()
            io.ktor.http.Url r4 = r4.N()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.r(r2)
            java.util.List r5 = r5.f49500a
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L60:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L79
            java.lang.Object r7 = r5.next()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.f49525a = r6
            r0.f49526b = r5
            r0.f49529e = r3
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L60
            return r1
        L79:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.b(io.ktor.client.plugins.HttpCallValidator, io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
