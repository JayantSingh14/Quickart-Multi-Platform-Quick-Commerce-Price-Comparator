package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.util.ParsableByteArray;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class WebvttCssParser {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f9433c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f9434d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9435a = new ParsableByteArray();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f9436b = new StringBuilder();

    public static String a(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int i2 = parsableByteArray.f5724b;
        int i3 = parsableByteArray.f5725c;
        while (i2 < i3 && !z) {
            char c2 = (char) parsableByteArray.f5723a[i2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                i2++;
                sb.append(c2);
            }
        }
        parsableByteArray.K(i2 - parsableByteArray.f5724b);
        return sb.toString();
    }

    public static String b(ParsableByteArray parsableByteArray, StringBuilder sb) {
        c(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        String strA = a(parsableByteArray, sb);
        if (!"".equals(strA)) {
            return strA;
        }
        return "" + ((char) parsableByteArray.x());
    }

    public static void c(ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z = true; parsableByteArray.a() > 0 && z; z = false) {
                int i2 = parsableByteArray.f5724b;
                byte[] bArr = parsableByteArray.f5723a;
                byte b2 = bArr[i2];
                char c2 = (char) b2;
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    parsableByteArray.K(1);
                } else {
                    int i3 = parsableByteArray.f5725c;
                    int i4 = i2 + 2;
                    if (i4 <= i3) {
                        int i5 = i2 + 1;
                        if (b2 == 47 && bArr[i5] == 42) {
                            while (true) {
                                int i6 = i4 + 1;
                                if (i6 >= i3) {
                                    break;
                                }
                                if (((char) bArr[i4]) == '*' && ((char) bArr[i6]) == '/') {
                                    i4 += 2;
                                    i3 = i4;
                                } else {
                                    i4 = i6;
                                }
                            }
                            parsableByteArray.K(i3 - parsableByteArray.f5724b);
                        }
                    }
                }
            }
            return;
        }
    }
}
