package androidx.media3.extractor.avif;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import java.io.EOFException;
import java.io.InterruptedIOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class AvifExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8693a = new ParsableByteArray(4);

    /* renamed from: b, reason: collision with root package name */
    public final SingleSampleExtractor f8694b = new SingleSampleExtractor(-1, -1, "image/avif");

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8694b.a(j2, j3);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8694b.c(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.l(4, false);
        ParsableByteArray parsableByteArray = this.f8693a;
        parsableByteArray.G(4);
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
        if (parsableByteArray.z() == 1718909296) {
            parsableByteArray.G(4);
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
            if (parsableByteArray.z() == 1635150182) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f8694b.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
