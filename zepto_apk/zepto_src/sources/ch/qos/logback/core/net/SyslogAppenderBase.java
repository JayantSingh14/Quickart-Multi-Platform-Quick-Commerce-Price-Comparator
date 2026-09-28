package ch.qos.logback.core.net;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class SyslogAppenderBase<E> extends AppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public Layout f13608j;

    /* renamed from: k, reason: collision with root package name */
    public String f13609k;

    /* renamed from: l, reason: collision with root package name */
    public SyslogOutputStream f13610l;

    /* renamed from: m, reason: collision with root package name */
    public final int f13611m = 514;
    public int n;
    public Charset o;

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) throws IOException {
        if (this.f13415d) {
            try {
                String strC1 = this.f13608j.c1(obj);
                if (strC1 == null) {
                    return;
                }
                int length = strC1.length();
                int i2 = this.n;
                if (length > i2) {
                    strC1 = strC1.substring(0, i2);
                }
                this.f13610l.write(strC1.getBytes(this.o));
                this.f13610l.flush();
                W1(obj, this.f13610l);
            } catch (IOException e2) {
                o1("Failed to send diagram to null", e2);
            }
        }
    }

    public abstract PatternLayout U1();

    public abstract SyslogOutputStream V1();

    public void W1(Object obj, OutputStream outputStream) {
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws SocketException {
        char c2;
        l1("The Facility option is mandatory");
        if (this.o == null) {
            this.o = Charset.defaultCharset();
        }
        try {
            SyslogOutputStream syslogOutputStreamV1 = V1();
            this.f13610l = syslogOutputStreamV1;
            int sendBufferSize = syslogOutputStreamV1.f13613b.getSendBufferSize();
            int i2 = this.n;
            if (i2 == 0) {
                this.n = Math.min(sendBufferSize, 65000);
                s1("Defaulting maxMessageSize to [" + this.n + "]");
            } else if (i2 > sendBufferSize) {
                J1("maxMessageSize of [" + this.n + "] is larger than the system defined datagram size of [" + sendBufferSize + "].");
                J1("This may result in dropped logs.");
            }
        } catch (SocketException e2) {
            O1("Failed to bind to a random datagram socket. Will try to reconnect later.", e2);
        } catch (UnknownHostException e3) {
            o1("Could not create SyslogWriter", e3);
            c2 = 2;
        }
        c2 = 1;
        if (this.f13608j == null) {
            this.f13608j = U1();
        }
        if (c2 == 0) {
            this.f13415d = true;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        SyslogOutputStream syslogOutputStream = this.f13610l;
        if (syslogOutputStream != null) {
            syslogOutputStream.close();
        }
        this.f13415d = false;
    }
}
