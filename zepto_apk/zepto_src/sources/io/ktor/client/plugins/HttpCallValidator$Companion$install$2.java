package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$2", f = "HttpCallValidator.kt", l = {WKSRecord.Service.BL_IDM, 145}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpCallValidator$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49508a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49509b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpResponseContainer f49510c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCallValidator f49511d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$2(HttpCallValidator httpCallValidator, Continuation continuation) {
        super(3, continuation);
        this.f49511d = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCallValidator$Companion$install$2 httpCallValidator$Companion$install$2 = new HttpCallValidator$Companion$install$2(this.f49511d, (Continuation) obj3);
        httpCallValidator$Companion$install$2.f49509b = (PipelineContext) obj;
        httpCallValidator$Companion$install$2.f49510c = (HttpResponseContainer) obj2;
        return httpCallValidator$Companion$install$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r5 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r4.f49508a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1c
            if (r1 == r2) goto L14
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L14:
            java.lang.Object r0 = r4.f49509b
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r5)
            goto L58
        L1c:
            java.lang.Object r1 = r4.f49509b
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L24
            goto L3b
        L24:
            r5 = move-exception
            goto L3e
        L26:
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = r4.f49509b
            r1 = r5
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            io.ktor.client.statement.HttpResponseContainer r5 = r4.f49510c
            r4.f49509b = r1     // Catch: java.lang.Throwable -> L24
            r4.f49508a = r3     // Catch: java.lang.Throwable -> L24
            java.lang.Object r5 = r1.f(r5, r4)     // Catch: java.lang.Throwable -> L24
            if (r5 != r0) goto L3b
            goto L56
        L3b:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L3e:
            java.lang.Throwable r5 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r5)
            java.lang.Object r1 = r1.f50587a
            io.ktor.client.call.HttpClientCall r1 = (io.ktor.client.call.HttpClientCall) r1
            io.ktor.client.request.HttpRequest r1 = r1.d()
            r4.f49509b = r5
            r4.f49508a = r2
            io.ktor.client.plugins.HttpCallValidator r2 = r4.f49511d
            kotlin.Unit r1 = io.ktor.client.plugins.HttpCallValidator.a(r2, r5, r1, r4)
            if (r1 != r0) goto L57
        L56:
            return r0
        L57:
            r0 = r5
        L58:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator$Companion$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
