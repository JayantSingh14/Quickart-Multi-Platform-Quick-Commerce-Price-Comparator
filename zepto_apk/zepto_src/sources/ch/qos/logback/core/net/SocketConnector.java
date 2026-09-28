package ch.qos.logback.core.net;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public interface SocketConnector extends Callable<Socket> {

    public interface ExceptionHandler {
        void c(IOException iOException);
    }
}
