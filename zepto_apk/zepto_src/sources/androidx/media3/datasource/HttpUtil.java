package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public final class HttpUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f5919a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5920b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j2, long j3) {
        if (j2 == 0 && j3 == -1) {
            return null;
        }
        StringBuilder sbV = android.support.v4.media.b.v(j2, "bytes=", "-");
        if (j3 != -1) {
            sbV.append((j2 + j3) - 1);
        }
        return sbV.toString();
    }

    public static long b(String str, String str2) throws NumberFormatException {
        long j2;
        if (TextUtils.isEmpty(str)) {
            j2 = -1;
        } else {
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                Log.d("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j2;
        }
        Matcher matcher = f5919a.matcher(str2);
        if (!matcher.matches()) {
            return j2;
        }
        try {
            String strGroup = matcher.group(2);
            strGroup.getClass();
            long j3 = Long.parseLong(strGroup);
            String strGroup2 = matcher.group(1);
            strGroup2.getClass();
            long j4 = (j3 - Long.parseLong(strGroup2)) + 1;
            if (j2 < 0) {
                return j4;
            }
            if (j2 == j4) {
                return j2;
            }
            Log.h("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j2, j4);
        } catch (NumberFormatException unused2) {
            Log.d("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j2;
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f5920b.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Long.parseLong(strGroup);
    }
}
