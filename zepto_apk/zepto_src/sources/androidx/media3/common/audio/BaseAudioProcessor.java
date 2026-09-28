package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5578b;

    /* renamed from: c, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5579c;

    /* renamed from: d, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5580d;

    /* renamed from: e, reason: collision with root package name */
    public AudioProcessor.AudioFormat f5581e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f5582f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f5583g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5584h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f5572a;
        this.f5582f = byteBuffer;
        this.f5583g = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
        this.f5580d = audioFormat;
        this.f5581e = audioFormat;
        this.f5578b = audioFormat;
        this.f5579c = audioFormat;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean a() {
        return this.f5581e != AudioProcessor.AudioFormat.f5573e;
    }

    public AudioProcessor.AudioFormat b(AudioProcessor.AudioFormat audioFormat) {
        return AudioProcessor.AudioFormat.f5573e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean c() {
        return this.f5584h && this.f5583g == AudioProcessor.f5572a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f5583g;
        this.f5583g = AudioProcessor.f5572a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void f() {
        this.f5584h = true;
        i();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        this.f5583g = AudioProcessor.f5572a;
        this.f5584h = false;
        this.f5578b = this.f5580d;
        this.f5579c = this.f5581e;
        h();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) {
        this.f5580d = audioFormat;
        this.f5581e = b(audioFormat);
        return a() ? this.f5581e : AudioProcessor.AudioFormat.f5573e;
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public final ByteBuffer k(int i2) {
        if (this.f5582f.capacity() < i2) {
            this.f5582f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f5582f.clear();
        }
        ByteBuffer byteBuffer = this.f5582f;
        this.f5583g = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f5582f = AudioProcessor.f5572a;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
        this.f5580d = audioFormat;
        this.f5581e = audioFormat;
        this.f5578b = audioFormat;
        this.f5579c = audioFormat;
        j();
    }
}
