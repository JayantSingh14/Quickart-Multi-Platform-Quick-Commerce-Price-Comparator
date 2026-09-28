package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class TrimmingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* renamed from: i, reason: collision with root package name */
    public int f6629i;

    /* renamed from: j, reason: collision with root package name */
    public int f6630j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6631k;

    /* renamed from: l, reason: collision with root package name */
    public int f6632l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f6633m = Util.f5749f;
    public int n;
    public long o;

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f5576c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.f6631k = true;
        return (this.f6629i == 0 && this.f6630j == 0) ? AudioProcessor.AudioFormat.f5573e : audioFormat;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public final boolean c() {
        return super.c() && this.n == 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public final ByteBuffer d() {
        int i2;
        if (super.c() && (i2 = this.n) > 0) {
            k(i2).put(this.f6633m, 0, this.n).flip();
            this.n = 0;
        }
        return super.d();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        if (i2 == 0) {
            return;
        }
        int iMin = Math.min(i2, this.f6632l);
        this.o += iMin / this.f5578b.f5577d;
        this.f6632l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f6632l > 0) {
            return;
        }
        int i3 = i2 - iMin;
        int length = (this.n + i3) - this.f6633m.length;
        ByteBuffer byteBufferK = k(length);
        int iK = Util.k(length, 0, this.n);
        byteBufferK.put(this.f6633m, 0, iK);
        int iK2 = Util.k(length - iK, 0, i3);
        byteBuffer.limit(byteBuffer.position() + iK2);
        byteBufferK.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i4 = i3 - iK2;
        int i5 = this.n - iK;
        this.n = i5;
        byte[] bArr = this.f6633m;
        System.arraycopy(bArr, iK, bArr, 0, i5);
        byteBuffer.get(this.f6633m, this.n, i4);
        this.n += i4;
        byteBufferK.flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void h() {
        if (this.f6631k) {
            this.f6631k = false;
            int i2 = this.f6630j;
            int i3 = this.f5578b.f5577d;
            this.f6633m = new byte[i2 * i3];
            this.f6632l = this.f6629i * i3;
        }
        this.n = 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void i() {
        if (this.f6631k) {
            if (this.n > 0) {
                this.o += r0 / this.f5578b.f5577d;
            }
            this.n = 0;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void j() {
        this.f6633m = Util.f5749f;
    }
}
