package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes3.dex */
abstract class AllocatedBuffer {

    /* renamed from: androidx.datastore.preferences.protobuf.AllocatedBuffer$1, reason: invalid class name */
    class AnonymousClass1 extends AllocatedBuffer {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.AllocatedBuffer$2, reason: invalid class name */
    class AnonymousClass2 extends AllocatedBuffer {
    }

    public static AnonymousClass1 a(ByteBuffer byteBuffer) {
        Internal.a(byteBuffer, "buffer");
        return new AnonymousClass1();
    }

    public static void b(int i2, byte[] bArr, int i3) {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }
}
