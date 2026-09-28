package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FilterOutputStream;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public class CountingOutputStream extends FilterOutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f17076a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        this.f17076a += i3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        this.f17076a++;
    }
}
