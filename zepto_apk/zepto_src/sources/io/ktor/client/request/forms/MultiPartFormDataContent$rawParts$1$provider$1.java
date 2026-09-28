package io.ktor.client.request.forms;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MultiPartFormDataContent$rawParts$1$provider$1 extends Lambda implements Function0<ByteReadPacket> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        try {
            OutputKt.b(bytePacketBuilder, null, 0, null.length);
            throw null;
        } catch (Throwable th) {
            bytePacketBuilder.close();
            throw th;
        }
    }
}
