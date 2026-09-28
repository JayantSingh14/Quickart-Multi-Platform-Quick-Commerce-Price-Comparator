package io.ktor.serialization.kotlinx;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class KotlinxWebsocketSerializationConverter implements WebsocketContentConverter {
    @Override // io.ktor.serialization.WebsocketContentConverter
    public final boolean a(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return (frame instanceof Frame.Text) || (frame instanceof Frame.Binary);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public final Object b(Frame frame) throws WebsocketConverterNotFoundException {
        if (a(frame)) {
            throw null;
        }
        String message = "Unsupported frame " + frame.f51441b.name();
        Intrinsics.checkNotNullParameter(message, "message");
        throw new WebsocketConverterNotFoundException(message);
    }
}
