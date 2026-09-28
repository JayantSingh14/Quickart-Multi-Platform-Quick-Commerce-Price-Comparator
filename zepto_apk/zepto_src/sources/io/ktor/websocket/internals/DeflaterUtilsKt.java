package io.ktor.websocket.internals;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DeflaterUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f51538a = {0, 0, 0, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f51539b = {0, 0, -1, -1};

    public static final int a(BytePacketBuilder bytePacketBuilder, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        byteBuffer.clear();
        int iDeflate = z ? deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2) : deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        OutputArraysJVMKt.a(bytePacketBuilder, byteBuffer);
        return iDeflate;
    }
}
