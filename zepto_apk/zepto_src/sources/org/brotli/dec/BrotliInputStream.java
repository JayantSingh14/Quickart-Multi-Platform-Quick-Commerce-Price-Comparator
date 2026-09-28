package org.brotli.dec;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.InputStream;
import okio.RealBufferedSource$inputStream$1;

/* loaded from: classes5.dex */
public class BrotliInputStream extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f57404a;

    /* renamed from: b, reason: collision with root package name */
    public int f57405b;

    /* renamed from: c, reason: collision with root package name */
    public int f57406c;

    /* renamed from: d, reason: collision with root package name */
    public final State f57407d;

    public BrotliInputStream(RealBufferedSource$inputStream$1 realBufferedSource$inputStream$1) throws IOException {
        State state = new State();
        this.f57407d = state;
        this.f57404a = new byte[16384];
        this.f57405b = 0;
        this.f57406c = 0;
        try {
            State.a(state, realBufferedSource$inputStream$1);
        } catch (BrotliRuntimeException e2) {
            throw new IOException("Brotli decoder initialization failed", e2);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        State state = this.f57407d;
        int i2 = state.f57430a;
        if (i2 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i2 == 11) {
            return;
        }
        state.f57430a = 11;
        BitReader bitReader = state.f57432c;
        RealBufferedSource$inputStream$1 realBufferedSource$inputStream$1 = bitReader.f57398d;
        bitReader.f57398d = null;
        if (realBufferedSource$inputStream$1 != null) {
            realBufferedSource$inputStream$1.close();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i2 = this.f57406c;
        int i3 = this.f57405b;
        byte[] bArr = this.f57404a;
        if (i2 >= i3) {
            int i4 = read(bArr, 0, bArr.length);
            this.f57405b = i4;
            this.f57406c = 0;
            if (i4 == -1) {
                return -1;
            }
        }
        int i5 = this.f57406c;
        this.f57406c = i5 + 1;
        return bArr[i5] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        State state = this.f57407d;
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "Bad offset: "));
        }
        if (i3 >= 0) {
            int i4 = i2 + i3;
            if (i4 > bArr.length) {
                StringBuilder sbU = b.u(i4, "Buffer overflow: ", " > ");
                sbU.append(bArr.length);
                throw new IllegalArgumentException(sbU.toString());
            }
            if (i3 == 0) {
                return 0;
            }
            int iMax = Math.max(this.f57405b - this.f57406c, 0);
            if (iMax != 0) {
                iMax = Math.min(iMax, i3);
                System.arraycopy(this.f57404a, this.f57406c, bArr, i2, iMax);
                this.f57406c += iMax;
                i2 += iMax;
                i3 -= iMax;
                if (i3 == 0) {
                    return iMax;
                }
            }
            try {
                state.Y = bArr;
                state.T = i2;
                state.U = i3;
                state.V = 0;
                Decode.d(state);
                int i5 = state.V;
                if (i5 == 0) {
                    return -1;
                }
                return i5 + iMax;
            } catch (BrotliRuntimeException e2) {
                throw new IOException("Brotli stream decoding failed", e2);
            }
        }
        throw new IllegalArgumentException(b.f(i3, "Bad length: "));
    }
}
