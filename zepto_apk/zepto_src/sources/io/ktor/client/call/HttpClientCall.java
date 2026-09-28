package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class HttpClientCall implements CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public final HttpClient f49302a;

    /* renamed from: b, reason: collision with root package name */
    public HttpRequest f49303b;

    /* renamed from: c, reason: collision with root package name */
    public HttpResponse f49304c;

    @NotNull
    private volatile /* synthetic */ int received;

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49301e = new AttributeKey("CustomResponse");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49300d = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public HttpClientCall(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f49302a = client;
        this.received = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        if (r9 == r1) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:13:0x002e, B:49:0x00ba, B:54:0x00cc, B:57:0x00df, B:58:0x00f2), top: B:66:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.util.reflect.TypeInfo r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.HttpClientCall.a(io.ktor.util.reflect.TypeInfo, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public boolean c() {
        return false;
    }

    public final HttpRequest d() {
        HttpRequest httpRequest = this.f49303b;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.h("request");
        throw null;
    }

    public final HttpResponse e() {
        HttpResponse httpResponse = this.f49304c;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.h("response");
        throw null;
    }

    public Object f() {
        return e().a();
    }

    public final Attributes j1() {
        return d().j1();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return e().r();
    }

    public final String toString() {
        return "HttpClientCall[" + d().N() + ", " + e().e() + ']';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClientCall(HttpClient client, HttpRequestData requestData, HttpResponseData responseData) {
        this(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(this, requestData);
        Intrinsics.checkNotNullParameter(defaultHttpRequest, "<set-?>");
        this.f49303b = defaultHttpRequest;
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(this, responseData);
        Intrinsics.checkNotNullParameter(defaultHttpResponse, "<set-?>");
        this.f49304c = defaultHttpResponse;
        Object obj = responseData.f50027e;
        if (obj instanceof ByteReadChannel) {
            return;
        }
        j1().b(f49301e, obj);
    }
}
