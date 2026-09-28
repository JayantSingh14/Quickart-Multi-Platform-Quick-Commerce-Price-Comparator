package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class ResponseException extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final transient HttpResponse f49662a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseException(HttpResponse response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + '\"');
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.f49662a = response;
    }

    public final HttpResponse a() {
        return this.f49662a;
    }
}
