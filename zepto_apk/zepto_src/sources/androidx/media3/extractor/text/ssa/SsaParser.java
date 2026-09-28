package androidx.media3.extractor.text.ssa;

import android.graphics.PointF;
import android.support.v4.media.a;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.ssa.SsaStyle;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class SsaParser implements SubtitleParser {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f9325g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9326a;

    /* renamed from: b, reason: collision with root package name */
    public final SsaDialogueFormat f9327b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9328c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap f9329d;

    /* renamed from: e, reason: collision with root package name */
    public float f9330e;

    /* renamed from: f, reason: collision with root package name */
    public float f9331f;

    public SsaParser() {
        this(null);
    }

    public static int d(long j2, ArrayList arrayList, ArrayList arrayList2) {
        int i2;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i2 = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j2) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j2) {
                i2 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i2, Long.valueOf(j2));
        arrayList2.add(i2, i2 == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i2 - 1)));
        return i2;
    }

    public static long f(String str) {
        Matcher matcher = f9325g.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i2 = Util.f5744a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(strGroup) * 3600000000L);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) throws NumberFormatException {
        Charset charset;
        SsaDialogueFormat ssaDialogueFormat;
        ParsableByteArray parsableByteArray;
        float f2;
        float f3;
        Layout.Alignment alignment;
        int i4;
        int i5;
        int i6;
        float f4;
        int i7;
        int i8;
        Integer num;
        int iA;
        int i9;
        SsaParser ssaParser = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = ssaParser.f9328c;
        parsableByteArray2.H(i2 + i3, bArr);
        parsableByteArray2.J(i2);
        Charset charsetF = parsableByteArray2.F();
        if (charsetF == null) {
            charsetF = Charsets.f42260c;
        }
        boolean z = ssaParser.f9326a;
        if (!z) {
            ssaParser.e(parsableByteArray2, charsetF);
        }
        SsaDialogueFormat ssaDialogueFormatA = z ? ssaParser.f9327b : null;
        while (true) {
            String strK = parsableByteArray2.k(charsetF);
            if (strK == null) {
                long j2 = outputOptions.f9181a;
                ArrayList arrayList3 = (j2 == -9223372036854775807L || !outputOptions.f9182b) ? null : new ArrayList();
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    List list = (List) arrayList.get(i10);
                    if (!list.isEmpty() || i10 == 0) {
                        if (i10 == arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue = ((Long) arrayList2.get(i10)).longValue();
                        long jLongValue2 = ((Long) arrayList2.get(i10 + 1)).longValue() - ((Long) arrayList2.get(i10)).longValue();
                        if (j2 == -9223372036854775807L || jLongValue >= j2) {
                            consumer.accept(new CuesWithTiming(list, jLongValue, jLongValue2));
                        } else if (arrayList3 != null) {
                            arrayList3.add(new CuesWithTiming(list, jLongValue, jLongValue2));
                        }
                    }
                }
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        consumer.accept((CuesWithTiming) it.next());
                    }
                    return;
                }
                return;
            }
            if (strK.startsWith("Format:")) {
                ssaDialogueFormatA = SsaDialogueFormat.a(strK);
            } else if (strK.startsWith("Dialogue:")) {
                if (ssaDialogueFormatA == null) {
                    Log.h("SsaParser", "Skipping dialogue line before complete format: ".concat(strK));
                } else {
                    Assertions.a(strK.startsWith("Dialogue:"));
                    String strSubstring = strK.substring(9);
                    int i11 = ssaDialogueFormatA.f9324e;
                    String[] strArrSplit = strSubstring.split(",", i11);
                    if (strArrSplit.length != i11) {
                        Log.h("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strK));
                    } else {
                        long jF = f(strArrSplit[ssaDialogueFormatA.f9320a]);
                        if (jF == -9223372036854775807L) {
                            Log.h("SsaParser", "Skipping invalid timing: ".concat(strK));
                        } else {
                            long jF2 = f(strArrSplit[ssaDialogueFormatA.f9321b]);
                            if (jF2 == -9223372036854775807L) {
                                Log.h("SsaParser", "Skipping invalid timing: ".concat(strK));
                            } else {
                                LinkedHashMap linkedHashMap = ssaParser.f9329d;
                                charset = charsetF;
                                SsaStyle ssaStyle = (linkedHashMap == null || (i9 = ssaDialogueFormatA.f9322c) == -1) ? null : (SsaStyle) linkedHashMap.get(strArrSplit[i9].trim());
                                String str = strArrSplit[ssaDialogueFormatA.f9323d];
                                Matcher matcher = SsaStyle.Overrides.f9353a.matcher(str);
                                int i12 = -1;
                                PointF pointF = null;
                                while (matcher.find()) {
                                    SsaDialogueFormat ssaDialogueFormat2 = ssaDialogueFormatA;
                                    String strGroup = matcher.group(1);
                                    strGroup.getClass();
                                    try {
                                        PointF pointFA = SsaStyle.Overrides.a(strGroup);
                                        if (pointFA != null) {
                                            pointF = pointFA;
                                        }
                                    } catch (RuntimeException unused) {
                                    }
                                    try {
                                        Matcher matcher2 = SsaStyle.Overrides.f9356d.matcher(strGroup);
                                        if (matcher2.find()) {
                                            String strGroup2 = matcher2.group(1);
                                            strGroup2.getClass();
                                            iA = SsaStyle.a(strGroup2);
                                        } else {
                                            iA = -1;
                                        }
                                        if (iA != -1) {
                                            i12 = iA;
                                        }
                                    } catch (RuntimeException unused2) {
                                    }
                                    ssaDialogueFormatA = ssaDialogueFormat2;
                                }
                                ssaDialogueFormat = ssaDialogueFormatA;
                                String strReplace = SsaStyle.Overrides.f9353a.matcher(str).replaceAll("").replace("\\N", StringUtils.LF).replace("\\n", StringUtils.LF).replace("\\h", " ");
                                float f5 = ssaParser.f9330e;
                                float f6 = ssaParser.f9331f;
                                SpannableString spannableString = new SpannableString(strReplace);
                                Cue.Builder builder = new Cue.Builder();
                                builder.f5625a = spannableString;
                                if (ssaStyle != null) {
                                    Integer num2 = ssaStyle.f9334c;
                                    if (num2 != null) {
                                        parsableByteArray = parsableByteArray2;
                                        f2 = f5;
                                        f3 = f6;
                                        spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                    } else {
                                        parsableByteArray = parsableByteArray2;
                                        f2 = f5;
                                        f3 = f6;
                                    }
                                    if (ssaStyle.f9341j == 3 && (num = ssaStyle.f9335d) != null) {
                                        spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                    }
                                    float f7 = ssaStyle.f9336e;
                                    if (f7 != -3.4028235E38f && f3 != -3.4028235E38f) {
                                        builder.f5635k = f7 / f3;
                                        builder.f5634j = 1;
                                    }
                                    boolean z2 = ssaStyle.f9338g;
                                    boolean z3 = ssaStyle.f9337f;
                                    if (z3 && z2) {
                                        i7 = 0;
                                        i8 = 33;
                                        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                    } else {
                                        i7 = 0;
                                        i8 = 33;
                                        if (z3) {
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        } else if (z2) {
                                            spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                        }
                                    }
                                    if (ssaStyle.f9339h) {
                                        spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                    }
                                    if (ssaStyle.f9340i) {
                                        spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                    }
                                } else {
                                    parsableByteArray = parsableByteArray2;
                                    f2 = f5;
                                    f3 = f6;
                                }
                                int i13 = i12;
                                int i14 = -1;
                                if (i13 != -1) {
                                    i14 = i13;
                                } else if (ssaStyle != null) {
                                    i14 = ssaStyle.f9333b;
                                }
                                switch (i14) {
                                    case 0:
                                    default:
                                        a.r(i14, "Unknown alignment: ", "SsaParser");
                                    case -1:
                                        alignment = null;
                                        break;
                                    case 1:
                                    case 4:
                                    case 7:
                                        alignment = Layout.Alignment.ALIGN_NORMAL;
                                        break;
                                    case 2:
                                    case 5:
                                    case 8:
                                        alignment = Layout.Alignment.ALIGN_CENTER;
                                        break;
                                    case 3:
                                    case 6:
                                    case 9:
                                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                        break;
                                }
                                builder.f5627c = alignment;
                                int i15 = Integer.MIN_VALUE;
                                switch (i14) {
                                    case 0:
                                    default:
                                        a.r(i14, "Unknown alignment: ", "SsaParser");
                                    case -1:
                                        i4 = Integer.MIN_VALUE;
                                        break;
                                    case 1:
                                    case 4:
                                    case 7:
                                        i4 = 0;
                                        break;
                                    case 2:
                                    case 5:
                                    case 8:
                                        i4 = 1;
                                        break;
                                    case 3:
                                    case 6:
                                    case 9:
                                        i4 = 2;
                                        break;
                                }
                                builder.f5633i = i4;
                                switch (i14) {
                                    case -1:
                                        break;
                                    case 0:
                                    default:
                                        a.r(i14, "Unknown alignment: ", "SsaParser");
                                        break;
                                    case 1:
                                    case 2:
                                    case 3:
                                        i15 = 2;
                                        break;
                                    case 4:
                                    case 5:
                                    case 6:
                                        i15 = 1;
                                        break;
                                    case 7:
                                    case 8:
                                    case 9:
                                        i15 = 0;
                                        break;
                                }
                                builder.f5631g = i15;
                                PointF pointF2 = pointF;
                                if (pointF2 == null || f3 == -3.4028235E38f || f2 == -3.4028235E38f) {
                                    int i16 = builder.f5633i;
                                    if (i16 != 0) {
                                        i5 = 1;
                                        if (i16 != 1) {
                                            i6 = 2;
                                            f4 = i16 != 2 ? -3.4028235E38f : 0.95f;
                                        } else {
                                            i6 = 2;
                                            f4 = 0.5f;
                                        }
                                    } else {
                                        i5 = 1;
                                        i6 = 2;
                                        f4 = 0.05f;
                                    }
                                    builder.f5632h = f4;
                                    builder.f5629e = i15 != 0 ? i15 != i5 ? i15 != i6 ? -3.4028235E38f : 0.95f : 0.5f : 0.05f;
                                    builder.f5630f = 0;
                                } else {
                                    builder.f5632h = pointF2.x / f2;
                                    builder.f5629e = pointF2.y / f3;
                                    builder.f5630f = 0;
                                }
                                Cue cueA = builder.a();
                                int iD = d(jF2, arrayList2, arrayList);
                                for (int iD2 = d(jF, arrayList2, arrayList); iD2 < iD; iD2++) {
                                    ((List) arrayList.get(iD2)).add(cueA);
                                }
                                ssaParser = this;
                                charsetF = charset;
                                ssaDialogueFormatA = ssaDialogueFormat;
                                parsableByteArray2 = parsableByteArray;
                            }
                        }
                    }
                }
                charset = charsetF;
                ssaDialogueFormat = ssaDialogueFormatA;
                parsableByteArray = parsableByteArray2;
                ssaParser = this;
                charsetF = charset;
                ssaDialogueFormatA = ssaDialogueFormat;
                parsableByteArray2 = parsableByteArray;
            } else {
                charset = charsetF;
                ssaDialogueFormat = ssaDialogueFormatA;
                parsableByteArray = parsableByteArray2;
                ssaParser = this;
                charsetF = charset;
                ssaDialogueFormatA = ssaDialogueFormat;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(androidx.media3.common.util.ParsableByteArray r38, java.nio.charset.Charset r39) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaParser.e(androidx.media3.common.util.ParsableByteArray, java.nio.charset.Charset):void");
    }

    public SsaParser(List list) throws NumberFormatException {
        this.f9330e = -3.4028235E38f;
        this.f9331f = -3.4028235E38f;
        this.f9328c = new ParsableByteArray();
        if (list == null || list.isEmpty()) {
            this.f9326a = false;
            this.f9327b = null;
            return;
        }
        this.f9326a = true;
        String strP = Util.p((byte[]) list.get(0));
        Assertions.a(strP.startsWith("Format:"));
        SsaDialogueFormat ssaDialogueFormatA = SsaDialogueFormat.a(strP);
        ssaDialogueFormatA.getClass();
        this.f9327b = ssaDialogueFormatA;
        e(new ParsableByteArray((byte[]) list.get(1)), Charsets.f42260c);
    }
}
