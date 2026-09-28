package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Mp4Extractor;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes3.dex */
final class JpegMotionPhotoExtractor implements Extractor {

    /* renamed from: b, reason: collision with root package name */
    public ExtractorOutput f8743b;

    /* renamed from: c, reason: collision with root package name */
    public int f8744c;

    /* renamed from: d, reason: collision with root package name */
    public int f8745d;

    /* renamed from: e, reason: collision with root package name */
    public int f8746e;

    /* renamed from: g, reason: collision with root package name */
    public MotionPhotoMetadata f8748g;

    /* renamed from: h, reason: collision with root package name */
    public DefaultExtractorInput f8749h;

    /* renamed from: i, reason: collision with root package name */
    public StartOffsetExtractorInput f8750i;

    /* renamed from: j, reason: collision with root package name */
    public Mp4Extractor f8751j;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8742a = new ParsableByteArray(6);

    /* renamed from: f, reason: collision with root package name */
    public long f8747f = -1;

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f8744c = 0;
            this.f8751j = null;
        } else if (this.f8744c == 5) {
            Mp4Extractor mp4Extractor = this.f8751j;
            mp4Extractor.getClass();
            mp4Extractor.a(j2, j3);
        }
    }

    public final void b() {
        ExtractorOutput extractorOutput = this.f8743b;
        extractorOutput.getClass();
        extractorOutput.m();
        this.f8743b.c(new SeekMap.Unseekable(-9223372036854775807L));
        this.f8744c = 6;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8743b = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        ParsableByteArray parsableByteArray = this.f8742a;
        parsableByteArray.G(2);
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 2, false);
        if (parsableByteArray.D() == 65496) {
            parsableByteArray.G(2);
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 2, false);
            int iD = parsableByteArray.D();
            this.f8745d = iD;
            if (iD == 65504) {
                parsableByteArray.G(2);
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 2, false);
                defaultExtractorInput.l(parsableByteArray.D() - 2, false);
                parsableByteArray.G(2);
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 2, false);
                this.f8745d = parsableByteArray.D();
            }
            if (this.f8745d == 65505) {
                defaultExtractorInput.l(2, false);
                parsableByteArray.G(6);
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 6, false);
                if (parsableByteArray.z() == 1165519206 && parsableByteArray.D() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0191  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r28, androidx.media3.extractor.PositionHolder r29) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.jpeg.JpegMotionPhotoExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        Mp4Extractor mp4Extractor = this.f8751j;
        if (mp4Extractor != null) {
            mp4Extractor.getClass();
        }
    }
}
