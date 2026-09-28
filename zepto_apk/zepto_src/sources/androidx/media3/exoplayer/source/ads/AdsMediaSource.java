package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    public static final MediaSource.MediaPeriodId x = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: k, reason: collision with root package name */
    public final MaskingMediaSource f7777k;

    /* renamed from: l, reason: collision with root package name */
    public final MediaItem.DrmConfiguration f7778l;

    /* renamed from: m, reason: collision with root package name */
    public final DefaultMediaSourceFactory f7779m;
    public final AdsLoader n;
    public final AdViewProvider o;
    public final DataSpec p;
    public final Object q;
    public final Handler r;
    public final Timeline.Period s;
    public ComponentListener t;
    public Timeline u;
    public AdPlaybackState v;
    public AdMediaSourceHolder[][] w;

    public static final class AdLoadException extends IOException {

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }
    }

    public final class AdMediaSourceHolder {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f7780a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f7781b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public MediaItem f7782c;

        /* renamed from: d, reason: collision with root package name */
        public MediaSource f7783d;

        /* renamed from: e, reason: collision with root package name */
        public Timeline f7784e;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.f7780a = mediaPeriodId;
        }
    }

    public final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {

        /* renamed from: a, reason: collision with root package name */
        public final MediaItem f7786a;

        public AdPrepareListener(MediaItem mediaItem) {
            this.f7786a = mediaItem;
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public final void a(final MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource adsMediaSource = AdsMediaSource.this;
            MediaSourceEventListener.EventDispatcher eventDispatcherF0 = adsMediaSource.f0(mediaPeriodId);
            long andIncrement = LoadEventInfo.f7578d.getAndIncrement();
            MediaItem.LocalConfiguration localConfiguration = this.f7786a.f5258b;
            localConfiguration.getClass();
            DataSpec dataSpec = new DataSpec(localConfiguration.f5339a);
            SystemClock.elapsedRealtime();
            eventDispatcherF0.i(new LoadEventInfo(andIncrement, dataSpec), 6, new AdLoadException(iOException), true);
            adsMediaSource.r.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource adsMediaSource2 = AdsMediaSource.this;
                    AdsLoader adsLoader = adsMediaSource2.n;
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
                    adsLoader.e(adsMediaSource2, mediaPeriodId2.f7610b, mediaPeriodId2.f7611c, iOException);
                }
            });
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public final void b(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.r.post(new c(0, this, mediaPeriodId));
        }
    }

    public final class ComponentListener implements AdsLoader.EventListener {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f7788a = Util.o(null);

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f7789b;

        public ComponentListener() {
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public final void a(AdPlaybackState adPlaybackState) {
            if (this.f7789b) {
                return;
            }
            this.f7788a.post(new c(1, this, adPlaybackState));
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public final void b(AdLoadException adLoadException, DataSpec dataSpec) {
            if (this.f7789b) {
                return;
            }
            MediaSourceEventListener.EventDispatcher eventDispatcherF0 = AdsMediaSource.this.f0(null);
            long andIncrement = LoadEventInfo.f7578d.getAndIncrement();
            SystemClock.elapsedRealtime();
            eventDispatcherF0.i(new LoadEventInfo(andIncrement, dataSpec), 6, adLoadException, true);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, DefaultMediaSourceFactory defaultMediaSourceFactory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this.f7777k = new MaskingMediaSource(mediaSource, true);
        MediaItem.LocalConfiguration localConfiguration = mediaSource.D().f5258b;
        localConfiguration.getClass();
        this.f7778l = localConfiguration.f5341c;
        this.f7779m = defaultMediaSourceFactory;
        this.n = adsLoader;
        this.o = adViewProvider;
        this.p = dataSpec;
        this.q = obj;
        this.r = new Handler(Looper.getMainLooper());
        this.s = new Timeline.Period();
        this.w = new AdMediaSourceHolder[0][];
        adsLoader.d(defaultMediaSourceFactory.h());
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        AdPlaybackState adPlaybackState = this.v;
        adPlaybackState.getClass();
        if (adPlaybackState.f5125b <= 0 || !mediaPeriodId.b()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
            maskingMediaPeriod.t(this.f7777k);
            maskingMediaPeriod.a(mediaPeriodId);
            return maskingMediaPeriod;
        }
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.w;
        int i2 = mediaPeriodId.f7610b;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i2];
        int length = adMediaSourceHolderArr2.length;
        int i3 = mediaPeriodId.f7611c;
        if (length <= i3) {
            adMediaSourceHolderArr[i2] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i3 + 1);
        }
        AdMediaSourceHolder adMediaSourceHolder = this.w[i2][i3];
        if (adMediaSourceHolder == null) {
            adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
            this.w[i2][i3] = adMediaSourceHolder;
            s0();
        }
        MaskingMediaPeriod maskingMediaPeriod2 = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
        adMediaSourceHolder.f7781b.add(maskingMediaPeriod2);
        MediaSource mediaSource = adMediaSourceHolder.f7783d;
        if (mediaSource != null) {
            maskingMediaPeriod2.t(mediaSource);
            MediaItem mediaItem = adMediaSourceHolder.f7782c;
            mediaItem.getClass();
            maskingMediaPeriod2.f7591g = AdsMediaSource.this.new AdPrepareListener(mediaItem);
        }
        Timeline timeline = adMediaSourceHolder.f7784e;
        if (timeline != null) {
            maskingMediaPeriod2.a(new MediaSource.MediaPeriodId(mediaPeriodId.f7612d, timeline.l(0)));
        }
        return maskingMediaPeriod2;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        return this.f7777k.D();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.f7585a;
        if (!mediaPeriodId.b()) {
            maskingMediaPeriod.n();
            return;
        }
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.w;
        int i2 = mediaPeriodId.f7610b;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i2];
        int i3 = mediaPeriodId.f7611c;
        AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i3];
        adMediaSourceHolder.getClass();
        ArrayList arrayList = adMediaSourceHolder.f7781b;
        arrayList.remove(maskingMediaPeriod);
        maskingMediaPeriod.n();
        if (arrayList.isEmpty()) {
            if (adMediaSourceHolder.f7783d != null) {
                AdsMediaSource.this.r0(adMediaSourceHolder.f7780a);
            }
            this.w[i2][i3] = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void O(MediaItem mediaItem) {
        this.f7777k.O(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MaskingMediaSource maskingMediaSource = this.f7777k;
        MediaItem.LocalConfiguration localConfiguration = maskingMediaSource.f7774k.D().f5258b;
        MediaItem.AdsConfiguration adsConfiguration = localConfiguration == null ? null : localConfiguration.f5342d;
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.f5258b;
        return Util.a(adsConfiguration, localConfiguration2 != null ? localConfiguration2.f5342d : null) && maskingMediaSource.f7774k.c0(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        super.j0(transferListener);
        ComponentListener componentListener = new ComponentListener();
        this.t = componentListener;
        MaskingMediaSource maskingMediaSource = this.f7777k;
        this.u = maskingMediaSource.o;
        q0(x, maskingMediaSource);
        this.r.post(new a(this, componentListener, 0));
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        super.l0();
        ComponentListener componentListener = this.t;
        componentListener.getClass();
        this.t = null;
        componentListener.f7789b = true;
        componentListener.f7788a.removeCallbacksAndMessages(null);
        this.u = null;
        this.v = null;
        this.w = new AdMediaSourceHolder[0][];
        this.r.post(new a(this, componentListener, 1));
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) obj;
        return mediaPeriodId2.b() ? mediaPeriodId2 : mediaPeriodId;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) obj;
        int i2 = 0;
        if (mediaPeriodId.b()) {
            AdMediaSourceHolder adMediaSourceHolder = this.w[mediaPeriodId.f7610b][mediaPeriodId.f7611c];
            adMediaSourceHolder.getClass();
            Assertions.a(timeline.h() == 1);
            if (adMediaSourceHolder.f7784e == null) {
                Object objL = timeline.l(0);
                while (true) {
                    ArrayList arrayList = adMediaSourceHolder.f7781b;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) arrayList.get(i2);
                    maskingMediaPeriod.a(new MediaSource.MediaPeriodId(maskingMediaPeriod.f7585a.f7612d, objL));
                    i2++;
                }
            }
            adMediaSourceHolder.f7784e = timeline;
        } else {
            Assertions.a(timeline.h() == 1);
            this.u = timeline;
        }
        t0();
    }

    public final void s0() {
        MediaItem mediaItemA;
        AdsMediaSource adsMediaSource;
        AdPlaybackState adPlaybackState = this.v;
        if (adPlaybackState == null) {
            return;
        }
        for (int i2 = 0; i2 < this.w.length; i2++) {
            int i3 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr = this.w[i2];
                if (i3 < adMediaSourceHolderArr.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i3];
                    AdPlaybackState.AdGroup adGroupA = adPlaybackState.a(i2);
                    if (adMediaSourceHolder != null && adMediaSourceHolder.f7783d == null) {
                        MediaItem[] mediaItemArr = adGroupA.f5138e;
                        if (i3 < mediaItemArr.length && (mediaItemA = mediaItemArr[i3]) != null) {
                            MediaItem.DrmConfiguration drmConfiguration = this.f7778l;
                            if (drmConfiguration != null) {
                                MediaItem.Builder builderA = mediaItemA.a();
                                builderA.f5270e = drmConfiguration.a();
                                mediaItemA = builderA.a();
                            }
                            MediaSource mediaSourceA = this.f7779m.a(mediaItemA);
                            adMediaSourceHolder.f7783d = mediaSourceA;
                            adMediaSourceHolder.f7782c = mediaItemA;
                            int i4 = 0;
                            while (true) {
                                ArrayList arrayList = adMediaSourceHolder.f7781b;
                                int size = arrayList.size();
                                adsMediaSource = AdsMediaSource.this;
                                if (i4 >= size) {
                                    break;
                                }
                                MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) arrayList.get(i4);
                                maskingMediaPeriod.t(mediaSourceA);
                                maskingMediaPeriod.f7591g = adsMediaSource.new AdPrepareListener(mediaItemA);
                                i4++;
                            }
                            adsMediaSource.q0(adMediaSourceHolder.f7780a, mediaSourceA);
                        }
                    }
                    i3++;
                }
            }
        }
    }

    public final void t0() {
        Timeline timeline;
        Timeline timeline2 = this.u;
        AdPlaybackState adPlaybackState = this.v;
        if (adPlaybackState == null || timeline2 == null) {
            return;
        }
        int i2 = adPlaybackState.f5125b;
        if (i2 == 0) {
            k0(timeline2);
            return;
        }
        long[][] jArr = new long[this.w.length][];
        int i3 = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.w;
            if (i3 >= adMediaSourceHolderArr.length) {
                break;
            }
            jArr[i3] = new long[adMediaSourceHolderArr[i3].length];
            int i4 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.w[i3];
                if (i4 < adMediaSourceHolderArr2.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i4];
                    long[] jArr2 = jArr[i3];
                    long j2 = -9223372036854775807L;
                    if (adMediaSourceHolder != null && (timeline = adMediaSourceHolder.f7784e) != null) {
                        j2 = timeline.f(0, AdsMediaSource.this.s, false).f5478d;
                    }
                    jArr2[i4] = j2;
                    i4++;
                }
            }
            i3++;
        }
        Assertions.g(adPlaybackState.f5128e == 0);
        AdPlaybackState.AdGroup[] adGroupArr = adPlaybackState.f5129f;
        AdPlaybackState.AdGroup[] adGroupArr2 = (AdPlaybackState.AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
        for (int i5 = 0; i5 < i2; i5++) {
            AdPlaybackState.AdGroup adGroup = adGroupArr2[i5];
            long[] jArrCopyOf = jArr[i5];
            adGroup.getClass();
            int length = jArrCopyOf.length;
            MediaItem[] mediaItemArr = adGroup.f5138e;
            if (length < mediaItemArr.length) {
                jArrCopyOf = AdPlaybackState.AdGroup.a(jArrCopyOf, mediaItemArr.length);
            } else if (adGroup.f5135b != -1 && jArrCopyOf.length > mediaItemArr.length) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, mediaItemArr.length);
            }
            adGroupArr2[i5] = new AdPlaybackState.AdGroup(adGroup.f5134a, adGroup.f5135b, adGroup.f5136c, adGroup.f5139f, adGroup.f5138e, jArrCopyOf, adGroup.f5141h, adGroup.f5142i);
        }
        this.v = new AdPlaybackState(adPlaybackState.f5124a, adGroupArr2, adPlaybackState.f5126c, adPlaybackState.f5127d, adPlaybackState.f5128e);
        k0(new SinglePeriodAdTimeline(timeline2, this.v));
    }
}
