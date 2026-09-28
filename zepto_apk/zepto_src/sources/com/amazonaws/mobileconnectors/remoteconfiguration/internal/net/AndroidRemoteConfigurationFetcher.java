package com.amazonaws.mobileconnectors.remoteconfiguration.internal.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.support.v4.media.b;
import coil3.network.internal.UtilsKt;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.amazonaws.mobileconnectors.remoteconfiguration.exceptions.NetworkException;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ConfigurationImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfigurationImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AndroidRemoteConfigurationFetcher implements RemoteConfigurationFetcher {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f15288c = Pattern.compile("[1-9][0-9]*\\.[0-9]+\\.[0-9]+");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15289a;

    /* renamed from: b, reason: collision with root package name */
    public final URL f15290b;

    public AndroidRemoteConfigurationFetcher(Context context, URL url) {
        if (context == null) {
            throw new NullPointerException("The context may not be null.");
        }
        if (url == null) {
            throw new NullPointerException("The endpoint may not be null.");
        }
        this.f15289a = context;
        this.f15290b = url;
    }

    public byte[] a(String str, Attributes attributes, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appConfigId", str);
            jSONObject.put("lastSeenEntityTag", str2);
            jSONObject.put("localConfigurationInstanceId", str3);
            Map<String, Object> allAttributes = attributes.getAllAttributes();
            if (allAttributes != null) {
                jSONObject.put("clientAttributes", new JSONObject(allAttributes).toString());
            }
            return jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        } catch (JSONException e2) {
            throw new NetworkException("Error building request", e2);
        }
    }

    public void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/x-amz-json-1.1");
        httpURLConnection.setRequestProperty("X-Amz-Target", "RemoteConfigurationDistributionService.QueryConfiguration");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        Matcher matcher = f15288c.matcher("");
        httpURLConnection.setRequestProperty("User-Agent", "Arcus-Android/" + (matcher.find() ? matcher.group() : "1.3.x"));
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.net.RemoteConfigurationFetcher
    public RemoteConfiguration fetch(String str, Attributes attributes, String str2, String str3) throws Throwable {
        NetworkInfo activeNetworkInfo;
        HttpURLConnection httpURLConnection;
        if (str == null) {
            throw new NullPointerException("The App Configuration ID may not be null");
        }
        if (attributes == null) {
            throw new NullPointerException("The attributes may not be null");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f15289a.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            throw new NetworkException("There is no network connectivity.");
        }
        TrafficStats.setThreadStatsTag(72283);
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) this.f15290b.openConnection();
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setUseCaches(false);
            b(httpURLConnection);
            a(httpURLConnection, a(str, attributes, str2, str3));
            RemoteConfiguration remoteConfigurationA = a(str, a(httpURLConnection));
            httpURLConnection.disconnect();
            return remoteConfigurationA;
        } catch (IOException e3) {
            e = e3;
            throw new NetworkException("Unable to open connection", e);
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            throw new NetworkException("Error writing the request", e2);
        }
    }

    public JSONObject a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
                        inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i2 = inputStreamReader.read();
                                if (i2 == -1) {
                                    break;
                                }
                                sb.append((char) i2);
                            }
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            inputStreamReader.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return jSONObject;
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (IOException e2) {
                    throw new NetworkException("Error reading response.", e2);
                } catch (JSONException e3) {
                    throw new NetworkException("Invalid response format.", e3);
                }
            } else {
                throw new NetworkException(b.f(responseCode, "Request unsuccessful. Received code "));
            }
        } catch (IOException e4) {
            throw new NetworkException("Unable to get response code.", e4);
        }
    }

    public RemoteConfiguration a(String str, JSONObject jSONObject) throws JSONException {
        ConfigurationImpl configurationImpl;
        try {
            boolean z = jSONObject.getBoolean("updatedConfigurationAvailable");
            String string = jSONObject.getString("entityTag");
            try {
                configurationImpl = new ConfigurationImpl(jSONObject.getString("resultVariables"), new Date());
            } catch (JSONException unused) {
                configurationImpl = null;
            }
            return new RemoteConfigurationImpl(configurationImpl, str, 2, string, z);
        } catch (JSONException e2) {
            throw new NetworkException("Expected elements missing from the response", e2);
        }
    }
}
