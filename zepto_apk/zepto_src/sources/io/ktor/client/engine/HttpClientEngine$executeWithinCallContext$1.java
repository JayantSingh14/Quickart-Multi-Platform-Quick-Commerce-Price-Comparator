package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestData;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$DefaultImpls", f = "HttpClientEngine.kt", l = {WKSRecord.Service.MIT_DOV, 100}, m = "executeWithinCallContext")
/* loaded from: classes.dex */
final class HttpClientEngine$executeWithinCallContext$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpClientEngine f49335a;

    /* renamed from: b, reason: collision with root package name */
    public HttpRequestData f49336b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49337c;

    /* renamed from: d, reason: collision with root package name */
    public int f49338d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49337c = obj;
        this.f49338d |= Integer.MIN_VALUE;
        return HttpClientEngine.DefaultImpls.a(null, null, this);
    }
}
