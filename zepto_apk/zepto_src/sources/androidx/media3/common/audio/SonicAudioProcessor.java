package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public class SonicAudioProcessor implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public int f5599b;

    /* renamed from: c, reason: collision with root package name */
    public float f5600c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f5601d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5602e;

    /* renamed from: f, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5603f;

    /* renamed from: g, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5604g;

    /* renamed from: h, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5605h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5606i;

    /* renamed from: j, reason: collision with root package name */
    public Sonic f5607j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f5608k;

    /* renamed from: l, reason: collision with root package name */
    public ShortBuffer f5609l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f5610m;
    public long n;
    public long o;
    public boolean p;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
        this.f5602e = audioFormat;
        this.f5603f = audioFormat;
        this.f5604g = audioFormat;
        this.f5605h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f5572a;
        this.f5608k = byteBuffer;
        this.f5609l = byteBuffer.asShortBuffer();
        this.f5610m = byteBuffer;
        this.f5599b = -1;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean a() {
        if (this.f5603f.f5574a != -1) {
            return Math.abs(this.f5600c - 1.0f) >= 1.0E-4f || Math.abs(this.f5601d - 1.0f) >= 1.0E-4f || this.f5603f.f5574a != this.f5602e.f5574a;
        }
        return false;
    }

    public final long b(long j2) {
        if (this.o < 1024) {
            return (long) (this.f5600c * j2);
        }
        long j3 = this.n;
        this.f5607j.getClass();
        long j4 = j3 - ((r2.f5596k * r2.f5587b) * 2);
        int i2 = this.f5605h.f5574a;
        int i3 = this.f5604g.f5574a;
        return i2 == i3 ? Util.b0(j2, j4, this.o, RoundingMode.FLOOR) : Util.b0(j2, j4 * i2, this.o * i3, RoundingMode.FLOOR);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean c() {
        if (!this.p) {
            return false;
        }
        Sonic sonic = this.f5607j;
        return sonic == null || (sonic.f5598m * sonic.f5587b) * 2 == 0;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final ByteBuffer d() {
        Sonic sonic = this.f5607j;
        if (sonic != null) {
            int i2 = sonic.f5598m;
            int i3 = sonic.f5587b;
            int i4 = i2 * i3 * 2;
            if (i4 > 0) {
                if (this.f5608k.capacity() < i4) {
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i4).order(ByteOrder.nativeOrder());
                    this.f5608k = byteBufferOrder;
                    this.f5609l = byteBufferOrder.asShortBuffer();
                } else {
                    this.f5608k.clear();
                    this.f5609l.clear();
                }
                ShortBuffer shortBuffer = this.f5609l;
                int iMin = Math.min(shortBuffer.remaining() / i3, sonic.f5598m);
                int i5 = iMin * i3;
                shortBuffer.put(sonic.f5597l, 0, i5);
                int i6 = sonic.f5598m - iMin;
                sonic.f5598m = i6;
                short[] sArr = sonic.f5597l;
                System.arraycopy(sArr, i5, sArr, 0, i6 * i3);
                this.o += i4;
                this.f5608k.limit(i4);
                this.f5610m = this.f5608k;
            }
        }
        ByteBuffer byteBuffer = this.f5610m;
        this.f5610m = AudioProcessor.f5572a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            Sonic sonic = this.f5607j;
            sonic.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i2 = sonic.f5587b;
            int i3 = iRemaining2 / i2;
            short[] sArrC = sonic.c(sonic.f5595j, sonic.f5596k, i3);
            sonic.f5595j = sArrC;
            shortBufferAsShortBuffer.get(sArrC, sonic.f5596k * i2, ((i3 * i2) * 2) / 2);
            sonic.f5596k += i3;
            sonic.f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void f() {
        Sonic sonic = this.f5607j;
        if (sonic != null) {
            int i2 = sonic.f5596k;
            float f2 = sonic.f5588c;
            float f3 = sonic.f5589d;
            int i3 = sonic.f5598m + ((int) ((((i2 / (f2 / f3)) + sonic.o) / (sonic.f5590e * f3)) + 0.5f));
            short[] sArr = sonic.f5595j;
            int i4 = sonic.f5593h * 2;
            sonic.f5595j = sonic.c(sArr, i2, i4 + i2);
            int i5 = 0;
            while (true) {
                int i6 = sonic.f5587b;
                if (i5 >= i4 * i6) {
                    break;
                }
                sonic.f5595j[(i6 * i2) + i5] = 0;
                i5++;
            }
            sonic.f5596k = i4 + sonic.f5596k;
            sonic.f();
            if (sonic.f5598m > i3) {
                sonic.f5598m = i3;
            }
            sonic.f5596k = 0;
            sonic.r = 0;
            sonic.o = 0;
        }
        this.p = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        if (a()) {
            AudioProcessor.AudioFormat audioFormat = this.f5602e;
            this.f5604g = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f5603f;
            this.f5605h = audioFormat2;
            if (this.f5606i) {
                this.f5607j = new Sonic(audioFormat.f5574a, audioFormat.f5575b, this.f5600c, this.f5601d, audioFormat2.f5574a);
            } else {
                Sonic sonic = this.f5607j;
                if (sonic != null) {
                    sonic.f5596k = 0;
                    sonic.f5598m = 0;
                    sonic.o = 0;
                    sonic.p = 0;
                    sonic.q = 0;
                    sonic.r = 0;
                    sonic.s = 0;
                    sonic.t = 0;
                    sonic.u = 0;
                    sonic.v = 0;
                }
            }
        }
        this.f5610m = AudioProcessor.f5572a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f5576c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i2 = this.f5599b;
        if (i2 == -1) {
            i2 = audioFormat.f5574a;
        }
        this.f5602e = audioFormat;
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.f5575b, 2);
        this.f5603f = audioFormat2;
        this.f5606i = true;
        return audioFormat2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        this.f5600c = 1.0f;
        this.f5601d = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
        this.f5602e = audioFormat;
        this.f5603f = audioFormat;
        this.f5604g = audioFormat;
        this.f5605h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f5572a;
        this.f5608k = byteBuffer;
        this.f5609l = byteBuffer.asShortBuffer();
        this.f5610m = byteBuffer;
        this.f5599b = -1;
        this.f5606i = false;
        this.f5607j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
