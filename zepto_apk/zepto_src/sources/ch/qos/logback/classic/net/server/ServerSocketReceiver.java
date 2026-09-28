package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.net.ReceiverBase;
import ch.qos.logback.core.net.server.ConcurrentServerRunner;
import ch.qos.logback.core.net.server.ServerRunner;
import java.io.IOException;
import javax.net.ServerSocketFactory;

/* loaded from: classes3.dex */
public class ServerSocketReceiver extends ReceiverBase {

    /* renamed from: e, reason: collision with root package name */
    public final int f13307e = 4560;

    /* renamed from: f, reason: collision with root package name */
    public final int f13308f = 50;

    /* renamed from: g, reason: collision with root package name */
    public ServerRunner f13309g;

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public final Runnable T1() {
        return this.f13309g;
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public final void U1() {
        try {
            ServerRunner serverRunner = this.f13309g;
            if (serverRunner == null) {
                return;
            }
            ((ConcurrentServerRunner) serverRunner).stop();
        } catch (IOException e2) {
            o1("server shutdown error: " + e2, e2);
        }
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public final boolean V1() {
        try {
            RemoteAppenderServerRunner remoteAppenderServerRunner = new RemoteAppenderServerRunner(new RemoteAppenderServerListener(W1().createServerSocket(this.f13307e, this.f13308f, null)), this.f13733b.l0());
            this.f13309g = remoteAppenderServerRunner;
            remoteAppenderServerRunner.V(this.f13733b);
            return true;
        } catch (Exception e2) {
            o1("server startup error: " + e2, e2);
            return false;
        }
    }

    public ServerSocketFactory W1() {
        return ServerSocketFactory.getDefault();
    }
}
