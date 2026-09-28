package androidx.media3.exoplayer.video;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

@UnstableApi
/* loaded from: classes3.dex */
public interface VideoRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f8346a;

        /* renamed from: b, reason: collision with root package name */
        public final VideoRendererEventListener f8347b;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.f8346a = handler;
            this.f8347b = videoRendererEventListener;
        }

        public final void a(VideoSize videoSize) {
            Handler handler = this.f8346a;
            if (handler != null) {
                handler.post(new f(this, videoSize, 0));
            }
        }
    }

    default void b(VideoSize videoSize) {
    }

    default void f(String str) {
    }

    default void j(DecoderCounters decoderCounters) {
    }

    default void n(Exception exc) {
    }

    default void t(int i2, long j2) {
    }

    default void u(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void v(DecoderCounters decoderCounters) {
    }

    default void o(long j2, Object obj) {
    }

    default void r(int i2, long j2) {
    }

    default void x(long j2, long j3, String str) {
    }
}
