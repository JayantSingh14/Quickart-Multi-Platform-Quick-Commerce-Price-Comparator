package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class BatchBuffer extends DecoderInputBuffer {

    /* renamed from: i, reason: collision with root package name */
    public long f7309i;

    /* renamed from: j, reason: collision with root package name */
    public int f7310j;

    /* renamed from: k, reason: collision with root package name */
    public int f7311k;

    public BatchBuffer() {
        super(2);
        this.f7311k = 32;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer
    public final void h() {
        super.h();
        this.f7310j = 0;
    }

    public final boolean p(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        Assertions.a(!decoderInputBuffer.g(1073741824));
        Assertions.a(!decoderInputBuffer.g(268435456));
        Assertions.a(!decoderInputBuffer.g(4));
        if (q()) {
            if (this.f7310j >= this.f7311k) {
                return false;
            }
            ByteBuffer byteBuffer2 = decoderInputBuffer.f6071d;
            if (byteBuffer2 != null && (byteBuffer = this.f6071d) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i2 = this.f7310j;
        this.f7310j = i2 + 1;
        if (i2 == 0) {
            this.f6073f = decoderInputBuffer.f6073f;
            if (decoderInputBuffer.g(1)) {
                this.f6056a = 1;
            }
        }
        ByteBuffer byteBuffer3 = decoderInputBuffer.f6071d;
        if (byteBuffer3 != null) {
            l(byteBuffer3.remaining());
            this.f6071d.put(byteBuffer3);
        }
        this.f7309i = decoderInputBuffer.f6073f;
        return true;
    }

    public final boolean q() {
        return this.f7310j > 0;
    }
}
