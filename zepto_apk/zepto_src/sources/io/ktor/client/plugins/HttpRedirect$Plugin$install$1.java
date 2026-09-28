package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin$install$1", f = "HttpRedirect.kt", l = {64, 69}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpRedirect$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49569a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Sender f49570b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpRequestBuilder f49571c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpRedirect f49572d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49573e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$install$1(HttpRedirect httpRedirect, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49572d = httpRedirect;
        this.f49573e = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpRedirect$Plugin$install$1 httpRedirect$Plugin$install$1 = new HttpRedirect$Plugin$install$1(this.f49572d, this.f49573e, (Continuation) obj3);
        httpRedirect$Plugin$install$1.f49570b = (Sender) obj;
        httpRedirect$Plugin$install$1.f49571c = (HttpRequestBuilder) obj2;
        return httpRedirect$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequestBuilder httpRequestBuilder;
        Sender sender;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49569a;
        if (i2 == 0) {
            ResultKt.b(obj);
            Sender sender2 = this.f49570b;
            httpRequestBuilder = this.f49571c;
            this.f49570b = sender2;
            this.f49571c = httpRequestBuilder;
            this.f49569a = 1;
            Object objA = sender2.a(httpRequestBuilder, this);
            if (objA != coroutineSingletons) {
                sender = sender2;
                obj = objA;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        httpRequestBuilder = this.f49571c;
        sender = this.f49570b;
        ResultKt.b(obj);
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        this.f49572d.getClass();
        if (!HttpRedirectKt.f49574a.contains(httpClientCall.d().l())) {
            return httpClientCall;
        }
        HttpRedirect.Plugin plugin = HttpRedirect.f49555a;
        this.f49570b = null;
        this.f49571c = null;
        this.f49569a = 2;
        Object objC = HttpRedirect.Plugin.c(sender, httpRequestBuilder, httpClientCall, this.f49573e, this);
        return objC == coroutineSingletons ? coroutineSingletons : objC;
    }
}
