package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultHlsPlaylistParserFactory f7119a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7120b;

    public FilteringHlsPlaylistParserFactory(DefaultHlsPlaylistParserFactory defaultHlsPlaylistParserFactory, List list) {
        this.f7119a = defaultHlsPlaylistParserFactory;
        this.f7120b = list;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory
    public final ParsingLoadable.Parser a() {
        this.f7119a.getClass();
        return new FilteringManifestParser(new HlsPlaylistParser(), this.f7120b);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory
    public final ParsingLoadable.Parser b(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f7119a.getClass();
        return new FilteringManifestParser(new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist), this.f7120b);
    }
}
