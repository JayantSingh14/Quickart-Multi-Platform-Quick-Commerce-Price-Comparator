package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public interface ProgressiveMediaExtractor {

    public interface Factory {
    }

    void a(long j2, long j3);

    void b();

    long c();

    int d(PositionHolder positionHolder);

    void e(DataSource dataSource, Uri uri, Map map, long j2, long j3, ExtractorOutput extractorOutput);

    void release();
}
