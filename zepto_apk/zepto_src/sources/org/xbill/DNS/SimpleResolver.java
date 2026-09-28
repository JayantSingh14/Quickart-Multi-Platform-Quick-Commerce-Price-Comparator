package org.xbill.DNS;

import j$.time.Duration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.io.DefaultIoClientFactory;
import org.xbill.DNS.io.IoClientFactory;

/* loaded from: classes5.dex */
public class SimpleResolver implements Resolver {
    public static final int DEFAULT_EDNS_PAYLOADSIZE = 1280;
    public static final int DEFAULT_PORT = 53;
    private static final short DEFAULT_UDPSIZE = 512;
    private InetSocketAddress address;
    private boolean ignoreTruncation;
    private IoClientFactory ioClientFactory;
    private InetSocketAddress localAddress;
    private OPTRecord queryOPT;
    private Duration timeoutValue;
    private TSIG tsig;
    private boolean useTCP;

    @Generated
    private static final Logger log = LoggerFactory.b(SimpleResolver.class);
    private static InetSocketAddress defaultResolver = new InetSocketAddress(InetAddress.getLoopbackAddress(), 53);

    public SimpleResolver() throws UnknownHostException {
        this((String) null);
    }

    private void applyEDNS(Message message) {
        if (this.queryOPT == null || message.getOPT() != null) {
            return;
        }
        message.addRecord(this.queryOPT, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAsync$0(CompletableFuture completableFuture, Message message) {
        try {
            completableFuture.complete(sendAXFR(message));
        } catch (IOException e2) {
            completableFuture.completeExceptionally(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync$1(int i2, Message message, boolean z, Executor executor, byte[] bArr) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (bArr.length < 12) {
            completableFuture.completeExceptionally(new WireParseException("invalid DNS header - too short"));
            return completableFuture;
        }
        int i3 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
        if (i3 != i2) {
            completableFuture.completeExceptionally(new WireParseException(android.support.v4.media.b.d(i2, i3, "invalid message id: expected ", "; got id ")));
            return completableFuture;
        }
        try {
            Message message2 = parseMessage(bArr);
            if (message.getHeader().getOpcode() == 5) {
                if (message2.getHeader().getOpcode() != 5) {
                    completableFuture.completeExceptionally(new WireParseException("invalid message: opcode response is not UPDATE"));
                    return completableFuture;
                }
            } else {
                if (message2.getQuestion() == null) {
                    completableFuture.completeExceptionally(new WireParseException("invalid message: question section missing"));
                    return completableFuture;
                }
                if (!message.getQuestion().getName().equals(message2.getQuestion().getName())) {
                    completableFuture.completeExceptionally(new WireParseException("invalid name in message: expected " + message.getQuestion().getName() + "; got " + message2.getQuestion().getName()));
                    return completableFuture;
                }
                if (message.getQuestion().getDClass() != message2.getQuestion().getDClass()) {
                    completableFuture.completeExceptionally(new WireParseException("invalid class in message: expected " + DClass.string(message.getQuestion().getDClass()) + "; got " + DClass.string(message2.getQuestion().getDClass())));
                    return completableFuture;
                }
                if (message.getQuestion().getType() != message2.getQuestion().getType()) {
                    completableFuture.completeExceptionally(new WireParseException("invalid type in message: expected " + Type.string(message.getQuestion().getType()) + "; got " + Type.string(message2.getQuestion().getType())));
                    return completableFuture;
                }
            }
            verifyTSIG(message, message2, bArr);
            if (z || this.ignoreTruncation || !message2.getHeader().getFlag(6)) {
                message2.setResolver(this);
                completableFuture.complete(message2);
                return completableFuture;
            }
            Logger logger = log;
            if (logger.f()) {
                logger.d("Got truncated response for id {}, retrying via TCP, response:\n{}", Integer.valueOf(i2), message2);
            } else {
                logger.s(Integer.valueOf(i2), "Got truncated response for id {}, retrying via TCP");
            }
            return sendAsync(message, true, executor);
        } catch (WireParseException e2) {
            completableFuture.completeExceptionally(e2);
            return completableFuture;
        }
    }

    private int maxUDPSize(Message message) {
        OPTRecord opt = message.getOPT();
        if (opt == null) {
            return 512;
        }
        return opt.getPayloadSize();
    }

    private Message parseMessage(byte[] bArr) throws WireParseException {
        try {
            return new Message(bArr);
        } catch (IOException e2) {
            if (e2 instanceof WireParseException) {
                throw ((WireParseException) e2);
            }
            throw new WireParseException("Error parsing message", e2);
        }
    }

    private Message sendAXFR(Message message) throws IOException {
        ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(message.getQuestion().getName(), this.address, this.tsig);
        zoneTransferInNewAXFR.setTimeout(this.timeoutValue);
        zoneTransferInNewAXFR.setLocalAddress(this.localAddress);
        try {
            zoneTransferInNewAXFR.run();
            List<Record> axfr = zoneTransferInNewAXFR.getAXFR();
            Message message2 = new Message(message.getHeader().getID());
            message2.getHeader().setFlag(5);
            message2.getHeader().setFlag(0);
            message2.addRecord(message.getQuestion(), 0);
            Iterator<Record> it = axfr.iterator();
            while (it.hasNext()) {
                message2.addRecord(it.next(), 1);
            }
            return message2;
        } catch (ZoneTransferException e2) {
            throw new WireParseException(e2.getMessage());
        }
    }

    public static void setDefaultResolver(InetSocketAddress inetSocketAddress) {
        defaultResolver = inetSocketAddress;
    }

    private void verifyTSIG(Message message, Message message2, byte[] bArr) {
        TSIG tsig = this.tsig;
        if (tsig == null) {
            return;
        }
        log.u("TSIG verify on message id {}: {}", Integer.valueOf(message.getHeader().getID()), Rcode.TSIGstring(tsig.verify(message2, bArr, message.getGeneratedTSIG())));
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public OPTRecord getEDNS() {
        return this.queryOPT;
    }

    public boolean getIgnoreTruncation() {
        return this.ignoreTruncation;
    }

    @Generated
    public IoClientFactory getIoClientFactory() {
        return this.ioClientFactory;
    }

    public int getPort() {
        return this.address.getPort();
    }

    public boolean getTCP() {
        return this.useTCP;
    }

    public TSIG getTSIGKey() {
        return this.tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeoutValue;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    public void setAddress(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    public void setEDNS(OPTRecord oPTRecord) {
        this.queryOPT = oPTRecord;
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
        this.ignoreTruncation = z;
    }

    @Generated
    public void setIoClientFactory(IoClientFactory ioClientFactory) {
        this.ioClientFactory = ioClientFactory;
    }

    public void setLocalAddress(InetSocketAddress inetSocketAddress) {
        this.localAddress = inetSocketAddress;
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i2) {
        this.address = new InetSocketAddress(this.address.getAddress(), i2);
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        this.useTCP = z;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeoutValue = duration;
    }

    public String toString() {
        return "SimpleResolver [" + this.address + "]";
    }

    public SimpleResolver(String str) throws UnknownHostException {
        this.queryOPT = new OPTRecord(DEFAULT_EDNS_PAYLOADSIZE, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        this.ioClientFactory = new DefaultIoClientFactory();
        if (str != null) {
            this.address = new InetSocketAddress("0".equals(str) ? InetAddress.getLoopbackAddress() : InetAddress.getByName(str), 53);
            return;
        }
        InetSocketAddress inetSocketAddressServer = ResolverConfig.getCurrentConfig().server();
        this.address = inetSocketAddressServer;
        if (inetSocketAddressServer == null) {
            this.address = defaultResolver;
        }
    }

    public static void setDefaultResolver(String str) {
        defaultResolver = new InetSocketAddress(str, 53);
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        Record question;
        if (message.getHeader().getOpcode() == 0 && (question = message.getQuestion()) != null && question.getType() == 252) {
            CompletableFuture completableFuture = new CompletableFuture();
            CompletableFuture.runAsync(new androidx.media3.common.util.e(this, completableFuture, message, 26), executor);
            return completableFuture;
        }
        Message messageClone = message.clone();
        applyEDNS(messageClone);
        TSIG tsig = this.tsig;
        if (tsig != null) {
            messageClone.setTSIG(tsig, 0, null);
        }
        return sendAsync(messageClone, this.useTCP, executor);
    }

    public void setAddress(InetAddress inetAddress) {
        this.address = new InetSocketAddress(inetAddress, this.address.getPort());
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i2, int i3, int i4, List<EDNSOption> list) {
        if (i2 == -1) {
            this.queryOPT = null;
        } else {
            if (i2 != 0) {
                throw new IllegalArgumentException("invalid EDNS version - must be 0 or -1 to disable");
            }
            if (i3 == 0) {
                i3 = DEFAULT_EDNS_PAYLOADSIZE;
            }
            this.queryOPT = new OPTRecord(i3, 0, i2, i4, list);
        }
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = new InetSocketAddress(inetAddress, 0);
    }

    public SimpleResolver(InetSocketAddress inetSocketAddress) {
        this.queryOPT = new OPTRecord(DEFAULT_EDNS_PAYLOADSIZE, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        this.ioClientFactory = new DefaultIoClientFactory();
        Objects.requireNonNull(inetSocketAddress, "host must not be null");
        this.address = inetSocketAddress;
    }

    public CompletableFuture<Message> sendAsync(final Message message, boolean z, final Executor executor) {
        CompletableFuture<byte[]> completableFutureSendAndReceiveUdp;
        final int id = message.getHeader().getID();
        try {
            byte[] wire = message.toWire(Message.MAXLENGTH, message.getHeader().getOpcode() != 5);
            int iMaxUDPSize = maxUDPSize(message);
            final boolean z2 = z || wire.length > iMaxUDPSize;
            Logger logger = log;
            if (logger.f()) {
                logger.i("Sending {}/{}, id={} to {}/{}:{}, query:\n{}", message.getQuestion().getName(), Type.string(message.getQuestion().getType()), Integer.valueOf(id), z2 ? "tcp" : "udp", this.address.getAddress().getHostAddress(), Integer.valueOf(this.address.getPort()), message);
            } else if (logger.b()) {
                logger.g("Sending {}/{}, id={} to {}/{}:{}", message.getQuestion().getName(), Type.string(message.getQuestion().getType()), Integer.valueOf(id), z2 ? "tcp" : "udp", this.address.getAddress().getHostAddress(), Integer.valueOf(this.address.getPort()));
            }
            if (z2) {
                completableFutureSendAndReceiveUdp = this.ioClientFactory.createOrGetTcpClient().sendAndReceiveTcp(this.localAddress, this.address, message, wire, this.timeoutValue);
            } else {
                completableFutureSendAndReceiveUdp = this.ioClientFactory.createOrGetUdpClient().sendAndReceiveUdp(this.localAddress, this.address, message, wire, iMaxUDPSize, this.timeoutValue);
            }
            return completableFutureSendAndReceiveUdp.thenComposeAsync(new Function() { // from class: org.xbill.DNS.z
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    SimpleResolver simpleResolver = this.f58070a;
                    Message message2 = message;
                    boolean z3 = z2;
                    return simpleResolver.lambda$sendAsync$1(id, message2, z3, executor, (byte[]) obj);
                }
            }, executor);
        } catch (MessageSizeExceededException e2) {
            CompletableFuture<Message> completableFuture = new CompletableFuture<>();
            completableFuture.completeExceptionally(e2);
            return completableFuture;
        }
    }

    public SimpleResolver(InetAddress inetAddress) {
        this.queryOPT = new OPTRecord(DEFAULT_EDNS_PAYLOADSIZE, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        this.ioClientFactory = new DefaultIoClientFactory();
        Objects.requireNonNull(inetAddress, "host must not be null");
        this.address = new InetSocketAddress(inetAddress, 53);
    }
}
