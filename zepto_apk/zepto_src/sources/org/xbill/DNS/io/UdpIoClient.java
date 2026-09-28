package org.xbill.DNS.io;

import j$.time.Duration;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
public interface UdpIoClient {
    CompletableFuture<byte[]> sendAndReceiveUdp(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, int i2, Duration duration);
}
