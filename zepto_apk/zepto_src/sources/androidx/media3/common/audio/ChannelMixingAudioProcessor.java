package androidx.media3.common.audio;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class ChannelMixingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i, reason: collision with root package name */
    public final SparseArray f5585i = new SparseArray();

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f5576c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        if (((ChannelMixingMatrix) this.f5585i.get(audioFormat.f5575b)) != null) {
            return new AudioProcessor.AudioFormat(audioFormat.f5574a, 0, 2);
        }
        throw new AudioProcessor.UnhandledAudioFormatException("No mixing matrix for input channel count", audioFormat);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        Assertions.h((ChannelMixingMatrix) this.f5585i.get(this.f5578b.f5575b));
        int iRemaining = byteBuffer.remaining() / this.f5578b.f5577d;
        ByteBuffer byteBufferK = k(this.f5579c.f5577d * iRemaining);
        AudioProcessor.AudioFormat audioFormat = this.f5578b;
        AudioProcessor.AudioFormat audioFormat2 = this.f5579c;
        int i2 = audioFormat.f5576c;
        int i3 = audioFormat2.f5576c;
        for (int i4 = 0; i4 < iRemaining; i4++) {
        }
        byteBufferK.flip();
    }
}
