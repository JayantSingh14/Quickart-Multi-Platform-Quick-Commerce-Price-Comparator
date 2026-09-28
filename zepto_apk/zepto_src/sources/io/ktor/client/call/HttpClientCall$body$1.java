package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {WKSRecord.Service.SFTP}, m = "body")
/* loaded from: classes3.dex */
final class HttpClientCall$body$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49305a;

    /* renamed from: b, reason: collision with root package name */
    public int f49306b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49305a = obj;
        this.f49306b |= Integer.MIN_VALUE;
        throw null;
    }
}
