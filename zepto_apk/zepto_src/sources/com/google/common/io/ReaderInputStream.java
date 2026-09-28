package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
final class ReaderInputStream extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public CharBuffer f43251a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f43252b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f43253c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f43254d;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (read(null) != 1) {
            return -1;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r1 <= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        return -1;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r6, int r7, int r8) throws java.nio.charset.CharacterCodingException {
        /*
            r5 = this;
            int r0 = r7 + r8
            int r1 = r6.length
            com.google.common.base.Preconditions.l(r7, r0, r1)
            r0 = 0
            if (r8 != 0) goto La
            return r0
        La:
            r1 = r0
        Lb:
            boolean r2 = r5.f43253c
            if (r2 == 0) goto L37
            int r2 = r7 + r1
            int r3 = r8 - r1
            java.nio.ByteBuffer r4 = r5.f43252b
            int r4 = r4.remaining()
            int r3 = java.lang.Math.min(r3, r4)
            java.nio.ByteBuffer r4 = r5.f43252b
            r4.get(r6, r2, r3)
            int r1 = r1 + r3
            if (r1 == r8) goto L32
            boolean r2 = r5.f43254d
            if (r2 == 0) goto L2a
            goto L32
        L2a:
            r5.f43253c = r0
            java.nio.ByteBuffer r2 = r5.f43252b
            r2.clear()
            goto L37
        L32:
            if (r1 <= 0) goto L35
            return r1
        L35:
            r6 = -1
            return r6
        L37:
            boolean r2 = r5.f43254d
            r3 = 0
            if (r2 == 0) goto Lca
            java.nio.charset.CoderResult r2 = java.nio.charset.CoderResult.UNDERFLOW
            boolean r4 = r2.isOverflow()
            if (r4 == 0) goto L64
            java.nio.ByteBuffer r2 = r5.f43252b
            r2.flip()
            java.nio.ByteBuffer r2 = r5.f43252b
            int r2 = r2.remaining()
            if (r2 != 0) goto L60
            java.nio.ByteBuffer r2 = r5.f43252b
            int r2 = r2.capacity()
            int r2 = r2 * 2
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            r5.f43252b = r2
            goto Lb
        L60:
            r2 = 1
            r5.f43253c = r2
            goto Lb
        L64:
            boolean r4 = r2.isUnderflow()
            if (r4 == 0) goto Lc0
            java.nio.CharBuffer r6 = r5.f43251a
            int r7 = r6.capacity()
            int r6 = r6.limit()
            int r7 = r7 - r6
            if (r7 != 0) goto Lad
            java.nio.CharBuffer r6 = r5.f43251a
            int r6 = r6.position()
            if (r6 <= 0) goto L89
            java.nio.CharBuffer r6 = r5.f43251a
            java.nio.CharBuffer r6 = r6.compact()
            r6.flip()
            goto Lad
        L89:
            java.nio.CharBuffer r6 = r5.f43251a
            char[] r7 = r6.array()
            int r8 = r6.capacity()
            int r8 = r8 * 2
            char[] r7 = java.util.Arrays.copyOf(r7, r8)
            java.nio.CharBuffer r7 = java.nio.CharBuffer.wrap(r7)
            int r8 = r6.position()
            r7.position(r8)
            int r6 = r6.limit()
            r7.limit(r6)
            r5.f43251a = r7
        Lad:
            java.nio.CharBuffer r6 = r5.f43251a
            r6.limit()
            java.nio.CharBuffer r6 = r5.f43251a
            r6.array()
            java.nio.CharBuffer r6 = r5.f43251a
            r6.capacity()
            r6.limit()
            throw r3
        Lc0:
            boolean r3 = r2.isError()
            if (r3 == 0) goto L37
            r2.throwException()
            return r0
        Lca:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.read(byte[], int, int):int");
    }
}
