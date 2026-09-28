package io.ktor.client.plugins.websocket;

import android.support.v4.media.b;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.DefaultWebSocketSessionImpl;
import io.ktor.websocket.DefaultWebSocketSessionKt;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.slf4j.Logger;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", l = {212}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class WebSockets$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49988a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49989b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpResponseContainer f49990c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WebSockets f49991d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f49992e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$2(WebSockets webSockets, Continuation continuation, boolean z) {
        super(3, continuation);
        this.f49991d = webSockets;
        this.f49992e = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.f49991d, (Continuation) obj3, this.f49992e);
        webSockets$Plugin$install$2.f49989b = (PipelineContext) obj;
        webSockets$Plugin$install$2.f49990c = (HttpResponseContainer) obj2;
        return webSockets$Plugin$install$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [io.ktor.client.plugins.websocket.DefaultClientWebSocketSession] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v6, types: [io.ktor.websocket.WebSocketExtension] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DelegatingClientWebSocketSession delegatingClientWebSocketSession;
        DefaultWebSocketSession defaultWebSocketSession;
        ?? arrayList;
        ?? arrayList2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49988a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49989b;
            HttpResponseContainer httpResponseContainer = this.f49990c;
            TypeInfo typeInfo = httpResponseContainer.f50062a;
            HttpResponse httpResponseE = ((HttpClientCall) pipelineContext.f50587a).e();
            HttpStatusCode httpStatusCodeE = httpResponseE.e();
            boolean z = HttpResponseKt.d(httpResponseE).l1() instanceof WebSocketContent;
            Object obj2 = httpResponseContainer.f50063b;
            Object obj3 = pipelineContext.f50587a;
            if (!z) {
                WebSocketsKt.f49994b.r("Skipping non-websocket response from " + ((HttpClientCall) obj3).d().N() + ": " + obj2);
                return Unit.f53572a;
            }
            HttpStatusCode httpStatusCode = HttpStatusCode.f50219c;
            if (!Intrinsics.b(httpStatusCodeE, httpStatusCode)) {
                throw new WebSocketException("Handshake exception, expected status code " + httpStatusCode.f50229a + " but was " + httpStatusCodeE.f50229a);
            }
            if (!(obj2 instanceof WebSocketSession)) {
                throw new WebSocketException(b.j(obj2, "Handshake exception, expected `WebSocketSession` content but was "));
            }
            Logger logger = WebSocketsKt.f49994b;
            StringBuilder sb = new StringBuilder("Receive websocket session from ");
            HttpClientCall httpClientCall = (HttpClientCall) obj3;
            sb.append(httpClientCall.d().N());
            sb.append(": ");
            sb.append(obj2);
            logger.r(sb.toString());
            if (typeInfo.f50602a.equals(Reflection.a(DefaultClientWebSocketSession.class))) {
                WebSocketSession session = (WebSocketSession) obj2;
                WebSockets webSockets = this.f49991d;
                webSockets.getClass();
                Intrinsics.checkNotNullParameter(session, "session");
                boolean z2 = session instanceof DefaultWebSocketSession;
                if (z2) {
                    defaultWebSocketSession = (DefaultWebSocketSession) session;
                } else {
                    long j2 = webSockets.f49978a;
                    long j3 = 2 * j2;
                    Logger logger2 = DefaultWebSocketSessionKt.f51435a;
                    Intrinsics.checkNotNullParameter(session, "session");
                    if (z2) {
                        throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession");
                    }
                    DefaultWebSocketSessionImpl defaultWebSocketSessionImpl = new DefaultWebSocketSessionImpl(session, j2, j3);
                    defaultWebSocketSessionImpl.y0(webSockets.f49979b);
                    defaultWebSocketSession = defaultWebSocketSessionImpl;
                }
                ?? defaultClientWebSocketSession = new DefaultClientWebSocketSession(httpClientCall, defaultWebSocketSession);
                if (this.f49992e) {
                    Headers headers = httpClientCall.e().getHeaders();
                    List list = HttpHeaders.f50204a;
                    String value = headers.b("Sec-WebSocket-Extensions");
                    if (value != null) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        List listSplit$default = StringsKt__StringsKt.split$default(value, new String[]{","}, false, 0, 6, null);
                        arrayList2 = new ArrayList(CollectionsKt.r(listSplit$default, 10));
                        Iterator it = listSplit$default.iterator();
                        while (it.hasNext()) {
                            List listSplit$default2 = StringsKt__StringsKt.split$default((String) it.next(), new String[]{";"}, false, 0, 6, null);
                            String string = StringsKt.b0((String) CollectionsKt.z(listSplit$default2)).toString();
                            List listV = CollectionsKt.v(listSplit$default2);
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(listV, 10));
                            Iterator it2 = listV.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(StringsKt.b0((String) it2.next()).toString());
                            }
                            arrayList2.add(new WebSocketExtensionHeader(string, arrayList3));
                        }
                    } else {
                        arrayList2 = EmptyList.f53609a;
                    }
                    List list2 = (List) httpClientCall.j1().a(WebSocketsKt.f49993a);
                    arrayList = new ArrayList();
                    for (Object obj4 : list2) {
                        if (((WebSocketExtension) obj4).c(arrayList2)) {
                            arrayList.add(obj4);
                        }
                    }
                } else {
                    arrayList = EmptyList.f53609a;
                }
                defaultClientWebSocketSession.s1(arrayList);
                delegatingClientWebSocketSession = defaultClientWebSocketSession;
            } else {
                delegatingClientWebSocketSession = new DelegatingClientWebSocketSession(httpClientCall, (WebSocketSession) obj2);
            }
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, delegatingClientWebSocketSession);
            this.f49989b = null;
            this.f49988a = 1;
            if (pipelineContext.f(httpResponseContainer2, this) == coroutineSingletons) {
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
