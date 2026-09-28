package org.xbill.DNS;

import j$.time.Duration;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.NioTcpClient;
import org.xbill.DNS.io.TcpIoClient;

/* loaded from: classes5.dex */
final class NioTcpClient extends NioClient implements TcpIoClient {

    @Generated
    private static final Logger log = LoggerFactory.b(NioTcpClient.class);
    private final Queue<ChannelState> registrationQueue = new ConcurrentLinkedQueue();
    private final Map<ChannelKey, ChannelState> channelMap = new ConcurrentHashMap();

    public static class ChannelKey {
        final InetSocketAddress local;
        final InetSocketAddress remote;

        @Generated
        public ChannelKey(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.local = inetSocketAddress;
            this.remote = inetSocketAddress2;
        }

        @Generated
        public boolean canEqual(Object obj) {
            return obj instanceof ChannelKey;
        }

        @Generated
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChannelKey)) {
                return false;
            }
            ChannelKey channelKey = (ChannelKey) obj;
            if (!channelKey.canEqual(this)) {
                return false;
            }
            InetSocketAddress inetSocketAddress = this.local;
            InetSocketAddress inetSocketAddress2 = channelKey.local;
            if (inetSocketAddress != null ? !inetSocketAddress.equals(inetSocketAddress2) : inetSocketAddress2 != null) {
                return false;
            }
            InetSocketAddress inetSocketAddress3 = this.remote;
            InetSocketAddress inetSocketAddress4 = channelKey.remote;
            return inetSocketAddress3 != null ? inetSocketAddress3.equals(inetSocketAddress4) : inetSocketAddress4 == null;
        }

        @Generated
        public int hashCode() {
            InetSocketAddress inetSocketAddress = this.local;
            int iHashCode = inetSocketAddress == null ? 43 : inetSocketAddress.hashCode();
            InetSocketAddress inetSocketAddress2 = this.remote;
            return ((iHashCode + 59) * 59) + (inetSocketAddress2 != null ? inetSocketAddress2.hashCode() : 43);
        }
    }

    public class ChannelState implements NioClient.KeyProcessor {
        private final SocketChannel channel;
        final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();
        ByteBuffer responseLengthData = ByteBuffer.allocate(2);
        ByteBuffer responseData = ByteBuffer.allocate(Message.MAXLENGTH);
        int readState = 0;

        @Generated
        public ChannelState(SocketChannel socketChannel) {
            this.channel = socketChannel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleChannelException(IOException iOException) throws IOException {
            handleTransactionException(iOException);
            for (Map.Entry entry : NioTcpClient.this.channelMap.entrySet()) {
                if (entry.getValue() == this) {
                    NioTcpClient.this.channelMap.remove(entry.getKey());
                    try {
                        this.channel.close();
                        return;
                    } catch (IOException e2) {
                        NioTcpClient.log.e("Failed to close channel l={}/r={}", ((ChannelKey) entry.getKey()).local, ((ChannelKey) entry.getKey()).remote, e2);
                        return;
                    }
                }
            }
        }

        private void processConnect(SelectionKey selectionKey) throws IOException {
            try {
                this.channel.finishConnect();
                selectionKey.interestOps(4);
            } catch (IOException e2) {
                handleChannelException(e2);
            }
        }

        private void processRead() throws IOException {
            try {
                if (this.readState == 0) {
                    if (this.channel.read(this.responseLengthData) < 0) {
                        handleChannelException(new EOFException());
                        return;
                    } else if (this.responseLengthData.position() == 2) {
                        int i2 = ((this.responseLengthData.get(0) & 255) << 8) + (this.responseLengthData.get(1) & 255);
                        this.responseLengthData.flip();
                        this.responseData.limit(i2);
                        this.readState = 1;
                    }
                }
                if (this.channel.read(this.responseData) < 0) {
                    handleChannelException(new EOFException());
                    return;
                }
                if (this.responseData.hasRemaining()) {
                    return;
                }
                this.readState = 0;
                this.responseData.flip();
                int iLimit = this.responseData.limit();
                byte[] bArr = new byte[iLimit];
                System.arraycopy(this.responseData.array(), this.responseData.arrayOffset(), bArr, 0, this.responseData.limit());
                if (iLimit < 2) {
                    NioClient.verboseLog("TCP read: response too short for a valid reply, discarding", this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), bArr);
                    return;
                }
                int i3 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                NioClient.verboseLog(android.support.v4.media.b.f(i3, "TCP read: transaction id="), this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), bArr);
                Iterator<Transaction> it = this.pendingTransactions.iterator();
                while (it.hasNext()) {
                    Transaction next = it.next();
                    if (i3 == next.query.getHeader().getID()) {
                        next.f57911f.complete(bArr);
                        it.remove();
                        return;
                    }
                }
                NioTcpClient.log.n(Integer.valueOf(i3), "Transaction for answer to id {} not found");
            } catch (IOException e2) {
                handleChannelException(e2);
            }
        }

        private void processWrite(SelectionKey selectionKey) {
            Iterator<Transaction> it = this.pendingTransactions.iterator();
            while (it.hasNext()) {
                Transaction next = it.next();
                try {
                } catch (IOException e2) {
                    next.f57911f.completeExceptionally(e2);
                    it.remove();
                }
                if (!next.send()) {
                    selectionKey.interestOps(4);
                    return;
                }
                continue;
            }
            selectionKey.interestOps(1);
        }

        public void handleTransactionException(IOException iOException) {
            Iterator<Transaction> it = this.pendingTransactions.iterator();
            while (it.hasNext()) {
                it.next().f57911f.completeExceptionally(iOException);
                it.remove();
            }
        }

        @Override // org.xbill.DNS.NioClient.KeyProcessor
        public void processReadyKey(SelectionKey selectionKey) throws IOException {
            if (selectionKey.isValid()) {
                if (selectionKey.isConnectable()) {
                    processConnect(selectionKey);
                    return;
                }
                if (selectionKey.isWritable()) {
                    processWrite(selectionKey);
                }
                if (selectionKey.isReadable()) {
                    processRead();
                }
            }
        }
    }

    public static class Transaction {
        long bytesWrittenTotal = 0;
        private final SocketChannel channel;
        private final long endTime;

        /* renamed from: f, reason: collision with root package name */
        private final CompletableFuture<byte[]> f57911f;
        private final Message query;
        private final byte[] queryData;
        private ByteBuffer queryDataBuffer;

        @Generated
        public Transaction(Message message, byte[] bArr, long j2, SocketChannel socketChannel, CompletableFuture<byte[]> completableFuture) {
            this.query = message;
            this.queryData = bArr;
            this.endTime = j2;
            this.channel = socketChannel;
            this.f57911f = completableFuture;
        }

        public boolean send() throws IOException {
            long j2 = this.bytesWrittenTotal;
            byte[] bArr = this.queryData;
            if (j2 == bArr.length + 2) {
                return true;
            }
            if (this.queryDataBuffer == null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 2);
                this.queryDataBuffer = byteBufferAllocate;
                byteBufferAllocate.put((byte) (this.queryData.length >>> 8));
                this.queryDataBuffer.put((byte) (this.queryData.length & 255));
                this.queryDataBuffer.put(this.queryData);
                this.queryDataBuffer.flip();
            }
            NioClient.verboseLog("TCP write: transaction id=" + this.query.getHeader().getID(), this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), this.queryDataBuffer);
            while (this.queryDataBuffer.hasRemaining()) {
                long jWrite = this.channel.write(this.queryDataBuffer);
                long j3 = this.bytesWrittenTotal + jWrite;
                this.bytesWrittenTotal = j3;
                if (jWrite == 0) {
                    NioTcpClient.log.s(Integer.valueOf(this.query.getHeader().getID()), "Insufficient room for the data in the underlying output buffer for transaction {}, retrying");
                    return false;
                }
                if (j3 < this.queryData.length) {
                    NioTcpClient.log.g("Wrote {} of {} bytes data for transaction {}", Long.valueOf(this.bytesWrittenTotal), Integer.valueOf(this.queryData.length), Integer.valueOf(this.query.getHeader().getID()));
                }
            }
            NioTcpClient.log.u("Send for transaction {} is complete, wrote {} bytes", Integer.valueOf(this.query.getHeader().getID()), Long.valueOf(this.bytesWrittenTotal));
            return true;
        }
    }

    public NioTcpClient() {
        final int i2 = 0;
        NioClient.setRegistrationsTask(new Runnable(this) { // from class: org.xbill.DNS.u

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioTcpClient f58060b;

            {
                this.f58060b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i2) {
                    case 0:
                        this.f58060b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58060b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58060b.closeTcp();
                        break;
                }
            }
        }, true);
        final int i3 = 1;
        NioClient.setTimeoutTask(new Runnable(this) { // from class: org.xbill.DNS.u

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioTcpClient f58060b;

            {
                this.f58060b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i3) {
                    case 0:
                        this.f58060b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58060b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58060b.closeTcp();
                        break;
                }
            }
        }, true);
        final int i4 = 2;
        NioClient.setCloseTask(new Runnable(this) { // from class: org.xbill.DNS.u

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NioTcpClient f58060b;

            {
                this.f58060b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                switch (i4) {
                    case 0:
                        this.f58060b.processPendingRegistrations();
                        break;
                    case 1:
                        this.f58060b.checkTransactionTimeouts();
                        break;
                    default:
                        this.f58060b.closeTcp();
                        break;
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTransactionTimeouts() {
        Iterator<ChannelState> it = this.channelMap.values().iterator();
        while (it.hasNext()) {
            Iterator<Transaction> it2 = it.next().pendingTransactions.iterator();
            while (it2.hasNext()) {
                Transaction next = it2.next();
                if (next.endTime - System.nanoTime() < 0) {
                    next.f57911f.completeExceptionally(new SocketTimeoutException("Query timed out"));
                    it2.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeTcp() {
        this.registrationQueue.clear();
        this.channelMap.forEach(new t(new EOFException("Client is closing"), 0));
        this.channelMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeTcp$0(EOFException eOFException, ChannelKey channelKey, ChannelState channelState) throws IOException {
        channelState.handleTransactionException(eOFException);
        channelState.handleChannelException(eOFException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ChannelState lambda$sendAndReceiveTcp$1(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, CompletableFuture completableFuture, ChannelKey channelKey) throws IOException {
        SocketChannel socketChannelOpen;
        log.u("Opening async channel for l={}/r={}", inetSocketAddress, inetSocketAddress2);
        try {
            socketChannelOpen = SocketChannel.open();
            try {
                socketChannelOpen.configureBlocking(false);
                if (inetSocketAddress != null) {
                    socketChannelOpen.bind((SocketAddress) inetSocketAddress);
                }
                socketChannelOpen.connect(inetSocketAddress2);
                return new ChannelState(socketChannelOpen);
            } catch (IOException e2) {
                e = e2;
                if (socketChannelOpen != null) {
                    try {
                        socketChannelOpen.close();
                    } catch (IOException unused) {
                    }
                }
                completableFuture.completeExceptionally(e);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            socketChannelOpen = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingRegistrations() throws IOException {
        while (!this.registrationQueue.isEmpty()) {
            ChannelState channelStatePoll = this.registrationQueue.poll();
            if (channelStatePoll != null) {
                try {
                    Selector selector = NioClient.selector();
                    if (channelStatePoll.channel.isConnected()) {
                        channelStatePoll.channel.keyFor(selector).interestOps(4);
                    } else {
                        channelStatePoll.channel.register(selector, 8, channelStatePoll);
                    }
                } catch (IOException e2) {
                    channelStatePoll.handleChannelException(e2);
                }
            }
        }
    }

    @Override // org.xbill.DNS.io.TcpIoClient
    public CompletableFuture<byte[]> sendAndReceiveTcp(final InetSocketAddress inetSocketAddress, final InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, Duration duration) {
        final CompletableFuture<byte[]> completableFuture = new CompletableFuture<>();
        try {
            Selector selector = NioClient.selector();
            long jNanoTime = System.nanoTime() + duration.toNanos();
            ChannelState channelStateComputeIfAbsent = this.channelMap.computeIfAbsent(new ChannelKey(inetSocketAddress, inetSocketAddress2), new Function() { // from class: org.xbill.DNS.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f58061a.lambda$sendAndReceiveTcp$1(inetSocketAddress, inetSocketAddress2, completableFuture, (NioTcpClient.ChannelKey) obj);
                }
            });
            if (channelStateComputeIfAbsent != null) {
                log.i("Creating transaction for id {} ({}/{})", Integer.valueOf(message.getHeader().getID()), message.getQuestion().getName(), Type.string(message.getQuestion().getType()));
                channelStateComputeIfAbsent.pendingTransactions.add(new Transaction(message, bArr, jNanoTime, channelStateComputeIfAbsent.channel, completableFuture));
                this.registrationQueue.add(channelStateComputeIfAbsent);
                selector.wakeup();
                return completableFuture;
            }
        } catch (IOException e2) {
            completableFuture.completeExceptionally(e2);
        }
        return completableFuture;
    }
}
