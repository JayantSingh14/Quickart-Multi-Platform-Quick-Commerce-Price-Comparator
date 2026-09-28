package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.util.CloseUtil;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes3.dex */
class RemoteAppenderStreamClient implements RemoteAppenderClient {

    /* renamed from: a, reason: collision with root package name */
    public final String f13301a;

    /* renamed from: b, reason: collision with root package name */
    public final Socket f13302b;

    /* renamed from: c, reason: collision with root package name */
    public LoggerContext f13303c;

    /* renamed from: d, reason: collision with root package name */
    public Logger f13304d;

    public RemoteAppenderStreamClient(String str, Socket socket) {
        this.f13301a = str;
        this.f13302b = socket;
    }

    @Override // ch.qos.logback.classic.net.server.RemoteAppenderClient
    public final void G0(LoggerContext loggerContext) {
        this.f13303c = loggerContext;
        this.f13304d = loggerContext.c(getClass().getPackage().getName());
    }

    public final HardenedLoggingEventInputStream a() {
        return new HardenedLoggingEventInputStream(this.f13302b.getInputStream());
    }

    @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Socket socket = this.f13302b;
        if (socket == null) {
            return;
        }
        CloseUtil.b(socket);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HardenedLoggingEventInputStream hardenedLoggingEventInputStreamA;
        Logger logger;
        StringBuilder sb;
        Level level = Level.f13234d;
        String str = this + ": connected";
        this.f13304d.B(str);
        HardenedLoggingEventInputStream hardenedLoggingEventInputStream = null;
        try {
            try {
                try {
                    hardenedLoggingEventInputStreamA = a();
                    while (true) {
                        try {
                            ILoggingEvent iLoggingEvent = (ILoggingEvent) hardenedLoggingEventInputStreamA.readObject();
                            Logger loggerC = this.f13303c.c(iLoggingEvent.k());
                            if (loggerC.C(iLoggingEvent.a())) {
                                loggerC.v(iLoggingEvent);
                            }
                        } catch (EOFException unused) {
                            hardenedLoggingEventInputStream = hardenedLoggingEventInputStreamA;
                            if (hardenedLoggingEventInputStream != null) {
                                CloseUtil.a(hardenedLoggingEventInputStream);
                            }
                            close();
                            logger = this.f13304d;
                            sb = new StringBuilder();
                            sb.append(this);
                            sb.append(": connection closed");
                            logger.B(sb.toString());
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            hardenedLoggingEventInputStream = hardenedLoggingEventInputStreamA;
                            this.f13304d.B(this + ": " + e);
                            if (hardenedLoggingEventInputStream != null) {
                                CloseUtil.a(hardenedLoggingEventInputStream);
                            }
                            close();
                            logger = this.f13304d;
                            sb = new StringBuilder();
                            sb.append(this);
                            sb.append(": connection closed");
                            logger.B(sb.toString());
                            return;
                        } catch (ClassNotFoundException unused2) {
                            this.f13304d.x(level, this + ": unknown event class", null, null);
                            if (hardenedLoggingEventInputStreamA != null) {
                                CloseUtil.a(hardenedLoggingEventInputStreamA);
                            }
                            close();
                            logger = this.f13304d;
                            sb = new StringBuilder();
                            sb.append(this);
                            sb.append(": connection closed");
                            logger.B(sb.toString());
                            return;
                        } catch (RuntimeException e3) {
                            e = e3;
                            this.f13304d.x(level, this + ": " + e, null, null);
                            if (hardenedLoggingEventInputStreamA != null) {
                                CloseUtil.a(hardenedLoggingEventInputStreamA);
                            }
                            close();
                            logger = this.f13304d;
                            sb = new StringBuilder();
                            sb.append(this);
                            sb.append(": connection closed");
                            logger.B(sb.toString());
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (hardenedLoggingEventInputStream != null) {
                        CloseUtil.a(hardenedLoggingEventInputStream);
                    }
                    close();
                    this.f13304d.B(this + ": connection closed");
                    throw th;
                }
            } catch (EOFException unused3) {
            } catch (IOException e4) {
                e = e4;
            } catch (ClassNotFoundException unused4) {
                hardenedLoggingEventInputStreamA = null;
            } catch (RuntimeException e5) {
                e = e5;
                hardenedLoggingEventInputStreamA = null;
            }
        } catch (Throwable th2) {
            th = th2;
            hardenedLoggingEventInputStream = str;
        }
    }

    public final String toString() {
        return "client " + this.f13301a;
    }
}
