package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class NoOpExtractorOutput implements ExtractorOutput {
    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(SeekMap seekMap) {
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        return new DiscardingTrackOutput();
    }
}
