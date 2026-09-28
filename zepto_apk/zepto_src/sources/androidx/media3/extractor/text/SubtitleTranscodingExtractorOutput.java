package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;

@UnstableApi
/* loaded from: classes3.dex */
public final class SubtitleTranscodingExtractorOutput implements ExtractorOutput {

    /* renamed from: a, reason: collision with root package name */
    public final ExtractorOutput f9186a;

    /* renamed from: b, reason: collision with root package name */
    public final SubtitleParser.Factory f9187b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f9188c = new SparseArray();

    public SubtitleTranscodingExtractorOutput(ExtractorOutput extractorOutput, SubtitleParser.Factory factory) {
        this.f9186a = extractorOutput;
        this.f9187b = factory;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(SeekMap seekMap) {
        this.f9186a.c(seekMap);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
        this.f9186a.m();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        ExtractorOutput extractorOutput = this.f9186a;
        if (i3 != 3) {
            return extractorOutput.n(i2, i3);
        }
        SparseArray sparseArray = this.f9188c;
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = (SubtitleTranscodingTrackOutput) sparseArray.get(i2);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(extractorOutput.n(i2, i3), this.f9187b);
        sparseArray.put(i2, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }
}
