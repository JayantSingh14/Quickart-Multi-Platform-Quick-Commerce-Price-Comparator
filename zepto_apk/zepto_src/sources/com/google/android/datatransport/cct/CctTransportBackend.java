package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.media.b;
import android.util.Log;
import coil3.network.internal.UtilsKt;
import com.appsflyer.AdRevenueScheme;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.ExperimentIds;
import com.google.android.datatransport.cct.internal.ExternalPRequestContext;
import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
final class CctTransportBackend implements TransportBackend {

    /* renamed from: a, reason: collision with root package name */
    public final DataEncoder f20524a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f20525b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f20526c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f20527d;

    /* renamed from: e, reason: collision with root package name */
    public final Clock f20528e;

    /* renamed from: f, reason: collision with root package name */
    public final Clock f20529f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20530g;

    public static final class HttpRequest {

        /* renamed from: a, reason: collision with root package name */
        public final URL f20531a;

        /* renamed from: b, reason: collision with root package name */
        public final BatchedLogRequest f20532b;

        /* renamed from: c, reason: collision with root package name */
        public final String f20533c;

        public HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.f20531a = url;
            this.f20532b = batchedLogRequest;
            this.f20533c = str;
        }
    }

    public static final class HttpResponse {

        /* renamed from: a, reason: collision with root package name */
        public final int f20534a;

        /* renamed from: b, reason: collision with root package name */
        public final URL f20535b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20536c;

        public HttpResponse(int i2, URL url, long j2) {
            this.f20534a = i2;
            this.f20535b = url;
            this.f20536c = j2;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoBatchedLogRequestEncoder.f20538a.a(jsonDataEncoderBuilder);
        jsonDataEncoderBuilder.f44505d = true;
        this.f20524a = jsonDataEncoderBuilder.a();
        this.f20526c = context;
        this.f20525b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f20527d = c(CCTDestination.f20518c);
        this.f20528e = clock2;
        this.f20529f = clock;
        this.f20530g = 130000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(b.C("Invalid url: ", str), e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(1:4)(1:5)|6|(1:8)(9:10|(1:12)(2:13|(0))|15|(1:18)|19|26|20|24|25)|9|15|(0)|19|26|20|24|25) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f6, code lost:
    
        com.google.android.datatransport.runtime.logging.Logging.c("CctTransportBackend", "Unable to find version code for package", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00df  */
    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.datatransport.runtime.EventInternal a(com.google.android.datatransport.runtime.EventInternal r6) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.a(com.google.android.datatransport.runtime.EventInternal):com.google.android.datatransport.runtime.EventInternal");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.datatransport.cct.a] */
    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public final BackendResponse b(BackendRequest backendRequest) {
        int i2;
        String str;
        Object objA;
        LogEvent.Builder builderK;
        HashMap map = new HashMap();
        for (EventInternal eventInternal : backendRequest.b()) {
            String strL = eventInternal.l();
            if (map.containsKey(strL)) {
                ((List) map.get(strL)).add(eventInternal);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(strL, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            i2 = 5;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder builderA = LogRequest.a();
            QosTier qosTier = QosTier.f20674a;
            builderA.f();
            builderA.g(this.f20529f.a());
            builderA.h(this.f20528e.a());
            ClientInfo.Builder builderA2 = ClientInfo.a();
            builderA2.c();
            AndroidClientInfo.Builder builderA3 = AndroidClientInfo.a();
            builderA3.m(Integer.valueOf(eventInternal2.i("sdk-version")));
            builderA3.j(eventInternal2.b("model"));
            builderA3.f(eventInternal2.b("hardware"));
            builderA3.d(eventInternal2.b(LogSubCategory.Context.DEVICE));
            builderA3.l(eventInternal2.b("product"));
            builderA3.k(eventInternal2.b("os-uild"));
            builderA3.h(eventInternal2.b("manufacturer"));
            builderA3.e(eventInternal2.b("fingerprint"));
            builderA3.c(eventInternal2.b(AdRevenueScheme.COUNTRY));
            builderA3.g(eventInternal2.b("locale"));
            builderA3.i(eventInternal2.b("mcc_mnc"));
            builderA3.b(eventInternal2.b("application_build"));
            builderA2.b(builderA3.a());
            builderA.b(builderA2.a());
            try {
                builderA.d(Integer.valueOf(Integer.parseInt((String) entry.getKey())));
            } catch (NumberFormatException unused) {
                builderA.e((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload encodedPayloadE = eventInternal3.e();
                Encoding encoding = encodedPayloadE.f20745a;
                boolean zEquals = encoding.equals(new Encoding("proto"));
                byte[] bArr = encodedPayloadE.f20746b;
                if (zEquals) {
                    builderK = LogEvent.k(bArr);
                } else if (encoding.equals(new Encoding("json"))) {
                    builderK = LogEvent.j(new String(bArr, Charset.forName("UTF-8")));
                } else {
                    String strD = Logging.d("CctTransportBackend");
                    if (Log.isLoggable(strD, 5)) {
                        Log.w(strD, "Received event of unsupported encoding " + encoding + ". Skipping...");
                    }
                }
                builderK.d(eventInternal3.f());
                builderK.e(eventInternal3.m());
                String str2 = (String) eventInternal3.c().get("tz-offset");
                builderK.h(str2 == null ? 0L : Long.valueOf(str2).longValue());
                NetworkConnectionInfo.Builder builderA4 = NetworkConnectionInfo.a();
                builderA4.c((NetworkConnectionInfo.NetworkType) NetworkConnectionInfo.NetworkType.f20672a.get(eventInternal3.i("net-type")));
                builderA4.b((NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.f20670a.get(eventInternal3.i("mobile-subtype")));
                builderK.g(builderA4.a());
                if (eventInternal3.d() != null) {
                    builderK.c(eventInternal3.d());
                }
                if (eventInternal3.j() != null) {
                    ComplianceData.Builder builderA5 = ComplianceData.a();
                    ExternalPrivacyContext.Builder builderA6 = ExternalPrivacyContext.a();
                    ExternalPRequestContext.Builder builderA7 = ExternalPRequestContext.a();
                    builderA7.b(eventInternal3.j());
                    builderA6.b(builderA7.a());
                    builderA5.b(builderA6.a());
                    ComplianceData.ProductIdOrigin productIdOrigin = ComplianceData.ProductIdOrigin.f20668a;
                    builderA5.c();
                    builderK.b(builderA5.a());
                }
                if (eventInternal3.g() != null || eventInternal3.h() != null) {
                    ExperimentIds.Builder builderA8 = ExperimentIds.a();
                    if (eventInternal3.g() != null) {
                        builderA8.b(eventInternal3.g());
                    }
                    if (eventInternal3.h() != null) {
                        builderA8.c(eventInternal3.h());
                    }
                    builderK.f(builderA8.a());
                }
                arrayList3.add(builderK.a());
            }
            builderA.c(arrayList3);
            arrayList2.add(builderA.a());
        }
        BatchedLogRequest batchedLogRequestA = BatchedLogRequest.a(arrayList2);
        byte[] bArrC = backendRequest.c();
        URL urlC = this.f20527d;
        if (bArrC != null) {
            try {
                CCTDestination cCTDestinationB = CCTDestination.b(backendRequest.c());
                str = cCTDestinationB.f20523b;
                if (str == null) {
                    str = null;
                }
                String str3 = cCTDestinationB.f20522a;
                if (str3 != null) {
                    urlC = c(str3);
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.a();
            }
        } else {
            str = null;
        }
        try {
            HttpRequest httpRequest = new HttpRequest(urlC, batchedLogRequestA, str);
            ?? r0 = new Function() { // from class: com.google.android.datatransport.cct.a
                public final Object a(Object obj) {
                    CctTransportBackend.HttpRequest httpRequest2 = (CctTransportBackend.HttpRequest) obj;
                    CctTransportBackend cctTransportBackend = this.f20537a;
                    cctTransportBackend.getClass();
                    String strD2 = Logging.d("CctTransportBackend");
                    boolean zIsLoggable = Log.isLoggable(strD2, 4);
                    URL url = httpRequest2.f20531a;
                    if (zIsLoggable) {
                        Log.i(strD2, String.format("Making request to: %s", url));
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(cctTransportBackend.f20530g);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
                    httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/json");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    String str4 = httpRequest2.f20533c;
                    if (str4 != null) {
                        httpURLConnection.setRequestProperty("X-Goog-Api-Key", str4);
                    }
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                            try {
                                cctTransportBackend.f20524a.a(new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)), httpRequest2.f20532b);
                                gZIPOutputStream.close();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                int responseCode = httpURLConnection.getResponseCode();
                                Integer numValueOf = Integer.valueOf(responseCode);
                                String strD3 = Logging.d("CctTransportBackend");
                                if (Log.isLoggable(strD3, 4)) {
                                    Log.i(strD3, String.format("Status Code: %d", numValueOf));
                                }
                                Logging.a("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(UtilsKt.CONTENT_TYPE));
                                Logging.a("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                                    return new CctTransportBackend.HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                                }
                                if (responseCode != 200) {
                                    return new CctTransportBackend.HttpResponse(responseCode, null, 0L);
                                }
                                InputStream inputStream = httpURLConnection.getInputStream();
                                try {
                                    InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                                    try {
                                        CctTransportBackend.HttpResponse httpResponse = new CctTransportBackend.HttpResponse(responseCode, null, LogResponse.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).b());
                                        if (gZIPInputStream != null) {
                                            gZIPInputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return httpResponse;
                                    } finally {
                                    }
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } finally {
                            }
                        } catch (Throwable th3) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (EncodingException e2) {
                        e = e2;
                        Logging.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                        return new CctTransportBackend.HttpResponse(400, null, 0L);
                    } catch (ConnectException e3) {
                        e = e3;
                        Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                        return new CctTransportBackend.HttpResponse(500, null, 0L);
                    } catch (UnknownHostException e4) {
                        e = e4;
                        Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                        return new CctTransportBackend.HttpResponse(500, null, 0L);
                    } catch (IOException e5) {
                        e = e5;
                        Logging.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                        return new CctTransportBackend.HttpResponse(400, null, 0L);
                    }
                }
            };
            do {
                objA = r0.a(httpRequest);
                URL url = ((HttpResponse) objA).f20535b;
                if (url != null) {
                    Logging.a("CctTransportBackend", "Following redirect to: %s", url);
                    httpRequest = new HttpRequest(url, httpRequest.f20532b, httpRequest.f20533c);
                } else {
                    httpRequest = null;
                }
                if (httpRequest == null) {
                    break;
                }
                i2--;
            } while (i2 >= 1);
            HttpResponse httpResponse = (HttpResponse) objA;
            int i3 = httpResponse.f20534a;
            if (i3 == 200) {
                return BackendResponse.e(httpResponse.f20536c);
            }
            if (i3 < 500 && i3 != 404) {
                return i3 == 400 ? BackendResponse.d() : BackendResponse.a();
            }
            return BackendResponse.f();
        } catch (IOException e2) {
            Logging.c("CctTransportBackend", "Could not make request to the backend", e2);
            return BackendResponse.f();
        }
    }
}
