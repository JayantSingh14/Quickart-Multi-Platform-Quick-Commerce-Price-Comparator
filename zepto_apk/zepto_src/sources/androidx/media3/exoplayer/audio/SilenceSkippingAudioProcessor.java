package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public final class SilenceSkippingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {
    public int n;
    public boolean o;
    public int p;
    public long q;
    public byte[] s;
    public byte[] v;
    public int r = 0;
    public int t = 0;
    public int u = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f6626l = 100000;

    /* renamed from: i, reason: collision with root package name */
    public final float f6623i = 0.2f;

    /* renamed from: m, reason: collision with root package name */
    public final long f6627m = 2000000;

    /* renamed from: k, reason: collision with root package name */
    public final int f6625k = 10;

    /* renamed from: j, reason: collision with root package name */
    public final short f6624j = 1024;

    public SilenceSkippingAudioProcessor() {
        byte[] bArr = Util.f5749f;
        this.s = bArr;
        this.v = bArr;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public final boolean a() {
        return super.a() && this.o;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f5576c == 2) {
            return audioFormat.f5574a == -1 ? AudioProcessor.AudioFormat.f5573e : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        int iLimit;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f5583g.hasRemaining()) {
            int i2 = this.p;
            short s = this.f6624j;
            if (i2 == 0) {
                int iLimit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit2, byteBuffer.position() + this.s.length));
                int iLimit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit3 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit3) << 8) | (byteBuffer.get(iLimit3 - 1) & 255)) > s) {
                        int i3 = this.n;
                        iPosition = ((iLimit3 / i3) * i3) + i3;
                        break;
                    }
                    iLimit3 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.p = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    k(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit2);
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException();
                }
                Assertions.g(this.t < this.s.length);
                int iLimit4 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & 255)) > s) {
                        int i4 = this.n;
                        iLimit = (iPosition2 / i4) * i4;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int length = this.t;
                int i5 = this.u;
                int length2 = length + i5;
                byte[] bArr = this.s;
                if (length2 < bArr.length) {
                    length = bArr.length;
                } else {
                    length2 = i5 - (bArr.length - length);
                }
                int i6 = length - length2;
                boolean z = iLimit < iLimit4;
                int iMin = Math.min(iPosition3, i6);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.s, length2, iMin);
                int i7 = this.u + iMin;
                this.u = i7;
                Assertions.g(i7 <= this.s.length);
                boolean z2 = z && iPosition3 < i6;
                m(z2);
                if (z2) {
                    this.p = 0;
                    this.r = 0;
                }
                byteBuffer.limit(iLimit4);
            }
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void h() {
        if (a()) {
            int i2 = this.f5578b.f5575b * 2;
            this.n = i2;
            int i3 = ((((int) ((this.f6626l * r0.f5574a) / 1000000)) / 2) / i2) * i2 * 2;
            if (this.s.length != i3) {
                this.s = new byte[i3];
                this.v = new byte[i3];
            }
        }
        this.p = 0;
        this.q = 0L;
        this.r = 0;
        this.t = 0;
        this.u = 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void i() {
        if (this.u > 0) {
            m(true);
            this.r = 0;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void j() {
        this.o = false;
        byte[] bArr = Util.f5749f;
        this.s = bArr;
        this.v = bArr;
    }

    public final int l(int i2) {
        int length = ((((int) ((this.f6627m * this.f5578b.f5574a) / 1000000)) - this.r) * this.n) - (this.s.length / 2);
        Assertions.g(length >= 0);
        int iMin = (int) Math.min((i2 * this.f6623i) + 0.5f, length);
        int i3 = this.n;
        return (iMin / i3) * i3;
    }

    public final void m(boolean z) {
        int length;
        int iL;
        int i2 = this.u;
        byte[] bArr = this.s;
        if (i2 == bArr.length || z) {
            if (this.r == 0) {
                if (z) {
                    n(i2, 3);
                    length = i2;
                } else {
                    Assertions.g(i2 >= bArr.length / 2);
                    length = this.s.length / 2;
                    n(length, 0);
                }
                iL = length;
            } else if (z) {
                int length2 = i2 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iL2 = l(length2) + (this.s.length / 2);
                n(iL2, 2);
                iL = iL2;
                length = length3;
            } else {
                length = i2 - (bArr.length / 2);
                iL = l(length);
                n(iL, 1);
            }
            Assertions.f("bytesConsumed is not aligned to frame size: %s" + length, length % this.n == 0);
            Assertions.g(i2 >= iL);
            this.u -= length;
            int i3 = this.t + length;
            this.t = i3;
            this.t = i3 % this.s.length;
            this.r = (iL / this.n) + this.r;
            this.q += (length - iL) / r2;
        }
    }

    public final void n(int i2, int i3) {
        if (i2 == 0) {
            return;
        }
        Assertions.a(this.u >= i2);
        if (i3 == 2) {
            int i4 = this.t;
            int i5 = this.u;
            int i6 = i4 + i5;
            byte[] bArr = this.s;
            if (i6 <= bArr.length) {
                System.arraycopy(bArr, i6 - i2, this.v, 0, i2);
            } else {
                int length = i5 - (bArr.length - i4);
                if (length >= i2) {
                    System.arraycopy(bArr, length - i2, this.v, 0, i2);
                } else {
                    int i7 = i2 - length;
                    System.arraycopy(bArr, bArr.length - i7, this.v, 0, i7);
                    System.arraycopy(this.s, 0, this.v, i7, length);
                }
            }
        } else {
            int i8 = this.t;
            int i9 = i8 + i2;
            byte[] bArr2 = this.s;
            if (i9 <= bArr2.length) {
                System.arraycopy(bArr2, i8, this.v, 0, i2);
            } else {
                int length2 = bArr2.length - i8;
                System.arraycopy(bArr2, i8, this.v, 0, length2);
                System.arraycopy(this.s, 0, this.v, length2, i2 - length2);
            }
        }
        Assertions.b(i2 % this.n == 0, "sizeToOutput is not aligned to frame size: " + i2);
        Assertions.g(this.t < this.s.length);
        byte[] bArr3 = this.v;
        Assertions.b(i2 % this.n == 0, "byteOutput size is not aligned to frame size " + i2);
        if (i3 != 3) {
            for (int i10 = 0; i10 < i2; i10 += 2) {
                int i11 = i10 + 1;
                int i12 = (bArr3[i11] << 8) | (bArr3[i10] & 255);
                int i13 = this.f6625k;
                if (i3 == 0) {
                    i13 = ((((i10 * 1000) / (i2 - 1)) * (i13 - 100)) / 1000) + 100;
                } else if (i3 == 2) {
                    i13 += (((i10 * 1000) * (100 - i13)) / (i2 - 1)) / 1000;
                }
                int i14 = (i12 * i13) / 100;
                if (i14 >= 32767) {
                    bArr3[i10] = -1;
                    bArr3[i11] = 127;
                } else if (i14 <= -32768) {
                    bArr3[i10] = 0;
                    bArr3[i11] = -128;
                } else {
                    bArr3[i10] = (byte) (i14 & 255);
                    bArr3[i11] = (byte) (i14 >> 8);
                }
            }
        }
        k(i2).put(bArr3, 0, i2).flip();
    }
}
