package ch.qos.logback.core.net;

import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.util.FixedDelay;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public class DefaultSocketConnector implements SocketConnector {

    /* renamed from: a, reason: collision with root package name */
    public final InetAddress f13597a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13598b;

    /* renamed from: c, reason: collision with root package name */
    public final FixedDelay f13599c;

    /* renamed from: d, reason: collision with root package name */
    public SocketConnector.ExceptionHandler f13600d;

    /* renamed from: e, reason: collision with root package name */
    public SocketFactory f13601e;

    public static class ConsoleExceptionHandler implements SocketConnector.ExceptionHandler {
        @Override // ch.qos.logback.core.net.SocketConnector.ExceptionHandler
        public final void c(IOException iOException) {
            System.out.println(iOException);
        }
    }

    public DefaultSocketConnector(InetAddress inetAddress, int i2, long j2, long j3) {
        FixedDelay fixedDelay = new FixedDelay(j2, j3);
        this.f13597a = inetAddress;
        this.f13598b = i2;
        this.f13599c = fixedDelay;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Socket call() throws InterruptedException, IOException {
        Socket socketCreateSocket;
        int i2 = this.f13598b;
        InetAddress inetAddress = this.f13597a;
        if (this.f13600d == null) {
            this.f13600d = new ConsoleExceptionHandler();
        }
        if (this.f13601e == null) {
            this.f13601e = SocketFactory.getDefault();
        }
        try {
            socketCreateSocket = this.f13601e.createSocket(inetAddress, i2);
        } catch (IOException e2) {
            this.f13600d.c(e2);
            socketCreateSocket = null;
        }
        while (socketCreateSocket == null && !Thread.currentThread().isInterrupted()) {
            FixedDelay fixedDelay = this.f13599c;
            long j2 = fixedDelay.f13810b;
            fixedDelay.f13810b = fixedDelay.f13809a;
            Thread.sleep(j2);
            try {
                socketCreateSocket = this.f13601e.createSocket(inetAddress, i2);
            } catch (IOException e3) {
                this.f13600d.c(e3);
                socketCreateSocket = null;
            }
        }
        return socketCreateSocket;
    }
}
