package in.juspay.airborne.network;

import android.content.Context;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import coil3.network.internal.UtilsKt;
import in.juspay.airborne.TrackerCallback;
import in.juspay.airborne.network.NetworkSummarizer;
import in.juspay.airborne.security.HyperSSLSocketFactory;
import in.juspay.airborne.services.Workspace;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class NetUtils {
    public static final OkHttpClient DEFAULT_HTTP_CLIENT;
    private static final String HTTP_CACHE_NAME = "hyper-http-cache";
    private static final MediaType MEDIA_TYPE_TEXT;
    private static final String TAG = "NetUtils";
    private int connectionTimeout;
    private final NetworkSummarizer networkSummarizer;
    private int readTimeout;
    private String sessionId;
    private SSLSocketFactory sslSocketFactory;
    private boolean trackMetrics;

    static {
        Pattern pattern = MediaType.f56278d;
        MEDIA_TYPE_TEXT = MediaType.Companion.b(UtilsKt.MIME_TYPE_TEXT_PLAIN);
        DEFAULT_HTTP_CLIENT = buildHttpClient();
    }

    public NetUtils(@IntRange int i2, @IntRange int i3) throws NoSuchAlgorithmException, KeyManagementException {
        this(i2, i3, false);
    }

    private static OkHttpClient buildHttpClient() {
        Cache cache = new Cache(Workspace.getCtx().getDir(HTTP_CACHE_NAME, 0));
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.f56320k = cache;
        builder.f56318i = false;
        return new OkHttpClient(builder);
    }

    public static void cancelAPICall(String str, @NonNull TrackerCallback trackerCallback) {
        try {
            for (Call call : DEFAULT_HTTP_CLIENT.f56297a.f()) {
                if (str.equals(call.r().c(Object.class))) {
                    call.cancel();
                    trackerCallback.track("action", "network", "info", "cancel_api", "Cancelling api call from running calls", new JSONObject().put("tag", str));
                    return;
                }
            }
            for (Call call2 : DEFAULT_HTTP_CLIENT.f56297a.e()) {
                if (str.equals(call2.r().c(Object.class))) {
                    call2.cancel();
                    trackerCallback.track("action", "network", "info", "cancel_api", "Cancelling api call from queued calls", new JSONObject().put("tag", str));
                    return;
                }
            }
            try {
                trackerCallback.track("action", "network", "info", "cancel_api", "Not able to Cancel api call from queued/running calls", new JSONObject().put("tag", str));
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            trackerCallback.trackAndLogException(TAG, "action", "system", "cancel_api", b.C("Exception while Cancelling API with tag ", str), e2);
        }
    }

    private RequestBody createRequestBody(@NonNull final byte[] bArr, @Nullable final String str) {
        return new RequestBody() { // from class: in.juspay.airborne.network.NetUtils.1
            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                String str2 = str;
                if (str2 != null) {
                    Pattern pattern = MediaType.f56278d;
                    if (MediaType.Companion.b(str2) != null) {
                        return MediaType.Companion.b(str);
                    }
                }
                return NetUtils.MEDIA_TYPE_TEXT;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(@NonNull BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr);
            }
        };
    }

    private Response doMethod(@NonNull String str, @NonNull String str2, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable byte[] bArr, @Nullable String str3, @Nullable JSONObject jSONObject, @Nullable String str4) throws IOException {
        X509TrustManager trustManager;
        String strGenerateQueryString = generateQueryString(map);
        StringBuilder sb = new StringBuilder(str2);
        if (!strGenerateQueryString.isEmpty()) {
            str2 = b.r(sb, "?", strGenerateQueryString);
        }
        Request.Builder builder = new Request.Builder();
        builder.i(str2);
        if (str4 != null) {
            builder.h(Object.class, str4);
        }
        if (map2 != null) {
            setHeaders(builder, map2);
        }
        setHeaders(builder, getDefaultSDKHeaders());
        if (bArr != null) {
            String contentType = getContentType(map2);
            if (contentType != null) {
                str3 = contentType;
            }
            builder.f(str, createRequestBody(bArr, str3));
        } else {
            builder.f(str, null);
        }
        OkHttpClient.Builder builderC = DEFAULT_HTTP_CLIENT.c();
        if (jSONObject != null) {
            setOptions(builderC, jSONObject);
        }
        SSLSocketFactory sslSocketFactory = this.sslSocketFactory;
        if (sslSocketFactory != null && (trustManager = HyperSSLSocketFactory.DEFAULT_TRUST_MANAGER) != null) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (!Intrinsics.b(sslSocketFactory, builderC.q) || !Intrinsics.b(trustManager, builderC.r)) {
                builderC.C = null;
            }
            builderC.q = sslSocketFactory;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Platform platform = Platform.f56791a;
            builderC.w = Platform.f56791a.b(trustManager);
            builderC.r = trustManager;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Response responseD = new OkHttpClient(builderC).a(builder.b()).d();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        String str5 = "CACHE-MISS";
        if (str.equalsIgnoreCase(UtilsKt.HTTP_METHOD_GET)) {
            Response response = responseD.f56357h;
            int i2 = response != null ? response.f56353d : -1;
            Response response2 = responseD.f56358i;
            if (response2 != null && i2 == 304) {
                str5 = "CONDITIONAL-HIT";
            } else if (response2 != null && i2 == -1) {
                str5 = "CACHE-HIT";
            }
            Intrinsics.checkNotNullParameter("x-cache", CLConstants.FIELD_PAY_INFO_NAME);
            String strB = responseD.b("x-cache", null);
            StringBuilder sbY = b.y("GET ", str2, StringUtils.SPACE);
            sbY.append(responseD.f56353d);
            sbY.append(" -> ");
            sbY.append(jCurrentTimeMillis2);
            b.B(sbY, " ms [", str5, "] [x-cache: ", strB);
            sbY.append("]");
            Log.d(TAG, sbY.toString());
        } else {
            Log.d(TAG, str + StringUtils.SPACE + str2 + StringUtils.SPACE + responseD.f56353d + " -> " + jCurrentTimeMillis2 + " ms");
        }
        if (!str5.equalsIgnoreCase("CACHE-HIT") && this.trackMetrics) {
            this.networkSummarizer.addMetric(responseD, jCurrentTimeMillis2);
        }
        return responseD;
    }

    @Nullable
    private String getContentType(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String str = map.get("content-type");
        return str == null ? map.get(UtilsKt.CONTENT_TYPE) : str;
    }

    private static void setHeaders(@NonNull Request.Builder builder, @Nullable Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null && (!key.equalsIgnoreCase("accept-encoding") || !value.equalsIgnoreCase("gzip"))) {
                    builder.d(key, value);
                }
            }
        }
    }

    private void setOptions(OkHttpClient.Builder builder, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("connectionTimeout", this.connectionTimeout);
        int iOptInt2 = jSONObject.optInt("readTimeout", this.readTimeout);
        int iOptInt3 = jSONObject.optInt("writeTimeout", -1);
        boolean zOptBoolean = jSONObject.optBoolean("retryOnConnectionFailure", true);
        if (iOptInt != -1) {
            builder.b(iOptInt, TimeUnit.MILLISECONDS);
        }
        if (iOptInt2 != -1) {
            builder.c(iOptInt2, TimeUnit.MILLISECONDS);
        }
        if (iOptInt3 != -1) {
            builder.d(iOptInt3, TimeUnit.MILLISECONDS);
        }
        builder.f56315f = zOptBoolean;
    }

    public Response deleteUrl(URL url, Map<String, String> map, JSONObject jSONObject) throws IOException {
        return doDelete(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null, jSONObject, null);
    }

    public Response doDelete(URL url, byte[] bArr, String str, @Nullable Map<String, String> map, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doMethod("DELETE", url.toString(), null, map, bArr, str, jSONObject, str2);
    }

    public Response doGet(@NonNull String str) throws IOException {
        return doGet(str, null, null, null, null);
    }

    public Response doHead(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doMethod("HEAD", str, map2, map, null, null, jSONObject, str2);
    }

    public Response doPost(URL url, byte[] bArr, String str, @Nullable Map<String, String> map, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doMethod("POST", url.toString(), null, map, bArr, str, jSONObject, str2);
    }

    public Response doPut(@NonNull Context context, URL url, byte[] bArr, @Nullable Map<String, String> map, NetUtils netUtils, JSONObject jSONObject, @Nullable String str) throws Exception {
        return doMethod("PUT", url.toString(), null, map, bArr, null, jSONObject, str);
    }

    public byte[] fetchIfModified(String str, Map<String, String> map) throws IOException {
        Response responseDoGet = doGet(str, map, null, new JSONObject(), null);
        if (responseDoGet.f56353d == 200) {
            return new JuspayHttpsResponse(responseDoGet).responsePayload;
        }
        return null;
    }

    @Keep
    public String generateQueryString(@Nullable Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public Map<String, String> getDefaultSDKHeaders() {
        return new HashMap();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Response postForm(URL url, Map<String, String> map, JSONObject jSONObject) throws IOException {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null, jSONObject, null);
    }

    public <T> Response postJson(URL url, T t, JSONObject jSONObject) throws IOException {
        return doPost(url, t.toString().getBytes(), "application/json", null, jSONObject, null);
    }

    public void postMetrics(String str, @Nullable String str2, String str3, boolean z) throws IOException {
        try {
            NetworkSummarizer networkSummarizer = this.networkSummarizer;
            if (str2 == null) {
                str2 = this.sessionId;
            }
            NetworkSummarizer.Summary summaryPublishSummary = networkSummarizer.publishSummary(str2, str3, z);
            HashMap map = new HashMap();
            map.put("summary", summaryPublishSummary.toJSON().toString());
            doMethod(UtilsKt.HTTP_METHOD_GET, str, map, null, null, null, null, null).close();
        } catch (Exception unused) {
        }
    }

    public Response postUrl(URL url, Map<String, String> map, JSONObject jSONObject) throws IOException {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null, jSONObject, null);
    }

    public void setConnectionTimeout(@IntRange int i2) {
        this.connectionTimeout = i2;
    }

    public void setReadTimeout(@IntRange int i2) {
        this.readTimeout = i2;
    }

    public void setSessionId(@NonNull String str) {
        this.sessionId = str;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setTrackMetrics(boolean z) {
        this.trackMetrics = z;
    }

    public NetUtils(@IntRange int i2, @IntRange int i3, boolean z) throws NoSuchAlgorithmException, KeyManagementException {
        this.trackMetrics = false;
        this.networkSummarizer = new NetworkSummarizer();
        this.connectionTimeout = i2;
        this.readTimeout = i3;
        OkHttpClient.Builder builderC = DEFAULT_HTTP_CLIENT.c();
        long j2 = i3;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builderC.c(j2, timeUnit);
        builderC.b(i2, timeUnit);
        new OkHttpClient(builderC);
        this.sslSocketFactory = new JuspaySSLSocketFactory();
    }

    public Response deleteUrl(URL url, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, @Nullable String str) throws IOException {
        return doDelete(url, generateQueryString(map2).getBytes(), "application/json", map, jSONObject, str);
    }

    public Response doGet(@NonNull String str, @Nullable Map<String, String> map) throws IOException {
        return doMethod(UtilsKt.HTTP_METHOD_GET, str, null, map, null, null, null, null);
    }

    public Response postUrl(URL url, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, @Nullable String str) throws IOException {
        return doPost(url, generateQueryString(map2).getBytes(), "application/json", map, jSONObject, str);
    }

    public Response deleteUrl(URL url, Map<String, String> map, String str, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doDelete(url, str.getBytes(), "application/x-www-form-urlencoded", map, jSONObject, str2);
    }

    public Response doGet(@NonNull String str, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doMethod(UtilsKt.HTTP_METHOD_GET, str, map2, map, null, null, jSONObject, str2);
    }

    public Response postUrl(URL url, Map<String, String> map, String str, JSONObject jSONObject, @Nullable String str2) throws IOException {
        return doPost(url, str.getBytes(), "application/x-www-form-urlencoded", map, jSONObject, str2);
    }

    public Response deleteUrl(URL url, JSONObject jSONObject) throws IOException {
        return doDelete(url, null, "application/x-www-form-urlencoded", null, jSONObject, null);
    }

    public Response postUrl(URL url, JSONObject jSONObject) throws IOException {
        return doPost(url, null, "application/x-www-form-urlencoded", null, jSONObject, null);
    }
}
