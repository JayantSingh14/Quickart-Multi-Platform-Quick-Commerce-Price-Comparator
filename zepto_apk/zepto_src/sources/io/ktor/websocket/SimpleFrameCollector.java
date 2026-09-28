package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SimpleFrameCollector {
    public SimpleFrameCollector() {
        ByteBuffer.allocate(4);
    }
}
