package org.xbill.DNS;

import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes5.dex */
class TCPClient implements AutoCloseable {
    private final SelectionKey key;
    private final long startTime = System.nanoTime();
    private final Duration timeout;

    public TCPClient(Duration duration) throws Throwable {
        Selector selectorOpen;
        this.timeout = duration;
        SocketChannel socketChannelOpen = SocketChannel.open();
        try {
            selectorOpen = Selector.open();
        } catch (Throwable th) {
            th = th;
            selectorOpen = null;
        }
        try {
            socketChannelOpen.configureBlocking(false);
            this.key = socketChannelOpen.register(selectorOpen, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selectorOpen != null) {
                selectorOpen.close();
            }
            socketChannelOpen.close();
            throw th;
        }
    }

    private void blockUntil(SelectionKey selectionKey) throws IOException {
        long millis = this.timeout.minus(System.nanoTime() - this.startTime, ChronoUnit.NANOS).toMillis();
        if ((millis > 0 ? selectionKey.selector().select(millis) : millis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    private byte[] recv(int i2) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        byte[] bArr = new byte[i2];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.key.interestOps(1);
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.key.isReadable()) {
                    long j2 = socketChannel.read(byteBufferWrap);
                    if (j2 < 0) {
                        throw new EOFException();
                    }
                    i3 += (int) j2;
                    if (i3 < i2 && System.nanoTime() - this.startTime >= this.timeout.toNanos()) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    blockUntil(this.key);
                }
            } catch (Throwable th) {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
                throw th;
            }
        }
        if (this.key.isValid()) {
            this.key.interestOps(0);
        }
        return bArr;
    }

    public void bind(SocketAddress socketAddress) throws IOException {
        ((SocketChannel) this.key.channel()).socket().bind(socketAddress);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        this.key.selector().close();
        this.key.channel().close();
    }

    public void connect(SocketAddress socketAddress) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.key.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.key.isConnectable()) {
                    blockUntil(this.key);
                }
            } finally {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
            }
        }
    }

    public void send(byte[] bArr) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        NioClient.verboseLog("TCP write", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArr);
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.key.interestOps(4);
        int i2 = 0;
        while (i2 < bArr.length + 2) {
            try {
                if (this.key.isWritable()) {
                    long jWrite = socketChannel.write(byteBufferArr);
                    if (jWrite < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) jWrite;
                    if (i2 < bArr.length + 2 && System.nanoTime() - this.startTime >= this.timeout.toNanos()) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    blockUntil(this.key);
                }
            } catch (Throwable th) {
                if (this.key.isValid()) {
                    this.key.interestOps(0);
                }
                throw th;
            }
        }
        if (this.key.isValid()) {
            this.key.interestOps(0);
        }
    }

    public byte[] recv() throws IOException {
        byte[] bArrRecv = recv(2);
        byte[] bArrRecv2 = recv(((bArrRecv[0] & 255) << 8) + (bArrRecv[1] & 255));
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        NioClient.verboseLog("TCP read", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArrRecv2);
        return bArrRecv2;
    }
}
