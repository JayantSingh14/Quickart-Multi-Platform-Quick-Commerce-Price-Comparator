package io.ktor.client.call;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {86, WKSRecord.Service.SU_MIT_TG}, m = "bodyNullable")
/* loaded from: classes3.dex */
final class HttpClientCall$bodyNullable$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpClientCall f49307a;

    /* renamed from: b, reason: collision with root package name */
    public TypeInfo f49308b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49309c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpClientCall f49310d;

    /* renamed from: e, reason: collision with root package name */
    public int f49311e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCall$bodyNullable$1(HttpClientCall httpClientCall, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49310d = httpClientCall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49309c = obj;
        this.f49311e |= Integer.MIN_VALUE;
        return this.f49310d.a(null, this);
    }
}
