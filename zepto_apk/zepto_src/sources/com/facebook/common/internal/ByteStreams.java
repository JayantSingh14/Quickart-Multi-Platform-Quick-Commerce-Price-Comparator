package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe
/* loaded from: classes3.dex */
public final class ByteStreams {

    public static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
    }

    public static int a(InputStream inputStream, byte[] bArr, int i2) throws IOException {
        inputStream.getClass();
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }
}
