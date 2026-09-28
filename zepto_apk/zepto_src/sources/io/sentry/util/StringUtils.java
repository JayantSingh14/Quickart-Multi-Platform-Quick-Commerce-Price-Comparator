package io.sentry.util;

import android.support.v4.media.a;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class StringUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f53134a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f53135b = Pattern.compile("[\\W_]+");

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static String b(String str) {
        return (str != null && str.startsWith("\"") && str.endsWith("\"")) ? a.k(1, 1, str) : str;
    }
}
