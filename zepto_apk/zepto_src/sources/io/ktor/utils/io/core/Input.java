package io.ktor.utils.io.core;

import android.support.v4.media.b;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class Input implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final ObjectPool f51194a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f51195b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f51196c;

    /* renamed from: d, reason: collision with root package name */
    public int f51197d;

    /* renamed from: e, reason: collision with root package name */
    public int f51198e;

    /* renamed from: f, reason: collision with root package name */
    public long f51199f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f51200g;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Input() {
        ChunkBuffer chunkBuffer = ChunkBuffer.f51216l;
        this(chunkBuffer, BuffersKt.d(chunkBuffer), BufferFactoryKt.f51186a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        throw new java.lang.IllegalStateException("Buffer's limit change is not allowed");
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0416  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String Z(io.ktor.utils.io.core.Input r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.Z(io.ktor.utils.io.core.Input):java.lang.String");
    }

    public final ChunkBuffer A() {
        ChunkBuffer chunkBuffer = this.f51195b;
        int i2 = this.f51197d;
        if (i2 < 0 || i2 > chunkBuffer.f51182c) {
            int i3 = chunkBuffer.f51181b;
            BufferKt.b(i2 - i3, chunkBuffer.f51182c - i3);
            throw null;
        }
        if (chunkBuffer.f51181b != i2) {
            chunkBuffer.f51181b = i2;
        }
        return chunkBuffer;
    }

    public final long D() {
        return (this.f51198e - this.f51197d) + this.f51199f;
    }

    public final ChunkBuffer N() {
        ChunkBuffer chunkBufferA = A();
        return this.f51198e - this.f51197d >= 1 ? chunkBufferA : T(1, chunkBufferA);
    }

    public final ChunkBuffer O(int i2) {
        return T(i2, A());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.ktor.utils.io.core.internal.ChunkBuffer T(int r8, io.ktor.utils.io.core.internal.ChunkBuffer r9) {
        /*
            r7 = this;
        L0:
            int r0 = r7.f51198e
            int r1 = r7.f51197d
            int r0 = r0 - r1
            if (r0 < r8) goto L9
            goto L7b
        L9:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r9.i()
            r2 = 0
            if (r1 != 0) goto L17
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r7.c()
            if (r1 != 0) goto L17
            return r2
        L17:
            if (r0 != 0) goto L22
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.ChunkBuffer.f51216l
            if (r9 == r0) goto L20
            r7.j0(r9)
        L20:
            r9 = r1
            goto L0
        L22:
            int r0 = r8 - r0
            int r0 = io.ktor.utils.io.core.BufferAppendKt.a(r9, r1, r0)
            int r3 = r9.f51182c
            r7.f51198e = r3
            long r3 = r7.f51199f
            long r5 = (long) r0
            long r3 = r3 - r5
            r7.k0(r3)
            int r3 = r1.f51182c
            int r4 = r1.f51181b
            if (r3 <= r4) goto L65
            if (r0 < 0) goto L55
            if (r4 < r0) goto L40
            r1.f51183d = r0
            goto L74
        L40:
            if (r4 != r3) goto L51
            int r3 = r1.f51184e
            if (r0 > r3) goto L4d
            r1.f51182c = r0
            r1.f51181b = r0
            r1.f51183d = r0
            goto L74
        L4d:
            io.ktor.utils.io.core.BufferKt.h(r0, r1)
            throw r2
        L51:
            io.ktor.utils.io.core.BufferKt.g(r0, r1)
            throw r2
        L55:
            java.lang.String r8 = "startGap shouldn't be negative: "
            java.lang.String r8 = android.support.v4.media.b.f(r0, r8)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L65:
            r9.g()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = r1.g()
            r9.m(r0)
            io.ktor.utils.io.pool.ObjectPool r0 = r7.f51194a
            r1.k(r0)
        L74:
            int r0 = r9.f51182c
            int r1 = r9.f51181b
            int r0 = r0 - r1
            if (r0 < r8) goto L7c
        L7b:
            return r9
        L7c:
            r0 = 8
            if (r8 > r0) goto L82
            goto L0
        L82:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "minSize of "
            java.lang.String r1 = " is too big (should be less than 8)"
            java.lang.String r8 = android.support.v4.media.b.g(r8, r0, r1)
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.T(int, io.ktor.utils.io.core.internal.ChunkBuffer):io.ktor.utils.io.core.internal.ChunkBuffer");
    }

    public final byte V() throws EOFException {
        int i2 = this.f51197d;
        int i3 = i2 + 1;
        int i4 = this.f51198e;
        if (i3 < i4) {
            this.f51197d = i3;
            return this.f51196c.get(i2);
        }
        if (i2 >= i4) {
            ChunkBuffer chunkBufferN = N();
            if (chunkBufferN == null) {
                StringsKt.a(1);
                throw null;
            }
            int i5 = chunkBufferN.f51181b;
            if (i5 == chunkBufferN.f51182c) {
                throw new EOFException("No readable bytes available.");
            }
            chunkBufferN.f51181b = i5 + 1;
            byte b2 = chunkBufferN.f51180a.get(i5);
            UnsafeKt.a(this, chunkBufferN);
            return b2;
        }
        byte b3 = this.f51196c.get(i2);
        this.f51197d = i2;
        ChunkBuffer chunkBuffer = this.f51195b;
        if (i2 < 0 || i2 > chunkBuffer.f51182c) {
            int i6 = chunkBuffer.f51181b;
            BufferKt.b(i2 - i6, chunkBuffer.f51182c - i6);
            throw null;
        }
        if (chunkBuffer.f51181b != i2) {
            chunkBuffer.f51181b = i2;
        }
        e(chunkBuffer);
        return b3;
    }

    public abstract void a();

    public final void b(int i2) throws EOFException {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "Negative discard is not allowed: ").toString());
        }
        int i3 = 0;
        int i4 = i2;
        while (i4 != 0) {
            ChunkBuffer chunkBufferN = N();
            if (chunkBufferN == null) {
                break;
            }
            int iMin = Math.min(chunkBufferN.f51182c - chunkBufferN.f51181b, i4);
            chunkBufferN.c(iMin);
            this.f51197d += iMin;
            if (chunkBufferN.f51182c - chunkBufferN.f51181b == 0) {
                j0(chunkBufferN);
            }
            i4 -= iMin;
            i3 += iMin;
        }
        if (i3 != i2) {
            throw new EOFException(b.g(i2, "Unable to discard ", " bytes due to end of packet"));
        }
    }

    public final ChunkBuffer c() {
        if (this.f51200g) {
            return null;
        }
        ChunkBuffer chunkBufferL = l();
        if (chunkBufferL == null) {
            this.f51200g = true;
            return null;
        }
        ChunkBuffer chunkBufferB = BuffersKt.b(this.f51195b);
        if (chunkBufferB != ChunkBuffer.f51216l) {
            chunkBufferB.m(chunkBufferL);
            k0(BuffersKt.d(chunkBufferL) + this.f51199f);
            return chunkBufferL;
        }
        l0(chunkBufferL);
        if (this.f51199f != 0) {
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
        ChunkBuffer chunkBufferI = chunkBufferL.i();
        k0(chunkBufferI != null ? BuffersKt.d(chunkBufferI) : 0L);
        return chunkBufferL;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
        if (!this.f51200g) {
            this.f51200g = true;
        }
        a();
    }

    public final ChunkBuffer e(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        ChunkBuffer chunkBuffer = ChunkBuffer.f51216l;
        while (current != chunkBuffer) {
            ChunkBuffer chunkBufferG = current.g();
            current.k(this.f51194a);
            if (chunkBufferG == null) {
                l0(chunkBuffer);
                k0(0L);
                current = chunkBuffer;
            } else {
                if (chunkBufferG.f51182c > chunkBufferG.f51181b) {
                    l0(chunkBufferG);
                    k0(this.f51199f - (chunkBufferG.f51182c - chunkBufferG.f51181b));
                    return chunkBufferG;
                }
                current = chunkBufferG;
            }
        }
        return c();
    }

    public final void j0(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer chunkBufferG = head.g();
        if (chunkBufferG == null) {
            chunkBufferG = ChunkBuffer.f51216l;
        }
        l0(chunkBufferG);
        k0(this.f51199f - (chunkBufferG.f51182c - chunkBufferG.f51181b));
        head.k(this.f51194a);
    }

    public final void k0(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "tailRemaining shouldn't be negative: ").toString());
        }
        this.f51199f = j2;
    }

    public ChunkBuffer l() {
        ObjectPool objectPool = this.f51194a;
        ChunkBuffer chunkBuffer = (ChunkBuffer) objectPool.S0();
        try {
            chunkBuffer.e();
            ByteBuffer byteBuffer = chunkBuffer.f51180a;
            int i2 = chunkBuffer.f51182c;
            int iR = r(byteBuffer, i2, chunkBuffer.f51184e - i2);
            if (iR == 0) {
                this.f51200g = true;
                if (chunkBuffer.f51182c <= chunkBuffer.f51181b) {
                    chunkBuffer.k(objectPool);
                    return null;
                }
            }
            chunkBuffer.a(iR);
            return chunkBuffer;
        } catch (Throwable th) {
            chunkBuffer.k(objectPool);
            throw th;
        }
    }

    public final void l0(ChunkBuffer chunkBuffer) {
        this.f51195b = chunkBuffer;
        this.f51196c = chunkBuffer.f51180a;
        this.f51197d = chunkBuffer.f51181b;
        this.f51198e = chunkBuffer.f51182c;
    }

    public abstract int r(ByteBuffer byteBuffer, int i2, int i3);

    public final void release() {
        ChunkBuffer chunkBufferA = A();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        ChunkBuffer chunkBuffer = ChunkBuffer.f51216l;
        if (chunkBufferA != chunkBuffer) {
            l0(chunkBuffer);
            k0(0L);
            BuffersKt.c(chunkBufferA, this.f51194a);
        }
    }

    public final void s(ChunkBuffer chunkBuffer) {
        if (this.f51200g && chunkBuffer.i() == null) {
            this.f51197d = chunkBuffer.f51181b;
            this.f51198e = chunkBuffer.f51182c;
            k0(0L);
            return;
        }
        int i2 = chunkBuffer.f51182c - chunkBuffer.f51181b;
        int iMin = Math.min(i2, 8 - (chunkBuffer.f51185f - chunkBuffer.f51184e));
        ObjectPool objectPool = this.f51194a;
        if (i2 > iMin) {
            ChunkBuffer chunkBuffer2 = (ChunkBuffer) objectPool.S0();
            ChunkBuffer chunkBuffer3 = (ChunkBuffer) objectPool.S0();
            chunkBuffer2.e();
            chunkBuffer3.e();
            chunkBuffer2.m(chunkBuffer3);
            chunkBuffer3.m(chunkBuffer.g());
            BufferAppendKt.a(chunkBuffer2, chunkBuffer, i2 - iMin);
            BufferAppendKt.a(chunkBuffer3, chunkBuffer, iMin);
            l0(chunkBuffer2);
            k0(BuffersKt.d(chunkBuffer3));
        } else {
            ChunkBuffer chunkBuffer4 = (ChunkBuffer) objectPool.S0();
            chunkBuffer4.e();
            chunkBuffer4.m(chunkBuffer.g());
            BufferAppendKt.a(chunkBuffer4, chunkBuffer, i2);
            l0(chunkBuffer4);
        }
        chunkBuffer.k(objectPool);
    }

    public final boolean x() {
        if (this.f51198e - this.f51197d == 0 && this.f51199f == 0) {
            return this.f51200g || c() == null;
        }
        return false;
    }

    public Input(ChunkBuffer head, long j2, ObjectPool pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f51194a = pool;
        this.f51195b = head;
        this.f51196c = head.f51180a;
        this.f51197d = head.f51181b;
        this.f51198e = head.f51182c;
        this.f51199f = j2 - (r3 - r6);
    }
}
