package g;

import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f48413f = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f48415b;

    /* renamed from: c, reason: collision with root package name */
    public final int f48416c;

    /* renamed from: e, reason: collision with root package name */
    public int f48418e;

    /* renamed from: d, reason: collision with root package name */
    public int f48417d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final SecureRandom f48414a = new SecureRandom();

    public h(int i2, int i3) {
        this.f48415b = i2;
        this.f48416c = i3;
        int i4 = this.f48417d;
        int i5 = 1;
        for (int i6 = 0; i6 < i4 && this.f48415b * i5 * 2 <= this.f48416c; i6++) {
            i5 *= 2;
        }
        this.f48418e = i5;
        if (i2 <= 0) {
            this.f48415b = 10;
            String.format("ExponentialBackoffHelper: was constructed with a first retry interval value less than or equal to zero. It has been set to a default value (%d ms)", 10);
        }
    }

    public static int a(HttpsURLConnection httpsURLConnection) throws IOException {
        int responseCode = httpsURLConnection.getResponseCode();
        URL url = httpsURLConnection.getURL();
        if (responseCode == 429 || (responseCode >= 500 && responseCode <= 599)) {
            Locale locale = Locale.ENGLISH;
            b(url);
            return responseCode;
        }
        HashMap map = f48413f;
        synchronized (map) {
            map.remove(url.getHost() + url.getPath());
        }
        return responseCode;
    }

    public static void b(URL url) {
        String str = url.getHost() + url.getPath();
        HashMap map = f48413f;
        synchronized (map) {
            try {
                g gVar = (g) map.get(str);
                map.put(str, gVar == null ? new g(1, url, g.f48405f) : gVar.a(url));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
