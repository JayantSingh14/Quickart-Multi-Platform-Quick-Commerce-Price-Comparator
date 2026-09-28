package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
final class ReusableBufferedOutputStream extends BufferedOutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6024a;

    public final void a(OutputStream outputStream) {
        Assertions.g(this.f6024a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f6024a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.f6024a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        int i2 = Util.f5744a;
        throw th;
    }
}
