package com.amazon.android.apay.commonlibrary.instrumentationlib.clients;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class HttpsClient {

    /* renamed from: b, reason: collision with root package name */
    public static final String f14882b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f14883c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f14884d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f14885e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f14886f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f14887g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f14888h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f14889i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f14890j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f14891k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f14892l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f14893m;
    public static final String n;

    /* renamed from: a, reason: collision with root package name */
    public HttpsURLConnection f14894a;

    static {
        Reflection.a(HttpsClient.class).i();
        f14882b = "Keep-Alive";
        f14883c = UtilsKt.CACHE_CONTROL;
        f14884d = "no-cache";
        f14885e = "multipart/form-data";
        f14886f = "boundary";
        f14887g = "charset";
        f14888h = "UTF-8";
        f14889i = "Content-length";
        f14890j = 10000;
        f14891k = "Content-Disposition";
        f14892l = "form-data";
        f14893m = CLConstants.FIELD_PAY_INFO_NAME;
        n = "filename";
    }

    public static HttpsURLConnection b(String str, byte[] bArr) throws NoSuchAlgorithmException, IOException, KeyManagementException, NoSuchProviderException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        Intrinsics.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Connection", f14882b);
        httpsURLConnection.setRequestProperty(f14883c, f14884d);
        httpsURLConnection.setRequestProperty(f14887g, f14888h);
        httpsURLConnection.setConnectTimeout(f14890j);
        httpsURLConnection.setRequestProperty(f14889i, String.valueOf(bArr.length));
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS", "GmsCore_OpenSSL");
            sSLContext.init(null, null, null);
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            return httpsURLConnection;
        } catch (Exception unused) {
            httpsURLConnection.setSSLSocketFactory(SSLContext.getDefault().getSocketFactory());
            return httpsURLConnection;
        }
    }

    public static byte[] c(String str, String str2) {
        StringBuilder sb = new StringBuilder("--*****\r\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f14891k);
        sb2.append(": ");
        sb2.append(f14892l);
        sb2.append("; ");
        sb2.append(f14893m);
        sb2.append("=\"file\";");
        String strN = a.n(sb, a.n(sb2, n, "=\"", str, "\"\r\n"), "\r\n", str2, "\r\n--*****--\r\n");
        Intrinsics.checkNotNullExpressionValue(strN, "stringBuilder.toString()");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = strN.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final Integer a(String endpoint, String attachmentFileName, String data) throws Exception {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(attachmentFileName, "attachmentFileName");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            byte[] bArrC = c(attachmentFileName, data);
            HttpsURLConnection httpsURLConnectionB = b(endpoint, bArrC);
            this.f14894a = httpsURLConnectionB;
            httpsURLConnectionB.setRequestProperty(UtilsKt.CONTENT_TYPE, f14885e + ';' + f14886f + "=*****");
            HttpsURLConnection httpsURLConnection = this.f14894a;
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection != null ? httpsURLConnection.getOutputStream() : null);
            try {
                dataOutputStream.write(bArrC);
                dataOutputStream.close();
                HttpsURLConnection httpsURLConnection2 = this.f14894a;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.getResponseCode();
                }
                HttpsURLConnection httpsURLConnection3 = this.f14894a;
                if (httpsURLConnection3 != null) {
                    return Integer.valueOf(httpsURLConnection3.getResponseCode());
                }
                return null;
            } finally {
            }
        } catch (MalformedURLException e2) {
            throw new Exception(b.D("Unable to form endpoint: ", endpoint, " while sending events form sdk to kds"), e2);
        } catch (IOException e3) {
            throw new Exception(e.p("Unable to upload metric events file from SDK to KDS for endpoint: ", endpoint, " and fileName: ", attachmentFileName), e3);
        }
    }
}
