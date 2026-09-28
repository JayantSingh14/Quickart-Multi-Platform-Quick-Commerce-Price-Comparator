package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
/* loaded from: classes3.dex */
public interface WebSocketSession extends CoroutineScope {

    @Metadata
    public static final class DefaultImpls {
    }

    ReceiveChannel A();

    long D0();

    SendChannel Z();

    Object c1(Frame.Close close, Continuation continuation);

    Object n0(Continuation continuation);

    void y0(long j2);
}
