package io.ktor.websocket;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FrameCommonKt {
    public static final CloseReason a(Frame.Close close) {
        Intrinsics.checkNotNullParameter(close, "<this>");
        if (close.f51442c.length < 2) {
            return null;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        try {
            byte[] bArr = close.f51442c;
            OutputKt.b(bytePacketBuilder, bArr, 0, bArr.length);
            ByteReadPacket byteReadPacketV = bytePacketBuilder.V();
            return new CloseReason(Input.Z(byteReadPacketV), InputPrimitivesKt.a(byteReadPacketV));
        } catch (Throwable th) {
            bytePacketBuilder.close();
            throw th;
        }
    }
}
