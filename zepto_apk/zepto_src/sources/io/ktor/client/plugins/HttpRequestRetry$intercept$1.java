package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", l = {298, 314}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Function3 f49606a;

    /* renamed from: b, reason: collision with root package name */
    public Function3 f49607b;

    /* renamed from: c, reason: collision with root package name */
    public Function2 f49608c;

    /* renamed from: d, reason: collision with root package name */
    public Function2 f49609d;

    /* renamed from: e, reason: collision with root package name */
    public Object f49610e;

    /* renamed from: f, reason: collision with root package name */
    public int f49611f;

    /* renamed from: g, reason: collision with root package name */
    public int f49612g;

    /* renamed from: h, reason: collision with root package name */
    public int f49613h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Sender f49614i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ HttpRequestBuilder f49615j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ HttpRequestRetry f49616k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ HttpClient f49617l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.f49616k = httpRequestRetry;
        this.f49617l = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.f49616k, this.f49617l, (Continuation) obj3);
        httpRequestRetry$intercept$1.f49614i = (Sender) obj;
        httpRequestRetry$intercept$1.f49615j = (HttpRequestBuilder) obj2;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:40|41|61|42|(6:44|45|46|55|(9:58|7|59|32|(0)|35|(0)|38|(0))|57)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0139, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0154, code lost:
    
        r8 = r8 + 1;
        r2 = new io.ktor.client.plugins.HttpRequestRetry.RetryEventData(r9, r8, null, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5 A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #1 {all -> 0x005b, blocks: (B:34:0x00d5, B:35:0x00e2, B:38:0x00fe, B:40:0x0107, B:11:0x0054), top: B:63:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #1 {all -> 0x005b, blocks: (B:34:0x00d5, B:35:0x00e2, B:38:0x00fe, B:40:0x0107, B:11:0x0054), top: B:63:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0198 -> B:7:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
