package com.amazon.apay.instrumentation.clients;

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
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class HttpsClient {

    /* renamed from: b, reason: collision with root package name */
    public static final String f15018b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f15019c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f15020d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f15021e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f15022f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f15023g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f15024h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f15025i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f15026j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f15027k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f15028l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f15029m;
    public static final String n;

    /* renamed from: a, reason: collision with root package name */
    public HttpsURLConnection f15030a;

    static {
        Reflection.a(HttpsClient.class).i();
        f15018b = "Keep-Alive";
        f15019c = UtilsKt.CACHE_CONTROL;
        f15020d = "no-cache";
        f15021e = "multipart/form-data";
        f15022f = "boundary";
        f15023g = "charset";
        f15024h = "UTF-8";
        f15025i = "Content-length";
        f15026j = 10000;
        f15027k = "Content-Disposition";
        f15028l = "form-data";
        f15029m = CLConstants.FIELD_PAY_INFO_NAME;
        n = "filename";
    }

    public static HttpsURLConnection b(String str, byte[] bArr) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        if (uRLConnectionOpenConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Connection", f15018b);
        httpsURLConnection.setRequestProperty(f15019c, f15020d);
        httpsURLConnection.setRequestProperty(f15023g, f15024h);
        httpsURLConnection.setConnectTimeout(f15026j);
        httpsURLConnection.setRequestProperty(f15025i, String.valueOf(bArr.length));
        return httpsURLConnection;
    }

    public static byte[] c(String str, String str2) {
        StringBuilder sb = new StringBuilder("--*****\r\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f15027k);
        sb2.append(": ");
        sb2.append(f15028l);
        sb2.append("; ");
        sb2.append(f15029m);
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
            this.f15030a = httpsURLConnectionB;
            httpsURLConnectionB.setRequestProperty(UtilsKt.CONTENT_TYPE, f15021e + ';' + f15022f + "=*****");
            HttpsURLConnection httpsURLConnection = this.f15030a;
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection != null ? httpsURLConnection.getOutputStream() : null);
            try {
                dataOutputStream.write(bArrC);
                dataOutputStream.close();
                HttpsURLConnection httpsURLConnection2 = this.f15030a;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.getResponseCode();
                }
                HttpsURLConnection httpsURLConnection3 = this.f15030a;
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
