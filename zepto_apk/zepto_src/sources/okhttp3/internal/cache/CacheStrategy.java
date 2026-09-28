package okhttp3.internal.cache;

import java.util.Date;
import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;

@Metadata
/* loaded from: classes.dex */
public final class CacheStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Request f56410a;

    /* renamed from: b, reason: collision with root package name */
    public final Response f56411b;

    @Metadata
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static boolean a(okhttp3.Request r2, okhttp3.Response r3) {
            /*
                java.lang.String r0 = "response"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "request"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                int r0 = r3.f56353d
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 == r1) goto L5b
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L5b
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L5b
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L5b
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L5b
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L5b
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L38
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L5b
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L5b
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L5b
                switch(r0) {
                    case 300: goto L5b;
                    case 301: goto L5b;
                    case 302: goto L38;
                    default: goto L37;
                }
            L37:
                goto L77
            L38:
                java.lang.String r0 = "Expires"
                r1 = 0
                java.lang.String r0 = r3.b(r0, r1)
                if (r0 != 0) goto L5b
                okhttp3.CacheControl r0 = r3.a()
                r1 = -1
                int r0 = r0.f56173c
                if (r0 != r1) goto L5b
                okhttp3.CacheControl r0 = r3.a()
                boolean r0 = r0.f56176f
                if (r0 != 0) goto L5b
                okhttp3.CacheControl r0 = r3.a()
                boolean r0 = r0.f56175e
                if (r0 != 0) goto L5b
                goto L77
            L5b:
                okhttp3.CacheControl r3 = r3.a()
                boolean r3 = r3.f56172b
                if (r3 != 0) goto L77
                okhttp3.CacheControl r3 = r2.f56336f
                if (r3 != 0) goto L71
                int r3 = okhttp3.CacheControl.n
                okhttp3.Headers r3 = r2.f56333c
                okhttp3.CacheControl r3 = okhttp3.CacheControl.Companion.a(r3)
                r2.f56336f = r3
            L71:
                boolean r2 = r3.f56172b
                if (r2 != 0) goto L77
                r2 = 1
                return r2
            L77:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Companion.a(okhttp3.Request, okhttp3.Response):boolean");
        }
    }

    @Metadata
    public static final class Factory {

        /* renamed from: a, reason: collision with root package name */
        public Date f56412a;

        /* renamed from: b, reason: collision with root package name */
        public String f56413b;

        /* renamed from: c, reason: collision with root package name */
        public Date f56414c;

        /* renamed from: d, reason: collision with root package name */
        public String f56415d;

        /* renamed from: e, reason: collision with root package name */
        public Date f56416e;

        /* renamed from: f, reason: collision with root package name */
        public long f56417f;

        /* renamed from: g, reason: collision with root package name */
        public long f56418g;

        /* renamed from: h, reason: collision with root package name */
        public String f56419h;

        /* renamed from: i, reason: collision with root package name */
        public int f56420i;
    }

    public CacheStrategy(Request request, Response response) {
        this.f56410a = request;
        this.f56411b = response;
    }
}
