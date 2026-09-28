package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import coil3.network.internal.UtilsKt;
import com.appsflyer.AFLogger;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.KEYRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class AFd1zSDK {
    public int AFAdRevenueData;

    @NotNull
    public byte[] getCurrencyIso4217Code;

    @Nullable
    public Map<String, String> getMonetizationNetwork;
    private final boolean getRevenue;

    public AFd1zSDK(@NotNull byte[] bArr, @Nullable Map<String, String> map, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.getCurrencyIso4217Code = bArr;
        this.getMonetizationNetwork = map;
        this.AFAdRevenueData = i2;
        this.getRevenue = true;
    }

    private static String AFAdRevenueData(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.HTTP_CLIENT;
            String message = th.getMessage();
            AFg1gSDK.e$default(aFLogger, aFg1cSDK, message == null ? "" : message, th, false, false, false, false, 96, null);
            errorStream = httpURLConnection.getErrorStream();
        }
        if (errorStream == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(errorStream, "");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, Charsets.UTF_8), KEYRecord.Flags.FLAG2);
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        ArrayList arrayList = new ArrayList();
        com.brentvatne.react.c action = new com.brentvatne.react.c(arrayList, 9);
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            Iterator it = TextStreamsKt.a(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            Unit unit = Unit.f53572a;
            bufferedReader.close();
            String strE = CollectionsKt.E(arrayList, null, null, null, null, 63);
            bufferedReader.close();
            return strE == null ? "" : strE;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(bufferedReader, th2);
                throw th3;
            }
        }
    }

    @JvmName
    @NotNull
    public abstract String getCurrencyIso4217Code();

    @NotNull
    public abstract String getCurrencyIso4217Code(@NotNull String str);

    @JvmName
    public boolean getMediationNetwork() {
        return this.getRevenue;
    }

    @WorkerThread
    public final boolean getMonetizationNetwork() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection = null;
        try {
            String currencyIso4217Code = getCurrencyIso4217Code();
            Intrinsics.checkNotNullParameter(currencyIso4217Code, "");
            URLConnection uRLConnectionOpenConnection = new URL(currencyIso4217Code).openConnection();
            Intrinsics.d(uRLConnectionOpenConnection, "");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                boolean monetizationNetwork = getMonetizationNetwork(httpURLConnection2, jCurrentTimeMillis);
                httpURLConnection2.disconnect();
                return monetizationNetwork;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    String str = "error: " + th + "\n\ttook " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms\n\t" + th.getMessage();
                    String currencyIso4217Code2 = getCurrencyIso4217Code("HTTP: [" + (httpURLConnection != null ? httpURLConnection.hashCode() : 0) + "] " + str);
                    if (getMediationNetwork()) {
                        AFLogger.afRDLog(currencyIso4217Code2);
                    } else {
                        AFLogger.afVerboseLog(currencyIso4217Code2);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (Throwable th2) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @JvmName
    @NotNull
    public abstract AFd1gSDK getRevenue();

    private final boolean getMonetizationNetwork(HttpURLConnection httpURLConnection, long j2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        StringBuilder sb = new StringBuilder(httpURLConnection.getRequestMethod() + ":" + httpURLConnection.getURL());
        sb.append("\n length: ");
        sb.append(new String(this.getCurrencyIso4217Code, Charsets.UTF_8).length());
        Map<String, String> map = this.getMonetizationNetwork;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("\n ");
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
            }
        }
        String currencyIso4217Code = getCurrencyIso4217Code("HTTP: [" + httpURLConnection.hashCode() + "] " + ((Object) sb));
        if (getMediationNetwork()) {
            AFLogger.afRDLog(currencyIso4217Code);
        } else {
            AFLogger.afVerboseLog(currencyIso4217Code);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setReadTimeout(this.AFAdRevenueData);
        httpURLConnection.setConnectTimeout(this.AFAdRevenueData);
        httpURLConnection.addRequestProperty(UtilsKt.CONTENT_TYPE, getRevenue().getRevenue);
        Map<String, String> map2 = this.getMonetizationNetwork;
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
            }
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.getCurrencyIso4217Code.length));
        OutputStream outputStream = httpURLConnection.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "");
        BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, KEYRecord.Flags.FLAG2);
        bufferedOutputStream.write(this.getCurrencyIso4217Code);
        bufferedOutputStream.close();
        String strAFAdRevenueData = AFAdRevenueData(httpURLConnection);
        long jCurrentTimeMillis = System.currentTimeMillis() - j2;
        String str = "response code:" + httpURLConnection.getResponseCode() + StringUtils.SPACE + httpURLConnection.getResponseMessage() + "\n\tbody:" + strAFAdRevenueData + "\n\ttook " + jCurrentTimeMillis + "ms";
        String currencyIso4217Code2 = getCurrencyIso4217Code("HTTP: [" + httpURLConnection.hashCode() + "] " + str);
        if (getMediationNetwork()) {
            AFLogger.afRDLog(currencyIso4217Code2);
        } else {
            AFLogger.afVerboseLog(currencyIso4217Code2);
        }
        return AFd1tSDK.getRevenue(httpURLConnection);
    }
}
