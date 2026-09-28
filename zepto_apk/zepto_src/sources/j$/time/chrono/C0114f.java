package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* renamed from: j$.time.chrono.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0114f implements TemporalAmount, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f53226e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a, reason: collision with root package name */
    public final k f53227a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53228b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53229c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53230d;

    static {
        j$.time.d.c(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    public C0114f(k kVar, int i2, int i3, int i4) {
        this.f53227a = kVar;
        this.f53228b = i2;
        this.f53229c = i3;
        this.f53230d = i4;
    }

    public final String toString() {
        k kVar = this.f53227a;
        int i2 = this.f53230d;
        int i3 = this.f53229c;
        int i4 = this.f53228b;
        if (i4 == 0 && i3 == 0 && i2 == 0) {
            return kVar.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(kVar.toString());
        sb.append(" P");
        if (i4 != 0) {
            sb.append(i4);
            sb.append('Y');
        }
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('D');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    @Override // j$.time.temporal.TemporalAmount
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.Temporal q(j$.time.temporal.Temporal r8) {
        /*
            r7 = this;
            j$.time.f r0 = j$.time.temporal.o.f53429b
            java.lang.Object r0 = r8.e(r0)
            j$.time.chrono.k r0 = (j$.time.chrono.k) r0
            j$.time.chrono.k r1 = r7.f53227a
            if (r0 == 0) goto L37
            boolean r2 = r1.equals(r0)
            if (r2 == 0) goto L13
            goto L37
        L13:
            j$.time.DateTimeException r8 = new j$.time.DateTimeException
            java.lang.String r1 = r1.getId()
            java.lang.String r0 = r0.getId()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Chronology mismatch, expected: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = ", actual: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r8.<init>(r0)
            throw r8
        L37:
            int r0 = r7.f53228b
            int r2 = r7.f53229c
            if (r2 != 0) goto L47
            if (r0 == 0) goto L8d
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            j$.time.temporal.Temporal r8 = r8.c(r0, r2)
            goto L8d
        L47:
            j$.time.temporal.a r3 = j$.time.temporal.a.MONTH_OF_YEAR
            j$.time.temporal.q r1 = r1.Y(r3)
            long r3 = r1.f53435a
            long r5 = r1.f53436b
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L6a
            long r3 = r1.f53437c
            long r5 = r1.f53438d
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L6a
            boolean r3 = r1.d()
            if (r3 == 0) goto L6a
            long r3 = r1.f53435a
            long r5 = r5 - r3
            r3 = 1
            long r5 = r5 + r3
            goto L6c
        L6a:
            r5 = -1
        L6c:
            r3 = 0
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L7d
            long r0 = (long) r0
            long r0 = r0 * r5
            long r2 = (long) r2
            long r0 = r0 + r2
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
            j$.time.temporal.Temporal r8 = r8.c(r0, r2)
            goto L8d
        L7d:
            if (r0 == 0) goto L86
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r3 = j$.time.temporal.ChronoUnit.YEARS
            j$.time.temporal.Temporal r8 = r8.c(r0, r3)
        L86:
            long r0 = (long) r2
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
            j$.time.temporal.Temporal r8 = r8.c(r0, r2)
        L8d:
            int r0 = r7.f53230d
            if (r0 == 0) goto L98
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.Temporal r8 = r8.c(r0, r2)
        L98:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C0114f.q(j$.time.temporal.Temporal):j$.time.temporal.Temporal");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0114f) {
            C0114f c0114f = (C0114f) obj;
            if (this.f53228b == c0114f.f53228b && this.f53229c == c0114f.f53229c && this.f53230d == c0114f.f53230d && this.f53227a.equals(c0114f.f53227a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f53227a.hashCode() ^ (Integer.rotateLeft(this.f53230d, 16) + (Integer.rotateLeft(this.f53229c, 8) + this.f53228b));
    }

    public Object writeReplace() {
        return new D((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
