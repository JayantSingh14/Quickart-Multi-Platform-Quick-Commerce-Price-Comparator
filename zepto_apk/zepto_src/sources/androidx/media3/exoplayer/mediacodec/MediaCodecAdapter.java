package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoInfo;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public interface MediaCodecAdapter {

    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodecInfo f7314a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f7315b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f7316c;

        /* renamed from: d, reason: collision with root package name */
        public final Surface f7317d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaCrypto f7318e;

        public Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto) {
            this.f7314a = mediaCodecInfo;
            this.f7315b = mediaFormat;
            this.f7316c = format;
            this.f7317d = surface;
            this.f7318e = mediaCrypto;
        }
    }

    public interface Factory {
        MediaCodecAdapter a(Configuration configuration);
    }

    public interface OnBufferAvailableListener {
    }

    public interface OnFrameRenderedListener {
        void a(long j2);
    }

    void a(int i2, CryptoInfo cryptoInfo, long j2, int i3);

    void b(Bundle bundle);

    void c(int i2, int i3, long j2, int i4);

    default boolean d(OnBufferAvailableListener onBufferAvailableListener) {
        return false;
    }

    void e(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    MediaFormat f();

    void flush();

    void g(int i2);

    ByteBuffer h(int i2);

    void i(Surface surface);

    void j(int i2, long j2);

    int k();

    int l(MediaCodec.BufferInfo bufferInfo);

    void m(int i2, boolean z);

    ByteBuffer n(int i2);

    void release();
}
