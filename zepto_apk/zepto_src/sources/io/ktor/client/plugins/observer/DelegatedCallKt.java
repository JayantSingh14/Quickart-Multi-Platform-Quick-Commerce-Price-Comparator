package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DelegatedCallKt {
    public static final DelegatedCall a(HttpClientCall originCall, ByteReadChannel content) {
        Intrinsics.checkNotNullParameter(originCall, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        HttpClient client = originCall.f49302a;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(originCall, "originCall");
        DelegatedCall delegatedCall = new DelegatedCall(client);
        DelegatedRequest delegatedRequest = new DelegatedRequest(delegatedCall, originCall.d());
        Intrinsics.checkNotNullParameter(delegatedRequest, "<set-?>");
        delegatedCall.f49303b = delegatedRequest;
        DelegatedResponse delegatedResponse = new DelegatedResponse(delegatedCall, content, originCall.e());
        Intrinsics.checkNotNullParameter(delegatedResponse, "<set-?>");
        delegatedCall.f49304c = delegatedResponse;
        return delegatedCall;
    }
}
