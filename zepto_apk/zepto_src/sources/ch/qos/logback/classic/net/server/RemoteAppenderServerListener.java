package ch.qos.logback.classic.net.server;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.net.server.ServerSocketListener;
import java.net.Socket;

/* loaded from: classes3.dex */
class RemoteAppenderServerListener extends ServerSocketListener<RemoteAppenderClient> {
    @Override // ch.qos.logback.core.net.server.ServerSocketListener
    public final Client b(String str, Socket socket) {
        return new RemoteAppenderStreamClient(str, socket);
    }
}
