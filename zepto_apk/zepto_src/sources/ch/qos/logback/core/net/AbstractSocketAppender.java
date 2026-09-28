package ch.qos.logback.core.net;

import android.support.v4.media.b;
import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import ch.qos.logback.classic.spi.LoggingEventVO;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.util.CloseUtil;
import ch.qos.logback.core.util.Duration;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public abstract class AbstractSocketAppender<E> extends AppenderBase<E> implements SocketConnector.ExceptionHandler {

    /* renamed from: j, reason: collision with root package name */
    public final ObjectWriterFactory f13590j;

    /* renamed from: k, reason: collision with root package name */
    public final QueueFactory f13591k;

    /* renamed from: l, reason: collision with root package name */
    public String f13592l;

    /* renamed from: m, reason: collision with root package name */
    public int f13593m;
    public InetAddress n;
    public final Duration o;
    public final int p;
    public final int q;
    public final Duration r;
    public LinkedBlockingDeque s;
    public String t;
    public DefaultSocketConnector u;
    public Future v;
    public volatile Socket w;

    public AbstractSocketAppender() {
        QueueFactory queueFactory = new QueueFactory();
        ObjectWriterFactory objectWriterFactory = new ObjectWriterFactory();
        this.f13593m = 4560;
        this.o = new Duration(30000L);
        this.p = 128;
        this.q = 5000;
        this.r = new Duration(100L);
        this.f13590j = objectWriterFactory;
        this.f13591k = queueFactory;
    }

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        if (obj == null || !this.f13415d) {
            return;
        }
        try {
            if (this.s.offer(obj, this.r.f13804a, TimeUnit.MILLISECONDS)) {
                return;
            }
            s1("Dropping event due to timeout limit of [" + this.r + "] being exceeded");
        } catch (InterruptedException e2) {
            o1("Interrupted while appending event to SocketAppender", e2);
        }
    }

    public final AutoFlushingObjectWriter U1() throws IOException {
        this.w.setSoTimeout(this.q);
        ObjectWriterFactory objectWriterFactory = this.f13590j;
        OutputStream outputStream = this.w.getOutputStream();
        objectWriterFactory.getClass();
        AutoFlushingObjectWriter autoFlushingObjectWriter = new AutoFlushingObjectWriter(new ObjectOutputStream(outputStream));
        this.w.setSoTimeout(0);
        return autoFlushingObjectWriter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V1(AutoFlushingObjectWriter autoFlushingObjectWriter) throws InterruptedException, IOException {
        while (true) {
            Object objTakeFirst = this.s.takeFirst();
            Y1(objTakeFirst);
            LoggingEventVO loggingEventVOA = W1().a(objTakeFirst);
            try {
                ObjectOutputStream objectOutputStream = autoFlushingObjectWriter.f13595a;
                objectOutputStream.writeObject(loggingEventVOA);
                objectOutputStream.flush();
                int i2 = autoFlushingObjectWriter.f13596b + 1;
                autoFlushingObjectWriter.f13596b = i2;
                if (i2 >= 70) {
                    objectOutputStream.reset();
                    autoFlushingObjectWriter.f13596b = 0;
                }
            } catch (IOException e2) {
                if (!this.s.offerFirst(objTakeFirst)) {
                    s1("Dropping event due to socket connection error and maxed out deque capacity");
                }
                throw e2;
            }
        }
    }

    public abstract LoggingEventPreSerializationTransformer W1();

    public SocketFactory X1() {
        return SocketFactory.getDefault();
    }

    public abstract void Y1(Object obj);

    @Override // ch.qos.logback.core.net.SocketConnector.ExceptionHandler
    public final void c(IOException iOException) {
        if (iOException instanceof ConnectException) {
            s1(this.t + "connection refused");
            return;
        }
        s1(this.t + iOException);
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int i2;
        if (this.f13415d) {
            return;
        }
        if (this.f13593m <= 0) {
            l1("No port was configured for appender" + this.f13417f + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_port");
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f13592l == null) {
            i2++;
            l1("No remote host was configured for appender" + this.f13417f + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_host");
        }
        if (this.p == 0) {
            J1("Queue size of zero is deprecated, use a size of one to indicate synchronous processing");
        }
        if (this.p < 0) {
            i2++;
            l1("Queue size must be greater than zero");
        }
        if (i2 == 0) {
            try {
                this.n = InetAddress.getByName(this.f13592l);
            } catch (UnknownHostException unused) {
                l1("unknown host: " + this.f13592l);
                i2++;
            }
        }
        if (i2 == 0) {
            QueueFactory queueFactory = this.f13591k;
            int i3 = this.p;
            queueFactory.getClass();
            if (i3 < 1) {
                i3 = 1;
            }
            this.s = new LinkedBlockingDeque(i3);
            StringBuilder sb = new StringBuilder("remote peer ");
            sb.append(this.f13592l);
            sb.append(":");
            this.t = b.o(sb, this.f13593m, ": ");
            DefaultSocketConnector defaultSocketConnector = new DefaultSocketConnector(this.n, this.f13593m, 0, this.o.f13804a);
            defaultSocketConnector.f13600d = this;
            defaultSocketConnector.f13601e = X1();
            this.u = defaultSocketConnector;
            this.v = this.f13733b.l0().submit(new Runnable() { // from class: ch.qos.logback.core.net.AbstractSocketAppender.1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    AbstractSocketAppender abstractSocketAppender = AbstractSocketAppender.this;
                    while (true) {
                        try {
                            Socket socketCall = abstractSocketAppender.u.call();
                            abstractSocketAppender.w = socketCall;
                            if (socketCall == null) {
                                break;
                            }
                            try {
                                try {
                                    AutoFlushingObjectWriter autoFlushingObjectWriterU1 = abstractSocketAppender.U1();
                                    abstractSocketAppender.s1(abstractSocketAppender.t + "connection established");
                                    abstractSocketAppender.V1(autoFlushingObjectWriterU1);
                                    throw null;
                                } catch (IOException e2) {
                                    abstractSocketAppender.s1(abstractSocketAppender.t + "connection failed: " + e2);
                                    CloseUtil.b(abstractSocketAppender.w);
                                    abstractSocketAppender.w = null;
                                    abstractSocketAppender.s1(abstractSocketAppender.t + "connection closed");
                                }
                            } catch (Throwable th) {
                                CloseUtil.b(abstractSocketAppender.w);
                                abstractSocketAppender.w = null;
                                abstractSocketAppender.s1(abstractSocketAppender.t + "connection closed");
                                throw th;
                            }
                        } catch (InterruptedException unused2) {
                        }
                    }
                    abstractSocketAppender.s1("shutting down");
                }
            });
            this.f13415d = true;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() throws IOException {
        if (this.f13415d) {
            CloseUtil.b(this.w);
            this.v.cancel(true);
            this.f13415d = false;
        }
    }
}
