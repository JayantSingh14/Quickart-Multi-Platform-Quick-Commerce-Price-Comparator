package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.ParsingLoadable;

@UnstableApi
/* loaded from: classes3.dex */
public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser a();

    ParsingLoadable.Parser b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist);
}
