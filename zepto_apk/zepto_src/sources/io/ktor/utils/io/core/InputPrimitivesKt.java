package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InputPrimitivesKt {
    public static final short a(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        int i2 = byteReadPacket.f51198e;
        int i3 = byteReadPacket.f51197d;
        if (i2 - i3 > 2) {
            byteReadPacket.f51197d = i3 + 2;
            return byteReadPacket.f51196c.getShort(i3);
        }
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        ChunkBuffer chunkBufferO = byteReadPacket.O(2);
        if (chunkBufferO == null) {
            StringsKt.a(2);
            throw null;
        }
        Intrinsics.checkNotNullParameter(chunkBufferO, "<this>");
        int i4 = chunkBufferO.f51181b;
        if (chunkBufferO.f51182c - i4 < 2) {
            throw new EOFException("Not enough bytes to read a short integer of size 2.");
        }
        short s = chunkBufferO.f51180a.getShort(i4);
        chunkBufferO.c(2);
        UnsafeKt.a(byteReadPacket, chunkBufferO);
        return s;
    }
}
