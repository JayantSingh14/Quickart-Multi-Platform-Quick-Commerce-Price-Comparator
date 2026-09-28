package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation", f = "ContentNegotiation.kt", l = {182}, m = "convertRequest$ktor_client_content_negotiation")
/* loaded from: classes.dex */
final class ContentNegotiation$convertRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpRequestBuilder f49862a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49863b;

    /* renamed from: c, reason: collision with root package name */
    public ContentType f49864c;

    /* renamed from: d, reason: collision with root package name */
    public List f49865d;

    /* renamed from: e, reason: collision with root package name */
    public Iterator f49866e;

    /* renamed from: f, reason: collision with root package name */
    public ContentNegotiation.Config.ConverterRegistration f49867f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f49868g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ContentNegotiation f49869h;

    /* renamed from: i, reason: collision with root package name */
    public int f49870i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$convertRequest$1(ContentNegotiation contentNegotiation, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49869h = contentNegotiation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49868g = obj;
        this.f49870i |= Integer.MIN_VALUE;
        return this.f49869h.a(null, null, this);
    }
}
