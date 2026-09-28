package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", l = {146, 174}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpTimeout$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49650a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Sender f49651b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpRequestBuilder f49652c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpTimeout f49653d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49654e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1(HttpTimeout httpTimeout, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49653d = httpTimeout;
        this.f49654e = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpTimeout$Plugin$install$1 httpTimeout$Plugin$install$1 = new HttpTimeout$Plugin$install$1(this.f49653d, this.f49654e, (Continuation) obj3);
        httpTimeout$Plugin$install$1.f49651b = (Sender) obj;
        httpTimeout$Plugin$install$1.f49652c = (HttpRequestBuilder) obj2;
        return httpTimeout$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49650a;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.b(obj);
                return obj;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Sender sender = this.f49651b;
        HttpRequestBuilder httpRequestBuilder = this.f49652c;
        URLProtocol uRLProtocol = httpRequestBuilder.f50003a.f50241a;
        Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
        if ((Intrinsics.b(uRLProtocol.f50257a, "ws") || Intrinsics.b(uRLProtocol.f50257a, "wss")) || (httpRequestBuilder.f50006d instanceof ClientUpgradeContent)) {
            this.f49651b = null;
            this.f49650a = 1;
            Object objA = sender.a(httpRequestBuilder, this);
            if (objA != coroutineSingletons) {
                return objA;
            }
        } else {
            HttpTimeout.Plugin key = HttpTimeout.f49642d;
            Intrinsics.checkNotNullParameter(key, "key");
            Map map = (Map) httpRequestBuilder.f50008f.f(HttpClientEngineCapabilityKt.f49353a);
            HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) (map != null ? map.get(key) : null);
            HttpTimeout httpTimeout = this.f49653d;
            if (httpTimeoutCapabilityConfiguration == null && (httpTimeout.f49644a != null || httpTimeout.f49645b != null || httpTimeout.f49646c != null)) {
                httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration();
                httpRequestBuilder.c(key, httpTimeoutCapabilityConfiguration);
            }
            if (httpTimeoutCapabilityConfiguration != null) {
                Long l2 = httpTimeoutCapabilityConfiguration.f49648b;
                if (l2 == null) {
                    l2 = httpTimeout.f49645b;
                }
                HttpTimeout.HttpTimeoutCapabilityConfiguration.a(l2);
                httpTimeoutCapabilityConfiguration.f49648b = l2;
                Long l3 = httpTimeoutCapabilityConfiguration.f49649c;
                if (l3 == null) {
                    l3 = httpTimeout.f49646c;
                }
                HttpTimeout.HttpTimeoutCapabilityConfiguration.a(l3);
                httpTimeoutCapabilityConfiguration.f49649c = l3;
                Long l4 = httpTimeoutCapabilityConfiguration.f49647a;
                if (l4 == null) {
                    l4 = httpTimeout.f49644a;
                }
                HttpTimeout.HttpTimeoutCapabilityConfiguration.a(l4);
                httpTimeoutCapabilityConfiguration.f49647a = l4;
                if (l4 == null) {
                    l4 = httpTimeout.f49644a;
                }
                if (l4 != null && l4.longValue() != Long.MAX_VALUE) {
                    final Job jobC = BuildersKt.c(this.f49654e, null, new HttpTimeout$Plugin$install$1$1$killer$1(l4, httpRequestBuilder, httpRequestBuilder.f50007e, null), 3);
                    ((JobSupport) httpRequestBuilder.f50007e).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            ((JobSupport) jobC).e(null);
                            return Unit.f53572a;
                        }
                    });
                }
            }
            this.f49651b = null;
            this.f49650a = 2;
            Object objA2 = sender.a(httpRequestBuilder, this);
            if (objA2 != coroutineSingletons) {
                return objA2;
            }
        }
        return coroutineSingletons;
    }
}
