package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BufferUtilsJvmKt {
    public static final ChunkBuffer a(ByteBuffer buffer, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer byteBuffer = Memory.f51175b;
        ByteBuffer buffer2 = buffer.slice().order(java.nio.ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(buffer2, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        return new ChunkBuffer(buffer2, null, objectPool);
    }

    public static final void c(Buffer buffer, ByteBuffer dst, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer byteBuffer = buffer.f51180a;
        int i3 = buffer.f51181b;
        if (buffer.f51182c - i3 < i2) {
            throw new EOFException("Not enough bytes to read a buffer content of size " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        int iLimit = dst.limit();
        try {
            dst.limit(dst.position() + i2);
            MemoryJvmKt.a(byteBuffer, dst, i3);
            dst.limit(iLimit);
            Unit unit = Unit.f53572a;
            buffer.c(i2);
        } catch (Throwable th) {
            dst.limit(iLimit);
            throw th;
        }
    }

    public static final void d(ChunkBuffer chunkBuffer, ByteBuffer child) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        chunkBuffer.f(child.limit());
        chunkBuffer.b(child.position());
    }
}
