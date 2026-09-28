package okhttp3;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Base64;
import okio.ByteString;

@Metadata
/* loaded from: classes3.dex */
public final class Credentials {
    public static final String a(String username, String password, Charset charset) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String str = username + ':' + password;
        ByteString byteString = ByteString.f56924d;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        new ByteString(bytes);
        return "Basic ".concat(Base64.b(bytes));
    }
}
