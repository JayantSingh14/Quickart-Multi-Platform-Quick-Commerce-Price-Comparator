package org.xbill.DNS;

import j$.time.Duration;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.io.UdpIoClient;

/* loaded from: classes5.dex */
final class NioUdpClient extends NioClient implements UdpIoClient {

    @Generated
    private static final Logger log = LoggerFactory.b(NioUdpClient.class);
    private final int ephemeralRange;
    private final int ephemeralStart;
    private final SecureRandom prng;
    private final Queue<Transaction> registrationQueue = new ConcurrentLinkedQueue();
    private final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();

    public class Transaction implements NioClient.KeyProcessor {
        private final DatagramChannel channel;
        private final byte[] data;
        private final long endTime;

        /* renamed from: f, reason: collision with root package name */
        private final CompletableFuture<byte[]> f57912f;
        private final int id;
        private final int max;

        @Generated
        public Transaction(int i2, byte[] bArr, int i3, long j2, DatagramChannel datagramChannel, CompletableFuture<byte[]> completableFuture) {
            this.id = i2;
            this.data = bArr;
            this.max = i3;
            this.endTime = j2;
            this.channel = datagramChannel;
            this.f57912f = completableFuture;
        }

        public static /* synthetic */ void access$200(Transaction transaction, Exception exc) throws IOException {
            transaction.completeExceptionally(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void completeExceptionally(Exception exc) throws IOException {
            silentDisconnectAndCloseChannel();
            this.f57912f.completeExceptionally(exc);
        }

        private void silentDisconnectAndCloseChannel() throws IOException {
            try {
                this.channel.disconnect();
            } catch (IOException unused) {
            } finally {
                NioUdpClient.silentCloseChannel(this.channel);
            }
        }

        @Override // org.xbill.DNS.NioClient.KeyProcessor
        public void processReadyKey(SelectionKey selectionKey) throws IOException {
            if (!selectionKey.isReadable()) {
                completeExceptionally(new EOFException(android.support.v4.media.b.o(new StringBuilder("Key for transaction "), this.id, " is not readable")));
                NioUdpClient.this.pendingTransactions.remove(this);
                return;
            }
            DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.max);
            try {
                int i2 = datagramChannel.read(byteBufferAllocate);
                if (i2 <= 0) {
                    throw new EOFException();
                }
                byteBufferAllocate.flip();
                byte[] bArr = new byte[i2];
                System.arraycopy(byteBufferAllocate.array(), 0, bArr, 0, i2);
                NioClient.verboseLog("UDP read: transaction id=" + this.id, datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
                silentDisconnectAndCloseChannel();
                this.f57912f.complete(bArr);
                NioUdpClient.this.pendingTransactions.remove(this);
            } catch (IOException e2) {
                completeExceptionally(e2);
                NioUdpClient.this.pendingTransactions.remove(this);
            }
        }

        public void send() throws IOException {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.data);
            NioClient.verboseLog("UDP write: transaction id=" + this.id, this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), this.data);
            DatagramChannel datagramChannel = this.channel;
            int iSend = datagramChannel.send(byteBufferWrap, datagramChannel.socket().getRemoteSocketAddress());
            if (iSend == 0) {
                throw new EOFException("Insufficient room for the datagram in the underlying output buffer for transaction " + this.id);
            }
            if (iSend >= this.data.length) {
                return;
            }
            throw new EOFException("Could not send all data for transaction " + this.id);
        }
    }

