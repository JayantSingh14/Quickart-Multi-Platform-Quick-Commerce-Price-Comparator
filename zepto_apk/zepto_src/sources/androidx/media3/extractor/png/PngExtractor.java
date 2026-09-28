package androidx.media3.extractor.png;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import com.reactnativecommunity.clipboard.ClipboardModule;

@UnstableApi
/* loaded from: classes3.dex */
public final class PngExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final SingleSampleExtractor f9154a = new SingleSampleExtractor(35152, 2, ClipboardModule.MIMETYPE_PNG);

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9154a.a(j2, j3);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9154a.c(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return this.f9154a.h(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f9154a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
