package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class FlatBufferBuilder {

    public static class ByteBufferBackedInputStream extends InputStream {
        @Override // java.io.InputStream
        public final int read() {
            throw null;
        }
    }

    public static abstract class ByteBufferFactory {
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {

        /* renamed from: a, reason: collision with root package name */
        public static final HeapByteBufferFactory f4367a = new HeapByteBufferFactory();
    }

    public FlatBufferBuilder() {
        HeapByteBufferFactory heapByteBufferFactory = HeapByteBufferFactory.f4367a;
        if (Utf8.f4389a == null) {
            Utf8.f4389a = new Utf8Safe();
        }
        heapByteBufferFactory.getClass();
        ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN).capacity();
    }
}
