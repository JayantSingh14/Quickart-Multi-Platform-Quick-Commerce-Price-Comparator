package ch.qos.logback.classic.net;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.DefaultSocketConnector;
import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.util.CloseUtil;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public class SocketReceiver extends ReceiverBase implements Runnable, SocketConnector.ExceptionHandler {

    /* renamed from: e, reason: collision with root package name */
    public int f13297e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13298f = 5000;

    /* renamed from: g, reason: collision with root package name */
    public volatile Socket f13299g;

    /* renamed from: h, reason: collision with root package name */
    public Future f13300h;

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public final Runnable T1() {
        return this;
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public final void U1() throws IOException {
        if (this.f13299g != null) {
            CloseUtil.b(this.f13299g);
        }
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public boolean V1() {
        l1("No port was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_port");
        l1("No host name or address was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_host");
        if (this.f13297e != 0) {
            return false;
        }
        this.f13297e = 30000;
        return false;
    }

    public final void W1(LoggerContext loggerContext) throws Throwable {
        HardenedLoggingEventInputStream hardenedLoggingEventInputStream;
        try {
            try {
                this.f13299g.setSoTimeout(this.f13298f);
                hardenedLoggingEventInputStream = new HardenedLoggingEventInputStream(this.f13299g.getInputStream());
                try {
                    this.f13299g.setSoTimeout(0);
                    s1("nullconnection established");
                    while (true) {
                        ILoggingEvent iLoggingEvent = (ILoggingEvent) hardenedLoggingEventInputStream.readObject();
                        Logger loggerC = loggerContext.c(iLoggingEvent.k());
                        if (loggerC.C(iLoggingEvent.a())) {
                            loggerC.v(iLoggingEvent);
                        }
                    }
                } catch (EOFException unused) {
                    s1(((String) null) + "end-of-stream detected");
                    CloseUtil.a(hardenedLoggingEventInputStream);
                    CloseUtil.b(this.f13299g);
                    this.f13299g = null;
                    s1("nullconnection closed");
                } catch (IOException e2) {
                    e = e2;
                    s1(((String) null) + "connection failed: " + e);
                    CloseUtil.a(hardenedLoggingEventInputStream);
                    CloseUtil.b(this.f13299g);
                    this.f13299g = null;
                    s1("nullconnection closed");
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    s1(((String) null) + "unknown event class: " + e);
                    CloseUtil.a(hardenedLoggingEventInputStream);
                    CloseUtil.b(this.f13299g);
                    this.f13299g = null;
                    s1("nullconnection closed");
                }
            } catch (Throwable th) {
                th = th;
                CloseUtil.a(null);
                CloseUtil.b(this.f13299g);
                this.f13299g = null;
                s1("nullconnection closed");
                throw th;
            }
        } catch (EOFException unused2) {
            hardenedLoggingEventInputStream = null;
        } catch (IOException e4) {
            e = e4;
            hardenedLoggingEventInputStream = null;
        } catch (ClassNotFoundException e5) {
            e = e5;
            hardenedLoggingEventInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtil.a(null);
            CloseUtil.b(this.f13299g);
            this.f13299g = null;
            s1("nullconnection closed");
            throw th;
        }
    }

    public SocketFactory X1() {
        return SocketFactory.getDefault();
    }

    @Override // ch.qos.logback.core.net.SocketConnector.ExceptionHandler
    public final void c(IOException iOException) {
        if (iOException instanceof ConnectException) {
            s1("nullconnection refused");
            return;
        }
        s1("null" + iOException);
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Future futureSubmit;
        try {
            LoggerContext loggerContext = (LoggerContext) this.f13733b;
            while (!Thread.currentThread().isInterrupted()) {
                DefaultSocketConnector defaultSocketConnector = new DefaultSocketConnector(null, 0, 0, this.f13297e);
                defaultSocketConnector.f13600d = this;
                defaultSocketConnector.f13601e = X1();
                Socket socket = null;
                try {
                    futureSubmit = this.f13733b.T().submit(defaultSocketConnector);
                } catch (RejectedExecutionException unused) {
                    futureSubmit = null;
                }
                this.f13300h = futureSubmit;
                if (futureSubmit == null) {
                    break;
                }
                try {
                    Socket socket2 = (Socket) futureSubmit.get();
                    this.f13300h = null;
                    socket = socket2;
                } catch (ExecutionException unused2) {
                }
                this.f13299g = socket;
                if (this.f13299g == null) {
                    break;
                } else {
                    W1(loggerContext);
                }
            }
        } catch (InterruptedException unused3) {
        }
        s1("shutting down");
    }
}
