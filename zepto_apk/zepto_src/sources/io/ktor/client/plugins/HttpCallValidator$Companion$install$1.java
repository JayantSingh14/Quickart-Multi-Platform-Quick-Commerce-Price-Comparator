package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$1", f = "HttpCallValidator.kt", l = {WKSRecord.Service.CISCO_FNA, WKSRecord.Service.STATSRV}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpCallValidator$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49503a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49504b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49505c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCallValidator f49506d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$1(HttpCallValidator httpCallValidator, Continuation continuation) {
        super(3, continuation);
        this.f49506d = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCallValidator$Companion$install$1 httpCallValidator$Companion$install$1 = new HttpCallValidator$Companion$install$1(this.f49506d, (Continuation) obj3);
        httpCallValidator$Companion$install$1.f49504b = (PipelineContext) obj;
        httpCallValidator$Companion$install$1.f49505c = obj2;
        return httpCallValidator$Companion$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r9 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f49503a
            io.ktor.client.plugins.HttpCallValidator r2 = r8.f49506d
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L28
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L16
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L16:
            java.lang.Object r0 = r8.f49504b
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r9)
            goto L6b
        L1e:
            java.lang.Object r1 = r8.f49504b
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L26
            goto L4d
        L26:
            r9 = move-exception
            goto L50
        L28:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f49504b
            r1 = r9
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r9 = r8.f49505c
            java.lang.Object r5 = r1.f50587a     // Catch: java.lang.Throwable -> L26
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5     // Catch: java.lang.Throwable -> L26
            io.ktor.util.Attributes r5 = r5.f50008f     // Catch: java.lang.Throwable -> L26
            io.ktor.util.AttributeKey r6 = io.ktor.client.plugins.HttpCallValidatorKt.f49531b     // Catch: java.lang.Throwable -> L26
            io.ktor.client.plugins.HttpCallValidator$Companion$install$1$1 r7 = new io.ktor.client.plugins.HttpCallValidator$Companion$install$1$1     // Catch: java.lang.Throwable -> L26
            r7.<init>()     // Catch: java.lang.Throwable -> L26
            r5.g(r6, r7)     // Catch: java.lang.Throwable -> L26
            r8.f49504b = r1     // Catch: java.lang.Throwable -> L26
            r8.f49503a = r4     // Catch: java.lang.Throwable -> L26
            java.lang.Object r9 = r1.f(r9, r8)     // Catch: java.lang.Throwable -> L26
            if (r9 != r0) goto L4d
            goto L69
        L4d:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L50:
            java.lang.Throwable r9 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r9)
            java.lang.Object r1 = r1.f50587a
            io.ktor.client.request.HttpRequestBuilder r1 = (io.ktor.client.request.HttpRequestBuilder) r1
            org.slf4j.Logger r4 = io.ktor.client.plugins.HttpCallValidatorKt.f49530a
            io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1 r4 = new io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1
            r4.<init>()
            r8.f49504b = r9
            r8.f49503a = r3
            kotlin.Unit r1 = io.ktor.client.plugins.HttpCallValidator.a(r2, r9, r4, r8)
            if (r1 != r0) goto L6a
        L69:
            return r0
        L6a:
            r0 = r9
        L6b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator$Companion$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
