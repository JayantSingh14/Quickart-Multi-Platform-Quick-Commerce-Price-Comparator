package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49493a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49494b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpResponseContainer f49495c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 defaultTransformersJvmKt$platformResponseDefaultTransformers$1 = new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(3, (Continuation) obj3);
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.f49494b = (PipelineContext) obj;
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.f49495c = (HttpResponseContainer) obj2;
        return defaultTransformersJvmKt$platformResponseDefaultTransformers$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49493a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final PipelineContext pipelineContext = this.f49494b;
            HttpResponseContainer httpResponseContainer = this.f49495c;
            TypeInfo typeInfoA = httpResponseContainer.a();
            Object objB = httpResponseContainer.b();
            if (!(objB instanceof ByteReadChannel)) {
                return Unit.f53572a;
            }
            if (typeInfoA.f50602a.equals(Reflection.a(InputStream.class))) {
                final InputStream inputStreamA = BlockingKt.a((ByteReadChannel) objB, (Job) ((HttpClientCall) pipelineContext.f50587a).r().get(Job.Key.f54121a));
                HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfoA, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                    @Override // java.io.InputStream
                    public final int available() {
                        return inputStreamA.available();
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() throws IOException {
                        super.close();
                        inputStreamA.close();
                        HttpResponseKt.c(((HttpClientCall) pipelineContext.f50587a).e());
                    }

                    @Override // java.io.InputStream
                    public final int read() {
                        return inputStreamA.read();
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] b2, int i3, int i4) {
                        Intrinsics.checkNotNullParameter(b2, "b");
                        return inputStreamA.read(b2, i3, i4);
                    }
                });
                this.f49494b = null;
                this.f49493a = 1;
                if (pipelineContext.f(httpResponseContainer2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
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
