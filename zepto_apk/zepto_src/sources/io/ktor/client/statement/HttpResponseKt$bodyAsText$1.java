package io.ktor.client.statement;

import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {WKSRecord.Service.SWIFT_RVF}, m = "bodyAsText")
/* loaded from: classes3.dex */
final class HttpResponseKt$bodyAsText$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CharsetDecoder f50066a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50067b;

    /* renamed from: c, reason: collision with root package name */
    public int f50068c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50067b = obj;
        this.f50068c |= Integer.MIN_VALUE;
        return HttpResponseKt.a(null, null, this);
    }
}
