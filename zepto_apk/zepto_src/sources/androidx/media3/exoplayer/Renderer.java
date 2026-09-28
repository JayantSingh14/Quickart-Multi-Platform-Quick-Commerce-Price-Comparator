package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public interface Renderer extends PlayerMessage.Target {

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface WakeupListener {
        void a();

        void b();
    }

    void A(long j2);

    MediaClock B();

    boolean a();

    boolean c();

    void disable();

    default void f() {
    }

    int g();

    String getName();

    int getState();

    void i(long j2, long j3);

    SampleStream j();

    boolean k();

    void l();

    void m(int i2, PlayerId playerId, SystemClock systemClock);

    void p(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId);

    void q();

    boolean r();

    default void release() {
    }

    void reset();

    void s(Timeline timeline);

    void start();

    void stop();

    void t(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId);

    RendererCapabilities u();

    default void x(float f2, float f3) {
    }

    long z();
}
