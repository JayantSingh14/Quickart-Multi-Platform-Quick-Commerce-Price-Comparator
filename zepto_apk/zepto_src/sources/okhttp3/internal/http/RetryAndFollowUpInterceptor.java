package okhttp3.internal.http;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

@Metadata
/* loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f56590a;

    @Metadata
    public static final class Companion {
    }

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f56590a = client;
    }

    public static int d(Response response, int i2) throws NumberFormatException {
        String strB = response.b("Retry-After", null);
        if (strB == null) {
            return i2;
        }
        if (!new Regex("\\d+").c(strB)) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Integer numValueOf = Integer.valueOf(strB);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        if (r9 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        r0 = r0.e();
        r3 = r9.e();
        r3.f56369g = null;
        r3 = r3.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (r3.f56356g != null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
    
        r0.f56372j = r3;
        r0 = r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        throw new java.lang.IllegalArgumentException("priorResponse.body != null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        r0 = r4.f56528l;
        r5 = b(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c2, code lost:
    
        if (r5 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
    
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c8, code lost:
    
        if (r0.f56493e == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
    
        if (r4.f56527k != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
    
        r4.f56527k = true;
        r4.f56522f.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
    
        throw new java.lang.IllegalStateException("Check failed.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        r4.e(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e3, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
    
        r0 = r5.f56334d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e7, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ed, code lost:
    
        if (r0.isOneShot() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ef, code lost:
    
        r4.e(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f2, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f3, code lost:
    
        r0 = r9.f56356g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f5, code lost:
    
        if (r0 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
    
        okhttp3.internal.Util.c(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
    
        if (r10 > 20) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011b, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r10);
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response a(okhttp3.internal.http.RealInterceptorChain r30) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.a(okhttp3.internal.http.RealInterceptorChain):okhttp3.Response");
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Request b(okhttp3.Response r12, okhttp3.internal.connection.Exchange r13) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.b(okhttp3.Response, okhttp3.internal.connection.Exchange):okhttp3.Request");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.io.IOException r4, okhttp3.internal.connection.RealCall r5, okhttp3.Request r6, boolean r7) {
        /*
            r3 = this;
            okhttp3.OkHttpClient r0 = r3.f56590a
            boolean r0 = r0.f56302f
            r1 = 0
            if (r0 != 0) goto L9
            goto La5
        L9:
            if (r7 == 0) goto L1a
            okhttp3.RequestBody r6 = r6.f56334d
            if (r6 == 0) goto L15
            boolean r6 = r6.isOneShot()
            if (r6 != 0) goto La5
        L15:
            boolean r6 = r4 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L1a
            return r1
        L1a:
            boolean r6 = r4 instanceof java.net.ProtocolException
            if (r6 == 0) goto L1f
            return r1
        L1f:
            boolean r6 = r4 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L2a
            boolean r4 = r4 instanceof java.net.SocketTimeoutException
            if (r4 == 0) goto La5
            if (r7 != 0) goto La5
            goto L3d
        L2a:
            boolean r6 = r4 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L38
            java.lang.Throwable r6 = r4.getCause()
            boolean r6 = r6 instanceof java.security.cert.CertificateException
            if (r6 == 0) goto L38
            goto La5
        L38:
            boolean r4 = r4 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r4 == 0) goto L3d
            return r1
        L3d:
            okhttp3.internal.connection.ExchangeFinder r4 = r5.f56525i
            kotlin.jvm.internal.Intrinsics.c(r4)
            int r5 = r4.f56513g
            r6 = 1
            if (r5 != 0) goto L51
            int r7 = r4.f56514h
            if (r7 != 0) goto L51
            int r7 = r4.f56515i
            if (r7 != 0) goto L51
            r4 = r1
            goto La3
        L51:
            okhttp3.Route r7 = r4.f56516j
            if (r7 == 0) goto L56
            goto L9e
        L56:
            r7 = 0
            if (r5 > r6) goto L89
            int r5 = r4.f56514h
            if (r5 > r6) goto L89
            int r5 = r4.f56515i
            if (r5 <= 0) goto L62
            goto L89
        L62:
            okhttp3.internal.connection.RealCall r5 = r4.f56509c
            okhttp3.internal.connection.RealConnection r5 = r5.f56526j
            if (r5 != 0) goto L69
            goto L89
        L69:
            monitor-enter(r5)
            int r0 = r5.f56545l     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L70
            monitor-exit(r5)
            goto L89
        L70:
            okhttp3.Route r0 = r5.f56535b     // Catch: java.lang.Throwable -> L86
            okhttp3.Address r0 = r0.f56384a     // Catch: java.lang.Throwable -> L86
            okhttp3.HttpUrl r0 = r0.f56140i     // Catch: java.lang.Throwable -> L86
            okhttp3.Address r2 = r4.f56508b     // Catch: java.lang.Throwable -> L86
            okhttp3.HttpUrl r2 = r2.f56140i     // Catch: java.lang.Throwable -> L86
            boolean r0 = okhttp3.internal.Util.a(r0, r2)     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L82
            monitor-exit(r5)
            goto L89
        L82:
            okhttp3.Route r7 = r5.f56535b     // Catch: java.lang.Throwable -> L86
            monitor-exit(r5)
            goto L89
        L86:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L89:
            if (r7 == 0) goto L8f
            r4.f56516j = r7
        L8d:
            r4 = r6
            goto La3
        L8f:
            okhttp3.internal.connection.RouteSelector$Selection r5 = r4.f56511e
            if (r5 == 0) goto L9a
            boolean r5 = r5.a()
            if (r5 != r6) goto L9a
            goto L9e
        L9a:
            okhttp3.internal.connection.RouteSelector r4 = r4.f56512f
            if (r4 != 0) goto L9f
        L9e:
            goto L8d
        L9f:
            boolean r4 = r4.a()
        La3:
            if (r4 != 0) goto La6
        La5:
            return r1
        La6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.c(java.io.IOException, okhttp3.internal.connection.RealCall, okhttp3.Request, boolean):boolean");
    }
}
