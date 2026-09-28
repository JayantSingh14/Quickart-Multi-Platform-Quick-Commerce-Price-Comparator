package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;

@UnstableApi
/* loaded from: classes3.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {

    /* renamed from: h, reason: collision with root package name */
    public final DataSource.Factory f7669h;

    /* renamed from: i, reason: collision with root package name */
    public final k f7670i;

    /* renamed from: j, reason: collision with root package name */
    public final DrmSessionManager f7671j;

    /* renamed from: k, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7672k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7673l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7674m = true;
    public long n = -9223372036854775807L;
    public boolean o;
    public boolean p;
    public TransferListener q;
    public MediaItem r;

    /* renamed from: androidx.media3.exoplayer.source.ProgressiveMediaSource$1, reason: invalid class name */
    class AnonymousClass1 extends ForwardingTimeline {
        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            super.f(i2, period, z);
            period.f5480f = true;
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            super.m(i2, window, j2);
            window.f5496k = true;
            return window;
        }
    }

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f7675h = 0;

        /* renamed from: c, reason: collision with root package name */
        public final DataSource.Factory f7676c;

        /* renamed from: d, reason: collision with root package name */
        public final k f7677d;

        /* renamed from: e, reason: collision with root package name */
        public DrmSessionManagerProvider f7678e;

        /* renamed from: f, reason: collision with root package name */
        public LoadErrorHandlingPolicy f7679f;

        /* renamed from: g, reason: collision with root package name */
        public final int f7680g;

        public Factory(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource a(MediaItem mediaItem) {
            mediaItem.f5258b.getClass();
            return new ProgressiveMediaSource(mediaItem, this.f7676c, this.f7677d, this.f7678e.a(mediaItem), this.f7679f, this.f7680g);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            Assertions.e(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7678e = drmSessionManagerProvider;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public final MediaSource.Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            Assertions.e(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            this.f7679f = loadErrorHandlingPolicy;
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            k kVar = new k(extractorsFactory);
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.f7676c = factory;
            this.f7677d = kVar;
            this.f7678e = defaultDrmSessionManagerProvider;
            this.f7679f = defaultLoadErrorHandlingPolicy;
            this.f7680g = 1048576;
        }
    }

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, k kVar, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
        this.r = mediaItem;
        this.f7669h = factory;
        this.f7670i = kVar;
        this.f7671j = drmSessionManager;
        this.f7672k = loadErrorHandlingPolicy;
        this.f7673l = i2;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        DataSource dataSourceA = this.f7669h.a();
        TransferListener transferListener = this.q;
        if (transferListener != null) {
            dataSourceA.a(transferListener);
        }
        MediaItem.LocalConfiguration localConfiguration = D().f5258b;
        localConfiguration.getClass();
        Assertions.h(this.f7501g);
        k kVar = this.f7670i;
        kVar.getClass();
        int i2 = Factory.f7675h;
        BundledExtractorsAdapter bundledExtractorsAdapter = new BundledExtractorsAdapter(kVar.f7919a);
        DrmSessionEventListener.EventDispatcher eventDispatcherE0 = e0(mediaPeriodId);
        MediaSourceEventListener.EventDispatcher eventDispatcherF0 = f0(mediaPeriodId);
        long jT = Util.T(localConfiguration.f5346h);
        return new ProgressiveMediaPeriod(localConfiguration.f5339a, dataSourceA, bundledExtractorsAdapter, this.f7671j, eventDispatcherE0, this.f7672k, eventDispatcherF0, this, allocator, localConfiguration.f5344f, this.f7673l, jT);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.r;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) mediaPeriod;
        if (progressiveMediaPeriod.w) {
            for (SampleQueue sampleQueue : progressiveMediaPeriod.t) {
                sampleQueue.i();
                DrmSession drmSession = sampleQueue.f7699h;
                if (drmSession != null) {
                    drmSession.f(sampleQueue.f7696e);
                    sampleQueue.f7699h = null;
                    sampleQueue.f7698g = null;
                }
            }
        }
        progressiveMediaPeriod.f7645l.f(progressiveMediaPeriod);
        progressiveMediaPeriod.q.removeCallbacksAndMessages(null);
        progressiveMediaPeriod.r = null;
        progressiveMediaPeriod.Q = true;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.r = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = D().f5258b;
        localConfiguration.getClass();
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return localConfiguration2 != null && localConfiguration2.f5339a.equals(localConfiguration.f5339a) && localConfiguration2.f5346h == localConfiguration.f5346h && Util.a(localConfiguration2.f5344f, localConfiguration.f5344f);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        this.q = transferListener;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        DrmSessionManager drmSessionManager = this.f7671j;
        drmSessionManager.a(looperMyLooper, playerId);
        drmSessionManager.p();
        m0();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        this.f7671j.release();
    }

    public final void m0() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.n, this.o, this.p, D());
        if (this.f7674m) {
            singlePeriodTimeline = new AnonymousClass1(singlePeriodTimeline);
        }
        k0(singlePeriodTimeline);
    }

    public final void n0(long j2, boolean z, boolean z2) {
        if (j2 == -9223372036854775807L) {
            j2 = this.n;
        }
        if (!this.f7674m && this.n == j2 && this.o == z && this.p == z2) {
            return;
        }
        this.n = j2;
        this.o = z;
        this.p = z2;
        this.f7674m = false;
        m0();
    }
}
