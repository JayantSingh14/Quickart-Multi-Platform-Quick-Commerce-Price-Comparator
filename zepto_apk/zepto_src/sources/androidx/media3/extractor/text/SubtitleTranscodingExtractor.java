package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;

@UnstableApi
/* loaded from: classes3.dex */
public class SubtitleTranscodingExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final Extractor f9183a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultSubtitleParserFactory f9184b;

    /* renamed from: c, reason: collision with root package name */
    public SubtitleTranscodingExtractorOutput f9185c;

    public SubtitleTranscodingExtractor(Extractor extractor, DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
        this.f9183a = extractor;
        this.f9184b = defaultSubtitleParserFactory;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = this.f9185c;
        if (subtitleTranscodingExtractorOutput != null) {
            int i2 = 0;
            while (true) {
                SparseArray sparseArray = subtitleTranscodingExtractorOutput.f9188c;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                SubtitleParser subtitleParser = ((SubtitleTranscodingTrackOutput) sparseArray.valueAt(i2)).f9196h;
                if (subtitleParser != null) {
                    subtitleParser.reset();
                }
                i2++;
            }
        }
        this.f9183a.a(j2, j3);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f9184b);
        this.f9185c = subtitleTranscodingExtractorOutput;
        this.f9183a.c(subtitleTranscodingExtractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final Extractor e() {
        return this.f9183a;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return this.f9183a.h(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f9183a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        this.f9183a.release();
    }
}
