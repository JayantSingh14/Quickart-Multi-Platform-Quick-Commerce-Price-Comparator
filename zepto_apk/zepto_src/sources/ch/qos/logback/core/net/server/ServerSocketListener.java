package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: classes3.dex */
public abstract class ServerSocketListener<T extends Client> implements ServerListener<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ServerSocket f13631a;

    public ServerSocketListener(ServerSocket serverSocket) {
        this.f13631a = serverSocket;
    }

    public final Client a() throws IOException {
        Socket socketAccept = this.f13631a.accept();
        String string = socketAccept.getRemoteSocketAddress().toString();
        int iIndexOf = string.indexOf("/");
        if (iIndexOf >= 0) {
            string = string.substring(iIndexOf + 1);
        }
        return b(string, socketAccept);
    }

    public abstract Client b(String str, Socket socket);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ServerSocket serverSocket = this.f13631a;
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException unused) {
        }
    }

    public final String toString() {
        String string = this.f13631a.getLocalSocketAddress().toString();
        int iIndexOf = string.indexOf("/");
        return iIndexOf >= 0 ? string.substring(iIndexOf + 1) : string;
    }
}
