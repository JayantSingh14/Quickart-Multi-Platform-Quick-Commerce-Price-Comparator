package io.ktor.serialization;

import io.ktor.websocket.Frame;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface WebsocketContentConverter {

    @Metadata
    public static final class DefaultImpls {
    }

    boolean a(Frame frame);

    Object b(Frame frame);
}
