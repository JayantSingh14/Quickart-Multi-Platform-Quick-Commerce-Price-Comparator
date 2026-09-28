package com.facebook.common.util;

import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public class StreamUtil {

    /* renamed from: com.facebook.common.util.StreamUtil$1, reason: invalid class name */
    class AnonymousClass1 extends ByteArrayOutputStream {
        @Override // java.io.ByteArrayOutputStream
        public final byte[] toByteArray() {
            int i2 = ((ByteArrayOutputStream) this).count;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            return i2 == bArr.length ? bArr : super.toByteArray();
        }
    }

    public static void a(PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream, long j2) throws IOException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException();
        }
        while (j2 > 0) {
            long jSkip = pooledByteArrayBufferedInputStream.skip(j2);
            if (jSkip <= 0) {
                if (pooledByteArrayBufferedInputStream.read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j2 -= jSkip;
        }
    }
}
