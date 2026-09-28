package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.view.Surface;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.io.IOException;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7348a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer[] f7349b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f7350c;

    public static class Factory implements MediaCodecAdapter.Factory {
        public static MediaCodec b(MediaCodecAdapter.Configuration configuration) throws IOException {
            MediaCodecInfo mediaCodecInfo = configuration.f7314a;
            StringBuilder sb = new StringBuilder("createCodec:");
            String str = mediaCodecInfo.f7320a;
            sb.append(str);
            Trace.beginSection(sb.toString());
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
            return mediaCodecCreateByCodecName;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
        public final MediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) {
            MediaCodec mediaCodecB = null;
            try {
                mediaCodecB = b(configuration);
                Trace.beginSection("configureCodec");
                mediaCodecB.configure(configuration.f7315b, configuration.f7317d, configuration.f7318e, 0);
                Trace.endSection();
                Trace.beginSection("startCodec");
                mediaCodecB.start();
                Trace.endSection();
                return new SynchronousMediaCodecAdapter(mediaCodecB);
            } catch (IOException | RuntimeException e2) {
                if (mediaCodecB != null) {
                    mediaCodecB.release();
                }
                throw e2;
            }
        }
    }

    public SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.f7348a = mediaCodec;
        if (Util.f5744a < 21) {
            this.f7349b = mediaCodec.getInputBuffers();
            this.f7350c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void a(int i2, CryptoInfo cryptoInfo, long j2, int i3) throws MediaCodec.CryptoException {
        this.f7348a.queueSecureInputBuffer(i2, 0, cryptoInfo.f6065i, j2, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void b(Bundle bundle) {
        this.f7348a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void c(int i2, int i3, long j2, int i4) throws MediaCodec.CryptoException {
        this.f7348a.queueInputBuffer(i2, 0, i3, j2, i4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void e(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f7348a.setOnFrameRenderedListener(new a(this, onFrameRenderedListener, 1), handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final MediaFormat f() {
        return this.f7348a.getOutputFormat();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void flush() {
        this.f7348a.flush();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void g(int i2) {
        this.f7348a.setVideoScalingMode(i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer h(int i2) {
        return Util.f5744a >= 21 ? this.f7348a.getInputBuffer(i2) : this.f7349b[i2];
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void i(Surface surface) {
        this.f7348a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void j(int i2, long j2) {
        this.f7348a.releaseOutputBuffer(i2, j2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int k() {
        return this.f7348a.dequeueInputBuffer(0L);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int l(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            MediaCodec mediaCodec = this.f7348a;
            iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && Util.f5744a < 21) {
                this.f7350c = mediaCodec.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void m(int i2, boolean z) {
        this.f7348a.releaseOutputBuffer(i2, z);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer n(int i2) {
        return Util.f5744a >= 21 ? this.f7348a.getOutputBuffer(i2) : this.f7350c[i2];
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void release() {
        MediaCodec mediaCodec = this.f7348a;
        this.f7349b = null;
        this.f7350c = null;
        try {
            int i2 = Util.f5744a;
            if (i2 >= 30 && i2 < 33) {
                mediaCodec.stop();
            }
        } finally {
            mediaCodec.release();
        }
    }
}
