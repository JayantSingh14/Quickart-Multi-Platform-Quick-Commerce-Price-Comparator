package com.amazon.identity.auth.device.endpoint;

import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Pair;
import com.amazon.identity.auth.device.AuthError;
import g.f;
import g.g;
import g.h;
import g.i;
import g.r;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
public abstract class AbstractHTTPSRequest<T extends r> {

    /* renamed from: d, reason: collision with root package name */
    public static final int f15232d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f15233e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15235b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f15236c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final h f15234a = new h(f15232d, f15233e);

    static {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        f15232d = (int) timeUnit.convert(1L, timeUnit2);
        f15233e = (int) timeUnit.convert(64L, timeUnit2);
    }

    public abstract r a(i iVar);

    public abstract String b();

    public final HttpsURLConnection c(String str) throws f {
        g gVar;
        g gVar2;
        URL url = new URL(str);
        HashMap map = h.f48413f;
        synchronized (map) {
            gVar = (g) map.get(url.getHost() + url.getPath());
        }
        if (gVar != null) {
            long jCurrentTimeMillis = gVar.f48410c - System.currentTimeMillis();
            long j2 = g.f48407h;
            if (jCurrentTimeMillis > j2) {
                h.b(gVar.f48408a);
                jCurrentTimeMillis = j2;
            }
            if (jCurrentTimeMillis > 0) {
                synchronized (map) {
                    gVar2 = (g) map.get(url.getHost() + url.getPath());
                }
                url.getHost();
                url.getPath();
                Locale locale = Locale.ENGLISH;
                if (gVar2 == null) {
                    throw new f(b.D("Ran in to a rare race condition during backoff interval, this call is backed off but ", url.getHost(), " server is back to available after this point."));
                }
                long jCurrentTimeMillis2 = gVar2.f48410c - System.currentTimeMillis();
                throw new f("Service " + url.getHost() + " is unavailable and currently in backoff interval, please retry after " + jCurrentTimeMillis2 + " ms.");
            }
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        h(httpsURLConnection);
        httpsURLConnection.setConnectTimeout(30000);
        Iterator it = this.f15236c.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            httpsURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
        return httpsURLConnection;
    }

    public final void d(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.getRequestMethod();
        Map<String, List<String>> requestProperties = httpsURLConnection.getRequestProperties();
        if (requestProperties != null) {
            requestProperties.size();
            for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                entry.getKey();
                List<String> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    TextUtils.join(", ", value);
                }
            }
        }
        i();
    }

    public final r e(HttpsURLConnection httpsURLConnection) throws InterruptedException, f {
        i iVar = null;
        while (true) {
            h hVar = this.f15234a;
            if (hVar.f48417d >= 1) {
                break;
            }
            try {
                int iA = h.a(httpsURLConnection);
                iVar = new i(iA, i.a(httpsURLConnection), i.b(httpsURLConnection));
                httpsURLConnection.disconnect();
                if (this.f15235b || (iA != 429 && (iA < 500 || iA > 599))) {
                    break;
                }
                String strB = b();
                hVar.f48417d++;
                int i2 = hVar.f48418e;
                int i3 = hVar.f48415b * i2;
                if (i3 * 2 <= hVar.f48416c) {
                    hVar.f48418e = i2 * 2;
                }
                long jNextInt = i3;
                SecureRandom secureRandom = hVar.f48414a;
                if (((int) Math.min(TTL.MAX_VALUE, (60 * jNextInt) / 100)) != 0) {
                    jNextInt = (jNextInt - (r4 / 2)) + secureRandom.nextInt(r4);
                }
                try {
                    Thread.sleep((int) jNextInt);
                } catch (InterruptedException e2) {
                    e2.toString();
                }
                httpsURLConnection = c(strB);
                j(httpsURLConnection);
            } catch (Throwable th) {
                httpsURLConnection.disconnect();
                throw th;
            }
        }
        return a(iVar);
    }

    public abstract void f();

    public void g() {
    }

    public abstract void h(HttpsURLConnection httpsURLConnection);

    public abstract void i();

    public void j(HttpsURLConnection httpsURLConnection) {
    }

    public final r k() throws AuthError {
        g gVar;
        try {
            f();
            g();
            String strB = b();
            URL url = new URL(strB);
            HashMap map = h.f48413f;
            synchronized (map) {
                gVar = (g) map.get(url.getHost() + url.getPath());
            }
            this.f15235b = gVar != null;
            HttpsURLConnection httpsURLConnectionC = c(strB);
            d(httpsURLConnectionC);
            j(httpsURLConnectionC);
            Objects.toString(httpsURLConnectionC.getURL());
            return e(httpsURLConnectionC);
        } catch (IllegalStateException e2) {
            e2.toString();
            throw new AuthError("Received communication error when executing token request", e2, AuthError.ERROR_TYPE.ERROR_COM);
        } catch (MalformedURLException e3) {
            throw new AuthError("MalformedURLException", e3, AuthError.ERROR_TYPE.ERROR_BAD_PARAM);
        } catch (IOException e4) {
            e4.toString();
            throw new AuthError("Received communication error when executing token request", e4, AuthError.ERROR_TYPE.ERROR_IO);
        }
    }
}
