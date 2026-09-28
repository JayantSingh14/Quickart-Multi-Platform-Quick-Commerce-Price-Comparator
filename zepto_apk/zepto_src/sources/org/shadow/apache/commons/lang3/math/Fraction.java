package org.shadow.apache.commons.lang3.math;

/* loaded from: classes5.dex */
public final class Fraction extends Number implements Comparable<Fraction> {

    /* renamed from: a, reason: collision with root package name */
    public final int f57757a;

    /* renamed from: b, reason: collision with root package name */
    public final int f57758b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f57759c = 0;

    /* renamed from: d, reason: collision with root package name */
    public transient String f57760d = null;

    static {
        new Fraction(0, 1);
        new Fraction(1, 1);
        new Fraction(1, 2);
        new Fraction(1, 3);
        new Fraction(2, 3);
        new Fraction(1, 4);
        new Fraction(2, 4);
        new Fraction(3, 4);
        new Fraction(1, 5);
        new Fraction(2, 5);
        new Fraction(3, 5);
        new Fraction(4, 5);
    }

    public Fraction(int i2, int i3) {
        this.f57757a = i2;
        this.f57758b = i3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Fraction fraction) {
        Fraction fraction2 = fraction;
        if (this == fraction2) {
            return 0;
        }
        int i2 = fraction2.f57757a;
        int i3 = this.f57758b;
        int i4 = this.f57757a;
        int i5 = fraction2.f57758b;
        if (i4 == i2 && i3 == i5) {
            return 0;
        }
        long j2 = i4 * i5;
        long j3 = i2 * i3;
        if (j2 == j3) {
            return 0;
        }
        return j2 < j3 ? -1 : 1;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.f57757a / this.f57758b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return this.f57757a == fraction.f57757a && this.f57758b == fraction.f57758b;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return this.f57757a / this.f57758b;
    }

    public final int hashCode() {
        if (this.f57759c == 0) {
            this.f57759c = ((this.f57757a + 629) * 37) + this.f57758b;
        }
        return this.f57759c;
    }

    @Override // java.lang.Number
    public final int intValue() {
        return this.f57757a / this.f57758b;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.f57757a / this.f57758b;
    }

    public final String toString() {
        if (this.f57760d == null) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f57757a);
            sb.append('/');
            sb.append(this.f57758b);
            this.f57760d = sb.toString();
        }
        return this.f57760d;
    }
}
