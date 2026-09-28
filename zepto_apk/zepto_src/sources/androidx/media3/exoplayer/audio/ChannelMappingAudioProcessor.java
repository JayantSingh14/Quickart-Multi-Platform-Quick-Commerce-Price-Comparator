package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class ChannelMappingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* renamed from: i, reason: collision with root package name */
    public int[] f6564i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f6565j;

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f6564i;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.f5573e;
        }
        if (audioFormat.f5576c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int length = iArr.length;
        int i2 = audioFormat.f5575b;
        boolean z = i2 != length;
        int i3 = 0;
        while (i3 < iArr.length) {
            int i4 = iArr[i3];
            if (i4 >= i2) {
                throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
            }
            z |= i4 != i3;
            i3++;
        }
        return z ? new AudioProcessor.AudioFormat(audioFormat.f5574a, iArr.length, 2) : AudioProcessor.AudioFormat.f5573e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        int[] iArr = this.f6565j;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferK = k(((iLimit - iPosition) / this.f5578b.f5577d) * this.f5579c.f5577d);
        while (iPosition < iLimit) {
            for (int i2 : iArr) {
                byteBufferK.putShort(byteBuffer.getShort((i2 * 2) + iPosition));
            }
            iPosition += this.f5578b.f5577d;
        }
        byteBuffer.position(iLimit);
        byteBufferK.flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void h() {
        this.f6565j = this.f6564i;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void j() {
        this.f6565j = null;
        this.f6564i = null;
    }
}
