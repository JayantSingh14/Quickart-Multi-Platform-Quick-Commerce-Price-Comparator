package io.ktor.client.plugins;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$3", f = "HttpCallValidator.kt", l = {151, ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpCallValidator$Companion$install$3 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49512a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49513b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpRequestBuilder f49514c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCallValidator f49515d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$3(HttpCallValidator httpCallValidator, Continuation continuation) {
        super(3, continuation);
        this.f49515d = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpCallValidator$Companion$install$3 httpCallValidator$Companion$install$3 = new HttpCallValidator$Companion$install$3(this.f49515d, (Continuation) obj3);
        httpCallValidator$Companion$install$3.f49513b = (Sender) obj;
        httpCallValidator$Companion$install$3.f49514c = (HttpRequestBuilder) obj2;
        return httpCallValidator$Companion$install$3.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49512a;
        if (i2 == 0) {
            ResultKt.b(obj);
            Sender sender = (Sender) this.f49513b;
            HttpRequestBuilder httpRequestBuilder = this.f49514c;
            this.f49513b = null;
            this.f49512a = 1;
            obj = sender.a(httpRequestBuilder, this);
            if (obj != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HttpClientCall httpClientCall = (HttpClientCall) this.f49513b;
            ResultKt.b(obj);
            return httpClientCall;
        }
        ResultKt.b(obj);
        HttpClientCall httpClientCall2 = (HttpClientCall) obj;
        HttpResponse httpResponseE = httpClientCall2.e();
        this.f49513b = httpClientCall2;
        this.f49512a = 2;
        return HttpCallValidator.b(this.f49515d, httpResponseE, this) == coroutineSingletons ? coroutineSingletons : httpClientCall2;
    }
}
