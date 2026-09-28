package com.facebook.react.modules.network;

import java.io.FilterOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
class CountingOutputStream extends FilterOutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f19128a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        this.f19128a += i3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        this.f19128a++;
    }
}
