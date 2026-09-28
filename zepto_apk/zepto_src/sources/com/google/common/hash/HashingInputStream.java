package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class HashingInputStream extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 == -1) {
            return i2;
        }
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (i4 == -1) {
            return i4;
        }
        throw null;
    }
}
