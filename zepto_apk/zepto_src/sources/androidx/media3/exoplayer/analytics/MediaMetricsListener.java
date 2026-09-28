package androidx.media3.exoplayer.analytics;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.util.HashMap;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6412a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultPlaybackSessionManager f6413b;

    /* renamed from: c, reason: collision with root package name */
    public final PlaybackSession f6414c;

    /* renamed from: i, reason: collision with root package name */
    public String f6420i;

    /* renamed from: j, reason: collision with root package name */
    public PlaybackMetrics.Builder f6421j;

    /* renamed from: k, reason: collision with root package name */
    public int f6422k;
    public PlaybackException n;
    public PendingFormatUpdate o;
    public PendingFormatUpdate p;
    public PendingFormatUpdate q;
    public Format r;
    public Format s;
    public Format t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;

    /* renamed from: e, reason: collision with root package name */
    public final Timeline.Window f6416e = new Timeline.Window();

    /* renamed from: f, reason: collision with root package name */
    public final Timeline.Period f6417f = new Timeline.Period();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f6419h = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f6418g = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final long f6415d = SystemClock.elapsedRealtime();

    /* renamed from: l, reason: collision with root package name */
    public int f6423l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f6424m = 0;

    public static final class ErrorInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f6425a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6426b;

        public ErrorInfo(int i2, int i3) {
            this.f6425a = i2;
            this.f6426b = i3;
        }
    }

    public static final class PendingFormatUpdate {

        /* renamed from: a, reason: collision with root package name */
        public final Format f6427a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6428b;

        /* renamed from: c, reason: collision with root package name */
        public final String f6429c;

        public PendingFormatUpdate(Format format, int i2, String str) {
            this.f6427a = format;
            this.f6428b = i2;
            this.f6429c = str;
        }
    }

    public MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.f6412a = context.getApplicationContext();
        this.f6414c = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f6413b = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.f6401d = this;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void H(int i2, long j2, AnalyticsListener.EventTime eventTime) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f6372d;
        if (mediaPeriodId != null) {
            String strC = this.f6413b.c(eventTime.f6370b, mediaPeriodId);
            HashMap map = this.f6419h;
            Long l2 = (Long) map.get(strC);
            HashMap map2 = this.f6418g;
            Long l3 = (Long) map2.get(strC);
            map.put(strC, Long.valueOf((l2 == null ? 0L : l2.longValue()) + j2));
            map2.put(strC, Long.valueOf((l3 != null ? l3.longValue() : 0L) + i2));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void N(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.o;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.f6427a;
            if (format.t == -1) {
                Format.Builder builderA = format.a();
                builderA.r = videoSize.f5564a;
                builderA.s = videoSize.f5565b;
                this.o = new PendingFormatUpdate(new Format(builderA), pendingFormatUpdate.f6428b, pendingFormatUpdate.f6429c);
            }
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void O(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f6372d;
        if (mediaPeriodId == null) {
            return;
        }
        Format format = mediaLoadData.f7602c;
        format.getClass();
        mediaPeriodId.getClass();
        PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate(format, mediaLoadData.f7603d, this.f6413b.c(eventTime.f6370b, mediaPeriodId));
        int i2 = mediaLoadData.f7601b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.p = pendingFormatUpdate;
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.q = pendingFormatUpdate;
                return;
            }
        }
        this.o = pendingFormatUpdate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x05ed A[PHI: r7
      0x05ed: PHI (r7v35 int) = (r7v33 int), (r7v32 int) binds: [B:381:0x0603, B:371:0x05eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x067f A[ORIG_RETURN, RETURN] */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(androidx.media3.common.Player r28, androidx.media3.exoplayer.analytics.AnalyticsListener.Events r29) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.MediaMetricsListener.P(androidx.media3.common.Player, androidx.media3.exoplayer.analytics.AnalyticsListener$Events):void");
    }

    public final boolean S(PendingFormatUpdate pendingFormatUpdate) {
        String str;
        if (pendingFormatUpdate == null) {
            return false;
        }
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = this.f6413b;
        synchronized (defaultPlaybackSessionManager) {
            str = defaultPlaybackSessionManager.f6403f;
        }
        return pendingFormatUpdate.f6429c.equals(str);
    }

    public final void T() {
        PlaybackMetrics.Builder builder = this.f6421j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.z);
            this.f6421j.setVideoFramesDropped(this.x);
            this.f6421j.setVideoFramesPlayed(this.y);
            Long l2 = (Long) this.f6418g.get(this.f6420i);
            this.f6421j.setNetworkTransferDurationMillis(l2 == null ? 0L : l2.longValue());
            Long l3 = (Long) this.f6419h.get(this.f6420i);
            this.f6421j.setNetworkBytesRead(l3 == null ? 0L : l3.longValue());
            this.f6421j.setStreamSource((l3 == null || l3.longValue() <= 0) ? 0 : 1);
            this.f6414c.reportPlaybackMetrics(this.f6421j.build());
        }
        this.f6421j = null;
        this.f6420i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    public final void U(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int iB;
        PlaybackMetrics.Builder builder = this.f6421j;
        if (mediaPeriodId == null || (iB = timeline.b(mediaPeriodId.f7609a)) == -1) {
            return;
        }
        Timeline.Period period = this.f6417f;
        int i2 = 0;
        timeline.f(iB, period, false);
        int i3 = period.f5477c;
        Timeline.Window window = this.f6416e;
        timeline.n(i3, window);
        MediaItem.LocalConfiguration localConfiguration = window.f5488c.f5258b;
        if (localConfiguration != null) {
            int iM = Util.M(localConfiguration.f5339a, localConfiguration.f5340b);
            i2 = iM != 0 ? iM != 1 ? iM != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i2);
        if (window.f5498m != -9223372036854775807L && !window.f5496k && !window.f5494i && !window.a()) {
            builder.setMediaDurationMillis(Util.j0(window.f5498m));
        }
        builder.setPlaybackType(window.a() ? 2 : 1);
        this.A = true;
    }

    public final void V(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f6372d;
        if ((mediaPeriodId == null || !mediaPeriodId.b()) && str.equals(this.f6420i)) {
            T();
        }
        this.f6418g.remove(str);
        this.f6419h.remove(str);
    }

    public final void W(int i2, long j2, Format format, int i3) {
        int i4;
        TrackChangeEvent.Builder timeSinceCreatedMillis = s.j(i2).setTimeSinceCreatedMillis(j2 - this.f6415d);
        if (format != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i3 != 1) {
                i4 = 3;
                if (i3 != 2) {
                    i4 = i3 != 3 ? 1 : 4;
                }
            } else {
                i4 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i4);
            String str = format.f5224l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = format.f5225m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = format.f5222j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i5 = format.f5221i;
            if (i5 != -1) {
                timeSinceCreatedMillis.setBitrate(i5);
            }
            int i6 = format.s;
            if (i6 != -1) {
                timeSinceCreatedMillis.setWidth(i6);
            }
            int i7 = format.t;
            if (i7 != -1) {
                timeSinceCreatedMillis.setHeight(i7);
            }
            int i8 = format.A;
            if (i8 != -1) {
                timeSinceCreatedMillis.setChannelCount(i8);
            }
            int i9 = format.B;
            if (i9 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i9);
            }
            String str4 = format.f5216d;
            if (str4 != null) {
                int i10 = Util.f5744a;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f2 = format.u;
            if (f2 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f2);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.f6414c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void g(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.n = playbackException;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void i(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.x += decoderCounters.f6131g;
        this.y += decoderCounters.f6129e;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void n(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener.EventTime eventTime) {
        if (i2 == 1) {
            this.u = true;
        }
        this.f6422k = i2;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void o(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, IOException iOException) {
        this.v = mediaLoadData.f7600a;
    }
}
