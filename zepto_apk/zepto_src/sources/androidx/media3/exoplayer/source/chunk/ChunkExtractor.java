package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
/* loaded from: classes3.dex */
public interface ChunkExtractor {

    public interface Factory {
    }

    public interface TrackOutputProvider {
        TrackOutput a(int i2);
    }

    boolean a(DefaultExtractorInput defaultExtractorInput);

    ChunkIndex b();

    Format[] d();

    void e(TrackOutputProvider trackOutputProvider, long j2, long j3);

    void release();
}
