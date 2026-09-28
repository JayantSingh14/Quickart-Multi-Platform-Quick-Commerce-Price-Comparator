package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.FilteringHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {

    /* renamed from: h, reason: collision with root package name */
    public final DefaultHlsExtractorFactory f7019h;

    /* renamed from: i, reason: collision with root package name */
    public final DefaultHlsDataSourceFactory f7020i;

    /* renamed from: j, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f7021j;

    /* renamed from: k, reason: collision with root package name */
    public final CmcdConfiguration f7022k;

    /* renamed from: l, reason: collision with root package name */
    public final DrmSessionManager f7023l;

    /* renamed from: m, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7024m;
    public final boolean n;
    public final int o;
    public final DefaultHlsPlaylistTracker p;
    public final long q;
    public MediaItem.LiveConfiguration r;
    public TransferListener s;
    public MediaItem t;

    public static final class Factory implements MediaSourceFactory {
        public static final /* synthetic */ int n = 0;

        /* renamed from: c, reason: collision with root package name */
        public final DefaultHlsDataSourceFactory f7025c;

        /* renamed from: h, reason: collision with root package name */
        public com.brentvatne.exoplayer.a f7030h;

        /* renamed from: i, reason: collision with root package name */
        public DrmSessionManagerProvider f7031i = new DefaultDrmSessionManagerProvider();

        /* renamed from: e, reason: collision with root package name */
        public final DefaultHlsPlaylistParserFactory f7027e = new DefaultHlsPlaylistParserFactory();

        /* renamed from: f, reason: collision with root package name */
        public final p f7028f = DefaultHlsPlaylistTracker.o;

        /* renamed from: d, reason: collision with root package name */
        public final DefaultHlsExtractorFactory f7026d = HlsExtractorFactory.f0;

        /* renamed from: j, reason: collision with root package name */
        public LoadErrorHandlingPolicy f7032j = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: g, reason: collision with root package name */
        public final DefaultCompositeSequenceableLoaderFactory f7029g = new DefaultCompositeSequenceableLoaderFactory();

        /* renamed from: l, reason: collision with root package name */
        public final int f7034l = 1;

        /* renamed from: m, reason: collision with root package name */
        public final long f7035m = -9223372036854775807L;

        /* renamed from: k, reason: collision with root package name */
        public boolean f7033k = true;

        public Factory(DataSource.Factory factory) {
            this.f7025c = new DefaultHlsDataSourceFactory(factory);
            this.f7026d.f6976b = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.media3.exoplayer.hls.playlist.FilteringHlsPlaylistParserFactory] */
        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            mediaItem.f5258b.getClass();
            DefaultHlsPlaylistParserFactory filteringHlsPlaylistParserFactory = this.f7027e;
            List list = mediaItem.f5258b.f5343e;
            if (!list.isEmpty()) {
                filteringHlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(filteringHlsPlaylistParserFactory, list);
            }
            com.brentvatne.exoplayer.a aVar = this.f7030h;
            CmcdConfiguration cmcdConfigurationB = aVar == null ? null : ((CmcdConfiguration.Factory) aVar.f15602b).b(mediaItem);
            DefaultHlsExtractorFactory defaultHlsExtractorFactory = this.f7026d;
            DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory = this.f7029g;
            DrmSessionManager drmSessionManagerA = this.f7031i.a(mediaItem);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7032j;
            this.f7028f.getClass();
            DefaultHlsDataSourceFactory defaultHlsDataSourceFactory = this.f7025c;
            return new HlsMediaSource(mediaItem, defaultHlsDataSourceFactory, defaultHlsExtractorFactory, defaultCompositeSequenceableLoaderFactory, cmcdConfigurationB, drmSessionManagerA, loadErrorHandlingPolicy, new DefaultHlsPlaylistTracker(defaultHlsDataSourceFactory, loadErrorHandlingPolicy, filteringHlsPlaylistParserFactory), this.f7035m, this.f7033k, this.f7034l);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            Assertions.e(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7031i = drmSessionManagerProvider;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.e(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7032j = loadErrorHandlingPolicy;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void d(boolean z) {
            this.f7026d.f6976b = z;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory e(com.brentvatne.exoplayer.a aVar) {
            aVar.getClass();
            this.f7030h = aVar;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final void f(DefaultSubtitleParserFactory defaultSubtitleParserFactory) {
            this.f7026d.f6975a = defaultSubtitleParserFactory;
        }

        public final void g(boolean z) {
            this.f7033k = z;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.hls");
    }

    public HlsMediaSource(MediaItem mediaItem, DefaultHlsDataSourceFactory defaultHlsDataSourceFactory, DefaultHlsExtractorFactory defaultHlsExtractorFactory, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, long j2, boolean z, int i2) {
        this.t = mediaItem;
        this.r = mediaItem.f5259c;
        this.f7020i = defaultHlsDataSourceFactory;
        this.f7019h = defaultHlsExtractorFactory;
        this.f7021j = defaultCompositeSequenceableLoaderFactory;
        this.f7022k = cmcdConfiguration;
        this.f7023l = drmSessionManager;
        this.f7024m = loadErrorHandlingPolicy;
        this.p = defaultHlsPlaylistTracker;
        this.q = j2;
        this.n = z;
        this.o = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HlsMediaPlaylist.Part m0(ImmutableList immutableList, long j2) {
        HlsMediaPlaylist.Part part = null;
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            HlsMediaPlaylist.Part part2 = (HlsMediaPlaylist.Part) immutableList.get(i2);
            long j3 = part2.f7142e;
            if (j3 > j2 || !part2.f7131l) {
                if (j3 > j2) {
                    break;
                }
            } else {
                part = part2;
            }
        }
        return part;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher eventDispatcherE0 = e0(mediaPeriodId);
        TransferListener transferListener = this.s;
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        return new HlsMediaPeriod(this.f7019h, this.p, this.f7020i, transferListener, this.f7022k, this.f7023l, eventDispatcherE0, this.f7024m, eventDispatcherF0, allocator, this.f7021j, this.n, this.o, playerId);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.t;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        HlsMediaPeriod hlsMediaPeriod = (HlsMediaPeriod) mediaPeriod;
        hlsMediaPeriod.f7006b.f7097e.remove(hlsMediaPeriod);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsMediaPeriod.u) {
            if (hlsSampleStreamWrapper.D) {
                for (HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : hlsSampleStreamWrapper.v) {
                    hlsSampleQueue.i();
                    DrmSession drmSession = hlsSampleQueue.f7699h;
                    if (drmSession != null) {
                        drmSession.f(hlsSampleQueue.f7696e);
                        hlsSampleQueue.f7699h = null;
                        hlsSampleQueue.f7698g = null;
                    }
                }
            }
            HlsChunkSource hlsChunkSource = hlsSampleStreamWrapper.f7042d;
            hlsChunkSource.f6984g.a(hlsChunkSource.f6982e[hlsChunkSource.r.q()]);
            hlsChunkSource.o = null;
            hlsSampleStreamWrapper.f7048j.f(hlsSampleStreamWrapper);
            hlsSampleStreamWrapper.r.removeCallbacksAndMessages(null);
            hlsSampleStreamWrapper.H = true;
            hlsSampleStreamWrapper.s.clear();
        }
        hlsMediaPeriod.r = null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.t = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() throws IOException {
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.p;
        Loader loader = defaultHlsPlaylistTracker.f7099g;
        if (loader != null) {
            loader.c();
        }
        Uri uri = defaultHlsPlaylistTracker.f7103k;
        if (uri != null) {
            defaultHlsPlaylistTracker.f(uri);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem mediaItemD = D();
        MediaItem.LocalConfiguration localConfiguration = mediaItemD.f5258b;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return localConfiguration2 != null && localConfiguration2.f5339a.equals(localConfiguration.f5339a) && localConfiguration2.f5343e.equals(localConfiguration.f5343e) && Util.a(localConfiguration2.f5341c, localConfiguration.f5341c) && mediaItemD.f5259c.equals(mediaItem.f5259c);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        this.s = transferListener;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        DrmSessionManager drmSessionManager = this.f7023l;
        drmSessionManager.a(looperMyLooper, playerId);
        drmSessionManager.p();
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(null);
        MediaItem.LocalConfiguration localConfiguration = D().f5258b;
        localConfiguration.getClass();
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this.p;
        defaultHlsPlaylistTracker.getClass();
        defaultHlsPlaylistTracker.f7100h = Util.o(null);
        defaultHlsPlaylistTracker.f7098f = eventDispatcherF0;
        defaultHlsPlaylistTracker.f7101i = this;
        ParsingLoadable parsingLoadable = new ParsingLoadable(defaultHlsPlaylistTracker.f7093a.f6973a.a(), localConfiguration.f5339a, 4, defaultHlsPlaylistTracker.f7094b.a());
        Assertions.g(defaultHlsPlaylistTracker.f7099g == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        defaultHlsPlaylistTracker.f7099g = loader;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = defaultHlsPlaylistTracker.f7095c;
        int i2 = parsingLoadable.f8185c;
        loader.g(parsingLoadable, defaultHlsPlaylistTracker, loadErrorHandlingPolicy.b(i2));
        eventDispatcherF0.k(new LoadEventInfo(parsingLoadable.f8183a, parsingLoadable.f8184b), i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        this.p.h();
        this.f7023l.release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0111 A[PHI: r2
      0x0111: PHI (r2v42 long) = (r2v34 long), (r2v36 long), (r2v37 long), (r2v38 long) binds: [B:62:0x010f, B:74:0x0141, B:73:0x013e, B:67:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r39) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.n0(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist):void");
    }
}
