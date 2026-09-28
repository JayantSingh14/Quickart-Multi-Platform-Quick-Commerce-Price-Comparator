package androidx.media3.decoder;

import android.support.v4.media.b;
import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

@UnstableApi
/* loaded from: classes3.dex */
public class DecoderInputBuffer extends Buffer {

    /* renamed from: b, reason: collision with root package name */
    public Format f6069b;

    /* renamed from: c, reason: collision with root package name */
    public final CryptoInfo f6070c = new CryptoInfo();

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f6071d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6072e;

    /* renamed from: f, reason: collision with root package name */
    public long f6073f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f6074g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6075h;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static final class InsufficientCapacityException extends IllegalStateException {
    }

    static {
        MediaLibraryInfo.a("media3.decoder");
    }

    public DecoderInputBuffer(int i2) {
        this.f6075h = i2;
    }

    public void h() {
        this.f6056a = 0;
        ByteBuffer byteBuffer = this.f6071d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f6074g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f6072e = false;
    }

    public final ByteBuffer i(int i2) {
        int i3 = this.f6075h;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f6071d;
        throw new InsufficientCapacityException(b.e(byteBuffer == null ? 0 : byteBuffer.capacity(), i2, "Buffer too small (", " < ", ")"));
    }

    public final void l(int i2) {
        ByteBuffer byteBuffer = this.f6071d;
        if (byteBuffer == null) {
            this.f6071d = i(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.f6071d = byteBuffer;
            return;
        }
        ByteBuffer byteBufferI = i(i3);
        byteBufferI.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferI.put(byteBuffer);
        }
        this.f6071d = byteBufferI;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f6071d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f6074g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
