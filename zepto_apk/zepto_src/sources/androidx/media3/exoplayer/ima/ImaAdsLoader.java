package androidx.media3.exoplayer.ima;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ima.AdTagLoader;
import androidx.media3.exoplayer.ima.ImaUtil;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class ImaAdsLoader implements AdsLoader {
    public static final /* synthetic */ int n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ImaUtil.Configuration f7212a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7213b;

    /* renamed from: c, reason: collision with root package name */
    public final ImaUtil.ImaFactory f7214c;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7220i;

    /* renamed from: j, reason: collision with root package name */
    public Player f7221j;

    /* renamed from: l, reason: collision with root package name */
    public Player f7223l;

    /* renamed from: m, reason: collision with root package name */
    public AdTagLoader f7224m;

    /* renamed from: d, reason: collision with root package name */
    public final PlayerListenerImpl f7215d = new PlayerListenerImpl();

    /* renamed from: k, reason: collision with root package name */
    public List f7222k = ImmutableList.r();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f7216e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f7217f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Timeline.Period f7218g = new Timeline.Period();

    /* renamed from: h, reason: collision with root package name */
    public final Timeline.Window f7219h = new Timeline.Window();

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f7225a;

        /* renamed from: b, reason: collision with root package name */
        public ImaSdkSettings f7226b;

        /* renamed from: c, reason: collision with root package name */
        public ReactExoplayerView f7227c;

        /* renamed from: d, reason: collision with root package name */
        public ReactExoplayerView f7228d;

        /* renamed from: e, reason: collision with root package name */
        public final long f7229e;

        /* renamed from: f, reason: collision with root package name */
        public final int f7230f;

        /* renamed from: g, reason: collision with root package name */
        public final int f7231g;

        /* renamed from: h, reason: collision with root package name */
        public final int f7232h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f7233i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f7234j;

        /* renamed from: k, reason: collision with root package name */
        public final ImaUtil.ImaFactory f7235k;

        public Builder(Context context) {
            context.getClass();
            this.f7225a = context.getApplicationContext();
            this.f7229e = 10000L;
            this.f7230f = -1;
            this.f7231g = -1;
            this.f7232h = -1;
            this.f7233i = true;
            this.f7234j = true;
            this.f7235k = new DefaultImaFactory();
        }

        public final ImaAdsLoader a() {
            return new ImaAdsLoader(this.f7225a, new ImaUtil.Configuration(this.f7229e, this.f7230f, this.f7231g, this.f7233i, this.f7234j, this.f7232h, this.f7227c, this.f7228d, this.f7226b), this.f7235k);
        }

        public final void b(ReactExoplayerView reactExoplayerView) {
            this.f7227c = reactExoplayerView;
        }

        public final void c(ReactExoplayerView reactExoplayerView) {
            this.f7228d = reactExoplayerView;
        }

        public final void d(ImaSdkSettings imaSdkSettings) {
            this.f7226b = imaSdkSettings;
        }
    }

    public static final class DefaultImaFactory implements ImaUtil.ImaFactory {
    }

    public final class PlayerListenerImpl implements Player.Listener {
        public PlayerListenerImpl() {
        }

        @Override // androidx.media3.common.Player.Listener
        public final void B1(Timeline timeline, int i2) {
            if (timeline.p()) {
                return;
            }
            int i3 = ImaAdsLoader.n;
            ImaAdsLoader imaAdsLoader = ImaAdsLoader.this;
            imaAdsLoader.g();
            ImaAdsLoader.f(imaAdsLoader);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void d1(int i2) {
            ImaAdsLoader.f(ImaAdsLoader.this);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void k1(boolean z) {
            ImaAdsLoader.f(ImaAdsLoader.this);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
            int i3 = ImaAdsLoader.n;
            ImaAdsLoader imaAdsLoader = ImaAdsLoader.this;
            imaAdsLoader.g();
            ImaAdsLoader.f(imaAdsLoader);
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.ima");
    }

    public ImaAdsLoader(Context context, ImaUtil.Configuration configuration, ImaUtil.ImaFactory imaFactory) {
        this.f7213b = context.getApplicationContext();
        this.f7212a = configuration;
        this.f7214c = imaFactory;
    }

    public static void f(ImaAdsLoader imaAdsLoader) {
        AdTagLoader adTagLoader;
        Player player = imaAdsLoader.f7223l;
        if (player == null) {
            return;
        }
        Timeline timelineF0 = player.F0();
        if (timelineF0.p()) {
            return;
        }
        int iD = timelineF0.d(player.T0(), imaAdsLoader.f7218g, imaAdsLoader.f7219h, player.G(), player.s1());
        if (iD == -1) {
            return;
        }
        Timeline.Period period = imaAdsLoader.f7218g;
        timelineF0.f(iD, period, false);
        Object obj = period.f5481g.f5124a;
        if (obj == null || (adTagLoader = (AdTagLoader) imaAdsLoader.f7216e.get(obj)) == null || adTagLoader == imaAdsLoader.f7224m) {
            return;
        }
        adTagLoader.S(Util.j0(((Long) timelineF0.i(imaAdsLoader.f7219h, period, period.f5477c, -9223372036854775807L).second).longValue()), Util.j0(period.f5478d));
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public final void a(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        Assertions.f("Set player using adsLoader.setPlayer before preparing the player.", this.f7220i);
        HashMap map = this.f7217f;
        if (map.isEmpty()) {
            Player player = this.f7221j;
            this.f7223l = player;
            if (player == null) {
                return;
            } else {
                player.D0(this.f7215d);
            }
        }
        HashMap map2 = this.f7216e;
        AdTagLoader adTagLoader = (AdTagLoader) map2.get(obj);
        if (adTagLoader == null) {
            ViewGroup adViewGroup = adViewProvider.getAdViewGroup();
            if (!map2.containsKey(obj)) {
                map2.put(obj, new AdTagLoader(this.f7213b, this.f7212a, this.f7214c, this.f7222k, dataSpec, obj, adViewGroup));
            }
            adTagLoader = (AdTagLoader) map2.get(obj);
        }
        adTagLoader.getClass();
        map.put(adsMediaSource, adTagLoader);
        ArrayList arrayList = adTagLoader.f7203i;
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(eventListener);
        if (zIsEmpty) {
            adTagLoader.t = 0;
            VideoProgressUpdate videoProgressUpdate = VideoProgressUpdate.VIDEO_TIME_NOT_READY;
            adTagLoader.s = videoProgressUpdate;
            adTagLoader.r = videoProgressUpdate;
            adTagLoader.U();
            if (!AdPlaybackState.f5118g.equals(adTagLoader.z)) {
                eventListener.a(adTagLoader.z);
            } else if (adTagLoader.u != null) {
                adTagLoader.z = new AdPlaybackState(adTagLoader.f7199e, ImaUtil.a(adTagLoader.u.getAdCuePoints()));
                adTagLoader.W();
            }
            for (AdOverlayInfo adOverlayInfo : adViewProvider.getAdOverlayInfos()) {
                View view = adOverlayInfo.f5114a;
                int i2 = adOverlayInfo.f5115b;
                FriendlyObstructionPurpose friendlyObstructionPurpose = i2 != 1 ? i2 != 2 ? i2 != 4 ? FriendlyObstructionPurpose.OTHER : FriendlyObstructionPurpose.NOT_VISIBLE : FriendlyObstructionPurpose.CLOSE_AD : FriendlyObstructionPurpose.VIDEO_CONTROLS;
                ((DefaultImaFactory) adTagLoader.f7196b).getClass();
                adTagLoader.f7207m.registerFriendlyObstruction(ImaSdkFactory.getInstance().createFriendlyObstruction(view, friendlyObstructionPurpose, adOverlayInfo.f5116c));
            }
        } else if (!AdPlaybackState.f5118g.equals(adTagLoader.z)) {
            eventListener.a(adTagLoader.z);
        }
        g();
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public final void b(AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        HashMap map = this.f7217f;
        AdTagLoader adTagLoader = (AdTagLoader) map.remove(adsMediaSource);
        g();
        if (adTagLoader != null) {
            ArrayList arrayList = adTagLoader.f7203i;
            arrayList.remove(eventListener);
            if (arrayList.isEmpty()) {
                adTagLoader.f7207m.unregisterAllFriendlyObstructions();
            }
        }
        if (this.f7223l == null || !map.isEmpty()) {
            return;
        }
        this.f7223l.A0(this.f7215d);
        this.f7223l = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public final void c(AdsMediaSource adsMediaSource, int i2, int i3) {
        if (this.f7223l == null) {
            return;
        }
        AdTagLoader adTagLoader = (AdTagLoader) this.f7217f.get(adsMediaSource);
        adTagLoader.getClass();
        AdTagLoader.AdInfo adInfo = new AdTagLoader.AdInfo(i2, i3);
        adTagLoader.f7195a.getClass();
        AdMediaInfo adMediaInfo = (AdMediaInfo) adTagLoader.f7206l.j().get(adInfo);
        if (adMediaInfo == null) {
            Log.h("AdTagLoader", "Unexpected prepared ad " + adInfo);
        } else {
            int i4 = 0;
            while (true) {
                ArrayList arrayList = adTagLoader.f7204j;
                if (i4 >= arrayList.size()) {
                    return;
                }
                ((VideoAdPlayer.VideoAdPlayerCallback) arrayList.get(i4)).onLoaded(adMediaInfo);
                i4++;
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public final void d(int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 == 0) {
                arrayList.add("application/dash+xml");
            } else if (i2 == 2) {
                arrayList.add("application/x-mpegURL");
            } else if (i2 == 4) {
                arrayList.addAll(Arrays.asList("video/mp4", "video/webm", "video/3gpp", "audio/mp4", "audio/mpeg"));
            }
        }
        this.f7222k = Collections.unmodifiableList(arrayList);
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public final void e(AdsMediaSource adsMediaSource, int i2, int i3, IOException iOException) {
        if (this.f7223l == null) {
            return;
        }
        AdTagLoader adTagLoader = (AdTagLoader) this.f7217f.get(adsMediaSource);
        adTagLoader.getClass();
        if (adTagLoader.q == null) {
            return;
        }
        try {
            adTagLoader.M(i2, i3, iOException);
        } catch (RuntimeException e2) {
            adTagLoader.T(e2, "handlePrepareError");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ima.ImaAdsLoader.g():void");
    }

    public final void h() {
        Player player = this.f7223l;
        if (player != null) {
            player.A0(this.f7215d);
            this.f7223l = null;
            g();
        }
        this.f7221j = null;
        HashMap map = this.f7217f;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((AdTagLoader) it.next()).release();
        }
        map.clear();
        HashMap map2 = this.f7216e;
        Iterator it2 = map2.values().iterator();
        while (it2.hasNext()) {
            ((AdTagLoader) it2.next()).release();
        }
        map2.clear();
    }

    public final void i(Player player) {
        Assertions.g(Looper.myLooper() == Looper.getMainLooper());
        Assertions.g(player == null || player.F1() == Looper.getMainLooper());
        this.f7221j = player;
        this.f7220i = true;
    }
}
