package g;

import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: f, reason: collision with root package name */
    public static final long f48405f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f48406g;

    /* renamed from: h, reason: collision with root package name */
    public static final long f48407h;

    /* renamed from: a, reason: collision with root package name */
    public final URL f48408a;

    /* renamed from: b, reason: collision with root package name */
    public final long f48409b;

    /* renamed from: c, reason: collision with root package name */
    public final long f48410c;

    /* renamed from: d, reason: collision with root package name */
    public final SecureRandom f48411d;

    /* renamed from: e, reason: collision with root package name */
    public int f48412e;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f48405f = timeUnit.toMillis(2L);
        f48406g = timeUnit.toMillis(60L);
        f48407h = timeUnit.toMillis(78L);
    }

    public g(int i2, URL url, long j2) {
        this.f48412e = 0;
        this.f48408a = url;
        long jMin = f48405f;
        if (j2 < jMin) {
            Locale locale = Locale.ENGLISH;
        } else {
            jMin = Math.min(j2, f48407h);
        }
        this.f48409b = jMin;
        this.f48410c = System.currentTimeMillis() + jMin;
        this.f48411d = new SecureRandom();
        this.f48412e = i2;
    }

    public final g a(URL url) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f48410c;
        boolean z = jCurrentTimeMillis < j2;
        boolean z2 = j2 - jCurrentTimeMillis < f48407h;
        if (z && z2) {
            return this;
        }
        int iMin = (int) Math.min(this.f48409b * 2, f48406g);
        Locale locale = Locale.ENGLISH;
        int i2 = this.f48412e + 1;
        this.f48412e = i2;
        long jNextInt = iMin;
        SecureRandom secureRandom = this.f48411d;
        HashMap map = h.f48413f;
        if (((int) Math.min(TTL.MAX_VALUE, (60 * jNextInt) / 100)) != 0) {
            jNextInt = (jNextInt - (r5 / 2)) + secureRandom.nextInt(r5);
        }
        return new g(i2, url, (int) jNextInt);
    }
}
