package androidx.media3.exoplayer.source.chunk;

import android.media.MediaParser;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaParserChunkExtractor implements ChunkExtractor {

    /* renamed from: a, reason: collision with root package name */
    public long f7892a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkExtractor.TrackOutputProvider f7893b;

    /* renamed from: c, reason: collision with root package name */
    public Format[] f7894c;

    public class TrackOutputProviderAdapter implements ExtractorOutput {
        @Override // androidx.media3.extractor.ExtractorOutput
        public final void c(SeekMap seekMap) {
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final void m() {
            throw null;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final TrackOutput n(int i2, int i3) {
            throw null;
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final boolean a(DefaultExtractorInput defaultExtractorInput) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final ChunkIndex b() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final Format[] d() {
        return this.f7894c;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final void e(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f7893b = trackOutputProvider;
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final void release() {
        ((MediaParser) null).release();
    }
}
