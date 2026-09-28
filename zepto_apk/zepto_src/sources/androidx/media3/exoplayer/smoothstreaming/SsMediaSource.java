package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.source.SinglePeriodTimeline;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import com.brentvatne.exoplayer.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

@UnstableApi
/* loaded from: classes3.dex */
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final /* synthetic */ int B = 0;
    public MediaItem A;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f7430h;

    /* renamed from: i, reason: collision with root package name */
    public final Uri f7431i;

    /* renamed from: j, reason: collision with root package name */
    public final DataSource.Factory f7432j;

    /* renamed from: k, reason: collision with root package name */
    public final DefaultSsChunkSource.Factory f7433k;

    /* renamed from: l, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f7434l;

    /* renamed from: m, reason: collision with root package name */
    public final CmcdConfiguration f7435m;
    public final DrmSessionManager n;
    public final LoadErrorHandlingPolicy o;
    public final long p;
    public final MediaSourceEventListener.EventDispatcher q;
    public final ParsingLoadable.Parser r;
    public final ArrayList s;
    public DataSource t;
    public Loader u;
    public LoaderErrorThrower v;
    public TransferListener w;
    public long x;
    public SsManifest y;
    public Handler z;

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int f7436j = 0;

        /* renamed from: c, reason: collision with root package name */
        public final DefaultSsChunkSource.Factory f7437c;

        /* renamed from: d, reason: collision with root package name */
        public final DataSource.Factory f7438d;

        /* renamed from: e, reason: collision with root package name */
        public final DefaultCompositeSequenceableLoaderFactory f7439e;

        /* renamed from: f, reason: collision with root package name */
        public a f7440f;

        /* renamed from: g, reason: collision with root package name */
        public DrmSessionManagerProvider f7441g;

        /* renamed from: h, reason: collision with root package name */
        public LoadErrorHandlingPolicy f7442h;

        /* renamed from: i, reason: collision with root package name */
        public final long f7443i;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            mediaItem.f5258b.getClass();
            ParsingLoadable.Parser ssManifestParser = new SsManifestParser();
            List list = mediaItem.f5258b.f5343e;
            ParsingLoadable.Parser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(ssManifestParser, list) : ssManifestParser;
            a aVar = this.f7440f;
            CmcdConfiguration cmcdConfigurationB = aVar == null ? null : ((CmcdConfiguration.Factory) aVar.f15602b).b(mediaItem);
            return new SsMediaSource(mediaItem, this.f7438d, filteringManifestParser, this.f7437c, this.f7439e, cmcdConfigurationB, this.f7441g.a(mediaItem), this.f7442h, this.f7443i);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            Assertions.e(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7441g = drmSessionManagerProvider;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.e(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7442h = loadErrorHandlingPolicy;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void d(boolean z) {
            this.f7437c.f7415c = z;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory e(a aVar) {
            aVar.getClass();
            this.f7440f = aVar;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void f(DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
            this.f7437c.f7414b = defaultSubtitleParserFactory;
        }

        public Factory(DefaultSsChunkSource.Factory factory, DataSource.Factory factory2) {
            this.f7437c = factory;
            this.f7438d = factory2;
            this.f7441g = new DefaultDrmSessionManagerProvider();
            this.f7442h = new DefaultLoadErrorHandlingPolicy();
            this.f7443i = 30000L;
            this.f7439e = new DefaultCompositeSequenceableLoaderFactory();
            factory.f7415c = true;
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.smoothstreaming");
    }

    public SsMediaSource(MediaItem mediaItem, DataSource.Factory factory, ParsingLoadable.Parser parser, DefaultSsChunkSource.Factory factory2, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        this.A = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
        localConfiguration.getClass();
        this.y = null;
        Uri uri = Uri.EMPTY;
        Uri uriWithAppendedPath = localConfiguration.f5339a;
        if (uriWithAppendedPath.equals(uri)) {
            uriWithAppendedPath = null;
        } else {
            String path = uriWithAppendedPath.getPath();
            if (path != null) {
                Matcher matcher = Util.f5754k.matcher(path);
                if (matcher.matches() && matcher.group(1) == null) {
                    uriWithAppendedPath = Uri.withAppendedPath(uriWithAppendedPath, "Manifest");
                }
            }
        }
        this.f7431i = uriWithAppendedPath;
        this.f7432j = factory;
        this.r = parser;
        this.f7433k = factory2;
        this.f7434l = defaultCompositeSequenceableLoaderFactory;
        this.f7435m = cmcdConfiguration;
        this.n = drmSessionManager;
        this.o = loadErrorHandlingPolicy;
        this.p = j2;
        this.q = f0(null);
        this.f7430h = false;
        this.s = new ArrayList();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher eventDispatcherE0 = e0(mediaPeriodId);
        SsManifest ssManifest = this.y;
        TransferListener transferListener = this.w;
        LoaderErrorThrower loaderErrorThrower = this.v;
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(ssManifest, this.f7433k, transferListener, this.f7434l, this.f7435m, this.n, eventDispatcherE0, this.o, eventDispatcherF0, loaderErrorThrower, allocator);
        this.s.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.A;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        SsMediaPeriod ssMediaPeriod = (SsMediaPeriod) mediaPeriod;
        for (ChunkSampleStream chunkSampleStream : ssMediaPeriod.n) {
            chunkSampleStream.z(null);
        }
        ssMediaPeriod.f7428l = null;
        this.s.remove(mediaPeriod);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.A = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
        this.v.c();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.o.getClass();
        this.q.e(loadEventInfo, parsingLoadable.f8185c);
        this.y = (SsManifest) parsingLoadable.f8188f;
        this.x = j2 - j3;
        m0();
        if (this.y.f7447d) {
            this.z.postDelayed(new androidx.constraintlayout.helper.widget.a(this, 3), Math.max(0L, (this.x + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = D().f5258b;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return localConfiguration2 != null && localConfiguration2.f5339a.equals(localConfiguration.f5339a) && localConfiguration2.f5343e.equals(localConfiguration.f5343e) && Util.a(localConfiguration2.f5341c, localConfiguration.f5341c);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.o.getClass();
        this.q.c(loadEventInfo, parsingLoadable.f8185c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        this.w = transferListener;
        Looper looperMyLooper = Looper.myLooper();
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        DrmSessionManager drmSessionManager = this.n;
        drmSessionManager.a(looperMyLooper, playerId);
        drmSessionManager.p();
        if (this.f7430h) {
            this.v = new LoaderErrorThrower.Placeholder();
            m0();
            return;
        }
        this.t = this.f7432j.a();
        Loader loader = new Loader("SsMediaSource");
        this.u = loader;
        this.v = loader;
        this.z = Util.o(null);
        n0();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
        long j4 = parsingLoadable.f8183a;
        StatsDataSource statsDataSource = parsingLoadable.f8186d;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        long jA = this.o.a(new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2));
        Loader.LoadErrorAction loadErrorAction = jA == -9223372036854775807L ? Loader.f8166f : new Loader.LoadErrorAction(0, jA);
        this.q.i(loadEventInfo, parsingLoadable.f8185c, iOException, !loadErrorAction.a());
        return loadErrorAction;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        this.y = this.f7430h ? this.y : null;
        this.t = null;
        this.x = 0L;
        Loader loader = this.u;
        if (loader != null) {
            loader.f(null);
            this.u = null;
        }
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.z = null;
        }
        this.n.release();
    }

    public final void m0() {
        SinglePeriodTimeline singlePeriodTimeline;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.s;
            if (i2 >= arrayList.size()) {
                break;
            }
            SsMediaPeriod ssMediaPeriod = (SsMediaPeriod) arrayList.get(i2);
            SsManifest ssManifest = this.y;
            ssMediaPeriod.f7429m = ssManifest;
            for (ChunkSampleStream chunkSampleStream : ssMediaPeriod.n) {
                ((SsChunkSource) chunkSampleStream.f7870e).e(ssManifest);
            }
            MediaPeriod.Callback callback = ssMediaPeriod.f7428l;
            callback.getClass();
            callback.k(ssMediaPeriod);
            i2++;
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.y.f7449f) {
            if (streamElement.f7465k > 0) {
                long[] jArr = streamElement.o;
                jMax2 = Math.min(jMax2, jArr[0]);
                int i3 = streamElement.f7465k - 1;
                jMax = Math.max(jMax, streamElement.c(i3) + jArr[i3]);
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j2 = this.y.f7447d ? -9223372036854775807L : 0L;
            SsManifest ssManifest2 = this.y;
            boolean z = ssManifest2.f7447d;
            singlePeriodTimeline = new SinglePeriodTimeline(j2, 0L, 0L, 0L, true, z, z, ssManifest2, D());
        } else {
            SsManifest ssManifest3 = this.y;
            if (ssManifest3.f7447d) {
                long j3 = ssManifest3.f7451h;
                if (j3 != -9223372036854775807L && j3 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j3);
                }
                long j4 = jMax2;
                long j5 = jMax - j4;
                long jT = j5 - Util.T(this.p);
                if (jT < 5000000) {
                    jT = Math.min(5000000L, j5 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, j5, j4, jT, true, true, true, this.y, D());
            } else {
                long j6 = ssManifest3.f7450g;
                if (j6 == -9223372036854775807L) {
                    j6 = jMax - jMax2;
                }
                long j7 = j6;
                long j8 = jMax2;
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, -9223372036854775807L, j8 + j7, j7, j8, 0L, true, false, false, this.y, D(), null);
            }
        }
        k0(singlePeriodTimeline);
    }

    public final void n0() {
        if (this.u.b()) {
            return;
        }
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.t, this.f7431i, 4, this.r);
        Loader loader = this.u;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.o;
        int i2 = parsingLoadable.f8185c;
        loader.g(parsingLoadable, this, loadErrorHandlingPolicy.b(i2));
        this.q.k(new LoadEventInfo(parsingLoadable.f8183a, parsingLoadable.f8184b), i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
