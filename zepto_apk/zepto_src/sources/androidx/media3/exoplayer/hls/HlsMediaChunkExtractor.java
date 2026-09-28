package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;

@UnstableApi
/* loaded from: classes3.dex */
public interface HlsMediaChunkExtractor {
    boolean a(DefaultExtractorInput defaultExtractorInput);

    void c(ExtractorOutput extractorOutput);

    void d();

    boolean e();

    boolean f();

    HlsMediaChunkExtractor g();
}
