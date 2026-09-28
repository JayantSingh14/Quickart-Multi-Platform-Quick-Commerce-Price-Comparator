package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultAnalyticsCollector implements AnalyticsCollector {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f6381a;

    /* renamed from: b, reason: collision with root package name */
    public final Timeline.Period f6382b;

    /* renamed from: c, reason: collision with root package name */
    public final Timeline.Window f6383c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaPeriodQueueTracker f6384d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f6385e;

    /* renamed from: f, reason: collision with root package name */
    public ListenerSet f6386f;

    /* renamed from: g, reason: collision with root package name */
    public Player f6387g;

    /* renamed from: h, reason: collision with root package name */
    public HandlerWrapper f6388h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6389i;

    public static final class MediaPeriodQueueTracker {

        /* renamed from: a, reason: collision with root package name */
        public final Timeline.Period f6390a;

        /* renamed from: b, reason: collision with root package name */
        public ImmutableList f6391b = ImmutableList.r();

        /* renamed from: c, reason: collision with root package name */
        public ImmutableMap f6392c = ImmutableMap.j();

        /* renamed from: d, reason: collision with root package name */
        public MediaSource.MediaPeriodId f6393d;

        /* renamed from: e, reason: collision with root package name */
        public MediaSource.MediaPeriodId f6394e;

        /* renamed from: f, reason: collision with root package name */
        public MediaSource.MediaPeriodId f6395f;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.f6390a = period;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MediaSource.MediaPeriodId b(Player player, ImmutableList immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            int iB;
            Timeline timelineF0 = player.F0();
            int iT0 = player.T0();
            Object objL = timelineF0.p() ? null : timelineF0.l(iT0);
            if (player.f0() || timelineF0.p()) {
                iB = -1;
            } else {
                Timeline.Period periodF = timelineF0.f(iT0, period, false);
                iB = periodF.f5481g.b(Util.T(player.z1()) - period.f5479e, periodF.f5478d);
            }
            int i2 = iB;
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) immutableList.get(i3);
                if (c(mediaPeriodId2, objL, player.f0(), player.B0(), player.a1(), i2)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null && c(mediaPeriodId, objL, player.f0(), player.B0(), player.a1(), i2)) {
                return mediaPeriodId;
            }
            return null;
        }

        public static boolean c(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i2, int i3, int i4) {
            if (!mediaPeriodId.f7609a.equals(obj)) {
                return false;
            }
            int i5 = mediaPeriodId.f7610b;
            if (z && i5 == i2 && mediaPeriodId.f7611c == i3) {
                return true;
            }
            return !z && i5 == -1 && mediaPeriodId.f7613e == i4;
        }

        public final void a(ImmutableMap.Builder builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.b(mediaPeriodId.f7609a) != -1) {
                builder.c(mediaPeriodId, timeline);
                return;
            }
            Timeline timeline2 = (Timeline) this.f6392c.get(mediaPeriodId);
            if (timeline2 != null) {
                builder.c(mediaPeriodId, timeline2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d(Timeline timeline) {
            ImmutableMap.Builder builder = new ImmutableMap.Builder();
            if (this.f6391b.isEmpty()) {
                a(builder, this.f6394e, timeline);
                if (!Objects.a(this.f6395f, this.f6394e)) {
                    a(builder, this.f6395f, timeline);
                }
                if (!Objects.a(this.f6393d, this.f6394e) && !Objects.a(this.f6393d, this.f6395f)) {
                    a(builder, this.f6393d, timeline);
                }
            } else {
                for (int i2 = 0; i2 < this.f6391b.size(); i2++) {
                    a(builder, (MediaSource.MediaPeriodId) this.f6391b.get(i2), timeline);
                }
                if (!this.f6391b.contains(this.f6393d)) {
                    a(builder, this.f6393d, timeline);
                }
            }
            this.f6392c = builder.a(true);
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        clock.getClass();
        this.f6381a = clock;
        int i2 = Util.f5744a;
        Looper looperMyLooper = Looper.myLooper();
        this.f6386f = new ListenerSet(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, clock, new androidx.media3.common.b(29));
        Timeline.Period period = new Timeline.Period();
        this.f6382b = period;
        this.f6383c = new Timeline.Window();
        this.f6384d = new MediaPeriodQueueTracker(period);
        this.f6385e = new SparseArray();
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void A() {
        if (this.f6389i) {
            return;
        }
        AnalyticsListener.EventTime eventTimeC = C();
        this.f6389i = true;
        L(eventTimeC, -1, new androidx.media3.common.b(eventTimeC, 10));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void A1(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 20, new d(4, eventTimeJ, audioAttributes));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1000, new p(eventTimeI, loadEventInfo, mediaLoadData));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void B1(Timeline timeline, int i2) {
        Player player = this.f6387g;
        player.getClass();
        MediaPeriodQueueTracker mediaPeriodQueueTracker = this.f6384d;
        mediaPeriodQueueTracker.f6393d = MediaPeriodQueueTracker.b(player, mediaPeriodQueueTracker.f6391b, mediaPeriodQueueTracker.f6394e, mediaPeriodQueueTracker.f6390a);
        mediaPeriodQueueTracker.d(player.F0());
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 0, new b(i2, 2, (Object) eventTimeC));
    }

    public final AnalyticsListener.EventTime C() {
        return F(this.f6384d.f6393d);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void C1(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 15, new androidx.media3.common.b(eventTimeC, mediaMetadata, 28));
    }

    public final AnalyticsListener.EventTime D(Timeline timeline, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.p() ? null : mediaPeriodId;
        long jElapsedRealtime = this.f6381a.elapsedRealtime();
        boolean z = timeline.equals(this.f6387g.F0()) && i2 == this.f6387g.l1();
        long jJ0 = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.b()) {
            if (z) {
                jJ0 = this.f6387g.f1();
            } else if (!timeline.p()) {
                jJ0 = Util.j0(timeline.m(i2, this.f6383c, 0L).f5497l);
            }
        } else if (z && this.f6387g.B0() == mediaPeriodId2.f7610b && this.f6387g.a1() == mediaPeriodId2.f7611c) {
            jJ0 = this.f6387g.z1();
        }
        return new AnalyticsListener.EventTime(jElapsedRealtime, timeline, i2, mediaPeriodId2, jJ0, this.f6387g.F0(), this.f6387g.l1(), this.f6384d.f6393d, this.f6387g.z1(), this.f6387g.g0());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void D1(long j2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 17, new androidx.media3.common.b(eventTimeC, j2, 22, (byte) 0));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1023, new c(eventTimeI, 5));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void E1(Tracks tracks) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 2, new d(2, eventTimeC, tracks));
    }

    public final AnalyticsListener.EventTime F(MediaSource.MediaPeriodId mediaPeriodId) {
        this.f6387g.getClass();
        Timeline timeline = mediaPeriodId == null ? null : (Timeline) this.f6384d.f6392c.get(mediaPeriodId);
        if (mediaPeriodId != null && timeline != null) {
            return D(timeline, timeline.g(mediaPeriodId.f7609a, this.f6382b).f5477c, mediaPeriodId);
        }
        int iL1 = this.f6387g.l1();
        Timeline timelineF0 = this.f6387g.F0();
        if (iL1 >= timelineF0.o()) {
            timelineF0 = Timeline.f5466a;
        }
        return D(timelineF0, iL1, null);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void F1(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 29, new androidx.media3.common.b(eventTimeC, deviceInfo, 27));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1022, new b(i3, 1, (Object) eventTimeI));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void G1(int i2, boolean z) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, -1, new androidx.media3.common.b(eventTimeC, z, i2));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void H(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1003, new q(eventTimeI, loadEventInfo, mediaLoadData, iOException, z));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void H1(PlaybackException playbackException) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.EventTime eventTimeC = (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).o) == null) ? C() : F(mediaPeriodId);
        L(eventTimeC, 10, new androidx.media3.common.b(eventTimeC, playbackException, 25));
    }

    public final AnalyticsListener.EventTime I(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f6387g.getClass();
        if (mediaPeriodId != null) {
            return ((Timeline) this.f6384d.f6392c.get(mediaPeriodId)) != null ? F(mediaPeriodId) : D(Timeline.f5466a, i2, mediaPeriodId);
        }
        Timeline timelineF0 = this.f6387g.F0();
        if (i2 >= timelineF0.o()) {
            timelineF0 = Timeline.f5466a;
        }
        return D(timelineF0, i2, null);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void I1(long j2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 18, new androidx.media3.common.b(eventTimeC, j2, 19, (byte) 0));
    }

    public final AnalyticsListener.EventTime J() {
        return F(this.f6384d.f6395f);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void J1(boolean z) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 7, new h(eventTimeC, z, 1));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1024, new d(0, eventTimeI, exc));
    }

    public final void L(AnalyticsListener.EventTime eventTime, int i2, ListenerSet.Event event) {
        this.f6385e.put(i2, eventTime);
        this.f6386f.f(i2, event);
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void M(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1002, new androidx.media3.common.b(eventTimeI, loadEventInfo, mediaLoadData, 12));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void P(AnalyticsListener analyticsListener) {
        this.f6386f.a(analyticsListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void Q(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, DateUtils.SEMI_MONTH, new androidx.media3.common.b(eventTimeI, loadEventInfo, mediaLoadData, 13));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1004, new g(eventTimeI, mediaLoadData, 1));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1025, new c(eventTimeI, 4));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void Y(AnalyticsListener analyticsListener) {
        this.f6386f.e(analyticsListener);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1027, new c(eventTimeI, 2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void a(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1031, new o(eventTimeJ, audioTrackConfig, 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void b(VideoSize videoSize) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 25, new d(7, eventTimeJ, videoSize));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void b0(Player player, Looper looper) {
        Assertions.g(this.f6387g == null || this.f6384d.f6391b.isEmpty());
        player.getClass();
        this.f6387g = player;
        this.f6388h = this.f6381a.a(looper, null);
        ListenerSet listenerSet = this.f6386f;
        this.f6386f = new ListenerSet(listenerSet.f5690d, looper, listenerSet.f5687a, new d(9, this, player), listenerSet.f5695i);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void c(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1032, new o(eventTimeJ, audioTrackConfig, 1));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void d(boolean z) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 23, new h(eventTimeJ, z, 3));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void d1(int i2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 8, new b(i2, 6, (Object) eventTimeC));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void e(Exception exc) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1014, new androidx.media3.common.b(eventTimeJ, exc, 15));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void e1(CueGroup cueGroup) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 27, new androidx.media3.common.b(eventTimeC, cueGroup, 16));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void f(String str) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1019, new a(eventTimeJ, str, 1));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void f1(Metadata metadata) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 28, new d(5, eventTimeC, metadata));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void g(String str) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1012, new a(eventTimeJ, str, 3));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void g1(int i2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 6, new b(i2, 4, (Object) eventTimeC));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void h(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime eventTimeI = I(i2, mediaPeriodId);
        L(eventTimeI, 1005, new g(eventTimeI, mediaLoadData, 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void h1(boolean z) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void i(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1007, new c(eventTimeJ, decoderCounters, 3));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void i1(int i2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 4, new b(i2, 5, (Object) eventTimeC));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void j(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1015, new c(eventTimeJ, decoderCounters, 1));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void j1(int i2, MediaItem mediaItem) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 1, new b(eventTimeC, mediaItem, i2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void k(List list) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 27, new l(eventTimeC, list));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void k1(boolean z) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 9, new h(eventTimeC, z, 2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void l(long j2) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1010, new p(eventTimeJ, j2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void l1(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 12, new d(1, eventTimeC, playbackParameters));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void m(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1009, new e(eventTimeJ, format, decoderReuseEvaluation, 1));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void m1(int i2, boolean z) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 30, new androidx.media3.common.b(eventTimeC, i2, z));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void n(Exception exc) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1030, new p(eventTimeJ, exc));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void n1(long j2) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 16, new androidx.media3.common.b(eventTimeC, j2, 18, (byte) 0));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void o(long j2, Object obj) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 26, new d(eventTimeJ, obj, j2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void o1(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 14, new androidx.media3.common.b(eventTimeC, mediaMetadata, 17));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void p(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeF = F(this.f6384d.f6394e);
        L(eventTimeF, 1013, new c(eventTimeF, decoderCounters, 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void p1(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 19, new androidx.media3.common.b(eventTimeC, trackSelectionParameters, 20));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void q(long j2, long j3, String str) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1008, new a(eventTimeJ, str, j3, j2, 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void q1() {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void r(int i2, long j2) {
        AnalyticsListener.EventTime eventTimeF = F(this.f6384d.f6394e);
        L(eventTimeF, 1021, new androidx.media3.common.b(i2, j2, eventTimeF));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void r1(PlaybackException playbackException) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.EventTime eventTimeC = (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).o) == null) ? C() : F(mediaPeriodId);
        L(eventTimeC, 10, new d(6, eventTimeC, playbackException));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void release() {
        HandlerWrapper handlerWrapper = this.f6388h;
        Assertions.h(handlerWrapper);
        handlerWrapper.i(new androidx.constraintlayout.helper.widget.a(this, 2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void s(final long j2, final long j3, final int i2) {
        final AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1011, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.j
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).y(eventTimeJ, i2, j2, j3);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void s1(final int i2, final int i3) {
        final AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 24, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.n
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t(eventTimeJ, i2, i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void t(int i2, long j2) {
        AnalyticsListener.EventTime eventTimeF = F(this.f6384d.f6394e);
        L(eventTimeF, 1018, new b(i2, j2, eventTimeF));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void t1(Player.Commands commands) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 13, new androidx.media3.common.b(eventTimeC, commands, 23));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void u(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1017, new e(eventTimeJ, format, decoderReuseEvaluation, 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void u1(int i2) {
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void v(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime eventTimeF = F(this.f6384d.f6394e);
        L(eventTimeF, 1020, new d(3, eventTimeF, decoderCounters));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void v1(final int i2, final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2) {
        if (i2 == 1) {
            this.f6389i = false;
        }
        Player player = this.f6387g;
        player.getClass();
        MediaPeriodQueueTracker mediaPeriodQueueTracker = this.f6384d;
        mediaPeriodQueueTracker.f6393d = MediaPeriodQueueTracker.b(player, mediaPeriodQueueTracker.f6391b, mediaPeriodQueueTracker.f6394e, mediaPeriodQueueTracker.f6390a);
        final AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 11, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.m
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                AnalyticsListener.EventTime eventTime = eventTimeC;
                analyticsListener.getClass();
                analyticsListener.n(i2, positionInfo, positionInfo2, eventTime);
            }
        });
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void w(Exception exc) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1029, new androidx.media3.common.b(eventTimeJ, exc, 14));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void w1(boolean z) {
        AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 3, new h(eventTimeC, z, 0));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void x(long j2, long j3, String str) {
        AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 1016, new a(eventTimeJ, str, j3, j2, 2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void x1(Player player, Player.Events events) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsCollector
    public final void y(List list, MediaSource.MediaPeriodId mediaPeriodId) {
        Player player = this.f6387g;
        player.getClass();
        MediaPeriodQueueTracker mediaPeriodQueueTracker = this.f6384d;
        mediaPeriodQueueTracker.getClass();
        mediaPeriodQueueTracker.f6391b = ImmutableList.o(list);
        if (!((AbstractCollection) list).isEmpty()) {
            mediaPeriodQueueTracker.f6394e = (MediaSource.MediaPeriodId) list.get(0);
            mediaPeriodId.getClass();
            mediaPeriodQueueTracker.f6395f = mediaPeriodId;
        }
        if (mediaPeriodQueueTracker.f6393d == null) {
            mediaPeriodQueueTracker.f6393d = MediaPeriodQueueTracker.b(player, mediaPeriodQueueTracker.f6391b, mediaPeriodQueueTracker.f6394e, mediaPeriodQueueTracker.f6390a);
        }
        mediaPeriodQueueTracker.d(player.F0());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void y1(final int i2, final boolean z) {
        final AnalyticsListener.EventTime eventTimeC = C();
        L(eventTimeC, 5, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.k
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).m(eventTimeC, i2, z);
            }
        });
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener
    public final void z(final long j2, final long j3, final int i2) {
        MediaPeriodQueueTracker mediaPeriodQueueTracker = this.f6384d;
        final AnalyticsListener.EventTime eventTimeF = F(mediaPeriodQueueTracker.f6391b.isEmpty() ? null : (MediaSource.MediaPeriodId) Iterables.c(mediaPeriodQueueTracker.f6391b));
        L(eventTimeF, 1006, new ListenerSet.Event(i2, j2, j3) { // from class: androidx.media3.exoplayer.analytics.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f6457b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f6458c;

            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).H(this.f6457b, this.f6458c, this.f6456a);
            }
        });
    }

    @Override // androidx.media3.common.Player.Listener
    public final void z1(final float f2) {
        final AnalyticsListener.EventTime eventTimeJ = J();
        L(eventTimeJ, 22, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.analytics.i
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).v(eventTimeJ, f2);
            }
        });
    }
}
