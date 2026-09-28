package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface CookieJar {

    /* renamed from: a, reason: collision with root package name */
    public static final CookieJar f56237a = new Companion.NoCookies();

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            public final List b(HttpUrl url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return EmptyList.f53609a;
            }

            @Override // okhttp3.CookieJar
            public final void d(HttpUrl url, List cookies) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(cookies, "cookies");
            }
        }
    }

    List b(HttpUrl httpUrl);

    void d(HttpUrl httpUrl, List list);
}
