package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public final class WebvttParserUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f9479a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(ParsableByteArray parsableByteArray) {
        parsableByteArray.getClass();
        String strK = parsableByteArray.k(Charsets.f42260c);
        return strK != null && strK.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i2 = Util.f5744a;
        String[] strArrSplit = str.split("\\.", 2);
        long j2 = 0;
        for (String str2 : strArrSplit[0].split(":", -1)) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long j3 = j2 * 1000;
        if (strArrSplit.length == 2) {
            j3 += Long.parseLong(strArrSplit[1]);
        }
        return j3 * 1000;
    }

    public static void d(ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.f5724b;
        if (a(parsableByteArray)) {
            return;
        }
        parsableByteArray.J(i2);
        throw ParserException.a(null, "Expected WEBVTT. Got " + parsableByteArray.k(Charsets.f42260c));
    }
}
