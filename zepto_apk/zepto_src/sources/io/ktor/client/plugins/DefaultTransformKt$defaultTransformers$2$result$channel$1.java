package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelJVMKt;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1", f = "DefaultTransform.kt", l = {100}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DefaultTransformKt$defaultTransformers$2$result$channel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49485a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49486b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f49487c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpResponse f49488d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2$result$channel$1(ByteReadChannel byteReadChannel, HttpResponse httpResponse, Continuation continuation) {
        super(2, continuation);
        this.f49487c = byteReadChannel;
        this.f49488d = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultTransformKt$defaultTransformers$2$result$channel$1 defaultTransformKt$defaultTransformers$2$result$channel$1 = new DefaultTransformKt$defaultTransformers$2$result$channel$1(this.f49487c, this.f49488d, continuation);
        defaultTransformKt$defaultTransformers$2$result$channel$1.f49486b = obj;
        return defaultTransformKt$defaultTransformers$2$result$channel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DefaultTransformKt$defaultTransformers$2$result$channel$1) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49485a;
        HttpResponse httpResponse = this.f49488d;
        try {
            if (i2 != 0) {
                try {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                } catch (Throwable th) {
                    HttpResponseKt.c(httpResponse);
                    throw th;
                }
            } else {
                ResultKt.b(obj);
                WriterScope writerScope = (WriterScope) this.f49486b;
                ByteReadChannel byteReadChannel = this.f49487c;
                ByteChannel byteChannelL0 = writerScope.l0();
                this.f49485a = 1;
                if (ByteReadChannelJVMKt.a(byteReadChannel, byteChannelL0, Long.MAX_VALUE, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            HttpResponseKt.c(httpResponse);
            return Unit.f53572a;
        } catch (CancellationException e2) {
            CoroutineScopeKt.b(httpResponse, e2);
            throw e2;
        } catch (Throwable th2) {
            CoroutineScopeKt.b(httpResponse, ExceptionsKt.a("Receive failed", th2));
            throw th2;
        }
    }
}
