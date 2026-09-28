package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", l = {188, 194, 198, 206, 210}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49698a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49699b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpResponse f49700c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCache f49701d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49702e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49701d = httpCache;
        this.f49702e = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.f49701d, this.f49702e, (Continuation) obj3);
        httpCache$Companion$install$2.f49699b = (PipelineContext) obj;
        httpCache$Companion$install$2.f49700c = (HttpResponse) obj2;
        return httpCache$Companion$install$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f4, code lost:
    
        if (r5.f(r14, r13) == r0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015b, code lost:
    
        if (r3.f(r14, r13) == r0) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
