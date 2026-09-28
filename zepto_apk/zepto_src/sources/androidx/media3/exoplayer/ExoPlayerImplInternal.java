package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    public static final long D0 = Util.j0(10000);
    public static final /* synthetic */ int E0 = 0;
    public boolean A;
    public ExoPlaybackException A0;
    public boolean B;
    public long B0;
    public boolean C;
    public ExoPlayer.PreloadConfiguration C0;
    public boolean D;
    public long E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public SeekPosition M;
    public long Q;
    public long X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final Renderer[] f6217a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f6218b;

    /* renamed from: c, reason: collision with root package name */
    public final RendererCapabilities[] f6219c;

    /* renamed from: d, reason: collision with root package name */
    public final TrackSelector f6220d;

    /* renamed from: e, reason: collision with root package name */
    public final TrackSelectorResult f6221e;

    /* renamed from: f, reason: collision with root package name */
    public final LoadControl f6222f;

    /* renamed from: g, reason: collision with root package name */
    public final BandwidthMeter f6223g;

    /* renamed from: h, reason: collision with root package name */
    public final HandlerWrapper f6224h;

    /* renamed from: i, reason: collision with root package name */
    public final HandlerThread f6225i;

    /* renamed from: j, reason: collision with root package name */
    public final Looper f6226j;

    /* renamed from: k, reason: collision with root package name */
    public final Timeline.Window f6227k;

    /* renamed from: l, reason: collision with root package name */
    public final Timeline.Period f6228l;

    /* renamed from: m, reason: collision with root package name */
    public final long f6229m;
    public final boolean n;
    public final DefaultMediaClock o;
    public final ArrayList p;
    public final SystemClock q;
    public final l r;
    public final MediaPeriodQueue s;
    public final MediaSourceList t;
    public final DefaultLivePlaybackSpeedControl u;
    public final long v;
    public final PlayerId w;
    public SeekParameters x;
    public PlaybackInfo y;
    public PlaybackInfoUpdate z;

    public static final class MediaSourceListUpdateMessage {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f6231a;

        /* renamed from: b, reason: collision with root package name */
        public final ShuffleOrder f6232b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6233c;

        /* renamed from: d, reason: collision with root package name */
        public final long f6234d;

        public MediaSourceListUpdateMessage(ArrayList arrayList, ShuffleOrder shuffleOrder, int i2, long j2) {
            this.f6231a = arrayList;
            this.f6232b = shuffleOrder;
            this.f6233c = i2;
            this.f6234d = j2;
        }
    }

    public static class MoveMediaItemsMessage {

        /* renamed from: a, reason: collision with root package name */
        public final int f6235a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6236b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6237c;

        /* renamed from: d, reason: collision with root package name */
        public final ShuffleOrder f6238d;

        public MoveMediaItemsMessage(int i2, int i3, int i4, ShuffleOrder shuffleOrder) {
            this.f6235a = i2;
            this.f6236b = i3;
            this.f6237c = i4;
            this.f6238d = shuffleOrder;
        }
    }

    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        @Override // java.lang.Comparable
        public final int compareTo(PendingMessageInfo pendingMessageInfo) {
            pendingMessageInfo.getClass();
            return 0;
        }
    }

    public static final class PlaybackInfoUpdate {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6239a;

        /* renamed from: b, reason: collision with root package name */
        public PlaybackInfo f6240b;

        /* renamed from: c, reason: collision with root package name */
        public int f6241c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6242d;

        /* renamed from: e, reason: collision with root package name */
        public int f6243e;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.f6240b = playbackInfo;
        }

        public final void a(int i2) {
            this.f6239a |= i2 > 0;
            this.f6241c += i2;
        }
    }

    public interface PlaybackInfoUpdateListener {
    }

    public static final class PositionUpdateForPlaylistChange {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6244a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6245b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6246c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f6247d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f6248e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f6249f;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, boolean z, boolean z2, boolean z3) {
            this.f6244a = mediaPeriodId;
            this.f6245b = j2;
            this.f6246c = j3;
            this.f6247d = z;
            this.f6248e = z2;
            this.f6249f = z3;
        }
    }

    public static final class SeekPosition {

        /* renamed from: a, reason: collision with root package name */
        public final Timeline f6250a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6251b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6252c;

        public SeekPosition(Timeline timeline, int i2, long j2) {
            this.f6250a = timeline;
            this.f6251b = i2;
            this.f6252c = j2;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i2, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl, long j2, Looper looper, SystemClock systemClock, l lVar, PlayerId playerId) {
        ExoPlayer.PreloadConfiguration preloadConfiguration = ExoPlayer.PreloadConfiguration.f6196a;
        this.r = lVar;
        this.f6217a = rendererArr;
        this.f6220d = trackSelector;
        this.f6221e = trackSelectorResult;
        this.f6222f = loadControl;
        this.f6223g = bandwidthMeter;
        this.G = i2;
        this.H = z;
        this.x = seekParameters;
        this.u = defaultLivePlaybackSpeedControl;
        this.v = j2;
        this.B = false;
        this.q = systemClock;
        this.w = playerId;
        this.C0 = preloadConfiguration;
        this.B0 = -9223372036854775807L;
        this.E = -9223372036854775807L;
        this.f6229m = loadControl.c();
        this.n = loadControl.b();
        Timeline timeline = Timeline.f5466a;
        PlaybackInfo playbackInfoI = PlaybackInfo.i(trackSelectorResult);
        this.y = playbackInfoI;
        this.z = new PlaybackInfoUpdate(playbackInfoI);
        this.f6219c = new RendererCapabilities[rendererArr.length];
        RendererCapabilities.Listener listenerC = trackSelector.c();
        for (int i3 = 0; i3 < rendererArr.length; i3++) {
            rendererArr[i3].m(i3, playerId, systemClock);
            this.f6219c[i3] = rendererArr[i3].u();
            if (listenerC != null) {
                this.f6219c[i3].v(listenerC);
            }
        }
        this.o = new DefaultMediaClock(this, systemClock);
        this.p = new ArrayList();
        this.f6218b = Collections.newSetFromMap(new IdentityHashMap());
        this.f6227k = new Timeline.Window();
        this.f6228l = new Timeline.Period();
        trackSelector.f8037a = this;
        trackSelector.f8038b = bandwidthMeter;
        this.Z = true;
        HandlerWrapper handlerWrapperA = systemClock.a(looper, null);
        this.s = new MediaPeriodQueue(analyticsCollector, handlerWrapperA, new e(this, 4));
        this.t = new MediaSourceList(this, analyticsCollector, handlerWrapperA, playerId);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f6225i = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f6226j = looper2;
        this.f6224h = systemClock.a(looper2, this);
    }

    public static Pair J(Timeline timeline, SeekPosition seekPosition, boolean z, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        int iK;
        Timeline timeline2 = seekPosition.f6250a;
        if (timeline.p()) {
            return null;
        }
        Timeline timeline3 = timeline2.p() ? timeline : timeline2;
        try {
            Pair pairI = timeline3.i(window, period, seekPosition.f6251b, seekPosition.f6252c);
            if (!timeline.equals(timeline3)) {
                if (timeline.b(pairI.first) == -1) {
                    if (!z || (iK = K(window, period, i2, z2, pairI.first, timeline3, timeline)) == -1) {
                        return null;
                    }
                    return timeline.i(window, period, iK, -9223372036854775807L);
                }
                if (timeline3.g(pairI.first, period).f5480f && timeline3.m(period.f5477c, window, 0L).n == timeline3.b(pairI.first)) {
                    return timeline.i(window, period, timeline.g(pairI.first, period).f5477c, seekPosition.f6252c);
                }
            }
            return pairI;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int K(Timeline.Window window, Timeline.Period period, int i2, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        Timeline.Window window2 = window;
        Timeline timeline3 = timeline;
        Object obj2 = timeline3.m(timeline3.g(obj, period).f5477c, window, 0L).f5486a;
        for (int i3 = 0; i3 < timeline2.o(); i3++) {
            if (timeline2.m(i3, window, 0L).f5486a.equals(obj2)) {
                return i3;
            }
        }
        int iB = timeline3.b(obj);
        int iH = timeline3.h();
        int iB2 = -1;
        int i4 = 0;
        while (i4 < iH && iB2 == -1) {
            Timeline timeline4 = timeline3;
            int iD = timeline4.d(iB, period, window2, i2, z);
            if (iD == -1) {
                break;
            }
            iB2 = timeline2.b(timeline4.l(iD));
            i4++;
            timeline3 = timeline4;
            iB = iD;
            window2 = window;
        }
        if (iB2 == -1) {
            return -1;
        }
        return timeline2.f(iB2, period, false).f5477c;
    }

    public static void R(Renderer renderer, long j2) {
        renderer.l();
        if (renderer instanceof TextRenderer) {
            TextRenderer textRenderer = (TextRenderer) renderer;
            Assertions.g(textRenderer.n);
            textRenderer.K = j2;
        }
    }

    public static boolean v(Renderer renderer) {
        return renderer.getState() != 0;
    }

    public final void A(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        Timeline timelineB;
        this.z.a(1);
        int i2 = moveMediaItemsMessage.f6235a;
        MediaSourceList mediaSourceList = this.t;
        mediaSourceList.getClass();
        ArrayList arrayList = mediaSourceList.f6303b;
        int i3 = moveMediaItemsMessage.f6236b;
        int i4 = moveMediaItemsMessage.f6237c;
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= arrayList.size() && i4 >= 0);
        mediaSourceList.f6311j = moveMediaItemsMessage.f6238d;
        if (i2 == i3 || i2 == i4) {
            timelineB = mediaSourceList.b();
        } else {
            int iMin = Math.min(i2, i4);
            int iMax = Math.max(((i3 - i2) + i4) - 1, i3 - 1);
            int iO = ((MediaSourceList.MediaSourceHolder) arrayList.get(iMin)).f6322d;
            Util.S(arrayList, i2, i3, i4);
            while (iMin <= iMax) {
                MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) arrayList.get(iMin);
                mediaSourceHolder.f6322d = iO;
                iO += mediaSourceHolder.f6319a.o.f7572e.o();
                iMin++;
            }
            timelineB = mediaSourceList.b();
        }
        q(timelineB, false);
    }

    public final void B() {
        this.z.a(1);
        int i2 = 0;
        F(false, false, false, true);
        this.f6222f.d(this.w);
        b0(this.y.f6327a.p() ? 4 : 2);
        TransferListener transferListenerE = this.f6223g.e();
        MediaSourceList mediaSourceList = this.t;
        Assertions.g(!mediaSourceList.f6312k);
        mediaSourceList.f6313l = transferListenerE;
        while (true) {
            ArrayList arrayList = mediaSourceList.f6303b;
            if (i2 >= arrayList.size()) {
                mediaSourceList.f6312k = true;
                this.f6224h.k(2);
                return;
            } else {
                MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) arrayList.get(i2);
                mediaSourceList.e(mediaSourceHolder);
                mediaSourceList.f6308g.add(mediaSourceHolder);
                i2++;
            }
        }
    }

    public final void C() {
        int i2 = 0;
        try {
            F(true, false, true, false);
            while (true) {
                Renderer[] rendererArr = this.f6217a;
                if (i2 >= rendererArr.length) {
                    break;
                }
                this.f6219c[i2].d();
                rendererArr[i2].release();
                i2++;
            }
            this.f6222f.f(this.w);
            b0(1);
            HandlerThread handlerThread = this.f6225i;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
            }
        } catch (Throwable th) {
            HandlerThread handlerThread2 = this.f6225i;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
                throw th;
            }
        }
    }

    public final void D(int i2, int i3, ShuffleOrder shuffleOrder) throws Throwable {
        this.z.a(1);
        MediaSourceList mediaSourceList = this.t;
        mediaSourceList.getClass();
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= mediaSourceList.f6303b.size());
        mediaSourceList.f6311j = shuffleOrder;
        mediaSourceList.g(i2, i3);
        q(mediaSourceList.b(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.E():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0 A[PHI: r5 r6 r8
      0x00c0: PHI (r5v4 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId) = 
      (r5v3 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
      (r5v14 androidx.media3.exoplayer.source.MediaSource$MediaPeriodId)
     binds: [B:35:0x0096, B:37:0x00bb] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r6v2 long) = (r6v1 long), (r6v14 long) binds: [B:35:0x0096, B:37:0x00bb] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r8v3 long) = (r8v2 long), (r8v11 long) binds: [B:35:0x0096, B:37:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.F(boolean, boolean, boolean, boolean):void");
    }

    public final void G() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        this.C = mediaPeriodHolder != null && mediaPeriodHolder.f6272f.f6287h && this.B;
    }

    public final void H(long j2) {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        long j3 = j2 + (mediaPeriodHolder == null ? 1000000000000L : mediaPeriodHolder.o);
        this.Q = j3;
        this.o.f6170a.a(j3);
        for (Renderer renderer : this.f6217a) {
            if (v(renderer)) {
                renderer.A(this.Q);
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = r0.f6297i; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.f6278l) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder2.n.f8041c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.k();
                }
            }
        }
    }

    public final void I(Timeline timeline, Timeline timeline2) {
        if (timeline.p() && timeline2.p()) {
            return;
        }
        ArrayList arrayList = this.p;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            ((PendingMessageInfo) arrayList.get(size)).getClass();
            throw null;
        }
    }

    public final void L(long j2) {
        this.f6224h.j(j2 + ((this.y.f6331e != 3 || c0()) ? D0 : 1000L));
    }

    public final void M(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.s.f6297i.f6272f.f6280a;
        long jO = O(mediaPeriodId, this.y.s, true, false);
        if (jO != this.y.s) {
            PlaybackInfo playbackInfo = this.y;
            this.y = t(mediaPeriodId, jO, playbackInfo.f6329c, playbackInfo.f6330d, z, 5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x00a4, TryCatch #2 {all -> 0x00a4, blocks: (B:22:0x0097, B:24:0x00a1, B:31:0x00ad, B:33:0x00b3, B:34:0x00b6, B:36:0x00be, B:41:0x00ce, B:45:0x00d6), top: B:103:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.N(androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition):void");
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    public final long O(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z, boolean z2) throws ExoPlaybackException {
        g0();
        l0(false, true);
        if (z2 || this.y.f6331e == 3) {
            b0(2);
        }
        MediaPeriodQueue mediaPeriodQueue = this.s;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.f6297i;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        while (mediaPeriodHolder2 != null && !mediaPeriodId.equals(mediaPeriodHolder2.f6272f.f6280a)) {
            mediaPeriodHolder2 = mediaPeriodHolder2.f6278l;
        }
        if (z || mediaPeriodHolder != mediaPeriodHolder2 || (mediaPeriodHolder2 != null && mediaPeriodHolder2.o + j2 < 0)) {
            Renderer[] rendererArr = this.f6217a;
            for (Renderer renderer : rendererArr) {
                e(renderer);
            }
            if (mediaPeriodHolder2 != null) {
                while (mediaPeriodQueue.f6297i != mediaPeriodHolder2) {
                    mediaPeriodQueue.a();
                }
                mediaPeriodQueue.l(mediaPeriodHolder2);
                mediaPeriodHolder2.o = 1000000000000L;
                g(new boolean[rendererArr.length], mediaPeriodQueue.f6298j.e());
            }
        }
        if (mediaPeriodHolder2 != null) {
            mediaPeriodQueue.l(mediaPeriodHolder2);
            if (!mediaPeriodHolder2.f6270d) {
                mediaPeriodHolder2.f6272f = mediaPeriodHolder2.f6272f.b(j2);
            } else if (mediaPeriodHolder2.f6271e) {
                ?? r9 = mediaPeriodHolder2.f6267a;
                j2 = r9.g(j2);
                r9.r(j2 - this.f6229m, this.n);
            }
            H(j2);
            x();
        } else {
            mediaPeriodQueue.b();
            H(j2);
        }
        p(false);
        this.f6224h.k(2);
        return j2;
    }

    public final void P(PlayerMessage playerMessage) {
        Looper looper = playerMessage.f6345f;
        Looper looper2 = this.f6226j;
        HandlerWrapper handlerWrapper = this.f6224h;
        if (looper != looper2) {
            handlerWrapper.e(15, playerMessage).a();
            return;
        }
        synchronized (playerMessage) {
        }
        try {
            playerMessage.f6340a.o(playerMessage.f6343d, playerMessage.f6344e);
            playerMessage.b(true);
            int i2 = this.y.f6331e;
            if (i2 == 3 || i2 == 2) {
                handlerWrapper.k(2);
            }
        } catch (Throwable th) {
            playerMessage.b(true);
            throw th;
        }
    }

    public final void Q(PlayerMessage playerMessage) {
        Looper looper = playerMessage.f6345f;
        if (looper.getThread().isAlive()) {
            this.q.a(looper, null).i(new m(1, this, playerMessage));
        } else {
            Log.h("TAG", "Trying to send message on a dead thread.");
            playerMessage.b(false);
        }
    }

    public final void S(boolean z, AtomicBoolean atomicBoolean) {
        if (this.I != z) {
            this.I = z;
            if (!z) {
                for (Renderer renderer : this.f6217a) {
                    if (!v(renderer) && this.f6218b.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void T(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.z.a(1);
        int i2 = mediaSourceListUpdateMessage.f6233c;
        ArrayList arrayList = mediaSourceListUpdateMessage.f6231a;
        ShuffleOrder shuffleOrder = mediaSourceListUpdateMessage.f6232b;
        if (i2 != -1) {
            this.M = new SeekPosition(new PlaylistTimeline(arrayList, shuffleOrder), mediaSourceListUpdateMessage.f6233c, mediaSourceListUpdateMessage.f6234d);
        }
        MediaSourceList mediaSourceList = this.t;
        ArrayList arrayList2 = mediaSourceList.f6303b;
        mediaSourceList.g(0, arrayList2.size());
        q(mediaSourceList.a(arrayList2.size(), arrayList, shuffleOrder), false);
    }

    public final void U(boolean z) throws ExoPlaybackException {
        this.B = z;
        G();
        if (this.C) {
            MediaPeriodQueue mediaPeriodQueue = this.s;
            if (mediaPeriodQueue.f6298j != mediaPeriodQueue.f6297i) {
                M(true);
                p(false);
            }
        }
    }

    public final void V(int i2, int i3, boolean z, boolean z2) {
        this.z.a(z2 ? 1 : 0);
        this.y = this.y.d(i3, i2, z);
        l0(false, false);
        for (MediaPeriodHolder mediaPeriodHolder = this.s.f6297i; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f6278l) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.n.f8041c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.o(z);
                }
            }
        }
        if (!c0()) {
            g0();
            j0();
            return;
        }
        int i4 = this.y.f6331e;
        HandlerWrapper handlerWrapper = this.f6224h;
        if (i4 != 3) {
            if (i4 == 2) {
                handlerWrapper.k(2);
                return;
            }
            return;
        }
        DefaultMediaClock defaultMediaClock = this.o;
        defaultMediaClock.f6175f = true;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.f6170a;
        if (!standaloneMediaClock.f6363b) {
            standaloneMediaClock.f6362a.getClass();
            standaloneMediaClock.f6365d = android.os.SystemClock.elapsedRealtime();
            standaloneMediaClock.f6363b = true;
        }
        e0();
        handlerWrapper.k(2);
    }

    public final void W(PlaybackParameters playbackParameters) {
        this.f6224h.l(16);
        DefaultMediaClock defaultMediaClock = this.o;
        defaultMediaClock.D(playbackParameters);
        PlaybackParameters playbackParametersF = defaultMediaClock.F();
        s(playbackParametersF, playbackParametersF.f5427a, true, true);
    }

    public final void X(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.C0 = preloadConfiguration;
        Timeline timeline = this.y.f6327a;
        MediaPeriodQueue mediaPeriodQueue = this.s;
        mediaPeriodQueue.o = preloadConfiguration;
        mediaPeriodQueue.o.getClass();
        if (mediaPeriodQueue.p.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < mediaPeriodQueue.p.size(); i2++) {
            ((MediaPeriodHolder) mediaPeriodQueue.p.get(i2)).g();
        }
        mediaPeriodQueue.p = arrayList;
    }

    public final void Y(int i2) throws ExoPlaybackException {
        this.G = i2;
        Timeline timeline = this.y.f6327a;
        MediaPeriodQueue mediaPeriodQueue = this.s;
        mediaPeriodQueue.f6295g = i2;
        if (!mediaPeriodQueue.p(timeline)) {
            M(true);
        }
        p(false);
    }

    public final void Z(boolean z) throws ExoPlaybackException {
        this.H = z;
        Timeline timeline = this.y.f6327a;
        MediaPeriodQueue mediaPeriodQueue = this.s;
        mediaPeriodQueue.f6296h = z;
        if (!mediaPeriodQueue.p(timeline)) {
            M(true);
        }
        p(false);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.InvalidationListener
    public final void a() {
        this.f6224h.k(10);
    }

    public final void a0(ShuffleOrder shuffleOrder) throws Throwable {
        this.z.a(1);
        MediaSourceList mediaSourceList = this.t;
        int size = mediaSourceList.f6303b.size();
        if (shuffleOrder.getLength() != size) {
            shuffleOrder = shuffleOrder.e().g(0, size);
        }
        mediaSourceList.f6311j = shuffleOrder;
        q(mediaSourceList.b(), false);
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Sender
    public final synchronized void b(PlayerMessage playerMessage) {
        if (!this.A && this.f6226j.getThread().isAlive()) {
            this.f6224h.e(14, playerMessage).a();
            return;
        }
        Log.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.b(false);
    }

    public final void b0(int i2) {
        PlaybackInfo playbackInfo = this.y;
        if (playbackInfo.f6331e != i2) {
            if (i2 != 2) {
                this.B0 = -9223372036854775807L;
            }
            this.y = playbackInfo.g(i2);
        }
    }

    public final boolean c0() {
        PlaybackInfo playbackInfo = this.y;
        return playbackInfo.f6338l && playbackInfo.n == 0;
    }

    public final void d(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i2) throws Throwable {
        this.z.a(1);
        MediaSourceList mediaSourceList = this.t;
        if (i2 == -1) {
            i2 = mediaSourceList.f6303b.size();
        }
        q(mediaSourceList.a(i2, mediaSourceListUpdateMessage.f6231a, mediaSourceListUpdateMessage.f6232b), false);
    }

    public final boolean d0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.b() || timeline.p()) {
            return false;
        }
        int i2 = timeline.g(mediaPeriodId.f7609a, this.f6228l).f5477c;
        Timeline.Window window = this.f6227k;
        timeline.n(i2, window);
        return window.a() && window.f5494i && window.f5491f != -9223372036854775807L;
    }

    public final void e(Renderer renderer) {
        if (v(renderer)) {
            DefaultMediaClock defaultMediaClock = this.o;
            if (renderer == defaultMediaClock.f6172c) {
                defaultMediaClock.f6173d = null;
                defaultMediaClock.f6172c = null;
                defaultMediaClock.f6174e = true;
            }
            if (renderer.getState() == 2) {
                renderer.stop();
            }
            renderer.disable();
            this.L--;
        }
    }

    public final void e0() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        if (mediaPeriodHolder == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.n;
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f6217a;
            if (i2 >= rendererArr.length) {
                return;
            }
            if (trackSelectorResult.b(i2) && rendererArr[i2].getState() == 1) {
                rendererArr[i2].start();
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0368 A[EDGE_INSN: B:444:0x0368->B:199:0x0368 BREAK  A[LOOP:0: B:165:0x02e5->B:198:0x0364], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017d  */
    /* JADX WARN: Type inference failed for: r1v55, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v78, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v69, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 1899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.f():void");
    }

    public final void f0(boolean z, boolean z2) {
        F(z || !this.I, false, true, false);
        this.z.a(z2 ? 1 : 0);
        this.f6222f.h(this.w);
        b0(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(boolean[] r23, long r24) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.g(boolean[], long):void");
    }

    public final void g0() {
        DefaultMediaClock defaultMediaClock = this.o;
        defaultMediaClock.f6175f = false;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.f6170a;
        if (standaloneMediaClock.f6363b) {
            standaloneMediaClock.a(standaloneMediaClock.w());
            standaloneMediaClock.f6363b = false;
        }
        for (Renderer renderer : this.f6217a) {
            if (v(renderer) && renderer.getState() == 2) {
                renderer.stop();
            }
        }
    }

    public final long h(Timeline timeline, Object obj, long j2) {
        Timeline.Period period = this.f6228l;
        int i2 = timeline.g(obj, period).f5477c;
        Timeline.Window window = this.f6227k;
        timeline.n(i2, window);
        if (window.f5491f != -9223372036854775807L && window.a() && window.f5494i) {
            return Util.T(Util.A(window.f5492g) - window.f5491f) - (j2 + period.f5479e);
        }
        return -9223372036854775807L;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final void h0() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6299k;
        boolean z = this.F || (mediaPeriodHolder != null && mediaPeriodHolder.f6267a.b());
        PlaybackInfo playbackInfo = this.y;
        if (z != playbackInfo.f6333g) {
            this.y = new PlaybackInfo(playbackInfo.f6327a, playbackInfo.f6328b, playbackInfo.f6329c, playbackInfo.f6330d, playbackInfo.f6331e, playbackInfo.f6332f, z, playbackInfo.f6334h, playbackInfo.f6335i, playbackInfo.f6336j, playbackInfo.f6337k, playbackInfo.f6338l, playbackInfo.f6339m, playbackInfo.n, playbackInfo.o, playbackInfo.q, playbackInfo.r, playbackInfo.s, playbackInfo.t, playbackInfo.p);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        MediaPeriodHolder mediaPeriodHolder;
        int i2;
        MediaPeriodHolder mediaPeriodHolder2;
        int i3;
        try {
            switch (message.what) {
                case 1:
                    boolean z = message.arg1 != 0;
                    int i4 = message.arg2;
                    V(i4 >> 4, i4 & 15, z, true);
                    break;
                case 2:
                    f();
                    break;
                case 3:
                    N((SeekPosition) message.obj);
                    break;
                case 4:
                    W((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.x = (SeekParameters) message.obj;
                    break;
                case 6:
                    f0(false, true);
                    break;
                case 7:
                    C();
                    return true;
                case 8:
                    r((MediaPeriod) message.obj);
                    break;
                case 9:
                    n((MediaPeriod) message.obj);
                    break;
                case 10:
                    E();
                    break;
                case 11:
                    Y(message.arg1);
                    break;
                case 12:
                    Z(message.arg1 != 0);
                    break;
                case 13:
                    S(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    PlayerMessage playerMessage = (PlayerMessage) message.obj;
                    playerMessage.getClass();
                    P(playerMessage);
                    break;
                case 15:
                    Q((PlayerMessage) message.obj);
                    break;
                case 16:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    s(playbackParameters, playbackParameters.f5427a, true, false);
                    break;
                case 17:
                    T((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    d((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    A((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    D(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    a0((ShuffleOrder) message.obj);
                    break;
                case 22:
                    z();
                    break;
                case 23:
                    U(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    E();
                    M(true);
                    break;
                case 26:
                    E();
                    M(true);
                    break;
                case 27:
                    i0(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    X((ExoPlayer.PreloadConfiguration) message.obj);
                    break;
                case 29:
                    B();
                    break;
            }
        } catch (ParserException e2) {
            boolean z2 = e2.f5411a;
            int i5 = e2.f5412b;
            if (i5 == 1) {
                i3 = z2 ? 3001 : 3003;
            } else {
                if (i5 == 4) {
                    i3 = z2 ? 3002 : 3004;
                }
                o(e2, i);
            }
            i = i3;
            o(e2, i);
        } catch (DataSourceException e3) {
            o(e3, e3.f5845a);
        } catch (ExoPlaybackException e4) {
            e = e4;
            int i6 = e.f6179j;
            MediaPeriodQueue mediaPeriodQueue = this.s;
            if (i6 == 1 && (mediaPeriodHolder2 = mediaPeriodQueue.f6298j) != null) {
                e = e.d(mediaPeriodHolder2.f6272f.f6280a);
            }
            if (e.p && (this.A0 == null || (i2 = e.f5421a) == 5004 || i2 == 5003)) {
                Log.i("ExoPlayerImplInternal", "Recoverable renderer error", e);
                ExoPlaybackException exoPlaybackException = this.A0;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.A0;
                } else {
                    this.A0 = e;
                }
                HandlerWrapper handlerWrapper = this.f6224h;
                handlerWrapper.h(handlerWrapper.e(25, e));
            } else {
                ExoPlaybackException exoPlaybackException2 = this.A0;
                if (exoPlaybackException2 != null) {
                    exoPlaybackException2.addSuppressed(e);
                    e = this.A0;
                }
                Log.e("ExoPlayerImplInternal", "Playback error", e);
                if (e.f6179j == 1 && mediaPeriodQueue.f6297i != mediaPeriodQueue.f6298j) {
                    while (true) {
                        mediaPeriodHolder = mediaPeriodQueue.f6297i;
                        if (mediaPeriodHolder == mediaPeriodQueue.f6298j) {
                            break;
                        }
                        mediaPeriodQueue.a();
                    }
                    mediaPeriodHolder.getClass();
                    y();
                    MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f6272f;
                    MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f6280a;
                    long j2 = mediaPeriodInfo.f6281b;
                    this.y = t(mediaPeriodId, j2, mediaPeriodInfo.f6282c, j2, true, 0);
                }
                f0(true, false);
                this.y = this.y.e(e);
            }
        } catch (DrmSession.DrmSessionException e5) {
            o(e5, e5.f6923a);
        } catch (BehindLiveWindowException e6) {
            o(e6, 1002);
        } catch (IOException e7) {
            o(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackException3 = new ExoPlaybackException(2, e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException3);
            f0(true, false);
            this.y = this.y.e(exoPlaybackException3);
        }
        y();
        return true;
    }

    public final long i() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6298j;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long jMax = mediaPeriodHolder.o;
        if (!mediaPeriodHolder.f6270d) {
            return jMax;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f6217a;
            if (i2 >= rendererArr.length) {
                return jMax;
            }
            if (v(rendererArr[i2]) && rendererArr[i2].j() == mediaPeriodHolder.f6269c[i2]) {
                long jZ = rendererArr[i2].z();
                if (jZ == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(jZ, jMax);
            }
            i2++;
        }
    }

    public final void i0(int i2, int i3, List list) throws Throwable {
        this.z.a(1);
        MediaSourceList mediaSourceList = this.t;
        mediaSourceList.getClass();
        ArrayList arrayList = mediaSourceList.f6303b;
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= arrayList.size());
        Assertions.a(list.size() == i3 - i2);
        for (int i4 = i2; i4 < i3; i4++) {
            ((MediaSourceList.MediaSourceHolder) arrayList.get(i4)).f6319a.O((MediaItem) list.get(i4 - i2));
        }
        q(mediaSourceList.b(), false);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void j(MediaPeriod mediaPeriod) {
        this.f6224h.e(8, mediaPeriod).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r2v24, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0() {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.j0():void");
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        this.f6224h.e(9, (MediaPeriod) sequenceableLoader).a();
    }

    public final void k0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j2, boolean z) {
        if (!d0(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.b() ? PlaybackParameters.f5424d : this.y.o;
            DefaultMediaClock defaultMediaClock = this.o;
            if (defaultMediaClock.F().equals(playbackParameters)) {
                return;
            }
            this.f6224h.l(16);
            defaultMediaClock.D(playbackParameters);
            s(this.y.o, playbackParameters.f5427a, false, false);
            return;
        }
        Object obj = mediaPeriodId.f7609a;
        Timeline.Period period = this.f6228l;
        int i2 = timeline.g(obj, period).f5477c;
        Timeline.Window window = this.f6227k;
        timeline.n(i2, window);
        MediaItem.LiveConfiguration liveConfiguration = window.f5495j;
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = this.u;
        defaultLivePlaybackSpeedControl.getClass();
        defaultLivePlaybackSpeedControl.f6145d = Util.T(liveConfiguration.f5324a);
        defaultLivePlaybackSpeedControl.f6148g = Util.T(liveConfiguration.f5325b);
        defaultLivePlaybackSpeedControl.f6149h = Util.T(liveConfiguration.f5326c);
        float f2 = liveConfiguration.f5327d;
        if (f2 == -3.4028235E38f) {
            f2 = 0.97f;
        }
        defaultLivePlaybackSpeedControl.f6152k = f2;
        float f3 = liveConfiguration.f5328e;
        if (f3 == -3.4028235E38f) {
            f3 = 1.03f;
        }
        defaultLivePlaybackSpeedControl.f6151j = f3;
        if (f2 == 1.0f && f3 == 1.0f) {
            defaultLivePlaybackSpeedControl.f6145d = -9223372036854775807L;
        }
        defaultLivePlaybackSpeedControl.a();
        if (j2 != -9223372036854775807L) {
            defaultLivePlaybackSpeedControl.b(h(timeline, obj, j2));
            return;
        }
        if (!Util.a(!timeline2.p() ? timeline2.m(timeline2.g(mediaPeriodId2.f7609a, period).f5477c, window, 0L).f5486a : null, window.f5486a) || z) {
            defaultLivePlaybackSpeedControl.b(-9223372036854775807L);
        }
    }

    public final Pair l(Timeline timeline) {
        if (timeline.p()) {
            return Pair.create(PlaybackInfo.u, 0L);
        }
        Pair pairI = timeline.i(this.f6227k, this.f6228l, timeline.a(this.H), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdN = this.s.n(timeline, pairI.first, 0L);
        long jLongValue = ((Long) pairI.second).longValue();
        if (mediaPeriodIdN.b()) {
            Object obj = mediaPeriodIdN.f7609a;
            Timeline.Period period = this.f6228l;
            timeline.g(obj, period);
            jLongValue = mediaPeriodIdN.f7611c == period.d(mediaPeriodIdN.f7610b) ? period.f5481g.f5126c : 0L;
        }
        return Pair.create(mediaPeriodIdN, Long.valueOf(jLongValue));
    }

    public final void l0(boolean z, boolean z2) {
        long jElapsedRealtime;
        this.D = z;
        if (!z || z2) {
            jElapsedRealtime = -9223372036854775807L;
        } else {
            this.q.getClass();
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        this.E = jElapsedRealtime;
    }

    public final synchronized void m0(o oVar, long j2) {
        this.q.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() + j2;
        boolean z = false;
        while (!((Boolean) oVar.get()).booleanValue() && j2 > 0) {
            try {
                this.q.getClass();
                wait(j2);
            } catch (InterruptedException unused) {
                z = true;
            }
            this.q.getClass();
            j2 = jElapsedRealtime - android.os.SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final void n(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6299k;
        if (mediaPeriodHolder == null || mediaPeriodHolder.f6267a != mediaPeriod) {
            return;
        }
        long j2 = this.Q;
        if (mediaPeriodHolder != null) {
            Assertions.g(mediaPeriodHolder.f6278l == null);
            if (mediaPeriodHolder.f6270d) {
                mediaPeriodHolder.f6267a.s(j2 - mediaPeriodHolder.o);
            }
        }
        x();
    }

    public final void o(IOException iOException, int i2) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i2);
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        if (mediaPeriodHolder != null) {
            exoPlaybackException = exoPlaybackException.d(mediaPeriodHolder.f6272f.f6280a);
        }
        Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        f0(false, false);
        this.y = this.y.e(exoPlaybackException);
    }

    public final void p(boolean z) {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6299k;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolder == null ? this.y.f6328b : mediaPeriodHolder.f6272f.f6280a;
        boolean zEquals = this.y.f6337k.equals(mediaPeriodId);
        if (!zEquals) {
            this.y = this.y.b(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.y;
        playbackInfo.q = mediaPeriodHolder == null ? playbackInfo.s : mediaPeriodHolder.d();
        PlaybackInfo playbackInfo2 = this.y;
        long j2 = playbackInfo2.q;
        MediaPeriodHolder mediaPeriodHolder2 = this.s.f6299k;
        playbackInfo2.r = mediaPeriodHolder2 != null ? Math.max(0L, j2 - (this.Q - mediaPeriodHolder2.o)) : 0L;
        if ((!zEquals || z) && mediaPeriodHolder != null && mediaPeriodHolder.f6270d) {
            this.f6222f.i(this.w, this.y.f6327a, mediaPeriodHolder.f6272f.f6280a, this.f6217a, mediaPeriodHolder.f6279m, mediaPeriodHolder.n.f8041c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0227 A[PHI: r4
      0x0227: PHI (r4v32 long) = (r4v31 long), (r4v33 long) binds: [B:103:0x021d, B:106:0x0225] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0202  */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r2v49, types: [androidx.media3.exoplayer.MediaPeriodQueue] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [int] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v33, types: [androidx.media3.common.Timeline] */
    /* JADX WARN: Type inference failed for: r7v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(androidx.media3.common.Timeline r35, boolean r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.q(androidx.media3.common.Timeline, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    public final void r(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        MediaPeriodQueue mediaPeriodQueue = this.s;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.f6299k;
        if (mediaPeriodHolder == null || mediaPeriodHolder.f6267a != mediaPeriod) {
            return;
        }
        float f2 = this.o.F().f5427a;
        Timeline timeline = this.y.f6327a;
        mediaPeriodHolder.f6270d = true;
        mediaPeriodHolder.f6279m = mediaPeriodHolder.f6267a.p();
        TrackSelectorResult trackSelectorResultH = mediaPeriodHolder.h(f2, timeline);
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f6272f;
        long j2 = mediaPeriodInfo.f6284e;
        long jMax = mediaPeriodInfo.f6281b;
        if (j2 != -9223372036854775807L && jMax >= j2) {
            jMax = Math.max(0L, j2 - 1);
        }
        long jA = mediaPeriodHolder.a(trackSelectorResultH, jMax, false, new boolean[mediaPeriodHolder.f6275i.length]);
        long j3 = mediaPeriodHolder.o;
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f6272f;
        mediaPeriodHolder.o = (mediaPeriodInfo2.f6281b - jA) + j3;
        MediaPeriodInfo mediaPeriodInfoB = mediaPeriodInfo2.b(jA);
        mediaPeriodHolder.f6272f = mediaPeriodInfoB;
        TrackGroupArray trackGroupArray = mediaPeriodHolder.f6279m;
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.n;
        Timeline timeline2 = this.y.f6327a;
        ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.f8041c;
        this.f6222f.i(this.w, timeline2, mediaPeriodInfoB.f6280a, this.f6217a, trackGroupArray, exoTrackSelectionArr);
        if (mediaPeriodHolder == mediaPeriodQueue.f6297i) {
            H(mediaPeriodHolder.f6272f.f6281b);
            g(new boolean[this.f6217a.length], mediaPeriodQueue.f6298j.e());
            PlaybackInfo playbackInfo = this.y;
            MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f6328b;
            long j4 = mediaPeriodHolder.f6272f.f6281b;
            this.y = t(mediaPeriodId, j4, playbackInfo.f6329c, j4, false, 5);
        }
        x();
    }

    public final void s(PlaybackParameters playbackParameters, float f2, boolean z, boolean z2) {
        int i2;
        if (z) {
            if (z2) {
                this.z.a(1);
            }
            this.y = this.y.f(playbackParameters);
        }
        float f3 = playbackParameters.f5427a;
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        while (true) {
            i2 = 0;
            if (mediaPeriodHolder == null) {
                break;
            }
            ExoTrackSelection[] exoTrackSelectionArr = mediaPeriodHolder.n.f8041c;
            int length = exoTrackSelectionArr.length;
            while (i2 < length) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
                if (exoTrackSelection != null) {
                    exoTrackSelection.i(f3);
                }
                i2++;
            }
            mediaPeriodHolder = mediaPeriodHolder.f6278l;
        }
        Renderer[] rendererArr = this.f6217a;
        int length2 = rendererArr.length;
        while (i2 < length2) {
            Renderer renderer = rendererArr[i2];
            if (renderer != null) {
                renderer.x(f2, playbackParameters.f5427a);
            }
            i2++;
        }
    }

    public final PlaybackInfo t(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, boolean z, int i2) {
        boolean z2;
        this.Z = (!this.Z && j2 == this.y.s && mediaPeriodId.equals(this.y.f6328b)) ? false : true;
        G();
        PlaybackInfo playbackInfo = this.y;
        TrackGroupArray trackGroupArray = playbackInfo.f6334h;
        TrackSelectorResult trackSelectorResult = playbackInfo.f6335i;
        List listR = playbackInfo.f6336j;
        if (this.t.f6312k) {
            MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
            trackGroupArray = mediaPeriodHolder == null ? TrackGroupArray.f7769d : mediaPeriodHolder.f6279m;
            trackSelectorResult = mediaPeriodHolder == null ? this.f6221e : mediaPeriodHolder.n;
            ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.f8041c;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            boolean z3 = false;
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Metadata metadata = exoTrackSelection.e(0).f5223k;
                    if (metadata == null) {
                        builder.h(new Metadata(new Metadata.Entry[0]));
                    } else {
                        builder.h(metadata);
                        z3 = true;
                    }
                }
            }
            listR = z3 ? builder.j() : ImmutableList.r();
            if (mediaPeriodHolder != null) {
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f6272f;
                if (mediaPeriodInfo.f6282c != j3) {
                    mediaPeriodHolder.f6272f = mediaPeriodInfo.a(j3);
                }
            }
            MediaPeriodHolder mediaPeriodHolder2 = this.s.f6297i;
            if (mediaPeriodHolder2 != null) {
                TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder2.n;
                int i3 = 0;
                boolean z4 = false;
                while (true) {
                    Renderer[] rendererArr = this.f6217a;
                    if (i3 >= rendererArr.length) {
                        z2 = true;
                        break;
                    }
                    if (trackSelectorResult2.b(i3)) {
                        if (rendererArr[i3].g() != 1) {
                            z2 = false;
                            break;
                        }
                        if (trackSelectorResult2.f8040b[i3].f6357a != 0) {
                            z4 = true;
                        }
                    }
                    i3++;
                }
                boolean z5 = z4 && z2;
                if (z5 != this.K) {
                    this.K = z5;
                    if (!z5 && this.y.p) {
                        this.f6224h.k(2);
                    }
                }
            }
        } else if (!mediaPeriodId.equals(playbackInfo.f6328b)) {
            trackGroupArray = TrackGroupArray.f7769d;
            trackSelectorResult = this.f6221e;
            listR = ImmutableList.r();
        }
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult;
        List list = listR;
        if (z) {
            PlaybackInfoUpdate playbackInfoUpdate = this.z;
            if (!playbackInfoUpdate.f6242d || playbackInfoUpdate.f6243e == 5) {
                playbackInfoUpdate.f6239a = true;
                playbackInfoUpdate.f6242d = true;
                playbackInfoUpdate.f6243e = i2;
            } else {
                Assertions.a(i2 == 5);
            }
        }
        PlaybackInfo playbackInfo2 = this.y;
        long j5 = playbackInfo2.q;
        MediaPeriodHolder mediaPeriodHolder3 = this.s.f6299k;
        return playbackInfo2.c(mediaPeriodId, j2, j3, j4, mediaPeriodHolder3 == null ? 0L : Math.max(0L, j5 - (this.Q - mediaPeriodHolder3.o)), trackGroupArray2, trackSelectorResult3, list);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final boolean u() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6299k;
        if (mediaPeriodHolder != null) {
            try {
                ?? r2 = mediaPeriodHolder.f6267a;
                if (mediaPeriodHolder.f6270d) {
                    for (SampleStream sampleStream : mediaPeriodHolder.f6269c) {
                        if (sampleStream != null) {
                            sampleStream.c();
                        }
                    }
                } else {
                    r2.l();
                }
                if ((!mediaPeriodHolder.f6270d ? 0L : r2.f()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public final boolean w() {
        MediaPeriodHolder mediaPeriodHolder = this.s.f6297i;
        long j2 = mediaPeriodHolder.f6272f.f6284e;
        if (mediaPeriodHolder.f6270d) {
            return j2 == -9223372036854775807L || this.y.s < j2 || !c0();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final void x() {
        long j2;
        long j3;
        boolean zG;
        if (u()) {
            MediaPeriodHolder mediaPeriodHolder = this.s.f6299k;
            long jF = !mediaPeriodHolder.f6270d ? 0L : mediaPeriodHolder.f6267a.f();
            MediaPeriodHolder mediaPeriodHolder2 = this.s.f6299k;
            long jMax = mediaPeriodHolder2 == null ? 0L : Math.max(0L, jF - (this.Q - mediaPeriodHolder2.o));
            if (mediaPeriodHolder == this.s.f6297i) {
                j2 = this.Q;
                j3 = mediaPeriodHolder.o;
            } else {
                j2 = this.Q - mediaPeriodHolder.o;
                j3 = mediaPeriodHolder.f6272f.f6281b;
            }
            long j4 = j2 - j3;
            long j5 = d0(this.y.f6327a, mediaPeriodHolder.f6272f.f6280a) ? this.u.f6150i : -9223372036854775807L;
            PlayerId playerId = this.w;
            Timeline timeline = this.y.f6327a;
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolder.f6272f.f6280a;
            float f2 = this.o.F().f5427a;
            boolean z = this.y.f6338l;
            LoadControl.Parameters parameters = new LoadControl.Parameters(playerId, timeline, mediaPeriodId, j4, jMax, f2, this.D, j5);
            zG = this.f6222f.g(parameters);
            MediaPeriodHolder mediaPeriodHolder3 = this.s.f6297i;
            if (!zG && mediaPeriodHolder3.f6270d && jMax < 500000 && (this.f6229m > 0 || this.n)) {
                mediaPeriodHolder3.f6267a.r(this.y.s, false);
                zG = this.f6222f.g(parameters);
            }
        } else {
            zG = false;
        }
        this.F = zG;
        if (zG) {
            MediaPeriodHolder mediaPeriodHolder4 = this.s.f6299k;
            long j6 = this.Q;
            float f3 = this.o.F().f5427a;
            long j7 = this.E;
            Assertions.g(mediaPeriodHolder4.f6278l == null);
            long j8 = j6 - mediaPeriodHolder4.o;
            ?? r1 = mediaPeriodHolder4.f6267a;
            LoadingInfo.Builder builder = new LoadingInfo.Builder();
            builder.f6264a = j8;
            Assertions.a(f3 > 0.0f || f3 == -3.4028235E38f);
            builder.f6265b = f3;
            Assertions.a(j7 >= 0 || j7 == -9223372036854775807L);
            builder.f6266c = j7;
            r1.e(new LoadingInfo(builder));
        }
        h0();
    }

    public final void y() {
        PlaybackInfoUpdate playbackInfoUpdate = this.z;
        PlaybackInfo playbackInfo = this.y;
        boolean z = playbackInfoUpdate.f6239a | (playbackInfoUpdate.f6240b != playbackInfo);
        playbackInfoUpdate.f6239a = z;
        playbackInfoUpdate.f6240b = playbackInfo;
        if (z) {
            this.r.a(playbackInfoUpdate);
            this.z = new PlaybackInfoUpdate(this.y);
        }
    }

    public final void z() throws Throwable {
        q(this.t.b(), true);
    }
}
