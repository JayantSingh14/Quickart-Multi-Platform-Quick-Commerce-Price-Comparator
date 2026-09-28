package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.TrackOutput;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public class SubtitleExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final SubtitleParser f9163a;

    /* renamed from: c, reason: collision with root package name */
    public final Format f9165c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f9166d;

    /* renamed from: g, reason: collision with root package name */
    public TrackOutput f9169g;

    /* renamed from: h, reason: collision with root package name */
    public int f9170h;

    /* renamed from: i, reason: collision with root package name */
    public int f9171i;

    /* renamed from: j, reason: collision with root package name */
    public long[] f9172j;

    /* renamed from: k, reason: collision with root package name */
    public long f9173k;

    /* renamed from: b, reason: collision with root package name */
    public final CueEncoder f9164b = new CueEncoder();

    /* renamed from: f, reason: collision with root package name */
    public byte[] f9168f = Util.f5749f;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f9167e = new ParsableByteArray();

    public static class Sample implements Comparable<Sample> {

        /* renamed from: a, reason: collision with root package name */
        public final long f9174a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f9175b;

        public Sample(long j2, byte[] bArr) {
            this.f9174a = j2;
            this.f9175b = bArr;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Sample sample) {
            return Long.compare(this.f9174a, sample.f9174a);
        }
    }

    public SubtitleExtractor(SubtitleParser subtitleParser, Format format) {
        this.f9163a = subtitleParser;
        Format.Builder builderA = format.a();
        builderA.f5237l = MimeTypes.p("application/x-media3-cues");
        builderA.f5234i = format.f5225m;
        builderA.F = subtitleParser.c();
        this.f9165c = new Format(builderA);
        this.f9166d = new ArrayList();
        this.f9171i = 0;
        this.f9172j = Util.f5750g;
        this.f9173k = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        int i2 = this.f9171i;
        Assertions.g((i2 == 0 || i2 == 5) ? false : true);
        this.f9173k = j3;
        if (this.f9171i == 2) {
            this.f9171i = 1;
        }
        if (this.f9171i == 4) {
            this.f9171i = 3;
        }
    }

    public final void b(Sample sample) {
        Assertions.h(this.f9169g);
        byte[] bArr = sample.f9175b;
        int length = bArr.length;
        ParsableByteArray parsableByteArray = this.f9167e;
        parsableByteArray.getClass();
        parsableByteArray.H(bArr.length, bArr);
        this.f9169g.e(length, parsableByteArray);
        this.f9169g.f(sample.f9174a, 1, length, 0, null);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        Assertions.g(this.f9171i == 0);
        TrackOutput trackOutputN = extractorOutput.n(0, 3);
        this.f9169g = trackOutputN;
        trackOutputN.b(this.f9165c);
        extractorOutput.m();
        extractorOutput.c(new IndexSeekMap(-9223372036854775807L, new long[]{0}, new long[]{0}));
        this.f9171i = 1;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0080 A[EXC_TOP_SPLITTER, PHI: r15
      0x0080: PHI (r15v3 long) = (r15v4 long), (r15v5 long) binds: [B:32:0x007e, B:29:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r24, androidx.media3.extractor.PositionHolder r25) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.SubtitleExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        if (this.f9171i == 5) {
            return;
        }
        this.f9163a.reset();
        this.f9171i = 5;
    }
}
