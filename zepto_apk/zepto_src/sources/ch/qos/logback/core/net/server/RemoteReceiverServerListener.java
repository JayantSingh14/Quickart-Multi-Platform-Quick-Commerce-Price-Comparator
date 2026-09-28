package ch.qos.logback.core.net.server;

import java.net.Socket;

/* loaded from: classes3.dex */
class RemoteReceiverServerListener extends ServerSocketListener<RemoteReceiverClient> {
    @Override // ch.qos.logback.core.net.server.ServerSocketListener
    public final Client b(String str, Socket socket) {
        return new RemoteReceiverStreamClient(str, socket);
    }
}
