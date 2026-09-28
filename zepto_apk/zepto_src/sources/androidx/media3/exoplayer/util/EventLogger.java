package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class EventLogger implements AnalyticsListener {

    /* renamed from: e, reason: collision with root package name */
    public static final NumberFormat f8209e;

    /* renamed from: a, reason: collision with root package name */
    public final String f8210a;

    /* renamed from: b, reason: collision with root package name */
    public final Timeline.Window f8211b;

    /* renamed from: c, reason: collision with root package name */
    public final Timeline.Period f8212c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8213d;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f8209e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger() {
        this("EventLogger");
    }

    public static String S(AudioSink.AudioTrackConfig audioTrackConfig) {
        return audioTrackConfig.f6525a + "," + audioTrackConfig.f6527c + "," + audioTrackConfig.f6526b + "," + audioTrackConfig.f6528d + "," + audioTrackConfig.f6529e + "," + audioTrackConfig.f6530f;
    }

    public static String V(long j2) {
        if (j2 == -9223372036854775807L) {
            return "?";
        }
        return f8209e.format(j2 / 1000.0f);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void A(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        X(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void B(AnalyticsListener.EventTime eventTime, String str) {
        X(eventTime, "audioDecoderReleased", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void C(AnalyticsListener.EventTime eventTime, String str) {
        X(eventTime, "videoDecoderInitialized", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void D(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        X(eventTime, "audioTrackReleased", S(audioTrackConfig));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void E(AnalyticsListener.EventTime eventTime, String str) {
        X(eventTime, "videoDecoderReleased", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void F(AnalyticsListener.EventTime eventTime, int i2) {
        X(eventTime, "playbackSuppressionReason", i2 != 0 ? i2 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void G(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        X(eventTime, "upstreamDiscarded", Format.d(mediaLoadData.f7602c));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void I(AnalyticsListener.EventTime eventTime, int i2) {
        X(eventTime, "droppedFrames", Integer.toString(i2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void J(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "drmKeysRestored");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void K(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "audioEnabled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void L(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        Y("tracks [" + U(eventTime));
        ImmutableList immutableList = tracks.f5548a;
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Tracks.Group group = (Tracks.Group) immutableList.get(i2);
            Y("  group [");
            for (int i3 = 0; i3 < group.f5553a; i3++) {
                String str = group.f5557e[i3] ? "[X]" : "[ ]";
                Y("    " + str + " Track:" + i3 + ", " + Format.d(group.a(i3)) + ", supported=" + Util.y(group.f5556d[i3]));
            }
            Y("  ]");
        }
        boolean z = false;
        for (int i4 = 0; !z && i4 < immutableList.size(); i4++) {
            Tracks.Group group2 = (Tracks.Group) immutableList.get(i4);
            for (int i5 = 0; !z && i5 < group2.f5553a; i5++) {
                if (group2.f5557e[i5] && (metadata = group2.a(i5).f5223k) != null && metadata.f5405a.length > 0) {
                    Y("  Metadata [");
                    Z(metadata, "    ");
                    Y("  ]");
                    z = true;
                }
            }
        }
        Y("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void M(AnalyticsListener.EventTime eventTime, int i2) {
        X(eventTime, "repeatMode", i2 != 0 ? i2 != 1 ? i2 != 2 ? "?" : Rule.ALL : "ONE" : "OFF");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void N(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        X(eventTime, "videoSize", videoSize.f5564a + ", " + videoSize.f5565b);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void O(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        X(eventTime, "downstreamFormat", Format.d(mediaLoadData.f7602c));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void Q(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "drmKeysLoaded");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void R(AnalyticsListener.EventTime eventTime, String str) {
        X(eventTime, "audioDecoderInitialized", str);
    }

    public final String T(AnalyticsListener.EventTime eventTime, String str, String str2, Exception exc) {
        StringBuilder sbX = b.x(str, " [");
        sbX.append(U(eventTime));
        String string = sbX.toString();
        if (exc instanceof PlaybackException) {
            StringBuilder sbX2 = b.x(string, ", errorCode=");
            sbX2.append(PlaybackException.b(((PlaybackException) exc).f5421a));
            string = sbX2.toString();
        }
        if (str2 != null) {
            string = b.l(string, ", ", str2);
        }
        String strF = Log.f(exc);
        if (!TextUtils.isEmpty(strF)) {
            StringBuilder sbX3 = b.x(string, "\n  ");
            sbX3.append(strF.replace(StringUtils.LF, "\n  "));
            sbX3.append('\n');
            string = sbX3.toString();
        }
        return b.k(string, "]");
    }

    public final String U(AnalyticsListener.EventTime eventTime) {
        String string = "window=" + eventTime.f6371c;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f6372d;
        if (mediaPeriodId != null) {
            StringBuilder sbX = b.x(string, ", period=");
            sbX.append(eventTime.f6370b.b(mediaPeriodId.f7609a));
            string = sbX.toString();
            if (mediaPeriodId.b()) {
                StringBuilder sbX2 = b.x(string, ", adGroup=");
                sbX2.append(mediaPeriodId.f7610b);
                StringBuilder sbX3 = b.x(sbX2.toString(), ", ad=");
                sbX3.append(mediaPeriodId.f7611c);
                string = sbX3.toString();
            }
        }
        return "eventTime=" + V(eventTime.f6369a - this.f8213d) + ", mediaPos=" + V(eventTime.f6373e) + ", " + string;
    }

    public final void W(AnalyticsListener.EventTime eventTime, String str) {
        Y(T(eventTime, str, null, null));
    }

    public final void X(AnalyticsListener.EventTime eventTime, String str, String str2) {
        Y(T(eventTime, str, str2, null));
    }

    public final void Y(String str) {
        Log.b(this.f8210a, str);
    }

    public final void Z(Metadata metadata, String str) {
        for (int i2 = 0; i2 < metadata.f5405a.length; i2++) {
            StringBuilder sbW = b.w(str);
            sbW.append(metadata.f5405a[i2]);
            Y(sbW.toString());
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void a(AnalyticsListener.EventTime eventTime, boolean z) {
        X(eventTime, "loading", Boolean.toString(z));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void b(AnalyticsListener.EventTime eventTime, Object obj) {
        X(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void c(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "videoEnabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void d(AnalyticsListener.EventTime eventTime, boolean z) {
        X(eventTime, "isPlaying", Boolean.toString(z));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void e(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        Y("metadata [" + U(eventTime));
        Z(metadata, "  ");
        Y("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void f(AnalyticsListener.EventTime eventTime, boolean z) {
        X(eventTime, "skipSilenceEnabled", Boolean.toString(z));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void g(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        Log.d(this.f8210a, T(eventTime, "playerFailed", null, playbackException));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void h(AnalyticsListener.EventTime eventTime, Format format) {
        X(eventTime, "audioInputFormat", Format.d(format));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void i(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        W(eventTime, "videoDisabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void j(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "drmSessionReleased");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void k(AnalyticsListener.EventTime eventTime) {
        W(eventTime, "audioDisabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void l(AnalyticsListener.EventTime eventTime, Format format) {
        X(eventTime, "videoInputFormat", Format.d(format));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void m(AnalyticsListener.EventTime eventTime, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        sb.append(", ");
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST");
        X(eventTime, "playWhenReady", sb.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void n(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener.EventTime eventTime) {
        String str;
        StringBuilder sb = new StringBuilder("reason=");
        switch (i2) {
            case 0:
                str = "AUTO_TRANSITION";
                break;
            case 1:
                str = "SEEK";
                break;
            case 2:
                str = "SEEK_ADJUSTMENT";
                break;
            case 3:
                str = "SKIP";
                break;
            case 4:
                str = "REMOVE";
                break;
            case 5:
                str = "INTERNAL";
                break;
            case 6:
                str = "SILENCE_SKIP";
                break;
            default:
                str = "?";
                break;
        }
        sb.append(str);
        sb.append(", PositionInfo:old [mediaItem=");
        sb.append(positionInfo.f5441b);
        sb.append(", period=");
        sb.append(positionInfo.f5444e);
        sb.append(", pos=");
        sb.append(positionInfo.f5445f);
        int i3 = positionInfo.f5447h;
        if (i3 != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.f5446g);
            sb.append(", adGroup=");
            sb.append(i3);
            sb.append(", ad=");
            sb.append(positionInfo.f5448i);
        }
        sb.append("], PositionInfo:new [mediaItem=");
        sb.append(positionInfo2.f5441b);
        sb.append(", period=");
        sb.append(positionInfo2.f5444e);
        sb.append(", pos=");
        sb.append(positionInfo2.f5445f);
        int i4 = positionInfo2.f5447h;
        if (i4 != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.f5446g);
            sb.append(", adGroup=");
            sb.append(i4);
            sb.append(", ad=");
            sb.append(positionInfo2.f5448i);
        }
        sb.append("]");
        X(eventTime, "positionDiscontinuity", sb.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void o(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData, IOException iOException) {
        Log.d(this.f8210a, T(eventTime, "internalError", "loadError", iOException));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void p(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        X(eventTime, "audioAttributes", audioAttributes.f5149a + "," + audioAttributes.f5150b + "," + audioAttributes.f5151c + "," + audioAttributes.f5152d);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void q(AnalyticsListener.EventTime eventTime, int i2) {
        Timeline timeline = eventTime.f6370b;
        int iH = timeline.h();
        int iO = timeline.o();
        StringBuilder sb = new StringBuilder("timeline [");
        sb.append(U(eventTime));
        sb.append(", periodCount=");
        sb.append(iH);
        sb.append(", windowCount=");
        sb.append(iO);
        sb.append(", reason=");
        sb.append(i2 != 0 ? i2 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED");
        Y(sb.toString());
        for (int i3 = 0; i3 < Math.min(iH, 3); i3++) {
            Timeline.Period period = this.f8212c;
            timeline.f(i3, period, false);
            Y("  period [" + V(Util.j0(period.f5478d)) + "]");
        }
        if (iH > 3) {
            Y("  ...");
        }
        for (int i4 = 0; i4 < Math.min(iO, 3); i4++) {
            Timeline.Window window = this.f8211b;
            timeline.n(i4, window);
            Y("  window [" + V(Util.j0(window.f5498m)) + ", seekable=" + window.f5493h + ", dynamic=" + window.f5494i + "]");
        }
        if (iO > 3) {
            Y("  ...");
        }
        Y("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void r(AnalyticsListener.EventTime eventTime, Exception exc) {
        Log.d(this.f8210a, T(eventTime, "internalError", "drmSessionManagerError", exc));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void s(AnalyticsListener.EventTime eventTime, int i2) {
        StringBuilder sb = new StringBuilder("mediaItem [");
        sb.append(U(eventTime));
        sb.append(", reason=");
        sb.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : RegionUtil.REGION_STRING_AUTO : "REPEAT");
        sb.append("]");
        Y(sb.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void t(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        X(eventTime, "surfaceSize", i2 + ", " + i3);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void u(AnalyticsListener.EventTime eventTime, int i2) {
        X(eventTime, "drmSessionAcquired", "state=" + i2);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void v(AnalyticsListener.EventTime eventTime, float f2) {
        X(eventTime, "volume", Float.toString(f2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void w(AnalyticsListener.EventTime eventTime, boolean z) {
        X(eventTime, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void x(AnalyticsListener.EventTime eventTime, int i2) {
        X(eventTime, "state", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void y(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        Log.d(this.f8210a, T(eventTime, "audioTrackUnderrun", i2 + ", " + j2 + ", " + j3, null));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void z(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        X(eventTime, "audioTrackInit", S(audioTrackConfig));
    }

    public EventLogger(String str) {
        this.f8210a = str;
        this.f8211b = new Timeline.Window();
        this.f8212c = new Timeline.Period();
        this.f8213d = SystemClock.elapsedRealtime();
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void H(int i2, long j2, AnalyticsListener.EventTime eventTime) {
    }
}
