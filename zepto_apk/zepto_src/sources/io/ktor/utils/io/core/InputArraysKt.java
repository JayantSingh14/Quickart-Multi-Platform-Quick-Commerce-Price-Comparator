package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InputArraysKt {
    public static final int a(ByteReadPacket byteReadPacket, byte[] dst, int i2, int i3) throws Throwable {
        int i4;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        boolean z = true;
        ChunkBuffer chunkBufferO = byteReadPacket.O(1);
        if (chunkBufferO == null) {
            i4 = i3;
        } else {
            i4 = i3;
            while (true) {
                try {
                    int iMin = Math.min(i4, chunkBufferO.f51182c - chunkBufferO.f51181b);
                    BufferPrimitivesKt.a(chunkBufferO, dst, i2, iMin);
                    i4 -= iMin;
                    i2 += iMin;
                    if (i4 <= 0) {
                        UnsafeKt.a(byteReadPacket, chunkBufferO);
                        break;
                    }
                    try {
                        chunkBufferO = UnsafeKt.c(byteReadPacket, chunkBufferO);
                        if (chunkBufferO == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.a(byteReadPacket, chunkBufferO);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return i3 - i4;
    }

    public static final long b(Input readAvailable, ByteBuffer byteBuffer, long j2, long j3) throws Throwable {
        long j4;
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        ByteBuffer destination = byteBuffer;
        Intrinsics.checkNotNullParameter(destination, "destination");
        boolean z = true;
        ChunkBuffer chunkBufferB = UnsafeKt.b(readAvailable, 1);
        if (chunkBufferB == null) {
            j4 = j3;
        } else {
            long j5 = j2;
            j4 = j3;
            ChunkBuffer chunkBufferC = chunkBufferB;
            while (true) {
                try {
                    int iMin = (int) Math.min(j4, chunkBufferC.f51182c - chunkBufferC.f51181b);
                    long j6 = iMin;
                    Memory.a(chunkBufferC.f51181b, j6, j5, chunkBufferC.f51180a, destination);
                    chunkBufferC.c(iMin);
                    j4 -= j6;
                    j5 += j6;
                    if (j4 <= 0) {
                        UnsafeKt.a(readAvailable, chunkBufferC);
                        break;
                    }
                    try {
                        chunkBufferC = UnsafeKt.c(readAvailable, chunkBufferC);
                        if (chunkBufferC == null) {
                            break;
                        }
                        destination = byteBuffer;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.a(readAvailable, chunkBufferC);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        long j7 = j3 - j4;
        if (j7 == 0 && readAvailable.x()) {
            return -1L;
        }
        return j7;
    }
}
