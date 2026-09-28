package in.juspay.airborne.network;

import androidx.annotation.NonNull;
import com.amazon.apay.hardened.external.model.APayConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class JuspayHttpsResponse {
    public final Map<String, List<String>> headers;
    public final int responseCode;
    public final byte[] responsePayload;

    public JuspayHttpsResponse(int i2, @NonNull byte[] bArr, Map<String, List<String>> map) {
        this.responseCode = i2;
        this.responsePayload = bArr;
        this.headers = map;
    }

    private static byte[] decodeGZip(InputStream inputStream) throws IOException {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = gZIPInputStream.read(bArr);
                    if (i2 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(APayConstants.RESPONSE_CODE, this.responseCode);
            jSONObject.put("responsePayload", this.responsePayload);
            jSONObject.put("headers", this.headers);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public JuspayHttpsResponse(HttpsURLConnection httpsURLConnection) throws IOException {
        InputStream errorStream;
        int responseCode = httpsURLConnection.getResponseCode();
        this.responseCode = responseCode;
        this.headers = httpsURLConnection.getHeaderFields();
        if ((responseCode >= 200 && responseCode < 300) || responseCode == 302) {
            errorStream = httpsURLConnection.getInputStream();
        } else {
            errorStream = httpsURLConnection.getErrorStream();
        }
        String contentEncoding = httpsURLConnection.getContentEncoding();
        if (contentEncoding != null && contentEncoding.equals("gzip")) {
            this.responsePayload = decodeGZip(errorStream);
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = bufferedInputStream.read(bArr, 0, 1024);
                    if (i2 != -1) {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    } else {
                        this.responsePayload = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public JuspayHttpsResponse(Response response) throws IOException {
        this.responseCode = response.f56353d;
        this.headers = response.f56355f.k();
        ResponseBody responseBody = response.f56356g;
        if (responseBody != null) {
            Intrinsics.checkNotNullParameter("content-encoding", CLConstants.FIELD_PAY_INFO_NAME);
            String strB = response.b("content-encoding", null);
            if (strB != null && strB.equalsIgnoreCase("gzip")) {
                this.responsePayload = decodeGZip(responseBody.a());
            } else {
                this.responsePayload = responseBody.b();
            }
        } else {
            this.responsePayload = null;
        }
        if (responseBody != null) {
            responseBody.close();
        }
    }
}
