package androidx.media3.exoplayer.smoothstreaming;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

@UnstableApi
/* loaded from: classes3.dex */
public interface SsChunkSource extends ChunkSource {

    public interface Factory {
    }

    void a(ExoTrackSelection exoTrackSelection);

    void e(SsManifest ssManifest);
}
