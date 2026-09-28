package org.xbill.DNS.io;

import org.xbill.DNS.DefaultIoClient;

/* loaded from: classes5.dex */
public class DefaultIoClientFactory implements IoClientFactory {
    private static final DefaultIoClient RESOLVER_CLIENT = new DefaultIoClient();

    @Override // org.xbill.DNS.io.IoClientFactory
    public TcpIoClient createOrGetTcpClient() {
        return RESOLVER_CLIENT;
    }

    @Override // org.xbill.DNS.io.IoClientFactory
    public UdpIoClient createOrGetUdpClient() {
        return RESOLVER_CLIENT;
    }
}
