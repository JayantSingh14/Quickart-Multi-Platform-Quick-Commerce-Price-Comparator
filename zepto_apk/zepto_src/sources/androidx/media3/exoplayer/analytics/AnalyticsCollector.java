package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void A();

    void P(AnalyticsListener analyticsListener);

    void Y(AnalyticsListener analyticsListener);

    void a(AudioSink.AudioTrackConfig audioTrackConfig);

    void b0(Player player, Looper looper);

    void c(AudioSink.AudioTrackConfig audioTrackConfig);

    void e(Exception exc);

    void f(String str);

    void g(String str);

    void i(DecoderCounters decoderCounters);

    void j(DecoderCounters decoderCounters);

    void l(long j2);

    void m(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void n(Exception exc);

    void o(long j2, Object obj);

    void p(DecoderCounters decoderCounters);

    void q(long j2, long j3, String str);

    void r(int i2, long j2);

    void release();

    void s(long j2, long j3, int i2);

    void t(int i2, long j2);

    void u(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void v(DecoderCounters decoderCounters);

    void w(Exception exc);

    void x(long j2, long j3, String str);

    void y(List list, MediaSource.MediaPeriodId mediaPeriodId);
}
