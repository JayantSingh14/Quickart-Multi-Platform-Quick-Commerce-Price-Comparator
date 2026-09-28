package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation", f = "ContentNegotiation.kt", l = {232}, m = "convertResponse$ktor_client_content_negotiation")
/* loaded from: classes3.dex */
final class ContentNegotiation$convertResponse$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Url f49872a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49873b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentNegotiation f49874c;

    /* renamed from: d, reason: collision with root package name */
    public int f49875d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$convertResponse$1(ContentNegotiation contentNegotiation, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49874c = contentNegotiation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49873b = obj;
        this.f49875d |= Integer.MIN_VALUE;
        return this.f49874c.b(null, null, null, null, null, this);
    }
}
