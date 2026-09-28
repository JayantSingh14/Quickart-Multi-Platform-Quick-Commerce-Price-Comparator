package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class AdtsExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final AdtsReader f9516a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9517b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9518c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableBitArray f9519d;

    /* renamed from: e, reason: collision with root package name */
    public ExtractorOutput f9520e;

    /* renamed from: f, reason: collision with root package name */
    public long f9521f;

    /* renamed from: g, reason: collision with root package name */
    public long f9522g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9523h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9524i;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9523h = false;
        this.f9516a.c();
        this.f9521f = j3;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9520e = extractorOutput;
        this.f9516a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        int i2 = 0;
        while (true) {
            ParsableByteArray parsableByteArray = this.f9518c;
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 10, false);
            parsableByteArray.J(0);
            if (parsableByteArray.A() != 4801587) {
                break;
            }
            parsableByteArray.K(3);
            int iW = parsableByteArray.w();
            i2 += iW + 10;
            defaultExtractorInput.l(iW, false);
        }
        defaultExtractorInput.f8521f = 0;
        defaultExtractorInput.l(i2, false);
        if (this.f9522g == -1) {
            this.f9522g = i2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        do {
            ParsableByteArray parsableByteArray2 = this.f9518c;
            defaultExtractorInput.b(parsableByteArray2.f5723a, 0, 2, false);
            parsableByteArray2.J(0);
            if ((parsableByteArray2.D() & 65526) == 65520) {
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                defaultExtractorInput.b(parsableByteArray2.f5723a, 0, 4, false);
                ParsableBitArray parsableBitArray = this.f9519d;
                parsableBitArray.m(14);
                int iG = parsableBitArray.g(13);
                if (iG <= 6) {
                    i3++;
                    defaultExtractorInput.f8521f = 0;
                    defaultExtractorInput.l(i3, false);
                } else {
                    defaultExtractorInput.l(iG - 6, false);
                    i5 += iG;
                }
            } else {
                i3++;
                defaultExtractorInput.f8521f = 0;
                defaultExtractorInput.l(i3, false);
            }
            i4 = 0;
            i5 = 0;
        } while (i3 - i2 < 8192);
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException, EOFException, InterruptedIOException {
        Assertions.h(this.f9520e);
        long j2 = ((DefaultExtractorInput) extractorInput).f8518c;
        ParsableByteArray parsableByteArray = this.f9517b;
        int i2 = ((DefaultExtractorInput) extractorInput).read(parsableByteArray.f5723a, 0, 2048);
        boolean z = i2 == -1;
        if (!this.f9524i) {
            this.f9520e.c(new SeekMap.Unseekable(-9223372036854775807L));
            this.f9524i = true;
        }
        if (z) {
            return -1;
        }
        parsableByteArray.J(0);
        parsableByteArray.I(i2);
        boolean z2 = this.f9523h;
        AdtsReader adtsReader = this.f9516a;
        if (!z2) {
            adtsReader.t = this.f9521f;
            this.f9523h = true;
        }
        adtsReader.a(parsableByteArray);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public AdtsExtractor(int i2) {
        this.f9516a = new AdtsReader(null, 0, true);
        this.f9517b = new ParsableByteArray(2048);
        this.f9522g = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f9518c = parsableByteArray;
        byte[] bArr = parsableByteArray.f5723a;
        this.f9519d = new ParsableBitArray(bArr, bArr.length);
    }
}
