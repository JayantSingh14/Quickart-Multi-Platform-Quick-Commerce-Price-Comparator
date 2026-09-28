package ch.qos.logback.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public class SyslogOutputStream extends OutputStream implements AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public final int f13615d;

    /* renamed from: c, reason: collision with root package name */
    public ByteArrayOutputStream f13614c = new ByteArrayOutputStream();

    /* renamed from: a, reason: collision with root package name */
    public InetAddress f13612a = InetAddress.getByName(null);

    /* renamed from: b, reason: collision with root package name */
    public DatagramSocket f13613b = new DatagramSocket();

    public SyslogOutputStream(int i2) {
        this.f13615d = i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f13612a = null;
        this.f13613b = null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        DatagramSocket datagramSocket;
        byte[] byteArray = this.f13614c.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, this.f13612a, this.f13615d);
        if (this.f13614c.size() > 1024) {
            this.f13614c = new ByteArrayOutputStream();
        } else {
            this.f13614c.reset();
        }
        if (byteArray.length == 0 || (datagramSocket = this.f13613b) == null) {
            return;
        }
        datagramSocket.send(datagramPacket);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        this.f13614c.write(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.f13614c.write(i2);
    }
}
