package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: j$.time.format.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0123f extends i {

    /* renamed from: g, reason: collision with root package name */
    public final boolean f53315g;

    @Override // j$.time.format.i
    public final boolean b(u uVar) {
        return uVar.f53363c && this.f53320b == this.f53321c && !this.f53315g;
    }

    @Override // j$.time.format.i, j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        int i3 = (uVar.f53363c || b(uVar)) ? this.f53320b : 0;
        int i4 = (uVar.f53363c || b(uVar)) ? this.f53321c : 9;
        int length = charSequence.length();
        if (i2 != length) {
            DateTimeFormatter dateTimeFormatter = uVar.f53361a;
            if (this.f53315g) {
                char cCharAt = charSequence.charAt(i2);
                dateTimeFormatter.f53288c.getClass();
                if (cCharAt == '.') {
                    i2++;
                } else if (i3 > 0) {
                    return ~i2;
                }
            }
            int i5 = i2;
            int i6 = i3 + i5;
            if (i6 > length) {
                return ~i5;
            }
            int iMin = Math.min(i4 + i5, length);
            int i7 = 0;
            int i8 = i5;
            while (true) {
                if (i8 >= iMin) {
                    break;
                }
                int i9 = i8 + 1;
                char cCharAt2 = charSequence.charAt(i8);
                dateTimeFormatter.f53288c.getClass();
                int i10 = cCharAt2 - '0';
                if (i10 < 0 || i10 > 9) {
                    i10 = -1;
                }
                if (i10 >= 0) {
                    i7 = (i7 * 10) + i10;
                    i8 = i9;
                } else if (i9 < i6) {
                    return ~i5;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i7).movePointLeft(i8 - i5);
            j$.time.temporal.q qVarA = this.f53319a.A();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(qVarA.f53435a);
            return uVar.f(this.f53319a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(qVarA.f53438d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i5, i8);
        }
        if (i3 > 0) {
            return ~i2;
        }
        return i2;
    }

    public C0123f(j$.time.temporal.a aVar, int i2, int i3, boolean z) {
        this(aVar, i2, i3, z, 0);
        Objects.requireNonNull(aVar, "field");
        j$.time.temporal.q qVar = aVar.f53410b;
        if (qVar.f53435a != qVar.f53436b || qVar.f53437c != qVar.f53438d) {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar);
        }
        if (i2 < 0 || i2 > 9) {
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i2);
        }
        if (i3 < 1 || i3 > 9) {
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i3);
        }
        if (i3 >= i2) {
            return;
        }
        throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    public C0123f(j$.time.temporal.n nVar, int i2, int i3, boolean z, int i4) {
        super(nVar, i2, i3, D.NOT_NEGATIVE, i4);
        this.f53315g = z;
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.f53323e == -1) {
            return this;
        }
        return new C0123f(this.f53319a, this.f53320b, this.f53321c, this.f53315g, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i2) {
        return new C0123f(this.f53319a, this.f53320b, this.f53321c, this.f53315g, this.f53323e + i2);
    }

    @Override // j$.time.format.i, j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        j$.time.temporal.n nVar = this.f53319a;
        Long lA = wVar.a(nVar);
        if (lA == null) {
            return false;
        }
        A a2 = wVar.f53371b.f53288c;
        long jLongValue = lA.longValue();
        j$.time.temporal.q qVarA = nVar.A();
        qVarA.b(jLongValue, nVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(qVarA.f53435a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(qVarA.f53438d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z = this.f53315g;
        int i2 = this.f53320b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i2), this.f53321c), roundingMode).toPlainString().substring(2);
            a2.getClass();
            if (z) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            sb.append(strSubstring);
            return true;
        }
        if (i2 <= 0) {
            return true;
        }
        if (z) {
            a2.getClass();
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            a2.getClass();
            sb.append('0');
        }
        return true;
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f53319a + "," + this.f53320b + "," + this.f53321c + (this.f53315g ? ",DecimalPoint" : "") + ")";
    }
}
