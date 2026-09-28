package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class AudioProcessingPipeline {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f5568a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5569b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f5570c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f5571d;

    public AudioProcessingPipeline(ImmutableList immutableList) {
        this.f5568a = immutableList;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
        this.f5571d = false;
    }

    public final AudioProcessor.AudioFormat a(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.equals(AudioProcessor.AudioFormat.f5573e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f5568a;
            if (i2 >= immutableList.size()) {
                return audioFormat;
            }
            AudioProcessor audioProcessor = (AudioProcessor) immutableList.get(i2);
            AudioProcessor.AudioFormat audioFormatG = audioProcessor.g(audioFormat);
            if (audioProcessor.a()) {
                Assertions.g(!audioFormatG.equals(AudioProcessor.AudioFormat.f5573e));
                audioFormat = audioFormatG;
            }
            i2++;
        }
    }

    public final void b() {
        ArrayList arrayList = this.f5569b;
        arrayList.clear();
        this.f5571d = false;
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f5568a;
            if (i2 >= immutableList.size()) {
                break;
            }
            AudioProcessor audioProcessor = (AudioProcessor) immutableList.get(i2);
            audioProcessor.flush();
            if (audioProcessor.a()) {
                arrayList.add(audioProcessor);
            }
            i2++;
        }
        this.f5570c = new ByteBuffer[arrayList.size()];
        for (int i3 = 0; i3 <= c(); i3++) {
            this.f5570c[i3] = ((AudioProcessor) arrayList.get(i3)).d();
        }
    }

    public final int c() {
        return this.f5570c.length - 1;
    }

    public final boolean d() {
        return this.f5571d && ((AudioProcessor) this.f5569b.get(c())).c() && !this.f5570c[c()].hasRemaining();
    }

    public final boolean e() {
        return !this.f5569b.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioProcessingPipeline)) {
            return false;
        }
        AudioProcessingPipeline audioProcessingPipeline = (AudioProcessingPipeline) obj;
        ImmutableList immutableList = this.f5568a;
        if (immutableList.size() != audioProcessingPipeline.f5568a.size()) {
            return false;
        }
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            if (immutableList.get(i2) != audioProcessingPipeline.f5568a.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final void f(ByteBuffer byteBuffer) {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            int i2 = 0;
            while (i2 <= c()) {
                if (!this.f5570c[i2].hasRemaining()) {
                    ArrayList arrayList = this.f5569b;
                    AudioProcessor audioProcessor = (AudioProcessor) arrayList.get(i2);
                    if (!audioProcessor.c()) {
                        ByteBuffer byteBuffer2 = i2 > 0 ? this.f5570c[i2 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f5572a;
                        long jRemaining = byteBuffer2.remaining();
                        audioProcessor.e(byteBuffer2);
                        this.f5570c[i2] = audioProcessor.d();
                        z |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f5570c[i2].hasRemaining();
                    } else if (!this.f5570c[i2].hasRemaining() && i2 < c()) {
                        ((AudioProcessor) arrayList.get(i2 + 1)).f();
                    }
                }
                i2++;
            }
        }
    }

    public final int hashCode() {
        return this.f5568a.hashCode();
    }
}
