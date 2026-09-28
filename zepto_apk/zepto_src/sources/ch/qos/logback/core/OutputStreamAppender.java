package ch.qos.logback.core;

import android.support.v4.media.b;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import ch.qos.logback.core.status.ErrorStatus;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class OutputStreamAppender<E> extends UnsynchronizedAppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public LayoutWrappingEncoder f13447j;

    /* renamed from: l, reason: collision with root package name */
    public OutputStream f13449l;

    /* renamed from: k, reason: collision with root package name */
    public final ReentrantLock f13448k = new ReentrantLock(false);

    /* renamed from: m, reason: collision with root package name */
    public final boolean f13450m = true;

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public final void T1(Object obj) {
        if (this.f13451d) {
            Y1(obj);
        }
    }

    public final void U1() throws IOException {
        if (this.f13449l != null) {
            try {
                V1();
                this.f13449l.close();
                this.f13449l = null;
            } catch (IOException e2) {
                w1(new ErrorStatus("Could not close output stream for OutputStreamAppender.", this, e2));
            }
        }
    }

    public final void V1() {
        byte[] bytes;
        LayoutWrappingEncoder layoutWrappingEncoder = this.f13447j;
        if (layoutWrappingEncoder == null || this.f13449l == null) {
            return;
        }
        try {
            if (layoutWrappingEncoder.f13476e == null) {
                bytes = null;
            } else {
                StringBuilder sb = new StringBuilder();
                String strJ1 = layoutWrappingEncoder.f13476e.j1();
                if (strJ1 != null) {
                    sb.append(strJ1);
                }
                String strJ0 = layoutWrappingEncoder.f13476e.j0();
                if (strJ0 != null) {
                    sb.append(strJ0);
                }
                bytes = sb.toString().getBytes();
            }
            Z1(bytes);
        } catch (IOException e2) {
            this.f13451d = false;
            w1(new ErrorStatus(b.r(new StringBuilder("Failed to write footer for appender named ["), this.f13453f, "]."), this, e2));
        }
    }

    public final void W1() {
        byte[] bytes;
        LayoutWrappingEncoder layoutWrappingEncoder = this.f13447j;
        if (layoutWrappingEncoder == null || this.f13449l == null) {
            return;
        }
        try {
            if (layoutWrappingEncoder.f13476e == null) {
                bytes = null;
            } else {
                StringBuilder sb = new StringBuilder();
                String strD0 = layoutWrappingEncoder.f13476e.D0();
                if (strD0 != null) {
                    sb.append(strD0);
                }
                String strZ = layoutWrappingEncoder.f13476e.Z();
                if (strZ != null) {
                    sb.append(strZ);
                }
                if (sb.length() > 0) {
                    sb.append(CoreConstants.f13442a);
                }
                bytes = sb.toString().getBytes();
            }
            Z1(bytes);
        } catch (IOException e2) {
            this.f13451d = false;
            w1(new ErrorStatus(b.r(new StringBuilder("Failed to initialize encoder for appender named ["), this.f13453f, "]."), this, e2));
        }
    }

    public final void X1(OutputStream outputStream) {
        ReentrantLock reentrantLock = this.f13448k;
        reentrantLock.lock();
        try {
            U1();
            this.f13449l = outputStream;
            if (this.f13447j == null) {
                J1("Encoder has not been set. Cannot invoke its init method.");
            } else {
                W1();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void Y1(Object obj) {
        if (this.f13451d) {
            try {
                if (obj instanceof DeferredProcessingAware) {
                    ((DeferredProcessingAware) obj).g();
                }
                Z1(this.f13447j.f13476e.c1(obj).getBytes());
            } catch (IOException e2) {
                this.f13451d = false;
                w1(new ErrorStatus("IO failure in appender", this, e2));
            }
        }
    }

    public final void Z1(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        ReentrantLock reentrantLock = this.f13448k;
        reentrantLock.lock();
        try {
            this.f13449l.write(bArr);
            if (this.f13450m) {
                this.f13449l.flush();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int i2;
        if (this.f13447j == null) {
            w1(new ErrorStatus(b.r(new StringBuilder("No encoder set for the appender named \""), this.f13453f, "\"."), this));
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f13449l == null) {
            w1(new ErrorStatus(b.r(new StringBuilder("No output stream set for the appender named \""), this.f13453f, "\"."), this));
            i2++;
        }
        if (i2 == 0) {
            this.f13451d = true;
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        ReentrantLock reentrantLock = this.f13448k;
        reentrantLock.lock();
        try {
            U1();
            this.f13451d = false;
        } finally {
            reentrantLock.unlock();
        }
    }
}
