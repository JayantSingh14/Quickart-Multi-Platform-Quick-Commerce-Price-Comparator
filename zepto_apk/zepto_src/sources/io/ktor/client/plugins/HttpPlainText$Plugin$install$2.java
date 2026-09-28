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
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$2", f = "HttpPlainText.kt", l = {WKSRecord.Service.PROFILE, WKSRecord.Service.NETBIOS_DGM}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpPlainText$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49550a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49551b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49552c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpPlainText f49553d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$2(HttpPlainText httpPlainText, Continuation continuation) {
        super(3, continuation);
        this.f49553d = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpPlainText$Plugin$install$2 httpPlainText$Plugin$install$2 = new HttpPlainText$Plugin$install$2(this.f49553d, (Continuation) obj3);
        httpPlainText$Plugin$install$2.f49551b = (PipelineContext) obj;
        httpPlainText$Plugin$install$2.f49552c = (HttpResponseContainer) obj2;
        return httpPlainText$Plugin$install$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00da, code lost:
    
        if (r2.f(r4, r10) == r0) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws io.ktor.http.BadContentTypeFormatException {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r10.f49550a
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L23
            if (r1 == r2) goto L19
            if (r1 != r3) goto L11
            kotlin.ResultKt.b(r11)
            goto Ldd
        L11:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L19:
            java.lang.Object r1 = r10.f49552c
            io.ktor.util.reflect.TypeInfo r1 = (io.ktor.util.reflect.TypeInfo) r1
            io.ktor.util.pipeline.PipelineContext r2 = r10.f49551b
            kotlin.ResultKt.b(r11)
            goto L60
        L23:
            kotlin.ResultKt.b(r11)
            io.ktor.util.pipeline.PipelineContext r11 = r10.f49551b
            java.lang.Object r1 = r10.f49552c
            io.ktor.client.statement.HttpResponseContainer r1 = (io.ktor.client.statement.HttpResponseContainer) r1
            io.ktor.util.reflect.TypeInfo r4 = r1.a()
            java.lang.Object r1 = r1.b()
            kotlin.reflect.KClass r5 = r4.f50602a
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            kotlin.jvm.internal.ClassReference r6 = kotlin.jvm.internal.Reflection.a(r6)
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto Le0
            boolean r5 = r1 instanceof io.ktor.utils.io.ByteReadChannel
            if (r5 != 0) goto L48
            goto Le0
        L48:
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            r10.f49551b = r11
            r10.f49552c = r4
            r10.f49550a = r2
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r1 = r1.n(r5, r10)
            if (r1 != r0) goto L5d
            goto Ldc
        L5d:
            r2 = r11
            r11 = r1
            r1 = r4
        L60:
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11
            java.lang.Object r4 = r2.f50587a
            io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
            io.ktor.client.plugins.HttpPlainText r5 = r10.f49553d
            r5.getClass()
            java.lang.String r6 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
            io.ktor.client.statement.HttpResponse r6 = r4.e()
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            io.ktor.http.Headers r6 = r6.getHeaders()
            java.util.List r7 = io.ktor.http.HttpHeaders.f50204a
            java.lang.String r7 = "Content-Type"
            java.lang.String r6 = r6.b(r7)
            r7 = 0
            if (r6 == 0) goto L97
            io.ktor.http.ContentType r8 = io.ktor.http.ContentType.f50126e
            io.ktor.http.ContentType r6 = io.ktor.http.ContentType.Companion.a(r6)
            goto L98
        L97:
            r6 = r7
        L98:
            if (r6 == 0) goto L9f
            java.nio.charset.Charset r6 = io.ktor.http.ContentTypesKt.a(r6)
            goto La0
        L9f:
            r6 = r7
        La0:
            if (r6 != 0) goto La4
            java.nio.charset.Charset r6 = r5.f49540a
        La4:
            org.slf4j.Logger r5 = io.ktor.client.plugins.HttpPlainTextKt.f49554a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Reading response body for "
            r8.<init>(r9)
            io.ktor.client.request.HttpRequest r4 = r4.d()
            io.ktor.http.Url r4 = r4.N()
            r8.append(r4)
            java.lang.String r4 = " as String with charset "
            r8.append(r4)
            r8.append(r6)
            java.lang.String r4 = r8.toString()
            r5.r(r4)
            java.lang.String r11 = io.ktor.utils.io.core.StringsKt.d(r11, r6)
            io.ktor.client.statement.HttpResponseContainer r4 = new io.ktor.client.statement.HttpResponseContainer
            r4.<init>(r1, r11)
            r10.f49551b = r7
            r10.f49552c = r7
            r10.f49550a = r3
            java.lang.Object r11 = r2.f(r4, r10)
            if (r11 != r0) goto Ldd
        Ldc:
            return r0
        Ldd:
            kotlin.Unit r11 = kotlin.Unit.f53572a
            return r11
        Le0:
            kotlin.Unit r11 = kotlin.Unit.f53572a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpPlainText$Plugin$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
