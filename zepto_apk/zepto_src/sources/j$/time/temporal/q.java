package j$.time.temporal;

import j$.time.DateTimeException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.xbill.DNS.TTL;

/* loaded from: classes2.dex */
public final class q implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f53435a;

    /* renamed from: b, reason: collision with root package name */
    public final long f53436b;

    /* renamed from: c, reason: collision with root package name */
    public final long f53437c;

    /* renamed from: d, reason: collision with root package name */
    public final long f53438d;

    public static q f(long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new q(j2, j2, j3, j3);
    }

    public static q g(long j2, long j3, long j4) {
        if (j2 > 1) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (j3 > j4) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j4) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new q(j2, 1L, j3, j4);
    }

    public q(long j2, long j3, long j4, long j5) {
        this.f53435a = j2;
        this.f53436b = j3;
        this.f53437c = j4;
        this.f53438d = j5;
    }

    public final boolean d() {
        return this.f53435a >= -2147483648L && this.f53438d <= TTL.MAX_VALUE;
    }

    public final boolean e(long j2) {
        return j2 >= this.f53435a && j2 <= this.f53438d;
    }

    public final int a(long j2, n nVar) {
        if (d() && e(j2)) {
            return (int) j2;
        }
        throw new DateTimeException(c(j2, nVar));
    }

    public final void b(long j2, n nVar) {
        if (!e(j2)) {
            throw new DateTimeException(c(j2, nVar));
        }
    }

    public final String c(long j2, n nVar) {
        if (nVar != null) {
            return "Invalid value for " + nVar + " (valid values " + this + "): " + j2;
        }
        return "Invalid value (valid values " + this + "): " + j2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j2 = this.f53435a;
        long j3 = this.f53436b;
        if (j2 > j3) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j4 = this.f53437c;
        long j5 = this.f53438d;
        if (j4 > j5) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j3 > j5) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f53435a == qVar.f53435a && this.f53436b == qVar.f53436b && this.f53437c == qVar.f53437c && this.f53438d == qVar.f53438d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f53436b;
        long j3 = this.f53435a + (j2 << 16) + (j2 >> 48);
        long j4 = this.f53437c;
        long j5 = j3 + (j4 << 32) + (j4 >> 32);
        long j6 = this.f53438d;
        long j7 = j5 + (j6 << 48) + (j6 >> 16);
        return (int) ((j7 >>> 32) ^ j7);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j2 = this.f53435a;
        sb.append(j2);
        long j3 = this.f53436b;
        if (j2 != j3) {
            sb.append('/');
            sb.append(j3);
        }
        sb.append(" - ");
        long j4 = this.f53437c;
        sb.append(j4);
        long j5 = this.f53438d;
        if (j4 != j5) {
            sb.append('/');
            sb.append(j5);
        }
        return sb.toString();
    }
}
