package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.websocket.WebSocketExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$1", f = "WebSockets.kt", l = {169}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class WebSockets$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49984a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49985b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f49986c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WebSockets f49987d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$1(WebSockets webSockets, Continuation continuation, boolean z) {
        super(3, continuation);
        this.f49986c = z;
        this.f49987d = webSockets;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z = this.f49986c;
        WebSockets$Plugin$install$1 webSockets$Plugin$install$1 = new WebSockets$Plugin$install$1(this.f49987d, (Continuation) obj3, z);
        webSockets$Plugin$install$1.f49985b = (PipelineContext) obj;
        return webSockets$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49984a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49985b;
            URLProtocol uRLProtocol = ((HttpRequestBuilder) pipelineContext.f50587a).f50003a.f50241a;
            Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
            boolean z = Intrinsics.b(uRLProtocol.f50257a, "ws") || Intrinsics.b(uRLProtocol.f50257a, "wss");
            Object obj2 = pipelineContext.f50587a;
            if (!z) {
                WebSocketsKt.f49994b.r("Skipping WebSocket plugin for non-websocket request: " + ((HttpRequestBuilder) obj2).f50003a);
                return Unit.f53572a;
            }
            Logger logger = WebSocketsKt.f49994b;
            StringBuilder sb = new StringBuilder("Sending WebSocket request ");
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj2;
            sb.append(httpRequestBuilder.f50003a);
            logger.r(sb.toString());
            httpRequestBuilder.c(WebSocketCapability.f49973a, Unit.f53572a);
            if (this.f49986c) {
                ArrayList arrayList = this.f49987d.f49980c.f51517a;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add((WebSocketExtension) ((Function0) it.next()).invoke());
                }
                httpRequestBuilder.f50008f.b(WebSocketsKt.f49993a, arrayList2);
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.i(arrayList3, ((WebSocketExtension) it2.next()).d());
                }
                if (!arrayList3.isEmpty()) {
                    String strE = CollectionsKt.E(arrayList3, ";", null, null, null, 62);
                    List list = HttpHeaders.f50204a;
                    UtilsKt.a(httpRequestBuilder, "Sec-WebSocket-Extensions", strE);
                }
            }
            WebSocketContent webSocketContent = new WebSocketContent();
            this.f49984a = 1;
            if (pipelineContext.f(webSocketContent, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
