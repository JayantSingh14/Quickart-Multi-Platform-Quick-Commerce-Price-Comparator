package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public abstract class HttpResponse implements HttpMessage, CoroutineScope {
    public abstract ByteReadChannel a();

    public abstract GMTDate c();

    public abstract GMTDate d();

    public abstract HttpStatusCode e();

    public abstract HttpProtocolVersion f();

    public abstract HttpClientCall o1();

    public final String toString() {
        return "HttpResponse[" + HttpResponseKt.d(this).N() + ", " + e() + ']';
    }
}
