package com.zeptoconsumerapp.NetworkLogger;

import android.util.LruCache;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator;
import in.juspay.hyperutil.constants.LogLevel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* loaded from: classes.dex */
public class NetworkEventListener extends EventListener {

    /* renamed from: f, reason: collision with root package name */
    public static final EventListener.Factory f47527f = new EventListener.Factory() { // from class: com.zeptoconsumerapp.NetworkLogger.NetworkEventListener.1

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLong f47533a = new AtomicLong(1);

        /* renamed from: b, reason: collision with root package name */
        public final List f47534b = Arrays.asList("ik.imagekit.io", "events.zepto.co.in");

        @Override // okhttp3.EventListener.Factory
        public final EventListener d(RealCall realCall) {
            this.f47533a.getAndIncrement();
            Request request = realCall.f56518b;
            return this.f47534b.contains(request.f56331a.j().getHost()) ? EventListener.f56243a : new NetworkEventListener(request.f56331a.f56267i, System.nanoTime());
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public static final LruCache f47528g = new LruCache(100);

    /* renamed from: b, reason: collision with root package name */
    public final String f47529b;

    /* renamed from: c, reason: collision with root package name */
    public final long f47530c;

    /* renamed from: d, reason: collision with root package name */
    public long f47531d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f47532e = -1;

    public NetworkEventListener(String str, long j2) {
        this.f47529b = str;
        this.f47530c = j2;
    }

    public static void D(String str, Call call) {
        try {
            String strA = call.r().a("request_id");
            if (strA != null) {
                LruCache lruCache = f47528g;
                if (lruCache.get(strA) == null) {
                    lruCache.put(strA, new CopyOnWriteArrayList());
                }
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) lruCache.get(strA);
                copyOnWriteArrayList.add(str);
                lruCache.put(strA, copyOnWriteArrayList);
            }
        } catch (Exception unused) {
        }
    }

    public static void E() {
        System.nanoTime();
        String str = Utils.f47559a;
    }

    @Override // okhttp3.EventListener
    public final void A(Call call, Response response) {
        D("satisfactionFailure", call);
    }

    @Override // okhttp3.EventListener
    public final void B(Call call, Handshake handshake) {
        D("secureConnectEnd", call);
    }

    @Override // okhttp3.EventListener
    public final void C(Call call) {
        D("secureConnectStart", call);
    }

    @Override // okhttp3.EventListener
    public final void d(RealCall realCall) {
        E();
        D("callEnd", realCall);
    }

    @Override // okhttp3.EventListener
    public final void e(RealCall realCall, IOException iOException) {
        iOException.toString();
        E();
        D("callFailed", realCall);
    }

    @Override // okhttp3.EventListener
    public final void f(RealCall realCall) {
        E();
        D("callStart", realCall);
    }

    @Override // okhttp3.EventListener
    public final void g(RealCall realCall) {
        E();
        D("canceled", realCall);
    }

    @Override // okhttp3.EventListener
    public final void h(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        E();
        D("connectEnd", call);
    }

    @Override // okhttp3.EventListener
    public final void i(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, IOException iOException) throws JSONException {
        E();
        D("connectFailed " + iOException.toString(), call);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogLevel.EXCEPTION, iOException.toString());
            jSONObject.put("timeTaken", (int) ((System.nanoTime() - this.f47530c) / 1000000.0d));
            jSONObject.put("url", this.f47529b);
        } catch (JSONException unused) {
        }
    }

    @Override // okhttp3.EventListener
    public final void j(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        D("connectStart", call);
    }

    @Override // okhttp3.EventListener
    public final void k(Call call, Connection connection) {
        D("connectionAcquired", call);
    }

    @Override // okhttp3.EventListener
    public final void l(Call call, Connection connection) {
        D("connectionReleased", call);
    }

    @Override // okhttp3.EventListener
    public final void m(Call call, String str, List list) throws JSONException {
        E();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!list.isEmpty()) {
                jSONObject.put("inetAddresses", Arrays.toString(list.toArray()));
            }
            jSONObject.put("domainName", str);
            long j2 = this.f47531d;
            if (j2 == -1) {
                j2 = this.f47530c;
            }
            jSONObject.put("timeTaken", (int) ((System.nanoTime() - j2) / 1000000.0d));
            jSONObject.put("url", this.f47529b);
        } catch (JSONException unused) {
        }
        D("dnsEnd (" + list.size() + ")", call);
    }

    @Override // okhttp3.EventListener
    public final void n(String str, Call call) {
        this.f47531d = System.nanoTime();
        E();
        D("dnsStart", call);
    }

    @Override // okhttp3.EventListener
    public final void o(Call call, HttpUrl httpUrl, List list) {
        D("proxySelectEnd", call);
    }

    @Override // okhttp3.EventListener
    public final void p(Call call, HttpUrl httpUrl) {
        D("proxySelectStart", call);
    }

    @Override // okhttp3.EventListener
    public final void q(Call call, long j2) {
        D("requestBodyEnd", call);
    }

    @Override // okhttp3.EventListener
    public final void r(Call call) {
        D("requestBodyStart", call);
    }

    @Override // okhttp3.EventListener
    public final void s(Call call, IOException iOException) {
        E();
        D("requestFailed " + iOException.toString(), call);
    }

    @Override // okhttp3.EventListener
    public final void t(Call call, Request request) {
        D("requestHeadersEnd", call);
    }

    @Override // okhttp3.EventListener
    public final void u(Call call) {
        D("requestHeadersStart", call);
    }

    @Override // okhttp3.EventListener
    public final void v(Call call, long j2) {
        D("responseBodyEnd " + j2, call);
        if (this.f47532e == -1 || j2 <= 500) {
            return;
        }
        long jNanoTime = (System.nanoTime() - this.f47532e) / 1000000;
        Timber.d("PSP").d("%d %d", Long.valueOf(j2), Long.valueOf(jNanoTime));
        if (jNanoTime > 0) {
            double d2 = ((j2 * 8.0d) / (jNanoTime / 1000.0d)) / 1000.0d;
            Timber.d("PSP").d("Response body download: %d bytes in %d ms, bandwidth: %.2f kbps", Long.valueOf(j2), Long.valueOf(jNanoTime), Double.valueOf(d2));
            NetworkBandwidthAggregator.f47757a.a(d2, jNanoTime);
        }
    }

    @Override // okhttp3.EventListener
    public final void w(Call call) {
        this.f47532e = System.nanoTime();
        D("responseBodyStart", call);
    }

    @Override // okhttp3.EventListener
    public final void x(Call call, IOException iOException) {
        E();
        D("responseFailed " + iOException.toString(), call);
    }

    @Override // okhttp3.EventListener
    public final void y(Call call, Response response) {
        D("responseHeadersEnd " + response.f56353d, call);
    }

    @Override // okhttp3.EventListener
    public final void z(Call call) {
        D("responseHeadersStart", call);
    }
}
