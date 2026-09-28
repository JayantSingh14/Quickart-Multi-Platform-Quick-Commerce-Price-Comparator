package io.ktor.client.plugins;

import android.support.v4.media.b;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.ParametersBuilderImpl;
import io.ktor.http.ParametersKt;
import io.ktor.http.QueryKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.UrlDecodedParametersBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.StringValuesKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.slf4j.Logger;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class DefaultRequest$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49461a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultRequest f49462b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRequest$Plugin$install$1(DefaultRequest defaultRequest, Continuation continuation) {
        super(3, continuation);
        this.f49462b = defaultRequest;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        DefaultRequest$Plugin$install$1 defaultRequest$Plugin$install$1 = new DefaultRequest$Plugin$install$1(this.f49462b, (Continuation) obj3);
        defaultRequest$Plugin$install$1.f49461a = (PipelineContext) obj;
        return defaultRequest$Plugin$install$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        PipelineContext pipelineContext = this.f49461a;
        String string = ((HttpRequestBuilder) pipelineContext.f50587a).f50003a.toString();
        DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = new DefaultRequest.DefaultRequestBuilder();
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.f50587a;
        HeadersBuilder headersBuilder = httpRequestBuilder.f50005c;
        HeadersBuilder headersBuilder2 = defaultRequestBuilder.f49458a;
        StringValuesKt.a(headersBuilder2, headersBuilder);
        this.f49462b.f49457a.invoke(defaultRequestBuilder);
        Url url = defaultRequestBuilder.f49459b.b();
        DefaultRequest.Plugin plugin = DefaultRequest.f49455b;
        URLBuilder uRLBuilder = httpRequestBuilder.f50003a;
        boolean zB = Intrinsics.b(uRLBuilder.f50241a, URLProtocol.f50253c);
        URLProtocol uRLProtocol = url.f50260a;
        if (zB) {
            uRLBuilder.e(uRLProtocol);
        }
        if (uRLBuilder.f50242b.length() <= 0) {
            Intrinsics.checkNotNullParameter(url, "url");
            URLBuilder uRLBuilder2 = new URLBuilder(0);
            Intrinsics.checkNotNullParameter(uRLBuilder2, "<this>");
            Intrinsics.checkNotNullParameter(url, "url");
            uRLBuilder2.e(uRLProtocol);
            uRLBuilder2.d(url.f50261b);
            int i2 = url.f50262c;
            Integer numValueOf = Integer.valueOf(i2);
            if (i2 == 0) {
                numValueOf = null;
            }
            uRLBuilder2.f50243c = numValueOf != null ? numValueOf.intValue() : uRLProtocol.f50258b;
            URLBuilderKt.d(uRLBuilder2, (String) url.f50269j.getValue());
            uRLBuilder2.f50245e = (String) url.f50272m.getValue();
            uRLBuilder2.f50246f = (String) url.n.getValue();
            ParametersBuilderImpl value = ParametersKt.a();
            value.e(QueryKt.b((String) url.f50270k.getValue()));
            Intrinsics.checkNotNullParameter(value, "value");
            uRLBuilder2.f50249i = value;
            uRLBuilder2.f50250j = new UrlDecodedParametersBuilder(value);
            String str = (String) url.o.getValue();
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            uRLBuilder2.f50247g = str;
            uRLBuilder2.f50244d = url.f50267h;
            uRLBuilder2.e(uRLBuilder.f50241a);
            int i3 = uRLBuilder.f50243c;
            if (i3 != 0) {
                uRLBuilder2.f50243c = i3;
            }
            List listJ = uRLBuilder2.f50248h;
            List list = uRLBuilder.f50248h;
            if (!list.isEmpty()) {
                if (listJ.isEmpty() || ((CharSequence) CollectionsKt.z(list)).length() == 0) {
                    listJ = list;
                } else {
                    ListBuilder builder = new ListBuilder((list.size() + listJ.size()) - 1);
                    int size = listJ.size() - 1;
                    for (int i4 = 0; i4 < size; i4++) {
                        builder.add(listJ.get(i4));
                    }
                    builder.addAll(list);
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    listJ = builder.j();
                }
            }
            uRLBuilder2.c(listJ);
            if (uRLBuilder.f50247g.length() > 0) {
                String str2 = uRLBuilder.f50247g;
                Intrinsics.checkNotNullParameter(str2, "<set-?>");
                uRLBuilder2.f50247g = str2;
            }
            ParametersBuilderImpl parametersBuilderImplA = ParametersKt.a();
            StringValuesKt.a(parametersBuilderImplA, uRLBuilder2.f50249i);
            ParametersBuilderImpl value2 = uRLBuilder.f50249i;
            Intrinsics.checkNotNullParameter(value2, "value");
            uRLBuilder2.f50249i = value2;
            uRLBuilder2.f50250j = new UrlDecodedParametersBuilder(value2);
            for (Map.Entry entry : parametersBuilderImplA.d()) {
                String name = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                ParametersBuilderImpl parametersBuilderImpl = uRLBuilder2.f50249i;
                parametersBuilderImpl.getClass();
                Intrinsics.checkNotNullParameter(name, "name");
                if (!parametersBuilderImpl.f50508b.containsKey(name)) {
                    uRLBuilder2.f50249i.b(list2, name);
                }
            }
            URLUtilsKt.b(uRLBuilder, uRLBuilder2);
        }
        Attributes attributes = defaultRequestBuilder.f49460c;
        for (AttributeKey attributeKey : attributes.c()) {
            if (!httpRequestBuilder.f50008f.e(attributeKey)) {
                httpRequestBuilder.f50008f.b(attributeKey, attributes.a(attributeKey));
            }
        }
        httpRequestBuilder.f50005c.f();
        httpRequestBuilder.f50005c.e(headersBuilder2.l());
        Logger logger = DefaultRequestKt.f49463a;
        StringBuilder sbY = b.y("Applied DefaultRequest to ", string, ". New url: ");
        sbY.append(httpRequestBuilder.f50003a);
        logger.r(sbY.toString());
        return Unit.f53572a;
    }
}
