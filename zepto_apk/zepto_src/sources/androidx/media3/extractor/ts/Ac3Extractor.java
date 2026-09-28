package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.EOFException;
import java.io.InterruptedIOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class Ac3Extractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final Ac3Reader f9484a = new Ac3Reader();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9485b = new ParsableByteArray(2786);

    /* renamed from: c, reason: collision with root package name */
    public boolean f9486c;

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9486c = false;
        this.f9484a.c();
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9484a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
        extractorOutput.c(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iA;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i2 = 0;
        while (true) {
            defaultExtractorInput = (DefaultExtractorInput) extractorInput;
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
        int i3 = 0;
        int i4 = i2;
        while (true) {
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 6, false);
            parsableByteArray.J(0);
            if (parsableByteArray.D() != 2935) {
                defaultExtractorInput.f8521f = 0;
                i4++;
                if (i4 - i2 >= 8192) {
                    break;
                }
                defaultExtractorInput.l(i4, false);
                i3 = 0;
            } else {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.f5723a;
                if (bArr.length < 6) {
                    iA = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    iA = ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2;
                } else {
                    byte b2 = bArr[4];
                    iA = Ac3Util.a((b2 & 192) >> 6, b2 & 63);
                }
                if (iA == -1) {
                    break;
                }
                defaultExtractorInput.l(iA - 6, false);
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws EOFException, InterruptedIOException {
        ParsableByteArray parsableByteArray = this.f9485b;
        int i2 = ((DefaultExtractorInput) extractorInput).read(parsableByteArray.f5723a, 0, 2786);
        if (i2 == -1) {
            return -1;
        }
        parsableByteArray.J(0);
        parsableByteArray.I(i2);
        boolean z = this.f9486c;
        Ac3Reader ac3Reader = this.f9484a;
        if (!z) {
            ac3Reader.f9499m = 0L;
            this.f9486c = true;
        }
        ac3Reader.a(parsableByteArray);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
