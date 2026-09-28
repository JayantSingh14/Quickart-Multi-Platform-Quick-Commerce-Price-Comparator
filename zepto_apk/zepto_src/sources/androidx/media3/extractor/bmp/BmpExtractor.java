package androidx.media3.extractor.bmp;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

@UnstableApi
/* loaded from: classes3.dex */
public final class BmpExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final SingleSampleExtractor f8695a = new SingleSampleExtractor(16973, 2, "image/bmp");

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8695a.a(j2, j3);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8695a.c(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return this.f8695a.h(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f8695a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
