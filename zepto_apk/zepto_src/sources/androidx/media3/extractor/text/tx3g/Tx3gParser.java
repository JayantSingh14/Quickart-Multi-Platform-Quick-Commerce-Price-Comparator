package androidx.media3.extractor.text.tx3g;

import android.support.v4.media.b;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
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
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class Tx3gParser implements SubtitleParser {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9425a = new ParsableByteArray();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9426b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9427c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9428d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9429e;

    /* renamed from: f, reason: collision with root package name */
    public final float f9430f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9431g;

    public Tx3gParser(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f9427c = 0;
            this.f9428d = -1;
            this.f9429e = "sans-serif";
            this.f9426b = false;
            this.f9430f = 0.85f;
            this.f9431g = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f9427c = bArr[24];
        this.f9428d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        int length = bArr.length - 43;
        int i2 = Util.f5744a;
        this.f9429e = "Serif".equals(new String(bArr, 43, length, Charsets.f42260c)) ? "serif" : "sans-serif";
        int i3 = bArr[25] * 20;
        this.f9431g = i3;
        boolean z = (bArr[0] & 32) != 0;
        this.f9426b = z;
        if (z) {
            this.f9430f = Util.j(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3, 0.0f, 0.95f);
        } else {
            this.f9430f = 0.85f;
        }
    }

    public static void d(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z = (i2 & 1) != 0;
            boolean z2 = (i2 & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            boolean z3 = (i2 & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        String strV;
        int i4;
        int i5;
        ParsableByteArray parsableByteArray = this.f9425a;
        parsableByteArray.H(i2 + i3, bArr);
        parsableByteArray.J(i2);
        int i6 = 1;
        int i7 = 2;
        int i8 = 0;
        Assertions.a(parsableByteArray.a() >= 2);
        int iD = parsableByteArray.D();
        if (iD == 0) {
            strV = "";
        } else {
            int i9 = parsableByteArray.f5724b;
            Charset charsetF = parsableByteArray.F();
            int i10 = iD - (parsableByteArray.f5724b - i9);
            if (charsetF == null) {
                charsetF = Charsets.f42260c;
            }
            strV = parsableByteArray.v(i10, charsetF);
        }
        if (strV.isEmpty()) {
            consumer.accept(new CuesWithTiming(ImmutableList.r(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strV);
        e(spannableStringBuilder, this.f9427c, 0, 0, spannableStringBuilder.length(), 16711680);
        d(spannableStringBuilder, this.f9428d, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.f9429e;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fJ = this.f9430f;
        while (parsableByteArray.a() >= 8) {
            int i11 = parsableByteArray.f5724b;
            int iJ = parsableByteArray.j();
            int iJ2 = parsableByteArray.j();
            if (iJ2 == 1937013100) {
                Assertions.a(parsableByteArray.a() >= i7 ? i6 : i8);
                int iD2 = parsableByteArray.D();
                int i12 = i8;
                while (i12 < iD2) {
                    Assertions.a(parsableByteArray.a() >= 12 ? i6 : i8);
                    int iD3 = parsableByteArray.D();
                    int iD4 = parsableByteArray.D();
                    parsableByteArray.K(i7);
                    int i13 = i12;
                    int iX = parsableByteArray.x();
                    parsableByteArray.K(i6);
                    int iJ3 = parsableByteArray.j();
                    if (iD4 > spannableStringBuilder.length()) {
                        StringBuilder sbU = b.u(iD4, "Truncating styl end (", ") to cueText.length() (");
                        sbU.append(spannableStringBuilder.length());
                        sbU.append(").");
                        Log.h("Tx3gParser", sbU.toString());
                        iD4 = spannableStringBuilder.length();
                    }
                    if (iD3 >= iD4) {
                        Log.h("Tx3gParser", b.e(iD3, iD4, "Ignoring styl with start (", ") >= end (", ")."));
                        i5 = i13;
                    } else {
                        i5 = i13;
                        int i14 = iD4;
                        e(spannableStringBuilder, iX, this.f9427c, iD3, i14, 0);
                        d(spannableStringBuilder, iJ3, this.f9428d, iD3, i14, 0);
                    }
                    i12 = i5 + 1;
                    i6 = 1;
                    i7 = 2;
                    i8 = 0;
                }
                i4 = i7;
            } else if (iJ2 == 1952608120 && this.f9426b) {
                i4 = 2;
                Assertions.a(parsableByteArray.a() >= 2);
                fJ = Util.j(parsableByteArray.D() / this.f9431g, 0.0f, 0.95f);
            } else {
                i4 = 2;
            }
            parsableByteArray.J(i11 + iJ);
            i7 = i4;
            i6 = 1;
            i8 = 0;
        }
        Cue.Builder builder = new Cue.Builder();
        builder.f5625a = spannableStringBuilder;
        builder.f5629e = fJ;
        builder.f5630f = 0;
        builder.f5631g = 0;
        consumer.accept(new CuesWithTiming(ImmutableList.t(builder.a()), -9223372036854775807L, -9223372036854775807L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 2;
    }
}
