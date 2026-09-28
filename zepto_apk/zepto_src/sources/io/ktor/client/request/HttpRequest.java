package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes3.dex */
public interface HttpRequest extends HttpMessage, CoroutineScope {

    @Metadata
    public static final class DefaultImpls {
    }

    Url N();

    Attributes j1();

    HttpMethod l();

    OutgoingContent l1();

    HttpClientCall o1();

    CoroutineContext r();
}
