package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.net.server.ConcurrentServerRunner;

/* loaded from: classes3.dex */
class RemoteAppenderServerRunner extends ConcurrentServerRunner<RemoteAppenderClient> {
    @Override // ch.qos.logback.core.net.server.ConcurrentServerRunner
    public final void V1(Client client) {
        ((RemoteAppenderClient) client).G0((LoggerContext) this.f13733b);
    }
}
