package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* renamed from: a, reason: collision with root package name */
    public final ParsingLoadable.Parser f7386a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f7387b;

    /* renamed from: androidx.media3.exoplayer.offline.SegmentDownloader$1, reason: invalid class name */
    class AnonymousClass1 extends RunnableFutureTask<FilterableManifest<Object>, IOException> {
        @Override // androidx.media3.common.util.RunnableFutureTask
        public final Object b() {
            throw null;
        }
    }

    public static final class ProgressNotifier implements CacheWriter.ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        public long f7388a;

        /* renamed from: b, reason: collision with root package name */
        public int f7389b;

        @Override // androidx.media3.datasource.cache.CacheWriter.ProgressListener
        public final void a(long j2, long j3, long j4) {
            this.f7388a += j4;
            throw null;
        }
    }

    public static class Segment implements Comparable<Segment> {
        @Override // java.lang.Comparable
        public final int compareTo(Segment segment) {
            segment.getClass();
            return Util.i(0L, 0L);
        }
    }

    public static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        @Override // androidx.media3.common.util.RunnableFutureTask
        public final void a() {
            throw null;
        }

        @Override // androidx.media3.common.util.RunnableFutureTask
        public final Object b() {
            throw null;
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser parser, CacheDataSource.Factory factory, Executor executor) {
        mediaItem.f5258b.getClass();
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        Uri uri = localConfiguration.f5339a;
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = uri;
        builder.f5868i = 1;
        builder.a();
        this.f7386a = parser;
        new ArrayList(localConfiguration.f5343e);
        this.f7387b = executor;
        factory.f5974a.getClass();
        new ArrayList();
        Util.T(20000L);
    }
}
