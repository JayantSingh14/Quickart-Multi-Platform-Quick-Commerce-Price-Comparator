package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RedirectResponseException extends ResponseException {

    /* renamed from: b, reason: collision with root package name */
    public final String f49661b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedirectResponseException(HttpResponse response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.f49661b = "Unhandled redirect: " + response.o1().d().l().f50209a + ' ' + response.o1().d().N() + ". Status: " + response.e() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f49661b;
    }
}
