package androidx.media3.exoplayer.smoothstreaming.offline;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;

@UnstableApi
/* loaded from: classes3.dex */
public final class SsDownloader extends SegmentDownloader<SsManifest> {
    /* JADX WARN: Illegal instructions before constructor call */
    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        MediaItem.Builder builderA = mediaItem.a();
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        localConfiguration.getClass();
        Uri uriWithAppendedPath = localConfiguration.f5339a;
        String path = uriWithAppendedPath.getPath();
        if (path != null) {
            Matcher matcher = Util.f5754k.matcher(path);
            if (matcher.matches() && matcher.group(1) == null) {
                uriWithAppendedPath = Uri.withAppendedPath(uriWithAppendedPath, "Manifest");
            }
        }
        builderA.f5267b = uriWithAppendedPath;
        super(builderA.a(), new SsManifestParser(), factory, executor);
    }
}
