package okhttp3.internal.http;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a, reason: collision with root package name */
    public final RealCall f56578a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f56579b;

    /* renamed from: c, reason: collision with root package name */
    public final int f56580c;

    /* renamed from: d, reason: collision with root package name */
    public final Exchange f56581d;

    /* renamed from: e, reason: collision with root package name */
    public final Request f56582e;

    /* renamed from: f, reason: collision with root package name */
    public final int f56583f;

    /* renamed from: g, reason: collision with root package name */
    public final int f56584g;

    /* renamed from: h, reason: collision with root package name */
    public final int f56585h;

    /* renamed from: i, reason: collision with root package name */
    public int f56586i;

    public RealInterceptorChain(RealCall call, ArrayList interceptors, int i2, Exchange exchange, Request request, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f56578a = call;
        this.f56579b = interceptors;
        this.f56580c = i2;
        this.f56581d = exchange;
        this.f56582e = request;
        this.f56583f = i3;
        this.f56584g = i4;
        this.f56585h = i5;
    }

    public static RealInterceptorChain b(RealInterceptorChain realInterceptorChain, int i2, Exchange exchange, Request request, int i3) {
        if ((i3 & 1) != 0) {
            i2 = realInterceptorChain.f56580c;
        }
        int i4 = i2;
        if ((i3 & 2) != 0) {
            exchange = realInterceptorChain.f56581d;
        }
        Exchange exchange2 = exchange;
        if ((i3 & 4) != 0) {
            request = realInterceptorChain.f56582e;
        }
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "request");
        return new RealInterceptorChain(realInterceptorChain.f56578a, realInterceptorChain.f56579b, i4, exchange2, request2, realInterceptorChain.f56583f, realInterceptorChain.f56584g, realInterceptorChain.f56585h);
    }

    @Override // okhttp3.Interceptor.Chain
    public final Response a(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = this.f56579b;
        int size = arrayList.size();
        int i2 = this.f56580c;
        if (i2 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f56586i++;
        Exchange exchange = this.f56581d;
        if (exchange != null) {
            if (!exchange.f56491c.b(request.f56331a)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must retain the same host and port").toString());
            }
            if (this.f56586i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i3 = i2 + 1;
        RealInterceptorChain realInterceptorChainB = b(this, i3, null, request, 58);
        Interceptor interceptor = (Interceptor) arrayList.get(i2);
        Response responseA = interceptor.a(realInterceptorChainB);
        if (responseA == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (exchange != null && i3 < arrayList.size() && realInterceptorChainB.f56586i != 1) {
            throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
        }
        if (responseA.f56356g != null) {
            return responseA;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public final Request r() {
        return this.f56582e;
    }
}
