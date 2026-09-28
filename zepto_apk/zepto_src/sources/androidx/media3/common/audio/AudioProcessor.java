package androidx.media3.common.audio;

import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f5572a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {

        /* renamed from: e, reason: collision with root package name */
        public static final AudioFormat f5573e = new AudioFormat(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f5574a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5575b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5576c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5577d;

        public AudioFormat(int i2, int i3, int i4) {
            this.f5574a = i2;
            this.f5575b = i3;
            this.f5576c = i4;
            this.f5577d = Util.O(i4) ? Util.C(i4, i3) : -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            return this.f5574a == audioFormat.f5574a && this.f5575b == audioFormat.f5575b && this.f5576c == audioFormat.f5576c;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5574a), Integer.valueOf(this.f5575b), Integer.valueOf(this.f5576c)});
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AudioFormat[sampleRate=");
            sb.append(this.f5574a);
            sb.append(", channelCount=");
            sb.append(this.f5575b);
            sb.append(", encoding=");
            return b.n(sb, this.f5576c, ']');
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            this("Unhandled input format:", audioFormat);
        }

        public UnhandledAudioFormatException(String str, AudioFormat audioFormat) {
            super(str + StringUtils.SPACE + audioFormat);
        }
    }

    boolean a();

    boolean c();

    ByteBuffer d();

    void e(ByteBuffer byteBuffer);

    void f();

    void flush();

    AudioFormat g(AudioFormat audioFormat);

    void reset();
}
