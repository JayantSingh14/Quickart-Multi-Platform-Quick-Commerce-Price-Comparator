package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import coil3.network.internal.UtilsKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public class FirebaseInstallationServiceClient {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f44638d = Pattern.compile("[0-9]+s");

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f44639e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f44640a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f44641b;

    /* renamed from: c, reason: collision with root package name */
    public final RequestLimiter f44642c = new RequestLimiter();

    public FirebaseInstallationServiceClient(Context context, Provider provider) {
        this.f44640a = context;
        this.f44641b = provider;
    }

    public static URL c(String str) throws FirebaseInstallationsException {
        try {
            return new URL("https://firebaseinstallations.googleapis.com/v1/".concat(str));
        } catch (MalformedURLException e2) {
            throw new FirebaseInstallationsException(e2.getMessage());
        }
    }

    public static void d(HttpURLConnection httpURLConnection, String str, String str2, String str3) throws IOException {
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f44639e));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        Log.w("Firebase-Installations", str4);
        Log.w("Firebase-Installations", b.m("Firebase options used while communicating with Firebase server APIs: ", str2, ", ", str3, TextUtils.isEmpty(str) ? "" : b.C(", ", str)));
    }

    public static long f(String str) {
        Preconditions.checkArgument(f44638d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static InstallationResponse g(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f44639e));
        TokenResult.Builder builderA = TokenResult.a();
        AutoValue_InstallationResponse.Builder builder = new AutoValue_InstallationResponse.Builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                builder.f44628a = jsonReader.nextString();
            } else if (strNextName.equals("fid")) {
                builder.f44629b = jsonReader.nextString();
            } else if (strNextName.equals("refreshToken")) {
                builder.f44630c = jsonReader.nextString();
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN)) {
                        ((AutoValue_TokenResult.Builder) builderA).f44635a = jsonReader.nextString();
                    } else if (strNextName2.equals("expiresIn")) {
                        ((AutoValue_TokenResult.Builder) builderA).f44636b = Long.valueOf(f(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder.f44631d = builderA.a();
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new AutoValue_InstallationResponse(builder.f44628a, builder.f44629b, builder.f44630c, builder.f44631d, InstallationResponse.ResponseCode.f44643a);
    }

    public static TokenResult h(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f44639e));
        TokenResult.Builder builderA = TokenResult.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN)) {
                ((AutoValue_TokenResult.Builder) builderA).f44635a = jsonReader.nextString();
            } else if (strNextName.equals("expiresIn")) {
                ((AutoValue_TokenResult.Builder) builderA).f44636b = Long.valueOf(f(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        AutoValue_TokenResult.Builder builder = (AutoValue_TokenResult.Builder) builderA;
        builder.f44637c = TokenResult.ResponseCode.f44651a;
        return builder.a();
    }

    public static void i(HttpURLConnection httpURLConnection, String str, String str2) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put(CLConstants.SALT_FIELD_APP_ID, str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put(PaymentConstants.SDK_VERSION, "a:18.0.0");
            k(httpURLConnection, jSONObject.toString().getBytes("UTF-8"));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void j(HttpURLConnection httpURLConnection) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PaymentConstants.SDK_VERSION, "a:18.0.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            k(httpURLConnection, jSONObject2.toString().getBytes("UTF-8"));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void k(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final InstallationResponse a(String str, String str2, String str3, String str4, String str5) {
        int responseCode;
        RequestLimiter requestLimiter = this.f44642c;
        if (!requestLimiter.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlC = c("projects/" + str3 + "/installations");
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 > 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
            }
            TrafficStats.setThreadStatsTag(Type.DLV);
            HttpURLConnection httpURLConnectionE = e(urlC, str);
            try {
                try {
                    httpURLConnectionE.setRequestMethod("POST");
                    httpURLConnectionE.setDoOutput(true);
                    if (str5 != null) {
                        httpURLConnectionE.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    try {
                        i(httpURLConnectionE, str2, str4);
                        responseCode = httpURLConnectionE.getResponseCode();
                        requestLimiter.b(responseCode);
                        if (responseCode < 200 || responseCode >= 300) {
                            z = false;
                        }
                    } catch (IOException | AssertionError unused) {
                    }
                } catch (IOException | AssertionError unused2) {
                }
                if (z) {
                    return g(httpURLConnectionE);
                }
                d(httpURLConnectionE, str4, str, str3);
                if (responseCode == 429) {
                    throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    break;
                }
                i2++;
            } finally {
                httpURLConnectionE.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
        }
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
        AutoValue_InstallationResponse.Builder builder = new AutoValue_InstallationResponse.Builder();
        return new AutoValue_InstallationResponse(builder.f44628a, builder.f44629b, builder.f44630c, builder.f44631d, InstallationResponse.ResponseCode.f44644b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
    
        r4 = (com.google.firebase.installations.remote.AutoValue_TokenResult.Builder) com.google.firebase.installations.remote.TokenResult.a();
        r4.f44637c = com.google.firebase.installations.remote.TokenResult.ResponseCode.f44653c;
        r10 = r4.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.firebase.installations.remote.TokenResult b(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r9 = this;
            com.google.firebase.installations.remote.RequestLimiter r0 = r9.f44642c
            boolean r1 = r0.a()
            java.lang.String r2 = "Firebase Installations Service is unavailable. Please try again later."
            if (r1 == 0) goto Ld7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "projects/"
            r1.<init>(r3)
            r1.append(r12)
            java.lang.String r3 = "/installations/"
            r1.append(r3)
            r1.append(r11)
            java.lang.String r11 = "/authTokens:generate"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.net.URL r11 = c(r11)
            r1 = 0
            r3 = r1
        L2b:
            r4 = 1
            if (r3 > r4) goto Ld1
            r5 = 32771(0x8003, float:4.5922E-41)
            android.net.TrafficStats.setThreadStatsTag(r5)
            java.net.HttpURLConnection r5 = r9.e(r11, r10)
            java.lang.String r6 = "POST"
            r5.setRequestMethod(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            java.lang.String r6 = "Authorization"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r7.<init>()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            java.lang.String r8 = "FIS_v2 "
            r7.append(r8)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r7.append(r13)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r5.addRequestProperty(r6, r7)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r5.setDoOutput(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            j(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r0.b(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 < r7) goto L69
            r7 = 300(0x12c, float:4.2E-43)
            if (r6 >= r7) goto L69
            goto L6a
        L69:
            r4 = r1
        L6a:
            if (r4 == 0) goto L79
            com.google.firebase.installations.remote.TokenResult r10 = h(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92
        L70:
            r5.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            return r10
        L77:
            r10 = move-exception
            goto Lc6
        L79:
            r4 = 0
            d(r5, r4, r10, r12)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            r4 = 401(0x191, float:5.62E-43)
            if (r6 == r4) goto Lb7
            r4 = 404(0x194, float:5.66E-43)
            if (r6 != r4) goto L86
            goto Lb7
        L86:
            r4 = 429(0x1ad, float:6.01E-43)
            if (r6 == r4) goto Laf
            r4 = 500(0x1f4, float:7.0E-43)
            if (r6 < r4) goto L99
            r4 = 600(0x258, float:8.41E-43)
            if (r6 >= r4) goto L99
        L92:
            r5.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            goto Lcd
        L99:
            java.lang.String r4 = "Firebase-Installations"
            java.lang.String r6 = "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase."
            android.util.Log.e(r4, r6)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.TokenResult$Builder r4 = com.google.firebase.installations.remote.TokenResult.a()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.TokenResult$ResponseCode r6 = com.google.firebase.installations.remote.TokenResult.ResponseCode.f44652b     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.AutoValue_TokenResult$Builder r4 = (com.google.firebase.installations.remote.AutoValue_TokenResult.Builder) r4     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            r4.f44637c = r6     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.TokenResult r10 = r4.a()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            goto L70
        Laf:
            com.google.firebase.installations.FirebaseInstallationsException r4 = new com.google.firebase.installations.FirebaseInstallationsException     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            java.lang.String r6 = "Firebase servers have received too many requests from this client in a short period of time. Please try again later."
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            throw r4     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
        Lb7:
            com.google.firebase.installations.remote.TokenResult$Builder r4 = com.google.firebase.installations.remote.TokenResult.a()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.TokenResult$ResponseCode r6 = com.google.firebase.installations.remote.TokenResult.ResponseCode.f44653c     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.AutoValue_TokenResult$Builder r4 = (com.google.firebase.installations.remote.AutoValue_TokenResult.Builder) r4     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            r4.f44637c = r6     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            com.google.firebase.installations.remote.TokenResult r10 = r4.a()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L92 java.lang.Throwable -> L92
            goto L70
        Lc6:
            r5.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            throw r10
        Lcd:
            int r3 = r3 + 1
            goto L2b
        Ld1:
            com.google.firebase.installations.FirebaseInstallationsException r10 = new com.google.firebase.installations.FirebaseInstallationsException
            r10.<init>(r2)
            throw r10
        Ld7:
            com.google.firebase.installations.FirebaseInstallationsException r10 = new com.google.firebase.installations.FirebaseInstallationsException
            r10.<init>(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.google.firebase.installations.remote.TokenResult");
    }

    public final HttpURLConnection e(URL url, String str) throws FirebaseInstallationsException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty(UtilsKt.CONTENT_TYPE, "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty(UtilsKt.CACHE_CONTROL, "no-cache");
            Context context = this.f44640a;
            httpURLConnection.addRequestProperty("X-Android-Package", context.getPackageName());
            HeartBeatController heartBeatController = (HeartBeatController) this.f44641b.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) Tasks.a(heartBeatController.a()));
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e2);
                } catch (ExecutionException e3) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e3);
                }
            }
            String strBytesToStringUppercase = null;
            try {
                byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
                if (packageCertificateHashBytes == null) {
                    Log.e("ContentValues", "Could not get fingerprint hash for package: " + context.getPackageName());
                } else {
                    strBytesToStringUppercase = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
                }
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("ContentValues", "No such package: " + context.getPackageName(), e4);
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", strBytesToStringUppercase);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
    }
}
