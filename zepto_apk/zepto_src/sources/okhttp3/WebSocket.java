package okhttp3;

import kotlin.Metadata;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;

@Metadata
/* loaded from: classes3.dex */
public interface WebSocket {

    @Metadata
    /* loaded from: classes.dex */
    public interface Factory {
        RealWebSocket b(Request request, WebSocketListener webSocketListener);
    }

    boolean a(ByteString byteString);

    boolean b(String str);

    boolean c(int i2, String str);

    void cancel();
}
