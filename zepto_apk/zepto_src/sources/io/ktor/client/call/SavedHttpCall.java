package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteChannelCtorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SavedHttpCall extends HttpClientCall {

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f49316f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f49317g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient client, HttpRequest request, HttpResponse response, byte[] responseBody) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.f49316f = responseBody;
        SavedHttpRequest savedHttpRequest = new SavedHttpRequest(this, request);
        Intrinsics.checkNotNullParameter(savedHttpRequest, "<set-?>");
        this.f49303b = savedHttpRequest;
        SavedHttpResponse savedHttpResponse = new SavedHttpResponse(this, responseBody, response);
        Intrinsics.checkNotNullParameter(savedHttpResponse, "<set-?>");
        this.f49304c = savedHttpResponse;
        this.f49317g = true;
    }

    @Override // io.ktor.client.call.HttpClientCall
    public final boolean c() {
        return this.f49317g;
    }

    @Override // io.ktor.client.call.HttpClientCall
    public final Object f() {
        return ByteChannelCtorKt.a(this.f49316f);
    }
}
