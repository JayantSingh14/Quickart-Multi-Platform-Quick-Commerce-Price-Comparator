package io.ktor.client.plugins;

import coil3.network.internal.UtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.InputStream;
import java.util.List;
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
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {Type.RKEY}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49471a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49472b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49473c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(3, (Continuation) obj3);
        defaultTransformKt$defaultTransformers$1.f49472b = (PipelineContext) obj;
        defaultTransformKt$defaultTransformers$1.f49473c = obj2;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OutgoingContent textContent;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49471a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final PipelineContext pipelineContext = this.f49472b;
            final Object body = this.f49473c;
            HeadersBuilder headersBuilder = ((HttpRequestBuilder) pipelineContext.f50587a).f50005c;
            List list = HttpHeaders.f50204a;
            String strH = headersBuilder.h("Accept");
            Object obj2 = pipelineContext.f50587a;
            if (strH == null) {
                ((HttpRequestBuilder) obj2).f50005c.c("Accept", "*/*");
            }
            final ContentType contentTypeB = HttpMessagePropertiesKt.b((HttpMessageBuilder) obj2);
            if (body instanceof String) {
                String str = (String) body;
                if (contentTypeB == null) {
                    contentTypeB = ContentType.Text.a();
                }
                textContent = new TextContent(str, contentTypeB);
            } else if (body instanceof byte[]) {
                textContent = new OutgoingContent.ByteArrayContent(contentTypeB, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1

                    /* renamed from: a, reason: collision with root package name */
                    public final ContentType f49474a;

                    /* renamed from: b, reason: collision with root package name */
                    public final long f49475b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ Object f49476c;

                    {
                        this.f49476c = body;
                        if (contentTypeB == null) {
                            ContentType contentType = ContentType.Application.f50129a;
                            contentType = ContentType.Application.f50130b;
                        }
                        this.f49474a = contentType;
                        this.f49475b = ((byte[]) body).length;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final Long a() {
                        return Long.valueOf(this.f49475b);
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final ContentType b() {
                        return this.f49474a;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                    public final byte[] d() {
                        return (byte[]) this.f49476c;
                    }
                };
            } else if (body instanceof ByteReadChannel) {
                textContent = new OutgoingContent.ReadChannelContent(pipelineContext, contentTypeB, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2

                    /* renamed from: a, reason: collision with root package name */
                    public final Long f49477a;

                    /* renamed from: b, reason: collision with root package name */
                    public final ContentType f49478b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ Object f49479c;

                    {
                        this.f49479c = body;
                        HeadersBuilder headersBuilder2 = ((HttpRequestBuilder) pipelineContext.f50587a).f50005c;
                        List list2 = HttpHeaders.f50204a;
                        String strH2 = headersBuilder2.h("Content-Length");
                        this.f49477a = strH2 != null ? Long.valueOf(Long.parseLong(strH2)) : null;
                        if (contentTypeB == null) {
                            ContentType contentType = ContentType.Application.f50129a;
                            contentType = ContentType.Application.f50130b;
                        }
                        this.f49478b = contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final Long a() {
                        return this.f49477a;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final ContentType b() {
                        return this.f49478b;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public final ByteReadChannel d() {
                        return (ByteReadChannel) this.f49479c;
                    }
                };
            } else if (body instanceof OutgoingContent) {
                textContent = (OutgoingContent) body;
            } else {
                final HttpRequestBuilder context = (HttpRequestBuilder) obj2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(body, "body");
                textContent = body instanceof InputStream ? new OutgoingContent.ReadChannelContent(context, contentTypeB, body) { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformRequestDefaultTransform$1

                    /* renamed from: a, reason: collision with root package name */
                    public final Long f49490a;

                    /* renamed from: b, reason: collision with root package name */
                    public final ContentType f49491b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ Object f49492c;

                    {
                        this.f49492c = body;
                        HeadersBuilder headersBuilder2 = context.f50005c;
                        List list2 = HttpHeaders.f50204a;
                        String strH2 = headersBuilder2.h("Content-Length");
                        this.f49490a = strH2 != null ? Long.valueOf(Long.parseLong(strH2)) : null;
                        if (contentTypeB == null) {
                            ContentType contentType = ContentType.Application.f50129a;
                            contentType = ContentType.Application.f50130b;
                        }
                        this.f49491b = contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final Long a() {
                        return this.f49490a;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final ContentType b() {
                        return this.f49491b;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public final ByteReadChannel d() {
                        return ReadingKt.a((InputStream) this.f49492c);
                    }
                } : null;
            }
            if ((textContent != null ? textContent.b() : null) != null) {
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj2;
                httpRequestBuilder.f50005c.i(UtilsKt.CONTENT_TYPE);
                DefaultTransformKt.f49470a.r("Transformed with default transformers request body for " + httpRequestBuilder.f50003a + " from " + Reflection.a(body.getClass()));
                this.f49472b = null;
                this.f49471a = 1;
                if (pipelineContext.f(textContent, this) == coroutineSingletons) {
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
