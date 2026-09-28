package io.sentry.transport;

import coil3.network.internal.UtilsKt;
import io.sentry.ILogger;
import io.sentry.RequestDetails;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.transport.TransportResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
final class HttpConnection {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f53092e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Proxy f53093a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestDetails f53094b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryOptions f53095c;

    /* renamed from: d, reason: collision with root package name */
    public final RateLimiter f53096d;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HttpConnection(io.sentry.SentryOptions r5, io.sentry.RequestDetails r6, io.sentry.transport.RateLimiter r7) {
        /*
            r4 = this;
            r4.<init>()
            r4.f53094b = r6
            r4.f53095c = r5
            r4.f53096d = r7
            io.sentry.SentryOptions$Proxy r6 = r5.getProxy()
            if (r6 == 0) goto L52
            java.lang.String r7 = r6.c()
            java.lang.String r0 = r6.a()
            if (r7 == 0) goto L52
            if (r0 == 0) goto L52
            java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP     // Catch: java.lang.NumberFormatException -> L2c
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch: java.lang.NumberFormatException -> L2c
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L2c
            r2.<init>(r0, r7)     // Catch: java.lang.NumberFormatException -> L2c
            java.net.Proxy r7 = new java.net.Proxy     // Catch: java.lang.NumberFormatException -> L2c
            r7.<init>(r1, r2)     // Catch: java.lang.NumberFormatException -> L2c
            goto L53
        L2c:
            r7 = move-exception
            io.sentry.SentryOptions r0 = r4.f53095c
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to parse Sentry Proxy port: "
            r2.<init>(r3)
            java.lang.String r6 = r6.c()
            r2.append(r6)
            java.lang.String r6 = ". Proxy is ignored"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.a(r1, r7, r6, r2)
        L52:
            r7 = 0
        L53:
            r4.f53093a = r7
            if (r7 == 0) goto L79
            io.sentry.SentryOptions$Proxy r6 = r5.getProxy()
            if (r6 == 0) goto L79
            io.sentry.SentryOptions$Proxy r6 = r5.getProxy()
            java.lang.String r6 = r6.d()
            io.sentry.SentryOptions$Proxy r5 = r5.getProxy()
            java.lang.String r5 = r5.b()
            if (r6 == 0) goto L79
            if (r5 == 0) goto L79
            io.sentry.transport.ProxyAuthenticator r7 = new io.sentry.transport.ProxyAuthenticator
            r7.<init>(r6, r5)
            java.net.Authenticator.setDefault(r7)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.HttpConnection.<init>(io.sentry.SentryOptions, io.sentry.RequestDetails, io.sentry.transport.RateLimiter):void");
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static String b(HttpURLConnection httpURLConnection) throws IOException {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f53092e));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!z) {
                            sb.append(StringUtils.LF);
                        }
                        sb.append(line);
                        z = false;
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return string;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }

    public final TransportResult c(HttpURLConnection httpURLConnection) {
        SentryOptions sentryOptions = this.f53095c;
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                e(httpURLConnection, responseCode);
                if (responseCode == 200) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "Envelope sent successfully.", new Object[0]);
                    return TransportResult.SuccessTransportResult.f53117a;
                }
                ILogger logger = sentryOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.c(sentryLevel, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (sentryOptions.isDebug()) {
                    sentryOptions.getLogger().c(sentryLevel, "%s", b(httpURLConnection));
                }
                return new TransportResult.ErrorTransportResult(responseCode);
            } catch (IOException e2) {
                sentryOptions.getLogger().a(SentryLevel.ERROR, e2, "Error reading and logging the response stream", new Object[0]);
                a(httpURLConnection);
                return new TransportResult.ErrorTransportResult(-1);
            }
        } finally {
            a(httpURLConnection);
        }
    }

    public final TransportResult d(SentryEnvelope sentryEnvelope) throws IOException {
        RequestDetails requestDetails = this.f53094b;
        URL url = requestDetails.f51756a;
        Proxy proxy = this.f53093a;
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
        for (Map.Entry entry : requestDetails.f51757b.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Connection", "close");
        SentryOptions sentryOptions = this.f53095c;
        httpURLConnection.setConnectTimeout(sentryOptions.getConnectionTimeoutMillis());
        httpURLConnection.setReadTimeout(sentryOptions.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = sentryOptions.getSslSocketFactory();
        if ((httpURLConnection instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sslSocketFactory);
        }
        httpURLConnection.connect();
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    sentryOptions.getSerializer().c(sentryEnvelope, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return c(httpURLConnection);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                sentryOptions.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while submitting the envelope to the Sentry server.", new Object[0]);
                return c(httpURLConnection);
            } finally {
                c(httpURLConnection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.net.HttpURLConnection r26, int r27) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.HttpConnection.e(java.net.HttpURLConnection, int):void");
    }
}
