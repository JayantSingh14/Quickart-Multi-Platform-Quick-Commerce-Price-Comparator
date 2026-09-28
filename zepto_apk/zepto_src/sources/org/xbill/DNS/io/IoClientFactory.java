package org.xbill.DNS.io;

/* loaded from: classes5.dex */
public interface IoClientFactory {
    TcpIoClient createOrGetTcpClient();

    UdpIoClient createOrGetUdpClient();
}
