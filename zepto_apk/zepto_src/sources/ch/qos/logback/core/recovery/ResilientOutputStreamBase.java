package ch.qos.logback.core.recovery;

import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.StatusBase;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public abstract class ResilientOutputStreamBase extends OutputStream implements AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public Context f13710c;

    /* renamed from: d, reason: collision with root package name */
    public RecoveryCoordinator f13711d;

    /* renamed from: e, reason: collision with root package name */
    public OutputStream f13712e;

    /* renamed from: a, reason: collision with root package name */
    public int f13708a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f13709b = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13713f = true;

    public final void a(StatusBase statusBase) {
        Context context = this.f13710c;
        if (context != null) {
            BasicStatusManager basicStatusManagerD = context.D();
            if (basicStatusManagerD != null) {
                basicStatusManagerD.a(statusBase);
                return;
            }
            return;
        }
        int i2 = this.f13708a;
        this.f13708a = i2 + 1;
        if (i2 == 0) {
            System.out.println("LOGBACK: No context given for " + this);
        }
    }

    public final void b(StatusBase statusBase) {
        int i2 = this.f13709b + 1;
        this.f13709b = i2;
        if (i2 < 8) {
            a(statusBase);
        }
        if (this.f13709b == 8) {
            a(statusBase);
            a(new InfoStatus("Will supress future messages regarding " + e(), this));
        }
    }

    public final void c() {
        try {
            close();
        } catch (IOException unused) {
        }
        b(new InfoStatus("Attempting to recover from IO failure on " + e(), this));
        try {
            this.f13712e = l();
            this.f13713f = true;
        } catch (IOException e2) {
            b(new ErrorStatus(2, "Failed to open " + e(), this, e2));
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        OutputStream outputStream = this.f13712e;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public abstract String e();

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        OutputStream outputStream = this.f13712e;
        if (outputStream != null) {
            try {
                outputStream.flush();
                s();
            } catch (IOException e2) {
                r(e2);
            }
        }
    }

    public abstract OutputStream l();

    public final void r(IOException iOException) {
        b(new ErrorStatus(2, "IO failure while writing to " + e(), this, iOException));
        this.f13713f = false;
        if (this.f13711d == null) {
            this.f13711d = new RecoveryCoordinator();
        }
    }

    public final void s() {
        if (this.f13711d != null) {
            this.f13711d = null;
            this.f13709b = 0;
            a(new InfoStatus("Recovered from IO failure on " + e(), this));
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        RecoveryCoordinator recoveryCoordinator = this.f13711d;
        if (recoveryCoordinator == null || this.f13713f) {
            try {
                this.f13712e.write(i2);
                s();
                return;
            } catch (IOException e2) {
                r(e2);
                return;
            }
        }
        recoveryCoordinator.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis > recoveryCoordinator.f13705b) {
            long j2 = recoveryCoordinator.f13704a;
            if (j2 < 327680) {
                recoveryCoordinator.f13704a = 4 * j2;
            }
            recoveryCoordinator.f13705b = j2 + jCurrentTimeMillis;
            c();
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        RecoveryCoordinator recoveryCoordinator = this.f13711d;
        if (recoveryCoordinator != null && !this.f13713f) {
            recoveryCoordinator.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis > recoveryCoordinator.f13705b) {
                long j2 = recoveryCoordinator.f13704a;
                if (j2 < 327680) {
                    recoveryCoordinator.f13704a = 4 * j2;
                }
                recoveryCoordinator.f13705b = j2 + jCurrentTimeMillis;
                c();
                return;
            }
            return;
        }
        try {
            this.f13712e.write(bArr, i2, i3);
            s();
        } catch (IOException e2) {
            r(e2);
        }
    }
}
