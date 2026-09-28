package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class TeeAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    public interface AudioBufferSink {
    }

    public static final class WavFileAudioBufferSink implements AudioBufferSink {
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return;
        }
        int i2 = Util.f5744a;
        byteBuffer.asReadOnlyBuffer().order(byteBuffer.order());
        throw null;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void h() {
        if (a()) {
            int i2 = this.f5578b.f5574a;
            throw null;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void i() {
        if (a()) {
            int i2 = this.f5578b.f5574a;
            throw null;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void j() {
        if (a()) {
            int i2 = this.f5578b.f5574a;
            throw null;
        }
    }
}
