package androidx.media3.extractor.amr;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import com.google.common.base.Charsets;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.charset.Charset;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class AmrExtractor implements Extractor {
    public static final int[] n = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] o;
    public static final byte[] p;
    public static final byte[] q;
    public static final int r;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8638a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8639b;

    /* renamed from: c, reason: collision with root package name */
    public long f8640c;

    /* renamed from: d, reason: collision with root package name */
    public int f8641d;

    /* renamed from: e, reason: collision with root package name */
    public int f8642e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8643f;

    /* renamed from: g, reason: collision with root package name */
    public int f8644g;

    /* renamed from: h, reason: collision with root package name */
    public int f8645h;

    /* renamed from: i, reason: collision with root package name */
    public long f8646i;

    /* renamed from: j, reason: collision with root package name */
    public ExtractorOutput f8647j;

    /* renamed from: k, reason: collision with root package name */
    public TrackOutput f8648k;

    /* renamed from: l, reason: collision with root package name */
    public SeekMap f8649l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8650m;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        o = iArr;
        int i2 = Util.f5744a;
        Charset charset = Charsets.f42260c;
        p = "#!AMR\n".getBytes(charset);
        q = "#!AMR-WB\n".getBytes(charset);
        r = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8640c = 0L;
        this.f8641d = 0;
        this.f8642e = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.f8649l;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.f8646i = (Math.max(0L, j2 - ((ConstantBitrateSeekMap) seekMap).f8510b) * 8000000) / r0.f8513e;
                return;
            }
        }
        this.f8646i = 0L;
    }

    public final int b(DefaultExtractorInput defaultExtractorInput) throws ParserException {
        boolean z;
        defaultExtractorInput.f8521f = 0;
        byte[] bArr = this.f8638a;
        defaultExtractorInput.b(bArr, 0, 1, false);
        byte b2 = bArr[0];
        if ((b2 & 131) > 0) {
            throw ParserException.a(null, "Invalid padding bits for frame header " + ((int) b2));
        }
        int i2 = (b2 >> 3) & 15;
        if (i2 >= 0 && i2 <= 15 && (((z = this.f8639b) && (i2 < 10 || i2 > 13)) || (!z && (i2 < 12 || i2 > 14)))) {
            return z ? o[i2] : n[i2];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(this.f8639b ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i2);
        throw ParserException.a(null, sb.toString());
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8647j = extractorOutput;
        this.f8648k = extractorOutput.n(0, 1);
        extractorOutput.m();
    }

    public final boolean d(DefaultExtractorInput defaultExtractorInput) throws EOFException, InterruptedIOException {
        defaultExtractorInput.f8521f = 0;
        byte[] bArr = p;
        byte[] bArr2 = new byte[bArr.length];
        defaultExtractorInput.b(bArr2, 0, bArr.length, false);
        if (Arrays.equals(bArr2, bArr)) {
            this.f8639b = false;
            defaultExtractorInput.i(bArr.length);
            return true;
        }
        defaultExtractorInput.f8521f = 0;
        byte[] bArr3 = q;
        byte[] bArr4 = new byte[bArr3.length];
        defaultExtractorInput.b(bArr4, 0, bArr3.length, false);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f8639b = true;
        defaultExtractorInput.i(bArr3.length);
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return d((DefaultExtractorInput) extractorInput);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r10, androidx.media3.extractor.PositionHolder r11) throws androidx.media3.common.ParserException {
        /*
            r9 = this;
            androidx.media3.extractor.TrackOutput r11 = r9.f8648k
            androidx.media3.common.util.Assertions.h(r11)
            int r11 = androidx.media3.common.util.Util.f5744a
            r11 = r10
            androidx.media3.extractor.DefaultExtractorInput r11 = (androidx.media3.extractor.DefaultExtractorInput) r11
            long r0 = r11.f8519d
            r2 = 0
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 != 0) goto L24
            r11 = r10
            androidx.media3.extractor.DefaultExtractorInput r11 = (androidx.media3.extractor.DefaultExtractorInput) r11
            boolean r11 = r9.d(r11)
            if (r11 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r10 = "Could not find AMR header."
            r11 = 0
            androidx.media3.common.ParserException r10 = androidx.media3.common.ParserException.a(r11, r10)
            throw r10
        L24:
            boolean r11 = r9.f8650m
            r0 = 1
            if (r11 != 0) goto L53
            r9.f8650m = r0
            boolean r11 = r9.f8639b
            if (r11 == 0) goto L32
            java.lang.String r1 = "audio/amr-wb"
            goto L34
        L32:
            java.lang.String r1 = "audio/3gpp"
        L34:
            if (r11 == 0) goto L39
            r11 = 16000(0x3e80, float:2.2421E-41)
            goto L3b
        L39:
            r11 = 8000(0x1f40, float:1.121E-41)
        L3b:
            androidx.media3.extractor.TrackOutput r2 = r9.f8648k
            androidx.media3.common.Format$Builder r3 = new androidx.media3.common.Format$Builder
            r3.<init>()
            java.lang.String r1 = androidx.media3.common.MimeTypes.p(r1)
            r3.f5237l = r1
            int r1 = androidx.media3.extractor.amr.AmrExtractor.r
            r3.f5238m = r1
            r3.z = r0
            r3.A = r11
            android.support.v4.media.a.s(r3, r2)
        L53:
            int r11 = r9.f8642e
            r1 = -1
            if (r11 != 0) goto L77
            r11 = r10
            androidx.media3.extractor.DefaultExtractorInput r11 = (androidx.media3.extractor.DefaultExtractorInput) r11     // Catch: java.io.EOFException -> La1
            int r11 = r9.b(r11)     // Catch: java.io.EOFException -> La1
            r9.f8641d = r11     // Catch: java.io.EOFException -> La1
            r9.f8642e = r11
            int r2 = r9.f8644g
            if (r2 != r1) goto L6e
            r2 = r10
            androidx.media3.extractor.DefaultExtractorInput r2 = (androidx.media3.extractor.DefaultExtractorInput) r2
            long r2 = r2.f8519d
            r9.f8644g = r11
        L6e:
            int r2 = r9.f8644g
            if (r2 != r11) goto L77
            int r11 = r9.f8645h
            int r11 = r11 + r0
            r9.f8645h = r11
        L77:
            androidx.media3.extractor.TrackOutput r11 = r9.f8648k
            int r2 = r9.f8642e
            int r10 = r11.c(r10, r2, r0)
            if (r10 != r1) goto L82
            goto La1
        L82:
            int r11 = r9.f8642e
            int r11 = r11 - r10
            r9.f8642e = r11
            r1 = 0
            if (r11 <= 0) goto L8b
            goto La1
        L8b:
            androidx.media3.extractor.TrackOutput r2 = r9.f8648k
            long r10 = r9.f8646i
            long r3 = r9.f8640c
            long r3 = r3 + r10
            int r6 = r9.f8641d
            r5 = 1
            r7 = 0
            r8 = 0
            r2.f(r3, r5, r6, r7, r8)
            long r10 = r9.f8640c
            r2 = 20000(0x4e20, double:9.8813E-320)
            long r10 = r10 + r2
            r9.f8640c = r10
        La1:
            boolean r10 = r9.f8643f
            if (r10 == 0) goto La6
            goto Lb9
        La6:
            androidx.media3.extractor.SeekMap$Unseekable r10 = new androidx.media3.extractor.SeekMap$Unseekable
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10.<init>(r2)
            r9.f8649l = r10
            androidx.media3.extractor.ExtractorOutput r11 = r9.f8647j
            r11.c(r10)
            r9.f8643f = r0
        Lb9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.amr.AmrExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public AmrExtractor(int i2) {
        this.f8638a = new byte[1];
        this.f8644g = -1;
    }
}
