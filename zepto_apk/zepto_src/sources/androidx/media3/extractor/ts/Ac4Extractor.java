package androidx.media3.extractor.ts;

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

@UnstableApi
/* loaded from: classes3.dex */
public final class Ac4Extractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final Ac4Reader f9500a = new Ac4Reader();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9501b = new ParsableByteArray(16384);

    /* renamed from: c, reason: collision with root package name */
    public boolean f9502c;

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9502c = false;
        this.f9500a.c();
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9500a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.m();
        extractorOutput.c(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int i2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i3 = 0;
        while (true) {
            defaultExtractorInput = (DefaultExtractorInput) extractorInput;
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 10, false);
            parsableByteArray.J(0);
            if (parsableByteArray.A() != 4801587) {
                break;
            }
            parsableByteArray.K(3);
            int iW = parsableByteArray.w();
            i3 += iW + 10;
            defaultExtractorInput.l(iW, false);
        }
        defaultExtractorInput.f8521f = 0;
        defaultExtractorInput.l(i3, false);
        int i4 = 0;
        int i5 = i3;
        while (true) {
            int i6 = 7;
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 7, false);
            parsableByteArray.J(0);
            int iD = parsableByteArray.D();
            if (iD == 44096 || iD == 44097) {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.f5723a;
                if (bArr.length < 7) {
                    i2 = -1;
                } else {
                    int i7 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i7 == 65535) {
                        i7 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i6 = 4;
                    }
                    if (iD == 44097) {
                        i6 += 2;
                    }
                    i2 = i7 + i6;
                }
                if (i2 == -1) {
                    break;
                }
                defaultExtractorInput.l(i2 - 7, false);
            } else {
                defaultExtractorInput.f8521f = 0;
                i5++;
                if (i5 - i3 >= 8192) {
                    break;
                }
                defaultExtractorInput.l(i5, false);
                i4 = 0;
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws EOFException, InterruptedIOException {
        ParsableByteArray parsableByteArray = this.f9501b;
        int i2 = ((DefaultExtractorInput) extractorInput).read(parsableByteArray.f5723a, 0, 16384);
        if (i2 == -1) {
            return -1;
        }
        parsableByteArray.J(0);
        parsableByteArray.I(i2);
        boolean z = this.f9502c;
        Ac4Reader ac4Reader = this.f9500a;
        if (!z) {
            ac4Reader.f9515m = 0L;
            this.f9502c = true;
        }
        ac4Reader.a(parsableByteArray);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
