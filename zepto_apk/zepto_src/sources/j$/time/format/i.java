package j$.time.format;

import j$.time.DateTimeException;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes2.dex */
public class i implements InterfaceC0122e {

    /* renamed from: f, reason: collision with root package name */
    public static final long[] f53318f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.n f53319a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53320b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53321c;

    /* renamed from: d, reason: collision with root package name */
    public final D f53322d;

    /* renamed from: e, reason: collision with root package name */
    public final int f53323e;

    public long a(w wVar, long j2) {
        return j2;
    }

    public i(j$.time.temporal.n nVar, int i2, int i3, D d2) {
        this.f53319a = nVar;
        this.f53320b = i2;
        this.f53321c = i3;
        this.f53322d = d2;
        this.f53323e = 0;
    }

    public i(j$.time.temporal.n nVar, int i2, int i3, D d2, int i4) {
        this.f53319a = nVar;
        this.f53320b = i2;
        this.f53321c = i3;
        this.f53322d = d2;
        this.f53323e = i4;
    }

    public i d() {
        if (this.f53323e == -1) {
            return this;
        }
        return new i(this.f53319a, this.f53320b, this.f53321c, this.f53322d, -1);
    }

    public i e(int i2) {
        int i3 = this.f53323e + i2;
        return new i(this.f53319a, this.f53320b, this.f53321c, this.f53322d, i3);
    }

    @Override // j$.time.format.InterfaceC0122e
    public boolean q(w wVar, StringBuilder sb) {
        j$.time.temporal.n nVar = this.f53319a;
        Long lA = wVar.a(nVar);
        if (lA == null) {
            return false;
        }
        long jA = a(wVar, lA.longValue());
        A a2 = wVar.f53371b.f53288c;
        String string = jA == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jA));
        int length = string.length();
        int i2 = this.f53321c;
        if (length > i2) {
            throw new DateTimeException("Field " + nVar + " cannot be printed as the value " + jA + " exceeds the maximum print width of " + i2);
        }
        a2.getClass();
        int i3 = this.f53320b;
        D d2 = this.f53322d;
        if (jA >= 0) {
            int i4 = AbstractC0119b.f53311a[d2.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    sb.append('+');
                }
            } else if (i3 < 19 && jA >= f53318f[i3]) {
                sb.append('+');
            }
        } else {
            int i5 = AbstractC0119b.f53311a[d2.ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                sb.append(Soundex.SILENT_MARKER);
            } else if (i5 == 4) {
                throw new DateTimeException("Field " + nVar + " cannot be printed as the value " + jA + " cannot be negative according to the SignStyle");
            }
        }
        for (int i6 = 0; i6 < i3 - string.length(); i6++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    public boolean b(u uVar) {
        int i2 = this.f53323e;
        if (i2 != -1) {
            return i2 > 0 && this.f53320b == this.f53321c && this.f53322d == D.NOT_NEGATIVE;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0176, code lost:
    
        if (r6 <= r11) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019a  */
    @Override // j$.time.format.InterfaceC0122e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int s(j$.time.format.u r27, java.lang.CharSequence r28, int r29) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.i.s(j$.time.format.u, java.lang.CharSequence, int):int");
    }

    public int c(u uVar, long j2, int i2, int i3) {
        return uVar.f(this.f53319a, j2, i2, i3);
    }

    public String toString() {
        int i2 = this.f53321c;
        j$.time.temporal.n nVar = this.f53319a;
        D d2 = this.f53322d;
        int i3 = this.f53320b;
        if (i3 == 1 && i2 == 19 && d2 == D.NORMAL) {
            return "Value(" + nVar + ")";
        }
        if (i3 == i2 && d2 == D.NOT_NEGATIVE) {
            return "Value(" + nVar + "," + i3 + ")";
        }
        return "Value(" + nVar + "," + i3 + "," + i2 + "," + d2 + ")";
    }
}