    public NioUdpClient() {
        int i2;
        int i3;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            i2 = 32768;
            i3 = 60999;
        } else {
            i2 = 49152;
            i3 = Message.MAXLENGTH;
        }
        int iIntValue = Integer.getInteger("dnsjava.udp.ephemeral.start", i2).intValue();
        this.ephemeralStart = iIntValue;
        this.ephemeralRange = Integer.getInteger("dnsjava.udp.ephemeral.end", i3).intValue() - iIntValue;
        if (Boolean.getBoolean("dnsjava.udp.ephemeral.use_ephemeral_port")) {
            this.prng = null;
        } else {
            this.prng = new SecureRandom();
        }
        final int i4 = 0;
        NioClient.setRegistrationsTask(new Runnable(this) { // from class: org.xbill.DNS.w

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioUdpClient f58066b;

            {
                this.f58066b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i4) {
                    case 0:
                        this.f58066b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58066b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58066b.closeUdp();
                        break;
                }
            }
        }, false);
        final int i5 = 1;
        NioClient.setTimeoutTask(new Runnable(this) { // from class: org.xbill.DNS.w

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioUdpClient f58066b;

            {
                this.f58066b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i5) {
                    case 0:
                        this.f58066b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58066b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58066b.closeUdp();
                        break;
                }
            }
        }, false);
        final int i6 = 2;
        NioClient.setCloseTask(new Runnable(this) { // from class: org.xbill.DNS.w

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioUdpClient f58066b;

            {
                this.f58066b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i6) {
                    case 0:
                        this.f58066b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58066b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58066b.closeUdp();
                        break;
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTransactionTimeouts() throws IOException {
        Iterator<Transaction> it = this.pendingTransactions.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if (next.endTime - System.nanoTime() < 0) {
                next.completeExceptionally(new SocketTimeoutException("Query timed out"));
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeUdp() {
        this.registrationQueue.clear();
        this.pendingTransactions.forEach(new x(new EOFException("Client is closing"), 0));
        this.pendingTransactions.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingRegistrations() throws IOException {
        while (!this.registrationQueue.isEmpty()) {
            Transaction transactionPoll = this.registrationQueue.poll();
            if (transactionPoll != null) {
                try {
                    log.m(Integer.valueOf(transactionPoll.id), "Registering OP_READ for transaction with id {}");
                    transactionPoll.channel.register(NioClient.selector(), 1, transactionPoll);
                    transactionPoll.send();
                } catch (IOException e2) {
                    transactionPoll.completeExceptionally(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void silentCloseChannel(DatagramChannel datagramChannel) throws IOException {
        if (datagramChannel != null) {
            try {
                datagramChannel.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.xbill.DNS.io.UdpIoClient
    public CompletableFuture<byte[]> sendAndReceiveUdp(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, int i2, Duration duration) throws Throwable {
        InetSocketAddress inetSocketAddress3;
        SecureRandom secureRandom;
        long nanos = duration.toNanos() + System.nanoTime();
        CompletableFuture<byte[]> completableFuture = new CompletableFuture<>();
        DatagramChannel datagramChannel = null;
        try {
            Selector selector = NioClient.selector();
            DatagramChannel datagramChannelOpen = DatagramChannel.open();
            try {
                datagramChannelOpen.configureBlocking(false);
                Transaction transaction = new Transaction(message.getHeader().getID(), bArr, i2, nanos, datagramChannelOpen, completableFuture);
                if (inetSocketAddress != null && inetSocketAddress.getPort() != 0) {
                    datagramChannelOpen.connect(inetSocketAddress2);
                    this.pendingTransactions.add(transaction);
                    this.registrationQueue.add(transaction);
                    selector.wakeup();
                    break;
                }
                for (int i3 = 0; i3 < 1024; i3++) {
                    try {
                        if (inetSocketAddress == null) {
                            inetSocketAddress3 = this.prng != null ? new InetSocketAddress(this.prng.nextInt(this.ephemeralRange) + this.ephemeralStart) : null;
                        } else {
                            int port = inetSocketAddress.getPort();
                            if (port == 0 && (secureRandom = this.prng) != null) {
                                port = secureRandom.nextInt(this.ephemeralRange) + this.ephemeralStart;
                            }
                            inetSocketAddress3 = new InetSocketAddress(inetSocketAddress.getAddress(), port);
                        }
                        datagramChannelOpen.bind((SocketAddress) inetSocketAddress3);
                        datagramChannelOpen.connect(inetSocketAddress2);
                        this.pendingTransactions.add(transaction);
                        this.registrationQueue.add(transaction);
                        selector.wakeup();
                        break;
                    } catch (SocketException unused) {
                    }
                }
                transaction.completeExceptionally(new IOException("No available source port found"));
            } catch (IOException e2) {
                e = e2;
                datagramChannel = datagramChannelOpen;
                silentCloseChannel(datagramChannel);
                completableFuture.completeExceptionally(e);
                return completableFuture;
            } catch (Throwable th) {
                th = th;
                datagramChannel = datagramChannelOpen;
                silentCloseChannel(datagramChannel);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
        }
        return completableFuture;
    }
}
