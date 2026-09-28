package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.xbill.DNS.TTL;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class Output implements Appendable, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultBufferPool f51202a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f51203b;

    /* renamed from: c, reason: collision with root package name */
    public ChunkBuffer f51204c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f51205d;

    /* renamed from: e, reason: collision with root package name */
    public int f51206e;

    /* renamed from: f, reason: collision with root package name */
    public int f51207f;

    /* renamed from: g, reason: collision with root package name */
    public int f51208g;

    /* renamed from: h, reason: collision with root package name */
    public int f51209h;

    public Output(DefaultBufferPool pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f51202a = pool;
        this.f51205d = Memory.f51175b;
    }

    public final int A() {
        return (this.f51206e - this.f51208g) + this.f51209h;
    }

    public final ChunkBuffer D(int i2) {
        ChunkBuffer chunkBuffer;
        int i3 = this.f51207f;
        int i4 = this.f51206e;
        if (i3 - i4 >= i2 && (chunkBuffer = this.f51204c) != null) {
            chunkBuffer.b(i4);
            return chunkBuffer;
        }
        ChunkBuffer buffer = (ChunkBuffer) this.f51202a.S0();
        buffer.e();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.i() != null) {
            throw new IllegalStateException("It should be a single buffer chunk.");
        }
        r(buffer, buffer, 0);
        return buffer;
    }

    public final ChunkBuffer N() {
        ChunkBuffer chunkBuffer = this.f51203b;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this.f51204c;
        if (chunkBuffer2 != null) {
            chunkBuffer2.b(this.f51206e);
        }
        this.f51203b = null;
        this.f51204c = null;
        this.f51206e = 0;
        this.f51207f = 0;
        this.f51208g = 0;
        this.f51209h = 0;
        this.f51205d = Memory.f51175b;
        return chunkBuffer;
    }

    public final void O(byte b2) throws InsufficientSpaceException {
        int i2 = this.f51206e;
        if (i2 < this.f51207f) {
            this.f51206e = i2 + 1;
            this.f51205d.put(i2, b2);
            return;
        }
        ChunkBuffer buffer = (ChunkBuffer) this.f51202a.S0();
        buffer.e();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.i() != null) {
            throw new IllegalStateException("It should be a single buffer chunk.");
        }
        r(buffer, buffer, 0);
        int i3 = buffer.f51182c;
        if (i3 == buffer.f51184e) {
            throw new InsufficientSpaceException("No free space in the buffer to write a byte");
        }
        buffer.f51180a.put(i3, b2);
        buffer.f51182c = i3 + 1;
        this.f51206e++;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(io.ktor.utils.io.core.ByteReadPacket r11) {
        /*
            r10 = this;
            java.lang.String r0 = "packet"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = r11.A()
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.ChunkBuffer.f51216l
            if (r0 != r1) goto Lf
            r0 = 0
            goto L17
        Lf:
            r11.l0(r1)
            r1 = 0
            r11.k0(r1)
        L17:
            if (r0 != 0) goto L1d
            r11.release()
            return
        L1d:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r10.f51204c
            if (r1 != 0) goto L25
            r10.l(r0)
            return
        L25:
            int r2 = r10.f51206e
            r1.b(r2)
            int r2 = r1.f51182c
            int r3 = r1.f51181b
            int r2 = r2 - r3
            int r3 = r0.f51182c
            int r4 = r0.f51181b
            int r3 = r3 - r4
            int r4 = io.ktor.utils.io.core.PacketJVMKt.a()
            r5 = -1
            int r6 = r1.f51185f
            if (r3 >= r4) goto L48
            int r7 = r1.f51184e
            int r8 = r6 - r7
            int r9 = r1.f51182c
            int r7 = r7 - r9
            int r7 = r7 + r8
            if (r3 > r7) goto L48
            goto L49
        L48:
            r3 = r5
        L49:
            if (r2 >= r4) goto L56
            int r4 = r0.f51183d
            if (r2 > r4) goto L56
            boolean r4 = io.ktor.utils.io.core.internal.ChunkBufferKt.a(r0)
            if (r4 == 0) goto L56
            goto L57
        L56:
            r2 = r5
        L57:
            if (r3 != r5) goto L5f
            if (r2 != r5) goto L5f
            r10.l(r0)
            return
        L5f:
            if (r2 == r5) goto La5
            if (r3 > r2) goto L64
            goto La5
        L64:
            if (r3 == r5) goto L77
            if (r2 >= r3) goto L69
            goto L77
        L69:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "prep = "
            java.lang.String r1 = ", app = "
            java.lang.String r0 = android.support.v4.media.b.d(r2, r3, r0, r1)
            r11.<init>(r0)
            throw r11
        L77:
            io.ktor.utils.io.core.BufferAppendKt.b(r0, r1)
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = r10.f51203b
            if (r11 == 0) goto L9d
            if (r11 != r1) goto L83
            r10.f51203b = r0
            goto L91
        L83:
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = r11.i()
            kotlin.jvm.internal.Intrinsics.c(r2)
            if (r2 == r1) goto L8e
            r11 = r2
            goto L83
        L8e:
            r11.m(r0)
        L91:
            io.ktor.utils.io.core.DefaultBufferPool r11 = r10.f51202a
            r1.k(r11)
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = io.ktor.utils.io.core.BuffersKt.b(r0)
            r10.f51204c = r11
            return
        L9d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "head should't be null since it is already handled in the fast-path"
            r11.<init>(r0)
            throw r11
        La5:
            int r2 = r1.f51184e
            int r3 = r1.f51182c
            int r3 = r2 - r3
            int r6 = r6 - r2
            int r6 = r6 + r3
            io.ktor.utils.io.core.BufferAppendKt.a(r1, r0, r6)
            r10.a()
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r0.g()
            if (r1 == 0) goto Lbc
            r10.l(r1)
        Lbc:
            io.ktor.utils.io.pool.ObjectPool r11 = r11.f51194a
            r0.k(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Output.T(io.ktor.utils.io.core.ByteReadPacket):void");
    }

    public final void a() {
        ChunkBuffer chunkBuffer = this.f51204c;
        if (chunkBuffer != null) {
            this.f51206e = chunkBuffer.f51182c;
        }
    }

    @Override // java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Output append(char c2) {
        int i2 = this.f51206e;
        int i3 = 4;
        if (this.f51207f - i2 >= 3) {
            ByteBuffer byteBuffer = this.f51205d;
            if (c2 >= 0 && c2 < 128) {
                byteBuffer.put(i2, (byte) c2);
                i3 = 1;
            } else if (128 <= c2 && c2 < 2048) {
                byteBuffer.put(i2, (byte) (((c2 >> 6) & 31) | 192));
                byteBuffer.put(i2 + 1, (byte) ((c2 & '?') | 128));
                i3 = 2;
            } else if (2048 <= c2 && c2 < 0) {
                byteBuffer.put(i2, (byte) (((c2 >> '\f') & 15) | 224));
                byteBuffer.put(i2 + 1, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer.put(i2 + 2, (byte) ((c2 & '?') | 128));
                i3 = 3;
            } else {
                if (0 > c2 || c2 >= 0) {
                    UTF8Kt.h(c2);
                    throw null;
                }
                byteBuffer.put(i2, (byte) (((c2 >> 18) & 7) | 240));
                byteBuffer.put(i2 + 1, (byte) (((c2 >> '\f') & 63) | 128));
                byteBuffer.put(i2 + 2, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer.put(i2 + 3, (byte) ((c2 & '?') | 128));
            }
            this.f51206e = i2 + i3;
            return this;
        }
        ChunkBuffer chunkBufferD = D(3);
        try {
            ByteBuffer byteBuffer2 = chunkBufferD.f51180a;
            int i4 = chunkBufferD.f51182c;
            if (c2 >= 0 && c2 < 128) {
                byteBuffer2.put(i4, (byte) c2);
                i3 = 1;
            } else if (128 <= c2 && c2 < 2048) {
                byteBuffer2.put(i4, (byte) (((c2 >> 6) & 31) | 192));
                byteBuffer2.put(i4 + 1, (byte) ((c2 & '?') | 128));
                i3 = 2;
            } else if (2048 <= c2 && c2 < 0) {
                byteBuffer2.put(i4, (byte) (((c2 >> '\f') & 15) | 224));
                byteBuffer2.put(i4 + 1, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer2.put(i4 + 2, (byte) ((c2 & '?') | 128));
                i3 = 3;
            } else {
                if (0 > c2 || c2 >= 0) {
                    UTF8Kt.h(c2);
                    throw null;
                }
                byteBuffer2.put(i4, (byte) (((c2 >> 18) & 7) | 240));
                byteBuffer2.put(i4 + 1, (byte) (((c2 >> '\f') & 63) | 128));
                byteBuffer2.put(i4 + 2, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer2.put(i4 + 3, (byte) ((c2 & '?') | 128));
            }
            chunkBufferD.a(i3);
            if (i3 < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            a();
            return this;
        } catch (Throwable th) {
            a();
            throw th;
        }
    }

    @Override // java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Output append(CharSequence charSequence) {
        if (charSequence == null) {
            append("null", 0, 4);
            return this;
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            DefaultBufferPool defaultBufferPool = this.f51202a;
            ChunkBuffer chunkBufferN = N();
            if (chunkBufferN != null) {
                ChunkBuffer chunkBufferI = chunkBufferN;
                do {
                    try {
                        ByteBuffer byteBuffer = chunkBufferI.f51180a;
                        int i2 = chunkBufferI.f51181b;
                        x(byteBuffer, i2, chunkBufferI.f51182c - i2);
                        chunkBufferI = chunkBufferI.i();
                    } finally {
                        BuffersKt.c(chunkBufferN, defaultBufferPool);
                    }
                } while (chunkBufferI != null);
            }
        } finally {
            s();
        }
    }

    @Override // java.lang.Appendable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Output append(CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            return append("null", i2, i3);
        }
        StringsKt.e(this, charSequence, i2, i3, Charsets.UTF_8);
        return this;
    }

    public final void l(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer chunkBufferB = BuffersKt.b(head);
        long jD = BuffersKt.d(head) - (chunkBufferB.f51182c - chunkBufferB.f51181b);
        if (jD < TTL.MAX_VALUE) {
            r(head, chunkBufferB, (int) jD);
        } else {
            NumbersKt.a(jD, "total size increase");
            throw null;
        }
    }

    public final void r(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, int i2) {
        ChunkBuffer chunkBuffer3 = this.f51204c;
        if (chunkBuffer3 == null) {
            this.f51203b = chunkBuffer;
            this.f51209h = 0;
        } else {
            chunkBuffer3.m(chunkBuffer);
            int i3 = this.f51206e;
            chunkBuffer3.b(i3);
            this.f51209h = (i3 - this.f51208g) + this.f51209h;
        }
        this.f51204c = chunkBuffer2;
        this.f51209h += i2;
        this.f51205d = chunkBuffer2.f51180a;
        this.f51206e = chunkBuffer2.f51182c;
        this.f51208g = chunkBuffer2.f51181b;
        this.f51207f = chunkBuffer2.f51184e;
    }

    public abstract void s();

    public abstract void x(ByteBuffer byteBuffer, int i2, int i3);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Output() {
        this(BufferFactoryKt.f51186a);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
    }
}
