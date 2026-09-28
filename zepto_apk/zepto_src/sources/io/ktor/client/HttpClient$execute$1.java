package io.ktor.client;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.HttpClient", f = "HttpClient.kt", l = {191}, m = "execute$ktor_client_core")
/* loaded from: classes.dex */
final class HttpClient$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49278a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49279b;

    /* renamed from: c, reason: collision with root package name */
    public int f49280c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient$execute$1(HttpClient httpClient, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49279b = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49278a = obj;
        this.f49280c |= Integer.MIN_VALUE;
        return this.f49279b.a(null, this);
    }
}
