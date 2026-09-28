package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata
/* loaded from: classes.dex */
public final class HttpRequestBuilder implements HttpMessageBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final URLBuilder f50003a = new URLBuilder(0);

    /* renamed from: b, reason: collision with root package name */
    public HttpMethod f50004b = HttpMethod.f50205b;

    /* renamed from: c, reason: collision with root package name */
    public final HeadersBuilder f50005c = new HeadersBuilder(true);

    /* renamed from: d, reason: collision with root package name */
    public Object f50006d = EmptyContent.f50113a;

    /* renamed from: e, reason: collision with root package name */
    public Job f50007e = SupervisorKt.b();

    /* renamed from: f, reason: collision with root package name */
    public final Attributes f50008f = AttributesJvmKt.a();

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public final HttpRequestData a() {
        Url urlB = this.f50003a.b();
        HttpMethod httpMethod = this.f50004b;
        HeadersImpl headersImplL = this.f50005c.l();
        Object obj = this.f50006d;
        OutgoingContent outgoingContent = obj instanceof OutgoingContent ? (OutgoingContent) obj : null;
        if (outgoingContent != null) {
            return new HttpRequestData(urlB, httpMethod, headersImplL, outgoingContent, this.f50007e, this.f50008f);
        }
        throw new IllegalStateException(("No request transformation found: " + this.f50006d).toString());
    }

    public final void b(TypeInfo typeInfo) {
        Attributes attributes = this.f50008f;
        if (typeInfo != null) {
            attributes.b(RequestBodyKt.f50036a, typeInfo);
        } else {
            attributes.d(RequestBodyKt.f50036a);
        }
    }

    public final void c(HttpClientEngineCapability key, Object capability) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(capability, "capability");
        ((Map) this.f50008f.g(HttpClientEngineCapabilityKt.f49353a, HttpRequestBuilder$setCapability$capabilities$1.f50009c)).put(key, capability);
    }

    public final void d(HttpRequestBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f50004b = builder.f50004b;
        this.f50006d = builder.f50006d;
        Attributes other = builder.f50008f;
        b((TypeInfo) other.f(RequestBodyKt.f50036a));
        URLBuilder uRLBuilder = this.f50003a;
        URLUtilsKt.b(uRLBuilder, builder.f50003a);
        uRLBuilder.c(uRLBuilder.f50248h);
        StringValuesKt.a(this.f50005c, builder.f50005c);
        Attributes attributes = this.f50008f;
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (AttributeKey attributeKey : other.c()) {
            Intrinsics.d(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            attributes.b(attributeKey, other.a(attributeKey));
        }
    }

    @Override // io.ktor.http.HttpMessageBuilder
    public final HeadersBuilder getHeaders() {
        return this.f50005c;
    }
}
