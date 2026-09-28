package ch.qos.logback.core.net.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
class RemoteReceiverServerRunner extends ConcurrentServerRunner<RemoteReceiverClient> {

    /* renamed from: h, reason: collision with root package name */
    public final int f13627h;

    public RemoteReceiverServerRunner(ServerListener serverListener, ExecutorService executorService, int i2) {
        super((ServerSocketListener) serverListener, executorService);
        this.f13627h = i2;
    }

    @Override // ch.qos.logback.core.net.server.ConcurrentServerRunner
    public final void V1(Client client) {
        RemoteReceiverClient remoteReceiverClient = (RemoteReceiverClient) client;
        remoteReceiverClient.V(this.f13733b);
        remoteReceiverClient.L1(new ArrayBlockingQueue(this.f13627h));
    }
}
