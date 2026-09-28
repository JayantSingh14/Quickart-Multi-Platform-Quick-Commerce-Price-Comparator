package okhttp3.internal.cache;

import kotlin.Metadata;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata
/* loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final Cache f56405a;

    @Metadata
    public static final class Companion {
        public static final Response a(Response response) {
            if ((response != null ? response.f56356g : null) == null) {
                return response;
            }
            Response.Builder builderE = response.e();
            builderE.f56369g = null;
            return builderE.a();
        }

        public static boolean b(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }
    }

    public CacheInterceptor(Cache cache) {
        this.f56405a = cache;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015a  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response a(okhttp3.internal.http.RealInterceptorChain r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1147
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.a(okhttp3.internal.http.RealInterceptorChain):okhttp3.Response");
    }
}
