package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import java.nio.charset.Charset;
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
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.slf4j.Logger;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$1", f = "HttpPlainText.kt", l = {WKSRecord.Service.CISCO_FNA}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HttpPlainText$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f49546a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49547b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49548c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpPlainText f49549d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$1(HttpPlainText httpPlainText, Continuation continuation) {
        super(3, continuation);
        this.f49549d = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpPlainText$Plugin$install$1 httpPlainText$Plugin$install$1 = new HttpPlainText$Plugin$install$1(this.f49549d, (Continuation) obj3);
        httpPlainText$Plugin$install$1.f49547b = (PipelineContext) obj;
        httpPlainText$Plugin$install$1.f49548c = obj2;
        return httpPlainText$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Charset charsetA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49546a;
        if (i2 == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = this.f49547b;
            Object obj2 = this.f49548c;
            HttpRequestBuilder context = (HttpRequestBuilder) pipelineContext.f50587a;
            HttpPlainText httpPlainText = this.f49549d;
            httpPlainText.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            HeadersBuilder headersBuilder = context.f50005c;
            List list = HttpHeaders.f50204a;
            if (headersBuilder.h("Accept-Charset") == null) {
                Logger logger = HttpPlainTextKt.f49554a;
                StringBuilder sb = new StringBuilder("Adding Accept-Charset=");
                String value = httpPlainText.f49542c;
                sb.append(value);
                sb.append(" to ");
                sb.append(context.f50003a);
                logger.r(sb.toString());
                HeadersBuilder headersBuilder2 = context.f50005c;
                headersBuilder2.getClass();
                Intrinsics.checkNotNullParameter("Accept-Charset", CLConstants.FIELD_PAY_INFO_NAME);
                Intrinsics.checkNotNullParameter(value, "value");
                headersBuilder2.k(value);
                List listG = headersBuilder2.g("Accept-Charset");
                listG.clear();
                listG.add(value);
            }
            if (!(obj2 instanceof String)) {
                return Unit.f53572a;
            }
            Object obj3 = pipelineContext.f50587a;
            ContentType contentTypeB = HttpMessagePropertiesKt.b((HttpMessageBuilder) obj3);
            if (contentTypeB != null) {
                if (!Intrinsics.b(contentTypeB.f50127c, ContentType.Text.a().f50127c)) {
                    return Unit.f53572a;
                }
            }
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj3;
            String str = (String) obj2;
            ContentType contentTypeA = contentTypeB == null ? ContentType.Text.a() : contentTypeB;
            if (contentTypeB == null || (charsetA = ContentTypesKt.a(contentTypeB)) == null) {
                charsetA = httpPlainText.f49541b;
            }
            HttpPlainTextKt.f49554a.r("Sending request body to " + httpRequestBuilder.f50003a + " as text/plain with charset " + charsetA);
            TextContent textContent = new TextContent(str, ContentTypesKt.b(contentTypeA, charsetA));
            this.f49547b = null;
            this.f49546a = 1;
            if (pipelineContext.f(textContent, this) == coroutineSingletons) {
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
