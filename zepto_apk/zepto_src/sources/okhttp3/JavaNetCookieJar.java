package okhttp3;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

@Metadata
/* loaded from: classes.dex */
public final class JavaNetCookieJar implements CookieJar {

    /* renamed from: b, reason: collision with root package name */
    public final CookieHandler f56277b;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        Intrinsics.checkNotNullParameter(cookieHandler, "cookieHandler");
        this.f56277b = cookieHandler;
    }

    @Override // okhttp3.CookieJar
    public final List b(HttpUrl url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Map<String, List<String>> cookieHeaders = this.f56277b.get(url.i(), MapsKt.c());
            Intrinsics.checkNotNullExpressionValue(cookieHeaders, "cookieHeaders");
            ArrayList arrayList = null;
            for (Map.Entry<String, List<String>> entry : cookieHeaders.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    if (!value.isEmpty()) {
                        for (String header : value) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Intrinsics.checkNotNullExpressionValue(header, "header");
                            ArrayList arrayList2 = new ArrayList();
                            int length = header.length();
                            int i2 = 0;
                            while (i2 < length) {
                                int iE = Util.e(i2, length, header, ";,");
                                int iF = Util.f(header, '=', i2, iE);
                                String strA = Util.A(i2, iF, header);
                                if (!StringsKt.O(strA, "$", false)) {
                                    String strA2 = iF < iE ? Util.A(iF + 1, iE, header) : "";
                                    if (StringsKt.O(strA2, "\"", false) && StringsKt.r(strA2, "\"", false)) {
                                        strA2 = strA2.substring(1, strA2.length() - 1);
                                        Intrinsics.checkNotNullExpressionValue(strA2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    }
                                    Cookie.Builder builder = new Cookie.Builder();
                                    builder.c(strA);
                                    builder.d(strA2);
                                    builder.b(url.f56262d);
                                    arrayList2.add(builder.a());
                                }
                                i2 = iE + 1;
                            }
                            arrayList.addAll(arrayList2);
                        }
                    }
                }
            }
            if (arrayList == null) {
                return EmptyList.f53609a;
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmo…fiableList(cookies)\n    }");
            return listUnmodifiableList;
        } catch (IOException e2) {
            Platform platform = Platform.f56791a;
            Platform platform2 = Platform.f56791a;
            StringBuilder sb = new StringBuilder("Loading cookies failed for ");
            HttpUrl httpUrlH = url.h("/...");
            Intrinsics.c(httpUrlH);
            sb.append(httpUrlH);
            String string = sb.toString();
            platform2.getClass();
            Platform.i(5, string, e2);
            return EmptyList.f53609a;
        }
    }

    @Override // okhttp3.CookieJar
    public final void d(HttpUrl url, List cookies) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        ArrayList arrayList = new ArrayList();
        Iterator it = cookies.iterator();
        while (it.hasNext()) {
            arrayList.add(Internal.a((Cookie) it.next()));
        }
        try {
            this.f56277b.put(url.i(), MapsKt.g(new Pair("Set-Cookie", arrayList)));
        } catch (IOException e2) {
            Platform platform = Platform.f56791a;
            Platform platform2 = Platform.f56791a;
            StringBuilder sb = new StringBuilder("Saving cookies failed for ");
            HttpUrl httpUrlH = url.h("/...");
            Intrinsics.c(httpUrlH);
            sb.append(httpUrlH);
            String string = sb.toString();
            platform2.getClass();
            Platform.i(5, string, e2);
        }
    }
}
