package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", l = {145, 149, 155, 165, 170}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49693a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49694b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49695c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCache f49696d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49697e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49696d = httpCache;
        this.f49697e = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.f49696d, this.f49697e, (Continuation) obj3);
        httpCache$Companion$install$1.f49694b = (PipelineContext) obj;
        httpCache$Companion$install$1.f49695c = obj2;
        return httpCache$Companion$install$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x034b, code lost:
    
        if (r1 == r7) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03b6, code lost:
    
        if (r1 == r7) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011f, code lost:
    
        if (r1 == r7) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 1045
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
