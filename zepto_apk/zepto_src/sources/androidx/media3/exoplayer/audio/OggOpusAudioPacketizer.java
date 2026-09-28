package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import org.xbill.DNS.Flags;

@UnstableApi
/* loaded from: classes3.dex */
public final class OggOpusAudioPacketizer {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f6618d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f6619e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Flags.CD, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f6620a = AudioProcessor.f5572a;

    /* renamed from: c, reason: collision with root package name */
    public int f6622c = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f6621b = 2;

    public static void a(ByteBuffer byteBuffer, long j2, int i2, int i3, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i2);
        byteBuffer.putInt(0);
        long j3 = i3;
        Preconditions.c(j3, "out of range: %s", (j3 >> 8) == 0);
        byteBuffer.put((byte) j3);
    }
}
