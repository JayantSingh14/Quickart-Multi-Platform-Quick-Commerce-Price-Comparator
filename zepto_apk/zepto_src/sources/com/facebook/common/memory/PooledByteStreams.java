package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;
import java.io.OutputStream;

@Nullsafe
/* loaded from: classes.dex */
public class PooledByteStreams {

    /* renamed from: a, reason: collision with root package name */
    public final int f17105a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f17106b;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        Preconditions.a(true);
        this.f17105a = 16384;
        this.f17106b = byteArrayPool;
    }

    public final void a(InputStream inputStream, OutputStream outputStream) {
        ByteArrayPool byteArrayPool = this.f17106b;
        int i2 = this.f17105a;
        byte[] bArr = (byte[]) byteArrayPool.get(i2);
        while (true) {
            try {
                int i3 = inputStream.read(bArr, 0, i2);
                if (i3 == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i3);
                }
            } finally {
                byteArrayPool.a(bArr);
            }
        }
    }
}
