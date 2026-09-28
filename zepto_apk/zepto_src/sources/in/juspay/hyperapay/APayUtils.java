package in.juspay.hyperapay;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class APayUtils {
    private static final int LENGTH = 128;

    @NotNull
    public static final APayUtils INSTANCE = new APayUtils();

    @NotNull
    private static final char[] CHARACTER_SET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', Soundex.SILENT_MARKER, '_', ClassUtils.PACKAGE_SEPARATOR_CHAR, '~'};

    private APayUtils() {
    }

    private final String base64UrlEncode(byte[] bArr) {
        List listZ;
        String s = Base64.encodeToString(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(s, "s");
        List listE = new Regex("=").e(s);
        if (listE.isEmpty()) {
            listZ = EmptyList.f53609a;
        } else {
            ListIterator listIterator = listE.listIterator(listE.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listZ = CollectionsKt.Z(listE, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listZ = EmptyList.f53609a;
        }
        return StringsKt.J(StringsKt.J((String) listZ.get(0), '+', Soundex.SILENT_MARKER), '/', '_');
    }

    @NotNull
    public final String generateCodeChallenge$hyper_apay_release(@NotNull String codeVerifier) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        byte[] digestArr;
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest != null) {
            Charset charsetDefaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset()");
            byte[] bytes = codeVerifier.getBytes(charsetDefaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            digestArr = messageDigest.digest(bytes);
        } else {
            digestArr = new byte[0];
        }
        Intrinsics.checkNotNullExpressionValue(digestArr, "digestArr");
        return base64UrlEncode(digestArr);
    }

    @NotNull
    public final String getCodeVerifier$hyper_apay_release() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 128; i2++) {
            char[] cArr = CHARACTER_SET;
            sb.append(cArr[secureRandom.nextInt(cArr.length)]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
