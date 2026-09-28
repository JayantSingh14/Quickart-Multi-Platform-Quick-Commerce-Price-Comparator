package androidx.media3.exoplayer.dash.offline;

import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.BaseUrlExclusionList;
import androidx.media3.exoplayer.dash.DashUtil;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.concurrent.Executor;

@UnstableApi
/* loaded from: classes3.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest> {

    /* renamed from: androidx.media3.exoplayer.dash.offline.DashDownloader$1, reason: invalid class name */
    class AnonymousClass1 extends RunnableFutureTask<ChunkIndex, IOException> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.util.RunnableFutureTask
        public final Object b() {
            Representation representation = null;
            RangedUri rangedUri = representation.f6839e;
            if (rangedUri == null) {
                return null;
            }
            Format format = representation.f6835a;
            String str = format.f5224l;
            SubtitleParser.Factory factory = SubtitleParser.Factory.f9179a;
            BundledChunkExtractor bundledChunkExtractor = new BundledChunkExtractor((str == null || !(str.startsWith("video/webm") || str.startsWith("audio/webm"))) ? new FragmentedMp4Extractor(32, factory) : new MatroskaExtractor(2, factory), 0, format);
            try {
                rangedUri.getClass();
                RangedUri rangedUriM = representation.m();
                if (rangedUriM != null) {
                    RangedUri rangedUriA = rangedUri.a(rangedUriM, ((BaseUrl) representation.f6836b.get(0)).f6785a);
                    if (rangedUriA == null) {
                        DashUtil.b(null, null, bundledChunkExtractor, rangedUri);
                    } else {
                        rangedUriM = rangedUriA;
                    }
                    DashUtil.b(null, null, bundledChunkExtractor, rangedUriM);
                }
                bundledChunkExtractor.release();
                return bundledChunkExtractor.b();
            } catch (Throwable th) {
                bundledChunkExtractor.release();
                throw th;
            }
        }
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        super(mediaItem, new DashManifestParser(), factory, executor);
        new BaseUrlExclusionList();
    }
}
