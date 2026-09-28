package androidx.media3.exoplayer.ima;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.ima.ImaUtil;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.common.collect.HashBiMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
final class AdTagLoader implements Player.Listener {
    public boolean A;
    public boolean B;
    public int C;
    public AdMediaInfo D;
    public AdInfo E;
    public boolean F;
    public String G;
    public boolean H;
    public boolean I;
    public int J;
    public AdInfo K;
    public long L;
    public long M;
    public long Q;
    public boolean X;
    public long Y;

    /* renamed from: a, reason: collision with root package name */
    public final ImaUtil.Configuration f7195a;

    /* renamed from: b, reason: collision with root package name */
    public final ImaUtil.ImaFactory f7196b;

    /* renamed from: c, reason: collision with root package name */
    public final List f7197c;

    /* renamed from: d, reason: collision with root package name */
    public final DataSpec f7198d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f7199e;

    /* renamed from: f, reason: collision with root package name */
    public final Timeline.Period f7200f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f7201g;

    /* renamed from: h, reason: collision with root package name */
    public final ComponentListener f7202h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f7203i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7204j;

    /* renamed from: k, reason: collision with root package name */
    public final b f7205k;

    /* renamed from: l, reason: collision with root package name */
    public final HashBiMap f7206l;

    /* renamed from: m, reason: collision with root package name */
    public final AdDisplayContainer f7207m;
    public final AdsLoader n;
    public final b o;
    public Object p;
    public Player q;
    public VideoProgressUpdate r;
    public VideoProgressUpdate s;
    public int t;
    public AdsManager u;
    public boolean v;
    public AdsMediaSource.AdLoadException w;
    public Timeline x;
    public long y;
    public AdPlaybackState z;

