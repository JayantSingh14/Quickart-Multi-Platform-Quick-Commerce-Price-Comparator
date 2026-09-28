package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.LocalDate;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class x implements l, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final x f53262d;

    /* renamed from: e, reason: collision with root package name */
    public static final x[] f53263e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a, reason: collision with root package name */
    public final transient int f53264a;

    /* renamed from: b, reason: collision with root package name */
    public final transient LocalDate f53265b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f53266c;

    static {
        x xVar = new x(-1, LocalDate.of(1868, 1, 1), "Meiji");
        f53262d = xVar;
        f53263e = new x[]{xVar, new x(0, LocalDate.of(1912, 7, 30), "Taisho"), new x(1, LocalDate.of(1926, 12, 25), "Showa"), new x(2, LocalDate.of(1989, 1, 8), "Heisei"), new x(3, LocalDate.of(2019, 5, 1), "Reiwa")};
    }

    public final x s() {
        if (this == f53263e[r0.length - 1]) {
            return null;
        }
        return t(this.f53264a + 1);
    }

    public x(int i2, LocalDate localDate, String str) {
        this.f53264a = i2;
        this.f53265b = localDate;
        this.f53266c = str;
    }

    public static x t(int i2) {
        int i3 = i2 + 1;
        if (i3 >= 0) {
            x[] xVarArr = f53263e;
            if (i3 < xVarArr.length) {
                return xVarArr[i3];
            }
        }
        throw new DateTimeException("Invalid era: " + i2);
    }

    public static x r(LocalDate localDate) {
        if (localDate.c0(w.f53258d)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 are not supported");
        }
        x[] xVarArr = f53263e;
        for (int length = xVarArr.length - 1; length >= 0; length--) {
            x xVar = xVarArr[length];
            if (localDate.compareTo((ChronoLocalDate) xVar.f53265b) >= 0) {
                return xVar;
            }
        }
        return null;
    }

    @Override // j$.time.chrono.l
    public final int q() {
        return this.f53264a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        if (nVar == aVar) {
            return u.f53256c.Y(aVar);
        }
        return super.l(nVar);
    }

    public final String toString() {
        return this.f53266c;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new D((byte) 5, this);
    }
}
