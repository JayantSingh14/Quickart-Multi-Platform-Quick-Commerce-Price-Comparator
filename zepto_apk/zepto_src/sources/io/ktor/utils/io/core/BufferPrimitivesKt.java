package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BufferPrimitivesKt {
    public static final void a(ChunkBuffer chunkBuffer, byte[] destination, int i2, int i3) throws EOFException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i4 = chunkBuffer.f51181b;
        if (chunkBuffer.f51182c - i4 < i3) {
            throw new EOFException("Not enough bytes to read a byte array of size " + i3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        ByteBuffer copyTo = chunkBuffer.f51180a;
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!copyTo.hasArray() || copyTo.isReadOnly()) {
            copyTo.duplicate().get(destination, i2, i3);
        } else {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i4, destination, i2, i3);
        }
        Unit unit = Unit.f53572a;
        chunkBuffer.c(i3);
    }

    public static final void b(ChunkBuffer chunkBuffer, byte[] source, int i2, int i3) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i4 = chunkBuffer.f51182c;
        int i5 = chunkBuffer.f51184e - i4;
        if (i5 < i3) {
            throw new InsufficientSpaceException("byte array", i3, i5);
        }
        ByteBuffer buffer = ByteBuffer.wrap(source, i2, i3).slice().order(java.nio.ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(buffer, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        ByteBuffer byteBuffer = Memory.f51175b;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Memory.b(buffer, 0, i3, chunkBuffer.f51180a, i4);
        chunkBuffer.a(i3);
    }
}
