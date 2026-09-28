package okhttp3;

import kotlin.Metadata;
import okhttp3.internal.http.RealInterceptorChain;

@Metadata
/* loaded from: classes.dex */
public interface Interceptor {

    @Metadata
    public interface Chain {
        Response a(Request request);

        Request r();
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    Response a(RealInterceptorChain realInterceptorChain);
}
