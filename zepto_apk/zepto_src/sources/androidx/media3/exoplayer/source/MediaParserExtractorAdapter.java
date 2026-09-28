package androidx.media3.exoplayer.source;

import android.media.MediaParser;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a, reason: collision with root package name */
    public String f7607a;

    public static final class Factory implements ProgressiveMediaExtractor.Factory {
        static {
            new HashMap();
        }
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void a(long j2, long j3) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void b() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f7607a)) {
            throw null;
        }
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final long c() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final int d(PositionHolder positionHolder) throws IOException {
        ((MediaParser) null).advance(null);
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void e(DataSource dataSource, Uri uri, Map map, long j2, long j3, ExtractorOutput extractorOutput) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void release() {
        ((MediaParser) null).release();
    }
}
