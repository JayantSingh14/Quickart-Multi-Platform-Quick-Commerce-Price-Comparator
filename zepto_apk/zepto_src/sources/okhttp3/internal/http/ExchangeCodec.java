package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;

@Metadata
/* loaded from: classes.dex */
public interface ExchangeCodec {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    void a();

    Source b(Response response);

    RealConnection c();

    void cancel();

    long d(Response response);

    Sink e(Request request, long j2);

    void f(Request request);

    Response.Builder g(boolean z);

    void h();
}
