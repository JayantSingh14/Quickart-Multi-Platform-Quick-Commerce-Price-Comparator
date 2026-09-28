package io.ktor.client.plugins.cookies;

import androidx.fragment.app.e;
import io.ktor.http.CodecsKt;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.util.Base64Kt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class HttpCookiesKt$renderClientCookies$1 extends FunctionReferenceImpl implements Function1<Cookie, String> {

    /* renamed from: b, reason: collision with root package name */
    public static final HttpCookiesKt$renderClientCookies$1 f49944b = new HttpCookiesKt$renderClientCookies$1(1, CookieKt.class, "renderCookieHeader", "renderCookieHeader(Lio/ktor/http/Cookie;)Ljava/lang/String;", 1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        Cookie cookie = (Cookie) obj;
        Intrinsics.checkNotNullParameter(cookie, "p0");
        Set set = CookieKt.f50160a;
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        StringBuilder sb = new StringBuilder();
        sb.append(cookie.f50132a);
        sb.append('=');
        String value = cookie.f50133b;
        Intrinsics.checkNotNullParameter(value, "value");
        CookieEncoding encoding = cookie.f50134c;
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        int iOrdinal = encoding.ordinal();
        int i2 = 0;
        if (iOrdinal == 0) {
            while (i2 < value.length()) {
                char cCharAt = value.charAt(i2);
                if (!CharsKt.b(cCharAt) && Intrinsics.e(cCharAt, 32) >= 0) {
                    if (!CookieKt.f50162c.contains(Character.valueOf(cCharAt))) {
                        i2++;
                    }
                }
                throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in RAW format.  Consider URL_ENCODING mode");
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                value = CodecsKt.f(value, true);
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                int[] iArr = Base64Kt.f50419a;
                Intrinsics.checkNotNullParameter(value, "<this>");
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
                try {
                    StringsKt.e(bytePacketBuilder, value, 0, value.length(), Charsets.UTF_8);
                    ByteReadPacket byteReadPacketV = bytePacketBuilder.V();
                    Intrinsics.checkNotNullParameter(byteReadPacketV, "<this>");
                    value = Base64Kt.a(StringsKt.c(byteReadPacketV));
                } catch (Throwable th) {
                    bytePacketBuilder.close();
                    throw th;
                }
            }
        } else {
            if (kotlin.text.StringsKt.o(value, '\"')) {
                throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
            }
            while (i2 < value.length()) {
                char cCharAt2 = value.charAt(i2);
                if (!CharsKt.b(cCharAt2) && Intrinsics.e(cCharAt2, 32) >= 0) {
                    if (!CookieKt.f50162c.contains(Character.valueOf(cCharAt2))) {
                        i2++;
                    }
                }
                value = e.l('\"', "\"", value);
            }
        }
        sb.append(value);
        return sb.toString();
    }
}
