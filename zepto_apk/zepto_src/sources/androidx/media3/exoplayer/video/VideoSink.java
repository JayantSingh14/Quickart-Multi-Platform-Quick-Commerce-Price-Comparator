package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
/* loaded from: classes3.dex */
public interface VideoSink {

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    public static final class VideoSinkException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final Format f8349a;

        public VideoSinkException(Exception exc, Format format) {
            super(exc);
            this.f8349a = format;
        }
    }

    void C(float f2);

    boolean a();

    boolean c();

    boolean d();

    void f();

    Surface g();

    void i(long j2, long j3);

    void j(VideoFrameMetadataListener videoFrameMetadataListener);

    long k(long j2, boolean z);

    void l();

    void m(List list);

    boolean n();

    void o(Format format);

    void p(Format format);

    void q(boolean z);

    void r();

    void release();

    void s(Surface surface, Size size);

    void t(long j2);

    void u();

    void v();

    void w(boolean z);

    void x(Listener listener, Executor executor);

    public interface Listener {

        /* renamed from: a, reason: collision with root package name */
        public static final Listener f8348a = new AnonymousClass1();

        void e();

        void h();

        /* renamed from: androidx.media3.exoplayer.video.VideoSink$Listener$1, reason: invalid class name */
        public class AnonymousClass1 implements Listener {
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void e() {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void h() {
            }
        }
    }
}
