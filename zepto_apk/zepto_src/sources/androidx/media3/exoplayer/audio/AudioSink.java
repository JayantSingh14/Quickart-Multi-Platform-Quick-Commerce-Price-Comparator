package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public interface AudioSink {

    public static final class AudioTrackConfig {

        /* renamed from: a, reason: collision with root package name */
        public final int f6525a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6526b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6527c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f6528d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f6529e;

        /* renamed from: f, reason: collision with root package name */
        public final int f6530f;

        public AudioTrackConfig(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            this.f6525a = i2;
            this.f6526b = i3;
            this.f6527c = i4;
            this.f6528d = z;
            this.f6529e = z2;
            this.f6530f = i5;
        }
    }

    public static final class InitializationException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f6532a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6533b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f6534c;

        /* JADX WARN: Illegal instructions before constructor call */
        public InitializationException(int i2, int i3, int i4, int i5, Format format, boolean z, RuntimeException runtimeException) {
            StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "AudioTrack init failed ", " Config(", ", ");
            android.support.v4.media.a.q(i4, i5, ", ", ") ", sbT);
            sbT.append(format);
            sbT.append(z ? " (recoverable)" : "");
            super(sbT.toString(), runtimeException);
            this.f6532a = i2;
            this.f6533b = z;
            this.f6534c = format;
        }
    }

    public interface Listener {
        default void a(AudioTrackConfig audioTrackConfig) {
        }

        default void b() {
        }

        default void c(AudioTrackConfig audioTrackConfig) {
        }

        void d(boolean z);

        default void e(Exception exc) {
        }

        default void f() {
        }

        void g(long j2, long j3, int i2);

        default void h(long j2) {
        }

        default void i() {
        }

        void j();

        default void k() {
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
    }

    public static final class WriteException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f6535a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6536b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f6537c;

        public WriteException(int i2, Format format, boolean z) {
            super(android.support.v4.media.b.f(i2, "AudioTrack write failed: "));
            this.f6536b = z;
            this.f6535a = i2;
            this.f6537c = format;
        }
    }

    default void a(AudioDeviceInfo audioDeviceInfo) {
    }

    public static final class ConfigurationException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final Format f6531a;

        public ConfigurationException(AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException, Format format) {
            super(unhandledAudioFormatException);
            this.f6531a = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.f6531a = format;
        }
    }
}
