package okhttp3.internal.connection;

import coil3.network.internal.UtilsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

@Metadata
/* loaded from: classes.dex */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public static final ConnectInterceptor f56484a = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response a(RealInterceptorChain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealCall realCall = chain.f56578a;
        realCall.getClass();
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (realCall) {
            if (!realCall.o) {
                throw new IllegalStateException("released");
            }
            if (realCall.n) {
                throw new IllegalStateException("Check failed.");
            }
            if (realCall.f56529m) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.f53572a;
        }
        ExchangeFinder exchangeFinder = realCall.f56525i;
        Intrinsics.c(exchangeFinder);
        OkHttpClient client = realCall.f56517a;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            int i2 = chain.f56583f;
            int i3 = chain.f56584g;
            int i4 = chain.f56585h;
            client.getClass();
            Exchange exchange = new Exchange(realCall, realCall.f56521e, exchangeFinder, exchangeFinder.a(i2, i3, i4, client.f56302f, !Intrinsics.b(chain.f56582e.f56332b, UtilsKt.HTTP_METHOD_GET)).j(client, chain));
            realCall.f56528l = exchange;
            realCall.q = exchange;
            synchronized (realCall) {
                realCall.f56529m = true;
                realCall.n = true;
            }
            if (realCall.p) {
                throw new IOException("Canceled");
            }
            return RealInterceptorChain.b(chain, 0, exchange, null, 61).a(chain.f56582e);
        } catch (IOException e2) {
            exchangeFinder.c(e2);
            throw new RouteException(e2);
        } catch (RouteException e3) {
            exchangeFinder.c(e3.f56560b);
            throw e3;
        }
    }
}
