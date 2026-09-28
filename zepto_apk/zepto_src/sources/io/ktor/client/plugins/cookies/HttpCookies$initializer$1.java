package io.ktor.client.plugins.cookies;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$initializer$1", f = "HttpCookies.kt", l = {32}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class HttpCookies$initializer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public HttpCookies f49925a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f49926b;

    /* renamed from: c, reason: collision with root package name */
    public int f49927c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49928d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$initializer$1(HttpCookies httpCookies, Continuation continuation) {
        super(2, continuation);
        this.f49928d = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpCookies$initializer$1(this.f49928d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HttpCookies$initializer$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        HttpCookies httpCookies;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49927c;
        if (i2 == 0) {
            ResultKt.b(obj);
            HttpCookies httpCookies2 = this.f49928d;
            it = httpCookies2.f49901b.iterator();
            httpCookies = httpCookies2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f49926b;
            httpCookies = this.f49925a;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            Function2 function2 = (Function2) it.next();
            AcceptAllCookiesStorage acceptAllCookiesStorage = httpCookies.f49900a;
            this.f49925a = httpCookies;
            this.f49926b = it;
            this.f49927c = 1;
            if (function2.invoke(acceptAllCookiesStorage, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}
