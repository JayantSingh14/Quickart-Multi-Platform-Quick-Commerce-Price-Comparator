package androidx.media3.exoplayer.offline;

import android.util.SparseArray;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.offline.DashDownloader;
import androidx.media3.exoplayer.hls.offline.HlsDownloader;
import androidx.media3.exoplayer.smoothstreaming.offline.SsDownloader;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultDownloaderFactory implements DownloaderFactory {
    static {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, a(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, a(HlsDownloader.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, a(SsDownloader.class));
        } catch (ClassNotFoundException unused3) {
        }
    }

    public static Constructor a(Class cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(MediaItem.class, CacheDataSource.Factory.class, Executor.class);
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Downloader constructor missing", e2);
        }
    }
}
