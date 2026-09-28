package ch.qos.logback.core.net.server;

import android.support.v4.media.b;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.CloseUtil;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes3.dex */
class RemoteReceiverStreamClient extends ContextAwareBase implements RemoteReceiverClient {

    /* renamed from: d, reason: collision with root package name */
    public final String f13628d;

    /* renamed from: e, reason: collision with root package name */
    public final Socket f13629e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayBlockingQueue f13630f;

    public RemoteReceiverStreamClient(String str, Socket socket) {
        this.f13628d = b.D("client ", str, ": ");
        this.f13629e = socket;
    }

    @Override // ch.qos.logback.core.net.server.RemoteReceiverClient
    public final void L1(ArrayBlockingQueue arrayBlockingQueue) {
        this.f13630f = arrayBlockingQueue;
    }

    public final ObjectOutputStream T1() {
        Socket socket = this.f13629e;
        return socket == null ? new ObjectOutputStream(null) : new ObjectOutputStream(socket.getOutputStream());
    }

    @Override // ch.qos.logback.core.net.server.RemoteReceiverClient
    public final boolean b1(Serializable serializable) {
        ArrayBlockingQueue arrayBlockingQueue = this.f13630f;
        if (arrayBlockingQueue != null) {
            return arrayBlockingQueue.offer(serializable);
        }
        throw new IllegalStateException("client has no event queue");
    }

    @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Socket socket = this.f13629e;
        if (socket == null) {
            return;
        }
        CloseUtil.b(socket);
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        String str = this.f13628d;
        sb2.append(str);
        sb2.append("connected");
        s1(sb2.toString());
        ObjectOutputStream objectOutputStreamT1 = null;
        try {
            try {
                try {
                    try {
                        objectOutputStreamT1 = T1();
                        loop0: while (true) {
                            int i2 = 0;
                            while (!Thread.currentThread().isInterrupted()) {
                                try {
                                    objectOutputStreamT1.writeObject((Serializable) this.f13630f.take());
                                    objectOutputStreamT1.flush();
                                    i2++;
                                } catch (InterruptedException unused) {
                                }
                                if (i2 >= 70) {
                                    try {
                                        objectOutputStreamT1.reset();
                                        break;
                                    } catch (InterruptedException unused2) {
                                        i2 = 0;
                                        Thread.currentThread().interrupt();
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        CloseUtil.a(objectOutputStreamT1);
                        close();
                        sb = new StringBuilder();
                    } catch (SocketException e2) {
                        s1(str + e2);
                        if (objectOutputStreamT1 != null) {
                            CloseUtil.a(objectOutputStreamT1);
                        }
                        close();
                        sb = new StringBuilder();
                    }
                } catch (IOException e3) {
                    l1(str + e3);
                    if (objectOutputStreamT1 != null) {
                        CloseUtil.a(objectOutputStreamT1);
                    }
                    close();
                    sb = new StringBuilder();
                }
            } catch (RuntimeException e4) {
                l1(str + e4);
                if (objectOutputStreamT1 != null) {
                    CloseUtil.a(objectOutputStreamT1);
                }
                close();
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append("connection closed");
            s1(sb.toString());
        } catch (Throwable th) {
            if (objectOutputStreamT1 != null) {
                CloseUtil.a(objectOutputStreamT1);
            }
            close();
            s1(str + "connection closed");
            throw th;
        }
    }
}
