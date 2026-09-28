package io.ktor.client.plugins.cache;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class InvalidCacheStateException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidCacheStateException(Url requestUrl) {
        super("The entry for url: " + requestUrl + " was removed from cache");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
    }
}
