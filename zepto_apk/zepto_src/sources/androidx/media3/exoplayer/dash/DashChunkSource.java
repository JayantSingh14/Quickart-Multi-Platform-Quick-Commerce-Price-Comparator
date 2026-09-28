package androidx.media3.exoplayer.dash;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

@UnstableApi
/* loaded from: classes3.dex */
public interface DashChunkSource extends ChunkSource {

    public interface Factory {
    }

    void a(ExoTrackSelection exoTrackSelection);

    void f(DashManifest dashManifest, int i2);
}