    /* renamed from: androidx.media3.exoplayer.ima.AdTagLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7208a;

        static {
            int[] iArr = new int[AdEvent.AdEventType.values().length];
            f7208a = iArr;
            try {
                iArr[AdEvent.AdEventType.AD_BREAK_FETCH_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7208a[AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7208a[AdEvent.AdEventType.TAPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7208a[AdEvent.AdEventType.CLICKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7208a[AdEvent.AdEventType.CONTENT_RESUME_REQUESTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7208a[AdEvent.AdEventType.LOG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7208a[AdEvent.AdEventType.LOADED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class AdInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f7209a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7210b;

        public AdInfo(int i2, int i3) {
            this.f7209a = i2;
            this.f7210b = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AdInfo.class == obj.getClass()) {
                AdInfo adInfo = (AdInfo) obj;
                if (this.f7209a == adInfo.f7209a && this.f7210b == adInfo.f7210b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.f7209a * 31) + this.f7210b;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(this.f7209a);
            sb.append(", ");
            return android.support.v4.media.b.n(sb, this.f7210b, ')');
        }
    }

    public final class ComponentListener implements AdsLoader.AdsLoadedListener, ContentProgressProvider, AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, VideoAdPlayer {
        public ComponentListener() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void addCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
            AdTagLoader.this.f7204j.add(videoAdPlayerCallback);
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
        public final VideoProgressUpdate getAdProgress() {
            throw new IllegalStateException("Unexpected call to getAdProgress when using preloading");
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider
        public final VideoProgressUpdate getContentProgress() {
            Player player;
            AdTagLoader adTagLoader = AdTagLoader.this;
            VideoProgressUpdate videoProgressUpdateI = adTagLoader.I();
            adTagLoader.f7195a.getClass();
            if (adTagLoader.Y != -9223372036854775807L) {
                if (SystemClock.elapsedRealtime() - adTagLoader.Y >= 4000) {
                    adTagLoader.Y = -9223372036854775807L;
                    adTagLoader.L(new IOException("Ad preloading timed out"));
                    adTagLoader.U();
                    return videoProgressUpdateI;
                }
            } else if (adTagLoader.Q != -9223372036854775807L && (player = adTagLoader.q) != null && player.u() == 2 && adTagLoader.Q()) {
                adTagLoader.Y = SystemClock.elapsedRealtime();
            }
            return videoProgressUpdateI;
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VolumeProvider
        public final int getVolume() {
            return AdTagLoader.this.K();
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void loadAd(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
            AdTagLoader adTagLoader = AdTagLoader.this;
            try {
                AdTagLoader.z(adTagLoader, adMediaInfo, adPodInfo);
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "loadAd");
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
        public final void onAdError(AdErrorEvent adErrorEvent) {
            AdError error = adErrorEvent.getError();
            AdTagLoader adTagLoader = AdTagLoader.this;
            adTagLoader.f7195a.getClass();
            if (adTagLoader.u == null) {
                adTagLoader.p = null;
                adTagLoader.z = new AdPlaybackState(adTagLoader.f7199e, new long[0]);
                adTagLoader.W();
            } else if (error.getErrorCode() == AdError.AdErrorCode.VAST_LINEAR_ASSET_MISMATCH || error.getErrorCode() == AdError.AdErrorCode.UNKNOWN_ERROR) {
                try {
                    adTagLoader.L(error);
                } catch (RuntimeException e2) {
                    adTagLoader.T(e2, "onAdError");
                }
            }
            if (adTagLoader.w == null) {
                adTagLoader.w = new AdsMediaSource.AdLoadException(error);
            }
            adTagLoader.U();
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public final void onAdEvent(AdEvent adEvent) {
            adEvent.getType();
            AdTagLoader adTagLoader = AdTagLoader.this;
            adTagLoader.f7195a.getClass();
            try {
                AdTagLoader.h(adTagLoader, adEvent);
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "onAdEvent");
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener
        public final void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent) {
            AdsManager adsManager = adsManagerLoadedEvent.getAdsManager();
            AdTagLoader adTagLoader = AdTagLoader.this;
            if (!Util.a(adTagLoader.p, adsManagerLoadedEvent.getUserRequestContext())) {
                adsManager.destroy();
                return;
            }
            adTagLoader.p = null;
            adTagLoader.u = adsManager;
            adsManager.addAdErrorListener(this);
            ImaUtil.Configuration configuration = adTagLoader.f7195a;
            ReactExoplayerView reactExoplayerView = configuration.f7249g;
            if (reactExoplayerView != null) {
                adsManager.addAdErrorListener(reactExoplayerView);
            }
            adsManager.addAdEventListener(this);
            ReactExoplayerView reactExoplayerView2 = configuration.f7250h;
            if (reactExoplayerView2 != null) {
                adsManager.addAdEventListener(reactExoplayerView2);
            }
            try {
                adTagLoader.z = new AdPlaybackState(adTagLoader.f7199e, ImaUtil.a(adsManager.getAdCuePoints()));
                adTagLoader.W();
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "onAdsManagerLoaded");
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void pauseAd(AdMediaInfo adMediaInfo) {
            AdTagLoader adTagLoader = AdTagLoader.this;
            try {
                adTagLoader.f7195a.getClass();
                if (adTagLoader.u != null && adTagLoader.C != 0) {
                    adTagLoader.C = 2;
                    int i2 = 0;
                    while (true) {
                        ArrayList arrayList = adTagLoader.f7204j;
                        if (i2 >= arrayList.size()) {
                            return;
                        }
                        ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i2)).onPause(adMediaInfo);
                        i2++;
                    }
                }
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "pauseAd");
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void playAd(AdMediaInfo adMediaInfo) {
            AdTagLoader adTagLoader = AdTagLoader.this;
            try {
                AdTagLoader.B(adTagLoader, adMediaInfo);
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "playAd");
            }
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void release() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void removeCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
            AdTagLoader.this.f7204j.remove(videoAdPlayerCallback);
        }

        @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
        public final void stopAd(AdMediaInfo adMediaInfo) {
            AdTagLoader adTagLoader = AdTagLoader.this;
            try {
                AdTagLoader.C(adTagLoader, adMediaInfo);
            } catch (RuntimeException e2) {
                adTagLoader.T(e2, "stopAd");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.media3.exoplayer.ima.b] */
    /* JADX WARN: Type inference failed for: r11v5, types: [androidx.media3.exoplayer.ima.b] */
    public AdTagLoader(Context context, ImaUtil.Configuration configuration, ImaUtil.ImaFactory imaFactory, List list, DataSpec dataSpec, Object obj, ViewGroup viewGroup) {
        final int i2 = 1;
        this.f7195a = configuration;
        this.f7196b = imaFactory;
        ImaSdkSettings imaSdkSettingsCreateImaSdkSettings = configuration.f7251i;
        final int i3 = 0;
        if (imaSdkSettingsCreateImaSdkSettings == null) {
            ((ImaAdsLoader.DefaultImaFactory) imaFactory).getClass();
            imaSdkSettingsCreateImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
            imaSdkSettingsCreateImaSdkSettings.setLanguage(Util.F()[0]);
        }
        imaSdkSettingsCreateImaSdkSettings.setPlayerType("google/exo.ext.ima");
        imaSdkSettingsCreateImaSdkSettings.setPlayerVersion("1.4.1");
        this.f7197c = list;
        this.f7198d = dataSpec;
        this.f7199e = obj;
        this.f7200f = new Timeline.Period();
        Looper mainLooper = Looper.getMainLooper();
        int i4 = Util.f5744a;
        this.f7201g = new Handler(mainLooper, null);
        ComponentListener componentListener = new ComponentListener();
        this.f7202h = componentListener;
        this.f7203i = new ArrayList();
        this.f7204j = new ArrayList(1);
        this.f7205k = new Runnable(this) { // from class: androidx.media3.exoplayer.ima.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AdTagLoader f7255b;

            {
                this.f7255b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        this.f7255b.X();
                        break;
                    default:
                        AdTagLoader adTagLoader = this.f7255b;
                        adTagLoader.getClass();
                        adTagLoader.L(new IOException("Ad loading timed out"));
                        adTagLoader.U();
                        break;
                }
            }
        };
        this.f7206l = new HashBiMap();
        VideoProgressUpdate videoProgressUpdate = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        this.r = videoProgressUpdate;
        this.s = videoProgressUpdate;
        this.L = -9223372036854775807L;
        this.M = -9223372036854775807L;
        this.Q = -9223372036854775807L;
        this.Y = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.x = Timeline.f5466a;
        this.z = AdPlaybackState.f5118g;
        this.o = new Runnable(this) { // from class: androidx.media3.exoplayer.ima.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AdTagLoader f7255b;

            {
                this.f7255b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f7255b.X();
                        break;
                    default:
                        AdTagLoader adTagLoader = this.f7255b;
                        adTagLoader.getClass();
                        adTagLoader.L(new IOException("Ad loading timed out"));
                        adTagLoader.U();
                        break;
                }
            }
        };
        if (viewGroup != null) {
            ((ImaAdsLoader.DefaultImaFactory) imaFactory).getClass();
            this.f7207m = ImaSdkFactory.createAdDisplayContainer(viewGroup, componentListener);
        } else {
            ((ImaAdsLoader.DefaultImaFactory) imaFactory).getClass();
            this.f7207m = ImaSdkFactory.createAudioAdDisplayContainer(context, componentListener);
        }
        AdDisplayContainer adDisplayContainer = this.f7207m;
        ((ImaAdsLoader.DefaultImaFactory) imaFactory).getClass();
        AdsLoader adsLoaderCreateAdsLoader = ImaSdkFactory.getInstance().createAdsLoader(context, imaSdkSettingsCreateImaSdkSettings, adDisplayContainer);
        adsLoaderCreateAdsLoader.addAdErrorListener(componentListener);
        ReactExoplayerView reactExoplayerView = configuration.f7249g;
        if (reactExoplayerView != null) {
            adsLoaderCreateAdsLoader.addAdErrorListener(reactExoplayerView);
        }
        adsLoaderCreateAdsLoader.addAdsLoadedListener(componentListener);
        try {
            AdsRequest adsRequestB = ImaUtil.b(imaFactory, dataSpec);
            Object obj2 = new Object();
            this.p = obj2;
            adsRequestB.setUserRequestContext(obj2);
            int i5 = configuration.f7244b;
            if (i5 != -1) {
                adsRequestB.setVastLoadTimeout(i5);
            }
            adsRequestB.setContentProgressProvider(componentListener);
            adsLoaderCreateAdsLoader.requestAds(adsRequestB);
        } catch (IOException e2) {
            this.z = new AdPlaybackState(this.f7199e, new long[0]);
            W();
            this.w = new AdsMediaSource.AdLoadException(e2);
            U();
        }
        this.n = adsLoaderCreateAdsLoader;
    }

    public static void B(AdTagLoader adTagLoader, AdMediaInfo adMediaInfo) {
        adTagLoader.f7195a.getClass();
        if (adTagLoader.u == null) {
            return;
        }
        if (adTagLoader.C == 1) {
            Log.h("AdTagLoader", "Unexpected playAd without stopAd");
        }
        int i2 = adTagLoader.C;
        ArrayList arrayList = adTagLoader.f7204j;
        int i3 = 0;
        if (i2 == 0) {
            adTagLoader.L = -9223372036854775807L;
            adTagLoader.M = -9223372036854775807L;
            adTagLoader.C = 1;
            adTagLoader.D = adMediaInfo;
            AdInfo adInfo = (AdInfo) adTagLoader.f7206l.get(adMediaInfo);
            adInfo.getClass();
            adTagLoader.E = adInfo;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i4)).onPlay(adMediaInfo);
            }
            AdInfo adInfo2 = adTagLoader.K;
            if (adInfo2 != null && adInfo2.equals(adTagLoader.E)) {
                adTagLoader.K = null;
                while (i3 < arrayList.size()) {
                    ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i3)).onError(adMediaInfo);
                    i3++;
                }
            }
            adTagLoader.X();
        } else {
            adTagLoader.C = 1;
            Assertions.g(adMediaInfo.equals(adTagLoader.D));
            while (i3 < arrayList.size()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i3)).onResume(adMediaInfo);
                i3++;
            }
        }
        Player player = adTagLoader.q;
        if (player == null || !player.O0()) {
            AdsManager adsManager = adTagLoader.u;
            adsManager.getClass();
            adsManager.pause();
        }
    }

    public static void C(AdTagLoader adTagLoader, AdMediaInfo adMediaInfo) {
        AdPlaybackState.AdGroup adGroupA;
        int i2;
        adTagLoader.f7195a.getClass();
        if (adTagLoader.u == null) {
            return;
        }
        if (adTagLoader.C == 0) {
            AdInfo adInfo = (AdInfo) adTagLoader.f7206l.get(adMediaInfo);
            if (adInfo != null) {
                AdPlaybackState adPlaybackState = adTagLoader.z;
                int i3 = adInfo.f7209a;
                int i4 = adInfo.f7210b;
                int i5 = i3 - adPlaybackState.f5128e;
                AdPlaybackState.AdGroup[] adGroupArr = adPlaybackState.f5129f;
                AdPlaybackState.AdGroup[] adGroupArr2 = (AdPlaybackState.AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
                adGroupArr2[i5] = adGroupArr2[i5].d(2, i4);
                adTagLoader.z = new AdPlaybackState(adPlaybackState.f5124a, adGroupArr2, adPlaybackState.f5126c, adPlaybackState.f5127d, adPlaybackState.f5128e);
                adTagLoader.W();
                return;
            }
            return;
        }
        adTagLoader.C = 0;
        adTagLoader.f7201g.removeCallbacks(adTagLoader.f7205k);
        adTagLoader.E.getClass();
        AdInfo adInfo2 = adTagLoader.E;
        int i6 = adInfo2.f7209a;
        AdPlaybackState adPlaybackState2 = adTagLoader.z;
        int i7 = adPlaybackState2.f5125b;
        int i8 = adInfo2.f7210b;
        if (i6 < i7 && (i2 = (adGroupA = adPlaybackState2.a(i6)).f5135b) != -1 && i8 < i2 && adGroupA.f5139f[i8] == 4) {
            return;
        }
        AdPlaybackState adPlaybackState3 = adTagLoader.z;
        int i9 = i6 - adPlaybackState3.f5128e;
        AdPlaybackState.AdGroup[] adGroupArr3 = adPlaybackState3.f5129f;
        AdPlaybackState.AdGroup[] adGroupArr4 = (AdPlaybackState.AdGroup[]) Util.V(adGroupArr3.length, adGroupArr3);
        adGroupArr4[i9] = adGroupArr4[i9].d(3, i8);
        AdPlaybackState adPlaybackState4 = new AdPlaybackState(adPlaybackState3.f5124a, adGroupArr4, adPlaybackState3.f5126c, adPlaybackState3.f5127d, adPlaybackState3.f5128e);
        if (adPlaybackState4.f5126c != 0) {
            adPlaybackState4 = new AdPlaybackState(adPlaybackState4.f5124a, adPlaybackState4.f5129f, 0L, adPlaybackState4.f5127d, adPlaybackState4.f5128e);
        }
        adTagLoader.z = adPlaybackState4;
        adTagLoader.W();
        if (adTagLoader.H) {
            return;
        }
        adTagLoader.D = null;
        adTagLoader.E = null;
    }

    public static long H(Player player, Timeline timeline, Timeline.Period period) {
        long jF1 = player.f1();
        return timeline.p() ? jF1 : jF1 - Util.j0(timeline.f(player.T0(), period, false).f5479e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void h(AdTagLoader adTagLoader, AdEvent adEvent) throws NumberFormatException {
        if (adTagLoader.u == null) {
            return;
        }
        int i2 = AnonymousClass1.f7208a[adEvent.getType().ordinal()];
        ArrayList arrayList = adTagLoader.f7203i;
        int i3 = 0;
        switch (i2) {
            case 1:
                String str = adEvent.getAdData().get("adBreakTime");
                str.getClass();
                adTagLoader.f7195a.getClass();
                double d2 = Double.parseDouble(str);
                adTagLoader.R(d2 == -1.0d ? adTagLoader.z.f5125b - 1 : adTagLoader.F(d2));
                break;
            case 2:
                adTagLoader.B = true;
                adTagLoader.C = 0;
                if (adTagLoader.X) {
                    adTagLoader.Q = -9223372036854775807L;
                    adTagLoader.X = false;
                    break;
                }
                break;
            case 3:
                while (i3 < arrayList.size()) {
                    ((AdsLoader.EventListener) arrayList.get(i3)).getClass();
                    i3++;
                }
                break;
            case 4:
                while (i3 < arrayList.size()) {
                    ((AdsLoader.EventListener) arrayList.get(i3)).getClass();
                    i3++;
                }
                break;
            case 5:
                adTagLoader.B = false;
                AdInfo adInfo = adTagLoader.E;
                if (adInfo != null) {
                    adTagLoader.z = adTagLoader.z.g(adInfo.f7209a);
                    adTagLoader.W();
                    break;
                }
                break;
            case 6:
                Log.g("AdTagLoader", "AdEvent: " + adEvent.getAdData());
                break;
            case 7:
                adTagLoader.G = adEvent.getAd().getContentType();
                break;
        }
    }

    public static void z(AdTagLoader adTagLoader, AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
        MediaItem.LocalConfiguration localConfiguration;
        AdPlaybackState.AdGroup adGroupA;
        int i2;
        AdsManager adsManager = adTagLoader.u;
        ImaUtil.Configuration configuration = adTagLoader.f7195a;
        if (adsManager == null) {
            configuration.getClass();
            return;
        }
        int iF = adPodInfo.getPodIndex() == -1 ? adTagLoader.z.f5125b - 1 : adTagLoader.F(adPodInfo.getTimeOffset());
        int adPosition = adPodInfo.getAdPosition() - 1;
        AdInfo adInfo = new AdInfo(iF, adPosition);
        adTagLoader.f7206l.k(adMediaInfo, adInfo, true);
        configuration.getClass();
        AdPlaybackState adPlaybackState = adTagLoader.z;
        if (iF < adPlaybackState.f5125b && (i2 = (adGroupA = adPlaybackState.a(iF)).f5135b) != -1 && adPosition < i2 && adGroupA.f5139f[adPosition] == 4) {
            return;
        }
        Player player = adTagLoader.q;
        if (player != null && player.B0() == iF && adTagLoader.q.a1() == adPosition) {
            adTagLoader.f7201g.removeCallbacks(adTagLoader.o);
        }
        AdPlaybackState adPlaybackStateE = adTagLoader.z.e(iF, Math.max(adPodInfo.getTotalAds(), adTagLoader.z.a(iF).f5139f.length));
        adTagLoader.z = adPlaybackStateE;
        AdPlaybackState.AdGroup adGroupA2 = adPlaybackStateE.a(iF);
        for (int i3 = 0; i3 < adPosition; i3++) {
            if (adGroupA2.f5139f[i3] == 0) {
                adTagLoader.z = adTagLoader.z.f(iF, i3);
            }
        }
        MediaItem.Builder builder = new MediaItem.Builder();
        String url = adMediaInfo.getUrl();
        builder.f5267b = url == null ? null : Uri.parse(url);
        String str = adTagLoader.G;
        if (str != null) {
            builder.f5268c = str;
            adTagLoader.G = null;
        }
        AdPlaybackState adPlaybackState2 = adTagLoader.z;
        MediaItem mediaItemA = builder.a();
        int i4 = adInfo.f7209a;
        int i5 = adInfo.f7210b;
        int i6 = i4 - adPlaybackState2.f5128e;
        AdPlaybackState.AdGroup[] adGroupArr = adPlaybackState2.f5129f;
        AdPlaybackState.AdGroup[] adGroupArr2 = (AdPlaybackState.AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
        Assertions.g(adGroupArr2[i6].f5142i || !((localConfiguration = mediaItemA.f5258b) == null || localConfiguration.f5339a.equals(Uri.EMPTY)));
        AdPlaybackState.AdGroup adGroup = adGroupArr2[i6];
        int[] iArr = adGroup.f5139f;
        int length = iArr.length;
        int iMax = Math.max(i5 + 1, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArrA = adGroup.f5140g;
        if (jArrA.length != iArrCopyOf.length) {
            jArrA = AdPlaybackState.AdGroup.a(jArrA, iArrCopyOf.length);
        }
        long[] jArr = jArrA;
        MediaItem[] mediaItemArr = (MediaItem[]) Arrays.copyOf(adGroup.f5138e, iArrCopyOf.length);
        mediaItemArr[i5] = mediaItemA;
        iArrCopyOf[i5] = 1;
        adGroupArr2[i6] = new AdPlaybackState.AdGroup(adGroup.f5134a, adGroup.f5135b, adGroup.f5136c, iArrCopyOf, mediaItemArr, jArr, adGroup.f5141h, adGroup.f5142i);
        adTagLoader.z = new AdPlaybackState(adPlaybackState2.f5124a, adGroupArr2, adPlaybackState2.f5126c, adPlaybackState2.f5127d, adPlaybackState2.f5128e);
        adTagLoader.W();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void B1(Timeline timeline, int i2) {
        Player player;
        if (timeline.p() || (player = this.q) == null) {
            return;
        }
        this.x = timeline;
        int iT0 = player.T0();
        Timeline.Period period = this.f7200f;
        long j2 = timeline.f(iT0, period, false).f5478d;
        this.y = Util.j0(j2);
        AdPlaybackState adPlaybackState = this.z;
        long j3 = adPlaybackState.f5127d;
        if (j2 != j3) {
            if (j3 != j2) {
                adPlaybackState = new AdPlaybackState(adPlaybackState.f5124a, adPlaybackState.f5129f, adPlaybackState.f5126c, j2, adPlaybackState.f5128e);
            }
            this.z = adPlaybackState;
            W();
        }
        S(H(player, timeline, period), this.y);
        O();
    }

    public final void D() {
        AdsManager adsManager = this.u;
        if (adsManager != null) {
            ComponentListener componentListener = this.f7202h;
            adsManager.removeAdErrorListener(componentListener);
            ImaUtil.Configuration configuration = this.f7195a;
            ReactExoplayerView reactExoplayerView = configuration.f7249g;
            if (reactExoplayerView != null) {
                this.u.removeAdErrorListener(reactExoplayerView);
            }
            this.u.removeAdEventListener(componentListener);
            ReactExoplayerView reactExoplayerView2 = configuration.f7250h;
            if (reactExoplayerView2 != null) {
                this.u.removeAdEventListener(reactExoplayerView2);
            }
            this.u.destroy();
            this.u = null;
        }
    }

    public final void E() {
        AdPlaybackState.AdGroup adGroupA;
        int i2;
        if (this.F || this.y == -9223372036854775807L || this.Q != -9223372036854775807L) {
            return;
        }
        Player player = this.q;
        player.getClass();
        long jH = H(player, this.x, this.f7200f);
        if (5000 + jH < this.y) {
            return;
        }
        int iC = this.z.c(Util.T(jH), Util.T(this.y));
        if (iC == -1 || this.z.a(iC).f5134a == Long.MIN_VALUE || ((i2 = (adGroupA = this.z.a(iC)).f5135b) != -1 && adGroupA.b(-1) >= i2)) {
            V();
        }
    }

    public final int F(double d2) {
        long jRound = Math.round(((float) d2) * 1000000.0d);
        int i2 = 0;
        while (true) {
            AdPlaybackState adPlaybackState = this.z;
            if (i2 >= adPlaybackState.f5125b) {
                throw new IllegalStateException("Failed to find cue point");
            }
            long j2 = adPlaybackState.a(i2).f5134a;
            if (j2 != Long.MIN_VALUE && Math.abs(j2 - jRound) < 1000) {
                return i2;
            }
            i2++;
        }
    }

    public final VideoProgressUpdate G() {
        Player player = this.q;
        if (player == null) {
            return this.s;
        }
        if (this.C == 0 || !this.H) {
            return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        }
        long duration = player.getDuration();
        return duration == -9223372036854775807L ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : new VideoProgressUpdate(this.q.z1(), duration);
    }

    public final VideoProgressUpdate I() {
        boolean z = this.y != -9223372036854775807L;
        long jH = this.Q;
        if (jH != -9223372036854775807L) {
            this.X = true;
        } else {
            Player player = this.q;
            if (player == null) {
                return this.r;
            }
            if (this.L != -9223372036854775807L) {
                jH = this.M + (SystemClock.elapsedRealtime() - this.L);
            } else {
                if (this.C != 0 || this.H || !z) {
                    return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
                }
                jH = H(player, this.x, this.f7200f);
            }
        }
        return new VideoProgressUpdate(jH, z ? this.y : -1L);
    }

    public final int J() {
        Player player = this.q;
        if (player == null) {
            return -1;
        }
        long jT = Util.T(H(player, this.x, this.f7200f));
        int iC = this.z.c(jT, Util.T(this.y));
        return iC == -1 ? this.z.b(jT, Util.T(this.y)) : iC;
    }

    public final int K() {
        Player player = this.q;
        return player == null ? this.t : ((BasePlayer) player).D1(22) ? (int) (player.getVolume() * 100.0f) : player.y0().a(1) ? 100 : 0;
    }

    public final void L(Exception exc) {
        int iJ = J();
        if (iJ == -1) {
            Log.i("AdTagLoader", "Unable to determine ad group index for ad group load error", exc);
            return;
        }
        R(iJ);
        if (this.w == null) {
            this.w = new AdsMediaSource.AdLoadException(new IOException(android.support.v4.media.b.f(iJ, "Failed to load ad group "), exc));
        }
    }

    public final void M(int i2, int i3, IOException iOException) {
        this.f7195a.getClass();
        if (this.u == null) {
            Log.h("AdTagLoader", "Ignoring ad prepare error after release");
            return;
        }
        if (this.C == 0) {
            this.L = SystemClock.elapsedRealtime();
            long jJ0 = Util.j0(this.z.a(i2).f5134a);
            this.M = jJ0;
            if (jJ0 == Long.MIN_VALUE) {
                this.M = this.y;
            }
            this.K = new AdInfo(i2, i3);
        } else {
            AdMediaInfo adMediaInfo = this.D;
            adMediaInfo.getClass();
            int i4 = this.J;
            ArrayList arrayList = this.f7204j;
            if (i3 > i4) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i5)).onEnded(adMediaInfo);
                }
            }
            this.J = this.z.a(i2).b(-1);
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i6)).onError(adMediaInfo);
            }
        }
        this.z = this.z.f(i2, i3);
        W();
    }

    public final void N(int i2, boolean z) {
        boolean z2 = this.H;
        ArrayList arrayList = this.f7204j;
        if (z2 && this.C == 1) {
            boolean z3 = this.I;
            if (!z3 && i2 == 2) {
                this.I = true;
                AdMediaInfo adMediaInfo = this.D;
                adMediaInfo.getClass();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i3)).onBuffering(adMediaInfo);
                }
                this.f7201g.removeCallbacks(this.f7205k);
            } else if (z3 && i2 == 3) {
                this.I = false;
                X();
            }
        }
        int i4 = this.C;
        if (i4 == 0 && i2 == 2 && z) {
            E();
            return;
        }
        if (i4 == 0 || i2 != 4) {
            return;
        }
        AdMediaInfo adMediaInfo2 = this.D;
        if (adMediaInfo2 == null) {
            Log.h("AdTagLoader", "onEnded without ad media info");
        } else {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i5)).onEnded(adMediaInfo2);
            }
        }
        this.f7195a.getClass();
    }

    public final void O() {
        int iB0;
        Player player = this.q;
        if (this.u == null || player == null) {
            return;
        }
        int i2 = 0;
        if (!this.H && !player.f0()) {
            E();
            if (!this.F && !this.x.p()) {
                Timeline timeline = this.x;
                Timeline.Period period = this.f7200f;
                long jH = H(player, timeline, period);
                this.x.f(player.T0(), period, false);
                if (period.f5481g.c(Util.T(jH), period.f5478d) != -1) {
                    this.X = false;
                    this.Q = jH;
                }
            }
        }
        boolean z = this.H;
        int i3 = this.J;
        boolean zF0 = player.f0();
        this.H = zF0;
        int iA1 = zF0 ? player.a1() : -1;
        this.J = iA1;
        ImaUtil.Configuration configuration = this.f7195a;
        if (z && iA1 != i3) {
            AdMediaInfo adMediaInfo = this.D;
            if (adMediaInfo == null) {
                Log.h("AdTagLoader", "onEnded without ad media info");
            } else {
                AdInfo adInfo = (AdInfo) this.f7206l.get(adMediaInfo);
                int i4 = this.J;
                if (i4 == -1 || (adInfo != null && adInfo.f7210b < i4)) {
                    while (true) {
                        ArrayList arrayList = this.f7204j;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i2)).onEnded(adMediaInfo);
                        i2++;
                    }
                    configuration.getClass();
                }
            }
        }
        if (!this.F && !z && this.H && this.C == 0) {
            AdPlaybackState.AdGroup adGroupA = this.z.a(player.B0());
            if (adGroupA.f5134a == Long.MIN_VALUE) {
                V();
            } else {
                this.L = SystemClock.elapsedRealtime();
                long jJ0 = Util.j0(adGroupA.f5134a);
                this.M = jJ0;
                if (jJ0 == Long.MIN_VALUE) {
                    this.M = this.y;
                }
            }
        }
        Player player2 = this.q;
        if (player2 == null || (iB0 = player2.B0()) == -1) {
            return;
        }
        AdPlaybackState.AdGroup adGroupA2 = this.z.a(iB0);
        int iA12 = player2.a1();
        int i5 = adGroupA2.f5135b;
        if (i5 == -1 || i5 <= iA12 || adGroupA2.f5139f[iA12] == 0) {
            Handler handler = this.f7201g;
            b bVar = this.o;
            handler.removeCallbacks(bVar);
            handler.postDelayed(bVar, configuration.f7243a);
        }
    }

    public final boolean Q() {
        int iJ;
        Player player = this.q;
        if (player == null || (iJ = J()) == -1) {
            return false;
        }
        AdPlaybackState.AdGroup adGroupA = this.z.a(iJ);
        int i2 = adGroupA.f5135b;
        return (i2 == -1 || i2 == 0 || adGroupA.f5139f[0] == 0) && Util.j0(adGroupA.f5134a) - H(player, this.x, this.f7200f) < this.f7195a.f7243a;
    }

    public final void R(int i2) {
        AdPlaybackState.AdGroup adGroupA = this.z.a(i2);
        if (adGroupA.f5135b == -1) {
            AdPlaybackState adPlaybackStateE = this.z.e(i2, Math.max(1, adGroupA.f5139f.length));
            this.z = adPlaybackStateE;
            adGroupA = adPlaybackStateE.a(i2);
        }
        for (int i3 = 0; i3 < adGroupA.f5135b; i3++) {
            if (adGroupA.f5139f[i3] == 0) {
                this.f7195a.getClass();
                this.z = this.z.f(i2, i3);
            }
        }
        W();
        this.Q = -9223372036854775807L;
        this.L = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(long r12, long r14) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ima.AdTagLoader.S(long, long):void");
    }

    public final void T(RuntimeException runtimeException, String str) {
        String strConcat = "Internal error in ".concat(str);
        Log.e("AdTagLoader", strConcat, runtimeException);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            AdPlaybackState adPlaybackState = this.z;
            if (i3 >= adPlaybackState.f5125b) {
                break;
            }
            this.z = adPlaybackState.g(i3);
            i3++;
        }
        W();
        while (true) {
            ArrayList arrayList = this.f7203i;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((AdsLoader.EventListener) arrayList.get(i2)).b(new AdsMediaSource.AdLoadException(new RuntimeException(strConcat, runtimeException)), this.f7198d);
            i2++;
        }
    }

    public final void U() {
        if (this.w == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7203i;
            if (i2 >= arrayList.size()) {
                this.w = null;
                return;
            } else {
                ((AdsLoader.EventListener) arrayList.get(i2)).b(this.w, this.f7198d);
                i2++;
            }
        }
    }

    public final void V() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f7204j;
            if (i3 >= arrayList.size()) {
                break;
            }
            ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i3)).onContentComplete();
            i3++;
        }
        this.F = true;
        this.f7195a.getClass();
        while (true) {
            AdPlaybackState adPlaybackState = this.z;
            if (i2 >= adPlaybackState.f5125b) {
                W();
                return;
            } else {
                if (adPlaybackState.a(i2).f5134a != Long.MIN_VALUE) {
                    this.z = this.z.g(i2);
                }
                i2++;
            }
        }
    }

    public final void W() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7203i;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((AdsLoader.EventListener) arrayList.get(i2)).a(this.z);
            i2++;
        }
    }

    public final void X() {
        VideoProgressUpdate videoProgressUpdateG = G();
        this.f7195a.getClass();
        AdMediaInfo adMediaInfo = this.D;
        adMediaInfo.getClass();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7204j;
            if (i2 >= arrayList.size()) {
                Handler handler = this.f7201g;
                b bVar = this.f7205k;
                handler.removeCallbacks(bVar);
                handler.postDelayed(bVar, 200L);
                return;
            }
            ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i2)).onAdProgress(adMediaInfo, videoProgressUpdateG);
            i2++;
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void i1(int i2) {
        Player player = this.q;
        if (this.u == null || player == null) {
            return;
        }
        if (i2 == 2 && !player.f0() && Q()) {
            this.Y = SystemClock.elapsedRealtime();
        } else if (i2 == 3) {
            this.Y = -9223372036854775807L;
        }
        N(i2, player.O0());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void r1(PlaybackException playbackException) {
        if (this.C == 0) {
            return;
        }
        AdMediaInfo adMediaInfo = this.D;
        adMediaInfo.getClass();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7204j;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i2)).onError(adMediaInfo);
            i2++;
        }
    }

    public final void release() {
        if (this.A) {
            return;
        }
        this.A = true;
        this.p = null;
        D();
        com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader = this.n;
        ComponentListener componentListener = this.f7202h;
        adsLoader.removeAdsLoadedListener(componentListener);
        adsLoader.removeAdErrorListener(componentListener);
        ReactExoplayerView reactExoplayerView = this.f7195a.f7249g;
        if (reactExoplayerView != null) {
            adsLoader.removeAdErrorListener(reactExoplayerView);
        }
        adsLoader.release();
        int i2 = 0;
        this.B = false;
        this.C = 0;
        this.D = null;
        this.f7201g.removeCallbacks(this.f7205k);
        this.E = null;
        this.w = null;
        while (true) {
            AdPlaybackState adPlaybackState = this.z;
            if (i2 >= adPlaybackState.f5125b) {
                W();
                return;
            } else {
                this.z = adPlaybackState.g(i2);
                i2++;
            }
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        O();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void y1(int i2, boolean z) {
        Player player;
        AdsManager adsManager = this.u;
        if (adsManager == null || (player = this.q) == null) {
            return;
        }
        int i3 = this.C;
        if (i3 == 1 && !z) {
            adsManager.pause();
        } else if (i3 == 2 && z) {
            adsManager.resume();
        } else {
            N(player.u(), z);
        }
    }
}
