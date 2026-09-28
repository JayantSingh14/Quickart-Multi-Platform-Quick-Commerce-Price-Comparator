package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.media3.decoder.CryptoInfo;

@RequiresApi
/* loaded from: classes3.dex */
class SynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7351a;

    public SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.f7351a = mediaCodec;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void a(int i2, CryptoInfo cryptoInfo, long j2, int i3) throws MediaCodec.CryptoException {
        this.f7351a.queueSecureInputBuffer(i2, 0, cryptoInfo.f6065i, j2, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void b(Bundle bundle) {
        this.f7351a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void c(int i2, int i3, long j2, int i4) throws MediaCodec.CryptoException {
        this.f7351a.queueInputBuffer(i2, 0, i3, j2, i4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void d() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void flush() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void shutdown() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void start() {
    }
}
