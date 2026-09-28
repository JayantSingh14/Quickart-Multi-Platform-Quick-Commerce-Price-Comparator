package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;

@UnstableApi
/* loaded from: classes3.dex */
public interface AudioRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f6523a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioRendererEventListener f6524b;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            if (audioRendererEventListener != null) {
                handler.getClass();
            } else {
                handler = null;
            }
            this.f6523a = handler;
            this.f6524b = audioRendererEventListener;
        }

        public final void a(DecoderCounters decoderCounters) {
            synchronized (decoderCounters) {
            }
            Handler handler = this.f6523a;
            if (handler != null) {
                handler.post(new b(this, decoderCounters, 1));
            }
        }
    }

    default void a(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void c(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void d(boolean z) {
    }

    default void e(Exception exc) {
    }

    default void g(String str) {
    }

    default void i(DecoderCounters decoderCounters) {
    }

    default void l(long j2) {
    }

    default void m(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void p(DecoderCounters decoderCounters) {
    }

    default void w(Exception exc) {
    }

    default void q(long j2, long j3, String str) {
    }

    default void s(long j2, long j3, int i2) {
    }
}
