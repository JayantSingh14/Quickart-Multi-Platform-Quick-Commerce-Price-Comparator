package io.ktor.websocket;

import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Serializer {
    public Serializer() {
        new ArrayBlockingQueue(1024);
    }
}
