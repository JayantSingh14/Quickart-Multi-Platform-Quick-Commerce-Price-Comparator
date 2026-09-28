package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.VorbisUtil;

@UnstableApi
/* loaded from: classes3.dex */
public class OggExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public ExtractorOutput f9119a;

    /* renamed from: b, reason: collision with root package name */
    public StreamReader f9120b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9121c;

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        StreamReader streamReader = this.f9120b;
        if (streamReader != null) {
            OggPacket oggPacket = streamReader.f9134a;
            OggPageHeader oggPageHeader = oggPacket.f9122a;
            oggPageHeader.f9127a = 0;
            oggPageHeader.f9128b = 0L;
            oggPageHeader.f9129c = 0;
            oggPageHeader.f9130d = 0;
            oggPageHeader.f9131e = 0;
            oggPacket.f9123b.G(0);
            oggPacket.f9124c = -1;
            oggPacket.f9126e = false;
            if (j2 == 0) {
                streamReader.d(!streamReader.f9145l);
                return;
            }
            if (streamReader.f9141h != 0) {
                long j4 = (streamReader.f9142i * j3) / 1000000;
                streamReader.f9138e = j4;
                OggSeeker oggSeeker = streamReader.f9137d;
                int i2 = Util.f5744a;
                oggSeeker.c(j4);
                streamReader.f9141h = 2;
            }
        }
    }

    public final boolean b(DefaultExtractorInput defaultExtractorInput) {
        boolean zD;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(defaultExtractorInput, true) && (oggPageHeader.f9127a & 2) == 2) {
            int iMin = Math.min(oggPageHeader.f9131e, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, iMin, false);
            parsableByteArray.J(0);
            if (parsableByteArray.a() >= 5 && parsableByteArray.x() == 127 && parsableByteArray.z() == 1179402563) {
                this.f9120b = new FlacReader();
                return true;
            }
            parsableByteArray.J(0);
            try {
                zD = VorbisUtil.d(1, parsableByteArray, true);
            } catch (ParserException unused) {
                zD = false;
            }
            if (zD) {
                this.f9120b = new VorbisReader();
            } else {
                parsableByteArray.J(0);
                if (OpusReader.e(parsableByteArray, OpusReader.o)) {
                    this.f9120b = new OpusReader();
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9119a = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        try {
            return b((DefaultExtractorInput) extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016f  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r20, androidx.media3.extractor.PositionHolder r21) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ogg.OggExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
