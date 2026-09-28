package androidx.core.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

/* loaded from: classes3.dex */
class DatagramSocketWrapper extends Socket {

    public static class DatagramSocketImplWrapper extends SocketImpl {
        @Override // java.net.SocketImpl
        public final void accept(SocketImpl socketImpl) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final int available() {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void bind(InetAddress inetAddress, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void close() {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void connect(String str, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void create(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final InputStream getInputStream() {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public final Object getOption(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final OutputStream getOutputStream() {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void listen(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void sendUrgentData(int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public final void setOption(int i2, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void connect(InetAddress inetAddress, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public final void connect(SocketAddress socketAddress, int i2) {
            throw new UnsupportedOperationException();
        }
    }
}
