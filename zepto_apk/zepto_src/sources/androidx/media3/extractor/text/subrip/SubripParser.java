package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class SubripParser implements SubtitleParser {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f9357d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f9358e = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f9359a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f9360b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9361c = new ParsableByteArray();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.common.text.Cue d(android.text.Spanned r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.subrip.SubripParser.d(android.text.Spanned, java.lang.String):androidx.media3.common.text.Cue");
    }

    public static long e(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2 + 1);
        long j2 = strGroup != null ? Long.parseLong(strGroup) * DateUtils.MILLIS_PER_HOUR : 0L;
        String strGroup2 = matcher.group(i2 + 2);
        strGroup2.getClass();
        long j3 = (Long.parseLong(strGroup2) * DateUtils.MILLIS_PER_MINUTE) + j2;
        String strGroup3 = matcher.group(i2 + 3);
        strGroup3.getClass();
        long j4 = (Long.parseLong(strGroup3) * 1000) + j3;
        String strGroup4 = matcher.group(i2 + 4);
        if (strGroup4 != null) {
            j4 += Long.parseLong(strGroup4);
        }
        return j4 * 1000;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) throws NumberFormatException {
        String strK;
        String str;
        SubripParser subripParser = this;
        ParsableByteArray parsableByteArray = subripParser.f9361c;
        parsableByteArray.H(i2 + i3, bArr);
        parsableByteArray.J(i2);
        Charset charsetF = parsableByteArray.F();
        if (charsetF == null) {
            charsetF = Charsets.f42260c;
        }
        long j2 = outputOptions.f9181a;
        long j3 = -9223372036854775807L;
        ArrayList arrayList = (j2 == -9223372036854775807L || !outputOptions.f9182b) ? null : new ArrayList();
        while (true) {
            String strK2 = parsableByteArray.k(charsetF);
            if (strK2 == null) {
                break;
            }
            if (strK2.length() != 0) {
                try {
                    Integer.parseInt(strK2);
                    strK = parsableByteArray.k(charsetF);
                } catch (NumberFormatException unused) {
                    Log.h("SubripParser", "Skipping invalid index: ".concat(strK2));
                }
                if (strK == null) {
                    Log.h("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f9357d.matcher(strK);
                if (matcher.matches()) {
                    long jE = e(matcher, 1);
                    long jE2 = e(matcher, 6);
                    StringBuilder sb = subripParser.f9359a;
                    sb.setLength(0);
                    long j4 = j3;
                    ArrayList arrayList2 = subripParser.f9360b;
                    arrayList2.clear();
                    String strK3 = parsableByteArray.k(charsetF);
                    while (!TextUtils.isEmpty(strK3)) {
                        if (sb.length() > 0) {
                            sb.append("<br>");
                        }
                        String strTrim = strK3.trim();
                        StringBuilder sb2 = new StringBuilder(strTrim);
                        Matcher matcher2 = f9358e.matcher(strTrim);
                        int i4 = 0;
                        while (matcher2.find()) {
                            String strGroup = matcher2.group();
                            arrayList2.add(strGroup);
                            int iStart = matcher2.start() - i4;
                            int length = strGroup.length();
                            sb2.replace(iStart, iStart + length, "");
                            i4 += length;
                            j2 = j2;
                        }
                        sb.append(sb2.toString());
                        strK3 = parsableByteArray.k(charsetF);
                        j2 = j2;
                    }
                    long j5 = j2;
                    Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList2.size()) {
                            str = null;
                            break;
                        }
                        str = (String) arrayList2.get(i5);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (j5 == j4 || jE >= j5) {
                        consumer.accept(new CuesWithTiming(ImmutableList.t(d(spannedFromHtml, str)), jE, jE2 - jE));
                    } else if (arrayList != null) {
                        arrayList.add(new CuesWithTiming(ImmutableList.t(d(spannedFromHtml, str)), jE, jE2 - jE));
                    }
                    subripParser = this;
                    j3 = j4;
                    j2 = j5;
                } else {
                    Log.h("SubripParser", "Skipping invalid timing: ".concat(strK));
                    subripParser = this;
                }
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                consumer.accept((CuesWithTiming) it.next());
            }
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 1;
    }
}
