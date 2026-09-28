package ch.qos.logback.core.net.server;

import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import ch.qos.logback.classic.spi.LoggingEventVO;
import ch.qos.logback.core.AppenderBase;
import java.io.IOException;
import javax.net.ServerSocketFactory;

/* loaded from: classes3.dex */
public abstract class AbstractServerSocketAppender<E> extends AppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public final int f13616j = 4560;

    /* renamed from: k, reason: collision with root package name */
    public final int f13617k = 50;

    /* renamed from: l, reason: collision with root package name */
    public final int f13618l = 100;

    /* renamed from: m, reason: collision with root package name */
    public ServerRunner f13619m;

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        if (obj == null) {
            return;
        }
        W1(obj);
        final LoggingEventVO loggingEventVOA = U1().a(obj);
        ((ConcurrentServerRunner) this.f13619m).T1(new ClientVisitor<RemoteReceiverClient>() { // from class: ch.qos.logback.core.net.server.AbstractServerSocketAppender.1
            @Override // ch.qos.logback.core.net.server.ClientVisitor
            public final void a(Client client) {
                ((RemoteReceiverClient) client).b1(loggingEventVOA);
            }
        });
    }

    public abstract LoggingEventPreSerializationTransformer U1();

    public ServerSocketFactory V1() {
        return ServerSocketFactory.getDefault();
    }

    public abstract void W1(Object obj);

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.f13415d) {
            return;
        }
        try {
            RemoteReceiverServerRunner remoteReceiverServerRunner = new RemoteReceiverServerRunner(new RemoteReceiverServerListener(V1().createServerSocket(this.f13616j, this.f13617k, null)), this.f13733b.l0(), this.f13618l);
            this.f13619m = remoteReceiverServerRunner;
            remoteReceiverServerRunner.V(this.f13733b);
            this.f13733b.l0().execute(this.f13619m);
            this.f13415d = true;
        } catch (Exception e2) {
            o1("server startup error: " + e2, e2);
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        if (this.f13415d) {
            try {
                ((ConcurrentServerRunner) this.f13619m).stop();
                this.f13415d = false;
            } catch (IOException e2) {
                o1("server shutdown error: " + e2, e2);
            }
        }
    }
}
