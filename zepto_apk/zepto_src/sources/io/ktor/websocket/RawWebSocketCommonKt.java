package io.ktor.websocket;

import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RawWebSocketCommonKt {
    public static final ByteReadPacket a(ByteReadPacket byteReadPacket, int i2) {
        long j2 = 4;
        DefaultAllocator defaultAllocator = DefaultAllocator.f51174a;
        if (j2 >= TTL.MAX_VALUE) {
            NumbersKt.a(j2, "size");
            throw null;
        }
        ByteBuffer instance = defaultAllocator.b((int) j2);
        try {
            instance.putInt(0, i2);
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
            try {
                int iD = (int) byteReadPacket.D();
                for (int i3 = 0; i3 < iD; i3++) {
                    bytePacketBuilder.O((byte) (byteReadPacket.V() ^ instance.get(i3 % 4)));
                }
                ByteReadPacket byteReadPacketV = bytePacketBuilder.V();
                Intrinsics.checkNotNullParameter(instance, "instance");
                return byteReadPacketV;
            } finally {
            }
        } catch (Throwable th) {
            defaultAllocator.a(instance);
            throw th;
        }
    }
}
