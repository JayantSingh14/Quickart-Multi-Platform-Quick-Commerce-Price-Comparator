package androidx.emoji2.text;

import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

@AnyThread
@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
class MetadataListReader {

    public static class ByteBufferReader implements OpenTypeReader {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f4343a;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.f4343a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final void a(int i2) {
            ByteBuffer byteBuffer = this.f4343a;
            byteBuffer.position(byteBuffer.position() + i2);
        }
    }

    public static class InputStreamOpenTypeReader implements OpenTypeReader {
    }

    public static class OffsetInfo {
    }

    public interface OpenTypeReader {
    }

    public static MetadataList a(MappedByteBuffer mappedByteBuffer) throws IOException {
        ByteBuffer byteBuffer;
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        ByteBufferReader byteBufferReader = new ByteBufferReader(byteBufferDuplicate);
        byteBufferReader.a(4);
        int i2 = byteBufferDuplicate.getShort() & 65535;
        if (i2 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferReader.a(6);
        int i3 = 0;
        while (true) {
            byteBuffer = byteBufferReader.f4343a;
            if (i3 >= i2) {
                j2 = -1;
                break;
            }
            int i4 = byteBuffer.getInt();
            byteBufferReader.a(4);
            j2 = byteBuffer.getInt() & 4294967295L;
            byteBufferReader.a(4);
            if (1835365473 == i4) {
                break;
            }
            i3++;
        }
        if (j2 != -1) {
            byteBufferReader.a((int) (j2 - byteBuffer.position()));
            byteBufferReader.a(12);
            long j3 = byteBuffer.getInt() & 4294967295L;
            for (int i5 = 0; i5 < j3; i5++) {
                int i6 = byteBuffer.getInt();
                long j4 = byteBuffer.getInt() & 4294967295L;
                byteBuffer.getInt();
                if (1164798569 == i6 || 1701669481 == i6) {
                    byteBufferDuplicate.position((int) (j4 + j2));
                    MetadataList metadataList = new MetadataList();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    metadataList.f4386b = byteBufferDuplicate;
                    metadataList.f4385a = iPosition;
                    int i7 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    metadataList.f4387c = i7;
                    metadataList.f4388d = metadataList.f4386b.getShort(i7);
                    return metadataList;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }
}
